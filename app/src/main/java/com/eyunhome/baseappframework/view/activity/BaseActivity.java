package com.eyunhome.baseappframework.view.activity;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;


/**
 * activity基类,所有的activity继承它
 */
public abstract class BaseActivity extends Activity {
    public Context mContext;


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
