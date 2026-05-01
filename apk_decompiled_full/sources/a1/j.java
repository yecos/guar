package a1;

import ca.f1;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class j implements ListenableFuture {

    /* renamed from: a, reason: collision with root package name */
    public final f1 f111a;

    /* renamed from: b, reason: collision with root package name */
    public final l1.c f112b;

    public static final class a extends t9.j implements s9.l {
        public a() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            if (th == null) {
                if (!j.this.f112b.isDone()) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            } else {
                if (th instanceof CancellationException) {
                    j.this.f112b.cancel(true);
                    return;
                }
                l1.c cVar = j.this.f112b;
                Throwable cause = th.getCause();
                if (cause != null) {
                    th = cause;
                }
                cVar.p(th);
            }
        }
    }

    public j(f1 f1Var, l1.c cVar) {
        t9.i.g(f1Var, "job");
        t9.i.g(cVar, "underlying");
        this.f111a = f1Var;
        this.f112b = cVar;
        f1Var.e(new a());
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        this.f112b.addListener(runnable, executor);
    }

    public final void b(Object obj) {
        this.f112b.o(obj);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        return this.f112b.cancel(z10);
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        return this.f112b.get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f112b.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.f112b.isDone();
    }

    @Override // java.util.concurrent.Future
    public Object get(long j10, TimeUnit timeUnit) {
        return this.f112b.get(j10, timeUnit);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ j(f1 f1Var, l1.c cVar, int i10, t9.g gVar) {
        this(f1Var, cVar);
        if ((i10 & 2) != 0) {
            cVar = l1.c.s();
            t9.i.f(cVar, "create()");
        }
    }
}
