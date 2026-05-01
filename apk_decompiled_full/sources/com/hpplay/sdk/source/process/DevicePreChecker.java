package com.hpplay.sdk.source.process;

import android.content.Context;
import com.hpplay.common.utils.NetworkUtil;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.utils.HpplayUtil;
import com.hpplay.sdk.source.utils.KeepAliveUtitls;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes3.dex */
public class DevicePreChecker extends Thread {
    public static final int ALL_ONLINE = 1;
    public static final int OFFLINE = 0;
    public static final int ONLY_ONE_ONLINE = 2;
    private static final String TAG = "DevicePreChecker";
    private long mCheckStartTime;
    private Context mContext;
    private final LinkedBlockingQueue<LelinkServiceInfo> mServiceInfos = new LinkedBlockingQueue<>();
    private final ConcurrentHashMap<String, OnDevicePreCheckResultCallback> mResultMap = new ConcurrentHashMap<>();
    private boolean isRunning = false;

    public interface OnDevicePreCheckResultCallback {
        void onResult(LelinkServiceInfo lelinkServiceInfo, int i10);
    }

    public DevicePreChecker(Context context) {
        this.mContext = context;
    }

    private void callback(LelinkServiceInfo lelinkServiceInfo, int i10) {
        try {
            SourceLog.i(TAG, "=============> callback use time  " + (System.currentTimeMillis() - this.mCheckStartTime) + " state " + i10);
            String lelinkServiceKey = getLelinkServiceKey(lelinkServiceInfo);
            OnDevicePreCheckResultCallback onDevicePreCheckResultCallback = this.mResultMap.get(lelinkServiceKey);
            if (onDevicePreCheckResultCallback != null) {
                onDevicePreCheckResultCallback.onResult(lelinkServiceInfo, i10);
                this.mResultMap.remove(lelinkServiceKey);
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    private boolean checkIM(BrowserInfo browserInfo) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(browserInfo);
        String httpPostCheckTvState = KeepAliveUtitls.httpPostCheckTvState(arrayList);
        if (httpPostCheckTvState != null) {
            return httpPostCheckTvState.contains("state:true");
        }
        return false;
    }

    public static String getLelinkServiceKey(LelinkServiceInfo lelinkServiceInfo) {
        return lelinkServiceInfo.getName() + lelinkServiceInfo.getIp();
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public void release() {
        this.isRunning = false;
        interrupt();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a2 A[SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        BrowserInfo browserInfo;
        BrowserInfo browserInfo2;
        boolean tcpCheckTvState;
        int i10;
        super.run();
        this.isRunning = true;
        while (this.isRunning) {
            try {
                LelinkServiceInfo take = this.mServiceInfos.take();
                if (take == null) {
                    break;
                }
                this.mCheckStartTime = System.currentTimeMillis();
                BrowserInfo browserInfo3 = null;
                try {
                    browserInfo = take.getBrowserInfos().get(1);
                    try {
                        browserInfo2 = take.getBrowserInfos().get(3);
                    } catch (Exception e10) {
                        e = e10;
                        browserInfo2 = null;
                    }
                    try {
                        browserInfo3 = take.getBrowserInfos().get(4);
                    } catch (Exception e11) {
                        e = e11;
                        SourceLog.w(TAG, e);
                        if (browserInfo != null) {
                        }
                        if (browserInfo == null) {
                        }
                        callback(take, !tcpCheckTvState ? 1 : 0);
                    }
                } catch (Exception e12) {
                    e = e12;
                    browserInfo = null;
                    browserInfo2 = null;
                }
                if (browserInfo != null || browserInfo3 == null) {
                    if (browserInfo == null) {
                        tcpCheckTvState = KeepAliveUtitls.tcpCheckTvState(browserInfo.getName(), browserInfo.getIp(), browserInfo.getPort());
                    } else if (browserInfo2 != null) {
                        tcpCheckTvState = KeepAliveUtitls.tcpCheckTvState(browserInfo2.getName(), browserInfo2.getIp(), browserInfo2.getPort());
                    } else if (browserInfo3 != null) {
                        tcpCheckTvState = checkIM(browserInfo3);
                    } else {
                        callback(take, 0);
                    }
                    callback(take, !tcpCheckTvState ? 1 : 0);
                } else {
                    if (!NetworkUtil.isWifiConnected(this.mContext) && !HpplayUtil.isWifiApOpen(this.mContext)) {
                        BrowserInfo browserInfo4 = take.getBrowserInfos().get(4);
                        if (browserInfo4 == null || checkIM(browserInfo4)) {
                            i10 = 0;
                        } else {
                            take.getBrowserInfos().remove(3);
                            take.getBrowserInfos().remove(1);
                            i10 = 2;
                        }
                        callback(take, i10);
                    }
                    i10 = 1;
                    callback(take, i10);
                }
            } catch (Exception e13) {
                SourceLog.w(TAG, e13);
            }
        }
        this.isRunning = false;
    }

    public void setOnDevicePreCheckResult(LelinkServiceInfo lelinkServiceInfo, OnDevicePreCheckResultCallback onDevicePreCheckResultCallback) {
        String lelinkServiceKey = getLelinkServiceKey(lelinkServiceInfo);
        this.mServiceInfos.add(lelinkServiceInfo);
        this.mResultMap.put(lelinkServiceKey, onDevicePreCheckResultCallback);
    }
}
