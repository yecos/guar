package m;

import java.util.ArrayList;
import m.f;

/* loaded from: classes.dex */
public class b extends j {

    /* renamed from: x0, reason: collision with root package name */
    public int f16461x0 = 0;

    /* renamed from: y0, reason: collision with root package name */
    public ArrayList f16462y0 = new ArrayList(4);

    /* renamed from: z0, reason: collision with root package name */
    public boolean f16463z0 = true;

    public void K0(boolean z10) {
        this.f16463z0 = z10;
    }

    public void L0(int i10) {
        this.f16461x0 = i10;
    }

    @Override // m.f
    public void S() {
        super.S();
        this.f16462y0.clear();
    }

    @Override // m.f
    public void U() {
        m f10;
        float f11;
        m mVar;
        int i10 = this.f16461x0;
        float f12 = Float.MAX_VALUE;
        if (i10 != 0) {
            if (i10 == 1) {
                f10 = this.f16552w.f();
            } else if (i10 == 2) {
                f10 = this.f16551v.f();
            } else if (i10 != 3) {
                return;
            } else {
                f10 = this.f16553x.f();
            }
            f12 = 0.0f;
        } else {
            f10 = this.f16550u.f();
        }
        int size = this.f16462y0.size();
        m mVar2 = null;
        for (int i11 = 0; i11 < size; i11++) {
            m mVar3 = (m) this.f16462y0.get(i11);
            if (mVar3.f16602b != 1) {
                return;
            }
            int i12 = this.f16461x0;
            if (i12 == 0 || i12 == 2) {
                f11 = mVar3.f16592h;
                if (f11 < f12) {
                    mVar = mVar3.f16591g;
                    mVar2 = mVar;
                    f12 = f11;
                }
            } else {
                f11 = mVar3.f16592h;
                if (f11 > f12) {
                    mVar = mVar3.f16591g;
                    mVar2 = mVar;
                    f12 = f11;
                }
            }
        }
        l.e.x();
        f10.f16591g = mVar2;
        f10.f16592h = f12;
        f10.b();
        int i13 = this.f16461x0;
        if (i13 == 0) {
            this.f16552w.f().l(mVar2, f12);
            return;
        }
        if (i13 == 1) {
            this.f16550u.f().l(mVar2, f12);
        } else if (i13 == 2) {
            this.f16553x.f().l(mVar2, f12);
        } else {
            if (i13 != 3) {
                return;
            }
            this.f16551v.f().l(mVar2, f12);
        }
    }

    @Override // m.f
    public void b(l.e eVar) {
        e[] eVarArr;
        boolean z10;
        int i10;
        int i11;
        e[] eVarArr2 = this.C;
        eVarArr2[0] = this.f16550u;
        eVarArr2[2] = this.f16551v;
        eVarArr2[1] = this.f16552w;
        eVarArr2[3] = this.f16553x;
        int i12 = 0;
        while (true) {
            eVarArr = this.C;
            if (i12 >= eVarArr.length) {
                break;
            }
            e eVar2 = eVarArr[i12];
            eVar2.f16490j = eVar.r(eVar2);
            i12++;
        }
        int i13 = this.f16461x0;
        if (i13 < 0 || i13 >= 4) {
            return;
        }
        e eVar3 = eVarArr[i13];
        for (int i14 = 0; i14 < this.f16585w0; i14++) {
            f fVar = this.f16584v0[i14];
            if ((this.f16463z0 || fVar.c()) && ((((i10 = this.f16461x0) == 0 || i10 == 1) && fVar.s() == f.b.MATCH_CONSTRAINT) || (((i11 = this.f16461x0) == 2 || i11 == 3) && fVar.B() == f.b.MATCH_CONSTRAINT))) {
                z10 = true;
                break;
            }
        }
        z10 = false;
        int i15 = this.f16461x0;
        if (i15 == 0 || i15 == 1 ? u().s() == f.b.WRAP_CONTENT : u().B() == f.b.WRAP_CONTENT) {
            z10 = false;
        }
        for (int i16 = 0; i16 < this.f16585w0; i16++) {
            f fVar2 = this.f16584v0[i16];
            if (this.f16463z0 || fVar2.c()) {
                l.i r10 = eVar.r(fVar2.C[this.f16461x0]);
                e[] eVarArr3 = fVar2.C;
                int i17 = this.f16461x0;
                eVarArr3[i17].f16490j = r10;
                if (i17 == 0 || i17 == 2) {
                    eVar.j(eVar3.f16490j, r10, z10);
                } else {
                    eVar.h(eVar3.f16490j, r10, z10);
                }
            }
        }
        int i18 = this.f16461x0;
        if (i18 == 0) {
            eVar.e(this.f16552w.f16490j, this.f16550u.f16490j, 0, 6);
            if (z10) {
                return;
            }
            eVar.e(this.f16550u.f16490j, this.F.f16552w.f16490j, 0, 5);
            return;
        }
        if (i18 == 1) {
            eVar.e(this.f16550u.f16490j, this.f16552w.f16490j, 0, 6);
            if (z10) {
                return;
            }
            eVar.e(this.f16550u.f16490j, this.F.f16550u.f16490j, 0, 5);
            return;
        }
        if (i18 == 2) {
            eVar.e(this.f16553x.f16490j, this.f16551v.f16490j, 0, 6);
            if (z10) {
                return;
            }
            eVar.e(this.f16551v.f16490j, this.F.f16553x.f16490j, 0, 5);
            return;
        }
        if (i18 == 3) {
            eVar.e(this.f16551v.f16490j, this.f16553x.f16490j, 0, 6);
            if (z10) {
                return;
            }
            eVar.e(this.f16551v.f16490j, this.F.f16551v.f16490j, 0, 5);
        }
    }

    @Override // m.f
    public boolean c() {
        return true;
    }

    @Override // m.f
    public void d(int i10) {
        m f10;
        f fVar = this.F;
        if (fVar != null && ((g) fVar).X0(2)) {
            int i11 = this.f16461x0;
            if (i11 == 0) {
                f10 = this.f16550u.f();
            } else if (i11 == 1) {
                f10 = this.f16552w.f();
            } else if (i11 == 2) {
                f10 = this.f16551v.f();
            } else if (i11 != 3) {
                return;
            } else {
                f10 = this.f16553x.f();
            }
            f10.p(5);
            int i12 = this.f16461x0;
            if (i12 == 0 || i12 == 1) {
                this.f16551v.f().l(null, 0.0f);
                this.f16553x.f().l(null, 0.0f);
            } else {
                this.f16550u.f().l(null, 0.0f);
                this.f16552w.f().l(null, 0.0f);
            }
            this.f16462y0.clear();
            for (int i13 = 0; i13 < this.f16585w0; i13++) {
                f fVar2 = this.f16584v0[i13];
                if (this.f16463z0 || fVar2.c()) {
                    int i14 = this.f16461x0;
                    m f11 = i14 != 0 ? i14 != 1 ? i14 != 2 ? i14 != 3 ? null : fVar2.f16553x.f() : fVar2.f16551v.f() : fVar2.f16552w.f() : fVar2.f16550u.f();
                    if (f11 != null) {
                        this.f16462y0.add(f11);
                        f11.a(f10);
                    }
                }
            }
        }
    }
}
