package ca;

import java.util.concurrent.CancellationException;

/* loaded from: classes3.dex */
public abstract /* synthetic */ class k1 {
    public static final q a(f1 f1Var) {
        return new i1(f1Var);
    }

    public static /* synthetic */ q b(f1 f1Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f1Var = null;
        }
        return j1.a(f1Var);
    }

    public static final void c(k9.f fVar, CancellationException cancellationException) {
        f1 f1Var = (f1) fVar.a(f1.f5750a0);
        if (f1Var != null) {
            f1Var.q(cancellationException);
        }
    }
}
