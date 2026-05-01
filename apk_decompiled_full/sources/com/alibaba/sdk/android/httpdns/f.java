package com.alibaba.sdk.android.httpdns;

import com.alibaba.sdk.android.httpdns.probe.IPProbeItem;
import com.umeng.analytics.pro.by;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class f {

    /* renamed from: c, reason: collision with root package name */
    static String f5903c;

    /* renamed from: a, reason: collision with other field name */
    static String[] f19a = {"203.107.1.1"};

    /* renamed from: b, reason: collision with root package name */
    static final String[] f5902b = {"203.107.1.97", "203.107.1.100", "httpdns-sc.aliyuncs.com"};

    /* renamed from: c, reason: collision with other field name */
    static final String[] f20c = new String[0];

    /* renamed from: d, reason: collision with root package name */
    static String f5904d = "80";
    static String PROTOCOL = "http://";

    /* renamed from: a, reason: collision with root package name */
    static int f5901a = by.f10132b;
    static Map<String, String> extra = new HashMap();

    /* renamed from: a, reason: collision with other field name */
    static List<IPProbeItem> f18a = null;

    public static synchronized void a(List<IPProbeItem> list) {
        synchronized (f.class) {
            f18a = list;
        }
    }

    public static synchronized void c(String str) {
        synchronized (f.class) {
            f5903c = str;
        }
    }

    public static synchronized void clearSdnsGlobalParams() {
        synchronized (f.class) {
            extra.clear();
        }
    }

    public static synchronized void setHTTPSRequestEnabled(boolean z10) {
        String str;
        synchronized (f.class) {
            if (z10) {
                PROTOCOL = "https://";
                str = "443";
            } else {
                PROTOCOL = "http://";
                str = "80";
            }
            f5904d = str;
        }
    }

    public static synchronized void setSdnsGlobalParams(Map<String, String> map) {
        synchronized (f.class) {
            extra.putAll(map);
        }
    }

    public static synchronized void setTimeoutInterval(int i10) {
        synchronized (f.class) {
            if (i10 > 0) {
                f5901a = i10;
            }
        }
    }

    public static synchronized boolean a(String[] strArr) {
        synchronized (f.class) {
            if (strArr != null) {
                if (strArr.length != 0) {
                    f19a = strArr;
                    i.d("serverIps:" + Arrays.toString(f19a));
                    return true;
                }
            }
            return false;
        }
    }
}
