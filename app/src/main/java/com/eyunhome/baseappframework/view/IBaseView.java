package com.eyunhome.baseappframework.view;

import android.app.ProgressDialog;

/**
 * 作者：zhoubenhua
 * 时间：2017-2-8 15:07
 * 功能: 视图基类接口
 */
public interface IBaseView {
    /**
     * 打开加载框
     * @param title  加载框标题
     * @param message 加载框内容
     * @return 加载框
     */
    public abstract void showProgressDialog(String title, String message);

    /**
     * 关闭对话框
     */
    public abstract void dissmissProgressDialog();

}
