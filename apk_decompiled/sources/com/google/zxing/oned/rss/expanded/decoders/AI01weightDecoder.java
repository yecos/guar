package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

/* loaded from: classes2.dex */
abstract class AI01weightDecoder extends AI01decoder {
    public AI01weightDecoder(BitArray bitArray) {
        super(bitArray);
    }

    public abstract void addWeightCode(StringBuilder sb, int i10);

    public abstract int checkWeight(int i10);

    public final void encodeCompressedWeight(StringBuilder sb, int i10, int i11) {
        int extractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray(i10, i11);
        addWeightCode(sb, extractNumericValueFromBitArray);
        int checkWeight = checkWeight(extractNumericValueFromBitArray);
        int i12 = 100000;
        for (int i13 = 0; i13 < 5; i13++) {
            if (checkWeight / i12 == 0) {
                sb.append('0');
            }
            i12 /= 10;
        }
        sb.append(checkWeight);
    }
}
