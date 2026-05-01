package com.alibaba.sdk.android.httpdns;

import android.util.Log;
import java.lang.Thread;

/* loaded from: classes.dex */
public class k implements Thread.UncaughtExceptionHandler {
    private void b(Throwable th) {
        com.alibaba.sdk.android.httpdns.d.b a10 = com.alibaba.sdk.android.httpdns.d.b.a();
        if (a10 != null) {
            a10.k(th.getMessage());
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            Log.e("HttpDnsSDK", "Catch an uncaught exception, " + thread.getName() + ", error message: " + th.getMessage());
            b(th);
            th.printStackTrace();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
