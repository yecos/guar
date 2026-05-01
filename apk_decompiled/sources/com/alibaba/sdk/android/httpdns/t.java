package com.alibaba.sdk.android.httpdns;

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
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void g(java.lang.String r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            if (r6 == 0) goto L5
            r5.hostName = r6     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
        L5:
            boolean r0 = r5.f5965k     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            r1 = 0
            r2 = 0
            if (r0 != 0) goto L10
            java.lang.String r0 = "sniffer is turned off"
        Ld:
            r3 = r0
            r0 = 0
            goto L26
        L10:
            boolean r0 = r5.d()     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            if (r0 != 0) goto L19
            java.lang.String r0 = "sniff too often"
            goto Ld
        L19:
            java.lang.String r0 = r5.hostName     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            if (r0 == 0) goto L24
            java.lang.String r0 = "hostname is null"
            goto Ld
        L24:
            r0 = 1
            r3 = r1
        L26:
            if (r0 == 0) goto L4a
            java.lang.String r0 = "launch a sniff task"
            com.alibaba.sdk.android.httpdns.i.d(r0)     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            com.alibaba.sdk.android.httpdns.q r0 = new com.alibaba.sdk.android.httpdns.q     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            java.lang.String r3 = r5.hostName     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            com.alibaba.sdk.android.httpdns.s r4 = com.alibaba.sdk.android.httpdns.s.SNIFF_HOST     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            r0.<init>(r3, r4)     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            r0.a(r2)     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            java.util.concurrent.ExecutorService r2 = com.alibaba.sdk.android.httpdns.c.a()     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            r2.submit(r0)     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            java.lang.String r0 = com.alibaba.sdk.android.httpdns.u.a(r4)     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            r5.a(r6, r0)     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            r5.hostName = r1     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            goto L65
        L4a:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            r6.<init>()     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            java.lang.String r0 = "launch sniffer failed due to "
            r6.append(r0)     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            r6.append(r3)     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            com.alibaba.sdk.android.httpdns.i.d(r6)     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            goto L65
        L5f:
            r6 = move-exception
            goto L67
        L61:
            r6 = move-exception
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L5f
        L65:
            monitor-exit(r5)
            return
        L67:
            monitor-exit(r5)
            goto L6a
        L69:
            throw r6
        L6a:
            goto L69
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.t.g(java.lang.String):void");
    }
}
