package m;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import m.e;
import m.f;

/* loaded from: classes.dex */
public abstract class a {
    public static void a(g gVar) {
        if ((gVar.R0() & 32) != 32) {
            j(gVar);
            return;
        }
        gVar.O0 = true;
        gVar.I0 = false;
        gVar.J0 = false;
        gVar.K0 = false;
        ArrayList<f> arrayList = gVar.f16613v0;
        List<h> list = gVar.H0;
        f.b s10 = gVar.s();
        f.b bVar = f.b.WRAP_CONTENT;
        boolean z10 = s10 == bVar;
        boolean z11 = gVar.B() == bVar;
        boolean z12 = z10 || z11;
        list.clear();
        for (f fVar : arrayList) {
            fVar.f16544r = null;
            fVar.f16531k0 = false;
            fVar.S();
        }
        for (f fVar2 : arrayList) {
            if (fVar2.f16544r == null && !b(fVar2, list, z12)) {
                j(gVar);
                gVar.O0 = false;
                return;
            }
        }
        int i10 = 0;
        int i11 = 0;
        for (h hVar : list) {
            i10 = Math.max(i10, c(hVar, 0));
            i11 = Math.max(i11, c(hVar, 1));
        }
        if (z10) {
            gVar.g0(f.b.FIXED);
            gVar.y0(i10);
            gVar.I0 = true;
            gVar.J0 = true;
            gVar.L0 = i10;
        }
        if (z11) {
            gVar.u0(f.b.FIXED);
            gVar.b0(i11);
            gVar.I0 = true;
            gVar.K0 = true;
            gVar.M0 = i11;
        }
        i(list, 0, gVar.D());
        i(list, 1, gVar.r());
    }

    public static boolean b(f fVar, List list, boolean z10) {
        h hVar = new h(new ArrayList(), true);
        list.add(hVar);
        return k(fVar, hVar, list, z10);
    }

    public static int c(h hVar, int i10) {
        int i11 = i10 * 2;
        List b10 = hVar.b(i10);
        int size = b10.size();
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            f fVar = (f) b10.get(i13);
            e[] eVarArr = fVar.C;
            e eVar = eVarArr[i11 + 1].f16484d;
            i12 = Math.max(i12, d(fVar, i10, eVar == null || !(eVarArr[i11].f16484d == null || eVar == null), 0));
        }
        hVar.f16571e[i10] = i12;
        return i12;
    }

    public static int d(f fVar, int i10, boolean z10, int i11) {
        int r10;
        int j10;
        int i12;
        int i13;
        int i14;
        int D;
        int i15;
        int i16;
        int i17;
        int i18 = 0;
        if (!fVar.f16527i0) {
            return 0;
        }
        boolean z11 = fVar.f16554y.f16484d != null && i10 == 1;
        if (z10) {
            r10 = fVar.j();
            j10 = fVar.r() - fVar.j();
            i13 = i10 * 2;
            i12 = i13 + 1;
        } else {
            r10 = fVar.r() - fVar.j();
            j10 = fVar.j();
            i12 = i10 * 2;
            i13 = i12 + 1;
        }
        e[] eVarArr = fVar.C;
        if (eVarArr[i12].f16484d == null || eVarArr[i13].f16484d != null) {
            i14 = 1;
        } else {
            i14 = -1;
            int i19 = i12;
            i12 = i13;
            i13 = i19;
        }
        int i20 = z11 ? i11 - r10 : i11;
        int d10 = (eVarArr[i13].d() * i14) + e(fVar, i10);
        int i21 = i20 + d10;
        int D2 = (i10 == 0 ? fVar.D() : fVar.r()) * i14;
        Iterator it = fVar.C[i13].f().f16601a.iterator();
        while (it.hasNext()) {
            i18 = Math.max(i18, d(((m) ((o) it.next())).f16587c.f16482b, i10, z10, i21));
        }
        int i22 = 0;
        for (Iterator it2 = fVar.C[i12].f().f16601a.iterator(); it2.hasNext(); it2 = it2) {
            i22 = Math.max(i22, d(((m) ((o) it2.next())).f16587c.f16482b, i10, z10, D2 + i21));
        }
        if (z11) {
            i18 -= r10;
            D = i22 + j10;
        } else {
            D = i22 + ((i10 == 0 ? fVar.D() : fVar.r()) * i14);
        }
        int i23 = 1;
        if (i10 == 1) {
            Iterator it3 = fVar.f16554y.f().f16601a.iterator();
            int i24 = 0;
            while (it3.hasNext()) {
                Iterator it4 = it3;
                m mVar = (m) ((o) it3.next());
                if (i14 == i23) {
                    i24 = Math.max(i24, d(mVar.f16587c.f16482b, i10, z10, r10 + i21));
                    i17 = i12;
                } else {
                    i17 = i12;
                    i24 = Math.max(i24, d(mVar.f16587c.f16482b, i10, z10, (j10 * i14) + i21));
                }
                it3 = it4;
                i12 = i17;
                i23 = 1;
            }
            i15 = i12;
            int i25 = i24;
            i16 = (fVar.f16554y.f().f16601a.size() <= 0 || z11) ? i25 : i14 == 1 ? i25 + r10 : i25 - j10;
        } else {
            i15 = i12;
            i16 = 0;
        }
        int max = d10 + Math.max(i18, Math.max(D, i16));
        int i26 = D2 + i21;
        if (i14 == -1) {
            i26 = i21;
            i21 = i26;
        }
        if (z10) {
            k.e(fVar, i10, i21);
            fVar.Z(i21, i26, i10);
        } else {
            fVar.f16544r.a(fVar, i10);
            fVar.q0(i21, i10);
        }
        if (fVar.o(i10) == f.b.MATCH_CONSTRAINT && fVar.I != 0.0f) {
            fVar.f16544r.a(fVar, i10);
        }
        e[] eVarArr2 = fVar.C;
        if (eVarArr2[i13].f16484d != null && eVarArr2[i15].f16484d != null) {
            f u10 = fVar.u();
            e[] eVarArr3 = fVar.C;
            if (eVarArr3[i13].f16484d.f16482b == u10 && eVarArr3[i15].f16484d.f16482b == u10) {
                fVar.f16544r.a(fVar, i10);
            }
        }
        return max;
    }

    public static int e(f fVar, int i10) {
        e eVar;
        int i11 = i10 * 2;
        e[] eVarArr = fVar.C;
        e eVar2 = eVarArr[i11];
        e eVar3 = eVarArr[i11 + 1];
        e eVar4 = eVar2.f16484d;
        if (eVar4 == null) {
            return 0;
        }
        f fVar2 = eVar4.f16482b;
        f fVar3 = fVar.F;
        if (fVar2 != fVar3 || (eVar = eVar3.f16484d) == null || eVar.f16482b != fVar3) {
            return 0;
        }
        return (int) ((((fVar3.t(i10) - eVar2.d()) - eVar3.d()) - fVar.t(i10)) * (i10 == 0 ? fVar.Z : fVar.f16511a0));
    }

    public static void f(g gVar, f fVar, h hVar) {
        hVar.f16570d = false;
        gVar.O0 = false;
        fVar.f16527i0 = false;
    }

    public static int g(f fVar) {
        f.b s10 = fVar.s();
        f.b bVar = f.b.MATCH_CONSTRAINT;
        if (s10 == bVar) {
            int r10 = (int) (fVar.J == 0 ? fVar.r() * fVar.I : fVar.r() / fVar.I);
            fVar.y0(r10);
            return r10;
        }
        if (fVar.B() != bVar) {
            return -1;
        }
        int D = (int) (fVar.J == 1 ? fVar.D() * fVar.I : fVar.D() / fVar.I);
        fVar.b0(D);
        return D;
    }

    public static void h(e eVar) {
        m f10 = eVar.f();
        e eVar2 = eVar.f16484d;
        if (eVar2 == null || eVar2.f16484d == eVar) {
            return;
        }
        eVar2.f().a(f10);
    }

    public static void i(List list, int i10, int i11) {
        int size = list.size();
        for (int i12 = 0; i12 < size; i12++) {
            for (f fVar : ((h) list.get(i12)).c(i10)) {
                if (fVar.f16527i0) {
                    l(fVar, i10, i11);
                }
            }
        }
    }

    public static void j(g gVar) {
        gVar.H0.clear();
        gVar.H0.add(0, new h(gVar.f16613v0));
    }

    /* JADX WARN: Code restructure failed: missing block: B:135:0x0159, code lost:
    
        if (r4.f16482b == r5) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0110, code lost:
    
        if (r4.f16482b == r5) goto L88;
     */
    /* JADX WARN: Removed duplicated region for block: B:131:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x019a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean k(f fVar, h hVar, List list, boolean z10) {
        e eVar;
        e eVar2;
        e eVar3;
        int length;
        int i10;
        if (fVar == null) {
            return true;
        }
        fVar.f16529j0 = false;
        g gVar = (g) fVar.u();
        h hVar2 = fVar.f16544r;
        if (hVar2 != null) {
            if (hVar2 != hVar) {
                hVar.f16567a.addAll(hVar2.f16567a);
                hVar.f16572f.addAll(fVar.f16544r.f16572f);
                hVar.f16573g.addAll(fVar.f16544r.f16573g);
                h hVar3 = fVar.f16544r;
                if (!hVar3.f16570d) {
                    hVar.f16570d = false;
                }
                list.remove(hVar3);
                Iterator it = fVar.f16544r.f16567a.iterator();
                while (it.hasNext()) {
                    ((f) it.next()).f16544r = hVar;
                }
            }
            return true;
        }
        fVar.f16527i0 = true;
        hVar.f16567a.add(fVar);
        fVar.f16544r = hVar;
        if (fVar.f16550u.f16484d == null && fVar.f16552w.f16484d == null && fVar.f16551v.f16484d == null && fVar.f16553x.f16484d == null && fVar.f16554y.f16484d == null && fVar.B.f16484d == null) {
            f(gVar, fVar, hVar);
            if (z10) {
                return false;
            }
        }
        if (fVar.f16551v.f16484d != null && fVar.f16553x.f16484d != null) {
            gVar.B();
            f.b bVar = f.b.FIXED;
            if (z10) {
                f(gVar, fVar, hVar);
                return false;
            }
            if (fVar.f16551v.f16484d.f16482b != fVar.u() || fVar.f16553x.f16484d.f16482b != fVar.u()) {
                f(gVar, fVar, hVar);
            }
        }
        if (fVar.f16550u.f16484d != null && fVar.f16552w.f16484d != null) {
            gVar.s();
            f.b bVar2 = f.b.FIXED;
            if (z10) {
                f(gVar, fVar, hVar);
                return false;
            }
            if (fVar.f16550u.f16484d.f16482b != fVar.u() || fVar.f16552w.f16484d.f16482b != fVar.u()) {
                f(gVar, fVar, hVar);
            }
        }
        f.b s10 = fVar.s();
        f.b bVar3 = f.b.MATCH_CONSTRAINT;
        if (((s10 == bVar3) ^ (fVar.B() == bVar3)) && fVar.I != 0.0f) {
            g(fVar);
        } else if (fVar.s() == bVar3 || fVar.B() == bVar3) {
            f(gVar, fVar, hVar);
            if (z10) {
                return false;
            }
        }
        e eVar4 = fVar.f16550u.f16484d;
        if ((eVar4 != null || fVar.f16552w.f16484d != null) && ((eVar4 == null || eVar4.f16482b != fVar.F || fVar.f16552w.f16484d != null) && ((eVar = fVar.f16552w.f16484d) == null || eVar.f16482b != fVar.F || eVar4 != null))) {
            if (eVar4 != null) {
                f fVar2 = eVar4.f16482b;
                f fVar3 = fVar.F;
                if (fVar2 == fVar3) {
                    if (eVar != null) {
                    }
                }
            }
            eVar2 = fVar.f16551v.f16484d;
            if ((eVar2 == null || fVar.f16553x.f16484d != null) && ((eVar2 == null || eVar2.f16482b != fVar.F || fVar.f16553x.f16484d != null) && ((eVar3 = fVar.f16553x.f16484d) == null || eVar3.f16482b != fVar.F || eVar2 != null))) {
                if (eVar2 != null) {
                    f fVar4 = eVar2.f16482b;
                    f fVar5 = fVar.F;
                    if (fVar4 == fVar5) {
                        if (eVar3 != null) {
                        }
                    }
                }
                if (fVar instanceof j) {
                    f(gVar, fVar, hVar);
                    if (z10) {
                        return false;
                    }
                    j jVar = (j) fVar;
                    for (int i11 = 0; i11 < jVar.f16585w0; i11++) {
                        if (!k(jVar.f16584v0[i11], hVar, list, z10)) {
                            return false;
                        }
                    }
                }
                length = fVar.C.length;
                for (i10 = 0; i10 < length; i10++) {
                    e eVar5 = fVar.C[i10];
                    e eVar6 = eVar5.f16484d;
                    if (eVar6 != null && eVar6.f16482b != fVar.u()) {
                        if (eVar5.f16483c == e.d.CENTER) {
                            f(gVar, fVar, hVar);
                            if (z10) {
                                return false;
                            }
                        } else {
                            h(eVar5);
                        }
                        if (!k(eVar5.f16484d.f16482b, hVar, list, z10)) {
                            return false;
                        }
                    }
                }
                return true;
            }
            if (fVar.B.f16484d == null && fVar.f16554y.f16484d == null && !(fVar instanceof i) && !(fVar instanceof j)) {
                hVar.f16573g.add(fVar);
            }
            if (fVar instanceof j) {
            }
            length = fVar.C.length;
            while (i10 < length) {
            }
            return true;
        }
        if (fVar.B.f16484d == null && !(fVar instanceof i) && !(fVar instanceof j)) {
            hVar.f16572f.add(fVar);
        }
        eVar2 = fVar.f16551v.f16484d;
        if (eVar2 == null) {
        }
        if (eVar2 != null) {
        }
        if (fVar instanceof j) {
        }
        length = fVar.C.length;
        while (i10 < length) {
        }
        return true;
    }

    public static void l(f fVar, int i10, int i11) {
        int i12 = i10 * 2;
        e[] eVarArr = fVar.C;
        e eVar = eVarArr[i12];
        e eVar2 = eVarArr[i12 + 1];
        if ((eVar.f16484d == null || eVar2.f16484d == null) ? false : true) {
            k.e(fVar, i10, e(fVar, i10) + eVar.d());
            return;
        }
        if (fVar.I == 0.0f || fVar.o(i10) != f.b.MATCH_CONSTRAINT) {
            int v10 = i11 - fVar.v(i10);
            int t10 = v10 - fVar.t(i10);
            fVar.Z(t10, v10, i10);
            k.e(fVar, i10, t10);
            return;
        }
        int g10 = g(fVar);
        int i13 = (int) fVar.C[i12].f().f16592h;
        eVar2.f().f16591g = eVar.f();
        eVar2.f().f16592h = g10;
        eVar2.f().f16602b = 1;
        fVar.Z(i13, i13 + g10, i10);
    }
}
