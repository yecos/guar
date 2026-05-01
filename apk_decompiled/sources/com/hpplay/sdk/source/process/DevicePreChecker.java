package com.hpplay.sdk.source.process;

import android.content.Context;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.log.SourceLog;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            r12 = this;
            java.lang.String r0 = "DevicePreChecker"
            super.run()
            r1 = 1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            r12.isRunning = r1
        Lc:
            boolean r3 = r12.isRunning
            r4 = 0
            if (r3 == 0) goto Ldf
            java.util.concurrent.LinkedBlockingQueue<com.hpplay.sdk.source.browse.api.LelinkServiceInfo> r3 = r12.mServiceInfos     // Catch: java.lang.Exception -> Ldb
            java.lang.Object r3 = r3.take()     // Catch: java.lang.Exception -> Ldb
            com.hpplay.sdk.source.browse.api.LelinkServiceInfo r3 = (com.hpplay.sdk.source.browse.api.LelinkServiceInfo) r3     // Catch: java.lang.Exception -> Ldb
            if (r3 != 0) goto L1d
            goto Ldf
        L1d:
            long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> Ldb
            r12.mCheckStartTime = r5     // Catch: java.lang.Exception -> Ldb
            r5 = 4
            r6 = 3
            r7 = 0
            java.util.Map r8 = r3.getBrowserInfos()     // Catch: java.lang.Exception -> L53
            java.lang.Object r8 = r8.get(r2)     // Catch: java.lang.Exception -> L53
            com.hpplay.sdk.source.browse.data.BrowserInfo r8 = (com.hpplay.sdk.source.browse.data.BrowserInfo) r8     // Catch: java.lang.Exception -> L53
            java.util.Map r9 = r3.getBrowserInfos()     // Catch: java.lang.Exception -> L50
            java.lang.Integer r10 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Exception -> L50
            java.lang.Object r9 = r9.get(r10)     // Catch: java.lang.Exception -> L50
            com.hpplay.sdk.source.browse.data.BrowserInfo r9 = (com.hpplay.sdk.source.browse.data.BrowserInfo) r9     // Catch: java.lang.Exception -> L50
            java.util.Map r10 = r3.getBrowserInfos()     // Catch: java.lang.Exception -> L4e
            java.lang.Integer r11 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Exception -> L4e
            java.lang.Object r10 = r10.get(r11)     // Catch: java.lang.Exception -> L4e
            com.hpplay.sdk.source.browse.data.BrowserInfo r10 = (com.hpplay.sdk.source.browse.data.BrowserInfo) r10     // Catch: java.lang.Exception -> L4e
            r7 = r10
            goto L59
        L4e:
            r10 = move-exception
            goto L56
        L50:
            r10 = move-exception
            r9 = r7
            goto L56
        L53:
            r10 = move-exception
            r8 = r7
            r9 = r8
        L56:
            com.hpplay.sdk.source.log.SourceLog.w(r0, r10)     // Catch: java.lang.Exception -> Ldb
        L59:
            if (r8 == 0) goto La0
            if (r7 == 0) goto La0
            android.content.Context r7 = r12.mContext     // Catch: java.lang.Exception -> Ldb
            boolean r7 = com.hpplay.common.utils.NetworkUtil.isWifiConnected(r7)     // Catch: java.lang.Exception -> Ldb
            if (r7 != 0) goto L9a
            android.content.Context r7 = r12.mContext     // Catch: java.lang.Exception -> Ldb
            boolean r7 = com.hpplay.sdk.source.utils.HpplayUtil.isWifiApOpen(r7)     // Catch: java.lang.Exception -> Ldb
            if (r7 == 0) goto L6e
            goto L9a
        L6e:
            java.util.Map r7 = r3.getBrowserInfos()     // Catch: java.lang.Exception -> Ldb
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Exception -> Ldb
            java.lang.Object r5 = r7.get(r5)     // Catch: java.lang.Exception -> Ldb
            com.hpplay.sdk.source.browse.data.BrowserInfo r5 = (com.hpplay.sdk.source.browse.data.BrowserInfo) r5     // Catch: java.lang.Exception -> Ldb
            if (r5 == 0) goto L98
            boolean r5 = r12.checkIM(r5)     // Catch: java.lang.Exception -> Ldb
            if (r5 != 0) goto L98
            java.util.Map r5 = r3.getBrowserInfos()     // Catch: java.lang.Exception -> Ldb
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Exception -> Ldb
            r5.remove(r6)     // Catch: java.lang.Exception -> Ldb
            java.util.Map r5 = r3.getBrowserInfos()     // Catch: java.lang.Exception -> Ldb
            r5.remove(r2)     // Catch: java.lang.Exception -> Ldb
            r5 = 2
            goto L9b
        L98:
            r5 = 0
            goto L9b
        L9a:
            r5 = 1
        L9b:
            r12.callback(r3, r5)     // Catch: java.lang.Exception -> Ldb
            goto Lc
        La0:
            if (r8 == 0) goto Lb3
            java.lang.String r5 = r8.getName()     // Catch: java.lang.Exception -> Ldb
            java.lang.String r6 = r8.getIp()     // Catch: java.lang.Exception -> Ldb
            int r7 = r8.getPort()     // Catch: java.lang.Exception -> Ldb
            boolean r5 = com.hpplay.sdk.source.utils.KeepAliveUtitls.tcpCheckTvState(r5, r6, r7)     // Catch: java.lang.Exception -> Ldb
            goto Lcc
        Lb3:
            if (r9 == 0) goto Lc6
            java.lang.String r5 = r9.getName()     // Catch: java.lang.Exception -> Ldb
            java.lang.String r6 = r9.getIp()     // Catch: java.lang.Exception -> Ldb
            int r7 = r9.getPort()     // Catch: java.lang.Exception -> Ldb
            boolean r5 = com.hpplay.sdk.source.utils.KeepAliveUtitls.tcpCheckTvState(r5, r6, r7)     // Catch: java.lang.Exception -> Ldb
            goto Lcc
        Lc6:
            if (r7 == 0) goto Ld6
            boolean r5 = r12.checkIM(r7)     // Catch: java.lang.Exception -> Ldb
        Lcc:
            if (r5 == 0) goto Ld0
            r5 = 1
            goto Ld1
        Ld0:
            r5 = 0
        Ld1:
            r12.callback(r3, r5)     // Catch: java.lang.Exception -> Ldb
            goto Lc
        Ld6:
            r12.callback(r3, r4)     // Catch: java.lang.Exception -> Ldb
            goto Lc
        Ldb:
            r1 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w(r0, r1)
        Ldf:
            r12.isRunning = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.process.DevicePreChecker.run():void");
    }

    public void setOnDevicePreCheckResult(LelinkServiceInfo lelinkServiceInfo, OnDevicePreCheckResultCallback onDevicePreCheckResultCallback) {
        String lelinkServiceKey = getLelinkServiceKey(lelinkServiceInfo);
        this.mServiceInfos.add(lelinkServiceInfo);
        this.mResultMap.put(lelinkServiceKey, onDevicePreCheckResultCallback);
    }
}
