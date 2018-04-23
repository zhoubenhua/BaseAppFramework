package com.qk365.demo.ui.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.TextView;

import com.eyunhome.baseappframework.bean.AliyuncsOosBean;
import com.eyunhome.baseappframework.common.CommonUtil;
import com.eyunhome.baseappframework.common.PermissionsCheckerUtil;
import com.eyunhome.baseappframework.common.UploadLogFileUtil;
import com.eyunhome.baseappframework.widget.TopbarView;
import com.eyunhome.safe.Safe;
import com.qk365.demo.R;
import com.qk365.demo.ui.activity.base.QkBaseActivity;
import com.qk365.demo.ui.activity.record.RecordVideoActivity;
import com.qk365.demo.ui.activity.user.LoginActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends QkBaseActivity {
    private TextView testMvpTv;
    private Context mContext;
    private TopbarView topbarView;
    private TextView testRecordVideoTv;
    private TextView testUploadLogTv;
    private TextView testDbTv;


    @Override
    public void initViews() {
        topbarView = (TopbarView)findViewById(R.id.top_bar_view);
        testMvpTv = (TextView)findViewById(R.id.test_mvp_tv);
        testRecordVideoTv = (TextView)findViewById(R.id.test_record_video_tv);
        testDbTv = (TextView)findViewById(R.id.test_db_tv);
        testUploadLogTv = (TextView)findViewById(R.id.test_upload_log_tv);
    }

    @Override
    public void initData() {
        mContext = this;
        topbarView.setTopbarTitle("使用青客框架Demo");
    }

    /**
     * 测试上传日志
     */
    private void testUploadLog() {
        AliyuncsOosBean aliyuncsOosBean = new AliyuncsOosBean();
        Safe safe = new Safe();
        aliyuncsOosBean.setAliyuncsAccessKeyId(safe.getAliyuncsAccessKeyId());
        aliyuncsOosBean.setAliyuncsAccessKeySecret(safe.getAliyuncsAccessKeySecret());
        aliyuncsOosBean.setAliyuncsOosBucket(safe.getAliyuncsQkHuiyuanBucket());
        aliyuncsOosBean.setAliyuncsOosDomain(safe.getAliyuncsOosDomain());
        File files = new File(CommonUtil.getSDCardPath() + "/qkonline/log");
        String userName = "15782541265";
        UploadLogFileUtil.uploadLogFileDirectory(mContext,userName,files.listFiles(),aliyuncsOosBean);
    }

    /**
     * 测试录制视频事件
     */
    private View.OnClickListener testRecordVideoListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            checkRecordNeedsPermission();
        }
    };

    /**
     * 测试上传日志
     */
    private View.OnClickListener testUploadLogListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            testUploadLog();
        }
    };


    /**
     * 测试数据库
     */
    private View.OnClickListener testDbListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            startActivity(new Intent(mContext,TestDbActivity.class));
        }
    };


    /**
     * 检查录音需要的权限
     */
    private void checkRecordNeedsPermission( ) {
        /**
         * 检查是否需要授权
         */
        if(PermissionsCheckerUtil.chickIsRequestPermissions()) {
            List<String> permissionList = new ArrayList<String>();
            if(PermissionsCheckerUtil.checkIsLacksPermission(mContext,Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            }
            if(PermissionsCheckerUtil.checkIsLacksPermission(mContext,Manifest.permission.CAMERA)) {
                permissionList.add(Manifest.permission.CAMERA);
            }
            if(PermissionsCheckerUtil.checkIsLacksPermission(mContext,Manifest.permission.RECORD_AUDIO)) {
                permissionList.add(Manifest.permission.RECORD_AUDIO);
            }
            if(permissionList.size() != 0) {
                ActivityCompat.requestPermissions(this, permissionList.toArray(new String[permissionList.size()]), 1);
            } else {
                startActivity(new Intent(mContext,RecordVideoActivity.class));
            }
        } else {
            /**
             * 不需要授权
             */
            startActivity(new Intent(mContext,RecordVideoActivity.class));
        }
    }


    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0) {
                    for (int result : grantResults) {
                        if (result != PackageManager.PERMISSION_GRANTED) {
                            CommonUtil.sendToast(mContext,"必须同意所有权限才能使用本程序");
                            return;
                        }
                    }
                    startActivity(new Intent(mContext,RecordVideoActivity.class));
                }
                break;
        }
    }



    @Override
    public void addListeners() {
        testMvpTv.setOnClickListener(testMvpListener);
        testRecordVideoTv.setOnClickListener(testRecordVideoListener);
        testDbTv.setOnClickListener(testDbListener);
        testUploadLogTv.setOnClickListener(testUploadLogListener);

    }

    /**
     * 测试mvp事件
     */
    private View.OnClickListener testMvpListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            startActivity(new Intent(mContext,LoginActivity.class));
        }
    };

    @Override
    public int getLayoutId() {
        return R.layout.main;
    }

}
