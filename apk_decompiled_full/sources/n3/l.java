package n3;

import b3.k0;
import b3.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k3.k;
import k3.p;
import o3.z;

/* loaded from: classes.dex */
public abstract class l extends k3.g {

    /* renamed from: m, reason: collision with root package name */
    public transient LinkedHashMap f17234m;

    /* renamed from: n, reason: collision with root package name */
    public List f17235n;

    public static final class a extends l {
        public a(n nVar) {
            super(nVar, (m) null);
        }

        @Override // n3.l
        public l Q0(k3.f fVar) {
            return new a(this, fVar);
        }

        @Override // n3.l
        public l R0(k3.f fVar, c3.k kVar, k3.i iVar) {
            return new a(this, fVar, kVar, iVar);
        }

        @Override // n3.l
        public l V0(n nVar) {
            return new a(this, nVar);
        }

        public a(a aVar, k3.f fVar, c3.k kVar, k3.i iVar) {
            super(aVar, fVar, kVar, iVar);
        }

        public a(a aVar, n nVar) {
            super(aVar, nVar);
        }

        public a(a aVar, k3.f fVar) {
            super(aVar, fVar);
        }
    }

    public l(n nVar, m mVar) {
        super(nVar, mVar);
    }

    @Override // k3.g
    public z H(Object obj, k0 k0Var, o0 o0Var) {
        if (obj == null) {
            return null;
        }
        k0.a f10 = k0Var.f(obj);
        LinkedHashMap linkedHashMap = this.f17234m;
        if (linkedHashMap == null) {
            this.f17234m = new LinkedHashMap();
        } else {
            z zVar = (z) linkedHashMap.get(f10);
            if (zVar != null) {
                return zVar;
            }
        }
        List list = this.f17235n;
        if (list == null) {
            this.f17235n = new ArrayList(8);
        } else {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                androidx.appcompat.app.m.a(it.next());
                throw null;
            }
        }
        o0Var.a(this);
        this.f17235n.add(null);
        z S0 = S0(f10);
        S0.g(null);
        this.f17234m.put(f10, S0);
        return S0;
    }

    public Object O0(c3.k kVar, k3.j jVar, k3.k kVar2, Object obj) {
        String c10 = this.f14881c.J(jVar).c();
        c3.n n10 = kVar.n();
        c3.n nVar = c3.n.START_OBJECT;
        if (n10 != nVar) {
            F0(jVar, nVar, "Current token not START_OBJECT (needed to unwrap root name %s), but %s", d4.h.U(c10), kVar.n());
        }
        c3.n s02 = kVar.s0();
        c3.n nVar2 = c3.n.FIELD_NAME;
        if (s02 != nVar2) {
            F0(jVar, nVar2, "Current token not FIELD_NAME (to contain expected root name %s), but %s", d4.h.U(c10), kVar.n());
        }
        String m10 = kVar.m();
        if (!c10.equals(m10)) {
            B0(jVar, m10, "Root name (%s) does not match expected (%s) for type %s", d4.h.U(m10), d4.h.U(c10), d4.h.G(jVar));
        }
        kVar.s0();
        Object deserialize = obj == null ? kVar2.deserialize(kVar, this) : kVar2.deserialize(kVar, this, obj);
        c3.n s03 = kVar.s0();
        c3.n nVar3 = c3.n.END_OBJECT;
        if (s03 != nVar3) {
            F0(jVar, nVar3, "Current token not END_OBJECT (to match wrapper object with root name %s), but %s", d4.h.U(c10), kVar.n());
        }
        return deserialize;
    }

    public void P0() {
        if (this.f17234m != null && n0(k3.h.FAIL_ON_UNRESOLVED_OBJECT_IDS)) {
            Iterator it = this.f17234m.entrySet().iterator();
            u uVar = null;
            while (it.hasNext()) {
                z zVar = (z) ((Map.Entry) it.next()).getValue();
                if (zVar.d() && !U0(zVar)) {
                    if (uVar == null) {
                        uVar = new u(S(), "Unresolved forward references for: ");
                    }
                    Object obj = zVar.c().f4543c;
                    Iterator e10 = zVar.e();
                    while (e10.hasNext()) {
                        z.a aVar = (z.a) e10.next();
                        uVar.s(obj, aVar.a(), aVar.b());
                    }
                }
            }
            if (uVar != null) {
                throw uVar;
            }
        }
    }

    public abstract l Q0(k3.f fVar);

    public abstract l R0(k3.f fVar, c3.k kVar, k3.i iVar);

    public z S0(k0.a aVar) {
        return new z(aVar);
    }

    public Object T0(c3.k kVar, k3.j jVar, k3.k kVar2, Object obj) {
        return this.f14881c.k0() ? O0(kVar, jVar, kVar2, obj) : obj == null ? kVar2.deserialize(kVar, this) : kVar2.deserialize(kVar, this, obj);
    }

    public boolean U0(z zVar) {
        return zVar.h(this);
    }

    public abstract l V0(n nVar);

    @Override // k3.g
    public final k3.p p0(r3.b bVar, Object obj) {
        k3.p pVar;
        if (obj == null) {
            return null;
        }
        if (obj instanceof k3.p) {
            pVar = (k3.p) obj;
        } else {
            if (!(obj instanceof Class)) {
                throw new IllegalStateException("AnnotationIntrospector returned key deserializer definition of type " + obj.getClass().getName() + "; expected type KeyDeserializer or Class<KeyDeserializer> instead");
            }
            Class cls = (Class) obj;
            if (cls == p.a.class || d4.h.J(cls)) {
                return null;
            }
            if (!k3.p.class.isAssignableFrom(cls)) {
                throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<KeyDeserializer>");
            }
            this.f14881c.u();
            pVar = (k3.p) d4.h.l(cls, this.f14881c.b());
        }
        if (pVar instanceof r) {
            ((r) pVar).resolve(this);
        }
        return pVar;
    }

    @Override // k3.g
    public k3.k y(r3.b bVar, Object obj) {
        k3.k kVar;
        if (obj == null) {
            return null;
        }
        if (obj instanceof k3.k) {
            kVar = (k3.k) obj;
        } else {
            if (!(obj instanceof Class)) {
                throw new IllegalStateException("AnnotationIntrospector returned deserializer definition of type " + obj.getClass().getName() + "; expected type JsonDeserializer or Class<JsonDeserializer> instead");
            }
            Class cls = (Class) obj;
            if (cls == k.a.class || d4.h.J(cls)) {
                return null;
            }
            if (!k3.k.class.isAssignableFrom(cls)) {
                throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<JsonDeserializer>");
            }
            this.f14881c.u();
            kVar = (k3.k) d4.h.l(cls, this.f14881c.b());
        }
        if (kVar instanceof r) {
            ((r) kVar).resolve(this);
        }
        return kVar;
    }

    public l(l lVar, k3.f fVar, c3.k kVar, k3.i iVar) {
        super(lVar, fVar, kVar, iVar);
    }

    public l(l lVar, k3.f fVar) {
        super(lVar, fVar);
    }

    public l(l lVar, n nVar) {
        super(lVar, nVar);
    }
}
