package ab;

import ab.b;
import java.util.Arrays;

/* loaded from: classes.dex */
public class l extends b {

    /* renamed from: f, reason: collision with root package name */
    public static final eb.m f558f = new eb.l();

    /* renamed from: b, reason: collision with root package name */
    public b.a f560b;

    /* renamed from: a, reason: collision with root package name */
    public eb.b f559a = new eb.b(f558f);

    /* renamed from: c, reason: collision with root package name */
    public bb.c f561c = new bb.c();

    /* renamed from: d, reason: collision with root package name */
    public cb.h f562d = new cb.h();

    /* renamed from: e, reason: collision with root package name */
    public byte[] f563e = new byte[2];

    public l() {
        i();
    }

    @Override // ab.b
    public String c() {
        return za.b.f21204l;
    }

    @Override // ab.b
    public float d() {
        return Math.max(this.f561c.a(), this.f562d.a());
    }

    @Override // ab.b
    public b.a e() {
        return this.f560b;
    }

    @Override // ab.b
    public b.a f(byte[] bArr, int i10, int i11) {
        b.a aVar;
        int i12 = i11 + i10;
        for (int i13 = i10; i13 < i12; i13++) {
            int c10 = this.f559a.c(bArr[i13]);
            if (c10 == 1) {
                aVar = b.a.NOT_ME;
            } else if (c10 == 2) {
                aVar = b.a.FOUND_IT;
            } else {
                if (c10 == 0) {
                    int b10 = this.f559a.b();
                    if (i13 == i10) {
                        byte[] bArr2 = this.f563e;
                        bArr2[1] = bArr[i10];
                        this.f561c.d(bArr2, 2 - b10, b10);
                        this.f562d.d(this.f563e, 0, b10);
                    } else {
                        this.f561c.d(bArr, (i13 + 1) - b10, b10);
                        this.f562d.d(bArr, i13 - 1, b10);
                    }
                }
            }
            this.f560b = aVar;
        }
        this.f563e[0] = bArr[i12 - 1];
        if (this.f560b == b.a.DETECTING && this.f561c.c() && d() > 0.95f) {
            this.f560b = b.a.FOUND_IT;
        }
        return this.f560b;
    }

    @Override // ab.b
    public void i() {
        this.f559a.d();
        this.f560b = b.a.DETECTING;
        this.f561c.e();
        this.f562d.e();
        Arrays.fill(this.f563e, (byte) 0);
    }
}
