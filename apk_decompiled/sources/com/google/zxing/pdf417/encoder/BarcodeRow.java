package com.google.zxing.pdf417.encoder;

/* loaded from: classes2.dex */
final class BarcodeRow {
    private int currentLocation = 0;
    private final byte[] row;

    public BarcodeRow(int i10) {
        this.row = new byte[i10];
    }

    public void addBar(boolean z10, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = this.currentLocation;
            this.currentLocation = i12 + 1;
            set(i12, z10);
        }
    }

    public byte[] getScaledRow(int i10) {
        int length = this.row.length * i10;
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            bArr[i11] = this.row[i11 / i10];
        }
        return bArr;
    }

    public void set(int i10, byte b10) {
        this.row[i10] = b10;
    }

    private void set(int i10, boolean z10) {
        this.row[i10] = z10 ? (byte) 1 : (byte) 0;
    }
}
