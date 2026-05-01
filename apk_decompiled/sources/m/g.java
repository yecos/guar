package m;

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
        To view partially-correct add '--show-bad-code' argument
    */
    public void K0() {
        /*
            Method dump skipped, instructions count: 835
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.g.K0():void");
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
