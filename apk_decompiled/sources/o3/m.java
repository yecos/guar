package o3;

import java.util.Collection;
import java.util.Map;
import n3.t;

/* loaded from: classes.dex */
public final class m extends t.a {

    /* renamed from: p, reason: collision with root package name */
    public final String f17548p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f17549q;

    /* renamed from: r, reason: collision with root package name */
    public final n3.t f17550r;

    public m(n3.t tVar, String str, n3.t tVar2, boolean z10) {
        super(tVar);
        this.f17548p = str;
        this.f17550r = tVar2;
        this.f17549q = z10;
    }

    @Override // n3.t.a, n3.t
    public final void C(Object obj, Object obj2) {
        D(obj, obj2);
    }

    @Override // n3.t.a, n3.t
    public Object D(Object obj, Object obj2) {
        if (obj2 != null) {
            if (!this.f17549q) {
                this.f17550r.C(obj2, obj);
            } else if (obj2 instanceof Object[]) {
                for (Object obj3 : (Object[]) obj2) {
                    if (obj3 != null) {
                        this.f17550r.C(obj3, obj);
                    }
                }
            } else if (obj2 instanceof Collection) {
                for (Object obj4 : (Collection) obj2) {
                    if (obj4 != null) {
                        this.f17550r.C(obj4, obj);
                    }
                }
            } else {
                if (!(obj2 instanceof Map)) {
                    throw new IllegalStateException("Unsupported container type (" + obj2.getClass().getName() + ") when resolving reference '" + this.f17548p + "'");
                }
                for (Object obj5 : ((Map) obj2).values()) {
                    if (obj5 != null) {
                        this.f17550r.C(obj5, obj);
                    }
                }
            }
        }
        return this.f17261o.D(obj, obj2);
    }

    @Override // n3.t.a
    public n3.t N(n3.t tVar) {
        throw new IllegalStateException("Should never try to reset delegate");
    }

    @Override // n3.t
    public void l(c3.k kVar, k3.g gVar, Object obj) {
        C(obj, this.f17261o.k(kVar, gVar));
    }

    @Override // n3.t
    public Object m(c3.k kVar, k3.g gVar, Object obj) {
        return D(obj, k(kVar, gVar));
    }

    @Override // n3.t.a, n3.t
    public void o(k3.f fVar) {
        this.f17261o.o(fVar);
        this.f17550r.o(fVar);
    }
}
