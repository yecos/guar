package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* loaded from: classes.dex */
public abstract class i extends Service implements g {

    /* renamed from: a, reason: collision with root package name */
    public final u f2579a = new u(this);

    @Override // androidx.lifecycle.g
    public d getLifecycle() {
        return this.f2579a.a();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        this.f2579a.b();
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.f2579a.c();
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f2579a.d();
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i10) {
        this.f2579a.e();
        super.onStart(intent, i10);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        return super.onStartCommand(intent, i10, i11);
    }
}
