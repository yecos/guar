package e7;

import android.graphics.Bitmap;
import com.google.zxing.LuminanceSource;

/* loaded from: classes3.dex */
public final class h extends LuminanceSource {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f12957a;

    public h(Bitmap bitmap) {
        super(bitmap.getWidth(), bitmap.getHeight());
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i10 = width * height;
        int[] iArr = new int[i10];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        this.f12957a = new byte[i10];
        for (int i11 = 0; i11 < height; i11++) {
            int i12 = i11 * width;
            for (int i13 = 0; i13 < width; i13++) {
                int i14 = i12 + i13;
                int i15 = iArr[i14];
                int i16 = (i15 >> 16) & 255;
                int i17 = (i15 >> 8) & 255;
                int i18 = i15 & 255;
                if (i16 == i17 && i17 == i18) {
                    this.f12957a[i14] = (byte) i16;
                } else {
                    this.f12957a[i14] = (byte) ((((i16 + i17) + i17) + i18) >> 2);
                }
            }
        }
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getMatrix() {
        return this.f12957a;
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
        System.arraycopy(this.f12957a, i10 * width, bArr, 0, width);
        return bArr;
    }
}
