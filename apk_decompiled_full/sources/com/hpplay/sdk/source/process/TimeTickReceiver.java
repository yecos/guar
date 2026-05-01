package com.hpplay.sdk.source.process;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.hpplay.sdk.source.business.cloud.AuthSDK;
import com.hpplay.sdk.source.c.a;
import com.hpplay.sdk.source.log.SourceLog;

/* loaded from: classes3.dex */
class TimeTickReceiver extends BroadcastReceiver {
    private static final String TAG = "TimeTickReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.TIME_TICK".equals(intent.getAction())) {
            try {
                long j10 = LelinkSdkManager.getInstance().mAuthSuccessTime;
                long currentTimeMillis = System.currentTimeMillis();
                if (j10 > 0) {
                    if (currentTimeMillis - j10 >= Math.max(1, LelinkSdkManager.getInstance().mExpireTime - 1) * 60 * 60 * 500 || TextUtils.isEmpty(a.a())) {
                        SourceLog.i(TAG, "TimeTickReceiver start auth again");
                        AuthSDK.getInstance().authSDK();
                    }
                }
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
        }
    }
}
