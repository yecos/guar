package d4;

import c3.h;
import c3.k;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class y extends c3.h {

    /* renamed from: t, reason: collision with root package name */
    public static final int f12598t = h.b.a();

    /* renamed from: e, reason: collision with root package name */
    public c3.o f12599e;

    /* renamed from: f, reason: collision with root package name */
    public c3.m f12600f;

    /* renamed from: g, reason: collision with root package name */
    public int f12601g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f12602h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f12603i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f12604j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f12605k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f12606l;

    /* renamed from: m, reason: collision with root package name */
    public c f12607m;

    /* renamed from: n, reason: collision with root package name */
    public c f12608n;

    /* renamed from: o, reason: collision with root package name */
    public int f12609o;

    /* renamed from: p, reason: collision with root package name */
    public Object f12610p;

    /* renamed from: q, reason: collision with root package name */
    public Object f12611q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f12612r;

    /* renamed from: s, reason: collision with root package name */
    public g3.e f12613s;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12614a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f12615b;

        static {
            int[] iArr = new int[k.b.values().length];
            f12615b = iArr;
            try {
                iArr[k.b.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12615b[k.b.BIG_INTEGER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12615b[k.b.BIG_DECIMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12615b[k.b.FLOAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12615b[k.b.LONG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[c3.n.values().length];
            f12614a = iArr2;
            try {
                iArr2[c3.n.START_OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12614a[c3.n.END_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f12614a[c3.n.START_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f12614a[c3.n.END_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f12614a[c3.n.FIELD_NAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f12614a[c3.n.VALUE_STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f12614a[c3.n.VALUE_NUMBER_INT.ordinal()] = 7;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f12614a[c3.n.VALUE_NUMBER_FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f12614a[c3.n.VALUE_TRUE.ordinal()] = 9;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f12614a[c3.n.VALUE_FALSE.ordinal()] = 10;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f12614a[c3.n.VALUE_NULL.ordinal()] = 11;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f12614a[c3.n.VALUE_EMBEDDED_OBJECT.ordinal()] = 12;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public static final class b extends d3.c {

        /* renamed from: o, reason: collision with root package name */
        public c3.o f12616o;

        /* renamed from: p, reason: collision with root package name */
        public final boolean f12617p;

        /* renamed from: q, reason: collision with root package name */
        public final boolean f12618q;

        /* renamed from: r, reason: collision with root package name */
        public final boolean f12619r;

        /* renamed from: s, reason: collision with root package name */
        public c f12620s;

        /* renamed from: t, reason: collision with root package name */
        public int f12621t;

        /* renamed from: u, reason: collision with root package name */
        public z f12622u;

        /* renamed from: v, reason: collision with root package name */
        public boolean f12623v;

        /* renamed from: w, reason: collision with root package name */
        public transient j3.c f12624w;

        /* renamed from: x, reason: collision with root package name */
        public c3.i f12625x;

        public b(c cVar, c3.o oVar, boolean z10, boolean z11, c3.m mVar) {
            super(0);
            this.f12625x = null;
            this.f12620s = cVar;
            this.f12621t = -1;
            this.f12616o = oVar;
            this.f12622u = z.m(mVar);
            this.f12617p = z10;
            this.f12618q = z11;
            this.f12619r = z10 || z11;
        }

        @Override // d3.c, c3.k
        public String E() {
            return m();
        }

        @Override // d3.c
        public void H0() {
            U0();
        }

        @Override // c3.k
        public BigDecimal L() {
            Number S = S();
            if (S instanceof BigDecimal) {
                return (BigDecimal) S;
            }
            int i10 = a.f12615b[R().ordinal()];
            if (i10 != 1) {
                if (i10 == 2) {
                    return new BigDecimal((BigInteger) S);
                }
                if (i10 != 5) {
                    return BigDecimal.valueOf(S.doubleValue());
                }
            }
            return BigDecimal.valueOf(S.longValue());
        }

        @Override // c3.k
        public double M() {
            return S().doubleValue();
        }

        @Override // c3.k
        public Object N() {
            if (this.f12503c == c3.n.VALUE_EMBEDDED_OBJECT) {
                return l1();
            }
            return null;
        }

        @Override // c3.k
        public float O() {
            return S().floatValue();
        }

        @Override // c3.k
        public int P() {
            Number S = this.f12503c == c3.n.VALUE_NUMBER_INT ? (Number) l1() : S();
            return ((S instanceof Integer) || m1(S)) ? S.intValue() : j1(S);
        }

        @Override // c3.k
        public long Q() {
            Number S = this.f12503c == c3.n.VALUE_NUMBER_INT ? (Number) l1() : S();
            return ((S instanceof Long) || n1(S)) ? S.longValue() : k1(S);
        }

        @Override // c3.k
        public k.b R() {
            Number S = S();
            if (S instanceof Integer) {
                return k.b.INT;
            }
            if (S instanceof Long) {
                return k.b.LONG;
            }
            if (S instanceof Double) {
                return k.b.DOUBLE;
            }
            if (S instanceof BigDecimal) {
                return k.b.BIG_DECIMAL;
            }
            if (S instanceof BigInteger) {
                return k.b.BIG_INTEGER;
            }
            if (S instanceof Float) {
                return k.b.FLOAT;
            }
            if (S instanceof Short) {
                return k.b.INT;
            }
            return null;
        }

        @Override // c3.k
        public final Number S() {
            i1();
            Object l12 = l1();
            if (l12 instanceof Number) {
                return (Number) l12;
            }
            if (l12 instanceof String) {
                String str = (String) l12;
                return str.indexOf(46) >= 0 ? Double.valueOf(Double.parseDouble(str)) : Long.valueOf(Long.parseLong(str));
            }
            if (l12 == null) {
                return null;
            }
            throw new IllegalStateException("Internal error: entry should be a Number, but is of type " + l12.getClass().getName());
        }

        @Override // c3.k
        public Object U() {
            return this.f12620s.h(this.f12621t);
        }

        @Override // c3.k
        public c3.m V() {
            return this.f12622u;
        }

        @Override // c3.k
        public j3.i W() {
            return c3.k.f5455b;
        }

        @Override // d3.c, c3.k
        public String Y() {
            c3.n nVar = this.f12503c;
            if (nVar == c3.n.VALUE_STRING || nVar == c3.n.FIELD_NAME) {
                Object l12 = l1();
                return l12 instanceof String ? (String) l12 : h.a0(l12);
            }
            if (nVar == null) {
                return null;
            }
            int i10 = a.f12614a[nVar.ordinal()];
            return (i10 == 7 || i10 == 8) ? h.a0(l1()) : this.f12503c.b();
        }

        @Override // c3.k
        public char[] Z() {
            String Y = Y();
            if (Y == null) {
                return null;
            }
            return Y.toCharArray();
        }

        @Override // c3.k
        public int a0() {
            String Y = Y();
            if (Y == null) {
                return 0;
            }
            return Y.length();
        }

        @Override // c3.k
        public int b0() {
            return 0;
        }

        @Override // c3.k
        public boolean c() {
            return this.f12618q;
        }

        @Override // c3.k
        public c3.i c0() {
            return z();
        }

        @Override // c3.k, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f12623v) {
                return;
            }
            this.f12623v = true;
        }

        @Override // c3.k
        public Object d0() {
            return this.f12620s.i(this.f12621t);
        }

        @Override // c3.k
        public boolean e() {
            return this.f12617p;
        }

        @Override // c3.k
        public boolean i0() {
            return false;
        }

        public final void i1() {
            c3.n nVar = this.f12503c;
            if (nVar == null || !nVar.d()) {
                throw b("Current token (" + this.f12503c + ") not numeric, cannot use numeric value accessors");
            }
        }

        public int j1(Number number) {
            if (number instanceof Long) {
                long longValue = number.longValue();
                int i10 = (int) longValue;
                if (i10 != longValue) {
                    b1();
                }
                return i10;
            }
            if (number instanceof BigInteger) {
                BigInteger bigInteger = (BigInteger) number;
                if (d3.c.f12495g.compareTo(bigInteger) > 0 || d3.c.f12496h.compareTo(bigInteger) < 0) {
                    b1();
                }
            } else {
                if ((number instanceof Double) || (number instanceof Float)) {
                    double doubleValue = number.doubleValue();
                    if (doubleValue < -2.147483648E9d || doubleValue > 2.147483647E9d) {
                        b1();
                    }
                    return (int) doubleValue;
                }
                if (number instanceof BigDecimal) {
                    BigDecimal bigDecimal = (BigDecimal) number;
                    if (d3.c.f12501m.compareTo(bigDecimal) > 0 || d3.c.f12502n.compareTo(bigDecimal) < 0) {
                        b1();
                    }
                } else {
                    U0();
                }
            }
            return number.intValue();
        }

        public long k1(Number number) {
            if (number instanceof BigInteger) {
                BigInteger bigInteger = (BigInteger) number;
                if (d3.c.f12497i.compareTo(bigInteger) > 0 || d3.c.f12498j.compareTo(bigInteger) < 0) {
                    e1();
                }
            } else {
                if ((number instanceof Double) || (number instanceof Float)) {
                    double doubleValue = number.doubleValue();
                    if (doubleValue < -9.223372036854776E18d || doubleValue > 9.223372036854776E18d) {
                        e1();
                    }
                    return (long) doubleValue;
                }
                if (number instanceof BigDecimal) {
                    BigDecimal bigDecimal = (BigDecimal) number;
                    if (d3.c.f12499k.compareTo(bigDecimal) > 0 || d3.c.f12500l.compareTo(bigDecimal) < 0) {
                        e1();
                    }
                } else {
                    U0();
                }
            }
            return number.longValue();
        }

        public final Object l1() {
            return this.f12620s.j(this.f12621t);
        }

        @Override // c3.k
        public String m() {
            c3.n nVar = this.f12503c;
            return (nVar == c3.n.START_OBJECT || nVar == c3.n.START_ARRAY) ? this.f12622u.e().b() : this.f12622u.b();
        }

        public final boolean m1(Number number) {
            return (number instanceof Short) || (number instanceof Byte);
        }

        public final boolean n1(Number number) {
            return (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
        }

        public void o1(c3.i iVar) {
            this.f12625x = iVar;
        }

        @Override // c3.k
        public boolean p0() {
            if (this.f12503c != c3.n.VALUE_NUMBER_FLOAT) {
                return false;
            }
            Object l12 = l1();
            if (l12 instanceof Double) {
                Double d10 = (Double) l12;
                return d10.isNaN() || d10.isInfinite();
            }
            if (!(l12 instanceof Float)) {
                return false;
            }
            Float f10 = (Float) l12;
            return f10.isNaN() || f10.isInfinite();
        }

        @Override // c3.k
        public String q0() {
            c cVar;
            if (this.f12623v || (cVar = this.f12620s) == null) {
                return null;
            }
            int i10 = this.f12621t + 1;
            if (i10 < 16) {
                c3.n p10 = cVar.p(i10);
                c3.n nVar = c3.n.FIELD_NAME;
                if (p10 == nVar) {
                    this.f12621t = i10;
                    this.f12503c = nVar;
                    Object j10 = this.f12620s.j(i10);
                    String obj = j10 instanceof String ? (String) j10 : j10.toString();
                    this.f12622u.o(obj);
                    return obj;
                }
            }
            if (s0() == c3.n.FIELD_NAME) {
                return m();
            }
            return null;
        }

        @Override // c3.k
        public BigInteger s() {
            Number S = S();
            return S instanceof BigInteger ? (BigInteger) S : R() == k.b.BIG_DECIMAL ? ((BigDecimal) S).toBigInteger() : BigInteger.valueOf(S.longValue());
        }

        @Override // d3.c, c3.k
        public c3.n s0() {
            c cVar;
            if (this.f12623v || (cVar = this.f12620s) == null) {
                return null;
            }
            int i10 = this.f12621t + 1;
            this.f12621t = i10;
            if (i10 >= 16) {
                this.f12621t = 0;
                c k10 = cVar.k();
                this.f12620s = k10;
                if (k10 == null) {
                    return null;
                }
            }
            c3.n p10 = this.f12620s.p(this.f12621t);
            this.f12503c = p10;
            if (p10 == c3.n.FIELD_NAME) {
                Object l12 = l1();
                this.f12622u.o(l12 instanceof String ? (String) l12 : l12.toString());
            } else if (p10 == c3.n.START_OBJECT) {
                this.f12622u = this.f12622u.l();
            } else if (p10 == c3.n.START_ARRAY) {
                this.f12622u = this.f12622u.k();
            } else if (p10 == c3.n.END_OBJECT || p10 == c3.n.END_ARRAY) {
                this.f12622u = this.f12622u.n();
            } else {
                this.f12622u.p();
            }
            return this.f12503c;
        }

        @Override // c3.k
        public byte[] v(c3.a aVar) {
            if (this.f12503c == c3.n.VALUE_EMBEDDED_OBJECT) {
                Object l12 = l1();
                if (l12 instanceof byte[]) {
                    return (byte[]) l12;
                }
            }
            if (this.f12503c != c3.n.VALUE_STRING) {
                throw b("Current token (" + this.f12503c + ") not VALUE_STRING (or VALUE_EMBEDDED_OBJECT with byte[]), cannot access as binary");
            }
            String Y = Y();
            if (Y == null) {
                return null;
            }
            j3.c cVar = this.f12624w;
            if (cVar == null) {
                cVar = new j3.c(100);
                this.f12624w = cVar;
            } else {
                cVar.reset();
            }
            F0(Y, cVar, aVar);
            return cVar.v();
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
            return this.f12616o;
        }

        @Override // c3.k
        public c3.i z() {
            c3.i iVar = this.f12625x;
            return iVar == null ? c3.i.f5449f : iVar;
        }
    }

    public static final class c {

        /* renamed from: e, reason: collision with root package name */
        public static final c3.n[] f12626e;

        /* renamed from: a, reason: collision with root package name */
        public c f12627a;

        /* renamed from: b, reason: collision with root package name */
        public long f12628b;

        /* renamed from: c, reason: collision with root package name */
        public final Object[] f12629c = new Object[16];

        /* renamed from: d, reason: collision with root package name */
        public TreeMap f12630d;

        static {
            c3.n[] nVarArr = new c3.n[16];
            f12626e = nVarArr;
            c3.n[] values = c3.n.values();
            System.arraycopy(values, 1, nVarArr, 1, Math.min(15, values.length - 1));
        }

        public final int a(int i10) {
            return i10 + i10 + 1;
        }

        public final int b(int i10) {
            return i10 + i10;
        }

        public c c(int i10, c3.n nVar) {
            if (i10 < 16) {
                l(i10, nVar);
                return null;
            }
            c cVar = new c();
            this.f12627a = cVar;
            cVar.l(0, nVar);
            return this.f12627a;
        }

        public c d(int i10, c3.n nVar, Object obj) {
            if (i10 < 16) {
                m(i10, nVar, obj);
                return null;
            }
            c cVar = new c();
            this.f12627a = cVar;
            cVar.m(0, nVar, obj);
            return this.f12627a;
        }

        public c e(int i10, c3.n nVar, Object obj, Object obj2) {
            if (i10 < 16) {
                n(i10, nVar, obj, obj2);
                return null;
            }
            c cVar = new c();
            this.f12627a = cVar;
            cVar.n(0, nVar, obj, obj2);
            return this.f12627a;
        }

        public c f(int i10, c3.n nVar, Object obj, Object obj2, Object obj3) {
            if (i10 < 16) {
                o(i10, nVar, obj, obj2, obj3);
                return null;
            }
            c cVar = new c();
            this.f12627a = cVar;
            cVar.o(0, nVar, obj, obj2, obj3);
            return this.f12627a;
        }

        public final void g(int i10, Object obj, Object obj2) {
            if (this.f12630d == null) {
                this.f12630d = new TreeMap();
            }
            if (obj != null) {
                this.f12630d.put(Integer.valueOf(a(i10)), obj);
            }
            if (obj2 != null) {
                this.f12630d.put(Integer.valueOf(b(i10)), obj2);
            }
        }

        public Object h(int i10) {
            TreeMap treeMap = this.f12630d;
            if (treeMap == null) {
                return null;
            }
            return treeMap.get(Integer.valueOf(a(i10)));
        }

        public Object i(int i10) {
            TreeMap treeMap = this.f12630d;
            if (treeMap == null) {
                return null;
            }
            return treeMap.get(Integer.valueOf(b(i10)));
        }

        public Object j(int i10) {
            return this.f12629c[i10];
        }

        public c k() {
            return this.f12627a;
        }

        public final void l(int i10, c3.n nVar) {
            long ordinal = nVar.ordinal();
            if (i10 > 0) {
                ordinal <<= i10 << 2;
            }
            this.f12628b |= ordinal;
        }

        public final void m(int i10, c3.n nVar, Object obj) {
            this.f12629c[i10] = obj;
            long ordinal = nVar.ordinal();
            if (i10 > 0) {
                ordinal <<= i10 << 2;
            }
            this.f12628b = ordinal | this.f12628b;
        }

        public final void n(int i10, c3.n nVar, Object obj, Object obj2) {
            long ordinal = nVar.ordinal();
            if (i10 > 0) {
                ordinal <<= i10 << 2;
            }
            this.f12628b = ordinal | this.f12628b;
            g(i10, obj, obj2);
        }

        public final void o(int i10, c3.n nVar, Object obj, Object obj2, Object obj3) {
            this.f12629c[i10] = obj;
            long ordinal = nVar.ordinal();
            if (i10 > 0) {
                ordinal <<= i10 << 2;
            }
            this.f12628b = ordinal | this.f12628b;
            g(i10, obj2, obj3);
        }

        public c3.n p(int i10) {
            long j10 = this.f12628b;
            if (i10 > 0) {
                j10 >>= i10 << 2;
            }
            return f12626e[((int) j10) & 15];
        }
    }

    public y(c3.o oVar, boolean z10) {
        this.f12612r = false;
        this.f12599e = oVar;
        this.f12601g = f12598t;
        this.f12613s = g3.e.q(null);
        c cVar = new c();
        this.f12608n = cVar;
        this.f12607m = cVar;
        this.f12609o = 0;
        this.f12603i = z10;
        this.f12604j = z10;
        this.f12605k = z10 || z10;
    }

    public static y Q0(c3.k kVar) {
        y yVar = new y(kVar);
        yVar.V0(kVar);
        return yVar;
    }

    @Override // c3.h
    public void A0(char[] cArr, int i10, int i11) {
        z0(new String(cArr, i10, i11));
    }

    @Override // c3.h
    public void C0(Object obj) {
        this.f12610p = obj;
        this.f12612r = true;
    }

    public final void F0(c3.n nVar) {
        c c10 = this.f12608n.c(this.f12609o, nVar);
        if (c10 == null) {
            this.f12609o++;
        } else {
            this.f12608n = c10;
            this.f12609o = 1;
        }
    }

    public final void G0(Object obj) {
        c f10 = this.f12612r ? this.f12608n.f(this.f12609o, c3.n.FIELD_NAME, obj, this.f12611q, this.f12610p) : this.f12608n.d(this.f12609o, c3.n.FIELD_NAME, obj);
        if (f10 == null) {
            this.f12609o++;
        } else {
            this.f12608n = f10;
            this.f12609o = 1;
        }
    }

    public final void H0(StringBuilder sb) {
        Object h10 = this.f12608n.h(this.f12609o - 1);
        if (h10 != null) {
            sb.append("[objectId=");
            sb.append(String.valueOf(h10));
            sb.append(']');
        }
        Object i10 = this.f12608n.i(this.f12609o - 1);
        if (i10 != null) {
            sb.append("[typeId=");
            sb.append(String.valueOf(i10));
            sb.append(']');
        }
    }

    public final void I0(c3.n nVar) {
        c e10 = this.f12612r ? this.f12608n.e(this.f12609o, nVar, this.f12611q, this.f12610p) : this.f12608n.c(this.f12609o, nVar);
        if (e10 == null) {
            this.f12609o++;
        } else {
            this.f12608n = e10;
            this.f12609o = 1;
        }
    }

    public final void J0(c3.n nVar) {
        this.f12613s.x();
        c e10 = this.f12612r ? this.f12608n.e(this.f12609o, nVar, this.f12611q, this.f12610p) : this.f12608n.c(this.f12609o, nVar);
        if (e10 == null) {
            this.f12609o++;
        } else {
            this.f12608n = e10;
            this.f12609o = 1;
        }
    }

    public final void K0(c3.n nVar, Object obj) {
        this.f12613s.x();
        c f10 = this.f12612r ? this.f12608n.f(this.f12609o, nVar, obj, this.f12611q, this.f12610p) : this.f12608n.d(this.f12609o, nVar, obj);
        if (f10 == null) {
            this.f12609o++;
        } else {
            this.f12608n = f10;
            this.f12609o = 1;
        }
    }

    public final void L0(c3.k kVar) {
        Object d02 = kVar.d0();
        this.f12610p = d02;
        if (d02 != null) {
            this.f12612r = true;
        }
        Object U = kVar.U();
        this.f12611q = U;
        if (U != null) {
            this.f12612r = true;
        }
    }

    public void M0(c3.k kVar) {
        int i10 = 1;
        while (true) {
            c3.n s02 = kVar.s0();
            if (s02 == null) {
                return;
            }
            int i11 = a.f12614a[s02.ordinal()];
            if (i11 == 1) {
                if (this.f12605k) {
                    L0(kVar);
                }
                v0();
            } else if (i11 == 2) {
                W();
                i10--;
                if (i10 == 0) {
                    return;
                }
            } else if (i11 == 3) {
                if (this.f12605k) {
                    L0(kVar);
                }
                s0();
            } else if (i11 == 4) {
                V();
                i10--;
                if (i10 == 0) {
                    return;
                }
            } else if (i11 != 5) {
                N0(kVar, s02);
            } else {
                if (this.f12605k) {
                    L0(kVar);
                }
                Z(kVar.m());
            }
            i10++;
        }
    }

    public final void N0(c3.k kVar, c3.n nVar) {
        if (this.f12605k) {
            L0(kVar);
        }
        switch (a.f12614a[nVar.ordinal()]) {
            case 6:
                if (kVar.i0()) {
                    A0(kVar.Z(), kVar.b0(), kVar.a0());
                    return;
                } else {
                    z0(kVar.Y());
                    return;
                }
            case 7:
                int i10 = a.f12615b[kVar.R().ordinal()];
                if (i10 == 1) {
                    d0(kVar.P());
                    return;
                } else if (i10 != 2) {
                    e0(kVar.Q());
                    return;
                } else {
                    h0(kVar.s());
                    return;
                }
            case 8:
                if (this.f12606l) {
                    g0(kVar.L());
                    return;
                } else {
                    K0(c3.n.VALUE_NUMBER_FLOAT, kVar.T());
                    return;
                }
            case 9:
                U(true);
                return;
            case 10:
                U(false);
                return;
            case 11:
                a0();
                return;
            case 12:
                a1(kVar.N());
                return;
            default:
                throw new RuntimeException("Internal error: unexpected token: " + nVar);
        }
    }

    public void O0() {
        throw new UnsupportedOperationException("Called operation not supported for TokenBuffer");
    }

    @Override // c3.h
    public int P(c3.a aVar, InputStream inputStream, int i10) {
        throw new UnsupportedOperationException();
    }

    public y P0(y yVar) {
        if (!this.f12603i) {
            this.f12603i = yVar.n();
        }
        if (!this.f12604j) {
            this.f12604j = yVar.m();
        }
        this.f12605k = this.f12603i || this.f12604j;
        c3.k R0 = yVar.R0();
        while (R0.s0() != null) {
            V0(R0);
        }
        return this;
    }

    @Override // c3.h
    public void R(c3.a aVar, byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        a1(bArr2);
    }

    public c3.k R0() {
        return T0(this.f12599e);
    }

    public c3.k S0(c3.k kVar) {
        b bVar = new b(this.f12607m, kVar.y(), this.f12603i, this.f12604j, this.f12600f);
        bVar.o1(kVar.c0());
        return bVar;
    }

    public c3.k T0(c3.o oVar) {
        return new b(this.f12607m, oVar, this.f12603i, this.f12604j, this.f12600f);
    }

    @Override // c3.h
    public void U(boolean z10) {
        J0(z10 ? c3.n.VALUE_TRUE : c3.n.VALUE_FALSE);
    }

    public c3.k U0() {
        c3.k T0 = T0(this.f12599e);
        T0.s0();
        return T0;
    }

    @Override // c3.h
    public final void V() {
        F0(c3.n.END_ARRAY);
        g3.e e10 = this.f12613s.e();
        if (e10 != null) {
            this.f12613s = e10;
        }
    }

    public void V0(c3.k kVar) {
        c3.n n10 = kVar.n();
        if (n10 == c3.n.FIELD_NAME) {
            if (this.f12605k) {
                L0(kVar);
            }
            Z(kVar.m());
            n10 = kVar.s0();
        } else if (n10 == null) {
            throw new IllegalStateException("No token available from argument `JsonParser`");
        }
        int i10 = a.f12614a[n10.ordinal()];
        if (i10 == 1) {
            if (this.f12605k) {
                L0(kVar);
            }
            v0();
            M0(kVar);
            return;
        }
        if (i10 == 2) {
            W();
            return;
        }
        if (i10 != 3) {
            if (i10 != 4) {
                N0(kVar, n10);
                return;
            } else {
                V();
                return;
            }
        }
        if (this.f12605k) {
            L0(kVar);
        }
        s0();
        M0(kVar);
    }

    @Override // c3.h
    public final void W() {
        F0(c3.n.END_OBJECT);
        g3.e e10 = this.f12613s.e();
        if (e10 != null) {
            this.f12613s = e10;
        }
    }

    public y W0(c3.k kVar, k3.g gVar) {
        c3.n s02;
        if (!kVar.j0(c3.n.FIELD_NAME)) {
            V0(kVar);
            return this;
        }
        v0();
        do {
            V0(kVar);
            s02 = kVar.s0();
        } while (s02 == c3.n.FIELD_NAME);
        c3.n nVar = c3.n.END_OBJECT;
        if (s02 != nVar) {
            gVar.E0(y.class, nVar, "Expected END_OBJECT after copying contents of a JsonParser into TokenBuffer, got " + s02, new Object[0]);
        }
        W();
        return this;
    }

    public c3.n X0() {
        return this.f12607m.p(0);
    }

    @Override // c3.h
    public void Y(c3.q qVar) {
        this.f12613s.w(qVar.getValue());
        G0(qVar);
    }

    public int Y0() {
        return this.f12601g;
    }

    @Override // c3.h
    public final void Z(String str) {
        this.f12613s.w(str);
        G0(str);
    }

    @Override // c3.h
    /* renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public final g3.e s() {
        return this.f12613s;
    }

    @Override // c3.h
    public void a0() {
        J0(c3.n.VALUE_NULL);
    }

    public void a1(Object obj) {
        if (obj == null) {
            a0();
            return;
        }
        if (obj.getClass() == byte[].class || (obj instanceof u)) {
            K0(c3.n.VALUE_EMBEDDED_OBJECT, obj);
            return;
        }
        c3.o oVar = this.f12599e;
        if (oVar == null) {
            K0(c3.n.VALUE_EMBEDDED_OBJECT, obj);
        } else {
            oVar.c(this, obj);
        }
    }

    @Override // c3.h
    public void b0(double d10) {
        K0(c3.n.VALUE_NUMBER_FLOAT, Double.valueOf(d10));
    }

    @Override // c3.h
    public void c0(float f10) {
        K0(c3.n.VALUE_NUMBER_FLOAT, Float.valueOf(f10));
    }

    @Override // c3.h, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f12602h = true;
    }

    @Override // c3.h
    public void d0(int i10) {
        K0(c3.n.VALUE_NUMBER_INT, Integer.valueOf(i10));
    }

    @Override // c3.h
    public void e0(long j10) {
        K0(c3.n.VALUE_NUMBER_INT, Long.valueOf(j10));
    }

    @Override // c3.h
    public boolean f() {
        return true;
    }

    @Override // c3.h
    public void f0(String str) {
        K0(c3.n.VALUE_NUMBER_FLOAT, str);
    }

    @Override // c3.h, java.io.Flushable
    public void flush() {
    }

    @Override // c3.h
    public void g0(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            a0();
        } else {
            K0(c3.n.VALUE_NUMBER_FLOAT, bigDecimal);
        }
    }

    @Override // c3.h
    public void h0(BigInteger bigInteger) {
        if (bigInteger == null) {
            a0();
        } else {
            K0(c3.n.VALUE_NUMBER_INT, bigInteger);
        }
    }

    @Override // c3.h
    public void i0(short s10) {
        K0(c3.n.VALUE_NUMBER_INT, Short.valueOf(s10));
    }

    @Override // c3.h
    public void j0(Object obj) {
        this.f12611q = obj;
        this.f12612r = true;
    }

    @Override // c3.h
    public boolean m() {
        return this.f12604j;
    }

    @Override // c3.h
    public void m0(char c10) {
        O0();
    }

    @Override // c3.h
    public boolean n() {
        return this.f12603i;
    }

    @Override // c3.h
    public void n0(c3.q qVar) {
        O0();
    }

    @Override // c3.h
    public void o0(String str) {
        O0();
    }

    @Override // c3.h
    public void p0(char[] cArr, int i10, int i11) {
        O0();
    }

    @Override // c3.h
    public c3.h q(h.b bVar) {
        this.f12601g = (bVar.d() ^ (-1)) & this.f12601g;
        return this;
    }

    @Override // c3.h
    public void r0(String str) {
        K0(c3.n.VALUE_EMBEDDED_OBJECT, new u(str));
    }

    @Override // c3.h
    public final void s0() {
        this.f12613s.x();
        I0(c3.n.START_ARRAY);
        this.f12613s = this.f12613s.m();
    }

    @Override // c3.h
    public void t0(Object obj) {
        this.f12613s.x();
        I0(c3.n.START_ARRAY);
        this.f12613s = this.f12613s.n(obj);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[TokenBuffer: ");
        c3.k R0 = R0();
        int i10 = 0;
        boolean z10 = this.f12603i || this.f12604j;
        while (true) {
            try {
                c3.n s02 = R0.s0();
                if (s02 == null) {
                    break;
                }
                if (z10) {
                    H0(sb);
                }
                if (i10 < 100) {
                    if (i10 > 0) {
                        sb.append(", ");
                    }
                    sb.append(s02.toString());
                    if (s02 == c3.n.FIELD_NAME) {
                        sb.append(ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN);
                        sb.append(R0.m());
                        sb.append(ASCIIPropertyListParser.ARRAY_END_TOKEN);
                    }
                }
                i10++;
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        }
        if (i10 >= 100) {
            sb.append(" ... (truncated ");
            sb.append(i10 - 100);
            sb.append(" entries)");
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // c3.h
    public void u0(Object obj, int i10) {
        this.f12613s.x();
        I0(c3.n.START_ARRAY);
        this.f12613s = this.f12613s.n(obj);
    }

    @Override // c3.h
    public boolean v(h.b bVar) {
        return (bVar.d() & this.f12601g) != 0;
    }

    @Override // c3.h
    public final void v0() {
        this.f12613s.x();
        I0(c3.n.START_OBJECT);
        this.f12613s = this.f12613s.o();
    }

    @Override // c3.h
    public void w0(Object obj) {
        this.f12613s.x();
        I0(c3.n.START_OBJECT);
        this.f12613s = this.f12613s.p(obj);
    }

    @Override // c3.h
    public void x0(Object obj, int i10) {
        this.f12613s.x();
        I0(c3.n.START_OBJECT);
        this.f12613s = this.f12613s.p(obj);
    }

    @Override // c3.h
    public c3.h y(int i10, int i11) {
        this.f12601g = (i10 & i11) | (Y0() & (i11 ^ (-1)));
        return this;
    }

    @Override // c3.h
    public void y0(c3.q qVar) {
        if (qVar == null) {
            a0();
        } else {
            K0(c3.n.VALUE_STRING, qVar);
        }
    }

    @Override // c3.h
    public void z0(String str) {
        if (str == null) {
            a0();
        } else {
            K0(c3.n.VALUE_STRING, str);
        }
    }

    public y(c3.k kVar) {
        this(kVar, (k3.g) null);
    }

    public y(c3.k kVar, k3.g gVar) {
        this.f12612r = false;
        this.f12599e = kVar.y();
        this.f12600f = kVar.V();
        this.f12601g = f12598t;
        this.f12613s = g3.e.q(null);
        c cVar = new c();
        this.f12608n = cVar;
        this.f12607m = cVar;
        this.f12609o = 0;
        this.f12603i = kVar.e();
        boolean c10 = kVar.c();
        this.f12604j = c10;
        this.f12605k = this.f12603i || c10;
        this.f12606l = gVar != null ? gVar.n0(k3.h.USE_BIG_DECIMAL_FOR_FLOATS) : false;
    }
}
