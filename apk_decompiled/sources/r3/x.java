package r3;

import b3.b;
import b3.b0;
import b3.c0;
import b3.e0;
import b3.h;
import b3.i0;
import b3.k;
import b3.m0;
import b3.p;
import b3.r;
import b3.s;
import b3.w;
import d4.j;
import java.io.Closeable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import k3.b;
import k3.k;
import k3.o;
import k3.p;
import l3.b;
import l3.e;
import l3.f;

/* loaded from: classes.dex */
public class x extends k3.b {

    /* renamed from: c, reason: collision with root package name */
    public static final Class[] f18500c = {l3.f.class, i0.class, b3.k.class, b3.e0.class, b3.z.class, b3.g0.class, b3.g.class, b3.u.class};

    /* renamed from: d, reason: collision with root package name */
    public static final Class[] f18501d = {l3.c.class, i0.class, b3.k.class, b3.e0.class, b3.g0.class, b3.g.class, b3.u.class, b3.v.class};

    /* renamed from: a, reason: collision with root package name */
    public transient d4.n f18502a = new d4.n(48, 48);

    /* renamed from: b, reason: collision with root package name */
    public boolean f18503b = true;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18504a;

        static {
            int[] iArr = new int[f.a.values().length];
            f18504a = iArr;
            try {
                iArr[f.a.ALWAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18504a[f.a.NON_NULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18504a[f.a.NON_DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18504a[f.a.NON_EMPTY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18504a[f.a.DEFAULT_INCLUSION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        try {
            q3.c.a();
        } catch (Throwable unused) {
        }
    }

    @Override // k3.b
    public Object A(b bVar) {
        Class nullsUsing;
        l3.f fVar = (l3.f) a(bVar, l3.f.class);
        if (fVar == null || (nullsUsing = fVar.nullsUsing()) == o.a.class) {
            return null;
        }
        return nullsUsing;
    }

    public x3.o A0() {
        return new x3.o();
    }

    @Override // k3.b
    public b0 B(b bVar) {
        b3.m mVar = (b3.m) a(bVar, b3.m.class);
        if (mVar == null || mVar.generator() == m0.class) {
            return null;
        }
        return new b0(k3.x.a(mVar.property()), mVar.scope(), mVar.generator(), mVar.resolver());
    }

    public a4.c B0(b.a aVar, m3.m mVar, c cVar, k3.j jVar) {
        k3.w wVar = aVar.required() ? k3.w.f14994h : k3.w.f14995i;
        String value = aVar.value();
        k3.x J0 = J0(aVar.propName(), aVar.propNamespace());
        if (!J0.e()) {
            J0 = k3.x.a(value);
        }
        return b4.a.J(value, d4.w.F(mVar, new g0(cVar, cVar.e(), value, jVar), J0, wVar, aVar.include()), cVar.o(), jVar);
    }

    @Override // k3.b
    public b0 C(b bVar, b0 b0Var) {
        b3.n nVar = (b3.n) a(bVar, b3.n.class);
        if (nVar == null) {
            return b0Var;
        }
        if (b0Var == null) {
            b0Var = b0.a();
        }
        return b0Var.g(nVar.alwaysAsId());
    }

    public a4.c C0(b.InterfaceC0270b interfaceC0270b, m3.m mVar, c cVar) {
        k3.w wVar = interfaceC0270b.required() ? k3.w.f14994h : k3.w.f14995i;
        k3.x J0 = J0(interfaceC0270b.name(), interfaceC0270b.namespace());
        k3.j e10 = mVar.e(interfaceC0270b.type());
        d4.w F = d4.w.F(mVar, new g0(cVar, cVar.e(), J0.c(), e10), J0, wVar, interfaceC0270b.include());
        Class value = interfaceC0270b.value();
        mVar.u();
        return ((a4.s) d4.h.l(value, mVar.b())).I(mVar, cVar, F, e10);
    }

    @Override // k3.b
    public Class D(c cVar) {
        l3.c cVar2 = (l3.c) a(cVar, l3.c.class);
        if (cVar2 == null) {
            return null;
        }
        return x0(cVar2.builder());
    }

    public k3.x D0(b bVar) {
        if (!(bVar instanceof m)) {
            return null;
        }
        ((m) bVar).r();
        return null;
    }

    @Override // k3.b
    public e.a E(c cVar) {
        l3.e eVar = (l3.e) a(cVar, l3.e.class);
        if (eVar == null) {
            return null;
        }
        return new e.a(eVar);
    }

    public final Boolean E0(b bVar) {
        b3.y yVar = (b3.y) a(bVar, b3.y.class);
        if (yVar == null || !yVar.alphabetic()) {
            return null;
        }
        return Boolean.TRUE;
    }

    @Override // k3.b
    public w.a F(b bVar) {
        b3.w wVar = (b3.w) a(bVar, b3.w.class);
        if (wVar != null) {
            return wVar.access();
        }
        return null;
    }

    public w3.g F0(m3.m mVar, b bVar, k3.j jVar) {
        w3.g A0;
        b3.e0 e0Var = (b3.e0) a(bVar, b3.e0.class);
        l3.h hVar = (l3.h) a(bVar, l3.h.class);
        if (hVar != null) {
            if (e0Var == null) {
                return null;
            }
            A0 = mVar.G(bVar, hVar.value());
        } else {
            if (e0Var == null) {
                return null;
            }
            if (e0Var.use() == e0.b.NONE) {
                return z0();
            }
            A0 = A0();
        }
        l3.g gVar = (l3.g) a(bVar, l3.g.class);
        w3.f F = gVar != null ? mVar.F(bVar, gVar.value()) : null;
        if (F != null) {
            F.c(jVar);
        }
        w3.g h10 = A0.h(e0Var.use(), F);
        e0.a include = e0Var.include();
        if (include == e0.a.EXTERNAL_PROPERTY && (bVar instanceof c)) {
            include = e0.a.PROPERTY;
        }
        w3.g c10 = h10.f(include).c(e0Var.property());
        Class defaultImpl = e0Var.defaultImpl();
        if (defaultImpl != e0.c.class && !defaultImpl.isAnnotation()) {
            c10 = c10.d(defaultImpl);
        }
        return c10.a(e0Var.visible());
    }

    @Override // k3.b
    public List G(b bVar) {
        b3.c cVar = (b3.c) a(bVar, b3.c.class);
        if (cVar == null) {
            return null;
        }
        String[] value = cVar.value();
        int length = value.length;
        if (length == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(length);
        for (String str : value) {
            arrayList.add(k3.x.a(str));
        }
        return arrayList;
    }

    public boolean G0(b bVar) {
        b3.o oVar = (b3.o) a(bVar, b3.o.class);
        if (oVar != null) {
            return oVar.value();
        }
        return false;
    }

    @Override // k3.b
    public w3.g H(m3.m mVar, i iVar, k3.j jVar) {
        if (jVar.k() != null) {
            return F0(mVar, iVar, jVar);
        }
        throw new IllegalArgumentException("Must call method with a container or reference type (got " + jVar + ")");
    }

    public final boolean H0(Class cls, Class cls2) {
        return cls.isPrimitive() ? cls == d4.h.b0(cls2) : cls2.isPrimitive() && cls2 == d4.h.b0(cls);
    }

    @Override // k3.b
    public String I(b bVar) {
        b3.w wVar = (b3.w) a(bVar, b3.w.class);
        if (wVar == null) {
            return null;
        }
        String defaultValue = wVar.defaultValue();
        if (defaultValue.isEmpty()) {
            return null;
        }
        return defaultValue;
    }

    public final boolean I0(k3.j jVar, Class cls) {
        return jVar.K() ? jVar.y(d4.h.b0(cls)) : cls.isPrimitive() && cls == d4.h.b0(jVar.q());
    }

    @Override // k3.b
    public String J(b bVar) {
        b3.x xVar = (b3.x) a(bVar, b3.x.class);
        if (xVar == null) {
            return null;
        }
        return xVar.value();
    }

    public k3.x J0(String str, String str2) {
        return str.isEmpty() ? k3.x.f15006d : (str2 == null || str2.isEmpty()) ? k3.x.a(str) : k3.x.b(str, str2);
    }

    @Override // k3.b
    public p.a K(m3.m mVar, b bVar) {
        b3.p pVar = (b3.p) a(bVar, b3.p.class);
        return pVar == null ? p.a.f() : p.a.i(pVar);
    }

    public final r.b K0(b bVar, r.b bVar2) {
        l3.f fVar = (l3.f) a(bVar, l3.f.class);
        if (fVar != null) {
            int i10 = a.f18504a[fVar.include().ordinal()];
            if (i10 == 1) {
                return bVar2.n(r.a.ALWAYS);
            }
            if (i10 == 2) {
                return bVar2.n(r.a.NON_NULL);
            }
            if (i10 == 3) {
                return bVar2.n(r.a.NON_DEFAULT);
            }
            if (i10 == 4) {
                return bVar2.n(r.a.NON_EMPTY);
            }
        }
        return bVar2;
    }

    @Override // k3.b
    public p.a L(b bVar) {
        return K(null, bVar);
    }

    @Override // k3.b
    public r.b M(b bVar) {
        b3.r rVar = (b3.r) a(bVar, b3.r.class);
        r.b c10 = rVar == null ? r.b.c() : r.b.d(rVar);
        return c10.h() == r.a.USE_DEFAULTS ? K0(bVar, c10) : c10;
    }

    @Override // k3.b
    public s.a N(m3.m mVar, b bVar) {
        b3.s sVar = (b3.s) a(bVar, b3.s.class);
        return sVar == null ? s.a.c() : s.a.d(sVar);
    }

    @Override // k3.b
    public Integer O(b bVar) {
        int index;
        b3.w wVar = (b3.w) a(bVar, b3.w.class);
        if (wVar == null || (index = wVar.index()) == -1) {
            return null;
        }
        return Integer.valueOf(index);
    }

    @Override // k3.b
    public w3.g P(m3.m mVar, i iVar, k3.j jVar) {
        if (jVar.D() || jVar.b()) {
            return null;
        }
        return F0(mVar, iVar, jVar);
    }

    @Override // k3.b
    public b.a Q(i iVar) {
        b3.u uVar = (b3.u) a(iVar, b3.u.class);
        if (uVar != null) {
            return b.a.e(uVar.value());
        }
        b3.g gVar = (b3.g) a(iVar, b3.g.class);
        if (gVar != null) {
            return b.a.a(gVar.value());
        }
        return null;
    }

    @Override // k3.b
    public k3.x R(m3.m mVar, g gVar, k3.x xVar) {
        return null;
    }

    @Override // k3.b
    public k3.x S(c cVar) {
        b3.a0 a0Var = (b3.a0) a(cVar, b3.a0.class);
        if (a0Var == null) {
            return null;
        }
        String namespace = a0Var.namespace();
        return k3.x.b(a0Var.value(), (namespace == null || !namespace.isEmpty()) ? namespace : null);
    }

    @Override // k3.b
    public Object T(i iVar) {
        l3.f fVar = (l3.f) a(iVar, l3.f.class);
        if (fVar == null) {
            return null;
        }
        return y0(fVar.contentConverter(), j.a.class);
    }

    @Override // k3.b
    public Object U(b bVar) {
        l3.f fVar = (l3.f) a(bVar, l3.f.class);
        if (fVar == null) {
            return null;
        }
        return y0(fVar.converter(), j.a.class);
    }

    @Override // k3.b
    public String[] V(c cVar) {
        b3.y yVar = (b3.y) a(cVar, b3.y.class);
        if (yVar == null) {
            return null;
        }
        return yVar.value();
    }

    @Override // k3.b
    public Boolean W(b bVar) {
        return E0(bVar);
    }

    @Override // k3.b
    public f.b X(b bVar) {
        l3.f fVar = (l3.f) a(bVar, l3.f.class);
        if (fVar == null) {
            return null;
        }
        return fVar.typing();
    }

    @Override // k3.b
    public Object Y(b bVar) {
        Class using;
        l3.f fVar = (l3.f) a(bVar, l3.f.class);
        if (fVar != null && (using = fVar.using()) != o.a.class) {
            return using;
        }
        b3.z zVar = (b3.z) a(bVar, b3.z.class);
        if (zVar == null || !zVar.value()) {
            return null;
        }
        return new com.fasterxml.jackson.databind.ser.std.y(bVar.e());
    }

    @Override // k3.b
    public b0.a Z(b bVar) {
        return b0.a.d((b3.b0) a(bVar, b3.b0.class));
    }

    @Override // k3.b
    public List a0(b bVar) {
        b3.c0 c0Var = (b3.c0) a(bVar, b3.c0.class);
        if (c0Var == null) {
            return null;
        }
        c0.a[] value = c0Var.value();
        ArrayList arrayList = new ArrayList(value.length);
        for (c0.a aVar : value) {
            arrayList.add(new w3.b(aVar.value(), aVar.name()));
            for (String str : aVar.names()) {
                arrayList.add(new w3.b(aVar.value(), str));
            }
        }
        return arrayList;
    }

    @Override // k3.b
    public String b0(c cVar) {
        b3.f0 f0Var = (b3.f0) a(cVar, b3.f0.class);
        if (f0Var == null) {
            return null;
        }
        return f0Var.value();
    }

    @Override // k3.b
    public w3.g c0(m3.m mVar, c cVar, k3.j jVar) {
        return F0(mVar, cVar, jVar);
    }

    @Override // k3.b
    public void d(m3.m mVar, c cVar, List list) {
        l3.b bVar = (l3.b) a(cVar, l3.b.class);
        if (bVar == null) {
            return;
        }
        boolean prepend = bVar.prepend();
        b.a[] attrs = bVar.attrs();
        int length = attrs.length;
        k3.j jVar = null;
        for (int i10 = 0; i10 < length; i10++) {
            if (jVar == null) {
                jVar = mVar.e(Object.class);
            }
            a4.c B0 = B0(attrs[i10], mVar, cVar, jVar);
            if (prepend) {
                list.add(i10, B0);
            } else {
                list.add(B0);
            }
        }
        b.InterfaceC0270b[] props = bVar.props();
        int length2 = props.length;
        for (int i11 = 0; i11 < length2; i11++) {
            a4.c C0 = C0(props[i11], mVar, cVar);
            if (prepend) {
                list.add(i11, C0);
            } else {
                list.add(C0);
            }
        }
    }

    @Override // k3.b
    public d4.q d0(i iVar) {
        b3.g0 g0Var = (b3.g0) a(iVar, b3.g0.class);
        if (g0Var == null || !g0Var.enabled()) {
            return null;
        }
        return d4.q.b(g0Var.prefix(), g0Var.suffix());
    }

    @Override // k3.b
    public h0 e(c cVar, h0 h0Var) {
        b3.f fVar = (b3.f) a(cVar, b3.f.class);
        return fVar == null ? h0Var : h0Var.a(fVar);
    }

    @Override // k3.b
    public Object e0(c cVar) {
        l3.i iVar = (l3.i) a(cVar, l3.i.class);
        if (iVar == null) {
            return null;
        }
        return iVar.value();
    }

    @Override // k3.b
    public Object f(b bVar) {
        Class contentUsing;
        l3.c cVar = (l3.c) a(bVar, l3.c.class);
        if (cVar == null || (contentUsing = cVar.contentUsing()) == k.a.class) {
            return null;
        }
        return contentUsing;
    }

    @Override // k3.b
    public Class[] f0(b bVar) {
        i0 i0Var = (i0) a(bVar, i0.class);
        if (i0Var == null) {
            return null;
        }
        return i0Var.value();
    }

    @Override // k3.b
    public Object g(b bVar) {
        Class contentUsing;
        l3.f fVar = (l3.f) a(bVar, l3.f.class);
        if (fVar == null || (contentUsing = fVar.contentUsing()) == o.a.class) {
            return null;
        }
        return contentUsing;
    }

    @Override // k3.b
    public h.a h(m3.m mVar, b bVar) {
        b3.h hVar = (b3.h) a(bVar, b3.h.class);
        if (hVar != null) {
            return hVar.mode();
        }
        if (!this.f18503b || !mVar.D(k3.q.INFER_CREATOR_FROM_CONSTRUCTOR_PROPERTIES)) {
            return null;
        }
        boolean z10 = bVar instanceof e;
        return null;
    }

    @Override // k3.b
    public Boolean h0(b bVar) {
        b3.d dVar = (b3.d) a(bVar, b3.d.class);
        if (dVar == null) {
            return null;
        }
        return Boolean.valueOf(dVar.enabled());
    }

    @Override // k3.b
    public h.a i(b bVar) {
        b3.h hVar = (b3.h) a(bVar, b3.h.class);
        if (hVar == null) {
            return null;
        }
        return hVar.mode();
    }

    @Override // k3.b
    public boolean i0(j jVar) {
        return b(jVar, b3.d.class);
    }

    @Override // k3.b
    public Enum j(Class cls) {
        return d4.h.v(cls, b3.i.class);
    }

    @Override // k3.b
    public Boolean j0(b bVar) {
        b3.e eVar = (b3.e) a(bVar, b3.e.class);
        if (eVar == null) {
            return null;
        }
        return Boolean.valueOf(eVar.enabled());
    }

    @Override // k3.b
    public Object k(i iVar) {
        l3.c cVar = (l3.c) a(iVar, l3.c.class);
        if (cVar == null) {
            return null;
        }
        return y0(cVar.contentConverter(), j.a.class);
    }

    @Override // k3.b
    public Boolean k0(m3.m mVar, b bVar) {
        b3.t tVar = (b3.t) a(bVar, b3.t.class);
        if (tVar == null) {
            return null;
        }
        return Boolean.valueOf(tVar.value());
    }

    @Override // k3.b
    public Object l(b bVar) {
        l3.c cVar = (l3.c) a(bVar, l3.c.class);
        if (cVar == null) {
            return null;
        }
        return y0(cVar.converter(), j.a.class);
    }

    @Override // k3.b
    public Boolean l0(b bVar) {
        b3.h0 h0Var = (b3.h0) a(bVar, b3.h0.class);
        if (h0Var == null) {
            return null;
        }
        return Boolean.valueOf(h0Var.value());
    }

    @Override // k3.b
    public Object m(b bVar) {
        Class using;
        l3.c cVar = (l3.c) a(bVar, l3.c.class);
        if (cVar == null || (using = cVar.using()) == k.a.class) {
            return null;
        }
        return using;
    }

    @Override // k3.b
    public boolean m0(j jVar) {
        b3.h0 h0Var = (b3.h0) a(jVar, b3.h0.class);
        return h0Var != null && h0Var.value();
    }

    @Override // k3.b
    public void n(Class cls, Enum[] enumArr, String[][] strArr) {
        b3.c cVar;
        for (Field field : cls.getDeclaredFields()) {
            if (field.isEnumConstant() && (cVar = (b3.c) field.getAnnotation(b3.c.class)) != null) {
                String[] value = cVar.value();
                if (value.length != 0) {
                    String name = field.getName();
                    int length = enumArr.length;
                    for (int i10 = 0; i10 < length; i10++) {
                        if (name.equals(enumArr[i10].name())) {
                            strArr[i10] = value;
                        }
                    }
                }
            }
        }
    }

    @Override // k3.b
    public boolean n0(b bVar) {
        b3.h hVar = (b3.h) a(bVar, b3.h.class);
        if (hVar != null) {
            return hVar.mode() != h.a.DISABLED;
        }
        if (this.f18503b) {
            boolean z10 = bVar instanceof e;
        }
        return false;
    }

    @Override // k3.b
    public String[] o(Class cls, Enum[] enumArr, String[] strArr) {
        b3.w wVar;
        HashMap hashMap = null;
        for (Field field : cls.getDeclaredFields()) {
            if (field.isEnumConstant() && (wVar = (b3.w) field.getAnnotation(b3.w.class)) != null) {
                String value = wVar.value();
                if (!value.isEmpty()) {
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    hashMap.put(field.getName(), value);
                }
            }
        }
        if (hashMap != null) {
            int length = enumArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                String str = (String) hashMap.get(enumArr[i10].name());
                if (str != null) {
                    strArr[i10] = str;
                }
            }
        }
        return strArr;
    }

    @Override // k3.b
    public boolean o0(i iVar) {
        return G0(iVar);
    }

    @Override // k3.b
    public Object p(b bVar) {
        b3.j jVar = (b3.j) a(bVar, b3.j.class);
        if (jVar == null) {
            return null;
        }
        String value = jVar.value();
        if (value.isEmpty()) {
            return null;
        }
        return value;
    }

    @Override // k3.b
    public Boolean p0(i iVar) {
        b3.w wVar = (b3.w) a(iVar, b3.w.class);
        if (wVar != null) {
            return Boolean.valueOf(wVar.required());
        }
        return null;
    }

    @Override // k3.b
    public k.d q(b bVar) {
        b3.k kVar = (b3.k) a(bVar, b3.k.class);
        if (kVar == null) {
            return null;
        }
        return k.d.d(kVar);
    }

    @Override // k3.b
    public boolean q0(Annotation annotation) {
        Class<? extends Annotation> annotationType = annotation.annotationType();
        Boolean bool = (Boolean) this.f18502a.get(annotationType);
        if (bool == null) {
            bool = Boolean.valueOf(annotationType.getAnnotation(b3.a.class) != null);
            this.f18502a.putIfAbsent(annotationType, bool);
        }
        return bool.booleanValue();
    }

    @Override // k3.b
    public String r(i iVar) {
        k3.x D0 = D0(iVar);
        if (D0 == null) {
            return null;
        }
        return D0.c();
    }

    @Override // k3.b
    public Boolean r0(c cVar) {
        b3.q qVar = (b3.q) a(cVar, b3.q.class);
        if (qVar == null) {
            return null;
        }
        return Boolean.valueOf(qVar.value());
    }

    @Override // k3.b
    public b.a s(i iVar) {
        String name;
        b3.b bVar = (b3.b) a(iVar, b3.b.class);
        if (bVar == null) {
            return null;
        }
        b.a d10 = b.a.d(bVar);
        if (d10.f()) {
            return d10;
        }
        if (iVar instanceof j) {
            j jVar = (j) iVar;
            name = jVar.v() == 0 ? iVar.e().getName() : jVar.x(0).getName();
        } else {
            name = iVar.e().getName();
        }
        return d10.h(name);
    }

    @Override // k3.b
    public Boolean s0(i iVar) {
        return Boolean.valueOf(b(iVar, b3.d0.class));
    }

    @Override // k3.b
    public Object t(i iVar) {
        b.a s10 = s(iVar);
        if (s10 == null) {
            return null;
        }
        return s10.e();
    }

    @Override // k3.b
    public Object u(b bVar) {
        Class keyUsing;
        l3.c cVar = (l3.c) a(bVar, l3.c.class);
        if (cVar == null || (keyUsing = cVar.keyUsing()) == p.a.class) {
            return null;
        }
        return keyUsing;
    }

    @Override // k3.b
    public k3.j u0(m3.m mVar, b bVar, k3.j jVar) {
        c4.o z10 = mVar.z();
        l3.c cVar = (l3.c) a(bVar, l3.c.class);
        Class x02 = cVar == null ? null : x0(cVar.as());
        if (x02 != null && !jVar.y(x02) && !I0(jVar, x02)) {
            try {
                jVar = z10.F(jVar, x02);
            } catch (IllegalArgumentException e10) {
                throw new k3.l((Closeable) null, String.format("Failed to narrow type %s with annotation (value %s), from '%s': %s", jVar, x02.getName(), bVar.d(), e10.getMessage()), e10);
            }
        }
        if (jVar.J()) {
            k3.j p10 = jVar.p();
            Class x03 = cVar == null ? null : x0(cVar.keyAs());
            if (x03 != null && !I0(p10, x03)) {
                try {
                    jVar = ((c4.g) jVar).b0(z10.F(p10, x03));
                } catch (IllegalArgumentException e11) {
                    throw new k3.l((Closeable) null, String.format("Failed to narrow key type of %s with concrete-type annotation (value %s), from '%s': %s", jVar, x03.getName(), bVar.d(), e11.getMessage()), e11);
                }
            }
        }
        k3.j k10 = jVar.k();
        if (k10 == null) {
            return jVar;
        }
        Class x04 = cVar == null ? null : x0(cVar.contentAs());
        if (x04 == null || I0(k10, x04)) {
            return jVar;
        }
        try {
            return jVar.R(z10.F(k10, x04));
        } catch (IllegalArgumentException e12) {
            throw new k3.l((Closeable) null, String.format("Failed to narrow value type of %s with concrete-type annotation (value %s), from '%s': %s", jVar, x04.getName(), bVar.d(), e12.getMessage()), e12);
        }
    }

    @Override // k3.b
    public Object v(b bVar) {
        Class keyUsing;
        l3.f fVar = (l3.f) a(bVar, l3.f.class);
        if (fVar == null || (keyUsing = fVar.keyUsing()) == o.a.class) {
            return null;
        }
        return keyUsing;
    }

    @Override // k3.b
    public k3.j v0(m3.m mVar, b bVar, k3.j jVar) {
        k3.j d02;
        k3.j d03;
        c4.o z10 = mVar.z();
        l3.f fVar = (l3.f) a(bVar, l3.f.class);
        Class<?> x02 = fVar == null ? null : x0(fVar.as());
        if (x02 != null) {
            if (jVar.y(x02)) {
                jVar = jVar.d0();
            } else {
                Class<?> q10 = jVar.q();
                try {
                    if (x02.isAssignableFrom(q10)) {
                        jVar = z10.B(jVar, x02);
                    } else if (q10.isAssignableFrom(x02)) {
                        jVar = z10.F(jVar, x02);
                    } else {
                        if (!H0(q10, x02)) {
                            throw new k3.l(null, String.format("Cannot refine serialization type %s into %s; types not related", jVar, x02.getName()));
                        }
                        jVar = jVar.d0();
                    }
                } catch (IllegalArgumentException e10) {
                    throw new k3.l((Closeable) null, String.format("Failed to widen type %s with annotation (value %s), from '%s': %s", jVar, x02.getName(), bVar.d(), e10.getMessage()), e10);
                }
            }
        }
        if (jVar.J()) {
            k3.j p10 = jVar.p();
            Class<?> x03 = fVar == null ? null : x0(fVar.keyAs());
            if (x03 != null) {
                if (p10.y(x03)) {
                    d03 = p10.d0();
                } else {
                    Class<?> q11 = p10.q();
                    try {
                        if (x03.isAssignableFrom(q11)) {
                            d03 = z10.B(p10, x03);
                        } else if (q11.isAssignableFrom(x03)) {
                            d03 = z10.F(p10, x03);
                        } else {
                            if (!H0(q11, x03)) {
                                throw new k3.l(null, String.format("Cannot refine serialization key type %s into %s; types not related", p10, x03.getName()));
                            }
                            d03 = p10.d0();
                        }
                    } catch (IllegalArgumentException e11) {
                        throw new k3.l((Closeable) null, String.format("Failed to widen key type of %s with concrete-type annotation (value %s), from '%s': %s", jVar, x03.getName(), bVar.d(), e11.getMessage()), e11);
                    }
                }
                jVar = ((c4.g) jVar).b0(d03);
            }
        }
        k3.j k10 = jVar.k();
        if (k10 == null) {
            return jVar;
        }
        Class<?> x04 = fVar == null ? null : x0(fVar.contentAs());
        if (x04 == null) {
            return jVar;
        }
        if (k10.y(x04)) {
            d02 = k10.d0();
        } else {
            Class<?> q12 = k10.q();
            try {
                if (x04.isAssignableFrom(q12)) {
                    d02 = z10.B(k10, x04);
                } else if (q12.isAssignableFrom(x04)) {
                    d02 = z10.F(k10, x04);
                } else {
                    if (!H0(q12, x04)) {
                        throw new k3.l(null, String.format("Cannot refine serialization content type %s into %s; types not related", k10, x04.getName()));
                    }
                    d02 = k10.d0();
                }
            } catch (IllegalArgumentException e12) {
                throw new k3.l((Closeable) null, String.format("Internal error: failed to refine value type of %s with concrete-type annotation (value %s), from '%s': %s", jVar, x04.getName(), bVar.d(), e12.getMessage()), e12);
            }
        }
        return jVar.R(d02);
    }

    @Override // k3.b
    public Boolean w(b bVar) {
        b3.v vVar = (b3.v) a(bVar, b3.v.class);
        if (vVar == null) {
            return null;
        }
        return vVar.value().a();
    }

    @Override // k3.b
    public j w0(m3.m mVar, j jVar, j jVar2) {
        Class x10 = jVar.x(0);
        Class x11 = jVar2.x(0);
        if (x10.isPrimitive()) {
            if (!x11.isPrimitive()) {
                return jVar;
            }
        } else if (x11.isPrimitive()) {
            return jVar2;
        }
        if (x10 == String.class) {
            if (x11 != String.class) {
                return jVar;
            }
            return null;
        }
        if (x11 == String.class) {
            return jVar2;
        }
        return null;
    }

    @Override // k3.b
    public k3.x x(b bVar) {
        boolean z10;
        b3.b0 b0Var = (b3.b0) a(bVar, b3.b0.class);
        if (b0Var != null) {
            String value = b0Var.value();
            if (!value.isEmpty()) {
                return k3.x.a(value);
            }
            z10 = true;
        } else {
            z10 = false;
        }
        b3.w wVar = (b3.w) a(bVar, b3.w.class);
        if (wVar != null) {
            String namespace = wVar.namespace();
            return k3.x.b(wVar.value(), (namespace == null || !namespace.isEmpty()) ? namespace : null);
        }
        if (z10 || c(bVar, f18501d)) {
            return k3.x.f15006d;
        }
        return null;
    }

    public Class x0(Class cls) {
        if (cls == null || d4.h.J(cls)) {
            return null;
        }
        return cls;
    }

    @Override // k3.b
    public k3.x y(b bVar) {
        boolean z10;
        b3.l lVar = (b3.l) a(bVar, b3.l.class);
        if (lVar != null) {
            String value = lVar.value();
            if (!value.isEmpty()) {
                return k3.x.a(value);
            }
            z10 = true;
        } else {
            z10 = false;
        }
        b3.w wVar = (b3.w) a(bVar, b3.w.class);
        if (wVar != null) {
            String namespace = wVar.namespace();
            return k3.x.b(wVar.value(), (namespace == null || !namespace.isEmpty()) ? namespace : null);
        }
        if (z10 || c(bVar, f18500c)) {
            return k3.x.f15006d;
        }
        return null;
    }

    public Class y0(Class cls, Class cls2) {
        Class x02 = x0(cls);
        if (x02 == null || x02 == cls2) {
            return null;
        }
        return x02;
    }

    @Override // k3.b
    public Object z(c cVar) {
        l3.d dVar = (l3.d) a(cVar, l3.d.class);
        if (dVar == null) {
            return null;
        }
        return dVar.value();
    }

    public x3.o z0() {
        return x3.o.o();
    }
}
