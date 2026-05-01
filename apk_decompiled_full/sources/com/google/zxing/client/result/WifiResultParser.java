package com.google.zxing.client.result;

import com.google.zxing.Result;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes2.dex */
public final class WifiResultParser extends ResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    public WifiParsedResult parse(Result result) {
        String matchSinglePrefixedField;
        String massagedText = ResultParser.getMassagedText(result);
        if (!massagedText.startsWith("WIFI:") || (matchSinglePrefixedField = ResultParser.matchSinglePrefixedField("S:", massagedText, ASCIIPropertyListParser.DICTIONARY_ITEM_DELIMITER_TOKEN, false)) == null || matchSinglePrefixedField.isEmpty()) {
            return null;
        }
        String matchSinglePrefixedField2 = ResultParser.matchSinglePrefixedField("P:", massagedText, ASCIIPropertyListParser.DICTIONARY_ITEM_DELIMITER_TOKEN, false);
        String matchSinglePrefixedField3 = ResultParser.matchSinglePrefixedField("T:", massagedText, ASCIIPropertyListParser.DICTIONARY_ITEM_DELIMITER_TOKEN, false);
        if (matchSinglePrefixedField3 == null) {
            matchSinglePrefixedField3 = "nopass";
        }
        return new WifiParsedResult(matchSinglePrefixedField3, matchSinglePrefixedField, matchSinglePrefixedField2, Boolean.parseBoolean(ResultParser.matchSinglePrefixedField("H:", massagedText, ASCIIPropertyListParser.DICTIONARY_ITEM_DELIMITER_TOKEN, false)));
    }
}
