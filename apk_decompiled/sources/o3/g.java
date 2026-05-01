package o3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public final k3.j f17517a;

    /* renamed from: b, reason: collision with root package name */
    public final b[] f17518b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f17519c;

    /* renamed from: d, reason: collision with root package name */
    public final String[] f17520d;

    /* renamed from: e, reason: collision with root package name */
    public final d4.y[] f17521e;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final k3.j f17522a;

        /* renamed from: b, reason: collision with root package name */
        public final List f17523b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public final Map f17524c = new HashMap();

        public a(k3.j jVar) {
            this.f17522a = jVar;
        }

        public final void a(String str, Integer num) {
            Object obj = this.f17524c.get(str);
            if (obj == null) {
                this.f17524c.put(str, num);
                return;
            }
            if (obj instanceof List) {
                ((List) obj).add(num);
                return;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(obj);
            linkedList.add(num);
            this.f17524c.put(str, linkedList);
        }

        public void b(n3.t tVar, w3.e eVar) {
            Integer valueOf = Integer.valueOf(this.f17523b.size());
            this.f17523b.add(new b(tVar, eVar));
            a(tVar.getName(), valueOf);
            a(eVar.i(), valueOf);
        }

        public g c(c cVar) {
            int size = this.f17523b.size();
            b[] bVarArr = new b[size];
            for (int i10 = 0; i10 < size; i10++) {
                b bVar = (b) this.f17523b.get(i10);
                n3.t k10 = cVar.k(bVar.d());
                if (k10 != null) {
                    bVar.g(k10);
                }
                bVarArr[i10] = bVar;
            }
            return new g(this.f17522a, bVarArr, this.f17524c, null, null);
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final n3.t f17525a;

        /* renamed from: b, reason: collision with root package name */
        public final w3.e f17526b;

        /* renamed from: c, reason: collision with root package name */
        public final String f17527c;

        /* renamed from: d, reason: collision with root package name */
        public n3.t f17528d;

        public b(n3.t tVar, w3.e eVar) {
            this.f17525a = tVar;
            this.f17526b = eVar;
            this.f17527c = eVar.i();
        }

        public String a() {
            Class h10 = this.f17526b.h();
            if (h10 == null) {
                return null;
            }
            return this.f17526b.j().d(null, h10);
        }

        public n3.t b() {
            return this.f17525a;
        }

        public n3.t c() {
            return this.f17528d;
        }

        public String d() {
            return this.f17527c;
        }

        public boolean e() {
            return this.f17526b.l();
        }

        public boolean f(String str) {
            return str.equals(this.f17527c);
        }

        public void g(n3.t tVar) {
            this.f17528d = tVar;
        }
    }

    public g(k3.j jVar, b[] bVarArr, Map map, String[] strArr, d4.y[] yVarArr) {
        this.f17517a = jVar;
        this.f17518b = bVarArr;
        this.f17519c = map;
        this.f17520d = strArr;
        this.f17521e = yVarArr;
    }

    public static a d(k3.j jVar) {
        return new a(jVar);
    }

    public final Object a(c3.k kVar, k3.g gVar, int i10, String str) {
        c3.k S0 = this.f17521e[i10].S0(kVar);
        if (S0.s0() == c3.n.VALUE_NULL) {
            return null;
        }
        d4.y yVar = new d4.y(kVar, gVar);
        yVar.s0();
        yVar.z0(str);
        yVar.V0(S0);
        yVar.V();
        c3.k S02 = yVar.S0(kVar);
        S02.s0();
        return this.f17518b[i10].b().k(S02, gVar);
    }

    public final void b(c3.k kVar, k3.g gVar, Object obj, int i10, String str) {
        if (str == null) {
            gVar.y0(this.f17517a, "Internal error in external Type Id handling: `null` type id passed", new Object[0]);
        }
        c3.k S0 = this.f17521e[i10].S0(kVar);
        if (S0.s0() == c3.n.VALUE_NULL) {
            this.f17518b[i10].b().C(obj, null);
            return;
        }
        d4.y yVar = new d4.y(kVar, gVar);
        yVar.s0();
        yVar.z0(str);
        yVar.V0(S0);
        yVar.V();
        c3.k S02 = yVar.S0(kVar);
        S02.s0();
        this.f17518b[i10].b().l(S02, gVar, obj);
    }

    public final boolean c(c3.k kVar, k3.g gVar, String str, Object obj, String str2, int i10) {
        boolean z10 = false;
        if (!this.f17518b[i10].f(str)) {
            return false;
        }
        if (obj != null && this.f17521e[i10] != null) {
            z10 = true;
        }
        if (z10) {
            b(kVar, gVar, obj, i10, str2);
            this.f17521e[i10] = null;
        } else {
            this.f17520d[i10] = str2;
        }
        return true;
    }

    public Object e(c3.k kVar, k3.g gVar, Object obj) {
        int length = this.f17518b.length;
        for (int i10 = 0; i10 < length; i10++) {
            String str = this.f17520d[i10];
            b bVar = this.f17518b[i10];
            if (str == null) {
                d4.y yVar = this.f17521e[i10];
                if (yVar != null) {
                    if (yVar.X0().e()) {
                        c3.k S0 = yVar.S0(kVar);
                        S0.s0();
                        n3.t b10 = bVar.b();
                        Object b11 = w3.e.b(S0, gVar, b10.getType());
                        if (b11 != null) {
                            b10.C(obj, b11);
                        }
                    }
                    if (bVar.e()) {
                        str = bVar.a();
                        if (str == null) {
                            gVar.B0(this.f17517a, bVar.b().getName(), "Invalid default type id for property '%s': `null` returned by TypeIdResolver", bVar.d());
                        }
                    } else {
                        gVar.B0(this.f17517a, bVar.b().getName(), "Missing external type id property '%s' (and no 'defaultImpl' specified)", bVar.d());
                    }
                }
            } else if (this.f17521e[i10] == null) {
                n3.t b12 = bVar.b();
                if (b12.f() || gVar.n0(k3.h.FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY)) {
                    gVar.A0(obj.getClass(), b12.getName(), "Missing property '%s' for external type id '%s'", b12.getName(), bVar.d());
                }
                return obj;
            }
            b(kVar, gVar, obj, i10, str);
        }
        return obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x005d, code lost:
    
        if (r13.n0(k3.h.FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY) != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(c3.k r12, k3.g r13, o3.y r14, o3.v r15) {
        /*
            r11 = this;
            o3.g$b[] r0 = r11.f17518b
            int r0 = r0.length
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r2 = 0
            r3 = 0
        L7:
            if (r3 >= r0) goto Lcf
            java.lang.String[] r4 = r11.f17520d
            r4 = r4[r3]
            o3.g$b[] r5 = r11.f17518b
            r5 = r5[r3]
            r6 = 1
            if (r4 != 0) goto L47
            d4.y[] r7 = r11.f17521e
            r7 = r7[r3]
            if (r7 == 0) goto Lcb
            c3.n r7 = r7.X0()
            c3.n r8 = c3.n.VALUE_NULL
            if (r7 != r8) goto L24
            goto Lcb
        L24:
            boolean r7 = r5.e()
            if (r7 != 0) goto L42
            k3.j r7 = r11.f17517a
            n3.t r8 = r5.b()
            java.lang.String r8 = r8.getName()
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.String r9 = r5.d()
            r6[r2] = r9
            java.lang.String r9 = "Missing external type id property '%s'"
            r13.B0(r7, r8, r9, r6)
            goto L7d
        L42:
            java.lang.String r4 = r5.a()
            goto L7d
        L47:
            d4.y[] r7 = r11.f17521e
            r7 = r7[r3]
            if (r7 != 0) goto L7d
            n3.t r7 = r5.b()
            boolean r8 = r7.f()
            if (r8 != 0) goto L5f
            k3.h r8 = k3.h.FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY
            boolean r8 = r13.n0(r8)
            if (r8 == 0) goto L7d
        L5f:
            k3.j r8 = r11.f17517a
            java.lang.String r9 = r7.getName()
            r10 = 2
            java.lang.Object[] r10 = new java.lang.Object[r10]
            java.lang.String r7 = r7.getName()
            r10[r2] = r7
            o3.g$b[] r7 = r11.f17518b
            r7 = r7[r3]
            java.lang.String r7 = r7.d()
            r10[r6] = r7
            java.lang.String r6 = "Missing property '%s' for external type id '%s'"
            r13.B0(r8, r9, r6, r10)
        L7d:
            d4.y[] r6 = r11.f17521e
            r6 = r6[r3]
            if (r6 == 0) goto L89
            java.lang.Object r6 = r11.a(r12, r13, r3, r4)
            r1[r3] = r6
        L89:
            n3.t r6 = r5.b()
            int r7 = r6.p()
            if (r7 < 0) goto Lcb
            r7 = r1[r3]
            r14.b(r6, r7)
            n3.t r5 = r5.c()
            if (r5 == 0) goto Lcb
            int r6 = r5.p()
            if (r6 < 0) goto Lcb
            k3.j r6 = r5.getType()
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            boolean r6 = r6.y(r7)
            if (r6 == 0) goto Lb1
            goto Lc8
        Lb1:
            d4.y r6 = new d4.y
            r6.<init>(r12, r13)
            r6.z0(r4)
            k3.k r4 = r5.u()
            c3.k r7 = r6.U0()
            java.lang.Object r4 = r4.deserialize(r7, r13)
            r6.close()
        Lc8:
            r14.b(r5, r4)
        Lcb:
            int r3 = r3 + 1
            goto L7
        Lcf:
            java.lang.Object r12 = r15.a(r13, r14)
        Ld3:
            if (r2 >= r0) goto Leb
            o3.g$b[] r13 = r11.f17518b
            r13 = r13[r2]
            n3.t r13 = r13.b()
            int r14 = r13.p()
            if (r14 >= 0) goto Le8
            r14 = r1[r2]
            r13.C(r12, r14)
        Le8:
            int r2 = r2 + 1
            goto Ld3
        Leb:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.g.f(c3.k, k3.g, o3.y, o3.v):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0094, code lost:
    
        if (r10.f17521e[r0] != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0096, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00aa, code lost:
    
        if (r10.f17520d[r0] != null) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean g(c3.k r11, k3.g r12, java.lang.String r13, java.lang.Object r14) {
        /*
            r10 = this;
            java.util.Map r0 = r10.f17519c
            java.lang.Object r0 = r0.get(r13)
            r1 = 0
            if (r0 != 0) goto La
            return r1
        La:
            boolean r2 = r0 instanceof java.util.List
            r3 = 1
            if (r2 == 0) goto L73
            java.util.List r0 = (java.util.List) r0
            java.util.Iterator r14 = r0.iterator()
            java.lang.Object r0 = r14.next()
            java.lang.Integer r0 = (java.lang.Integer) r0
            o3.g$b[] r1 = r10.f17518b
            int r2 = r0.intValue()
            r1 = r1[r2]
            boolean r13 = r1.f(r13)
            if (r13 == 0) goto L4d
            java.lang.String r12 = r11.Y()
            r11.D0()
            java.lang.String[] r11 = r10.f17520d
            int r13 = r0.intValue()
            r11[r13] = r12
        L38:
            boolean r11 = r14.hasNext()
            if (r11 == 0) goto L72
            java.lang.String[] r11 = r10.f17520d
            java.lang.Object r13 = r14.next()
            java.lang.Integer r13 = (java.lang.Integer) r13
            int r13 = r13.intValue()
            r11[r13] = r12
            goto L38
        L4d:
            d4.y r13 = new d4.y
            r13.<init>(r11, r12)
            r13.V0(r11)
            d4.y[] r11 = r10.f17521e
            int r12 = r0.intValue()
            r11[r12] = r13
        L5d:
            boolean r11 = r14.hasNext()
            if (r11 == 0) goto L72
            d4.y[] r11 = r10.f17521e
            java.lang.Object r12 = r14.next()
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
            r11[r12] = r13
            goto L5d
        L72:
            return r3
        L73:
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            o3.g$b[] r2 = r10.f17518b
            r2 = r2[r0]
            boolean r13 = r2.f(r13)
            if (r13 == 0) goto L98
            java.lang.String[] r13 = r10.f17520d
            java.lang.String r2 = r11.g0()
            r13[r0] = r2
            r11.D0()
            if (r14 == 0) goto Lad
            d4.y[] r13 = r10.f17521e
            r13 = r13[r0]
            if (r13 == 0) goto Lad
        L96:
            r1 = 1
            goto Lad
        L98:
            d4.y r13 = new d4.y
            r13.<init>(r11, r12)
            r13.V0(r11)
            d4.y[] r2 = r10.f17521e
            r2[r0] = r13
            if (r14 == 0) goto Lad
            java.lang.String[] r13 = r10.f17520d
            r13 = r13[r0]
            if (r13 == 0) goto Lad
            goto L96
        Lad:
            if (r1 == 0) goto Lc2
            java.lang.String[] r13 = r10.f17520d
            r9 = r13[r0]
            r1 = 0
            r13[r0] = r1
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r14
            r8 = r0
            r4.b(r5, r6, r7, r8, r9)
            d4.y[] r11 = r10.f17521e
            r11[r0] = r1
        Lc2:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.g.g(c3.k, k3.g, java.lang.String, java.lang.Object):boolean");
    }

    public boolean h(c3.k kVar, k3.g gVar, String str, Object obj) {
        Object obj2 = this.f17519c.get(str);
        boolean z10 = false;
        if (obj2 == null) {
            return false;
        }
        String Y = kVar.Y();
        if (!(obj2 instanceof List)) {
            return c(kVar, gVar, str, obj, Y, ((Integer) obj2).intValue());
        }
        Iterator it = ((List) obj2).iterator();
        while (it.hasNext()) {
            if (c(kVar, gVar, str, obj, Y, ((Integer) it.next()).intValue())) {
                z10 = true;
            }
        }
        return z10;
    }

    public g i() {
        return new g(this);
    }

    public g(g gVar) {
        this.f17517a = gVar.f17517a;
        b[] bVarArr = gVar.f17518b;
        this.f17518b = bVarArr;
        this.f17519c = gVar.f17519c;
        int length = bVarArr.length;
        this.f17520d = new String[length];
        this.f17521e = new d4.y[length];
    }
}
