package com.umeng.analytics.pro;

/* loaded from: classes3.dex */
public final class dt extends du {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f10306a;

    /* renamed from: b, reason: collision with root package name */
    private int f10307b;

    /* renamed from: c, reason: collision with root package name */
    private int f10308c;

    public dt() {
    }

    @Override // com.umeng.analytics.pro.du
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.du
    public void b() {
    }

    @Override // com.umeng.analytics.pro.du
    public void c() {
    }

    public void e() {
        this.f10306a = null;
    }

    @Override // com.umeng.analytics.pro.du
    public byte[] f() {
        return this.f10306a;
    }

    @Override // com.umeng.analytics.pro.du
    public int g() {
        return this.f10307b;
    }

    @Override // com.umeng.analytics.pro.du
    public int h() {
        return this.f10308c - this.f10307b;
    }

    public dt(byte[] bArr) {
        a(bArr);
    }

    public void a(byte[] bArr) {
        c(bArr, 0, bArr.length);
    }

    @Override // com.umeng.analytics.pro.du
    public void b(byte[] bArr, int i10, int i11) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    public void c(byte[] bArr, int i10, int i11) {
        this.f10306a = bArr;
        this.f10307b = i10;
        this.f10308c = i10 + i11;
    }

    @Override // com.umeng.analytics.pro.du
    public int a(byte[] bArr, int i10, int i11) {
        int h10 = h();
        if (i11 > h10) {
            i11 = h10;
        }
        if (i11 > 0) {
            System.arraycopy(this.f10306a, this.f10307b, bArr, i10, i11);
            a(i11);
        }
        return i11;
    }

    public dt(byte[] bArr, int i10, int i11) {
        c(bArr, i10, i11);
    }

    @Override // com.umeng.analytics.pro.du
    public void a(int i10) {
        this.f10307b += i10;
    }
}
