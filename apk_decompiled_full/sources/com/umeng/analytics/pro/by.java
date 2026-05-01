package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.umeng.analytics.pro.ca;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.net.URL;

/* loaded from: classes3.dex */
public class by {

    /* renamed from: a, reason: collision with root package name */
    public static final String f10131a = "resolve.umeng.com";

    /* renamed from: b, reason: collision with root package name */
    public static final int f10132b = 15000;

    /* renamed from: c, reason: collision with root package name */
    private static cc f10133c = null;

    /* renamed from: d, reason: collision with root package name */
    private static volatile int f10134d = -1;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final by f10135a = new by();

        private a() {
        }
    }

    public static by a() {
        return a.f10135a;
    }

    private String c() {
        if (f10133c == null) {
            f10133c = cc.b();
        }
        ca caVar = new ca("https://resolve.umeng.com/resolve", ca.a.GET, null, f10133c);
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 发送domain下发请求。");
        return caVar.a(f10132b, "");
    }

    public synchronized boolean b() {
        if (f10134d < 0) {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(UMGlobalContext.getAppContext(), "cj_domain", "0");
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> cj_domain读取值：" + imprintProperty);
            if ("1".equalsIgnoreCase(imprintProperty)) {
                f10134d = 1;
            } else {
                f10134d = 0;
            }
        }
        return f10134d <= 0;
    }

    private by() {
    }

    public synchronized String a(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        c();
        String c10 = cc.b().c();
        if (!TextUtils.isEmpty(c10)) {
            str2 = "https://" + c10 + Operator.Operation.DIVISION + str;
        }
        return str2;
    }

    private static String c(String str) {
        try {
            return new URL(str).getHost();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        return "https://" + str + Operator.Operation.DIVISION + str2;
    }

    public static String b(String str) {
        try {
            String c10 = c(str);
            return str.substring(str.indexOf(c10) + c10.length() + 1);
        } catch (Throwable unused) {
            return "";
        }
    }
}
