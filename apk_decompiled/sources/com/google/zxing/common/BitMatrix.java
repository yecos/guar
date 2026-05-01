package com.google.zxing.common;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class BitMatrix implements Cloneable {
    private final int[] bits;
    private final int height;
    private final int rowSize;
    private final int width;

    public BitMatrix(int i10) {
        this(i10, i10);
    }

    private String buildToString(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.height * (this.width + 1));
        for (int i10 = 0; i10 < this.height; i10++) {
            for (int i11 = 0; i11 < this.width; i11++) {
                sb.append(get(i11, i10) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    public static BitMatrix parse(String str, String str2, String str3) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        boolean[] zArr = new boolean[str.length()];
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = -1;
        int i14 = 0;
        while (i10 < str.length()) {
            if (str.charAt(i10) == '\n' || str.charAt(i10) == '\r') {
                if (i11 > i12) {
                    if (i13 == -1) {
                        i13 = i11 - i12;
                    } else if (i11 - i12 != i13) {
                        throw new IllegalArgumentException("row lengths do not match");
                    }
                    i14++;
                    i12 = i11;
                }
                i10++;
            } else {
                if (str.substring(i10, str2.length() + i10).equals(str2)) {
                    i10 += str2.length();
                    zArr[i11] = true;
                } else {
                    if (!str.substring(i10, str3.length() + i10).equals(str3)) {
                        throw new IllegalArgumentException("illegal character encountered: " + str.substring(i10));
                    }
                    i10 += str3.length();
                    zArr[i11] = false;
                }
                i11++;
            }
        }
        if (i11 > i12) {
            if (i13 == -1) {
                i13 = i11 - i12;
            } else if (i11 - i12 != i13) {
                throw new IllegalArgumentException("row lengths do not match");
            }
            i14++;
        }
        BitMatrix bitMatrix = new BitMatrix(i13, i14);
        for (int i15 = 0; i15 < i11; i15++) {
            if (zArr[i15]) {
                bitMatrix.set(i15 % i13, i15 / i13);
            }
        }
        return bitMatrix;
    }

    public void clear() {
        int length = this.bits.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.bits[i10] = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitMatrix)) {
            return false;
        }
        BitMatrix bitMatrix = (BitMatrix) obj;
        return this.width == bitMatrix.width && this.height == bitMatrix.height && this.rowSize == bitMatrix.rowSize && Arrays.equals(this.bits, bitMatrix.bits);
    }

    public void flip(int i10, int i11) {
        int i12 = (i11 * this.rowSize) + (i10 / 32);
        int[] iArr = this.bits;
        iArr[i12] = (1 << (i10 & 31)) ^ iArr[i12];
    }

    public boolean get(int i10, int i11) {
        return ((this.bits[(i11 * this.rowSize) + (i10 / 32)] >>> (i10 & 31)) & 1) != 0;
    }

    public int[] getBottomRightOnBit() {
        int length = this.bits.length - 1;
        while (length >= 0 && this.bits[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i10 = this.rowSize;
        int i11 = length / i10;
        int i12 = (length % i10) << 5;
        int i13 = 31;
        while ((this.bits[length] >>> i13) == 0) {
            i13--;
        }
        return new int[]{i12 + i13, i11};
    }

    public int[] getEnclosingRectangle() {
        int i10 = this.width;
        int i11 = this.height;
        int i12 = -1;
        int i13 = -1;
        for (int i14 = 0; i14 < this.height; i14++) {
            int i15 = 0;
            while (true) {
                int i16 = this.rowSize;
                if (i15 < i16) {
                    int i17 = this.bits[(i16 * i14) + i15];
                    if (i17 != 0) {
                        if (i14 < i11) {
                            i11 = i14;
                        }
                        if (i14 > i13) {
                            i13 = i14;
                        }
                        int i18 = i15 << 5;
                        if (i18 < i10) {
                            int i19 = 0;
                            while ((i17 << (31 - i19)) == 0) {
                                i19++;
                            }
                            int i20 = i19 + i18;
                            if (i20 < i10) {
                                i10 = i20;
                            }
                        }
                        if (i18 + 31 > i12) {
                            int i21 = 31;
                            while ((i17 >>> i21) == 0) {
                                i21--;
                            }
                            int i22 = i18 + i21;
                            if (i22 > i12) {
                                i12 = i22;
                            }
                        }
                    }
                    i15++;
                }
            }
        }
        if (i12 < i10 || i13 < i11) {
            return null;
        }
        return new int[]{i10, i11, (i12 - i10) + 1, (i13 - i11) + 1};
    }

    public int getHeight() {
        return this.height;
    }

    public BitArray getRow(int i10, BitArray bitArray) {
        if (bitArray == null || bitArray.getSize() < this.width) {
            bitArray = new BitArray(this.width);
        } else {
            bitArray.clear();
        }
        int i11 = i10 * this.rowSize;
        for (int i12 = 0; i12 < this.rowSize; i12++) {
            bitArray.setBulk(i12 << 5, this.bits[i11 + i12]);
        }
        return bitArray;
    }

    public int getRowSize() {
        return this.rowSize;
    }

    public int[] getTopLeftOnBit() {
        int[] iArr;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            iArr = this.bits;
            if (i11 >= iArr.length || iArr[i11] != 0) {
                break;
            }
            i11++;
        }
        if (i11 == iArr.length) {
            return null;
        }
        int i12 = this.rowSize;
        int i13 = i11 / i12;
        int i14 = (i11 % i12) << 5;
        while ((iArr[i11] << (31 - i10)) == 0) {
            i10++;
        }
        return new int[]{i14 + i10, i13};
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int i10 = this.width;
        return (((((((i10 * 31) + i10) * 31) + this.height) * 31) + this.rowSize) * 31) + Arrays.hashCode(this.bits);
    }

    public void rotate180() {
        int width = getWidth();
        int height = getHeight();
        BitArray bitArray = new BitArray(width);
        BitArray bitArray2 = new BitArray(width);
        for (int i10 = 0; i10 < (height + 1) / 2; i10++) {
            bitArray = getRow(i10, bitArray);
            int i11 = (height - 1) - i10;
            bitArray2 = getRow(i11, bitArray2);
            bitArray.reverse();
            bitArray2.reverse();
            setRow(i10, bitArray2);
            setRow(i11, bitArray);
        }
    }

    public void set(int i10, int i11) {
        int i12 = (i11 * this.rowSize) + (i10 / 32);
        int[] iArr = this.bits;
        iArr[i12] = (1 << (i10 & 31)) | iArr[i12];
    }

    public void setRegion(int i10, int i11, int i12, int i13) {
        if (i11 < 0 || i10 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i13 <= 0 || i12 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i14 = i12 + i10;
        int i15 = i13 + i11;
        if (i15 > this.height || i14 > this.width) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i11 < i15) {
            int i16 = this.rowSize * i11;
            for (int i17 = i10; i17 < i14; i17++) {
                int[] iArr = this.bits;
                int i18 = (i17 / 32) + i16;
                iArr[i18] = iArr[i18] | (1 << (i17 & 31));
            }
            i11++;
        }
    }

    public void setRow(int i10, BitArray bitArray) {
        int[] bitArray2 = bitArray.getBitArray();
        int[] iArr = this.bits;
        int i11 = this.rowSize;
        System.arraycopy(bitArray2, 0, iArr, i10 * i11, i11);
    }

    public String toString() {
        return toString("X ", "  ");
    }

    public void unset(int i10, int i11) {
        int i12 = (i11 * this.rowSize) + (i10 / 32);
        int[] iArr = this.bits;
        iArr[i12] = ((1 << (i10 & 31)) ^ (-1)) & iArr[i12];
    }

    public void xor(BitMatrix bitMatrix) {
        if (this.width != bitMatrix.getWidth() || this.height != bitMatrix.getHeight() || this.rowSize != bitMatrix.getRowSize()) {
            throw new IllegalArgumentException("input matrix dimensions do not match");
        }
        BitArray bitArray = new BitArray((this.width / 32) + 1);
        for (int i10 = 0; i10 < this.height; i10++) {
            int i11 = this.rowSize * i10;
            int[] bitArray2 = bitMatrix.getRow(i10, bitArray).getBitArray();
            for (int i12 = 0; i12 < this.rowSize; i12++) {
                int[] iArr = this.bits;
                int i13 = i11 + i12;
                iArr[i13] = iArr[i13] ^ bitArray2[i12];
            }
        }
    }

    public BitMatrix(int i10, int i11) {
        if (i10 <= 0 || i11 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.width = i10;
        this.height = i11;
        int i12 = (i10 + 31) / 32;
        this.rowSize = i12;
        this.bits = new int[i12 * i11];
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BitMatrix m34clone() {
        return new BitMatrix(this.width, this.height, this.rowSize, (int[]) this.bits.clone());
    }

    public String toString(String str, String str2) {
        return buildToString(str, str2, "\n");
    }

    @Deprecated
    public String toString(String str, String str2, String str3) {
        return buildToString(str, str2, str3);
    }

    private BitMatrix(int i10, int i11, int i12, int[] iArr) {
        this.width = i10;
        this.height = i11;
        this.rowSize = i12;
        this.bits = iArr;
    }
}
