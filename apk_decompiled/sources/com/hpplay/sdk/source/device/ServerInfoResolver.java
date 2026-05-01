package com.hpplay.sdk.source.device;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncHttpRequestListener;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.sdk.source.browse.api.IServiceInfoParseListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.browse.data.LelinkServiceInfoCreator;
import com.hpplay.sdk.source.business.cloud.CloudAPI;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.utils.CastUtil;
import com.hpplay.sdk.source.utils.Feature;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ServerInfoResolver {
    private static final int DELAY_CALLBACK_IM = 500;
    private static final String TAG = "ServerInfoResolver";
    private static final int WHAT_CALLBACK_IM = 1;
    private Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.hpplay.sdk.source.device.ServerInfoResolver.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            Object obj;
            if (message.what != 1 || (obj = message.obj) == null) {
                return false;
            }
            ServerInfoResolver.this.callbackIMFirst((LelinkServiceInfo) obj);
            return false;
        }
    });
    private IServiceInfoParseListener mServiceInfoParseListener;

    public static class SinkServerBean {
        public String appID;
        public String dsn;
        public String ip;
        public String name;
        public String port;
        public String pt;
        public String tunnels;
        public String uid;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackIMFirst(LelinkServiceInfo lelinkServiceInfo) {
        if (lelinkServiceInfo == null) {
            return;
        }
        SourceLog.w(TAG, "callbackIMFirst");
        try {
            if (lelinkServiceInfo.getBrowserInfos().size() > 1 && lelinkServiceInfo.getBrowserInfos().containsKey(4)) {
                lelinkServiceInfo.getBrowserInfos().remove(1);
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        if (CastUtil.isSupportIM(lelinkServiceInfo)) {
            BrowserInfo browserInfo = CastUtil.getBrowserInfo(lelinkServiceInfo, 4);
            if (browserInfo != null) {
                browserInfo.setOnLine(true);
            }
            notifyParseResult(1, lelinkServiceInfo);
        }
    }

    private void delayCallbackIM(LelinkServiceInfo lelinkServiceInfo) {
        if (Feature.isDisableIM()) {
            return;
        }
        this.mHandler.removeMessages(1);
        Handler handler = this.mHandler;
        handler.sendMessageDelayed(handler.obtainMessage(1, lelinkServiceInfo), 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyParseResult(int i10, LelinkServiceInfo lelinkServiceInfo) {
        this.mHandler.removeMessages(1);
        SourceLog.i(TAG, "notifyParseResult " + this.mServiceInfoParseListener + Operator.Operation.DIVISION + lelinkServiceInfo);
        IServiceInfoParseListener iServiceInfoParseListener = this.mServiceInfoParseListener;
        if (iServiceInfoParseListener != null) {
            iServiceInfoParseListener.onParseResult(i10, lelinkServiceInfo);
        }
    }

    private void requestLelinkTxtInfo(final String str, int i10) {
        if (TextUtils.isEmpty(str) || i10 <= 0) {
            SourceLog.w(TAG, "requestLelinkTxtInfo ignore," + str + Operator.Operation.DIVISION + i10);
            return;
        }
        SourceLog.w(TAG, "requestLelinkTxtInfo");
        AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.getHttpServerUrl(str, i10 + ""), null);
        asyncHttpParameter.in.readTimeout = (int) TimeUnit.SECONDS.toMillis(5L);
        asyncHttpParameter.in.tryCount = 1;
        AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() { // from class: com.hpplay.sdk.source.device.ServerInfoResolver.2
            @Override // com.hpplay.common.asyncmanager.AsyncHttpRequestListener
            public void onRequestResult(AsyncHttpParameter asyncHttpParameter2) {
                AsyncHttpParameter.Out out = asyncHttpParameter2.out;
                int i11 = out.resultType;
                if (i11 == 2) {
                    SourceLog.i(ServerInfoResolver.TAG, "requestLelinkTxtInfo cancel");
                    return;
                }
                if (i11 == 0) {
                    try {
                        JSONObject jSONObject = new JSONObject(out.result);
                        String optString = jSONObject.optString("serviceName");
                        JSONObject optJSONObject = jSONObject.optJSONObject("leLinkTxt");
                        if (optJSONObject != null) {
                            HashMap hashMap = new HashMap();
                            Iterator<String> keys = optJSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                hashMap.put(next, optJSONObject.optString(next));
                                SourceLog.i(ServerInfoResolver.TAG, "key  : " + next);
                            }
                            LelinkServiceInfo lelinkServiceInfo = new LelinkServiceInfo(1, ServerInfoResolver.this.resolveServiceInfo(optString, str, hashMap));
                            BrowserInfo browserInfo = CastUtil.getBrowserInfo(lelinkServiceInfo, 4);
                            if (browserInfo != null) {
                                browserInfo.setOnLine(true);
                            }
                            ServerInfoResolver.this.notifyParseResult(1, lelinkServiceInfo);
                            return;
                        }
                    } catch (Exception e10) {
                        SourceLog.w(ServerInfoResolver.TAG, e10);
                    }
                }
                SourceLog.i(ServerInfoResolver.TAG, "requestLelinkTxtInfo failed");
                if (Feature.isDisableIM()) {
                    ServerInfoResolver.this.notifyParseResult(0, null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BrowserInfo resolveServiceInfo(String str, String str2, Map<String, String> map) {
        String str3 = map.get("vv");
        SourceLog.i(TAG, "resolveServiceInfo vv:" + str3);
        if (TextUtils.isEmpty(str3) || !"2".equals(str3)) {
            return null;
        }
        BrowserInfo browserInfo = new BrowserInfo(1, 1);
        browserInfo.setName(str);
        browserInfo.setIp(str2);
        browserInfo.setLocalWifi(true);
        browserInfo.setOnLine(true);
        String str4 = map.get("u");
        if (!TextUtils.isEmpty(str4)) {
            browserInfo.setUid(str4);
        }
        String str5 = map.get("lelinkport");
        if (!TextUtils.isEmpty(str5)) {
            try {
                browserInfo.setPort(Integer.parseInt(str5));
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
        }
        HashMap hashMap = new HashMap();
        for (String str6 : map.keySet()) {
            hashMap.put(str6, map.get(str6));
        }
        browserInfo.setExtras(hashMap);
        return browserInfo;
    }

    public void parserServerInfo(SinkServerBean sinkServerBean, IServiceInfoParseListener iServiceInfoParseListener) {
        this.mServiceInfoParseListener = iServiceInfoParseListener;
        SourceLog.w(TAG, "parserServerInfo");
        int i10 = 0;
        if (sinkServerBean == null) {
            notifyParseResult(0, null);
            return;
        }
        try {
            if (!TextUtils.isEmpty(sinkServerBean.port)) {
                i10 = Integer.parseInt(sinkServerBean.port);
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        if (TextUtils.isEmpty(sinkServerBean.ip) || i10 <= 0) {
            notifyParseResult(9, null);
        } else {
            delayCallbackIM(LelinkServiceInfoCreator.createIMServiceByUID(sinkServerBean.appID, sinkServerBean.uid, sinkServerBean.name, sinkServerBean.pt, sinkServerBean.tunnels, 1));
            requestLelinkTxtInfo(sinkServerBean.ip, i10);
        }
    }
}
