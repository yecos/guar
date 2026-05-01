package ab;

import ab.b;
import java.util.Arrays;

/* loaded from: classes.dex */
public class e extends b {

    /* renamed from: e, reason: collision with root package name */
    public static final eb.m f508e = new eb.e();

    /* renamed from: b, reason: collision with root package name */
    public b.a f510b;

    /* renamed from: a, reason: collision with root package name */
    public eb.b f509a = new eb.b(f508e);

    /* renamed from: c, reason: collision with root package name */
    public cb.e f511c = new cb.e();

    /* renamed from: d, reason: collision with root package name */
    public byte[] f512d = new byte[2];

    public e() {
        i();
    }

    @Override // ab.b
    public String c() {
        return za.b.f21203k;
    }

    @Override // ab.b
    public float d() {
        return this.f511c.a();
    }

    @Override // ab.b
    public b.a e() {
        return this.f510b;
    }

    @Override // ab.b
    public b.a f(byte[] bArr, int i10, int i11) {
        b.a aVar;
        int i12 = i11 + i10;
        for (int i13 = i10; i13 < i12; i13++) {
            int c10 = this.f509a.c(bArr[i13]);
            if (c10 == 1) {
                aVar = b.a.NOT_ME;
            } else if (c10 == 2) {
                aVar = b.a.FOUND_IT;
            } else {
                if (c10 == 0) {
                    int b10 = this.f509a.b();
                    if (i13 == i10) {
                        byte[] bArr2 = this.f512d;
                        bArr2[1] = bArr[i10];
                        this.f511c.d(bArr2, 0, b10);
                    } else {
                        this.f511c.d(bArr, i13 - 1, b10);
                    }
                }
            }
            this.f510b = aVar;
        }
        this.f512d[0] = bArr[i12 - 1];
        if (this.f510b == b.a.DETECTING && this.f511c.c() && d() > 0.95f) {
            this.f510b = b.a.FOUND_IT;
        }
        return this.f510b;
    }

    @Override // ab.b
    public void i() {
        this.f509a.d();
        this.f510b = b.a.DETECTING;
        this.f511c.e();
        Arrays.fill(this.f512d, (byte) 0);
    }
}
