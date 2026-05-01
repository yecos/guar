package ab;

import ab.b;

/* loaded from: classes.dex */
public class m extends b {

    /* renamed from: a, reason: collision with root package name */
    public b.a f564a;

    /* renamed from: b, reason: collision with root package name */
    public db.l f565b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f566c;

    /* renamed from: d, reason: collision with root package name */
    public short f567d;

    /* renamed from: e, reason: collision with root package name */
    public int f568e;

    /* renamed from: f, reason: collision with root package name */
    public int[] f569f;

    /* renamed from: g, reason: collision with root package name */
    public int f570g;

    /* renamed from: h, reason: collision with root package name */
    public int f571h;

    /* renamed from: i, reason: collision with root package name */
    public b f572i;

    public m(db.l lVar) {
        this.f565b = lVar;
        this.f566c = false;
        this.f572i = null;
        this.f569f = new int[4];
        i();
    }

    @Override // ab.b
    public String c() {
        b bVar = this.f572i;
        return bVar == null ? this.f565b.a() : bVar.c();
    }

    @Override // ab.b
    public float d() {
        int i10 = this.f568e;
        if (i10 <= 0) {
            return 0.01f;
        }
        float d10 = ((((this.f569f[3] * 1.0f) / i10) / this.f565b.d()) * this.f571h) / this.f570g;
        if (d10 >= 1.0f) {
            return 0.99f;
        }
        return d10;
    }

    @Override // ab.b
    public b.a e() {
        return this.f564a;
    }

    @Override // ab.b
    public b.a f(byte[] bArr, int i10, int i11) {
        b.a aVar;
        int i12 = i11 + i10;
        while (i10 < i12) {
            short b10 = this.f565b.b(bArr[i10]);
            if (b10 < 250) {
                this.f570g++;
            }
            if (b10 < 64) {
                this.f571h++;
                short s10 = this.f567d;
                if (s10 < 64) {
                    this.f568e++;
                    if (this.f566c) {
                        int[] iArr = this.f569f;
                        byte c10 = this.f565b.c((b10 * 64) + s10);
                        iArr[c10] = iArr[c10] + 1;
                    } else {
                        int[] iArr2 = this.f569f;
                        byte c11 = this.f565b.c((s10 * 64) + b10);
                        iArr2[c11] = iArr2[c11] + 1;
                    }
                }
            }
            this.f567d = b10;
            i10++;
        }
        if (this.f564a == b.a.DETECTING && this.f568e > 1024) {
            float d10 = d();
            if (d10 > 0.95f) {
                aVar = b.a.FOUND_IT;
            } else if (d10 < 0.05f) {
                aVar = b.a.NOT_ME;
            }
            this.f564a = aVar;
        }
        return this.f564a;
    }

    @Override // ab.b
    public void i() {
        this.f564a = b.a.DETECTING;
        this.f567d = (short) 255;
        for (int i10 = 0; i10 < 4; i10++) {
            this.f569f[i10] = 0;
        }
        this.f568e = 0;
        this.f570g = 0;
        this.f571h = 0;
    }

    public m(db.l lVar, boolean z10, b bVar) {
        this.f565b = lVar;
        this.f566c = z10;
        this.f572i = bVar;
        this.f569f = new int[4];
        i();
    }
}
