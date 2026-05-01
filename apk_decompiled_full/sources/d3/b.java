package d3;

import c3.k;
import c3.n;
import com.hpplay.sdk.source.mdns.xbill.dns.TTL;
import f3.f;
import j3.i;
import j3.o;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes.dex */
public abstract class b extends c {
    public static final i Q = k.f5455b;
    public final o A;
    public char[] B;
    public boolean C;
    public j3.c D;
    public byte[] E;
    public int F;
    public int G;
    public long H;
    public double I;
    public BigInteger J;
    public BigDecimal K;
    public boolean L;
    public int M;
    public int N;
    public int O;

    /* renamed from: o, reason: collision with root package name */
    public final f3.c f12481o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f12482p;

    /* renamed from: q, reason: collision with root package name */
    public int f12483q;

    /* renamed from: r, reason: collision with root package name */
    public int f12484r;

    /* renamed from: s, reason: collision with root package name */
    public long f12485s;

    /* renamed from: t, reason: collision with root package name */
    public int f12486t;

    /* renamed from: u, reason: collision with root package name */
    public int f12487u;

    /* renamed from: v, reason: collision with root package name */
    public long f12488v;

    /* renamed from: w, reason: collision with root package name */
    public int f12489w;

    /* renamed from: x, reason: collision with root package name */
    public int f12490x;

    /* renamed from: y, reason: collision with root package name */
    public g3.c f12491y;

    /* renamed from: z, reason: collision with root package name */
    public n f12492z;

    public b(f3.c cVar, int i10) {
        super(i10);
        this.f12486t = 1;
        this.f12489w = 1;
        this.F = 0;
        this.f12481o = cVar;
        this.A = cVar.i();
        this.f12491y = g3.c.o(k.a.STRICT_DUPLICATE_DETECTION.c(i10) ? g3.a.f(this) : null);
    }

    @Override // c3.k
    public void A0(Object obj) {
        this.f12491y.i(obj);
    }

    public String A1() {
        return l0(k.a.ALLOW_NON_NUMERIC_NUMBERS) ? "(JSON String, Number (or 'NaN'/'INF'/'+INF'), Array, Object or token 'null', 'true' or 'false')" : "(JSON String, Number, Array, Object or token 'null', 'true' or 'false')";
    }

    @Override // c3.k
    public k B0(int i10) {
        int i11 = this.f5456a ^ i10;
        if (i11 != 0) {
            this.f5456a = i10;
            i1(i10, i11);
        }
        return this;
    }

    public void B1() {
        int i10 = this.F;
        if ((i10 & 8) != 0) {
            this.K = f.f(Y());
        } else if ((i10 & 4) != 0) {
            this.K = new BigDecimal(this.J);
        } else if ((i10 & 2) != 0) {
            this.K = BigDecimal.valueOf(this.H);
        } else if ((i10 & 1) != 0) {
            this.K = BigDecimal.valueOf(this.G);
        } else {
            U0();
        }
        this.F |= 16;
    }

    public void C1() {
        int i10 = this.F;
        if ((i10 & 16) != 0) {
            this.J = this.K.toBigInteger();
        } else if ((i10 & 2) != 0) {
            this.J = BigInteger.valueOf(this.H);
        } else if ((i10 & 1) != 0) {
            this.J = BigInteger.valueOf(this.G);
        } else if ((i10 & 8) != 0) {
            this.J = BigDecimal.valueOf(this.I).toBigInteger();
        } else {
            U0();
        }
        this.F |= 4;
    }

    public void D1() {
        int i10 = this.F;
        if ((i10 & 16) != 0) {
            this.I = this.K.doubleValue();
        } else if ((i10 & 4) != 0) {
            this.I = this.J.doubleValue();
        } else if ((i10 & 2) != 0) {
            this.I = this.H;
        } else if ((i10 & 1) != 0) {
            this.I = this.G;
        } else {
            U0();
        }
        this.F |= 8;
    }

    @Override // d3.c, c3.k
    public String E() {
        g3.c e10;
        n nVar = this.f12503c;
        return ((nVar == n.START_OBJECT || nVar == n.START_ARRAY) && (e10 = this.f12491y.e()) != null) ? e10.b() : this.f12491y.b();
    }

    public void E1() {
        int i10 = this.F;
        if ((i10 & 2) != 0) {
            long j10 = this.H;
            int i11 = (int) j10;
            if (i11 != j10) {
                d1(Y(), n());
            }
            this.G = i11;
        } else if ((i10 & 4) != 0) {
            if (c.f12495g.compareTo(this.J) > 0 || c.f12496h.compareTo(this.J) < 0) {
                b1();
            }
            this.G = this.J.intValue();
        } else if ((i10 & 8) != 0) {
            double d10 = this.I;
            if (d10 < -2.147483648E9d || d10 > 2.147483647E9d) {
                b1();
            }
            this.G = (int) this.I;
        } else if ((i10 & 16) != 0) {
            if (c.f12501m.compareTo(this.K) > 0 || c.f12502n.compareTo(this.K) < 0) {
                b1();
            }
            this.G = this.K.intValue();
        } else {
            U0();
        }
        this.F |= 1;
    }

    public void F1() {
        int i10 = this.F;
        if ((i10 & 1) != 0) {
            this.H = this.G;
        } else if ((i10 & 4) != 0) {
            if (c.f12497i.compareTo(this.J) > 0 || c.f12498j.compareTo(this.J) < 0) {
                e1();
            }
            this.H = this.J.longValue();
        } else if ((i10 & 8) != 0) {
            double d10 = this.I;
            if (d10 < -9.223372036854776E18d || d10 > 9.223372036854776E18d) {
                e1();
            }
            this.H = (long) this.I;
        } else if ((i10 & 16) != 0) {
            if (c.f12499k.compareTo(this.K) > 0 || c.f12500l.compareTo(this.K) < 0) {
                e1();
            }
            this.H = this.K.longValue();
        } else {
            U0();
        }
        this.F |= 2;
    }

    @Override // c3.k
    /* renamed from: G1, reason: merged with bridge method [inline-methods] */
    public g3.c V() {
        return this.f12491y;
    }

    @Override // d3.c
    public void H0() {
        if (this.f12491y.h()) {
            return;
        }
        Q0(String.format(": expected close marker for %s (start marker at %s)", this.f12491y.f() ? "Array" : "Object", this.f12491y.s(o1())), null);
    }

    public IllegalArgumentException H1(c3.a aVar, int i10, int i11) {
        return I1(aVar, i10, i11, null);
    }

    public IllegalArgumentException I1(c3.a aVar, int i10, int i11, String str) {
        String str2;
        if (i10 <= 32) {
            str2 = String.format("Illegal white space character (code 0x%s) as character #%d of 4-char base64 unit: can only used between units", Integer.toHexString(i10), Integer.valueOf(i11 + 1));
        } else if (aVar.x(i10)) {
            str2 = "Unexpected padding character ('" + aVar.r() + "') as character #" + (i11 + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
        } else if (!Character.isDefined(i10) || Character.isISOControl(i10)) {
            str2 = "Illegal character (code 0x" + Integer.toHexString(i10) + ") in base64 content";
        } else {
            str2 = "Illegal character '" + ((char) i10) + "' (code 0x" + Integer.toHexString(i10) + ") in base64 content";
        }
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        return new IllegalArgumentException(str2);
    }

    public final n J1(boolean z10, int i10, int i11, int i12) {
        return (i11 >= 1 || i12 >= 1) ? L1(z10, i10, i11, i12) : M1(z10, i10);
    }

    public final n K1(String str, double d10) {
        this.A.x(str);
        this.I = d10;
        this.F = 8;
        return n.VALUE_NUMBER_FLOAT;
    }

    @Override // c3.k
    public BigDecimal L() {
        int i10 = this.F;
        if ((i10 & 16) == 0) {
            if (i10 == 0) {
                s1(16);
            }
            if ((this.F & 16) == 0) {
                B1();
            }
        }
        return this.K;
    }

    public final n L1(boolean z10, int i10, int i11, int i12) {
        this.L = z10;
        this.M = i10;
        this.N = i11;
        this.O = i12;
        this.F = 0;
        return n.VALUE_NUMBER_FLOAT;
    }

    @Override // c3.k
    public double M() {
        int i10 = this.F;
        if ((i10 & 8) == 0) {
            if (i10 == 0) {
                s1(8);
            }
            if ((this.F & 8) == 0) {
                D1();
            }
        }
        return this.I;
    }

    public final n M1(boolean z10, int i10) {
        this.L = z10;
        this.M = i10;
        this.N = 0;
        this.O = 0;
        this.F = 0;
        return n.VALUE_NUMBER_INT;
    }

    @Override // c3.k
    public float O() {
        return (float) M();
    }

    @Override // c3.k
    public int P() {
        int i10 = this.F;
        if ((i10 & 1) == 0) {
            if (i10 == 0) {
                return r1();
            }
            if ((i10 & 1) == 0) {
                E1();
            }
        }
        return this.G;
    }

    @Override // c3.k
    public long Q() {
        int i10 = this.F;
        if ((i10 & 2) == 0) {
            if (i10 == 0) {
                s1(2);
            }
            if ((this.F & 2) == 0) {
                F1();
            }
        }
        return this.H;
    }

    @Override // c3.k
    public k.b R() {
        if (this.F == 0) {
            s1(0);
        }
        if (this.f12503c != n.VALUE_NUMBER_INT) {
            return (this.F & 16) != 0 ? k.b.BIG_DECIMAL : k.b.DOUBLE;
        }
        int i10 = this.F;
        return (i10 & 1) != 0 ? k.b.INT : (i10 & 2) != 0 ? k.b.LONG : k.b.BIG_INTEGER;
    }

    @Override // c3.k
    public Number S() {
        if (this.F == 0) {
            s1(0);
        }
        if (this.f12503c == n.VALUE_NUMBER_INT) {
            int i10 = this.F;
            if ((i10 & 1) != 0) {
                return Integer.valueOf(this.G);
            }
            if ((i10 & 2) != 0) {
                return Long.valueOf(this.H);
            }
            if ((i10 & 4) != 0) {
                return this.J;
            }
            U0();
        }
        int i11 = this.F;
        if ((i11 & 16) != 0) {
            return this.K;
        }
        if ((i11 & 8) == 0) {
            U0();
        }
        return Double.valueOf(this.I);
    }

    @Override // c3.k
    public Number T() {
        if (this.f12503c == n.VALUE_NUMBER_INT) {
            if (this.F == 0) {
                s1(0);
            }
            int i10 = this.F;
            if ((i10 & 1) != 0) {
                return Integer.valueOf(this.G);
            }
            if ((i10 & 2) != 0) {
                return Long.valueOf(this.H);
            }
            if ((i10 & 4) != 0) {
                return this.J;
            }
            U0();
        }
        if (this.F == 0) {
            s1(16);
        }
        int i11 = this.F;
        if ((i11 & 16) != 0) {
            return this.K;
        }
        if ((i11 & 8) == 0) {
            U0();
        }
        return Double.valueOf(this.I);
    }

    @Override // c3.k, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f12482p) {
            return;
        }
        this.f12483q = Math.max(this.f12483q, this.f12484r);
        this.f12482p = true;
        try {
            j1();
        } finally {
            v1();
        }
    }

    @Override // c3.k
    public boolean i0() {
        n nVar = this.f12503c;
        if (nVar == n.VALUE_STRING) {
            return true;
        }
        if (nVar == n.FIELD_NAME) {
            return this.C;
        }
        return false;
    }

    public void i1(int i10, int i11) {
        int d10 = k.a.STRICT_DUPLICATE_DETECTION.d();
        if ((i11 & d10) == 0 || (i10 & d10) == 0) {
            return;
        }
        if (this.f12491y.q() == null) {
            this.f12491y = this.f12491y.v(g3.a.f(this));
        } else {
            this.f12491y = this.f12491y.v(null);
        }
    }

    public abstract void j1();

    public final int k1(c3.a aVar, char c10, int i10) {
        if (c10 != '\\') {
            throw H1(aVar, c10, i10);
        }
        char l12 = l1();
        if (l12 <= ' ' && i10 == 0) {
            return -1;
        }
        int g10 = aVar.g(l12);
        if (g10 >= 0 || (g10 == -2 && i10 >= 2)) {
            return g10;
        }
        throw H1(aVar, l12, i10);
    }

    public abstract char l1();

    public final int m1() {
        H0();
        return -1;
    }

    public j3.c n1() {
        j3.c cVar = this.D;
        if (cVar == null) {
            this.D = new j3.c();
        } else {
            cVar.reset();
        }
        return this.D;
    }

    public Object o1() {
        if (k.a.INCLUDE_SOURCE_IN_LOCATION.c(this.f5456a)) {
            return this.f12481o.j();
        }
        return null;
    }

    @Override // c3.k
    public boolean p0() {
        if (this.f12503c != n.VALUE_NUMBER_FLOAT || (this.F & 8) == 0) {
            return false;
        }
        double d10 = this.I;
        return Double.isNaN(d10) || Double.isInfinite(d10);
    }

    public void p1(c3.a aVar) {
        L0(aVar.s());
    }

    public char q1(char c10) {
        if (l0(k.a.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER)) {
            return c10;
        }
        if (c10 == '\'' && l0(k.a.ALLOW_SINGLE_QUOTES)) {
            return c10;
        }
        L0("Unrecognized character escape " + c.G0(c10));
        return c10;
    }

    public int r1() {
        if (this.f12482p) {
            L0("Internal error: _parseNumericValue called when parser instance closed");
        }
        if (this.f12503c != n.VALUE_NUMBER_INT || this.M > 9) {
            s1(1);
            if ((this.F & 1) == 0) {
                E1();
            }
            return this.G;
        }
        int j10 = this.A.j(this.L);
        this.G = j10;
        this.F = 1;
        return j10;
    }

    @Override // c3.k
    public BigInteger s() {
        int i10 = this.F;
        if ((i10 & 4) == 0) {
            if (i10 == 0) {
                s1(4);
            }
            if ((this.F & 4) == 0) {
                C1();
            }
        }
        return this.J;
    }

    public void s1(int i10) {
        if (this.f12482p) {
            L0("Internal error: _parseNumericValue called when parser instance closed");
        }
        n nVar = this.f12503c;
        if (nVar != n.VALUE_NUMBER_INT) {
            if (nVar == n.VALUE_NUMBER_FLOAT) {
                t1(i10);
                return;
            } else {
                M0("Current token (%s) not numeric, can not use numeric value accessors", nVar);
                return;
            }
        }
        int i11 = this.M;
        if (i11 <= 9) {
            this.G = this.A.j(this.L);
            this.F = 1;
            return;
        }
        if (i11 > 18) {
            u1(i10);
            return;
        }
        long k10 = this.A.k(this.L);
        if (i11 == 10) {
            if (this.L) {
                if (k10 >= -2147483648L) {
                    this.G = (int) k10;
                    this.F = 1;
                    return;
                }
            } else if (k10 <= TTL.MAX_VALUE) {
                this.G = (int) k10;
                this.F = 1;
                return;
            }
        }
        this.H = k10;
        this.F = 2;
    }

    public final void t1(int i10) {
        try {
            if (i10 == 16) {
                this.K = this.A.h();
                this.F = 16;
            } else {
                this.I = this.A.i();
                this.F = 8;
            }
        } catch (NumberFormatException e10) {
            W0("Malformed numeric value (" + K0(this.A.l()) + ")", e10);
        }
    }

    public final void u1(int i10) {
        String l10 = this.A.l();
        try {
            int i11 = this.M;
            char[] s10 = this.A.s();
            int t10 = this.A.t();
            boolean z10 = this.L;
            if (z10) {
                t10++;
            }
            if (f.c(s10, t10, i11, z10)) {
                this.H = Long.parseLong(l10);
                this.F = 2;
                return;
            }
            if (i10 == 1 || i10 == 2) {
                x1(i10, l10);
            }
            if (i10 != 8 && i10 != 32) {
                this.J = new BigInteger(l10);
                this.F = 4;
                return;
            }
            this.I = f.i(l10);
            this.F = 8;
        } catch (NumberFormatException e10) {
            W0("Malformed numeric value (" + K0(l10) + ")", e10);
        }
    }

    @Override // c3.k
    public k v0(int i10, int i11) {
        int i12 = this.f5456a;
        int i13 = (i10 & i11) | ((i11 ^ (-1)) & i12);
        int i14 = i12 ^ i13;
        if (i14 != 0) {
            this.f5456a = i13;
            i1(i13, i14);
        }
        return this;
    }

    public void v1() {
        this.A.u();
        char[] cArr = this.B;
        if (cArr != null) {
            this.B = null;
            this.f12481o.n(cArr);
        }
    }

    public void w1(int i10, char c10) {
        g3.c V = V();
        L0(String.format("Unexpected close marker '%s': expected '%c' (for %s starting at %s)", Character.valueOf((char) i10), Character.valueOf(c10), V.j(), V.s(o1())));
    }

    public void x1(int i10, String str) {
        if (i10 == 1) {
            c1(str);
        } else {
            f1(str);
        }
    }

    public void y1(int i10, String str) {
        if (!l0(k.a.ALLOW_UNQUOTED_CONTROL_CHARS) || i10 > 32) {
            L0("Illegal unquoted character (" + c.G0((char) i10) + "): has to be escaped using backslash to be included in " + str);
        }
    }

    public String z1() {
        return A1();
    }
}
