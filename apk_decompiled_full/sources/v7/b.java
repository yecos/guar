package v7;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f19124a = "2b494e53756c664c2f44465245733572";

    /* renamed from: b, reason: collision with root package name */
    public static String f19125b;

    public static String a(String str, String str2) {
        byte[] e10 = new t7.a().e(a.b(str));
        SecretKey generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(new t7.a().e(str2)));
        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(2, generateSecret);
        return new String(cipher.doFinal(e10), "UTF-8");
    }

    public static String b(String str, String str2) {
        SecretKey generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(new t7.a().e(str2)));
        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(1, generateSecret);
        return a.c(new t7.b().c(cipher.doFinal(str.getBytes("UTF-8"))).replaceAll("\r", "").replaceAll("\n", ""));
    }
}
