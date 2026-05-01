package com.umeng.ccg;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f10667a = true;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f10668b = true;

    /* renamed from: c, reason: collision with root package name */
    private static volatile boolean f10669c = true;

    /* renamed from: d, reason: collision with root package name */
    private static volatile boolean f10670d = true;

    /* renamed from: e, reason: collision with root package name */
    private static volatile boolean f10671e = true;

    /* renamed from: g, reason: collision with root package name */
    private static Map<String, Boolean> f10673g = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private static Object f10672f = new Object();

    public static boolean a() {
        boolean z10;
        synchronized (f10672f) {
            z10 = f10667a;
        }
        return z10;
    }

    public static boolean b() {
        boolean z10;
        synchronized (f10672f) {
            z10 = f10668b;
        }
        return z10;
    }

    public static boolean c() {
        boolean z10;
        synchronized (f10672f) {
            z10 = f10669c;
        }
        return z10;
    }

    public static boolean d() {
        boolean z10;
        synchronized (f10672f) {
            z10 = f10670d;
        }
        return z10;
    }

    public static void a(boolean z10) {
        synchronized (f10672f) {
            f10670d = z10;
            f10673g.put(a.f10645e, Boolean.valueOf(z10));
        }
    }

    public static void b(boolean z10) {
        synchronized (f10672f) {
            f10671e = z10;
            f10673g.put(a.f10649i, Boolean.valueOf(z10));
        }
    }

    public static boolean a(String str) {
        boolean booleanValue;
        synchronized (f10672f) {
            booleanValue = f10673g.containsKey(str) ? f10673g.get(str).booleanValue() : true;
        }
        return booleanValue;
    }
}
