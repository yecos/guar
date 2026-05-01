package h1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* loaded from: classes.dex */
public abstract class c extends d {

    /* renamed from: h, reason: collision with root package name */
    public static final String f14093h = a1.k.f("BrdcstRcvrCnstrntTrckr");

    /* renamed from: g, reason: collision with root package name */
    public final BroadcastReceiver f14094g;

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                c.this.h(context, intent);
            }
        }
    }

    public c(Context context, m1.a aVar) {
        super(context, aVar);
        this.f14094g = new a();
    }

    @Override // h1.d
    public void e() {
        a1.k.c().a(f14093h, String.format("%s: registering receiver", getClass().getSimpleName()), new Throwable[0]);
        this.f14098b.registerReceiver(this.f14094g, g());
    }

    @Override // h1.d
    public void f() {
        a1.k.c().a(f14093h, String.format("%s: unregistering receiver", getClass().getSimpleName()), new Throwable[0]);
        this.f14098b.unregisterReceiver(this.f14094g);
    }

    public abstract IntentFilter g();

    public abstract void h(Context context, Intent intent);
}
