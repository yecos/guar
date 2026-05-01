package androidx.work.impl.background.systemalarm;

import a1.k;
import android.content.Intent;
import androidx.lifecycle.i;
import androidx.work.impl.background.systemalarm.d;
import k1.n;

/* loaded from: classes.dex */
public class SystemAlarmService extends i implements d.c {

    /* renamed from: d, reason: collision with root package name */
    public static final String f3674d = k.f("SystemAlarmService");

    /* renamed from: b, reason: collision with root package name */
    public d f3675b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3676c;

    @Override // androidx.work.impl.background.systemalarm.d.c
    public void b() {
        this.f3676c = true;
        k.c().a(f3674d, "All commands completed in dispatcher", new Throwable[0]);
        n.a();
        stopSelf();
    }

    public final void e() {
        d dVar = new d(this);
        this.f3675b = dVar;
        dVar.m(this);
    }

    @Override // androidx.lifecycle.i, android.app.Service
    public void onCreate() {
        super.onCreate();
        e();
        this.f3676c = false;
    }

    @Override // androidx.lifecycle.i, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f3676c = true;
        this.f3675b.j();
    }

    @Override // androidx.lifecycle.i, android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        super.onStartCommand(intent, i10, i11);
        if (this.f3676c) {
            k.c().d(f3674d, "Re-initializing SystemAlarmDispatcher after a request to shut-down.", new Throwable[0]);
            this.f3675b.j();
            e();
            this.f3676c = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f3675b.a(intent, i11);
        return 3;
    }
}
