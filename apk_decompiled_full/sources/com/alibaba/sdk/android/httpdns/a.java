package com.alibaba.sdk.android.httpdns;

import android.text.TextUtils;
import com.raizlabs.android.dbflow.sql.language.Operator;

/* loaded from: classes.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    private static long f5838a;
    private static String sSecretKey;

    public static String a(String str, String str2) {
        if (!l.b(str)) {
            return "";
        }
        try {
            return l.a(str + Operator.Operation.MINUS + sSecretKey + Operator.Operation.MINUS + str2);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getTimestamp() {
        return String.valueOf((System.currentTimeMillis() / 1000) + f5838a + 600);
    }

    public static void setAuthCurrentTime(long j10) {
        f5838a = j10 - (System.currentTimeMillis() / 1000);
    }

    public static void setSecretKey(String str) {
        sSecretKey = str;
    }

    public static boolean a() {
        return !TextUtils.isEmpty(sSecretKey);
    }
}
