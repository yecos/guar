package h1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

/* loaded from: classes.dex */
public class j extends d {

    /* renamed from: j, reason: collision with root package name */
    public static final String f14104j = a1.k.f("NetworkStateTracker");

    /* renamed from: g, reason: collision with root package name */
    public final ConnectivityManager f14105g;

    /* renamed from: h, reason: collision with root package name */
    public b f14106h;

    /* renamed from: i, reason: collision with root package name */
    public a f14107i;

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getAction() == null || !intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                return;
            }
            a1.k.c().a(j.f14104j, "Network broadcast received", new Throwable[0]);
            j jVar = j.this;
            jVar.d(jVar.g());
        }
    }

    public class b extends ConnectivityManager.NetworkCallback {
        public b() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            a1.k.c().a(j.f14104j, String.format("Network capabilities changed: %s", networkCapabilities), new Throwable[0]);
            j jVar = j.this;
            jVar.d(jVar.g());
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            a1.k.c().a(j.f14104j, "Network connection lost", new Throwable[0]);
            j jVar = j.this;
            jVar.d(jVar.g());
        }
    }

    public j(Context context, m1.a aVar) {
        super(context, aVar);
        this.f14105g = (ConnectivityManager) this.f14098b.getSystemService("connectivity");
        if (j()) {
            this.f14106h = new b();
        } else {
            this.f14107i = new a();
        }
    }

    public static boolean j() {
        return Build.VERSION.SDK_INT >= 24;
    }

    @Override // h1.d
    public void e() {
        if (!j()) {
            a1.k.c().a(f14104j, "Registering broadcast receiver", new Throwable[0]);
            this.f14098b.registerReceiver(this.f14107i, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            return;
        }
        try {
            a1.k.c().a(f14104j, "Registering network callback", new Throwable[0]);
            this.f14105g.registerDefaultNetworkCallback(this.f14106h);
        } catch (IllegalArgumentException | SecurityException e10) {
            a1.k.c().b(f14104j, "Received exception while registering network callback", e10);
        }
    }

    @Override // h1.d
    public void f() {
        if (!j()) {
            a1.k.c().a(f14104j, "Unregistering broadcast receiver", new Throwable[0]);
            this.f14098b.unregisterReceiver(this.f14107i);
            return;
        }
        try {
            a1.k.c().a(f14104j, "Unregistering network callback", new Throwable[0]);
            this.f14105g.unregisterNetworkCallback(this.f14106h);
        } catch (IllegalArgumentException | SecurityException e10) {
            a1.k.c().b(f14104j, "Received exception while unregistering network callback", e10);
        }
    }

    public f1.b g() {
        NetworkInfo activeNetworkInfo = this.f14105g.getActiveNetworkInfo();
        return new f1.b(activeNetworkInfo != null && activeNetworkInfo.isConnected(), i(), w.a.a(this.f14105g), (activeNetworkInfo == null || activeNetworkInfo.isRoaming()) ? false : true);
    }

    @Override // h1.d
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public f1.b b() {
        return g();
    }

    public boolean i() {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        boolean hasCapability;
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        try {
            activeNetwork = this.f14105g.getActiveNetwork();
            networkCapabilities = this.f14105g.getNetworkCapabilities(activeNetwork);
            if (networkCapabilities == null) {
                return false;
            }
            hasCapability = networkCapabilities.hasCapability(16);
            return hasCapability;
        } catch (SecurityException e10) {
            a1.k.c().b(f14104j, "Unable to validate active network", e10);
            return false;
        }
    }
}
