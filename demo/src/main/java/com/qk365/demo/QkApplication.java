/*
 * Copyright (c) 2016.
 * All right reserved.
 * @author:
 * @date:2016.
 */

package com.qk365.demo;

import android.app.Application;


public class QkApplication extends Application {
    public void onCreate() {
        super.onCreate();
        CatchAppException handler = new CatchAppException(this);
        Thread.setDefaultUncaughtExceptionHandler(handler);
    }


}
