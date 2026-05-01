package k3;

import a4.j;
import c3.k;
import com.umeng.analytics.pro.bt;
import java.io.Closeable;
import java.io.Reader;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import k3.s;
import n3.l;
import r3.e0;
import r3.w;

/* loaded from: classes.dex */
public class t extends c3.o implements Serializable {

    /* renamed from: n, reason: collision with root package name */
    public static final b f14955n;

    /* renamed from: o, reason: collision with root package name */
    public static final m3.a f14956o;

    /* renamed from: a, reason: collision with root package name */
    public final c3.f f14957a;

    /* renamed from: b, reason: collision with root package name */
    public c4.o f14958b;

    /* renamed from: c, reason: collision with root package name */
    public w3.d f14959c;

    /* renamed from: d, reason: collision with root package name */
    public final m3.h f14960d;

    /* renamed from: e, reason: collision with root package name */
    public final m3.d f14961e;

    /* renamed from: f, reason: collision with root package name */
    public e0 f14962f;

    /* renamed from: g, reason: collision with root package name */
    public a0 f14963g;

    /* renamed from: h, reason: collision with root package name */
    public a4.j f14964h;

    /* renamed from: i, reason: collision with root package name */
    public a4.q f14965i;

    /* renamed from: j, reason: collision with root package name */
    public f f14966j;

    /* renamed from: k, reason: collision with root package name */
    public n3.l f14967k;

    /* renamed from: l, reason: collision with root package name */
    public Set f14968l;

    /* renamed from: m, reason: collision with root package name */
    public final ConcurrentHashMap f14969m;

    public class a implements s.a {
        public a() {
        }

        @Override // k3.s.a
        public void a(w3.b... bVarArr) {
            t.this.C(bVarArr);
        }

        @Override // k3.s.a
        public void b(n3.o oVar) {
            n3.n n10 = t.this.f14967k.f14880b.n(oVar);
            t tVar = t.this;
            tVar.f14967k = tVar.f14967k.V0(n10);
        }

        @Override // k3.s.a
        public void c(Class cls, Class cls2) {
            t.this.n(cls, cls2);
        }

        @Override // k3.s.a
        public void d(a4.r rVar) {
            t tVar = t.this;
            tVar.f14965i = tVar.f14965i.e(rVar);
        }

        @Override // k3.s.a
        public void e(a4.r rVar) {
            t tVar = t.this;
            tVar.f14965i = tVar.f14965i.d(rVar);
        }
    }

    static {
        r3.x xVar = new r3.x();
        f14955n = xVar;
        f14956o = new m3.a(null, xVar, null, c4.o.I(), null, d4.x.f12590m, null, Locale.getDefault(), null, c3.b.a(), x3.l.f19425a, new w.b());
    }

    public t() {
        this(null, null, null);
    }

    public u A(Class cls) {
        return g(u(), this.f14958b.H(cls), null, null, null);
    }

    public t B(s sVar) {
        Object c10;
        d(bt.f10044e, sVar);
        if (sVar.b() == null) {
            throw new IllegalArgumentException("Module without defined name");
        }
        if (sVar.e() == null) {
            throw new IllegalArgumentException("Module without defined version");
        }
        Iterator it = sVar.a().iterator();
        while (it.hasNext()) {
            B((s) it.next());
        }
        if (y(q.IGNORE_DUPLICATE_MODULE_REGISTRATIONS) && (c10 = sVar.c()) != null) {
            if (this.f14968l == null) {
                this.f14968l = new LinkedHashSet();
            }
            if (!this.f14968l.add(c10)) {
                return this;
            }
        }
        sVar.d(new a());
        return this;
    }

    public void C(w3.b... bVarArr) {
        x().e(bVarArr);
    }

    public v D() {
        return h(w());
    }

    @Override // c3.o
    public c3.v a(c3.k kVar) {
        d(bt.aD, kVar);
        f u10 = u();
        if (kVar.n() == null && kVar.s0() == null) {
            return null;
        }
        m mVar = (m) j(u10, kVar, r(m.class));
        return mVar == null ? v().d() : mVar;
    }

    @Override // c3.o
    public Object b(c3.k kVar, Class cls) {
        d(bt.aD, kVar);
        return j(u(), kVar, this.f14958b.H(cls));
    }

    @Override // c3.o
    public void c(c3.h hVar, Object obj) {
        d("g", hVar);
        a0 w10 = w();
        if (w10.c0(b0.INDENT_OUTPUT) && hVar.u() == null) {
            hVar.I(w10.X());
        }
        if (w10.c0(b0.CLOSE_CLOSEABLE) && (obj instanceof Closeable)) {
            m(hVar, obj, w10);
            return;
        }
        k(w10).C0(hVar, obj);
        if (w10.c0(b0.FLUSH_AFTER_WRITE_VALUE)) {
            hVar.flush();
        }
    }

    public final void d(String str, Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException(String.format("argument \"%s\" is null", str));
        }
    }

    public k e(g gVar, j jVar) {
        k kVar = (k) this.f14969m.get(jVar);
        if (kVar != null) {
            return kVar;
        }
        k I = gVar.I(jVar);
        if (I != null) {
            this.f14969m.put(jVar, I);
            return I;
        }
        return (k) gVar.q(jVar, "Cannot find a deserializer for type " + jVar);
    }

    public c3.n f(c3.k kVar, j jVar) {
        this.f14966j.e0(kVar);
        c3.n n10 = kVar.n();
        if (n10 == null && (n10 = kVar.s0()) == null) {
            throw p3.f.t(kVar, jVar, "No content to map due to end-of-input");
        }
        return n10;
    }

    public u g(f fVar, j jVar, Object obj, c3.c cVar, i iVar) {
        return new u(this, fVar, jVar, obj, cVar, iVar);
    }

    public v h(a0 a0Var) {
        return new v(this, a0Var);
    }

    public Object i(c3.k kVar, j jVar) {
        Object obj;
        try {
            f u10 = u();
            n3.l s10 = s(kVar, u10);
            c3.n f10 = f(kVar, jVar);
            if (f10 == c3.n.VALUE_NULL) {
                obj = e(s10, jVar).getNullValue(s10);
            } else {
                if (f10 != c3.n.END_ARRAY && f10 != c3.n.END_OBJECT) {
                    obj = s10.T0(kVar, jVar, e(s10, jVar), null);
                    s10.P0();
                }
                obj = null;
            }
            if (u10.j0(h.FAIL_ON_TRAILING_TOKENS)) {
                l(kVar, s10, jVar);
            }
            if (kVar != null) {
                kVar.close();
            }
            return obj;
        } catch (Throwable th) {
            if (kVar != null) {
                try {
                    kVar.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public Object j(f fVar, c3.k kVar, j jVar) {
        c3.n f10 = f(kVar, jVar);
        n3.l s10 = s(kVar, fVar);
        Object nullValue = f10 == c3.n.VALUE_NULL ? e(s10, jVar).getNullValue(s10) : (f10 == c3.n.END_ARRAY || f10 == c3.n.END_OBJECT) ? null : s10.T0(kVar, jVar, e(s10, jVar), null);
        kVar.f();
        if (fVar.j0(h.FAIL_ON_TRAILING_TOKENS)) {
            l(kVar, s10, jVar);
        }
        return nullValue;
    }

    public a4.j k(a0 a0Var) {
        return this.f14964h.A0(a0Var, this.f14965i);
    }

    public final void l(c3.k kVar, g gVar, j jVar) {
        c3.n s02 = kVar.s0();
        if (s02 != null) {
            gVar.C0(d4.h.d0(jVar), kVar, s02);
        }
    }

    public final void m(c3.h hVar, Object obj, a0 a0Var) {
        Closeable closeable = (Closeable) obj;
        try {
            k(a0Var).C0(hVar, obj);
            if (a0Var.c0(b0.FLUSH_AFTER_WRITE_VALUE)) {
                hVar.flush();
            }
            closeable.close();
        } catch (Exception e10) {
            d4.h.j(null, closeable, e10);
        }
    }

    public t n(Class cls, Class cls2) {
        this.f14962f.b(cls, cls2);
        return this;
    }

    public t o(k.a aVar, boolean z10) {
        this.f14957a.j(aVar, z10);
        return this;
    }

    public t p(h hVar, boolean z10) {
        this.f14966j = z10 ? this.f14966j.l0(hVar) : this.f14966j.m0(hVar);
        return this;
    }

    public t q(q qVar, boolean z10) {
        this.f14963g = (a0) (z10 ? this.f14963g.U(qVar) : this.f14963g.V(qVar));
        this.f14966j = (f) (z10 ? this.f14966j.U(qVar) : this.f14966j.V(qVar));
        return this;
    }

    public j r(Type type) {
        d("t", type);
        return this.f14958b.H(type);
    }

    public n3.l s(c3.k kVar, f fVar) {
        return this.f14967k.R0(fVar, kVar, null);
    }

    public r3.t t() {
        return new r3.r();
    }

    public f u() {
        return this.f14966j;
    }

    public z3.l v() {
        return this.f14966j.c0();
    }

    public a0 w() {
        return this.f14963g;
    }

    public w3.d x() {
        return this.f14959c;
    }

    public boolean y(q qVar) {
        return this.f14963g.D(qVar);
    }

    public Object z(Reader reader, Class cls) {
        d("src", reader);
        return i(this.f14957a.m(reader), this.f14958b.H(cls));
    }

    public t(c3.f fVar) {
        this(fVar, null, null);
    }

    public t(c3.f fVar, a4.j jVar, n3.l lVar) {
        this.f14969m = new ConcurrentHashMap(64, 0.6f, 2);
        if (fVar == null) {
            this.f14957a = new r(this);
        } else {
            this.f14957a = fVar;
            if (fVar.p() == null) {
                fVar.r(this);
            }
        }
        this.f14959c = new x3.n();
        d4.v vVar = new d4.v();
        this.f14958b = c4.o.I();
        e0 e0Var = new e0(null);
        this.f14962f = e0Var;
        m3.a m10 = f14956o.m(t());
        m3.h hVar = new m3.h();
        this.f14960d = hVar;
        m3.d dVar = new m3.d();
        this.f14961e = dVar;
        this.f14963g = new a0(m10, this.f14959c, e0Var, vVar, hVar);
        this.f14966j = new f(m10, this.f14959c, e0Var, vVar, hVar, dVar);
        boolean q10 = this.f14957a.q();
        a0 a0Var = this.f14963g;
        q qVar = q.SORT_PROPERTIES_ALPHABETICALLY;
        if (a0Var.D(qVar) ^ q10) {
            q(qVar, q10);
        }
        this.f14964h = jVar == null ? new j.a() : jVar;
        this.f14967k = lVar == null ? new l.a(n3.f.f17225k) : lVar;
        this.f14965i = a4.f.f210d;
    }
}
