package x3;

import com.fasterxml.jackson.databind.deser.std.u;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public abstract class q extends w3.e implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final w3.f f19440a;

    /* renamed from: b, reason: collision with root package name */
    public final k3.j f19441b;

    /* renamed from: c, reason: collision with root package name */
    public final k3.d f19442c;

    /* renamed from: d, reason: collision with root package name */
    public final k3.j f19443d;

    /* renamed from: e, reason: collision with root package name */
    public final String f19444e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f19445f;

    /* renamed from: g, reason: collision with root package name */
    public final Map f19446g;

    /* renamed from: h, reason: collision with root package name */
    public k3.k f19447h;

    public q(k3.j jVar, w3.f fVar, String str, boolean z10, k3.j jVar2) {
        this.f19441b = jVar;
        this.f19440a = fVar;
        this.f19444e = d4.h.Z(str);
        this.f19445f = z10;
        this.f19446g = new ConcurrentHashMap(16, 0.75f, 2);
        this.f19443d = jVar2;
        this.f19442c = null;
    }

    @Override // w3.e
    public Class h() {
        return d4.h.d0(this.f19443d);
    }

    @Override // w3.e
    public final String i() {
        return this.f19444e;
    }

    @Override // w3.e
    public w3.f j() {
        return this.f19440a;
    }

    @Override // w3.e
    public boolean l() {
        return this.f19443d != null;
    }

    public Object m(c3.k kVar, k3.g gVar, Object obj) {
        k3.k o10;
        if (obj == null) {
            o10 = n(gVar);
            if (o10 == null) {
                return gVar.y0(r(), "No (native) type id found when one was expected for polymorphic type handling", new Object[0]);
            }
        } else {
            o10 = o(gVar, obj instanceof String ? (String) obj : String.valueOf(obj));
        }
        return o10.deserialize(kVar, gVar);
    }

    public final k3.k n(k3.g gVar) {
        k3.k kVar;
        k3.j jVar = this.f19443d;
        if (jVar == null) {
            if (gVar.n0(k3.h.FAIL_ON_INVALID_SUBTYPE)) {
                return null;
            }
            return u.f6613a;
        }
        if (d4.h.J(jVar.q())) {
            return u.f6613a;
        }
        synchronized (this.f19443d) {
            if (this.f19447h == null) {
                this.f19447h = gVar.D(this.f19443d, this.f19442c);
            }
            kVar = this.f19447h;
        }
        return kVar;
    }

    public final k3.k o(k3.g gVar, String str) {
        k3.k D;
        k3.k kVar = (k3.k) this.f19446g.get(str);
        if (kVar == null) {
            k3.j f10 = this.f19440a.f(gVar, str);
            if (f10 == null) {
                kVar = n(gVar);
                if (kVar == null) {
                    k3.j q10 = q(gVar, str);
                    if (q10 == null) {
                        return u.f6613a;
                    }
                    D = gVar.D(q10, this.f19442c);
                }
                this.f19446g.put(str, kVar);
            } else {
                k3.j jVar = this.f19441b;
                if (jVar != null && jVar.getClass() == f10.getClass() && !f10.w()) {
                    try {
                        f10 = gVar.w(this.f19441b, f10.q());
                    } catch (IllegalArgumentException e10) {
                        throw gVar.m(this.f19441b, str, e10.getMessage());
                    }
                }
                D = gVar.D(f10, this.f19442c);
            }
            kVar = D;
            this.f19446g.put(str, kVar);
        }
        return kVar;
    }

    public k3.j p(k3.g gVar, String str) {
        return gVar.X(this.f19441b, this.f19440a, str);
    }

    public k3.j q(k3.g gVar, String str) {
        String str2;
        String b10 = this.f19440a.b();
        if (b10 == null) {
            str2 = "type ids are not statically known";
        } else {
            str2 = "known type ids = " + b10;
        }
        k3.d dVar = this.f19442c;
        if (dVar != null) {
            str2 = String.format("%s (for POJO property '%s')", str2, dVar.getName());
        }
        return gVar.f0(this.f19441b, str, this.f19440a, str2);
    }

    public k3.j r() {
        return this.f19441b;
    }

    public String s() {
        return this.f19441b.q().getName();
    }

    public String toString() {
        return '[' + getClass().getName() + "; base-type:" + this.f19441b + "; id-resolver: " + this.f19440a + ']';
    }

    public q(q qVar, k3.d dVar) {
        this.f19441b = qVar.f19441b;
        this.f19440a = qVar.f19440a;
        this.f19444e = qVar.f19444e;
        this.f19445f = qVar.f19445f;
        this.f19446g = qVar.f19446g;
        this.f19443d = qVar.f19443d;
        this.f19447h = qVar.f19447h;
        this.f19442c = dVar;
    }
}
