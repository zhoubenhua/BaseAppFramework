package com.eyunhome.baseappframework.view.fragment;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

/**
 * 作者：zhoubenhua
 * 时间：2017-7-29 16:37
 * 功能: 碎片基类 子项目要定义类 继承基类 重写onCreateView
 */
public abstract class BaseFragment extends Fragment {
    protected ProgressDialog loadingProgressDialog; //请求网络弹出加载框

    /**
     * 初始化控件
     */
    public abstract void initViews(View view);

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

    protected LayoutInflater mInflater;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        this.mInflater = inflater;
//        View view = this.mInflater.inflate(getLayoutId(),container,false);
//        initViews(view);
//        initData();
//        addListeners();
//        return view;
//    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    protected View inflateView(int resId) {
        return this.mInflater.inflate(resId, null);
    }

    public boolean onBackPressed() {
        return false;
    }


}
