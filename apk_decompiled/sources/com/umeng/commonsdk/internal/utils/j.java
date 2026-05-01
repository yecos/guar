package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.bd;

/* loaded from: classes3.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10964a = bd.b().b(bd.f9991r);

    /* renamed from: b, reason: collision with root package name */
    private static final String f10965b = "um_common_strength";

    /* renamed from: c, reason: collision with root package name */
    private static final String f10966c = "um_common_battery";

    public static String a(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f10964a, 0)) == null) {
            return null;
        }
        return sharedPreferences.getString(f10966c, null);
    }

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context == null || TextUtils.isEmpty(str) || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f10964a, 0)) == null) {
            return;
        }
        sharedPreferences.edit().putString(f10966c, str).commit();
    }
}
