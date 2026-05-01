package org.repackage.com.miui.deviceid;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class IdentifierManager {

    /* renamed from: a, reason: collision with root package name */
    private static final String f17907a = "IdentifierManager";

    /* renamed from: b, reason: collision with root package name */
    private static Object f17908b;

    /* renamed from: c, reason: collision with root package name */
    private static Class<?> f17909c;

    /* renamed from: d, reason: collision with root package name */
    private static Method f17910d;

    /* renamed from: e, reason: collision with root package name */
    private static Method f17911e;

    /* renamed from: f, reason: collision with root package name */
    private static Method f17912f;

    /* renamed from: g, reason: collision with root package name */
    private static Method f17913g;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f17909c = cls;
            f17908b = cls.newInstance();
            f17910d = f17909c.getMethod("getUDID", Context.class);
            f17911e = f17909c.getMethod("getOAID", Context.class);
            f17912f = f17909c.getMethod("getVAID", Context.class);
            f17913g = f17909c.getMethod("getAAID", Context.class);
        } catch (Exception e10) {
            Log.e(f17907a, "reflect exception!", e10);
        }
    }

    public static boolean a() {
        return (f17909c == null || f17908b == null) ? false : true;
    }

    public static String b(Context context) {
        return a(context, f17911e);
    }

    public static String c(Context context) {
        return a(context, f17912f);
    }

    public static String d(Context context) {
        return a(context, f17913g);
    }

    public static String a(Context context) {
        return a(context, f17910d);
    }

    private static String a(Context context, Method method) {
        Object obj = f17908b;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception e10) {
            Log.e(f17907a, "invoke exception!", e10);
            return null;
        }
    }
}
