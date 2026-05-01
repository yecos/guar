package com.hpplay.sdk.source.business.cloud;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncHttpRequestListener;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.common.utils.ContextPath;
import com.hpplay.common.utils.DeviceUtil;
import com.hpplay.common.utils.EncryptUtil;
import com.hpplay.common.utils.FieldUtil;
import com.hpplay.common.utils.FileUtil;
import com.hpplay.common.utils.HttpEncrypt;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.utils.DeviceProperties;
import com.hpplay.sdk.source.api.BuildConfig;
import com.hpplay.sdk.source.bean.AuthRepeatInfoBean;
import com.hpplay.sdk.source.browse.api.AuthListener;
import com.hpplay.sdk.source.business.PublicCastClient;
import com.hpplay.sdk.source.business.cloud.ServListEntity;
import com.hpplay.sdk.source.business.cloud.SwitchEntity;
import com.hpplay.sdk.source.c.a;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.common.store.Preference;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.common.utils.HapplayUtils;
import com.hpplay.sdk.source.config.LelinkConfig;
import com.hpplay.sdk.source.device.ServiceUpdater;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.process.LelinkSdkManager;
import com.hpplay.sdk.source.protocol.connect.OnConnectIMListener;
import com.hpplay.sdk.source.utils.Feature;
import com.hpplay.sdk.source.utils.LeboUtil;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.f;
import com.umeng.umcrash.UMCrash;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class AuthSDK {
    private static final String AUTH_DATA_ERROR = "120102036";
    private static final int AUTH_DEFAULT_TIME = 100;
    private static final int AUTH_DEFAULT_TIME_DEBUG = 10;
    private static final int AUTH_FAIL_RETRY_LIMIT = 180000;
    private static final String AUTH_NETWORK_ERROR = "120102035";
    private static final String AUTH_PARSE_ERROR = "120102034";
    private static final int CODE_AUTH_DEFAULT = -100;
    public static final int CODE_AUTH_DISABLE = 402;
    private static final int CODE_AUTH_PARAM_ERROR = 401;
    private static final int CODE_AUTH_SER_ERROR = 405;
    public static final int CODE_AUTH_TIME_DONE = -101;
    private static final int MAX_INVALID_TOKEN_COUNT = 3;
    private static final int MAX_RETRY_SER_ERROR = 3;
    private static final String REPEAT_INFO_FILE_DIR;
    public static final String REPEAT_INFO_FILE_NAME;
    private static final int SER_STATE_ERROR = 500;
    private static final int SER_STATE_FAILED = -1;
    private static final int SER_STATE_NOTFOUND = 404;
    private static final String SSL2_URL_CONF = "conf_ssl2";
    private static final String SSL2_URL_DEVICE_MANAGER = "devicemgr_ssl2";
    private static final String SSL2_URL_IM_CONNECT = "im_ssl2";
    private static final String SSL2_URL_TYPE_AD_ENGINE = "adengine_ssl2";
    private static final String SSL2_URL_TYPE_GSLB = "gslb_ssl2";
    private static final String SSL2_URL_TYPE_IM_DNS = "imdns_ssl2";
    private static final String SSL2_URL_TYPE_LOG_REPORT = "logreport_ssl2";
    private static final String SSL2_URL_TYPE_PIN = "pin_ssl2";
    private static final String SSL2_URL_TYPE_REPORT = "report_ssl2";
    private static final String SSL2_URL_TYPE_REPORT_SEARCH = "reportsearch_ssl2";
    private static final String SSL2_URL_TYPE_SHORT_LINK = "shorturl_ssl2";
    private static final String SSL2_URL_VIP_AUTH = "vipauth_ssl2";
    private static final String TAG = "AuthSDK";
    private static final String URL_DEVICE_MANAGER = "devicemgr";
    private static final String URL_IM_CONNECT = "im";
    private static final String URL_SDK_AUTH = "sdkauth";
    private static final String URL_TYPE_AD_ENGINE = "adengine";
    private static final String URL_TYPE_GSLB = "gslb";
    private static final String URL_TYPE_IM_DNS = "imdns";
    private static final String URL_TYPE_LOG_REPORT = "logreport";
    private static final String URL_TYPE_PIN = "pin";
    private static final String URL_TYPE_REPORT = "report";
    private static final String URL_TYPE_REPORT_SEARCH = "reportsearch";
    private static final String URL_TYPE_SHORT_LINK = "shorturl";
    private static final String URL_VIP_AUTH = "vipauth";
    private static AuthSDK mAuthSDK;
    private List<AuthListener> mAuthListeners;
    private AsyncTask mAuthTask;
    private Context mContext;
    private int mServerErrorCount = 0;
    private List<String> mAuthUrlList = new ArrayList();
    private int mAuthUrlIndex = 0;
    private int mAuthStatusCode = -100;
    private boolean isHasIMConnectDomain = false;
    private int mInvalidTokenCount = 0;

    static {
        String path = Session.getInstance().getContextPath().getPath(ContextPath.SDCARD_HPPLAY);
        REPEAT_INFO_FILE_DIR = path;
        REPEAT_INFO_FILE_NAME = path + File.separator + BuildConfig.SDK_CHANNEL;
    }

    public static /* synthetic */ int access$1004(AuthSDK authSDK) {
        int i10 = authSDK.mServerErrorCount + 1;
        authSDK.mServerErrorCount = i10;
        return i10;
    }

    private void analysisServerList() {
        try {
            ServListEntity servListEntity = new ServListEntity(new JSONObject(Preference.getInstance().get(Preference.KEY_SDK_SERVER_LIST)));
            Session.getInstance().serverProtocolVer = servListEntity.ver + "";
            for (ServListEntity.UrlListEntity urlListEntity : servListEntity.url_list) {
                String str = urlListEntity.name;
                String str2 = urlListEntity.url;
                if (!TextUtils.isEmpty(str2)) {
                    if (URL_SDK_AUTH.equalsIgnoreCase(str)) {
                        Preference.getInstance().put(Preference.KEY_SDK_AUTH_URL, str2);
                        parseAuthUrl(str2);
                    }
                    if (!str2.startsWith(HttpConstant.HTTP)) {
                        str2 = "http://" + str2;
                    }
                    if (SSL2_URL_TYPE_REPORT.equalsIgnoreCase(str)) {
                        ArrayList<String> arrayList = CloudAPI.DOMAIN_REPORT_LIST;
                        parseUrlList(str2, arrayList);
                        CloudAPI.sReportRoot = arrayList.get(0);
                    } else if (SSL2_URL_TYPE_GSLB.equalsIgnoreCase(str)) {
                        ArrayList<String> arrayList2 = CloudAPI.DOMAIN_REPORT_GSLB;
                        parseUrlList(str2, arrayList2);
                        CloudAPI.sGLSBRoot = arrayList2.get(0);
                        CloudAPI.sResPositionRoot = arrayList2.get(0);
                        CloudAPI.sUploadRoot = arrayList2.get(0);
                    } else if (SSL2_URL_TYPE_IM_DNS.equalsIgnoreCase(str)) {
                        ArrayList<String> arrayList3 = CloudAPI.DOMAIN_REPORT_IM_DNS;
                        parseUrlList(str2, arrayList3);
                        CloudAPI.sImDNSUrl = arrayList3.get(0);
                    } else if (SSL2_URL_TYPE_AD_ENGINE.equalsIgnoreCase(str)) {
                        ArrayList<String> arrayList4 = CloudAPI.DOMAIN_REPORT_AD_ENGINE;
                        parseUrlList(str2, arrayList4);
                        CloudAPI.sADEngineUrl = arrayList4.get(0);
                    } else if (SSL2_URL_DEVICE_MANAGER.equalsIgnoreCase(str)) {
                        ArrayList<String> arrayList5 = CloudAPI.DOMAIN_REPORT_DEVICE_MANAGER;
                        parseUrlList(str2, arrayList5);
                        CloudAPI.sDeviceMgrUrl = arrayList5.get(0);
                    } else if (SSL2_URL_TYPE_PIN.equalsIgnoreCase(str)) {
                        ArrayList<String> arrayList6 = CloudAPI.DOMAIN_REPORT_PIN;
                        parseUrlList(str2, arrayList6);
                        CloudAPI.sPinRoot = arrayList6.get(0);
                    } else if (SSL2_URL_TYPE_SHORT_LINK.equalsIgnoreCase(str)) {
                        ArrayList<String> arrayList7 = CloudAPI.DOMAIN_REPORT_SHORT_LINK;
                        parseUrlList(str2, arrayList7);
                        CloudAPI.sShortLink = arrayList7.get(0);
                    } else if (SSL2_URL_TYPE_LOG_REPORT.equalsIgnoreCase(str)) {
                        ArrayList<String> arrayList8 = CloudAPI.DOMAIN_REPORT_LOG_REPORT;
                        parseUrlList(str2, arrayList8);
                        CloudAPI.sLogReportUrl = arrayList8.get(0);
                    } else if (SSL2_URL_TYPE_REPORT_SEARCH.equals(str)) {
                        ArrayList<String> arrayList9 = CloudAPI.DOMAIN_REPORT_REPORT_SEARCH;
                        parseUrlList(str2, arrayList9);
                        CloudAPI.sLogReportQueryUrl = arrayList9.get(0);
                    } else if (SSL2_URL_IM_CONNECT.equalsIgnoreCase(str)) {
                        SourceLog.i(TAG, "has im connect domain");
                        this.isHasIMConnectDomain = true;
                        ArrayList<String> arrayList10 = CloudAPI.DOMAIN_REPORT_IM_CONNECT;
                        parseUrlList(str2, arrayList10);
                        CloudAPI.sImServer = arrayList10.get(0);
                    } else if (SSL2_URL_CONF.equalsIgnoreCase(str)) {
                        ArrayList<String> arrayList11 = CloudAPI.DOMAIN_REPORT_CONF;
                        parseUrlList(str2, arrayList11);
                        CloudAPI.sConfigRoot = arrayList11.get(0);
                    } else if (SSL2_URL_VIP_AUTH.equalsIgnoreCase(str)) {
                        ArrayList<String> arrayList12 = CloudAPI.DOMAIN_REPORT_VIP_AUTH;
                        parseUrlList(str2, arrayList12);
                        CloudAPI.sVipAuthRoot = arrayList12.get(0);
                    }
                }
            }
            CloudAPI.updateDynamicUrls();
            SourceLog.i(TAG, "analysis url result : " + CloudAPI.sReportRoot);
            if (this.isHasIMConnectDomain) {
                return;
            }
            updateIMRootUrl();
        } catch (Exception e10) {
            SourceLog.w(TAG, e10.getMessage());
        }
    }

    private void analysisSwitch() {
        String str = Preference.getInstance().get(Preference.KEY_SDK_SWITCH);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            SwitchEntity.SwitchBean switchBean = new SwitchEntity(new JSONObject(str)).switchBean;
            if (switchBean == null || switchBean.sl != 1) {
                Session.getInstance().isPreferLelink = false;
            } else {
                Session.getInstance().isPreferLelink = true;
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void analysisVerifyData(AuthSDKBean authSDKBean) {
        SourceLog.i(TAG, "analysisVerifyData");
        if (authSDKBean == null || authSDKBean.data == null) {
            return;
        }
        Session.getInstance().setToken(authSDKBean.data.token);
        Session.getInstance().tid = String.valueOf(authSDKBean.data.tid);
        Session.getInstance().scanTime = authSDKBean.data.scan_time;
        Session.getInstance().mExpireTime = authSDKBean.data.expire_time;
        analysisSwitch();
        analysisServerList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void authFailed(String str) {
        try {
            Preference.getInstance().put(Preference.KEY_SDK_VERIFY_SUCCESSFUL, false);
            Session.getInstance().isAuthSuccess = false;
            if (isUseDone(Preference.getInstance().get(Preference.KEY_SDK_AUTH_TIME, 0))) {
                this.mAuthStatusCode = -101;
            }
            List<AuthListener> list = this.mAuthListeners;
            if (list != null && !list.isEmpty()) {
                for (int i10 = 0; i10 < this.mAuthListeners.size(); i10++) {
                    this.mAuthListeners.get(i10).onAuthFailed(this.mAuthStatusCode);
                }
            }
            SourceLog.i(TAG, "authSDK auth failed " + str);
            reportAuthFailedInfo(AUTH_DATA_ERROR + str);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cacheServerList(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                return;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("serv_list");
            long j10 = Preference.getInstance().get(Preference.KEY_SDK_LOGIN_TIME, 0L);
            long currentTimeMillis = System.currentTimeMillis() - j10;
            if ((optJSONObject2 != null || (j10 > 0 && ((currentTimeMillis / 1000) / 60) / 60 > 24)) && this.mAuthStatusCode != 402) {
                reportLogin(Session.getInstance().appVersion);
                Preference.getInstance().put(Preference.KEY_SDK_LOGIN_TIME, System.currentTimeMillis());
            }
            if (optJSONObject2 == null) {
                return;
            }
            Preference.getInstance().put(Preference.KEY_SDK_SERVER_LIST, optJSONObject2.toString());
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cacheSwitch(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
            if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("switch")) == null) {
                return;
            }
            Preference.getInstance().put(Preference.KEY_SDK_SWITCH, optJSONObject.toString());
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeUrl() {
        if (this.mAuthUrlIndex >= this.mAuthUrlList.size()) {
            authFailed("");
            return;
        }
        List<String> list = this.mAuthUrlList;
        int i10 = this.mAuthUrlIndex;
        this.mAuthUrlIndex = i10 + 1;
        startAuth(list.get(i10));
    }

    private void connectIM() {
        SourceLog.i(TAG, "connectIM");
        if (TextUtils.isEmpty(CloudAPI.sImServer)) {
            SourceLog.w(TAG, "connectIM, ignore, invalid im url");
        } else {
            if (PublicCastClient.getInstance().isConnectedServer()) {
                return;
            }
            PublicCastClient.getInstance().connectServer(CloudAPI.sImServer, a.a(), new OnConnectIMListener() { // from class: com.hpplay.sdk.source.business.cloud.AuthSDK.2
                @Override // com.hpplay.sdk.source.protocol.connect.OnConnectIMListener
                public void onConnectFailed() {
                    SourceLog.i(AuthSDK.TAG, "onConnectFailed");
                }

                @Override // com.hpplay.sdk.source.protocol.connect.OnConnectIMListener
                public void onConnectSuccess() {
                    SourceLog.i(AuthSDK.TAG, "onConnectSuccess");
                }
            });
        }
    }

    public static synchronized AuthSDK getInstance() {
        AuthSDK authSDK;
        synchronized (AuthSDK.class) {
            if (mAuthSDK == null) {
                mAuthSDK = new AuthSDK();
            }
            authSDK = mAuthSDK;
        }
        return authSDK;
    }

    private void initAuthUrlList() {
        this.mAuthUrlList.clear();
        if (Feature.isMUIChannel()) {
            this.mAuthUrlList.add("https://misdkauth.hpplay.cn/Author/PhoneAuthor/?");
            return;
        }
        if (Feature.isOPPOChannel()) {
            this.mAuthUrlList.add("https://vosdkauth.hpplay.cn/Author/PhoneAuthor/?");
            return;
        }
        if (CloudAPI.isDebug()) {
            this.mAuthUrlList.add("https://test.lebo.cn:90/Author/PhoneAuthor/?");
            this.mAuthUrlList.add("https://test.lebo.cn:90/Author/PhoneAuthor/?");
            this.mAuthUrlList.add("https://test.lebo.cn:90/Author/PhoneAuthor/?");
        } else {
            this.mAuthUrlList.add("https://sdkauth.lebo.cn/Author/PhoneAuthor/?");
            this.mAuthUrlList.add("https://sdkauth.lebo.cn/Author/PhoneAuthor/?");
            this.mAuthUrlList.add("https://sdkauth.lebo.cn/Author/PhoneAuthor/?");
        }
    }

    private boolean isHistorySuccess() {
        SourceLog.w(TAG, " tid = " + Session.getInstance().tid);
        return !TextUtils.isEmpty(r0);
    }

    private boolean isUseDone(int i10) {
        return CloudAPI.isDebug() ? i10 >= 10 : i10 >= 100;
    }

    private void parseAuthUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        List<String> list = this.mAuthUrlList;
        if (list == null) {
            this.mAuthUrlList = new LinkedList();
        } else {
            list.clear();
        }
        if (CloudAPI.isDebug()) {
            this.mAuthUrlList.add("https://test.lebo.cn:90/Author/PhoneAuthor/?");
        } else {
            this.mAuthUrlList.add("https://sdkauth.lebo.cn/Author/PhoneAuthor/?");
        }
        for (String str2 : str.split(",")) {
            if (!str2.startsWith(HttpConstant.HTTP)) {
                str2 = "http://" + str2;
            }
            String str3 = str2 + "/Author/PhoneAuthor/?";
            if (this.mAuthUrlList.contains(str3)) {
                return;
            }
            this.mAuthUrlList.add(str3);
        }
    }

    private void parseUrlList(String str, ArrayList<String> arrayList) {
        if (!str.contains(";")) {
            arrayList.add(str);
            return;
        }
        for (String str2 : str.split(";")) {
            arrayList.add(str2);
        }
    }

    private AuthRepeatInfoBean readRepeatInfoFromLocal() {
        String str;
        try {
            str = Preference.getInstance().get(Preference.KEY_REPEAT_INFO);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            try {
                str = FileUtil.file2String(REPEAT_INFO_FILE_NAME);
                SourceLog.i(TAG, "form file info = " + str);
                if (TextUtils.isEmpty(str)) {
                    str = Preference.getInstance().get(Preference.KEY_REPEAT_INFO);
                    SourceLog.i(TAG, "form sp info = " + str);
                }
            } catch (Exception unused) {
                str = Preference.getInstance().get(Preference.KEY_REPEAT_INFO);
            }
        }
        return AuthRepeatInfoBean.jsonToBean(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportLogin(String str) {
        SourceLog.i(TAG, "reportLogin");
        SourceDataReport.getInstance().login(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestLicense() {
        boolean isSdkFree = LelinkConfig.isSdkFree();
        boolean isLicenseMode = LelinkConfig.isLicenseMode();
        SourceLog.i(TAG, "requestLicense :" + isSdkFree + " / " + isLicenseMode);
        if (isSdkFree || !isLicenseMode) {
            return;
        }
        LicenseManager.getInstance().requestLicense(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestResPosition() {
        SourceLog.i(TAG, "requestResPosition");
        HashMap hashMap = new HashMap();
        hashMap.put(ParamsMap.DeviceParams.KEY_UID, Session.getInstance().getUID());
        hashMap.put(ParamsMap.DeviceParams.KEY_APPID, Session.getInstance().appKey);
        hashMap.put(ParamsMap.DeviceParams.KEY_AUTH_TOKEN, Session.getInstance().getToken());
        hashMap.put("sourceId", "SDK_UI_LIST_BANNER,SDK_UI_LIST_BANNER_HORIZONTAL");
        hashMap.put(f.an, "1.0");
        hashMap.put("sdk_ver", "41214");
        hashMap.put("apk_ver", "" + HapplayUtils.getAppVersion(this.mContext));
        SourceLog.debug(TAG, "requestResPosition, " + CloudAPI.sResPositionUrl + Operator.Operation.EMPTY_PARAM + HapplayUtils.getMapParams(hashMap));
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sResPositionUrl, HapplayUtils.getMapParams(hashMap), 1);
        AsyncHttpParameter.In in = asyncHttpParameter.in;
        in.connectTimeout = 10000;
        in.readTimeout = 10000;
        in.requestMethod = 0;
        AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.business.cloud.AuthSDK.3
            @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter2) {
                AsyncHttpParameter.Out out;
                if (asyncHttpParameter2 == null || (out = asyncHttpParameter2.out) == null || out.resultType != 0) {
                    SourceLog.i(AuthSDK.TAG, "requestResPosition,result is null");
                    if (LelinkSdkManager.getInstance().mSearchBannerDataCallback != null) {
                        LelinkSdkManager.getInstance().mSearchBannerDataCallback.onBannerData(null);
                        return;
                    }
                    return;
                }
                SourceLog.i(AuthSDK.TAG, "requestResPosition,updateBannerData");
                if (LelinkSdkManager.getInstance().mSearchBannerDataCallback != null) {
                    LelinkSdkManager.getInstance().mSearchBannerDataCallback.onBannerData(asyncHttpParameter2.out.result);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveRepeatInfoToLocal(AuthRepeatInfoBean authRepeatInfoBean) {
        SourceLog.i(TAG, "saveRepeatInfoToLocal info =" + authRepeatInfoBean);
        File file = new File(REPEAT_INFO_FILE_DIR);
        if (!file.exists()) {
            SourceLog.i(TAG, "make dir status =" + file.mkdirs());
        }
        try {
            Preference.getInstance().put(Preference.KEY_REPEAT_INFO, AuthRepeatInfoBean.beanToJson(authRepeatInfoBean));
            FileUtil.string2File(AuthRepeatInfoBean.beanToJson(authRepeatInfoBean), REPEAT_INFO_FILE_NAME);
        } catch (Exception e10) {
            SourceLog.w(TAG, "saveRepeatInfoToLocal error :" + e10.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAuth(final String str) {
        String str2;
        long currentTimeMillis = System.currentTimeMillis() - Preference.getInstance().get(Preference.KEY_AUTH_FAIL_TIME, 0L);
        if (currentTimeMillis < 180000) {
            SourceLog.w(TAG, "startAuth ignore : " + currentTimeMillis);
            return;
        }
        AsyncTask asyncTask = this.mAuthTask;
        if (asyncTask != null) {
            try {
                asyncTask.cancel(true);
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
            this.mAuthTask = null;
        }
        final String str3 = Session.getInstance().appVersion;
        String str4 = Session.getInstance().appKey;
        String str5 = Session.getInstance().appSecret;
        HashMap hashMap = new HashMap();
        hashMap.put(ParamsMap.DeviceParams.KEY_UID, Session.getInstance().getUID());
        hashMap.put(ParamsMap.DeviceParams.KEY_APPID, str4);
        hashMap.put(Constants.KEY_PACKAGE, this.mContext.getPackageName());
        hashMap.put("prot_ver", Constant.AUTH_PROTOCOL_VER);
        hashMap.put("sever_ver", Session.getInstance().serverProtocolVer);
        hashMap.put(ParamsMap.DeviceParams.KEY_HID, Session.getInstance().getHID());
        hashMap.put("board", DeviceProperties.getBoard());
        hashMap.put(Constants.KEY_BRAND, DeviceProperties.getBrand());
        hashMap.put(FieldUtil.getString(FieldUtil.f7331a), LeboUtil.getAID(this.mContext));
        hashMap.put("facturer", DeviceProperties.getManufacturer());
        hashMap.put(Constants.KEY_MODEL, DeviceProperties.getModel());
        hashMap.put(UMCrash.SP_KEY_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
        String string = FieldUtil.getString(FieldUtil.f7332m);
        Session.getInstance();
        hashMap.put(string, Session.DEFAULT_M);
        if (Feature.isMirrorCustomMode()) {
            hashMap.put("oaid", DeviceUtil.getOAID(this.mContext));
            str2 = "1";
        } else {
            hashMap.put("iemi", "");
            str2 = "0";
        }
        hashMap.put("ismd5", str2);
        if (Session.getInstance().getRegTime() > 0) {
            hashMap.put("reg_time", Session.getInstance().getRegTime() + "");
        }
        String str6 = ((String) hashMap.get(ParamsMap.DeviceParams.KEY_UID)) + ((String) hashMap.get(ParamsMap.DeviceParams.KEY_APPID)) + ((String) hashMap.get(Constants.KEY_PACKAGE)) + ((String) hashMap.get(UMCrash.SP_KEY_TIMESTAMP));
        StringBuilder sb = new StringBuilder();
        sb.append("appid=");
        sb.append(str4);
        sb.append("&uid=");
        sb.append(Session.getInstance().getUID());
        sb.append("&version=");
        sb.append(41214);
        sb.append("&prot_ver=");
        sb.append(Constant.AUTH_PROTOCOL_VER);
        hashMap.put("sign", EncryptUtil.md5EncryData(str6 + str5));
        final HttpEncrypt httpEncrypt = new HttpEncrypt();
        SourceLog.i(TAG, "authSDK map = " + HapplayUtils.getJsonParams(hashMap) + "\r\n " + str + ((Object) sb));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append((Object) sb);
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(sb2.toString(), httpEncrypt.encode(HapplayUtils.getJsonParams(hashMap)), 1);
        AsyncHttpParameter.In in = asyncHttpParameter.in;
        in.connectTimeout = 10000;
        in.readTimeout = 10000;
        in.requestHeaders = httpEncrypt.buildHeader();
        asyncHttpParameter.in.requestMethod = 1;
        this.mAuthTask = AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.business.cloud.AuthSDK.1
            @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter2) {
                int i10;
                AuthSDKBean authSDKBean = null;
                AuthSDK.this.mAuthTask = null;
                AsyncHttpParameter.Out out = asyncHttpParameter2.out;
                if (out.resultType == 2) {
                    SourceLog.w(AuthSDK.TAG, "onRequestResult cancel");
                    return;
                }
                if (out.result == null || (i10 = out.responseCode) == -1 || i10 == 500 || i10 == 404) {
                    AuthSDK.this.updateAuthTime();
                    AuthSDK.this.changeUrl();
                    return;
                }
                SourceLog.i(AuthSDK.TAG, "authSDK onRequestResult = " + asyncHttpParameter2.out.result);
                try {
                    AsyncHttpParameter.Out out2 = asyncHttpParameter2.out;
                    int i11 = 0;
                    if (out2.resultType == 0) {
                        String str7 = out2.result;
                        try {
                            str7 = httpEncrypt.decode(out2);
                            JSONObject jSONObject = new JSONObject(str7);
                            AuthSDK.this.cacheServerList(jSONObject);
                            AuthSDK.this.cacheSwitch(jSONObject);
                            authSDKBean = new AuthSDKBean(jSONObject);
                        } catch (Exception e11) {
                            SourceLog.w(AuthSDK.TAG, "AuthSDK parse error:", e11);
                            AuthSDK.this.reportAuthFailedInfo(AuthSDK.AUTH_PARSE_ERROR);
                        }
                        if (authSDKBean != null && authSDKBean.data != null) {
                            if (AuthSDK.this.mAuthStatusCode = authSDKBean.status == 200) {
                                AuthRepeatInfoBean authRepeatInfoBean = new AuthRepeatInfoBean();
                                if (!TextUtils.isEmpty(authSDKBean.data.uid)) {
                                    SourceLog.w(AuthSDK.TAG, "uid reduplicate with other device, use server uid instead");
                                    authRepeatInfoBean.setUid(authSDKBean.data.uid);
                                }
                                if (!TextUtils.isEmpty(authSDKBean.data.hid)) {
                                    SourceLog.w(AuthSDK.TAG, "hid reduplicate with other device, use server hid instead");
                                    authRepeatInfoBean.setHid(authSDKBean.data.hid);
                                }
                                long j10 = authSDKBean.data.reg_time;
                                if (j10 > 0) {
                                    authRepeatInfoBean.setReg_time(j10);
                                }
                                if (authRepeatInfoBean.hasRepeatInfo()) {
                                    AuthSDK.this.saveRepeatInfoToLocal(authRepeatInfoBean);
                                    Session.getInstance().updateRepeatInfo(authRepeatInfoBean);
                                    if (!TextUtils.isEmpty(authRepeatInfoBean.getUid())) {
                                        Session.getInstance().updateUID();
                                    }
                                    if (!TextUtils.isEmpty(authRepeatInfoBean.getHid())) {
                                        Session.getInstance().updateHID();
                                    }
                                    if (authRepeatInfoBean.getRegTime() > 0) {
                                        Session.getInstance().setRegTime(authRepeatInfoBean.getRegTime());
                                    }
                                }
                                Preference.getInstance().put(Preference.KEY_SDK_VERIFY, str7);
                                AuthSDK.this.analysisVerifyData(authSDKBean);
                                Session.getInstance().isAuthSuccess = true;
                                Preference.getInstance().put(Preference.KEY_SDK_VERIFY_SUCCESSFUL, true);
                                Preference.getInstance().put(Preference.KEY_SDK_AUTH_DISABLE, false);
                                if (AuthSDK.this.mAuthListeners != null && !AuthSDK.this.mAuthListeners.isEmpty()) {
                                    while (i11 < AuthSDK.this.mAuthListeners.size()) {
                                        ((AuthListener) AuthSDK.this.mAuthListeners.get(i11)).onAuthSuccess(a.a(), str7);
                                        i11++;
                                    }
                                }
                                RightsManager.getInstance().vipAuth();
                                SDKConfig.getInstance().requestConfig();
                                AuthSDK.this.requestResPosition();
                            }
                        }
                        if (authSDKBean == null || authSDKBean.data == null || AuthSDK.this.mAuthStatusCode != AuthSDK.CODE_AUTH_SER_ERROR) {
                            AuthSDK.this.updateAuthTime();
                            if (AuthSDK.this.mAuthStatusCode == 401 || AuthSDK.this.mAuthStatusCode == 402) {
                                Preference.getInstance().put(Preference.KEY_AUTH_FAIL_TIME, System.currentTimeMillis());
                            } else {
                                AuthSDK.this.changeUrl();
                            }
                            Session.getInstance().isAuthSuccess = false;
                            if (402 == AuthSDK.this.mAuthStatusCode) {
                                Preference.getInstance().put(Preference.KEY_SDK_AUTH_DISABLE, true);
                            }
                            AuthSDK authSDK = AuthSDK.this;
                            authSDK.authFailed(String.valueOf(authSDK.mAuthStatusCode));
                        } else {
                            AuthSDK.this.updateAuthTime();
                            if (AuthSDK.access$1004(AuthSDK.this) < 3) {
                                AuthSDK.this.startAuth(str);
                            } else {
                                AuthSDK authSDK2 = AuthSDK.this;
                                authSDK2.authFailed(String.valueOf(authSDK2.mAuthStatusCode));
                            }
                        }
                    } else {
                        AuthSDK.this.updateAuthTime();
                        AuthSDK.this.changeUrl();
                        Session.getInstance().isAuthSuccess = false;
                        Preference.getInstance().put(Preference.KEY_SDK_VERIFY_SUCCESSFUL, false);
                        if (AuthSDK.this.mAuthListeners != null && !AuthSDK.this.mAuthListeners.isEmpty()) {
                            while (i11 < AuthSDK.this.mAuthListeners.size()) {
                                ((AuthListener) AuthSDK.this.mAuthListeners.get(i11)).onAuthFailed(AuthSDK.this.mAuthStatusCode);
                                i11++;
                            }
                        }
                        SourceLog.i(AuthSDK.TAG, "authSDK auth failed");
                        AuthSDK.this.reportAuthFailedInfo(AuthSDK.AUTH_NETWORK_ERROR + String.valueOf(asyncHttpParameter2.out.responseCode));
                    }
                    if (!TextUtils.isEmpty(Session.getInstance().getToken())) {
                        AuthSDK.this.requestLicense();
                    }
                    ServiceUpdater.getInstance().uploadDeviceInfo(AuthSDK.this.mContext);
                    if (AuthSDK.this.mAuthStatusCode != 402) {
                        AuthSDK.this.reportLogin(str3);
                    }
                    SDKConfig.getInstance().requestConfig();
                } catch (Exception e12) {
                    SourceLog.w(AuthSDK.TAG, e12);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAuthTime() {
        try {
            SourceLog.i(TAG, "update auth time");
            if (isHistorySuccess()) {
                Preference.getInstance().put(Preference.KEY_SDK_AUTH_TIME, 0);
                return;
            }
            int i10 = Preference.getInstance().get(Preference.KEY_SDK_AUTH_TIME, 0) + 1;
            Preference.getInstance().put(Preference.KEY_SDK_AUTH_TIME, i10);
            SourceLog.i(TAG, "update auth time， current time = " + i10);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    public void addAuthListener(AuthListener authListener) {
        if (authListener == null) {
            return;
        }
        if (this.mAuthListeners == null) {
            this.mAuthListeners = new ArrayList();
        }
        this.mAuthListeners.add(authListener);
    }

    public void authSDK() {
        if (this.mAuthUrlList.isEmpty()) {
            SourceLog.w(TAG, "authSDK ignore, never should be here");
            return;
        }
        this.mAuthUrlIndex = 1;
        this.mServerErrorCount = 0;
        startAuth(this.mAuthUrlList.get(0));
    }

    public void authSDKByInvalidToken() {
        int i10 = this.mAuthStatusCode;
        if (i10 == 401 || i10 == 402) {
            return;
        }
        int i11 = this.mInvalidTokenCount + 1;
        this.mInvalidTokenCount = i11;
        if (i11 >= 3) {
            return;
        }
        authSDK();
    }

    public boolean checkSdkUsable() {
        boolean z10 = Preference.getInstance().get(Preference.KEY_SDK_VERIFY_SUCCESSFUL, false);
        boolean z11 = Preference.getInstance().get(Preference.KEY_SDK_AUTH_DISABLE, false);
        SourceLog.i(TAG, "checkSdkUsable AuthStatusCode:" + this.mAuthStatusCode);
        int i10 = Preference.getInstance().get(Preference.KEY_SDK_AUTH_TIME, 0);
        if (z10 || Feature.isAuthFailedBrowse()) {
            return true;
        }
        return (this.mAuthStatusCode == 402 || getInstance().isUseDone(i10) || z11 || (this.mAuthStatusCode == -100 && getInstance().isUseDone(i10))) ? false : true;
    }

    public int getAuthCode() {
        return this.mAuthStatusCode;
    }

    public void init(Context context) {
        this.mContext = context;
        initAuthUrlList();
        String str = Preference.getInstance().get(Preference.KEY_SDK_VERIFY, (String) null);
        if (TextUtils.isEmpty(str)) {
            SourceLog.w(TAG, "AuthSDK preVerifyData is empty");
        } else {
            try {
                analysisVerifyData(new AuthSDKBean(new JSONObject(str)));
            } catch (Exception e10) {
                SourceLog.w(TAG, "AuthSDK preVerifyData parser error", e10);
            }
        }
        Session.getInstance().updateRepeatInfo(readRepeatInfoFromLocal());
    }

    public void release() {
        this.isHasIMConnectDomain = false;
    }

    public void removeListener(AuthListener authListener) {
        try {
            this.mAuthListeners.remove(authListener);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    public void reportAuthFailedInfo(String str) {
        SourceDataReport.getInstance().onAuthFailed(str);
    }

    public void updateIMRootUrl() {
        IMTask.getIMUrl();
    }
}
