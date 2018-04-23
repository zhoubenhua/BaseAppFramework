package com.eyunhome.baseappframework.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 作者：zhoubenhua
 * 时间：2016-10-31 11:07
 * 功能:日期工具
 */
public class DateUtil {

    public static String getCurrentDate() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        String date = sDateFormat.format(new java.util.Date());
        return date;
    }

    /**
     * 将日期时间转换指定格式
     * @param dateTimes 日期时间字符串
     * @param format 格式
     * @return
     */
    public static String getDateTimeByTimes(String dateTimes,int format) {
        SimpleDateFormat df = null ;
        String date = null;
        switch (format) {
            case 1:
                df = new SimpleDateFormat(
                        "yyyy-MM-dd HH:mm:ss");
                break;
            case 2:
                df = new SimpleDateFormat(
                        "yyyy-MM-dd");
                break;
        }
        try {
            if(df != null) {
                date = df.format(df.parse(dateTimes));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
