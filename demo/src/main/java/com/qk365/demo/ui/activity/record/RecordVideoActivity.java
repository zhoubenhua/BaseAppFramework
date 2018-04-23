package com.qk365.demo.ui.activity.record;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.widget.ImageView;

import com.eyunhome.baseappframework.common.CommonUtil;
import com.eyunhome.baseappframework.widget.CustomeRecordVideoView;
import com.qk365.demo.R;
import com.qk365.demo.ui.activity.base.QkBaseActivity;

import java.io.File;
import java.io.IOException;

/**
 * 作者：zhoubenhua
 * 时间：2017-3-9 16:08
 * 功能:录制视频
 */
public class RecordVideoActivity extends QkBaseActivity {
    private CustomeRecordVideoView recordVideoCv;
    private Context mContext;
    private ImageView startRecordIv,stopRecordIv;
    @Override
    public void initViews() {
        recordVideoCv = (CustomeRecordVideoView)findViewById(R.id.record_video_cv);
        startRecordIv = (ImageView)findViewById(R.id.start_record_iv);
        stopRecordIv = (ImageView)findViewById(R.id.stop_record_iv);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void initData() {
        mContext = this;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        recordVideoCv.realeaseCameraResource();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        recordVideoCv.realeaseCameraResource();
    }

    /**
     * 开始录音事件
     */
    private View.OnClickListener startRecordListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            File recordVideoFileDirectory = new File(CommonUtil.getSDCardPath()+"/video");
            try {
                startRecordIv.setVisibility(View.GONE);
                stopRecordIv.setVisibility(View.VISIBLE);
                if(!recordVideoFileDirectory.exists()) {
                  recordVideoFileDirectory.createNewFile();
                }
                recordVideoCv.startRecordVideo(new File(recordVideoFileDirectory+ "/"
                        + System.currentTimeMillis() + ".mp4"));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

        /**
     * 停止录音事件
     */
    private View.OnClickListener stopRecordListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            stopRecordIv.setVisibility(View.GONE);
            startRecordIv.setVisibility(View.VISIBLE);
            recordVideoCv.stopRecord();
        }
    };

    @Override
    public void addListeners() {
        startRecordIv.setOnClickListener(startRecordListener);
        stopRecordIv.setOnClickListener(stopRecordListener);
    }

    @Override
    public int getLayoutId() {
        return R.layout.recorder_video;
    }

}
