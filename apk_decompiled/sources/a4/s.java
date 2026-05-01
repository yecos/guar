package a4;

import b3.r;
import k3.c0;

/* loaded from: classes.dex */
public abstract class s extends c {
    public s(r3.s sVar, d4.b bVar, k3.j jVar, k3.o oVar, w3.h hVar, k3.j jVar2, r.b bVar2, Class[] clsArr) {
        super(sVar, sVar.s(), bVar, jVar, oVar, hVar, jVar2, F(bVar2), G(bVar2), clsArr);
    }

    public static boolean F(r.b bVar) {
        r.a h10;
        return (bVar == null || (h10 = bVar.h()) == r.a.ALWAYS || h10 == r.a.USE_DEFAULTS) ? false : true;
    }

    public static Object G(r.b bVar) {
        if (bVar == null) {
            return Boolean.FALSE;
        }
        r.a h10 = bVar.h();
        if (h10 == r.a.ALWAYS || h10 == r.a.NON_NULL || h10 == r.a.USE_DEFAULTS) {
            return null;
        }
        return c.f183t;
    }

    public abstract Object H(Object obj, c3.h hVar, c0 c0Var);

    public abstract s I(m3.m mVar, r3.c cVar, r3.s sVar, k3.j jVar);

    @Override // a4.c
    public void x(Object obj, c3.h hVar, c0 c0Var) {
        Object H = H(obj, hVar, c0Var);
        if (H == null) {
            k3.o oVar = this.f194m;
            if (oVar != null) {
                oVar.serialize(null, hVar, c0Var);
                return;
            } else {
                hVar.a0();
                return;
            }
        }
        k3.o oVar2 = this.f193l;
        if (oVar2 == null) {
            Class<?> cls = H.getClass();
            b4.k kVar = this.f196o;
            k3.o j10 = kVar.j(cls);
            oVar2 = j10 == null ? h(kVar, cls, c0Var) : j10;
        }
        Object obj2 = this.f198q;
        if (obj2 != null) {
            if (c.f183t == obj2) {
                if (oVar2.isEmpty(c0Var, H)) {
                    A(obj, hVar, c0Var);
                    return;
                }
            } else if (obj2.equals(H)) {
                A(obj, hVar, c0Var);
                return;
            }
        }
        if (H == obj && i(obj, hVar, c0Var, oVar2)) {
            return;
        }
        w3.h hVar2 = this.f195n;
        if (hVar2 == null) {
            oVar2.serialize(H, hVar, c0Var);
        } else {
            oVar2.serializeWithType(H, hVar, c0Var, hVar2);
        }
    }

    @Override // a4.c
    public void y(Object obj, c3.h hVar, c0 c0Var) {
        Object H = H(obj, hVar, c0Var);
        if (H == null) {
            if (this.f194m != null) {
                hVar.Y(this.f184c);
                this.f194m.serialize(null, hVar, c0Var);
                return;
            }
            return;
        }
        k3.o oVar = this.f193l;
        if (oVar == null) {
            Class<?> cls = H.getClass();
            b4.k kVar = this.f196o;
            k3.o j10 = kVar.j(cls);
            oVar = j10 == null ? h(kVar, cls, c0Var) : j10;
        }
        Object obj2 = this.f198q;
        if (obj2 != null) {
            if (c.f183t == obj2) {
                if (oVar.isEmpty(c0Var, H)) {
                    return;
                }
            } else if (obj2.equals(H)) {
                return;
            }
        }
        if (H == obj && i(obj, hVar, c0Var, oVar)) {
            return;
        }
        hVar.Y(this.f184c);
        w3.h hVar2 = this.f195n;
        if (hVar2 == null) {
            oVar.serialize(H, hVar, c0Var);
        } else {
            oVar.serializeWithType(H, hVar, c0Var, hVar2);
        }
    }
}
