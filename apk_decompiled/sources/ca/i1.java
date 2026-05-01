package ca;

/* loaded from: classes3.dex */
public class i1 extends m1 implements q {

    /* renamed from: b, reason: collision with root package name */
    public final boolean f5757b;

    public i1(f1 f1Var) {
        super(true);
        R(f1Var);
        this.f5757b = s0();
    }

    @Override // ca.m1
    public boolean K() {
        return this.f5757b;
    }

    @Override // ca.m1
    public boolean L() {
        return true;
    }

    public final boolean s0() {
        m1 r10;
        n N = N();
        o oVar = N instanceof o ? (o) N : null;
        if (oVar != null && (r10 = oVar.r()) != null) {
            while (!r10.K()) {
                n N2 = r10.N();
                o oVar2 = N2 instanceof o ? (o) N2 : null;
                if (oVar2 != null && (r10 = oVar2.r()) != null) {
                }
            }
            return true;
        }
        return false;
    }
}
