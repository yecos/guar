package com.umeng.message.proguard;

import android.text.TextUtils;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public final class bk {
    public static String a(String str, String str2, byte[] bArr) {
        if (TextUtils.isEmpty(str2) || bArr == null || TextUtils.isEmpty(str)) {
            return "";
        }
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, new SecretKeySpec(str2.getBytes(), "AES"), new IvParameterSpec(bArr));
        return bf.a(cipher.doFinal(str.getBytes()));
    }

    public static String b(String str, String str2, byte[] bArr) {
        if (TextUtils.isEmpty(str2) || bArr == null || TextUtils.isEmpty(str)) {
            return "";
        }
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, new SecretKeySpec(str2.getBytes(), "AES"), new IvParameterSpec(bArr));
        return new String(cipher.doFinal(bf.a(str)));
    }
}
