package na;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Util;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static Context f17333a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f17334b = "";

    /* renamed from: c, reason: collision with root package name */
    public static String f17335c = "";

    /* renamed from: d, reason: collision with root package name */
    public static String f17336d = "";

    /* renamed from: e, reason: collision with root package name */
    public static ExecutorService f17337e;

    public static String a() {
        return TextUtils.isEmpty(f17336d) ? Locale.getDefault().getLanguage() : f17336d;
    }

    public static int b() {
        try {
            return f17333a.getPackageManager().getPackageInfo(g(), 64).versionCode;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public static String c() {
        try {
            return (f17333a.getPackageManager().getPackageInfo(f17333a.getPackageName(), 64).versionName + "").trim();
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String d() {
        return f.f(f17333a, "SP_DRMID", "");
    }

    public static String e() {
        return f17334b;
    }

    public static synchronized ExecutorService f() {
        ExecutorService executorService;
        synchronized (a.class) {
            if (f17337e == null) {
                f17337e = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("Net OkHttp Dispatcher", false));
            }
            executorService = f17337e;
        }
        return executorService;
    }

    public static String g() {
        return f17333a.getPackageName();
    }

    public static String h() {
        if (f17335c.isEmpty()) {
            f17335c = f.f(f17333a, "key_sn", "");
        }
        return f17335c;
    }

    public static void i(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f17334b = str;
    }
}
