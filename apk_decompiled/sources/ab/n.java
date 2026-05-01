package ab;

import ab.b;

/* loaded from: classes.dex */
public class n extends b {

    /* renamed from: d, reason: collision with root package name */
    public static final eb.m f573d = new eb.n();

    /* renamed from: b, reason: collision with root package name */
    public b.a f575b;

    /* renamed from: c, reason: collision with root package name */
    public int f576c = 0;

    /* renamed from: a, reason: collision with root package name */
    public eb.b f574a = new eb.b(f573d);

    public n() {
        i();
    }

    @Override // ab.b
    public String c() {
        return za.b.f21213u;
    }

    @Override // ab.b
    public float d() {
        float f10 = 0.99f;
        if (this.f576c >= 6) {
            return 0.99f;
        }
        for (int i10 = 0; i10 < this.f576c; i10++) {
            f10 *= 0.5f;
        }
        return 1.0f - f10;
    }

    @Override // ab.b
    public b.a e() {
        return this.f575b;
    }

    @Override // ab.b
    public b.a f(byte[] bArr, int i10, int i11) {
        b.a aVar;
        int i12 = i11 + i10;
        while (i10 < i12) {
            int c10 = this.f574a.c(bArr[i10]);
            if (c10 == 1) {
                aVar = b.a.NOT_ME;
            } else if (c10 == 2) {
                aVar = b.a.FOUND_IT;
            } else {
                if (c10 == 0 && this.f574a.b() >= 2) {
                    this.f576c++;
                }
                i10++;
            }
            this.f575b = aVar;
            break;
        }
        if (this.f575b == b.a.DETECTING && d() > 0.95f) {
            this.f575b = b.a.FOUND_IT;
        }
        return this.f575b;
    }

    @Override // ab.b
    public void i() {
        this.f574a.d();
        this.f576c = 0;
        this.f575b = b.a.DETECTING;
    }
}
