package f3;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/* loaded from: classes.dex */
public final class j extends Writer {

    /* renamed from: a, reason: collision with root package name */
    public final c f13084a;

    /* renamed from: b, reason: collision with root package name */
    public OutputStream f13085b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f13086c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13087d;

    /* renamed from: e, reason: collision with root package name */
    public int f13088e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f13089f;

    public j(c cVar, OutputStream outputStream) {
        this.f13084a = cVar;
        this.f13085b = outputStream;
        this.f13086c = cVar.h();
        this.f13087d = r1.length - 4;
    }

    public static void b(int i10) {
        throw new IOException(c(i10));
    }

    public static String c(int i10) {
        if (i10 > 1114111) {
            return "Illegal character point (0x" + Integer.toHexString(i10) + ") to output; max is 0x10FFFF as per RFC 4627";
        }
        if (i10 < 55296) {
            return "Illegal character point (0x" + Integer.toHexString(i10) + ") to output";
        }
        if (i10 <= 56319) {
            return "Unmatched first part of surrogate pair (0x" + Integer.toHexString(i10) + ")";
        }
        return "Unmatched second part of surrogate pair (0x" + Integer.toHexString(i10) + ")";
    }

    public int a(int i10) {
        int i11 = this.f13089f;
        this.f13089f = 0;
        if (i10 >= 56320 && i10 <= 57343) {
            return ((i11 - 55296) << 10) + 65536 + (i10 - 56320);
        }
        throw new IOException("Broken surrogate pair: first char 0x" + Integer.toHexString(i11) + ", second 0x" + Integer.toHexString(i10) + "; illegal combination");
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        OutputStream outputStream = this.f13085b;
        if (outputStream != null) {
            int i10 = this.f13088e;
            if (i10 > 0) {
                outputStream.write(this.f13086c, 0, i10);
                this.f13088e = 0;
            }
            OutputStream outputStream2 = this.f13085b;
            this.f13085b = null;
            byte[] bArr = this.f13086c;
            if (bArr != null) {
                this.f13086c = null;
                this.f13084a.p(bArr);
            }
            outputStream2.close();
            int i11 = this.f13089f;
            this.f13089f = 0;
            if (i11 > 0) {
                b(i11);
            }
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        OutputStream outputStream = this.f13085b;
        if (outputStream != null) {
            int i10 = this.f13088e;
            if (i10 > 0) {
                outputStream.write(this.f13086c, 0, i10);
                this.f13088e = 0;
            }
            this.f13085b.flush();
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr) {
        write(cArr, 0, cArr.length);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c10) {
        write(c10);
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0025, code lost:
    
        continue;
     */
    @Override // java.io.Writer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void write(char[] cArr, int i10, int i11) {
        if (i11 < 2) {
            if (i11 == 1) {
                write(cArr[i10]);
                return;
            }
            return;
        }
        if (this.f13089f > 0) {
            i11--;
            write(a(cArr[i10]));
            i10++;
        }
        int i12 = this.f13088e;
        byte[] bArr = this.f13086c;
        int i13 = this.f13087d;
        int i14 = i11 + i10;
        while (i10 < i14) {
            if (i12 >= i13) {
                this.f13085b.write(bArr, 0, i12);
                i12 = 0;
            }
            int i15 = i10 + 1;
            char c10 = cArr[i10];
            if (c10 < 128) {
                int i16 = i12 + 1;
                bArr[i12] = (byte) c10;
                int i17 = i14 - i15;
                int i18 = i13 - i16;
                if (i17 > i18) {
                    i17 = i18;
                }
                int i19 = i17 + i15;
                while (true) {
                    i10 = i15;
                    i12 = i16;
                    if (i10 >= i19) {
                        break;
                    }
                    i15 = i10 + 1;
                    c10 = cArr[i10];
                    if (c10 >= 128) {
                        break;
                    }
                    i16 = i12 + 1;
                    bArr[i12] = (byte) c10;
                }
            }
            if (c10 < 2048) {
                int i20 = i12 + 1;
                bArr[i12] = (byte) ((c10 >> 6) | 192);
                i12 = i20 + 1;
                bArr[i20] = (byte) ((c10 & '?') | 128);
                i10 = i15;
            } else if (c10 < 55296 || c10 > 57343) {
                int i21 = i12 + 1;
                bArr[i12] = (byte) ((c10 >> '\f') | 224);
                int i22 = i21 + 1;
                bArr[i21] = (byte) (((c10 >> 6) & 63) | 128);
                bArr[i22] = (byte) ((c10 & '?') | 128);
                i10 = i15;
                i12 = i22 + 1;
            } else {
                if (c10 > 56319) {
                    this.f13088e = i12;
                    b(c10);
                }
                this.f13089f = c10;
                if (i15 >= i14) {
                    break;
                }
                i10 = i15 + 1;
                int a10 = a(cArr[i15]);
                if (a10 > 1114111) {
                    this.f13088e = i12;
                    b(a10);
                }
                int i23 = i12 + 1;
                bArr[i12] = (byte) ((a10 >> 18) | 240);
                int i24 = i23 + 1;
                bArr[i23] = (byte) (((a10 >> 12) & 63) | 128);
                int i25 = i24 + 1;
                bArr[i24] = (byte) (((a10 >> 6) & 63) | 128);
                i12 = i25 + 1;
                bArr[i25] = (byte) ((a10 & 63) | 128);
            }
        }
        this.f13088e = i12;
    }

    @Override // java.io.Writer
    public void write(int i10) {
        int i11;
        if (this.f13089f > 0) {
            i10 = a(i10);
        } else if (i10 >= 55296 && i10 <= 57343) {
            if (i10 > 56319) {
                b(i10);
            }
            this.f13089f = i10;
            return;
        }
        int i12 = this.f13088e;
        if (i12 >= this.f13087d) {
            this.f13085b.write(this.f13086c, 0, i12);
            this.f13088e = 0;
        }
        if (i10 < 128) {
            byte[] bArr = this.f13086c;
            int i13 = this.f13088e;
            this.f13088e = i13 + 1;
            bArr[i13] = (byte) i10;
            return;
        }
        int i14 = this.f13088e;
        if (i10 < 2048) {
            byte[] bArr2 = this.f13086c;
            int i15 = i14 + 1;
            bArr2[i14] = (byte) ((i10 >> 6) | 192);
            i11 = i15 + 1;
            bArr2[i15] = (byte) ((i10 & 63) | 128);
        } else if (i10 <= 65535) {
            byte[] bArr3 = this.f13086c;
            int i16 = i14 + 1;
            bArr3[i14] = (byte) ((i10 >> 12) | 224);
            int i17 = i16 + 1;
            bArr3[i16] = (byte) (((i10 >> 6) & 63) | 128);
            bArr3[i17] = (byte) ((i10 & 63) | 128);
            i11 = i17 + 1;
        } else {
            if (i10 > 1114111) {
                b(i10);
            }
            byte[] bArr4 = this.f13086c;
            int i18 = i14 + 1;
            bArr4[i14] = (byte) ((i10 >> 18) | 240);
            int i19 = i18 + 1;
            bArr4[i18] = (byte) (((i10 >> 12) & 63) | 128);
            int i20 = i19 + 1;
            bArr4[i19] = (byte) (((i10 >> 6) & 63) | 128);
            i11 = i20 + 1;
            bArr4[i20] = (byte) ((i10 & 63) | 128);
        }
        this.f13088e = i11;
    }

    @Override // java.io.Writer
    public void write(String str) {
        write(str, 0, str.length());
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0029, code lost:
    
        continue;
     */
    @Override // java.io.Writer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void write(String str, int i10, int i11) {
        if (i11 < 2) {
            if (i11 == 1) {
                write(str.charAt(i10));
                return;
            }
            return;
        }
        if (this.f13089f > 0) {
            i11--;
            write(a(str.charAt(i10)));
            i10++;
        }
        int i12 = this.f13088e;
        byte[] bArr = this.f13086c;
        int i13 = this.f13087d;
        int i14 = i11 + i10;
        while (i10 < i14) {
            if (i12 >= i13) {
                this.f13085b.write(bArr, 0, i12);
                i12 = 0;
            }
            int i15 = i10 + 1;
            char charAt = str.charAt(i10);
            if (charAt < 128) {
                int i16 = i12 + 1;
                bArr[i12] = (byte) charAt;
                int i17 = i14 - i15;
                int i18 = i13 - i16;
                if (i17 > i18) {
                    i17 = i18;
                }
                int i19 = i17 + i15;
                while (true) {
                    i10 = i15;
                    i12 = i16;
                    if (i10 >= i19) {
                        break;
                    }
                    i15 = i10 + 1;
                    charAt = str.charAt(i10);
                    if (charAt >= 128) {
                        break;
                    }
                    i16 = i12 + 1;
                    bArr[i12] = (byte) charAt;
                }
            }
            if (charAt < 2048) {
                int i20 = i12 + 1;
                bArr[i12] = (byte) ((charAt >> 6) | 192);
                i12 = i20 + 1;
                bArr[i20] = (byte) ((charAt & '?') | 128);
                i10 = i15;
            } else if (charAt >= 55296 && charAt <= 57343) {
                if (charAt > 56319) {
                    this.f13088e = i12;
                    b(charAt);
                }
                this.f13089f = charAt;
                if (i15 >= i14) {
                    break;
                }
                i10 = i15 + 1;
                int a10 = a(str.charAt(i15));
                if (a10 > 1114111) {
                    this.f13088e = i12;
                    b(a10);
                }
                int i21 = i12 + 1;
                bArr[i12] = (byte) ((a10 >> 18) | 240);
                int i22 = i21 + 1;
                bArr[i21] = (byte) (((a10 >> 12) & 63) | 128);
                int i23 = i22 + 1;
                bArr[i22] = (byte) (((a10 >> 6) & 63) | 128);
                i12 = i23 + 1;
                bArr[i23] = (byte) ((a10 & 63) | 128);
            } else {
                int i24 = i12 + 1;
                bArr[i12] = (byte) ((charAt >> '\f') | 224);
                int i25 = i24 + 1;
                bArr[i24] = (byte) (((charAt >> 6) & 63) | 128);
                bArr[i25] = (byte) ((charAt & '?') | 128);
                i10 = i15;
                i12 = i25 + 1;
            }
        }
        this.f13088e = i12;
    }
}
