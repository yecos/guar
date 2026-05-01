package com.hpplay.sdk.source.process;

import android.content.BroadcastReceiver;
import android.os.Handler;
import android.os.Looper;
import com.hpplay.sdk.source.business.PublicCastClient;

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
        To view partially-correct add '--show-bad-code' argument
    */
    public void onReceive(android.content.Context r7, android.content.Intent r8) {
        /*
            Method dump skipped, instructions count: 425
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.process.NetworkReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }
}
