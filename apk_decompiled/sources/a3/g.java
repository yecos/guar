package a3;

import android.content.SharedPreferences;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f164a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f165b;

    /* renamed from: c, reason: collision with root package name */
    public static SharedPreferences f166c;

    static {
        g gVar = new g();
        f164a = gVar;
        f165b = gVar.getClass().getSimpleName();
    }

    public final String a(String str) {
        t9.i.g(str, "key");
        if (f166c == null) {
            f166c = t2.a.f18798a.a().getSharedPreferences("log", 0);
        }
        SharedPreferences sharedPreferences = f166c;
        String a10 = a.a(sharedPreferences != null ? sharedPreferences.getString(str, "") : null);
        t9.i.f(a10, "decrypt(sp?.getString(key, \"\"))");
        return a10;
    }

    public final void b(String str, String str2) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putString;
        t9.i.g(str, "key");
        t9.i.g(str2, "value");
        if (f166c == null) {
            f166c = t2.a.f18798a.a().getSharedPreferences("log", 0);
        }
        SharedPreferences sharedPreferences = f166c;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null || (putString = edit.putString(str, str2)) == null) {
            return;
        }
        putString.apply();
    }

    public final void c(String str, String str2) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putString;
        t9.i.g(str, "key");
        t9.i.g(str2, "value");
        if (f166c == null) {
            f166c = t2.a.f18798a.a().getSharedPreferences("log", 0);
        }
        SharedPreferences sharedPreferences = f166c;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null || (putString = edit.putString(str, a.c(str2))) == null) {
            return;
        }
        putString.apply();
    }
}
