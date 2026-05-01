package com.alibaba.sdk.android.httpdns.e;

import java.util.Random;

/* loaded from: classes.dex */
public class a {

    /* renamed from: t, reason: collision with root package name */
    private String f5899t;

    /* renamed from: com.alibaba.sdk.android.httpdns.e.a$a, reason: collision with other inner class name */
    public static final class C0087a {

        /* renamed from: a, reason: collision with root package name */
        private static final a f5900a = new a();
    }

    private a() {
        try {
            Random random = new Random();
            char[] cArr = new char[12];
            for (int i10 = 0; i10 < 12; i10++) {
                cArr[i10] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt(62));
            }
            this.f5899t = new String(cArr);
        } catch (Exception e10) {
            e10.getMessage();
        }
    }

    public static a a() {
        return C0087a.f5900a;
    }

    public String getSessionId() {
        return this.f5899t;
    }

    public String l() {
        int networkType = com.alibaba.sdk.android.httpdns.c.a.a().getNetworkType();
        return networkType != 1 ? networkType != 2 ? networkType != 3 ? networkType != 4 ? "unknown" : "4g" : "3g" : "2g" : "wifi";
    }
}
