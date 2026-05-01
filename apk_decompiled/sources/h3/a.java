package h3;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final a f14125a = null;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference f14126b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14127c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f14128d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f14129e;

    /* renamed from: f, reason: collision with root package name */
    public int[] f14130f;

    /* renamed from: g, reason: collision with root package name */
    public int f14131g;

    /* renamed from: h, reason: collision with root package name */
    public int f14132h;

    /* renamed from: i, reason: collision with root package name */
    public int f14133i;

    /* renamed from: j, reason: collision with root package name */
    public int f14134j;

    /* renamed from: k, reason: collision with root package name */
    public int f14135k;

    /* renamed from: h3.a$a, reason: collision with other inner class name */
    public static final class C0224a {

        /* renamed from: a, reason: collision with root package name */
        public final int f14136a;

        /* renamed from: b, reason: collision with root package name */
        public final int f14137b;

        /* renamed from: c, reason: collision with root package name */
        public final int f14138c;

        /* renamed from: d, reason: collision with root package name */
        public final int[] f14139d;

        /* renamed from: e, reason: collision with root package name */
        public final String[] f14140e;

        /* renamed from: f, reason: collision with root package name */
        public final int f14141f;

        /* renamed from: g, reason: collision with root package name */
        public final int f14142g;

        public C0224a(int i10, int i11, int i12, int[] iArr, String[] strArr, int i13, int i14) {
            this.f14136a = i10;
            this.f14137b = i11;
            this.f14138c = i12;
            this.f14139d = iArr;
            this.f14140e = strArr;
            this.f14141f = i13;
            this.f14142g = i14;
        }

        public static C0224a a(int i10) {
            int i11 = i10 << 3;
            return new C0224a(i10, 0, a.a(i10), new int[i11], new String[i10 << 1], i11 - i10, i11);
        }
    }

    public a(int i10, boolean z10, int i11, boolean z11) {
        this.f14127c = i11;
        this.f14128d = z10;
        this.f14129e = z11;
        int i12 = 16;
        if (i10 < 16) {
            i10 = 16;
        } else if (((i10 - 1) & i10) != 0) {
            while (i12 < i10) {
                i12 += i12;
            }
            i10 = i12;
        }
        this.f14126b = new AtomicReference(C0224a.a(i10));
    }

    public static int a(int i10) {
        int i11 = i10 >> 2;
        if (i11 < 64) {
            return 4;
        }
        if (i11 <= 256) {
            return 5;
        }
        return i11 <= 1024 ? 6 : 7;
    }

    public static a c() {
        long currentTimeMillis = System.currentTimeMillis();
        return d((((int) currentTimeMillis) + ((int) (currentTimeMillis >>> 32))) | 1);
    }

    public static a d(int i10) {
        return new a(64, true, i10, true);
    }

    public final int b() {
        int i10 = this.f14131g;
        return (i10 << 3) - i10;
    }

    public int e() {
        int i10 = this.f14132h;
        int i11 = 0;
        for (int i12 = 3; i12 < i10; i12 += 4) {
            if (this.f14130f[i12] != 0) {
                i11++;
            }
        }
        return i11;
    }

    public int f() {
        int i10 = this.f14133i;
        int i11 = 0;
        for (int i12 = this.f14132h + 3; i12 < i10; i12 += 4) {
            if (this.f14130f[i12] != 0) {
                i11++;
            }
        }
        return i11;
    }

    public int g() {
        return (this.f14135k - b()) >> 2;
    }

    public int h() {
        int i10 = this.f14133i + 3;
        int i11 = this.f14131g + i10;
        int i12 = 0;
        while (i10 < i11) {
            if (this.f14130f[i10] != 0) {
                i12++;
            }
            i10 += 4;
        }
        return i12;
    }

    public int i() {
        int i10 = this.f14131g << 3;
        int i11 = 0;
        for (int i12 = 3; i12 < i10; i12 += 4) {
            if (this.f14130f[i12] != 0) {
                i11++;
            }
        }
        return i11;
    }

    public String toString() {
        int e10 = e();
        int f10 = f();
        int h10 = h();
        int g10 = g();
        return String.format("[%s: size=%d, hashSize=%d, %d/%d/%d/%d pri/sec/ter/spill (=%s), total:%d]", a.class.getName(), Integer.valueOf(this.f14134j), Integer.valueOf(this.f14131g), Integer.valueOf(e10), Integer.valueOf(f10), Integer.valueOf(h10), Integer.valueOf(g10), Integer.valueOf(e10 + f10 + h10 + g10), Integer.valueOf(i()));
    }
}
