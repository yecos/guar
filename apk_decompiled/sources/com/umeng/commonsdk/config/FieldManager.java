package com.umeng.commonsdk.config;

import android.content.Context;
import android.util.Pair;
import com.umeng.commonsdk.config.d;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class FieldManager {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10752a = "cfgfd";

    /* renamed from: b, reason: collision with root package name */
    private static b f10753b = b.b();

    /* renamed from: c, reason: collision with root package name */
    private static boolean f10754c = false;

    /* renamed from: d, reason: collision with root package name */
    private static Object f10755d = new Object();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final FieldManager f10756a = new FieldManager();

        private a() {
        }
    }

    public static FieldManager a() {
        return a.f10756a;
    }

    public static boolean allow(String str) {
        synchronized (f10755d) {
            if (!f10754c) {
                return false;
            }
            return b.a(str);
        }
    }

    public static boolean b() {
        boolean z10;
        synchronized (f10755d) {
            z10 = f10754c;
        }
        return z10;
    }

    private FieldManager() {
    }

    public void a(Context context) {
        String str;
        String str2 = "1001@3749699455,2130669566,262139,1983";
        String[] strArr = {d.a.class.getName(), d.b.class.getName(), d.c.class.getName(), d.EnumC0176d.class.getName()};
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "cfgfd", "1001@3749699455,2130669566,262139,1983");
        synchronized (f10755d) {
            Pair<Long, String> a10 = a(imprintProperty);
            if (((Long) a10.first).longValue() > 1000 && (str = (String) a10.second) != null && str.length() > 0) {
                str2 = str;
            }
            String[] split = str2.split(",");
            int length = split.length;
            if (length > 0) {
                ArrayList arrayList = new ArrayList();
                g gVar = new g();
                for (int i10 = 0; i10 < length; i10++) {
                    arrayList.add(gVar);
                    ((e) arrayList.get(i10)).a(split[i10], f10753b, d.b(strArr[i10]));
                }
            }
            f10754c = true;
        }
    }

    public void a(Context context, String str) {
        String str2;
        String str3 = "1001@3749699455,2130669566,262139,1983";
        String[] strArr = {d.a.class.getName(), d.b.class.getName(), d.c.class.getName(), d.EnumC0176d.class.getName()};
        synchronized (f10755d) {
            f10753b.a();
            if (str != null) {
                Pair<Long, String> a10 = a(str);
                if (((Long) a10.first).longValue() > 1000 && (str2 = (String) a10.second) != null && str2.length() > 0) {
                    str3 = str2;
                }
            }
            String[] split = str3.split(",");
            int length = split.length;
            if (length > 0) {
                ArrayList arrayList = new ArrayList();
                g gVar = new g();
                for (int i10 = 0; i10 < length; i10++) {
                    arrayList.add(gVar);
                    ((e) arrayList.get(i10)).a(split[i10], f10753b, d.b(strArr[i10]));
                }
            }
            f10754c = true;
        }
    }

    private static Pair<Long, String> a(String str) {
        Pair<Long, String> pair = new Pair<>(-1L, null);
        if (str != null && str.length() >= 2) {
            String[] split = str.split("@");
            if (split.length < 2) {
                return pair;
            }
            try {
                long parseLong = Long.parseLong(split[0]);
                return new Pair<>(Long.valueOf(parseLong), split[1]);
            } catch (Throwable unused) {
            }
        }
        return pair;
    }
}
