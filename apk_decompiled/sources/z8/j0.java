package z8;

import com.google.common.base.MoreObjects;
import java.util.concurrent.Executor;
import z8.j1;
import z8.s;

/* loaded from: classes3.dex */
public abstract class j0 implements v {
    public abstract v a();

    @Override // z8.s
    public q b(y8.w0 w0Var, y8.v0 v0Var, y8.c cVar, y8.k[] kVarArr) {
        return a().b(w0Var, v0Var, cVar, kVarArr);
    }

    @Override // z8.j1
    public void c(y8.k1 k1Var) {
        a().c(k1Var);
    }

    @Override // y8.m0
    public y8.i0 d() {
        return a().d();
    }

    @Override // z8.j1
    public Runnable e(j1.a aVar) {
        return a().e(aVar);
    }

    @Override // z8.s
    public void f(s.a aVar, Executor executor) {
        a().f(aVar, executor);
    }

    @Override // z8.j1
    public void g(y8.k1 k1Var) {
        a().g(k1Var);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", a()).toString();
    }
}
