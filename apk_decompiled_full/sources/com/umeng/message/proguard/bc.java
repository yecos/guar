package com.umeng.message.proguard;

import android.content.SharedPreferences;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public class bc {

    /* renamed from: b, reason: collision with root package name */
    private static volatile bc f11628b;

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f11629a = y.a().getSharedPreferences("umeng_push", 0);

    private bc() {
    }

    public static bc a() {
        if (f11628b == null) {
            synchronized (bc.class) {
                if (f11628b == null) {
                    f11628b = new bc();
                }
            }
        }
        return f11628b;
    }

    public final void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f11629a.edit().putString(str, str2).apply();
    }

    public final void a(String str) {
        if (this.f11629a.contains(str)) {
            this.f11629a.edit().remove(str).apply();
        }
    }
}
