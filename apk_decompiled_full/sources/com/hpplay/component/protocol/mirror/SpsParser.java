package com.hpplay.component.protocol.mirror;

import com.hpplay.component.common.utils.CLog;

/* loaded from: classes2.dex */
public class SpsParser {
    private static final int NAL_HEADER = 4;
    private static final String TAG = "SpsParser";
    private static int nStartBit;

    private static int Se(byte[] bArr, int i10) {
        int Ue = Ue(bArr, i10);
        double d10 = Ue;
        Double.isNaN(d10);
        int ceil = (int) Math.ceil(d10 / 2.0d);
        return Ue % 2 == 0 ? -ceil : ceil;
    }

    private static int Ue(byte[] bArr, int i10) {
        int i11;
        int i12 = 0;
        while (true) {
            i11 = nStartBit;
            if (i11 >= i10 * 8 || (bArr[i11 / 8] & (128 >> (i11 % 8))) != 0) {
                break;
            }
            i12++;
            nStartBit = i11 + 1;
        }
        nStartBit = i11 + 1;
        int i13 = 0;
        for (int i14 = 0; i14 < i12; i14++) {
            i13 <<= 1;
            int i15 = nStartBit;
            if ((bArr[i15 / 8] & (128 >> (i15 % 8))) != 0) {
                i13++;
            }
            nStartBit = i15 + 1;
        }
        return ((1 << i12) - 1) + i13;
    }

    public static int[] getSizeFromSps(byte[] bArr) {
        for (int i10 = 0; i10 < bArr.length - 4; i10++) {
            if (bArr[i10] == 0 && bArr[i10 + 1] == 0 && bArr[i10 + 2] == 0 && bArr[i10 + 3] == 1 && bArr[i10 + 4] == 103) {
                int[] iArr = new int[2];
                h264_decode_seq_parameter_set(bArr, bArr.length, iArr);
                CLog.i(TAG, "Sps=(" + iArr[0] + ", " + iArr[1] + ")");
                return iArr;
            }
        }
        return null;
    }

    private static boolean h264_decode_seq_parameter_set(byte[] bArr, int i10, int[] iArr) {
        nStartBit = 32;
        u(1, bArr);
        u(2, bArr);
        if (u(5, bArr) != 7) {
            return false;
        }
        int u10 = u(8, bArr);
        u(1, bArr);
        u(1, bArr);
        u(1, bArr);
        u(1, bArr);
        u(4, bArr);
        u(8, bArr);
        Ue(bArr, i10);
        if (u10 == 100 || u10 == 110 || u10 == 122 || u10 == 144) {
            if (Ue(bArr, i10) == 3) {
                u(1, bArr);
            }
            Ue(bArr, i10);
            Ue(bArr, i10);
            u(1, bArr);
            int[] iArr2 = new int[8];
            if (u(1, bArr) != 0) {
                for (int i11 = 0; i11 < 8; i11++) {
                    iArr2[i11] = u(1, bArr);
                }
            }
        }
        Ue(bArr, i10);
        int Ue = Ue(bArr, i10);
        if (Ue == 0) {
            Ue(bArr, i10);
        } else if (Ue == 1) {
            u(1, bArr);
            Se(bArr, i10);
            Se(bArr, i10);
            int Ue2 = Ue(bArr, i10);
            int[] iArr3 = new int[Ue2];
            for (int i12 = 0; i12 < Ue2; i12++) {
                iArr3[i12] = Se(bArr, i10);
            }
        }
        Ue(bArr, i10);
        u(1, bArr);
        int Ue3 = Ue(bArr, i10);
        int Ue4 = Ue(bArr, i10);
        iArr[0] = (Ue3 + 1) * 16;
        iArr[1] = (Ue4 + 1) * 16;
        return true;
    }

    private static int u(int i10, byte[] bArr) {
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 <<= 1;
            int i13 = nStartBit;
            if ((bArr[i13 / 8] & (128 >> (i13 % 8))) != 0) {
                i11++;
            }
            nStartBit = i13 + 1;
        }
        return i11;
    }
}
