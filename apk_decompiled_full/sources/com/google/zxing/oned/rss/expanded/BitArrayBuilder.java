package com.google.zxing.oned.rss.expanded;

import com.google.zxing.common.BitArray;
import java.util.List;

/* loaded from: classes2.dex */
final class BitArrayBuilder {
    private BitArrayBuilder() {
    }

    public static BitArray buildBitArray(List<ExpandedPair> list) {
        int size = (list.size() << 1) - 1;
        if (list.get(list.size() - 1).getRightChar() == null) {
            size--;
        }
        BitArray bitArray = new BitArray(size * 12);
        int i10 = 0;
        int value = list.get(0).getRightChar().getValue();
        for (int i11 = 11; i11 >= 0; i11--) {
            if (((1 << i11) & value) != 0) {
                bitArray.set(i10);
            }
            i10++;
        }
        for (int i12 = 1; i12 < list.size(); i12++) {
            ExpandedPair expandedPair = list.get(i12);
            int value2 = expandedPair.getLeftChar().getValue();
            for (int i13 = 11; i13 >= 0; i13--) {
                if (((1 << i13) & value2) != 0) {
                    bitArray.set(i10);
                }
                i10++;
            }
            if (expandedPair.getRightChar() != null) {
                int value3 = expandedPair.getRightChar().getValue();
                for (int i14 = 11; i14 >= 0; i14--) {
                    if (((1 << i14) & value3) != 0) {
                        bitArray.set(i10);
                    }
                    i10++;
                }
            }
        }
        return bitArray;
    }
}
