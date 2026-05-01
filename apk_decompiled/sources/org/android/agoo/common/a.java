package org.android.agoo.common;

import com.google.common.base.Ascii;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static byte[] f17826a = {82, Ascii.SYN, 50, 44, -16, 124, -40, -114, -87, -40, 37, Ascii.ETB, -56, Ascii.ETB, -33, 75};

    /* renamed from: b, reason: collision with root package name */
    private static ThreadLocal<Cipher> f17827b = new ThreadLocal<>();

    /* renamed from: c, reason: collision with root package name */
    private static final AlgorithmParameterSpec f17828c = new IvParameterSpec(f17826a);

    public static final byte[] a(byte[] bArr, SecretKeySpec secretKeySpec, byte[] bArr2) {
        try {
            return a(secretKeySpec, bArr2, 2).doFinal(bArr);
        } catch (BadPaddingException e10) {
            throw new IllegalArgumentException("AES decrypt error:" + e10.getMessage(), e10);
        } catch (IllegalBlockSizeException e11) {
            throw new IllegalArgumentException("AES decrypt error:" + e11.getMessage(), e11);
        }
    }

    private static final Cipher a(SecretKeySpec secretKeySpec, byte[] bArr, int i10) {
        Cipher a10 = a();
        try {
            a10.init(i10, secretKeySpec, new IvParameterSpec(bArr));
            return a10;
        } catch (IllegalArgumentException e10) {
            throw new RuntimeException("init Chipher error:" + e10.getMessage(), e10);
        } catch (InvalidAlgorithmParameterException e11) {
            throw new RuntimeException("init Chipher error:" + e11.getMessage(), e11);
        } catch (InvalidKeyException e12) {
            throw new RuntimeException("init Chipher error:" + e12.getMessage(), e12);
        }
    }

    private static final Cipher a() {
        Cipher cipher = f17827b.get();
        if (cipher == null) {
            try {
                cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                f17827b.set(cipher);
            } catch (NoSuchAlgorithmException e10) {
                throw new RuntimeException("get Chipher error:" + e10.getMessage(), e10);
            } catch (NoSuchPaddingException e11) {
                throw new RuntimeException("get Chipher error:" + e11.getMessage(), e11);
            }
        }
        return cipher;
    }

    public static final byte[] a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Throwable th) {
            throw new RuntimeException("md5 value Throwable", th);
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "HmacSHA1");
        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(secretKeySpec);
            return mac.doFinal(bArr2);
        } catch (Throwable th) {
            throw new RuntimeException("HmacSHA1 Throwable", th);
        }
    }
}
