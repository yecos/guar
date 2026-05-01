package k3;

import com.umeng.analytics.pro.bt;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class u extends c3.o implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final f f14971a;

    /* renamed from: b, reason: collision with root package name */
    public final n3.l f14972b;

    /* renamed from: c, reason: collision with root package name */
    public final c3.f f14973c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f14974d;

    /* renamed from: e, reason: collision with root package name */
    public final j f14975e;

    /* renamed from: f, reason: collision with root package name */
    public final k f14976f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f14977g;

    /* renamed from: h, reason: collision with root package name */
    public final ConcurrentHashMap f14978h;

    /* renamed from: i, reason: collision with root package name */
    public transient j f14979i;

    public u(t tVar, f fVar, j jVar, Object obj, c3.c cVar, i iVar) {
        this.f14971a = fVar;
        this.f14972b = tVar.f14967k;
        this.f14978h = tVar.f14969m;
        this.f14973c = tVar.f14957a;
        this.f14975e = jVar;
        this.f14977g = obj;
        this.f14974d = fVar.k0();
        this.f14976f = l(jVar);
    }

    @Override // c3.o
    public c3.v a(c3.k kVar) {
        d(bt.aD, kVar);
        return f(kVar);
    }

    @Override // c3.o
    public Object b(c3.k kVar, Class cls) {
        d(bt.aD, kVar);
        return p(cls).s(kVar);
    }

    @Override // c3.o
    public void c(c3.h hVar, Object obj) {
        throw new UnsupportedOperationException("Not implemented for ObjectReader");
    }

    public final void d(String str, Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException(String.format("argument \"%s\" is null", str));
        }
    }

    public Object e(c3.k kVar, Object obj) {
        n3.l n10 = n(kVar);
        c3.n i10 = i(n10, kVar);
        if (i10 == c3.n.VALUE_NULL) {
            if (obj == null) {
                obj = g(n10).getNullValue(n10);
            }
        } else if (i10 != c3.n.END_ARRAY && i10 != c3.n.END_OBJECT) {
            obj = n10.T0(kVar, this.f14975e, g(n10), this.f14977g);
        }
        kVar.f();
        if (this.f14971a.j0(h.FAIL_ON_TRAILING_TOKENS)) {
            m(kVar, n10, this.f14975e);
        }
        return obj;
    }

    public final m f(c3.k kVar) {
        this.f14971a.e0(kVar);
        c3.n n10 = kVar.n();
        if (n10 == null && (n10 = kVar.s0()) == null) {
            return null;
        }
        n3.l n11 = n(kVar);
        m d10 = n10 == c3.n.VALUE_NULL ? this.f14971a.c0().d() : (m) n11.T0(kVar, j(), h(n11), null);
        if (this.f14971a.j0(h.FAIL_ON_TRAILING_TOKENS)) {
            m(kVar, n11, j());
        }
        return d10;
    }

    public k g(g gVar) {
        k kVar = this.f14976f;
        if (kVar != null) {
            return kVar;
        }
        j jVar = this.f14975e;
        if (jVar == null) {
            gVar.q(null, "No value type configured for ObjectReader");
        }
        k kVar2 = (k) this.f14978h.get(jVar);
        if (kVar2 != null) {
            return kVar2;
        }
        k I = gVar.I(jVar);
        if (I == null) {
            gVar.q(jVar, "Cannot find a deserializer for type " + jVar);
        }
        this.f14978h.put(jVar, I);
        return I;
    }

    public k h(g gVar) {
        j j10 = j();
        k kVar = (k) this.f14978h.get(j10);
        if (kVar == null) {
            kVar = gVar.I(j10);
            if (kVar == null) {
                gVar.q(j10, "Cannot find a deserializer for type " + j10);
            }
            this.f14978h.put(j10, kVar);
        }
        return kVar;
    }

    public c3.n i(g gVar, c3.k kVar) {
        this.f14971a.f0(kVar, null);
        c3.n n10 = kVar.n();
        if (n10 == null && (n10 = kVar.s0()) == null) {
            gVar.y0(this.f14975e, "No content to map due to end-of-input", new Object[0]);
        }
        return n10;
    }

    public final j j() {
        j jVar = this.f14979i;
        if (jVar != null) {
            return jVar;
        }
        j H = r().H(m.class);
        this.f14979i = H;
        return H;
    }

    public u k(u uVar, f fVar, j jVar, k kVar, Object obj, c3.c cVar, i iVar, n3.k kVar2) {
        return new u(uVar, fVar, jVar, kVar, obj, cVar, iVar, kVar2);
    }

    public k l(j jVar) {
        if (jVar == null || !this.f14971a.j0(h.EAGER_DESERIALIZER_FETCH)) {
            return null;
        }
        k kVar = (k) this.f14978h.get(jVar);
        if (kVar == null) {
            try {
                kVar = o().I(jVar);
                if (kVar != null) {
                    this.f14978h.put(jVar, kVar);
                }
            } catch (c3.l unused) {
            }
        }
        return kVar;
    }

    public final void m(c3.k kVar, g gVar, j jVar) {
        Object obj;
        c3.n s02 = kVar.s0();
        if (s02 != null) {
            Class<?> d02 = d4.h.d0(jVar);
            if (d02 == null && (obj = this.f14977g) != null) {
                d02 = obj.getClass();
            }
            gVar.C0(d02, kVar, s02);
        }
    }

    public n3.l n(c3.k kVar) {
        return this.f14972b.R0(this.f14971a, kVar, null);
    }

    public n3.l o() {
        return this.f14972b.Q0(this.f14971a);
    }

    public u p(Class cls) {
        return q(this.f14971a.e(cls));
    }

    public u q(j jVar) {
        if (jVar != null && jVar.equals(this.f14975e)) {
            return this;
        }
        return k(this, this.f14971a, jVar, l(jVar), this.f14977g, null, null, null);
    }

    public c4.o r() {
        return this.f14971a.z();
    }

    public Object s(c3.k kVar) {
        d(bt.aD, kVar);
        return e(kVar, this.f14977g);
    }

    public u(u uVar, f fVar, j jVar, k kVar, Object obj, c3.c cVar, i iVar, n3.k kVar2) {
        this.f14971a = fVar;
        this.f14972b = uVar.f14972b;
        this.f14978h = uVar.f14978h;
        this.f14973c = uVar.f14973c;
        this.f14975e = jVar;
        this.f14976f = kVar;
        this.f14977g = obj;
        this.f14974d = fVar.k0();
    }
}
