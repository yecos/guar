package o3;

import java.lang.reflect.Constructor;
import n3.t;

/* loaded from: classes.dex */
public final class j extends t.a {

    /* renamed from: p, reason: collision with root package name */
    public final transient Constructor f17533p;

    public j(n3.t tVar, Constructor constructor) {
        super(tVar);
        this.f17533p = constructor;
    }

    @Override // n3.t.a
    public n3.t N(n3.t tVar) {
        return tVar == this.f17261o ? this : new j(tVar, this.f17533p);
    }

    @Override // n3.t
    public void l(c3.k kVar, k3.g gVar, Object obj) {
        Object obj2;
        Object obj3;
        if (kVar.n() == c3.n.VALUE_NULL) {
            obj3 = this.f17254g.getNullValue(gVar);
        } else {
            w3.e eVar = this.f17255h;
            if (eVar != null) {
                obj3 = this.f17254g.deserializeWithType(kVar, gVar, eVar);
            } else {
                try {
                    obj2 = this.f17533p.newInstance(obj);
                } catch (Exception e10) {
                    d4.h.m0(e10, String.format("Failed to instantiate class %s, problem: %s", this.f17533p.getDeclaringClass().getName(), e10.getMessage()));
                    obj2 = null;
                }
                this.f17254g.deserialize(kVar, gVar, obj2);
                obj3 = obj2;
            }
        }
        C(obj, obj3);
    }

    @Override // n3.t
    public Object m(c3.k kVar, k3.g gVar, Object obj) {
        return D(obj, k(kVar, gVar));
    }
}
