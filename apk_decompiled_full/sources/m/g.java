package m;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import m.e;
import m.f;

/* loaded from: classes.dex */
public class g extends q {
    public int A0;
    public int B0;
    public int C0;

    /* renamed from: y0, reason: collision with root package name */
    public p f16565y0;

    /* renamed from: z0, reason: collision with root package name */
    public int f16566z0;

    /* renamed from: w0, reason: collision with root package name */
    public boolean f16563w0 = false;

    /* renamed from: x0, reason: collision with root package name */
    public l.e f16564x0 = new l.e();
    public int D0 = 0;
    public int E0 = 0;
    public d[] F0 = new d[4];
    public d[] G0 = new d[4];
    public List H0 = new ArrayList();
    public boolean I0 = false;
    public boolean J0 = false;
    public boolean K0 = false;
    public int L0 = 0;
    public int M0 = 0;
    public int N0 = 7;
    public boolean O0 = false;
    public boolean P0 = false;
    public boolean Q0 = false;
    public int R0 = 0;

    /* JADX WARN: Removed duplicated region for block: B:109:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0287  */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v25 */
    @Override // m.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void K0() {
        int i10;
        int i11;
        int i12;
        int i13;
        char c10;
        boolean z10;
        int max;
        int max2;
        ?? r82;
        boolean z11;
        int i14 = this.K;
        int i15 = this.L;
        int max3 = Math.max(0, D());
        int max4 = Math.max(0, r());
        this.P0 = false;
        this.Q0 = false;
        if (this.F != null) {
            if (this.f16565y0 == null) {
                this.f16565y0 = new p(this);
            }
            this.f16565y0.b(this);
            C0(this.f16566z0);
            D0(this.A0);
            R();
            T(this.f16564x0.w());
        } else {
            this.K = 0;
            this.L = 0;
        }
        int i16 = 32;
        if (this.N0 != 0) {
            if (!X0(8)) {
                Z0();
            }
            if (!X0(32)) {
                W0();
            }
            this.f16564x0.f15859g = true;
        } else {
            this.f16564x0.f15859g = false;
        }
        f.b[] bVarArr = this.E;
        f.b bVar = bVarArr[1];
        f.b bVar2 = bVarArr[0];
        b1();
        if (this.H0.size() == 0) {
            this.H0.clear();
            this.H0.add(0, new h(this.f16613v0));
        }
        int size = this.H0.size();
        ArrayList arrayList = this.f16613v0;
        f.b s10 = s();
        f.b bVar3 = f.b.WRAP_CONTENT;
        boolean z12 = s10 == bVar3 || B() == bVar3;
        boolean z13 = false;
        int i17 = 0;
        while (i17 < size && !this.O0) {
            if (((h) this.H0.get(i17)).f16570d) {
                i10 = i15;
                i11 = size;
            } else {
                if (X0(i16)) {
                    f.b s11 = s();
                    f.b bVar4 = f.b.FIXED;
                    if (s11 == bVar4 && B() == bVar4) {
                        this.f16613v0 = (ArrayList) ((h) this.H0.get(i17)).d();
                    } else {
                        this.f16613v0 = (ArrayList) ((h) this.H0.get(i17)).f16567a;
                    }
                }
                b1();
                int size2 = this.f16613v0.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    f fVar = (f) this.f16613v0.get(i18);
                    if (fVar instanceof q) {
                        ((q) fVar).K0();
                    }
                }
                boolean z14 = z13;
                int i19 = 0;
                boolean z15 = true;
                while (z15) {
                    boolean z16 = z14;
                    int i20 = i19 + 1;
                    try {
                        this.f16564x0.E();
                        b1();
                        g(this.f16564x0);
                        int i21 = 0;
                        while (i21 < size2) {
                            boolean z17 = z15;
                            try {
                                ((f) this.f16613v0.get(i21)).g(this.f16564x0);
                                i21++;
                                z15 = z17;
                            } catch (Exception e10) {
                                e = e10;
                                z15 = z17;
                                e.printStackTrace();
                                PrintStream printStream = System.out;
                                boolean z18 = z15;
                                StringBuilder sb = new StringBuilder();
                                i12 = size;
                                sb.append("EXCEPTION : ");
                                sb.append(e);
                                printStream.println(sb.toString());
                                z15 = z18;
                                if (!z15) {
                                }
                                i13 = i15;
                                c10 = 2;
                                if (z12) {
                                }
                                z10 = false;
                                max = Math.max(this.V, D());
                                if (max > D()) {
                                }
                                max2 = Math.max(this.W, r());
                                if (max2 > r()) {
                                }
                                if (!z11) {
                                }
                                z15 = z10;
                                i19 = i20;
                                z14 = z11;
                                size = i12;
                                i15 = i13;
                            }
                        }
                        z15 = O0(this.f16564x0);
                        if (z15) {
                            try {
                                this.f16564x0.A();
                            } catch (Exception e11) {
                                e = e11;
                                e.printStackTrace();
                                PrintStream printStream2 = System.out;
                                boolean z182 = z15;
                                StringBuilder sb2 = new StringBuilder();
                                i12 = size;
                                sb2.append("EXCEPTION : ");
                                sb2.append(e);
                                printStream2.println(sb2.toString());
                                z15 = z182;
                                if (!z15) {
                                }
                                i13 = i15;
                                c10 = 2;
                                if (z12) {
                                }
                                z10 = false;
                                max = Math.max(this.V, D());
                                if (max > D()) {
                                }
                                max2 = Math.max(this.W, r());
                                if (max2 > r()) {
                                }
                                if (!z11) {
                                }
                                z15 = z10;
                                i19 = i20;
                                z14 = z11;
                                size = i12;
                                i15 = i13;
                            }
                        }
                        i12 = size;
                    } catch (Exception e12) {
                        e = e12;
                    }
                    if (!z15) {
                        G0(this.f16564x0);
                        int i22 = 0;
                        while (i22 < size2) {
                            f fVar2 = (f) this.f16613v0.get(i22);
                            f.b bVar5 = fVar2.E[0];
                            f.b bVar6 = f.b.MATCH_CONSTRAINT;
                            if (bVar5 == bVar6) {
                                i13 = i15;
                                if (fVar2.D() < fVar2.F()) {
                                    c10 = 2;
                                    k.f16586a[2] = true;
                                    break;
                                }
                            } else {
                                i13 = i15;
                            }
                            if (fVar2.E[1] == bVar6 && fVar2.r() < fVar2.E()) {
                                c10 = 2;
                                k.f16586a[2] = true;
                                break;
                            } else {
                                i22++;
                                i15 = i13;
                            }
                        }
                    } else {
                        f1(this.f16564x0, k.f16586a);
                    }
                    i13 = i15;
                    c10 = 2;
                    if (z12 || i20 >= 8 || !k.f16586a[c10]) {
                        z10 = false;
                    } else {
                        int i23 = 0;
                        int i24 = 0;
                        for (int i25 = 0; i25 < size2; i25++) {
                            f fVar3 = (f) this.f16613v0.get(i25);
                            i23 = Math.max(i23, fVar3.K + fVar3.D());
                            i24 = Math.max(i24, fVar3.L + fVar3.r());
                        }
                        int max5 = Math.max(this.V, i23);
                        int max6 = Math.max(this.W, i24);
                        f.b bVar7 = f.b.WRAP_CONTENT;
                        if (bVar2 != bVar7 || D() >= max5) {
                            z10 = false;
                        } else {
                            y0(max5);
                            this.E[0] = bVar7;
                            z10 = true;
                            z16 = true;
                        }
                        if (bVar == bVar7 && r() < max6) {
                            b0(max6);
                            this.E[1] = bVar7;
                            z10 = true;
                            z16 = true;
                        }
                    }
                    max = Math.max(this.V, D());
                    if (max > D()) {
                        y0(max);
                        this.E[0] = f.b.FIXED;
                        z10 = true;
                        z16 = true;
                    }
                    max2 = Math.max(this.W, r());
                    if (max2 > r()) {
                        b0(max2);
                        r82 = 1;
                        this.E[1] = f.b.FIXED;
                        z10 = true;
                        z11 = true;
                    } else {
                        r82 = 1;
                        z11 = z16;
                    }
                    if (!z11) {
                        f.b bVar8 = this.E[0];
                        f.b bVar9 = f.b.WRAP_CONTENT;
                        if (bVar8 == bVar9 && max3 > 0 && D() > max3) {
                            this.P0 = r82;
                            this.E[0] = f.b.FIXED;
                            y0(max3);
                            z10 = true;
                            z11 = true;
                        }
                        if (this.E[r82] == bVar9 && max4 > 0 && r() > max4) {
                            this.Q0 = r82;
                            this.E[r82] = f.b.FIXED;
                            b0(max4);
                            z15 = true;
                            z11 = true;
                            i19 = i20;
                            z14 = z11;
                            size = i12;
                            i15 = i13;
                        }
                    }
                    z15 = z10;
                    i19 = i20;
                    z14 = z11;
                    size = i12;
                    i15 = i13;
                }
                i10 = i15;
                i11 = size;
                ((h) this.H0.get(i17)).g();
                z13 = z14;
            }
            i17++;
            size = i11;
            i15 = i10;
            i16 = 32;
        }
        int i26 = i15;
        this.f16613v0 = arrayList;
        if (this.F != null) {
            int max7 = Math.max(this.V, D());
            int max8 = Math.max(this.W, r());
            this.f16565y0.a(this);
            y0(max7 + this.f16566z0 + this.B0);
            b0(max8 + this.A0 + this.C0);
        } else {
            this.K = i14;
            this.L = i26;
        }
        if (z13) {
            f.b[] bVarArr2 = this.E;
            bVarArr2[0] = bVar2;
            bVarArr2[1] = bVar;
        }
        T(this.f16564x0.w());
        if (this == J0()) {
            F0();
        }
    }

    public void N0(f fVar, int i10) {
        if (i10 == 0) {
            P0(fVar);
        } else if (i10 == 1) {
            Q0(fVar);
        }
    }

    public boolean O0(l.e eVar) {
        b(eVar);
        int size = this.f16613v0.size();
        for (int i10 = 0; i10 < size; i10++) {
            f fVar = (f) this.f16613v0.get(i10);
            if (fVar instanceof g) {
                f.b[] bVarArr = fVar.E;
                f.b bVar = bVarArr[0];
                f.b bVar2 = bVarArr[1];
                f.b bVar3 = f.b.WRAP_CONTENT;
                if (bVar == bVar3) {
                    fVar.g0(f.b.FIXED);
                }
                if (bVar2 == bVar3) {
                    fVar.u0(f.b.FIXED);
                }
                fVar.b(eVar);
                if (bVar == bVar3) {
                    fVar.g0(bVar);
                }
                if (bVar2 == bVar3) {
                    fVar.u0(bVar2);
                }
            } else {
                k.c(this, eVar, fVar);
                fVar.b(eVar);
            }
        }
        if (this.D0 > 0) {
            c.a(this, eVar, 0);
        }
        if (this.E0 > 0) {
            c.a(this, eVar, 1);
        }
        return true;
    }

    public final void P0(f fVar) {
        int i10 = this.D0 + 1;
        d[] dVarArr = this.G0;
        if (i10 >= dVarArr.length) {
            this.G0 = (d[]) Arrays.copyOf(dVarArr, dVarArr.length * 2);
        }
        this.G0[this.D0] = new d(fVar, 0, U0());
        this.D0++;
    }

    @Override // m.q, m.f
    public void Q() {
        this.f16564x0.E();
        this.f16566z0 = 0;
        this.B0 = 0;
        this.A0 = 0;
        this.C0 = 0;
        this.H0.clear();
        this.O0 = false;
        super.Q();
    }

    public final void Q0(f fVar) {
        int i10 = this.E0 + 1;
        d[] dVarArr = this.F0;
        if (i10 >= dVarArr.length) {
            this.F0 = (d[]) Arrays.copyOf(dVarArr, dVarArr.length * 2);
        }
        this.F0[this.E0] = new d(fVar, 1, U0());
        this.E0++;
    }

    public int R0() {
        return this.N0;
    }

    public boolean S0() {
        return false;
    }

    public boolean T0() {
        return this.Q0;
    }

    public boolean U0() {
        return this.f16563w0;
    }

    public boolean V0() {
        return this.P0;
    }

    public void W0() {
        if (!X0(8)) {
            d(this.N0);
        }
        e1();
    }

    public boolean X0(int i10) {
        return (this.N0 & i10) == i10;
    }

    public void Y0(int i10, int i11) {
        n nVar;
        n nVar2;
        f.b bVar = this.E[0];
        f.b bVar2 = f.b.WRAP_CONTENT;
        if (bVar != bVar2 && (nVar2 = this.f16514c) != null) {
            nVar2.h(i10);
        }
        if (this.E[1] == bVar2 || (nVar = this.f16516d) == null) {
            return;
        }
        nVar.h(i11);
    }

    public void Z0() {
        int size = this.f16613v0.size();
        S();
        for (int i10 = 0; i10 < size; i10++) {
            ((f) this.f16613v0.get(i10)).S();
        }
    }

    public void a1() {
        Z0();
        d(this.N0);
    }

    public final void b1() {
        this.D0 = 0;
        this.E0 = 0;
    }

    public void c1(int i10) {
        this.N0 = i10;
    }

    @Override // m.f
    public void d(int i10) {
        super.d(i10);
        int size = this.f16613v0.size();
        for (int i11 = 0; i11 < size; i11++) {
            ((f) this.f16613v0.get(i11)).d(i10);
        }
    }

    public void d1(boolean z10) {
        this.f16563w0 = z10;
    }

    public void e1() {
        m f10 = h(e.d.LEFT).f();
        m f11 = h(e.d.TOP).f();
        f10.l(null, 0.0f);
        f11.l(null, 0.0f);
    }

    public void f1(l.e eVar, boolean[] zArr) {
        zArr[2] = false;
        G0(eVar);
        int size = this.f16613v0.size();
        for (int i10 = 0; i10 < size; i10++) {
            f fVar = (f) this.f16613v0.get(i10);
            fVar.G0(eVar);
            f.b bVar = fVar.E[0];
            f.b bVar2 = f.b.MATCH_CONSTRAINT;
            if (bVar == bVar2 && fVar.D() < fVar.F()) {
                zArr[2] = true;
            }
            if (fVar.E[1] == bVar2 && fVar.r() < fVar.E()) {
                zArr[2] = true;
            }
        }
    }
}
