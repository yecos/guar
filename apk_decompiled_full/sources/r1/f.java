package r1;

import com.google.common.primitives.UnsignedBytes;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public abstract class f {
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

    public static String c(String str, String str2) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest((str + str2).getBytes());
            String str3 = "";
            for (byte b10 : digest) {
                String hexString = Integer.toHexString(b10 & UnsignedBytes.MAX_VALUE);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                str3 = str3 + hexString;
            }
            return str3;
        } catch (NoSuchAlgorithmException e10) {
            e10.printStackTrace();
            return " ";
        } catch (Exception e11) {
            e11.printStackTrace();
            return " ";
        }
    }
}
