package y3;

import c4.d;
import c4.g;
import c4.h;
import java.io.Serializable;
import java.util.HashMap;
import k3.f;
import k3.j;
import k3.k;
import k3.p;
import n3.o;
import w3.e;

/* loaded from: classes.dex */
public class a extends o.a implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public HashMap f19728a = null;

    /* renamed from: b, reason: collision with root package name */
    public boolean f19729b = false;

    @Override // n3.o
    public k a(j jVar, f fVar, k3.c cVar) {
        return j(jVar);
    }

    @Override // n3.o
    public k b(c4.j jVar, f fVar, k3.c cVar, e eVar, k kVar) {
        return j(jVar);
    }

    @Override // n3.o
    public k c(h hVar, f fVar, k3.c cVar, p pVar, e eVar, k kVar) {
        return j(hVar);
    }

    @Override // n3.o
    public k d(Class cls, f fVar, k3.c cVar) {
        HashMap hashMap = this.f19728a;
        if (hashMap == null) {
            return null;
        }
        k kVar = (k) hashMap.get(new c4.b(cls));
        return (kVar == null && this.f19729b && cls.isEnum()) ? (k) this.f19728a.get(new c4.b(Enum.class)) : kVar;
    }

    @Override // n3.o
    public k e(d dVar, f fVar, k3.c cVar, e eVar, k kVar) {
        return j(dVar);
    }

    @Override // n3.o
    public k f(Class cls, f fVar, k3.c cVar) {
        HashMap hashMap = this.f19728a;
        if (hashMap == null) {
            return null;
        }
        return (k) hashMap.get(new c4.b(cls));
    }

    @Override // n3.o
    public k g(c4.a aVar, f fVar, k3.c cVar, e eVar, k kVar) {
        return j(aVar);
    }

    @Override // n3.o
    public k h(c4.e eVar, f fVar, k3.c cVar, e eVar2, k kVar) {
        return j(eVar);
    }

    @Override // n3.o
    public k i(g gVar, f fVar, k3.c cVar, p pVar, e eVar, k kVar) {
        return j(gVar);
    }

    public final k j(j jVar) {
        HashMap hashMap = this.f19728a;
        if (hashMap == null) {
            return null;
        }
        return (k) hashMap.get(new c4.b(jVar.q()));
    }

    public void k(Class cls, k kVar) {
        c4.b bVar = new c4.b(cls);
        if (this.f19728a == null) {
            this.f19728a = new HashMap();
        }
        this.f19728a.put(bVar, kVar);
        if (cls == Enum.class) {
            this.f19729b = true;
        }
    }
}
