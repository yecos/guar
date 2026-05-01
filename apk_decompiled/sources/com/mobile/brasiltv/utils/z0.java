package com.mobile.brasiltv.utils;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public abstract class z0 {
    public static boolean a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            str2.hashCode();
            if (str2.equals("China")) {
                if (str.length() == 11) {
                    return Pattern.compile("^1[3|4|5|6|7|8|9][0-9]\\d{8}$").matcher(str).matches();
                }
            } else if (str.length() >= 6 && str.length() <= 17) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String b(java.lang.String r5, java.lang.String r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            java.lang.String r1 = " "
            if (r0 != 0) goto L8a
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 != 0) goto L8a
            r6.hashCode()
            int r0 = r6.hashCode()
            r2 = 0
            r3 = 2
            r4 = -1
            switch(r0) {
                case -771733562: goto L32;
                case 1997815692: goto L27;
                case 2011108078: goto L1c;
                default: goto L1b;
            }
        L1b:
            goto L3c
        L1c:
            java.lang.String r0 = "Canada"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L25
            goto L3c
        L25:
            r4 = 2
            goto L3c
        L27:
            java.lang.String r0 = "Brazil"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L30
            goto L3c
        L30:
            r4 = 1
            goto L3c
        L32:
            java.lang.String r0 = "United States of America"
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L3b
            goto L3c
        L3b:
            r4 = 0
        L3c:
            switch(r4) {
                case 0: goto L61;
                case 1: goto L40;
                case 2: goto L61;
                default: goto L3f;
            }
        L3f:
            goto L8a
        L40:
            int r0 = r5.length()
            if (r0 <= r3) goto L8a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r5.substring(r2, r3)
            r0.append(r2)
            r0.append(r1)
            java.lang.String r2 = r5.substring(r3)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            goto L8c
        L61:
            int r0 = r5.length()
            r3 = 3
            if (r0 <= r3) goto L8a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "("
            r0.append(r4)
            java.lang.String r2 = r5.substring(r2, r3)
            r0.append(r2)
            java.lang.String r2 = ")"
            r0.append(r2)
            java.lang.String r2 = r5.substring(r3)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            goto L8c
        L8a:
            java.lang.String r0 = ""
        L8c:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L93
            goto L94
        L93:
            r5 = r0
        L94:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "+"
            r0.append(r2)
            r0.append(r6)
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.utils.z0.b(java.lang.String, java.lang.String):java.lang.String");
    }
}
