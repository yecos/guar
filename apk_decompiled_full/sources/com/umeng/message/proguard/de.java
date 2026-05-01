package com.umeng.message.proguard;

import android.app.Application;
import android.content.Context;

/* loaded from: classes3.dex */
public final class de {

    /* renamed from: a, reason: collision with root package name */
    private static Application f11877a;

    public static void a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        if (f11877a == null) {
            f11877a = (Application) context.getApplicationContext();
            dy.a("u", "2.0.0");
            bz.a(context);
        }
    }

    public static Context a() {
        Application application = f11877a;
        if (application != null) {
            return application;
        }
        throw new IllegalStateException("context is null! make sure UMUnionSdk.init(...) be called");
    }
}
