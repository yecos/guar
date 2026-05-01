package r3;

import b3.h;
import b3.k;
import b3.r;
import d4.j;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k3.b;
import l3.e;

/* loaded from: classes.dex */
public class q extends k3.c {

    /* renamed from: j, reason: collision with root package name */
    public static final Class[] f18466j = new Class[0];

    /* renamed from: b, reason: collision with root package name */
    public final c0 f18467b;

    /* renamed from: c, reason: collision with root package name */
    public final m3.m f18468c;

    /* renamed from: d, reason: collision with root package name */
    public final k3.b f18469d;

    /* renamed from: e, reason: collision with root package name */
    public final c f18470e;

    /* renamed from: f, reason: collision with root package name */
    public Class[] f18471f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f18472g;

    /* renamed from: h, reason: collision with root package name */
    public List f18473h;

    /* renamed from: i, reason: collision with root package name */
    public b0 f18474i;

    public q(c0 c0Var, k3.j jVar, c cVar) {
        super(jVar);
        this.f18467b = c0Var;
        m3.m B = c0Var.B();
        this.f18468c = B;
        if (B == null) {
            this.f18469d = null;
        } else {
            this.f18469d = B.g();
        }
        this.f18470e = cVar;
    }

    public static q H(c0 c0Var) {
        return new q(c0Var);
    }

    public static q I(m3.m mVar, k3.j jVar, c cVar) {
        return new q(mVar, jVar, cVar, Collections.emptyList());
    }

    public static q J(c0 c0Var) {
        return new q(c0Var);
    }

    @Override // k3.c
    public boolean A() {
        return this.f18470e.s();
    }

    @Override // k3.c
    public Object B(boolean z10) {
        e q10 = this.f18470e.q();
        if (q10 == null) {
            return null;
        }
        if (z10) {
            q10.i(this.f18468c.D(k3.q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        try {
            return q10.b().newInstance(new Object[0]);
        } catch (Exception e10) {
            e = e10;
            while (e.getCause() != null) {
                e = e.getCause();
            }
            d4.h.h0(e);
            d4.h.j0(e);
            throw new IllegalArgumentException("Failed to instantiate bean of type " + this.f18470e.n().getName() + ": (" + e.getClass().getName() + ") " + d4.h.o(e), e);
        }
    }

    public d4.j D(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof d4.j) {
            return (d4.j) obj;
        }
        if (!(obj instanceof Class)) {
            throw new IllegalStateException("AnnotationIntrospector returned Converter definition of type " + obj.getClass().getName() + "; expected type Converter or Class<Converter> instead");
        }
        Class cls = (Class) obj;
        if (cls == j.a.class || d4.h.J(cls)) {
            return null;
        }
        if (d4.j.class.isAssignableFrom(cls)) {
            this.f18468c.u();
            return (d4.j) d4.h.l(cls, this.f18468c.b());
        }
        throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<Converter>");
    }

    public List E() {
        if (this.f18473h == null) {
            this.f18473h = this.f18467b.H();
        }
        return this.f18473h;
    }

    public boolean F(s sVar) {
        if (K(sVar.c())) {
            return false;
        }
        E().add(sVar);
        return true;
    }

    public s G(k3.x xVar) {
        for (s sVar : E()) {
            if (sVar.z(xVar)) {
                return sVar;
            }
        }
        return null;
    }

    public boolean K(k3.x xVar) {
        return G(xVar) != null;
    }

    public boolean L(j jVar) {
        Class x10;
        if (!s().isAssignableFrom(jVar.D())) {
            return false;
        }
        h.a h10 = this.f18469d.h(this.f18468c, jVar);
        if (h10 != null && h10 != h.a.DISABLED) {
            return true;
        }
        String d10 = jVar.d();
        if ("valueOf".equals(d10) && jVar.v() == 1) {
            return true;
        }
        return "fromString".equals(d10) && jVar.v() == 1 && ((x10 = jVar.x(0)) == String.class || CharSequence.class.isAssignableFrom(x10));
    }

    public boolean M(String str) {
        Iterator it = E().iterator();
        while (it.hasNext()) {
            if (((s) it.next()).getName().equals(str)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override // k3.c
    public i a() {
        c0 c0Var = this.f18467b;
        if (c0Var == null) {
            return null;
        }
        i x10 = c0Var.x();
        if (x10 != null) {
            if (Map.class.isAssignableFrom(x10.e())) {
                return x10;
            }
            throw new IllegalArgumentException(String.format("Invalid 'any-getter' annotation on method %s(): return type is not instance of java.util.Map", x10.d()));
        }
        i w10 = this.f18467b.w();
        if (w10 == null) {
            return null;
        }
        if (Map.class.isAssignableFrom(w10.e())) {
            return w10;
        }
        throw new IllegalArgumentException(String.format("Invalid 'any-getter' annotation on field '%s': type is not instance of java.util.Map", w10.d()));
    }

    @Override // k3.c
    public i b() {
        c0 c0Var = this.f18467b;
        if (c0Var == null) {
            return null;
        }
        j z10 = c0Var.z();
        if (z10 != null) {
            Class x10 = z10.x(0);
            if (x10 == String.class || x10 == Object.class) {
                return z10;
            }
            throw new IllegalArgumentException(String.format("Invalid 'any-setter' annotation on method '%s()': first argument not of type String or Object, but %s", z10.d(), x10.getName()));
        }
        i y10 = this.f18467b.y();
        if (y10 == null) {
            return null;
        }
        if (Map.class.isAssignableFrom(y10.e())) {
            return y10;
        }
        throw new IllegalArgumentException(String.format("Invalid 'any-setter' annotation on field '%s': type is not instance of java.util.Map", y10.d()));
    }

    @Override // k3.c
    public List c() {
        ArrayList arrayList = null;
        HashSet hashSet = null;
        for (s sVar : E()) {
            b.a j10 = sVar.j();
            if (j10 != null && j10.c()) {
                String b10 = j10.b();
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    hashSet = new HashSet();
                    hashSet.add(b10);
                } else if (!hashSet.add(b10)) {
                    throw new IllegalArgumentException("Multiple back-reference properties with name " + d4.h.U(b10));
                }
                arrayList.add(sVar);
            }
        }
        return arrayList;
    }

    @Override // k3.c
    public e d() {
        return this.f18470e.q();
    }

    @Override // k3.c
    public Class[] e() {
        if (!this.f18472g) {
            this.f18472g = true;
            k3.b bVar = this.f18469d;
            Class[] f02 = bVar == null ? null : bVar.f0(this.f18470e);
            if (f02 == null && !this.f18468c.D(k3.q.DEFAULT_VIEW_INCLUSION)) {
                f02 = f18466j;
            }
            this.f18471f = f02;
        }
        return this.f18471f;
    }

    @Override // k3.c
    public d4.j f() {
        k3.b bVar = this.f18469d;
        if (bVar == null) {
            return null;
        }
        return D(bVar.l(this.f18470e));
    }

    @Override // k3.c
    public k.d g(k.d dVar) {
        k.d q10;
        k3.b bVar = this.f18469d;
        if (bVar != null && (q10 = bVar.q(this.f18470e)) != null) {
            dVar = dVar == null ? q10 : dVar.r(q10);
        }
        k.d o10 = this.f18468c.o(this.f18470e.e());
        return o10 != null ? dVar == null ? o10 : dVar.r(o10) : dVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // k3.c
    public Method h(Class... clsArr) {
        for (j jVar : this.f18470e.r()) {
            if (L(jVar) && jVar.v() == 1) {
                Class x10 = jVar.x(0);
                for (Class cls : clsArr) {
                    if (x10.isAssignableFrom(cls)) {
                        return jVar.b();
                    }
                }
            }
        }
        return null;
    }

    @Override // k3.c
    public Map i() {
        c0 c0Var = this.f18467b;
        return c0Var != null ? c0Var.D() : Collections.emptyMap();
    }

    @Override // k3.c
    public i j() {
        c0 c0Var = this.f18467b;
        if (c0Var == null) {
            return null;
        }
        return c0Var.E();
    }

    @Override // k3.c
    public i k() {
        c0 c0Var = this.f18467b;
        if (c0Var == null) {
            return null;
        }
        return c0Var.F();
    }

    @Override // k3.c
    public j l(String str, Class[] clsArr) {
        return this.f18470e.m(str, clsArr);
    }

    @Override // k3.c
    public Class m() {
        k3.b bVar = this.f18469d;
        if (bVar == null) {
            return null;
        }
        return bVar.D(this.f18470e);
    }

    @Override // k3.c
    public e.a n() {
        k3.b bVar = this.f18469d;
        if (bVar == null) {
            return null;
        }
        return bVar.E(this.f18470e);
    }

    @Override // k3.c
    public List o() {
        return E();
    }

    @Override // k3.c
    public r.b p(r.b bVar) {
        r.b M;
        k3.b bVar2 = this.f18469d;
        return (bVar2 == null || (M = bVar2.M(this.f18470e)) == null) ? bVar : bVar == null ? M : bVar.m(M);
    }

    @Override // k3.c
    public d4.j q() {
        k3.b bVar = this.f18469d;
        if (bVar == null) {
            return null;
        }
        return D(bVar.U(this.f18470e));
    }

    @Override // k3.c
    public Constructor r(Class... clsArr) {
        for (e eVar : this.f18470e.p()) {
            if (eVar.v() == 1) {
                Class x10 = eVar.x(0);
                for (Class cls : clsArr) {
                    if (cls == x10) {
                        return eVar.b();
                    }
                }
            }
        }
        return null;
    }

    @Override // k3.c
    public d4.b t() {
        return this.f18470e.o();
    }

    @Override // k3.c
    public c u() {
        return this.f18470e;
    }

    @Override // k3.c
    public List v() {
        return this.f18470e.p();
    }

    @Override // k3.c
    public List w() {
        List<j> r10 = this.f18470e.r();
        if (r10.isEmpty()) {
            return r10;
        }
        ArrayList arrayList = null;
        for (j jVar : r10) {
            if (L(jVar)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(jVar);
            }
        }
        return arrayList == null ? Collections.emptyList() : arrayList;
    }

    @Override // k3.c
    public Set x() {
        c0 c0Var = this.f18467b;
        Set C = c0Var == null ? null : c0Var.C();
        return C == null ? Collections.emptySet() : C;
    }

    @Override // k3.c
    public b0 y() {
        return this.f18474i;
    }

    public q(m3.m mVar, k3.j jVar, c cVar, List list) {
        super(jVar);
        this.f18467b = null;
        this.f18468c = mVar;
        if (mVar == null) {
            this.f18469d = null;
        } else {
            this.f18469d = mVar.g();
        }
        this.f18470e = cVar;
        this.f18473h = list;
    }

    public q(c0 c0Var) {
        this(c0Var, c0Var.J(), c0Var.A());
        this.f18474i = c0Var.G();
    }
}
