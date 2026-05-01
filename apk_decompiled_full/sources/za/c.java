package za;

import ab.b;
import ab.f;
import ab.i;
import ab.j;
import ab.k;
import com.google.common.primitives.UnsignedBytes;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public a f21219a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f21220b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f21221c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f21222d;

    /* renamed from: e, reason: collision with root package name */
    public byte f21223e;

    /* renamed from: f, reason: collision with root package name */
    public String f21224f;

    /* renamed from: h, reason: collision with root package name */
    public ab.b f21226h = null;

    /* renamed from: g, reason: collision with root package name */
    public ab.b[] f21225g = new ab.b[3];

    public enum a {
        PURE_ASCII,
        ESC_ASCII,
        HIGHBYTE
    }

    public c(za.a aVar) {
        int i10 = 0;
        while (true) {
            ab.b[] bVarArr = this.f21225g;
            if (i10 >= bVarArr.length) {
                e();
                return;
            } else {
                bVarArr[i10] = null;
                i10++;
            }
        }
    }

    public void a() {
        ab.b[] bVarArr;
        if (this.f21222d) {
            if (this.f21224f != null) {
                this.f21220b = true;
                return;
            }
            if (this.f21219a == a.HIGHBYTE) {
                int i10 = 0;
                int i11 = 0;
                float f10 = 0.0f;
                while (true) {
                    bVarArr = this.f21225g;
                    if (i10 >= bVarArr.length) {
                        break;
                    }
                    float d10 = bVarArr[i10].d();
                    if (d10 > f10) {
                        i11 = i10;
                        f10 = d10;
                    }
                    i10++;
                }
                if (f10 > 0.2f) {
                    this.f21224f = bVarArr[i11].c();
                }
            }
        }
    }

    public String b() {
        return this.f21224f;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(byte[] bArr, int i10, int i11) {
        String str;
        if (this.f21220b) {
            return;
        }
        if (i11 > 0) {
            this.f21222d = true;
        }
        int i12 = 0;
        if (this.f21221c) {
            this.f21221c = false;
            if (i11 > 3) {
                int i13 = bArr[i10] & UnsignedBytes.MAX_VALUE;
                int i14 = bArr[i10 + 1] & UnsignedBytes.MAX_VALUE;
                int i15 = bArr[i10 + 2] & UnsignedBytes.MAX_VALUE;
                int i16 = bArr[i10 + 3] & UnsignedBytes.MAX_VALUE;
                if (i13 == 0) {
                    if (i14 == 0 && i15 == 254 && i16 == 255) {
                        str = b.f21216x;
                    } else {
                        if (i14 == 0 && i15 == 255 && i16 == 254) {
                            str = b.B;
                        }
                        if (this.f21224f != null) {
                        }
                    }
                    this.f21224f = str;
                    if (this.f21224f != null) {
                    }
                } else if (i13 == 239) {
                    if (i14 == 187 && i15 == 191) {
                        str = b.f21213u;
                        this.f21224f = str;
                    }
                    if (this.f21224f != null) {
                    }
                } else if (i13 != 254) {
                    if (i13 == 255) {
                        if (i14 == 254 && i15 == 0 && i16 == 0) {
                            str = b.f21217y;
                        } else if (i14 == 254) {
                            str = b.f21215w;
                        }
                        this.f21224f = str;
                    }
                    if (this.f21224f != null) {
                        this.f21220b = true;
                        return;
                    }
                } else {
                    if (i14 == 255 && i15 == 0 && i16 == 0) {
                        str = b.A;
                    } else {
                        if (i14 == 255) {
                            str = b.f21214v;
                        }
                        if (this.f21224f != null) {
                        }
                    }
                    this.f21224f = str;
                    if (this.f21224f != null) {
                    }
                }
            }
        }
        int i17 = i10 + i11;
        for (int i18 = i10; i18 < i17; i18++) {
            byte b10 = bArr[i18];
            int i19 = b10 & UnsignedBytes.MAX_VALUE;
            if ((i19 & 128) == 0 || i19 == 160) {
                if (this.f21219a == a.PURE_ASCII && (i19 == 27 || (i19 == 123 && this.f21223e == 126))) {
                    this.f21219a = a.ESC_ASCII;
                }
                this.f21223e = b10;
            } else {
                a aVar = this.f21219a;
                a aVar2 = a.HIGHBYTE;
                if (aVar != aVar2) {
                    this.f21219a = aVar2;
                    if (this.f21226h != null) {
                        this.f21226h = null;
                    }
                    ab.b[] bVarArr = this.f21225g;
                    if (bVarArr[0] == null) {
                        bVarArr[0] = new j();
                    }
                    ab.b[] bVarArr2 = this.f21225g;
                    if (bVarArr2[1] == null) {
                        bVarArr2[1] = new k();
                    }
                    ab.b[] bVarArr3 = this.f21225g;
                    if (bVarArr3[2] == null) {
                        bVarArr3[2] = new i();
                    }
                }
            }
        }
        a aVar3 = this.f21219a;
        if (aVar3 == a.ESC_ASCII) {
            if (this.f21226h == null) {
                this.f21226h = new f();
            }
            if (this.f21226h.f(bArr, i10, i11) == b.a.FOUND_IT) {
                this.f21220b = true;
                this.f21224f = this.f21226h.c();
                return;
            }
            return;
        }
        if (aVar3 != a.HIGHBYTE) {
            return;
        }
        while (true) {
            ab.b[] bVarArr4 = this.f21225g;
            if (i12 >= bVarArr4.length) {
                return;
            }
            if (bVarArr4[i12].f(bArr, i10, i11) == b.a.FOUND_IT) {
                this.f21220b = true;
                this.f21224f = this.f21225g[i12].c();
                return;
            }
            i12++;
        }
    }

    public boolean d() {
        return this.f21220b;
    }

    public void e() {
        int i10 = 0;
        this.f21220b = false;
        this.f21221c = true;
        this.f21224f = null;
        this.f21222d = false;
        this.f21219a = a.PURE_ASCII;
        this.f21223e = (byte) 0;
        ab.b bVar = this.f21226h;
        if (bVar != null) {
            bVar.i();
        }
        while (true) {
            ab.b[] bVarArr = this.f21225g;
            if (i10 >= bVarArr.length) {
                return;
            }
            ab.b bVar2 = bVarArr[i10];
            if (bVar2 != null) {
                bVar2.i();
            }
            i10++;
        }
    }
}
