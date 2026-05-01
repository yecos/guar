package x3;

import java.util.EnumMap;
import java.util.EnumSet;

/* loaded from: classes.dex */
public class k extends r {

    /* renamed from: c, reason: collision with root package name */
    public final w3.c f19424c;

    public k(k3.j jVar, c4.o oVar, w3.c cVar) {
        super(jVar, oVar);
        this.f19424c = cVar;
    }

    public static k i(k3.j jVar, m3.m mVar, w3.c cVar) {
        return new k(jVar, mVar.z(), cVar);
    }

    @Override // w3.f
    public String a(Object obj) {
        return g(obj, obj.getClass(), this.f19448a);
    }

    @Override // w3.f
    public String b() {
        return "class name used as type id";
    }

    @Override // w3.f
    public String d(Object obj, Class cls) {
        return g(obj, cls, this.f19448a);
    }

    @Override // w3.f
    public k3.j f(k3.e eVar, String str) {
        return h(str, eVar);
    }

    public String g(Object obj, Class cls, c4.o oVar) {
        if (d4.h.L(cls) && !cls.isEnum()) {
            cls = cls.getSuperclass();
        }
        String name = cls.getName();
        return name.startsWith("java.util.") ? obj instanceof EnumSet ? oVar.y(EnumSet.class, d4.h.u((EnumSet) obj)).c() : obj instanceof EnumMap ? oVar.C(EnumMap.class, d4.h.t((EnumMap) obj), Object.class).c() : name : (name.indexOf(36) < 0 || d4.h.E(cls) == null || d4.h.E(this.f19449b.q()) != null) ? name : this.f19449b.q().getName();
    }

    public k3.j h(String str, k3.e eVar) {
        k3.j r10 = eVar.r(this.f19449b, str, this.f19424c);
        return (r10 == null && (eVar instanceof k3.g)) ? ((k3.g) eVar).f0(this.f19449b, str, this, "no such class found") : r10;
    }
}
