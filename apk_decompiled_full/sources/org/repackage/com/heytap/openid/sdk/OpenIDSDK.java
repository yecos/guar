package org.repackage.com.heytap.openid.sdk;

import android.content.Context;
import org.repackage.a.a.a.a.a;
import org.repackage.a.a.a.a.c;

/* loaded from: classes.dex */
public class OpenIDSDK {
    public static void a(Context context) {
        a.f17873b = c.a.f17881a.a(context.getApplicationContext());
        a.f17872a = true;
    }

    public static String b(Context context) {
        if (a.f17872a) {
            return c.a.f17881a.a(context.getApplicationContext(), "GUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String c(Context context) {
        if (a.f17872a) {
            return c.a.f17881a.a(context.getApplicationContext(), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String d(Context context) {
        if (a.f17872a) {
            return c.a.f17881a.a(context.getApplicationContext(), "DUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String e(Context context) {
        if (a.f17872a) {
            return c.a.f17881a.a(context.getApplicationContext(), "AUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static boolean a() {
        if (a.f17872a) {
            return a.f17873b;
        }
        throw new RuntimeException("SDK Need Init First!");
    }
}
