package a3;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.titans.entity.CdnType;
import i9.r;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Util;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: b, reason: collision with root package name */
    public static ExecutorService f171b;

    /* renamed from: a, reason: collision with root package name */
    public static final j f170a = new j();

    /* renamed from: c, reason: collision with root package name */
    public static final List f172c = i9.j.g("googleadservices", "googleapis", "googleanalysis", "googleadmob", "googleMessaging", "umengacs", CdnType.TYPE_AWS);

    /* renamed from: d, reason: collision with root package name */
    public static final List f173d = i9.j.g("log?s=", "rpc?alt=json", "vpkg?asfast=true", "zip?g=true", "log_event");

    public final int a() {
        try {
            t2.a aVar = t2.a.f18798a;
            return aVar.a().getPackageManager().getPackageInfo(aVar.a().getPackageName(), 64).versionCode;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public final List b() {
        return f172c;
    }

    public final List c() {
        return f173d;
    }

    public final synchronized ExecutorService d() {
        ExecutorService executorService;
        if (f171b == null) {
            f171b = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("Net OkHttp Dispatcher", false));
        }
        executorService = f171b;
        t9.i.d(executorService);
        return executorService;
    }

    public final String e(List list) {
        t9.i.g(list, "strings");
        return (String) r.z(list, w9.c.f19267a);
    }

    public final boolean f(Context context) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        return i(context) || j(context) || g(context) || h(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
    
        r5 = r5.getNetworkCapabilities(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(android.content.Context r5) {
        /*
            r4 = this;
            java.lang.String r0 = "context"
            t9.i.g(r5, r0)
            r0 = 1
            java.lang.String r1 = "connectivity"
            java.lang.Object r5 = r5.getSystemService(r1)     // Catch: java.lang.Exception -> L3b
            java.lang.String r1 = "null cannot be cast to non-null type android.net.ConnectivityManager"
            t9.i.e(r5, r1)     // Catch: java.lang.Exception -> L3b
            android.net.ConnectivityManager r5 = (android.net.ConnectivityManager) r5     // Catch: java.lang.Exception -> L3b
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L3b
            r2 = 23
            r3 = 0
            if (r1 < r2) goto L2d
            android.net.Network r1 = h1.e.a(r5)     // Catch: java.lang.Exception -> L3b
            if (r1 != 0) goto L21
            return r3
        L21:
            android.net.NetworkCapabilities r5 = h1.f.a(r5, r1)     // Catch: java.lang.Exception -> L3b
            if (r5 != 0) goto L28
            return r3
        L28:
            boolean r5 = a3.i.a(r5, r0)     // Catch: java.lang.Exception -> L3b
            return r5
        L2d:
            android.net.NetworkInfo r5 = r5.getNetworkInfo(r3)     // Catch: java.lang.Exception -> L3b
            if (r5 == 0) goto L3a
            boolean r5 = r5.isConnected()     // Catch: java.lang.Exception -> L3b
            if (r5 == 0) goto L3a
            goto L3b
        L3a:
            r0 = 0
        L3b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.j.g(android.content.Context):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
    
        r5 = r5.getNetworkCapabilities(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean h(android.content.Context r5) {
        /*
            r4 = this;
            java.lang.String r0 = "context"
            t9.i.g(r5, r0)
            r0 = 1
            java.lang.String r1 = "connectivity"
            java.lang.Object r5 = r5.getSystemService(r1)     // Catch: java.lang.Exception -> L4e
            java.lang.String r1 = "null cannot be cast to non-null type android.net.ConnectivityManager"
            t9.i.e(r5, r1)     // Catch: java.lang.Exception -> L4e
            android.net.ConnectivityManager r5 = (android.net.ConnectivityManager) r5     // Catch: java.lang.Exception -> L4e
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L4e
            r2 = 23
            r3 = 0
            if (r1 < r2) goto L40
            android.net.Network r1 = h1.e.a(r5)     // Catch: java.lang.Exception -> L4e
            if (r1 != 0) goto L21
            return r3
        L21:
            android.net.NetworkCapabilities r5 = h1.f.a(r5, r1)     // Catch: java.lang.Exception -> L4e
            if (r5 != 0) goto L28
            return r3
        L28:
            boolean r1 = a3.i.a(r5, r0)     // Catch: java.lang.Exception -> L4e
            if (r1 == 0) goto L2f
            goto L3f
        L2f:
            boolean r1 = a3.i.a(r5, r3)     // Catch: java.lang.Exception -> L4e
            if (r1 == 0) goto L36
            goto L3f
        L36:
            r1 = 3
            boolean r5 = a3.i.a(r5, r1)     // Catch: java.lang.Exception -> L4e
            if (r5 == 0) goto L3e
            goto L3f
        L3e:
            r0 = 0
        L3f:
            return r0
        L40:
            android.net.NetworkInfo r5 = r5.getActiveNetworkInfo()     // Catch: java.lang.Exception -> L4e
            if (r5 == 0) goto L4d
            boolean r5 = r5.isConnected()     // Catch: java.lang.Exception -> L4e
            if (r5 == 0) goto L4d
            goto L4e
        L4d:
            r0 = 0
        L4e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.j.h(android.content.Context):boolean");
    }

    public final boolean i(Context context) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        Object systemService = context.getSystemService("connectivity");
        t9.i.e(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
    
        r5 = r5.getNetworkCapabilities(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean j(android.content.Context r5) {
        /*
            r4 = this;
            java.lang.String r0 = "context"
            t9.i.g(r5, r0)
            r0 = 1
            java.lang.String r1 = "connectivity"
            java.lang.Object r5 = r5.getSystemService(r1)     // Catch: java.lang.Exception -> L3b
            java.lang.String r1 = "null cannot be cast to non-null type android.net.ConnectivityManager"
            t9.i.e(r5, r1)     // Catch: java.lang.Exception -> L3b
            android.net.ConnectivityManager r5 = (android.net.ConnectivityManager) r5     // Catch: java.lang.Exception -> L3b
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L3b
            r2 = 23
            r3 = 0
            if (r1 < r2) goto L2d
            android.net.Network r1 = h1.e.a(r5)     // Catch: java.lang.Exception -> L3b
            if (r1 != 0) goto L21
            return r3
        L21:
            android.net.NetworkCapabilities r5 = h1.f.a(r5, r1)     // Catch: java.lang.Exception -> L3b
            if (r5 != 0) goto L28
            return r3
        L28:
            boolean r5 = a3.i.a(r5, r0)     // Catch: java.lang.Exception -> L3b
            return r5
        L2d:
            android.net.NetworkInfo r5 = r5.getNetworkInfo(r0)     // Catch: java.lang.Exception -> L3b
            if (r5 == 0) goto L3a
            boolean r5 = r5.isConnected()     // Catch: java.lang.Exception -> L3b
            if (r5 == 0) goto L3a
            goto L3b
        L3a:
            r0 = 0
        L3b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.j.j(android.content.Context):boolean");
    }
}
