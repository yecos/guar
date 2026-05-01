package m;

import java.util.ArrayList;
import m.e;
import m.f;

/* loaded from: classes.dex */
public class i extends f {

    /* renamed from: v0, reason: collision with root package name */
    public float f16578v0 = -1.0f;

    /* renamed from: w0, reason: collision with root package name */
    public int f16579w0 = -1;

    /* renamed from: x0, reason: collision with root package name */
    public int f16580x0 = -1;

    /* renamed from: y0, reason: collision with root package name */
    public e f16581y0 = this.f16551v;

    /* renamed from: z0, reason: collision with root package name */
    public int f16582z0 = 0;
    public boolean A0 = false;
    public int B0 = 0;
    public l C0 = new l();
    public int D0 = 8;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16583a;

        static {
            int[] iArr = new int[e.d.values().length];
            f16583a = iArr;
            try {
                iArr[e.d.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16583a[e.d.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16583a[e.d.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16583a[e.d.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f16583a[e.d.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f16583a[e.d.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f16583a[e.d.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f16583a[e.d.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f16583a[e.d.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public i() {
        this.D.clear();
        this.D.add(this.f16581y0);
        int length = this.C.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.C[i10] = this.f16581y0;
        }
    }

    @Override // m.f
    public void G0(l.e eVar) {
        if (u() == null) {
            return;
        }
        int y10 = eVar.y(this.f16581y0);
        if (this.f16582z0 == 1) {
            C0(y10);
            D0(0);
            b0(u().r());
            y0(0);
            return;
        }
        C0(0);
        D0(y10);
        y0(u().D());
        b0(0);
    }

    public int I0() {
        return this.f16582z0;
    }

    public void J0(int i10) {
        if (i10 > -1) {
            this.f16578v0 = -1.0f;
            this.f16579w0 = i10;
            this.f16580x0 = -1;
        }
    }

    public void K0(int i10) {
        if (i10 > -1) {
            this.f16578v0 = -1.0f;
            this.f16579w0 = -1;
            this.f16580x0 = i10;
        }
    }

    public void L0(float f10) {
        if (f10 > -1.0f) {
            this.f16578v0 = f10;
            this.f16579w0 = -1;
            this.f16580x0 = -1;
        }
    }

    public void M0(int i10) {
        if (this.f16582z0 == i10) {
            return;
        }
        this.f16582z0 = i10;
        this.D.clear();
        if (this.f16582z0 == 1) {
            this.f16581y0 = this.f16550u;
        } else {
            this.f16581y0 = this.f16551v;
        }
        this.D.add(this.f16581y0);
        int length = this.C.length;
        for (int i11 = 0; i11 < length; i11++) {
            this.C[i11] = this.f16581y0;
        }
    }

    @Override // m.f
    public void b(l.e eVar) {
        g gVar = (g) u();
        if (gVar == null) {
            return;
        }
        e h10 = gVar.h(e.d.LEFT);
        e h11 = gVar.h(e.d.RIGHT);
        f fVar = this.F;
        boolean z10 = fVar != null && fVar.E[0] == f.b.WRAP_CONTENT;
        if (this.f16582z0 == 0) {
            h10 = gVar.h(e.d.TOP);
            h11 = gVar.h(e.d.BOTTOM);
            f fVar2 = this.F;
            z10 = fVar2 != null && fVar2.E[1] == f.b.WRAP_CONTENT;
        }
        if (this.f16579w0 != -1) {
            l.i r10 = eVar.r(this.f16581y0);
            eVar.e(r10, eVar.r(h10), this.f16579w0, 6);
            if (z10) {
                eVar.i(eVar.r(h11), r10, 0, 5);
                return;
            }
            return;
        }
        if (this.f16580x0 == -1) {
            if (this.f16578v0 != -1.0f) {
                eVar.d(l.e.t(eVar, eVar.r(this.f16581y0), eVar.r(h10), eVar.r(h11), this.f16578v0, this.A0));
                return;
            }
            return;
        }
        l.i r11 = eVar.r(this.f16581y0);
        l.i r12 = eVar.r(h11);
        eVar.e(r11, r12, -this.f16580x0, 6);
        if (z10) {
            eVar.i(r11, eVar.r(h10), 0, 5);
            eVar.i(r12, r11, 0, 5);
        }
    }

    @Override // m.f
    public boolean c() {
        return true;
    }

    @Override // m.f
    public void d(int i10) {
        f u10 = u();
        if (u10 == null) {
            return;
        }
        if (I0() == 1) {
            this.f16551v.f().h(1, u10.f16551v.f(), 0);
            this.f16553x.f().h(1, u10.f16551v.f(), 0);
            if (this.f16579w0 != -1) {
                this.f16550u.f().h(1, u10.f16550u.f(), this.f16579w0);
                this.f16552w.f().h(1, u10.f16550u.f(), this.f16579w0);
                return;
            } else if (this.f16580x0 != -1) {
                this.f16550u.f().h(1, u10.f16552w.f(), -this.f16580x0);
                this.f16552w.f().h(1, u10.f16552w.f(), -this.f16580x0);
                return;
            } else {
                if (this.f16578v0 == -1.0f || u10.s() != f.b.FIXED) {
                    return;
                }
                int i11 = (int) (u10.G * this.f16578v0);
                this.f16550u.f().h(1, u10.f16550u.f(), i11);
                this.f16552w.f().h(1, u10.f16550u.f(), i11);
                return;
            }
        }
        this.f16550u.f().h(1, u10.f16550u.f(), 0);
        this.f16552w.f().h(1, u10.f16550u.f(), 0);
        if (this.f16579w0 != -1) {
            this.f16551v.f().h(1, u10.f16551v.f(), this.f16579w0);
            this.f16553x.f().h(1, u10.f16551v.f(), this.f16579w0);
        } else if (this.f16580x0 != -1) {
            this.f16551v.f().h(1, u10.f16553x.f(), -this.f16580x0);
            this.f16553x.f().h(1, u10.f16553x.f(), -this.f16580x0);
        } else {
            if (this.f16578v0 == -1.0f || u10.B() != f.b.FIXED) {
                return;
            }
            int i12 = (int) (u10.H * this.f16578v0);
            this.f16551v.f().h(1, u10.f16551v.f(), i12);
            this.f16553x.f().h(1, u10.f16551v.f(), i12);
        }
    }

    @Override // m.f
    public e h(e.d dVar) {
        switch (a.f16583a[dVar.ordinal()]) {
            case 1:
            case 2:
                if (this.f16582z0 == 1) {
                    return this.f16581y0;
                }
                break;
            case 3:
            case 4:
                if (this.f16582z0 == 0) {
                    return this.f16581y0;
                }
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
        }
        throw new AssertionError(dVar.name());
    }

    @Override // m.f
    public ArrayList i() {
        return this.D;
    }
}
