package ab;

import ab.b;
import com.google.common.primitives.UnsignedBytes;

/* loaded from: classes.dex */
public class h extends b {

    /* renamed from: a, reason: collision with root package name */
    public int f526a;

    /* renamed from: b, reason: collision with root package name */
    public int f527b;

    /* renamed from: c, reason: collision with root package name */
    public byte f528c;

    /* renamed from: d, reason: collision with root package name */
    public byte f529d;

    /* renamed from: e, reason: collision with root package name */
    public b f530e = null;

    /* renamed from: f, reason: collision with root package name */
    public b f531f = null;

    public h() {
        i();
    }

    public static boolean j(byte b10) {
        int i10 = b10 & UnsignedBytes.MAX_VALUE;
        return i10 == 234 || i10 == 237 || i10 == 239 || i10 == 243 || i10 == 245;
    }

    public static boolean k(byte b10) {
        int i10 = b10 & UnsignedBytes.MAX_VALUE;
        return i10 == 235 || i10 == 238 || i10 == 240 || i10 == 244;
    }

    @Override // ab.b
    public String c() {
        int i10 = this.f526a - this.f527b;
        if (i10 >= 5) {
            return za.b.f21212t;
        }
        if (i10 <= -5) {
            return za.b.f21198f;
        }
        float d10 = this.f530e.d() - this.f531f.d();
        if (d10 > 0.01f) {
            return za.b.f21212t;
        }
        if (d10 >= -0.01f && i10 >= 0) {
            return za.b.f21212t;
        }
        return za.b.f21198f;
    }

    @Override // ab.b
    public float d() {
        return 0.0f;
    }

    @Override // ab.b
    public b.a e() {
        b.a e10 = this.f530e.e();
        b.a aVar = b.a.NOT_ME;
        return (e10 == aVar && this.f531f.e() == aVar) ? aVar : b.a.DETECTING;
    }

    @Override // ab.b
    public b.a f(byte[] bArr, int i10, int i11) {
        b.a e10 = e();
        b.a aVar = b.a.NOT_ME;
        if (e10 == aVar) {
            return aVar;
        }
        int i12 = i11 + i10;
        while (i10 < i12) {
            byte b10 = bArr[i10];
            byte b11 = this.f529d;
            if (b10 == 32) {
                if (b11 != 32) {
                    if (j(this.f528c)) {
                        this.f526a++;
                    } else {
                        if (!k(this.f528c)) {
                        }
                        this.f527b++;
                    }
                }
            } else if (b11 == 32) {
                if (j(this.f528c)) {
                    if (b10 == 32) {
                    }
                    this.f527b++;
                }
            }
            this.f529d = this.f528c;
            this.f528c = b10;
            i10++;
        }
        return b.a.DETECTING;
    }

    @Override // ab.b
    public void i() {
        this.f526a = 0;
        this.f527b = 0;
        this.f528c = (byte) 32;
        this.f529d = (byte) 32;
    }

    public void l(b bVar, b bVar2) {
        this.f530e = bVar;
        this.f531f = bVar2;
    }
}
