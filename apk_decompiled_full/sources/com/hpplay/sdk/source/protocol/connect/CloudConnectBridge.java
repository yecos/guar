package com.hpplay.sdk.source.protocol.connect;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.hpplay.common.utils.DeviceUtil;
import com.hpplay.sdk.source.api.IConnectListener;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.bean.PassBean;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.business.BusinessEntity;
import com.hpplay.sdk.source.business.PlayController;
import com.hpplay.sdk.source.business.PublicCastClient;
import com.hpplay.sdk.source.business.cloud.CloudAPI;
import com.hpplay.sdk.source.business.cloud.RightsManager;
import com.hpplay.sdk.source.business.cloud.SourceDataReport;
import com.hpplay.sdk.source.c.a;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.common.store.Preference;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.pass.Pass;
import com.hpplay.sdk.source.player.GroupPlayer;
import com.hpplay.sdk.source.process.LelinkSdkManager;
import com.hpplay.sdk.source.utils.CastUtil;
import com.hpplay.sdk.source.utils.CreateUtil;
import com.taobao.accs.utl.BaseMonitor;
import java.net.URLEncoder;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class CloudConnectBridge extends AbsConnectBridge {
    public static final int CONNECT_ALLOW = 2;
    public static final int CONNECT_DEFAULT = 0;
    public static final int CONNECT_DETAIL_IN_LIST = 3;
    public static final int CONNECT_DETAIL_MANUAL = 2;
    public static final int CONNECT_DETAIL_TIMEOUT = 1;
    public static final int CONNECT_REJECT = 3;
    public static final int CONNECT_WAITING = 1;
    private static final int DELAY_CONNECT_TIME = 30000;
    private static String TAG = "CloudConnectBridge";
    private static final int WHAT_CONNECT_TIMEOUT_CHECK = 1;
    private static final int WHAT_IM_CONNECT_TIME_OUT = 100;
    private Context mContext;
    private String mFeature;
    private BrowserInfo mIMInfo;
    private LelinkServiceInfo mServiceInfo;
    private boolean isRelease = false;
    private boolean isNeedConnectSink = true;
    private boolean isReportDisconnect = false;
    private boolean isCallDisconnect = false;
    private boolean isCallbackDisconnectSuccess = false;
    private Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.hpplay.sdk.source.protocol.connect.CloudConnectBridge.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                SourceLog.w(CloudConnectBridge.TAG, "WHAT_CONNECT_TIMEOUT_CHECK");
                if (CloudConnectBridge.this.mSinkConnectListener == null) {
                    return false;
                }
                CloudConnectBridge.this.mSinkConnectListener.onDisconnect(212014);
                return false;
            }
            if (i10 != 100) {
                return false;
            }
            CloudConnectBridge cloudConnectBridge = CloudConnectBridge.this;
            IConnectListener iConnectListener = cloudConnectBridge.mAppListener;
            if (iConnectListener != null) {
                iConnectListener.onDisconnect(cloudConnectBridge.mServiceInfo, 212000, 212010);
            }
            SourceLog.i(CloudConnectBridge.TAG, "WHAT_IM_CONNECT_TIME_OUT");
            return false;
        }
    });
    private OnConnectSinkListener mSinkConnectListener = new OnConnectSinkListener() { // from class: com.hpplay.sdk.source.protocol.connect.CloudConnectBridge.2
        @Override // com.hpplay.sdk.source.protocol.connect.OnConnectSinkListener
        public void onConnect(int i10, String str) {
            String str2 = CloudConnectBridge.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onConnect ");
            sb.append(i10);
            sb.append("=========");
            sb.append(CloudConnectBridge.this.mAppListener == null);
            SourceLog.i(str2, sb.toString());
            CloudConnectBridge.this.mHandler.removeMessages(100);
            CloudConnectBridge.this.isNeedConnectSink = false;
            SourceDataReport sourceDataReport = SourceDataReport.getInstance();
            CloudConnectBridge cloudConnectBridge = CloudConnectBridge.this;
            sourceDataReport.onCloudConnectSuccess(cloudConnectBridge.mConnectSession, 4, cloudConnectBridge.mServiceInfo);
            CloudConnectBridge.this.setConnected(true);
            CloudConnectBridge cloudConnectBridge2 = CloudConnectBridge.this;
            IConnectListener iConnectListener = cloudConnectBridge2.mAppListener;
            if (iConnectListener != null) {
                iConnectListener.onConnect(cloudConnectBridge2.mServiceInfo, 4);
            }
            if (LelinkSdkManager.getInstance().mOuterRelevantInfoListener != null) {
                LelinkSdkManager.getInstance().mOuterRelevantInfoListener.onReverseInfoResult(101, str);
            }
        }

        @Override // com.hpplay.sdk.source.protocol.connect.OnConnectSinkListener
        public void onDisconnect(int i10) {
            SourceLog.i(CloudConnectBridge.TAG, "onDisconnect " + i10);
            CloudConnectBridge.this.isNeedConnectSink = false;
            CloudConnectBridge.this.setConnected(false);
            CloudConnectBridge cloudConnectBridge = CloudConnectBridge.this;
            IConnectListener iConnectListener = cloudConnectBridge.mAppListener;
            if (iConnectListener != null) {
                if (i10 == 212012) {
                    iConnectListener.onDisconnect(cloudConnectBridge.mServiceInfo, 212012, i10);
                } else {
                    iConnectListener.onDisconnect(cloudConnectBridge.mServiceInfo, 212000, i10);
                }
            }
        }
    };
    private OnConnectIMListener mServerListener = new OnConnectIMListener() { // from class: com.hpplay.sdk.source.protocol.connect.CloudConnectBridge.3
        @Override // com.hpplay.sdk.source.protocol.connect.OnConnectIMListener
        public void onConnectFailed() {
            SourceLog.i(CloudConnectBridge.TAG, "onConnectFailed im server " + CloudConnectBridge.this.isNeedConnectSink);
            if (CloudConnectBridge.this.isNeedConnectSink) {
                SourceLog.w(CloudConnectBridge.TAG, " server onConnectFailed");
                CloudConnectBridge.this.setConnected(false);
                SourceDataReport sourceDataReport = SourceDataReport.getInstance();
                CloudConnectBridge cloudConnectBridge = CloudConnectBridge.this;
                sourceDataReport.onCloudConnectFailed(cloudConnectBridge.mConnectSession, 4, cloudConnectBridge.mServiceInfo, "212010");
                CloudConnectBridge.this.isNeedConnectSink = false;
                CloudConnectBridge cloudConnectBridge2 = CloudConnectBridge.this;
                IConnectListener iConnectListener = cloudConnectBridge2.mAppListener;
                if (iConnectListener != null) {
                    iConnectListener.onDisconnect(cloudConnectBridge2.mServiceInfo, 212010, 212011);
                }
            }
        }

        @Override // com.hpplay.sdk.source.protocol.connect.OnConnectIMListener
        public void onConnectSuccess() {
            SourceLog.i(CloudConnectBridge.TAG, "onConnectSuccess im server " + CloudConnectBridge.this.isNeedConnectSink);
            if (CloudConnectBridge.this.isNeedConnectSink) {
                CloudConnectBridge.this.connect();
            }
        }
    };

    public CloudConnectBridge(Context context) {
        this.mContext = context;
    }

    private void callbackDisconnectSuccess() {
        if (this.isCallbackDisconnectSuccess) {
            return;
        }
        setConnected(false);
        this.isCallbackDisconnectSuccess = true;
        IConnectListener iConnectListener = this.mAppListener;
        if (iConnectListener == null) {
            SourceLog.w(TAG, "disconnect, invalid listener");
        } else {
            iConnectListener.onDisconnect(this.mServiceInfo, 212000, 212001);
        }
    }

    private boolean isGroupMirrorNow() {
        try {
            PlayController lastPlayController = BusinessEntity.getInstance().getLastPlayController();
            OutParameter lastPlayInfo = BusinessEntity.getInstance().getLastPlayInfo();
            if (lastPlayController == null || lastPlayController.getMediaPlayer() == null || !(lastPlayController.getMediaPlayer() instanceof GroupPlayer) || lastPlayInfo == null) {
                return false;
            }
            return TextUtils.equals(lastPlayInfo.serviceInfo.getUid(), this.mServiceInfo.getUid());
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return false;
        }
    }

    @Override // com.hpplay.sdk.source.protocol.connect.AbsConnectBridge
    public void connect(LelinkServiceInfo lelinkServiceInfo) {
        super.connect(lelinkServiceInfo);
        if (lelinkServiceInfo == null) {
            this.mIMInfo = null;
        } else {
            this.mIMInfo = CastUtil.getBrowserInfo(lelinkServiceInfo, 4);
        }
        this.mServiceInfo = lelinkServiceInfo;
        BrowserInfo browserInfo = this.mIMInfo;
        if (browserInfo != null) {
            connect(lelinkServiceInfo, browserInfo);
            return;
        }
        SourceLog.w(TAG, "connect ignore, there has no im info " + lelinkServiceInfo);
    }

    @Override // com.hpplay.sdk.source.protocol.connect.AbsConnectBridge
    public void disconnect(int i10) {
        super.disconnect(i10);
        if (this.isCallDisconnect) {
            return;
        }
        this.mHandler.removeMessages(100);
        SourceLog.i(TAG, "disconnect " + i10);
        if (i10 == 3 && isGroupMirrorNow()) {
            SourceLog.i(TAG, "group mirror ignore wifi disconnected");
            return;
        }
        this.isCallDisconnect = true;
        if (isConnected()) {
            PublicCastClient publicCastClient = PublicCastClient.getInstance();
            String str = this.mConnectSession;
            BrowserInfo browserInfo = this.mIMInfo;
            publicCastClient.disconnectTV(str, browserInfo != null ? browserInfo.getUid() : "");
            setConnected(false);
        }
        this.isNeedConnectSink = false;
        callbackDisconnectSuccess();
        if (this.isReportDisconnect) {
            return;
        }
        this.isReportDisconnect = true;
        SourceDataReport.getInstance().onCloudDisconnect(this.mConnectSession, 4, this.mServiceInfo, i10);
    }

    @Override // com.hpplay.sdk.source.protocol.connect.AbsConnectBridge
    public boolean isSupportTrack() {
        String str = this.mFeature;
        return str != null && str.length() >= 7 && this.mFeature.charAt(6) == '1';
    }

    @Override // com.hpplay.sdk.source.protocol.connect.AbsConnectBridge
    public boolean isSupportUrlList() {
        String str = this.mFeature;
        return str != null && str.length() >= 6 && this.mFeature.charAt(5) == '1';
    }

    public void reconnectServer() {
        if (!TextUtils.isEmpty(CloudAPI.sImServer)) {
            PublicCastClient.getInstance().connectServer(CloudAPI.sImServer, a.a(), this.mServerListener);
            return;
        }
        SourceLog.w(TAG, "connect ignore, invalid im url");
        SourceDataReport.getInstance().onCloudConnectFailed(this.mConnectSession, 4, this.mServiceInfo, "212010");
        IConnectListener iConnectListener = this.mAppListener;
        if (iConnectListener != null) {
            iConnectListener.onDisconnect(this.mServiceInfo, 212010, 212011);
        }
    }

    @Override // com.hpplay.sdk.source.protocol.connect.AbsConnectBridge
    public void release() {
        SourceLog.i(TAG, "release");
        if (this.isRelease) {
            return;
        }
        this.isRelease = true;
        disconnect(100);
        PublicCastClient.getInstance().removeConnectIMListener(this.mServerListener);
        this.mServerListener = null;
    }

    public void resolveConnectMsg(String str) {
        SourceLog.i(TAG, "resolveConnectMsg");
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("st");
            int optInt2 = jSONObject.optInt(DramaInfoBean.CATEGORY_STD);
            int optInt3 = jSONObject.optInt("plat");
            String optString = jSONObject.optString("sm");
            int optInt4 = jSONObject.optInt(AgooConstants.MESSAGE_TIME);
            this.mFeature = jSONObject.optString(BrowserInfo.KEY_FE);
            setSinkSM(optString);
            saveConnectBean(str);
            if (this.mIMInfo != null) {
                RightsManager.getInstance().handleNetConnectMessage(this.mIMInfo.getUid(), str);
            }
            if (optInt == 1) {
                OnConnectSinkListener onConnectSinkListener = this.mSinkConnectListener;
                if (onConnectSinkListener != null) {
                    onConnectSinkListener.onDisconnect(212012);
                }
                if (optInt4 <= 0) {
                    optInt4 = 15;
                }
                this.mHandler.removeMessages(1);
                this.mHandler.sendEmptyMessageDelayed(1, optInt4 * 1000);
                return;
            }
            if (optInt == 2) {
                this.mHandler.removeMessages(1);
                OnConnectSinkListener onConnectSinkListener2 = this.mSinkConnectListener;
                if (onConnectSinkListener2 != null) {
                    onConnectSinkListener2.onConnect(optInt3, str);
                    return;
                }
                return;
            }
            this.mHandler.removeMessages(1);
            if (optInt2 == 1) {
                OnConnectSinkListener onConnectSinkListener3 = this.mSinkConnectListener;
                if (onConnectSinkListener3 != null) {
                    onConnectSinkListener3.onDisconnect(212014);
                    return;
                }
                return;
            }
            if (optInt2 == 3) {
                OnConnectSinkListener onConnectSinkListener4 = this.mSinkConnectListener;
                if (onConnectSinkListener4 != null) {
                    onConnectSinkListener4.onDisconnect(212015);
                    return;
                }
                return;
            }
            OnConnectSinkListener onConnectSinkListener5 = this.mSinkConnectListener;
            if (onConnectSinkListener5 != null) {
                onConnectSinkListener5.onDisconnect(212013);
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    @Override // com.hpplay.sdk.source.protocol.connect.AbsConnectBridge
    public synchronized void sendPassData(int i10, String str, String str2) {
        boolean z10;
        try {
            String str3 = Pass.PLACEHOLDER_START + str + Pass.PLACEHOLDER_END + Pass.PLACEHOLDER_START + str2 + Pass.PLACEHOLDER_END;
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(0, str3);
            z10 = PublicCastClient.getInstance().sendPass(this.mServiceInfo.getUid(), jSONArray.toString());
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            z10 = false;
        }
        PassBean passBean = new PassBean();
        passBean.action = 1;
        try {
            passBean.action = new JSONObject(str2).optInt("regist", passBean.action);
        } catch (Exception e11) {
            SourceLog.w(TAG, e11);
        }
        passBean.result = z10 ? 1 : 0;
        passBean.cmd = i10;
        callbackPass(passBean);
    }

    private void connect(LelinkServiceInfo lelinkServiceInfo, BrowserInfo browserInfo) {
        SourceLog.i(TAG, BaseMonitor.ALARM_POINT_CONNECT);
        this.mConnectSession = CreateUtil.createSessionId();
        this.isReportDisconnect = false;
        this.isCallDisconnect = false;
        this.isCallbackDisconnectSuccess = false;
        this.isNeedConnectSink = true;
        if (browserInfo == null) {
            this.isNeedConnectSink = false;
        } else {
            this.mConnectBrowserInfo = browserInfo;
            SourceDataReport.getInstance().onCloudConnect(this.mConnectSession, 4, this.mServiceInfo);
        }
        if (PublicCastClient.getInstance().isConnectedServer()) {
            connect();
        } else {
            reconnectServer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connect() {
        this.isNeedConnectSink = true;
        SourceLog.i(TAG, "connect 2");
        this.mFeature = null;
        String str = this.mIMInfo.getExtras().get("phone");
        if (!TextUtils.isEmpty(str) && str.equals("1")) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.hpplay.sdk.source.protocol.connect.CloudConnectBridge.4
                @Override // java.lang.Runnable
                public void run() {
                    CloudConnectBridge cloudConnectBridge = CloudConnectBridge.this;
                    IConnectListener iConnectListener = cloudConnectBridge.mAppListener;
                    if (iConnectListener != null) {
                        iConnectListener.onConnect(cloudConnectBridge.mServiceInfo, 4);
                    }
                    if (LelinkSdkManager.getInstance().mOuterRelevantInfoListener != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("plat", 107);
                            LelinkSdkManager.getInstance().mOuterRelevantInfoListener.onReverseInfoResult(101, jSONObject.toString());
                        } catch (Exception e10) {
                            SourceLog.w(CloudConnectBridge.TAG, e10);
                        }
                    }
                }
            }, 300L);
            return;
        }
        String str2 = "";
        try {
            String str3 = Preference.getInstance().get(Constant.KEY_USERNAME);
            if (TextUtils.isEmpty(str3)) {
                str2 = URLEncoder.encode(DeviceUtil.getBluetoothName());
            } else {
                str2 = URLEncoder.encode(str3);
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        PublicCastClient.getInstance().connectTV(this.mIMInfo, str2, "", this.mConnectSession, this.mSinkConnectListener, this);
        this.mHandler.removeMessages(100);
        Handler handler = this.mHandler;
        handler.sendMessageDelayed(handler.obtainMessage(100), NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS);
    }
}
