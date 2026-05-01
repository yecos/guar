package ab;

import ab.b;
import java.util.Arrays;

/* loaded from: classes.dex */
public class a extends b {

    /* renamed from: e, reason: collision with root package name */
    public static final eb.m f488e = new eb.a();

    /* renamed from: b, reason: collision with root package name */
    public b.a f490b;

    /* renamed from: a, reason: collision with root package name */
    public eb.b f489a = new eb.b(f488e);

    /* renamed from: c, reason: collision with root package name */
    public cb.a f491c = new cb.a();

    /* renamed from: d, reason: collision with root package name */
    public byte[] f492d = new byte[2];

    public a() {
        i();
    }

    @Override // ab.b
    public String c() {
        return za.b.f21199g;
    }

    @Override // ab.b
    public float d() {
        return this.f491c.a();
    }

    @Override // ab.b
    public b.a e() {
        return this.f490b;
    }

    @Override // ab.b
    public b.a f(byte[] bArr, int i10, int i11) {
        b.a aVar;
        int i12 = i11 + i10;
        for (int i13 = i10; i13 < i12; i13++) {
            int c10 = this.f489a.c(bArr[i13]);
            if (c10 == 1) {
                aVar = b.a.NOT_ME;
            } else if (c10 == 2) {
                aVar = b.a.FOUND_IT;
            } else {
                if (c10 == 0) {
                    int b10 = this.f489a.b();
                    if (i13 == i10) {
                        byte[] bArr2 = this.f492d;
                        bArr2[1] = bArr[i10];
                        this.f491c.d(bArr2, 0, b10);
                    } else {
                        this.f491c.d(bArr, i13 - 1, b10);
                    }
                }
            }
            this.f490b = aVar;
        }
        this.f492d[0] = bArr[i12 - 1];
        if (this.f490b == b.a.DETECTING && this.f491c.c() && d() > 0.95f) {
            this.f490b = b.a.FOUND_IT;
        }
        return this.f490b;
    }

    @Override // ab.b
    public void i() {
        this.f489a.d();
        this.f490b = b.a.DETECTING;
        this.f491c.e();
        Arrays.fill(this.f492d, (byte) 0);
    }
}
