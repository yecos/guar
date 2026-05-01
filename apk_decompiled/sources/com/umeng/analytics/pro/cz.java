package com.umeng.analytics.pro;

import com.google.common.primitives.UnsignedBytes;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class cz extends dg {

    /* renamed from: a, reason: collision with root package name */
    protected static final int f10208a = -65536;

    /* renamed from: b, reason: collision with root package name */
    protected static final int f10209b = -2147418112;

    /* renamed from: h, reason: collision with root package name */
    private static final dl f10210h = new dl();

    /* renamed from: c, reason: collision with root package name */
    protected boolean f10211c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f10212d;

    /* renamed from: e, reason: collision with root package name */
    protected int f10213e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f10214f;

    /* renamed from: i, reason: collision with root package name */
    private byte[] f10215i;

    /* renamed from: j, reason: collision with root package name */
    private byte[] f10216j;

    /* renamed from: k, reason: collision with root package name */
    private byte[] f10217k;

    /* renamed from: l, reason: collision with root package name */
    private byte[] f10218l;

    /* renamed from: m, reason: collision with root package name */
    private byte[] f10219m;

    /* renamed from: n, reason: collision with root package name */
    private byte[] f10220n;

    /* renamed from: o, reason: collision with root package name */
    private byte[] f10221o;

    /* renamed from: p, reason: collision with root package name */
    private byte[] f10222p;

    public static class a implements di {

        /* renamed from: a, reason: collision with root package name */
        protected boolean f10223a;

        /* renamed from: b, reason: collision with root package name */
        protected boolean f10224b;

        /* renamed from: c, reason: collision with root package name */
        protected int f10225c;

        public a() {
            this(false, true);
        }

        @Override // com.umeng.analytics.pro.di
        public dg a(du duVar) {
            cz czVar = new cz(duVar, this.f10223a, this.f10224b);
            int i10 = this.f10225c;
            if (i10 != 0) {
                czVar.c(i10);
            }
            return czVar;
        }

        public a(boolean z10, boolean z11) {
            this(z10, z11, 0);
        }

        public a(boolean z10, boolean z11, int i10) {
            this.f10223a = z10;
            this.f10224b = z11;
            this.f10225c = i10;
        }
    }

    public cz(du duVar) {
        this(duVar, false, true);
    }

    @Override // com.umeng.analytics.pro.dg
    public ByteBuffer A() {
        int w10 = w();
        d(w10);
        if (this.f10277g.h() >= w10) {
            ByteBuffer wrap = ByteBuffer.wrap(this.f10277g.f(), this.f10277g.g(), w10);
            this.f10277g.a(w10);
            return wrap;
        }
        byte[] bArr = new byte[w10];
        this.f10277g.d(bArr, 0, w10);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a() {
    }

    @Override // com.umeng.analytics.pro.dg
    public void b() {
    }

    @Override // com.umeng.analytics.pro.dg
    public void c() {
    }

    @Override // com.umeng.analytics.pro.dg
    public void d() {
        a((byte) 0);
    }

    @Override // com.umeng.analytics.pro.dg
    public void e() {
    }

    @Override // com.umeng.analytics.pro.dg
    public void f() {
    }

    @Override // com.umeng.analytics.pro.dg
    public void g() {
    }

    @Override // com.umeng.analytics.pro.dg
    public de h() {
        int w10 = w();
        if (w10 < 0) {
            if ((f10208a & w10) == f10209b) {
                return new de(z(), (byte) (w10 & 255), w());
            }
            throw new dh(4, "Bad version in readMessageBegin");
        }
        if (this.f10211c) {
            throw new dh(4, "Missing version in readMessageBegin, old client?");
        }
        return new de(b(w10), u(), w());
    }

    @Override // com.umeng.analytics.pro.dg
    public void i() {
    }

    @Override // com.umeng.analytics.pro.dg
    public dl j() {
        return f10210h;
    }

    @Override // com.umeng.analytics.pro.dg
    public void k() {
    }

    @Override // com.umeng.analytics.pro.dg
    public db l() {
        byte u10 = u();
        return new db("", u10, u10 == 0 ? (short) 0 : v());
    }

    @Override // com.umeng.analytics.pro.dg
    public void m() {
    }

    @Override // com.umeng.analytics.pro.dg
    public dd n() {
        return new dd(u(), u(), w());
    }

    @Override // com.umeng.analytics.pro.dg
    public void o() {
    }

    @Override // com.umeng.analytics.pro.dg
    public dc p() {
        return new dc(u(), w());
    }

    @Override // com.umeng.analytics.pro.dg
    public void q() {
    }

    @Override // com.umeng.analytics.pro.dg
    public dk r() {
        return new dk(u(), w());
    }

    @Override // com.umeng.analytics.pro.dg
    public void s() {
    }

    @Override // com.umeng.analytics.pro.dg
    public boolean t() {
        return u() == 1;
    }

    @Override // com.umeng.analytics.pro.dg
    public byte u() {
        if (this.f10277g.h() < 1) {
            a(this.f10219m, 0, 1);
            return this.f10219m[0];
        }
        byte b10 = this.f10277g.f()[this.f10277g.g()];
        this.f10277g.a(1);
        return b10;
    }

    @Override // com.umeng.analytics.pro.dg
    public short v() {
        int i10;
        byte[] bArr = this.f10220n;
        if (this.f10277g.h() >= 2) {
            bArr = this.f10277g.f();
            i10 = this.f10277g.g();
            this.f10277g.a(2);
        } else {
            a(this.f10220n, 0, 2);
            i10 = 0;
        }
        return (short) ((bArr[i10 + 1] & UnsignedBytes.MAX_VALUE) | ((bArr[i10] & UnsignedBytes.MAX_VALUE) << 8));
    }

    @Override // com.umeng.analytics.pro.dg
    public int w() {
        int i10;
        byte[] bArr = this.f10221o;
        if (this.f10277g.h() >= 4) {
            bArr = this.f10277g.f();
            i10 = this.f10277g.g();
            this.f10277g.a(4);
        } else {
            a(this.f10221o, 0, 4);
            i10 = 0;
        }
        return (bArr[i10 + 3] & UnsignedBytes.MAX_VALUE) | ((bArr[i10] & UnsignedBytes.MAX_VALUE) << 24) | ((bArr[i10 + 1] & UnsignedBytes.MAX_VALUE) << 16) | ((bArr[i10 + 2] & UnsignedBytes.MAX_VALUE) << 8);
    }

    @Override // com.umeng.analytics.pro.dg
    public long x() {
        int i10;
        byte[] bArr = this.f10222p;
        if (this.f10277g.h() >= 8) {
            bArr = this.f10277g.f();
            i10 = this.f10277g.g();
            this.f10277g.a(8);
        } else {
            a(this.f10222p, 0, 8);
            i10 = 0;
        }
        return (bArr[i10 + 7] & UnsignedBytes.MAX_VALUE) | ((bArr[i10] & UnsignedBytes.MAX_VALUE) << 56) | ((bArr[i10 + 1] & UnsignedBytes.MAX_VALUE) << 48) | ((bArr[i10 + 2] & UnsignedBytes.MAX_VALUE) << 40) | ((bArr[i10 + 3] & UnsignedBytes.MAX_VALUE) << 32) | ((bArr[i10 + 4] & UnsignedBytes.MAX_VALUE) << 24) | ((bArr[i10 + 5] & UnsignedBytes.MAX_VALUE) << 16) | ((bArr[i10 + 6] & UnsignedBytes.MAX_VALUE) << 8);
    }

    @Override // com.umeng.analytics.pro.dg
    public double y() {
        return Double.longBitsToDouble(x());
    }

    @Override // com.umeng.analytics.pro.dg
    public String z() {
        int w10 = w();
        if (this.f10277g.h() < w10) {
            return b(w10);
        }
        try {
            String str = new String(this.f10277g.f(), this.f10277g.g(), w10, "UTF-8");
            this.f10277g.a(w10);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new cn("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public cz(du duVar, boolean z10, boolean z11) {
        super(duVar);
        this.f10214f = false;
        this.f10215i = new byte[1];
        this.f10216j = new byte[2];
        this.f10217k = new byte[4];
        this.f10218l = new byte[8];
        this.f10219m = new byte[1];
        this.f10220n = new byte[2];
        this.f10221o = new byte[4];
        this.f10222p = new byte[8];
        this.f10211c = z10;
        this.f10212d = z11;
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(dl dlVar) {
    }

    public String b(int i10) {
        try {
            d(i10);
            byte[] bArr = new byte[i10];
            this.f10277g.d(bArr, 0, i10);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new cn("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public void c(int i10) {
        this.f10213e = i10;
        this.f10214f = true;
    }

    public void d(int i10) {
        if (i10 < 0) {
            throw new dh("Negative length: " + i10);
        }
        if (this.f10214f) {
            int i11 = this.f10213e - i10;
            this.f10213e = i11;
            if (i11 >= 0) {
                return;
            }
            throw new dh("Message length exceeded: " + i10);
        }
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(de deVar) {
        if (this.f10212d) {
            a(deVar.f10271b | f10209b);
            a(deVar.f10270a);
            a(deVar.f10272c);
        } else {
            a(deVar.f10270a);
            a(deVar.f10271b);
            a(deVar.f10272c);
        }
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(db dbVar) {
        a(dbVar.f10263b);
        a(dbVar.f10264c);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(dd ddVar) {
        a(ddVar.f10267a);
        a(ddVar.f10268b);
        a(ddVar.f10269c);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(dc dcVar) {
        a(dcVar.f10265a);
        a(dcVar.f10266b);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(dk dkVar) {
        a(dkVar.f10287a);
        a(dkVar.f10288b);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(boolean z10) {
        a(z10 ? (byte) 1 : (byte) 0);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(byte b10) {
        byte[] bArr = this.f10215i;
        bArr[0] = b10;
        this.f10277g.b(bArr, 0, 1);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(short s10) {
        byte[] bArr = this.f10216j;
        bArr[0] = (byte) ((s10 >> 8) & 255);
        bArr[1] = (byte) (s10 & 255);
        this.f10277g.b(bArr, 0, 2);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(int i10) {
        byte[] bArr = this.f10217k;
        bArr[0] = (byte) ((i10 >> 24) & 255);
        bArr[1] = (byte) ((i10 >> 16) & 255);
        bArr[2] = (byte) ((i10 >> 8) & 255);
        bArr[3] = (byte) (i10 & 255);
        this.f10277g.b(bArr, 0, 4);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(long j10) {
        byte[] bArr = this.f10218l;
        bArr[0] = (byte) ((j10 >> 56) & 255);
        bArr[1] = (byte) ((j10 >> 48) & 255);
        bArr[2] = (byte) ((j10 >> 40) & 255);
        bArr[3] = (byte) ((j10 >> 32) & 255);
        bArr[4] = (byte) ((j10 >> 24) & 255);
        bArr[5] = (byte) ((j10 >> 16) & 255);
        bArr[6] = (byte) ((j10 >> 8) & 255);
        bArr[7] = (byte) (j10 & 255);
        this.f10277g.b(bArr, 0, 8);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(double d10) {
        a(Double.doubleToLongBits(d10));
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes.length);
            this.f10277g.b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new cn("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit() - byteBuffer.position();
        a(limit);
        this.f10277g.b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    private int a(byte[] bArr, int i10, int i11) {
        d(i11);
        return this.f10277g.d(bArr, i10, i11);
    }
}
