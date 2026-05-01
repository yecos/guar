package com.google.zxing.client.result;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes2.dex */
public final class ExpandedProductResultParser extends ResultParser {
    private static String findAIvalue(int i10, String str) {
        if (str.charAt(i10) != '(') {
            return null;
        }
        String substring = str.substring(i10 + 1);
        StringBuilder sb = new StringBuilder();
        for (int i11 = 0; i11 < substring.length(); i11++) {
            char charAt = substring.charAt(i11);
            if (charAt == ')') {
                return sb.toString();
            }
            if (charAt < '0' || charAt > '9') {
                return null;
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    private static String findValue(int i10, String str) {
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(i10);
        for (int i11 = 0; i11 < substring.length(); i11++) {
            char charAt = substring.charAt(i11);
            if (charAt != '(') {
                sb.append(charAt);
            } else {
                if (findAIvalue(i11, substring) != null) {
                    break;
                }
                sb.append(ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN);
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x020b, code lost:
    
        if (r1.equals(org.android.agoo.common.AgooConstants.ACK_REMOVE_PACKAGE) == false) goto L13;
     */
    @Override // com.google.zxing.client.result.ResultParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.zxing.client.result.ExpandedProductParsedResult parse(com.google.zxing.Result r24) {
        /*
            Method dump skipped, instructions count: 862
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.result.ExpandedProductResultParser.parse(com.google.zxing.Result):com.google.zxing.client.result.ExpandedProductParsedResult");
    }
}
