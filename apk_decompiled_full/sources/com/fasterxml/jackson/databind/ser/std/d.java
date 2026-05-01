package com.fasterxml.jackson.databind.ser.std;

import b3.k;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import k3.l;

/* loaded from: classes.dex */
public abstract class d extends i0 implements a4.i, a4.o {

    /* renamed from: i, reason: collision with root package name */
    public static final k3.x f6671i = new k3.x("#object-ref");

    /* renamed from: j, reason: collision with root package name */
    public static final a4.c[] f6672j = new a4.c[0];

    /* renamed from: a, reason: collision with root package name */
    public final k3.j f6673a;

    /* renamed from: b, reason: collision with root package name */
    public final a4.c[] f6674b;

    /* renamed from: c, reason: collision with root package name */
    public final a4.c[] f6675c;

    /* renamed from: d, reason: collision with root package name */
    public final a4.a f6676d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f6677e;

    /* renamed from: f, reason: collision with root package name */
    public final r3.i f6678f;

    /* renamed from: g, reason: collision with root package name */
    public final b4.i f6679g;

    /* renamed from: h, reason: collision with root package name */
    public final k.c f6680h;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6681a;

        static {
            int[] iArr = new int[k.c.values().length];
            f6681a = iArr;
            try {
                iArr[k.c.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6681a[k.c.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6681a[k.c.NUMBER_INT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public d(k3.j jVar, a4.e eVar, a4.c[] cVarArr, a4.c[] cVarArr2) {
        super(jVar);
        this.f6673a = jVar;
        this.f6674b = cVarArr;
        this.f6675c = cVarArr2;
        if (eVar == null) {
            this.f6678f = null;
            this.f6676d = null;
            this.f6677e = null;
            this.f6679g = null;
            this.f6680h = null;
            return;
        }
        this.f6678f = eVar.h();
        this.f6676d = eVar.c();
        this.f6677e = eVar.e();
        this.f6679g = eVar.f();
        this.f6680h = eVar.d().g(null).i();
    }

    public static final a4.c[] i(a4.c[] cVarArr, d4.q qVar) {
        if (cVarArr == null || cVarArr.length == 0 || qVar == null || qVar == d4.q.f12559a) {
            return cVarArr;
        }
        int length = cVarArr.length;
        a4.c[] cVarArr2 = new a4.c[length];
        for (int i10 = 0; i10 < length; i10++) {
            a4.c cVar = cVarArr[i10];
            if (cVar != null) {
                cVarArr2[i10] = cVar.w(qVar);
            }
        }
        return cVarArr2;
    }

    @Override // a4.o
    public void a(k3.c0 c0Var) {
        a4.c cVar;
        w3.h hVar;
        k3.o L;
        a4.c cVar2;
        a4.c[] cVarArr = this.f6675c;
        int length = cVarArr == null ? 0 : cVarArr.length;
        int length2 = this.f6674b.length;
        for (int i10 = 0; i10 < length2; i10++) {
            a4.c cVar3 = this.f6674b[i10];
            if (!cVar3.D() && !cVar3.u() && (L = c0Var.L(cVar3)) != null) {
                cVar3.k(L);
                if (i10 < length && (cVar2 = this.f6675c[i10]) != null) {
                    cVar2.k(L);
                }
            }
            if (!cVar3.v()) {
                k3.o h10 = h(c0Var, cVar3);
                if (h10 == null) {
                    k3.j q10 = cVar3.q();
                    if (q10 == null) {
                        q10 = cVar3.getType();
                        if (!q10.G()) {
                            if (q10.D() || q10.g() > 0) {
                                cVar3.B(q10);
                            }
                        }
                    }
                    k3.o U = c0Var.U(q10, cVar3);
                    h10 = (q10.D() && (hVar = (w3.h) q10.k().t()) != null && (U instanceof a4.h)) ? ((a4.h) U).d(hVar) : U;
                }
                if (i10 >= length || (cVar = this.f6675c[i10]) == null) {
                    cVar3.l(h10);
                } else {
                    cVar.l(h10);
                }
            }
        }
        a4.a aVar = this.f6676d;
        if (aVar != null) {
            aVar.c(c0Var);
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    public void acceptJsonFormatVisitor(u3.f fVar, k3.j jVar) {
        if (fVar == null) {
            return;
        }
        fVar.b(jVar);
    }

    @Override // a4.i
    public k3.o b(k3.c0 c0Var, k3.d dVar) {
        k.c cVar;
        a4.c[] cVarArr;
        Object obj;
        Set set;
        Set set2;
        int i10;
        d dVar2;
        b4.i c10;
        a4.c cVar2;
        Object obj2;
        r3.b0 C;
        k3.b W = c0Var.W();
        r3.i d10 = (dVar == null || W == null) ? null : dVar.d();
        k3.a0 k10 = c0Var.k();
        k.d findFormatOverrides = findFormatOverrides(c0Var, dVar, this._handledType);
        int i11 = 2;
        if (findFormatOverrides == null || !findFormatOverrides.n()) {
            cVar = null;
        } else {
            cVar = findFormatOverrides.i();
            if (cVar != k.c.ANY && cVar != this.f6680h) {
                if (this.f6673a.F()) {
                    int i12 = a.f6681a[cVar.ordinal()];
                    if (i12 == 1 || i12 == 2 || i12 == 3) {
                        return c0Var.h0(m.e(this.f6673a.q(), c0Var.k(), k10.B(this.f6673a), findFormatOverrides), dVar);
                    }
                } else if (cVar == k.c.NATURAL && ((!this.f6673a.J() || !Map.class.isAssignableFrom(this._handledType)) && Map.Entry.class.isAssignableFrom(this._handledType))) {
                    k3.j i13 = this.f6673a.i(Map.Entry.class);
                    return c0Var.h0(new b4.h(this.f6673a, i13.h(0), i13.h(1), false, null, dVar), dVar);
                }
            }
        }
        b4.i iVar = this.f6679g;
        if (d10 != null) {
            set2 = W.K(k10, d10).h();
            set = W.N(k10, d10).e();
            r3.b0 B = W.B(d10);
            if (B == null) {
                if (iVar != null && (C = W.C(d10, null)) != null) {
                    iVar = this.f6679g.b(C.b());
                }
                cVarArr = null;
            } else {
                r3.b0 C2 = W.C(d10, B);
                Class c11 = C2.c();
                k3.j jVar = c0Var.l().K(c0Var.i(c11), b3.k0.class)[0];
                if (c11 == b3.n0.class) {
                    String c12 = C2.d().c();
                    int length = this.f6674b.length;
                    i10 = 0;
                    while (true) {
                        if (i10 == length) {
                            k3.j jVar2 = this.f6673a;
                            Object[] objArr = new Object[i11];
                            objArr[0] = d4.h.X(handledType());
                            objArr[1] = d4.h.U(c12);
                            c0Var.q(jVar2, String.format("Invalid Object Id definition for %s: cannot find property with name %s", objArr));
                        }
                        cVar2 = this.f6674b[i10];
                        if (c12.equals(cVar2.getName())) {
                            break;
                        }
                        i10++;
                        i11 = 2;
                    }
                    cVarArr = null;
                    iVar = b4.i.a(cVar2.getType(), null, new b4.j(C2, cVar2), C2.b());
                    obj = W.p(d10);
                    if (obj != null || ((obj2 = this.f6677e) != null && obj.equals(obj2))) {
                        obj = cVarArr;
                    }
                } else {
                    cVarArr = null;
                    iVar = b4.i.a(jVar, C2.d(), c0Var.n(d10, C2), C2.b());
                }
            }
            i10 = 0;
            obj = W.p(d10);
            if (obj != null) {
            }
            obj = cVarArr;
        } else {
            cVarArr = null;
            obj = null;
            set = null;
            set2 = null;
            i10 = 0;
        }
        if (i10 > 0) {
            a4.c[] cVarArr2 = this.f6674b;
            a4.c[] cVarArr3 = (a4.c[]) Arrays.copyOf(cVarArr2, cVarArr2.length);
            a4.c cVar3 = cVarArr3[i10];
            System.arraycopy(cVarArr3, 0, cVarArr3, 1, i10);
            cVarArr3[0] = cVar3;
            a4.c[] cVarArr4 = this.f6675c;
            if (cVarArr4 != null) {
                cVarArr = (a4.c[]) Arrays.copyOf(cVarArr4, cVarArr4.length);
                a4.c cVar4 = cVarArr[i10];
                System.arraycopy(cVarArr, 0, cVarArr, 1, i10);
                cVarArr[0] = cVar4;
            }
            dVar2 = o(cVarArr3, cVarArr);
        } else {
            dVar2 = this;
        }
        if (iVar != null && (c10 = iVar.c(c0Var.U(iVar.f4605a, dVar))) != this.f6679g) {
            dVar2 = dVar2.n(c10);
        }
        if ((set2 != null && !set2.isEmpty()) || set != null) {
            dVar2 = dVar2.l(set2, set);
        }
        if (obj != null) {
            dVar2 = dVar2.withFilterId(obj);
        }
        if (cVar == null) {
            cVar = this.f6680h;
        }
        return cVar == k.c.ARRAY ? dVar2.g() : dVar2;
    }

    public void c(Object obj, c3.h hVar, k3.c0 c0Var, w3.h hVar2, b4.t tVar) {
        b4.i iVar = this.f6679g;
        i3.b f10 = f(hVar2, obj, c3.n.START_OBJECT);
        hVar2.g(hVar, f10);
        tVar.b(hVar, c0Var, iVar);
        if (this.f6677e != null) {
            k(obj, hVar, c0Var);
        } else {
            j(obj, hVar, c0Var);
        }
        hVar2.h(hVar, f10);
    }

    public final void d(Object obj, c3.h hVar, k3.c0 c0Var, w3.h hVar2) {
        b4.i iVar = this.f6679g;
        b4.t M = c0Var.M(obj, iVar.f4607c);
        if (M.c(hVar, c0Var, iVar)) {
            return;
        }
        Object a10 = M.a(obj);
        if (iVar.f4609e) {
            iVar.f4608d.serialize(a10, hVar, c0Var);
        } else {
            c(obj, hVar, c0Var, hVar2, M);
        }
    }

    public final void e(Object obj, c3.h hVar, k3.c0 c0Var, boolean z10) {
        b4.i iVar = this.f6679g;
        b4.t M = c0Var.M(obj, iVar.f4607c);
        if (M.c(hVar, c0Var, iVar)) {
            return;
        }
        Object a10 = M.a(obj);
        if (iVar.f4609e) {
            iVar.f4608d.serialize(a10, hVar, c0Var);
            return;
        }
        if (z10) {
            hVar.w0(obj);
        }
        M.b(hVar, c0Var, iVar);
        if (this.f6677e != null) {
            k(obj, hVar, c0Var);
        } else {
            j(obj, hVar, c0Var);
        }
        if (z10) {
            hVar.W();
        }
    }

    public final i3.b f(w3.h hVar, Object obj, c3.n nVar) {
        r3.i iVar = this.f6678f;
        if (iVar == null) {
            return hVar.d(obj, nVar);
        }
        Object n10 = iVar.n(obj);
        if (n10 == null) {
            n10 = "";
        }
        return hVar.e(obj, nVar, n10);
    }

    public abstract d g();

    @Override // com.fasterxml.jackson.databind.ser.std.i0, v3.c
    public k3.m getSchema(k3.c0 c0Var, Type type) {
        String id;
        z3.r createSchemaNode = createSchemaNode("object", true);
        v3.b bVar = (v3.b) this._handledType.getAnnotation(v3.b.class);
        if (bVar != null && (id = bVar.id()) != null && !id.isEmpty()) {
            createSchemaNode.C("id", id);
        }
        z3.r y10 = createSchemaNode.y();
        Object obj = this.f6677e;
        if (obj != null) {
            findPropertyFilter(c0Var, obj, null);
        }
        int i10 = 0;
        while (true) {
            a4.c[] cVarArr = this.f6674b;
            if (i10 >= cVarArr.length) {
                createSchemaNode.G("properties", y10);
                return createSchemaNode;
            }
            cVarArr[i10].n(y10, c0Var);
            i10++;
        }
    }

    public k3.o h(k3.c0 c0Var, a4.c cVar) {
        r3.i d10;
        Object U;
        k3.b W = c0Var.W();
        if (W == null || (d10 = cVar.d()) == null || (U = W.U(d10)) == null) {
            return null;
        }
        d4.j j10 = c0Var.j(cVar.d(), U);
        k3.j a10 = j10.a(c0Var.l());
        return new d0(j10, a10, a10.I() ? null : c0Var.U(a10, cVar));
    }

    public void j(Object obj, c3.h hVar, k3.c0 c0Var) {
        a4.c[] cVarArr = (this.f6675c == null || c0Var.V() == null) ? this.f6674b : this.f6675c;
        int i10 = 0;
        try {
            int length = cVarArr.length;
            while (i10 < length) {
                a4.c cVar = cVarArr[i10];
                if (cVar != null) {
                    cVar.y(obj, hVar, c0Var);
                }
                i10++;
            }
            a4.a aVar = this.f6676d;
            if (aVar != null) {
                aVar.b(obj, hVar, c0Var);
            }
        } catch (Exception e10) {
            wrapAndThrow(c0Var, e10, obj, i10 != cVarArr.length ? cVarArr[i10].getName() : "[anySetter]");
        } catch (StackOverflowError e11) {
            k3.l lVar = new k3.l(hVar, "Infinite recursion (StackOverflowError)", e11);
            lVar.o(new l.a(obj, i10 != cVarArr.length ? cVarArr[i10].getName() : "[anySetter]"));
            throw lVar;
        }
    }

    public void k(Object obj, c3.h hVar, k3.c0 c0Var) {
        if (this.f6675c != null) {
            c0Var.V();
        }
        findPropertyFilter(c0Var, this.f6677e, obj);
        j(obj, hVar, c0Var);
    }

    public abstract d l(Set set, Set set2);

    /* renamed from: m */
    public abstract d withFilterId(Object obj);

    public abstract d n(b4.i iVar);

    public abstract d o(a4.c[] cVarArr, a4.c[] cVarArr2);

    @Override // k3.o
    public Iterator properties() {
        return Arrays.asList(this.f6674b).iterator();
    }

    @Override // k3.o
    public void serializeWithType(Object obj, c3.h hVar, k3.c0 c0Var, w3.h hVar2) {
        if (this.f6679g != null) {
            hVar.z(obj);
            d(obj, hVar, c0Var, hVar2);
            return;
        }
        hVar.z(obj);
        i3.b f10 = f(hVar2, obj, c3.n.START_OBJECT);
        hVar2.g(hVar, f10);
        if (this.f6677e != null) {
            k(obj, hVar, c0Var);
        } else {
            j(obj, hVar, c0Var);
        }
        hVar2.h(hVar, f10);
    }

    @Override // k3.o
    public boolean usesObjectId() {
        return this.f6679g != null;
    }

    public d(d dVar, a4.c[] cVarArr, a4.c[] cVarArr2) {
        super(dVar._handledType);
        this.f6673a = dVar.f6673a;
        this.f6674b = cVarArr;
        this.f6675c = cVarArr2;
        this.f6678f = dVar.f6678f;
        this.f6676d = dVar.f6676d;
        this.f6679g = dVar.f6679g;
        this.f6677e = dVar.f6677e;
        this.f6680h = dVar.f6680h;
    }

    public d(d dVar, b4.i iVar) {
        this(dVar, iVar, dVar.f6677e);
    }

    public d(d dVar, b4.i iVar, Object obj) {
        super(dVar._handledType);
        this.f6673a = dVar.f6673a;
        this.f6674b = dVar.f6674b;
        this.f6675c = dVar.f6675c;
        this.f6678f = dVar.f6678f;
        this.f6676d = dVar.f6676d;
        this.f6679g = iVar;
        this.f6677e = obj;
        this.f6680h = dVar.f6680h;
    }

    public d(d dVar, Set set, Set set2) {
        super(dVar._handledType);
        this.f6673a = dVar.f6673a;
        a4.c[] cVarArr = dVar.f6674b;
        a4.c[] cVarArr2 = dVar.f6675c;
        int length = cVarArr.length;
        ArrayList arrayList = new ArrayList(length);
        ArrayList arrayList2 = cVarArr2 == null ? null : new ArrayList(length);
        for (int i10 = 0; i10 < length; i10++) {
            a4.c cVar = cVarArr[i10];
            if (!d4.m.c(cVar.getName(), set, set2)) {
                arrayList.add(cVar);
                if (cVarArr2 != null) {
                    arrayList2.add(cVarArr2[i10]);
                }
            }
        }
        this.f6674b = (a4.c[]) arrayList.toArray(new a4.c[arrayList.size()]);
        this.f6675c = arrayList2 != null ? (a4.c[]) arrayList2.toArray(new a4.c[arrayList2.size()]) : null;
        this.f6678f = dVar.f6678f;
        this.f6676d = dVar.f6676d;
        this.f6679g = dVar.f6679g;
        this.f6677e = dVar.f6677e;
        this.f6680h = dVar.f6680h;
    }

    public d(d dVar, d4.q qVar) {
        this(dVar, i(dVar.f6674b, qVar), i(dVar.f6675c, qVar));
    }
}
