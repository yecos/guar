package com.umeng.commonsdk.config;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class b implements f {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, Boolean> f10757a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private static Object f10758b = new Object();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f10759a = new b();

        private a() {
        }
    }

    public static b b() {
        return a.f10759a;
    }

    public void a() {
        synchronized (f10758b) {
            f10757a.clear();
        }
    }

    private b() {
    }

    public static boolean a(String str) {
        if (!d.a(str)) {
            return false;
        }
        synchronized (f10758b) {
            if (!f10757a.containsKey(str)) {
                return true;
            }
            return f10757a.get(str).booleanValue();
        }
    }

    @Override // com.umeng.commonsdk.config.f
    public void a(String str, Boolean bool) {
        if (d.a(str)) {
            synchronized (f10758b) {
                Map<String, Boolean> map = f10757a;
                if (map != null) {
                    map.put(str, bool);
                }
            }
        }
    }
}
