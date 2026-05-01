package p1;

import android.content.SharedPreferences;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static SharedPreferences f18045a;

    public static void a(String str) {
        SharedPreferences sharedPreferences;
        if (str == null || (sharedPreferences = f18045a) == null) {
            return;
        }
        sharedPreferences.edit().putString("networksdk_target_cookie_name", str).apply();
    }
}
