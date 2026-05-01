package com.hpplay.sdk.source.device.qr;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncHttpRequestListener;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.common.utils.FieldUtil;
import com.hpplay.common.utils.HttpEncrypt;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.cybergarage.xml.XML;
import com.hpplay.sdk.source.browse.api.AuthListener;
import com.hpplay.sdk.source.browse.api.ICreateShortUrlListener;
import com.hpplay.sdk.source.browse.api.IServiceInfoParseListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.browse.data.LelinkServiceInfoCreator;
import com.hpplay.sdk.source.business.cloud.AuthSDK;
import com.hpplay.sdk.source.business.cloud.CloudAPI;
import com.hpplay.sdk.source.business.cloud.SourceDataReport;
import com.hpplay.sdk.source.c.a;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.common.utils.HapplayUtils;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.utils.CastUtil;
import com.hpplay.sdk.source.utils.CreateUtil;
import com.hpplay.sdk.source.utils.Feature;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class QRCodeController {
    private static final int DELAY_CALLBACK_IM = 500;
    private static final int WHAT_CALLBACK_IM = 1;
    private IServiceInfoParseListener listener;
    private String mConnectSession;
    private String plateForm;
    private final String TAG = "QRCodeController";
    private long startMarkTime = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.hpplay.sdk.source.device.qr.QRCodeController.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Object obj;
            if (message.what != 1 || (obj = message.obj) == null) {
                return false;
            }
            QRCodeController.this.callbackIMFirst((LelinkServiceInfo) obj);
            return false;
        }
    });

    private void QRCodeParseCheck(String str, IServiceInfoParseListener iServiceInfoParseListener) {
        String str2;
        this.listener = iServiceInfoParseListener;
        if (iServiceInfoParseListener == null) {
            SourceLog.i("QRCodeController", "addQRCodeServiceInfo ParceQRCodeListener listener is null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            SourceLog.i("QRCodeController", "addQRCodeServiceInfo qrCodeStr is empty");
            callbackToApp(0, null);
            return;
        }
        SourceLog.i("QRCodeController", "addQRCodeServiceInfo qrCodeStr:" + str);
        if (!str.contains("ip=") && !str.contains("remotePort=")) {
            SourceLog.i("QRCodeController", "addQRCodeServiceInfo split length less than 2");
            requestShortUrlForServer(str, this.listener);
            return;
        }
        String substring = str.substring(str.indexOf(Operator.Operation.EMPTY_PARAM) + 1, str.length());
        Map<String, String> urlParams = getUrlParams(substring);
        if (urlParams == null) {
            SourceLog.i("QRCodeController", "addQRCodeServiceInfo getUrlParams is empty");
            requestShortUrlForServer(str, this.listener);
            return;
        }
        String str3 = urlParams.get(BrowserInfo.KEY_REMOTEPORT);
        String str4 = urlParams.get("ip");
        String str5 = urlParams.get(BrowserInfo.KEY_CNAME);
        String str6 = urlParams.get(BrowserInfo.KEY_DEVICE_NAME);
        this.plateForm = urlParams.get(DispatchConstants.PLATFORM);
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str5) || TextUtils.isEmpty(str6)) {
            SourceLog.i("QRCodeController", "addQRCodeServiceInfo ip or remotePort is empty");
            requestShortUrlForServer(str, this.listener);
            return;
        }
        try {
            str2 = URLDecoder.decode(str6, XML.CHARSET_UTF8);
        } catch (Exception e10) {
            SourceLog.w("QRCodeController", e10);
            str2 = str6;
        }
        delayCallbackIM(LelinkServiceInfoCreator.getQRCodeInfo(substring));
        requestLelinkTxtInfo(str5, str2, str4, str3, substring);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackIMFirst(LelinkServiceInfo lelinkServiceInfo) {
        if (lelinkServiceInfo == null) {
            return;
        }
        SourceLog.w("QRCodeController", "callbackIMFirst");
        try {
            if (lelinkServiceInfo.getBrowserInfos().size() > 1 && lelinkServiceInfo.getBrowserInfos().containsKey(4)) {
                lelinkServiceInfo.getBrowserInfos().remove(1);
            }
        } catch (Exception e10) {
            SourceLog.w("QRCodeController", e10);
        }
        if (CastUtil.isSupportIM(lelinkServiceInfo)) {
            BrowserInfo browserInfo = CastUtil.getBrowserInfo(lelinkServiceInfo, 4);
            if (browserInfo != null) {
                browserInfo.setOnLine(true);
            }
            callbackToApp(1, lelinkServiceInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackToApp(int i10, LelinkServiceInfo lelinkServiceInfo) {
        this.mHandler.removeMessages(1);
        IServiceInfoParseListener iServiceInfoParseListener = this.listener;
        if (iServiceInfoParseListener != null) {
            iServiceInfoParseListener.onParseResult(i10, lelinkServiceInfo);
        }
        SourceDataReport.getInstance().onQRScanEnd(lelinkServiceInfo, this.mConnectSession, i10, System.currentTimeMillis() - this.startMarkTime);
    }

    private void delayCallbackIM(LelinkServiceInfo lelinkServiceInfo) {
        if (Feature.isDisableIM()) {
            return;
        }
        this.mHandler.removeMessages(1);
        Handler handler = this.mHandler;
        handler.sendMessageDelayed(handler.obtainMessage(1, lelinkServiceInfo), 500L);
    }

    private String getQrAsyncHttpParameter(String str) {
        Session session = Session.getInstance();
        HashMap hashMap = new HashMap();
        hashMap.put(ParamsMap.DeviceParams.KEY_UID, session.getUID());
        hashMap.put(ParamsMap.DeviceParams.KEY_APPID, session.appKey);
        hashMap.put(ParamsMap.DeviceParams.KEY_AUTH_TOKEN, a.a());
        try {
            hashMap.put("url", URLEncoder.encode(str, "UTF-8"));
        } catch (UnsupportedEncodingException e10) {
            SourceLog.w("QRCodeController", e10);
        }
        hashMap.put("t", String.valueOf(TimeUnit.HOURS.toSeconds(session.mExpireTime)));
        hashMap.put("sdk_ver", String.valueOf(41214));
        String mapParams = HapplayUtils.getMapParams(hashMap);
        SourceLog.i("QRCodeController", "getQrAsyncHttpParameter: " + CloudAPI.sCreateShortUrl + mapParams);
        return mapParams;
    }

    private String getShortUrlParameter() {
        Session session = Session.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("a=" + session.appKey);
        sb.append("&cname=" + session.getUID());
        sb.append("&tc=" + session.serverPort);
        sb.append("&remotePort=" + session.serverPort);
        sb.append("&ip=" + HapplayUtils.getLoaclIp());
        sb.append("&ver=2.0");
        sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        sb.append(FieldUtil.getString(FieldUtil.f7332m));
        sb.append(Operator.Operation.EQUALS);
        sb.append(Session.DEFAULT_M);
        sb.append("&hid=" + session.getHID());
        return sb.toString();
    }

    private Map<String, String> getUrlParams(String str) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (String str2 : str.split(DispatchConstants.SIGN_SPLIT_SYMBOL)) {
            String[] split = str2.split(Operator.Operation.EQUALS);
            if (split.length == 2) {
                hashMap.put(split[0], split[1]);
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseLongUrl(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt(Constant.KEY_STATUS);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optInt != 200 || optJSONObject == null) {
                SourceLog.i("QRCodeController", "addQRCodeServiceInfo status not 200 or data is null");
                callbackToApp(4, null);
            } else {
                QRCodeParseCheck(optJSONObject.optString("url"), this.listener);
            }
        } catch (Exception unused) {
            SourceLog.i("QRCodeController", "addQRCodeServiceInfo not json");
            callbackToApp(5, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseQRCodeforServer(String str, IServiceInfoParseListener iServiceInfoParseListener) {
        HashMap hashMap = new HashMap();
        hashMap.put(ParamsMap.DeviceParams.KEY_APPID, Session.getInstance().appKey);
        hashMap.put(ParamsMap.DeviceParams.KEY_UID, Session.getInstance().getUID());
        hashMap.put(ParamsMap.DeviceParams.KEY_AUTH_TOKEN, a.a());
        hashMap.put("shortUrl", str);
        hashMap.put(BrowserInfo.KEY_VER, "2.0");
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sParseQRInfoUrl, HapplayUtils.getJsonParams(hashMap));
        SourceLog.i("QRCodeController", "request params=" + HapplayUtils.getJsonParams(hashMap));
        asyncHttpParameter.in.readTimeout = (int) TimeUnit.SECONDS.toMillis(2L);
        AsyncHttpParameter.In in = asyncHttpParameter.in;
        in.tryCount = 2;
        in.requestMethod = 1;
        SourceLog.i("QRCodeController", "parseQRCodeforServer url:" + CloudAPI.sParseQRInfoUrl + " params:" + HapplayUtils.getJsonParams(hashMap));
        AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.device.qr.QRCodeController.4
            @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter2) {
                if (asyncHttpParameter2.out.resultType == 2) {
                    SourceLog.i("QRCodeController", "parseQRCodeforServer cancel");
                    return;
                }
                SourceLog.debug("QRCodeController", "parseQRCodeforServer  : " + asyncHttpParameter2.out.result);
                AsyncHttpParameter.Out out = asyncHttpParameter2.out;
                if (out.resultType == 0) {
                    QRCodeController.this.parseLongUrl(out.result);
                    return;
                }
                SourceLog.w("QRCodeController", "parseQRCodeforServer  : " + asyncHttpParameter2.out.result);
                if (!TextUtils.isEmpty(asyncHttpParameter2.out.result) && asyncHttpParameter2.out.result.contains("411")) {
                    QRCodeController.this.callbackToApp(4, null);
                } else if (TextUtils.isEmpty(asyncHttpParameter2.out.result)) {
                    QRCodeController.this.callbackToApp(5, null);
                } else {
                    QRCodeController.this.callbackToApp(5, null);
                }
            }
        });
    }

    private void requestLelinkTxtInfo(final String str, final String str2, final String str3, final String str4, final String str5) {
        String httpServerUrl = CloudAPI.getHttpServerUrl(str3, str4);
        SourceLog.i("QRCodeController", "infoUlr" + httpServerUrl);
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(httpServerUrl, null);
        asyncHttpParameter.in.readTimeout = (int) TimeUnit.SECONDS.toMillis(2L);
        asyncHttpParameter.in.tryCount = 1;
        System.currentTimeMillis();
        AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.device.qr.QRCodeController.2
            @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter2) {
                AsyncHttpParameter.Out out = asyncHttpParameter2.out;
                int i10 = out.resultType;
                if (i10 == 2) {
                    SourceLog.i("QRCodeController", "requestLelinkTxtInfo cancel");
                    return;
                }
                if (i10 != 0) {
                    SourceLog.i("QRCodeController", "requestLelinkTxtInfo failed");
                    if (Feature.isDisableIM()) {
                        QRCodeController.this.callbackToApp(5, null);
                        return;
                    }
                    return;
                }
                String str6 = out.result;
                SourceLog.debug("QRCodeController", "requestLelinkTxtInfo response:" + str6);
                LelinkServiceInfo lelinkTxtInfo = LelinkServiceInfoCreator.getLelinkTxtInfo(str, str2, str3, str4, QRCodeController.this.plateForm, str6, 2);
                if (lelinkTxtInfo != null) {
                    QRCodeController.this.callbackToApp(1, lelinkTxtInfo);
                    return;
                }
                if (Feature.isDisableIM()) {
                    QRCodeController.this.callbackToApp(5, null);
                } else if (Feature.isNubiaChannel()) {
                    QRCodeController.this.callbackToApp(5, null);
                } else {
                    QRCodeController.this.callbackToApp(1, LelinkServiceInfoCreator.getQRCodeInfo(str5));
                }
            }
        });
    }

    private void requestShortUrlForServer(final String str, final IServiceInfoParseListener iServiceInfoParseListener) {
        if (!TextUtils.isEmpty(a.a())) {
            parseQRCodeforServer(str, iServiceInfoParseListener);
        } else {
            AuthSDK.getInstance().addAuthListener(new AuthListener() { // from class: com.hpplay.sdk.source.device.qr.QRCodeController.3
                @Override // com.hpplay.sdk.source.browse.api.AuthListener
                public void onAuthFailed(int i10) {
                    AuthSDK.getInstance().removeListener(this);
                }

                @Override // com.hpplay.sdk.source.browse.api.AuthListener
                public void onAuthSuccess(String str2, String str3) {
                    AuthSDK.getInstance().removeListener(this);
                    QRCodeController.this.parseQRCodeforServer(str, iServiceInfoParseListener);
                }
            });
            AuthSDK.getInstance().authSDKByInvalidToken();
        }
    }

    public void addQRCodeServiceInfo(String str, IServiceInfoParseListener iServiceInfoParseListener) {
        this.startMarkTime = System.currentTimeMillis();
        this.mConnectSession = CreateUtil.createSessionId();
        SourceDataReport.getInstance().onQRScanStart(this.mConnectSession);
        QRCodeParseCheck(str, iServiceInfoParseListener);
    }

    public void requestShortUrl(final ICreateShortUrlListener iCreateShortUrlListener) {
        if (iCreateShortUrlListener == null) {
            SourceLog.w("QRCodeController", "requestShortUrl,value is invalid");
            return;
        }
        String qrAsyncHttpParameter = getQrAsyncHttpParameter("http://hpplay.cdn.cibn.cc/release/out/weixin.html?" + getShortUrlParameter());
        final HttpEncrypt httpEncrypt = new HttpEncrypt();
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sCreateShortUrl, httpEncrypt.encode(qrAsyncHttpParameter));
        AsyncHttpParameter.In in = asyncHttpParameter.in;
        in.requestMethod = 1;
        in.requestHeaders = httpEncrypt.buildHeader();
        AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.device.qr.QRCodeController.5
            /* JADX WARN: Removed duplicated region for block: B:10:0x0042  */
            /* JADX WARN: Removed duplicated region for block: B:28:0x007b  */
            /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
            @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void onRequestResult(com.hpplay.common.asyncmanager.AsyncHttpParameter r5) {
                /*
                    r4 = this;
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r1 = "requestShortUrl onRequestResult:"
                    r0.append(r1)
                    com.hpplay.common.asyncmanager.AsyncHttpParameter$Out r1 = r5.out
                    r0.append(r1)
                    java.lang.String r0 = r0.toString()
                    java.lang.String r1 = "QRCodeController"
                    com.hpplay.sdk.source.log.SourceLog.debug(r1, r0)
                    com.hpplay.common.asyncmanager.AsyncHttpParameter$Out r5 = r5.out
                    int r0 = r5.resultType
                    r2 = 2
                    if (r0 != r2) goto L25
                    java.lang.String r5 = "requestShortUrl cancel request"
                    com.hpplay.sdk.source.log.SourceLog.w(r1, r5)
                    return
                L25:
                    java.lang.String r0 = r5.result
                    r2 = 0
                    if (r0 == 0) goto L3f
                    com.hpplay.common.utils.HttpEncrypt r0 = r2     // Catch: java.lang.Exception -> L3b
                    java.lang.String r5 = r0.decode(r5)     // Catch: java.lang.Exception -> L3b
                    com.hpplay.sdk.source.bean.ShortUrlBean r0 = new com.hpplay.sdk.source.bean.ShortUrlBean     // Catch: java.lang.Exception -> L3b
                    org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Exception -> L3b
                    r3.<init>(r5)     // Catch: java.lang.Exception -> L3b
                    r0.<init>(r3)     // Catch: java.lang.Exception -> L3b
                    goto L40
                L3b:
                    r5 = move-exception
                    com.hpplay.sdk.source.log.SourceLog.w(r1, r5)
                L3f:
                    r0 = r2
                L40:
                    if (r0 == 0) goto L77
                    int r5 = r0.status
                    r3 = 200(0xc8, float:2.8E-43)
                    if (r5 != r3) goto L65
                    com.hpplay.sdk.source.bean.ShortUrlBean$DataEntity r5 = r0.data
                    if (r5 == 0) goto L65
                    java.lang.String r5 = r5.shorturl
                    boolean r5 = android.text.TextUtils.isEmpty(r5)
                    if (r5 != 0) goto L65
                    java.lang.String r5 = "requestShortUrl callback shortUrl to caller"
                    com.hpplay.sdk.source.log.SourceLog.i(r1, r5)
                    com.hpplay.sdk.source.browse.api.ICreateShortUrlListener r5 = r3
                    if (r5 == 0) goto L77
                    com.hpplay.sdk.source.bean.ShortUrlBean$DataEntity r0 = r0.data
                    java.lang.String r0 = r0.shorturl
                    r5.onCreateShortUrl(r0)
                    return
                L65:
                    int r5 = r0.status
                    r0 = 401(0x191, float:5.62E-43)
                    if (r5 == r0) goto L6f
                    r0 = 410(0x19a, float:5.75E-43)
                    if (r5 != r0) goto L77
                L6f:
                    com.hpplay.sdk.source.business.cloud.AuthSDK r5 = com.hpplay.sdk.source.business.cloud.AuthSDK.getInstance()
                    r5.authSDKByInvalidToken()
                    return
                L77:
                    com.hpplay.sdk.source.browse.api.ICreateShortUrlListener r5 = r3
                    if (r5 == 0) goto L7e
                    r5.onCreateShortUrl(r2)
                L7e:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.device.qr.QRCodeController.AnonymousClass5.onRequestResult(com.hpplay.common.asyncmanager.AsyncHttpParameter):void");
            }
        });
    }
}
