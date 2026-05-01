package com.google.zxing.qrcode.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Version;

/* loaded from: classes2.dex */
final class MatrixUtil {
    private static final int TYPE_INFO_MASK_PATTERN = 21522;
    private static final int TYPE_INFO_POLY = 1335;
    private static final int VERSION_INFO_POLY = 7973;
    private static final int[][] POSITION_DETECTION_PATTERN = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    private static final int[][] POSITION_ADJUSTMENT_PATTERN = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    private static final int[][] POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};
    private static final int[][] TYPE_INFO_COORDINATES = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    private MatrixUtil() {
    }

    public static void buildMatrix(BitArray bitArray, ErrorCorrectionLevel errorCorrectionLevel, Version version, int i10, ByteMatrix byteMatrix) {
        clearMatrix(byteMatrix);
        embedBasicPatterns(version, byteMatrix);
        embedTypeInfo(errorCorrectionLevel, i10, byteMatrix);
        maybeEmbedVersionInfo(version, byteMatrix);
        embedDataBits(bitArray, i10, byteMatrix);
    }

    public static int calculateBCHCode(int i10, int i11) {
        if (i11 == 0) {
            throw new IllegalArgumentException("0 polynomial");
        }
        int findMSBSet = findMSBSet(i11);
        int i12 = i10 << (findMSBSet - 1);
        while (findMSBSet(i12) >= findMSBSet) {
            i12 ^= i11 << (findMSBSet(i12) - findMSBSet);
        }
        return i12;
    }

    public static void clearMatrix(ByteMatrix byteMatrix) {
        byteMatrix.clear((byte) -1);
    }

    public static void embedBasicPatterns(Version version, ByteMatrix byteMatrix) {
        embedPositionDetectionPatternsAndSeparators(byteMatrix);
        embedDarkDotAtLeftBottomCorner(byteMatrix);
        maybeEmbedPositionAdjustmentPatterns(version, byteMatrix);
        embedTimingPatterns(byteMatrix);
    }

    private static void embedDarkDotAtLeftBottomCorner(ByteMatrix byteMatrix) {
        if (byteMatrix.get(8, byteMatrix.getHeight() - 8) == 0) {
            throw new WriterException();
        }
        byteMatrix.set(8, byteMatrix.getHeight() - 8, 1);
    }

    public static void embedDataBits(BitArray bitArray, int i10, ByteMatrix byteMatrix) {
        boolean z10;
        int width = byteMatrix.getWidth() - 1;
        int height = byteMatrix.getHeight() - 1;
        int i11 = 0;
        int i12 = -1;
        while (width > 0) {
            if (width == 6) {
                width--;
            }
            while (height >= 0 && height < byteMatrix.getHeight()) {
                for (int i13 = 0; i13 < 2; i13++) {
                    int i14 = width - i13;
                    if (isEmpty(byteMatrix.get(i14, height))) {
                        if (i11 < bitArray.getSize()) {
                            z10 = bitArray.get(i11);
                            i11++;
                        } else {
                            z10 = false;
                        }
                        if (i10 != -1 && MaskUtil.getDataMaskBit(i10, i14, height)) {
                            z10 = !z10;
                        }
                        byteMatrix.set(i14, height, z10);
                    }
                }
                height += i12;
            }
            i12 = -i12;
            height += i12;
            width -= 2;
        }
        if (i11 == bitArray.getSize()) {
            return;
        }
        throw new WriterException("Not all bits consumed: " + i11 + '/' + bitArray.getSize());
    }

    private static void embedHorizontalSeparationPattern(int i10, int i11, ByteMatrix byteMatrix) {
        for (int i12 = 0; i12 < 8; i12++) {
            int i13 = i10 + i12;
            if (!isEmpty(byteMatrix.get(i13, i11))) {
                throw new WriterException();
            }
            byteMatrix.set(i13, i11, 0);
        }
    }

    private static void embedPositionAdjustmentPattern(int i10, int i11, ByteMatrix byteMatrix) {
        for (int i12 = 0; i12 < 5; i12++) {
            for (int i13 = 0; i13 < 5; i13++) {
                byteMatrix.set(i10 + i13, i11 + i12, POSITION_ADJUSTMENT_PATTERN[i12][i13]);
            }
        }
    }

    private static void embedPositionDetectionPattern(int i10, int i11, ByteMatrix byteMatrix) {
        for (int i12 = 0; i12 < 7; i12++) {
            for (int i13 = 0; i13 < 7; i13++) {
                byteMatrix.set(i10 + i13, i11 + i12, POSITION_DETECTION_PATTERN[i12][i13]);
            }
        }
    }

    private static void embedPositionDetectionPatternsAndSeparators(ByteMatrix byteMatrix) {
        int length = POSITION_DETECTION_PATTERN[0].length;
        embedPositionDetectionPattern(0, 0, byteMatrix);
        embedPositionDetectionPattern(byteMatrix.getWidth() - length, 0, byteMatrix);
        embedPositionDetectionPattern(0, byteMatrix.getWidth() - length, byteMatrix);
        embedHorizontalSeparationPattern(0, 7, byteMatrix);
        embedHorizontalSeparationPattern(byteMatrix.getWidth() - 8, 7, byteMatrix);
        embedHorizontalSeparationPattern(0, byteMatrix.getWidth() - 8, byteMatrix);
        embedVerticalSeparationPattern(7, 0, byteMatrix);
        embedVerticalSeparationPattern((byteMatrix.getHeight() - 7) - 1, 0, byteMatrix);
        embedVerticalSeparationPattern(7, byteMatrix.getHeight() - 7, byteMatrix);
    }

    private static void embedTimingPatterns(ByteMatrix byteMatrix) {
        int i10 = 8;
        while (i10 < byteMatrix.getWidth() - 8) {
            int i11 = i10 + 1;
            int i12 = i11 % 2;
            if (isEmpty(byteMatrix.get(i10, 6))) {
                byteMatrix.set(i10, 6, i12);
            }
            if (isEmpty(byteMatrix.get(6, i10))) {
                byteMatrix.set(6, i10, i12);
            }
            i10 = i11;
        }
    }

    public static void embedTypeInfo(ErrorCorrectionLevel errorCorrectionLevel, int i10, ByteMatrix byteMatrix) {
        BitArray bitArray = new BitArray();
        makeTypeInfoBits(errorCorrectionLevel, i10, bitArray);
        for (int i11 = 0; i11 < bitArray.getSize(); i11++) {
            boolean z10 = bitArray.get((bitArray.getSize() - 1) - i11);
            int[] iArr = TYPE_INFO_COORDINATES[i11];
            byteMatrix.set(iArr[0], iArr[1], z10);
            if (i11 < 8) {
                byteMatrix.set((byteMatrix.getWidth() - i11) - 1, 8, z10);
            } else {
                byteMatrix.set(8, (byteMatrix.getHeight() - 7) + (i11 - 8), z10);
            }
        }
    }

    private static void embedVerticalSeparationPattern(int i10, int i11, ByteMatrix byteMatrix) {
        for (int i12 = 0; i12 < 7; i12++) {
            int i13 = i11 + i12;
            if (!isEmpty(byteMatrix.get(i10, i13))) {
                throw new WriterException();
            }
            byteMatrix.set(i10, i13, 0);
        }
    }

    public static int findMSBSet(int i10) {
        return 32 - Integer.numberOfLeadingZeros(i10);
    }

    private static boolean isEmpty(int i10) {
        return i10 == -1;
    }

    public static void makeTypeInfoBits(ErrorCorrectionLevel errorCorrectionLevel, int i10, BitArray bitArray) {
        if (!QRCode.isValidMaskPattern(i10)) {
            throw new WriterException("Invalid mask pattern");
        }
        int bits = (errorCorrectionLevel.getBits() << 3) | i10;
        bitArray.appendBits(bits, 5);
        bitArray.appendBits(calculateBCHCode(bits, TYPE_INFO_POLY), 10);
        BitArray bitArray2 = new BitArray();
        bitArray2.appendBits(TYPE_INFO_MASK_PATTERN, 15);
        bitArray.xor(bitArray2);
        if (bitArray.getSize() == 15) {
            return;
        }
        throw new WriterException("should not happen but we got: " + bitArray.getSize());
    }

    public static void makeVersionInfoBits(Version version, BitArray bitArray) {
        bitArray.appendBits(version.getVersionNumber(), 6);
        bitArray.appendBits(calculateBCHCode(version.getVersionNumber(), VERSION_INFO_POLY), 12);
        if (bitArray.getSize() == 18) {
            return;
        }
        throw new WriterException("should not happen but we got: " + bitArray.getSize());
    }

    private static void maybeEmbedPositionAdjustmentPatterns(Version version, ByteMatrix byteMatrix) {
        if (version.getVersionNumber() < 2) {
            return;
        }
        int[] iArr = POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE[version.getVersionNumber() - 1];
        for (int i10 : iArr) {
            for (int i11 : iArr) {
                if (i11 != -1 && i10 != -1 && isEmpty(byteMatrix.get(i11, i10))) {
                    embedPositionAdjustmentPattern(i11 - 2, i10 - 2, byteMatrix);
                }
            }
        }
    }

    public static void maybeEmbedVersionInfo(Version version, ByteMatrix byteMatrix) {
        if (version.getVersionNumber() < 7) {
            return;
        }
        BitArray bitArray = new BitArray();
        makeVersionInfoBits(version, bitArray);
        int i10 = 17;
        for (int i11 = 0; i11 < 6; i11++) {
            for (int i12 = 0; i12 < 3; i12++) {
                boolean z10 = bitArray.get(i10);
                i10--;
                byteMatrix.set(i11, (byteMatrix.getHeight() - 11) + i12, z10);
                byteMatrix.set((byteMatrix.getHeight() - 11) + i12, i11, z10);
            }
        }
    }
}
