package b8;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.umeng.analytics.pro.f;
import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0074a f5079a = new C0074a(null);

    /* renamed from: b8.a$a, reason: collision with other inner class name */
    public static final class C0074a {
        public C0074a() {
        }

        public /* synthetic */ C0074a(g gVar) {
            this();
        }

        public final boolean a(Context context) {
            i.g(context, f.X);
            Object systemService = context.getSystemService("connectivity");
            i.e(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            NetworkInfo networkInfo = ((ConnectivityManager) systemService).getNetworkInfo(0);
            return networkInfo != null && networkInfo.isConnected();
        }

        public final boolean b(Context context) {
            i.g(context, f.X);
            Object systemService = context.getSystemService("connectivity");
            i.e(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }

        public final boolean c(Context context) {
            i.g(context, f.X);
            Object systemService = context.getSystemService("connectivity");
            i.e(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            NetworkInfo networkInfo = ((ConnectivityManager) systemService).getNetworkInfo(1);
            return networkInfo != null && networkInfo.isConnected();
        }
    }
}
