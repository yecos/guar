package a3;

import com.google.common.primitives.UnsignedBytes;
import com.hpplay.cybergarage.http.HTTP;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f163a = new f();

    public final String a(String str) {
        t9.i.g(str, "str");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bytes = str.getBytes(ba.c.f5214b);
            t9.i.f(bytes, "this as java.lang.String).getBytes(charset)");
            byte[] digest = messageDigest.digest(bytes);
            String str2 = "";
            t9.i.f(digest, HTTP.CONTENT_RANGE_BYTES);
            for (byte b10 : digest) {
                String hexString = Integer.toHexString(b10 & UnsignedBytes.MAX_VALUE);
                if (hexString.length() == 1) {
                    hexString = '0' + hexString;
                }
                str2 = str2 + hexString;
            }
            return str2;
        } catch (NoSuchAlgorithmException e10) {
            e10.printStackTrace();
            return " ";
        } catch (Exception e11) {
            e11.printStackTrace();
            return " ";
        }
    }
}
