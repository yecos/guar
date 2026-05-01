package n0;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Handler;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import n0.p0;
import n0.q1;

/* loaded from: classes.dex */
public final class t1 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f17101a;

    /* renamed from: b, reason: collision with root package name */
    public final c f17102b;

    /* renamed from: d, reason: collision with root package name */
    public final PackageManager f17104d;

    /* renamed from: f, reason: collision with root package name */
    public boolean f17106f;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f17105e = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public final BroadcastReceiver f17107g = new a();

    /* renamed from: h, reason: collision with root package name */
    public final Runnable f17108h = new b();

    /* renamed from: c, reason: collision with root package name */
    public final Handler f17103c = new Handler();

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            t1.this.h();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            t1.this.h();
        }
    }

    public interface c {
        void a(p0 p0Var);

        void b(p0 p0Var);

        void d(q1 q1Var, p0.e eVar);
    }

    public t1(Context context, c cVar) {
        this.f17101a = context;
        this.f17102b = cVar;
        this.f17104d = context.getPackageManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(q1 q1Var, p0.e eVar) {
        this.f17102b.d(q1Var, eVar);
    }

    public static boolean g(List list, ServiceInfo serviceInfo) {
        if (serviceInfo != null && list != null && !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ServiceInfo serviceInfo2 = (ServiceInfo) it.next();
                if (serviceInfo.packageName.equals(serviceInfo2.packageName) && serviceInfo.name.equals(serviceInfo2.name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int c(String str, String str2) {
        int size = this.f17105e.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (((q1) this.f17105e.get(i10)).G(str, str2)) {
                return i10;
            }
        }
        return -1;
    }

    public List d() {
        Stream stream;
        Stream map;
        Collector list;
        Object collect;
        stream = this.f17104d.queryIntentServices(new Intent("android.media.MediaRoute2ProviderService"), 0).stream();
        map = stream.map(new Function() { // from class: n0.s1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                ServiceInfo serviceInfo;
                serviceInfo = ((ResolveInfo) obj).serviceInfo;
                return serviceInfo;
            }
        });
        list = Collectors.toList();
        collect = map.collect(list);
        return (List) collect;
    }

    public void h() {
        int i10;
        if (this.f17106f) {
            List arrayList = new ArrayList();
            if (Build.VERSION.SDK_INT >= 30) {
                arrayList = d();
            }
            int i11 = 0;
            Iterator<ResolveInfo> it = this.f17104d.queryIntentServices(new Intent("android.media.MediaRouteProviderService"), 0).iterator();
            while (it.hasNext()) {
                ServiceInfo serviceInfo = it.next().serviceInfo;
                if (serviceInfo != null && (!t0.n() || !g(arrayList, serviceInfo))) {
                    int c10 = c(serviceInfo.packageName, serviceInfo.name);
                    if (c10 < 0) {
                        final q1 q1Var = new q1(this.f17101a, new ComponentName(serviceInfo.packageName, serviceInfo.name));
                        q1Var.P(new q1.b() { // from class: n0.r1
                            @Override // n0.q1.b
                            public final void a(p0.e eVar) {
                                t1.this.f(q1Var, eVar);
                            }
                        });
                        q1Var.R();
                        i10 = i11 + 1;
                        this.f17105e.add(i11, q1Var);
                        this.f17102b.a(q1Var);
                    } else if (c10 >= i11) {
                        q1 q1Var2 = (q1) this.f17105e.get(c10);
                        q1Var2.R();
                        q1Var2.O();
                        i10 = i11 + 1;
                        Collections.swap(this.f17105e, c10, i11);
                    }
                    i11 = i10;
                }
            }
            if (i11 < this.f17105e.size()) {
                for (int size = this.f17105e.size() - 1; size >= i11; size--) {
                    q1 q1Var3 = (q1) this.f17105e.get(size);
                    this.f17102b.b(q1Var3);
                    this.f17105e.remove(q1Var3);
                    q1Var3.P(null);
                    q1Var3.S();
                }
            }
        }
    }

    public void i() {
        if (this.f17106f) {
            return;
        }
        this.f17106f = true;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addAction("android.intent.action.PACKAGE_RESTARTED");
        intentFilter.addDataScheme(Constants.KEY_PACKAGE);
        this.f17101a.registerReceiver(this.f17107g, intentFilter, null, this.f17103c);
        this.f17103c.post(this.f17108h);
    }
}
