package com.hpplay.component.utils;

import android.text.TextUtils;
import com.google.common.primitives.UnsignedBytes;
import com.hpplay.component.common.utils.CLog;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
public class EncryptUtil {
    private static final String TAG = "EncryptUtil";

    private EncryptUtil() {
        throw new UnsupportedOperationException("u can't instantiate me...");
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
            CLog.w(TAG, e10);
            return "";
        }
    }

    public static String xor(String str) {
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        for (int i10 = 0; i10 < bytes.length; i10++) {
            bytes[i10] = (byte) (bytes[i10] ^ 1);
        }
        return new String(bytes);
    }
}
