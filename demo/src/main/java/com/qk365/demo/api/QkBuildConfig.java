package com.qk365.demo.api;

import com.eyunhome.baseappframework.bean.BaseBuildConfig;
import com.eyunhome.baseappframework.bean.BaseConnect;

import static com.qk365.demo.api.QkBuildConfig.EnvironmentType.TEST;


/**
 * @desc 配置各个环境服务器地址
 * @auth zhoubenhua
 * @time 2017-12-5. 13:47.
 */
public class QkBuildConfig extends BaseBuildConfig {
    private QkConnect connect;
    private static QkBuildConfig instance;
    private EnvironmentType environmentType;//环境类型 1是正式 2是仿真 3是测试
    private String baseUrl;

    public static QkBuildConfig getInstance() {
       if(instance == null) {
           instance = new QkBuildConfig();
       }
       return instance;
    }

    public enum EnvironmentType {
        TEST,//测试
        SIMULATION, //仿真
        OFFICIAL //正式
    }

    private QkBuildConfig() {
        /**
         * 默认切换到测试环境
         */
        environmentType = TEST;
        connect = new QkConnect();
        changeEnvironment();
    }

    public BaseConnect getConnect() {
        return connect;
    }

    /**
     * 切换环境
     */
    public void changeEnvironment(){
        switch(environmentType) {
            case OFFICIAL:
                /**
                 * 切换正式环境
                 */
                switchOfficial();
                break;
            case SIMULATION:
                /**
                 * 切换仿真环境
                 */
                switchSimulation();
                break;
            case TEST:
                /**
                 * 切换测试环境
                 */
                switchTest();
                break;
        }
    }

    /**
     * 切换正式环境
     */
    @Override
    public void switchOfficial() {
        baseUrl = "http://58.215.175.244:8080/";
        connect.setApiUrl(baseUrl + "mdk");//正式
        connect.setApiHmUrl(baseUrl + "hmconsumer");//退房
        connect.setApiMyRoomUrl(baseUrl + "hdkprovider");//我的房间
        connect.setHealthyUrl(baseUrl + "hdkprovider");// 我的健康度
        connect.setRankPrivoider(baseUrl + "rankprovider");// 排行榜正式
        connect.setThirdService(baseUrl + "thirdprovider");//第三方对接
        connect.setCommonPrivoider(baseUrl + "commonprovider");//commonprovider
        connect.setPushUrl("http://58.215.175.243:8585/qkMessagePushProvider");//推送平台正式地址
        connect.setAppChannelId("043ef3db-82f7-11e6-a590-a0481c7d4a7c"); //极光推送渠道id测试和正式
        connect.setPriceApiUrl("http://mdj.qk365.com/User/Login");//定价系统正式地址
        connect.setSettlementUrl("http://api.qk365.com/mobile");//结算单正式地址
        connect.setScanCardUrl("http://kpff.qk365.com:83/api");//扫码正式
        connect.setAliParams("http://58.215.175.244:8080");//获取阿里参数地址正式
        connect.setCustomerGrabsingle("http://58.215.175.244:83");//客户线索抢单
        connect.setScgUrl("http://58.215.175.254:58086");//学习专区
        connect.setInverstigationApproval("http://58.215.175.244:8081/index.html#/Home");//勘查审批
        connect.setWithLookApproval("http://58.215.175.244:8081/index.html#/ApproHome");//带看审批
        connect.setIfSale("http://58.215.175.244:8081");//判断岗位是否是采购
        connect.setFullWaterService("http://jf.qk365.com");//充水

        connect.setSpecialPerformance("http://58.215.175.244:83/#/businesslist?type=0&to=native&");//专场
        connect.setArea("http://58.215.175.244:83/#/businesslist?type=1&to=native&");//区域
        connect.setShare("http://58.215.175.244:83/#/index/business/share");//共享
        connect.setGrabSingle("http://58.215.175.244:83/#/index/my/mytrack");//我的线索页
    }

    /**
     * 切换测试环境
     */
    @Override
    public void switchTest() {
        baseUrl = "http://qingketest.chinacloudapp.cn:30316/";
        connect.setPushUrl("http://192.168.1.236:58706/qkMessagePushProvider");//推送平台测试基地址
        connect.setApiUrl("http://qingketest.chinacloudapp.cn:9466/" + "mdk");//72测试mdk
        connect.setApiHmUrl(baseUrl + "hmconsumer");//测试hmconsumer
        connect.setThirdService(baseUrl + "thirdprovider");//第三方对接
        connect.setCommonPrivoider(baseUrl + "commonprovider");//获取系统参数
        connect.setApiMyRoomUrl(baseUrl + "myroom");//测试我的房间
        connect.setAppChannelId("043ef3db-82f7-11e6-a590-a0481c7d4a7c"); //极光推送渠道id测试和正式
        connect.setPriceApiUrl("http://192.168.1.86:8080/User/Login");//定价系统测试环境
        connect.setSettlementUrl("http://wx01.test.qk365.com/mobile");//结算单测试环境
        connect.setRankPrivoider(baseUrl + "rankPrivoider");//排行榜测试环境
        connect.setScanCardUrl("http://qktest.chinacloudapp.cn:8082/api");//扫码测试地址
        connect.setHealthyUrl(baseUrl + "myroom");//我的健康度测试
        connect.setAliParams("http://qingketest.chinacloudapp.cn:37256");//获取阿里参数地址
        connect.setCustomerGrabsingle("http://qingketest.chinacloudapp.cn:30316");//客户线索抢单
        connect.setScgUrl("http://116.228.53.202:89");//学习专区
        connect.setInverstigationApproval("http://qingketest.chinacloudapp.cn:13889/index.html#/Home");//勘查审批
        connect.setWithLookApproval("http://qingketest.chinacloudapp.cn:13889/index.html#/ApproHome");//带看审批
        connect.setIfSale("http://qingketest.chinacloudapp.cn:13889");//判断岗位是否是采购
        connect.setFullWaterService("http://qingketest.chinacloudapp.cn:18666/QKBilling");//充水

        connect.setSpecialPerformance("http://qingketest.chinacloudapp.cn:30316/#/businesslist?type=0&to=native&");//专场
        connect.setArea("http://qingketest.chinacloudapp.cn:30316/#/businesslist?type=1&to=native&");//区域
        connect.setShare("http://qingketest.chinacloudapp.cn:30316/#/index/business/share");//共享
        connect.setGrabSingle("http://qingketest.chinacloudapp.cn:30316/#/index/my/mytrack");//我的线索页
    }

    /**
     * 切换仿真环境
     */
    @Override
    public void switchSimulation() {
        baseUrl = "http://139.219.198.123:18106/";
        connect.setPushUrl("http://192.168.1.156:8585/qkMessagePushProvider");//推送平台仿真地址（内网）
        connect.setApiUrl(baseUrl + "mdk");//仿真mdk
        connect.setApiHmUrl(baseUrl + "hmconsumer");//退房仿真
        connect.setThirdService("http://qingkesim.chinacloudapp.cn:51366/thirdprovider");//第三方对接
        connect.setCommonPrivoider("http://qingkesim.chinacloudapp.cn:52366/commonprovider");
        connect.setApiMyRoomUrl(baseUrl + "myroom");//仿真我的房间
        connect.setAppChannelId("043ef3db-82f7-11e6-a590-a0481c7d4a7c"); //仿真极光推送渠道id
        connect.setPriceApiUrl("http://qingkesim.chinacloudapp.cn:8003/User/Login");//定价系统仿真地址
        connect.setSettlementUrl("http://wx03.test.qk365.com/mobile");//结算单仿真地址
        connect.setRankPrivoider("http://139.219.198.123:58082/rankprovider");//排行榜仿真
        connect.setScanCardUrl("http://qksim.chinacloudapp.cn:8089/api");//扫码仿真外网映射
        connect.setHealthyUrl(baseUrl + "myroom");//我的健康度仿真
        connect.setAliParams("http://qingketest.chinacloudapp.cn:37256");//获取阿里参数地址仿真
        connect.setCustomerGrabsingle("http://139.219.198.123:8088");//客户线索抢单
        connect.setScgUrl("http://qingkesim.chinacloudapp.cn:58888");//学习专区
        connect.setInverstigationApproval("http://qingkesim.chinacloudapp.cn:8301/index.html#/Home");//勘查审批
        connect.setWithLookApproval("http://qingkesim.chinacloudapp.cn:8301/index.html#/ApproHome");//带看审批
        connect.setIfSale("http://qingkesim.chinacloudapp.cn:8301");//判断岗位是否是采购
        connect.setFullWaterService("http://qingkesim.chinacloudapp.cn:51306");//充水
        connect.setSpecialPerformance("http://139.219.198.123:8088/#/businesslist?type=0&to=native&");//专场
        connect.setArea("http://139.219.198.123:8088/#/businesslist?type=1&to=native&");//区域
        connect.setShare("http://139.219.198.123:8088/#/index/business/share");//共享
        connect.setGrabSingle("http://139.219.198.123:8088/#/index/my/mytrack");//我的线索页
    }

}
