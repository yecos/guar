package com.umeng.ut.a.b;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f12351a = -1;
    public long timestamp = 0;
    public String signature = "";
    public byte[] data = null;

    /* renamed from: b, reason: collision with root package name */
    public long f12352b = 0;

    public static boolean a(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                com.umeng.ut.a.c.e.b("", "result", str, com.umeng.ccg.a.f10664x, str2);
                if (str2.equals(com.umeng.ut.b.a.a.a.a(com.umeng.ut.a.c.b.c(str).getBytes(), 2))) {
                    com.umeng.ut.a.c.e.m72a("", "signature is ok");
                    return true;
                }
                com.umeng.ut.a.c.e.m72a("", "signature is error");
            }
        } catch (Exception e10) {
            com.umeng.ut.a.c.e.m72a("", e10);
        }
        return false;
    }
}
