package com.google.zxing.pdf417.decoder.ec;

import com.google.zxing.pdf417.PDF417Common;

/* loaded from: classes2.dex */
public final class ModulusGF {
    public static final ModulusGF PDF417_GF = new ModulusGF(PDF417Common.NUMBER_OF_CODEWORDS, 3);
    private final int[] expTable;
    private final int[] logTable;
    private final int modulus;
    private final ModulusPoly one;
    private final ModulusPoly zero;

    private ModulusGF(int i10, int i11) {
        this.modulus = i10;
        this.expTable = new int[i10];
        this.logTable = new int[i10];
        int i12 = 1;
        for (int i13 = 0; i13 < i10; i13++) {
            this.expTable[i13] = i12;
            i12 = (i12 * i11) % i10;
        }
        for (int i14 = 0; i14 < i10 - 1; i14++) {
            this.logTable[this.expTable[i14]] = i14;
        }
        this.zero = new ModulusPoly(this, new int[]{0});
        this.one = new ModulusPoly(this, new int[]{1});
    }

    public int add(int i10, int i11) {
        return (i10 + i11) % this.modulus;
    }

    public ModulusPoly buildMonomial(int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException();
        }
        if (i11 == 0) {
            return this.zero;
        }
        int[] iArr = new int[i10 + 1];
        iArr[0] = i11;
        return new ModulusPoly(this, iArr);
    }

    public int exp(int i10) {
        return this.expTable[i10];
    }

    public ModulusPoly getOne() {
        return this.one;
    }

    public int getSize() {
        return this.modulus;
    }

    public ModulusPoly getZero() {
        return this.zero;
    }

    public int inverse(int i10) {
        if (i10 != 0) {
            return this.expTable[(this.modulus - this.logTable[i10]) - 1];
        }
        throw new ArithmeticException();
    }

    public int log(int i10) {
        if (i10 != 0) {
            return this.logTable[i10];
        }
        throw new IllegalArgumentException();
    }

    public int multiply(int i10, int i11) {
        if (i10 == 0 || i11 == 0) {
            return 0;
        }
        int[] iArr = this.expTable;
        int[] iArr2 = this.logTable;
        return iArr[(iArr2[i10] + iArr2[i11]) % (this.modulus - 1)];
    }

    public int subtract(int i10, int i11) {
        int i12 = this.modulus;
        return ((i10 + i12) - i11) % i12;
    }
}
