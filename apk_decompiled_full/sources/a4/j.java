package a4;

import b3.k0;
import b4.t;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import k3.a0;
import k3.b0;
import k3.c0;
import k3.o;
import k3.x;

/* loaded from: classes.dex */
public abstract class j extends c0 implements Serializable {

    /* renamed from: o, reason: collision with root package name */
    public transient Map f211o;

    /* renamed from: p, reason: collision with root package name */
    public transient ArrayList f212p;

    /* renamed from: q, reason: collision with root package name */
    public transient c3.h f213q;

    public static final class a extends j {
        public a() {
        }

        @Override // a4.j
        /* renamed from: F0, reason: merged with bridge method [inline-methods] */
        public a A0(a0 a0Var, q qVar) {
            return new a(this, a0Var, qVar);
        }

        public a(c0 c0Var, a0 a0Var, q qVar) {
            super(c0Var, a0Var, qVar);
        }
    }

    public j() {
    }

    public abstract j A0(a0 a0Var, q qVar);

    public void B0(c3.h hVar, Object obj, k3.j jVar, k3.o oVar, w3.h hVar2) {
        boolean z10;
        this.f213q = hVar;
        if (obj == null) {
            y0(hVar);
            return;
        }
        if (jVar != null && !jVar.q().isAssignableFrom(obj.getClass())) {
            y(obj, jVar);
        }
        if (oVar == null) {
            oVar = (jVar == null || !jVar.D()) ? S(obj.getClass(), null) : U(jVar, null);
        }
        x S = this.f14850a.S();
        if (S == null) {
            z10 = this.f14850a.c0(b0.WRAP_ROOT_VALUE);
            if (z10) {
                hVar.v0();
                hVar.Y(this.f14850a.I(obj.getClass()).i(this.f14850a));
            }
        } else if (S.h()) {
            z10 = false;
        } else {
            hVar.v0();
            hVar.Z(S.c());
            z10 = true;
        }
        try {
            oVar.serializeWithType(obj, hVar, this, hVar2);
            if (z10) {
                hVar.W();
            }
        } catch (Exception e10) {
            throw z0(hVar, e10);
        }
    }

    public void C0(c3.h hVar, Object obj) {
        this.f213q = hVar;
        if (obj == null) {
            y0(hVar);
            return;
        }
        Class<?> cls = obj.getClass();
        k3.o P = P(cls, true, null);
        x S = this.f14850a.S();
        if (S == null) {
            if (this.f14850a.c0(b0.WRAP_ROOT_VALUE)) {
                x0(hVar, obj, P, this.f14850a.I(cls));
                return;
            }
        } else if (!S.h()) {
            x0(hVar, obj, P, S);
            return;
        }
        w0(hVar, obj, P);
    }

    public void D0(c3.h hVar, Object obj, k3.j jVar) {
        this.f213q = hVar;
        if (obj == null) {
            y0(hVar);
            return;
        }
        if (!jVar.q().isAssignableFrom(obj.getClass())) {
            y(obj, jVar);
        }
        k3.o Q = Q(jVar, true, null);
        x S = this.f14850a.S();
        if (S == null) {
            if (this.f14850a.c0(b0.WRAP_ROOT_VALUE)) {
                x0(hVar, obj, Q, this.f14850a.J(jVar));
                return;
            }
        } else if (!S.h()) {
            x0(hVar, obj, Q, S);
            return;
        }
        w0(hVar, obj, Q);
    }

    public void E0(c3.h hVar, Object obj, k3.j jVar, k3.o oVar) {
        this.f213q = hVar;
        if (obj == null) {
            y0(hVar);
            return;
        }
        if (jVar != null && !jVar.q().isAssignableFrom(obj.getClass())) {
            y(obj, jVar);
        }
        if (oVar == null) {
            oVar = Q(jVar, true, null);
        }
        x S = this.f14850a.S();
        if (S == null) {
            if (this.f14850a.c0(b0.WRAP_ROOT_VALUE)) {
                x0(hVar, obj, oVar, jVar == null ? this.f14850a.I(obj.getClass()) : this.f14850a.J(jVar));
                return;
            }
        } else if (!S.h()) {
            x0(hVar, obj, oVar, S);
            return;
        }
        w0(hVar, obj, oVar);
    }

    @Override // k3.c0
    public t M(Object obj, k0 k0Var) {
        k0 k0Var2;
        Map map = this.f211o;
        if (map == null) {
            this.f211o = v0();
        } else {
            t tVar = (t) map.get(obj);
            if (tVar != null) {
                return tVar;
            }
        }
        ArrayList arrayList = this.f212p;
        if (arrayList == null) {
            this.f212p = new ArrayList(8);
        } else {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                k0Var2 = (k0) this.f212p.get(i10);
                if (k0Var2.a(k0Var)) {
                    break;
                }
            }
        }
        k0Var2 = null;
        if (k0Var2 == null) {
            k0Var2 = k0Var.h(this);
            this.f212p.add(k0Var2);
        }
        t tVar2 = new t(k0Var2);
        this.f211o.put(obj, tVar2);
        return tVar2;
    }

    @Override // k3.c0
    public c3.h d0() {
        return this.f213q;
    }

    @Override // k3.c0
    public Object j0(r3.s sVar, Class cls) {
        if (cls == null) {
            return null;
        }
        this.f14850a.u();
        return d4.h.l(cls, this.f14850a.b());
    }

    @Override // k3.c0
    public boolean k0(Object obj) {
        if (obj == null) {
            return true;
        }
        try {
            return obj.equals(null);
        } catch (Throwable th) {
            o0(obj.getClass(), String.format("Problem determining whether filter of type '%s' should filter out `null` values: (%s) %s", obj.getClass().getName(), th.getClass().getName(), d4.h.o(th)), th);
            return false;
        }
    }

    @Override // k3.c0
    public k3.o t0(r3.b bVar, Object obj) {
        k3.o oVar;
        if (obj == null) {
            return null;
        }
        if (obj instanceof k3.o) {
            oVar = (k3.o) obj;
        } else {
            if (!(obj instanceof Class)) {
                q(bVar.f(), "AnnotationIntrospector returned serializer definition of type " + obj.getClass().getName() + "; expected type JsonSerializer or Class<JsonSerializer> instead");
            }
            Class cls = (Class) obj;
            if (cls == o.a.class || d4.h.J(cls)) {
                return null;
            }
            if (!k3.o.class.isAssignableFrom(cls)) {
                q(bVar.f(), "AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<JsonSerializer>");
            }
            this.f14850a.u();
            oVar = (k3.o) d4.h.l(cls, this.f14850a.b());
        }
        return x(oVar);
    }

    public Map v0() {
        return m0(b0.USE_EQUALITY_FOR_OBJECT_ID) ? new HashMap() : new IdentityHashMap();
    }

    public final void w0(c3.h hVar, Object obj, k3.o oVar) {
        try {
            oVar.serialize(obj, hVar, this);
        } catch (Exception e10) {
            throw z0(hVar, e10);
        }
    }

    public final void x0(c3.h hVar, Object obj, k3.o oVar, x xVar) {
        try {
            hVar.v0();
            hVar.Y(xVar.i(this.f14850a));
            oVar.serialize(obj, hVar, this);
            hVar.W();
        } catch (Exception e10) {
            throw z0(hVar, e10);
        }
    }

    public void y0(c3.h hVar) {
        try {
            Z().serialize(null, hVar, this);
        } catch (Exception e10) {
            throw z0(hVar, e10);
        }
    }

    public final IOException z0(c3.h hVar, Exception exc) {
        if (exc instanceof IOException) {
            return (IOException) exc;
        }
        String o10 = d4.h.o(exc);
        if (o10 == null) {
            o10 = "[no message for " + exc.getClass().getName() + "]";
        }
        return new k3.l(hVar, o10, exc);
    }

    public j(c0 c0Var, a0 a0Var, q qVar) {
        super(c0Var, a0Var, qVar);
    }
}
