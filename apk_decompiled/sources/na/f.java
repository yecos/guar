package na;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static SharedPreferences f17346a;

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return v7.b.a(str, "1b494e53756c664c2f44465245733572");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return v7.b.b(str, "1b494e53756c664c2f44465245733572");
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean c(Context context, String str, boolean z10) {
        if (f17346a == null) {
            f17346a = context.getSharedPreferences("config", 0);
        }
        return f17346a.getBoolean(str, z10);
    }

    public static int d(Context context, String str, int i10) {
        if (f17346a == null) {
            f17346a = context.getSharedPreferences("config", 0);
        }
        return f17346a.getInt(str, i10);
    }

    public static String e(Context context, String str) {
        if (f17346a == null) {
            f17346a = context.getSharedPreferences("config", 0);
        }
        return f17346a.getString(str, "");
    }

    public static String f(Context context, String str, String str2) {
        if (f17346a == null) {
            f17346a = context.getSharedPreferences("config", 0);
        }
        return f17346a.getString(str, str2);
    }

    public static String g(Context context, String str) {
        if (f17346a == null) {
            f17346a = context.getSharedPreferences("config", 0);
        }
        return a(f17346a.getString(str, ""));
    }

    public static String h(Context context, String str, String str2) {
        return a(context.getSharedPreferences(str, 0).getString(str2, ""));
    }

    public static void i(Context context, String str, boolean z10) {
        if (f17346a == null) {
            f17346a = context.getSharedPreferences("config", 0);
        }
        f17346a.edit().putBoolean(str, z10).apply();
    }

    public static void j(Context context, String str, int i10) {
        if (f17346a == null) {
            f17346a = context.getSharedPreferences("config", 0);
        }
        f17346a.edit().putInt(str, i10).apply();
    }

    public static void k(Context context, String str, String str2) {
        if (f17346a == null) {
            f17346a = context.getSharedPreferences("config", 0);
        }
        f17346a.edit().putString(str, str2).apply();
    }

    public static void l(Context context, String str, String str2) {
        if (f17346a == null) {
            f17346a = context.getSharedPreferences("config", 0);
        }
        f17346a.edit().putString(str, b(str2)).apply();
    }

    public static void m(Context context, String str, String str2, String str3) {
        context.getSharedPreferences(str, 0).edit().putString(str2, b(str3)).apply();
    }

    public static void n(Context context, String[] strArr) {
        if (strArr.length <= 0) {
            return;
        }
        if (f17346a == null) {
            f17346a = context.getSharedPreferences("config", 0);
        }
        SharedPreferences.Editor edit = f17346a.edit();
        for (String str : strArr) {
            edit.remove(str);
        }
        edit.apply();
    }
}
