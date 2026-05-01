package io.jsonwebtoken.io;

import com.google.common.primitives.UnsignedBytes;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.Arrays;

/* loaded from: classes3.dex */
final class Base64 {
    private static final char[] BASE64URL_ALPHABET;
    private static final int[] BASE64URL_IALPHABET;
    private static final char[] BASE64_ALPHABET;
    private static final int[] BASE64_IALPHABET;
    static final Base64 DEFAULT;
    private static final int IALPHABET_MAX_INDEX;
    static final Base64 URL_SAFE;
    private final char[] ALPHABET;
    private final int[] IALPHABET;
    private final boolean urlsafe;

    static {
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        BASE64_ALPHABET = charArray;
        BASE64URL_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".toCharArray();
        int[] iArr = new int[256];
        BASE64_IALPHABET = iArr;
        int[] iArr2 = new int[256];
        BASE64URL_IALPHABET = iArr2;
        IALPHABET_MAX_INDEX = iArr.length - 1;
        Arrays.fill(iArr, -1);
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        int length = charArray.length;
        for (int i10 = 0; i10 < length; i10++) {
            BASE64_IALPHABET[BASE64_ALPHABET[i10]] = i10;
            BASE64URL_IALPHABET[BASE64URL_ALPHABET[i10]] = i10;
        }
        BASE64_IALPHABET[61] = 0;
        BASE64URL_IALPHABET[61] = 0;
        DEFAULT = new Base64(false);
        URL_SAFE = new Base64(true);
    }

    private Base64(boolean z10) {
        this.urlsafe = z10;
        this.ALPHABET = z10 ? BASE64URL_ALPHABET : BASE64_ALPHABET;
        this.IALPHABET = z10 ? BASE64URL_IALPHABET : BASE64_IALPHABET;
    }

    private int ctoi(char c10) {
        int i10 = c10 > IALPHABET_MAX_INDEX ? -1 : this.IALPHABET[c10];
        if (i10 >= 0) {
            return i10;
        }
        throw new DecodingException("Illegal " + getName() + " character: '" + c10 + "'");
    }

    private char[] encodeToChar(byte[] bArr, boolean z10) {
        int length = bArr != null ? bArr.length : 0;
        if (length == 0) {
            return new char[0];
        }
        int i10 = (length / 3) * 3;
        int i11 = length - i10;
        int i12 = length - 1;
        int i13 = ((i12 / 3) + 1) << 2;
        int i14 = i13 + (z10 ? ((i13 - 1) / 76) << 1 : 0);
        char[] cArr = new char[this.urlsafe ? i14 - (i11 == 2 ? 1 : i11 == 1 ? 2 : 0) : i14];
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        while (i15 < i10) {
            int i18 = i15 + 1;
            int i19 = i18 + 1;
            int i20 = ((bArr[i15] & UnsignedBytes.MAX_VALUE) << 16) | ((bArr[i18] & UnsignedBytes.MAX_VALUE) << 8);
            int i21 = i19 + 1;
            int i22 = i20 | (bArr[i19] & UnsignedBytes.MAX_VALUE);
            int i23 = i16 + 1;
            char[] cArr2 = this.ALPHABET;
            cArr[i16] = cArr2[(i22 >>> 18) & 63];
            int i24 = i23 + 1;
            cArr[i23] = cArr2[(i22 >>> 12) & 63];
            int i25 = i24 + 1;
            cArr[i24] = cArr2[(i22 >>> 6) & 63];
            i16 = i25 + 1;
            cArr[i25] = cArr2[i22 & 63];
            if (z10 && (i17 = i17 + 1) == 19 && i16 < i14 - 2) {
                int i26 = i16 + 1;
                cArr[i16] = ASCIIPropertyListParser.WHITESPACE_CARRIAGE_RETURN;
                cArr[i26] = '\n';
                i16 = i26 + 1;
                i17 = 0;
            }
            i15 = i21;
        }
        if (i11 > 0) {
            int i27 = ((bArr[i10] & UnsignedBytes.MAX_VALUE) << 10) | (i11 == 2 ? (bArr[i12] & UnsignedBytes.MAX_VALUE) << 2 : 0);
            char[] cArr3 = this.ALPHABET;
            cArr[i14 - 4] = cArr3[i27 >> 12];
            cArr[i14 - 3] = cArr3[(i27 >>> 6) & 63];
            if (i11 == 2) {
                cArr[i14 - 2] = cArr3[i27 & 63];
            } else if (!this.urlsafe) {
                cArr[i14 - 2] = ASCIIPropertyListParser.DICTIONARY_ASSIGN_TOKEN;
            }
            if (!this.urlsafe) {
                cArr[i14 - 1] = ASCIIPropertyListParser.DICTIONARY_ASSIGN_TOKEN;
            }
        }
        return cArr;
    }

    private String getName() {
        return this.urlsafe ? "base64url" : "base64";
    }

    public byte[] decodeFast(CharSequence charSequence) {
        int i10;
        int i11 = 0;
        int length = charSequence != null ? charSequence.length() : 0;
        if (length == 0) {
            return new byte[0];
        }
        int i12 = length - 1;
        int i13 = 0;
        while (i13 < i12 && this.IALPHABET[charSequence.charAt(i13)] < 0) {
            i13++;
        }
        while (i12 > 0 && this.IALPHABET[charSequence.charAt(i12)] < 0) {
            i12--;
        }
        int i14 = charSequence.charAt(i12) == '=' ? charSequence.charAt(i12 + (-1)) == '=' ? 2 : 1 : 0;
        int i15 = (i12 - i13) + 1;
        if (length > 76) {
            i10 = (charSequence.charAt(76) == '\r' ? i15 / 78 : 0) << 1;
        } else {
            i10 = 0;
        }
        int i16 = (((i15 - i10) * 6) >> 3) - i14;
        byte[] bArr = new byte[i16];
        int i17 = (i16 / 3) * 3;
        int i18 = 0;
        int i19 = 0;
        while (i18 < i17) {
            int i20 = i13 + 1;
            int i21 = i20 + 1;
            int ctoi = (ctoi(charSequence.charAt(i13)) << 18) | (ctoi(charSequence.charAt(i20)) << 12);
            int i22 = i21 + 1;
            int ctoi2 = ctoi | (ctoi(charSequence.charAt(i21)) << 6);
            int i23 = i22 + 1;
            int ctoi3 = ctoi2 | ctoi(charSequence.charAt(i22));
            int i24 = i18 + 1;
            bArr[i18] = (byte) (ctoi3 >> 16);
            int i25 = i24 + 1;
            bArr[i24] = (byte) (ctoi3 >> 8);
            int i26 = i25 + 1;
            bArr[i25] = (byte) ctoi3;
            if (i10 <= 0 || (i19 = i19 + 1) != 19) {
                i13 = i23;
            } else {
                i13 = i23 + 2;
                i19 = 0;
            }
            i18 = i26;
        }
        if (i18 < i16) {
            int i27 = 0;
            while (i13 <= i12 - i14) {
                i11 |= ctoi(charSequence.charAt(i13)) << (18 - (i27 * 6));
                i27++;
                i13++;
            }
            int i28 = 16;
            while (i18 < i16) {
                bArr[i18] = (byte) (i11 >> i28);
                i28 -= 8;
                i18++;
            }
        }
        return bArr;
    }

    public String encodeToString(byte[] bArr, boolean z10) {
        return new String(encodeToChar(bArr, z10));
    }
}
