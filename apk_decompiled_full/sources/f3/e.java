package f3;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import j3.o;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f13063a = a.d();

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f13064b = a.c();

    /* renamed from: c, reason: collision with root package name */
    public static final e f13065c = new e();

    public static int d(int i10, int i11) {
        if (i11 >= 56320 && i11 <= 57343) {
            return ((i10 - 55296) << 10) + 65536 + (i11 - 56320);
        }
        throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(i10) + ", second 0x" + Integer.toHexString(i11) + "; illegal combination");
    }

    public static void e(int i10) {
        throw new IllegalArgumentException(j.c(i10));
    }

    public static e h() {
        return f13065c;
    }

    public final int a(int i10, int i11, j3.c cVar, int i12) {
        cVar.u(i12);
        cVar.b(92);
        if (i11 < 0) {
            cVar.b(117);
            if (i10 > 255) {
                int i13 = i10 >> 8;
                byte[] bArr = f13064b;
                cVar.b(bArr[i13 >> 4]);
                cVar.b(bArr[i13 & 15]);
                i10 &= 255;
            } else {
                cVar.b(48);
                cVar.b(48);
            }
            byte[] bArr2 = f13064b;
            cVar.b(bArr2[i10 >> 4]);
            cVar.b(bArr2[i10 & 15]);
        } else {
            cVar.b((byte) i11);
        }
        return cVar.s();
    }

    public final int b(int i10, char[] cArr) {
        cArr[1] = (char) i10;
        return 2;
    }

    public final int c(int i10, char[] cArr) {
        cArr[1] = 'u';
        char[] cArr2 = f13063a;
        cArr[4] = cArr2[i10 >> 4];
        cArr[5] = cArr2[i10 & 15];
        return 6;
    }

    public final char[] f() {
        return new char[]{ASCIIPropertyListParser.QUOTEDSTRING_ESCAPE_TOKEN, 0, '0', '0', 0, 0};
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] g(String str) {
        int i10;
        int i11;
        int length = str.length();
        int i12 = 60;
        byte[] bArr = new byte[60];
        j3.c cVar = null;
        int i13 = 0;
        int i14 = 0;
        loop0: while (true) {
            if (i13 >= length) {
                break;
            }
            int i15 = i13 + 1;
            int charAt = str.charAt(i13);
            while (charAt <= 127) {
                if (i14 >= i12) {
                    if (cVar == null) {
                        cVar = j3.c.n(bArr, i14);
                    }
                    byte[] m10 = cVar.m();
                    i14 = 0;
                    bArr = m10;
                    i12 = m10.length;
                }
                int i16 = i14 + 1;
                bArr[i14] = (byte) charAt;
                if (i15 >= length) {
                    i14 = i16;
                    break loop0;
                }
                int charAt2 = str.charAt(i15);
                i15++;
                charAt = charAt2;
                i14 = i16;
            }
            if (cVar == null) {
                cVar = j3.c.n(bArr, i14);
            }
            if (i14 >= i12) {
                bArr = cVar.m();
                i12 = bArr.length;
                i14 = 0;
            }
            if (charAt < 2048) {
                i10 = i14 + 1;
                bArr[i14] = (byte) ((charAt >> 6) | 192);
            } else if (charAt < 55296 || charAt > 57343) {
                int i17 = i14 + 1;
                bArr[i14] = (byte) ((charAt >> 12) | 224);
                if (i17 >= i12) {
                    byte[] m11 = cVar.m();
                    i17 = 0;
                    bArr = m11;
                    i12 = m11.length;
                }
                bArr[i17] = (byte) (((charAt >> 6) & 63) | 128);
                i10 = i17 + 1;
            } else {
                if (charAt > 56319) {
                    e(charAt);
                }
                if (i15 >= length) {
                    e(charAt);
                }
                int i18 = i15 + 1;
                int d10 = d(charAt, str.charAt(i15));
                if (d10 > 1114111) {
                    e(d10);
                }
                int i19 = i14 + 1;
                bArr[i14] = (byte) ((d10 >> 18) | 240);
                if (i19 >= i12) {
                    bArr = cVar.m();
                    i12 = bArr.length;
                    i19 = 0;
                }
                int i20 = i19 + 1;
                bArr[i19] = (byte) (((d10 >> 12) & 63) | 128);
                if (i20 >= i12) {
                    byte[] m12 = cVar.m();
                    i20 = 0;
                    bArr = m12;
                    i12 = m12.length;
                }
                int i21 = i20 + 1;
                bArr[i20] = (byte) (((d10 >> 6) & 63) | 128);
                i11 = d10;
                i13 = i18;
                i10 = i21;
                if (i10 < i12) {
                    byte[] m13 = cVar.m();
                    i10 = 0;
                    bArr = m13;
                    i12 = m13.length;
                }
                bArr[i10] = (byte) ((i11 & 63) | 128);
                i14 = i10 + 1;
            }
            i11 = charAt;
            i13 = i15;
            if (i10 < i12) {
            }
            bArr[i10] = (byte) ((i11 & 63) | 128);
            i14 = i10 + 1;
        }
        return cVar == null ? Arrays.copyOfRange(bArr, 0, i14) : cVar.f(i14);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0024, code lost:
    
        r9 = r7 + 1;
        r7 = r13.charAt(r7);
        r10 = r1[r7];
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002c, code lost:
    
        if (r10 >= 0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002e, code lost:
    
        r7 = c(r7, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
    
        r10 = r8 + r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
    
        if (r10 <= r0.length) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003c, code lost:
    
        r10 = r0.length - r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
    
        if (r10 <= 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0040, code lost:
    
        java.lang.System.arraycopy(r6, 0, r0, r8, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0043, code lost:
    
        if (r5 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0045, code lost:
    
        r5 = j3.o.p(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
    
        r0 = r5.o();
        r7 = r7 - r10;
        java.lang.System.arraycopy(r6, r10, r0, 0, r7);
        r8 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0053, code lost:
    
        java.lang.System.arraycopy(r6, 0, r0, r8, r7);
        r8 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0033, code lost:
    
        r7 = b(r10, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r6 != null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0020, code lost:
    
        r6 = f();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public char[] i(String str) {
        int i10;
        char[] cArr = new char[30];
        int[] e10 = a.e();
        int length = e10.length;
        int length2 = str.length();
        o oVar = null;
        char[] cArr2 = null;
        int i11 = 0;
        int i12 = 0;
        loop0: while (true) {
            if (i11 >= length2) {
                break;
            }
            while (true) {
                char charAt = str.charAt(i11);
                if (charAt < length && e10[charAt] != 0) {
                    break;
                }
                if (i12 >= cArr.length) {
                    if (oVar == null) {
                        oVar = o.p(cArr);
                    }
                    cArr = oVar.o();
                    i12 = 0;
                }
                int i13 = i12 + 1;
                cArr[i12] = charAt;
                i11++;
                if (i11 >= length2) {
                    i12 = i13;
                    break loop0;
                }
                i12 = i13;
            }
            i11 = i10;
        }
        if (oVar == null) {
            return Arrays.copyOfRange(cArr, 0, i12);
        }
        oVar.z(i12);
        return oVar.g();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] j(String str) {
        int i10;
        int i11;
        int i12;
        int length = str.length();
        byte[] bArr = new byte[60];
        j3.c cVar = null;
        int i13 = 0;
        int i14 = 0;
        loop0: while (true) {
            if (i13 >= length) {
                break;
            }
            int[] e10 = a.e();
            while (true) {
                char charAt = str.charAt(i13);
                if (charAt > 127 || e10[charAt] != 0) {
                    break;
                }
                if (i14 >= bArr.length) {
                    if (cVar == null) {
                        cVar = j3.c.n(bArr, i14);
                    }
                    bArr = cVar.m();
                    i14 = 0;
                }
                int i15 = i14 + 1;
                bArr[i14] = (byte) charAt;
                i13++;
                if (i13 >= length) {
                    i14 = i15;
                    break loop0;
                }
                i14 = i15;
            }
            if (cVar == null) {
                cVar = j3.c.n(bArr, i14);
            }
            if (i14 >= bArr.length) {
                bArr = cVar.m();
                i14 = 0;
            }
            int i16 = i13 + 1;
            char charAt2 = str.charAt(i13);
            if (charAt2 <= 127) {
                i14 = a(charAt2, e10[charAt2], cVar, i14);
                bArr = cVar.q();
                i13 = i16;
            } else {
                if (charAt2 <= 2047) {
                    i11 = i14 + 1;
                    bArr[i14] = (byte) ((charAt2 >> 6) | 192);
                    i10 = (charAt2 & '?') | 128;
                } else if (charAt2 < 55296 || charAt2 > 57343) {
                    int i17 = i14 + 1;
                    bArr[i14] = (byte) ((charAt2 >> '\f') | 224);
                    if (i17 >= bArr.length) {
                        bArr = cVar.m();
                        i17 = 0;
                    }
                    bArr[i17] = (byte) (((charAt2 >> 6) & 63) | 128);
                    i10 = (charAt2 & '?') | 128;
                    i11 = i17 + 1;
                } else {
                    if (charAt2 > 56319) {
                        e(charAt2);
                    }
                    if (i16 >= length) {
                        e(charAt2);
                    }
                    int i18 = i16 + 1;
                    int d10 = d(charAt2, str.charAt(i16));
                    if (d10 > 1114111) {
                        e(d10);
                    }
                    int i19 = i14 + 1;
                    bArr[i14] = (byte) ((d10 >> 18) | 240);
                    if (i19 >= bArr.length) {
                        bArr = cVar.m();
                        i19 = 0;
                    }
                    int i20 = i19 + 1;
                    bArr[i19] = (byte) (((d10 >> 12) & 63) | 128);
                    if (i20 >= bArr.length) {
                        bArr = cVar.m();
                        i20 = 0;
                    }
                    int i21 = i20 + 1;
                    bArr[i20] = (byte) (((d10 >> 6) & 63) | 128);
                    i12 = (d10 & 63) | 128;
                    i13 = i18;
                    i11 = i21;
                    if (i11 >= bArr.length) {
                        bArr = cVar.m();
                        i11 = 0;
                    }
                    bArr[i11] = (byte) i12;
                    i14 = i11 + 1;
                }
                i12 = i10;
                i13 = i16;
                if (i11 >= bArr.length) {
                }
                bArr[i11] = (byte) i12;
                i14 = i11 + 1;
            }
        }
        return cVar == null ? Arrays.copyOfRange(bArr, 0, i14) : cVar.f(i14);
    }
}
