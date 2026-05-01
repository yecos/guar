package m;

import java.util.ArrayList;
import m.f;

/* loaded from: classes.dex */
public abstract class c {
    public static void a(g gVar, l.e eVar, int i10) {
        int i11;
        d[] dVarArr;
        int i12;
        if (i10 == 0) {
            i11 = gVar.D0;
            dVarArr = gVar.G0;
            i12 = 0;
        } else {
            i11 = gVar.E0;
            dVarArr = gVar.F0;
            i12 = 2;
        }
        for (int i13 = 0; i13 < i11; i13++) {
            d dVar = dVarArr[i13];
            dVar.a();
            if (!gVar.X0(4)) {
                b(gVar, eVar, i10, i12, dVar);
            } else if (!k.b(gVar, eVar, i10, i12, dVar)) {
                b(gVar, eVar, i10, i12, dVar);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
    
        if (r7 == 2) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0040, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x003e, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x003c, code lost:
    
        if (r7 == 2) goto L25;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0477  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0480  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0487  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0497  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x047a  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0340 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:223:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0171  */
    /* JADX WARN: Type inference failed for: r2v58, types: [m.f] */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v34 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [m.f] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(g gVar, l.e eVar, int i10, int i11, d dVar) {
        boolean z10;
        boolean z11;
        boolean z12;
        ArrayList arrayList;
        f fVar;
        e eVar2;
        e eVar3;
        e eVar4;
        int i12;
        l.i iVar;
        e eVar5;
        l.i iVar2;
        f fVar2;
        e eVar6;
        l.i iVar3;
        l.i iVar4;
        f fVar3;
        l.i iVar5;
        int size;
        int i13;
        ArrayList arrayList2;
        int i14;
        float f10;
        int i15;
        boolean z13;
        f fVar4;
        boolean z14;
        int i16;
        f fVar5 = dVar.f16464a;
        f fVar6 = dVar.f16466c;
        f fVar7 = dVar.f16465b;
        f fVar8 = dVar.f16467d;
        f fVar9 = dVar.f16468e;
        float f11 = dVar.f16474k;
        boolean z15 = gVar.E[i10] == f.b.WRAP_CONTENT;
        if (i10 == 0) {
            int i17 = fVar9.f16533l0;
            z10 = i17 == 0;
            z11 = i17 == 1;
        } else {
            int i18 = fVar9.f16535m0;
            z10 = i18 == 0;
            z11 = i18 == 1;
        }
        boolean z16 = z11;
        boolean z17 = false;
        boolean z18 = z10;
        ?? r82 = fVar5;
        while (true) {
            if (z17) {
                break;
            }
            e eVar7 = r82.C[i11];
            int i19 = (z15 || z12) ? 1 : 4;
            int d10 = eVar7.d();
            e eVar8 = eVar7.f16484d;
            if (eVar8 != null && r82 != fVar5) {
                d10 += eVar8.d();
            }
            int i20 = d10;
            if (z12 && r82 != fVar5 && r82 != fVar7) {
                f10 = f11;
                z13 = z17;
                i15 = 6;
            } else if (z18 && z15) {
                f10 = f11;
                z13 = z17;
                i15 = 4;
            } else {
                f10 = f11;
                i15 = i19;
                z13 = z17;
            }
            e eVar9 = eVar7.f16484d;
            if (eVar9 != null) {
                if (r82 == fVar7) {
                    z14 = z18;
                    fVar4 = fVar9;
                    eVar.i(eVar7.f16490j, eVar9.f16490j, i20, 5);
                } else {
                    fVar4 = fVar9;
                    z14 = z18;
                    eVar.i(eVar7.f16490j, eVar9.f16490j, i20, 6);
                }
                eVar.e(eVar7.f16490j, eVar7.f16484d.f16490j, i20, i15);
            } else {
                fVar4 = fVar9;
                z14 = z18;
            }
            if (z15) {
                if (r82.C() == 8 || r82.E[i10] != f.b.MATCH_CONSTRAINT) {
                    i16 = 0;
                } else {
                    e[] eVarArr = r82.C;
                    i16 = 0;
                    eVar.i(eVarArr[i11 + 1].f16490j, eVarArr[i11].f16490j, 0, 5);
                }
                eVar.i(r82.C[i11].f16490j, gVar.C[i11].f16490j, i16, 6);
            }
            e eVar10 = r82.C[i11 + 1].f16484d;
            if (eVar10 != null) {
                ?? r22 = eVar10.f16482b;
                e eVar11 = r22.C[i11].f16484d;
                if (eVar11 != null && eVar11.f16482b == r82) {
                    r19 = r22;
                }
            }
            if (r19 != null) {
                r82 = r19;
                z17 = z13;
            } else {
                z17 = true;
            }
            f11 = f10;
            z18 = z14;
            fVar9 = fVar4;
            r82 = r82;
        }
        f fVar10 = fVar9;
        float f12 = f11;
        boolean z19 = z18;
        if (fVar8 != null) {
            int i21 = i11 + 1;
            e eVar12 = fVar6.C[i21].f16484d;
            if (eVar12 != null) {
                e eVar13 = fVar8.C[i21];
                eVar.k(eVar13.f16490j, eVar12.f16490j, -eVar13.d(), 5);
                if (z15) {
                    int i22 = i11 + 1;
                    l.i iVar6 = gVar.C[i22].f16490j;
                    e eVar14 = fVar6.C[i22];
                    eVar.i(iVar6, eVar14.f16490j, eVar14.d(), 6);
                }
                arrayList = dVar.f16471h;
                if (arrayList != null && (size = arrayList.size()) > 1) {
                    float f13 = (dVar.f16477n || dVar.f16479p) ? f12 : dVar.f16473j;
                    float f14 = 0.0f;
                    f fVar11 = null;
                    i13 = 0;
                    float f15 = 0.0f;
                    while (i13 < size) {
                        f fVar12 = (f) arrayList.get(i13);
                        float f16 = fVar12.f16541p0[i10];
                        if (f16 < f14) {
                            if (dVar.f16479p) {
                                e[] eVarArr2 = fVar12.C;
                                eVar.e(eVarArr2[i11 + 1].f16490j, eVarArr2[i11].f16490j, 0, 4);
                                arrayList2 = arrayList;
                                i14 = size;
                                i13++;
                                size = i14;
                                arrayList = arrayList2;
                                f14 = 0.0f;
                            } else {
                                f16 = 1.0f;
                            }
                        }
                        if (f16 == 0.0f) {
                            e[] eVarArr3 = fVar12.C;
                            eVar.e(eVarArr3[i11 + 1].f16490j, eVarArr3[i11].f16490j, 0, 6);
                            arrayList2 = arrayList;
                            i14 = size;
                            i13++;
                            size = i14;
                            arrayList = arrayList2;
                            f14 = 0.0f;
                        } else {
                            if (fVar11 != null) {
                                e[] eVarArr4 = fVar11.C;
                                l.i iVar7 = eVarArr4[i11].f16490j;
                                int i23 = i11 + 1;
                                l.i iVar8 = eVarArr4[i23].f16490j;
                                e[] eVarArr5 = fVar12.C;
                                arrayList2 = arrayList;
                                l.i iVar9 = eVarArr5[i11].f16490j;
                                l.i iVar10 = eVarArr5[i23].f16490j;
                                i14 = size;
                                l.b s10 = eVar.s();
                                s10.k(f15, f13, f16, iVar7, iVar8, iVar9, iVar10);
                                eVar.d(s10);
                            } else {
                                arrayList2 = arrayList;
                                i14 = size;
                            }
                            fVar11 = fVar12;
                            f15 = f16;
                            i13++;
                            size = i14;
                            arrayList = arrayList2;
                            f14 = 0.0f;
                        }
                    }
                }
                if (fVar7 == null && (fVar7 == fVar8 || z12)) {
                    e eVar15 = fVar5.C[i11];
                    int i24 = i11 + 1;
                    e eVar16 = fVar6.C[i24];
                    e eVar17 = eVar15.f16484d;
                    l.i iVar11 = eVar17 != null ? eVar17.f16490j : null;
                    e eVar18 = eVar16.f16484d;
                    l.i iVar12 = eVar18 != null ? eVar18.f16490j : null;
                    if (fVar7 == fVar8) {
                        e[] eVarArr6 = fVar7.C;
                        e eVar19 = eVarArr6[i11];
                        eVar16 = eVarArr6[i24];
                        eVar15 = eVar19;
                    }
                    if (iVar11 != null && iVar12 != null) {
                        eVar.c(eVar15.f16490j, iVar11, eVar15.d(), i10 == 0 ? fVar10.Z : fVar10.f16511a0, iVar12, eVar16.f16490j, eVar16.d(), 5);
                    }
                } else if (!z19 && fVar7 != null) {
                    int i25 = dVar.f16473j;
                    boolean z20 = i25 > 0 && dVar.f16472i == i25;
                    f fVar13 = fVar7;
                    f fVar14 = fVar13;
                    while (fVar13 != null) {
                        f fVar15 = fVar13.f16545r0[i10];
                        while (fVar15 != null && fVar15.C() == 8) {
                            fVar15 = fVar15.f16545r0[i10];
                        }
                        if (fVar15 != null || fVar13 == fVar8) {
                            e eVar20 = fVar13.C[i11];
                            l.i iVar13 = eVar20.f16490j;
                            e eVar21 = eVar20.f16484d;
                            l.i iVar14 = eVar21 != null ? eVar21.f16490j : null;
                            if (fVar14 != fVar13) {
                                iVar14 = fVar14.C[i11 + 1].f16490j;
                            } else if (fVar13 == fVar7 && fVar14 == fVar13) {
                                e eVar22 = fVar5.C[i11].f16484d;
                                iVar14 = eVar22 != null ? eVar22.f16490j : null;
                            }
                            int d11 = eVar20.d();
                            int i26 = i11 + 1;
                            int d12 = fVar13.C[i26].d();
                            if (fVar15 != null) {
                                eVar6 = fVar15.C[i11];
                                iVar3 = eVar6.f16490j;
                                iVar4 = fVar13.C[i26].f16490j;
                            } else {
                                eVar6 = fVar6.C[i26].f16484d;
                                iVar3 = eVar6 != null ? eVar6.f16490j : null;
                                iVar4 = fVar13.C[i26].f16490j;
                            }
                            if (eVar6 != null) {
                                d12 += eVar6.d();
                            }
                            if (fVar14 != null) {
                                d11 += fVar14.C[i26].d();
                            }
                            if (iVar13 != null && iVar14 != null && iVar3 != null && iVar4 != null) {
                                if (fVar13 == fVar7) {
                                    d11 = fVar7.C[i11].d();
                                }
                                int i27 = d11;
                                fVar3 = fVar15;
                                eVar.c(iVar13, iVar14, i27, 0.5f, iVar3, iVar4, fVar13 == fVar8 ? fVar8.C[i26].d() : d12, z20 ? 6 : 4);
                                if (fVar13.C() == 8) {
                                    fVar14 = fVar13;
                                }
                                fVar13 = fVar3;
                            }
                        }
                        fVar3 = fVar15;
                        if (fVar13.C() == 8) {
                        }
                        fVar13 = fVar3;
                    }
                } else if (z16 && fVar7 != null) {
                    int i28 = dVar.f16473j;
                    boolean z21 = i28 <= 0 && dVar.f16472i == i28;
                    fVar = fVar7;
                    f fVar16 = fVar;
                    while (fVar != null) {
                        f fVar17 = fVar.f16545r0[i10];
                        while (fVar17 != null && fVar17.C() == 8) {
                            fVar17 = fVar17.f16545r0[i10];
                        }
                        if (fVar != fVar7 && fVar != fVar8 && fVar17 != null) {
                            f fVar18 = fVar17 == fVar8 ? null : fVar17;
                            e eVar23 = fVar.C[i11];
                            l.i iVar15 = eVar23.f16490j;
                            e eVar24 = eVar23.f16484d;
                            if (eVar24 != null) {
                                l.i iVar16 = eVar24.f16490j;
                            }
                            int i29 = i11 + 1;
                            l.i iVar17 = fVar16.C[i29].f16490j;
                            int d13 = eVar23.d();
                            int d14 = fVar.C[i29].d();
                            if (fVar18 != null) {
                                eVar5 = fVar18.C[i11];
                                iVar2 = eVar5.f16490j;
                                e eVar25 = eVar5.f16484d;
                                iVar = eVar25 != null ? eVar25.f16490j : null;
                            } else {
                                e eVar26 = fVar.C[i29];
                                e eVar27 = eVar26.f16484d;
                                l.i iVar18 = eVar27 != null ? eVar27.f16490j : null;
                                iVar = eVar26.f16490j;
                                eVar5 = eVar27;
                                iVar2 = iVar18;
                            }
                            if (eVar5 != null) {
                                d14 += eVar5.d();
                            }
                            int i30 = d14;
                            int d15 = fVar16.C[i29].d() + d13;
                            int i31 = z21 ? 6 : 4;
                            if (iVar15 == null || iVar17 == null || iVar2 == null || iVar == null) {
                                fVar2 = fVar18;
                            } else {
                                fVar2 = fVar18;
                                eVar.c(iVar15, iVar17, d15, 0.5f, iVar2, iVar, i30, i31);
                            }
                            fVar17 = fVar2;
                        }
                        if (fVar.C() != 8) {
                            fVar16 = fVar;
                        }
                        fVar = fVar17;
                    }
                    e eVar28 = fVar7.C[i11];
                    eVar2 = fVar5.C[i11].f16484d;
                    int i32 = i11 + 1;
                    eVar3 = fVar8.C[i32];
                    eVar4 = fVar6.C[i32].f16484d;
                    if (eVar2 != null) {
                        i12 = 5;
                    } else if (fVar7 != fVar8) {
                        i12 = 5;
                        eVar.e(eVar28.f16490j, eVar2.f16490j, eVar28.d(), 5);
                    } else {
                        i12 = 5;
                        if (eVar4 != null) {
                            eVar.c(eVar28.f16490j, eVar2.f16490j, eVar28.d(), 0.5f, eVar3.f16490j, eVar4.f16490j, eVar3.d(), 5);
                        }
                    }
                    if (eVar4 != null && fVar7 != fVar8) {
                        eVar.e(eVar3.f16490j, eVar4.f16490j, -eVar3.d(), i12);
                    }
                }
                if ((!z19 || z16) && fVar7 != null) {
                    e[] eVarArr7 = fVar7.C;
                    e eVar29 = eVarArr7[i11];
                    int i33 = i11 + 1;
                    e eVar30 = fVar8.C[i33];
                    e eVar31 = eVar29.f16484d;
                    iVar5 = eVar31 == null ? eVar31.f16490j : null;
                    e eVar32 = eVar30.f16484d;
                    l.i iVar19 = eVar32 == null ? eVar32.f16490j : null;
                    if (fVar6 != fVar8) {
                        e eVar33 = fVar6.C[i33].f16484d;
                        iVar19 = eVar33 != null ? eVar33.f16490j : null;
                    }
                    if (fVar7 == fVar8) {
                        eVar30 = eVarArr7[i33];
                    }
                    if (iVar5 != null || iVar19 == null) {
                    }
                    eVar.c(eVar29.f16490j, iVar5, eVar29.d(), 0.5f, iVar19, eVar30.f16490j, fVar8.C[i33].d(), 5);
                    return;
                }
                return;
            }
        }
        if (z15) {
        }
        arrayList = dVar.f16471h;
        if (arrayList != null) {
            if (dVar.f16477n) {
            }
            float f142 = 0.0f;
            f fVar112 = null;
            i13 = 0;
            float f152 = 0.0f;
            while (i13 < size) {
            }
        }
        if (fVar7 == null) {
        }
        if (!z19) {
        }
        if (z16) {
            int i282 = dVar.f16473j;
            if (i282 <= 0) {
            }
            fVar = fVar7;
            f fVar162 = fVar;
            while (fVar != null) {
            }
            e eVar282 = fVar7.C[i11];
            eVar2 = fVar5.C[i11].f16484d;
            int i322 = i11 + 1;
            eVar3 = fVar8.C[i322];
            eVar4 = fVar6.C[i322].f16484d;
            if (eVar2 != null) {
            }
            if (eVar4 != null) {
                eVar.e(eVar3.f16490j, eVar4.f16490j, -eVar3.d(), i12);
            }
        }
        if (z19) {
        }
        e[] eVarArr72 = fVar7.C;
        e eVar292 = eVarArr72[i11];
        int i332 = i11 + 1;
        e eVar302 = fVar8.C[i332];
        e eVar312 = eVar292.f16484d;
        if (eVar312 == null) {
        }
        e eVar322 = eVar302.f16484d;
        if (eVar322 == null) {
        }
        if (fVar6 != fVar8) {
        }
        if (fVar7 == fVar8) {
        }
        if (iVar5 != null) {
        }
    }
}
