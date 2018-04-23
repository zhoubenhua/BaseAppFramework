package com.eyunhome.baseappframework.common;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * 作者：zhoubenhua
 * 时间：2017-7-29 16:40
 * 功能: 检查权限工具
 */
public class PermissionsCheckerUtil {


    /**
     * 检查是否缺少指定权限
     * @param mContext
     * @param permission 指定权限
     * @return
     */
    public static boolean checkIsLacksPermission(Context mContext,String permission) {
        return ContextCompat.checkSelfPermission(mContext, permission) ==
                PackageManager.PERMISSION_DENIED;
    }


    /**
     * 检测指定的权限是否都已授权
     * @param permissions  指定权限
     * @return
     */
    @TargetApi(Build.VERSION_CODES.M)
    public static  boolean chickIsRequestPermissions(Activity activity, String[] permissions) {
        for (String permission : permissions) {
            if (activity.checkSelfPermission(permission) !=
                    PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    /**
     * 申请指定权限
     * @param mActivity
     * @param permissions  指定权限
     * @param flag
     */
    public static void requestPermission(Activity mActivity, String[] permissions, int flag) {
        ActivityCompat.requestPermissions(mActivity, permissions, flag);
    }

    /**
     * 检查当前手机系统是否需要动态申请权限
     * @return
     */
    public static boolean chickIsRequestPermissions() {
        boolean flag = false;
        /**
         * 判断当前系统是否是高于等于6.0
         */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            /**
             * 高于等于6.0 需要动态申请权限
             */
            flag = true;
        }
        return flag;
    }

    /**
     * 确认所有的权限是否都已授权
     *
     * @param grantResults
     * @return
     */
    public static boolean verifyPermissions(int[] grantResults) {
        for (int grantResult : grantResults) {
            if (grantResult != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

}
