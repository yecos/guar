package f3;

import com.uc.crashsdk.export.CrashStatKey;
import java.math.BigDecimal;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final String f13066a = String.valueOf(Long.MIN_VALUE).substring(1);

    /* renamed from: b, reason: collision with root package name */
    public static final String f13067b = String.valueOf(Long.MAX_VALUE);

    public static NumberFormatException a(String str) {
        return new NumberFormatException("Value \"" + str + "\" can not be represented as BigDecimal");
    }

    public static boolean b(String str, boolean z10) {
        String str2 = z10 ? f13066a : f13067b;
        int length = str2.length();
        int length2 = str.length();
        if (length2 < length) {
            return true;
        }
        if (length2 > length) {
            return false;
        }
        for (int i10 = 0; i10 < length; i10++) {
            int charAt = str.charAt(i10) - str2.charAt(i10);
            if (charAt != 0) {
                return charAt < 0;
            }
        }
        return true;
    }

    public static boolean c(char[] cArr, int i10, int i11, boolean z10) {
        String str = z10 ? f13066a : f13067b;
        int length = str.length();
        if (i11 < length) {
            return true;
        }
        if (i11 > length) {
            return false;
        }
        for (int i12 = 0; i12 < length; i12++) {
            int charAt = cArr[i10 + i12] - str.charAt(i12);
            if (charAt != 0) {
                return charAt < 0;
            }
        }
        return true;
    }

    public static int d(String str, int i10) {
        if (str == null) {
            return i10;
        }
        String trim = str.trim();
        int length = trim.length();
        if (length == 0) {
            return i10;
        }
        int i11 = 0;
        char charAt = trim.charAt(0);
        if (charAt == '+') {
            trim = trim.substring(1);
            length = trim.length();
        } else if (charAt == '-') {
            i11 = 1;
        }
        while (i11 < length) {
            char charAt2 = trim.charAt(i11);
            if (charAt2 > '9' || charAt2 < '0') {
                try {
                    return (int) i(trim);
                } catch (NumberFormatException unused) {
                    return i10;
                }
            }
            i11++;
        }
        try {
            return Integer.parseInt(trim);
        } catch (NumberFormatException unused2) {
            return i10;
        }
    }

    public static long e(String str, long j10) {
        if (str == null) {
            return j10;
        }
        String trim = str.trim();
        int length = trim.length();
        if (length == 0) {
            return j10;
        }
        int i10 = 0;
        char charAt = trim.charAt(0);
        if (charAt == '+') {
            trim = trim.substring(1);
            length = trim.length();
        } else if (charAt == '-') {
            i10 = 1;
        }
        while (i10 < length) {
            char charAt2 = trim.charAt(i10);
            if (charAt2 > '9' || charAt2 < '0') {
                try {
                    return (long) i(trim);
                } catch (NumberFormatException unused) {
                    return j10;
                }
            }
            i10++;
        }
        try {
            return Long.parseLong(trim);
        } catch (NumberFormatException unused2) {
            return j10;
        }
    }

    public static BigDecimal f(String str) {
        try {
            return new BigDecimal(str);
        } catch (NumberFormatException unused) {
            throw a(str);
        }
    }

    public static BigDecimal g(char[] cArr) {
        return h(cArr, 0, cArr.length);
    }

    public static BigDecimal h(char[] cArr, int i10, int i11) {
        try {
            return new BigDecimal(cArr, i10, i11);
        } catch (NumberFormatException unused) {
            throw a(new String(cArr, i10, i11));
        }
    }

    public static double i(String str) {
        if ("2.2250738585072012e-308".equals(str)) {
            return Double.MIN_VALUE;
        }
        return Double.parseDouble(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0073, code lost:
    
        return java.lang.Integer.parseInt(r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int j(java.lang.String r8) {
        /*
            r0 = 0
            char r1 = r8.charAt(r0)
            int r2 = r8.length()
            r3 = 45
            r4 = 1
            if (r1 != r3) goto Lf
            r0 = 1
        Lf:
            r3 = 10
            if (r0 == 0) goto L23
            if (r2 == r4) goto L1e
            if (r2 <= r3) goto L18
            goto L1e
        L18:
            char r1 = r8.charAt(r4)
            r4 = 2
            goto L2c
        L1e:
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        L23:
            r5 = 9
            if (r2 <= r5) goto L2c
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        L2c:
            r5 = 57
            if (r1 > r5) goto L82
            r6 = 48
            if (r1 >= r6) goto L35
            goto L82
        L35:
            int r1 = r1 - r6
            if (r4 >= r2) goto L7e
            int r7 = r4 + 1
            char r4 = r8.charAt(r4)
            if (r4 > r5) goto L79
            if (r4 >= r6) goto L43
            goto L79
        L43:
            int r1 = r1 * 10
            int r4 = r4 - r6
            int r1 = r1 + r4
            if (r7 >= r2) goto L7e
            int r4 = r7 + 1
            char r7 = r8.charAt(r7)
            if (r7 > r5) goto L74
            if (r7 >= r6) goto L54
            goto L74
        L54:
            int r1 = r1 * 10
            int r7 = r7 - r6
            int r1 = r1 + r7
            if (r4 >= r2) goto L7e
        L5a:
            int r7 = r4 + 1
            char r4 = r8.charAt(r4)
            if (r4 > r5) goto L6f
            if (r4 >= r6) goto L65
            goto L6f
        L65:
            int r1 = r1 * 10
            int r4 = r4 + (-48)
            int r1 = r1 + r4
            if (r7 < r2) goto L6d
            goto L7e
        L6d:
            r4 = r7
            goto L5a
        L6f:
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        L74:
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        L79:
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        L7e:
            if (r0 == 0) goto L81
            int r1 = -r1
        L81:
            return r1
        L82:
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.f.j(java.lang.String):int");
    }

    public static int k(char[] cArr, int i10, int i11) {
        int i12 = cArr[(i10 + i11) - 1] - '0';
        switch (i11) {
            case 9:
                i12 += (cArr[i10] - '0') * 100000000;
                i10++;
            case 8:
                i12 += (cArr[i10] - '0') * 10000000;
                i10++;
            case 7:
                i12 += (cArr[i10] - '0') * CrashStatKey.STATS_REPORT_FINISHED;
                i10++;
            case 6:
                i12 += (cArr[i10] - '0') * 100000;
                i10++;
            case 5:
                i12 += (cArr[i10] - '0') * 10000;
                i10++;
            case 4:
                i12 += (cArr[i10] - '0') * 1000;
                i10++;
            case 3:
                i12 += (cArr[i10] - '0') * 100;
                i10++;
            case 2:
                return i12 + ((cArr[i10] - '0') * 10);
            default:
                return i12;
        }
    }

    public static long l(String str) {
        return str.length() <= 9 ? j(str) : Long.parseLong(str);
    }

    public static long m(char[] cArr, int i10, int i11) {
        int i12 = i11 - 9;
        return (k(cArr, i10, i12) * 1000000000) + k(cArr, i10 + i12, 9);
    }
}
