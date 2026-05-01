package com.google.zxing.oned;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes2.dex */
public final class CodaBarWriter extends OneDimensionalCodeWriter {
    private static final char[] ALT_START_END_CHARS;
    private static final char[] CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED;
    private static final char DEFAULT_GUARD;
    private static final char[] START_END_CHARS;

    static {
        char[] cArr = {'A', ASCIIPropertyListParser.DATA_GSBOOL_BEGIN_TOKEN, 'C', ASCIIPropertyListParser.DATA_GSDATE_BEGIN_TOKEN};
        START_END_CHARS = cArr;
        ALT_START_END_CHARS = new char[]{ASCIIPropertyListParser.DATE_APPLE_DATE_TIME_DELIMITER, ASCIIPropertyListParser.DATA_GSBOOL_FALSE_TOKEN, '*', 'E'};
        CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED = new char[]{'/', ASCIIPropertyListParser.DATE_TIME_FIELD_DELIMITER, '+', '.'};
        DEFAULT_GUARD = cArr[0];
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int i10;
        if (str.length() < 2) {
            StringBuilder sb = new StringBuilder();
            char c10 = DEFAULT_GUARD;
            sb.append(c10);
            sb.append(str);
            sb.append(c10);
            str = sb.toString();
        } else {
            char upperCase = Character.toUpperCase(str.charAt(0));
            char upperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            char[] cArr = START_END_CHARS;
            boolean arrayContains = CodaBarReader.arrayContains(cArr, upperCase);
            boolean arrayContains2 = CodaBarReader.arrayContains(cArr, upperCase2);
            char[] cArr2 = ALT_START_END_CHARS;
            boolean arrayContains3 = CodaBarReader.arrayContains(cArr2, upperCase);
            boolean arrayContains4 = CodaBarReader.arrayContains(cArr2, upperCase2);
            if (arrayContains) {
                if (!arrayContains2) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + str);
                }
            } else if (!arrayContains3) {
                if (arrayContains2 || arrayContains4) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + str);
                }
                StringBuilder sb2 = new StringBuilder();
                char c11 = DEFAULT_GUARD;
                sb2.append(c11);
                sb2.append(str);
                sb2.append(c11);
                str = sb2.toString();
            } else if (!arrayContains4) {
                throw new IllegalArgumentException("Invalid start/end guards: " + str);
            }
        }
        int i11 = 20;
        for (int i12 = 1; i12 < str.length() - 1; i12++) {
            if (Character.isDigit(str.charAt(i12)) || str.charAt(i12) == '-' || str.charAt(i12) == '$') {
                i11 += 9;
            } else {
                if (!CodaBarReader.arrayContains(CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED, str.charAt(i12))) {
                    throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i12) + '\'');
                }
                i11 += 10;
            }
        }
        boolean[] zArr = new boolean[i11 + (str.length() - 1)];
        int i13 = 0;
        for (int i14 = 0; i14 < str.length(); i14++) {
            char upperCase3 = Character.toUpperCase(str.charAt(i14));
            if (i14 == 0 || i14 == str.length() - 1) {
                if (upperCase3 == '*') {
                    upperCase3 = 'C';
                } else if (upperCase3 == 'E') {
                    upperCase3 = ASCIIPropertyListParser.DATA_GSDATE_BEGIN_TOKEN;
                } else if (upperCase3 == 'N') {
                    upperCase3 = ASCIIPropertyListParser.DATA_GSBOOL_BEGIN_TOKEN;
                } else if (upperCase3 == 'T') {
                    upperCase3 = 'A';
                }
            }
            int i15 = 0;
            while (true) {
                char[] cArr3 = CodaBarReader.ALPHABET;
                if (i15 >= cArr3.length) {
                    i10 = 0;
                    break;
                }
                if (upperCase3 == cArr3[i15]) {
                    i10 = CodaBarReader.CHARACTER_ENCODINGS[i15];
                    break;
                }
                i15++;
            }
            int i16 = 0;
            boolean z10 = true;
            while (true) {
                int i17 = 0;
                while (i16 < 7) {
                    zArr[i13] = z10;
                    i13++;
                    if (((i10 >> (6 - i16)) & 1) == 0 || i17 == 1) {
                        z10 = !z10;
                        i16++;
                    } else {
                        i17++;
                    }
                }
                break;
            }
            if (i14 < str.length() - 1) {
                zArr[i13] = false;
                i13++;
            }
        }
        return zArr;
    }
}
