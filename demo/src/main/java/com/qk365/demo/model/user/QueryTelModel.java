package com.qk365.demo.model.user;

import android.content.Context;

import com.alibaba.fastjson.JSONObject;
import com.eyunhome.baseappframework.listener.ResponseResultListener;
import com.qk365.demo.api.ApiAsyncTask;
import com.qk365.demo.api.Protocol;
import com.qk365.demo.api.QkBuildConfig;
import com.qk365.demo.bean.ResponseResult;
import com.qk365.demo.contract.UserContract;
import com.qk365.demo.util.Constants;

/**
 * @desc 处理查询电话业务
 * @auth zhoubenhua
 * @time 2017-12-4. 15:32.
 */

public class QueryTelModel extends UserContract.QueryTelContract.AbstractQueryTelModel {
    @Override
    public void doQueryTelRequest(Context mContext, JSONObject bodyParams) {
        String url = QkBuildConfig.getInstance().getConnect().getApiUrl() + Protocol.QUERY_CARD_STATUS;
        ApiAsyncTask apiAsyncTask = new ApiAsyncTask(mContext);
        String apiLogFileDirectory = Constants.LogDef.LOG_DIRECTORY;
        String apiLogFileName = Constants.LogDef.LOG_FILE_NAME;
        apiAsyncTask.post(apiLogFileDirectory, apiLogFileName, url, bodyParams, null, new ResponseResultListener() {
            @Override
            public void doResponse(Object data) {
                ResponseResult result = (ResponseResult) data;
                setChanged();
                notifyObservers(result);
            }
        });
    }
}
