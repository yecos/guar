package org.repackage.com.vivo.identifier;

import android.content.Context;
import java.util.List;

/* loaded from: classes.dex */
public class IdentifierManager {
    public static boolean a(Context context) {
        if (IdentifierIdClient.b(context) == null) {
            return false;
        }
        return IdentifierIdClient.a();
    }

    public static String b(Context context) {
        IdentifierIdClient b10 = IdentifierIdClient.b(context);
        if (b10 == null) {
            return null;
        }
        return b10.c();
    }

    public static String c(Context context) {
        IdentifierIdClient b10 = IdentifierIdClient.b(context);
        if (b10 == null) {
            return null;
        }
        return b10.d();
    }

    public static String d(Context context) {
        IdentifierIdClient b10 = IdentifierIdClient.b(context);
        if (b10 == null) {
            return null;
        }
        return b10.e();
    }

    public static String e(Context context) {
        IdentifierIdClient b10 = IdentifierIdClient.b(context);
        if (b10 == null) {
            return null;
        }
        return b10.f();
    }

    public static String f(Context context) {
        IdentifierIdClient b10 = IdentifierIdClient.b(context);
        if (b10 == null) {
            return null;
        }
        return b10.g();
    }

    public static String g(Context context) {
        IdentifierIdClient b10 = IdentifierIdClient.b(context);
        if (b10 == null) {
            return null;
        }
        return b10.h();
    }

    public static String h(Context context) {
        IdentifierIdClient b10 = IdentifierIdClient.b(context);
        if (b10 == null) {
            return null;
        }
        return b10.b();
    }

    public static String i(Context context) {
        IdentifierIdClient b10 = IdentifierIdClient.b(context);
        if (b10 == null) {
            return null;
        }
        return b10.i();
    }

    public static String j(Context context) {
        IdentifierIdClient a10 = IdentifierIdClient.a(context);
        if (a10 == null) {
            return null;
        }
        return a10.j();
    }

    public static String k(Context context) {
        IdentifierIdClient a10 = IdentifierIdClient.a(context);
        if (a10 == null) {
            return null;
        }
        return a10.k();
    }

    public static boolean a(Context context, List<String> list) {
        IdentifierIdClient b10 = IdentifierIdClient.b(context);
        if (b10 == null) {
            return false;
        }
        return b10.a(list);
    }

    public static List b(Context context, List<String> list) {
        IdentifierIdClient b10 = IdentifierIdClient.b(context);
        if (b10 == null) {
            return null;
        }
        return b10.b(list);
    }
}
