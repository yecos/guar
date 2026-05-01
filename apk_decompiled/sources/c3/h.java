package c3;

import i3.b;
import java.io.Closeable;
import java.io.Flushable;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes.dex */
public abstract class h implements Closeable, Flushable {

    /* renamed from: b, reason: collision with root package name */
    public static final j3.i f5431b;

    /* renamed from: c, reason: collision with root package name */
    public static final j3.i f5432c;

    /* renamed from: d, reason: collision with root package name */
    public static final j3.i f5433d;

    /* renamed from: a, reason: collision with root package name */
    public p f5434a;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5435a;

        static {
            int[] iArr = new int[b.a.values().length];
            f5435a = iArr;
            try {
                iArr[b.a.PARENT_PROPERTY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5435a[b.a.PAYLOAD_PROPERTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5435a[b.a.METADATA_PROPERTY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5435a[b.a.WRAPPER_OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5435a[b.a.WRAPPER_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum b {
        AUTO_CLOSE_TARGET(true),
        AUTO_CLOSE_JSON_CONTENT(true),
        FLUSH_PASSED_TO_STREAM(true),
        QUOTE_FIELD_NAMES(true),
        QUOTE_NON_NUMERIC_NUMBERS(true),
        ESCAPE_NON_ASCII(false),
        WRITE_NUMBERS_AS_STRINGS(false),
        WRITE_BIGDECIMAL_AS_PLAIN(false),
        STRICT_DUPLICATE_DETECTION(false),
        IGNORE_UNKNOWN(false);


        /* renamed from: a, reason: collision with root package name */
        public final boolean f5447a;

        /* renamed from: b, reason: collision with root package name */
        public final int f5448b = 1 << ordinal();

        b(boolean z10) {
            this.f5447a = z10;
        }

        public static int a() {
            int i10 = 0;
            for (b bVar : values()) {
                if (bVar.b()) {
                    i10 |= bVar.d();
                }
            }
            return i10;
        }

        public boolean b() {
            return this.f5447a;
        }

        public boolean c(int i10) {
            return (i10 & this.f5448b) != 0;
        }

        public int d() {
            return this.f5448b;
        }
    }

    static {
        j3.i a10 = j3.i.a(s.values());
        f5431b = a10;
        f5432c = a10.c(s.CAN_WRITE_FORMATTED_NUMBERS);
        f5433d = a10.c(s.CAN_WRITE_BINARY_NATIVELY);
    }

    public abstract void A0(char[] cArr, int i10, int i11);

    public void B0(String str, String str2) {
        Z(str);
        z0(str2);
    }

    public void C0(Object obj) {
        throw new g("No native support for writing Type Ids", this);
    }

    public i3.b D0(i3.b bVar) {
        Object obj = bVar.f14300c;
        n nVar = bVar.f14303f;
        if (n()) {
            bVar.f14304g = false;
            C0(obj);
        } else {
            String valueOf = obj instanceof String ? (String) obj : String.valueOf(obj);
            bVar.f14304g = true;
            b.a aVar = bVar.f14302e;
            if (nVar != n.START_OBJECT && aVar.a()) {
                aVar = b.a.WRAPPER_ARRAY;
                bVar.f14302e = aVar;
            }
            int i10 = a.f5435a[aVar.ordinal()];
            if (i10 != 1 && i10 != 2) {
                if (i10 == 3) {
                    w0(bVar.f14298a);
                    B0(bVar.f14301d, valueOf);
                    return bVar;
                }
                if (i10 != 4) {
                    s0();
                    z0(valueOf);
                } else {
                    v0();
                    Z(valueOf);
                }
            }
        }
        if (nVar == n.START_OBJECT) {
            w0(bVar.f14298a);
        } else if (nVar == n.START_ARRAY) {
            s0();
        }
        return bVar;
    }

    public abstract h E(int i10);

    public i3.b E0(i3.b bVar) {
        n nVar = bVar.f14303f;
        if (nVar == n.START_OBJECT) {
            W();
        } else if (nVar == n.START_ARRAY) {
            V();
        }
        if (bVar.f14304g) {
            int i10 = a.f5435a[bVar.f14302e.ordinal()];
            if (i10 == 1) {
                Object obj = bVar.f14300c;
                B0(bVar.f14301d, obj instanceof String ? (String) obj : String.valueOf(obj));
            } else if (i10 != 2 && i10 != 3) {
                if (i10 != 5) {
                    W();
                } else {
                    V();
                }
            }
        }
        return bVar;
    }

    public h I(p pVar) {
        this.f5434a = pVar;
        return this;
    }

    public h L(q qVar) {
        throw new UnsupportedOperationException();
    }

    public void M(double[] dArr, int i10, int i11) {
        if (dArr == null) {
            throw new IllegalArgumentException("null array");
        }
        c(dArr.length, i10, i11);
        u0(dArr, i11);
        int i12 = i11 + i10;
        while (i10 < i12) {
            b0(dArr[i10]);
            i10++;
        }
        V();
    }

    public void N(int[] iArr, int i10, int i11) {
        if (iArr == null) {
            throw new IllegalArgumentException("null array");
        }
        c(iArr.length, i10, i11);
        u0(iArr, i11);
        int i12 = i11 + i10;
        while (i10 < i12) {
            d0(iArr[i10]);
            i10++;
        }
        V();
    }

    public void O(long[] jArr, int i10, int i11) {
        if (jArr == null) {
            throw new IllegalArgumentException("null array");
        }
        c(jArr.length, i10, i11);
        u0(jArr, i11);
        int i12 = i11 + i10;
        while (i10 < i12) {
            e0(jArr[i10]);
            i10++;
        }
        V();
    }

    public abstract int P(c3.a aVar, InputStream inputStream, int i10);

    public int Q(InputStream inputStream, int i10) {
        return P(c3.b.a(), inputStream, i10);
    }

    public abstract void R(c3.a aVar, byte[] bArr, int i10, int i11);

    public void S(byte[] bArr) {
        R(c3.b.a(), bArr, 0, bArr.length);
    }

    public void T(byte[] bArr, int i10, int i11) {
        R(c3.b.a(), bArr, i10, i11);
    }

    public abstract void U(boolean z10);

    public abstract void V();

    public abstract void W();

    public void X(long j10) {
        Z(Long.toString(j10));
    }

    public abstract void Y(q qVar);

    public abstract void Z(String str);

    public void a(String str) {
        throw new g(str, this);
    }

    public abstract void a0();

    public final void b() {
        j3.q.a();
    }

    public abstract void b0(double d10);

    public final void c(int i10, int i11, int i12) {
        if (i11 < 0 || i11 + i12 > i10) {
            throw new IllegalArgumentException(String.format("invalid argument(s) (offset=%d, length=%d) for input array of %d element", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i10)));
        }
    }

    public abstract void c0(float f10);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public abstract void d0(int i10);

    public boolean e() {
        return true;
    }

    public abstract void e0(long j10);

    public boolean f() {
        return false;
    }

    public abstract void f0(String str);

    @Override // java.io.Flushable
    public abstract void flush();

    public abstract void g0(BigDecimal bigDecimal);

    public abstract void h0(BigInteger bigInteger);

    public abstract void i0(short s10);

    public void j0(Object obj) {
        throw new g("No native support for writing Object Ids", this);
    }

    public void k0(Object obj) {
        throw new g("No native support for writing Object Ids", this);
    }

    public void l0(String str) {
    }

    public boolean m() {
        return false;
    }

    public abstract void m0(char c10);

    public boolean n() {
        return false;
    }

    public abstract void n0(q qVar);

    public abstract void o0(String str);

    public abstract void p0(char[] cArr, int i10, int i11);

    public abstract h q(b bVar);

    public void q0(q qVar) {
        r0(qVar.getValue());
    }

    public abstract void r0(String str);

    public abstract m s();

    public abstract void s0();

    public abstract void t0(Object obj);

    public p u() {
        return this.f5434a;
    }

    public abstract void u0(Object obj, int i10);

    public abstract boolean v(b bVar);

    public abstract void v0();

    public abstract void w0(Object obj);

    public h x(int i10, int i11) {
        return this;
    }

    public void x0(Object obj, int i10) {
        v0();
        z(obj);
    }

    public abstract h y(int i10, int i11);

    public abstract void y0(q qVar);

    public void z(Object obj) {
        m s10 = s();
        if (s10 != null) {
            s10.i(obj);
        }
    }

    public abstract void z0(String str);
}
