package androidx.work.impl.background.systemalarm;

import a1.k;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import b1.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k1.n;
import k1.r;

/* loaded from: classes.dex */
public class d implements b1.b {

    /* renamed from: k, reason: collision with root package name */
    public static final String f3696k = k.f("SystemAlarmDispatcher");

    /* renamed from: a, reason: collision with root package name */
    public final Context f3697a;

    /* renamed from: b, reason: collision with root package name */
    public final m1.a f3698b;

    /* renamed from: c, reason: collision with root package name */
    public final r f3699c;

    /* renamed from: d, reason: collision with root package name */
    public final b1.d f3700d;

    /* renamed from: e, reason: collision with root package name */
    public final j f3701e;

    /* renamed from: f, reason: collision with root package name */
    public final androidx.work.impl.background.systemalarm.a f3702f;

    /* renamed from: g, reason: collision with root package name */
    public final Handler f3703g;

    /* renamed from: h, reason: collision with root package name */
    public final List f3704h;

    /* renamed from: i, reason: collision with root package name */
    public Intent f3705i;

    /* renamed from: j, reason: collision with root package name */
    public c f3706j;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar;
            RunnableC0061d runnableC0061d;
            synchronized (d.this.f3704h) {
                d dVar2 = d.this;
                dVar2.f3705i = (Intent) dVar2.f3704h.get(0);
            }
            Intent intent = d.this.f3705i;
            if (intent != null) {
                String action = intent.getAction();
                int intExtra = d.this.f3705i.getIntExtra("KEY_START_ID", 0);
                k c10 = k.c();
                String str = d.f3696k;
                c10.a(str, String.format("Processing command %s, %s", d.this.f3705i, Integer.valueOf(intExtra)), new Throwable[0]);
                PowerManager.WakeLock b10 = n.b(d.this.f3697a, String.format("%s (%s)", action, Integer.valueOf(intExtra)));
                try {
                    k.c().a(str, String.format("Acquiring operation wake lock (%s) %s", action, b10), new Throwable[0]);
                    b10.acquire();
                    d dVar3 = d.this;
                    dVar3.f3702f.p(dVar3.f3705i, intExtra, dVar3);
                    k.c().a(str, String.format("Releasing operation wake lock (%s) %s", action, b10), new Throwable[0]);
                    b10.release();
                    dVar = d.this;
                    runnableC0061d = new RunnableC0061d(dVar);
                } catch (Throwable th) {
                    try {
                        k c11 = k.c();
                        String str2 = d.f3696k;
                        c11.b(str2, "Unexpected error in onHandleIntent", th);
                        k.c().a(str2, String.format("Releasing operation wake lock (%s) %s", action, b10), new Throwable[0]);
                        b10.release();
                        dVar = d.this;
                        runnableC0061d = new RunnableC0061d(dVar);
                    } catch (Throwable th2) {
                        k.c().a(d.f3696k, String.format("Releasing operation wake lock (%s) %s", action, b10), new Throwable[0]);
                        b10.release();
                        d dVar4 = d.this;
                        dVar4.k(new RunnableC0061d(dVar4));
                        throw th2;
                    }
                }
                dVar.k(runnableC0061d);
            }
        }
    }

    public static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final d f3708a;

        /* renamed from: b, reason: collision with root package name */
        public final Intent f3709b;

        /* renamed from: c, reason: collision with root package name */
        public final int f3710c;

        public b(d dVar, Intent intent, int i10) {
            this.f3708a = dVar;
            this.f3709b = intent;
            this.f3710c = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3708a.a(this.f3709b, this.f3710c);
        }
    }

    public interface c {
        void b();
    }

    /* renamed from: androidx.work.impl.background.systemalarm.d$d, reason: collision with other inner class name */
    public static class RunnableC0061d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final d f3711a;

        public RunnableC0061d(d dVar) {
            this.f3711a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3711a.d();
        }
    }

    public d(Context context) {
        this(context, null, null);
    }

    public boolean a(Intent intent, int i10) {
        k c10 = k.c();
        String str = f3696k;
        c10.a(str, String.format("Adding command %s (%s)", intent, Integer.valueOf(i10)), new Throwable[0]);
        b();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            k.c().h(str, "Unknown command. Ignoring", new Throwable[0]);
            return false;
        }
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action) && i("ACTION_CONSTRAINTS_CHANGED")) {
            return false;
        }
        intent.putExtra("KEY_START_ID", i10);
        synchronized (this.f3704h) {
            boolean z10 = this.f3704h.isEmpty() ? false : true;
            this.f3704h.add(intent);
            if (!z10) {
                l();
            }
        }
        return true;
    }

    public final void b() {
        if (this.f3703g.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    @Override // b1.b
    public void c(String str, boolean z10) {
        k(new b(this, androidx.work.impl.background.systemalarm.a.d(this.f3697a, str, z10), 0));
    }

    public void d() {
        k c10 = k.c();
        String str = f3696k;
        c10.a(str, "Checking if commands are complete.", new Throwable[0]);
        b();
        synchronized (this.f3704h) {
            if (this.f3705i != null) {
                k.c().a(str, String.format("Removing command %s", this.f3705i), new Throwable[0]);
                if (!((Intent) this.f3704h.remove(0)).equals(this.f3705i)) {
                    throw new IllegalStateException("Dequeue-d command is not the first.");
                }
                this.f3705i = null;
            }
            k1.k c11 = this.f3698b.c();
            if (!this.f3702f.o() && this.f3704h.isEmpty() && !c11.a()) {
                k.c().a(str, "No more commands & intents.", new Throwable[0]);
                c cVar = this.f3706j;
                if (cVar != null) {
                    cVar.b();
                }
            } else if (!this.f3704h.isEmpty()) {
                l();
            }
        }
    }

    public b1.d e() {
        return this.f3700d;
    }

    public m1.a f() {
        return this.f3698b;
    }

    public j g() {
        return this.f3701e;
    }

    public r h() {
        return this.f3699c;
    }

    public final boolean i(String str) {
        b();
        synchronized (this.f3704h) {
            Iterator it = this.f3704h.iterator();
            while (it.hasNext()) {
                if (str.equals(((Intent) it.next()).getAction())) {
                    return true;
                }
            }
            return false;
        }
    }

    public void j() {
        k.c().a(f3696k, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        this.f3700d.i(this);
        this.f3699c.a();
        this.f3706j = null;
    }

    public void k(Runnable runnable) {
        this.f3703g.post(runnable);
    }

    public final void l() {
        b();
        PowerManager.WakeLock b10 = n.b(this.f3697a, "ProcessCommand");
        try {
            b10.acquire();
            this.f3701e.o().b(new a());
        } finally {
            b10.release();
        }
    }

    public void m(c cVar) {
        if (this.f3706j != null) {
            k.c().b(f3696k, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
        } else {
            this.f3706j = cVar;
        }
    }

    public d(Context context, b1.d dVar, j jVar) {
        Context applicationContext = context.getApplicationContext();
        this.f3697a = applicationContext;
        this.f3702f = new androidx.work.impl.background.systemalarm.a(applicationContext);
        this.f3699c = new r();
        jVar = jVar == null ? j.j(context) : jVar;
        this.f3701e = jVar;
        dVar = dVar == null ? jVar.l() : dVar;
        this.f3700d = dVar;
        this.f3698b = jVar.o();
        dVar.d(this);
        this.f3704h = new ArrayList();
        this.f3705i = null;
        this.f3703g = new Handler(Looper.getMainLooper());
    }
}
