package y3;

import a4.r;
import c4.d;
import c4.e;
import c4.g;
import java.io.Serializable;
import java.util.HashMap;
import k3.a0;
import k3.j;
import k3.o;
import w3.h;

/* loaded from: classes.dex */
public class c extends r.a implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public HashMap f19737a = null;

    /* renamed from: b, reason: collision with root package name */
    public HashMap f19738b = null;

    /* renamed from: c, reason: collision with root package name */
    public boolean f19739c = false;

    @Override // a4.r
    public o a(a0 a0Var, e eVar, k3.c cVar, h hVar, o oVar) {
        return c(a0Var, eVar, cVar);
    }

    @Override // a4.r
    public o b(a0 a0Var, c4.a aVar, k3.c cVar, h hVar, o oVar) {
        return c(a0Var, aVar, cVar);
    }

    @Override // a4.r.a, a4.r
    public o c(a0 a0Var, j jVar, k3.c cVar) {
        o i10;
        o oVar;
        Class q10 = jVar.q();
        c4.b bVar = new c4.b(q10);
        if (q10.isInterface()) {
            HashMap hashMap = this.f19738b;
            if (hashMap != null && (oVar = (o) hashMap.get(bVar)) != null) {
                return oVar;
            }
        } else {
            HashMap hashMap2 = this.f19737a;
            if (hashMap2 != null) {
                o oVar2 = (o) hashMap2.get(bVar);
                if (oVar2 != null) {
                    return oVar2;
                }
                if (this.f19739c && jVar.F()) {
                    bVar.b(Enum.class);
                    o oVar3 = (o) this.f19737a.get(bVar);
                    if (oVar3 != null) {
                        return oVar3;
                    }
                }
                for (Class cls = q10; cls != null; cls = cls.getSuperclass()) {
                    bVar.b(cls);
                    o oVar4 = (o) this.f19737a.get(bVar);
                    if (oVar4 != null) {
                        return oVar4;
                    }
                }
            }
        }
        if (this.f19738b == null) {
            return null;
        }
        o i11 = i(q10, bVar);
        if (i11 != null) {
            return i11;
        }
        if (q10.isInterface()) {
            return null;
        }
        do {
            q10 = q10.getSuperclass();
            if (q10 == null) {
                return null;
            }
            i10 = i(q10, bVar);
        } while (i10 == null);
        return i10;
    }

    @Override // a4.r
    public o e(a0 a0Var, c4.h hVar, k3.c cVar, o oVar, h hVar2, o oVar2) {
        return c(a0Var, hVar, cVar);
    }

    @Override // a4.r
    public o f(a0 a0Var, d dVar, k3.c cVar, h hVar, o oVar) {
        return c(a0Var, dVar, cVar);
    }

    @Override // a4.r
    public o g(a0 a0Var, g gVar, k3.c cVar, o oVar, h hVar, o oVar2) {
        return c(a0Var, gVar, cVar);
    }

    public void h(Class cls, o oVar) {
        c4.b bVar = new c4.b(cls);
        if (cls.isInterface()) {
            if (this.f19738b == null) {
                this.f19738b = new HashMap();
            }
            this.f19738b.put(bVar, oVar);
        } else {
            if (this.f19737a == null) {
                this.f19737a = new HashMap();
            }
            this.f19737a.put(bVar, oVar);
            if (cls == Enum.class) {
                this.f19739c = true;
            }
        }
    }

    public o i(Class cls, c4.b bVar) {
        for (Class<?> cls2 : cls.getInterfaces()) {
            bVar.b(cls2);
            o oVar = (o) this.f19738b.get(bVar);
            if (oVar != null) {
                return oVar;
            }
            o i10 = i(cls2, bVar);
            if (i10 != null) {
                return i10;
            }
        }
        return null;
    }

    public void j(o oVar) {
        Class handledType = oVar.handledType();
        if (handledType != null && handledType != Object.class) {
            h(handledType, oVar);
            return;
        }
        throw new IllegalArgumentException("JsonSerializer of type " + oVar.getClass().getName() + " does not define valid handledType() -- must either register with method that takes type argument  or make serializer extend 'com.fasterxml.jackson.databind.ser.std.StdSerializer'");
    }
}
