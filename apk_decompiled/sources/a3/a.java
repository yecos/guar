package a3;

import android.text.TextUtils;
import android.util.Base64;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public abstract class a {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return b(str);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String b(String str) {
        try {
            byte[] decode = Base64.decode(str, 0);
            byte[] bArr = new byte[16];
            System.arraycopy(decode, 0, bArr, 0, 16);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
            byte[] bArr2 = new byte[decode.length - 16];
            System.arraycopy(decode, 16, bArr2, 0, decode.length - 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec("b972E8a5A4e0e8Ff".getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return new String(cipher.doFinal(bArr2), "UTF-8");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return d(str);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String d(String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec("b972E8a5A4e0e8Ff".getBytes("UTF-8"), "AES");
            byte[] bArr = new byte[16];
            new SecureRandom().nextBytes(bArr);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            byte[] doFinal = cipher.doFinal(str.getBytes("UTF-8"));
            byte[] bArr2 = new byte[doFinal.length + 16];
            System.arraycopy(bArr, 0, bArr2, 0, 16);
            System.arraycopy(doFinal, 0, bArr2, 16, doFinal.length);
            return Base64.encodeToString(bArr2, 0);
        } catch (Exception unused) {
            return "";
        }
    }
}
