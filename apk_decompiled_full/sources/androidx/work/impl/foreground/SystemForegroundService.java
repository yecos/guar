package androidx.work.impl.foreground;

import a1.k;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.i;
import androidx.work.impl.foreground.a;

/* loaded from: classes.dex */
public class SystemForegroundService extends i implements a.b {

    /* renamed from: f, reason: collision with root package name */
    public static final String f3716f = k.f("SystemFgService");

    /* renamed from: g, reason: collision with root package name */
    public static SystemForegroundService f3717g = null;

    /* renamed from: b, reason: collision with root package name */
    public Handler f3718b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3719c;

    /* renamed from: d, reason: collision with root package name */
    public androidx.work.impl.foreground.a f3720d;

    /* renamed from: e, reason: collision with root package name */
    public NotificationManager f3721e;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f3722a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Notification f3723b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f3724c;

        public a(int i10, Notification notification, int i11) {
            this.f3722a = i10;
            this.f3723b = notification;
            this.f3724c = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Build.VERSION.SDK_INT >= 29) {
                SystemForegroundService.this.startForeground(this.f3722a, this.f3723b, this.f3724c);
            } else {
                SystemForegroundService.this.startForeground(this.f3722a, this.f3723b);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f3726a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Notification f3727b;

        public b(int i10, Notification notification) {
            this.f3726a = i10;
            this.f3727b = notification;
        }

        @Override // java.lang.Runnable
        public void run() {
            SystemForegroundService.this.f3721e.notify(this.f3726a, this.f3727b);
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f3729a;

        public c(int i10) {
            this.f3729a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            SystemForegroundService.this.f3721e.cancel(this.f3729a);
        }
    }

    @Override // androidx.work.impl.foreground.a.b
    public void a(int i10, Notification notification) {
        this.f3718b.post(new b(i10, notification));
    }

    @Override // androidx.work.impl.foreground.a.b
    public void c(int i10, int i11, Notification notification) {
        this.f3718b.post(new a(i10, notification, i11));
    }

    @Override // androidx.work.impl.foreground.a.b
    public void d(int i10) {
        this.f3718b.post(new c(i10));
    }

    public final void e() {
        this.f3718b = new Handler(Looper.getMainLooper());
        this.f3721e = (NotificationManager) getApplicationContext().getSystemService("notification");
        androidx.work.impl.foreground.a aVar = new androidx.work.impl.foreground.a(getApplicationContext());
        this.f3720d = aVar;
        aVar.m(this);
    }

    @Override // androidx.lifecycle.i, android.app.Service
    public void onCreate() {
        super.onCreate();
        f3717g = this;
        e();
    }

    @Override // androidx.lifecycle.i, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f3720d.k();
    }

    @Override // androidx.lifecycle.i, android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        super.onStartCommand(intent, i10, i11);
        if (this.f3719c) {
            k.c().d(f3716f, "Re-initializing SystemForegroundService after a request to shut-down.", new Throwable[0]);
            this.f3720d.k();
            e();
            this.f3719c = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f3720d.l(intent);
        return 3;
    }

    @Override // androidx.work.impl.foreground.a.b
    public void stop() {
        this.f3719c = true;
        k.c().a(f3716f, "All commands completed.", new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 26) {
            stopForeground(true);
        }
        f3717g = null;
        stopSelf();
    }
}
