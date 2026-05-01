package com.alibaba.sdk.android.httpdns.b;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static f f5846a = null;

    /* renamed from: a, reason: collision with other field name */
    private static com.alibaba.sdk.android.httpdns.c.a f5a = null;

    /* renamed from: a, reason: collision with other field name */
    private static boolean f6a = false;

    /* renamed from: n, reason: collision with root package name */
    private static boolean f5847n = true;

    public static List<e> a() {
        ArrayList arrayList = new ArrayList();
        if (!f6a) {
            return arrayList;
        }
        arrayList.addAll(f5846a.a());
        return arrayList;
    }

    public static void b(Context context) {
        if (context != null) {
            f5a.c(context);
        }
    }

    public static boolean g() {
        return f5847n;
    }

    public static String i() {
        return f5a.i();
    }

    public static void a(Context context) {
        a(context, (com.alibaba.sdk.android.httpdns.c.a) null);
    }

    public static void b(e eVar) {
        if (eVar == null) {
            return;
        }
        f5846a.b(eVar);
    }

    public static void a(Context context, com.alibaba.sdk.android.httpdns.c.a aVar) {
        f5846a = new a(context);
        f5a = aVar;
        if (aVar == null) {
            f5a = com.alibaba.sdk.android.httpdns.c.a.a();
        }
    }

    public static void a(e eVar) {
        if (eVar == null) {
            return;
        }
        f5846a.a(eVar);
    }

    public static void a(boolean z10, boolean z11) {
        f6a = z10;
        f5847n = z11;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m1a() {
        return f6a;
    }
}
