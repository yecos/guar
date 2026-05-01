package o3;

import n3.t;

/* loaded from: classes.dex */
public class n extends t.a {

    /* renamed from: p, reason: collision with root package name */
    public final r3.i f17551p;

    public n(n3.t tVar, r3.i iVar) {
        super(tVar);
        this.f17551p = iVar;
    }

    public static n O(n3.t tVar, r3.i iVar) {
        return new n(tVar, iVar);
    }

    @Override // n3.t.a, n3.t
    public void C(Object obj, Object obj2) {
        if (obj2 != null) {
            this.f17261o.C(obj, obj2);
        }
    }

    @Override // n3.t.a, n3.t
    public Object D(Object obj, Object obj2) {
        return obj2 != null ? this.f17261o.D(obj, obj2) : obj;
    }

    @Override // n3.t.a
    public n3.t N(n3.t tVar) {
        return new n(tVar, this.f17551p);
    }

    @Override // n3.t
    public void l(c3.k kVar, k3.g gVar, Object obj) {
        Object n10 = this.f17551p.n(obj);
        Object k10 = n10 == null ? this.f17261o.k(kVar, gVar) : this.f17261o.n(kVar, gVar, n10);
        if (k10 != n10) {
            this.f17261o.C(obj, k10);
        }
    }

    @Override // n3.t
    public Object m(c3.k kVar, k3.g gVar, Object obj) {
        Object n10 = this.f17551p.n(obj);
        Object k10 = n10 == null ? this.f17261o.k(kVar, gVar) : this.f17261o.n(kVar, gVar, n10);
        return (k10 == n10 || k10 == null) ? obj : this.f17261o.D(obj, k10);
    }
}
