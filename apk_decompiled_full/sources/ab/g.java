package ab;

import ab.b;
import java.util.Arrays;

/* loaded from: classes.dex */
public class g extends b {

    /* renamed from: e, reason: collision with root package name */
    public static final eb.m f521e = new eb.f();

    /* renamed from: b, reason: collision with root package name */
    public b.a f523b;

    /* renamed from: a, reason: collision with root package name */
    public eb.b f522a = new eb.b(f521e);

    /* renamed from: c, reason: collision with root package name */
    public cb.f f524c = new cb.f();

    /* renamed from: d, reason: collision with root package name */
    public byte[] f525d = new byte[2];

    public g() {
        i();
    }

    @Override // ab.b
    public String c() {
        return za.b.f21200h;
    }

    @Override // ab.b
    public float d() {
        return this.f524c.a();
    }

    @Override // ab.b
    public b.a e() {
        return this.f523b;
    }

    @Override // ab.b
    public b.a f(byte[] bArr, int i10, int i11) {
        b.a aVar;
        int i12 = i11 + i10;
        for (int i13 = i10; i13 < i12; i13++) {
            int c10 = this.f522a.c(bArr[i13]);
            if (c10 == 1) {
                aVar = b.a.NOT_ME;
            } else if (c10 == 2) {
                aVar = b.a.FOUND_IT;
            } else {
                if (c10 == 0) {
                    int b10 = this.f522a.b();
                    if (i13 == i10) {
                        byte[] bArr2 = this.f525d;
                        bArr2[1] = bArr[i10];
                        this.f524c.d(bArr2, 0, b10);
                    } else {
                        this.f524c.d(bArr, i13 - 1, b10);
                    }
                }
            }
            this.f523b = aVar;
        }
        this.f525d[0] = bArr[i12 - 1];
        if (this.f523b == b.a.DETECTING && this.f524c.c() && d() > 0.95f) {
            this.f523b = b.a.FOUND_IT;
        }
        return this.f523b;
    }

    @Override // ab.b
    public void i() {
        this.f522a.d();
        this.f523b = b.a.DETECTING;
        this.f524c.e();
        Arrays.fill(this.f525d, (byte) 0);
    }
}
