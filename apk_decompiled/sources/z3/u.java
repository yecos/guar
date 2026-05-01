package z3;

import c3.k;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import z3.o;

/* loaded from: classes.dex */
public class u extends d3.c {

    /* renamed from: o, reason: collision with root package name */
    public c3.o f20216o;

    /* renamed from: p, reason: collision with root package name */
    public o f20217p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f20218q;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20219a;

        static {
            int[] iArr = new int[c3.n.values().length];
            f20219a = iArr;
            try {
                iArr[c3.n.START_OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20219a[c3.n.START_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20219a[c3.n.END_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20219a[c3.n.END_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f20219a[c3.n.FIELD_NAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f20219a[c3.n.VALUE_STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f20219a[c3.n.VALUE_NUMBER_INT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f20219a[c3.n.VALUE_NUMBER_FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f20219a[c3.n.VALUE_EMBEDDED_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public u(k3.m mVar, c3.o oVar) {
        super(0);
        this.f20216o = oVar;
        this.f20217p = new o.c(mVar, null);
    }

    @Override // d3.c, c3.k
    public c3.k D0() {
        c3.n nVar = this.f12503c;
        if (nVar == c3.n.START_OBJECT) {
            this.f20217p = this.f20217p.l();
            this.f12503c = c3.n.END_OBJECT;
        } else if (nVar == c3.n.START_ARRAY) {
            this.f20217p = this.f20217p.l();
            this.f12503c = c3.n.END_ARRAY;
        }
        return this;
    }

    @Override // d3.c, c3.k
    public String E() {
        o oVar = this.f20217p;
        c3.n nVar = this.f12503c;
        if (nVar == c3.n.START_OBJECT || nVar == c3.n.START_ARRAY) {
            oVar = oVar.l();
        }
        if (oVar == null) {
            return null;
        }
        return oVar.b();
    }

    @Override // d3.c
    public void H0() {
        U0();
    }

    @Override // c3.k
    public BigDecimal L() {
        return j1().j();
    }

    @Override // c3.k
    public double M() {
        return j1().k();
    }

    @Override // c3.k
    public Object N() {
        k3.m i12;
        if (this.f20218q || (i12 = i1()) == null) {
            return null;
        }
        if (i12.s()) {
            return ((s) i12).w();
        }
        if (i12.q()) {
            return ((d) i12).i();
        }
        return null;
    }

    @Override // c3.k
    public float O() {
        return (float) j1().k();
    }

    @Override // c3.k
    public int P() {
        q qVar = (q) j1();
        if (!qVar.v()) {
            b1();
        }
        return qVar.x();
    }

    @Override // c3.k
    public long Q() {
        q qVar = (q) j1();
        if (!qVar.w()) {
            e1();
        }
        return qVar.z();
    }

    @Override // c3.k
    public k.b R() {
        k3.m j12 = j1();
        if (j12 == null) {
            return null;
        }
        return j12.a();
    }

    @Override // c3.k
    public Number S() {
        return j1().t();
    }

    @Override // c3.k
    public c3.m V() {
        return this.f20217p;
    }

    @Override // c3.k
    public j3.i W() {
        return c3.k.f5455b;
    }

    @Override // d3.c, c3.k
    public String Y() {
        if (this.f20218q) {
            return null;
        }
        switch (a.f20219a[this.f12503c.ordinal()]) {
            case 5:
                return this.f20217p.b();
            case 6:
                return i1().u();
            case 7:
            case 8:
                return String.valueOf(i1().t());
            case 9:
                k3.m i12 = i1();
                if (i12 != null && i12.q()) {
                    return i12.g();
                }
                break;
        }
        c3.n nVar = this.f12503c;
        if (nVar == null) {
            return null;
        }
        return nVar.b();
    }

    @Override // c3.k
    public char[] Z() {
        return Y().toCharArray();
    }

    @Override // c3.k
    public int a0() {
        return Y().length();
    }

    @Override // c3.k
    public int b0() {
        return 0;
    }

    @Override // c3.k
    public c3.i c0() {
        return c3.i.f5449f;
    }

    @Override // c3.k, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f20218q) {
            return;
        }
        this.f20218q = true;
        this.f20217p = null;
        this.f12503c = null;
    }

    @Override // c3.k
    public boolean i0() {
        return false;
    }

    public k3.m i1() {
        o oVar;
        if (this.f20218q || (oVar = this.f20217p) == null) {
            return null;
        }
        return oVar.k();
    }

    public k3.m j1() {
        k3.m i12 = i1();
        if (i12 != null && i12.r()) {
            return i12;
        }
        throw b("Current token (" + (i12 == null ? null : i12.b()) + ") not numeric, cannot use numeric value accessors");
    }

    @Override // c3.k
    public boolean p0() {
        if (this.f20218q) {
            return false;
        }
        k3.m i12 = i1();
        if (i12 instanceof q) {
            return ((q) i12).y();
        }
        return false;
    }

    @Override // c3.k
    public BigInteger s() {
        return j1().h();
    }

    @Override // d3.c, c3.k
    public c3.n s0() {
        c3.n m10 = this.f20217p.m();
        this.f12503c = m10;
        if (m10 == null) {
            this.f20218q = true;
            return null;
        }
        int i10 = a.f20219a[m10.ordinal()];
        if (i10 == 1) {
            this.f20217p = this.f20217p.o();
        } else if (i10 == 2) {
            this.f20217p = this.f20217p.n();
        } else if (i10 == 3 || i10 == 4) {
            this.f20217p = this.f20217p.l();
        }
        return this.f12503c;
    }

    @Override // c3.k
    public byte[] v(c3.a aVar) {
        k3.m i12 = i1();
        if (i12 != null) {
            return i12 instanceof t ? ((t) i12).v(aVar) : i12.i();
        }
        return null;
    }

    @Override // c3.k
    public int w0(c3.a aVar, OutputStream outputStream) {
        byte[] v10 = v(aVar);
        if (v10 == null) {
            return 0;
        }
        outputStream.write(v10, 0, v10.length);
        return v10.length;
    }

    @Override // c3.k
    public c3.o y() {
        return this.f20216o;
    }

    @Override // c3.k
    public c3.i z() {
        return c3.i.f5449f;
    }
}
