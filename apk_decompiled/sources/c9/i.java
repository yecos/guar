package c9;

/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public int f5730a;

    /* renamed from: b, reason: collision with root package name */
    public int f5731b;

    /* renamed from: c, reason: collision with root package name */
    public int f5732c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f5733d = new int[10];

    public int a(int i10) {
        return this.f5733d[i10];
    }

    public int b() {
        if ((this.f5730a & 2) != 0) {
            return this.f5733d[1];
        }
        return -1;
    }

    public int c(int i10) {
        return (this.f5730a & 32) != 0 ? this.f5733d[5] : i10;
    }

    public boolean d(int i10) {
        return ((1 << i10) & this.f5730a) != 0;
    }

    public i e(int i10, int i11, int i12) {
        int[] iArr = this.f5733d;
        if (i10 >= iArr.length) {
            return this;
        }
        int i13 = 1 << i10;
        this.f5730a |= i13;
        if ((i11 & 1) != 0) {
            this.f5731b |= i13;
        } else {
            this.f5731b &= i13 ^ (-1);
        }
        if ((i11 & 2) != 0) {
            this.f5732c |= i13;
        } else {
            this.f5732c &= i13 ^ (-1);
        }
        iArr[i10] = i12;
        return this;
    }

    public int f() {
        return Integer.bitCount(this.f5730a);
    }
}
