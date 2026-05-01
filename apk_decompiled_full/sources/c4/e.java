package c4;

/* loaded from: classes.dex */
public final class e extends d {
    public e(Class cls, n nVar, k3.j jVar, k3.j[] jVarArr, k3.j jVar2, Object obj, Object obj2, boolean z10) {
        super(cls, nVar, jVar, jVarArr, jVar2, obj, obj2, z10);
    }

    public static e b0(Class cls, n nVar, k3.j jVar, k3.j[] jVarArr, k3.j jVar2) {
        return new e(cls, nVar, jVar, jVarArr, jVar2, null, null, false);
    }

    @Override // k3.j
    public k3.j P(Class cls, n nVar, k3.j jVar, k3.j[] jVarArr) {
        return new e(cls, nVar, jVar, jVarArr, this.f5534l, this.f14920c, this.f14921d, this.f14922e);
    }

    @Override // k3.j
    public k3.j R(k3.j jVar) {
        return this.f5534l == jVar ? this : new e(this.f14918a, this.f5560h, this.f5558f, this.f5559g, jVar, this.f14920c, this.f14921d, this.f14922e);
    }

    @Override // k3.j
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public e S(Object obj) {
        return new e(this.f14918a, this.f5560h, this.f5558f, this.f5559g, this.f5534l.e0(obj), this.f14920c, this.f14921d, this.f14922e);
    }

    @Override // k3.j
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public e c0(Object obj) {
        return new e(this.f14918a, this.f5560h, this.f5558f, this.f5559g, this.f5534l.f0(obj), this.f14920c, this.f14921d, this.f14922e);
    }

    @Override // k3.j
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public e d0() {
        return this.f14922e ? this : new e(this.f14918a, this.f5560h, this.f5558f, this.f5559g, this.f5534l.d0(), this.f14920c, this.f14921d, true);
    }

    @Override // k3.j
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public e e0(Object obj) {
        return new e(this.f14918a, this.f5560h, this.f5558f, this.f5559g, this.f5534l, this.f14920c, obj, this.f14922e);
    }

    @Override // k3.j
    /* renamed from: g0, reason: merged with bridge method [inline-methods] */
    public e f0(Object obj) {
        return new e(this.f14918a, this.f5560h, this.f5558f, this.f5559g, this.f5534l, obj, this.f14921d, this.f14922e);
    }

    @Override // k3.j
    public String toString() {
        return "[collection type; class " + this.f14918a.getName() + ", contains " + this.f5534l + "]";
    }
}
