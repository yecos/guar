package com.google.zxing.client.result;

import com.google.zxing.Result;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class AddressBookAUResultParser extends ResultParser {
    private static String[] matchMultipleValuePrefix(String str, int i10, String str2, boolean z10) {
        ArrayList arrayList = null;
        for (int i11 = 1; i11 <= i10; i11++) {
            String matchSinglePrefixedField = ResultParser.matchSinglePrefixedField(str + i11 + ASCIIPropertyListParser.DATE_TIME_FIELD_DELIMITER, str2, ASCIIPropertyListParser.WHITESPACE_CARRIAGE_RETURN, z10);
            if (matchSinglePrefixedField == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList(i10);
            }
            arrayList.add(matchSinglePrefixedField);
        }
        if (arrayList == null) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @Override // com.google.zxing.client.result.ResultParser
    public AddressBookParsedResult parse(Result result) {
        String massagedText = ResultParser.getMassagedText(result);
        if (!massagedText.contains("MEMORY") || !massagedText.contains("\r\n")) {
            return null;
        }
        String matchSinglePrefixedField = ResultParser.matchSinglePrefixedField("NAME1:", massagedText, ASCIIPropertyListParser.WHITESPACE_CARRIAGE_RETURN, true);
        String matchSinglePrefixedField2 = ResultParser.matchSinglePrefixedField("NAME2:", massagedText, ASCIIPropertyListParser.WHITESPACE_CARRIAGE_RETURN, true);
        String[] matchMultipleValuePrefix = matchMultipleValuePrefix("TEL", 3, massagedText, true);
        String[] matchMultipleValuePrefix2 = matchMultipleValuePrefix("MAIL", 3, massagedText, true);
        String matchSinglePrefixedField3 = ResultParser.matchSinglePrefixedField("MEMORY:", massagedText, ASCIIPropertyListParser.WHITESPACE_CARRIAGE_RETURN, false);
        String matchSinglePrefixedField4 = ResultParser.matchSinglePrefixedField("ADD:", massagedText, ASCIIPropertyListParser.WHITESPACE_CARRIAGE_RETURN, true);
        return new AddressBookParsedResult(ResultParser.maybeWrap(matchSinglePrefixedField), null, matchSinglePrefixedField2, matchMultipleValuePrefix, null, matchMultipleValuePrefix2, null, null, matchSinglePrefixedField3, matchSinglePrefixedField4 != null ? new String[]{matchSinglePrefixedField4} : null, null, null, null, null, null, null);
    }
}
