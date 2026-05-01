package r3;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;

/* loaded from: classes.dex */
public final class m extends i {

    /* renamed from: c, reason: collision with root package name */
    public final n f18449c;

    /* renamed from: d, reason: collision with root package name */
    public final k3.j f18450d;

    /* renamed from: e, reason: collision with root package name */
    public final int f18451e;

    public m(n nVar, k3.j jVar, f0 f0Var, p pVar, int i10) {
        super(f0Var, pVar);
        this.f18449c = nVar;
        this.f18450d = jVar;
        this.f18451e = i10;
    }

    @Override // r3.b
    public AnnotatedElement b() {
        return null;
    }

    @Override // r3.b
    public String d() {
        return "";
    }

    @Override // r3.b
    public Class e() {
        return this.f18450d.q();
    }

    @Override // r3.b
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!d4.h.H(obj, m.class)) {
            return false;
        }
        m mVar = (m) obj;
        return mVar.f18449c.equals(this.f18449c) && mVar.f18451e == this.f18451e;
    }

    @Override // r3.b
    public k3.j f() {
        return this.f18450d;
    }

    @Override // r3.b
    public int hashCode() {
        return this.f18449c.hashCode() + this.f18451e;
    }

    @Override // r3.i
    public Class k() {
        return this.f18449c.k();
    }

    @Override // r3.i
    public Member m() {
        return this.f18449c.m();
    }

    @Override // r3.i
    public Object n(Object obj) {
        throw new UnsupportedOperationException("Cannot call getValue() on constructor parameter of " + k().getName());
    }

    @Override // r3.i
    public void o(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Cannot call setValue() on constructor parameter of " + k().getName());
    }

    public int q() {
        return this.f18451e;
    }

    public n r() {
        return this.f18449c;
    }

    @Override // r3.i
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public m p(p pVar) {
        return pVar == this.f18440b ? this : this.f18449c.y(this.f18451e, pVar);
    }

    @Override // r3.b
    public String toString() {
        return "[parameter #" + q() + ", annotations: " + this.f18440b + "]";
    }
}
