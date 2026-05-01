package io.jsonwebtoken.impl;

import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Strings;
import java.io.IOException;
import java.io.Reader;

/* loaded from: classes3.dex */
public class JwtTokenizer {
    static final char DELIMITER = '.';
    private static final String DELIM_ERR_MSG_PREFIX = "Invalid compact JWT string: Compact JWSs must contain exactly 2 period characters, and compact JWEs must contain exactly 4.  Found: ";

    private static int read(Reader reader, char[] cArr) {
        try {
            return reader.read(cArr);
        } catch (IOException e10) {
            throw new MalformedJwtException("Unable to read compact JWT: " + e10.getMessage(), e10);
        }
    }

    public <T extends TokenizedJwt> T tokenize(Reader reader) {
        Assert.notNull(reader, "Reader argument cannot be null.");
        char[] cArr = new char[4096];
        StringBuilder sb = new StringBuilder(4096);
        String str = "";
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        int i10 = 0;
        int i11 = 0;
        while (i10 != -1) {
            i10 = read(reader, cArr);
            for (int i12 = 0; i12 < i10; i12++) {
                char c10 = cArr[i12];
                if (Character.isWhitespace(c10)) {
                    throw new MalformedJwtException("Compact JWT strings may not contain whitespace.");
                }
                if (c10 == '.') {
                    CharSequence clean = Strings.clean(sb);
                    String charSequence = clean != null ? clean.toString() : "";
                    if (i11 == 0) {
                        str = charSequence;
                    } else if (i11 == 1) {
                        str2 = charSequence;
                        str3 = str2;
                    } else if (i11 == 2) {
                        str2 = "";
                        str4 = charSequence;
                    } else if (i11 == 3) {
                        str2 = charSequence;
                    }
                    i11++;
                    sb.setLength(0);
                } else {
                    sb.append(c10);
                }
            }
        }
        if (i11 == 2 || i11 == 4) {
            String sb2 = sb.length() > 0 ? sb.toString() : "";
            return i11 == 2 ? new DefaultTokenizedJwt(str, str2, sb2) : new DefaultTokenizedJwe(str, str2, sb2, str3, str4);
        }
        throw new MalformedJwtException(DELIM_ERR_MSG_PREFIX + i11);
    }
}
