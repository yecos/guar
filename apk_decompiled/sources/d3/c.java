package d3;

import c3.j;
import c3.k;
import c3.n;
import com.hpplay.sdk.source.mdns.xbill.dns.TTL;
import com.raizlabs.android.dbflow.sql.language.Operator;
import f3.d;
import f3.f;
import j3.q;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes.dex */
public abstract class c extends k {

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f12493e = new byte[0];

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f12494f = new int[0];

    /* renamed from: g, reason: collision with root package name */
    public static final BigInteger f12495g;

    /* renamed from: h, reason: collision with root package name */
    public static final BigInteger f12496h;

    /* renamed from: i, reason: collision with root package name */
    public static final BigInteger f12497i;

    /* renamed from: j, reason: collision with root package name */
    public static final BigInteger f12498j;

    /* renamed from: k, reason: collision with root package name */
    public static final BigDecimal f12499k;

    /* renamed from: l, reason: collision with root package name */
    public static final BigDecimal f12500l;

    /* renamed from: m, reason: collision with root package name */
    public static final BigDecimal f12501m;

    /* renamed from: n, reason: collision with root package name */
    public static final BigDecimal f12502n;

    /* renamed from: c, reason: collision with root package name */
    public n f12503c;

    /* renamed from: d, reason: collision with root package name */
    public n f12504d;

    static {
        BigInteger valueOf = BigInteger.valueOf(-2147483648L);
        f12495g = valueOf;
        BigInteger valueOf2 = BigInteger.valueOf(TTL.MAX_VALUE);
        f12496h = valueOf2;
        BigInteger valueOf3 = BigInteger.valueOf(Long.MIN_VALUE);
        f12497i = valueOf3;
        BigInteger valueOf4 = BigInteger.valueOf(Long.MAX_VALUE);
        f12498j = valueOf4;
        f12499k = new BigDecimal(valueOf3);
        f12500l = new BigDecimal(valueOf4);
        f12501m = new BigDecimal(valueOf);
        f12502n = new BigDecimal(valueOf2);
    }

    public c(int i10) {
        super(i10);
    }

    public static final String G0(int i10) {
        char c10 = (char) i10;
        if (Character.isISOControl(c10)) {
            return "(CTRL-CHAR, code " + i10 + ")";
        }
        if (i10 <= 255) {
            return "'" + c10 + "' (code " + i10 + ")";
        }
        return "'" + c10 + "' (code " + i10 + " / 0x" + Integer.toHexString(i10) + ")";
    }

    @Override // c3.k
    public k D0() {
        n nVar = this.f12503c;
        if (nVar != n.START_OBJECT && nVar != n.START_ARRAY) {
            return this;
        }
        int i10 = 1;
        while (true) {
            n s02 = s0();
            if (s02 == null) {
                H0();
                return this;
            }
            if (s02.g()) {
                i10++;
            } else if (s02.f()) {
                i10--;
                if (i10 == 0) {
                    return this;
                }
            } else if (s02 == n.NOT_AVAILABLE) {
                M0("Not enough content available for `skipChildren()`: non-blocking parser? (%s)", getClass().getName());
            }
        }
    }

    @Override // c3.k
    public abstract String E();

    public final j E0(String str, Throwable th) {
        return new j(this, str, th);
    }

    public void F0(String str, j3.c cVar, c3.a aVar) {
        try {
            aVar.e(str, cVar);
        } catch (IllegalArgumentException e10) {
            L0(e10.getMessage());
        }
    }

    public abstract void H0();

    @Override // c3.k
    public n I() {
        return this.f12503c;
    }

    public boolean I0(String str) {
        return "null".equals(str);
    }

    public String J0(String str) {
        int length = str.length();
        if (length < 1000) {
            return str;
        }
        if (str.startsWith(Operator.Operation.MINUS)) {
            length--;
        }
        return String.format("[Integer with %d digits]", Integer.valueOf(length));
    }

    public String K0(String str) {
        int length = str.length();
        if (length < 1000) {
            return str;
        }
        if (str.startsWith(Operator.Operation.MINUS)) {
            length--;
        }
        return String.format("[number with %d characters]", Integer.valueOf(length));
    }

    public final void L0(String str) {
        throw b(str);
    }

    public final void M0(String str, Object obj) {
        throw b(String.format(str, obj));
    }

    public final void N0(String str, Object obj, Object obj2) {
        throw b(String.format(str, obj, obj2));
    }

    public void O0(String str, n nVar, Class cls) {
        throw new e3.a(this, str, nVar, cls);
    }

    public void P0() {
        Q0(" in " + this.f12503c, this.f12503c);
    }

    public void Q0(String str, n nVar) {
        throw new d(this, nVar, "Unexpected end-of-input" + str);
    }

    public void R0(n nVar) {
        Q0(nVar == n.VALUE_STRING ? " in a String value" : (nVar == n.VALUE_NUMBER_INT || nVar == n.VALUE_NUMBER_FLOAT) ? " in a Number value" : " in a value", nVar);
    }

    public void S0(int i10) {
        T0(i10, "Expected space separating root-level values");
    }

    public void T0(int i10, String str) {
        if (i10 < 0) {
            P0();
        }
        String format = String.format("Unexpected character (%s)", G0(i10));
        if (str != null) {
            format = format + ": " + str;
        }
        L0(format);
    }

    public final void U0() {
        q.a();
    }

    public void V0(int i10) {
        L0("Illegal character (" + G0((char) i10) + "): only regular white space (\\r, \\n, \\t) is allowed between tokens");
    }

    public final void W0(String str, Throwable th) {
        throw E0(str, th);
    }

    public int X0(int i10) {
        n nVar = this.f12503c;
        if (nVar == n.VALUE_NUMBER_INT || nVar == n.VALUE_NUMBER_FLOAT) {
            return P();
        }
        if (nVar == null) {
            return i10;
        }
        int c10 = nVar.c();
        if (c10 == 6) {
            String Y = Y();
            if (I0(Y)) {
                return 0;
            }
            return f.d(Y, i10);
        }
        switch (c10) {
            case 9:
                return 1;
            case 10:
            case 11:
                return 0;
            case 12:
                Object N = N();
                return N instanceof Number ? ((Number) N).intValue() : i10;
            default:
                return i10;
        }
    }

    @Override // c3.k
    public abstract String Y();

    public long Y0(long j10) {
        n nVar = this.f12503c;
        if (nVar == n.VALUE_NUMBER_INT || nVar == n.VALUE_NUMBER_FLOAT) {
            return Q();
        }
        if (nVar == null) {
            return j10;
        }
        int c10 = nVar.c();
        if (c10 == 6) {
            String Y = Y();
            if (I0(Y)) {
                return 0L;
            }
            return f.e(Y, j10);
        }
        switch (c10) {
            case 9:
                return 1L;
            case 10:
            case 11:
                return 0L;
            case 12:
                Object N = N();
                return N instanceof Number ? ((Number) N).longValue() : j10;
            default:
                return j10;
        }
    }

    public String Z0(String str) {
        n nVar = this.f12503c;
        return nVar == n.VALUE_STRING ? Y() : nVar == n.FIELD_NAME ? E() : (nVar == null || nVar == n.VALUE_NULL || !nVar.e()) ? str : Y();
    }

    public void a1(String str) {
        L0("Invalid numeric value: " + str);
    }

    public void b1() {
        c1(Y());
    }

    public void c1(String str) {
        d1(str, n());
    }

    public void d1(String str, n nVar) {
        O0(String.format("Numeric value (%s) out of range of int (%d - %s)", J0(str), Integer.MIN_VALUE, Integer.MAX_VALUE), nVar, Integer.TYPE);
    }

    @Override // c3.k
    public int e0() {
        n nVar = this.f12503c;
        return (nVar == n.VALUE_NUMBER_INT || nVar == n.VALUE_NUMBER_FLOAT) ? P() : X0(0);
    }

    public void e1() {
        f1(Y());
    }

    @Override // c3.k
    public void f() {
        n nVar = this.f12503c;
        if (nVar != null) {
            this.f12504d = nVar;
            this.f12503c = null;
        }
    }

    @Override // c3.k
    public long f0() {
        n nVar = this.f12503c;
        return (nVar == n.VALUE_NUMBER_INT || nVar == n.VALUE_NUMBER_FLOAT) ? Q() : Y0(0L);
    }

    public void f1(String str) {
        g1(str, n());
    }

    @Override // c3.k
    public String g0() {
        return Z0(null);
    }

    public void g1(String str, n nVar) {
        O0(String.format("Numeric value (%s) out of range of long (%d - %s)", J0(str), Long.MIN_VALUE, Long.MAX_VALUE), nVar, Long.TYPE);
    }

    @Override // c3.k
    public boolean h0() {
        return this.f12503c != null;
    }

    public void h1(int i10, String str) {
        String format = String.format("Unexpected character (%s) in numeric value", G0(i10));
        if (str != null) {
            format = format + ": " + str;
        }
        L0(format);
    }

    @Override // c3.k
    public boolean j0(n nVar) {
        return this.f12503c == nVar;
    }

    @Override // c3.k
    public boolean k0(int i10) {
        n nVar = this.f12503c;
        return nVar == null ? i10 == 0 : nVar.c() == i10;
    }

    @Override // c3.k
    public boolean m0() {
        return this.f12503c == n.VALUE_NUMBER_INT;
    }

    @Override // c3.k
    public n n() {
        return this.f12503c;
    }

    @Override // c3.k
    public boolean n0() {
        return this.f12503c == n.START_ARRAY;
    }

    @Override // c3.k
    public boolean o0() {
        return this.f12503c == n.START_OBJECT;
    }

    @Override // c3.k
    public int q() {
        n nVar = this.f12503c;
        if (nVar == null) {
            return 0;
        }
        return nVar.c();
    }

    @Override // c3.k
    public abstract n s0();

    @Override // c3.k
    public n t0() {
        n s02 = s0();
        return s02 == n.FIELD_NAME ? s0() : s02;
    }
}
