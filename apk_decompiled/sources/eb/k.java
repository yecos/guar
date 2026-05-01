package eb;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public int f12997a;

    /* renamed from: b, reason: collision with root package name */
    public int f12998b;

    /* renamed from: c, reason: collision with root package name */
    public int f12999c;

    /* renamed from: d, reason: collision with root package name */
    public int f13000d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f13001e;

    public k(int i10, int i11, int i12, int i13, int[] iArr) {
        this.f12997a = i10;
        this.f12998b = i11;
        this.f12999c = i12;
        this.f13000d = i13;
        this.f13001e = iArr;
    }

    public static int a(int i10, int i11) {
        return i10 | (i11 << 16);
    }

    public static int b(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        return c(i10 | (i11 << 4), (i13 << 4) | i12, (i15 << 4) | i14, (i17 << 4) | i16);
    }

    public static int c(int i10, int i11, int i12, int i13) {
        return a(i10 | (i11 << 8), (i13 << 8) | i12);
    }

    public int d(int i10) {
        return (this.f13001e[i10 >> this.f12997a] >> ((i10 & this.f12998b) << this.f12999c)) & this.f13000d;
    }
}
