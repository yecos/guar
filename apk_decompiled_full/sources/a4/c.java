package a4;

import b3.r;
import b4.k;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import k3.a0;
import k3.b0;
import k3.c0;
import k3.x;

/* loaded from: classes.dex */
public class c extends n {

    /* renamed from: t, reason: collision with root package name */
    public static final Object f183t = r.a.NON_EMPTY;

    /* renamed from: c, reason: collision with root package name */
    public final f3.i f184c;

    /* renamed from: d, reason: collision with root package name */
    public final x f185d;

    /* renamed from: e, reason: collision with root package name */
    public final k3.j f186e;

    /* renamed from: f, reason: collision with root package name */
    public final k3.j f187f;

    /* renamed from: g, reason: collision with root package name */
    public k3.j f188g;

    /* renamed from: h, reason: collision with root package name */
    public final transient d4.b f189h;

    /* renamed from: i, reason: collision with root package name */
    public final r3.i f190i;

    /* renamed from: j, reason: collision with root package name */
    public transient Method f191j;

    /* renamed from: k, reason: collision with root package name */
    public transient Field f192k;

    /* renamed from: l, reason: collision with root package name */
    public k3.o f193l;

    /* renamed from: m, reason: collision with root package name */
    public k3.o f194m;

    /* renamed from: n, reason: collision with root package name */
    public w3.h f195n;

    /* renamed from: o, reason: collision with root package name */
    public transient b4.k f196o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f197p;

    /* renamed from: q, reason: collision with root package name */
    public final Object f198q;

    /* renamed from: r, reason: collision with root package name */
    public final Class[] f199r;

    /* renamed from: s, reason: collision with root package name */
    public transient HashMap f200s;

    public c(r3.s sVar, r3.i iVar, d4.b bVar, k3.j jVar, k3.o oVar, w3.h hVar, k3.j jVar2, boolean z10, Object obj, Class[] clsArr) {
        super(sVar);
        this.f190i = iVar;
        this.f189h = bVar;
        this.f184c = new f3.i(sVar.getName());
        this.f185d = sVar.w();
        this.f186e = jVar;
        this.f193l = oVar;
        this.f196o = oVar == null ? b4.k.c() : null;
        this.f195n = hVar;
        this.f187f = jVar2;
        if (iVar instanceof r3.g) {
            this.f191j = null;
            this.f192k = (Field) iVar.m();
        } else if (iVar instanceof r3.j) {
            this.f191j = (Method) iVar.m();
            this.f192k = null;
        } else {
            this.f191j = null;
            this.f192k = null;
        }
        this.f197p = z10;
        this.f198q = obj;
        this.f194m = null;
        this.f199r = clsArr;
    }

    public void A(Object obj, c3.h hVar, c0 c0Var) {
        k3.o oVar = this.f194m;
        if (oVar != null) {
            oVar.serialize(null, hVar, c0Var);
        } else {
            hVar.a0();
        }
    }

    public void B(k3.j jVar) {
        this.f188g = jVar;
    }

    public c C(d4.q qVar) {
        return new b4.r(this, qVar);
    }

    public boolean D() {
        return this.f197p;
    }

    public boolean E(x xVar) {
        x xVar2 = this.f185d;
        return xVar2 != null ? xVar2.equals(xVar) : xVar.f(this.f184c.getValue()) && !xVar.d();
    }

    @Override // k3.d
    public x c() {
        return new x(this.f184c.getValue());
    }

    @Override // k3.d
    public r3.i d() {
        return this.f190i;
    }

    public void g(z3.r rVar, k3.m mVar) {
        rVar.G(getName(), mVar);
    }

    @Override // k3.d, d4.r
    public String getName() {
        return this.f184c.getValue();
    }

    @Override // k3.d
    public k3.j getType() {
        return this.f186e;
    }

    public k3.o h(b4.k kVar, Class cls, c0 c0Var) {
        k3.j jVar = this.f188g;
        k.d f10 = jVar != null ? kVar.f(c0Var.A(jVar, cls), c0Var, this) : kVar.e(cls, c0Var, this);
        b4.k kVar2 = f10.f4620b;
        if (kVar != kVar2) {
            this.f196o = kVar2;
        }
        return f10.f4619a;
    }

    public boolean i(Object obj, c3.h hVar, c0 c0Var, k3.o oVar) {
        if (oVar.usesObjectId()) {
            return false;
        }
        if (c0Var.m0(b0.FAIL_ON_SELF_REFERENCES)) {
            if (!(oVar instanceof com.fasterxml.jackson.databind.ser.std.d)) {
                return false;
            }
            c0Var.q(getType(), "Direct self-reference leading to cycle");
            return false;
        }
        if (!c0Var.m0(b0.WRITE_SELF_REFERENCES_AS_NULL)) {
            return false;
        }
        if (this.f194m == null) {
            return true;
        }
        if (!hVar.s().f()) {
            hVar.Y(this.f184c);
        }
        this.f194m.serialize(null, hVar, c0Var);
        return true;
    }

    public c j(x xVar) {
        return new c(this, xVar);
    }

    public void k(k3.o oVar) {
        k3.o oVar2 = this.f194m;
        if (oVar2 != null && oVar2 != oVar) {
            throw new IllegalStateException(String.format("Cannot override _nullSerializer: had a %s, trying to set to %s", d4.h.h(this.f194m), d4.h.h(oVar)));
        }
        this.f194m = oVar;
    }

    public void l(k3.o oVar) {
        k3.o oVar2 = this.f193l;
        if (oVar2 != null && oVar2 != oVar) {
            throw new IllegalStateException(String.format("Cannot override _serializer: had a %s, trying to set to %s", d4.h.h(this.f193l), d4.h.h(oVar)));
        }
        this.f193l = oVar;
    }

    public void m(w3.h hVar) {
        this.f195n = hVar;
    }

    public void n(z3.r rVar, c0 c0Var) {
        k3.j q10 = q();
        Type type = q10 == null ? getType() : q10.q();
        Object r10 = r();
        if (r10 == null) {
            r10 = c0Var.U(getType(), this);
        }
        g(rVar, r10 instanceof v3.c ? ((v3.c) r10).getSchema(c0Var, type, !f()) : v3.a.a());
    }

    public void o(a0 a0Var) {
        this.f190i.i(a0Var.D(k3.q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
    }

    public final Object p(Object obj) {
        Method method = this.f191j;
        return method == null ? this.f192k.get(obj) : method.invoke(obj, null);
    }

    public k3.j q() {
        return this.f187f;
    }

    public k3.o r() {
        return this.f193l;
    }

    public w3.h s() {
        return this.f195n;
    }

    public Class[] t() {
        return this.f199r;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("property '");
        sb.append(getName());
        sb.append("' (");
        if (this.f191j != null) {
            sb.append("via method ");
            sb.append(this.f191j.getDeclaringClass().getName());
            sb.append("#");
            sb.append(this.f191j.getName());
        } else if (this.f192k != null) {
            sb.append("field \"");
            sb.append(this.f192k.getDeclaringClass().getName());
            sb.append("#");
            sb.append(this.f192k.getName());
        } else {
            sb.append("virtual");
        }
        if (this.f193l == null) {
            sb.append(", no static serializer");
        } else {
            sb.append(", static serializer of type " + this.f193l.getClass().getName());
        }
        sb.append(ASCIIPropertyListParser.ARRAY_END_TOKEN);
        return sb.toString();
    }

    public boolean u() {
        return this.f194m != null;
    }

    public boolean v() {
        return this.f193l != null;
    }

    public c w(d4.q qVar) {
        String c10 = qVar.c(this.f184c.getValue());
        return c10.equals(this.f184c.toString()) ? this : j(x.a(c10));
    }

    public void x(Object obj, c3.h hVar, c0 c0Var) {
        Method method = this.f191j;
        Object invoke = method == null ? this.f192k.get(obj) : method.invoke(obj, null);
        if (invoke == null) {
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
            Class<?> cls = invoke.getClass();
            b4.k kVar = this.f196o;
            k3.o j10 = kVar.j(cls);
            oVar2 = j10 == null ? h(kVar, cls, c0Var) : j10;
        }
        Object obj2 = this.f198q;
        if (obj2 != null) {
            if (f183t == obj2) {
                if (oVar2.isEmpty(c0Var, invoke)) {
                    A(obj, hVar, c0Var);
                    return;
                }
            } else if (obj2.equals(invoke)) {
                A(obj, hVar, c0Var);
                return;
            }
        }
        if (invoke == obj && i(obj, hVar, c0Var, oVar2)) {
            return;
        }
        w3.h hVar2 = this.f195n;
        if (hVar2 == null) {
            oVar2.serialize(invoke, hVar, c0Var);
        } else {
            oVar2.serializeWithType(invoke, hVar, c0Var, hVar2);
        }
    }

    public void y(Object obj, c3.h hVar, c0 c0Var) {
        Method method = this.f191j;
        Object invoke = method == null ? this.f192k.get(obj) : method.invoke(obj, null);
        if (invoke == null) {
            if (this.f194m != null) {
                hVar.Y(this.f184c);
                this.f194m.serialize(null, hVar, c0Var);
                return;
            }
            return;
        }
        k3.o oVar = this.f193l;
        if (oVar == null) {
            Class<?> cls = invoke.getClass();
            b4.k kVar = this.f196o;
            k3.o j10 = kVar.j(cls);
            oVar = j10 == null ? h(kVar, cls, c0Var) : j10;
        }
        Object obj2 = this.f198q;
        if (obj2 != null) {
            if (f183t == obj2) {
                if (oVar.isEmpty(c0Var, invoke)) {
                    return;
                }
            } else if (obj2.equals(invoke)) {
                return;
            }
        }
        if (invoke == obj && i(obj, hVar, c0Var, oVar)) {
            return;
        }
        hVar.Y(this.f184c);
        w3.h hVar2 = this.f195n;
        if (hVar2 == null) {
            oVar.serialize(invoke, hVar, c0Var);
        } else {
            oVar.serializeWithType(invoke, hVar, c0Var, hVar2);
        }
    }

    public void z(Object obj, c3.h hVar, c0 c0Var) {
        if (hVar.e()) {
            return;
        }
        hVar.l0(this.f184c.getValue());
    }

    public c(c cVar) {
        this(cVar, cVar.f184c);
    }

    public c(c cVar, x xVar) {
        super(cVar);
        this.f184c = new f3.i(xVar.c());
        this.f185d = cVar.f185d;
        this.f189h = cVar.f189h;
        this.f186e = cVar.f186e;
        this.f190i = cVar.f190i;
        this.f191j = cVar.f191j;
        this.f192k = cVar.f192k;
        this.f193l = cVar.f193l;
        this.f194m = cVar.f194m;
        if (cVar.f200s != null) {
            this.f200s = new HashMap(cVar.f200s);
        }
        this.f187f = cVar.f187f;
        this.f196o = cVar.f196o;
        this.f197p = cVar.f197p;
        this.f198q = cVar.f198q;
        this.f199r = cVar.f199r;
        this.f195n = cVar.f195n;
        this.f188g = cVar.f188g;
    }

    public c(c cVar, f3.i iVar) {
        super(cVar);
        this.f184c = iVar;
        this.f185d = cVar.f185d;
        this.f190i = cVar.f190i;
        this.f189h = cVar.f189h;
        this.f186e = cVar.f186e;
        this.f191j = cVar.f191j;
        this.f192k = cVar.f192k;
        this.f193l = cVar.f193l;
        this.f194m = cVar.f194m;
        if (cVar.f200s != null) {
            this.f200s = new HashMap(cVar.f200s);
        }
        this.f187f = cVar.f187f;
        this.f196o = cVar.f196o;
        this.f197p = cVar.f197p;
        this.f198q = cVar.f198q;
        this.f199r = cVar.f199r;
        this.f195n = cVar.f195n;
        this.f188g = cVar.f188g;
    }
}
