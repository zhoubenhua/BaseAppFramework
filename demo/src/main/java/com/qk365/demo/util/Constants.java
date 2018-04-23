package com.qk365.demo.util;


import com.eyunhome.baseappframework.common.CommonUtil;

/**
 * Created by acer on 2016-7-19.
 */
public class Constants {

    /**
     * 日志常量
     */
    public static final class LogDef {
        /**
         * 本地文件基目录
         */
        public static final String FILE_BASE_DIRECTORY = CommonUtil.getSDCardPath() + "/" + "project";
        /**
         * 日志目录
         */
        public static final String LOG_DIRECTORY = FILE_BASE_DIRECTORY + "/log";
        /**
         * 日志名称
         */
        public static final String LOG_FILE_NAME = "qk_api_log.txt";
    }
}
