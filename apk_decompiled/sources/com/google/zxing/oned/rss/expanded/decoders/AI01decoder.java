package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

/* loaded from: classes2.dex */
abstract class AI01decoder extends AbstractExpandedDecoder {
    static final int GTIN_SIZE = 40;

    public AI01decoder(BitArray bitArray) {
        super(bitArray);
    }

    private static void appendCheckDigit(StringBuilder sb, int i10) {
        int i11 = 0;
        for (int i12 = 0; i12 < 13; i12++) {
            int charAt = sb.charAt(i12 + i10) - '0';
            if ((i12 & 1) == 0) {
                charAt *= 3;
            }
            i11 += charAt;
        }
        int i13 = 10 - (i11 % 10);
        sb.append(i13 != 10 ? i13 : 0);
    }

    public final void encodeCompressedGtin(StringBuilder sb, int i10) {
        sb.append("(01)");
        int length = sb.length();
        sb.append('9');
        encodeCompressedGtinWithoutAI(sb, i10, length);
    }

    public final void encodeCompressedGtinWithoutAI(StringBuilder sb, int i10, int i11) {
        for (int i12 = 0; i12 < 4; i12++) {
            int extractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray((i12 * 10) + i10, 10);
            if (extractNumericValueFromBitArray / 100 == 0) {
                sb.append('0');
            }
            if (extractNumericValueFromBitArray / 10 == 0) {
                sb.append('0');
            }
            sb.append(extractNumericValueFromBitArray);
        }
        appendCheckDigit(sb, i11);
    }
}
