package com.hpplay.sdk.source.process;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import com.hpplay.common.utils.NetworkUtil;
import com.hpplay.common.utils.WifiInfoCache;
import com.hpplay.component.common.utils.DeviceProperties;
import com.hpplay.sdk.source.business.BusinessEntity;
import com.hpplay.sdk.source.business.PublicCastClient;
import com.hpplay.sdk.source.business.cloud.AuthSDK;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.protocol.browser.BrowserBridge;
import com.umeng.message.api.UPushThirdTokenCallback;

/* loaded from: classes3.dex */
public class NetworkReceiver extends BroadcastReceiver {
    private static final String TAG = "NetworkReceiver";
    private boolean isConnected;
    private boolean firstNetworkChange = true;
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());

    private void reconnectIM() {
        PublicCastClient.getInstance().disconnectServer();
        PublicCastClient.getInstance().reconnect();
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x0180, code lost:
    
        if (android.net.NetworkInfo.State.CONNECTED != r8.getState()) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0186, code lost:
    
        if (r8.isAvailable() == false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x018e, code lost:
    
        if (com.hpplay.sdk.source.common.store.Session.getInstance().isAuthSuccess != false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0190, code lost:
    
        com.hpplay.sdk.source.business.cloud.AuthSDK.getInstance().authSDK();
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0197, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:?, code lost:
    
        return;
     */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Context context, Intent intent) {
        if (AuthSDK.getInstance().getAuthCode() == 402 || AuthSDK.getInstance().getAuthCode() == -101) {
            return;
        }
        String action = intent.getAction();
        SourceLog.i(TAG, "onReceive: action := " + action);
        try {
            if (!"android.net.wifi.STATE_CHANGE".equalsIgnoreCase(action)) {
                if (!"android.net.conn.CONNECTIVITY_CHANGE".equalsIgnoreCase(action)) {
                    if ("android.intent.action.SCREEN_ON".equals(action)) {
                        reconnectIM();
                        return;
                    }
                    return;
                }
                NetworkUtil.NetworkType networkType = NetworkUtil.getNetworkType(context);
                SourceLog.i(TAG, "networkType:" + networkType);
                NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                if (networkInfo != null && networkInfo.getType() == 0) {
                    if (NetworkInfo.State.CONNECTED != networkInfo.getState() || !networkInfo.isAvailable()) {
                        if (NetworkUtil.NetworkType.NETWORK_WIFI.equals(networkType)) {
                            return;
                        }
                        if (this.firstNetworkChange) {
                            SourceLog.i(TAG, "firstNetworkChange in NetworkAndTimeChangeReceiver");
                            this.firstNetworkChange = false;
                            return;
                        } else {
                            SourceLog.i(TAG, "mobile is close");
                            LelinkSdkManager.getInstance().clearBrowserList();
                            return;
                        }
                    }
                    if (!Session.getInstance().isAuthSuccess) {
                        AuthSDK.getInstance().authSDK();
                    }
                    if (this.firstNetworkChange) {
                        SourceLog.i(TAG, "firstNetworkChange in NetworkAndTimeChangeReceiver");
                        this.firstNetworkChange = false;
                        return;
                    } else {
                        SourceLog.i(TAG, "mobile is open");
                        reconnectIM();
                        LelinkSdkManager.getInstance().clearBrowserList();
                        return;
                    }
                }
                return;
            }
            WifiInfoCache.clearCache();
            NetworkInfo networkInfo2 = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            intent.getStringExtra("bssid");
            if (networkInfo2 == null) {
                return;
            }
            boolean isConnected = networkInfo2.isConnected();
            NetworkInfo.State state = networkInfo2.getState();
            SourceLog.i(TAG, "wifi connect  " + isConnected + " " + state);
            if (state == NetworkInfo.State.CONNECTED) {
                if (isConnected) {
                    this.isConnected = true;
                    if (!Session.getInstance().isAuthSuccess && !Session.getInstance().isFirstBoot) {
                        AuthSDK.getInstance().authSDK();
                    }
                    if (this.firstNetworkChange) {
                        SourceLog.i(TAG, "firstNetworkChange in NetworkAndTimeChangeReceiver");
                        this.firstNetworkChange = false;
                        return;
                    } else {
                        LelinkSdkManager.getInstance().clearBrowserList();
                        this.mMainHandler.removeCallbacksAndMessages(null);
                        this.mMainHandler.postDelayed(new Runnable() { // from class: com.hpplay.sdk.source.process.NetworkReceiver.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (!new StringBuilder(DeviceProperties.getManufacturer().toLowerCase()).reverse().toString().equals("iewauh") || !DeviceProperties.getManufacturer().toLowerCase().equals(UPushThirdTokenCallback.TYPE_HONOR)) {
                                    LelinkSdkManager.getInstance().startBrowseThread();
                                }
                                BusinessEntity.getInstance().onWifiConnected();
                            }
                        }, 500L);
                        return;
                    }
                }
                return;
            }
            if (state == NetworkInfo.State.DISCONNECTED) {
                SourceLog.i(TAG, "f+++++++++++++++++DISCONNECTED+++++++++++++++++r");
                if (this.isConnected && !isConnected) {
                    this.isConnected = false;
                    if (this.firstNetworkChange) {
                        SourceLog.i(TAG, "firstNetworkChange in NetworkAndTimeChangeReceiver");
                        this.firstNetworkChange = false;
                        return;
                    } else {
                        this.mMainHandler.removeCallbacksAndMessages(null);
                        LelinkSdkManager.getInstance().clearBrowserList();
                        BrowserBridge.getInstance().onNetDisconnect(4);
                    }
                }
                ConnectManager.getInstance().onNetDisconnect();
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }
}
