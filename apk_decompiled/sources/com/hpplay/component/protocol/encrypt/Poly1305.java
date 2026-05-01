package com.hpplay.component.protocol.encrypt;

import com.google.common.primitives.UnsignedBytes;
import com.hpplay.sdk.source.mdns.xbill.dns.Type;

/* loaded from: classes2.dex */
public class Poly1305 {
    static final int[] minusp = {5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Type.AXFR};
    final int CRYPTO_BYTES = 16;
    final int CRYPTO_KEYBYTES = 32;

    public static void add(int[] iArr, int[] iArr2) {
        int i10 = 0;
        for (int i11 = 0; i11 < 17; i11++) {
            int i12 = i10 + iArr[i11] + iArr2[i11];
            iArr[i11] = i12 & 255;
            i10 = i12 >>> 8;
        }
    }

    public static int crypto_onetimeauth(byte[] bArr, int i10, byte[] bArr2, int i11, long j10, byte[] bArr3) {
        int[] iArr = new int[17];
        int[] iArr2 = new int[17];
        int[] iArr3 = {bArr3[0] & UnsignedBytes.MAX_VALUE, bArr3[1] & UnsignedBytes.MAX_VALUE, bArr3[2] & UnsignedBytes.MAX_VALUE, bArr3[3] & 15, bArr3[4] & 252, bArr3[5] & UnsignedBytes.MAX_VALUE, bArr3[6] & UnsignedBytes.MAX_VALUE, bArr3[7] & 15, bArr3[8] & 252, bArr3[9] & UnsignedBytes.MAX_VALUE, bArr3[10] & UnsignedBytes.MAX_VALUE, bArr3[11] & 15, bArr3[12] & 252, bArr3[13] & UnsignedBytes.MAX_VALUE, bArr3[14] & UnsignedBytes.MAX_VALUE, bArr3[15] & 15, 0};
        for (int i12 = 0; i12 < 17; i12++) {
            iArr[i12] = 0;
        }
        int i13 = i11;
        long j11 = j10;
        while (j11 > 0) {
            for (int i14 = 0; i14 < 17; i14++) {
                iArr2[i14] = 0;
            }
            int i15 = 0;
            while (i15 < 16 && i15 < j11) {
                iArr2[i15] = bArr2[i13 + i15] & UnsignedBytes.MAX_VALUE;
                i15++;
            }
            iArr2[i15] = 1;
            i13 += i15;
            j11 -= i15;
            add(iArr, iArr2);
            mulmod(iArr, iArr3);
        }
        freeze(iArr);
        for (int i16 = 0; i16 < 16; i16++) {
            iArr2[i16] = bArr3[i16 + 16] & UnsignedBytes.MAX_VALUE;
        }
        iArr2[16] = 0;
        add(iArr, iArr2);
        for (int i17 = 0; i17 < 16; i17++) {
            bArr[i17 + i10] = (byte) iArr[i17];
        }
        return 0;
    }

    public static int crypto_onetimeauth_verify(byte[] bArr, int i10, byte[] bArr2, int i11, long j10, byte[] bArr3) {
        byte[] bArr4 = new byte[16];
        crypto_onetimeauth(bArr4, 0, bArr2, i11, j10, bArr3);
        return Verify16.crypto_verify(bArr, i10, bArr4);
    }

    public static void freeze(int[] iArr) {
        int[] iArr2 = new int[17];
        for (int i10 = 0; i10 < 17; i10++) {
            iArr2[i10] = iArr[i10];
        }
        add(iArr, minusp);
        int i11 = -(iArr[16] >>> 7);
        for (int i12 = 0; i12 < 17; i12++) {
            int i13 = iArr[i12];
            iArr[i12] = i13 ^ ((iArr2[i12] ^ i13) & i11);
        }
    }

    public static void mulmod(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[17];
        int i10 = 0;
        while (i10 < 17) {
            int i11 = 0;
            for (int i12 = 0; i12 <= i10; i12++) {
                i11 += iArr[i12] * iArr2[i10 - i12];
            }
            int i13 = i10 + 1;
            for (int i14 = i13; i14 < 17; i14++) {
                i11 += iArr[i14] * 320 * iArr2[(i10 + 17) - i14];
            }
            iArr3[i10] = i11;
            i10 = i13;
        }
        for (int i15 = 0; i15 < 17; i15++) {
            iArr[i15] = iArr3[i15];
        }
        squeeze(iArr);
    }

    public static void squeeze(int[] iArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 16; i11++) {
            int i12 = i10 + iArr[i11];
            iArr[i11] = i12 & 255;
            i10 = i12 >>> 8;
        }
        int i13 = i10 + iArr[16];
        iArr[16] = i13 & 3;
        int i14 = (i13 >>> 2) * 5;
        for (int i15 = 0; i15 < 16; i15++) {
            int i16 = i14 + iArr[i15];
            iArr[i15] = i16 & 255;
            i14 = i16 >>> 8;
        }
        iArr[16] = i14 + iArr[16];
    }
}
