package com.umeng.message.proguard;

import android.content.SharedPreferences;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public class ds {

    /* renamed from: b, reason: collision with root package name */
    private static volatile ds f12013b;

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f12014a = de.a().getSharedPreferences("um_push_union", 0);

    private ds() {
    }

    public static ds a() {
        if (f12013b == null) {
            synchronized (ds.class) {
                if (f12013b == null) {
                    f12013b = new ds();
                }
            }
        }
        return f12013b;
    }

    public final String b(String str, String str2) {
        return this.f12014a.getString(str, str2);
    }

    public final void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f12014a.edit().putString(str, str2).apply();
    }
}
