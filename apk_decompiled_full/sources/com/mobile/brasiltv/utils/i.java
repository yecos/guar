package com.mobile.brasiltv.utils;

import android.content.Context;

/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f8717a = new i();

    /* renamed from: b, reason: collision with root package name */
    public static final String f8718b = "check_device";

    public final int a(Context context, String str, int i10) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "defaultKey");
        return context.getApplicationContext().getSharedPreferences(f8718b, 0).getInt(str, i10);
    }

    public final void b(Context context, String str, int i10) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "defaultKey");
        context.getApplicationContext().getSharedPreferences(f8718b, 0).edit().putInt(str, i10).apply();
    }
}
