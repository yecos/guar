package z3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k3.c0;

/* loaded from: classes.dex */
public class a extends f {

    /* renamed from: b, reason: collision with root package name */
    public final List f20160b;

    public a(l lVar) {
        super(lVar);
        this.f20160b = new ArrayList();
    }

    public a A(k3.m mVar) {
        this.f20160b.add(mVar);
        return this;
    }

    public a B(String str) {
        return str == null ? D() : A(z(str));
    }

    public a C(k3.m mVar) {
        if (mVar == null) {
            mVar = x();
        }
        A(mVar);
        return this;
    }

    public a D() {
        A(x());
        return this;
    }

    @Override // c3.v
    public c3.n b() {
        return c3.n.START_ARRAY;
    }

    @Override // z3.b, k3.n
    public void d(c3.h hVar, c0 c0Var) {
        List list = this.f20160b;
        int size = list.size();
        hVar.u0(this, size);
        for (int i10 = 0; i10 < size; i10++) {
            ((b) ((k3.m) list.get(i10))).d(hVar, c0Var);
        }
        hVar.V();
    }

    @Override // k3.n
    public void e(c3.h hVar, c0 c0Var, w3.h hVar2) {
        i3.b g10 = hVar2.g(hVar, hVar2.d(this, c3.n.START_ARRAY));
        Iterator it = this.f20160b.iterator();
        while (it.hasNext()) {
            ((b) ((k3.m) it.next())).d(hVar, c0Var);
        }
        hVar2.h(hVar, g10);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof a)) {
            return this.f20160b.equals(((a) obj).f20160b);
        }
        return false;
    }

    @Override // k3.n.a
    public boolean f(c0 c0Var) {
        return this.f20160b.isEmpty();
    }

    public int hashCode() {
        return this.f20160b.hashCode();
    }

    @Override // k3.m
    public Iterator l() {
        return this.f20160b.iterator();
    }

    @Override // k3.m
    public k3.m n(String str) {
        return null;
    }

    @Override // k3.m
    public m o() {
        return m.ARRAY;
    }

    @Override // k3.m
    public boolean p() {
        return true;
    }
}
