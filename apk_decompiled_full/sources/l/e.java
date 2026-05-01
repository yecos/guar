package l;

import java.util.Arrays;
import java.util.HashMap;
import l.i;
import m.e;

/* loaded from: classes.dex */
public class e {

    /* renamed from: q, reason: collision with root package name */
    public static int f15852q = 1000;

    /* renamed from: c, reason: collision with root package name */
    public a f15855c;

    /* renamed from: f, reason: collision with root package name */
    public b[] f15858f;

    /* renamed from: l, reason: collision with root package name */
    public final c f15864l;

    /* renamed from: p, reason: collision with root package name */
    public final a f15868p;

    /* renamed from: a, reason: collision with root package name */
    public int f15853a = 0;

    /* renamed from: b, reason: collision with root package name */
    public HashMap f15854b = null;

    /* renamed from: d, reason: collision with root package name */
    public int f15856d = 32;

    /* renamed from: e, reason: collision with root package name */
    public int f15857e = 32;

    /* renamed from: g, reason: collision with root package name */
    public boolean f15859g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean[] f15860h = new boolean[32];

    /* renamed from: i, reason: collision with root package name */
    public int f15861i = 1;

    /* renamed from: j, reason: collision with root package name */
    public int f15862j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f15863k = 32;

    /* renamed from: m, reason: collision with root package name */
    public i[] f15865m = new i[f15852q];

    /* renamed from: n, reason: collision with root package name */
    public int f15866n = 0;

    /* renamed from: o, reason: collision with root package name */
    public b[] f15867o = new b[32];

    public interface a {
        i a(e eVar, boolean[] zArr);

        void b(a aVar);

        void c(i iVar);

        void clear();

        i getKey();
    }

    public e() {
        this.f15858f = null;
        this.f15858f = new b[32];
        D();
        c cVar = new c();
        this.f15864l = cVar;
        this.f15855c = new d(cVar);
        this.f15868p = new b(cVar);
    }

    public static b t(e eVar, i iVar, i iVar2, i iVar3, float f10, boolean z10) {
        b s10 = eVar.s();
        if (z10) {
            eVar.g(s10);
        }
        return s10.i(iVar, iVar2, iVar3, f10);
    }

    public static f x() {
        return null;
    }

    public void A() {
        if (!this.f15859g) {
            B(this.f15855c);
            return;
        }
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= this.f15862j) {
                z10 = true;
                break;
            } else if (!this.f15858f[i10].f15848e) {
                break;
            } else {
                i10++;
            }
        }
        if (z10) {
            o();
        } else {
            B(this.f15855c);
        }
    }

    public void B(a aVar) {
        F((b) aVar);
        v(aVar);
        C(aVar, false);
        o();
    }

    public final int C(a aVar, boolean z10) {
        for (int i10 = 0; i10 < this.f15861i; i10++) {
            this.f15860h[i10] = false;
        }
        boolean z11 = false;
        int i11 = 0;
        while (!z11) {
            i11++;
            if (i11 >= this.f15861i * 2) {
                return i11;
            }
            if (aVar.getKey() != null) {
                this.f15860h[aVar.getKey().f15873b] = true;
            }
            i a10 = aVar.a(this, this.f15860h);
            if (a10 != null) {
                boolean[] zArr = this.f15860h;
                int i12 = a10.f15873b;
                if (zArr[i12]) {
                    return i11;
                }
                zArr[i12] = true;
            }
            if (a10 != null) {
                float f10 = Float.MAX_VALUE;
                int i13 = -1;
                for (int i14 = 0; i14 < this.f15862j; i14++) {
                    b bVar = this.f15858f[i14];
                    if (bVar.f15844a.f15878g != i.a.UNRESTRICTED && !bVar.f15848e && bVar.s(a10)) {
                        float f11 = bVar.f15847d.f(a10);
                        if (f11 < 0.0f) {
                            float f12 = (-bVar.f15845b) / f11;
                            if (f12 < f10) {
                                i13 = i14;
                                f10 = f12;
                            }
                        }
                    }
                }
                if (i13 > -1) {
                    b bVar2 = this.f15858f[i13];
                    bVar2.f15844a.f15874c = -1;
                    bVar2.v(a10);
                    i iVar = bVar2.f15844a;
                    iVar.f15874c = i13;
                    iVar.f(bVar2);
                }
            }
            z11 = true;
        }
        return i11;
    }

    public final void D() {
        int i10 = 0;
        while (true) {
            b[] bVarArr = this.f15858f;
            if (i10 >= bVarArr.length) {
                return;
            }
            b bVar = bVarArr[i10];
            if (bVar != null) {
                this.f15864l.f15849a.release(bVar);
            }
            this.f15858f[i10] = null;
            i10++;
        }
    }

    public void E() {
        c cVar;
        int i10 = 0;
        while (true) {
            cVar = this.f15864l;
            i[] iVarArr = cVar.f15851c;
            if (i10 >= iVarArr.length) {
                break;
            }
            i iVar = iVarArr[i10];
            if (iVar != null) {
                iVar.d();
            }
            i10++;
        }
        cVar.f15850b.a(this.f15865m, this.f15866n);
        this.f15866n = 0;
        Arrays.fill(this.f15864l.f15851c, (Object) null);
        HashMap hashMap = this.f15854b;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f15853a = 0;
        this.f15855c.clear();
        this.f15861i = 1;
        for (int i11 = 0; i11 < this.f15862j; i11++) {
            this.f15858f[i11].f15846c = false;
        }
        D();
        this.f15862j = 0;
    }

    public final void F(b bVar) {
        if (this.f15862j > 0) {
            bVar.f15847d.o(bVar, this.f15858f);
            if (bVar.f15847d.f15833a == 0) {
                bVar.f15848e = true;
            }
        }
    }

    public final i a(i.a aVar, String str) {
        i iVar = (i) this.f15864l.f15850b.acquire();
        if (iVar == null) {
            iVar = new i(aVar, str);
            iVar.e(aVar, str);
        } else {
            iVar.d();
            iVar.e(aVar, str);
        }
        int i10 = this.f15866n;
        int i11 = f15852q;
        if (i10 >= i11) {
            int i12 = i11 * 2;
            f15852q = i12;
            this.f15865m = (i[]) Arrays.copyOf(this.f15865m, i12);
        }
        i[] iVarArr = this.f15865m;
        int i13 = this.f15866n;
        this.f15866n = i13 + 1;
        iVarArr[i13] = iVar;
        return iVar;
    }

    public void b(m.f fVar, m.f fVar2, float f10, int i10) {
        e.d dVar = e.d.LEFT;
        i r10 = r(fVar.h(dVar));
        e.d dVar2 = e.d.TOP;
        i r11 = r(fVar.h(dVar2));
        e.d dVar3 = e.d.RIGHT;
        i r12 = r(fVar.h(dVar3));
        e.d dVar4 = e.d.BOTTOM;
        i r13 = r(fVar.h(dVar4));
        i r14 = r(fVar2.h(dVar));
        i r15 = r(fVar2.h(dVar2));
        i r16 = r(fVar2.h(dVar3));
        i r17 = r(fVar2.h(dVar4));
        b s10 = s();
        double d10 = f10;
        double sin = Math.sin(d10);
        double d11 = i10;
        Double.isNaN(d11);
        s10.p(r11, r13, r15, r17, (float) (sin * d11));
        d(s10);
        b s11 = s();
        double cos = Math.cos(d10);
        Double.isNaN(d11);
        s11.p(r10, r12, r14, r16, (float) (cos * d11));
        d(s11);
    }

    public void c(i iVar, i iVar2, int i10, float f10, i iVar3, i iVar4, int i11, int i12) {
        b s10 = s();
        s10.g(iVar, iVar2, i10, f10, iVar3, iVar4, i11);
        if (i12 != 6) {
            s10.d(this, i12);
        }
        d(s10);
    }

    public void d(b bVar) {
        i u10;
        if (bVar == null) {
            return;
        }
        boolean z10 = true;
        if (this.f15862j + 1 >= this.f15863k || this.f15861i + 1 >= this.f15857e) {
            z();
        }
        boolean z11 = false;
        if (!bVar.f15848e) {
            F(bVar);
            if (bVar.t()) {
                return;
            }
            bVar.q();
            if (bVar.f(this)) {
                i q10 = q();
                bVar.f15844a = q10;
                m(bVar);
                this.f15868p.b(bVar);
                C(this.f15868p, true);
                if (q10.f15874c == -1) {
                    if (bVar.f15844a == q10 && (u10 = bVar.u(q10)) != null) {
                        bVar.v(u10);
                    }
                    if (!bVar.f15848e) {
                        bVar.f15844a.f(bVar);
                    }
                    this.f15862j--;
                }
            } else {
                z10 = false;
            }
            if (!bVar.r()) {
                return;
            } else {
                z11 = z10;
            }
        }
        if (z11) {
            return;
        }
        m(bVar);
    }

    public b e(i iVar, i iVar2, int i10, int i11) {
        b s10 = s();
        s10.m(iVar, iVar2, i10);
        if (i11 != 6) {
            s10.d(this, i11);
        }
        d(s10);
        return s10;
    }

    public void f(i iVar, int i10) {
        int i11 = iVar.f15874c;
        if (i11 == -1) {
            b s10 = s();
            s10.h(iVar, i10);
            d(s10);
            return;
        }
        b bVar = this.f15858f[i11];
        if (bVar.f15848e) {
            bVar.f15845b = i10;
            return;
        }
        if (bVar.f15847d.f15833a == 0) {
            bVar.f15848e = true;
            bVar.f15845b = i10;
        } else {
            b s11 = s();
            s11.l(iVar, i10);
            d(s11);
        }
    }

    public final void g(b bVar) {
        bVar.d(this, 0);
    }

    public void h(i iVar, i iVar2, boolean z10) {
        b s10 = s();
        i u10 = u();
        u10.f15875d = 0;
        s10.n(iVar, iVar2, u10, 0);
        if (z10) {
            n(s10, (int) (s10.f15847d.f(u10) * (-1.0f)), 1);
        }
        d(s10);
    }

    public void i(i iVar, i iVar2, int i10, int i11) {
        b s10 = s();
        i u10 = u();
        u10.f15875d = 0;
        s10.n(iVar, iVar2, u10, i10);
        if (i11 != 6) {
            n(s10, (int) (s10.f15847d.f(u10) * (-1.0f)), i11);
        }
        d(s10);
    }

    public void j(i iVar, i iVar2, boolean z10) {
        b s10 = s();
        i u10 = u();
        u10.f15875d = 0;
        s10.o(iVar, iVar2, u10, 0);
        if (z10) {
            n(s10, (int) (s10.f15847d.f(u10) * (-1.0f)), 1);
        }
        d(s10);
    }

    public void k(i iVar, i iVar2, int i10, int i11) {
        b s10 = s();
        i u10 = u();
        u10.f15875d = 0;
        s10.o(iVar, iVar2, u10, i10);
        if (i11 != 6) {
            n(s10, (int) (s10.f15847d.f(u10) * (-1.0f)), i11);
        }
        d(s10);
    }

    public void l(i iVar, i iVar2, i iVar3, i iVar4, float f10, int i10) {
        b s10 = s();
        s10.j(iVar, iVar2, iVar3, iVar4, f10);
        if (i10 != 6) {
            s10.d(this, i10);
        }
        d(s10);
    }

    public final void m(b bVar) {
        b bVar2 = this.f15858f[this.f15862j];
        if (bVar2 != null) {
            this.f15864l.f15849a.release(bVar2);
        }
        b[] bVarArr = this.f15858f;
        int i10 = this.f15862j;
        bVarArr[i10] = bVar;
        i iVar = bVar.f15844a;
        iVar.f15874c = i10;
        this.f15862j = i10 + 1;
        iVar.f(bVar);
    }

    public void n(b bVar, int i10, int i11) {
        bVar.e(p(i11, null), i10);
    }

    public final void o() {
        for (int i10 = 0; i10 < this.f15862j; i10++) {
            b bVar = this.f15858f[i10];
            bVar.f15844a.f15876e = bVar.f15845b;
        }
    }

    public i p(int i10, String str) {
        if (this.f15861i + 1 >= this.f15857e) {
            z();
        }
        i a10 = a(i.a.ERROR, str);
        int i11 = this.f15853a + 1;
        this.f15853a = i11;
        this.f15861i++;
        a10.f15873b = i11;
        a10.f15875d = i10;
        this.f15864l.f15851c[i11] = a10;
        this.f15855c.c(a10);
        return a10;
    }

    public i q() {
        if (this.f15861i + 1 >= this.f15857e) {
            z();
        }
        i a10 = a(i.a.SLACK, null);
        int i10 = this.f15853a + 1;
        this.f15853a = i10;
        this.f15861i++;
        a10.f15873b = i10;
        this.f15864l.f15851c[i10] = a10;
        return a10;
    }

    public i r(Object obj) {
        i iVar = null;
        if (obj == null) {
            return null;
        }
        if (this.f15861i + 1 >= this.f15857e) {
            z();
        }
        if (obj instanceof m.e) {
            m.e eVar = (m.e) obj;
            iVar = eVar.g();
            if (iVar == null) {
                eVar.n(this.f15864l);
                iVar = eVar.g();
            }
            int i10 = iVar.f15873b;
            if (i10 == -1 || i10 > this.f15853a || this.f15864l.f15851c[i10] == null) {
                if (i10 != -1) {
                    iVar.d();
                }
                int i11 = this.f15853a + 1;
                this.f15853a = i11;
                this.f15861i++;
                iVar.f15873b = i11;
                iVar.f15878g = i.a.UNRESTRICTED;
                this.f15864l.f15851c[i11] = iVar;
            }
        }
        return iVar;
    }

    public b s() {
        b bVar = (b) this.f15864l.f15849a.acquire();
        if (bVar == null) {
            bVar = new b(this.f15864l);
        } else {
            bVar.w();
        }
        i.b();
        return bVar;
    }

    public i u() {
        if (this.f15861i + 1 >= this.f15857e) {
            z();
        }
        i a10 = a(i.a.SLACK, null);
        int i10 = this.f15853a + 1;
        this.f15853a = i10;
        this.f15861i++;
        a10.f15873b = i10;
        this.f15864l.f15851c[i10] = a10;
        return a10;
    }

    public final int v(a aVar) {
        float f10;
        boolean z10;
        int i10 = 0;
        while (true) {
            f10 = 0.0f;
            if (i10 >= this.f15862j) {
                z10 = false;
                break;
            }
            b bVar = this.f15858f[i10];
            if (bVar.f15844a.f15878g != i.a.UNRESTRICTED && bVar.f15845b < 0.0f) {
                z10 = true;
                break;
            }
            i10++;
        }
        if (!z10) {
            return 0;
        }
        boolean z11 = false;
        int i11 = 0;
        while (!z11) {
            i11++;
            float f11 = Float.MAX_VALUE;
            int i12 = 0;
            int i13 = -1;
            int i14 = -1;
            int i15 = 0;
            while (i12 < this.f15862j) {
                b bVar2 = this.f15858f[i12];
                if (bVar2.f15844a.f15878g != i.a.UNRESTRICTED && !bVar2.f15848e && bVar2.f15845b < f10) {
                    int i16 = 1;
                    while (i16 < this.f15861i) {
                        i iVar = this.f15864l.f15851c[i16];
                        float f12 = bVar2.f15847d.f(iVar);
                        if (f12 > f10) {
                            for (int i17 = 0; i17 < 7; i17++) {
                                float f13 = iVar.f15877f[i17] / f12;
                                if ((f13 < f11 && i17 == i15) || i17 > i15) {
                                    i15 = i17;
                                    f11 = f13;
                                    i13 = i12;
                                    i14 = i16;
                                }
                            }
                        }
                        i16++;
                        f10 = 0.0f;
                    }
                }
                i12++;
                f10 = 0.0f;
            }
            if (i13 != -1) {
                b bVar3 = this.f15858f[i13];
                bVar3.f15844a.f15874c = -1;
                bVar3.v(this.f15864l.f15851c[i14]);
                i iVar2 = bVar3.f15844a;
                iVar2.f15874c = i13;
                iVar2.f(bVar3);
            } else {
                z11 = true;
            }
            if (i11 > this.f15861i / 2) {
                z11 = true;
            }
            f10 = 0.0f;
        }
        return i11;
    }

    public c w() {
        return this.f15864l;
    }

    public int y(Object obj) {
        i g10 = ((m.e) obj).g();
        if (g10 != null) {
            return (int) (g10.f15876e + 0.5f);
        }
        return 0;
    }

    public final void z() {
        int i10 = this.f15856d * 2;
        this.f15856d = i10;
        this.f15858f = (b[]) Arrays.copyOf(this.f15858f, i10);
        c cVar = this.f15864l;
        cVar.f15851c = (i[]) Arrays.copyOf(cVar.f15851c, this.f15856d);
        int i11 = this.f15856d;
        this.f15860h = new boolean[i11];
        this.f15857e = i11;
        this.f15863k = i11;
    }
}
