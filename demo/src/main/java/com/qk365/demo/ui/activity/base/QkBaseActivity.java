package com.qk365.demo.ui.activity.base;

import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;

import com.eyunhome.baseappframework.common.GenericsUtils;
import com.eyunhome.baseappframework.model.BaseModel;
import com.eyunhome.baseappframework.presenter.BasePresenter;
import com.eyunhome.baseappframework.view.BaseView;
import com.eyunhome.baseappframework.view.activity.BaseActivity;

/**
 * @desc 界面基类
 * @auth zhoubenhua
 * @time 2017-11-21. 17:53.
 */
public abstract class QkBaseActivity<P extends BasePresenter,M extends BaseModel> extends BaseActivity implements BaseView {
    public ProgressDialog loadingProgressDialog; //请求网络弹出加载框
    public P mPresenter;
    public M mModel;

    /**
     * 打开加载框,用于调用接口弹出的对话框,并设置点击外部是否消失
     * @param title
     * @param message
     * @return
     */
    public ProgressDialog openProgressDialog(String title, String message) {
        try {
            if (isFinishing() == false) {
                if (loadingProgressDialog == null) {
                    loadingProgressDialog = ProgressDialog.show(this, title,
                            message);
                    loadingProgressDialog.setCancelable(false);
//                    loadingProgressDialog.setCanceledOnTouchOutside(true);
                } else {
                    loadingProgressDialog.setTitle(title);
                    loadingProgressDialog.setMessage(message);
                    if (loadingProgressDialog.isShowing() == false) {
                        loadingProgressDialog.show();
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return loadingProgressDialog;
    }


    public void closeProgressDialog() {
        try {
            if (isFinishing() == false && loadingProgressDialog != null) {
                loadingProgressDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化mvp(model,view,presenter)
     */
    public  void  initMvp(){
        mPresenter = GenericsUtils.getParameterizedType(this,0);
        if(mPresenter != null) {
            mModel =  GenericsUtils.getParameterizedType(this,1);
            mPresenter.attactView(this,mModel,this);
        }
    }




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(getLayoutId());
        initMvp();
        mContext = this;
        initViews();
        initData();
        addListeners();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter != null) {
            mPresenter.onDettach();
        }
    }
}
