package com.umeng.message.proguard;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public final class ce {
    public static void a(String str, Object... objArr) {
        q.a().d(a(str), a(objArr));
    }

    public static void b(String str, Object... objArr) {
        q.a().i(a(str), a(objArr));
    }

    public static void c(String str, Object... objArr) {
        q.a().w(a(str), a(objArr));
    }

    public static void d(String str, Object... objArr) {
        q.a().e(a(str), a(objArr));
    }

    private static String a(String str) {
        return TextUtils.isEmpty(str) ? "UMUnion" : "UMUnion.".concat(String.valueOf(str));
    }

    private static String a(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        if (objArr.length == 1) {
            return String.valueOf(objArr[0]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(objArr[0]);
        for (int i10 = 1; i10 < objArr.length; i10++) {
            Object obj = objArr[i10];
            if (obj != null) {
                sb.append(obj);
            }
        }
        return sb.toString();
    }
}
