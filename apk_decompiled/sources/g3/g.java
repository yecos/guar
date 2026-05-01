package g3;

import c3.h;
import c3.m;
import c3.o;
import c3.p;
import c3.q;
import com.google.common.primitives.UnsignedBytes;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class g extends b {
    public static final byte[] A = f3.a.c();
    public static final byte[] B = {110, 117, 108, 108};
    public static final byte[] C = {116, 114, 117, 101};
    public static final byte[] D = {102, 97, 108, 115, 101};

    /* renamed from: r, reason: collision with root package name */
    public final OutputStream f13612r;

    /* renamed from: s, reason: collision with root package name */
    public byte f13613s;

    /* renamed from: t, reason: collision with root package name */
    public byte[] f13614t;

    /* renamed from: u, reason: collision with root package name */
    public int f13615u;

    /* renamed from: v, reason: collision with root package name */
    public final int f13616v;

    /* renamed from: w, reason: collision with root package name */
    public final int f13617w;

    /* renamed from: x, reason: collision with root package name */
    public char[] f13618x;

    /* renamed from: y, reason: collision with root package name */
    public final int f13619y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f13620z;

    public g(f3.c cVar, int i10, o oVar, OutputStream outputStream, char c10) {
        super(cVar, i10, oVar);
        this.f13612r = outputStream;
        this.f13613s = (byte) c10;
        if (c10 != '\"') {
            this.f13567l = f3.a.f(c10);
        }
        this.f13620z = true;
        byte[] h10 = cVar.h();
        this.f13614t = h10;
        int length = h10.length;
        this.f13616v = length;
        this.f13617w = length >> 3;
        char[] e10 = cVar.e();
        this.f13618x = e10;
        this.f13619y = e10.length;
        if (v(h.b.ESCAPE_NON_ASCII)) {
            E(127);
        }
    }

    @Override // c3.h
    public void A0(char[] cArr, int i10, int i11) {
        I0("write a string");
        if (this.f13615u >= this.f13616v) {
            L0();
        }
        byte[] bArr = this.f13614t;
        int i12 = this.f13615u;
        int i13 = i12 + 1;
        this.f13615u = i13;
        bArr[i12] = this.f13613s;
        if (i11 <= this.f13617w) {
            if (i13 + i11 > this.f13616v) {
                L0();
            }
            g1(cArr, i10, i11);
        } else {
            n1(cArr, i10, i11);
        }
        if (this.f13615u >= this.f13616v) {
            L0();
        }
        byte[] bArr2 = this.f13614t;
        int i14 = this.f13615u;
        this.f13615u = i14 + 1;
        bArr2[i14] = this.f13613s;
    }

    @Override // d3.a
    public final void I0(String str) {
        byte b10;
        int x10 = this.f12479h.x();
        if (this.f5434a != null) {
            K0(str, x10);
            return;
        }
        if (x10 == 1) {
            b10 = 44;
        } else {
            if (x10 != 2) {
                if (x10 != 3) {
                    if (x10 != 5) {
                        return;
                    }
                    J0(str);
                    return;
                }
                q qVar = this.f13569n;
                if (qVar != null) {
                    byte[] g10 = qVar.g();
                    if (g10.length > 0) {
                        U0(g10);
                        return;
                    }
                    return;
                }
                return;
            }
            b10 = 58;
        }
        if (this.f13615u >= this.f13616v) {
            L0();
        }
        byte[] bArr = this.f13614t;
        int i10 = this.f13615u;
        this.f13615u = i10 + 1;
        bArr[i10] = b10;
    }

    public final void L0() {
        int i10 = this.f13615u;
        if (i10 > 0) {
            this.f13615u = 0;
            this.f13612r.write(this.f13614t, 0, i10);
        }
    }

    public final int M0(int i10, int i11) {
        byte[] bArr = this.f13614t;
        if (i10 < 55296 || i10 > 57343) {
            int i12 = i11 + 1;
            bArr[i11] = (byte) ((i10 >> 12) | 224);
            int i13 = i12 + 1;
            bArr[i12] = (byte) (((i10 >> 6) & 63) | 128);
            int i14 = i13 + 1;
            bArr[i13] = (byte) ((i10 & 63) | 128);
            return i14;
        }
        int i15 = i11 + 1;
        bArr[i11] = 92;
        int i16 = i15 + 1;
        bArr[i15] = 117;
        int i17 = i16 + 1;
        byte[] bArr2 = A;
        bArr[i16] = bArr2[(i10 >> 12) & 15];
        int i18 = i17 + 1;
        bArr[i17] = bArr2[(i10 >> 8) & 15];
        int i19 = i18 + 1;
        bArr[i18] = bArr2[(i10 >> 4) & 15];
        int i20 = i19 + 1;
        bArr[i19] = bArr2[i10 & 15];
        return i20;
    }

    public final int N0(int i10, char[] cArr, int i11, int i12) {
        if (i10 >= 55296 && i10 <= 57343) {
            if (i11 >= i12 || cArr == null) {
                a(String.format("Split surrogate on writeRaw() input (last character): first character 0x%4x", Integer.valueOf(i10)));
            } else {
                O0(i10, cArr[i11]);
            }
            return i11 + 1;
        }
        byte[] bArr = this.f13614t;
        int i13 = this.f13615u;
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((i10 >> 12) | 224);
        int i15 = i14 + 1;
        bArr[i14] = (byte) (((i10 >> 6) & 63) | 128);
        this.f13615u = i15 + 1;
        bArr[i15] = (byte) ((i10 & 63) | 128);
        return i11;
    }

    public final void O0(int i10, int i11) {
        int H0 = H0(i10, i11);
        if (this.f13615u + 4 > this.f13616v) {
            L0();
        }
        byte[] bArr = this.f13614t;
        int i12 = this.f13615u;
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((H0 >> 18) | 240);
        int i14 = i13 + 1;
        bArr[i13] = (byte) (((H0 >> 12) & 63) | 128);
        int i15 = i14 + 1;
        bArr[i14] = (byte) (((H0 >> 6) & 63) | 128);
        this.f13615u = i15 + 1;
        bArr[i15] = (byte) ((H0 & 63) | 128);
    }

    @Override // c3.h
    public int P(c3.a aVar, InputStream inputStream, int i10) {
        I0("write a binary value");
        if (this.f13615u >= this.f13616v) {
            L0();
        }
        byte[] bArr = this.f13614t;
        int i11 = this.f13615u;
        this.f13615u = i11 + 1;
        bArr[i11] = this.f13613s;
        byte[] d10 = this.f13566k.d();
        try {
            if (i10 < 0) {
                i10 = R0(aVar, inputStream, d10);
            } else {
                int S0 = S0(aVar, inputStream, d10, i10);
                if (S0 > 0) {
                    a("Too few bytes available: missing " + S0 + " bytes (out of " + i10 + ")");
                }
            }
            this.f13566k.l(d10);
            if (this.f13615u >= this.f13616v) {
                L0();
            }
            byte[] bArr2 = this.f13614t;
            int i12 = this.f13615u;
            this.f13615u = i12 + 1;
            bArr2[i12] = this.f13613s;
            return i10;
        } catch (Throwable th) {
            this.f13566k.l(d10);
            throw th;
        }
    }

    public final int P0(InputStream inputStream, byte[] bArr, int i10, int i11, int i12) {
        int i13 = 0;
        while (i10 < i11) {
            bArr[i13] = bArr[i10];
            i13++;
            i10++;
        }
        int min = Math.min(i12, bArr.length);
        do {
            int i14 = min - i13;
            if (i14 == 0) {
                break;
            }
            int read = inputStream.read(bArr, i13, i14);
            if (read < 0) {
                return i13;
            }
            i13 += read;
        } while (i13 < 3);
        return i13;
    }

    public void Q0() {
        byte[] bArr = this.f13614t;
        if (bArr != null && this.f13620z) {
            this.f13614t = null;
            this.f13566k.p(bArr);
        }
        char[] cArr = this.f13618x;
        if (cArr != null) {
            this.f13618x = null;
            this.f13566k.m(cArr);
        }
    }

    @Override // c3.h
    public void R(c3.a aVar, byte[] bArr, int i10, int i11) {
        I0("write a binary value");
        if (this.f13615u >= this.f13616v) {
            L0();
        }
        byte[] bArr2 = this.f13614t;
        int i12 = this.f13615u;
        this.f13615u = i12 + 1;
        bArr2[i12] = this.f13613s;
        T0(aVar, bArr, i10, i11 + i10);
        if (this.f13615u >= this.f13616v) {
            L0();
        }
        byte[] bArr3 = this.f13614t;
        int i13 = this.f13615u;
        this.f13615u = i13 + 1;
        bArr3[i13] = this.f13613s;
    }

    public final int R0(c3.a aVar, InputStream inputStream, byte[] bArr) {
        int i10 = this.f13616v - 6;
        int i11 = 2;
        int p10 = aVar.p() >> 2;
        int i12 = -3;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (true) {
            if (i13 > i12) {
                i14 = P0(inputStream, bArr, i13, i14, bArr.length);
                if (i14 < 3) {
                    break;
                }
                i12 = i14 - 3;
                i13 = 0;
            }
            if (this.f13615u > i10) {
                L0();
            }
            int i16 = i13 + 1;
            int i17 = bArr[i13] << 8;
            int i18 = i16 + 1;
            i13 = i18 + 1;
            i15 += 3;
            int j10 = aVar.j((((bArr[i16] & UnsignedBytes.MAX_VALUE) | i17) << 8) | (bArr[i18] & UnsignedBytes.MAX_VALUE), this.f13614t, this.f13615u);
            this.f13615u = j10;
            p10--;
            if (p10 <= 0) {
                byte[] bArr2 = this.f13614t;
                int i19 = j10 + 1;
                bArr2[j10] = 92;
                this.f13615u = i19 + 1;
                bArr2[i19] = 110;
                p10 = aVar.p() >> 2;
            }
        }
        if (i14 <= 0) {
            return i15;
        }
        if (this.f13615u > i10) {
            L0();
        }
        int i20 = bArr[0] << 16;
        if (1 < i14) {
            i20 |= (bArr[1] & UnsignedBytes.MAX_VALUE) << 8;
        } else {
            i11 = 1;
        }
        int i21 = i15 + i11;
        this.f13615u = aVar.m(i20, i11, this.f13614t, this.f13615u);
        return i21;
    }

    public final int S0(c3.a aVar, InputStream inputStream, byte[] bArr, int i10) {
        int P0;
        int i11 = this.f13616v - 6;
        int i12 = 2;
        int p10 = aVar.p() >> 2;
        int i13 = -3;
        int i14 = 0;
        int i15 = 0;
        while (true) {
            if (i10 <= 2) {
                break;
            }
            if (i14 > i13) {
                i15 = P0(inputStream, bArr, i14, i15, i10);
                if (i15 < 3) {
                    i14 = 0;
                    break;
                }
                i13 = i15 - 3;
                i14 = 0;
            }
            if (this.f13615u > i11) {
                L0();
            }
            int i16 = i14 + 1;
            int i17 = bArr[i14] << 8;
            int i18 = i16 + 1;
            i14 = i18 + 1;
            i10 -= 3;
            int j10 = aVar.j((((bArr[i16] & UnsignedBytes.MAX_VALUE) | i17) << 8) | (bArr[i18] & UnsignedBytes.MAX_VALUE), this.f13614t, this.f13615u);
            this.f13615u = j10;
            p10--;
            if (p10 <= 0) {
                byte[] bArr2 = this.f13614t;
                int i19 = j10 + 1;
                bArr2[j10] = 92;
                this.f13615u = i19 + 1;
                bArr2[i19] = 110;
                p10 = aVar.p() >> 2;
            }
        }
        if (i10 <= 0 || (P0 = P0(inputStream, bArr, i14, i15, i10)) <= 0) {
            return i10;
        }
        if (this.f13615u > i11) {
            L0();
        }
        int i20 = bArr[0] << 16;
        if (1 < P0) {
            i20 |= (bArr[1] & UnsignedBytes.MAX_VALUE) << 8;
        } else {
            i12 = 1;
        }
        this.f13615u = aVar.m(i20, i12, this.f13614t, this.f13615u);
        return i10 - i12;
    }

    public final void T0(c3.a aVar, byte[] bArr, int i10, int i11) {
        int i12 = i11 - 3;
        int i13 = this.f13616v - 6;
        int p10 = aVar.p() >> 2;
        while (i10 <= i12) {
            if (this.f13615u > i13) {
                L0();
            }
            int i14 = i10 + 1;
            int i15 = i14 + 1;
            int i16 = ((bArr[i10] << 8) | (bArr[i14] & UnsignedBytes.MAX_VALUE)) << 8;
            int i17 = i15 + 1;
            int j10 = aVar.j(i16 | (bArr[i15] & UnsignedBytes.MAX_VALUE), this.f13614t, this.f13615u);
            this.f13615u = j10;
            p10--;
            if (p10 <= 0) {
                byte[] bArr2 = this.f13614t;
                int i18 = j10 + 1;
                bArr2[j10] = 92;
                this.f13615u = i18 + 1;
                bArr2[i18] = 110;
                p10 = aVar.p() >> 2;
            }
            i10 = i17;
        }
        int i19 = i11 - i10;
        if (i19 > 0) {
            if (this.f13615u > i13) {
                L0();
            }
            int i20 = i10 + 1;
            int i21 = bArr[i10] << 16;
            if (i19 == 2) {
                i21 |= (bArr[i20] & UnsignedBytes.MAX_VALUE) << 8;
            }
            this.f13615u = aVar.m(i21, i19, this.f13614t, this.f13615u);
        }
    }

    @Override // c3.h
    public void U(boolean z10) {
        I0("write a boolean value");
        if (this.f13615u + 5 >= this.f13616v) {
            L0();
        }
        byte[] bArr = z10 ? C : D;
        int length = bArr.length;
        System.arraycopy(bArr, 0, this.f13614t, this.f13615u, length);
        this.f13615u += length;
    }

    public final void U0(byte[] bArr) {
        int length = bArr.length;
        if (this.f13615u + length > this.f13616v) {
            L0();
            if (length > 512) {
                this.f13612r.write(bArr, 0, length);
                return;
            }
        }
        System.arraycopy(bArr, 0, this.f13614t, this.f13615u, length);
        this.f13615u += length;
    }

    @Override // c3.h
    public final void V() {
        if (!this.f12479h.f()) {
            a("Current context not Array but " + this.f12479h.j());
        }
        p pVar = this.f5434a;
        if (pVar != null) {
            pVar.d(this, this.f12479h.d());
        } else {
            if (this.f13615u >= this.f13616v) {
                L0();
            }
            byte[] bArr = this.f13614t;
            int i10 = this.f13615u;
            this.f13615u = i10 + 1;
            bArr[i10] = 93;
        }
        this.f12479h = this.f12479h.l();
    }

    public final int V0(int i10, int i11) {
        int i12;
        byte[] bArr = this.f13614t;
        int i13 = i11 + 1;
        bArr[i11] = 92;
        int i14 = i13 + 1;
        bArr[i13] = 117;
        if (i10 > 255) {
            int i15 = 255 & (i10 >> 8);
            int i16 = i14 + 1;
            byte[] bArr2 = A;
            bArr[i14] = bArr2[i15 >> 4];
            i12 = i16 + 1;
            bArr[i16] = bArr2[i15 & 15];
            i10 &= 255;
        } else {
            int i17 = i14 + 1;
            bArr[i14] = 48;
            i12 = i17 + 1;
            bArr[i17] = 48;
        }
        int i18 = i12 + 1;
        byte[] bArr3 = A;
        bArr[i12] = bArr3[i10 >> 4];
        int i19 = i18 + 1;
        bArr[i18] = bArr3[i10 & 15];
        return i19;
    }

    @Override // c3.h
    public final void W() {
        if (!this.f12479h.g()) {
            a("Current context not Object but " + this.f12479h.j());
        }
        p pVar = this.f5434a;
        if (pVar != null) {
            pVar.i(this, this.f12479h.d());
        } else {
            if (this.f13615u >= this.f13616v) {
                L0();
            }
            byte[] bArr = this.f13614t;
            int i10 = this.f13615u;
            this.f13615u = i10 + 1;
            bArr[i10] = 125;
        }
        this.f12479h = this.f12479h.l();
    }

    public final void W0() {
        if (this.f13615u + 4 >= this.f13616v) {
            L0();
        }
        System.arraycopy(B, 0, this.f13614t, this.f13615u, 4);
        this.f13615u += 4;
    }

    public final void X0(q qVar) {
        int w10 = this.f12479h.w(qVar.getValue());
        if (w10 == 4) {
            a("Can not write a field name, expecting a value");
        }
        if (w10 == 1) {
            this.f5434a.a(this);
        } else {
            this.f5434a.k(this);
        }
        boolean z10 = !this.f13570o;
        if (z10) {
            if (this.f13615u >= this.f13616v) {
                L0();
            }
            byte[] bArr = this.f13614t;
            int i10 = this.f13615u;
            this.f13615u = i10 + 1;
            bArr[i10] = this.f13613s;
        }
        int d10 = qVar.d(this.f13614t, this.f13615u);
        if (d10 < 0) {
            U0(qVar.c());
        } else {
            this.f13615u += d10;
        }
        if (z10) {
            if (this.f13615u >= this.f13616v) {
                L0();
            }
            byte[] bArr2 = this.f13614t;
            int i11 = this.f13615u;
            this.f13615u = i11 + 1;
            bArr2[i11] = this.f13613s;
        }
    }

    @Override // c3.h
    public void Y(q qVar) {
        if (this.f5434a != null) {
            X0(qVar);
            return;
        }
        int w10 = this.f12479h.w(qVar.getValue());
        if (w10 == 4) {
            a("Can not write a field name, expecting a value");
        }
        if (w10 == 1) {
            if (this.f13615u >= this.f13616v) {
                L0();
            }
            byte[] bArr = this.f13614t;
            int i10 = this.f13615u;
            this.f13615u = i10 + 1;
            bArr[i10] = 44;
        }
        if (this.f13570o) {
            o1(qVar);
            return;
        }
        if (this.f13615u >= this.f13616v) {
            L0();
        }
        byte[] bArr2 = this.f13614t;
        int i11 = this.f13615u;
        int i12 = i11 + 1;
        this.f13615u = i12;
        bArr2[i11] = this.f13613s;
        int d10 = qVar.d(bArr2, i12);
        if (d10 < 0) {
            U0(qVar.c());
        } else {
            this.f13615u += d10;
        }
        if (this.f13615u >= this.f13616v) {
            L0();
        }
        byte[] bArr3 = this.f13614t;
        int i13 = this.f13615u;
        this.f13615u = i13 + 1;
        bArr3[i13] = this.f13613s;
    }

    public final void Y0(String str) {
        int w10 = this.f12479h.w(str);
        if (w10 == 4) {
            a("Can not write a field name, expecting a value");
        }
        if (w10 == 1) {
            this.f5434a.a(this);
        } else {
            this.f5434a.k(this);
        }
        if (this.f13570o) {
            m1(str, false);
            return;
        }
        int length = str.length();
        if (length > this.f13619y) {
            m1(str, true);
            return;
        }
        if (this.f13615u >= this.f13616v) {
            L0();
        }
        byte[] bArr = this.f13614t;
        int i10 = this.f13615u;
        this.f13615u = i10 + 1;
        bArr[i10] = this.f13613s;
        str.getChars(0, length, this.f13618x, 0);
        if (length <= this.f13617w) {
            if (this.f13615u + length > this.f13616v) {
                L0();
            }
            g1(this.f13618x, 0, length);
        } else {
            n1(this.f13618x, 0, length);
        }
        if (this.f13615u >= this.f13616v) {
            L0();
        }
        byte[] bArr2 = this.f13614t;
        int i11 = this.f13615u;
        this.f13615u = i11 + 1;
        bArr2[i11] = this.f13613s;
    }

    @Override // c3.h
    public void Z(String str) {
        if (this.f5434a != null) {
            Y0(str);
            return;
        }
        int w10 = this.f12479h.w(str);
        if (w10 == 4) {
            a("Can not write a field name, expecting a value");
        }
        if (w10 == 1) {
            if (this.f13615u >= this.f13616v) {
                L0();
            }
            byte[] bArr = this.f13614t;
            int i10 = this.f13615u;
            this.f13615u = i10 + 1;
            bArr[i10] = 44;
        }
        if (this.f13570o) {
            m1(str, false);
            return;
        }
        int length = str.length();
        if (length > this.f13619y) {
            m1(str, true);
            return;
        }
        if (this.f13615u >= this.f13616v) {
            L0();
        }
        byte[] bArr2 = this.f13614t;
        int i11 = this.f13615u;
        int i12 = i11 + 1;
        this.f13615u = i12;
        bArr2[i11] = this.f13613s;
        if (length <= this.f13617w) {
            if (i12 + length > this.f13616v) {
                L0();
            }
            f1(str, 0, length);
        } else {
            l1(str, 0, length);
        }
        if (this.f13615u >= this.f13616v) {
            L0();
        }
        byte[] bArr3 = this.f13614t;
        int i13 = this.f13615u;
        this.f13615u = i13 + 1;
        bArr3[i13] = this.f13613s;
    }

    public final void Z0(int i10) {
        if (this.f13615u + 13 >= this.f13616v) {
            L0();
        }
        byte[] bArr = this.f13614t;
        int i11 = this.f13615u;
        int i12 = i11 + 1;
        this.f13615u = i12;
        bArr[i11] = this.f13613s;
        int q10 = f3.g.q(i10, bArr, i12);
        byte[] bArr2 = this.f13614t;
        this.f13615u = q10 + 1;
        bArr2[q10] = this.f13613s;
    }

    @Override // c3.h
    public void a0() {
        I0("write a null");
        W0();
    }

    public final void a1(long j10) {
        if (this.f13615u + 23 >= this.f13616v) {
            L0();
        }
        byte[] bArr = this.f13614t;
        int i10 = this.f13615u;
        int i11 = i10 + 1;
        this.f13615u = i11;
        bArr[i10] = this.f13613s;
        int s10 = f3.g.s(j10, bArr, i11);
        byte[] bArr2 = this.f13614t;
        this.f13615u = s10 + 1;
        bArr2[s10] = this.f13613s;
    }

    @Override // c3.h
    public void b0(double d10) {
        if (this.f12478g || (f3.g.o(d10) && h.b.QUOTE_NON_NUMERIC_NUMBERS.c(this.f12477f))) {
            z0(String.valueOf(d10));
        } else {
            I0("write a number");
            o0(String.valueOf(d10));
        }
    }

    public final void b1(String str) {
        if (this.f13615u >= this.f13616v) {
            L0();
        }
        byte[] bArr = this.f13614t;
        int i10 = this.f13615u;
        this.f13615u = i10 + 1;
        bArr[i10] = this.f13613s;
        o0(str);
        if (this.f13615u >= this.f13616v) {
            L0();
        }
        byte[] bArr2 = this.f13614t;
        int i11 = this.f13615u;
        this.f13615u = i11 + 1;
        bArr2[i11] = this.f13613s;
    }

    @Override // c3.h
    public void c0(float f10) {
        if (this.f12478g || (f3.g.p(f10) && h.b.QUOTE_NON_NUMERIC_NUMBERS.c(this.f12477f))) {
            z0(String.valueOf(f10));
        } else {
            I0("write a number");
            o0(String.valueOf(f10));
        }
    }

    public final void c1(short s10) {
        if (this.f13615u + 8 >= this.f13616v) {
            L0();
        }
        byte[] bArr = this.f13614t;
        int i10 = this.f13615u;
        int i11 = i10 + 1;
        this.f13615u = i11;
        bArr[i10] = this.f13613s;
        int q10 = f3.g.q(s10, bArr, i11);
        byte[] bArr2 = this.f13614t;
        this.f13615u = q10 + 1;
        bArr2[q10] = this.f13613s;
    }

    @Override // d3.a, c3.h, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        if (this.f13614t != null && v(h.b.AUTO_CLOSE_JSON_CONTENT)) {
            while (true) {
                m s10 = s();
                if (!s10.f()) {
                    if (!s10.g()) {
                        break;
                    } else {
                        W();
                    }
                } else {
                    V();
                }
            }
        }
        L0();
        this.f13615u = 0;
        if (this.f13612r != null) {
            if (this.f13566k.k() || v(h.b.AUTO_CLOSE_TARGET)) {
                this.f13612r.close();
            } else if (v(h.b.FLUSH_PASSED_TO_STREAM)) {
                this.f13612r.flush();
            }
        }
        Q0();
    }

    @Override // c3.h
    public void d0(int i10) {
        I0("write a number");
        if (this.f13615u + 11 >= this.f13616v) {
            L0();
        }
        if (this.f12478g) {
            Z0(i10);
        } else {
            this.f13615u = f3.g.q(i10, this.f13614t, this.f13615u);
        }
    }

    public final void d1(char[] cArr, int i10, int i11) {
        while (i10 < i11) {
            do {
                char c10 = cArr[i10];
                if (c10 > 127) {
                    i10++;
                    if (c10 < 2048) {
                        byte[] bArr = this.f13614t;
                        int i12 = this.f13615u;
                        int i13 = i12 + 1;
                        bArr[i12] = (byte) ((c10 >> 6) | 192);
                        this.f13615u = i13 + 1;
                        bArr[i13] = (byte) ((c10 & '?') | 128);
                    } else {
                        i10 = N0(c10, cArr, i10, i11);
                    }
                } else {
                    byte[] bArr2 = this.f13614t;
                    int i14 = this.f13615u;
                    this.f13615u = i14 + 1;
                    bArr2[i14] = (byte) c10;
                    i10++;
                }
            } while (i10 < i11);
            return;
        }
    }

    @Override // c3.h
    public void e0(long j10) {
        I0("write a number");
        if (this.f12478g) {
            a1(j10);
            return;
        }
        if (this.f13615u + 21 >= this.f13616v) {
            L0();
        }
        this.f13615u = f3.g.s(j10, this.f13614t, this.f13615u);
    }

    public final void e1(char[] cArr, int i10, int i11) {
        int i12 = this.f13616v;
        byte[] bArr = this.f13614t;
        int i13 = i11 + i10;
        while (i10 < i13) {
            do {
                char c10 = cArr[i10];
                if (c10 >= 128) {
                    if (this.f13615u + 3 >= this.f13616v) {
                        L0();
                    }
                    int i14 = i10 + 1;
                    char c11 = cArr[i10];
                    if (c11 < 2048) {
                        int i15 = this.f13615u;
                        int i16 = i15 + 1;
                        bArr[i15] = (byte) ((c11 >> 6) | 192);
                        this.f13615u = i16 + 1;
                        bArr[i16] = (byte) ((c11 & '?') | 128);
                        i10 = i14;
                    } else {
                        i10 = N0(c11, cArr, i14, i13);
                    }
                } else {
                    if (this.f13615u >= i12) {
                        L0();
                    }
                    int i17 = this.f13615u;
                    this.f13615u = i17 + 1;
                    bArr[i17] = (byte) c10;
                    i10++;
                }
            } while (i10 < i13);
            return;
        }
    }

    @Override // c3.h
    public void f0(String str) {
        I0("write a number");
        if (str == null) {
            W0();
        } else if (this.f12478g) {
            b1(str);
        } else {
            o0(str);
        }
    }

    public final void f1(String str, int i10, int i11) {
        int i12 = i11 + i10;
        int i13 = this.f13615u;
        byte[] bArr = this.f13614t;
        int[] iArr = this.f13567l;
        while (i10 < i12) {
            char charAt = str.charAt(i10);
            if (charAt > 127 || iArr[charAt] != 0) {
                break;
            }
            bArr[i13] = (byte) charAt;
            i10++;
            i13++;
        }
        this.f13615u = i13;
        if (i10 < i12) {
            if (this.f13568m == 0) {
                h1(str, i10, i12);
            } else {
                j1(str, i10, i12);
            }
        }
    }

    @Override // c3.h, java.io.Flushable
    public void flush() {
        L0();
        if (this.f13612r == null || !v(h.b.FLUSH_PASSED_TO_STREAM)) {
            return;
        }
        this.f13612r.flush();
    }

    @Override // c3.h
    public void g0(BigDecimal bigDecimal) {
        I0("write a number");
        if (bigDecimal == null) {
            W0();
        } else if (this.f12478g) {
            b1(F0(bigDecimal));
        } else {
            o0(F0(bigDecimal));
        }
    }

    public final void g1(char[] cArr, int i10, int i11) {
        int i12 = i11 + i10;
        int i13 = this.f13615u;
        byte[] bArr = this.f13614t;
        int[] iArr = this.f13567l;
        while (i10 < i12) {
            char c10 = cArr[i10];
            if (c10 > 127 || iArr[c10] != 0) {
                break;
            }
            bArr[i13] = (byte) c10;
            i10++;
            i13++;
        }
        this.f13615u = i13;
        if (i10 < i12) {
            if (this.f13568m == 0) {
                i1(cArr, i10, i12);
            } else {
                k1(cArr, i10, i12);
            }
        }
    }

    @Override // c3.h
    public void h0(BigInteger bigInteger) {
        I0("write a number");
        if (bigInteger == null) {
            W0();
        } else if (this.f12478g) {
            b1(bigInteger.toString());
        } else {
            o0(bigInteger.toString());
        }
    }

    public final void h1(String str, int i10, int i11) {
        if (this.f13615u + ((i11 - i10) * 6) > this.f13616v) {
            L0();
        }
        int i12 = this.f13615u;
        byte[] bArr = this.f13614t;
        int[] iArr = this.f13567l;
        while (i10 < i11) {
            int i13 = i10 + 1;
            char charAt = str.charAt(i10);
            if (charAt <= 127) {
                int i14 = iArr[charAt];
                if (i14 == 0) {
                    bArr[i12] = (byte) charAt;
                    i10 = i13;
                    i12++;
                } else if (i14 > 0) {
                    int i15 = i12 + 1;
                    bArr[i12] = 92;
                    i12 = i15 + 1;
                    bArr[i15] = (byte) i14;
                } else {
                    i12 = V0(charAt, i12);
                }
            } else if (charAt <= 2047) {
                int i16 = i12 + 1;
                bArr[i12] = (byte) ((charAt >> 6) | 192);
                i12 = i16 + 1;
                bArr[i16] = (byte) ((charAt & '?') | 128);
            } else {
                i12 = M0(charAt, i12);
            }
            i10 = i13;
        }
        this.f13615u = i12;
    }

    @Override // c3.h
    public void i0(short s10) {
        I0("write a number");
        if (this.f13615u + 6 >= this.f13616v) {
            L0();
        }
        if (this.f12478g) {
            c1(s10);
        } else {
            this.f13615u = f3.g.q(s10, this.f13614t, this.f13615u);
        }
    }

    public final void i1(char[] cArr, int i10, int i11) {
        if (this.f13615u + ((i11 - i10) * 6) > this.f13616v) {
            L0();
        }
        int i12 = this.f13615u;
        byte[] bArr = this.f13614t;
        int[] iArr = this.f13567l;
        while (i10 < i11) {
            int i13 = i10 + 1;
            char c10 = cArr[i10];
            if (c10 <= 127) {
                int i14 = iArr[c10];
                if (i14 == 0) {
                    bArr[i12] = (byte) c10;
                    i10 = i13;
                    i12++;
                } else if (i14 > 0) {
                    int i15 = i12 + 1;
                    bArr[i12] = 92;
                    i12 = i15 + 1;
                    bArr[i15] = (byte) i14;
                } else {
                    i12 = V0(c10, i12);
                }
            } else if (c10 <= 2047) {
                int i16 = i12 + 1;
                bArr[i12] = (byte) ((c10 >> 6) | 192);
                i12 = i16 + 1;
                bArr[i16] = (byte) ((c10 & '?') | 128);
            } else {
                i12 = M0(c10, i12);
            }
            i10 = i13;
        }
        this.f13615u = i12;
    }

    public final void j1(String str, int i10, int i11) {
        if (this.f13615u + ((i11 - i10) * 6) > this.f13616v) {
            L0();
        }
        int i12 = this.f13615u;
        byte[] bArr = this.f13614t;
        int[] iArr = this.f13567l;
        int i13 = this.f13568m;
        while (i10 < i11) {
            int i14 = i10 + 1;
            char charAt = str.charAt(i10);
            if (charAt <= 127) {
                int i15 = iArr[charAt];
                if (i15 == 0) {
                    bArr[i12] = (byte) charAt;
                    i10 = i14;
                    i12++;
                } else if (i15 > 0) {
                    int i16 = i12 + 1;
                    bArr[i12] = 92;
                    i12 = i16 + 1;
                    bArr[i16] = (byte) i15;
                } else {
                    i12 = V0(charAt, i12);
                }
            } else if (charAt > i13) {
                i12 = V0(charAt, i12);
            } else if (charAt <= 2047) {
                int i17 = i12 + 1;
                bArr[i12] = (byte) ((charAt >> 6) | 192);
                i12 = i17 + 1;
                bArr[i17] = (byte) ((charAt & '?') | 128);
            } else {
                i12 = M0(charAt, i12);
            }
            i10 = i14;
        }
        this.f13615u = i12;
    }

    public final void k1(char[] cArr, int i10, int i11) {
        if (this.f13615u + ((i11 - i10) * 6) > this.f13616v) {
            L0();
        }
        int i12 = this.f13615u;
        byte[] bArr = this.f13614t;
        int[] iArr = this.f13567l;
        int i13 = this.f13568m;
        while (i10 < i11) {
            int i14 = i10 + 1;
            char c10 = cArr[i10];
            if (c10 <= 127) {
                int i15 = iArr[c10];
                if (i15 == 0) {
                    bArr[i12] = (byte) c10;
                    i10 = i14;
                    i12++;
                } else if (i15 > 0) {
                    int i16 = i12 + 1;
                    bArr[i12] = 92;
                    i12 = i16 + 1;
                    bArr[i16] = (byte) i15;
                } else {
                    i12 = V0(c10, i12);
                }
            } else if (c10 > i13) {
                i12 = V0(c10, i12);
            } else if (c10 <= 2047) {
                int i17 = i12 + 1;
                bArr[i12] = (byte) ((c10 >> 6) | 192);
                i12 = i17 + 1;
                bArr[i17] = (byte) ((c10 & '?') | 128);
            } else {
                i12 = M0(c10, i12);
            }
            i10 = i14;
        }
        this.f13615u = i12;
    }

    public final void l1(String str, int i10, int i11) {
        do {
            int min = Math.min(this.f13617w, i11);
            if (this.f13615u + min > this.f13616v) {
                L0();
            }
            f1(str, i10, min);
            i10 += min;
            i11 -= min;
        } while (i11 > 0);
    }

    @Override // c3.h
    public void m0(char c10) {
        if (this.f13615u + 3 >= this.f13616v) {
            L0();
        }
        byte[] bArr = this.f13614t;
        if (c10 <= 127) {
            int i10 = this.f13615u;
            this.f13615u = i10 + 1;
            bArr[i10] = (byte) c10;
        } else {
            if (c10 >= 2048) {
                N0(c10, null, 0, 0);
                return;
            }
            int i11 = this.f13615u;
            int i12 = i11 + 1;
            bArr[i11] = (byte) ((c10 >> 6) | 192);
            this.f13615u = i12 + 1;
            bArr[i12] = (byte) ((c10 & '?') | 128);
        }
    }

    public final void m1(String str, boolean z10) {
        if (z10) {
            if (this.f13615u >= this.f13616v) {
                L0();
            }
            byte[] bArr = this.f13614t;
            int i10 = this.f13615u;
            this.f13615u = i10 + 1;
            bArr[i10] = this.f13613s;
        }
        int length = str.length();
        int i11 = 0;
        while (length > 0) {
            int min = Math.min(this.f13617w, length);
            if (this.f13615u + min > this.f13616v) {
                L0();
            }
            f1(str, i11, min);
            i11 += min;
            length -= min;
        }
        if (z10) {
            if (this.f13615u >= this.f13616v) {
                L0();
            }
            byte[] bArr2 = this.f13614t;
            int i12 = this.f13615u;
            this.f13615u = i12 + 1;
            bArr2[i12] = this.f13613s;
        }
    }

    @Override // c3.h
    public void n0(q qVar) {
        int f10 = qVar.f(this.f13614t, this.f13615u);
        if (f10 < 0) {
            U0(qVar.g());
        } else {
            this.f13615u += f10;
        }
    }

    public final void n1(char[] cArr, int i10, int i11) {
        do {
            int min = Math.min(this.f13617w, i11);
            if (this.f13615u + min > this.f13616v) {
                L0();
            }
            g1(cArr, i10, min);
            i10 += min;
            i11 -= min;
        } while (i11 > 0);
    }

    @Override // c3.h
    public void o0(String str) {
        int length = str.length();
        char[] cArr = this.f13618x;
        if (length > cArr.length) {
            p1(str, 0, length);
        } else {
            str.getChars(0, length, cArr, 0);
            p0(cArr, 0, length);
        }
    }

    public final void o1(q qVar) {
        int d10 = qVar.d(this.f13614t, this.f13615u);
        if (d10 < 0) {
            U0(qVar.c());
        } else {
            this.f13615u += d10;
        }
    }

    @Override // c3.h
    public final void p0(char[] cArr, int i10, int i11) {
        int i12 = i11 + i11 + i11;
        int i13 = this.f13615u + i12;
        int i14 = this.f13616v;
        if (i13 > i14) {
            if (i14 < i12) {
                e1(cArr, i10, i11);
                return;
            }
            L0();
        }
        int i15 = i11 + i10;
        while (i10 < i15) {
            do {
                char c10 = cArr[i10];
                if (c10 > 127) {
                    i10++;
                    if (c10 < 2048) {
                        byte[] bArr = this.f13614t;
                        int i16 = this.f13615u;
                        int i17 = i16 + 1;
                        bArr[i16] = (byte) ((c10 >> 6) | 192);
                        this.f13615u = i17 + 1;
                        bArr[i17] = (byte) ((c10 & '?') | 128);
                    } else {
                        i10 = N0(c10, cArr, i10, i15);
                    }
                } else {
                    byte[] bArr2 = this.f13614t;
                    int i18 = this.f13615u;
                    this.f13615u = i18 + 1;
                    bArr2[i18] = (byte) c10;
                    i10++;
                }
            } while (i10 < i15);
            return;
        }
    }

    public void p1(String str, int i10, int i11) {
        char c10;
        char[] cArr = this.f13618x;
        int length = cArr.length;
        if (i11 <= length) {
            str.getChars(i10, i10 + i11, cArr, 0);
            p0(cArr, 0, i11);
            return;
        }
        int i12 = this.f13616v;
        int min = Math.min(length, (i12 >> 2) + (i12 >> 4));
        int i13 = min * 3;
        while (i11 > 0) {
            int min2 = Math.min(min, i11);
            str.getChars(i10, i10 + min2, cArr, 0);
            if (this.f13615u + i13 > this.f13616v) {
                L0();
            }
            if (min2 > 1 && (c10 = cArr[min2 - 1]) >= 55296 && c10 <= 56319) {
                min2--;
            }
            d1(cArr, 0, min2);
            i10 += min2;
            i11 -= min2;
        }
    }

    @Override // d3.a, c3.h
    public void q0(q qVar) {
        I0("write a raw (unencoded) value");
        int f10 = qVar.f(this.f13614t, this.f13615u);
        if (f10 < 0) {
            U0(qVar.g());
        } else {
            this.f13615u += f10;
        }
    }

    @Override // c3.h
    public final void s0() {
        I0("start an array");
        this.f12479h = this.f12479h.m();
        p pVar = this.f5434a;
        if (pVar != null) {
            pVar.b(this);
            return;
        }
        if (this.f13615u >= this.f13616v) {
            L0();
        }
        byte[] bArr = this.f13614t;
        int i10 = this.f13615u;
        this.f13615u = i10 + 1;
        bArr[i10] = 91;
    }

    @Override // c3.h
    public final void t0(Object obj) {
        I0("start an array");
        this.f12479h = this.f12479h.n(obj);
        p pVar = this.f5434a;
        if (pVar != null) {
            pVar.b(this);
            return;
        }
        if (this.f13615u >= this.f13616v) {
            L0();
        }
        byte[] bArr = this.f13614t;
        int i10 = this.f13615u;
        this.f13615u = i10 + 1;
        bArr[i10] = 91;
    }

    @Override // c3.h
    public void u0(Object obj, int i10) {
        I0("start an array");
        this.f12479h = this.f12479h.n(obj);
        p pVar = this.f5434a;
        if (pVar != null) {
            pVar.b(this);
            return;
        }
        if (this.f13615u >= this.f13616v) {
            L0();
        }
        byte[] bArr = this.f13614t;
        int i11 = this.f13615u;
        this.f13615u = i11 + 1;
        bArr[i11] = 91;
    }

    @Override // c3.h
    public final void v0() {
        I0("start an object");
        this.f12479h = this.f12479h.o();
        p pVar = this.f5434a;
        if (pVar != null) {
            pVar.e(this);
            return;
        }
        if (this.f13615u >= this.f13616v) {
            L0();
        }
        byte[] bArr = this.f13614t;
        int i10 = this.f13615u;
        this.f13615u = i10 + 1;
        bArr[i10] = 123;
    }

    @Override // c3.h
    public void w0(Object obj) {
        I0("start an object");
        this.f12479h = this.f12479h.p(obj);
        p pVar = this.f5434a;
        if (pVar != null) {
            pVar.e(this);
            return;
        }
        if (this.f13615u >= this.f13616v) {
            L0();
        }
        byte[] bArr = this.f13614t;
        int i10 = this.f13615u;
        this.f13615u = i10 + 1;
        bArr[i10] = 123;
    }

    @Override // c3.h
    public final void y0(q qVar) {
        I0("write a string");
        if (this.f13615u >= this.f13616v) {
            L0();
        }
        byte[] bArr = this.f13614t;
        int i10 = this.f13615u;
        int i11 = i10 + 1;
        this.f13615u = i11;
        bArr[i10] = this.f13613s;
        int d10 = qVar.d(bArr, i11);
        if (d10 < 0) {
            U0(qVar.c());
        } else {
            this.f13615u += d10;
        }
        if (this.f13615u >= this.f13616v) {
            L0();
        }
        byte[] bArr2 = this.f13614t;
        int i12 = this.f13615u;
        this.f13615u = i12 + 1;
        bArr2[i12] = this.f13613s;
    }

    @Override // c3.h
    public void z0(String str) {
        I0("write a string");
        if (str == null) {
            W0();
            return;
        }
        int length = str.length();
        if (length > this.f13617w) {
            m1(str, true);
            return;
        }
        if (this.f13615u + length >= this.f13616v) {
            L0();
        }
        byte[] bArr = this.f13614t;
        int i10 = this.f13615u;
        this.f13615u = i10 + 1;
        bArr[i10] = this.f13613s;
        f1(str, 0, length);
        if (this.f13615u >= this.f13616v) {
            L0();
        }
        byte[] bArr2 = this.f13614t;
        int i11 = this.f13615u;
        this.f13615u = i11 + 1;
        bArr2[i11] = this.f13613s;
    }
}
