package c4;

import com.raizlabs.android.dbflow.sql.language.Operator;

/* loaded from: classes.dex */
public class k extends m {

    /* renamed from: l, reason: collision with root package name */
    public k3.j f5555l;

    public k(Class cls, n nVar) {
        super(cls, nVar, null, null, 0, null, null, false);
    }

    @Override // k3.j
    public boolean D() {
        return false;
    }

    @Override // k3.j
    public k3.j P(Class cls, n nVar, k3.j jVar, k3.j[] jVarArr) {
        return null;
    }

    @Override // k3.j
    public k3.j R(k3.j jVar) {
        return this;
    }

    @Override // k3.j
    public k3.j S(Object obj) {
        return this;
    }

    @Override // k3.j
    public k3.j T(Object obj) {
        return this;
    }

    @Override // k3.j
    public k3.j V() {
        return this;
    }

    @Override // k3.j
    public k3.j W(Object obj) {
        return this;
    }

    @Override // k3.j
    public k3.j X(Object obj) {
        return this;
    }

    public k3.j b0() {
        return this.f5555l;
    }

    public void c0(k3.j jVar) {
        if (this.f5555l == null) {
            this.f5555l = jVar;
            return;
        }
        throw new IllegalStateException("Trying to re-set self reference; old value = " + this.f5555l + ", new = " + jVar);
    }

    @Override // k3.j
    public boolean equals(Object obj) {
        return obj == this;
    }

    @Override // c4.m, k3.j
    public n j() {
        k3.j jVar = this.f5555l;
        return jVar != null ? jVar.j() : super.j();
    }

    @Override // k3.j
    public StringBuilder l(StringBuilder sb) {
        k3.j jVar = this.f5555l;
        return jVar != null ? jVar.l(sb) : sb;
    }

    @Override // k3.j
    public StringBuilder n(StringBuilder sb) {
        k3.j jVar = this.f5555l;
        if (jVar != null) {
            return jVar.l(sb);
        }
        sb.append(Operator.Operation.EMPTY_PARAM);
        return sb;
    }

    @Override // c4.m, k3.j
    public k3.j s() {
        k3.j jVar = this.f5555l;
        return jVar != null ? jVar.s() : super.s();
    }

    @Override // k3.j
    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("[recursive type; ");
        k3.j jVar = this.f5555l;
        if (jVar == null) {
            sb.append("UNRESOLVED");
        } else {
            sb.append(jVar.q().getName());
        }
        return sb.toString();
    }
}
