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
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean b(m.g r21, l.e r22, int r23, int r24, m.d r25) {
        /*
            Method dump skipped, instructions count: 818
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.k.b(m.g, l.e, int, int, m.d):boolean");
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
