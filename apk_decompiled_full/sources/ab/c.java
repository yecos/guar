package ab;

import ab.b;
import java.util.Arrays;

/* loaded from: classes.dex */
public class c extends b {

    /* renamed from: f, reason: collision with root package name */
    public static final eb.m f497f = new eb.c();

    /* renamed from: b, reason: collision with root package name */
    public b.a f499b;

    /* renamed from: a, reason: collision with root package name */
    public eb.b f498a = new eb.b(f497f);

    /* renamed from: c, reason: collision with root package name */
    public bb.a f500c = new bb.a();

    /* renamed from: d, reason: collision with root package name */
    public cb.c f501d = new cb.c();

    /* renamed from: e, reason: collision with root package name */
    public byte[] f502e = new byte[2];

    public c() {
        i();
    }

    @Override // ab.b
    public String c() {
        return za.b.f21201i;
    }

    @Override // ab.b
    public float d() {
        return Math.max(this.f500c.a(), this.f501d.a());
    }

    @Override // ab.b
    public b.a e() {
        return this.f499b;
    }

    @Override // ab.b
    public b.a f(byte[] bArr, int i10, int i11) {
        b.a aVar;
        int i12 = i11 + i10;
        for (int i13 = i10; i13 < i12; i13++) {
            int c10 = this.f498a.c(bArr[i13]);
            if (c10 == 1) {
                aVar = b.a.NOT_ME;
            } else if (c10 == 2) {
                aVar = b.a.FOUND_IT;
            } else {
                if (c10 == 0) {
                    int b10 = this.f498a.b();
                    if (i13 == i10) {
                        byte[] bArr2 = this.f502e;
                        bArr2[1] = bArr[i10];
                        this.f500c.d(bArr2, 0, b10);
                        this.f501d.d(this.f502e, 0, b10);
                    } else {
                        int i14 = i13 - 1;
                        this.f500c.d(bArr, i14, b10);
                        this.f501d.d(bArr, i14, b10);
                    }
                }
            }
            this.f499b = aVar;
        }
        this.f502e[0] = bArr[i12 - 1];
        if (this.f499b == b.a.DETECTING && this.f500c.c() && d() > 0.95f) {
            this.f499b = b.a.FOUND_IT;
        }
        return this.f499b;
    }

    @Override // ab.b
    public void i() {
        this.f498a.d();
        this.f499b = b.a.DETECTING;
        this.f500c.e();
        this.f501d.e();
        Arrays.fill(this.f502e, (byte) 0);
    }
}
