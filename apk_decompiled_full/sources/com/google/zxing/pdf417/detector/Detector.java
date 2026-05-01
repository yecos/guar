package com.google.zxing.pdf417.detector;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class Detector {
    private static final int BARCODE_MIN_HEIGHT = 10;
    private static final float MAX_AVG_VARIANCE = 0.42f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.8f;
    private static final int MAX_PATTERN_DRIFT = 5;
    private static final int MAX_PIXEL_DRIFT = 3;
    private static final int ROW_STEP = 5;
    private static final int SKIPPED_ROW_COUNT_MAX = 25;
    private static final int[] INDEXES_START_PATTERN = {0, 4, 1, 5};
    private static final int[] INDEXES_STOP_PATTERN = {6, 2, 7, 3};
    private static final int[] START_PATTERN = {8, 1, 1, 1, 1, 1, 1, 3};
    private static final int[] STOP_PATTERN = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    private Detector() {
    }

    private static void copyToResult(ResultPoint[] resultPointArr, ResultPoint[] resultPointArr2, int[] iArr) {
        for (int i10 = 0; i10 < iArr.length; i10++) {
            resultPointArr[iArr[i10]] = resultPointArr2[i10];
        }
    }

    public static PDF417DetectorResult detect(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, boolean z10) {
        BitMatrix blackMatrix = binaryBitmap.getBlackMatrix();
        List<ResultPoint[]> detect = detect(z10, blackMatrix);
        if (detect.isEmpty()) {
            blackMatrix = blackMatrix.m34clone();
            blackMatrix.rotate180();
            detect = detect(z10, blackMatrix);
        }
        return new PDF417DetectorResult(blackMatrix, detect);
    }

    private static int[] findGuardPattern(BitMatrix bitMatrix, int i10, int i11, int i12, boolean z10, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i13 = 0;
        while (bitMatrix.get(i10, i11) && i10 > 0) {
            int i14 = i13 + 1;
            if (i13 >= 3) {
                break;
            }
            i10--;
            i13 = i14;
        }
        int length = iArr.length;
        boolean z11 = z10;
        int i15 = 0;
        int i16 = i10;
        while (i10 < i12) {
            if (bitMatrix.get(i10, i11) ^ z11) {
                iArr2[i15] = iArr2[i15] + 1;
            } else {
                int i17 = length - 1;
                if (i15 != i17) {
                    i15++;
                } else {
                    if (patternMatchVariance(iArr2, iArr, MAX_INDIVIDUAL_VARIANCE) < MAX_AVG_VARIANCE) {
                        return new int[]{i16, i10};
                    }
                    i16 += iArr2[0] + iArr2[1];
                    int i18 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i18);
                    iArr2[i18] = 0;
                    iArr2[i17] = 0;
                    i15--;
                }
                iArr2[i15] = 1;
                z11 = !z11;
            }
            i10++;
        }
        if (i15 != length - 1 || patternMatchVariance(iArr2, iArr, MAX_INDIVIDUAL_VARIANCE) >= MAX_AVG_VARIANCE) {
            return null;
        }
        return new int[]{i16, i10 - 1};
    }

    private static ResultPoint[] findRowsWithPattern(BitMatrix bitMatrix, int i10, int i11, int i12, int i13, int[] iArr) {
        int i14;
        boolean z10;
        int i15;
        int i16;
        int i17;
        ResultPoint[] resultPointArr = new ResultPoint[4];
        int[] iArr2 = new int[iArr.length];
        int i18 = i12;
        while (true) {
            if (i18 >= i10) {
                z10 = false;
                break;
            }
            int[] findGuardPattern = findGuardPattern(bitMatrix, i13, i18, i11, false, iArr, iArr2);
            if (findGuardPattern != null) {
                int i19 = i18;
                int[] iArr3 = findGuardPattern;
                int i20 = i19;
                while (true) {
                    if (i20 <= 0) {
                        i17 = i20;
                        break;
                    }
                    int i21 = i20 - 1;
                    int[] findGuardPattern2 = findGuardPattern(bitMatrix, i13, i21, i11, false, iArr, iArr2);
                    if (findGuardPattern2 == null) {
                        i17 = i21 + 1;
                        break;
                    }
                    iArr3 = findGuardPattern2;
                    i20 = i21;
                }
                float f10 = i17;
                resultPointArr[0] = new ResultPoint(iArr3[0], f10);
                resultPointArr[1] = new ResultPoint(iArr3[1], f10);
                i18 = i17;
                z10 = true;
            } else {
                i18 += 5;
            }
        }
        int i22 = i18 + 1;
        if (z10) {
            int[] iArr4 = {(int) resultPointArr[0].getX(), (int) resultPointArr[1].getX()};
            int i23 = i22;
            int i24 = 0;
            while (true) {
                if (i23 >= i10) {
                    i15 = i24;
                    i16 = i23;
                    break;
                }
                i15 = i24;
                i16 = i23;
                int[] findGuardPattern3 = findGuardPattern(bitMatrix, iArr4[0], i23, i11, false, iArr, iArr2);
                if (findGuardPattern3 != null && Math.abs(iArr4[0] - findGuardPattern3[0]) < 5 && Math.abs(iArr4[1] - findGuardPattern3[1]) < 5) {
                    iArr4 = findGuardPattern3;
                    i24 = 0;
                } else {
                    if (i15 > 25) {
                        break;
                    }
                    i24 = i15 + 1;
                }
                i23 = i16 + 1;
            }
            i22 = i16 - (i15 + 1);
            float f11 = i22;
            resultPointArr[2] = new ResultPoint(iArr4[0], f11);
            resultPointArr[3] = new ResultPoint(iArr4[1], f11);
        }
        if (i22 - i18 < 10) {
            for (i14 = 0; i14 < 4; i14++) {
                resultPointArr[i14] = null;
            }
        }
        return resultPointArr;
    }

    private static ResultPoint[] findVertices(BitMatrix bitMatrix, int i10, int i11) {
        int height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        ResultPoint[] resultPointArr = new ResultPoint[8];
        copyToResult(resultPointArr, findRowsWithPattern(bitMatrix, height, width, i10, i11, START_PATTERN), INDEXES_START_PATTERN);
        ResultPoint resultPoint = resultPointArr[4];
        if (resultPoint != null) {
            i11 = (int) resultPoint.getX();
            i10 = (int) resultPointArr[4].getY();
        }
        copyToResult(resultPointArr, findRowsWithPattern(bitMatrix, height, width, i10, i11, STOP_PATTERN), INDEXES_STOP_PATTERN);
        return resultPointArr;
    }

    private static float patternMatchVariance(int[] iArr, int[] iArr2, float f10) {
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            i10 += iArr[i12];
            i11 += iArr2[i12];
        }
        if (i10 < i11) {
            return Float.POSITIVE_INFINITY;
        }
        float f11 = i10;
        float f12 = f11 / i11;
        float f13 = f10 * f12;
        float f14 = 0.0f;
        for (int i13 = 0; i13 < length; i13++) {
            float f15 = iArr2[i13] * f12;
            float f16 = iArr[i13];
            float f17 = f16 > f15 ? f16 - f15 : f15 - f16;
            if (f17 > f13) {
                return Float.POSITIVE_INFINITY;
            }
            f14 += f17;
        }
        return f14 / f11;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r4 == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        r3 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
    
        if (r3.hasNext() == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        r4 = (com.google.zxing.ResultPoint[]) r3.next();
        r7 = r4[1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        if (r7 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
    
        r2 = (int) java.lang.Math.max(r2, r7.getY());
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:
    
        r4 = r4[3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
    
        if (r4 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
    
        r2 = java.lang.Math.max(r2, (int) r4.getY());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static List<ResultPoint[]> detect(boolean z10, BitMatrix bitMatrix) {
        int x10;
        float y10;
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        loop0: while (true) {
            int i11 = 0;
            boolean z11 = false;
            while (true) {
                if (i10 >= bitMatrix.getHeight()) {
                    break loop0;
                }
                ResultPoint[] findVertices = findVertices(bitMatrix, i10, i11);
                if (findVertices[0] != null || findVertices[3] != null) {
                    arrayList.add(findVertices);
                    if (!z10) {
                        break loop0;
                    }
                    ResultPoint resultPoint = findVertices[2];
                    if (resultPoint != null) {
                        x10 = (int) resultPoint.getX();
                        y10 = findVertices[2].getY();
                    } else {
                        x10 = (int) findVertices[4].getX();
                        y10 = findVertices[4].getY();
                    }
                    i10 = (int) y10;
                    i11 = x10;
                    z11 = true;
                } else {
                    break;
                }
            }
            i10 += 5;
        }
        return arrayList;
    }
}
