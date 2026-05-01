package com.google.zxing.common;

import com.google.common.primitives.UnsignedBytes;
import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import java.lang.reflect.Array;

/* loaded from: classes2.dex */
public final class HybridBinarizer extends GlobalHistogramBinarizer {
    private static final int BLOCK_SIZE = 8;
    private static final int BLOCK_SIZE_MASK = 7;
    private static final int BLOCK_SIZE_POWER = 3;
    private static final int MINIMUM_DIMENSION = 40;
    private static final int MIN_DYNAMIC_RANGE = 24;
    private BitMatrix matrix;

    public HybridBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
    }

    private static int[][] calculateBlackPoints(byte[] bArr, int i10, int i11, int i12, int i13) {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i11, i10);
        for (int i14 = 0; i14 < i11; i14++) {
            int i15 = i14 << 3;
            int i16 = i13 - 8;
            if (i15 > i16) {
                i15 = i16;
            }
            for (int i17 = 0; i17 < i10; i17++) {
                int i18 = i17 << 3;
                int i19 = i12 - 8;
                if (i18 > i19) {
                    i18 = i19;
                }
                int i20 = (i15 * i12) + i18;
                int i21 = 0;
                int i22 = 0;
                int i23 = 0;
                int i24 = 255;
                while (i21 < 8) {
                    for (int i25 = 0; i25 < 8; i25++) {
                        int i26 = bArr[i20 + i25] & UnsignedBytes.MAX_VALUE;
                        i22 += i26;
                        if (i26 < i24) {
                            i24 = i26;
                        }
                        if (i26 > i23) {
                            i23 = i26;
                        }
                    }
                    if (i23 - i24 > 24) {
                        while (true) {
                            i21++;
                            i20 += i12;
                            if (i21 < 8) {
                                for (int i27 = 0; i27 < 8; i27++) {
                                    i22 += bArr[i20 + i27] & UnsignedBytes.MAX_VALUE;
                                }
                            }
                        }
                    }
                    i21++;
                    i20 += i12;
                }
                int i28 = i22 >> 6;
                if (i23 - i24 <= 24) {
                    i28 = i24 / 2;
                    if (i14 > 0 && i17 > 0) {
                        int[] iArr2 = iArr[i14 - 1];
                        int i29 = i17 - 1;
                        int i30 = ((iArr2[i17] + (iArr[i14][i29] * 2)) + iArr2[i29]) / 4;
                        if (i24 < i30) {
                            i28 = i30;
                        }
                    }
                }
                iArr[i14][i17] = i28;
            }
        }
        return iArr;
    }

    private static void calculateThresholdForBlock(byte[] bArr, int i10, int i11, int i12, int i13, int[][] iArr, BitMatrix bitMatrix) {
        for (int i14 = 0; i14 < i11; i14++) {
            int i15 = i14 << 3;
            int i16 = i13 - 8;
            if (i15 > i16) {
                i15 = i16;
            }
            for (int i17 = 0; i17 < i10; i17++) {
                int i18 = i17 << 3;
                int i19 = i12 - 8;
                if (i18 <= i19) {
                    i19 = i18;
                }
                int cap = cap(i17, 2, i10 - 3);
                int cap2 = cap(i14, 2, i11 - 3);
                int i20 = 0;
                for (int i21 = -2; i21 <= 2; i21++) {
                    int[] iArr2 = iArr[cap2 + i21];
                    i20 += iArr2[cap - 2] + iArr2[cap - 1] + iArr2[cap] + iArr2[cap + 1] + iArr2[cap + 2];
                }
                thresholdBlock(bArr, i19, i15, i20 / 25, i12, bitMatrix);
            }
        }
    }

    private static int cap(int i10, int i11, int i12) {
        return i10 < i11 ? i11 : i10 > i12 ? i12 : i10;
    }

    private static void thresholdBlock(byte[] bArr, int i10, int i11, int i12, int i13, BitMatrix bitMatrix) {
        int i14 = (i11 * i13) + i10;
        int i15 = 0;
        while (i15 < 8) {
            for (int i16 = 0; i16 < 8; i16++) {
                if ((bArr[i14 + i16] & 255) <= i12) {
                    bitMatrix.set(i10 + i16, i11 + i15);
                }
            }
            i15++;
            i14 += i13;
        }
    }

    @Override // com.google.zxing.common.GlobalHistogramBinarizer, com.google.zxing.Binarizer
    public Binarizer createBinarizer(LuminanceSource luminanceSource) {
        return new HybridBinarizer(luminanceSource);
    }

    @Override // com.google.zxing.common.GlobalHistogramBinarizer, com.google.zxing.Binarizer
    public BitMatrix getBlackMatrix() {
        BitMatrix bitMatrix = this.matrix;
        if (bitMatrix != null) {
            return bitMatrix;
        }
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        int height = luminanceSource.getHeight();
        if (width < 40 || height < 40) {
            this.matrix = super.getBlackMatrix();
        } else {
            byte[] matrix = luminanceSource.getMatrix();
            int i10 = width >> 3;
            if ((width & 7) != 0) {
                i10++;
            }
            int i11 = i10;
            int i12 = height >> 3;
            if ((height & 7) != 0) {
                i12++;
            }
            int i13 = i12;
            int[][] calculateBlackPoints = calculateBlackPoints(matrix, i11, i13, width, height);
            BitMatrix bitMatrix2 = new BitMatrix(width, height);
            calculateThresholdForBlock(matrix, i11, i13, width, height, calculateBlackPoints, bitMatrix2);
            this.matrix = bitMatrix2;
        }
        return this.matrix;
    }
}
