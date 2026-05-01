package io.grpc.stub;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import y8.c;
import y8.g;
import y8.k1;
import y8.l1;
import y8.m1;
import y8.v0;
import y8.w0;

/* loaded from: classes3.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f14424a = Logger.getLogger(g.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public static boolean f14425b;

    /* renamed from: c, reason: collision with root package name */
    public static final c.C0345c f14426c;

    public static final class b extends io.grpc.stub.f {

        /* renamed from: a, reason: collision with root package name */
        public boolean f14427a;

        /* renamed from: b, reason: collision with root package name */
        public final y8.g f14428b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f14429c;

        /* renamed from: d, reason: collision with root package name */
        public Runnable f14430d;

        /* renamed from: e, reason: collision with root package name */
        public int f14431e = 1;

        /* renamed from: f, reason: collision with root package name */
        public boolean f14432f = true;

        /* renamed from: g, reason: collision with root package name */
        public boolean f14433g = false;

        /* renamed from: h, reason: collision with root package name */
        public boolean f14434h = false;

        public b(y8.g gVar, boolean z10) {
            this.f14428b = gVar;
            this.f14429c = z10;
        }

        public final void f() {
            this.f14427a = true;
        }

        public void g(int i10) {
            if (this.f14429c || i10 != 1) {
                this.f14428b.c(i10);
            } else {
                this.f14428b.c(2);
            }
        }

        @Override // io.grpc.stub.j
        public void onCompleted() {
            this.f14428b.b();
            this.f14434h = true;
        }

        @Override // io.grpc.stub.j
        public void onError(Throwable th) {
            this.f14428b.a("Cancelled by client with StreamObserver.onError()", th);
            this.f14433g = true;
        }

        @Override // io.grpc.stub.j
        public void onNext(Object obj) {
            Preconditions.checkState(!this.f14433g, "Stream was terminated by error, no further calls are allowed");
            Preconditions.checkState(!this.f14434h, "Stream is already completed, no further calls are allowed");
            this.f14428b.d(obj);
        }
    }

    public static final class c extends AbstractFuture {

        /* renamed from: a, reason: collision with root package name */
        public final y8.g f14435a;

        public c(y8.g gVar) {
            this.f14435a = gVar;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public void interruptTask() {
            this.f14435a.a("GrpcFuture was cancelled", null);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public String pendingToString() {
            return MoreObjects.toStringHelper(this).add("clientCall", this.f14435a).toString();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public boolean set(Object obj) {
            return super.set(obj);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public boolean setException(Throwable th) {
            return super.setException(th);
        }
    }

    public static abstract class d extends g.a {
        public d() {
        }

        public abstract void e();
    }

    public static final class e extends d {

        /* renamed from: a, reason: collision with root package name */
        public final j f14436a;

        /* renamed from: b, reason: collision with root package name */
        public final b f14437b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f14438c;

        public e(j jVar, b bVar) {
            super();
            this.f14436a = jVar;
            this.f14437b = bVar;
            bVar.f();
        }

        @Override // y8.g.a
        public void a(k1 k1Var, v0 v0Var) {
            if (k1Var.p()) {
                this.f14436a.onCompleted();
            } else {
                this.f14436a.onError(k1Var.e(v0Var));
            }
        }

        @Override // y8.g.a
        public void b(v0 v0Var) {
        }

        @Override // y8.g.a
        public void c(Object obj) {
            if (this.f14438c && !this.f14437b.f14429c) {
                throw k1.f19903t.r("More than one responses received for unary or client-streaming call").d();
            }
            this.f14438c = true;
            this.f14436a.onNext(obj);
            if (this.f14437b.f14429c && this.f14437b.f14432f) {
                this.f14437b.g(1);
            }
        }

        @Override // y8.g.a
        public void d() {
            if (this.f14437b.f14430d != null) {
                this.f14437b.f14430d.run();
            }
        }

        @Override // io.grpc.stub.g.d
        public void e() {
            if (this.f14437b.f14431e > 0) {
                b bVar = this.f14437b;
                bVar.g(bVar.f14431e);
            }
        }
    }

    public enum f {
        BLOCKING,
        FUTURE,
        ASYNC
    }

    /* renamed from: io.grpc.stub.g$g, reason: collision with other inner class name */
    public static final class ExecutorC0235g extends ConcurrentLinkedQueue implements Executor {

        /* renamed from: b, reason: collision with root package name */
        public static final Logger f14443b = Logger.getLogger(ExecutorC0235g.class.getName());

        /* renamed from: c, reason: collision with root package name */
        public static final Object f14444c = new Object();

        /* renamed from: a, reason: collision with root package name */
        public volatile Object f14445a;

        public static void a(Runnable runnable) {
            try {
                runnable.run();
            } catch (Throwable th) {
                f14443b.log(Level.WARNING, "Runnable threw exception", th);
            }
        }

        public static void b() {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
        }

        public void c() {
            Runnable runnable;
            b();
            Runnable runnable2 = (Runnable) poll();
            if (runnable2 == null) {
                this.f14445a = Thread.currentThread();
                while (true) {
                    try {
                        runnable = (Runnable) poll();
                        if (runnable != null) {
                            break;
                        }
                        LockSupport.park(this);
                        b();
                    } catch (Throwable th) {
                        this.f14445a = null;
                        throw th;
                    }
                }
                this.f14445a = null;
                runnable2 = runnable;
            }
            do {
                a(runnable2);
                runnable2 = (Runnable) poll();
            } while (runnable2 != null);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            add(runnable);
            Object obj = this.f14445a;
            if (obj != f14444c) {
                LockSupport.unpark((Thread) obj);
            } else if (remove(runnable) && g.f14425b) {
                throw new RejectedExecutionException();
            }
        }

        public void shutdown() {
            this.f14445a = f14444c;
            while (true) {
                Runnable runnable = (Runnable) poll();
                if (runnable == null) {
                    return;
                } else {
                    a(runnable);
                }
            }
        }
    }

    public static final class h extends d {

        /* renamed from: a, reason: collision with root package name */
        public final c f14446a;

        /* renamed from: b, reason: collision with root package name */
        public Object f14447b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f14448c;

        public h(c cVar) {
            super();
            this.f14448c = false;
            this.f14446a = cVar;
        }

        @Override // y8.g.a
        public void a(k1 k1Var, v0 v0Var) {
            if (!k1Var.p()) {
                this.f14446a.setException(k1Var.e(v0Var));
                return;
            }
            if (!this.f14448c) {
                this.f14446a.setException(k1.f19903t.r("No value received for unary call").e(v0Var));
            }
            this.f14446a.set(this.f14447b);
        }

        @Override // y8.g.a
        public void b(v0 v0Var) {
        }

        @Override // y8.g.a
        public void c(Object obj) {
            if (this.f14448c) {
                throw k1.f19903t.r("More than one value received for unary call").d();
            }
            this.f14447b = obj;
            this.f14448c = true;
        }

        @Override // io.grpc.stub.g.d
        public void e() {
            this.f14446a.f14435a.c(2);
        }
    }

    static {
        f14425b = !Strings.isNullOrEmpty(System.getenv("GRPC_CLIENT_CALL_REJECT_RUNNABLE")) && Boolean.parseBoolean(System.getenv("GRPC_CLIENT_CALL_REJECT_RUNNABLE"));
        f14426c = c.C0345c.b("internal-stub-type");
    }

    public static void a(y8.g gVar, Object obj, j jVar) {
        c(gVar, obj, jVar, false);
    }

    public static void b(y8.g gVar, Object obj, d dVar) {
        h(gVar, dVar);
        try {
            gVar.d(obj);
            gVar.b();
        } catch (Error e10) {
            throw e(gVar, e10);
        } catch (RuntimeException e11) {
            throw e(gVar, e11);
        }
    }

    public static void c(y8.g gVar, Object obj, j jVar, boolean z10) {
        b(gVar, obj, new e(jVar, new b(gVar, z10)));
    }

    public static Object d(y8.d dVar, w0 w0Var, y8.c cVar, Object obj) {
        ExecutorC0235g executorC0235g = new ExecutorC0235g();
        y8.g h10 = dVar.h(w0Var, cVar.s(f14426c, f.BLOCKING).p(executorC0235g));
        boolean z10 = false;
        try {
            try {
                ListenableFuture f10 = f(h10, obj);
                while (!f10.isDone()) {
                    try {
                        executorC0235g.c();
                    } catch (InterruptedException e10) {
                        try {
                            h10.a("Thread interrupted", e10);
                            z10 = true;
                        } catch (Error e11) {
                            e = e11;
                            throw e(h10, e);
                        } catch (RuntimeException e12) {
                            e = e12;
                            throw e(h10, e);
                        } catch (Throwable th) {
                            th = th;
                            z10 = true;
                            if (z10) {
                                Thread.currentThread().interrupt();
                            }
                            throw th;
                        }
                    }
                }
                executorC0235g.shutdown();
                Object g10 = g(f10);
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                return g10;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Error e13) {
            e = e13;
        } catch (RuntimeException e14) {
            e = e14;
        }
    }

    public static RuntimeException e(y8.g gVar, Throwable th) {
        try {
            gVar.a(null, th);
        } catch (Throwable th2) {
            f14424a.log(Level.SEVERE, "RuntimeException encountered while closing call", th2);
        }
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
        throw new AssertionError(th);
    }

    public static ListenableFuture f(y8.g gVar, Object obj) {
        c cVar = new c(gVar);
        b(gVar, obj, new h(cVar));
        return cVar;
    }

    public static Object g(Future future) {
        try {
            return future.get();
        } catch (InterruptedException e10) {
            Thread.currentThread().interrupt();
            throw k1.f19890g.r("Thread interrupted").q(e10).d();
        } catch (ExecutionException e11) {
            throw i(e11.getCause());
        }
    }

    public static void h(y8.g gVar, d dVar) {
        gVar.e(dVar, new v0());
        dVar.e();
    }

    public static m1 i(Throwable th) {
        for (Throwable th2 = (Throwable) Preconditions.checkNotNull(th, "t"); th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof l1) {
                l1 l1Var = (l1) th2;
                return new m1(l1Var.a(), l1Var.b());
            }
            if (th2 instanceof m1) {
                m1 m1Var = (m1) th2;
                return new m1(m1Var.a(), m1Var.b());
            }
        }
        return k1.f19891h.r("unexpected exception").q(th).d();
    }
}
