package j3;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f14631c = {8000, 8000, 2000, 2000};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f14632d = {4000, 4000, 200, 200};

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReferenceArray f14633a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReferenceArray f14634b;

    public a() {
        this(4, 4);
    }

    public final byte[] a(int i10) {
        return b(i10, 0);
    }

    public byte[] b(int i10, int i11) {
        int f10 = f(i10);
        if (i11 < f10) {
            i11 = f10;
        }
        byte[] bArr = (byte[]) this.f14633a.getAndSet(i10, null);
        return (bArr == null || bArr.length < i11) ? e(i11) : bArr;
    }

    public final char[] c(int i10) {
        return d(i10, 0);
    }

    public char[] d(int i10, int i11) {
        int h10 = h(i10);
        if (i11 < h10) {
            i11 = h10;
        }
        char[] cArr = (char[]) this.f14634b.getAndSet(i10, null);
        return (cArr == null || cArr.length < i11) ? g(i11) : cArr;
    }

    public byte[] e(int i10) {
        return new byte[i10];
    }

    public int f(int i10) {
        return f14631c[i10];
    }

    public char[] g(int i10) {
        return new char[i10];
    }

    public int h(int i10) {
        return f14632d[i10];
    }

    public void i(int i10, byte[] bArr) {
        this.f14633a.set(i10, bArr);
    }

    public void j(int i10, char[] cArr) {
        this.f14634b.set(i10, cArr);
    }

    public a(int i10, int i11) {
        this.f14633a = new AtomicReferenceArray(i10);
        this.f14634b = new AtomicReferenceArray(i11);
    }
}
