package com.eyunhome.baseappframework.listener;

import android.database.sqlite.SQLiteDatabase;

import com.eyunhome.baseappframework.db.QkDb;


/**
 * 数据库升级监听器
 */
public interface DbUpdateListener {
    public void onUpgrade(QkDb qkDb, SQLiteDatabase db, int oldVersion, int newVersion);
}
