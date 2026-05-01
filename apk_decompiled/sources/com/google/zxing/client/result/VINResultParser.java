package com.google.zxing.client.result;

import com.google.android.gms.cast.CastStatusCodes;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.cybergarage.http.HTTP;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class VINResultParser extends ResultParser {
    private static final Pattern IOQ = Pattern.compile("[IOQ]");
    private static final Pattern AZ09 = Pattern.compile("[A-Z0-9]{17}");

    private static char checkChar(int i10) {
        if (i10 < 10) {
            return (char) (i10 + 48);
        }
        if (i10 == 10) {
            return 'X';
        }
        throw new IllegalArgumentException();
    }

    private static boolean checkChecksum(CharSequence charSequence) {
        int i10 = 0;
        int i11 = 0;
        while (i10 < charSequence.length()) {
            int i12 = i10 + 1;
            i11 += vinPositionWeight(i12) * vinCharValue(charSequence.charAt(i10));
            i10 = i12;
        }
        return charSequence.charAt(8) == checkChar(i11 % 11);
    }

    private static String countryCode(CharSequence charSequence) {
        char charAt = charSequence.charAt(0);
        char charAt2 = charSequence.charAt(1);
        if (charAt == '9') {
            if (charAt2 >= 'A' && charAt2 <= 'E') {
                return "BR";
            }
            if (charAt2 < '3' || charAt2 > '9') {
                return null;
            }
            return "BR";
        }
        if (charAt == 'S') {
            if (charAt2 >= 'A' && charAt2 <= 'M') {
                return "UK";
            }
            if (charAt2 < 'N' || charAt2 > 'T') {
                return null;
            }
            return "DE";
        }
        if (charAt == 'Z') {
            if (charAt2 < 'A' || charAt2 > 'R') {
                return null;
            }
            return "IT";
        }
        switch (charAt) {
            case '1':
            case '4':
            case '5':
                return "US";
            case '2':
                return "CA";
            case '3':
                if (charAt2 < 'A' || charAt2 > 'W') {
                    return null;
                }
                return HTTP.MX;
            default:
                switch (charAt) {
                    case 'J':
                        if (charAt2 < 'A' || charAt2 > 'T') {
                            return null;
                        }
                        return "JP";
                    case 'K':
                        if (charAt2 < 'L' || charAt2 > 'R') {
                            return null;
                        }
                        return "KO";
                    case 'L':
                        return "CN";
                    case 'M':
                        if (charAt2 < 'A' || charAt2 > 'E') {
                            return null;
                        }
                        return Operator.Operation.IN;
                    default:
                        switch (charAt) {
                            case 'V':
                                if (charAt2 >= 'F' && charAt2 <= 'R') {
                                    return "FR";
                                }
                                if (charAt2 < 'S' || charAt2 > 'W') {
                                    return null;
                                }
                                return "ES";
                            case 'W':
                                return "DE";
                            case 'X':
                                if (charAt2 == '0') {
                                    return "RU";
                                }
                                if (charAt2 < '3' || charAt2 > '9') {
                                    return null;
                                }
                                return "RU";
                            default:
                                return null;
                        }
                }
        }
    }

    private static int modelYear(char c10) {
        if (c10 >= 'E' && c10 <= 'H') {
            return (c10 - 'E') + 1984;
        }
        if (c10 >= 'J' && c10 <= 'N') {
            return (c10 - 'J') + 1988;
        }
        if (c10 == 'P') {
            return 1993;
        }
        if (c10 >= 'R' && c10 <= 'T') {
            return (c10 - ASCIIPropertyListParser.DATA_GSREAL_BEGIN_TOKEN) + 1994;
        }
        if (c10 >= 'V' && c10 <= 'Y') {
            return (c10 - 'V') + 1997;
        }
        if (c10 >= '1' && c10 <= '9') {
            return (c10 - '1') + CastStatusCodes.INVALID_REQUEST;
        }
        if (c10 < 'A' || c10 > 'D') {
            throw new IllegalArgumentException();
        }
        return (c10 - 'A') + 2010;
    }

    private static int vinCharValue(char c10) {
        if (c10 >= 'A' && c10 <= 'I') {
            return (c10 - 'A') + 1;
        }
        if (c10 >= 'J' && c10 <= 'R') {
            return (c10 - 'J') + 1;
        }
        if (c10 >= 'S' && c10 <= 'Z') {
            return (c10 - 'S') + 2;
        }
        if (c10 < '0' || c10 > '9') {
            throw new IllegalArgumentException();
        }
        return c10 - '0';
    }

    private static int vinPositionWeight(int i10) {
        if (i10 > 0 && i10 <= 7) {
            return 9 - i10;
        }
        if (i10 == 8) {
            return 10;
        }
        if (i10 == 9) {
            return 0;
        }
        if (i10 < 10 || i10 > 17) {
            throw new IllegalArgumentException();
        }
        return 19 - i10;
    }

    @Override // com.google.zxing.client.result.ResultParser
    public VINParsedResult parse(Result result) {
        if (result.getBarcodeFormat() != BarcodeFormat.CODE_39) {
            return null;
        }
        String trim = IOQ.matcher(result.getText()).replaceAll("").trim();
        if (!AZ09.matcher(trim).matches()) {
            return null;
        }
        try {
            if (!checkChecksum(trim)) {
                return null;
            }
            String substring = trim.substring(0, 3);
            return new VINParsedResult(trim, substring, trim.substring(3, 9), trim.substring(9, 17), countryCode(substring), trim.substring(3, 8), modelYear(trim.charAt(9)), trim.charAt(10), trim.substring(11));
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
