package com.google.zxing.datamatrix.encoder;

import java.util.Arrays;

/* loaded from: classes2.dex */
public class DefaultPlacement {
    private final byte[] bits;
    private final CharSequence codewords;
    private final int numcols;
    private final int numrows;

    public DefaultPlacement(CharSequence charSequence, int i10, int i11) {
        this.codewords = charSequence;
        this.numcols = i10;
        this.numrows = i11;
        byte[] bArr = new byte[i10 * i11];
        this.bits = bArr;
        Arrays.fill(bArr, (byte) -1);
    }

    private void corner1(int i10) {
        module(this.numrows - 1, 0, i10, 1);
        module(this.numrows - 1, 1, i10, 2);
        module(this.numrows - 1, 2, i10, 3);
        module(0, this.numcols - 2, i10, 4);
        module(0, this.numcols - 1, i10, 5);
        module(1, this.numcols - 1, i10, 6);
        module(2, this.numcols - 1, i10, 7);
        module(3, this.numcols - 1, i10, 8);
    }

    private void corner2(int i10) {
        module(this.numrows - 3, 0, i10, 1);
        module(this.numrows - 2, 0, i10, 2);
        module(this.numrows - 1, 0, i10, 3);
        module(0, this.numcols - 4, i10, 4);
        module(0, this.numcols - 3, i10, 5);
        module(0, this.numcols - 2, i10, 6);
        module(0, this.numcols - 1, i10, 7);
        module(1, this.numcols - 1, i10, 8);
    }

    private void corner3(int i10) {
        module(this.numrows - 3, 0, i10, 1);
        module(this.numrows - 2, 0, i10, 2);
        module(this.numrows - 1, 0, i10, 3);
        module(0, this.numcols - 2, i10, 4);
        module(0, this.numcols - 1, i10, 5);
        module(1, this.numcols - 1, i10, 6);
        module(2, this.numcols - 1, i10, 7);
        module(3, this.numcols - 1, i10, 8);
    }

    private void corner4(int i10) {
        module(this.numrows - 1, 0, i10, 1);
        module(this.numrows - 1, this.numcols - 1, i10, 2);
        module(0, this.numcols - 3, i10, 3);
        module(0, this.numcols - 2, i10, 4);
        module(0, this.numcols - 1, i10, 5);
        module(1, this.numcols - 3, i10, 6);
        module(1, this.numcols - 2, i10, 7);
        module(1, this.numcols - 1, i10, 8);
    }

    private boolean hasBit(int i10, int i11) {
        return this.bits[(i11 * this.numcols) + i10] >= 0;
    }

    private void module(int i10, int i11, int i12, int i13) {
        if (i10 < 0) {
            int i14 = this.numrows;
            i10 += i14;
            i11 += 4 - ((i14 + 4) % 8);
        }
        if (i11 < 0) {
            int i15 = this.numcols;
            i11 += i15;
            i10 += 4 - ((i15 + 4) % 8);
        }
        setBit(i11, i10, (this.codewords.charAt(i12) & (1 << (8 - i13))) != 0);
    }

    private void setBit(int i10, int i11, boolean z10) {
        this.bits[(i11 * this.numcols) + i10] = z10 ? (byte) 1 : (byte) 0;
    }

    private void utah(int i10, int i11, int i12) {
        int i13 = i10 - 2;
        int i14 = i11 - 2;
        module(i13, i14, i12, 1);
        int i15 = i11 - 1;
        module(i13, i15, i12, 2);
        int i16 = i10 - 1;
        module(i16, i14, i12, 3);
        module(i16, i15, i12, 4);
        module(i16, i11, i12, 5);
        module(i10, i14, i12, 6);
        module(i10, i15, i12, 7);
        module(i10, i11, i12, 8);
    }

    public final boolean getBit(int i10, int i11) {
        return this.bits[(i11 * this.numcols) + i10] == 1;
    }

    public final byte[] getBits() {
        return this.bits;
    }

    public final int getNumcols() {
        return this.numcols;
    }

    public final int getNumrows() {
        return this.numrows;
    }

    public final void place() {
        int i10;
        int i11;
        int i12 = 0;
        int i13 = 0;
        int i14 = 4;
        while (true) {
            if (i14 == this.numrows && i12 == 0) {
                corner1(i13);
                i13++;
            }
            if (i14 == this.numrows - 2 && i12 == 0 && this.numcols % 4 != 0) {
                corner2(i13);
                i13++;
            }
            if (i14 == this.numrows - 2 && i12 == 0 && this.numcols % 8 == 4) {
                corner3(i13);
                i13++;
            }
            if (i14 == this.numrows + 4 && i12 == 2 && this.numcols % 8 == 0) {
                corner4(i13);
                i13++;
            }
            do {
                if (i14 < this.numrows && i12 >= 0 && !hasBit(i12, i14)) {
                    utah(i14, i12, i13);
                    i13++;
                }
                i14 -= 2;
                i12 += 2;
                if (i14 < 0) {
                    break;
                }
            } while (i12 < this.numcols);
            int i15 = i14 + 1;
            int i16 = i12 + 3;
            do {
                if (i15 >= 0 && i16 < this.numcols && !hasBit(i16, i15)) {
                    utah(i15, i16, i13);
                    i13++;
                }
                i15 += 2;
                i16 -= 2;
                i10 = this.numrows;
                if (i15 >= i10) {
                    break;
                }
            } while (i16 >= 0);
            i14 = i15 + 3;
            i12 = i16 + 1;
            if (i14 >= i10 && i12 >= (i11 = this.numcols)) {
                break;
            }
        }
        if (hasBit(i11 - 1, i10 - 1)) {
            return;
        }
        setBit(this.numcols - 1, this.numrows - 1, true);
        setBit(this.numcols - 2, this.numrows - 2, true);
    }
}
