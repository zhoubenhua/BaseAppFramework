package com.eyunhome.baseappframework.dialog;

import android.app.Dialog;
import android.content.Context;

/**
 * 对话框基类
 * Created by acer on 2016-9-2.
 */
public abstract class BaseDialog extends Dialog {
    public BaseDialog(Context mContext, int themeResId) {
        super(mContext,themeResId);
    }

    /**
     * 初始化控件
     */
    public abstract void initViews();

    /**
     * 初始化数据
     */
    public abstract void initData() ;

    /**
     * 添加事件
     */
    public abstract void addListeners();

    /**
     * 获取布局文件ID
     * @return
     */
    public abstract int getLayoutId();

}
