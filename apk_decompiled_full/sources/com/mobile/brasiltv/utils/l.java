package com.mobile.brasiltv.utils;

import com.google.common.primitives.UnsignedBytes;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/* loaded from: classes3.dex */
public abstract class l {
    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b10 : bArr) {
            sb.append(String.format("%02X", Integer.valueOf(b10 & UnsignedBytes.MAX_VALUE)));
        }
        return sb.toString();
    }

    public static String b(String str) {
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(1, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec("7A5POuI3".getBytes("UTF-8"))), new SecureRandom());
        return a(cipher.doFinal(str.getBytes("UTF-8")));
    }
}
