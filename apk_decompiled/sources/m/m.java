package m;

import com.hpplay.cybergarage.soap.SOAP;
import m.e;

/* loaded from: classes.dex */
public class m extends o {

    /* renamed from: c, reason: collision with root package name */
    public e f16587c;

    /* renamed from: d, reason: collision with root package name */
    public float f16588d;

    /* renamed from: e, reason: collision with root package name */
    public m f16589e;

    /* renamed from: f, reason: collision with root package name */
    public float f16590f;

    /* renamed from: g, reason: collision with root package name */
    public m f16591g;

    /* renamed from: h, reason: collision with root package name */
    public float f16592h;

    /* renamed from: j, reason: collision with root package name */
    public m f16594j;

    /* renamed from: k, reason: collision with root package name */
    public float f16595k;

    /* renamed from: i, reason: collision with root package name */
    public int f16593i = 0;

    /* renamed from: l, reason: collision with root package name */
    public n f16596l = null;

    /* renamed from: m, reason: collision with root package name */
    public int f16597m = 1;

    /* renamed from: n, reason: collision with root package name */
    public n f16598n = null;

    /* renamed from: o, reason: collision with root package name */
    public int f16599o = 1;

    public m(e eVar) {
        this.f16587c = eVar;
    }

    @Override // m.o
    public void e() {
        super.e();
        this.f16589e = null;
        this.f16590f = 0.0f;
        this.f16596l = null;
        this.f16597m = 1;
        this.f16598n = null;
        this.f16599o = 1;
        this.f16591g = null;
        this.f16592h = 0.0f;
        this.f16588d = 0.0f;
        this.f16594j = null;
        this.f16595k = 0.0f;
        this.f16593i = 0;
    }

    @Override // m.o
    public void f() {
        int i10;
        m mVar;
        m mVar2;
        m mVar3;
        m mVar4;
        m mVar5;
        m mVar6;
        float D;
        float f10;
        m mVar7;
        boolean z10 = true;
        if (this.f16602b == 1 || (i10 = this.f16593i) == 4) {
            return;
        }
        n nVar = this.f16596l;
        if (nVar != null) {
            if (nVar.f16602b != 1) {
                return;
            } else {
                this.f16590f = this.f16597m * nVar.f16600c;
            }
        }
        n nVar2 = this.f16598n;
        if (nVar2 != null) {
            if (nVar2.f16602b != 1) {
                return;
            } else {
                this.f16595k = this.f16599o * nVar2.f16600c;
            }
        }
        if (i10 == 1 && ((mVar7 = this.f16589e) == null || mVar7.f16602b == 1)) {
            if (mVar7 == null) {
                this.f16591g = this;
                this.f16592h = this.f16590f;
            } else {
                this.f16591g = mVar7.f16591g;
                this.f16592h = mVar7.f16592h + this.f16590f;
            }
            b();
            return;
        }
        if (i10 != 2 || (mVar4 = this.f16589e) == null || mVar4.f16602b != 1 || (mVar5 = this.f16594j) == null || (mVar6 = mVar5.f16589e) == null || mVar6.f16602b != 1) {
            if (i10 != 3 || (mVar = this.f16589e) == null || mVar.f16602b != 1 || (mVar2 = this.f16594j) == null || (mVar3 = mVar2.f16589e) == null || mVar3.f16602b != 1) {
                if (i10 == 5) {
                    this.f16587c.f16482b.U();
                    return;
                }
                return;
            }
            l.e.x();
            m mVar8 = this.f16589e;
            this.f16591g = mVar8.f16591g;
            m mVar9 = this.f16594j;
            m mVar10 = mVar9.f16589e;
            mVar9.f16591g = mVar10.f16591g;
            this.f16592h = mVar8.f16592h + this.f16590f;
            mVar9.f16592h = mVar10.f16592h + mVar9.f16590f;
            b();
            this.f16594j.b();
            return;
        }
        l.e.x();
        m mVar11 = this.f16589e;
        this.f16591g = mVar11.f16591g;
        m mVar12 = this.f16594j;
        m mVar13 = mVar12.f16589e;
        mVar12.f16591g = mVar13.f16591g;
        e.d dVar = this.f16587c.f16483c;
        e.d dVar2 = e.d.RIGHT;
        int i11 = 0;
        if (dVar != dVar2 && dVar != e.d.BOTTOM) {
            z10 = false;
        }
        float f11 = z10 ? mVar11.f16592h - mVar13.f16592h : mVar13.f16592h - mVar11.f16592h;
        if (dVar == e.d.LEFT || dVar == dVar2) {
            D = f11 - r2.f16482b.D();
            f10 = this.f16587c.f16482b.Z;
        } else {
            D = f11 - r2.f16482b.r();
            f10 = this.f16587c.f16482b.f16511a0;
        }
        int d10 = this.f16587c.d();
        int d11 = this.f16594j.f16587c.d();
        if (this.f16587c.i() == this.f16594j.f16587c.i()) {
            f10 = 0.5f;
            d11 = 0;
        } else {
            i11 = d10;
        }
        float f12 = i11;
        float f13 = d11;
        float f14 = (D - f12) - f13;
        if (z10) {
            m mVar14 = this.f16594j;
            mVar14.f16592h = mVar14.f16589e.f16592h + f13 + (f14 * f10);
            this.f16592h = (this.f16589e.f16592h - f12) - (f14 * (1.0f - f10));
        } else {
            this.f16592h = this.f16589e.f16592h + f12 + (f14 * f10);
            m mVar15 = this.f16594j;
            mVar15.f16592h = (mVar15.f16589e.f16592h - f13) - (f14 * (1.0f - f10));
        }
        b();
        this.f16594j.b();
    }

    public void g(l.e eVar) {
        l.i g10 = this.f16587c.g();
        m mVar = this.f16591g;
        if (mVar == null) {
            eVar.f(g10, (int) (this.f16592h + 0.5f));
        } else {
            eVar.e(g10, eVar.r(mVar.f16587c), (int) (this.f16592h + 0.5f), 6);
        }
    }

    public void h(int i10, m mVar, int i11) {
        this.f16593i = i10;
        this.f16589e = mVar;
        this.f16590f = i11;
        mVar.a(this);
    }

    public void i(m mVar, int i10) {
        this.f16589e = mVar;
        this.f16590f = i10;
        mVar.a(this);
    }

    public void j(m mVar, int i10, n nVar) {
        this.f16589e = mVar;
        mVar.a(this);
        this.f16596l = nVar;
        this.f16597m = i10;
        nVar.a(this);
    }

    public float k() {
        return this.f16592h;
    }

    public void l(m mVar, float f10) {
        int i10 = this.f16602b;
        if (i10 == 0 || !(this.f16591g == mVar || this.f16592h == f10)) {
            this.f16591g = mVar;
            this.f16592h = f10;
            if (i10 == 1) {
                c();
            }
            b();
        }
    }

    public String m(int i10) {
        return i10 == 1 ? "DIRECT" : i10 == 2 ? "CENTER" : i10 == 3 ? "MATCH" : i10 == 4 ? "CHAIN" : i10 == 5 ? "BARRIER" : "UNCONNECTED";
    }

    public void n(m mVar, float f10) {
        this.f16594j = mVar;
        this.f16595k = f10;
    }

    public void o(m mVar, int i10, n nVar) {
        this.f16594j = mVar;
        this.f16598n = nVar;
        this.f16599o = i10;
    }

    public void p(int i10) {
        this.f16593i = i10;
    }

    public void q() {
        e i10 = this.f16587c.i();
        if (i10 == null) {
            return;
        }
        if (i10.i() == this.f16587c) {
            this.f16593i = 4;
            i10.f().f16593i = 4;
        }
        int d10 = this.f16587c.d();
        e.d dVar = this.f16587c.f16483c;
        if (dVar == e.d.RIGHT || dVar == e.d.BOTTOM) {
            d10 = -d10;
        }
        i(i10.f(), d10);
    }

    public String toString() {
        if (this.f16602b != 1) {
            return "{ " + this.f16587c + " UNRESOLVED} type: " + m(this.f16593i);
        }
        if (this.f16591g == this) {
            return "[" + this.f16587c + ", RESOLVED: " + this.f16592h + "]  type: " + m(this.f16593i);
        }
        return "[" + this.f16587c + ", RESOLVED: " + this.f16591g + SOAP.DELIM + this.f16592h + "] type: " + m(this.f16593i);
    }
}
