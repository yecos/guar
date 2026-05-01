package com.uyumao;

import android.content.SharedPreferences;

/* loaded from: classes3.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public static volatile m f12424a;

    /* renamed from: b, reason: collision with root package name */
    public final SharedPreferences f12425b = e.a().getSharedPreferences("um_social_azx", 0);

    public static m a() {
        if (f12424a == null) {
            synchronized (m.class) {
                if (f12424a == null) {
                    f12424a = new m();
                }
            }
        }
        return f12424a;
    }
}
