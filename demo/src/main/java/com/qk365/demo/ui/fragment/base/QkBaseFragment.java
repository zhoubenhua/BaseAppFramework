package com.qk365.demo.ui.fragment.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eyunhome.baseappframework.common.GenericsUtils;
import com.eyunhome.baseappframework.model.BaseModel;
import com.eyunhome.baseappframework.presenter.BasePresenter;
import com.eyunhome.baseappframework.view.BaseView;
import com.eyunhome.baseappframework.view.fragment.BaseFragment;

/**
 * @desc 青客碎片基类     `
 * @auth zhoubenhua
 * @time 2018-4-12 11:21
 */

public abstract class QkBaseFragment<P extends BasePresenter,M extends BaseModel>
        extends BaseFragment implements BaseView {
    public Context mContext;
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
            if (getActivity().isFinishing() == false ) {
                if (loadingProgressDialog == null) {
                    loadingProgressDialog = ProgressDialog.show(getActivity(), title,
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


    /**
     * 初始化mvp(model,view,presenter)
     */
    public  void  initMvp(){
        mPresenter = GenericsUtils.getParameterizedType(this,0);
        if(mPresenter != null) {
            mModel =  GenericsUtils.getParameterizedType(this,1);
            mPresenter.attactView(this,mModel,mContext);
        }
    }

    public void closeProgressDialog() {
        try {
            if (getActivity().isFinishing() == false && loadingProgressDialog != null) {
                loadingProgressDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.mInflater = inflater;
        View view = this.mInflater.inflate(getLayoutId(),container,false);
        mContext = getActivity();
        initViews(view);
        initMvp();
        initData();
        addListeners();
        return view;
    }
}
