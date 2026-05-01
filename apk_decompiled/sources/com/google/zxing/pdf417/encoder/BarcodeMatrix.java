package com.google.zxing.pdf417.encoder;

import java.lang.reflect.Array;

/* loaded from: classes2.dex */
public final class BarcodeMatrix {
    private int currentRow;
    private final int height;
    private final BarcodeRow[] matrix;
    private final int width;

    public BarcodeMatrix(int i10, int i11) {
        BarcodeRow[] barcodeRowArr = new BarcodeRow[i10];
        this.matrix = barcodeRowArr;
        int length = barcodeRowArr.length;
        for (int i12 = 0; i12 < length; i12++) {
            this.matrix[i12] = new BarcodeRow(((i11 + 4) * 17) + 1);
        }
        this.width = i11 * 17;
        this.height = i10;
        this.currentRow = -1;
    }

    public BarcodeRow getCurrentRow() {
        return this.matrix[this.currentRow];
    }

    public byte[][] getMatrix() {
        return getScaledMatrix(1, 1);
    }

    public byte[][] getScaledMatrix(int i10, int i11) {
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, this.height * i11, this.width * i10);
        int i12 = this.height * i11;
        for (int i13 = 0; i13 < i12; i13++) {
            bArr[(i12 - i13) - 1] = this.matrix[i13 / i11].getScaledRow(i10);
        }
        return bArr;
    }

    public void set(int i10, int i11, byte b10) {
        this.matrix[i11].set(i10, b10);
    }

    public void startRow() {
        this.currentRow++;
    }
}
