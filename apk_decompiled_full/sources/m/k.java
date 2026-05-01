package m;

import m.f;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static boolean[] f16586a = new boolean[3];

    public static void a(int i10, f fVar) {
        fVar.H0();
        m f10 = fVar.f16550u.f();
        m f11 = fVar.f16551v.f();
        m f12 = fVar.f16552w.f();
        m f13 = fVar.f16553x.f();
        boolean z10 = (i10 & 8) == 8;
        f.b bVar = fVar.E[0];
        f.b bVar2 = f.b.MATCH_CONSTRAINT;
        boolean z11 = bVar == bVar2 && d(fVar, 0);
        if (f10.f16593i != 4 && f12.f16593i != 4) {
            if (fVar.E[0] == f.b.FIXED || (z11 && fVar.C() == 8)) {
                e eVar = fVar.f16550u.f16484d;
                if (eVar == null && fVar.f16552w.f16484d == null) {
                    f10.p(1);
                    f12.p(1);
                    if (z10) {
                        f12.j(f10, 1, fVar.x());
                    } else {
                        f12.i(f10, fVar.D());
                    }
                } else if (eVar != null && fVar.f16552w.f16484d == null) {
                    f10.p(1);
                    f12.p(1);
                    if (z10) {
                        f12.j(f10, 1, fVar.x());
                    } else {
                        f12.i(f10, fVar.D());
                    }
                } else if (eVar == null && fVar.f16552w.f16484d != null) {
                    f10.p(1);
                    f12.p(1);
                    f10.i(f12, -fVar.D());
                    if (z10) {
                        f10.j(f12, -1, fVar.x());
                    } else {
                        f10.i(f12, -fVar.D());
                    }
                } else if (eVar != null && fVar.f16552w.f16484d != null) {
                    f10.p(2);
                    f12.p(2);
                    if (z10) {
                        fVar.x().a(f10);
                        fVar.x().a(f12);
                        f10.o(f12, -1, fVar.x());
                        f12.o(f10, 1, fVar.x());
                    } else {
                        f10.n(f12, -fVar.D());
                        f12.n(f10, fVar.D());
                    }
                }
            } else if (z11) {
                int D = fVar.D();
                f10.p(1);
                f12.p(1);
                e eVar2 = fVar.f16550u.f16484d;
                if (eVar2 == null && fVar.f16552w.f16484d == null) {
                    if (z10) {
                        f12.j(f10, 1, fVar.x());
                    } else {
                        f12.i(f10, D);
                    }
                } else if (eVar2 == null || fVar.f16552w.f16484d != null) {
                    if (eVar2 != null || fVar.f16552w.f16484d == null) {
                        if (eVar2 != null && fVar.f16552w.f16484d != null) {
                            if (z10) {
                                fVar.x().a(f10);
                                fVar.x().a(f12);
                            }
                            if (fVar.I == 0.0f) {
                                f10.p(3);
                                f12.p(3);
                                f10.n(f12, 0.0f);
                                f12.n(f10, 0.0f);
                            } else {
                                f10.p(2);
                                f12.p(2);
                                f10.n(f12, -D);
                                f12.n(f10, D);
                                fVar.y0(D);
                            }
                        }
                    } else if (z10) {
                        f10.j(f12, -1, fVar.x());
                    } else {
                        f10.i(f12, -D);
                    }
                } else if (z10) {
                    f12.j(f10, 1, fVar.x());
                } else {
                    f12.i(f10, D);
                }
            }
        }
        boolean z12 = fVar.E[1] == bVar2 && d(fVar, 1);
        if (f11.f16593i == 4 || f13.f16593i == 4) {
            return;
        }
        if (fVar.E[1] != f.b.FIXED && (!z12 || fVar.C() != 8)) {
            if (z12) {
                int r10 = fVar.r();
                f11.p(1);
                f13.p(1);
                e eVar3 = fVar.f16551v.f16484d;
                if (eVar3 == null && fVar.f16553x.f16484d == null) {
                    if (z10) {
                        f13.j(f11, 1, fVar.w());
                        return;
                    } else {
                        f13.i(f11, r10);
                        return;
                    }
                }
                if (eVar3 != null && fVar.f16553x.f16484d == null) {
                    if (z10) {
                        f13.j(f11, 1, fVar.w());
                        return;
                    } else {
                        f13.i(f11, r10);
                        return;
                    }
                }
                if (eVar3 == null && fVar.f16553x.f16484d != null) {
                    if (z10) {
                        f11.j(f13, -1, fVar.w());
                        return;
                    } else {
                        f11.i(f13, -r10);
                        return;
                    }
                }
                if (eVar3 == null || fVar.f16553x.f16484d == null) {
                    return;
                }
                if (z10) {
                    fVar.w().a(f11);
                    fVar.x().a(f13);
                }
                if (fVar.I == 0.0f) {
                    f11.p(3);
                    f13.p(3);
                    f11.n(f13, 0.0f);
                    f13.n(f11, 0.0f);
                    return;
                }
                f11.p(2);
                f13.p(2);
                f11.n(f13, -r10);
                f13.n(f11, r10);
                fVar.b0(r10);
                if (fVar.U > 0) {
                    fVar.f16554y.f().h(1, f11, fVar.U);
                    return;
                }
                return;
            }
            return;
        }
        e eVar4 = fVar.f16551v.f16484d;
        if (eVar4 == null && fVar.f16553x.f16484d == null) {
            f11.p(1);
            f13.p(1);
            if (z10) {
                f13.j(f11, 1, fVar.w());
            } else {
                f13.i(f11, fVar.r());
            }
            e eVar5 = fVar.f16554y;
            if (eVar5.f16484d != null) {
                eVar5.f().p(1);
                f11.h(1, fVar.f16554y.f(), -fVar.U);
                return;
            }
            return;
        }
        if (eVar4 != null && fVar.f16553x.f16484d == null) {
            f11.p(1);
            f13.p(1);
            if (z10) {
                f13.j(f11, 1, fVar.w());
            } else {
                f13.i(f11, fVar.r());
            }
            if (fVar.U > 0) {
                fVar.f16554y.f().h(1, f11, fVar.U);
                return;
            }
            return;
        }
        if (eVar4 == null && fVar.f16553x.f16484d != null) {
            f11.p(1);
            f13.p(1);
            if (z10) {
                f11.j(f13, -1, fVar.w());
            } else {
                f11.i(f13, -fVar.r());
            }
            if (fVar.U > 0) {
                fVar.f16554y.f().h(1, f11, fVar.U);
                return;
            }
            return;
        }
        if (eVar4 == null || fVar.f16553x.f16484d == null) {
            return;
        }
        f11.p(2);
        f13.p(2);
        if (z10) {
            f11.o(f13, -1, fVar.w());
            f13.o(f11, 1, fVar.w());
            fVar.w().a(f11);
            fVar.x().a(f13);
        } else {
            f11.n(f13, -fVar.r());
            f13.n(f11, fVar.r());
        }
        if (fVar.U > 0) {
            fVar.f16554y.f().h(1, f11, fVar.U);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:206:0x002e, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x003c, code lost:
    
        if (r7 == 2) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002a, code lost:
    
        if (r7 == 2) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002c, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(g gVar, l.e eVar, int i10, int i11, d dVar) {
        boolean z10;
        boolean z11;
        boolean z12;
        m mVar;
        float d10;
        float f10;
        f fVar;
        boolean z13;
        f fVar2 = dVar.f16464a;
        f fVar3 = dVar.f16466c;
        f fVar4 = dVar.f16465b;
        f fVar5 = dVar.f16467d;
        f fVar6 = dVar.f16468e;
        float f11 = dVar.f16474k;
        f.b bVar = gVar.E[i10];
        f.b bVar2 = f.b.FIXED;
        if (i10 == 0) {
            int i12 = fVar6.f16533l0;
            z10 = i12 == 0;
            z11 = i12 == 1;
        } else {
            int i13 = fVar6.f16535m0;
            z10 = i13 == 0;
            z11 = i13 == 1;
        }
        f fVar7 = fVar2;
        int i14 = 0;
        boolean z14 = false;
        int i15 = 0;
        float f12 = 0.0f;
        float f13 = 0.0f;
        while (!z14) {
            if (fVar7.C() != 8) {
                i15++;
                f12 += i10 == 0 ? fVar7.D() : fVar7.r();
                if (fVar7 != fVar4) {
                    f12 += fVar7.C[i11].d();
                }
                if (fVar7 != fVar5) {
                    f12 += fVar7.C[i11 + 1].d();
                }
                f13 = f13 + fVar7.C[i11].d() + fVar7.C[i11 + 1].d();
            }
            e eVar2 = fVar7.C[i11];
            if (fVar7.C() != 8 && fVar7.E[i10] == f.b.MATCH_CONSTRAINT) {
                i14++;
                if (i10 != 0) {
                    z13 = false;
                    if (fVar7.f16520f != 0) {
                        return false;
                    }
                    if (fVar7.f16530k == 0) {
                        if (fVar7.f16532l != 0) {
                        }
                    }
                    return z13;
                }
                if (fVar7.f16518e != 0) {
                    return false;
                }
                z13 = false;
                if (fVar7.f16524h != 0 || fVar7.f16526i != 0) {
                    return false;
                }
                if (fVar7.I != 0.0f) {
                    return z13;
                }
            }
            e eVar3 = fVar7.C[i11 + 1].f16484d;
            if (eVar3 != null) {
                f fVar8 = eVar3.f16482b;
                e eVar4 = fVar8.C[i11].f16484d;
                if (eVar4 != null && eVar4.f16482b == fVar7) {
                    fVar = fVar8;
                    if (fVar == null) {
                        fVar7 = fVar;
                    } else {
                        z14 = true;
                    }
                }
            }
            fVar = null;
            if (fVar == null) {
            }
        }
        m f14 = fVar2.C[i11].f();
        int i16 = i11 + 1;
        m f15 = fVar3.C[i16].f();
        m mVar2 = f14.f16589e;
        if (mVar2 == null || (mVar = f15.f16589e) == null || mVar2.f16602b != 1 || mVar.f16602b != 1) {
            return false;
        }
        if (i14 > 0 && i14 != i15) {
            return false;
        }
        if (z12 || z10 || z11) {
            d10 = fVar4 != null ? fVar4.C[i11].d() : 0.0f;
            if (fVar5 != null) {
                d10 += fVar5.C[i16].d();
            }
        } else {
            d10 = 0.0f;
        }
        float f16 = f14.f16589e.f16592h;
        float f17 = f15.f16589e.f16592h;
        float f18 = (f16 < f17 ? f17 - f16 : f16 - f17) - f12;
        if (i14 > 0 && i14 == i15) {
            if (fVar7.u() != null && fVar7.u().E[i10] == f.b.WRAP_CONTENT) {
                return false;
            }
            float f19 = (f18 + f12) - f13;
            float f20 = f16;
            f fVar9 = fVar2;
            while (fVar9 != null) {
                int i17 = l.e.f15852q;
                f fVar10 = fVar9.f16545r0[i10];
                if (fVar10 != null || fVar9 == fVar3) {
                    float f21 = f19 / i14;
                    if (f11 > 0.0f) {
                        float f22 = fVar9.f16541p0[i10];
                        if (f22 == -1.0f) {
                            f10 = 0.0f;
                            if (fVar9.C() == 8) {
                                f10 = 0.0f;
                            }
                            float d11 = f20 + fVar9.C[i11].d();
                            fVar9.C[i11].f().l(f14.f16591g, d11);
                            float f23 = d11 + f10;
                            fVar9.C[i16].f().l(f14.f16591g, f23);
                            fVar9.C[i11].f().g(eVar);
                            fVar9.C[i16].f().g(eVar);
                            f20 = f23 + fVar9.C[i16].d();
                        } else {
                            f21 = (f22 * f19) / f11;
                        }
                    }
                    f10 = f21;
                    if (fVar9.C() == 8) {
                    }
                    float d112 = f20 + fVar9.C[i11].d();
                    fVar9.C[i11].f().l(f14.f16591g, d112);
                    float f232 = d112 + f10;
                    fVar9.C[i16].f().l(f14.f16591g, f232);
                    fVar9.C[i11].f().g(eVar);
                    fVar9.C[i16].f().g(eVar);
                    f20 = f232 + fVar9.C[i16].d();
                }
                fVar9 = fVar10;
            }
            return true;
        }
        if (f18 < 0.0f) {
            z12 = true;
            z10 = false;
            z11 = false;
        }
        if (z12) {
            f fVar11 = fVar2;
            float k10 = f16 + ((f18 - d10) * fVar11.k(i10));
            while (true) {
                f fVar12 = fVar11;
                if (fVar12 == null) {
                    return true;
                }
                int i18 = l.e.f15852q;
                fVar11 = fVar12.f16545r0[i10];
                if (fVar11 != null || fVar12 == fVar3) {
                    int D = i10 == 0 ? fVar12.D() : fVar12.r();
                    float d12 = k10 + fVar12.C[i11].d();
                    fVar12.C[i11].f().l(f14.f16591g, d12);
                    float f24 = d12 + D;
                    fVar12.C[i16].f().l(f14.f16591g, f24);
                    fVar12.C[i11].f().g(eVar);
                    fVar12.C[i16].f().g(eVar);
                    k10 = f24 + fVar12.C[i16].d();
                }
            }
        } else {
            f fVar13 = fVar2;
            if (!z10 && !z11) {
                return true;
            }
            if (z10 || z11) {
                f18 -= d10;
            }
            float f25 = f18 / (i15 + 1);
            if (z11) {
                f25 = f18 / (i15 > 1 ? i15 - 1 : 2.0f);
            }
            float f26 = fVar13.C() != 8 ? f16 + f25 : f16;
            if (z11 && i15 > 1) {
                f26 = fVar4.C[i11].d() + f16;
            }
            if (z10 && fVar4 != null) {
                f26 += fVar4.C[i11].d();
            }
            while (true) {
                f fVar14 = fVar13;
                if (fVar14 == null) {
                    return true;
                }
                int i19 = l.e.f15852q;
                fVar13 = fVar14.f16545r0[i10];
                if (fVar13 != null || fVar14 == fVar3) {
                    float D2 = i10 == 0 ? fVar14.D() : fVar14.r();
                    if (fVar14 != fVar4) {
                        f26 += fVar14.C[i11].d();
                    }
                    fVar14.C[i11].f().l(f14.f16591g, f26);
                    fVar14.C[i16].f().l(f14.f16591g, f26 + D2);
                    fVar14.C[i11].f().g(eVar);
                    fVar14.C[i16].f().g(eVar);
                    f26 += D2 + fVar14.C[i16].d();
                    if (fVar13 != null) {
                        if (fVar13.C() != 8) {
                            f26 += f25;
                        }
                    }
                }
            }
        }
    }

    public static void c(g gVar, l.e eVar, f fVar) {
        f.b bVar = gVar.E[0];
        f.b bVar2 = f.b.WRAP_CONTENT;
        if (bVar != bVar2 && fVar.E[0] == f.b.MATCH_PARENT) {
            int i10 = fVar.f16550u.f16485e;
            int D = gVar.D() - fVar.f16552w.f16485e;
            e eVar2 = fVar.f16550u;
            eVar2.f16490j = eVar.r(eVar2);
            e eVar3 = fVar.f16552w;
            eVar3.f16490j = eVar.r(eVar3);
            eVar.f(fVar.f16550u.f16490j, i10);
            eVar.f(fVar.f16552w.f16490j, D);
            fVar.f16510a = 2;
            fVar.f0(i10, D);
        }
        if (gVar.E[1] == bVar2 || fVar.E[1] != f.b.MATCH_PARENT) {
            return;
        }
        int i11 = fVar.f16551v.f16485e;
        int r10 = gVar.r() - fVar.f16553x.f16485e;
        e eVar4 = fVar.f16551v;
        eVar4.f16490j = eVar.r(eVar4);
        e eVar5 = fVar.f16553x;
        eVar5.f16490j = eVar.r(eVar5);
        eVar.f(fVar.f16551v.f16490j, i11);
        eVar.f(fVar.f16553x.f16490j, r10);
        if (fVar.U > 0 || fVar.C() == 8) {
            e eVar6 = fVar.f16554y;
            eVar6.f16490j = eVar.r(eVar6);
            eVar.f(fVar.f16554y.f16490j, fVar.U + i11);
        }
        fVar.f16512b = 2;
        fVar.t0(i11, r10);
    }

    public static boolean d(f fVar, int i10) {
        f.b[] bVarArr = fVar.E;
        if (bVarArr[i10] != f.b.MATCH_CONSTRAINT) {
            return false;
        }
        if (fVar.I != 0.0f) {
            f.b bVar = bVarArr[i10 != 0 ? (char) 0 : (char) 1];
            return false;
        }
        if (i10 == 0) {
            if (fVar.f16518e != 0 || fVar.f16524h != 0 || fVar.f16526i != 0) {
                return false;
            }
        } else if (fVar.f16520f != 0 || fVar.f16530k != 0 || fVar.f16532l != 0) {
            return false;
        }
        return true;
    }

    public static void e(f fVar, int i10, int i11) {
        int i12 = i10 * 2;
        int i13 = i12 + 1;
        fVar.C[i12].f().f16591g = fVar.u().f16550u.f();
        fVar.C[i12].f().f16592h = i11;
        fVar.C[i12].f().f16602b = 1;
        fVar.C[i13].f().f16591g = fVar.C[i12].f();
        fVar.C[i13].f().f16592h = fVar.t(i10);
        fVar.C[i13].f().f16602b = 1;
    }
}
