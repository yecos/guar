package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
final class Hashing {
    private static final long C1 = -862048943;
    private static final long C2 = 461845907;
    private static final int MAX_TABLE_SIZE = 1073741824;

    private Hashing() {
    }

    public static int closedTableSize(int i10, double d10) {
        int max = Math.max(i10, 2);
        int highestOneBit = Integer.highestOneBit(max);
        double d11 = highestOneBit;
        Double.isNaN(d11);
        if (max <= ((int) (d10 * d11))) {
            return highestOneBit;
        }
        int i11 = highestOneBit << 1;
        if (i11 > 0) {
            return i11;
        }
        return 1073741824;
    }

    public static boolean needsResizing(int i10, int i11, double d10) {
        double d11 = i10;
        double d12 = i11;
        Double.isNaN(d12);
        return d11 > d10 * d12 && i11 < 1073741824;
    }

    public static int smear(int i10) {
        return (int) (Integer.rotateLeft((int) (i10 * C1), 15) * C2);
    }

    public static int smearedHash(@CheckForNull Object obj) {
        return smear(obj == null ? 0 : obj.hashCode());
    }
}
