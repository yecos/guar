package ab;

import ab.b;
import com.google.common.primitives.UnsignedBytes;

/* loaded from: classes.dex */
public class j extends b {

    /* renamed from: a, reason: collision with root package name */
    public b.a f537a;

    /* renamed from: b, reason: collision with root package name */
    public b[] f538b;

    /* renamed from: c, reason: collision with root package name */
    public boolean[] f539c = new boolean[7];

    /* renamed from: d, reason: collision with root package name */
    public int f540d;

    /* renamed from: e, reason: collision with root package name */
    public int f541e;

    public j() {
        b[] bVarArr = new b[7];
        this.f538b = bVarArr;
        bVarArr[0] = new n();
        this.f538b[1] = new l();
        this.f538b[2] = new c();
        this.f538b[3] = new g();
        this.f538b[4] = new d();
        this.f538b[5] = new a();
        this.f538b[6] = new e();
        i();
    }

    @Override // ab.b
    public String c() {
        if (this.f540d == -1) {
            d();
            if (this.f540d == -1) {
                this.f540d = 0;
            }
        }
        return this.f538b[this.f540d].c();
    }

    @Override // ab.b
    public float d() {
        b.a aVar = this.f537a;
        if (aVar == b.a.FOUND_IT) {
            return 0.99f;
        }
        if (aVar == b.a.NOT_ME) {
            return 0.01f;
        }
        float f10 = 0.0f;
        int i10 = 0;
        while (true) {
            b[] bVarArr = this.f538b;
            if (i10 >= bVarArr.length) {
                return f10;
            }
            if (this.f539c[i10]) {
                float d10 = bVarArr[i10].d();
                if (f10 < d10) {
                    this.f540d = i10;
                    f10 = d10;
                }
            }
            i10++;
        }
    }

    @Override // ab.b
    public b.a e() {
        return this.f537a;
    }

    @Override // ab.b
    public b.a f(byte[] bArr, int i10, int i11) {
        b.a aVar;
        byte[] bArr2 = new byte[i11];
        int i12 = i11 + i10;
        boolean z10 = true;
        int i13 = 0;
        while (i10 < i12) {
            byte b10 = bArr[i10];
            if ((b10 & UnsignedBytes.MAX_POWER_OF_TWO) != 0) {
                bArr2[i13] = b10;
                i13++;
                z10 = true;
            } else if (z10) {
                bArr2[i13] = b10;
                i13++;
                z10 = false;
            }
            i10++;
        }
        int i14 = 0;
        while (true) {
            b[] bVarArr = this.f538b;
            if (i14 >= bVarArr.length) {
                break;
            }
            if (this.f539c[i14]) {
                b.a f10 = bVarArr[i14].f(bArr2, 0, i13);
                aVar = b.a.FOUND_IT;
                if (f10 == aVar) {
                    this.f540d = i14;
                    break;
                }
                aVar = b.a.NOT_ME;
                if (f10 == aVar) {
                    this.f539c[i14] = false;
                    int i15 = this.f541e - 1;
                    this.f541e = i15;
                    if (i15 <= 0) {
                        break;
                    }
                } else {
                    continue;
                }
            }
            i14++;
        }
        this.f537a = aVar;
        return this.f537a;
    }

    @Override // ab.b
    public void i() {
        int i10 = 0;
        this.f541e = 0;
        while (true) {
            b[] bVarArr = this.f538b;
            if (i10 >= bVarArr.length) {
                this.f540d = -1;
                this.f537a = b.a.DETECTING;
                return;
            } else {
                bVarArr[i10].i();
                this.f539c[i10] = true;
                this.f541e++;
                i10++;
            }
        }
    }
}
