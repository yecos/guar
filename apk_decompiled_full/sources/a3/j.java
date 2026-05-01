package a3;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
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
    */
    public final boolean g(Context context) {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        boolean hasTransport;
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        try {
            Object systemService = context.getSystemService("connectivity");
            t9.i.e(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            if (Build.VERSION.SDK_INT < 23) {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
                return networkInfo != null && networkInfo.isConnected();
            }
            activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null || networkCapabilities == null) {
                return false;
            }
            hasTransport = networkCapabilities.hasTransport(1);
            return hasTransport;
        } catch (Exception unused) {
            return true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
    
        r5 = r5.getNetworkCapabilities(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean h(Context context) {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        boolean hasTransport;
        boolean hasTransport2;
        boolean hasTransport3;
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        try {
            Object systemService = context.getSystemService("connectivity");
            t9.i.e(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            if (Build.VERSION.SDK_INT < 23) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                return activeNetworkInfo != null && activeNetworkInfo.isConnected();
            }
            activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null || networkCapabilities == null) {
                return false;
            }
            hasTransport = networkCapabilities.hasTransport(1);
            if (hasTransport) {
                return true;
            }
            hasTransport2 = networkCapabilities.hasTransport(0);
            if (hasTransport2) {
                return true;
            }
            hasTransport3 = networkCapabilities.hasTransport(3);
            return hasTransport3;
        } catch (Exception unused) {
            return true;
        }
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
    */
    public final boolean j(Context context) {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        boolean hasTransport;
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        try {
            Object systemService = context.getSystemService("connectivity");
            t9.i.e(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            if (Build.VERSION.SDK_INT < 23) {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                return networkInfo != null && networkInfo.isConnected();
            }
            activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null || networkCapabilities == null) {
                return false;
            }
            hasTransport = networkCapabilities.hasTransport(1);
            return hasTransport;
        } catch (Exception unused) {
            return true;
        }
    }
}
