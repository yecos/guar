package com.mobile.brasiltv.utils;

import android.content.Context;

/* loaded from: classes3.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public static final e0 f8646a = new e0();

    /* renamed from: b, reason: collision with root package name */
    public static final String f8647b = "show_gesture";

    public static /* synthetic */ String c(e0 e0Var, Context context, String str, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = "";
        }
        return e0Var.b(context, str, str2);
    }

    public final boolean a(Context context, String str, boolean z10) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "defaultKey");
        return context.getApplicationContext().getSharedPreferences(f8647b, 0).getBoolean(str, z10);
    }

    public final String b(Context context, String str, String str2) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "defaultKey");
        t9.i.g(str2, "defaultValue");
        String string = context.getApplicationContext().getSharedPreferences(f8647b, 0).getString(str, str2);
        return string == null ? "" : string;
    }

    public final void d(Context context, String str, String str2) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "defaultKey");
        t9.i.g(str2, "values");
        context.getApplicationContext().getSharedPreferences(f8647b, 0).edit().putString(str, str2).apply();
    }

    public final void e(Context context, String str, boolean z10) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "defaultKey");
        context.getApplicationContext().getSharedPreferences(f8647b, 0).edit().putBoolean(str, z10).apply();
    }
}
