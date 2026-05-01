package z3;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import k3.b0;
import k3.c0;

/* loaded from: classes.dex */
public class r extends f {

    /* renamed from: b, reason: collision with root package name */
    public final Map f20212b;

    public r(l lVar) {
        super(lVar);
        this.f20212b = new LinkedHashMap();
    }

    public boolean A(r rVar) {
        return this.f20212b.equals(rVar.f20212b);
    }

    public r B(String str, k3.m mVar) {
        this.f20212b.put(str, mVar);
        return this;
    }

    public r C(String str, String str2) {
        return B(str, str2 == null ? x() : z(str2));
    }

    public r D(String str, boolean z10) {
        return B(str, w(z10));
    }

    public a E(String str) {
        a v10 = v();
        B(str, v10);
        return v10;
    }

    public k3.m F(String str, k3.m mVar) {
        if (mVar == null) {
            mVar = x();
        }
        return (k3.m) this.f20212b.put(str, mVar);
    }

    public k3.m G(String str, k3.m mVar) {
        if (mVar == null) {
            mVar = x();
        }
        this.f20212b.put(str, mVar);
        return this;
    }

    @Override // c3.v
    public c3.n b() {
        return c3.n.START_OBJECT;
    }

    @Override // z3.b, k3.n
    public void d(c3.h hVar, c0 c0Var) {
        boolean z10 = (c0Var == null || c0Var.m0(b0.WRITE_EMPTY_JSON_ARRAYS)) ? false : true;
        hVar.w0(this);
        for (Map.Entry entry : this.f20212b.entrySet()) {
            b bVar = (b) entry.getValue();
            if (!z10 || !bVar.p() || !bVar.f(c0Var)) {
                hVar.Z((String) entry.getKey());
                bVar.d(hVar, c0Var);
            }
        }
        hVar.W();
    }

    @Override // k3.n
    public void e(c3.h hVar, c0 c0Var, w3.h hVar2) {
        boolean z10 = (c0Var == null || c0Var.m0(b0.WRITE_EMPTY_JSON_ARRAYS)) ? false : true;
        i3.b g10 = hVar2.g(hVar, hVar2.d(this, c3.n.START_OBJECT));
        for (Map.Entry entry : this.f20212b.entrySet()) {
            b bVar = (b) entry.getValue();
            if (!z10 || !bVar.p() || !bVar.f(c0Var)) {
                hVar.Z((String) entry.getKey());
                bVar.d(hVar, c0Var);
            }
        }
        hVar2.h(hVar, g10);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof r)) {
            return A((r) obj);
        }
        return false;
    }

    @Override // k3.n.a
    public boolean f(c0 c0Var) {
        return this.f20212b.isEmpty();
    }

    public int hashCode() {
        return this.f20212b.hashCode();
    }

    @Override // k3.m
    public Iterator l() {
        return this.f20212b.values().iterator();
    }

    @Override // k3.m
    public Iterator m() {
        return this.f20212b.entrySet().iterator();
    }

    @Override // k3.m
    public k3.m n(String str) {
        return (k3.m) this.f20212b.get(str);
    }

    @Override // k3.m
    public m o() {
        return m.OBJECT;
    }
}
