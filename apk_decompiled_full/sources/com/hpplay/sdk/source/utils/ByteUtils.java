package com.hpplay.sdk.source.utils;

import com.google.common.primitives.UnsignedBytes;

/* loaded from: classes3.dex */
public class ByteUtils {
    public static float bytesToFloat(byte[] bArr, int i10) {
        return Float.intBitsToFloat((int) ((bArr[i10 + 3] << 24) | (16777215 & ((int) ((65535 & ((int) ((bArr[i10] & UnsignedBytes.MAX_VALUE) | (bArr[i10 + 1] << 8)))) | (bArr[i10 + 2] << 16))))));
    }

    public static String bytesToHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & UnsignedBytes.MAX_VALUE);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static byte[] float2byte(float f10) {
        int floatToIntBits = Float.floatToIntBits(f10);
        byte[] bArr = new byte[4];
        for (int i10 = 0; i10 < 4; i10++) {
            bArr[i10] = (byte) (floatToIntBits >> (24 - (i10 * 8)));
        }
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        for (int i11 = 0; i11 < 2; i11++) {
            byte b10 = bArr2[i11];
            int i12 = (4 - i11) - 1;
            bArr2[i11] = bArr2[i12];
            bArr2[i12] = b10;
        }
        return bArr2;
    }

    public static byte[] hexToBytes(String str) {
        if (str == null || str.trim().equals("")) {
            return new byte[0];
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i10 = 0; i10 < str.length() / 2; i10++) {
            int i11 = i10 * 2;
            bArr[i10] = (byte) Integer.parseInt(str.substring(i11, i11 + 2), 16);
        }
        return bArr;
    }
}
