package com.umeng.analytics.pro;

/* loaded from: classes3.dex */
public abstract class du {
    public abstract int a(byte[] bArr, int i10, int i11);

    public void a(int i10) {
    }

    public abstract boolean a();

    public abstract void b();

    public void b(byte[] bArr) {
        b(bArr, 0, bArr.length);
    }

    public abstract void b(byte[] bArr, int i10, int i11);

    public abstract void c();

    public void d() {
    }

    public byte[] f() {
        return null;
    }

    public int g() {
        return 0;
    }

    public int h() {
        return -1;
    }

    public boolean i() {
        return a();
    }

    public int d(byte[] bArr, int i10, int i11) {
        int i12 = 0;
        while (i12 < i11) {
            int a10 = a(bArr, i10 + i12, i11 - i12);
            if (a10 <= 0) {
                throw new dv("Cannot read. Remote side has closed. Tried to read " + i11 + " bytes, but only got " + i12 + " bytes. (This is often indicative of an internal error on the server side. Please check your server logs.)");
            }
            i12 += a10;
        }
        return i12;
    }
}
