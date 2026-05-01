package com.hpplay.component.protocol.encrypt;

import com.google.common.primitives.UnsignedBytes;

/* loaded from: classes2.dex */
public class ChaCha20 {
    public static final int KEY_SIZE = 32;
    public static final int NONCE_SIZE_IETF = 12;
    public static final int NONCE_SIZE_REF = 8;
    private int[] matrix;

    public class WrongKeySizeException extends Exception {
        private static final long serialVersionUID = -290509589749955895L;

        public WrongKeySizeException() {
        }
    }

    public class WrongNonceSizeException extends Exception {
        private static final long serialVersionUID = 2687731889587117531L;

        public WrongNonceSizeException() {
        }
    }

    public ChaCha20(byte[] bArr, byte[] bArr2, int i10) {
        int[] iArr = new int[16];
        this.matrix = iArr;
        if (bArr.length != 32) {
            throw new WrongKeySizeException();
        }
        iArr[0] = 1634760805;
        iArr[1] = 857760878;
        iArr[2] = 2036477234;
        iArr[3] = 1797285236;
        iArr[4] = littleEndianToInt(bArr, 0);
        this.matrix[5] = littleEndianToInt(bArr, 4);
        this.matrix[6] = littleEndianToInt(bArr, 8);
        this.matrix[7] = littleEndianToInt(bArr, 12);
        this.matrix[8] = littleEndianToInt(bArr, 16);
        this.matrix[9] = littleEndianToInt(bArr, 20);
        this.matrix[10] = littleEndianToInt(bArr, 24);
        this.matrix[11] = littleEndianToInt(bArr, 28);
        if (bArr2.length == 8) {
            int[] iArr2 = this.matrix;
            iArr2[12] = 0;
            iArr2[13] = 0;
            iArr2[14] = littleEndianToInt(bArr2, 0);
            this.matrix[15] = littleEndianToInt(bArr2, 4);
            return;
        }
        if (bArr2.length != 12) {
            throw new WrongNonceSizeException();
        }
        int[] iArr3 = this.matrix;
        iArr3[12] = i10;
        iArr3[13] = littleEndianToInt(bArr2, 0);
        this.matrix[14] = littleEndianToInt(bArr2, 4);
        this.matrix[15] = littleEndianToInt(bArr2, 8);
    }

    public static int ROTATE(int i10, int i11) {
        return (i10 >>> (32 - i11)) | (i10 << i11);
    }

    public static void intToLittleEndian(int i10, byte[] bArr, int i11) {
        bArr[i11] = (byte) i10;
        int i12 = i11 + 1;
        bArr[i12] = (byte) (i10 >>> 8);
        int i13 = i12 + 1;
        bArr[i13] = (byte) (i10 >>> 16);
        bArr[i13 + 1] = (byte) (i10 >>> 24);
    }

    public static int littleEndianToInt(byte[] bArr, int i10) {
        return ((bArr[i10 + 3] & UnsignedBytes.MAX_VALUE) << 24) | (bArr[i10] & UnsignedBytes.MAX_VALUE) | ((bArr[i10 + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i10 + 2] & UnsignedBytes.MAX_VALUE) << 16);
    }

    public static void quarterRound(int[] iArr, int i10, int i11, int i12, int i13) {
        int i14 = iArr[i10] + iArr[i11];
        iArr[i10] = i14;
        int ROTATE = ROTATE(i14 ^ iArr[i13], 16);
        iArr[i13] = ROTATE;
        int i15 = iArr[i12] + ROTATE;
        iArr[i12] = i15;
        int ROTATE2 = ROTATE(iArr[i11] ^ i15, 12);
        iArr[i11] = ROTATE2;
        int i16 = iArr[i10] + ROTATE2;
        iArr[i10] = i16;
        int ROTATE3 = ROTATE(iArr[i13] ^ i16, 8);
        iArr[i13] = ROTATE3;
        int i17 = iArr[i12] + ROTATE3;
        iArr[i12] = i17;
        iArr[i11] = ROTATE(iArr[i11] ^ i17, 7);
    }

    public void decrypt(byte[] bArr, byte[] bArr2, int i10) {
        encrypt(bArr, bArr2, i10);
    }

    public void encrypt(byte[] bArr, byte[] bArr2, int i10) {
        int[] iArr = new int[16];
        byte[] bArr3 = new byte[64];
        int i11 = i10;
        int i12 = 0;
        int i13 = 0;
        while (i11 > 0) {
            int i14 = 16;
            while (true) {
                int i15 = i14 - 1;
                if (i14 <= 0) {
                    break;
                }
                iArr[i15] = this.matrix[i15];
                i14 = i15;
            }
            for (int i16 = 20; i16 > 0; i16 -= 2) {
                quarterRound(iArr, 0, 4, 8, 12);
                quarterRound(iArr, 1, 5, 9, 13);
                quarterRound(iArr, 2, 6, 10, 14);
                quarterRound(iArr, 3, 7, 11, 15);
                quarterRound(iArr, 0, 5, 10, 15);
                quarterRound(iArr, 1, 6, 11, 12);
                quarterRound(iArr, 2, 7, 8, 13);
                quarterRound(iArr, 3, 4, 9, 14);
            }
            int i17 = 16;
            while (true) {
                int i18 = i17 - 1;
                if (i17 <= 0) {
                    break;
                }
                iArr[i18] = iArr[i18] + this.matrix[i18];
                i17 = i18;
            }
            int i19 = 16;
            while (true) {
                int i20 = i19 - 1;
                if (i19 <= 0) {
                    break;
                }
                intToLittleEndian(iArr[i20], bArr3, i20 * 4);
                i19 = i20;
            }
            int[] iArr2 = this.matrix;
            int i21 = iArr2[12] + 1;
            iArr2[12] = i21;
            if (i21 <= 0) {
                iArr2[13] = iArr2[13] + 1;
            }
            if (i11 <= 64) {
                while (true) {
                    int i22 = i11 - 1;
                    if (i11 <= 0) {
                        return;
                    }
                    bArr[i22 + i12] = (byte) (bArr2[i22 + i13] ^ bArr3[i22]);
                    i11 = i22;
                }
            } else {
                int i23 = 64;
                while (true) {
                    int i24 = i23 - 1;
                    if (i23 > 0) {
                        bArr[i24 + i12] = (byte) (bArr2[i24 + i13] ^ bArr3[i24]);
                        i23 = i24;
                    }
                }
                i11 -= 64;
                i13 += 64;
                i12 += 64;
            }
        }
    }
}
