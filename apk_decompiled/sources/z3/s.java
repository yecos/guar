package z3;

import k3.c0;

/* loaded from: classes.dex */
public class s extends v {

    /* renamed from: a, reason: collision with root package name */
    public final Object f20213a;

    public s(Object obj) {
        this.f20213a = obj;
    }

    @Override // z3.v, c3.v
    public c3.n b() {
        return c3.n.VALUE_EMBEDDED_OBJECT;
    }

    @Override // z3.b, k3.n
    public final void d(c3.h hVar, c0 c0Var) {
        Object obj = this.f20213a;
        if (obj == null) {
            c0Var.E(hVar);
        } else if (obj instanceof k3.n) {
            ((k3.n) obj).d(hVar, c0Var);
        } else {
            c0Var.F(obj, hVar);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof s)) {
            return v((s) obj);
        }
        return false;
    }

    @Override // k3.m
    public String g() {
        Object obj = this.f20213a;
        return obj == null ? "null" : obj.toString();
    }

    public int hashCode() {
        return this.f20213a.hashCode();
    }

    @Override // k3.m
    public byte[] i() {
        Object obj = this.f20213a;
        return obj instanceof byte[] ? (byte[]) obj : super.i();
    }

    @Override // k3.m
    public m o() {
        return m.POJO;
    }

    public boolean v(s sVar) {
        Object obj = this.f20213a;
        return obj == null ? sVar.f20213a == null : obj.equals(sVar.f20213a);
    }

    public Object w() {
        return this.f20213a;
    }
}
