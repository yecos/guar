package androidx.work.impl.workers;

import a1.k;
import android.content.Context;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import b1.j;
import com.google.common.util.concurrent.ListenableFuture;
import f1.c;
import f1.d;
import j1.p;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class ConstraintTrackingWorker extends ListenableWorker implements c {

    /* renamed from: k, reason: collision with root package name */
    public static final String f3751k = k.f("ConstraintTrkngWrkr");

    /* renamed from: f, reason: collision with root package name */
    public WorkerParameters f3752f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f3753g;

    /* renamed from: h, reason: collision with root package name */
    public volatile boolean f3754h;

    /* renamed from: i, reason: collision with root package name */
    public l1.c f3755i;

    /* renamed from: j, reason: collision with root package name */
    public ListenableWorker f3756j;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ConstraintTrackingWorker.this.u();
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListenableFuture f3758a;

        public b(ListenableFuture listenableFuture) {
            this.f3758a = listenableFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (ConstraintTrackingWorker.this.f3753g) {
                if (ConstraintTrackingWorker.this.f3754h) {
                    ConstraintTrackingWorker.this.t();
                } else {
                    ConstraintTrackingWorker.this.f3755i.q(this.f3758a);
                }
            }
        }
    }

    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.f3752f = workerParameters;
        this.f3753g = new Object();
        this.f3754h = false;
        this.f3755i = l1.c.s();
    }

    @Override // f1.c
    public void b(List list) {
        k.c().a(f3751k, String.format("Constraints changed for %s", list), new Throwable[0]);
        synchronized (this.f3753g) {
            this.f3754h = true;
        }
    }

    @Override // f1.c
    public void d(List list) {
    }

    @Override // androidx.work.ListenableWorker
    public m1.a h() {
        return j.j(a()).o();
    }

    @Override // androidx.work.ListenableWorker
    public boolean j() {
        ListenableWorker listenableWorker = this.f3756j;
        return listenableWorker != null && listenableWorker.j();
    }

    @Override // androidx.work.ListenableWorker
    public void m() {
        super.m();
        ListenableWorker listenableWorker = this.f3756j;
        if (listenableWorker == null || listenableWorker.k()) {
            return;
        }
        this.f3756j.q();
    }

    @Override // androidx.work.ListenableWorker
    public ListenableFuture p() {
        c().execute(new a());
        return this.f3755i;
    }

    public WorkDatabase r() {
        return j.j(a()).n();
    }

    public void s() {
        this.f3755i.o(ListenableWorker.a.a());
    }

    public void t() {
        this.f3755i.o(ListenableWorker.a.b());
    }

    public void u() {
        String i10 = g().i("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
        if (TextUtils.isEmpty(i10)) {
            k.c().b(f3751k, "No worker to delegate to.", new Throwable[0]);
            s();
            return;
        }
        ListenableWorker b10 = i().b(a(), i10, this.f3752f);
        this.f3756j = b10;
        if (b10 == null) {
            k.c().a(f3751k, "No worker to delegate to.", new Throwable[0]);
            s();
            return;
        }
        p h10 = r().B().h(f().toString());
        if (h10 == null) {
            s();
            return;
        }
        d dVar = new d(a(), h(), this);
        dVar.d(Collections.singletonList(h10));
        if (!dVar.c(f().toString())) {
            k.c().a(f3751k, String.format("Constraints not met for delegate %s. Requesting retry.", i10), new Throwable[0]);
            t();
            return;
        }
        k.c().a(f3751k, String.format("Constraints met for delegate %s", i10), new Throwable[0]);
        try {
            ListenableFuture p10 = this.f3756j.p();
            p10.addListener(new b(p10), c());
        } catch (Throwable th) {
            k c10 = k.c();
            String str = f3751k;
            c10.a(str, String.format("Delegated worker %s threw exception in startWork.", i10), th);
            synchronized (this.f3753g) {
                if (this.f3754h) {
                    k.c().a(str, "Constraints were unmet, Retrying.", new Throwable[0]);
                    t();
                } else {
                    s();
                }
            }
        }
    }
}
