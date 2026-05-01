package n3;

import b3.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import l3.e;
import o3.e0;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final k3.f f17210a;

    /* renamed from: b, reason: collision with root package name */
    public final k3.g f17211b;

    /* renamed from: c, reason: collision with root package name */
    public final k3.c f17212c;

    /* renamed from: d, reason: collision with root package name */
    public final Map f17213d = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    public List f17214e;

    /* renamed from: f, reason: collision with root package name */
    public HashMap f17215f;

    /* renamed from: g, reason: collision with root package name */
    public HashSet f17216g;

    /* renamed from: h, reason: collision with root package name */
    public HashSet f17217h;

    /* renamed from: i, reason: collision with root package name */
    public w f17218i;

    /* renamed from: j, reason: collision with root package name */
    public o3.s f17219j;

    /* renamed from: k, reason: collision with root package name */
    public s f17220k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f17221l;

    /* renamed from: m, reason: collision with root package name */
    public r3.j f17222m;

    /* renamed from: n, reason: collision with root package name */
    public e.a f17223n;

    public e(k3.c cVar, k3.g gVar) {
        this.f17212c = cVar;
        this.f17211b = gVar;
        this.f17210a = gVar.k();
    }

    public Map a(Collection collection) {
        k3.b g10 = this.f17210a.g();
        HashMap hashMap = null;
        if (g10 != null) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                t tVar = (t) it.next();
                List G = g10.G(tVar.d());
                if (G != null && !G.isEmpty()) {
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    hashMap.put(tVar.getName(), G);
                }
            }
        }
        return hashMap == null ? Collections.emptyMap() : hashMap;
    }

    public boolean b() {
        Boolean e10 = this.f17212c.g(null).e(k.a.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
        return e10 == null ? this.f17210a.D(k3.q.ACCEPT_CASE_INSENSITIVE_PROPERTIES) : e10.booleanValue();
    }

    public void c(Collection collection) {
        if (this.f17210a.b()) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                ((t) it.next()).o(this.f17210a);
            }
        }
        s sVar = this.f17220k;
        if (sVar != null) {
            sVar.d(this.f17210a);
        }
        r3.j jVar = this.f17222m;
        if (jVar != null) {
            jVar.i(this.f17210a.D(k3.q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
    }

    public void d(String str, t tVar) {
        if (this.f17215f == null) {
            this.f17215f = new HashMap(4);
        }
        if (this.f17210a.b()) {
            tVar.o(this.f17210a);
        }
        this.f17215f.put(str, tVar);
    }

    public void e(t tVar) {
        j(tVar);
    }

    public void f(String str) {
        if (this.f17216g == null) {
            this.f17216g = new HashSet();
        }
        this.f17216g.add(str);
    }

    public void g(String str) {
        if (this.f17217h == null) {
            this.f17217h = new HashSet();
        }
        this.f17217h.add(str);
    }

    public void h(k3.x xVar, k3.j jVar, d4.b bVar, r3.i iVar, Object obj) {
        if (this.f17214e == null) {
            this.f17214e = new ArrayList();
        }
        if (this.f17210a.b()) {
            iVar.i(this.f17210a.D(k3.q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        this.f17214e.add(new e0(xVar, jVar, iVar, obj));
    }

    public void i(t tVar, boolean z10) {
        this.f17213d.put(tVar.getName(), tVar);
    }

    public void j(t tVar) {
        t tVar2 = (t) this.f17213d.put(tVar.getName(), tVar);
        if (tVar2 == null || tVar2 == tVar) {
            return;
        }
        throw new IllegalArgumentException("Duplicate property '" + tVar.getName() + "' for " + this.f17212c.z());
    }

    public k3.k k() {
        boolean z10;
        Collection values = this.f17213d.values();
        c(values);
        o3.c j10 = o3.c.j(this.f17210a, values, a(values), b());
        j10.i();
        boolean z11 = !this.f17210a.D(k3.q.DEFAULT_VIEW_INCLUSION);
        if (!z11) {
            Iterator it = values.iterator();
            while (it.hasNext()) {
                if (((t) it.next()).y()) {
                    z10 = true;
                    break;
                }
            }
        }
        z10 = z11;
        if (this.f17219j != null) {
            j10 = j10.u(new o3.u(this.f17219j, k3.w.f14994h));
        }
        return new c(this, this.f17212c, j10, this.f17215f, this.f17216g, this.f17221l, this.f17217h, z10);
    }

    public a l() {
        return new a(this, this.f17212c, this.f17215f, this.f17213d);
    }

    public k3.k m(k3.j jVar, String str) {
        r3.j jVar2 = this.f17222m;
        boolean z10 = true;
        if (jVar2 != null) {
            Class<?> D = jVar2.D();
            Class q10 = jVar.q();
            if (D != q10 && !D.isAssignableFrom(q10) && !q10.isAssignableFrom(D)) {
                this.f17211b.q(this.f17212c.z(), String.format("Build method `%s` has wrong return type (%s), not compatible with POJO type (%s)", this.f17222m.l(), d4.h.y(D), d4.h.G(jVar)));
            }
        } else if (!str.isEmpty()) {
            this.f17211b.q(this.f17212c.z(), String.format("Builder class %s does not have build method (name: '%s')", d4.h.G(this.f17212c.z()), str));
        }
        Collection values = this.f17213d.values();
        c(values);
        o3.c j10 = o3.c.j(this.f17210a, values, a(values), b());
        j10.i();
        boolean z11 = !this.f17210a.D(k3.q.DEFAULT_VIEW_INCLUSION);
        if (!z11) {
            Iterator it = values.iterator();
            while (it.hasNext()) {
                if (((t) it.next()).y()) {
                    break;
                }
            }
        }
        z10 = z11;
        if (this.f17219j != null) {
            j10 = j10.u(new o3.u(this.f17219j, k3.w.f14994h));
        }
        return n(jVar, j10, z10);
    }

    public k3.k n(k3.j jVar, o3.c cVar, boolean z10) {
        return new h(this, this.f17212c, jVar, cVar, this.f17215f, this.f17216g, this.f17221l, this.f17217h, z10);
    }

    public t o(k3.x xVar) {
        return (t) this.f17213d.get(xVar.c());
    }

    public s p() {
        return this.f17220k;
    }

    public r3.j q() {
        return this.f17222m;
    }

    public List r() {
        return this.f17214e;
    }

    public o3.s s() {
        return this.f17219j;
    }

    public w t() {
        return this.f17218i;
    }

    public boolean u(String str) {
        return d4.m.c(str, this.f17216g, this.f17217h);
    }

    public void v(s sVar) {
        if (this.f17220k != null && sVar != null) {
            throw new IllegalStateException("_anySetter already set to non-null");
        }
        this.f17220k = sVar;
    }

    public void w(boolean z10) {
        this.f17221l = z10;
    }

    public void x(o3.s sVar) {
        this.f17219j = sVar;
    }

    public void y(r3.j jVar, e.a aVar) {
        this.f17222m = jVar;
        this.f17223n = aVar;
    }

    public void z(w wVar) {
        this.f17218i = wVar;
    }
}
