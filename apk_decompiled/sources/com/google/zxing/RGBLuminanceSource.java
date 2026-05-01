package com.google.zxing;

import com.hpplay.cybergarage.http.HTTPStatus;

/* loaded from: classes2.dex */
public final class RGBLuminanceSource extends LuminanceSource {
    private final int dataHeight;
    private final int dataWidth;
    private final int left;
    private final byte[] luminances;
    private final int top;

    public RGBLuminanceSource(int i10, int i11, int[] iArr) {
        super(i10, i11);
        this.dataWidth = i10;
        this.dataHeight = i11;
        this.left = 0;
        this.top = 0;
        int i12 = i10 * i11;
        this.luminances = new byte[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = iArr[i13];
            this.luminances[i13] = (byte) (((((i14 >> 16) & 255) + ((i14 >> 7) & HTTPStatus.INTERNAL_SERVER_ERROR)) + (i14 & 255)) / 4);
        }
    }

    @Override // com.google.zxing.LuminanceSource
    public LuminanceSource crop(int i10, int i11, int i12, int i13) {
        return new RGBLuminanceSource(this.luminances, this.dataWidth, this.dataHeight, this.left + i10, this.top + i11, i12, i13);
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getMatrix() {
        int width = getWidth();
        int height = getHeight();
        int i10 = this.dataWidth;
        if (width == i10 && height == this.dataHeight) {
            return this.luminances;
        }
        int i11 = width * height;
        byte[] bArr = new byte[i11];
        int i12 = (this.top * i10) + this.left;
        if (width == i10) {
            System.arraycopy(this.luminances, i12, bArr, 0, i11);
            return bArr;
        }
        for (int i13 = 0; i13 < height; i13++) {
            System.arraycopy(this.luminances, i12, bArr, i13 * width, width);
            i12 += this.dataWidth;
        }
        return bArr;
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getRow(int i10, byte[] bArr) {
        if (i10 < 0 || i10 >= getHeight()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i10);
        }
        int width = getWidth();
        if (bArr == null || bArr.length < width) {
            bArr = new byte[width];
        }
        System.arraycopy(this.luminances, ((i10 + this.top) * this.dataWidth) + this.left, bArr, 0, width);
        return bArr;
    }

    @Override // com.google.zxing.LuminanceSource
    public boolean isCropSupported() {
        return true;
    }

    private RGBLuminanceSource(byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15) {
        super(i14, i15);
        if (i14 + i12 <= i10 && i15 + i13 <= i11) {
            this.luminances = bArr;
            this.dataWidth = i10;
            this.dataHeight = i11;
            this.left = i12;
            this.top = i13;
            return;
        }
        throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
    }
}
