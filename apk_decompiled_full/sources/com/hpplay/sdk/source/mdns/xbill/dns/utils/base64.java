package com.hpplay.sdk.source.mdns.xbill.dns.utils;

import com.google.common.primitives.UnsignedBytes;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes3.dex */
public class base64 {
    private static final String Base64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";

    private base64() {
    }

    public static String formatString(byte[] bArr, int i10, String str, boolean z10) {
        String base64Var = toString(bArr);
        StringBuffer stringBuffer = new StringBuffer();
        int i11 = 0;
        while (i11 < base64Var.length()) {
            stringBuffer.append(str);
            int i12 = i11 + i10;
            if (i12 >= base64Var.length()) {
                stringBuffer.append(base64Var.substring(i11));
                if (z10) {
                    stringBuffer.append(" )");
                }
            } else {
                stringBuffer.append(base64Var.substring(i11, i12));
                stringBuffer.append("\n");
            }
            i11 = i12;
        }
        return stringBuffer.toString();
    }

    public static byte[] fromString(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = str.getBytes();
        char c10 = 0;
        for (int i10 = 0; i10 < bytes.length; i10++) {
            if (!Character.isWhitespace((char) bytes[i10])) {
                byteArrayOutputStream.write(bytes[i10]);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (byteArray.length % 4 != 0) {
            return null;
        }
        byteArrayOutputStream.reset();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        int i11 = 0;
        while (i11 < (byteArray.length + 3) / 4) {
            short[] sArr = new short[4];
            short[] sArr2 = new short[3];
            for (int i12 = 0; i12 < 4; i12++) {
                sArr[i12] = (short) Base64.indexOf(byteArray[(i11 * 4) + i12]);
            }
            int i13 = sArr[c10] << 2;
            short s10 = sArr[1];
            sArr2[c10] = (short) (i13 + (s10 >> 4));
            short s11 = sArr[2];
            if (s11 == 64) {
                sArr2[2] = -1;
                sArr2[1] = -1;
                if ((sArr[1] & 15) != 0) {
                    return null;
                }
            } else {
                short s12 = sArr[3];
                if (s12 == 64) {
                    sArr2[1] = (short) (((s10 << 4) + (s11 >> 2)) & 255);
                    sArr2[2] = -1;
                    if ((sArr[2] & 3) != 0) {
                        return null;
                    }
                } else {
                    sArr2[1] = (short) (((s10 << 4) + (s11 >> 2)) & 255);
                    sArr2[2] = (short) (((s11 << 6) + s12) & 255);
                }
            }
            for (int i14 = 0; i14 < 3; i14++) {
                try {
                    short s13 = sArr2[i14];
                    if (s13 >= 0) {
                        dataOutputStream.writeByte(s13);
                    }
                } catch (IOException unused) {
                }
            }
            i11++;
            c10 = 0;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static String toString(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i10 = 0; i10 < (bArr.length + 2) / 3; i10++) {
            short[] sArr = new short[3];
            short[] sArr2 = new short[4];
            for (int i11 = 0; i11 < 3; i11++) {
                int i12 = (i10 * 3) + i11;
                if (i12 < bArr.length) {
                    sArr[i11] = (short) (bArr[i12] & UnsignedBytes.MAX_VALUE);
                } else {
                    sArr[i11] = -1;
                }
            }
            sArr2[0] = (short) (sArr[0] >> 2);
            short s10 = sArr[1];
            if (s10 == -1) {
                sArr2[1] = (short) ((sArr[0] & 3) << 4);
            } else {
                sArr2[1] = (short) (((sArr[0] & 3) << 4) + (s10 >> 4));
            }
            short s11 = sArr[1];
            if (s11 == -1) {
                sArr2[3] = 64;
                sArr2[2] = 64;
            } else {
                short s12 = sArr[2];
                if (s12 == -1) {
                    sArr2[2] = (short) ((s11 & 15) << 2);
                    sArr2[3] = 64;
                } else {
                    sArr2[2] = (short) (((s11 & 15) << 2) + (s12 >> 6));
                    sArr2[3] = (short) (sArr[2] & 63);
                }
            }
            for (int i13 = 0; i13 < 4; i13++) {
                byteArrayOutputStream.write(Base64.charAt(sArr2[i13]));
            }
        }
        return new String(byteArrayOutputStream.toByteArray());
    }
}
