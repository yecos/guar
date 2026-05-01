package n3;

import b3.k0;
import b3.n0;
import java.io.Serializable;
import java.util.Map;
import n3.w;
import o3.z;
import r3.b0;

/* loaded from: classes.dex */
public class a extends k3.k implements i, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final k3.j f17153a;

    /* renamed from: b, reason: collision with root package name */
    public final o3.s f17154b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f17155c;

    /* renamed from: d, reason: collision with root package name */
    public transient Map f17156d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f17157e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f17158f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f17159g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f17160h;

    public a(e eVar, k3.c cVar, Map map, Map map2) {
        k3.j z10 = cVar.z();
        this.f17153a = z10;
        this.f17154b = eVar.s();
        this.f17155c = map;
        this.f17156d = map2;
        Class q10 = z10.q();
        this.f17157e = q10.isAssignableFrom(String.class);
        this.f17158f = q10 == Boolean.TYPE || q10.isAssignableFrom(Boolean.class);
        this.f17159g = q10 == Integer.TYPE || q10.isAssignableFrom(Integer.class);
        this.f17160h = q10 == Double.TYPE || q10.isAssignableFrom(Double.class);
    }

    public static a c(k3.c cVar) {
        return new a(cVar);
    }

    public Object a(c3.k kVar, k3.g gVar) {
        Object f10 = this.f17154b.f(kVar, gVar);
        o3.s sVar = this.f17154b;
        k0 k0Var = sVar.f17564c;
        sVar.getClass();
        z H = gVar.H(f10, k0Var, null);
        Object f11 = H.f();
        if (f11 != null) {
            return f11;
        }
        throw new u(kVar, "Could not resolve Object Id [" + f10 + "] -- unresolved forward-reference?", kVar.z(), H);
    }

    public Object b(c3.k kVar, k3.g gVar) {
        switch (kVar.q()) {
            case 6:
                if (this.f17157e) {
                    return kVar.Y();
                }
                return null;
            case 7:
                if (this.f17159g) {
                    return Integer.valueOf(kVar.P());
                }
                return null;
            case 8:
                if (this.f17160h) {
                    return Double.valueOf(kVar.M());
                }
                return null;
            case 9:
                if (this.f17158f) {
                    return Boolean.TRUE;
                }
                return null;
            case 10:
                if (this.f17158f) {
                    return Boolean.FALSE;
                }
                return null;
            default:
                return null;
        }
    }

    @Override // n3.i
    public k3.k createContextual(k3.g gVar, k3.d dVar) {
        r3.i d10;
        b0 B;
        k0 n10;
        t tVar;
        k3.j jVar;
        k3.b K = gVar.K();
        if (dVar == null || K == null || (d10 = dVar.d()) == null || (B = K.B(d10)) == null) {
            return this.f17156d == null ? this : new a(this, this.f17154b, null);
        }
        gVar.o(d10, B);
        b0 C = K.C(d10, B);
        Class c10 = C.c();
        if (c10 == n0.class) {
            k3.x d11 = C.d();
            Map map = this.f17156d;
            t tVar2 = map == null ? null : (t) map.get(d11.c());
            if (tVar2 == null) {
                gVar.q(this.f17153a, String.format("Invalid Object Id definition for %s: cannot find property with name %s", d4.h.X(handledType()), d4.h.V(d11)));
            }
            k3.j type = tVar2.getType();
            n10 = new o3.w(C.f());
            jVar = type;
            tVar = tVar2;
        } else {
            gVar.o(d10, C);
            k3.j jVar2 = gVar.l().K(gVar.x(c10), k0.class)[0];
            n10 = gVar.n(d10, C);
            tVar = null;
            jVar = jVar2;
        }
        return new a(this, o3.s.a(jVar, C.d(), n10, gVar.I(jVar), tVar, null), null);
    }

    @Override // k3.k
    public Object deserialize(c3.k kVar, k3.g gVar) {
        return gVar.W(this.f17153a.q(), new w.a(this.f17153a), kVar, "abstract types either need to be mapped to concrete types, have custom deserializer, or contain additional type information", new Object[0]);
    }

    @Override // k3.k
    public Object deserializeWithType(c3.k kVar, k3.g gVar, w3.e eVar) {
        c3.n n10;
        if (this.f17154b != null && (n10 = kVar.n()) != null) {
            if (n10.e()) {
                return a(kVar, gVar);
            }
            if (n10 == c3.n.START_OBJECT) {
                n10 = kVar.s0();
            }
            if (n10 == c3.n.FIELD_NAME && this.f17154b.e() && this.f17154b.d(kVar.m(), kVar)) {
                return a(kVar, gVar);
            }
        }
        Object b10 = b(kVar, gVar);
        return b10 != null ? b10 : eVar.e(kVar, gVar);
    }

    @Override // k3.k
    public t findBackReference(String str) {
        Map map = this.f17155c;
        if (map == null) {
            return null;
        }
        return (t) map.get(str);
    }

    @Override // k3.k
    public o3.s getObjectIdReader() {
        return this.f17154b;
    }

    @Override // k3.k
    public Class handledType() {
        return this.f17153a.q();
    }

    @Override // k3.k
    public boolean isCachable() {
        return true;
    }

    @Override // k3.k
    public c4.f logicalType() {
        return c4.f.POJO;
    }

    @Override // k3.k
    public Boolean supportsUpdate(k3.f fVar) {
        return null;
    }

    public a(k3.c cVar) {
        k3.j z10 = cVar.z();
        this.f17153a = z10;
        this.f17154b = null;
        this.f17155c = null;
        Class q10 = z10.q();
        this.f17157e = q10.isAssignableFrom(String.class);
        this.f17158f = q10 == Boolean.TYPE || q10.isAssignableFrom(Boolean.class);
        this.f17159g = q10 == Integer.TYPE || q10.isAssignableFrom(Integer.class);
        this.f17160h = q10 == Double.TYPE || q10.isAssignableFrom(Double.class);
    }

    public a(a aVar, o3.s sVar, Map map) {
        this.f17153a = aVar.f17153a;
        this.f17155c = aVar.f17155c;
        this.f17157e = aVar.f17157e;
        this.f17158f = aVar.f17158f;
        this.f17159g = aVar.f17159g;
        this.f17160h = aVar.f17160h;
        this.f17154b = sVar;
        this.f17156d = map;
    }
}
