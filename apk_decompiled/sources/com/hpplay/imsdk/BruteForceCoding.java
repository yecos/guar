package com.hpplay.imsdk;

import com.google.common.primitives.UnsignedBytes;

/* loaded from: classes2.dex */
public class BruteForceCoding {
    public static final int BSIZE = 1;
    public static final int BYTEMASK = 255;
    protected static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final int ISIZE = 4;
    public static final int LSIZE = 8;
    public static final int SSIZE = 2;
    private static final String TAG = "IM_BruteForceCoding";
    private static byte byteVal = 101;
    private static int intVal = 100000001;
    private static long longVal = 1000000000001L;
    private static short shortVal = 10001;

    public static byte[] add(byte[] bArr, byte[] bArr2) {
        return add(bArr, bArr2, EMPTY_BYTE_ARRAY);
    }

    public static String byteArrayToDecimalString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b10 : bArr) {
            sb.append(b10 & UnsignedBytes.MAX_VALUE);
            sb.append(" ");
        }
        return sb.toString();
    }

    public static long decodeIntBigEndian(byte[] bArr, int i10, int i11) {
        long j10 = 0;
        for (int i12 = 0; i12 < i11; i12++) {
            j10 = (j10 << 8) | (bArr[i10 + i12] & 255);
        }
        return j10;
    }

    public static int encodeIntBigEndian(byte[] bArr, long j10, int i10, int i11) {
        int i12 = 0;
        while (i12 < i11) {
            bArr[i10] = (byte) (j10 >> (((i11 - i12) - 1) * 8));
            i12++;
            i10++;
        }
        return i10;
    }

    public static byte[] tail(byte[] bArr, int i10) {
        if (bArr.length < i10) {
            return null;
        }
        byte[] bArr2 = new byte[i10];
        System.arraycopy(bArr, bArr.length - i10, bArr2, 0, i10);
        return bArr2;
    }

    public static byte[] add(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = new byte[bArr.length + bArr2.length + bArr3.length];
        System.arraycopy(bArr, 0, bArr4, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr4, bArr.length, bArr2.length);
        System.arraycopy(bArr3, 0, bArr4, bArr.length + bArr2.length, bArr3.length);
        return bArr4;
    }

    public static byte[] tail(byte[] bArr, int i10, int i11) {
        if (bArr.length < i11) {
            return null;
        }
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        return bArr2;
    }
}
