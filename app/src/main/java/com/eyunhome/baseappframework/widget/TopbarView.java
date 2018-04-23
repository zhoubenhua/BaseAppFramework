package com.eyunhome.baseappframework.widget;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.eyunhome.baseappframework.R;
import com.eyunhome.baseappframework.common.CommonUtil;
import com.eyunhome.baseappframework.listener.TopbarImplListener;


/**
 * 顶部头部条
 */
public class TopbarView extends RelativeLayout {
    private TextView topbarTitleTv;
    private TextView topbarLeftTitelTv;
    private ImageView topbarLeftImgIv;
    private TextView topbarRightTitelTv;
    private ImageView topbarRightImgIv;
    private RelativeLayout topBarRl;
    private View topView;

    public TopbarImplListener listener;

    public TopbarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater mInflater = LayoutInflater.from(context);
        topView = mInflater.inflate(R.layout.top_bar, this,
                false);
        topBarRl = (RelativeLayout)topView.findViewById(R.id.top_bar_rl);
        topbarTitleTv = (TextView) topView.findViewById(R.id.top_bar_title_tv);
        topbarLeftImgIv = (ImageView) topView.findViewById(R.id.top_bar_left_img_iv);
        topbarLeftTitelTv = (TextView) topView.findViewById(R.id.top_bar_left_title_tv);
        topbarRightImgIv = (ImageView) topView.findViewById(R.id.top_bar_right_img_iv);
        topbarRightTitelTv = (TextView) topView.findViewById(R.id.top_bar_right_title_tv);
        topbarLeftImgIv.setOnClickListener(topBarLeftListener);
        topbarLeftTitelTv.setOnClickListener(topBarLeftListener);
        topbarRightImgIv.setOnClickListener(topBarRightListener);
        topbarRightTitelTv.setOnClickListener(topBarRightListener);
        addView(topView);
    }

    /**
     * topbar左边点击事件
     */
    private OnClickListener topBarLeftListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            if(listener != null) {
                listener.leftClick();
            }
        }
    };

      /**
     * topbar右边点击事件
     */
    private OnClickListener topBarRightListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            if(listener != null) {
                listener.rightClick();
            }
        }
    };

    /**
     * 设置背景颜色
     * @param color
     */
    public void setBackgroundResource(int color) {
        topBarRl.setBackgroundResource(color);
    }


    public TextView getTopbarTitleTv() {
        return topbarTitleTv;
    }


    public TextView getTopbarLeftTitelTv() {
        return topbarLeftTitelTv;
    }

    public ImageView getTopbarLeftImgIv() {
        return topbarLeftImgIv;
    }

    public TextView getTopbarRightTitelTv() {
        return topbarRightTitelTv;
    }

    public ImageView getTopbarRightImgIv() {
        return topbarRightImgIv;
    }


    /**
     * 设置top中间文字
     *
     * @param title
     */
    public void setTopbarTitle(String title) {
        if (!CommonUtil.isEmpty(title)) {
            topbarTitleTv.setText(title);
        }
    }


    public RelativeLayout getTopbarView() {
        return topBarRl;
    }

    /**
     * 设置top bar事件
     *
     * @param listener
     */
    public void setTopBarClickListener(TopbarImplListener listener) {
        this.listener = listener;
    }


}
