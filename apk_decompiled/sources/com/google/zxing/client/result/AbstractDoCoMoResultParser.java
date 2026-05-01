package com.google.zxing.client.result;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes2.dex */
abstract class AbstractDoCoMoResultParser extends ResultParser {
    public static String[] matchDoCoMoPrefixedField(String str, String str2, boolean z10) {
        return ResultParser.matchPrefixedField(str, str2, ASCIIPropertyListParser.DICTIONARY_ITEM_DELIMITER_TOKEN, z10);
    }

    public static String matchSingleDoCoMoPrefixedField(String str, String str2, boolean z10) {
        return ResultParser.matchSinglePrefixedField(str, str2, ASCIIPropertyListParser.DICTIONARY_ITEM_DELIMITER_TOKEN, z10);
    }
}
