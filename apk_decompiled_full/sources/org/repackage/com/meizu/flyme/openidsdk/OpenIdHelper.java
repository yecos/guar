package org.repackage.com.meizu.flyme.openidsdk;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class OpenIdHelper {

    /* renamed from: a, reason: collision with root package name */
    private static final String f17886a = "OpenIdHelper";

    /* renamed from: b, reason: collision with root package name */
    private static Method f17887b;

    public static String a(Context context) {
        b a10 = b.a();
        return a10.a(context.getApplicationContext(), a10.f17895a);
    }

    public static String b(Context context) {
        b a10 = b.a();
        return a10.a(context.getApplicationContext(), a10.f17896b);
    }

    public static String c(Context context) {
        b a10 = b.a();
        return a10.a(context.getApplicationContext(), a10.f17898d);
    }

    public static String d(Context context) {
        b a10 = b.a();
        return a10.a(context.getApplicationContext(), a10.f17897c);
    }

    public static void a(boolean z10) {
        b.a();
        b.a(z10);
    }

    public static final boolean a() {
        Context context = null;
        try {
            if (f17887b == null) {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]);
                f17887b = method;
                method.setAccessible(true);
            }
            context = (Context) f17887b.invoke(null, new Object[0]);
        } catch (Exception e10) {
            Log.e(f17886a, "ActivityThread:currentApplication --> " + e10.toString());
        }
        if (context == null) {
            return false;
        }
        return b.a().a(context, false);
    }
}
