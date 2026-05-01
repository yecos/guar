package ca;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes3.dex */
public final class x0 extends w0 implements j0 {

    /* renamed from: d, reason: collision with root package name */
    public final Executor f5815d;

    public x0(Executor executor) {
        this.f5815d = executor;
        kotlinx.coroutines.internal.d.a(P());
    }

    @Override // ca.y
    public void L(k9.f fVar, Runnable runnable) {
        try {
            Executor P = P();
            c.a();
            P.execute(runnable);
        } catch (RejectedExecutionException e10) {
            c.a();
            O(fVar, e10);
            n0.b().L(fVar, runnable);
        }
    }

    public final void O(k9.f fVar, RejectedExecutionException rejectedExecutionException) {
        j1.c(fVar, v0.a("The task was rejected", rejectedExecutionException));
    }

    public Executor P() {
        return this.f5815d;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor P = P();
        ExecutorService executorService = P instanceof ExecutorService ? (ExecutorService) P : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof x0) && ((x0) obj).P() == P();
    }

    public int hashCode() {
        return System.identityHashCode(P());
    }

    @Override // ca.y
    public String toString() {
        return P().toString();
    }
}
