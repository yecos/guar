package z3;

import k3.c0;

/* loaded from: classes.dex */
public class e extends v {

    /* renamed from: b, reason: collision with root package name */
    public static final e f20168b = new e(true);

    /* renamed from: c, reason: collision with root package name */
    public static final e f20169c = new e(false);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f20170a;

    public e(boolean z10) {
        this.f20170a = z10;
    }

    public static e v() {
        return f20169c;
    }

    public static e w() {
        return f20168b;
    }

    @Override // z3.v, c3.v
    public c3.n b() {
        return this.f20170a ? c3.n.VALUE_TRUE : c3.n.VALUE_FALSE;
    }

    @Override // z3.b, k3.n
    public final void d(c3.h hVar, c0 c0Var) {
        hVar.U(this.f20170a);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj != null && (obj instanceof e) && this.f20170a == ((e) obj).f20170a;
    }

    @Override // k3.m
    public String g() {
        return this.f20170a ? "true" : "false";
    }

    public int hashCode() {
        return this.f20170a ? 3 : 1;
    }

    @Override // k3.m
    public m o() {
        return m.BOOLEAN;
    }
}
