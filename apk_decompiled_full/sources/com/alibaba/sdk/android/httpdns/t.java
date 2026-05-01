package com.alibaba.sdk.android.httpdns;

import android.text.TextUtils;
import com.google.android.gms.cast.framework.media.NotificationOptions;

/* loaded from: classes.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    private static volatile t f5963a;

    /* renamed from: h, reason: collision with root package name */
    private long f5964h = 0;

    /* renamed from: k, reason: collision with root package name */
    private boolean f5965k = true;
    private String hostName = null;

    private t() {
    }

    public static t a() {
        if (f5963a == null) {
            synchronized (t.class) {
                if (f5963a == null) {
                    f5963a = new t();
                }
            }
        }
        return f5963a;
    }

    private boolean d() {
        long currentTimeMillis = System.currentTimeMillis();
        long j10 = this.f5964h;
        if (j10 != 0 && currentTimeMillis - j10 < NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS) {
            return false;
        }
        this.f5964h = currentTimeMillis;
        return true;
    }

    public synchronized void c(boolean z10) {
        this.f5965k = z10;
    }

    public synchronized void g() {
        this.f5964h = 0L;
    }

    private void a(String str, String str2) {
        try {
            com.alibaba.sdk.android.httpdns.d.b a10 = com.alibaba.sdk.android.httpdns.d.b.a();
            if (a10 != null) {
                a10.a(str, u.a(s.SNIFF_HOST), str2);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004a A[Catch: all -> 0x005f, Exception -> 0x0061, TRY_LEAVE, TryCatch #0 {Exception -> 0x0061, blocks: (B:22:0x0003, B:4:0x0005, B:9:0x0028, B:13:0x004a, B:14:0x0010, B:17:0x0019), top: B:21:0x0003, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028 A[Catch: all -> 0x005f, Exception -> 0x0061, TryCatch #0 {Exception -> 0x0061, blocks: (B:22:0x0003, B:4:0x0005, B:9:0x0028, B:13:0x004a, B:14:0x0010, B:17:0x0019), top: B:21:0x0003, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void g(String str) {
        boolean z10;
        String str2;
        String str3;
        if (str != null) {
            try {
                this.hostName = str;
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        if (!this.f5965k) {
            str3 = "sniffer is turned off";
        } else if (!d()) {
            str3 = "sniff too often";
        } else if (TextUtils.isEmpty(this.hostName)) {
            str3 = "hostname is null";
        } else {
            z10 = true;
            str2 = null;
            if (z10) {
                i.d("launch sniffer failed due to " + str2);
            } else {
                i.d("launch a sniff task");
                String str4 = this.hostName;
                s sVar = s.SNIFF_HOST;
                q qVar = new q(str4, sVar);
                qVar.a(0);
                c.a().submit(qVar);
                a(str, u.a(sVar));
                this.hostName = null;
            }
        }
        str2 = str3;
        z10 = false;
        if (z10) {
        }
    }
}
