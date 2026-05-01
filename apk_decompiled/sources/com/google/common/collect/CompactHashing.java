package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.primitives.UnsignedBytes;
import java.util.Arrays;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
final class CompactHashing {
    private static final int BYTE_MASK = 255;
    private static final int BYTE_MAX_SIZE = 256;
    static final int DEFAULT_SIZE = 3;
    static final int HASH_TABLE_BITS_MASK = 31;
    private static final int HASH_TABLE_BITS_MAX_BITS = 5;
    static final int MAX_SIZE = 1073741823;
    private static final int MIN_HASH_TABLE_SIZE = 4;
    static final int MODIFICATION_COUNT_INCREMENT = 32;
    private static final int SHORT_MASK = 65535;
    private static final int SHORT_MAX_SIZE = 65536;
    static final byte UNSET = 0;

    private CompactHashing() {
    }

    public static Object createTable(int i10) {
        if (i10 >= 2 && i10 <= 1073741824 && Integer.highestOneBit(i10) == i10) {
            return i10 <= 256 ? new byte[i10] : i10 <= 65536 ? new short[i10] : new int[i10];
        }
        StringBuilder sb = new StringBuilder(52);
        sb.append("must be power of 2 between 2^1 and 2^30: ");
        sb.append(i10);
        throw new IllegalArgumentException(sb.toString());
    }

    public static int getHashPrefix(int i10, int i11) {
        return i10 & (i11 ^ (-1));
    }

    public static int getNext(int i10, int i11) {
        return i10 & i11;
    }

    public static int maskCombine(int i10, int i11, int i12) {
        return (i10 & (i12 ^ (-1))) | (i11 & i12);
    }

    public static int newCapacity(int i10) {
        return (i10 < 32 ? 4 : 2) * (i10 + 1);
    }

    public static int remove(@CheckForNull Object obj, @CheckForNull Object obj2, int i10, Object obj3, int[] iArr, Object[] objArr, @CheckForNull Object[] objArr2) {
        int i11;
        int i12;
        int smearedHash = Hashing.smearedHash(obj);
        int i13 = smearedHash & i10;
        int tableGet = tableGet(obj3, i13);
        if (tableGet == 0) {
            return -1;
        }
        int hashPrefix = getHashPrefix(smearedHash, i10);
        int i14 = -1;
        while (true) {
            i11 = tableGet - 1;
            i12 = iArr[i11];
            if (getHashPrefix(i12, i10) != hashPrefix || !Objects.equal(obj, objArr[i11]) || (objArr2 != null && !Objects.equal(obj2, objArr2[i11]))) {
                int next = getNext(i12, i10);
                if (next == 0) {
                    return -1;
                }
                i14 = i11;
                tableGet = next;
            }
        }
        int next2 = getNext(i12, i10);
        if (i14 == -1) {
            tableSet(obj3, i13, next2);
        } else {
            iArr[i14] = maskCombine(iArr[i14], next2, i10);
        }
        return i11;
    }

    public static void tableClear(Object obj) {
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
    }

    public static int tableGet(Object obj, int i10) {
        return obj instanceof byte[] ? ((byte[]) obj)[i10] & UnsignedBytes.MAX_VALUE : obj instanceof short[] ? ((short[]) obj)[i10] & 65535 : ((int[]) obj)[i10];
    }

    public static void tableSet(Object obj, int i10, int i11) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i10] = (byte) i11;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i10] = (short) i11;
        } else {
            ((int[]) obj)[i10] = i11;
        }
    }

    public static int tableSize(int i10) {
        return Math.max(4, Hashing.closedTableSize(i10 + 1, 1.0d));
    }
}
