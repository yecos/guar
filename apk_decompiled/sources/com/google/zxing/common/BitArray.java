package com.google.zxing.common;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class BitArray implements Cloneable {
    private int[] bits;
    private int size;

    public BitArray() {
        this.size = 0;
        this.bits = new int[1];
    }

    private void ensureCapacity(int i10) {
        if (i10 > (this.bits.length << 5)) {
            int[] makeArray = makeArray(i10);
            int[] iArr = this.bits;
            System.arraycopy(iArr, 0, makeArray, 0, iArr.length);
            this.bits = makeArray;
        }
    }

    private static int[] makeArray(int i10) {
        return new int[(i10 + 31) / 32];
    }

    public void appendBit(boolean z10) {
        ensureCapacity(this.size + 1);
        if (z10) {
            int[] iArr = this.bits;
            int i10 = this.size;
            int i11 = i10 / 32;
            iArr[i11] = (1 << (i10 & 31)) | iArr[i11];
        }
        this.size++;
    }

    public void appendBitArray(BitArray bitArray) {
        int i10 = bitArray.size;
        ensureCapacity(this.size + i10);
        for (int i11 = 0; i11 < i10; i11++) {
            appendBit(bitArray.get(i11));
        }
    }

    public void appendBits(int i10, int i11) {
        if (i11 < 0 || i11 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        ensureCapacity(this.size + i11);
        while (i11 > 0) {
            boolean z10 = true;
            if (((i10 >> (i11 - 1)) & 1) != 1) {
                z10 = false;
            }
            appendBit(z10);
            i11--;
        }
    }

    public void clear() {
        int length = this.bits.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.bits[i10] = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitArray)) {
            return false;
        }
        BitArray bitArray = (BitArray) obj;
        return this.size == bitArray.size && Arrays.equals(this.bits, bitArray.bits);
    }

    public void flip(int i10) {
        int[] iArr = this.bits;
        int i11 = i10 / 32;
        iArr[i11] = (1 << (i10 & 31)) ^ iArr[i11];
    }

    public boolean get(int i10) {
        return ((1 << (i10 & 31)) & this.bits[i10 / 32]) != 0;
    }

    public int[] getBitArray() {
        return this.bits;
    }

    public int getNextSet(int i10) {
        int i11 = this.size;
        if (i10 >= i11) {
            return i11;
        }
        int i12 = i10 / 32;
        int i13 = (((1 << (i10 & 31)) - 1) ^ (-1)) & this.bits[i12];
        while (i13 == 0) {
            i12++;
            int[] iArr = this.bits;
            if (i12 == iArr.length) {
                return this.size;
            }
            i13 = iArr[i12];
        }
        int numberOfTrailingZeros = (i12 << 5) + Integer.numberOfTrailingZeros(i13);
        int i14 = this.size;
        return numberOfTrailingZeros > i14 ? i14 : numberOfTrailingZeros;
    }

    public int getNextUnset(int i10) {
        int i11 = this.size;
        if (i10 >= i11) {
            return i11;
        }
        int i12 = i10 / 32;
        int i13 = (((1 << (i10 & 31)) - 1) ^ (-1)) & (this.bits[i12] ^ (-1));
        while (i13 == 0) {
            i12++;
            int[] iArr = this.bits;
            if (i12 == iArr.length) {
                return this.size;
            }
            i13 = iArr[i12] ^ (-1);
        }
        int numberOfTrailingZeros = (i12 << 5) + Integer.numberOfTrailingZeros(i13);
        int i14 = this.size;
        return numberOfTrailingZeros > i14 ? i14 : numberOfTrailingZeros;
    }

    public int getSize() {
        return this.size;
    }

    public int getSizeInBytes() {
        return (this.size + 7) / 8;
    }

    public int hashCode() {
        return (this.size * 31) + Arrays.hashCode(this.bits);
    }

    public boolean isRange(int i10, int i11, boolean z10) {
        if (i11 < i10 || i10 < 0 || i11 > this.size) {
            throw new IllegalArgumentException();
        }
        if (i11 == i10) {
            return true;
        }
        int i12 = i11 - 1;
        int i13 = i10 / 32;
        int i14 = i12 / 32;
        int i15 = i13;
        while (i15 <= i14) {
            int i16 = (2 << (i15 >= i14 ? 31 & i12 : 31)) - (1 << (i15 > i13 ? 0 : i10 & 31));
            int i17 = this.bits[i15] & i16;
            if (!z10) {
                i16 = 0;
            }
            if (i17 != i16) {
                return false;
            }
            i15++;
        }
        return true;
    }

    public void reverse() {
        int[] iArr = new int[this.bits.length];
        int i10 = (this.size - 1) / 32;
        int i11 = i10 + 1;
        for (int i12 = 0; i12 < i11; i12++) {
            long j10 = this.bits[i12];
            long j11 = ((j10 & 1431655765) << 1) | ((j10 >> 1) & 1431655765);
            long j12 = ((j11 & 858993459) << 2) | ((j11 >> 2) & 858993459);
            long j13 = ((j12 & 252645135) << 4) | ((j12 >> 4) & 252645135);
            long j14 = ((j13 & 16711935) << 8) | ((j13 >> 8) & 16711935);
            iArr[i10 - i12] = (int) (((j14 & 65535) << 16) | ((j14 >> 16) & 65535));
        }
        int i13 = this.size;
        int i14 = i11 << 5;
        if (i13 != i14) {
            int i15 = i14 - i13;
            int i16 = iArr[0] >>> i15;
            for (int i17 = 1; i17 < i11; i17++) {
                int i18 = iArr[i17];
                iArr[i17 - 1] = i16 | (i18 << (32 - i15));
                i16 = i18 >>> i15;
            }
            iArr[i11 - 1] = i16;
        }
        this.bits = iArr;
    }

    public void set(int i10) {
        int[] iArr = this.bits;
        int i11 = i10 / 32;
        iArr[i11] = (1 << (i10 & 31)) | iArr[i11];
    }

    public void setBulk(int i10, int i11) {
        this.bits[i10 / 32] = i11;
    }

    public void setRange(int i10, int i11) {
        if (i11 < i10 || i10 < 0 || i11 > this.size) {
            throw new IllegalArgumentException();
        }
        if (i11 == i10) {
            return;
        }
        int i12 = i11 - 1;
        int i13 = i10 / 32;
        int i14 = i12 / 32;
        int i15 = i13;
        while (i15 <= i14) {
            int i16 = 31;
            int i17 = i15 > i13 ? 0 : i10 & 31;
            if (i15 >= i14) {
                i16 = 31 & i12;
            }
            int i18 = (2 << i16) - (1 << i17);
            int[] iArr = this.bits;
            iArr[i15] = i18 | iArr[i15];
            i15++;
        }
    }

    public void toBytes(int i10, byte[] bArr, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = 0;
            for (int i15 = 0; i15 < 8; i15++) {
                if (get(i10)) {
                    i14 |= 1 << (7 - i15);
                }
                i10++;
            }
            bArr[i11 + i13] = (byte) i14;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.size);
        for (int i10 = 0; i10 < this.size; i10++) {
            if ((i10 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(get(i10) ? 'X' : '.');
        }
        return sb.toString();
    }

    public void xor(BitArray bitArray) {
        if (this.size != bitArray.size) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i10 = 0;
        while (true) {
            int[] iArr = this.bits;
            if (i10 >= iArr.length) {
                return;
            }
            iArr[i10] = iArr[i10] ^ bitArray.bits[i10];
            i10++;
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BitArray m33clone() {
        return new BitArray((int[]) this.bits.clone(), this.size);
    }

    public BitArray(int i10) {
        this.size = i10;
        this.bits = makeArray(i10);
    }

    public BitArray(int[] iArr, int i10) {
        this.bits = iArr;
        this.size = i10;
    }
}
