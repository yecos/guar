package com.hpplay.cybergarage.util;

import com.hpplay.component.common.utils.CLog;

/* loaded from: classes2.dex */
public final class StringUtil {
    private static final String TAG = "Cyber-StringUtil";

    public static final int findFirstNotOf(String str, String str2) {
        return findOf(str, str2, 0, str.length() - 1, 1, false);
    }

    public static final int findFirstOf(String str, String str2) {
        return findOf(str, str2, 0, str.length() - 1, 1, true);
    }

    public static final int findLastNotOf(String str, String str2) {
        return findOf(str, str2, str.length() - 1, 0, -1, false);
    }

    public static final int findLastOf(String str, String str2) {
        return findOf(str, str2, str.length() - 1, 0, -1, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x000f, code lost:
    
        return -1;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int findOf(java.lang.String r7, java.lang.String r8, int r9, int r10, int r11, boolean r12) {
        /*
            r0 = -1
            if (r11 != 0) goto L4
            return r0
        L4:
            int r1 = r8.length()
        L8:
            if (r11 <= 0) goto Ld
            if (r10 >= r9) goto L10
            goto Lf
        Ld:
            if (r9 >= r10) goto L10
        Lf:
            return r0
        L10:
            char r2 = r7.charAt(r9)
            r3 = 0
            r4 = 0
        L16:
            if (r3 >= r1) goto L2c
            char r5 = r8.charAt(r3)
            r6 = 1
            if (r12 != r6) goto L22
            if (r2 != r5) goto L29
            return r9
        L22:
            if (r2 == r5) goto L26
            int r4 = r4 + 1
        L26:
            if (r4 != r1) goto L29
            return r9
        L29:
            int r3 = r3 + 1
            goto L16
        L2c:
            int r9 = r9 + r11
            goto L8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.cybergarage.util.StringUtil.findOf(java.lang.String, java.lang.String, int, int, int, boolean):int");
    }

    public static final boolean hasData(String str) {
        return str != null && str.length() > 0;
    }

    public static final int toInteger(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e10) {
            CLog.d(TAG, null, e10);
            return 0;
        }
    }

    public static final long toLong(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e10) {
            CLog.d(TAG, null, e10);
            return 0L;
        }
    }

    public static final String trim(String str, String str2) {
        int findFirstNotOf = findFirstNotOf(str, str2);
        if (findFirstNotOf < 0) {
            return str;
        }
        String substring = str.substring(findFirstNotOf, str.length());
        int findLastNotOf = findLastNotOf(substring, str2);
        return findLastNotOf < 0 ? substring : substring.substring(0, findLastNotOf + 1);
    }
}
