package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.text.TextUtils;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.utils.UMUtils;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Context f11107a;

    /* renamed from: b, reason: collision with root package name */
    private String f11108b;

    /* renamed from: c, reason: collision with root package name */
    private String f11109c;

    /* renamed from: com.umeng.commonsdk.statistics.internal.a$a, reason: collision with other inner class name */
    public static class C0180a {

        /* renamed from: a, reason: collision with root package name */
        private static final a f11110a = new a();

        private C0180a() {
        }
    }

    public static a a(Context context) {
        if (f11107a == null && context != null) {
            f11107a = context.getApplicationContext();
        }
        return C0180a.f11110a;
    }

    private void f(String str) {
        try {
            this.f11108b = str.replaceAll("&=", " ").replaceAll("&&", " ").replaceAll("==", Operator.Operation.DIVISION) + Operator.Operation.DIVISION + "Android " + HelperUtils.getUmengMD5(UMUtils.getAppkey(f11107a));
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f11107a, th);
        }
    }

    private void g(String str) {
        try {
            String str2 = str.split("&&")[0];
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String[] split = str2.split("&=");
            StringBuilder sb = new StringBuilder();
            sb.append(bt.aW);
            for (String str3 : split) {
                if (!TextUtils.isEmpty(str3)) {
                    String substring = str3.substring(0, 2);
                    if (substring.endsWith(Operator.Operation.EQUALS)) {
                        substring = substring.replace(Operator.Operation.EQUALS, "");
                    }
                    sb.append(substring);
                }
            }
            this.f11109c = sb.toString();
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f11107a, th);
        }
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("t");
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(bt.aJ);
    }

    public boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("h");
    }

    public void e(String str) {
        String substring = str.substring(0, str.indexOf(95));
        g(substring);
        f(substring);
    }

    private a() {
        this.f11108b = null;
        this.f11109c = null;
    }

    public String b() {
        return this.f11108b;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("a");
    }

    public String a() {
        return this.f11109c;
    }
}
