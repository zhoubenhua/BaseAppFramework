package com.eyunhome.safe;

/**
 * Created by acer on 2015-12-7.
 */
public class Safe {
    static {
        System.loadLibrary("safe");
    }

    /**
     * 获取阿里云accessKeyId
     * @return
     */
    public native String getAliyuncsAccessKeyId();
    /**
     * 获取阿里云accessKeySecret
     * @return
     */
    public native String getAliyuncsAccessKeySecret();
    /**
     * 获取阿里云OSS域名
     * @return
     */
    public native String getAliyuncsOosDomain();

    /**
     * 获取阿里云OSS房管员bucket
     * @return
     */
    public native String getAliyuncsOosHousekeeperBucket();
    /**
     * 获取阿里云OSS工地锁bucket
     * @return
     */
    public native String getAliyuncsOosSiteLockBucket();
    /**
     * 获取阿里云OSS青客宝bucket
     * @return
     */
    public native String getAliyuncsQkPayBucket();
    /**
     * 获取阿里云OSS青客测距仪bucket
     * @return
     */
    public native String getAliyuncsQkRangefinderBucket();
    /**
     * 获取阿里云OSS青客在线bucket
     * @return
     */
    public native String getAliyuncsQkOnlineBucket();
    /**
     * 获取阿里云OSS青客保洁bucket
     * @return
     */
    public native String getAliyuncsQkBreamBucket();

    /**
     * 获取阿里云OSS青客远程验收bucket
     * @return
     */
    public native String getAliyuncsQkRemoteaccpetanceBucket();
    /**
     * 获取阿里云OSS青客会员bucket
     * @return
     */
    public native String getAliyuncsQkHuiyuanBucket();
    /**
     * 获取阿里云OSS智能公章
     * @return
     */
    public native String getAliyuncsSmartsealBucket();

    /**
     * 获取阿里云OSS青客维修 bucket
     * @return
     */
    public native String getAliyuncsQkRepairBucket();

    /**
     * 获取阿里云OSS青客房源采购 bucket
     * @return
     */
    public native String getAliyuncsQkHousingProcurementBucket();

}
