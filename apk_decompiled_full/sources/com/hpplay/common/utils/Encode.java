package com.hpplay.common.utils;

import android.text.TextUtils;
import com.hpplay.cybergarage.xml.XML;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public class Encode {
    private static final Charset charset = Charset.forName(XML.CHARSET_UTF8);

    public static String decode(String str, String str2) {
        return encode(str, str2);
    }

    public static String decodeByteToString(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            return new String(bArr, charset);
        }
        Charset charset2 = charset;
        return new String(encrypt(bArr, str.getBytes(charset2)), charset2);
    }

    public static String encode(String str, String str2) {
        return TextUtils.isEmpty(str2) ? str : new String(encodeToByte(str, str2), charset);
    }

    public static byte[] encodeToByte(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str.getBytes(charset);
        }
        Charset charset2 = charset;
        return encrypt(str.getBytes(charset2), str2.getBytes(charset2));
    }

    private static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i10 = 0;
        while (i10 < length) {
            for (byte b10 : bArr2) {
                bArr[i10] = (byte) (b10 ^ bArr[i10]);
                i10++;
                if (i10 >= length) {
                    break;
                }
            }
        }
        return bArr;
    }
}
