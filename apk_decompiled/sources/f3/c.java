package f3;

import j3.o;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final Object f13053a;

    /* renamed from: b, reason: collision with root package name */
    public c3.e f13054b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f13055c;

    /* renamed from: d, reason: collision with root package name */
    public final j3.a f13056d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f13057e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f13058f;

    /* renamed from: g, reason: collision with root package name */
    public char[] f13059g;

    /* renamed from: h, reason: collision with root package name */
    public char[] f13060h;

    /* renamed from: i, reason: collision with root package name */
    public char[] f13061i;

    public c(j3.a aVar, Object obj, boolean z10) {
        this.f13056d = aVar;
        this.f13053a = obj;
        this.f13055c = z10;
    }

    public final void a(Object obj) {
        if (obj != null) {
            throw new IllegalStateException("Trying to call same allocXxx() method second time");
        }
    }

    public final void b(byte[] bArr, byte[] bArr2) {
        if (bArr != bArr2 && bArr.length < bArr2.length) {
            throw r();
        }
    }

    public final void c(char[] cArr, char[] cArr2) {
        if (cArr != cArr2 && cArr.length < cArr2.length) {
            throw r();
        }
    }

    public byte[] d() {
        a(this.f13058f);
        byte[] a10 = this.f13056d.a(3);
        this.f13058f = a10;
        return a10;
    }

    public char[] e() {
        a(this.f13060h);
        char[] c10 = this.f13056d.c(1);
        this.f13060h = c10;
        return c10;
    }

    public char[] f(int i10) {
        a(this.f13061i);
        char[] d10 = this.f13056d.d(3, i10);
        this.f13061i = d10;
        return d10;
    }

    public char[] g() {
        a(this.f13059g);
        char[] c10 = this.f13056d.c(0);
        this.f13059g = c10;
        return c10;
    }

    public byte[] h() {
        a(this.f13057e);
        byte[] a10 = this.f13056d.a(1);
        this.f13057e = a10;
        return a10;
    }

    public o i() {
        return new o(this.f13056d);
    }

    public Object j() {
        return this.f13053a;
    }

    public boolean k() {
        return this.f13055c;
    }

    public void l(byte[] bArr) {
        if (bArr != null) {
            b(bArr, this.f13058f);
            this.f13058f = null;
            this.f13056d.i(3, bArr);
        }
    }

    public void m(char[] cArr) {
        if (cArr != null) {
            c(cArr, this.f13060h);
            this.f13060h = null;
            this.f13056d.j(1, cArr);
        }
    }

    public void n(char[] cArr) {
        if (cArr != null) {
            c(cArr, this.f13061i);
            this.f13061i = null;
            this.f13056d.j(3, cArr);
        }
    }

    public void o(char[] cArr) {
        if (cArr != null) {
            c(cArr, this.f13059g);
            this.f13059g = null;
            this.f13056d.j(0, cArr);
        }
    }

    public void p(byte[] bArr) {
        if (bArr != null) {
            b(bArr, this.f13057e);
            this.f13057e = null;
            this.f13056d.i(1, bArr);
        }
    }

    public void q(c3.e eVar) {
        this.f13054b = eVar;
    }

    public final IllegalArgumentException r() {
        return new IllegalArgumentException("Trying to release buffer smaller than original");
    }
}
