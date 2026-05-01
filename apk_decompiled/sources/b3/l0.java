package b3;

/* loaded from: classes.dex */
public abstract class l0 extends k0 {

    /* renamed from: a, reason: collision with root package name */
    public final Class f4545a;

    public l0(Class cls) {
        this.f4545a = cls;
    }

    @Override // b3.k0
    public boolean a(k0 k0Var) {
        return k0Var.getClass() == getClass() && k0Var.d() == this.f4545a;
    }

    @Override // b3.k0
    public final Class d() {
        return this.f4545a;
    }
}
