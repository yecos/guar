package g3;

import c3.h;
import c3.m;
import c3.o;
import c3.p;
import c3.q;
import com.google.common.primitives.UnsignedBytes;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.InputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class h extends b {
    public static final char[] A = f3.a.d();

    /* renamed from: r, reason: collision with root package name */
    public final Writer f13621r;

    /* renamed from: s, reason: collision with root package name */
    public char f13622s;

    /* renamed from: t, reason: collision with root package name */
    public char[] f13623t;

    /* renamed from: u, reason: collision with root package name */
    public int f13624u;

    /* renamed from: v, reason: collision with root package name */
    public int f13625v;

    /* renamed from: w, reason: collision with root package name */
    public int f13626w;

    /* renamed from: x, reason: collision with root package name */
    public char[] f13627x;

    /* renamed from: y, reason: collision with root package name */
    public q f13628y;

    /* renamed from: z, reason: collision with root package name */
    public char[] f13629z;

    public h(f3.c cVar, int i10, o oVar, Writer writer, char c10) {
        super(cVar, i10, oVar);
        this.f13621r = writer;
        char[] e10 = cVar.e();
        this.f13623t = e10;
        this.f13626w = e10.length;
        this.f13622s = c10;
        if (c10 != '\"') {
            this.f13567l = f3.a.f(c10);
        }
    }

    @Override // c3.h
    public void A0(char[] cArr, int i10, int i11) {
        I0("write a string");
        if (this.f13625v >= this.f13626w) {
            N0();
        }
        char[] cArr2 = this.f13623t;
        int i12 = this.f13625v;
        this.f13625v = i12 + 1;
        cArr2[i12] = this.f13622s;
        j1(cArr, i10, i11);
        if (this.f13625v >= this.f13626w) {
            N0();
        }
        char[] cArr3 = this.f13623t;
        int i13 = this.f13625v;
        this.f13625v = i13 + 1;
        cArr3[i13] = this.f13622s;
    }

    @Override // d3.a
    public final void I0(String str) {
        char c10;
        int x10 = this.f12479h.x();
        if (this.f5434a != null) {
            K0(str, x10);
            return;
        }
        if (x10 == 1) {
            c10 = ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN;
        } else {
            if (x10 != 2) {
                if (x10 != 3) {
                    if (x10 != 5) {
                        return;
                    }
                    J0(str);
                    return;
                } else {
                    q qVar = this.f13569n;
                    if (qVar != null) {
                        o0(qVar.getValue());
                        return;
                    }
                    return;
                }
            }
            c10 = ASCIIPropertyListParser.DATE_TIME_FIELD_DELIMITER;
        }
        if (this.f13625v >= this.f13626w) {
            N0();
        }
        char[] cArr = this.f13623t;
        int i10 = this.f13625v;
        this.f13625v = i10 + 1;
        cArr[i10] = c10;
    }

    public final char[] L0() {
        char[] cArr = {ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN, 0, ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN, 'u', '0', '0', 0, 0, ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN, 'u', 0, 0, 0, 0};
        this.f13627x = cArr;
        return cArr;
    }

    public final void M0(char c10, int i10) {
        int i11;
        if (i10 >= 0) {
            if (this.f13625v + 2 > this.f13626w) {
                N0();
            }
            char[] cArr = this.f13623t;
            int i12 = this.f13625v;
            int i13 = i12 + 1;
            cArr[i12] = ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN;
            this.f13625v = i13 + 1;
            cArr[i13] = (char) i10;
            return;
        }
        if (i10 == -2) {
            q qVar = this.f13628y;
            qVar.getClass();
            String value = qVar.getValue();
            this.f13628y = null;
            int length = value.length();
            if (this.f13625v + length > this.f13626w) {
                N0();
                if (length > this.f13626w) {
                    this.f13621r.write(value);
                    return;
                }
            }
            value.getChars(0, length, this.f13623t, this.f13625v);
            this.f13625v += length;
            return;
        }
        if (this.f13625v + 5 >= this.f13626w) {
            N0();
        }
        int i14 = this.f13625v;
        char[] cArr2 = this.f13623t;
        int i15 = i14 + 1;
        cArr2[i14] = ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN;
        int i16 = i15 + 1;
        cArr2[i15] = 'u';
        if (c10 > 255) {
            int i17 = 255 & (c10 >> '\b');
            int i18 = i16 + 1;
            char[] cArr3 = A;
            cArr2[i16] = cArr3[i17 >> 4];
            i11 = i18 + 1;
            cArr2[i18] = cArr3[i17 & 15];
            c10 = (char) (c10 & 255);
        } else {
            int i19 = i16 + 1;
            cArr2[i16] = '0';
            i11 = i19 + 1;
            cArr2[i19] = '0';
        }
        int i20 = i11 + 1;
        char[] cArr4 = A;
        cArr2[i11] = cArr4[c10 >> 4];
        cArr2[i20] = cArr4[c10 & 15];
        this.f13625v = i20 + 1;
    }

    public void N0() {
        int i10 = this.f13625v;
        int i11 = this.f13624u;
        int i12 = i10 - i11;
        if (i12 > 0) {
            this.f13624u = 0;
            this.f13625v = 0;
            this.f13621r.write(this.f13623t, i11, i12);
        }
    }

    public final int O0(char[] cArr, int i10, int i11, char c10, int i12) {
        int i13;
        if (i12 >= 0) {
            if (i10 > 1 && i10 < i11) {
                int i14 = i10 - 2;
                cArr[i14] = ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN;
                cArr[i14 + 1] = (char) i12;
                return i14;
            }
            char[] cArr2 = this.f13627x;
            if (cArr2 == null) {
                cArr2 = L0();
            }
            cArr2[1] = (char) i12;
            this.f13621r.write(cArr2, 0, 2);
            return i10;
        }
        if (i12 == -2) {
            q qVar = this.f13628y;
            qVar.getClass();
            String value = qVar.getValue();
            this.f13628y = null;
            int length = value.length();
            if (i10 < length || i10 >= i11) {
                this.f13621r.write(value);
                return i10;
            }
            int i15 = i10 - length;
            value.getChars(0, length, cArr, i15);
            return i15;
        }
        if (i10 <= 5 || i10 >= i11) {
            char[] cArr3 = this.f13627x;
            if (cArr3 == null) {
                cArr3 = L0();
            }
            this.f13624u = this.f13625v;
            if (c10 <= 255) {
                char[] cArr4 = A;
                cArr3[6] = cArr4[c10 >> 4];
                cArr3[7] = cArr4[c10 & 15];
                this.f13621r.write(cArr3, 2, 6);
                return i10;
            }
            int i16 = (c10 >> '\b') & 255;
            int i17 = c10 & 255;
            char[] cArr5 = A;
            cArr3[10] = cArr5[i16 >> 4];
            cArr3[11] = cArr5[i16 & 15];
            cArr3[12] = cArr5[i17 >> 4];
            cArr3[13] = cArr5[i17 & 15];
            this.f13621r.write(cArr3, 8, 6);
            return i10;
        }
        int i18 = i10 - 6;
        int i19 = i18 + 1;
        cArr[i18] = ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN;
        int i20 = i19 + 1;
        cArr[i19] = 'u';
        if (c10 > 255) {
            int i21 = (c10 >> '\b') & 255;
            int i22 = i20 + 1;
            char[] cArr6 = A;
            cArr[i20] = cArr6[i21 >> 4];
            i13 = i22 + 1;
            cArr[i22] = cArr6[i21 & 15];
            c10 = (char) (c10 & 255);
        } else {
            int i23 = i20 + 1;
            cArr[i20] = '0';
            i13 = i23 + 1;
            cArr[i23] = '0';
        }
        int i24 = i13 + 1;
        char[] cArr7 = A;
        cArr[i13] = cArr7[c10 >> 4];
        cArr[i24] = cArr7[c10 & 15];
        return i24 - 5;
    }

    @Override // c3.h
    public int P(c3.a aVar, InputStream inputStream, int i10) {
        I0("write a binary value");
        if (this.f13625v >= this.f13626w) {
            N0();
        }
        char[] cArr = this.f13623t;
        int i11 = this.f13625v;
        this.f13625v = i11 + 1;
        cArr[i11] = this.f13622s;
        byte[] d10 = this.f13566k.d();
        try {
            if (i10 < 0) {
                i10 = S0(aVar, inputStream, d10);
            } else {
                int T0 = T0(aVar, inputStream, d10, i10);
                if (T0 > 0) {
                    a("Too few bytes available: missing " + T0 + " bytes (out of " + i10 + ")");
                }
            }
            this.f13566k.l(d10);
            if (this.f13625v >= this.f13626w) {
                N0();
            }
            char[] cArr2 = this.f13623t;
            int i12 = this.f13625v;
            this.f13625v = i12 + 1;
            cArr2[i12] = this.f13622s;
            return i10;
        } catch (Throwable th) {
            this.f13566k.l(d10);
            throw th;
        }
    }

    public final void P0(char c10, int i10) {
        int i11;
        if (i10 >= 0) {
            int i12 = this.f13625v;
            if (i12 >= 2) {
                int i13 = i12 - 2;
                this.f13624u = i13;
                char[] cArr = this.f13623t;
                cArr[i13] = ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN;
                cArr[i13 + 1] = (char) i10;
                return;
            }
            char[] cArr2 = this.f13627x;
            if (cArr2 == null) {
                cArr2 = L0();
            }
            this.f13624u = this.f13625v;
            cArr2[1] = (char) i10;
            this.f13621r.write(cArr2, 0, 2);
            return;
        }
        if (i10 == -2) {
            q qVar = this.f13628y;
            qVar.getClass();
            String value = qVar.getValue();
            this.f13628y = null;
            int length = value.length();
            int i14 = this.f13625v;
            if (i14 < length) {
                this.f13624u = i14;
                this.f13621r.write(value);
                return;
            } else {
                int i15 = i14 - length;
                this.f13624u = i15;
                value.getChars(0, length, this.f13623t, i15);
                return;
            }
        }
        int i16 = this.f13625v;
        if (i16 < 6) {
            char[] cArr3 = this.f13627x;
            if (cArr3 == null) {
                cArr3 = L0();
            }
            this.f13624u = this.f13625v;
            if (c10 <= 255) {
                char[] cArr4 = A;
                cArr3[6] = cArr4[c10 >> 4];
                cArr3[7] = cArr4[c10 & 15];
                this.f13621r.write(cArr3, 2, 6);
                return;
            }
            int i17 = (c10 >> '\b') & 255;
            int i18 = c10 & 255;
            char[] cArr5 = A;
            cArr3[10] = cArr5[i17 >> 4];
            cArr3[11] = cArr5[i17 & 15];
            cArr3[12] = cArr5[i18 >> 4];
            cArr3[13] = cArr5[i18 & 15];
            this.f13621r.write(cArr3, 8, 6);
            return;
        }
        char[] cArr6 = this.f13623t;
        int i19 = i16 - 6;
        this.f13624u = i19;
        cArr6[i19] = ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN;
        int i20 = i19 + 1;
        cArr6[i20] = 'u';
        if (c10 > 255) {
            int i21 = (c10 >> '\b') & 255;
            int i22 = i20 + 1;
            char[] cArr7 = A;
            cArr6[i22] = cArr7[i21 >> 4];
            i11 = i22 + 1;
            cArr6[i11] = cArr7[i21 & 15];
            c10 = (char) (c10 & 255);
        } else {
            int i23 = i20 + 1;
            cArr6[i23] = '0';
            i11 = i23 + 1;
            cArr6[i11] = '0';
        }
        int i24 = i11 + 1;
        char[] cArr8 = A;
        cArr6[i24] = cArr8[c10 >> 4];
        cArr6[i24 + 1] = cArr8[c10 & 15];
    }

    public final int Q0(InputStream inputStream, byte[] bArr, int i10, int i11, int i12) {
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

    @Override // c3.h
    public void R(c3.a aVar, byte[] bArr, int i10, int i11) {
        I0("write a binary value");
        if (this.f13625v >= this.f13626w) {
            N0();
        }
        char[] cArr = this.f13623t;
        int i12 = this.f13625v;
        this.f13625v = i12 + 1;
        cArr[i12] = this.f13622s;
        U0(aVar, bArr, i10, i11 + i10);
        if (this.f13625v >= this.f13626w) {
            N0();
        }
        char[] cArr2 = this.f13623t;
        int i13 = this.f13625v;
        this.f13625v = i13 + 1;
        cArr2[i13] = this.f13622s;
    }

    public void R0() {
        char[] cArr = this.f13623t;
        if (cArr != null) {
            this.f13623t = null;
            this.f13566k.m(cArr);
        }
        char[] cArr2 = this.f13629z;
        if (cArr2 != null) {
            this.f13629z = null;
            this.f13566k.n(cArr2);
        }
    }

    public final int S0(c3.a aVar, InputStream inputStream, byte[] bArr) {
        int i10 = this.f13626w - 6;
        int i11 = 2;
        int p10 = aVar.p() >> 2;
        int i12 = -3;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (true) {
            if (i13 > i12) {
                i14 = Q0(inputStream, bArr, i13, i14, bArr.length);
                if (i14 < 3) {
                    break;
                }
                i12 = i14 - 3;
                i13 = 0;
            }
            if (this.f13625v > i10) {
                N0();
            }
            int i16 = i13 + 1;
            int i17 = bArr[i13] << 8;
            int i18 = i16 + 1;
            i13 = i18 + 1;
            i15 += 3;
            int k10 = aVar.k((((bArr[i16] & UnsignedBytes.MAX_VALUE) | i17) << 8) | (bArr[i18] & UnsignedBytes.MAX_VALUE), this.f13623t, this.f13625v);
            this.f13625v = k10;
            p10--;
            if (p10 <= 0) {
                char[] cArr = this.f13623t;
                int i19 = k10 + 1;
                cArr[k10] = ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN;
                this.f13625v = i19 + 1;
                cArr[i19] = 'n';
                p10 = aVar.p() >> 2;
            }
        }
        if (i14 <= 0) {
            return i15;
        }
        if (this.f13625v > i10) {
            N0();
        }
        int i20 = bArr[0] << 16;
        if (1 < i14) {
            i20 |= (bArr[1] & UnsignedBytes.MAX_VALUE) << 8;
        } else {
            i11 = 1;
        }
        int i21 = i15 + i11;
        this.f13625v = aVar.n(i20, i11, this.f13623t, this.f13625v);
        return i21;
    }

    public final int T0(c3.a aVar, InputStream inputStream, byte[] bArr, int i10) {
        int Q0;
        int i11 = this.f13626w - 6;
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
                i15 = Q0(inputStream, bArr, i14, i15, i10);
                if (i15 < 3) {
                    i14 = 0;
                    break;
                }
                i13 = i15 - 3;
                i14 = 0;
            }
            if (this.f13625v > i11) {
                N0();
            }
            int i16 = i14 + 1;
            int i17 = bArr[i14] << 8;
            int i18 = i16 + 1;
            i14 = i18 + 1;
            i10 -= 3;
            int k10 = aVar.k((((bArr[i16] & UnsignedBytes.MAX_VALUE) | i17) << 8) | (bArr[i18] & UnsignedBytes.MAX_VALUE), this.f13623t, this.f13625v);
            this.f13625v = k10;
            p10--;
            if (p10 <= 0) {
                char[] cArr = this.f13623t;
                int i19 = k10 + 1;
                cArr[k10] = ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN;
                this.f13625v = i19 + 1;
                cArr[i19] = 'n';
                p10 = aVar.p() >> 2;
            }
        }
        if (i10 <= 0 || (Q0 = Q0(inputStream, bArr, i14, i15, i10)) <= 0) {
            return i10;
        }
        if (this.f13625v > i11) {
            N0();
        }
        int i20 = bArr[0] << 16;
        if (1 < Q0) {
            i20 |= (bArr[1] & UnsignedBytes.MAX_VALUE) << 8;
        } else {
            i12 = 1;
        }
        this.f13625v = aVar.n(i20, i12, this.f13623t, this.f13625v);
        return i10 - i12;
    }

    @Override // c3.h
    public void U(boolean z10) {
        int i10;
        I0("write a boolean value");
        if (this.f13625v + 5 >= this.f13626w) {
            N0();
        }
        int i11 = this.f13625v;
        char[] cArr = this.f13623t;
        if (z10) {
            cArr[i11] = 't';
            int i12 = i11 + 1;
            cArr[i12] = 'r';
            int i13 = i12 + 1;
            cArr[i13] = 'u';
            i10 = i13 + 1;
            cArr[i10] = 'e';
        } else {
            cArr[i11] = 'f';
            int i14 = i11 + 1;
            cArr[i14] = 'a';
            int i15 = i14 + 1;
            cArr[i15] = 'l';
            int i16 = i15 + 1;
            cArr[i16] = 's';
            i10 = i16 + 1;
            cArr[i10] = 'e';
        }
        this.f13625v = i10 + 1;
    }

    public final void U0(c3.a aVar, byte[] bArr, int i10, int i11) {
        int i12 = i11 - 3;
        int i13 = this.f13626w - 6;
        int p10 = aVar.p() >> 2;
        while (i10 <= i12) {
            if (this.f13625v > i13) {
                N0();
            }
            int i14 = i10 + 1;
            int i15 = i14 + 1;
            int i16 = ((bArr[i10] << 8) | (bArr[i14] & UnsignedBytes.MAX_VALUE)) << 8;
            int i17 = i15 + 1;
            int k10 = aVar.k(i16 | (bArr[i15] & UnsignedBytes.MAX_VALUE), this.f13623t, this.f13625v);
            this.f13625v = k10;
            p10--;
            if (p10 <= 0) {
                char[] cArr = this.f13623t;
                int i18 = k10 + 1;
                cArr[k10] = ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN;
                this.f13625v = i18 + 1;
                cArr[i18] = 'n';
                p10 = aVar.p() >> 2;
            }
            i10 = i17;
        }
        int i19 = i11 - i10;
        if (i19 > 0) {
            if (this.f13625v > i13) {
                N0();
            }
            int i20 = i10 + 1;
            int i21 = bArr[i10] << 16;
            if (i19 == 2) {
                i21 |= (bArr[i20] & UnsignedBytes.MAX_VALUE) << 8;
            }
            this.f13625v = aVar.n(i21, i19, this.f13623t, this.f13625v);
        }
    }

    @Override // c3.h
    public void V() {
        if (!this.f12479h.f()) {
            a("Current context not Array but " + this.f12479h.j());
        }
        p pVar = this.f5434a;
        if (pVar != null) {
            pVar.d(this, this.f12479h.d());
        } else {
            if (this.f13625v >= this.f13626w) {
                N0();
            }
            char[] cArr = this.f13623t;
            int i10 = this.f13625v;
            this.f13625v = i10 + 1;
            cArr[i10] = ']';
        }
        this.f12479h = this.f12479h.l();
    }

    public final void V0(q qVar, boolean z10) {
        if (this.f5434a != null) {
            a1(qVar, z10);
            return;
        }
        if (this.f13625v + 1 >= this.f13626w) {
            N0();
        }
        if (z10) {
            char[] cArr = this.f13623t;
            int i10 = this.f13625v;
            this.f13625v = i10 + 1;
            cArr[i10] = ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN;
        }
        if (this.f13570o) {
            char[] b10 = qVar.b();
            p0(b10, 0, b10.length);
            return;
        }
        char[] cArr2 = this.f13623t;
        int i11 = this.f13625v;
        int i12 = i11 + 1;
        this.f13625v = i12;
        cArr2[i11] = this.f13622s;
        int a10 = qVar.a(cArr2, i12);
        if (a10 < 0) {
            X0(qVar);
            return;
        }
        int i13 = this.f13625v + a10;
        this.f13625v = i13;
        if (i13 >= this.f13626w) {
            N0();
        }
        char[] cArr3 = this.f13623t;
        int i14 = this.f13625v;
        this.f13625v = i14 + 1;
        cArr3[i14] = this.f13622s;
    }

    @Override // c3.h
    public void W() {
        if (!this.f12479h.g()) {
            a("Current context not Object but " + this.f12479h.j());
        }
        p pVar = this.f5434a;
        if (pVar != null) {
            pVar.i(this, this.f12479h.d());
        } else {
            if (this.f13625v >= this.f13626w) {
                N0();
            }
            char[] cArr = this.f13623t;
            int i10 = this.f13625v;
            this.f13625v = i10 + 1;
            cArr[i10] = ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
        }
        this.f12479h = this.f12479h.l();
    }

    public final void W0(String str, boolean z10) {
        if (this.f5434a != null) {
            b1(str, z10);
            return;
        }
        if (this.f13625v + 1 >= this.f13626w) {
            N0();
        }
        if (z10) {
            char[] cArr = this.f13623t;
            int i10 = this.f13625v;
            this.f13625v = i10 + 1;
            cArr[i10] = ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN;
        }
        if (this.f13570o) {
            i1(str);
            return;
        }
        char[] cArr2 = this.f13623t;
        int i11 = this.f13625v;
        this.f13625v = i11 + 1;
        cArr2[i11] = this.f13622s;
        i1(str);
        if (this.f13625v >= this.f13626w) {
            N0();
        }
        char[] cArr3 = this.f13623t;
        int i12 = this.f13625v;
        this.f13625v = i12 + 1;
        cArr3[i12] = this.f13622s;
    }

    public final void X0(q qVar) {
        char[] b10 = qVar.b();
        p0(b10, 0, b10.length);
        if (this.f13625v >= this.f13626w) {
            N0();
        }
        char[] cArr = this.f13623t;
        int i10 = this.f13625v;
        this.f13625v = i10 + 1;
        cArr[i10] = this.f13622s;
    }

    @Override // c3.h
    public void Y(q qVar) {
        int w10 = this.f12479h.w(qVar.getValue());
        if (w10 == 4) {
            a("Can not write a field name, expecting a value");
        }
        V0(qVar, w10 == 1);
    }

    public final void Y0(String str) {
        N0();
        int length = str.length();
        int i10 = 0;
        while (true) {
            int i11 = this.f13626w;
            if (i10 + i11 > length) {
                i11 = length - i10;
            }
            int i12 = i10 + i11;
            str.getChars(i10, i12, this.f13623t, 0);
            int i13 = this.f13568m;
            if (i13 != 0) {
                h1(i11, i13);
            } else {
                g1(i11);
            }
            if (i12 >= length) {
                return;
            } else {
                i10 = i12;
            }
        }
    }

    @Override // c3.h
    public void Z(String str) {
        int w10 = this.f12479h.w(str);
        if (w10 == 4) {
            a("Can not write a field name, expecting a value");
        }
        W0(str, w10 == 1);
    }

    public final void Z0() {
        if (this.f13625v + 4 >= this.f13626w) {
            N0();
        }
        int i10 = this.f13625v;
        char[] cArr = this.f13623t;
        cArr[i10] = 'n';
        int i11 = i10 + 1;
        cArr[i11] = 'u';
        int i12 = i11 + 1;
        cArr[i12] = 'l';
        int i13 = i12 + 1;
        cArr[i13] = 'l';
        this.f13625v = i13 + 1;
    }

    @Override // c3.h
    public void a0() {
        I0("write a null");
        Z0();
    }

    public final void a1(q qVar, boolean z10) {
        if (z10) {
            this.f5434a.a(this);
        } else {
            this.f5434a.k(this);
        }
        char[] b10 = qVar.b();
        if (this.f13570o) {
            p0(b10, 0, b10.length);
            return;
        }
        if (this.f13625v >= this.f13626w) {
            N0();
        }
        char[] cArr = this.f13623t;
        int i10 = this.f13625v;
        this.f13625v = i10 + 1;
        cArr[i10] = this.f13622s;
        p0(b10, 0, b10.length);
        if (this.f13625v >= this.f13626w) {
            N0();
        }
        char[] cArr2 = this.f13623t;
        int i11 = this.f13625v;
        this.f13625v = i11 + 1;
        cArr2[i11] = this.f13622s;
    }

    @Override // c3.h
    public void b0(double d10) {
        if (this.f12478g || (f3.g.o(d10) && v(h.b.QUOTE_NON_NUMERIC_NUMBERS))) {
            z0(String.valueOf(d10));
        } else {
            I0("write a number");
            o0(String.valueOf(d10));
        }
    }

    public final void b1(String str, boolean z10) {
        if (z10) {
            this.f5434a.a(this);
        } else {
            this.f5434a.k(this);
        }
        if (this.f13570o) {
            i1(str);
            return;
        }
        if (this.f13625v >= this.f13626w) {
            N0();
        }
        char[] cArr = this.f13623t;
        int i10 = this.f13625v;
        this.f13625v = i10 + 1;
        cArr[i10] = this.f13622s;
        i1(str);
        if (this.f13625v >= this.f13626w) {
            N0();
        }
        char[] cArr2 = this.f13623t;
        int i11 = this.f13625v;
        this.f13625v = i11 + 1;
        cArr2[i11] = this.f13622s;
    }

    @Override // c3.h
    public void c0(float f10) {
        if (this.f12478g || (f3.g.p(f10) && v(h.b.QUOTE_NON_NUMERIC_NUMBERS))) {
            z0(String.valueOf(f10));
        } else {
            I0("write a number");
            o0(String.valueOf(f10));
        }
    }

    public final void c1(int i10) {
        if (this.f13625v + 13 >= this.f13626w) {
            N0();
        }
        char[] cArr = this.f13623t;
        int i11 = this.f13625v;
        int i12 = i11 + 1;
        this.f13625v = i12;
        cArr[i11] = this.f13622s;
        int r10 = f3.g.r(i10, cArr, i12);
        char[] cArr2 = this.f13623t;
        this.f13625v = r10 + 1;
        cArr2[r10] = this.f13622s;
    }

    @Override // d3.a, c3.h, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        if (this.f13623t != null && v(h.b.AUTO_CLOSE_JSON_CONTENT)) {
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
        N0();
        this.f13624u = 0;
        this.f13625v = 0;
        if (this.f13621r != null) {
            if (this.f13566k.k() || v(h.b.AUTO_CLOSE_TARGET)) {
                this.f13621r.close();
            } else if (v(h.b.FLUSH_PASSED_TO_STREAM)) {
                this.f13621r.flush();
            }
        }
        R0();
    }

    @Override // c3.h
    public void d0(int i10) {
        I0("write a number");
        if (this.f12478g) {
            c1(i10);
            return;
        }
        if (this.f13625v + 11 >= this.f13626w) {
            N0();
        }
        this.f13625v = f3.g.r(i10, this.f13623t, this.f13625v);
    }

    public final void d1(long j10) {
        if (this.f13625v + 23 >= this.f13626w) {
            N0();
        }
        char[] cArr = this.f13623t;
        int i10 = this.f13625v;
        int i11 = i10 + 1;
        this.f13625v = i11;
        cArr[i10] = this.f13622s;
        int t10 = f3.g.t(j10, cArr, i11);
        char[] cArr2 = this.f13623t;
        this.f13625v = t10 + 1;
        cArr2[t10] = this.f13622s;
    }

    @Override // c3.h
    public void e0(long j10) {
        I0("write a number");
        if (this.f12478g) {
            d1(j10);
            return;
        }
        if (this.f13625v + 21 >= this.f13626w) {
            N0();
        }
        this.f13625v = f3.g.t(j10, this.f13623t, this.f13625v);
    }

    public final void e1(String str) {
        if (this.f13625v >= this.f13626w) {
            N0();
        }
        char[] cArr = this.f13623t;
        int i10 = this.f13625v;
        this.f13625v = i10 + 1;
        cArr[i10] = this.f13622s;
        o0(str);
        if (this.f13625v >= this.f13626w) {
            N0();
        }
        char[] cArr2 = this.f13623t;
        int i11 = this.f13625v;
        this.f13625v = i11 + 1;
        cArr2[i11] = this.f13622s;
    }

    @Override // c3.h
    public void f0(String str) {
        I0("write a number");
        if (str == null) {
            Z0();
        } else if (this.f12478g) {
            e1(str);
        } else {
            o0(str);
        }
    }

    public final void f1(short s10) {
        if (this.f13625v + 8 >= this.f13626w) {
            N0();
        }
        char[] cArr = this.f13623t;
        int i10 = this.f13625v;
        int i11 = i10 + 1;
        this.f13625v = i11;
        cArr[i10] = this.f13622s;
        int r10 = f3.g.r(s10, cArr, i11);
        char[] cArr2 = this.f13623t;
        this.f13625v = r10 + 1;
        cArr2[r10] = this.f13622s;
    }

    @Override // c3.h, java.io.Flushable
    public void flush() {
        N0();
        if (this.f13621r == null || !v(h.b.FLUSH_PASSED_TO_STREAM)) {
            return;
        }
        this.f13621r.flush();
    }

    @Override // c3.h
    public void g0(BigDecimal bigDecimal) {
        I0("write a number");
        if (bigDecimal == null) {
            Z0();
        } else if (this.f12478g) {
            e1(F0(bigDecimal));
        } else {
            o0(F0(bigDecimal));
        }
    }

    public final void g1(int i10) {
        char[] cArr;
        char c10;
        int[] iArr = this.f13567l;
        int length = iArr.length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < i10) {
            do {
                cArr = this.f13623t;
                c10 = cArr[i11];
                if (c10 < length && iArr[c10] != 0) {
                    break;
                } else {
                    i11++;
                }
            } while (i11 < i10);
            int i13 = i11 - i12;
            if (i13 > 0) {
                this.f13621r.write(cArr, i12, i13);
                if (i11 >= i10) {
                    return;
                }
            }
            i11++;
            i12 = O0(this.f13623t, i11, i10, c10, iArr[c10]);
        }
    }

    @Override // c3.h
    public void h0(BigInteger bigInteger) {
        I0("write a number");
        if (bigInteger == null) {
            Z0();
        } else if (this.f12478g) {
            e1(bigInteger.toString());
        } else {
            o0(bigInteger.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:? A[LOOP:1: B:3:0x000e->B:20:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021 A[EDGE_INSN: B:9:0x0021->B:10:0x0021 BREAK  A[LOOP:1: B:3:0x000e->B:20:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h1(int r13, int r14) {
        /*
            r12 = this;
            int[] r0 = r12.f13567l
            int r1 = r0.length
            int r2 = r14 + 1
            int r1 = java.lang.Math.min(r1, r2)
            r2 = 0
            r3 = 0
            r4 = 0
        Lc:
            if (r2 >= r13) goto L3a
        Le:
            char[] r5 = r12.f13623t
            char r10 = r5[r2]
            if (r10 >= r1) goto L19
            r4 = r0[r10]
            if (r4 == 0) goto L1d
            goto L21
        L19:
            if (r10 <= r14) goto L1d
            r4 = -1
            goto L21
        L1d:
            int r2 = r2 + 1
            if (r2 < r13) goto Le
        L21:
            int r6 = r2 - r3
            if (r6 <= 0) goto L2d
            java.io.Writer r7 = r12.f13621r
            r7.write(r5, r3, r6)
            if (r2 < r13) goto L2d
            goto L3a
        L2d:
            int r2 = r2 + 1
            char[] r7 = r12.f13623t
            r6 = r12
            r8 = r2
            r9 = r13
            r11 = r4
            int r3 = r6.O0(r7, r8, r9, r10, r11)
            goto Lc
        L3a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.h.h1(int, int):void");
    }

    @Override // c3.h
    public void i0(short s10) {
        I0("write a number");
        if (this.f12478g) {
            f1(s10);
            return;
        }
        if (this.f13625v + 6 >= this.f13626w) {
            N0();
        }
        this.f13625v = f3.g.r(s10, this.f13623t, this.f13625v);
    }

    public final void i1(String str) {
        int length = str.length();
        int i10 = this.f13626w;
        if (length > i10) {
            Y0(str);
            return;
        }
        if (this.f13625v + length > i10) {
            N0();
        }
        str.getChars(0, length, this.f13623t, this.f13625v);
        int i11 = this.f13568m;
        if (i11 != 0) {
            m1(length, i11);
        } else {
            k1(length);
        }
    }

    public final void j1(char[] cArr, int i10, int i11) {
        int i12 = this.f13568m;
        if (i12 != 0) {
            n1(cArr, i10, i11, i12);
            return;
        }
        int i13 = i11 + i10;
        int[] iArr = this.f13567l;
        int length = iArr.length;
        while (i10 < i13) {
            int i14 = i10;
            do {
                char c10 = cArr[i14];
                if (c10 < length && iArr[c10] != 0) {
                    break;
                } else {
                    i14++;
                }
            } while (i14 < i13);
            int i15 = i14 - i10;
            if (i15 < 32) {
                if (this.f13625v + i15 > this.f13626w) {
                    N0();
                }
                if (i15 > 0) {
                    System.arraycopy(cArr, i10, this.f13623t, this.f13625v, i15);
                    this.f13625v += i15;
                }
            } else {
                N0();
                this.f13621r.write(cArr, i10, i15);
            }
            if (i14 >= i13) {
                return;
            }
            i10 = i14 + 1;
            char c11 = cArr[i14];
            M0(c11, iArr[c11]);
        }
    }

    public final void k1(int i10) {
        int i11;
        int i12 = this.f13625v + i10;
        int[] iArr = this.f13567l;
        int length = iArr.length;
        while (this.f13625v < i12) {
            do {
                char[] cArr = this.f13623t;
                int i13 = this.f13625v;
                char c10 = cArr[i13];
                if (c10 >= length || iArr[c10] == 0) {
                    i11 = i13 + 1;
                    this.f13625v = i11;
                } else {
                    int i14 = this.f13624u;
                    int i15 = i13 - i14;
                    if (i15 > 0) {
                        this.f13621r.write(cArr, i14, i15);
                    }
                    char[] cArr2 = this.f13623t;
                    int i16 = this.f13625v;
                    this.f13625v = i16 + 1;
                    char c11 = cArr2[i16];
                    P0(c11, iArr[c11]);
                }
            } while (i11 < i12);
            return;
        }
    }

    public final void l1(q qVar) {
        char[] b10 = qVar.b();
        int length = b10.length;
        if (length < 32) {
            if (length > this.f13626w - this.f13625v) {
                N0();
            }
            System.arraycopy(b10, 0, this.f13623t, this.f13625v, length);
            this.f13625v += length;
        } else {
            N0();
            this.f13621r.write(b10, 0, length);
        }
        if (this.f13625v >= this.f13626w) {
            N0();
        }
        char[] cArr = this.f13623t;
        int i10 = this.f13625v;
        this.f13625v = i10 + 1;
        cArr[i10] = this.f13622s;
    }

    @Override // c3.h
    public void m0(char c10) {
        if (this.f13625v >= this.f13626w) {
            N0();
        }
        char[] cArr = this.f13623t;
        int i10 = this.f13625v;
        this.f13625v = i10 + 1;
        cArr[i10] = c10;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m1(int r9, int r10) {
        /*
            r8 = this;
            int r0 = r8.f13625v
            int r0 = r0 + r9
            int[] r9 = r8.f13567l
            int r1 = r9.length
            int r2 = r10 + 1
            int r1 = java.lang.Math.min(r1, r2)
        Lc:
            int r2 = r8.f13625v
            if (r2 >= r0) goto L3a
        L10:
            char[] r2 = r8.f13623t
            int r3 = r8.f13625v
            char r4 = r2[r3]
            if (r4 >= r1) goto L1d
            r5 = r9[r4]
            if (r5 == 0) goto L34
            goto L20
        L1d:
            if (r4 <= r10) goto L34
            r5 = -1
        L20:
            int r6 = r8.f13624u
            int r3 = r3 - r6
            if (r3 <= 0) goto L2a
            java.io.Writer r7 = r8.f13621r
            r7.write(r2, r6, r3)
        L2a:
            int r2 = r8.f13625v
            int r2 = r2 + 1
            r8.f13625v = r2
            r8.P0(r4, r5)
            goto Lc
        L34:
            int r3 = r3 + 1
            r8.f13625v = r3
            if (r3 < r0) goto L10
        L3a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.h.m1(int, int):void");
    }

    @Override // c3.h
    public void n0(q qVar) {
        int e10 = qVar.e(this.f13623t, this.f13625v);
        if (e10 < 0) {
            o0(qVar.getValue());
        } else {
            this.f13625v += e10;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001f A[EDGE_INSN: B:10:0x001f->B:11:0x001f BREAK  A[LOOP:1: B:4:0x000e->B:24:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[LOOP:1: B:4:0x000e->B:24:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n1(char[] r9, int r10, int r11, int r12) {
        /*
            r8 = this;
            int r11 = r11 + r10
            int[] r0 = r8.f13567l
            int r1 = r0.length
            int r2 = r12 + 1
            int r1 = java.lang.Math.min(r1, r2)
            r2 = 0
        Lb:
            if (r10 >= r11) goto L4f
            r3 = r10
        Le:
            char r4 = r9[r3]
            if (r4 >= r1) goto L17
            r2 = r0[r4]
            if (r2 == 0) goto L1b
            goto L1f
        L17:
            if (r4 <= r12) goto L1b
            r2 = -1
            goto L1f
        L1b:
            int r3 = r3 + 1
            if (r3 < r11) goto Le
        L1f:
            int r5 = r3 - r10
            r6 = 32
            if (r5 >= r6) goto L3e
            int r6 = r8.f13625v
            int r6 = r6 + r5
            int r7 = r8.f13626w
            if (r6 <= r7) goto L2f
            r8.N0()
        L2f:
            if (r5 <= 0) goto L46
            char[] r6 = r8.f13623t
            int r7 = r8.f13625v
            java.lang.System.arraycopy(r9, r10, r6, r7, r5)
            int r10 = r8.f13625v
            int r10 = r10 + r5
            r8.f13625v = r10
            goto L46
        L3e:
            r8.N0()
            java.io.Writer r6 = r8.f13621r
            r6.write(r9, r10, r5)
        L46:
            if (r3 < r11) goto L49
            goto L4f
        L49:
            int r10 = r3 + 1
            r8.M0(r4, r2)
            goto Lb
        L4f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.h.n1(char[], int, int, int):void");
    }

    @Override // c3.h
    public void o0(String str) {
        int length = str.length();
        int i10 = this.f13626w - this.f13625v;
        if (i10 == 0) {
            N0();
            i10 = this.f13626w - this.f13625v;
        }
        if (i10 < length) {
            o1(str);
        } else {
            str.getChars(0, length, this.f13623t, this.f13625v);
            this.f13625v += length;
        }
    }

    public final void o1(String str) {
        int i10 = this.f13626w;
        int i11 = this.f13625v;
        int i12 = i10 - i11;
        str.getChars(0, i12, this.f13623t, i11);
        this.f13625v += i12;
        N0();
        int length = str.length() - i12;
        while (true) {
            int i13 = this.f13626w;
            if (length <= i13) {
                str.getChars(i12, i12 + length, this.f13623t, 0);
                this.f13624u = 0;
                this.f13625v = length;
                return;
            } else {
                int i14 = i12 + i13;
                str.getChars(i12, i14, this.f13623t, 0);
                this.f13624u = 0;
                this.f13625v = i13;
                N0();
                length -= i13;
                i12 = i14;
            }
        }
    }

    @Override // c3.h
    public void p0(char[] cArr, int i10, int i11) {
        if (i11 >= 32) {
            N0();
            this.f13621r.write(cArr, i10, i11);
        } else {
            if (i11 > this.f13626w - this.f13625v) {
                N0();
            }
            System.arraycopy(cArr, i10, this.f13623t, this.f13625v, i11);
            this.f13625v += i11;
        }
    }

    @Override // c3.h
    public void s0() {
        I0("start an array");
        this.f12479h = this.f12479h.m();
        p pVar = this.f5434a;
        if (pVar != null) {
            pVar.b(this);
            return;
        }
        if (this.f13625v >= this.f13626w) {
            N0();
        }
        char[] cArr = this.f13623t;
        int i10 = this.f13625v;
        this.f13625v = i10 + 1;
        cArr[i10] = '[';
    }

    @Override // c3.h
    public void t0(Object obj) {
        I0("start an array");
        this.f12479h = this.f12479h.n(obj);
        p pVar = this.f5434a;
        if (pVar != null) {
            pVar.b(this);
            return;
        }
        if (this.f13625v >= this.f13626w) {
            N0();
        }
        char[] cArr = this.f13623t;
        int i10 = this.f13625v;
        this.f13625v = i10 + 1;
        cArr[i10] = '[';
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
        if (this.f13625v >= this.f13626w) {
            N0();
        }
        char[] cArr = this.f13623t;
        int i11 = this.f13625v;
        this.f13625v = i11 + 1;
        cArr[i11] = '[';
    }

    @Override // c3.h
    public void v0() {
        I0("start an object");
        this.f12479h = this.f12479h.o();
        p pVar = this.f5434a;
        if (pVar != null) {
            pVar.e(this);
            return;
        }
        if (this.f13625v >= this.f13626w) {
            N0();
        }
        char[] cArr = this.f13623t;
        int i10 = this.f13625v;
        this.f13625v = i10 + 1;
        cArr[i10] = ASCIIPropertyListParser.DICTIONARY_BEGIN_TOKEN;
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
        if (this.f13625v >= this.f13626w) {
            N0();
        }
        char[] cArr = this.f13623t;
        int i10 = this.f13625v;
        this.f13625v = i10 + 1;
        cArr[i10] = ASCIIPropertyListParser.DICTIONARY_BEGIN_TOKEN;
    }

    @Override // c3.h
    public void y0(q qVar) {
        I0("write a string");
        if (this.f13625v >= this.f13626w) {
            N0();
        }
        char[] cArr = this.f13623t;
        int i10 = this.f13625v;
        int i11 = i10 + 1;
        this.f13625v = i11;
        cArr[i10] = this.f13622s;
        int a10 = qVar.a(cArr, i11);
        if (a10 < 0) {
            l1(qVar);
            return;
        }
        int i12 = this.f13625v + a10;
        this.f13625v = i12;
        if (i12 >= this.f13626w) {
            N0();
        }
        char[] cArr2 = this.f13623t;
        int i13 = this.f13625v;
        this.f13625v = i13 + 1;
        cArr2[i13] = this.f13622s;
    }

    @Override // c3.h
    public void z0(String str) {
        I0("write a string");
        if (str == null) {
            Z0();
            return;
        }
        if (this.f13625v >= this.f13626w) {
            N0();
        }
        char[] cArr = this.f13623t;
        int i10 = this.f13625v;
        this.f13625v = i10 + 1;
        cArr[i10] = this.f13622s;
        i1(str);
        if (this.f13625v >= this.f13626w) {
            N0();
        }
        char[] cArr2 = this.f13623t;
        int i11 = this.f13625v;
        this.f13625v = i11 + 1;
        cArr2[i11] = this.f13622s;
    }
}
