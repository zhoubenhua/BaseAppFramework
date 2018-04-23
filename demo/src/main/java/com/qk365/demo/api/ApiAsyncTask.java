package com.qk365.demo.api;

import android.content.Context;

import com.eyunhome.baseappframework.api.BaseApiAsyncTask;
import com.eyunhome.baseappframework.common.LogUtil;
import com.qk365.demo.bean.ResponseResult;

/**
 * 调用后台api
 * Created by acer on 2016-5-12.
 */
public class ApiAsyncTask extends BaseApiAsyncTask {
    public ApiAsyncTask(Context context) {
        super(context);
        connectTimeOut = 10*1000;

    }

    @Override
    public void requestSucessed(String result) {
        ResponseResult data = new ResponseResult();
        data.data = result;
        data.message = "";
        mListener.doResponse(data);

    }

    @Override
    public void requestFailed(Throwable error, String content) {
        LogUtil.log("error:" + error.getMessage() + ":" + content, apiLogFileDirectory, apiLogFileName);
        ResponseResult result = new  ResponseResult();
        result.code = -1;
        result.message = "连接失败";
        mListener.doResponse(result);
    }
}
