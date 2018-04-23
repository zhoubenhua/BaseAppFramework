package com.eyunhome.baseappframework.presenter;
import android.content.Context;

import java.util.Observable;
import java.util.Observer;

/**
 * @desc mvp（业务m-视图v-处理器p)设计模式 处理器基类
 * @auth zhoubenhua
 * @time 2017-11-16. 17:28.
 */

public class BasePresenter<V,M>   {
    /**
     * 内存不足时释放内存,避免内存泄露
     */
    protected V mView;//视图,显示数据
    protected M mModel;//处理业务逻辑
    protected Context mContext; //上下文

    /**
     * 关联视图和业务
     * @param view 视图
     * @param model 业务
     * @param context
     */
    public void attactView(V view,M model,Context context) {
        mView = view;
        mModel = model;
        mContext = context;
    }

    /**
     * 用于在activity销毁时释放资源
     */
    public void onDettach() {
        if(null != mView) {
            mView = null;
        }
        if(null != mModel) {
            mModel = null;
        }

    }


}
