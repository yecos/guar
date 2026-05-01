package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

/* loaded from: classes2.dex */
public final class EAN13Reader extends UPCEANReader {
    static final int[] FIRST_DIGIT_ENCODINGS = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};
    private final int[] decodeMiddleCounters = new int[4];

    private static void determineFirstDigit(StringBuilder sb, int i10) {
        for (int i11 = 0; i11 < 10; i11++) {
            if (i10 == FIRST_DIGIT_ENCODINGS[i11]) {
                sb.insert(0, (char) (i11 + 48));
                return;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.oned.UPCEANReader
    public int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb) {
        int[] iArr2 = this.decodeMiddleCounters;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int size = bitArray.getSize();
        int i10 = iArr[1];
        int i11 = 0;
        for (int i12 = 0; i12 < 6 && i10 < size; i12++) {
            int decodeDigit = UPCEANReader.decodeDigit(bitArray, iArr2, i10, UPCEANReader.L_AND_G_PATTERNS);
            sb.append((char) ((decodeDigit % 10) + 48));
            for (int i13 : iArr2) {
                i10 += i13;
            }
            if (decodeDigit >= 10) {
                i11 |= 1 << (5 - i12);
            }
        }
        determineFirstDigit(sb, i11);
        int i14 = UPCEANReader.findGuardPattern(bitArray, i10, true, UPCEANReader.MIDDLE_PATTERN)[1];
        for (int i15 = 0; i15 < 6 && i14 < size; i15++) {
            sb.append((char) (UPCEANReader.decodeDigit(bitArray, iArr2, i14, UPCEANReader.L_PATTERNS) + 48));
            for (int i16 : iArr2) {
                i14 += i16;
            }
        }
        return i14;
    }

    @Override // com.google.zxing.oned.UPCEANReader
    public BarcodeFormat getBarcodeFormat() {
        return BarcodeFormat.EAN_13;
    }
}
