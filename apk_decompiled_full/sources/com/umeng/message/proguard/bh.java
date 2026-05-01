package com.umeng.message.proguard;

import android.os.SystemClock;
import com.alibaba.sdk.android.httpdns.HttpDns;
import com.alibaba.sdk.android.httpdns.HttpDnsService;
import com.umeng.message.common.UPLog;

/* loaded from: classes3.dex */
public final class bh {
    public static String a(String str, String str2) {
        String str3;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            HttpDnsService service = HttpDns.getService(y.a(), str);
            service.setExpiredIPEnabled(true);
            service.setHTTPSRequestEnabled(true);
            str3 = null;
            int i10 = 0;
            while (true) {
                try {
                    str3 = service.getIpByHostAsync(str2);
                    if (str3 != null) {
                        break;
                    }
                    Thread.sleep(500L);
                    int i11 = i10 + 1;
                    if (i11 >= 5) {
                        break;
                    }
                    i10 = i11;
                } catch (Throwable th) {
                    th = th;
                    try {
                        UPLog.i("HttpDns", "host parse error:", th.getMessage());
                        UPLog.i("HttpDns", "host:", str2, "ip:", str3, "consume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                        return str3;
                    } catch (Throwable th2) {
                        UPLog.i("HttpDns", "host:", str2, "ip:", str3, "consume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                        throw th2;
                    }
                }
            }
            UPLog.i("HttpDns", "host:", str2, "ip:", str3, "consume:", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        } catch (Throwable th3) {
            th = th3;
            str3 = null;
        }
        return str3;
    }
}
