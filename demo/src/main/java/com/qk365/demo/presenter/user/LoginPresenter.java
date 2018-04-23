package com.qk365.demo.presenter.user;

import android.content.Context;

import com.alibaba.fastjson.JSONObject;
import com.eyunhome.baseappframework.common.CommonUtil;
import com.qk365.demo.bean.ResponseResult;
import com.qk365.demo.contract.UserContract;

import java.util.Observable;

/**
 * @desc 登录处理器 观察者
 * @auth zhoubenhua
 * @time 2017-11-21. 16:30.
 */
public class LoginPresenter extends UserContract.LoginContract.AbstractLoginPresenter{

    /**
     * 发送登录请求
     * @param mContext 上下文
     * @param bodyParams 参数
     */
    @Override
    public void sendLoginRequest(Context mContext, JSONObject bodyParams) {
        if(mModel.validateLogin(mContext,bodyParams)) {
            if(CommonUtil.checkNetwork(mContext)) {
                /**
                 * 注册观察者
                 */
                mModel.addObserver(this);
                mView.openProgressDialog("加载中...",null);
                mModel.doLoginRequest(mContext, bodyParams);
            }

        }

    }

    /**
     * 被观察者数据发生变化  服务器返回登录响应
     * @param o
     * @param data
     */
    @Override
    public void update(Observable o, Object data) {
        /**
         * 删除观察者
         */
        mView.closeProgressDialog();
        mModel.deleteObserver(this);
        if(data != null) {
            ResponseResult result = (ResponseResult)data;
            if(result.code == ResponseResult.SUCESS_CODE) {
                mView.loginSucess(result.data);
            } else if(!CommonUtil.isEmpty(result.message)){
                mView.loginFailed(result.message);
            }
        }
    }
}
