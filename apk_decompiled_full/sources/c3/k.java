package c3;

import java.io.Closeable;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes.dex */
public abstract class k implements Closeable {

    /* renamed from: b, reason: collision with root package name */
    public static final j3.i f5455b = j3.i.a(r.values());

    /* renamed from: a, reason: collision with root package name */
    public int f5456a;

    public enum a {
        AUTO_CLOSE_SOURCE(true),
        ALLOW_COMMENTS(false),
        ALLOW_YAML_COMMENTS(false),
        ALLOW_UNQUOTED_FIELD_NAMES(false),
        ALLOW_SINGLE_QUOTES(false),
        ALLOW_UNQUOTED_CONTROL_CHARS(false),
        ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER(false),
        ALLOW_NUMERIC_LEADING_ZEROS(false),
        ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS(false),
        ALLOW_NON_NUMERIC_NUMBERS(false),
        ALLOW_MISSING_VALUES(false),
        ALLOW_TRAILING_COMMA(false),
        STRICT_DUPLICATE_DETECTION(false),
        IGNORE_UNDEFINED(false),
        INCLUDE_SOURCE_IN_LOCATION(true);


        /* renamed from: a, reason: collision with root package name */
        public final boolean f5473a;

        /* renamed from: b, reason: collision with root package name */
        public final int f5474b = 1 << ordinal();

        a(boolean z10) {
            this.f5473a = z10;
        }

        public static int a() {
            int i10 = 0;
            for (a aVar : values()) {
                if (aVar.b()) {
                    i10 |= aVar.d();
                }
            }
            return i10;
        }

        public boolean b() {
            return this.f5473a;
        }

        public boolean c(int i10) {
            return (i10 & this.f5474b) != 0;
        }

        public int d() {
            return this.f5474b;
        }
    }

    public enum b {
        INT,
        LONG,
        BIG_INTEGER,
        FLOAT,
        DOUBLE,
        BIG_DECIMAL
    }

    public k() {
    }

    public k(int i10) {
        this.f5456a = i10;
    }

    public void A0(Object obj) {
        m V = V();
        if (V != null) {
            V.i(obj);
        }
    }

    public k B0(int i10) {
        this.f5456a = i10;
        return this;
    }

    public void C0(c cVar) {
        throw new UnsupportedOperationException("Parser of type " + getClass().getName() + " does not support schema of type '" + cVar.a() + "'");
    }

    public abstract k D0();

    public abstract String E();

    public abstract n I();

    public abstract BigDecimal L();

    public abstract double M();

    public Object N() {
        return null;
    }

    public abstract float O();

    public abstract int P();

    public abstract long Q();

    public abstract b R();

    public abstract Number S();

    public Number T() {
        return S();
    }

    public Object U() {
        return null;
    }

    public abstract m V();

    public abstract j3.i W();

    public short X() {
        int P = P();
        if (P < -32768 || P > 32767) {
            throw new e3.a(this, String.format("Numeric value (%s) out of range of Java short", Y()), n.VALUE_NUMBER_INT, Short.TYPE);
        }
        return (short) P;
    }

    public abstract String Y();

    public abstract char[] Z();

    public o a() {
        o y10 = y();
        if (y10 != null) {
            return y10;
        }
        throw new IllegalStateException("No ObjectCodec defined for parser, needed for deserialization");
    }

    public abstract int a0();

    public j b(String str) {
        return new j(this, str).f(null);
    }

    public abstract int b0();

    public boolean c() {
        return false;
    }

    public abstract i c0();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public Object d0() {
        return null;
    }

    public boolean e() {
        return false;
    }

    public abstract int e0();

    public abstract void f();

    public abstract long f0();

    public abstract String g0();

    public abstract boolean h0();

    public abstract boolean i0();

    public abstract boolean j0(n nVar);

    public abstract boolean k0(int i10);

    public boolean l0(a aVar) {
        return aVar.c(this.f5456a);
    }

    public String m() {
        return E();
    }

    public abstract boolean m0();

    public abstract n n();

    public abstract boolean n0();

    public abstract boolean o0();

    public abstract boolean p0();

    public abstract int q();

    public String q0() {
        if (s0() == n.FIELD_NAME) {
            return E();
        }
        return null;
    }

    public String r0() {
        if (s0() == n.VALUE_STRING) {
            return Y();
        }
        return null;
    }

    public abstract BigInteger s();

    public abstract n s0();

    public abstract n t0();

    public byte[] u() {
        return v(c3.b.a());
    }

    public k u0(int i10, int i11) {
        return this;
    }

    public abstract byte[] v(c3.a aVar);

    public k v0(int i10, int i11) {
        return B0((i10 & i11) | (this.f5456a & (i11 ^ (-1))));
    }

    public abstract int w0(c3.a aVar, OutputStream outputStream);

    public byte x() {
        int P = P();
        if (P < -128 || P > 255) {
            throw new e3.a(this, String.format("Numeric value (%s) out of range of Java byte", Y()), n.VALUE_NUMBER_INT, Byte.TYPE);
        }
        return (byte) P;
    }

    public Object x0(Class cls) {
        return a().b(this, cls);
    }

    public abstract o y();

    public v y0() {
        return a().a(this);
    }

    public abstract i z();

    public boolean z0() {
        return false;
    }
}
