package com.umeng.commonsdk.internal;

import android.content.Context;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static b f10909b;

    /* renamed from: a, reason: collision with root package name */
    private Context f10910a;

    /* renamed from: c, reason: collision with root package name */
    private c f10911c;

    private b(Context context) {
        this.f10910a = context;
        this.f10911c = new c(context);
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (f10909b == null) {
                f10909b = new b(context.getApplicationContext());
            }
            bVar = f10909b;
        }
        return bVar;
    }

    public c a() {
        return this.f10911c;
    }
}
