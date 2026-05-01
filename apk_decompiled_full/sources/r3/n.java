package r3;

/* loaded from: classes.dex */
public abstract class n extends i {

    /* renamed from: c, reason: collision with root package name */
    public final p[] f18452c;

    public n(f0 f0Var, p pVar, p[] pVarArr) {
        super(f0Var, pVar);
        this.f18452c = pVarArr;
    }

    public abstract Object q();

    public abstract Object r(Object[] objArr);

    public abstract Object s(Object obj);

    public final m t(int i10) {
        return new m(this, w(i10), this.f18439a, u(i10), i10);
    }

    public final p u(int i10) {
        p[] pVarArr = this.f18452c;
        if (pVarArr == null || i10 < 0 || i10 >= pVarArr.length) {
            return null;
        }
        return pVarArr[i10];
    }

    public abstract int v();

    public abstract k3.j w(int i10);

    public abstract Class x(int i10);

    public m y(int i10, p pVar) {
        this.f18452c[i10] = pVar;
        return t(i10);
    }
}
