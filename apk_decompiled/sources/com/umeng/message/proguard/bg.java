package com.umeng.message.proguard;

/* loaded from: classes3.dex */
abstract class bg {

    /* renamed from: b, reason: collision with root package name */
    protected byte[] f11638b;

    /* renamed from: c, reason: collision with root package name */
    protected int f11639c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f11640d;

    /* renamed from: e, reason: collision with root package name */
    protected int f11641e;

    /* renamed from: f, reason: collision with root package name */
    protected int f11642f;

    /* renamed from: i, reason: collision with root package name */
    private int f11645i;

    /* renamed from: a, reason: collision with root package name */
    protected final byte f11637a = 61;

    /* renamed from: g, reason: collision with root package name */
    private final int f11643g = 3;

    /* renamed from: h, reason: collision with root package name */
    private final int f11644h = 4;

    public final void a(int i10) {
        byte[] bArr = this.f11638b;
        if (bArr == null || bArr.length < this.f11639c + i10) {
            if (bArr == null) {
                this.f11638b = new byte[8192];
                this.f11639c = 0;
                this.f11645i = 0;
            } else {
                byte[] bArr2 = new byte[bArr.length * 2];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                this.f11638b = bArr2;
            }
        }
    }

    public abstract void a(byte[] bArr, int i10, int i11);

    public abstract void b(byte[] bArr, int i10, int i11);

    public byte[] b(String str) {
        return e(str.getBytes());
    }

    public long c(byte[] bArr) {
        int length = bArr.length;
        int i10 = this.f11643g;
        return (((length + i10) - 1) / i10) * this.f11644h;
    }

    public byte[] d(byte[] bArr) {
        a();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a(bArr, 0, bArr.length);
        a(bArr, 0, -1);
        int i10 = this.f11639c - this.f11645i;
        byte[] bArr2 = new byte[i10];
        a(bArr2, i10);
        return bArr2;
    }

    public byte[] e(byte[] bArr) {
        a();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        b(bArr, 0, bArr.length);
        b(bArr, 0, -1);
        int i10 = this.f11639c;
        byte[] bArr2 = new byte[i10];
        a(bArr2, i10);
        return bArr2;
    }

    private int a(byte[] bArr, int i10) {
        byte[] bArr2 = this.f11638b;
        if (bArr2 == null) {
            return this.f11640d ? -1 : 0;
        }
        int min = Math.min(bArr2 != null ? this.f11639c - this.f11645i : 0, i10);
        System.arraycopy(this.f11638b, this.f11645i, bArr, 0, min);
        int i11 = this.f11645i + min;
        this.f11645i = i11;
        if (i11 >= this.f11639c) {
            this.f11638b = null;
        }
        return min;
    }

    private void a() {
        this.f11638b = null;
        this.f11639c = 0;
        this.f11645i = 0;
        this.f11641e = 0;
        this.f11642f = 0;
        this.f11640d = false;
    }
}
