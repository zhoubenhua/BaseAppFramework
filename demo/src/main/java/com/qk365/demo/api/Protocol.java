package com.qk365.demo.api;

/**
 * 接口地址
 */
public class Protocol {
    //用户注册
    public static String MEMBER_FGYId = "easemob/customerFgy/customerList.json";
    public static String LOGIN_JSON = "/fgy/app/login/login.json";
    public static String TOKEN_JSON = "/fgy/app/login/token.json";
    public static String LOGIN_URL = "login";
    /**
     * 待回访信息列表接口（包括每月回访，到期回访与搜索接口合并）
     */
    public static String NO_VISIT_ROOM = "/fgy/app/visit/undone/list.json";

    /**
     * 当月到期访问接口与 3到期列表接口
     */
    public static String CURRENT_MONTH_EXPIRE = "/fgy/app/visit/undone/expireList.json";
    /**
     * 回访信息录入显示
     */
    public static String RETURN_VISIT_INPUT_SHOW = "/fgy/app/visit/create/show.json";
    /**
     * 回访信息录入保存
     */
    public static String RETURN_VISIT_INPUT_SAVE = "/fgy/app/visit/create/save.json";
    /**
     * 未带看勘察列表  旧
     */
    public static String GET_WAITING_SURVERY_ROOMS = "/fgy/app/daikanList/getWaitingSurveyRooms.json";
    /**
     * 未带看勘察列表  新
     */
    public static String GET_WAITING_SURVERY_ROOMSNEW = "/fgy/app/survey/getWaitingSurveyCell.json";


    /**
     * 已带看侦察列表
     */
    public static String GET_SEE_SURVERY_ROOMS = "/fgy/app/daikanList/getSeeSurveyRooms.json";
    /**
     * 新增客户信息接口(区域，价格，房型，户型)
     */
    public static String DEMAND_LIST = "/fgy/app/customer/create/show.json";
    /**
     * 账号重复登录检查接口
     */
    public static String REPEAT_LOGIN_CHECK = "/fgy/app/login/repeatLoginCheck.json";
    /**
     * 新增客户信息保存接口
     */
    public static String PUT_DEMAND_LIST = "/fgy/app/customer/create/save.json";
    /**
     * 回访记录列表接口
     */
    public static String RETURN_VISIT_RESULT_LIST = "/fgy/app/visit/history/customerList.json";
    /**
     * 已带看详情接口
     */
    public static String GET_SEE_ROOM_SDETAIL = "/fgy/app/daikanList/getSeeRoomsDetail.json";
    /**
     * 历史回访信息列表接口（包括每月回访，到期回访，带看回访）
     */
    public static String HISTORY_RETURN_VISIT_RESULT_LIST = "/fgy/app/visit/history/addressList.json";
    /**
     * 回访详情
     */
    public static String RETURN_VISIT_DETAIL = "/fgy/app/visit/history/detail.json";
    /**
     * 已勘察详情
     */
    public static String GET_SEE_SURVERY_DETAIL = "/fgy/app/daikanList/getSeeSurveyDetail.json";
    /**
     * 撤销带看勘察
     */
    public static String CANCEL = "/fgy/app/daikan/cancel.json";
    /**
     * 登记带看显示
     */
    public static String REGRISTRATION_WITH_LOOK_SHOW = "/fgy/app/daikan/registersee.json";
    /**
     * 读取客户信息
     */
    public static String LOAD_CLIENT_INFO = "/fgy/app/daikan/autoLoadInfo.json";
    /**
     * 发起（带看/勘察）显示接口	,延时带看延时勘察接口(saleCheckId: 如果是null，那就是新发起的带看或者是勘察。如果不是null，那就是延时开看或者勘察.)
     */
    public static String INITIATE = "/fgy/app/daikan/initiate.json";

    /**
     * 发起（带看/勘察）提交接口 延时带看延时勘察接口
     */
    public static String INITIATESUBMIT = "/fgy/app/daikan/initiateSubmit.json";

    /**
     * 带看提交接口(与签退接口合并）66666666
     */
    public static String REGISTERSEESUBMIT = "/fgy/app/daikan/registerseeSubmit.json";
    /**
     * 登记勘察显示接口(与签到接口合并)
     */
    public static String SURVEY = "/fgy/app/daikan/survey.json";
    /**
     * 勘察提交接口(与签退接口合并)
     */
    public static String SURVEYSUBMIT = "/fgy/app/daikan/surveySubmit.json";
    /**
     * 房源列表初期显示接口 旧
     */
    public static String ROOMLIST = "/fgy/app/room/getFgyRoomList.json";

    /**
     * 房源列表初期显示接口  新
     */
    public static String ROOMLISTNEW = "/fgy/app/room/getFgyRoomList2.json";

    /**
     * 获取系统的时间
     */
    public static final String GET_SYS_DATE = "/fgy/common/Sysconfig/getSysDate";
    /**
     * 报修根据客户手机号查询会员和房间信息接口
     */
    public static String CUSTOMER_ROM_dETAIL = "/fgy/app/repair/getCustomerRomDetail.json";
    /**
     * 报修提交接口
     */
    public static String CREATEREPAIR = "/fgy/app/repair/createRepair.json";
    /**
     * 修改客户信息列表接口
     */
    public static String USERLIST = "/fgy/app/customer/list.json";
    /**
     * 修改客户信息界面接口
     */
    public static String MODIFYSHOW = "/fgy/app/customer/modify/show.json";
    /**
     * 修改客户信息保存接口
     */
    public static String MODIFYSAVE = "/fgy/app/customer/modify/save.json";
    /**
     * 发布渠道录入显示接口
     */
    public static String RELEASEDINTOSHOW = "/fgy/app/approach/show.json";
    /**
     * 发起渠道录入保存接口
     */
    public static String SAVERELEASEDINTO = "/fgy/app/approach/save.json";
    /**
     * 报修显示
     */
    public static String SHOWREPAIR = "/fgy/app/repair/showRepair.json";
    /**
     * 版本检测
     */
    public static String VERSION = "/fgy/app/upgrade/version.json";
    /**
     * 每日勘查 旧
     */
    public static String SURVERYOFDAY = "/fgy/app/room/getSurveryOfDayList.json";

    /**
     * 每日勘查  新
     */
    public static String SURVERYOFDAYNEW = "/fgy/app/room/getSurveryOfDayList2.json";
    /**
     * 设备号更换次数检查接口
     */
    public static String CHANGEDEVICECNT = "/fgy/app/login/changDeviceCnt.json";
    /**
     * 检查锁定状态接口(在发起带看和登记带看显示接口之前调用)
     */
    public static String CHECKISEXITDAIKAN = "/fgy/app/daikanList/checkIsExistsDaiKan.json";
    /**
     * 勘察重复检查接口(在发起勘察按钮按下时调用)
     */
    public static String CHECKISEXISTSSURVEY = "/fgy/app/daikanList/checkIsExistsSurvey.json";
    /**
     * 当月到期回访列表接口
     */
    public static String EXPIRELIST = "/fgy/app/visit/undone/expireList.json";
    /**
     * 当月回访到期显示接口
     */
    public static String EXPIRESHOW = "/fgy/app/visit/create/expireShow.json";
    /**
     * 当月回访到期保存接口
     */
    public static String EXPIRESAVE = "/fgy/app/visit/create/expireSave.json";
    /**
     * 获得实时榜初期表示列表接口
     */
    public static String GETREALTIMELIST = "/fgy/app/rankList/getRealTimeList.json";
    /**
     * 获得实时榜推送列表接口
     */
    public static String GETREALTIMEPUSHLIST = "/fgy/app/rankList/getRealTimePushList.json";
    /**
     * 获取排行榜列表接口
     */
    public static String GETVOLUMERANKLIST = "/fgy/app/rankList/getVolumeRankList.json";

    /***
     * 待租房间列表接口
     */
    public static String GETFORRENTROOMLIST = "/fgy/app/room/getFgyDaizuRoomList.json";


    /***
     * 待维修间列表接口
     */
    public static String GETFORREPAIREDROOMLIST = "/fgy/app/room/getWaitRepairRoomList.json";

    public static String GetWorkBillCount = "/fgy/app/room/GetWorkBillCount.json";

    /**
     * 根据用户权限获取区域
     */
    public static String AREAUTHLIST = "/common/area/get/areauthlist.json";

    //add by clk on
    /***
     * 7.3获取签约客户列表接口
     */
    public static String GETSIGNCONTRACTLIST = "/fgy/app/signContract/signContractList.json";
    /***
     * 7.4获取续租客户列表接口
     */
    public static String GETRENEWALCONTRACTLIST = "/fgy/app/reletContract/reletContractList.json";
    //获取续租客户对应的各item对应的数量
    public static String GET_RENEWALCONTRACT_ITEM_SCOUNT = "/fgy/app/reletContract/reletSumTotal.json";
    /***
     * 7.1客户线索列表接口和客户线索总人数接口
     */
    public static String CUMLIST = "/fgy/app/customer/get/cumlist.json";
    public static String CUSTOMER_CLUE_NUMBER = "/fgy/app/customer/get/cumlistStat.json";


    /**
     * 7.2获取带看客户列表
     */
    public static String GETBELTCONTRACTLIST = "/fgy/app/WaitViewCut/getList.json";
    //获取带看客户对应的items的数量
    public static String GET_BELTCONTRACT_ITEMS_COUNT = "/fgy/app/WaitViewCut/getListStat.json";

    /**
     * 歌曲下载
     */
    public static String GET_SONG_VERSION = "/fgy/app/upgrade/songVersion.json";

    /**
     * 查看剩余电量
     */
    public static String GET_REMAIN_POWER = "/fgy/app/daikan/getRemainPowerByRoom.json";

    /**
     * 获取当前系统时间
     */
    public static String GET_RANK_LIST_CURRENT_DATE = "/fgy/app/rankList/getCurrentDate.json";

    /**
     * 排行榜单数据接口
     * userId: 登录的房管员id
     * conditionDate: 排行榜日期范围查询条件：0.日，1.周，2.月
     * conditionArea: 排行榜区域查询条件：0.房管员，1.服务中心，2.分公司
     * year:年份
     * queryRange: conditionDate为0  queryRange取值为 日期（2016-10-21）
     * conditionDate为1  queryRange取值为第几周（22）
     * conditionDate为2  queryRange取值为第几月（10）
     */
    public static String GET_RANK_LIST_VOLUME_RANK_LIST = "/fgy/app/rankList/getVolumeRankList.json";

    //add by clk off


    public static String AREALIST = "/common/area/get/arelist.json";
    /**
     * 获取待租房数量接口
     */
    public static String GETDAIZUROOMCNT = "/fgy/app/room/getDaizuRoomCnt.json";

    /**
     * 待维修房间数量接口
     */
    public static String GET_WAITREPAIRROOMCNT = "/fgy/app/room/getWaitRepairRoomList.json";

    /**
     * 待维修房间工单数量接口
     */
    public static String GET_WAIT_REPAIR_ROOM_ORDER_COUNT = "/fgy/app/room/GetWorkBillCount.json";


    /**
     * 待维修房间工单接口
     */
    public static String GET_WAIT_REPAIR_ROOM_ORDERS = "/fgy/app/room/GetWorkBillList.json";


    /**
     * 勘察物品状态接口
     */
    public static String SURVEY_GOODS_STATE = "/fgy/app/checkitem/findCheckItemAddition.json";

    /**
     * 提交勘察结果接口
     */
    public static String SUBMIT_SURVEY_RESULT = "/fgy/app/daikan/surveySubmit.json";


    /**
     * 1.2房管员APP扫码接口
     */
    public static String SALES_CARD_TRANSFER = "/SalesCardTransfer/TransferMethod";


    /**
     * 1.3房管员APP确定领取卡片接口
     */
    public static String SALES_GET_CARD = "/SalesGetCard/GetCard";


    /**
     * 1.4房管员APP查看当前持卡人接口
     */
    public static String QUERY_CARD_STATUS = "/QueryCardStatus/Query";

    /**
     * 我的健康获取当前时间接口
     */
    public static String HEALTHDEGREE_GETCURRENTDATE = "/my/app/healthdegree/getCurrentDate";

    /**
     * 我的健康获取详细数据
     */
    public static String HEALTHDEGREE_GETHEALTHDEGREEDATA = "/my/app/healthdegree/getHealthdegreeData";


    //***************以下接口为IP地址后面携带hm的url(退房模块)*****************
    /**
     * 列表
     */
    public static String CHECKOUTLIST = "/fgy/app/qrexp/roomlist.json";

    /**
     * 详情查看接口
     */
    public static String EXCEPTIONDETAIL = "/fgy/app/qrexp/qrdetail.json";
    /**
     * (显示)调差项目类型接口
     */
    public static String ADJUSTMENTPROJECTITEM = "/fgy/app/qrexp/dfItems.json";

    /**
     * (保存调差项目数据)调差持久化接口
     */
    public static String SAVEADJUSTPROJECT = "/fgy/app/qrexp/adjust.json";

    /**
     * 退房审批通过/驳回
     */
    public static String APPROVEORREJECT = "/fgy/app/qrexp/approve.json";

    /**
     * 9.1.5正常退房 待验房 登记验房 当前房间剩余电量接口  卢敏的
     */
    //public static String GET_CHECK_OUT_REMAIN_POWER = "/fgy/app/daikan/getRemainPowerByRoom.json";
    /**
     * 9.1.5正常退房 待验房 登记验房 当前房间剩余电量接口  李飞飞的
     */
    public static String GET_CHECK_OUT_REMAIN_POWER = "/fgy/app/qrnom/getRemainPowerByRoom.json";

    /**
     * 9.1.1正常退房  发起勘察 延期勘察 发起验房  延期验房提交接口
     */
    public static String CHECKOUTINITIATESUBMIT = "/fgy/app/qrnom/precheck.json";

    /**
     * 9.2 异常退房 凭证上报接口
     */
    public static String VOUCHERREPORT = "/fgy/app/qrexp/proof.json";

    /**
     * 房管员列表接口
     */
    public static String SALESLIST = "/fgy/app/qrnom/saleslist.json";
    /**
     * 变更验房房管员
     */
    public static String CHECKER = "/fgy/app/qrnom/checker.json";

    /**
     * 不结算退房 申请退房操作
     */
    public static String NOSETTLECHECKER = "/fgy/app/qrnst/noSettAppy.json";

    /**
     * 获取时间是否T+1接口
     */

    public static String GETISADDDATE = "/fgy/app/qrnom/getIsAddDate.json";

    /**
     * 获取时间是否T+1接口
     */

    public static String VERIFICATENORMALCHECKOUTPROCESS = "/fgy/app/qrnom/checkStaus.json";

    /**
     * 0-->我的房间业务入口接口  获取6.1--6.5的房间数 clk
     * http://192.168.2.136:18888/services/my/app/myroom/getAllCount4MyRoomNum
     */
    public static String GETDAIZUROOMLISTCNT = "/fgy/app/room/getFgyDaizuRoomListCnt.json";


    /**
     * 1-->我的房间业务入口接口  获取6.6--6.9的房间数 clk
     * http://192.168.2.136:18888/services/my/app/myroom/getAllCount4MyRoomNum
     */
    public static String GETALLCOUNTMYROOMNUM = "/my/app/myroom/getAllCount4MyRoomNum";
    /**
     * 2-->获取退房待打扫房间接口  clk
     * http://192.168.2.136:18888/services/my/app/checkout/getCheckOutCleanRecord
     */
    public static String GETCHECKOUTCLEANRECORD = "/my/app/checkout/getCheckOutCleanRecord";
    /**
     * 3--> 获取计租或不计租房接口  clk
     * http://192.168.2.136:18888/services/my/app/myroom/getForRentRoomInfo
     */
    public static String GETFORRENTROOMINFO = "/my/app/myroom/getForRentRoomInfo";

    /**
     * 4--> 获取ABC类房接口  clk
     * http://192.168.2.136:18888/services/my/app/myroom/getRoomClassificationInfo
     */
    public static String GETROOMCLASSIFICATIONINFO = "/my/app/myroom/getRoomClassificationInfo";


    //***************以下接口为IP地址后面携带rankPrivoider的url(排行榜模块)*****************

    /**
     * 获取日历时间范围
     */
    public static String GETRANKRELLIST = "/fgy/common/timeRange";
    /**
     * 5.2排行榜
     */
    public static String GETRANKLIST = "/fgy/rank/ranklist";

    public static String RANKDTLIST = "/fgy/rank/rankdtlist2";

    /**
     * 获取阿里参数
     */
    public static String GETALIYUNSTSINFO = "/fgy/app/tm/aliyun/vod/getAliyunSTSInfo";

    public static String GETCONFIGPARAMS = "/fgy/app/tm/config/query/getConfigParams";

    /**
     * 1.3.3.1 扫描客户二维码 获取客户注册手机号及被带看次数
     */
    public static String GET_CLIENT_CODE_MESSAGE = "/fgy/app/third/showCutInfo.json";

    /**
     * 1.3.3.1 查询系统配置接口
     */
    public static String GET_QUERY_SYSTEM_CONFIGURATION = "/fgy/app/daikan/findSysConfig.json";

    /**
     * 4.0模块及6.0模块语音电话是否显示号码配置接口
     */
    public static String GET_QUERY_SYSTEM_CONFIGURATION_NEW = "/fgy/app/daikan/findSystemConfig.json";


    /**
     * 4.0模块 回访信息录入 是否显示3到期列表的系统配置接口
     */
    public static String GET_QUERY_SYSTEM_CONFIGURATION_EXPIRE = "/fgy/app/visit/findSysConfigExpire.json";

    /**
     * 回访信息录入保存
     */
    public static String LAUNCH_VOICE_CALL = "/fgy/third/saveVoiceRecord";
//    /**
//     * 9.9 退房进度列表接口
//     */
//    public static String GET_SCHEDULE_LIST = "/fgy/app/schedule/scheduleList.json";
//    /**
//     * 9.9.1 退房进度详情接口
//     */
//    public static String GET_SCHEDULE_DETAIL= "/fgy/app/schedule/scheduleDetail.json";

    /**
     * 9.9 退房进度列表接口
     */
    public static String GET_SCHEDULE_LIST = "/fgy/app/schedule/scheduleList.json";
    /**
     * 9.9.1 退房进度详情接口
     */
    public static String GET_SCHEDULE_DETAIL = "/fgy/app/schedule/scheduleDetail.json";

    /**
     * 获取语音电话平台回调
     */
    public static String getThirdVoiceRecord = "/fgy/third/getThirdVoiceRecord";

    /**
     * 获取系统配置参数集合
     */
    public static String getSysConfigList = "/fgy/common/Sysconfig/getSysConfigList";

    /**
     * 获取勘察配置参数集合
     */
    public static String getSysCfgList = "/fgy/common/Sysconfig/getSysCfgList";
    /**
     * 获取勘察配置参数集合
     */
    public static String getSurveySysConfigList = "/fgy/common/Sysconfig/getSysCfg";
    /**
     * 报修展示
     */
    public static String loadRepair = "/fgy/repair/loadRepair";
    /**
     * 9.0学习专区是否有权限进入
     */
    public static String AUTH = "/fgy/common/scgService/author";
    /**
     * 地址是否可报修
     */
    public static String checkAddress = "/fgy/repair/checkAdderss";

    /**
     * 报修进度
     */
    public static String repairProgress = "/fgy/repair/repairProgress";
    /**
     * 维修记录详情
     */
    public static String repairRecodingInfo = "/fgy/repair/repairRecordingInfo";
    /**
     * 新增报修
     */
    public static String addRepair = "/fgy/repair/addRepair";
    /**
     * 根据地址查询会员信息
     */
    public static String searchUserInfo = "/fgy/repair/searchUserInfo";
    /**
     * 我的报修列表
     */
    public static String MyRepairList = "/fgy/repair/myRepair";
    public static String Evalute = "/fgy/repair/repairEvaluate";
    public static String repairSubject = "/fgy/repair/repairSubject";
    public static String getSysConfig = "/fgy/common/Sysconfig/getSysConfig";
    public static String repairInfo = "/fgy/repair/repairInfo";
    public static String getSysCfg = "/fgy/common/Sysconfig/getSysCfg";

    public static String POSITION = "/api/Postion";
    /**
     * 查询水费预付费单元的水费记录
     */
    public static String QUERYCELLSWATER = "/api/queryCellsWater";

    /**
     * 单元水费抄表充值的记录
     */
    public static String cellWaterHistory = "/api/cellWaterHistory";
    /**
     * 上传剩余水量接口
     */
    public static String uploadWaterRemain = "/api/uploadWaterRemain";
    /**
     * 上传充水记录接口
     */
    public static String uploadWaterRecharge = "/api/uploadWaterRecharge";
    /**
     * 图片上传
     */
    public static String fileserverAddress = "/api/fileserverAddress";

    /**
     * 勘察的图片或音频url接口  旧
     */
    public static final String SURVEY_AUDIO_IAMGE_URL = "/fgy/app/daikan/synImageSubmit.json";
    /**
     * 充电接口
     */
    public static String addElectricity = "/fgy/power/addElectricity";
    /**
     * 电表清退接口
     */
    public static String electricity = "/fgy/power/electricity";
    /**
     * 电表充电接口（二合一）
     */
    public static String clearAddRoomPower = "/fgy/power/clearAddRoomPower";
    /**
     * 更新已读消息接口
     */
    public static String updateMessage = "/message/updateMessageUserRange";
    /**
     * 查询消息接口
     */
    public static String queryMessage = "/message/queryUserMessageList";
    /**
     * 查询未读消息接口
     */
    public static String queryunReadMessage = "/message/unReadUserMessageTotal";
    /**
     * 删除消息接口
     */
    public static String deleteMessage = "/message/deleteUserMessage";
    /**
     * 解锁带看客户
     */
    public static String unlockCustomer = "/fgy/app/daikan/unlockCustomer.json";

    /**
     *  获取单元勘察项和单元房间列表
     */
    public static String unitSurveyList ="/fgy/app/checkitem/queryCheckUnitItem.json";

    /**
     * 勘察房间items接口
     */
    public static String SURVEY_ROOMS_ITEMS = "/fgy/app/checkitem/queryCheckItemList.json";
    /**
     * 房间勘察项接口  新
     */
    public static String houseSurveyList ="/fgy/app/checkitem/queryCheckRoomItem.json";

    /**
     * 提交勘察   新
     */
    public static String commitSurverNew ="/fgy/app/daikan/surveyUnitSubmit.json";

    /**
     * 勘察的图片或音频url接口  新
     */
    public static final String SURVEY_AUDIO_IAMGE_URLNEW = "/fgy/app/daikan/synUnitImageSubmit.json";


}

