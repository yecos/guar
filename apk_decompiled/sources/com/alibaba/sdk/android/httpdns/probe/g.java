package com.alibaba.sdk.android.httpdns.probe;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes.dex */
class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private CountDownLatch f5948a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, Long> f5949b;

    /* renamed from: o, reason: collision with root package name */
    private String f5950o;
    private int port;

    public g(String str, int i10, CountDownLatch countDownLatch, ConcurrentHashMap<String, Long> concurrentHashMap) {
        this.f5950o = str;
        this.port = i10;
        this.f5948a = countDownLatch;
        this.f5949b = concurrentHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x007c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private long a(java.lang.String r8, int r9) {
        /*
            r7 = this;
            java.lang.String r0 = "socket close failed:"
            long r1 = java.lang.System.currentTimeMillis()
            r3 = 0
            r4 = 2147483647(0x7fffffff, double:1.060997895E-314)
            java.net.Socket r6 = new java.net.Socket     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
            r6.<init>()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
            java.net.InetSocketAddress r3 = new java.net.InetSocketAddress     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3c
            r3.<init>(r8, r9)     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3c
            r8 = 5000(0x1388, float:7.006E-42)
            r6.connect(r3, r8)     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3c
            long r8 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3c
            r6.close()     // Catch: java.io.IOException -> L21
            goto L78
        L21:
            r3 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r0)
            java.lang.String r0 = r3.toString()
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            com.alibaba.sdk.android.httpdns.i.f(r0)
            goto L78
        L39:
            r8 = move-exception
            r3 = r6
            goto L7f
        L3c:
            r8 = move-exception
            r3 = r6
            goto L42
        L3f:
            r8 = move-exception
            goto L7f
        L41:
            r8 = move-exception
        L42:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3f
            r9.<init>()     // Catch: java.lang.Throwable -> L3f
            java.lang.String r6 = "connect failed:"
            r9.append(r6)     // Catch: java.lang.Throwable -> L3f
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L3f
            r9.append(r8)     // Catch: java.lang.Throwable -> L3f
            java.lang.String r8 = r9.toString()     // Catch: java.lang.Throwable -> L3f
            com.alibaba.sdk.android.httpdns.i.f(r8)     // Catch: java.lang.Throwable -> L3f
            if (r3 == 0) goto L77
            r3.close()     // Catch: java.io.IOException -> L60
            goto L77
        L60:
            r8 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r0)
            java.lang.String r8 = r8.toString()
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            com.alibaba.sdk.android.httpdns.i.f(r8)
        L77:
            r8 = r4
        L78:
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 != 0) goto L7d
            return r4
        L7d:
            long r8 = r8 - r1
            return r8
        L7f:
            if (r3 == 0) goto L9c
            r3.close()     // Catch: java.io.IOException -> L85
            goto L9c
        L85:
            r9 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r9 = r9.toString()
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            com.alibaba.sdk.android.httpdns.i.f(r9)
        L9c:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.probe.g.a(java.lang.String, int):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004a A[Catch: Exception -> 0x004e, TRY_LEAVE, TryCatch #0 {Exception -> 0x004e, blocks: (B:2:0x0000, B:4:0x0004, B:7:0x000d, B:9:0x0037, B:10:0x0046, B:12:0x004a, B:17:0x0041), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            r4 = this;
            java.lang.String r0 = r4.f5950o     // Catch: java.lang.Exception -> L4e
            if (r0 == 0) goto L41
            int r0 = r4.port     // Catch: java.lang.Exception -> L4e
            boolean r0 = r4.a(r0)     // Catch: java.lang.Exception -> L4e
            if (r0 != 0) goto Ld
            goto L41
        Ld:
            java.lang.String r0 = r4.f5950o     // Catch: java.lang.Exception -> L4e
            int r1 = r4.port     // Catch: java.lang.Exception -> L4e
            long r0 = r4.a(r0, r1)     // Catch: java.lang.Exception -> L4e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L4e
            r2.<init>()     // Catch: java.lang.Exception -> L4e
            java.lang.String r3 = "connect cost for ip:"
            r2.append(r3)     // Catch: java.lang.Exception -> L4e
            java.lang.String r3 = r4.f5950o     // Catch: java.lang.Exception -> L4e
            r2.append(r3)     // Catch: java.lang.Exception -> L4e
            java.lang.String r3 = " is "
            r2.append(r3)     // Catch: java.lang.Exception -> L4e
            r2.append(r0)     // Catch: java.lang.Exception -> L4e
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L4e
            com.alibaba.sdk.android.httpdns.i.d(r2)     // Catch: java.lang.Exception -> L4e
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> r2 = r4.f5949b     // Catch: java.lang.Exception -> L4e
            if (r2 == 0) goto L46
            java.lang.String r3 = r4.f5950o     // Catch: java.lang.Exception -> L4e
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch: java.lang.Exception -> L4e
            r2.put(r3, r0)     // Catch: java.lang.Exception -> L4e
            goto L46
        L41:
            java.lang.String r0 = "invalid params, give up"
            com.alibaba.sdk.android.httpdns.i.f(r0)     // Catch: java.lang.Exception -> L4e
        L46:
            java.util.concurrent.CountDownLatch r0 = r4.f5948a     // Catch: java.lang.Exception -> L4e
            if (r0 == 0) goto L52
            r0.countDown()     // Catch: java.lang.Exception -> L4e
            goto L52
        L4e:
            r0 = move-exception
            r0.printStackTrace()
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.probe.g.run():void");
    }

    private boolean a(int i10) {
        return i10 >= 1 && i10 <= 65535;
    }
}
