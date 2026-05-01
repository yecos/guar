package androidx.appcompat.widget;

/* loaded from: classes.dex */
public class i2 {

    /* renamed from: a, reason: collision with root package name */
    public int f1506a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f1507b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f1508c = Integer.MIN_VALUE;

    /* renamed from: d, reason: collision with root package name */
    public int f1509d = Integer.MIN_VALUE;

    /* renamed from: e, reason: collision with root package name */
    public int f1510e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f1511f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1512g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1513h = false;

    public int a() {
        return this.f1512g ? this.f1506a : this.f1507b;
    }

    public int b() {
        return this.f1506a;
    }

    public int c() {
        return this.f1507b;
    }

    public int d() {
        return this.f1512g ? this.f1507b : this.f1506a;
    }

    public void e(int i10, int i11) {
        this.f1513h = false;
        if (i10 != Integer.MIN_VALUE) {
            this.f1510e = i10;
            this.f1506a = i10;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.f1511f = i11;
            this.f1507b = i11;
        }
    }

    public void f(boolean z10) {
        if (z10 == this.f1512g) {
            return;
        }
        this.f1512g = z10;
        if (!this.f1513h) {
            this.f1506a = this.f1510e;
            this.f1507b = this.f1511f;
            return;
        }
        if (z10) {
            int i10 = this.f1509d;
            if (i10 == Integer.MIN_VALUE) {
                i10 = this.f1510e;
            }
            this.f1506a = i10;
            int i11 = this.f1508c;
            if (i11 == Integer.MIN_VALUE) {
                i11 = this.f1511f;
            }
            this.f1507b = i11;
            return;
        }
        int i12 = this.f1508c;
        if (i12 == Integer.MIN_VALUE) {
            i12 = this.f1510e;
        }
        this.f1506a = i12;
        int i13 = this.f1509d;
        if (i13 == Integer.MIN_VALUE) {
            i13 = this.f1511f;
        }
        this.f1507b = i13;
    }

    public void g(int i10, int i11) {
        this.f1508c = i10;
        this.f1509d = i11;
        this.f1513h = true;
        if (this.f1512g) {
            if (i11 != Integer.MIN_VALUE) {
                this.f1506a = i11;
            }
            if (i10 != Integer.MIN_VALUE) {
                this.f1507b = i10;
                return;
            }
            return;
        }
        if (i10 != Integer.MIN_VALUE) {
            this.f1506a = i10;
        }
        if (i11 != Integer.MIN_VALUE) {
            this.f1507b = i11;
        }
    }
}
