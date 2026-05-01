package io.jsonwebtoken.impl.lang;

import com.google.common.primitives.UnsignedBytes;
import io.jsonwebtoken.impl.security.Randoms;
import io.jsonwebtoken.lang.Assert;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class Bytes {
    public static final byte[] EMPTY = new byte[0];
    private static final int INT_BYTE_LENGTH = 4;
    public static final String INT_REQD_MSG = "Integer byte arrays must be 4 bytes in length.";
    private static final int LONG_BYTE_LENGTH = 8;
    public static final String LONG_REQD_MSG = "Long byte arrays must be 8 bytes in length.";

    private Bytes() {
    }

    public static long bitLength(byte[] bArr) {
        return length(bArr) * 8;
    }

    public static String bitsMsg(long j10) {
        return j10 + " bits (" + (j10 / 8) + " bytes)";
    }

    public static String bytesMsg(int i10) {
        return bitsMsg(i10 * 8);
    }

    public static void clear(byte[] bArr) {
        if (isEmpty(bArr)) {
            return;
        }
        Arrays.fill(bArr, (byte) 0);
    }

    public static byte[] concat(byte[]... bArr) {
        int length = io.jsonwebtoken.lang.Arrays.length(bArr);
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            i10 += length(bArr[i11]);
        }
        byte[] bArr2 = new byte[i10];
        if (i10 > 0) {
            int i12 = 0;
            for (byte[] bArr3 : bArr) {
                int length2 = length(bArr3);
                if (length2 > 0) {
                    System.arraycopy(bArr3, 0, bArr2, i12, length2);
                    i12 += length2;
                }
            }
        }
        return bArr2;
    }

    public static boolean endsWith(byte[] bArr, byte[] bArr2) {
        return startsWith(bArr, bArr2, length(bArr) - length(bArr2));
    }

    public static void increment(byte[] bArr) {
        for (int length = bArr.length - 1; length >= 0; length--) {
            byte b10 = (byte) (bArr[length] + 1);
            bArr[length] = b10;
            if (b10 != 0) {
                return;
            }
        }
    }

    public static int indexOf(byte[] bArr, byte[] bArr2) {
        return indexOf(bArr, bArr2, 0);
    }

    public static boolean isEmpty(byte[] bArr) {
        return length(bArr) == 0;
    }

    public static int length(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public static byte[] nullSafe(byte[] bArr) {
        return bArr != null ? bArr : EMPTY;
    }

    public static byte[] prepad(byte[] bArr, int i10) {
        Assert.notNull(bArr, "byte array cannot be null.");
        Assert.gt(Integer.valueOf(i10), 0, "length must be positive (> 0).");
        if (bArr.length >= i10) {
            return bArr;
        }
        byte[] bArr2 = new byte[i10];
        System.arraycopy(bArr, 0, bArr2, i10 - bArr.length, bArr.length);
        return bArr2;
    }

    public static byte[] random(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("numBytes argument must be >= 0");
        }
        byte[] bArr = new byte[i10];
        Randoms.secureRandom().nextBytes(bArr);
        return bArr;
    }

    public static byte[] randomBits(int i10) {
        return random(i10 / 8);
    }

    public static boolean startsWith(byte[] bArr, byte[] bArr2) {
        return startsWith(bArr, bArr2, 0);
    }

    public static byte[] toBytes(int i10) {
        return new byte[]{(byte) (i10 >>> 24), (byte) (i10 >>> 16), (byte) (i10 >>> 8), (byte) i10};
    }

    public static int toInt(byte[] bArr) {
        Assert.isTrue(io.jsonwebtoken.lang.Arrays.length(bArr) == 4, INT_REQD_MSG);
        return (bArr[3] & UnsignedBytes.MAX_VALUE) | ((bArr[0] & UnsignedBytes.MAX_VALUE) << 24) | ((bArr[1] & UnsignedBytes.MAX_VALUE) << 16) | ((bArr[2] & UnsignedBytes.MAX_VALUE) << 8);
    }

    public static long toLong(byte[] bArr) {
        Assert.isTrue(io.jsonwebtoken.lang.Arrays.length(bArr) == 8, LONG_REQD_MSG);
        return ((bArr[1] & 255) << 48) | ((bArr[0] & 255) << 56) | ((bArr[2] & 255) << 40) | ((bArr[3] & 255) << 32) | ((bArr[4] & 255) << 24) | ((bArr[5] & 255) << 16) | ((bArr[6] & 255) << 8) | (bArr[7] & 255);
    }

    public static int indexOf(byte[] bArr, byte[] bArr2, int i10) {
        return indexOf(bArr, 0, length(bArr), bArr2, 0, length(bArr2), i10);
    }

    public static int length(int i10) {
        if (i10 >= 0) {
            return (i10 + 7) / 8;
        }
        throw new IllegalArgumentException("bitLength argument must be >= 0");
    }

    public static boolean startsWith(byte[] bArr, byte[] bArr2, int i10) {
        int length = length(bArr2);
        if (i10 < 0 || i10 > length(bArr) - length) {
            return false;
        }
        int i11 = 0;
        while (true) {
            length--;
            if (length < 0) {
                return true;
            }
            int i12 = i10 + 1;
            int i13 = i11 + 1;
            if (bArr[i10] != bArr2[i11]) {
                return false;
            }
            i10 = i12;
            i11 = i13;
        }
    }

    public static byte[] toBytes(long j10) {
        return new byte[]{(byte) (j10 >>> 56), (byte) (j10 >>> 48), (byte) (j10 >>> 40), (byte) (j10 >>> 32), (byte) (j10 >>> 24), (byte) (j10 >>> 16), (byte) (j10 >>> 8), (byte) j10};
    }

    public static int indexOf(byte[] bArr, int i10, int i11, byte[] bArr2, int i12, int i13, int i14) {
        if (i14 >= i11) {
            if (i13 == 0) {
                return i11;
            }
            return -1;
        }
        if (i14 < 0) {
            i14 = 0;
        }
        if (i13 == 0) {
            return i14;
        }
        byte b10 = bArr2[i12];
        int i15 = (i11 - i13) + i10;
        int i16 = i14 + i10;
        while (i16 <= i15) {
            if (bArr[i16] != b10) {
                do {
                    i16++;
                    if (i16 > i15) {
                        break;
                    }
                } while (bArr[i16] != b10);
            }
            if (i16 <= i15) {
                int i17 = i16 + 1;
                int i18 = (i17 + i13) - 1;
                for (int i19 = i12 + 1; i17 < i18 && bArr[i17] == bArr2[i19]; i19++) {
                    i17++;
                }
                if (i17 == i18) {
                    return i16 - i10;
                }
            }
            i16++;
        }
        return -1;
    }
}
