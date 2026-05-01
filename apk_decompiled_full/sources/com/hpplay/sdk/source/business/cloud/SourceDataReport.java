package com.hpplay.sdk.source.business.cloud;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.hpplay.a.a.a.d;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncHttpRequestListener;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.common.datareport.DataReport;
import com.hpplay.common.datareport.ReportBean;
import com.hpplay.common.utils.DeviceUtil;
import com.hpplay.common.utils.EncryptUtil;
import com.hpplay.common.utils.NetworkUtil;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.utils.DeviceProperties;
import com.hpplay.cybergarage.http.HTTP;
import com.hpplay.cybergarage.xml.XML;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.common.store.Preference;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.common.utils.HapplayUtils;
import com.hpplay.sdk.source.da.e;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.process.ConnectManager;
import com.hpplay.sdk.source.utils.CastUtil;
import com.hpplay.sdk.source.utils.ErrorCode;
import com.hpplay.sdk.source.utils.Feature;
import com.hpplay.sdk.source.utils.LeboUtil;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* loaded from: classes3.dex */
public class SourceDataReport {
    public static final String CLIENT_ID = "2004";
    public static final String KEY_ERREPORT_DESC = "desc";
    public static final String KEY_ERREPORT_ERCODE = "er_code";
    public static final String KEY_ERREPORT_ERMSG = "er_msg";
    public static final String KEY_ERREPORT_EVENTID = "event_id";
    public static final String KEY_ERREPORT_LOCATION = "location";
    private static final String TAG = "SourceDataReport";
    private static SourceDataReport sInstance;
    private Context mContext;
    private Map<String, String> mConnectHeader = new HashMap();
    public String authSessionId = "";
    private Session mSession = Session.getInstance();

    /* renamed from: com.hpplay.sdk.source.business.cloud.SourceDataReport$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$hpplay$common$utils$NetworkUtil$NetworkType;

        static {
            int[] iArr = new int[NetworkUtil.NetworkType.values().length];
            $SwitchMap$com$hpplay$common$utils$NetworkUtil$NetworkType = iArr;
            try {
                iArr[NetworkUtil.NetworkType.NETWORK_WIFI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$hpplay$common$utils$NetworkUtil$NetworkType[NetworkUtil.NetworkType.NETWORK_2G.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$hpplay$common$utils$NetworkUtil$NetworkType[NetworkUtil.NetworkType.NETWORK_3G.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$hpplay$common$utils$NetworkUtil$NetworkType[NetworkUtil.NetworkType.NETWORK_4G.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private SourceDataReport(Context context) {
        this.mContext = context;
        this.mConnectHeader.put("Connection", HTTP.CLOSE);
    }

    private String getErrInfo(String str, String str2) {
        String str3 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            str3 = String.valueOf(jSONObject.optInt("errCode"));
            uploadPushErrorDetails(str3, jSONObject.optString("errMsg"), str2);
            return str3;
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return str3;
        }
    }

    public static SourceDataReport getInstance() {
        if (sInstance == null) {
            initDataReport(HapplayUtils.getApplication());
        }
        return sInstance;
    }

    private static int getNetType(Context context) {
        int i10 = AnonymousClass2.$SwitchMap$com$hpplay$common$utils$NetworkUtil$NetworkType[NetworkUtil.getNetworkType(context).ordinal()];
        return i10 != 1 ? (i10 == 2 || i10 == 3 || i10 == 4) ? 5 : 0 : NetworkUtil.getWifiType(context) == 0 ? 1 : 2;
    }

    public static void initDataReport(Context context) {
        SourceLog.i(TAG, "initDataReport");
        DataReport.initDataReport(context.getApplicationContext(), Constant.KEY_CT);
        initLocalInstance(context.getApplicationContext());
    }

    private static synchronized void initLocalInstance(Context context) {
        synchronized (SourceDataReport.class) {
            synchronized (SourceDataReport.class) {
                if (sInstance == null) {
                    SourceDataReport sourceDataReport = new SourceDataReport(context);
                    sInstance = sourceDataReport;
                    sourceDataReport.authSessionId = String.valueOf(System.currentTimeMillis());
                }
            }
        }
    }

    private void onConnect(int i10, int i11, String str, int i12, LelinkServiceInfo lelinkServiceInfo, long j10, int i13, String str2) {
        onConnect(i10, i11, str, i12, lelinkServiceInfo, j10, i13, str2, null);
    }

    private void onConnectSuccess(int i10, int i11, String str, int i12, LelinkServiceInfo lelinkServiceInfo) {
        onConnect(i10, i11, str, i12, lelinkServiceInfo, 0L, 1, "");
    }

    private void onGetRoom(OutParameter outParameter, boolean z10, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("st=");
        sb.append(7);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("sn=");
        sb.append(IMediaPlayer.MEDIA_INFO_BUFFERING_END);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("ls=");
        sb.append(System.currentTimeMillis());
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("cs=");
        sb.append(outParameter.connectSession);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("uri=");
        sb.append(outParameter.urlID);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("p=");
        sb.append(7);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("lnb=");
        sb.append(str);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("sta=");
        sb.append(z10 ? 1 : 0);
        if (!TextUtils.isEmpty(str2)) {
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("et=");
            sb.append(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("ec=");
            sb.append(str3);
        }
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("rav=");
        sb.append(HapplayUtils.getAppVersion(this.mContext));
        ReportBean reportBean = new ReportBean();
        String str4 = getPreParameter() + sb.toString();
        SourceLog.i(TAG, "params = " + str4);
        reportBean.httpParameter = new AsyncHttpParameter(CloudAPI.sReportConn, str4);
        addTask(reportBean);
    }

    private void onMirror(int i10, OutParameter outParameter, int i11, int i12) {
        StringBuilder sb = new StringBuilder();
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("st=");
        sb.append(2);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("sn=");
        sb.append(i10);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("ls=");
        sb.append(System.currentTimeMillis());
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("cs=");
        sb.append(outParameter.connectSession);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("s=");
        sb.append(outParameter.session);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("uri=");
        sb.append(outParameter.urlID);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("sta=");
        sb.append(1);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("mt=");
        sb.append(outParameter.mimeType);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("dt=");
        sb.append(100);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("rav=");
        sb.append(HapplayUtils.getAppVersion(this.mContext));
        try {
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("cm=");
            sb.append(LeboUtil.anonymizeByMD5(""));
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        if (i10 == 1) {
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("cdi=");
            sb.append(i12);
        } else if (i10 == 110) {
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("etp=");
            sb.append(i11);
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("etc=");
            sb.append(0);
        }
        if (outParameter.protocol == 4) {
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("p=");
            sb.append(7);
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("lnb=");
            sb.append(outParameter.roomID);
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("lbid=");
            sb.append(Preference.getInstance().get(Constant.KEY_VUUID));
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("mci=");
            sb.append(outParameter.urlID);
        } else {
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("p=");
            sb.append(getProtocol(outParameter));
        }
        if (NetworkUtil.isWiFiOpen(this.mContext)) {
            String wifiBSSIDNoneColon = NetworkUtil.getWifiBSSIDNoneColon(this.mContext);
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("bssdc=");
            sb.append(LeboUtil.anonymizeByMD5(wifiBSSIDNoneColon));
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("bssds=");
            sb.append(LeboUtil.anonymizeByMD5(wifiBSSIDNoneColon));
        }
        ReportBean reportBean = new ReportBean();
        String str = getPreParameter() + sb.toString();
        SourceLog.debug(TAG, "onMirror params :" + str);
        reportBean.httpParameter = new AsyncHttpParameter(CloudAPI.sReportMirror, str);
        addTask(reportBean);
    }

    private void onMirrorFailed(OutParameter outParameter, String str, String str2, String str3) {
        SourceLog.i(TAG, "onMirrorFailed");
        onMirrorSend(outParameter, false, str, str2, str3);
    }

    private void onMirrorRender(OutParameter outParameter) {
        StringBuilder sb = new StringBuilder();
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("st=");
        sb.append(2);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("sn=");
        sb.append(108);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("ls=");
        sb.append(System.currentTimeMillis());
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("cs=");
        sb.append(outParameter.connectSession);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("s=");
        sb.append(outParameter.session);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("uri=");
        sb.append(outParameter.urlID);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("sta=");
        sb.append(1);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("rav=");
        sb.append(HapplayUtils.getAppVersion(this.mContext));
        if (outParameter.protocol == 4) {
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("p=");
            sb.append(7);
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("lnb=");
            sb.append(outParameter.roomID);
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("lbid=");
            sb.append(Preference.getInstance().get(Constant.KEY_VUUID));
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("mci=");
            sb.append(outParameter.urlID);
        } else {
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("p=");
            sb.append(getProtocol(outParameter));
        }
        ReportBean reportBean = new ReportBean();
        String str = getPreParameter() + sb.toString();
        SourceLog.i(TAG, "onMirrorSend params :" + str);
        reportBean.httpParameter = new AsyncHttpParameter(CloudAPI.sReportMirror, str);
        addTask(reportBean);
    }

    private void onMirrorSend(OutParameter outParameter, boolean z10, String str, String str2, String str3) {
        String errInfo = getErrInfo(str3, outParameter.urlID);
        if (!TextUtils.isEmpty(errInfo)) {
            str = errInfo;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("st=");
        sb.append(2);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("sn=");
        sb.append(2);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("ls=");
        sb.append(System.currentTimeMillis());
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("cs=");
        sb.append(outParameter.connectSession);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("s=");
        sb.append(outParameter.session);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("uri=");
        sb.append(outParameter.urlID);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("sta=");
        sb.append(z10 ? 1 : 2);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("rav=");
        sb.append(HapplayUtils.getAppVersion(this.mContext));
        if (outParameter.protocol == 4) {
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("p=");
            sb.append(7);
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("lnb=");
            sb.append(outParameter.roomID);
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("lbid=");
            sb.append(Preference.getInstance().get(Constant.KEY_VUUID));
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("mci=");
            sb.append(outParameter.urlID);
        } else {
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("p=");
            sb.append(getProtocol(outParameter));
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("et=");
            sb.append(str);
        }
        ReportBean reportBean = new ReportBean();
        String str4 = getPreParameter() + sb.toString();
        SourceLog.debug(TAG, "onMirrorSend params :" + str4);
        reportBean.httpParameter = new AsyncHttpParameter(CloudAPI.sReportMirror, str4);
        addTask(reportBean);
    }

    private void onMirrorStart(OutParameter outParameter, int i10) {
        SourceLog.i(TAG, "onMirrorStart");
        onMirror(1, outParameter, 0, i10);
    }

    private void onMirrorStop(OutParameter outParameter, int i10) {
        SourceLog.i(TAG, "onMirrorStop " + i10);
        onMirror(110, outParameter, i10, -1);
    }

    private void onMirrorSuccess(OutParameter outParameter) {
        SourceLog.i(TAG, "onMirrorSuccess");
        onMirrorSend(outParameter, true, "", "", null);
    }

    private void onPush(int i10, OutParameter outParameter, int i11, int i12) {
        BrowserInfo browserInfo;
        Map<String, String> extras;
        StringBuilder sb = new StringBuilder();
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("st=");
        sb.append(1);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("sn=");
        sb.append(i10);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("ls=");
        sb.append(System.currentTimeMillis());
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("cs=");
        sb.append(outParameter.connectSession);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("s=");
        sb.append(outParameter.session);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("uri=");
        sb.append(outParameter.urlID);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("p=");
        sb.append(getProtocol(outParameter));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("clip=");
        sb.append(DeviceUtil.getIPAddress(this.mContext));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("sta=");
        sb.append(1);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("ez=");
        sb.append(outParameter.pushType);
        if (i10 == 1) {
            try {
                if (!TextUtils.isEmpty(outParameter.getPlayUrl())) {
                    sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
                    sb.append("i=");
                    sb.append(URLEncoder.encode(outParameter.getPlayUrl(), XML.CHARSET_UTF8));
                }
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("cdi=");
            sb.append(i12);
        } else if (i10 == 110) {
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("etp=");
            sb.append(i11);
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("etc=");
            sb.append(0);
        }
        if (outParameter.urls != null && (i10 == 1 || i10 == 110)) {
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("ipl=");
            sb.append(1);
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("plid=");
            sb.append(outParameter.dramaID);
        }
        int i13 = outParameter.protocol;
        if (i13 == 1) {
            try {
                sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
                sb.append("cm=");
                sb.append(LeboUtil.anonymizeByMD5(""));
            } catch (Exception e11) {
                SourceLog.w(TAG, e11);
            }
        } else if (i13 == 3 && (browserInfo = CastUtil.getBrowserInfo(outParameter.serviceInfo, 3)) != null && (extras = browserInfo.getExtras()) != null && extras.size() > 0) {
            String str = extras.get("dlna_mode_desc");
            if (!TextUtils.isEmpty(str)) {
                sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
                sb.append("mdd=");
                sb.append(str);
            }
            String str2 = extras.get(BrowserInfo.KEY_DLNA_MODE_NAME);
            if (!TextUtils.isEmpty(str2)) {
                sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
                sb.append("mdn=");
                sb.append(str2);
            }
            String str3 = extras.get(BrowserInfo.KEY_MANUFACTURER);
            if (!TextUtils.isEmpty(str3)) {
                sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
                sb.append("rem=");
                sb.append(str3);
            }
        }
        if (outParameter.pushType == 2) {
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("iez=");
            sb.append(e.d().a(outParameter.session));
        }
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("reu=");
        sb.append(outParameter.serviceInfo.getUid());
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("mt=");
        sb.append(outParameter.mimeType);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("dt=");
        sb.append(100);
        if (NetworkUtil.isWiFiOpen(this.mContext)) {
            String wifiBSSIDNoneColon = NetworkUtil.getWifiBSSIDNoneColon(this.mContext);
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("bssdc=");
            sb.append(LeboUtil.anonymizeByMD5(wifiBSSIDNoneColon));
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("bssds=");
            sb.append(LeboUtil.anonymizeByMD5(wifiBSSIDNoneColon));
        }
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("rav=");
        sb.append(HapplayUtils.getAppVersion(this.mContext));
        ReportBean reportBean = new ReportBean();
        String str4 = getPreParameter() + sb.toString();
        SourceLog.debug(TAG, "onPush params :" + str4);
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sReportPush, str4);
        reportBean.httpParameter = asyncHttpParameter;
        asyncHttpParameter.in.requestMethod = 1;
        addTask(reportBean);
    }

    private void onPushFailed(OutParameter outParameter, String str, String str2, boolean z10, String str3) {
        SourceLog.i(TAG, "onPushFailed");
        onPushSend(outParameter, false, str, str2, z10, str3);
    }

    private void onPushRender(OutParameter outParameter) {
        StringBuilder sb = new StringBuilder();
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("st=");
        sb.append(1);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("sn=");
        sb.append(108);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("ls=");
        sb.append(System.currentTimeMillis());
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("cs=");
        sb.append(outParameter.connectSession);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("s=");
        sb.append(outParameter.session);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("uri=");
        sb.append(outParameter.urlID);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("p=");
        sb.append(getProtocol(outParameter));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("sta=");
        sb.append(1);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("rav=");
        sb.append(HapplayUtils.getAppVersion(this.mContext));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("ez=");
        sb.append(outParameter.pushType);
        if (outParameter.urls != null) {
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("ipl=");
            sb.append(1);
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("plid=");
            sb.append(outParameter.dramaID);
        }
        if (outParameter.pushType == 2) {
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("iez=");
            sb.append(e.d().a(outParameter.session));
        }
        ReportBean reportBean = new ReportBean();
        String str = getPreParameter() + sb.toString();
        SourceLog.i(TAG, "onPushRender params " + outParameter.urlID);
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sReportPush, str);
        reportBean.httpParameter = asyncHttpParameter;
        asyncHttpParameter.in.requestMethod = 1;
        addTask(reportBean);
    }

    private void onPushSend(OutParameter outParameter, boolean z10, String str, String str2, boolean z11, String str3) {
        String str4 = outParameter.session;
        String str5 = outParameter.connectSession;
        String str6 = outParameter.urlID;
        if (!TextUtils.isEmpty(str3)) {
            try {
                JSONObject jSONObject = new JSONObject(str3);
                str4 = jSONObject.optString(ParamsMap.DeviceParams.KEY_SESSION_ID);
                str5 = jSONObject.optString(ParamsMap.DeviceParams.KEY_CONNECT_SESSION_ID);
                str6 = jSONObject.optString("uri");
                if (!z10) {
                    str2 = jSONObject.optString("errCode");
                    String optString = jSONObject.optString("errMsg");
                    String optString2 = jSONObject.optString(ParamsMap.PushParams.KEY_LOCATION_URI);
                    String optString3 = jSONObject.optString("desc");
                    HashMap hashMap = new HashMap();
                    hashMap.put("desc", optString3);
                    hashMap.put("location", optString2);
                    hashMap.put(KEY_ERREPORT_EVENTID, str6);
                    hashMap.put(KEY_ERREPORT_ERMSG, optString);
                    hashMap.put(KEY_ERREPORT_ERCODE, str2 + "");
                    uploadPushErrorDetails(hashMap);
                }
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
            str = getErrInfo(str3, str6);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("st=");
        sb.append(1);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("sn=");
        sb.append(2);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("ls=");
        sb.append(System.currentTimeMillis());
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("cs=");
        sb.append(str5);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("s=");
        sb.append(str4);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("uri=");
        sb.append(str6);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("p=");
        sb.append(getProtocol(outParameter));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("sta=");
        sb.append(z10 ? 1 : 2);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("et=");
        sb.append(str);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("ec=");
        sb.append(str2);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("ryf=");
        sb.append(z11 ? 1 : 0);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("rav=");
        sb.append(HapplayUtils.getAppVersion(this.mContext));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("ez=");
        sb.append(outParameter.pushType);
        if (outParameter.urls != null) {
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("ipl=");
            sb.append(1);
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("plid=");
            sb.append(outParameter.dramaID);
        }
        if (outParameter.pushType == 2) {
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("iez=");
            sb.append(e.d().a(outParameter.session));
        }
        ReportBean reportBean = new ReportBean();
        String str7 = getPreParameter() + sb.toString();
        SourceLog.i(TAG, "onPushSend " + outParameter.urlID);
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sReportPush, str7);
        reportBean.httpParameter = asyncHttpParameter;
        asyncHttpParameter.in.requestMethod = 1;
        addTask(reportBean);
    }

    private void onPushStart(OutParameter outParameter, int i10) {
        SourceLog.i(TAG, "onPushStart");
        onPush(1, outParameter, 0, i10);
    }

    private void onPushStop(OutParameter outParameter, int i10) {
        SourceLog.i(TAG, "onPushStop " + i10);
        onPush(110, outParameter, i10, -1);
    }

    private void onPushSuccess(OutParameter outParameter, boolean z10, String str) {
        SourceLog.i(TAG, "onPushSuccess");
        onPushSend(outParameter, true, "", "", z10, str);
    }

    public void addTask(ReportBean reportBean) {
        AsyncHttpParameter.In in = reportBean.httpParameter.in;
        Map<String, String> map = in.requestHeaders;
        if (map != null) {
            map.put("Connection", HTTP.CLOSE);
        } else {
            in.requestHeaders = this.mConnectHeader;
        }
        SourceLog.debug(TAG, "source addTask -----> " + reportBean.httpParameter.in.params);
        reportBean.encryptVersion = Constant.DATAREPORT_PROTOCOL_VER;
        DataReport.onDataReport(reportBean, true);
    }

    public void crashDataUpload(Map<String, String> map) {
        String preParameter = getPreParameter();
        if (!TextUtils.isEmpty(preParameter)) {
            for (String str : preParameter.split(DispatchConstants.SIGN_SPLIT_SYMBOL)) {
                if (!TextUtils.isEmpty(str) && str.contains(Operator.Operation.EQUALS)) {
                    String[] split = str.split(Operator.Operation.EQUALS);
                    if (split.length == 2) {
                        map.put(split[0], split[1]);
                    }
                }
            }
        }
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sReportError, HapplayUtils.getJsonParams(map));
        AsyncHttpParameter.In in = asyncHttpParameter.in;
        in.connectTimeout = d.SOCKET_READ_TIMEOUT;
        in.readTimeout = d.SOCKET_READ_TIMEOUT;
        in.requestMethod = 1;
        AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.business.cloud.SourceDataReport.1
            @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter2) {
                SourceLog.debug(SourceDataReport.TAG, "crash onRequestResult = " + asyncHttpParameter2.out.result);
            }
        });
    }

    public String getPreParameter() {
        StringBuilder sb = new StringBuilder();
        sb.append("tid");
        sb.append(Operator.Operation.EQUALS);
        sb.append(this.mSession.tid);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("cu");
        sb.append(Operator.Operation.EQUALS);
        sb.append(LeboUtil.getCUid(this.mContext));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("suc");
        sb.append(Operator.Operation.EQUALS);
        sb.append(Session.getInstance().getUID());
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("v");
        sb.append(Operator.Operation.EQUALS);
        sb.append(Constant.DATAREPORT_PROTOCOL_VER);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("a");
        sb.append(Operator.Operation.EQUALS);
        sb.append("2004");
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("as");
        sb.append(Operator.Operation.EQUALS);
        sb.append(this.authSessionId);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("sc");
        sb.append(Operator.Operation.EQUALS);
        sb.append(this.mSession.appKey);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(ParamsMap.DeviceParams.KEY_HID);
        sb.append(Operator.Operation.EQUALS);
        sb.append(Session.getInstance().getHID());
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("rav=");
        sb.append(HapplayUtils.getAppVersion(this.mContext));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("rsv");
        sb.append(Operator.Operation.EQUALS);
        sb.append("4.12.14");
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("j");
        sb.append(Operator.Operation.EQUALS);
        sb.append(DeviceProperties.getModel());
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("br");
        sb.append(Operator.Operation.EQUALS);
        sb.append(DeviceProperties.getBrand());
        String oaid = DeviceUtil.getOAID(this.mContext);
        String aid = LeboUtil.getAID(this.mContext);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("sv=");
        sb.append(Build.VERSION.SDK_INT);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("oidc=");
        sb.append(LeboUtil.anonymizeByMD5(oaid));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("oids=");
        sb.append(LeboUtil.anonymizeBySHA256(oaid));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("aidc=");
        sb.append(LeboUtil.anonymizeByMD5(aid));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("aids=");
        sb.append(LeboUtil.anonymizeBySHA256(aid));
        return sb.toString();
    }

    public int getProtocol(OutParameter outParameter) {
        if (outParameter == null) {
            return 0;
        }
        if (outParameter.protocol == 1 && CastUtil.isSupportLelinkV2(outParameter.serviceInfo)) {
            return 5;
        }
        return outParameter.protocol;
    }

    public void login(String str) {
        String str2 = "&imdc=" + LeboUtil.anonymizeByMD5("") + "&imds=" + LeboUtil.anonymizeBySHA256("") + "&j=" + DeviceProperties.getModel() + "&cut=1&pk=" + this.mContext.getPackageName() + "&fn=" + DeviceProperties.getManufacturer();
        String str3 = "&csv=4.12.14&l=" + Locale.getDefault().getLanguage() + "&sv=" + Build.VERSION.RELEASE + "&n=" + NetworkUtil.getNetType(this.mContext);
        try {
            if ("com.hpplay.sdk.source.test".equalsIgnoreCase(this.mContext.getPackageName())) {
                str3 = str3 + "&cav=" + str;
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        String str4 = getPreParameter() + "&st=5&sn=1" + str2 + str3;
        ReportBean reportBean = new ReportBean();
        reportBean.httpParameter = new AsyncHttpParameter(CloudAPI.sReportLogIn, str4);
        addTask(reportBean);
    }

    public void logout() {
        ReportBean reportBean = new ReportBean();
        reportBean.httpParameter = new AsyncHttpParameter(CloudAPI.sReportLogOut, getPreParameter() + "&st=5&sn=3");
        addTask(reportBean);
    }

    public void onAuthFailed(String str) {
        onConnect(5, 500, "", 0, null, 0L, 0, str);
    }

    public void onBlePublish(int i10, String str) {
        SourceLog.i(TAG, "onBlePublish:" + i10);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("st=");
        stringBuffer.append(11502);
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("sn=");
        stringBuffer.append(101);
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("status=");
        stringBuffer.append(i10);
        if (!TextUtils.isEmpty(str)) {
            stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            stringBuffer.append("errorcode=");
            stringBuffer.append(str);
        }
        ReportBean reportBean = new ReportBean();
        reportBean.httpParameter = new AsyncHttpParameter(CloudAPI.sReportUserBehavior, getPreParameter() + stringBuffer.toString());
        addTask(reportBean);
    }

    public void onCastFailed(OutParameter outParameter, String str, String str2, boolean z10, String str3) {
        int i10 = outParameter.castType;
        if (i10 == 1) {
            onPushFailed(outParameter, str, str2, z10, str3);
        } else {
            if (i10 != 2) {
                return;
            }
            onMirrorFailed(outParameter, str, str2, str3);
        }
    }

    public void onCastRender(OutParameter outParameter) {
        int i10 = outParameter.castType;
        if (i10 == 1) {
            onPushRender(outParameter);
        } else {
            if (i10 != 2) {
                return;
            }
            onMirrorRender(outParameter);
        }
    }

    public void onCastStart(OutParameter outParameter, int i10) {
        int i11 = outParameter.castType;
        if (i11 == 1) {
            onPushStart(outParameter, i10);
        } else {
            if (i11 != 2) {
                return;
            }
            onMirrorStart(outParameter, i10);
        }
    }

    public void onCastStop(OutParameter outParameter, int i10) {
        int i11 = outParameter.castType;
        if (i11 == 1) {
            onPushStop(outParameter, i10);
        } else {
            if (i11 != 2) {
                return;
            }
            onMirrorStop(outParameter, i10);
        }
    }

    public void onCastSuccess(OutParameter outParameter, boolean z10, String str) {
        int i10 = outParameter.castType;
        if (i10 == 1) {
            onPushSuccess(outParameter, z10, str);
        } else {
            if (i10 != 2) {
                return;
            }
            onMirrorSuccess(outParameter);
        }
    }

    public void onCloudConnect(String str, int i10, LelinkServiceInfo lelinkServiceInfo) {
        SourceLog.i(TAG, "onCloudConnect " + str + " / " + i10);
        BrowserInfo browserInfo = CastUtil.getBrowserInfo(lelinkServiceInfo, i10);
        if (browserInfo == null) {
            onConnectSuccess(4, 401, str, i10, lelinkServiceInfo);
            return;
        }
        int createType = browserInfo.getCreateType();
        if (createType == 2) {
            onConnectSuccess(10, 401, str, i10, lelinkServiceInfo);
        } else if (createType != 5) {
            onConnectSuccess(4, 401, str, i10, lelinkServiceInfo);
        } else {
            onConnectSuccess(11, 401, str, i10, lelinkServiceInfo);
        }
    }

    public void onCloudConnectFailed(String str, int i10, LelinkServiceInfo lelinkServiceInfo, String str2) {
        SourceLog.i(TAG, "onCloudConnectFailed " + str + " / " + i10 + " / " + str2);
        onConnect(4, 408, str, i10, lelinkServiceInfo, 0L, 0, str2);
    }

    public void onCloudConnectSuccess(String str, int i10, LelinkServiceInfo lelinkServiceInfo) {
        SourceLog.i(TAG, "onCloudConnectSuccess " + str + " / " + i10);
        onConnectSuccess(4, 408, str, i10, lelinkServiceInfo);
    }

    public void onCloudDisconnect(String str, int i10, LelinkServiceInfo lelinkServiceInfo, int i11) {
        SourceLog.i(TAG, "onCloudDisconnect " + str + " / " + i10);
        onConnect(4, Constant.TOKEN_EXPIRED, str, i10, lelinkServiceInfo, 0L, 1, "", i11, 0, null);
    }

    public void onConnectDeviceQuery() {
        SourceLog.i(TAG, "onConnectDeviceQuery");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("st=");
        stringBuffer.append(11101);
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("sn=");
        stringBuffer.append(2);
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("lbid=");
        stringBuffer.append(Preference.getInstance().get(Constant.KEY_VUUID));
        ReportBean reportBean = new ReportBean();
        reportBean.httpParameter = new AsyncHttpParameter(CloudAPI.sReportUserBehavior, getPreParameter() + stringBuffer.toString());
        addTask(reportBean);
    }

    public void onConnectDeviceUpload() {
        SourceLog.i(TAG, "onConnectDeviceUpload");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("st=");
        stringBuffer.append(11101);
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("sn=");
        stringBuffer.append(1);
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("lbid=");
        stringBuffer.append(Preference.getInstance().get(Constant.KEY_VUUID));
        ReportBean reportBean = new ReportBean();
        reportBean.httpParameter = new AsyncHttpParameter(CloudAPI.sReportUserBehavior, getPreParameter() + stringBuffer.toString());
        addTask(reportBean);
    }

    public void onGetRoomFailed(OutParameter outParameter, String str) {
        onGetRoom(outParameter, false, null, null, str);
    }

    public void onGetRoomSuccess(OutParameter outParameter, String str) {
        onGetRoom(outParameter, true, str, null, null);
    }

    public void onLocalConnect(String str, int i10, LelinkServiceInfo lelinkServiceInfo) {
        SourceLog.i(TAG, "onLocalConnect " + str + " / " + i10);
        BrowserInfo browserInfo = CastUtil.getBrowserInfo(lelinkServiceInfo, i10);
        if (browserInfo == null) {
            onConnectSuccess(3, 1, str, i10, lelinkServiceInfo);
            return;
        }
        int createType = browserInfo.getCreateType();
        if (createType == 2) {
            onConnectSuccess(10, 1, str, i10, lelinkServiceInfo);
        } else if (createType != 5) {
            onConnectSuccess(3, 1, str, i10, lelinkServiceInfo);
        } else {
            onConnectSuccess(11, 1, str, i10, lelinkServiceInfo);
        }
    }

    public void onLocalConnectFailed(String str, int i10, LelinkServiceInfo lelinkServiceInfo, String str2, String str3) {
        SourceLog.i(TAG, "onLocalConnectFailed " + str + " / " + i10 + " / " + str2);
        onConnect(3, 6, str, i10, lelinkServiceInfo, 0L, 0, str2, str3);
    }

    public void onLocalConnectSuccess(String str, int i10, LelinkServiceInfo lelinkServiceInfo) {
        SourceLog.i(TAG, "onLocalConnectSuccess " + str + " / " + i10);
        onConnectSuccess(3, 6, str, i10, lelinkServiceInfo);
    }

    public void onLocalDisconnect(String str, int i10, LelinkServiceInfo lelinkServiceInfo, int i11) {
        SourceLog.i(TAG, "onLocalDisconnect " + str + " / " + i10);
        onConnect(3, 10, str, i10, lelinkServiceInfo, 0L, 1, "", i11, 0, null);
    }

    public void onMirrorChange(OutParameter outParameter, JSONArray jSONArray) {
        if (outParameter == null) {
            return;
        }
        onQuality(jSONArray, outParameter.urlID, false);
    }

    public void onPinCodeEnd(LelinkServiceInfo lelinkServiceInfo, String str, int i10, long j10) {
        onConnect(11, 1002, str, 0, lelinkServiceInfo, j10, i10, null);
    }

    public void onPinCodeStart(String str) {
        onConnect(11, 1001, str, 0, null, 0L, 0, null);
    }

    public void onPushButtonClick(String str, String str2) {
        if (Feature.isNubiaChannel()) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("st=");
        stringBuffer.append(608);
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer2.append("st=");
        stringBuffer2.append(608);
        stringBuffer2.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer2.append("sn=");
        stringBuffer2.append(1);
        stringBuffer2.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer2.append("s=");
        stringBuffer2.append(str);
        stringBuffer2.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer2.append("akv=");
        stringBuffer2.append(str2);
        ReportBean reportBean = new ReportBean();
        String str3 = getPreParameter() + stringBuffer.toString();
        reportBean.httpParameter = new AsyncHttpParameter(CloudAPI.sReportUserBehavior, str3);
        addTask(reportBean);
        SourceLog.i(TAG, CloudAPI.sReportUserBehavior + str3);
    }

    public void onQRScanEnd(LelinkServiceInfo lelinkServiceInfo, String str, int i10, long j10) {
        onConnect(10, 1002, str, 0, lelinkServiceInfo, j10, i10, null);
    }

    public void onQRScanStart(String str) {
        onConnect(10, 1001, str, 0, null, 0L, 0, null);
    }

    public void onQuality(OutParameter outParameter, JSONArray jSONArray) {
        if (outParameter == null) {
            return;
        }
        onQuality(jSONArray, outParameter.urlID, true);
    }

    public void onReceiveCloudMirrorConnectRequest(String str, String str2, String str3, String str4) {
        SourceLog.i(TAG, "onReceiveCloudMirrorConnectRequest : " + str + "  uri :" + str3 + "  roomId :" + str4);
        StringBuilder sb = new StringBuilder();
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("st=");
        sb.append(2);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("sn=");
        sb.append(3);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("ls=");
        sb.append(System.currentTimeMillis());
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("cs=");
        sb.append(str);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("s=");
        sb.append(str2);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("uri=");
        sb.append(str3);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("p=");
        sb.append(7);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("mt=");
        sb.append(102);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("dt=");
        sb.append(100);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("lnb=");
        sb.append(str4);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("lbid=");
        sb.append(Preference.getInstance().get(Constant.KEY_VUUID));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("mci=");
        sb.append(str3);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("sta=");
        sb.append(1);
        if (NetworkUtil.isWiFiOpen(this.mContext)) {
            String wifiBSSIDNoneColon = NetworkUtil.getWifiBSSIDNoneColon(this.mContext);
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("bssdc=");
            sb.append(LeboUtil.anonymizeByMD5(wifiBSSIDNoneColon));
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("bssds=");
            sb.append(LeboUtil.anonymizeBySHA256(wifiBSSIDNoneColon));
        }
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("rav=");
        sb.append(HapplayUtils.getAppVersion(this.mContext));
        ReportBean reportBean = new ReportBean();
        String str5 = getPreParameter() + sb.toString();
        SourceLog.i(TAG, "params = " + str5);
        reportBean.httpParameter = new AsyncHttpParameter(CloudAPI.sReportMirror, str5);
        addTask(reportBean);
    }

    public void onReceiverLive(String str, String str2) {
        SourceLog.i(TAG, "onReceiverLive");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("cs=");
        stringBuffer.append(str);
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("a=");
        stringBuffer.append("2004");
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("cu=");
        stringBuffer.append(LeboUtil.getCUid(this.mContext));
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("sc=");
        stringBuffer.append(Session.getInstance().appKey);
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("hid=");
        stringBuffer.append(Session.getInstance().getHID());
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("suc=");
        stringBuffer.append(Session.getInstance().getUID());
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("rsv=");
        stringBuffer.append("4.12.14");
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("dll=");
        stringBuffer.append(str2);
        ReportBean reportBean = new ReportBean();
        reportBean.httpParameter = new AsyncHttpParameter(CloudAPI.sReportConnLive, getPreParameter() + stringBuffer.toString());
        addTask(reportBean);
    }

    public void onSinkTouchBuild(int i10, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("st=");
        stringBuffer.append(11503);
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("sn=");
        stringBuffer.append(101);
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("status=");
        stringBuffer.append(i10);
        if (!TextUtils.isEmpty(str)) {
            stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            stringBuffer.append("errorcode=");
            stringBuffer.append(str);
        }
        ReportBean reportBean = new ReportBean();
        reportBean.httpParameter = new AsyncHttpParameter(CloudAPI.sReportUserBehavior, getPreParameter() + stringBuffer.toString());
        addTask(reportBean);
    }

    public void onSinkTouchCloudBuild(int i10, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("st=");
        stringBuffer.append(11503);
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("sn=");
        stringBuffer.append(102);
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("status=");
        stringBuffer.append(i10);
        if (!TextUtils.isEmpty(str)) {
            stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            stringBuffer.append("errorcode=");
            stringBuffer.append(str);
        }
        ReportBean reportBean = new ReportBean();
        reportBean.httpParameter = new AsyncHttpParameter(CloudAPI.sReportUserBehavior, getPreParameter() + stringBuffer.toString());
        addTask(reportBean);
    }

    public void onSonicScan(int i10, String str) {
        SourceLog.i(TAG, "onSonicScan:" + i10);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("st=");
        stringBuffer.append(11502);
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("sn=");
        stringBuffer.append(102);
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("status=");
        stringBuffer.append(i10);
        if (!TextUtils.isEmpty(str)) {
            stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            stringBuffer.append("errorcode=");
            stringBuffer.append(str);
        }
        ReportBean reportBean = new ReportBean();
        reportBean.httpParameter = new AsyncHttpParameter(CloudAPI.sReportUserBehavior, getPreParameter() + stringBuffer.toString());
        addTask(reportBean);
    }

    public void onStartPullYoumeStream(OutParameter outParameter) {
        SourceLog.i(TAG, "onStartPullYoumeStream");
        StringBuilder sb = new StringBuilder();
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("st=");
        sb.append(2);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("sn=");
        sb.append(100);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("ls=");
        sb.append(System.currentTimeMillis());
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("cs=");
        sb.append(outParameter.connectSession);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("s=");
        sb.append(outParameter.session);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("uri=");
        sb.append(outParameter.urlID);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("p=");
        sb.append(7);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("mt=");
        sb.append(102);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("dt=");
        sb.append(100);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("lnb=");
        sb.append(outParameter.roomID);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("lbid=");
        sb.append(Preference.getInstance().get(Constant.KEY_VUUID));
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("mci=");
        sb.append(outParameter.urlID);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("sta=");
        sb.append(1);
        if (NetworkUtil.isWiFiOpen(this.mContext)) {
            String wifiBSSIDNoneColon = NetworkUtil.getWifiBSSIDNoneColon(this.mContext);
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("bssdc=");
            sb.append(LeboUtil.anonymizeByMD5(wifiBSSIDNoneColon));
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("bssds=");
            sb.append(LeboUtil.anonymizeByMD5(wifiBSSIDNoneColon));
        }
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("rav=");
        sb.append(HapplayUtils.getAppVersion(this.mContext));
        ReportBean reportBean = new ReportBean();
        String str = getPreParameter() + sb.toString();
        SourceLog.i(TAG, "params = " + str);
        reportBean.httpParameter = new AsyncHttpParameter(CloudAPI.sReportMirror, str);
        addTask(reportBean);
    }

    public void onStopPullYoumeStream(OutParameter outParameter) {
        if (outParameter == null) {
            SourceLog.i(TAG, "onStopPullYoumeStream ignore");
            return;
        }
        SourceLog.i(TAG, "onStopPullYoumeStream ");
        ReportBean reportBean = new ReportBean();
        StringBuilder sb = new StringBuilder();
        sb.append(getPreParameter());
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL + "st=2" + DispatchConstants.SIGN_SPLIT_SYMBOL + "sn=102" + DispatchConstants.SIGN_SPLIT_SYMBOL + "ls=" + System.currentTimeMillis() + DispatchConstants.SIGN_SPLIT_SYMBOL + "cs=" + outParameter.connectSession + DispatchConstants.SIGN_SPLIT_SYMBOL + "s=" + outParameter.session + DispatchConstants.SIGN_SPLIT_SYMBOL + "uri=" + outParameter.urlID + DispatchConstants.SIGN_SPLIT_SYMBOL + "p=7" + DispatchConstants.SIGN_SPLIT_SYMBOL + "lnb=" + outParameter.roomID + DispatchConstants.SIGN_SPLIT_SYMBOL + "lbid=" + Preference.getInstance().get(Constant.KEY_VUUID) + DispatchConstants.SIGN_SPLIT_SYMBOL + "mci=" + outParameter.urlID + DispatchConstants.SIGN_SPLIT_SYMBOL + "sta=1" + DispatchConstants.SIGN_SPLIT_SYMBOL + "rav=" + HapplayUtils.getAppVersion(this.mContext));
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("params = ");
        sb3.append(sb2);
        SourceLog.i(TAG, sb3.toString());
        reportBean.httpParameter = new AsyncHttpParameter(CloudAPI.sReportMirror, sb2);
        addTask(reportBean);
    }

    public void onYimConnect(String str, int i10, LelinkServiceInfo lelinkServiceInfo) {
        onConnectSuccess(7, IMediaPlayer.MEDIA_INFO_BUFFERING_START, str, i10, lelinkServiceInfo);
    }

    public void onYimInit(int i10, OutParameter outParameter, boolean z10, String str, String str2) {
        String str3;
        String str4;
        String str5 = outParameter.connectSession;
        LelinkServiceInfo lelinkServiceInfo = outParameter.serviceInfo;
        if (lelinkServiceInfo != null) {
            str3 = lelinkServiceInfo.getIp();
            str4 = lelinkServiceInfo.getUid();
        } else {
            str3 = null;
            str4 = null;
        }
        SourceLog.i(TAG, "onYoumeConnect sessionId = " + str5 + "  serviceNumber =" + i10);
        StringBuilder sb = new StringBuilder();
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("st=");
        sb.append(7);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("sn=");
        sb.append(i10);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("ls=");
        sb.append(System.currentTimeMillis());
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("cs=");
        sb.append(str5);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("p=");
        sb.append(7);
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("sta=");
        sb.append(z10 ? 1 : 0);
        if (!TextUtils.isEmpty(str3)) {
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("rli=");
            sb.append(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            sb.append("ru=");
            sb.append(str4);
        }
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append("rav=");
        sb.append(HapplayUtils.getAppVersion(this.mContext));
        if (!z10) {
            if (!TextUtils.isEmpty(str)) {
                sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
                sb.append("et=");
                sb.append(str);
            }
            if (!TextUtils.isEmpty(str2)) {
                sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
                sb.append("ec=");
                sb.append(str2);
            }
        }
        String str6 = getPreParameter() + sb.toString();
        SourceLog.i(TAG, "params = " + str6);
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sReportConn, str6);
        ReportBean reportBean = new ReportBean();
        reportBean.httpParameter = asyncHttpParameter;
        addTask(reportBean);
    }

    public void relation(long j10, long j11, String str, String str2, String str3, String str4, String str5) {
        relation(j10, j11, str, str2, str3, str4, null, str5);
    }

    public void reportBleStartBrowseTimes() {
        SourceLog.i(TAG, "reportBleStartBrowseTimes");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("st=");
        stringBuffer.append(11102);
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("sn=");
        stringBuffer.append(1);
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("lbid=");
        stringBuffer.append(Preference.getInstance().get(Constant.KEY_VUUID));
        ReportBean reportBean = new ReportBean();
        reportBean.httpParameter = new AsyncHttpParameter(CloudAPI.sReportUserBehavior, getPreParameter() + stringBuffer.toString());
        addTask(reportBean);
    }

    public void reportFoundDeviceOfBle() {
        SourceLog.i(TAG, "reportFoundOfBle");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("st=");
        stringBuffer.append(11102);
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("sn=");
        stringBuffer.append(2);
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("lbid=");
        stringBuffer.append(Preference.getInstance().get(Constant.KEY_VUUID));
        ReportBean reportBean = new ReportBean();
        reportBean.httpParameter = new AsyncHttpParameter(CloudAPI.sReportUserBehavior, getPreParameter() + stringBuffer.toString());
        addTask(reportBean);
    }

    public void uploadPushErrorDetails(Map<String, String> map) {
        getInstance().crashDataUpload(map);
    }

    private void onConnect(int i10, int i11, String str, int i12, LelinkServiceInfo lelinkServiceInfo, long j10, int i13, String str2, String str3) {
        onConnect(i10, i11, str, i12, lelinkServiceInfo, j10, i13, str2, 0, 0, str3);
    }

    private void onQuality(JSONArray jSONArray, String str, boolean z10) {
        try {
            Session session = Session.getInstance();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("st", 100);
            jSONObject.put("sn", 1);
            jSONObject.put("suc", session.getUID());
            jSONObject.put("sc", session.appKey);
            jSONObject.put(ParamsMap.DeviceParams.KEY_HID, session.getHID());
            jSONObject.put("rsv", CastUtil.getVersion());
            jSONObject.put("rav", HapplayUtils.getAppVersion(this.mContext));
            jSONObject.put("v", Constant.DATAREPORT_PROTOCOL_VER);
            jSONObject.put("uri_id", str);
            if (z10) {
                jSONObject.put("cqj", jSONArray);
            } else {
                jSONObject.put("ncs", jSONArray);
            }
            AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sReportConnLive, jSONArray.toString());
            asyncHttpParameter.in.requestMethod = 1;
            ReportBean reportBean = new ReportBean();
            reportBean.httpParameter = asyncHttpParameter;
            addTask(reportBean);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    private void uploadPushErrorDetails(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        SourceErrorLog.getInstance().handleErrorCode(str, str2, str3);
    }

    public void relation(long j10, long j11, String str, String str2, String str3, String str4, String str5, String str6) {
        if (Feature.isNubiaChannel()) {
            return;
        }
        SourceLog.i(TAG, "relation");
        HashMap hashMap = new HashMap();
        hashMap.put("st", AgooConstants.ACK_REMOVE_PACKAGE);
        hashMap.put("sn", "1");
        String iPAddress = DeviceUtil.getIPAddress(this.mContext);
        String encryptMD5ToString = EncryptUtil.encryptMD5ToString(System.currentTimeMillis() + "" + new Random().nextInt(10000000) + "" + iPAddress);
        if (!TextUtils.isEmpty(str6)) {
            uploadPushErrorDetails(ErrorCode.BROWSE_FAIL, str6, encryptMD5ToString);
            hashMap.put("et", ErrorCode.MODULE_BROWSE);
            hashMap.put("ec", ErrorCode.BROWSE_FAIL);
        }
        hashMap.put(ParamsMap.DeviceParams.KEY_HID, Session.getInstance().getHID());
        hashMap.put("cu", String.valueOf(LeboUtil.getCUid(this.mContext)));
        hashMap.put("suc", Session.getInstance().getUID());
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("udlist", str);
        }
        try {
            hashMap.put("imdc", LeboUtil.anonymizeByMD5(""));
            hashMap.put("imds", LeboUtil.anonymizeBySHA256(""));
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        hashMap.put("lip", iPAddress);
        hashMap.put("cut", "1");
        hashMap.put("sc", Session.getInstance().appKey);
        if (!TextUtils.isEmpty(Session.getInstance().mTUID)) {
            hashMap.put("tuid", Session.getInstance().mTUID);
        }
        hashMap.put("n", String.valueOf(getNetType(this.mContext)));
        int netType = NetworkUtil.getNetType(this.mContext);
        if (netType == 1 || netType == 2) {
            hashMap.put("bssdc", LeboUtil.anonymizeByMD5(NetworkUtil.getWifiBSSIDNoneColon(this.mContext)));
            hashMap.put("bssds", LeboUtil.anonymizeBySHA256(NetworkUtil.getWifiBSSIDNoneColon(this.mContext)));
            SourceLog.i(TAG, "-----> " + NetworkUtil.getWifiBSSIDNoneColon(this.mContext) + "  ff " + NetworkUtil.getWifiSSID(this.mContext));
            hashMap.put("bsswidc", LeboUtil.anonymizeByMD5(NetworkUtil.getWifiSSID(this.mContext)));
            hashMap.put("bsswids", LeboUtil.anonymizeBySHA256(NetworkUtil.getWifiSSID(this.mContext)));
        }
        hashMap.put("v", Constant.DATAREPORT_PROTOCOL_VER);
        hashMap.put("ltp", j10 + "");
        hashMap.put("lte", j11 + "");
        String oaid = DeviceUtil.getOAID(this.mContext);
        hashMap.put("oidc", LeboUtil.anonymizeByMD5(oaid));
        hashMap.put("oids", LeboUtil.anonymizeBySHA256(oaid));
        hashMap.put("sv", Build.VERSION.SDK_INT + "");
        hashMap.put("aidc", LeboUtil.anonymizeByMD5(LeboUtil.getAID(this.mContext)));
        hashMap.put("aids", LeboUtil.anonymizeBySHA256(LeboUtil.getAID(this.mContext)));
        hashMap.put("rb", str2);
        hashMap.put("wb", str3);
        hashMap.put("rav", HapplayUtils.getAppVersion(this.mContext) + "");
        hashMap.put("rpl", str4);
        hashMap.put("sdid", encryptMD5ToString);
        hashMap.put("rsv", "4.12.14");
        hashMap.put("ullist", str5);
        String mapParams = HapplayUtils.getMapParams(hashMap);
        ReportBean reportBean = new ReportBean();
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sReportRelation, mapParams);
        reportBean.httpParameter = asyncHttpParameter;
        asyncHttpParameter.in.requestMethod = 1;
        addTask(reportBean);
    }

    private void onConnect(int i10, int i11, String str, int i12, LelinkServiceInfo lelinkServiceInfo, long j10, int i13, String str2, int i14, int i15, String str3) {
        String errInfo = getErrInfo(str3, str);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("st=");
        stringBuffer.append(i10);
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("sn=");
        stringBuffer.append(i11);
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("ls=");
        stringBuffer.append(System.currentTimeMillis());
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("lt=");
        stringBuffer.append(j10);
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("cs=");
        stringBuffer.append(str);
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("p=");
        stringBuffer.append(i12);
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("sta=");
        stringBuffer.append(i13);
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("lbid=");
        stringBuffer.append(Preference.getInstance().get(Constant.KEY_VUUID));
        if (i11 == 6) {
            String deviceReportId = ConnectManager.getInstance().getDeviceReportId();
            SourceLog.debug(TAG, "onConnect encryptNumberId :" + deviceReportId);
            if (!TextUtils.isEmpty(deviceReportId)) {
                stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
                stringBuffer.append("lvpn=");
                stringBuffer.append(deviceReportId);
            }
        }
        if (lelinkServiceInfo != null && !TextUtils.isEmpty(lelinkServiceInfo.getIp())) {
            stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            stringBuffer.append("rli=");
            stringBuffer.append(lelinkServiceInfo.getIp());
        }
        if (lelinkServiceInfo != null && !TextUtils.isEmpty(lelinkServiceInfo.getUid())) {
            stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            stringBuffer.append("ru=");
            stringBuffer.append(lelinkServiceInfo.getUid());
        }
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        stringBuffer.append("rav=");
        stringBuffer.append(HapplayUtils.getAppVersion(this.mContext));
        if (i13 != 1) {
            if (!TextUtils.isEmpty(errInfo)) {
                stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
                stringBuffer.append("et=");
                stringBuffer.append(errInfo);
            } else {
                stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
                stringBuffer.append("et=");
                stringBuffer.append(str2);
            }
        }
        if (i11 == 10 || i11 == 410) {
            stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            stringBuffer.append("etp=");
            stringBuffer.append(i14);
            stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
            stringBuffer.append("etc=");
            stringBuffer.append(i15);
        }
        String str4 = getPreParameter() + stringBuffer.toString();
        SourceLog.debug(TAG, "onConnect params :" + str4);
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sReportConn, str4);
        ReportBean reportBean = new ReportBean();
        reportBean.httpParameter = asyncHttpParameter;
        addTask(reportBean);
    }
}
