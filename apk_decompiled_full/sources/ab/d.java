package ab;

import ab.b;
import java.util.Arrays;

/* loaded from: classes.dex */
public class d extends b {

    /* renamed from: e, reason: collision with root package name */
    public static final eb.m f503e = new eb.d();

    /* renamed from: b, reason: collision with root package name */
    public b.a f505b;

    /* renamed from: a, reason: collision with root package name */
    public eb.b f504a = new eb.b(f503e);

    /* renamed from: c, reason: collision with root package name */
    public cb.d f506c = new cb.d();

    /* renamed from: d, reason: collision with root package name */
    public byte[] f507d = new byte[2];

    public d() {
        i();
    }

    @Override // ab.b
    public String c() {
        return za.b.f21202j;
    }

    @Override // ab.b
    public float d() {
        return this.f506c.a();
    }

    @Override // ab.b
    public b.a e() {
        return this.f505b;
    }

    @Override // ab.b
    public b.a f(byte[] bArr, int i10, int i11) {
        b.a aVar;
        int i12 = i11 + i10;
        for (int i13 = i10; i13 < i12; i13++) {
            int c10 = this.f504a.c(bArr[i13]);
            if (c10 == 1) {
                aVar = b.a.NOT_ME;
            } else if (c10 == 2) {
                aVar = b.a.FOUND_IT;
            } else {
                if (c10 == 0) {
                    int b10 = this.f504a.b();
                    if (i13 == i10) {
                        byte[] bArr2 = this.f507d;
                        bArr2[1] = bArr[i10];
                        this.f506c.d(bArr2, 0, b10);
                    } else {
                        this.f506c.d(bArr, i13 - 1, b10);
                    }
                }
            }
            this.f505b = aVar;
        }
        this.f507d[0] = bArr[i12 - 1];
        if (this.f505b == b.a.DETECTING && this.f506c.c() && d() > 0.95f) {
            this.f505b = b.a.FOUND_IT;
        }
        return this.f505b;
    }

    @Override // ab.b
    public void i() {
        this.f504a.d();
        this.f505b = b.a.DETECTING;
        this.f506c.e();
        Arrays.fill(this.f507d, (byte) 0);
    }
}
