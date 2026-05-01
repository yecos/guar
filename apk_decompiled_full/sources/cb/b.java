package cb;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public int f5823a;

    /* renamed from: b, reason: collision with root package name */
    public int f5824b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f5825c;

    /* renamed from: d, reason: collision with root package name */
    public float f5826d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f5827e;

    public b() {
        e();
    }

    public float a() {
        int i10;
        int i11 = this.f5824b;
        if (i11 <= 0 || (i10 = this.f5823a) <= 4) {
            return 0.01f;
        }
        if (i11 != i10) {
            float f10 = (i10 / (i11 - i10)) * this.f5826d;
            if (f10 < 0.99f) {
                return f10;
            }
        }
        return 0.99f;
    }

    public abstract int b(byte[] bArr, int i10);

    public boolean c() {
        return this.f5824b > 1024;
    }

    public void d(byte[] bArr, int i10, int i11) {
        int b10 = i11 == 2 ? b(bArr, i10) : -1;
        if (b10 >= 0) {
            this.f5824b++;
            int[] iArr = this.f5825c;
            if (b10 >= iArr.length || 512 <= iArr[b10]) {
                return;
            }
            this.f5823a++;
        }
    }

    public void e() {
        this.f5827e = false;
        this.f5824b = 0;
        this.f5823a = 0;
    }
}
