package com.hpplay.sdk.source.business.cloud;

import com.hpplay.sdk.source.y;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes3.dex */
public class CloudAPI {
    public static final String AUTH_DEBUG = "https://test.lebo.cn:90/Author/PhoneAuthor/?";
    public static final String AUTH_DEBUG_URL1 = "https://test.lebo.cn:90/Author/PhoneAuthor/?";
    public static final String AUTH_DEBUG_URL2 = "https://test.lebo.cn:90/Author/PhoneAuthor/?";
    public static final String AUTH_DEVELOP = "http://47.112.113.131:90/Author/PhoneAuthor/?";
    public static final String AUTH_MI = "https://misdkauth.hpplay.cn/Author/PhoneAuthor/?";
    public static final String AUTH_OPPO = "https://vosdkauth.hpplay.cn/Author/PhoneAuthor/?";
    public static final String AUTH_URL = "https://sdkauth.lebo.cn/Author/PhoneAuthor/?";
    public static final String AUTH_URL1 = "https://sdkauth.lebo.cn/Author/PhoneAuthor/?";
    public static final String AUTH_URL2 = "https://sdkauth.lebo.cn/Author/PhoneAuthor/?";
    public static final String DOWN_SOURCE_URL = "http://hpplay.cdn.cibn.cc/release/out/weixin.html";
    public static final String RES_POSITION_SEARCH_AD_HORIZONTAL = "SDK_UI_LIST_BANNER_HORIZONTAL";
    public static final String RES_POSITION_SEARCH_AD_PORTRAIT = "SDK_UI_LIST_BANNER";
    public static String sPinRoot = "https://pin.lebo.cn";
    public static String sPinUrl = sPinRoot + "/codeAuth?";
    public static String sPinCodeCreateUrl = sPinRoot + "/code/gainCode";
    public static String sResPositionRoot = "http://gslb.hpplay.cn";
    public static String sResPositionUrl = sResPositionRoot + "/VipResInfo";
    public static String sGLSBRoot = y.ag;
    public static String sGetTVListStatus = sGLSBRoot + "/GetTVListStatus";
    public static String sGetDeviceStatusByDsn = sGLSBRoot + "/GetDeviceListStatus";
    public static String s3rdPartyReport = sGLSBRoot + "/Monitor3rd";
    public static String sPassthroughPushUrl = sGLSBRoot + "/PassThrough";
    public static String sPushMirror = sGLSBRoot + "/PushMirror";
    public static String sDeviceMgrUrl = y.ad;
    public static String sGetDevice = sDeviceMgrUrl + "/tvshare/getall";
    public static String sAddDevice = sDeviceMgrUrl + "/tvshare/addlist";
    public static String sDeleteDevice = sDeviceMgrUrl + "/tvshare/deletelist";
    public static String sVipAuthRoot = y.aI;
    public static String sVipAuth = sVipAuthRoot + "/VipAuth";
    public static String sTemporaryAuth = sVipAuthRoot + "/SenderTempAuth";
    public static String sLicenseAuth = sVipAuthRoot + "/LicenseAuth";
    public static String sShortLink = y.aE;
    public static String sParseQRInfoUrl = sShortLink + "/leboServer/parseShortUrl";
    public static String sCreateShortUrl = sShortLink + "/leboServer/shortUrl?";
    public static String sImDNSUrl = y.aj;
    public static String sImServer = "";
    public static String sReportRoot = y.aB;
    public static String sReportLogIn = sReportRoot + "/logins?";
    public static String sReportLogOut = sReportRoot + "/logouts?";
    public static String sReportPush = sReportRoot + "/push?";
    public static String sReportMirror = sReportRoot + "/mirror?";
    public static String sReportRelation = sReportRoot + "/relation?";
    public static String sReportConn = sReportRoot + "/conn?";
    public static String sReportDa = sReportRoot + "/adreport?";
    public static String sReportUserBehavior = sReportRoot + "/service?";
    public static String sADEngineUrl = "https://adeng.lebo.cn";
    public static String sSendCreative = sADEngineUrl + "/adEngine/sendCreative?";
    public static String sQuerySeAppConfig = sADEngineUrl + "/adEngine/querySeAppConfig?";
    public static String sConferenceRoot = y.Z;
    public static String sConferenceCodeAuth = sConferenceRoot + "/apicode/codeAuth?";
    public static String sConferenceLikeEqAuth = sConferenceRoot + "/apicode/likeEQdata?";
    public static String sConferenceVisitorAuth = sConferenceRoot + "/apicode/visitorAuth?";
    public static String sConferenceSetGuestMode = sConferenceRoot + "/apicode/setGuestMode?";
    public static String sMultiMirrorPinUrl = sPinRoot + "/code/codeDetail";
    public static String sReportError = sReportRoot + "/erlog?";
    public static String sReportConnLive = sReportRoot + "/conn_live?";
    public static String sLogReportUrl = getsLogReportUrl();
    public static String sLogReportQueryUrl = getLogReportQueryUrl();
    public static String sREAL_TIME_SERVICE_INFO_QUERY_RUL = sGLSBRoot + "/lebo-flux-sdk/sdk/service/get/";
    public static String sREAL_TIME_DEVICE_INFO_UPLOAD_URL = sGLSBRoot + "/lebo-flux-sdk/sdk/info/upload";
    public static String sDEVICE_SERVICE_UPLOAD_URL = sGLSBRoot + "/lebo-flux-sdk/sdk/service/upload";
    public static String sConfigRoot = y.f7745aa;
    public static String sConfig = sConfigRoot + "/sender/conf";
    public static String sUploadRoot = y.aH;
    public static String sUploadConn = sUploadRoot + "/aes-upload";
    public static String sFindByNumber = sUploadRoot + "/findById";
    public static String sAddFavoriteDevice = sGLSBRoot + "/lebo-flux-sdk/user-device-collect/addCollection";
    public static String sRemoveFavoriteDevice = sGLSBRoot + "/lebo-flux-sdk/user-device-collect/delCollection";
    public static String sGetFavoriteDevice = sGLSBRoot + "/lebo-flux-sdk/user-device-collect/findById";
    public static String sSetFavoriteDeviceAlias = sGLSBRoot + "/lebo-flux-sdk/user-device-collect/uploadName";
    public static String sAddHistoryDevice = sGLSBRoot + "/lebo-flux-sdk/user-history-device/addHistoryDevice";
    public static String sRemoveHistoryDevice = sGLSBRoot + "/lebo-flux-sdk/user-history-device/delHistoryDevice";
    public static String sGetHistoryDevice = sGLSBRoot + "/lebo-flux-sdk/user-history-device/findById";
    public static final ArrayList<String> DOMAIN_REPORT_LIST = new ArrayList<>();
    public static final ArrayList<String> DOMAIN_REPORT_GSLB = new ArrayList<>();
    public static final ArrayList<String> DOMAIN_REPORT_IM_DNS = new ArrayList<>();
    public static final ArrayList<String> DOMAIN_REPORT_IM_CONNECT = new ArrayList<>();
    public static final ArrayList<String> DOMAIN_REPORT_REPORT_SEARCH = new ArrayList<>();
    public static final ArrayList<String> DOMAIN_REPORT_LOG_REPORT = new ArrayList<>();
    public static final ArrayList<String> DOMAIN_REPORT_SHORT_LINK = new ArrayList<>();
    public static final ArrayList<String> DOMAIN_REPORT_PIN = new ArrayList<>();
    public static final ArrayList<String> DOMAIN_REPORT_DEVICE_MANAGER = new ArrayList<>();
    public static final ArrayList<String> DOMAIN_REPORT_AD_ENGINE = new ArrayList<>();
    public static final ArrayList<String> DOMAIN_REPORT_VIP_AUTH = new ArrayList<>();
    public static final ArrayList<String> DOMAIN_REPORT_CONF = new ArrayList<>();

    public static String getHttpServerUrl(String str, String str2) {
        return String.format(Locale.getDefault(), "http://%s:%s/www.hpplay.com.cn/tv/app/DnsTxtInfo", str, str2);
    }

    private static String getLogReportQueryUrl() {
        return isDebug() ? y.ap : y.am;
    }

    private static String getsLogReportUrl() {
        return isDebug() ? y.av : y.as;
    }

    public static boolean isDebug() {
        return false;
    }

    public static void updateDynamicUrls() {
        sReportLogIn = sReportRoot + "/logins?";
        sReportLogOut = sReportRoot + "/logouts?";
        sReportPush = sReportRoot + "/push?";
        sReportMirror = sReportRoot + "/mirror?";
        sReportRelation = sReportRoot + "/relation?";
        sReportConn = sReportRoot + "/conn?";
        sReportUserBehavior = sReportRoot + "/service?";
        sReportDa = sReportRoot + "/adreport?";
        sSendCreative = sADEngineUrl + "/adEngine/sendCreative?";
        sQuerySeAppConfig = sADEngineUrl + "/adEngine/querySeAppConfig?";
        sPinUrl = sPinRoot + "/codeAuth?";
        sPinCodeCreateUrl = sPinRoot + "/code/gainCode";
        sReportError = sReportRoot + "/erlog?";
        sReportConnLive = sReportRoot + "/conn_live?";
        sGetTVListStatus = sGLSBRoot + "/GetTVListStatus";
        sGetDeviceStatusByDsn = sGLSBRoot + "/GetDeviceListStatus";
        s3rdPartyReport = sGLSBRoot + "/Monitor3rd";
        sGetDevice = sDeviceMgrUrl + "/tvshare/getall";
        sAddDevice = sDeviceMgrUrl + "/tvshare/addlist";
        sDeleteDevice = sDeviceMgrUrl + "/tvshare/deletelist";
        sPassthroughPushUrl = sGLSBRoot + "/PassThrough";
        sConferenceCodeAuth = sConferenceRoot + "/apicode/codeAuth?";
        sConferenceVisitorAuth = sConferenceRoot + "/apicode/visitorAuth?";
        sConferenceSetGuestMode = sConferenceRoot + "/apicode/setGuestMode?";
        sConferenceLikeEqAuth = sConferenceRoot + "/apicode/likeEQdata?";
        sParseQRInfoUrl = sShortLink + "/leboServer/parseShortUrl";
        sCreateShortUrl = sShortLink + "/leboServer/shortUrl?";
        sPushMirror = sGLSBRoot + "/PushMirror";
        sMultiMirrorPinUrl = sPinRoot + "/code/codeDetail";
        sREAL_TIME_SERVICE_INFO_QUERY_RUL = sGLSBRoot + "/lebo-flux-sdk/sdk/service/get/";
        sREAL_TIME_DEVICE_INFO_UPLOAD_URL = sGLSBRoot + "/lebo-flux-sdk/sdk/info/upload";
        sDEVICE_SERVICE_UPLOAD_URL = sGLSBRoot + "/lebo-flux-sdk/sdk/service/upload";
        sConfig = sConfigRoot + "/sender/conf";
        sVipAuth = sVipAuthRoot + "/VipAuth";
        sTemporaryAuth = sVipAuthRoot + "/SenderTempAuth";
        sResPositionUrl = sResPositionRoot + "/VipResInfo";
        sLicenseAuth = sVipAuthRoot + "/LicenseAuth";
        sUploadConn = sUploadRoot + "/lebo-flux-sdk/user-device-link/aes-upload";
        sFindByNumber = sUploadRoot + "/lebo-flux-sdk/user-device-link/findById";
        sAddFavoriteDevice = sGLSBRoot + "/lebo-flux-sdk/user-device-collect/addCollection";
        sRemoveFavoriteDevice = sGLSBRoot + "/lebo-flux-sdk/user-device-collect/delCollection";
        sGetFavoriteDevice = sGLSBRoot + "/lebo-flux-sdk/user-device-collect/findById";
        sSetFavoriteDeviceAlias = sGLSBRoot + "/lebo-flux-sdk/user-device-collect/uploadName";
        sAddHistoryDevice = sGLSBRoot + "/lebo-flux-sdk/user-history-device/addHistoryDevice";
        sRemoveHistoryDevice = sGLSBRoot + "/lebo-flux-sdk/user-history-device/delHistoryDevice";
        sGetHistoryDevice = sGLSBRoot + "/lebo-flux-sdk/user-history-device/findById";
    }
}
