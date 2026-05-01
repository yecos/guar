package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.CharMatcher;
import java.util.BitSet;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
final class SmallCharMatcher extends CharMatcher.NamedFastMatcher {
    private static final int C1 = -862048943;
    private static final int C2 = 461845907;
    private static final double DESIRED_LOAD_FACTOR = 0.5d;
    static final int MAX_SIZE = 1023;
    private final boolean containsZero;
    private final long filter;
    private final char[] table;

    private SmallCharMatcher(char[] cArr, long j10, boolean z10, String str) {
        super(str);
        this.table = cArr;
        this.filter = j10;
        this.containsZero = z10;
    }

    private boolean checkFilter(int i10) {
        return 1 == ((this.filter >> i10) & 1);
    }

    @VisibleForTesting
    public static int chooseTableSize(int i10) {
        if (i10 == 1) {
            return 2;
        }
        int highestOneBit = Integer.highestOneBit(i10 - 1) << 1;
        while (true) {
            double d10 = highestOneBit;
            Double.isNaN(d10);
            if (d10 * 0.5d >= i10) {
                return highestOneBit;
            }
            highestOneBit <<= 1;
        }
    }

    public static CharMatcher from(BitSet bitSet, String str) {
        int i10;
        int cardinality = bitSet.cardinality();
        boolean z10 = bitSet.get(0);
        int chooseTableSize = chooseTableSize(cardinality);
        char[] cArr = new char[chooseTableSize];
        int i11 = chooseTableSize - 1;
        int nextSetBit = bitSet.nextSetBit(0);
        long j10 = 0;
        while (nextSetBit != -1) {
            long j11 = (1 << nextSetBit) | j10;
            int smear = smear(nextSetBit);
            while (true) {
                i10 = smear & i11;
                if (cArr[i10] == 0) {
                    break;
                }
                smear = i10 + 1;
            }
            cArr[i10] = (char) nextSetBit;
            nextSetBit = bitSet.nextSetBit(nextSetBit + 1);
            j10 = j11;
        }
        return new SmallCharMatcher(cArr, j10, z10, str);
    }

    public static int smear(int i10) {
        return Integer.rotateLeft(i10 * C1, 15) * C2;
    }

    @Override // com.google.common.base.CharMatcher
    public boolean matches(char c10) {
        if (c10 == 0) {
            return this.containsZero;
        }
        if (!checkFilter(c10)) {
            return false;
        }
        int length = this.table.length - 1;
        int smear = smear(c10) & length;
        int i10 = smear;
        do {
            char c11 = this.table[i10];
            if (c11 == 0) {
                return false;
            }
            if (c11 == c10) {
                return true;
            }
            i10 = (i10 + 1) & length;
        } while (i10 != smear);
        return false;
    }

    @Override // com.google.common.base.CharMatcher
    public void setBits(BitSet bitSet) {
        if (this.containsZero) {
            bitSet.set(0);
        }
        for (char c10 : this.table) {
            if (c10 != 0) {
                bitSet.set(c10);
            }
        }
    }
}
