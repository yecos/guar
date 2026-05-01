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
    */
    private static final String escapeXMLChars(String str, boolean z10) {
        if (str == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        char[] cArr = new char[length];
        str.getChars(0, length, cArr, 0);
        String str2 = null;
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            char c10 = cArr[i11];
            if (c10 != '\"') {
                if (c10 == '<') {
                    str2 = "&lt;";
                } else if (c10 == '>') {
                    str2 = "&gt;";
                } else if (c10 == '&') {
                    str2 = "&amp;";
                } else if (c10 == '\'') {
                    if (z10) {
                        str2 = "&apos;";
                    }
                }
                if (str2 == null) {
                    stringBuffer.append(cArr, i10, i11 - i10);
                    stringBuffer.append(str2);
                    i10 = i11 + 1;
                    str2 = null;
                }
            }
            if (z10) {
                str2 = "&quot;";
            }
            if (str2 == null) {
            }
        }
        if (i10 == 0) {
            return str;
        }
        stringBuffer.append(cArr, i10, length - i10);
        return stringBuffer.toString();
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
