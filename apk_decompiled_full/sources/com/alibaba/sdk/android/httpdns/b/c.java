package com.alibaba.sdk.android.httpdns.b;

import android.text.TextUtils;
import java.text.SimpleDateFormat;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final SimpleDateFormat f5848a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static long a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            return Long.valueOf(str).longValue();
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static String c(String str) {
        try {
            return f5848a.format(Long.valueOf(a(str) * 1000));
        } catch (Exception unused) {
            return f5848a.format(Long.valueOf(System.currentTimeMillis()));
        }
    }

    public static String d(String str) {
        try {
            return String.valueOf(f5848a.parse(str).getTime() / 1000);
        } catch (Exception unused) {
            return String.valueOf(System.currentTimeMillis() / 1000);
        }
    }
}
