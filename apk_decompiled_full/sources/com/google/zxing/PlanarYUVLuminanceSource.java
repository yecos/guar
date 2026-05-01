package com.google.zxing;

import com.google.common.primitives.UnsignedBytes;
import com.mobile.brasiltv.view.RoundedDrawable;

/* loaded from: classes2.dex */
public final class PlanarYUVLuminanceSource extends LuminanceSource {
    private static final int THUMBNAIL_SCALE_FACTOR = 2;
    private final int dataHeight;
    private final int dataWidth;
    private final int left;
    private final int top;
    private final byte[] yuvData;

    public PlanarYUVLuminanceSource(byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15, boolean z10) {
        super(i14, i15);
        if (i12 + i14 > i10 || i13 + i15 > i11) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.yuvData = bArr;
        this.dataWidth = i10;
        this.dataHeight = i11;
        this.left = i12;
        this.top = i13;
        if (z10) {
            reverseHorizontal(i14, i15);
        }
    }

    private void reverseHorizontal(int i10, int i11) {
        byte[] bArr = this.yuvData;
        int i12 = (this.top * this.dataWidth) + this.left;
        int i13 = 0;
        while (i13 < i11) {
            int i14 = (i10 / 2) + i12;
            int i15 = (i12 + i10) - 1;
            int i16 = i12;
            while (i16 < i14) {
                byte b10 = bArr[i16];
                bArr[i16] = bArr[i15];
                bArr[i15] = b10;
                i16++;
                i15--;
            }
            i13++;
            i12 += this.dataWidth;
        }
    }

    @Override // com.google.zxing.LuminanceSource
    public LuminanceSource crop(int i10, int i11, int i12, int i13) {
        return new PlanarYUVLuminanceSource(this.yuvData, this.dataWidth, this.dataHeight, this.left + i10, this.top + i11, i12, i13, false);
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getMatrix() {
        int width = getWidth();
        int height = getHeight();
        int i10 = this.dataWidth;
        if (width == i10 && height == this.dataHeight) {
            return this.yuvData;
        }
        int i11 = width * height;
        byte[] bArr = new byte[i11];
        int i12 = (this.top * i10) + this.left;
        if (width == i10) {
            System.arraycopy(this.yuvData, i12, bArr, 0, i11);
            return bArr;
        }
        for (int i13 = 0; i13 < height; i13++) {
            System.arraycopy(this.yuvData, i12, bArr, i13 * width, width);
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
        System.arraycopy(this.yuvData, ((i10 + this.top) * this.dataWidth) + this.left, bArr, 0, width);
        return bArr;
    }

    public int getThumbnailHeight() {
        return getHeight() / 2;
    }

    public int getThumbnailWidth() {
        return getWidth() / 2;
    }

    @Override // com.google.zxing.LuminanceSource
    public boolean isCropSupported() {
        return true;
    }

    public int[] renderThumbnail() {
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        int[] iArr = new int[width * height];
        byte[] bArr = this.yuvData;
        int i10 = (this.top * this.dataWidth) + this.left;
        for (int i11 = 0; i11 < height; i11++) {
            int i12 = i11 * width;
            for (int i13 = 0; i13 < width; i13++) {
                iArr[i12 + i13] = ((bArr[(i13 << 1) + i10] & UnsignedBytes.MAX_VALUE) * 65793) | RoundedDrawable.DEFAULT_BORDER_COLOR;
            }
            i10 += this.dataWidth << 1;
        }
        return iArr;
    }
}
