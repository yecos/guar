package com.hpplay.cybergarage.xml;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.raizlabs.android.dbflow.sql.language.Operator;

/* loaded from: classes2.dex */
public class XML {
    public static final String CHARSET_UTF8 = "utf-8";
    public static final String DEFAULT_CONTENT_LANGUAGE = "en";
    public static final String DEFAULT_CONTENT_TYPE = "text/xml; charset=\"utf-8\"";

    /* JADX WARN: Removed duplicated region for block: B:20:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final java.lang.String escapeXMLChars(java.lang.String r9, boolean r10) {
        /*
            r0 = 0
            if (r9 != 0) goto L4
            return r0
        L4:
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            int r2 = r9.length()
            char[] r3 = new char[r2]
            r4 = 0
            r9.getChars(r4, r2, r3, r4)
            r6 = r0
            r5 = 0
        L15:
            if (r4 >= r2) goto L50
            char r7 = r3[r4]
            r8 = 34
            if (r7 == r8) goto L3c
            r8 = 60
            if (r7 == r8) goto L39
            r8 = 62
            if (r7 == r8) goto L36
            r8 = 38
            if (r7 == r8) goto L33
            r8 = 39
            if (r7 == r8) goto L2e
            goto L40
        L2e:
            if (r10 == 0) goto L3c
            java.lang.String r6 = "&apos;"
            goto L40
        L33:
            java.lang.String r6 = "&amp;"
            goto L40
        L36:
            java.lang.String r6 = "&gt;"
            goto L40
        L39:
            java.lang.String r6 = "&lt;"
            goto L40
        L3c:
            if (r10 == 0) goto L40
            java.lang.String r6 = "&quot;"
        L40:
            if (r6 == 0) goto L4d
            int r7 = r4 - r5
            r1.append(r3, r5, r7)
            r1.append(r6)
            int r5 = r4 + 1
            r6 = r0
        L4d:
            int r4 = r4 + 1
            goto L15
        L50:
            if (r5 != 0) goto L53
            return r9
        L53:
            int r2 = r2 - r5
            r1.append(r3, r5, r2)
            java.lang.String r9 = r1.toString()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.cybergarage.xml.XML.escapeXMLChars(java.lang.String, boolean):java.lang.String");
    }

    public static final String unescapeXMLChars(String str) {
        if (str == null) {
            return null;
        }
        return str.replace("&amp;", DispatchConstants.SIGN_SPLIT_SYMBOL).replace("&lt;", Operator.Operation.LESS_THAN).replace("&gt;", Operator.Operation.GREATER_THAN).replace("&apos;", "'").replace("&quot;", "\"");
    }

    public static final String escapeXMLChars(String str) {
        return escapeXMLChars(str, true);
    }
}
