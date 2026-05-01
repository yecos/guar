package com.hpplay.sdk.source.mdns.xbill.dns;

/* loaded from: classes3.dex */
public final class TTL {
    public static final long MAX_VALUE = 2147483647L;

    private TTL() {
    }

    public static void check(long j10) {
        if (j10 < 0 || j10 > MAX_VALUE) {
            throw new InvalidDClassException((int) j10);
        }
    }

    public static String format(long j10) {
        check(j10);
        StringBuffer stringBuffer = new StringBuffer();
        long j11 = j10 % 60;
        long j12 = j10 / 60;
        long j13 = j12 % 60;
        long j14 = j12 / 60;
        long j15 = j14 % 24;
        long j16 = j14 / 24;
        long j17 = j16 % 7;
        long j18 = j16 / 7;
        if (j18 > 0) {
            stringBuffer.append(j18 + "W");
        }
        if (j17 > 0) {
            stringBuffer.append(j17 + "D");
        }
        if (j15 > 0) {
            stringBuffer.append(j15 + "H");
        }
        if (j13 > 0) {
            stringBuffer.append(j13 + "M");
        }
        if (j11 > 0 || (j18 == 0 && j17 == 0 && j15 == 0 && j13 == 0)) {
            stringBuffer.append(j11 + "S");
        }
        return stringBuffer.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long parse(java.lang.String r16, boolean r17) {
        /*
            r0 = r16
            if (r0 == 0) goto L9a
            int r1 = r16.length()
            if (r1 == 0) goto L9a
            r1 = 0
            char r2 = r0.charAt(r1)
            boolean r2 = java.lang.Character.isDigit(r2)
            if (r2 == 0) goto L9a
            r2 = 0
            r4 = r2
            r6 = r4
        L19:
            int r8 = r16.length()
            r9 = 4294967295(0xffffffff, double:2.1219957905E-314)
            if (r1 >= r8) goto L80
            char r8 = r0.charAt(r1)
            boolean r11 = java.lang.Character.isDigit(r8)
            if (r11 == 0) goto L44
            r9 = 10
            long r9 = r9 * r6
            int r8 = java.lang.Character.getNumericValue(r8)
            long r11 = (long) r8
            long r9 = r9 + r11
            int r8 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r8 < 0) goto L3e
            r6 = r9
            goto L77
        L3e:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r0.<init>()
            throw r0
        L44:
            char r8 = java.lang.Character.toUpperCase(r8)
            r11 = 68
            r12 = 60
            if (r8 == r11) goto L69
            r11 = 72
            if (r8 == r11) goto L6d
            r11 = 77
            if (r8 == r11) goto L6f
            r11 = 83
            if (r8 == r11) goto L71
            r11 = 87
            if (r8 != r11) goto L63
            r14 = 7
            long r6 = r6 * r14
            goto L69
        L63:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r0.<init>()
            throw r0
        L69:
            r14 = 24
            long r6 = r6 * r14
        L6d:
            long r6 = r6 * r12
        L6f:
            long r6 = r6 * r12
        L71:
            long r4 = r4 + r6
            int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r6 > 0) goto L7a
            r6 = r2
        L77:
            int r1 = r1 + 1
            goto L19
        L7a:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r0.<init>()
            throw r0
        L80:
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 != 0) goto L85
            r4 = r6
        L85:
            int r0 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r0 > 0) goto L94
            r0 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 <= 0) goto L93
            if (r17 == 0) goto L93
            r4 = r0
        L93:
            return r4
        L94:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r0.<init>()
            throw r0
        L9a:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r0.<init>()
            goto La1
        La0:
            throw r0
        La1:
            goto La0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.mdns.xbill.dns.TTL.parse(java.lang.String, boolean):long");
    }

    public static long parseTTL(String str) {
        return parse(str, true);
    }
}
