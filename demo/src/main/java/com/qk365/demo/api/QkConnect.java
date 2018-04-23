package com.qk365.demo.api;


import com.eyunhome.baseappframework.bean.BaseConnect;

/**
 * @desc 连接青客各个服务地址
 * @auth zhoubenhua
 * @time 2017-12-5. 13:47.
 */
public class QkConnect extends BaseConnect {

    /**
     * 后台服务器地址
     */
    private String apiHmUrl;//基地址带hm
    private String pushUrl;//推送平台的基地址
    private String appChannelId;//推送渠道id
    private String priceApiUrl;// 定价系统
    private String settlementUrl;//结算单地址
    private String rankPrivoider;//排行榜地址
    private String scanCardUrl;
    private String apiMyRoomUrl;//基地址带myroom add by clk
    private String healthyUrl;
    private String aliParams;//获取阿里参数即地址
    private String customerGrabsingle;//客户线索抢单
    private String thirdService;//第三方对接
    private String commonPrivoider;//获取系统配置接口
    private String scgUrl;//学习专区
    private String inverstigationApproval;//勘查审批
    private String withLookApproval;//带看审批

    private String ScanClientCodeUrl;
    private String ifSale;//是否是采购
    private String fullWaterService;//充水服务
    private String specialPerformance;//专场
    private String area;//区域
    private String share;//共享
    private String grabSingle;//自动抢单

    public String getApiHmUrl() {
        return apiHmUrl;
    }

    public void setApiHmUrl(String apiHmUrl) {
        this.apiHmUrl = apiHmUrl;
    }

    public String getPushUrl() {
        return pushUrl;
    }

    public void setPushUrl(String pushUrl) {
        this.pushUrl = pushUrl;
    }

    public String getAppChannelId() {
        return appChannelId;
    }

    public void setAppChannelId(String appChannelId) {
        this.appChannelId = appChannelId;
    }

    public String getPriceApiUrl() {
        return priceApiUrl;
    }

    public void setPriceApiUrl(String priceApiUrl) {
        this.priceApiUrl = priceApiUrl;
    }

    public String getSettlementUrl() {
        return settlementUrl;
    }

    public void setSettlementUrl(String settlementUrl) {
        this.settlementUrl = settlementUrl;
    }

    public String getRankPrivoider() {
        return rankPrivoider;
    }

    public void setRankPrivoider(String rankPrivoider) {
        this.rankPrivoider = rankPrivoider;
    }

    public String getScanCardUrl() {
        return scanCardUrl;
    }

    public void setScanCardUrl(String scanCardUrl) {
        this.scanCardUrl = scanCardUrl;
    }

    public String getApiMyRoomUrl() {
        return apiMyRoomUrl;
    }

    public void setApiMyRoomUrl(String apiMyRoomUrl) {
        this.apiMyRoomUrl = apiMyRoomUrl;
    }

    public String getHealthyUrl() {
        return healthyUrl;
    }

    public void setHealthyUrl(String healthyUrl) {
        this.healthyUrl = healthyUrl;
    }

    public String getAliParams() {
        return aliParams;
    }

    public void setAliParams(String aliParams) {
        this.aliParams = aliParams;
    }

    public String getCustomerGrabsingle() {
        return customerGrabsingle;
    }

    public void setCustomerGrabsingle(String customerGrabsingle) {
        this.customerGrabsingle = customerGrabsingle;
    }

    public String getThirdService() {
        return thirdService;
    }

    public void setThirdService(String thirdService) {
        this.thirdService = thirdService;
    }

    public String getCommonPrivoider() {
        return commonPrivoider;
    }

    public void setCommonPrivoider(String commonPrivoider) {
        this.commonPrivoider = commonPrivoider;
    }

    public String getScgUrl() {
        return scgUrl;
    }

    public void setScgUrl(String scgUrl) {
        this.scgUrl = scgUrl;
    }

    public String getInverstigationApproval() {
        return inverstigationApproval;
    }

    public void setInverstigationApproval(String inverstigationApproval) {
        this.inverstigationApproval = inverstigationApproval;
    }

    public String getWithLookApproval() {
        return withLookApproval;
    }

    public void setWithLookApproval(String withLookApproval) {
        this.withLookApproval = withLookApproval;
    }

    public String getScanClientCodeUrl() {
        return ScanClientCodeUrl;
    }

    public void setScanClientCodeUrl(String scanClientCodeUrl) {
        ScanClientCodeUrl = scanClientCodeUrl;
    }

    public String getIfSale() {
        return ifSale;
    }

    public void setIfSale(String ifSale) {
        this.ifSale = ifSale;
    }

    public String getFullWaterService() {
        return fullWaterService;
    }

    public void setFullWaterService(String fullWaterService) {
        this.fullWaterService = fullWaterService;
    }

    public String getSpecialPerformance() {
        return specialPerformance;
    }

    public void setSpecialPerformance(String specialPerformance) {
        this.specialPerformance = specialPerformance;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public String getGrabSingle() {
        return grabSingle;
    }

    public void setGrabSingle(String grabSingle) {
        this.grabSingle = grabSingle;
    }
}
