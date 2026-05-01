package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes3.dex */
public class au {

    /* renamed from: a, reason: collision with root package name */
    public static final String f9913a = "cl_count";

    /* renamed from: b, reason: collision with root package name */
    public static final String f9914b = "interval_";

    /* renamed from: c, reason: collision with root package name */
    public static final String f9915c = "config_ts";

    /* renamed from: d, reason: collision with root package name */
    public static final String f9916d = "iucc_s1";

    /* renamed from: e, reason: collision with root package name */
    public static final String f9917e = "iucc_s2";

    /* renamed from: f, reason: collision with root package name */
    public static final String f9918f = "sdk_type_ver";

    /* renamed from: g, reason: collision with root package name */
    public static final String f9919g = "should_fetch";

    /* renamed from: h, reason: collision with root package name */
    public static final String f9920h = "last_type_index";

    /* renamed from: i, reason: collision with root package name */
    private static final String f9921i = "ccg_sp_config_file";

    private au() {
    }

    public static SharedPreferences a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(f9921i, 0);
        } catch (Throwable unused) {
            return null;
        }
    }
}
