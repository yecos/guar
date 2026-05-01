package com.mobile.brasiltv.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.TypedValue;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public abstract class j1 {

    /* renamed from: a, reason: collision with root package name */
    public static String f8725a = "";

    public static int a(Context context, int i10) {
        return (int) TypedValue.applyDimension(1, i10, context.getResources().getDisplayMetrics());
    }

    public static String b(Context context) {
        if (!TextUtils.isEmpty(f8725a)) {
            return f8725a;
        }
        String string = Settings.System.getString(context.getContentResolver(), "android_id");
        if (TextUtils.isEmpty(string)) {
            f8725a = ma.i.e("4b4d354a69546a7636736d2f73776a2b705834316d3874536576774470327448", "combrasiltvaslgklxckbcombrasiltv");
        } else {
            f8725a = string;
        }
        return f8725a;
    }

    public static Long c(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        long j10 = memoryInfo.availMem / 1000000;
        return Long.valueOf(memoryInfo.totalMem / 1000000);
    }

    public static boolean d(String str) {
        return Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*").matcher(str).matches();
    }

    public static boolean e(String str) {
        return Pattern.compile("^[0-9]{4,}$").matcher(str).matches();
    }

    public static boolean f(String str) {
        return Pattern.compile("[0-9A-Za-z]{6,12}").matcher(str).matches();
    }

    public static boolean g(String str) {
        return Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$").matcher(str).matches();
    }

    public static void h(Context context, String str) {
        f1.f8649a.u(ma.j.a(context, str));
    }

    public static boolean i(String str) {
        return Pattern.compile("^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$").matcher(str).matches();
    }
}
