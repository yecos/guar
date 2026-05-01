package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.room.a;
import androidx.room.b;
import androidx.room.c;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3319a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3320b;

    /* renamed from: c, reason: collision with root package name */
    public int f3321c;

    /* renamed from: d, reason: collision with root package name */
    public final androidx.room.c f3322d;

    /* renamed from: e, reason: collision with root package name */
    public final c.AbstractC0051c f3323e;

    /* renamed from: f, reason: collision with root package name */
    public androidx.room.b f3324f;

    /* renamed from: g, reason: collision with root package name */
    public final Executor f3325g;

    /* renamed from: h, reason: collision with root package name */
    public final androidx.room.a f3326h = new a();

    /* renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f3327i = new AtomicBoolean(false);

    /* renamed from: j, reason: collision with root package name */
    public final ServiceConnection f3328j;

    /* renamed from: k, reason: collision with root package name */
    public final Runnable f3329k;

    /* renamed from: l, reason: collision with root package name */
    public final Runnable f3330l;

    /* renamed from: m, reason: collision with root package name */
    public final Runnable f3331m;

    public class a extends a.AbstractBinderC0048a {

        /* renamed from: androidx.room.d$a$a, reason: collision with other inner class name */
        public class RunnableC0052a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String[] f3333a;

            public RunnableC0052a(String[] strArr) {
                this.f3333a = strArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f3322d.e(this.f3333a);
            }
        }

        public a() {
        }

        @Override // androidx.room.a
        public void a(String[] strArr) {
            d.this.f3325g.execute(new RunnableC0052a(strArr));
        }
    }

    public class b implements ServiceConnection {
        public b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.f3324f = b.a.i0(iBinder);
            d dVar = d.this;
            dVar.f3325g.execute(dVar.f3329k);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d dVar = d.this;
            dVar.f3325g.execute(dVar.f3330l);
            d.this.f3324f = null;
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d dVar = d.this;
                androidx.room.b bVar = dVar.f3324f;
                if (bVar != null) {
                    dVar.f3321c = bVar.d(dVar.f3326h, dVar.f3320b);
                    d dVar2 = d.this;
                    dVar2.f3322d.a(dVar2.f3323e);
                }
            } catch (RemoteException unused) {
            }
        }
    }

    /* renamed from: androidx.room.d$d, reason: collision with other inner class name */
    public class RunnableC0053d implements Runnable {
        public RunnableC0053d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            dVar.f3322d.g(dVar.f3323e);
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            dVar.f3322d.g(dVar.f3323e);
            try {
                d dVar2 = d.this;
                androidx.room.b bVar = dVar2.f3324f;
                if (bVar != null) {
                    bVar.g0(dVar2.f3326h, dVar2.f3321c);
                }
            } catch (RemoteException unused) {
            }
            d dVar3 = d.this;
            dVar3.f3319a.unbindService(dVar3.f3328j);
        }
    }

    public class f extends c.AbstractC0051c {
        public f(String[] strArr) {
            super(strArr);
        }

        @Override // androidx.room.c.AbstractC0051c
        public boolean a() {
            return true;
        }

        @Override // androidx.room.c.AbstractC0051c
        public void b(Set set) {
            if (d.this.f3327i.get()) {
                return;
            }
            try {
                d dVar = d.this;
                androidx.room.b bVar = dVar.f3324f;
                if (bVar != null) {
                    bVar.b(dVar.f3321c, (String[]) set.toArray(new String[0]));
                }
            } catch (RemoteException unused) {
            }
        }
    }

    public d(Context context, String str, androidx.room.c cVar, Executor executor) {
        b bVar = new b();
        this.f3328j = bVar;
        this.f3329k = new c();
        this.f3330l = new RunnableC0053d();
        this.f3331m = new e();
        Context applicationContext = context.getApplicationContext();
        this.f3319a = applicationContext;
        this.f3320b = str;
        this.f3322d = cVar;
        this.f3325g = executor;
        this.f3323e = new f((String[]) cVar.f3296a.keySet().toArray(new String[0]));
        applicationContext.bindService(new Intent(applicationContext, (Class<?>) MultiInstanceInvalidationService.class), bVar, 1);
    }
}
