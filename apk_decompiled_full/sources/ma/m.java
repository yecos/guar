package ma;

import android.content.pm.Signature;
import com.google.common.primitives.UnsignedBytes;
import com.hpplay.cybergarage.soap.SOAP;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes3.dex */
public abstract class m {
    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & UnsignedBytes.MAX_VALUE);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static String b(File file) {
        if (!file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr, 0, 1024);
                if (read == -1) {
                    fileInputStream.close();
                    return a(messageDigest.digest());
                }
                messageDigest.update(bArr, 0, read);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static String c(String str) {
        try {
            String str2 = "";
            for (byte b10 : MessageDigest.getInstance("MD5").digest((str + "ntFT65w6itH!lHCPw7D=@qnsFC5adD28").getBytes())) {
                String hexString = Integer.toHexString(b10 & UnsignedBytes.MAX_VALUE);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
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

    public static String d(Signature signature) {
        try {
            byte[] byteArray = signature.toByteArray();
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            if (messageDigest == null) {
                return "";
            }
            byte[] digest = messageDigest.digest(byteArray);
            StringBuilder sb = new StringBuilder();
            for (byte b10 : digest) {
                sb.append(Integer.toHexString((b10 & UnsignedBytes.MAX_VALUE) | 256).substring(1, 3).toUpperCase());
                sb.append(SOAP.DELIM);
            }
            return sb.substring(0, sb.length() - 1);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String e(String str) {
        return (c(str) + a.a(str)).trim();
    }
}
