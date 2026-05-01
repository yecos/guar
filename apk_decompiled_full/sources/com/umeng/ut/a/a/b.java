package com.umeng.ut.a.a;

import android.text.TextUtils;
import com.umeng.ut.a.c.d;
import com.umeng.ut.a.c.e;

/* loaded from: classes3.dex */
public class b {
    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new String(com.umeng.ut.b.a.a.a.m74a(d.b(str.getBytes()), 2), "UTF-8");
        } catch (Exception e10) {
            e.a("", e10, new Object[0]);
            return "";
        }
    }
}
