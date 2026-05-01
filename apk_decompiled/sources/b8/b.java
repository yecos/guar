package b8;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.umeng.analytics.pro.f;
import t9.i;

/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public final Activity f5080a;

    /* renamed from: b, reason: collision with root package name */
    public int f5081b;

    /* renamed from: c, reason: collision with root package name */
    public final AudioManager f5082c;

    /* renamed from: d, reason: collision with root package name */
    public final BroadcastReceiver f5083d;

    public static final class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            i.g(context, f.X);
            i.g(intent, "intent");
            int intExtra = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", 0);
            int intExtra2 = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", 0);
            if (intExtra == 3) {
                b.this.f(intExtra2);
            }
        }
    }

    public b(Activity activity) {
        i.g(activity, "mActivity");
        this.f5080a = activity;
        Object systemService = activity.getSystemService("audio");
        i.e(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.f5082c = (AudioManager) systemService;
        this.f5083d = new a();
    }

    public static /* synthetic */ void b(b bVar, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: disable");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        bVar.a(z10);
    }

    public final void a(boolean z10) {
        if (z10) {
            this.f5082c.setStreamVolume(3, this.f5081b, 0);
        }
        this.f5080a.unregisterReceiver(this.f5083d);
    }

    public final void c() {
        int d10 = d();
        this.f5081b = d10;
        f(d10);
        this.f5080a.registerReceiver(this.f5083d, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
    }

    public final int d() {
        return this.f5082c.getStreamVolume(3);
    }

    public final int e() {
        return this.f5082c.getStreamMaxVolume(3);
    }

    public abstract void f(int i10);

    public final void g(int i10) {
        this.f5082c.setStreamVolume(3, i10, 16);
    }
}
