package com.hpplay.common.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.google.common.primitives.UnsignedBytes;
import com.hpplay.common.log.LeLog;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
public class EncryptUtil {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', ASCIIPropertyListParser.DATA_GSBOOL_BEGIN_TOKEN, 'C', ASCIIPropertyListParser.DATA_GSDATE_BEGIN_TOKEN, 'E', 'F'};
    private static final String TAG = "EncryptUtil";

    private EncryptUtil() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static byte[] base64Decode(byte[] bArr) {
        return Base64.decode(bArr, 2);
    }

    private static byte[] base64Encode(byte[] bArr) {
        return Base64.encode(bArr, 2);
    }

    private static String bytes2HexString(byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) <= 0) {
            return "";
        }
        char[] cArr = new char[length << 1];
        int i10 = 0;
        for (byte b10 : bArr) {
            int i11 = i10 + 1;
            char[] cArr2 = HEX_DIGITS;
            cArr[i10] = cArr2[(b10 >> 4) & 15];
            i10 = i11 + 1;
            cArr[i11] = cArr2[b10 & 15];
        }
        return new String(cArr);
    }

    public static byte[] encryptMD5(byte[] bArr) {
        return hashTemplate(bArr, "MD5");
    }

    public static String encryptMD5ToString(String str) {
        return (str == null || str.length() == 0) ? "" : encryptMD5ToString(str.getBytes());
    }

    public static byte[] encryptSHA256(byte[] bArr) {
        return hashTemplate(bArr, "SHA-256");
    }

    public static String encryptSHA256ToString(String str) {
        return (str == null || str.length() == 0) ? "" : encryptSHA256ToString(str.getBytes());
    }

    public static int fnvHash(String str) {
        int i10 = -2128831035;
        for (int i11 = 0; i11 < str.length(); i11++) {
            i10 = (i10 ^ str.charAt(i11)) * 16777619;
        }
        int i12 = i10 + (i10 << 13);
        int i13 = (i12 >> 7) ^ i12;
        int i14 = i13 + (i13 << 3);
        int i15 = i14 ^ (i14 >> 17);
        return i15 + (i15 << 5);
    }

    private static byte[] hashTemplate(byte[] bArr, String str) {
        if (bArr != null && bArr.length > 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                messageDigest.update(bArr);
                return messageDigest.digest();
            } catch (Exception e10) {
                LeLog.w(TAG, e10);
            }
        }
        return null;
    }

    private static int hex2Dec(char c10) {
        if (c10 >= '0' && c10 <= '9') {
            return c10 - '0';
        }
        if (c10 < 'A' || c10 > 'F') {
            throw new IllegalArgumentException();
        }
        return (c10 - 'A') + 10;
    }

    private static byte[] hexString2Bytes(String str) {
        if (isSpace(str)) {
            return null;
        }
        int length = str.length();
        if (length % 2 != 0) {
            str = "0" + str;
            length++;
        }
        char[] charArray = str.toUpperCase().toCharArray();
        byte[] bArr = new byte[length >> 1];
        for (int i10 = 0; i10 < length; i10 += 2) {
            bArr[i10 >> 1] = (byte) ((hex2Dec(charArray[i10]) << 4) | hex2Dec(charArray[i10 + 1]));
        }
        return bArr;
    }

    private static boolean isSpace(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!Character.isWhitespace(str.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    public static String md5EncryData(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String str2 = "";
            for (byte b10 : MessageDigest.getInstance("MD5").digest(str.getBytes())) {
                String hexString = Integer.toHexString(b10 & UnsignedBytes.MAX_VALUE);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                str2 = str2 + hexString;
            }
            return str2;
        } catch (Exception e10) {
            LeLog.w(TAG, e10);
            return "";
        }
    }

    public static String md5EncryData16(String str) {
        String md5EncryData = md5EncryData(str);
        return md5EncryData.length() >= 24 ? md5EncryData.substring(8, 24) : "";
    }

    public static long parseMd5L16ToLong(String str) {
        if (TextUtils.isEmpty(str)) {
            LeLog.e(TAG, "parseMd5L16ToLong error, invalid input");
            return -1L;
        }
        String lowerCase = str.toLowerCase();
        long j10 = 0;
        for (byte b10 : lowerCase.getBytes()) {
            long j11 = j10 << 4;
            byte b11 = (byte) (b10 - 48);
            if (b11 > 9) {
                b11 = (byte) (b11 - 39);
            }
            if (b11 > 15 || b11 < 0) {
                LeLog.e(TAG, "parseMd5L16ToLong error,For input string: " + lowerCase);
                return -1L;
            }
            j10 = j11 + b11;
        }
        return j10;
    }

    public static String encryptMD5ToString(byte[] bArr) {
        return bytes2HexString(encryptMD5(bArr));
    }

    public static String encryptSHA256ToString(byte[] bArr) {
        return bytes2HexString(encryptSHA256(bArr));
    }
}
