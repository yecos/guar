package z3;

import k3.c0;

/* loaded from: classes.dex */
public class p extends v {

    /* renamed from: a, reason: collision with root package name */
    public static final p f20211a = new p();

    public static p v() {
        return f20211a;
    }

    @Override // z3.v, c3.v
    public c3.n b() {
        return c3.n.VALUE_NULL;
    }

    @Override // z3.b, k3.n
    public final void d(c3.h hVar, c0 c0Var) {
        c0Var.E(hVar);
    }

    public boolean equals(Object obj) {
        return obj == this || (obj instanceof p);
    }

    @Override // k3.m
    public String g() {
        return "null";
    }

    public int hashCode() {
        return m.NULL.ordinal();
    }

    @Override // k3.m
    public m o() {
        return m.NULL;
    }
}
