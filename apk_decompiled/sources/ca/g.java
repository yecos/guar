package ca;

/* loaded from: classes3.dex */
public abstract /* synthetic */ class g {
    public static final f1 a(c0 c0Var, k9.f fVar, e0 e0Var, s9.p pVar) {
        k9.f d10 = x.d(c0Var, fVar);
        u1 o1Var = e0Var.c() ? new o1(d10, pVar) : new u1(d10, true);
        o1Var.v0(e0Var, o1Var, pVar);
        return o1Var;
    }

    public static /* synthetic */ f1 b(c0 c0Var, k9.f fVar, e0 e0Var, s9.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            fVar = k9.g.f15708a;
        }
        if ((i10 & 2) != 0) {
            e0Var = e0.DEFAULT;
        }
        return f.a(c0Var, fVar, e0Var, pVar);
    }
}
