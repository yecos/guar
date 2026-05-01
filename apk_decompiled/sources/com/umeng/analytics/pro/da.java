package com.umeng.analytics.pro;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class da extends dg {

    /* renamed from: d, reason: collision with root package name */
    private static final dl f10232d = new dl("");

    /* renamed from: e, reason: collision with root package name */
    private static final db f10233e = new db("", (byte) 0, 0);

    /* renamed from: f, reason: collision with root package name */
    private static final byte[] f10234f = {0, 0, 1, 3, 7, 0, 4, 0, 5, 0, 6, 8, 12, 11, 10, 9};

    /* renamed from: h, reason: collision with root package name */
    private static final byte f10235h = -126;

    /* renamed from: i, reason: collision with root package name */
    private static final byte f10236i = 1;

    /* renamed from: j, reason: collision with root package name */
    private static final byte f10237j = 31;

    /* renamed from: k, reason: collision with root package name */
    private static final byte f10238k = -32;

    /* renamed from: l, reason: collision with root package name */
    private static final int f10239l = 5;

    /* renamed from: a, reason: collision with root package name */
    byte[] f10240a;

    /* renamed from: b, reason: collision with root package name */
    byte[] f10241b;

    /* renamed from: c, reason: collision with root package name */
    byte[] f10242c;

    /* renamed from: m, reason: collision with root package name */
    private cf f10243m;

    /* renamed from: n, reason: collision with root package name */
    private short f10244n;

    /* renamed from: o, reason: collision with root package name */
    private db f10245o;

    /* renamed from: p, reason: collision with root package name */
    private Boolean f10246p;

    /* renamed from: q, reason: collision with root package name */
    private final long f10247q;

    /* renamed from: r, reason: collision with root package name */
    private byte[] f10248r;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final byte f10250a = 1;

        /* renamed from: b, reason: collision with root package name */
        public static final byte f10251b = 2;

        /* renamed from: c, reason: collision with root package name */
        public static final byte f10252c = 3;

        /* renamed from: d, reason: collision with root package name */
        public static final byte f10253d = 4;

        /* renamed from: e, reason: collision with root package name */
        public static final byte f10254e = 5;

        /* renamed from: f, reason: collision with root package name */
        public static final byte f10255f = 6;

        /* renamed from: g, reason: collision with root package name */
        public static final byte f10256g = 7;

        /* renamed from: h, reason: collision with root package name */
        public static final byte f10257h = 8;

        /* renamed from: i, reason: collision with root package name */
        public static final byte f10258i = 9;

        /* renamed from: j, reason: collision with root package name */
        public static final byte f10259j = 10;

        /* renamed from: k, reason: collision with root package name */
        public static final byte f10260k = 11;

        /* renamed from: l, reason: collision with root package name */
        public static final byte f10261l = 12;

        private b() {
        }
    }

    public da(du duVar, long j10) {
        super(duVar);
        this.f10243m = new cf(15);
        this.f10244n = (short) 0;
        this.f10245o = null;
        this.f10246p = null;
        this.f10240a = new byte[5];
        this.f10241b = new byte[10];
        this.f10248r = new byte[1];
        this.f10242c = new byte[1];
        this.f10247q = j10;
    }

    private int E() {
        int i10 = 0;
        if (this.f10277g.h() >= 5) {
            byte[] f10 = this.f10277g.f();
            int g10 = this.f10277g.g();
            int i11 = 0;
            int i12 = 0;
            while (true) {
                byte b10 = f10[g10 + i10];
                i11 |= (b10 & Ascii.DEL) << i12;
                if ((b10 & UnsignedBytes.MAX_POWER_OF_TWO) != 128) {
                    this.f10277g.a(i10 + 1);
                    return i11;
                }
                i12 += 7;
                i10++;
            }
        } else {
            int i13 = 0;
            while (true) {
                byte u10 = u();
                i10 |= (u10 & Ascii.DEL) << i13;
                if ((u10 & UnsignedBytes.MAX_POWER_OF_TWO) != 128) {
                    return i10;
                }
                i13 += 7;
            }
        }
    }

    private long F() {
        int i10 = 0;
        long j10 = 0;
        if (this.f10277g.h() >= 10) {
            byte[] f10 = this.f10277g.f();
            int g10 = this.f10277g.g();
            long j11 = 0;
            int i11 = 0;
            while (true) {
                j11 |= (r7 & Ascii.DEL) << i11;
                if ((f10[g10 + i10] & UnsignedBytes.MAX_POWER_OF_TWO) != 128) {
                    this.f10277g.a(i10 + 1);
                    return j11;
                }
                i11 += 7;
                i10++;
            }
        } else {
            while (true) {
                j10 |= (r0 & Ascii.DEL) << i10;
                if ((u() & UnsignedBytes.MAX_POWER_OF_TWO) != 128) {
                    return j10;
                }
                i10 += 7;
            }
        }
    }

    private int c(int i10) {
        return (i10 >> 31) ^ (i10 << 1);
    }

    private long d(long j10) {
        return (-(j10 & 1)) ^ (j10 >>> 1);
    }

    private int g(int i10) {
        return (-(i10 & 1)) ^ (i10 >>> 1);
    }

    @Override // com.umeng.analytics.pro.dg
    public ByteBuffer A() {
        int E = E();
        f(E);
        if (E == 0) {
            return ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[E];
        this.f10277g.d(bArr, 0, E);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.dg
    public void B() {
        this.f10243m.c();
        this.f10244n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.dg
    public void a() {
    }

    @Override // com.umeng.analytics.pro.dg
    public void b() {
        this.f10244n = this.f10243m.a();
    }

    @Override // com.umeng.analytics.pro.dg
    public void e() {
    }

    @Override // com.umeng.analytics.pro.dg
    public void f() {
    }

    @Override // com.umeng.analytics.pro.dg
    public de h() {
        byte u10 = u();
        if (u10 != -126) {
            throw new dh("Expected protocol id " + Integer.toHexString(-126) + " but got " + Integer.toHexString(u10));
        }
        byte u11 = u();
        byte b10 = (byte) (u11 & 31);
        if (b10 == 1) {
            return new de(z(), (byte) ((u11 >> 5) & 3), E());
        }
        throw new dh("Expected version 1 but got " + ((int) b10));
    }

    @Override // com.umeng.analytics.pro.dg
    public void i() {
    }

    @Override // com.umeng.analytics.pro.dg
    public dl j() {
        this.f10243m.a(this.f10244n);
        this.f10244n = (short) 0;
        return f10232d;
    }

    @Override // com.umeng.analytics.pro.dg
    public void k() {
        this.f10244n = this.f10243m.a();
    }

    @Override // com.umeng.analytics.pro.dg
    public db l() {
        byte u10 = u();
        if (u10 == 0) {
            return f10233e;
        }
        short s10 = (short) ((u10 & 240) >> 4);
        byte b10 = (byte) (u10 & 15);
        db dbVar = new db("", d(b10), s10 == 0 ? v() : (short) (this.f10244n + s10));
        if (c(u10)) {
            this.f10246p = b10 == 1 ? Boolean.TRUE : Boolean.FALSE;
        }
        this.f10244n = dbVar.f10264c;
        return dbVar;
    }

    @Override // com.umeng.analytics.pro.dg
    public void m() {
    }

    @Override // com.umeng.analytics.pro.dg
    public dd n() {
        int E = E();
        byte u10 = E == 0 ? (byte) 0 : u();
        return new dd(d((byte) (u10 >> 4)), d((byte) (u10 & 15)), E);
    }

    @Override // com.umeng.analytics.pro.dg
    public void o() {
    }

    @Override // com.umeng.analytics.pro.dg
    public dc p() {
        byte u10 = u();
        int i10 = (u10 >> 4) & 15;
        if (i10 == 15) {
            i10 = E();
        }
        return new dc(d(u10), i10);
    }

    @Override // com.umeng.analytics.pro.dg
    public void q() {
    }

    @Override // com.umeng.analytics.pro.dg
    public dk r() {
        return new dk(p());
    }

    @Override // com.umeng.analytics.pro.dg
    public void s() {
    }

    @Override // com.umeng.analytics.pro.dg
    public boolean t() {
        Boolean bool = this.f10246p;
        if (bool == null) {
            return u() == 1;
        }
        boolean booleanValue = bool.booleanValue();
        this.f10246p = null;
        return booleanValue;
    }

    @Override // com.umeng.analytics.pro.dg
    public byte u() {
        if (this.f10277g.h() <= 0) {
            this.f10277g.d(this.f10242c, 0, 1);
            return this.f10242c[0];
        }
        byte b10 = this.f10277g.f()[this.f10277g.g()];
        this.f10277g.a(1);
        return b10;
    }

    @Override // com.umeng.analytics.pro.dg
    public short v() {
        return (short) g(E());
    }

    @Override // com.umeng.analytics.pro.dg
    public int w() {
        return g(E());
    }

    @Override // com.umeng.analytics.pro.dg
    public long x() {
        return d(F());
    }

    @Override // com.umeng.analytics.pro.dg
    public double y() {
        byte[] bArr = new byte[8];
        this.f10277g.d(bArr, 0, 8);
        return Double.longBitsToDouble(a(bArr));
    }

    @Override // com.umeng.analytics.pro.dg
    public String z() {
        int E = E();
        f(E);
        if (E == 0) {
            return "";
        }
        try {
            if (this.f10277g.h() < E) {
                return new String(e(E), "UTF-8");
            }
            String str = new String(this.f10277g.f(), this.f10277g.g(), E, "UTF-8");
            this.f10277g.a(E);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new cn("UTF-8 not supported!");
        }
    }

    public static class a implements di {

        /* renamed from: a, reason: collision with root package name */
        private final long f10249a;

        public a() {
            this.f10249a = -1L;
        }

        @Override // com.umeng.analytics.pro.di
        public dg a(du duVar) {
            return new da(duVar, this.f10249a);
        }

        public a(int i10) {
            this.f10249a = i10;
        }
    }

    private void b(int i10) {
        int i11 = 0;
        while ((i10 & (-128)) != 0) {
            this.f10240a[i11] = (byte) ((i10 & 127) | 128);
            i10 >>>= 7;
            i11++;
        }
        byte[] bArr = this.f10240a;
        bArr[i11] = (byte) i10;
        this.f10277g.b(bArr, 0, i11 + 1);
    }

    private long c(long j10) {
        return (j10 >> 63) ^ (j10 << 1);
    }

    private byte[] e(int i10) {
        if (i10 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i10];
        this.f10277g.d(bArr, 0, i10);
        return bArr;
    }

    private void f(int i10) {
        if (i10 < 0) {
            throw new dh("Negative length: " + i10);
        }
        long j10 = this.f10247q;
        if (j10 == -1 || i10 <= j10) {
            return;
        }
        throw new dh("Length exceeded max allowed: " + i10);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(de deVar) {
        b(f10235h);
        d(((deVar.f10271b << 5) & (-32)) | 1);
        b(deVar.f10272c);
        a(deVar.f10270a);
    }

    @Override // com.umeng.analytics.pro.dg
    public void d() {
        b((byte) 0);
    }

    @Override // com.umeng.analytics.pro.dg
    public void g() {
    }

    private void d(int i10) {
        b((byte) i10);
    }

    @Override // com.umeng.analytics.pro.dg
    public void c() {
    }

    private boolean c(byte b10) {
        int i10 = b10 & 15;
        return i10 == 1 || i10 == 2;
    }

    private byte d(byte b10) {
        byte b11 = (byte) (b10 & 15);
        switch (b11) {
            case 0:
                return (byte) 0;
            case 1:
            case 2:
                return (byte) 2;
            case 3:
                return (byte) 3;
            case 4:
                return (byte) 6;
            case 5:
                return (byte) 8;
            case 6:
                return (byte) 10;
            case 7:
                return (byte) 4;
            case 8:
                return (byte) 11;
            case 9:
                return (byte) 15;
            case 10:
                return (byte) 14;
            case 11:
                return (byte) 13;
            case 12:
                return (byte) 12;
            default:
                throw new dh("don't know what type: " + ((int) b11));
        }
    }

    private byte e(byte b10) {
        return f10234f[b10];
    }

    private void b(long j10) {
        int i10 = 0;
        while (((-128) & j10) != 0) {
            this.f10241b[i10] = (byte) ((127 & j10) | 128);
            j10 >>>= 7;
            i10++;
        }
        byte[] bArr = this.f10241b;
        bArr[i10] = (byte) j10;
        this.f10277g.b(bArr, 0, i10 + 1);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(dl dlVar) {
        this.f10243m.a(this.f10244n);
        this.f10244n = (short) 0;
    }

    private void b(byte b10) {
        byte[] bArr = this.f10248r;
        bArr[0] = b10;
        this.f10277g.b(bArr);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(db dbVar) {
        if (dbVar.f10263b == 2) {
            this.f10245o = dbVar;
        } else {
            a(dbVar, (byte) -1);
        }
    }

    public da(du duVar) {
        this(duVar, -1L);
    }

    private void a(db dbVar, byte b10) {
        if (b10 == -1) {
            b10 = e(dbVar.f10263b);
        }
        short s10 = dbVar.f10264c;
        short s11 = this.f10244n;
        if (s10 > s11 && s10 - s11 <= 15) {
            d(b10 | ((s10 - s11) << 4));
        } else {
            b(b10);
            a(dbVar.f10264c);
        }
        this.f10244n = dbVar.f10264c;
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(dd ddVar) {
        int i10 = ddVar.f10269c;
        if (i10 == 0) {
            d(0);
            return;
        }
        b(i10);
        d(e(ddVar.f10268b) | (e(ddVar.f10267a) << 4));
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(dc dcVar) {
        a(dcVar.f10265a, dcVar.f10266b);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(dk dkVar) {
        a(dkVar.f10287a, dkVar.f10288b);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(boolean z10) {
        db dbVar = this.f10245o;
        if (dbVar != null) {
            a(dbVar, z10 ? (byte) 1 : (byte) 2);
            this.f10245o = null;
        } else {
            b(z10 ? (byte) 1 : (byte) 2);
        }
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(byte b10) {
        b(b10);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(short s10) {
        b(c((int) s10));
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(int i10) {
        b(c(i10));
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(long j10) {
        b(c(j10));
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(double d10) {
        byte[] bArr = {0, 0, 0, 0, 0, 0, 0, 0};
        a(Double.doubleToLongBits(d10), bArr, 0);
        this.f10277g.b(bArr);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new cn("UTF-8 not supported!");
        }
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(ByteBuffer byteBuffer) {
        a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position());
    }

    private void a(byte[] bArr, int i10, int i11) {
        b(i11);
        this.f10277g.b(bArr, i10, i11);
    }

    public void a(byte b10, int i10) {
        if (i10 <= 14) {
            d(e(b10) | (i10 << 4));
        } else {
            d(e(b10) | 240);
            b(i10);
        }
    }

    private void a(long j10, byte[] bArr, int i10) {
        bArr[i10 + 0] = (byte) (j10 & 255);
        bArr[i10 + 1] = (byte) ((j10 >> 8) & 255);
        bArr[i10 + 2] = (byte) ((j10 >> 16) & 255);
        bArr[i10 + 3] = (byte) ((j10 >> 24) & 255);
        bArr[i10 + 4] = (byte) ((j10 >> 32) & 255);
        bArr[i10 + 5] = (byte) ((j10 >> 40) & 255);
        bArr[i10 + 6] = (byte) ((j10 >> 48) & 255);
        bArr[i10 + 7] = (byte) ((j10 >> 56) & 255);
    }

    private long a(byte[] bArr) {
        return ((bArr[7] & 255) << 56) | ((bArr[6] & 255) << 48) | ((bArr[5] & 255) << 40) | ((bArr[4] & 255) << 32) | ((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[1] & 255) << 8) | (255 & bArr[0]);
    }
}
