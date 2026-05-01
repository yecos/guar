package com.google.zxing.pdf417.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.pdf417.PDF417Common;
import com.google.zxing.pdf417.decoder.ec.ErrorCorrection;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Formatter;

/* loaded from: classes2.dex */
public final class PDF417ScanningDecoder {
    private static final int CODEWORD_SKEW_SIZE = 2;
    private static final int MAX_EC_CODEWORDS = 512;
    private static final int MAX_ERRORS = 3;
    private static final ErrorCorrection errorCorrection = new ErrorCorrection();

    private PDF417ScanningDecoder() {
    }

    private static BoundingBox adjustBoundingBox(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn) {
        int[] rowHeights;
        if (detectionResultRowIndicatorColumn == null || (rowHeights = detectionResultRowIndicatorColumn.getRowHeights()) == null) {
            return null;
        }
        int max = getMax(rowHeights);
        int i10 = 0;
        int i11 = 0;
        for (int i12 : rowHeights) {
            i11 += max - i12;
            if (i12 > 0) {
                break;
            }
        }
        Codeword[] codewords = detectionResultRowIndicatorColumn.getCodewords();
        for (int i13 = 0; i11 > 0 && codewords[i13] == null; i13++) {
            i11--;
        }
        for (int length = rowHeights.length - 1; length >= 0; length--) {
            int i14 = rowHeights[length];
            i10 += max - i14;
            if (i14 > 0) {
                break;
            }
        }
        for (int length2 = codewords.length - 1; i10 > 0 && codewords[length2] == null; length2--) {
            i10--;
        }
        return detectionResultRowIndicatorColumn.getBoundingBox().addMissingRows(i11, i10, detectionResultRowIndicatorColumn.isLeft());
    }

    private static void adjustCodewordCount(DetectionResult detectionResult, BarcodeValue[][] barcodeValueArr) {
        int[] value = barcodeValueArr[0][1].getValue();
        int barcodeColumnCount = (detectionResult.getBarcodeColumnCount() * detectionResult.getBarcodeRowCount()) - getNumberOfECCodeWords(detectionResult.getBarcodeECLevel());
        if (value.length != 0) {
            if (value[0] != barcodeColumnCount) {
                barcodeValueArr[0][1].setValue(barcodeColumnCount);
            }
        } else {
            if (barcodeColumnCount <= 0 || barcodeColumnCount > 928) {
                throw NotFoundException.getNotFoundInstance();
            }
            barcodeValueArr[0][1].setValue(barcodeColumnCount);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int adjustCodewordStartColumn(com.google.zxing.common.BitMatrix r5, int r6, int r7, boolean r8, int r9, int r10) {
        /*
            if (r8 == 0) goto L4
            r0 = -1
            goto L5
        L4:
            r0 = 1
        L5:
            r1 = 0
            r2 = r9
        L7:
            r3 = 2
            if (r1 >= r3) goto L28
        La:
            if (r8 == 0) goto Lf
            if (r2 < r6) goto L22
            goto L11
        Lf:
            if (r2 >= r7) goto L22
        L11:
            boolean r4 = r5.get(r2, r10)
            if (r8 != r4) goto L22
            int r4 = r9 - r2
            int r4 = java.lang.Math.abs(r4)
            if (r4 <= r3) goto L20
            return r9
        L20:
            int r2 = r2 + r0
            goto La
        L22:
            int r0 = -r0
            r8 = r8 ^ 1
            int r1 = r1 + 1
            goto L7
        L28:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.PDF417ScanningDecoder.adjustCodewordStartColumn(com.google.zxing.common.BitMatrix, int, int, boolean, int, int):int");
    }

    private static boolean checkCodewordSkew(int i10, int i11, int i12) {
        return i11 + (-2) <= i10 && i10 <= i12 + 2;
    }

    private static int correctErrors(int[] iArr, int[] iArr2, int i10) {
        if ((iArr2 == null || iArr2.length <= (i10 / 2) + 3) && i10 >= 0 && i10 <= 512) {
            return errorCorrection.decode(iArr, i10, iArr2);
        }
        throw ChecksumException.getChecksumInstance();
    }

    private static BarcodeValue[][] createBarcodeMatrix(DetectionResult detectionResult) {
        int rowNumber;
        BarcodeValue[][] barcodeValueArr = (BarcodeValue[][]) Array.newInstance((Class<?>) BarcodeValue.class, detectionResult.getBarcodeRowCount(), detectionResult.getBarcodeColumnCount() + 2);
        for (BarcodeValue[] barcodeValueArr2 : barcodeValueArr) {
            int i10 = 0;
            while (true) {
                if (i10 < barcodeValueArr2.length) {
                    barcodeValueArr2[i10] = new BarcodeValue();
                    i10++;
                }
            }
        }
        int i11 = 0;
        for (DetectionResultColumn detectionResultColumn : detectionResult.getDetectionResultColumns()) {
            if (detectionResultColumn != null) {
                for (Codeword codeword : detectionResultColumn.getCodewords()) {
                    if (codeword != null && (rowNumber = codeword.getRowNumber()) >= 0 && rowNumber < barcodeValueArr.length) {
                        barcodeValueArr[rowNumber][i11].setValue(codeword.getValue());
                    }
                }
            }
            i11++;
        }
        return barcodeValueArr;
    }

    private static DecoderResult createDecoderResult(DetectionResult detectionResult) {
        BarcodeValue[][] createBarcodeMatrix = createBarcodeMatrix(detectionResult);
        adjustCodewordCount(detectionResult, createBarcodeMatrix);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[detectionResult.getBarcodeRowCount() * detectionResult.getBarcodeColumnCount()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i10 = 0; i10 < detectionResult.getBarcodeRowCount(); i10++) {
            int i11 = 0;
            while (i11 < detectionResult.getBarcodeColumnCount()) {
                int i12 = i11 + 1;
                int[] value = createBarcodeMatrix[i10][i12].getValue();
                int barcodeColumnCount = (detectionResult.getBarcodeColumnCount() * i10) + i11;
                if (value.length == 0) {
                    arrayList.add(Integer.valueOf(barcodeColumnCount));
                } else if (value.length == 1) {
                    iArr[barcodeColumnCount] = value[0];
                } else {
                    arrayList3.add(Integer.valueOf(barcodeColumnCount));
                    arrayList2.add(value);
                }
                i11 = i12;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size][];
        for (int i13 = 0; i13 < size; i13++) {
            iArr2[i13] = (int[]) arrayList2.get(i13);
        }
        return createDecoderResultFromAmbiguousValues(detectionResult.getBarcodeECLevel(), iArr, PDF417Common.toIntArray(arrayList), PDF417Common.toIntArray(arrayList3), iArr2);
    }

    private static DecoderResult createDecoderResultFromAmbiguousValues(int i10, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i11 = 100;
        while (true) {
            int i12 = i11 - 1;
            if (i11 <= 0) {
                throw ChecksumException.getChecksumInstance();
            }
            for (int i13 = 0; i13 < length; i13++) {
                iArr[iArr3[i13]] = iArr4[i13][iArr5[i13]];
            }
            try {
                return decodeCodewords(iArr, i10, iArr2);
            } catch (ChecksumException unused) {
                if (length == 0) {
                    throw ChecksumException.getChecksumInstance();
                }
                int i14 = 0;
                while (true) {
                    if (i14 >= length) {
                        break;
                    }
                    int i15 = iArr5[i14];
                    if (i15 < iArr4[i14].length - 1) {
                        iArr5[i14] = i15 + 1;
                        break;
                    }
                    iArr5[i14] = 0;
                    if (i14 == length - 1) {
                        throw ChecksumException.getChecksumInstance();
                    }
                    i14++;
                }
                i11 = i12;
            }
        }
    }

    public static DecoderResult decode(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i10, int i11) {
        int i12;
        int i13;
        int i14;
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn = null;
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2 = null;
        DetectionResult detectionResult = null;
        BoundingBox boundingBox = new BoundingBox(bitMatrix, resultPoint, resultPoint2, resultPoint3, resultPoint4);
        for (int i15 = 0; i15 < 2; i15++) {
            if (resultPoint != null) {
                detectionResultRowIndicatorColumn = getRowIndicatorColumn(bitMatrix, boundingBox, resultPoint, true, i10, i11);
            }
            if (resultPoint3 != null) {
                detectionResultRowIndicatorColumn2 = getRowIndicatorColumn(bitMatrix, boundingBox, resultPoint3, false, i10, i11);
            }
            detectionResult = merge(detectionResultRowIndicatorColumn, detectionResultRowIndicatorColumn2);
            if (detectionResult == null) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (i15 != 0 || detectionResult.getBoundingBox() == null || (detectionResult.getBoundingBox().getMinY() >= boundingBox.getMinY() && detectionResult.getBoundingBox().getMaxY() <= boundingBox.getMaxY())) {
                detectionResult.setBoundingBox(boundingBox);
                break;
            }
            boundingBox = detectionResult.getBoundingBox();
        }
        int barcodeColumnCount = detectionResult.getBarcodeColumnCount() + 1;
        detectionResult.setDetectionResultColumn(0, detectionResultRowIndicatorColumn);
        detectionResult.setDetectionResultColumn(barcodeColumnCount, detectionResultRowIndicatorColumn2);
        boolean z10 = detectionResultRowIndicatorColumn != null;
        int i16 = i10;
        int i17 = i11;
        for (int i18 = 1; i18 <= barcodeColumnCount; i18++) {
            int i19 = z10 ? i18 : barcodeColumnCount - i18;
            if (detectionResult.getDetectionResultColumn(i19) == null) {
                DetectionResultColumn detectionResultRowIndicatorColumn3 = (i19 == 0 || i19 == barcodeColumnCount) ? new DetectionResultRowIndicatorColumn(boundingBox, i19 == 0) : new DetectionResultColumn(boundingBox);
                detectionResult.setDetectionResultColumn(i19, detectionResultRowIndicatorColumn3);
                int i20 = -1;
                int minY = boundingBox.getMinY();
                int i21 = -1;
                while (minY <= boundingBox.getMaxY()) {
                    int startColumn = getStartColumn(detectionResult, i19, minY, z10);
                    if (startColumn >= 0 && startColumn <= boundingBox.getMaxX()) {
                        i14 = startColumn;
                    } else if (i21 != i20) {
                        i14 = i21;
                    } else {
                        i12 = i21;
                        i13 = minY;
                        i21 = i12;
                        minY = i13 + 1;
                        i20 = -1;
                    }
                    i12 = i21;
                    int i22 = minY;
                    Codeword detectCodeword = detectCodeword(bitMatrix, boundingBox.getMinX(), boundingBox.getMaxX(), z10, i14, i22, i16, i17);
                    i13 = i22;
                    if (detectCodeword != null) {
                        detectionResultRowIndicatorColumn3.setCodeword(i13, detectCodeword);
                        i16 = Math.min(i16, detectCodeword.getWidth());
                        i17 = Math.max(i17, detectCodeword.getWidth());
                        i21 = i14;
                        minY = i13 + 1;
                        i20 = -1;
                    }
                    i21 = i12;
                    minY = i13 + 1;
                    i20 = -1;
                }
            }
        }
        return createDecoderResult(detectionResult);
    }

    private static DecoderResult decodeCodewords(int[] iArr, int i10, int[] iArr2) {
        if (iArr.length == 0) {
            throw FormatException.getFormatInstance();
        }
        int i11 = 1 << (i10 + 1);
        int correctErrors = correctErrors(iArr, iArr2, i11);
        verifyCodewordCount(iArr, i11);
        DecoderResult decode = DecodedBitStreamParser.decode(iArr, String.valueOf(i10));
        decode.setErrorsCorrected(Integer.valueOf(correctErrors));
        decode.setErasures(Integer.valueOf(iArr2.length));
        return decode;
    }

    private static Codeword detectCodeword(BitMatrix bitMatrix, int i10, int i11, boolean z10, int i12, int i13, int i14, int i15) {
        int i16;
        int decodedValue;
        int codeword;
        int adjustCodewordStartColumn = adjustCodewordStartColumn(bitMatrix, i10, i11, z10, i12, i13);
        int[] moduleBitCount = getModuleBitCount(bitMatrix, i10, i11, z10, adjustCodewordStartColumn, i13);
        if (moduleBitCount == null) {
            return null;
        }
        int sum = MathUtils.sum(moduleBitCount);
        if (z10) {
            i16 = adjustCodewordStartColumn + sum;
        } else {
            for (int i17 = 0; i17 < moduleBitCount.length / 2; i17++) {
                int i18 = moduleBitCount[i17];
                moduleBitCount[i17] = moduleBitCount[(moduleBitCount.length - 1) - i17];
                moduleBitCount[(moduleBitCount.length - 1) - i17] = i18;
            }
            adjustCodewordStartColumn -= sum;
            i16 = adjustCodewordStartColumn;
        }
        if (checkCodewordSkew(sum, i14, i15) && (codeword = PDF417Common.getCodeword((decodedValue = PDF417CodewordDecoder.getDecodedValue(moduleBitCount)))) != -1) {
            return new Codeword(adjustCodewordStartColumn, i16, getCodewordBucketNumber(decodedValue), codeword);
        }
        return null;
    }

    private static BarcodeMetadata getBarcodeMetadata(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) {
        BarcodeMetadata barcodeMetadata;
        BarcodeMetadata barcodeMetadata2;
        if (detectionResultRowIndicatorColumn == null || (barcodeMetadata = detectionResultRowIndicatorColumn.getBarcodeMetadata()) == null) {
            if (detectionResultRowIndicatorColumn2 == null) {
                return null;
            }
            return detectionResultRowIndicatorColumn2.getBarcodeMetadata();
        }
        if (detectionResultRowIndicatorColumn2 == null || (barcodeMetadata2 = detectionResultRowIndicatorColumn2.getBarcodeMetadata()) == null || barcodeMetadata.getColumnCount() == barcodeMetadata2.getColumnCount() || barcodeMetadata.getErrorCorrectionLevel() == barcodeMetadata2.getErrorCorrectionLevel() || barcodeMetadata.getRowCount() == barcodeMetadata2.getRowCount()) {
            return barcodeMetadata;
        }
        return null;
    }

    private static int[] getBitCountForCodeword(int i10) {
        int[] iArr = new int[8];
        int i11 = 0;
        int i12 = 7;
        while (true) {
            int i13 = i10 & 1;
            if (i13 != i11) {
                i12--;
                if (i12 < 0) {
                    return iArr;
                }
                i11 = i13;
            }
            iArr[i12] = iArr[i12] + 1;
            i10 >>= 1;
        }
    }

    private static int getCodewordBucketNumber(int i10) {
        return getCodewordBucketNumber(getBitCountForCodeword(i10));
    }

    private static int getMax(int[] iArr) {
        int i10 = -1;
        for (int i11 : iArr) {
            i10 = Math.max(i10, i11);
        }
        return i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0027 A[EDGE_INSN: B:17:0x0027->B:18:0x0027 BREAK  A[LOOP:0: B:5:0x000c->B:13:0x000c], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int[] getModuleBitCount(com.google.zxing.common.BitMatrix r7, int r8, int r9, boolean r10, int r11, int r12) {
        /*
            r0 = 8
            int[] r1 = new int[r0]
            r2 = 1
            if (r10 == 0) goto L9
            r3 = 1
            goto La
        L9:
            r3 = -1
        La:
            r4 = 0
            r5 = r10
        Lc:
            if (r10 == 0) goto L11
            if (r11 >= r9) goto L27
            goto L13
        L11:
            if (r11 < r8) goto L27
        L13:
            if (r4 >= r0) goto L27
            boolean r6 = r7.get(r11, r12)
            if (r6 != r5) goto L22
            r6 = r1[r4]
            int r6 = r6 + r2
            r1[r4] = r6
            int r11 = r11 + r3
            goto Lc
        L22:
            int r4 = r4 + 1
            r5 = r5 ^ 1
            goto Lc
        L27:
            if (r4 == r0) goto L34
            if (r10 == 0) goto L2c
            r8 = r9
        L2c:
            if (r11 != r8) goto L32
            r7 = 7
            if (r4 != r7) goto L32
            goto L34
        L32:
            r7 = 0
            return r7
        L34:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.PDF417ScanningDecoder.getModuleBitCount(com.google.zxing.common.BitMatrix, int, int, boolean, int, int):int[]");
    }

    private static int getNumberOfECCodeWords(int i10) {
        return 2 << i10;
    }

    private static DetectionResultRowIndicatorColumn getRowIndicatorColumn(BitMatrix bitMatrix, BoundingBox boundingBox, ResultPoint resultPoint, boolean z10, int i10, int i11) {
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn = new DetectionResultRowIndicatorColumn(boundingBox, z10);
        int i12 = 0;
        while (i12 < 2) {
            int i13 = i12 == 0 ? 1 : -1;
            int x10 = (int) resultPoint.getX();
            for (int y10 = (int) resultPoint.getY(); y10 <= boundingBox.getMaxY() && y10 >= boundingBox.getMinY(); y10 += i13) {
                Codeword detectCodeword = detectCodeword(bitMatrix, 0, bitMatrix.getWidth(), z10, x10, y10, i10, i11);
                if (detectCodeword != null) {
                    detectionResultRowIndicatorColumn.setCodeword(y10, detectCodeword);
                    x10 = z10 ? detectCodeword.getStartX() : detectCodeword.getEndX();
                }
            }
            i12++;
        }
        return detectionResultRowIndicatorColumn;
    }

    private static int getStartColumn(DetectionResult detectionResult, int i10, int i11, boolean z10) {
        int i12 = z10 ? 1 : -1;
        int i13 = i10 - i12;
        Codeword codeword = isValidBarcodeColumn(detectionResult, i13) ? detectionResult.getDetectionResultColumn(i13).getCodeword(i11) : null;
        if (codeword != null) {
            return z10 ? codeword.getEndX() : codeword.getStartX();
        }
        Codeword codewordNearby = detectionResult.getDetectionResultColumn(i10).getCodewordNearby(i11);
        if (codewordNearby != null) {
            return z10 ? codewordNearby.getStartX() : codewordNearby.getEndX();
        }
        if (isValidBarcodeColumn(detectionResult, i13)) {
            codewordNearby = detectionResult.getDetectionResultColumn(i13).getCodewordNearby(i11);
        }
        if (codewordNearby != null) {
            return z10 ? codewordNearby.getEndX() : codewordNearby.getStartX();
        }
        int i14 = 0;
        while (true) {
            i10 -= i12;
            if (!isValidBarcodeColumn(detectionResult, i10)) {
                BoundingBox boundingBox = detectionResult.getBoundingBox();
                return z10 ? boundingBox.getMinX() : boundingBox.getMaxX();
            }
            for (Codeword codeword2 : detectionResult.getDetectionResultColumn(i10).getCodewords()) {
                if (codeword2 != null) {
                    return (z10 ? codeword2.getEndX() : codeword2.getStartX()) + (i12 * i14 * (codeword2.getEndX() - codeword2.getStartX()));
                }
            }
            i14++;
        }
    }

    private static boolean isValidBarcodeColumn(DetectionResult detectionResult, int i10) {
        return i10 >= 0 && i10 <= detectionResult.getBarcodeColumnCount() + 1;
    }

    private static DetectionResult merge(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) {
        BarcodeMetadata barcodeMetadata;
        if ((detectionResultRowIndicatorColumn == null && detectionResultRowIndicatorColumn2 == null) || (barcodeMetadata = getBarcodeMetadata(detectionResultRowIndicatorColumn, detectionResultRowIndicatorColumn2)) == null) {
            return null;
        }
        return new DetectionResult(barcodeMetadata, BoundingBox.merge(adjustBoundingBox(detectionResultRowIndicatorColumn), adjustBoundingBox(detectionResultRowIndicatorColumn2)));
    }

    public static String toString(BarcodeValue[][] barcodeValueArr) {
        Formatter formatter = new Formatter();
        for (int i10 = 0; i10 < barcodeValueArr.length; i10++) {
            formatter.format("Row %2d: ", Integer.valueOf(i10));
            int i11 = 0;
            while (true) {
                BarcodeValue[] barcodeValueArr2 = barcodeValueArr[i10];
                if (i11 < barcodeValueArr2.length) {
                    BarcodeValue barcodeValue = barcodeValueArr2[i11];
                    if (barcodeValue.getValue().length == 0) {
                        formatter.format("        ", null);
                    } else {
                        formatter.format("%4d(%2d)", Integer.valueOf(barcodeValue.getValue()[0]), barcodeValue.getConfidence(barcodeValue.getValue()[0]));
                    }
                    i11++;
                }
            }
            formatter.format("%n", new Object[0]);
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }

    private static void verifyCodewordCount(int[] iArr, int i10) {
        if (iArr.length < 4) {
            throw FormatException.getFormatInstance();
        }
        int i11 = iArr[0];
        if (i11 > iArr.length) {
            throw FormatException.getFormatInstance();
        }
        if (i11 == 0) {
            if (i10 >= iArr.length) {
                throw FormatException.getFormatInstance();
            }
            iArr[0] = iArr.length - i10;
        }
    }

    private static int getCodewordBucketNumber(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }
}
