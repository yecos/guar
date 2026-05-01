package com.alibaba.sdk.android.httpdns;

import android.content.Context;
import android.content.SharedPreferences;
import com.hpplay.sdk.source.common.global.Constant;
import java.net.SocketTimeoutException;

/* loaded from: classes.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private static SharedPreferences f5966a = null;

    /* renamed from: a, reason: collision with other field name */
    private static a f39a = a.ENABLE;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f5967d = false;

    /* renamed from: e, reason: collision with root package name */
    private static long f5968e = 0;

    /* renamed from: g, reason: collision with root package name */
    private static volatile int f5969g = 0;

    /* renamed from: h, reason: collision with root package name */
    private static volatile int f5970h = 0;

    /* renamed from: l, reason: collision with root package name */
    private static boolean f5971l = false;

    public enum a {
        ENABLE,
        PRE_DISABLE,
        DISABLE
    }

    public static synchronized String a(s sVar) {
        synchronized (u.class) {
            try {
                s sVar2 = s.QUERY_HOST;
                if (sVar != sVar2 && sVar != s.SNIFF_HOST) {
                    return (sVar == s.QUERY_SCHEDULE_CENTER || sVar == s.SNIFF_SCHEDULE_CENTER) ? null : null;
                }
                if (f39a == a.ENABLE || f39a == a.PRE_DISABLE) {
                    return f.f19a[f5969g];
                }
                if (sVar == sVar2) {
                    return null;
                }
                return f.f19a[f5969g];
            } catch (Exception e10) {
                e10.printStackTrace();
                return null;
            }
        }
    }

    public static void b(int i10) {
        if (f5966a == null || i10 < 0 || i10 >= f.f19a.length) {
            return;
        }
        f5969g = i10;
        SharedPreferences.Editor edit = f5966a.edit();
        edit.putInt("activiate_ip_index", i10);
        edit.putLong("activiated_ip_index_modified_time", System.currentTimeMillis());
        edit.commit();
    }

    public static synchronized void d(boolean z10) {
        synchronized (u.class) {
            if (f5971l != z10) {
                f5971l = z10;
                SharedPreferences sharedPreferences = f5966a;
                if (sharedPreferences != null) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putBoolean(Constant.KEY_STATUS, f5971l);
                    edit.putLong("disable_modified_time", System.currentTimeMillis());
                    edit.commit();
                }
            }
        }
    }

    public static synchronized boolean e() {
        boolean z10;
        synchronized (u.class) {
            z10 = f5971l;
        }
        return z10;
    }

    private static void h() {
        f5969g = f5969g == f.f19a.length + (-1) ? 0 : f5969g + 1;
        b(f5969g);
    }

    public static void i() {
        b(0);
        f5970h = f5969g;
        t.a().c(true);
    }

    public static void j() {
        t.a().c(true);
    }

    public static void reportHttpDnsSuccess(String str, int i10) {
        try {
            com.alibaba.sdk.android.httpdns.d.b a10 = com.alibaba.sdk.android.httpdns.d.b.a();
            if (a10 != null) {
                a10.a(str, i10, com.alibaba.sdk.android.httpdns.d.c.a(), com.alibaba.sdk.android.httpdns.b.b.m1a() ? 1 : 0);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static synchronized void a(Context context) {
        synchronized (u.class) {
            if (!f5967d) {
                synchronized (u.class) {
                    if (!f5967d) {
                        if (context != null) {
                            f5966a = context.getSharedPreferences("httpdns_config_cache", 0);
                        }
                        f5971l = f5966a.getBoolean(Constant.KEY_STATUS, false);
                        f5969g = f5966a.getInt("activiate_ip_index", 0);
                        f5970h = f5969g;
                        f5968e = f5966a.getLong("disable_modified_time", 0L);
                        if (System.currentTimeMillis() - f5968e >= 86400000) {
                            d(false);
                        }
                        f39a = f5971l ? a.DISABLE : a.ENABLE;
                        f5967d = true;
                    }
                }
            }
        }
    }

    private static void b(String str, String str2, long j10) {
        try {
            com.alibaba.sdk.android.httpdns.d.b a10 = com.alibaba.sdk.android.httpdns.d.b.a();
            if (a10 != null) {
                a10.b(str2, j10, com.alibaba.sdk.android.httpdns.d.c.a());
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private static void h(String str) {
        try {
            com.alibaba.sdk.android.httpdns.d.b a10 = com.alibaba.sdk.android.httpdns.d.b.a();
            if (a10 != null) {
                String m19d = n.a().m19d();
                int i10 = f5969g;
                if (i10 == 0) {
                    i10 = f.f19a.length;
                }
                int i11 = i10 - 1;
                int length = i11 == 0 ? f.f19a.length - 1 : i11 - 1;
                if (i11 >= 0) {
                    String[] strArr = f.f19a;
                    if (i11 >= strArr.length || length < 0 || length >= strArr.length) {
                        return;
                    }
                    String str2 = strArr[i11];
                    a10.b(str, m19d, strArr[length] + "," + str2);
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static synchronized void a(String str, String str2, long j10) {
        synchronized (u.class) {
            try {
                b(str, str2, j10);
                reportHttpDnsSuccess(str, 1);
                a aVar = f39a;
                a aVar2 = a.ENABLE;
                if (aVar != aVar2 && str2 != null && str2.equals(f.f19a[f5969g])) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(f39a == a.DISABLE ? "Disable " : "Pre_disable ");
                    sb.append("mode finished. Enter enable mode.");
                    i.f(sb.toString());
                    f39a = aVar2;
                    d(false);
                    t.a().g();
                    f5970h = f5969g;
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public static synchronized void a(String str, String str2, Throwable th) {
        synchronized (u.class) {
            try {
                a(str2, th);
                if (a(th) && str2 != null && str2.equals(f.f19a[f5969g])) {
                    h();
                    if (f5970h == f5969g) {
                        t.a().c(false);
                        n.a().c();
                    }
                    if (f39a == a.ENABLE) {
                        f39a = a.PRE_DISABLE;
                        i.f("enter pre_disable mode");
                    } else if (f39a == a.PRE_DISABLE) {
                        f39a = a.DISABLE;
                        i.f("enter disable mode");
                        d(true);
                        h(str);
                        t.a().g(str);
                    }
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    private static void a(String str, Throwable th) {
        try {
            com.alibaba.sdk.android.httpdns.d.b a10 = com.alibaba.sdk.android.httpdns.d.b.a();
            if (a10 != null) {
                int a11 = com.alibaba.sdk.android.httpdns.d.c.a(th);
                a10.a(str, String.valueOf(a11), com.alibaba.sdk.android.httpdns.d.c.m12a(th), com.alibaba.sdk.android.httpdns.d.c.a(), com.alibaba.sdk.android.httpdns.net64.a.a().i() ? 1 : 0);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private static boolean a(Throwable th) {
        if (th instanceof SocketTimeoutException) {
            return true;
        }
        if (th instanceof h) {
            h hVar = (h) th;
            if (hVar.getErrorCode() == 403 && hVar.getMessage().equals("ServiceLevelDeny")) {
                return true;
            }
        }
        return false;
    }
}
