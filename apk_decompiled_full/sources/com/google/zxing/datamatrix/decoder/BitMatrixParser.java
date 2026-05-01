package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

/* loaded from: classes2.dex */
final class BitMatrixParser {
    private final BitMatrix mappingBitMatrix;
    private final BitMatrix readMappingMatrix;
    private final Version version;

    public BitMatrixParser(BitMatrix bitMatrix) {
        int height = bitMatrix.getHeight();
        if (height < 8 || height > 144 || (height & 1) != 0) {
            throw FormatException.getFormatInstance();
        }
        this.version = readVersion(bitMatrix);
        BitMatrix extractDataRegion = extractDataRegion(bitMatrix);
        this.mappingBitMatrix = extractDataRegion;
        this.readMappingMatrix = new BitMatrix(extractDataRegion.getWidth(), extractDataRegion.getHeight());
    }

    private BitMatrix extractDataRegion(BitMatrix bitMatrix) {
        int symbolSizeRows = this.version.getSymbolSizeRows();
        int symbolSizeColumns = this.version.getSymbolSizeColumns();
        if (bitMatrix.getHeight() != symbolSizeRows) {
            throw new IllegalArgumentException("Dimension of bitMarix must match the version size");
        }
        int dataRegionSizeRows = this.version.getDataRegionSizeRows();
        int dataRegionSizeColumns = this.version.getDataRegionSizeColumns();
        int i10 = symbolSizeRows / dataRegionSizeRows;
        int i11 = symbolSizeColumns / dataRegionSizeColumns;
        BitMatrix bitMatrix2 = new BitMatrix(i11 * dataRegionSizeColumns, i10 * dataRegionSizeRows);
        for (int i12 = 0; i12 < i10; i12++) {
            int i13 = i12 * dataRegionSizeRows;
            for (int i14 = 0; i14 < i11; i14++) {
                int i15 = i14 * dataRegionSizeColumns;
                for (int i16 = 0; i16 < dataRegionSizeRows; i16++) {
                    int i17 = ((dataRegionSizeRows + 2) * i12) + 1 + i16;
                    int i18 = i13 + i16;
                    for (int i19 = 0; i19 < dataRegionSizeColumns; i19++) {
                        if (bitMatrix.get(((dataRegionSizeColumns + 2) * i14) + 1 + i19, i17)) {
                            bitMatrix2.set(i15 + i19, i18);
                        }
                    }
                }
            }
        }
        return bitMatrix2;
    }

    private int readCorner1(int i10, int i11) {
        int i12 = i10 - 1;
        int i13 = (readModule(i12, 0, i10, i11) ? 1 : 0) << 1;
        if (readModule(i12, 1, i10, i11)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (readModule(i12, 2, i10, i11)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        if (readModule(0, i11 - 2, i10, i11)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        int i17 = i11 - 1;
        if (readModule(0, i17, i10, i11)) {
            i16 |= 1;
        }
        int i18 = i16 << 1;
        if (readModule(1, i17, i10, i11)) {
            i18 |= 1;
        }
        int i19 = i18 << 1;
        if (readModule(2, i17, i10, i11)) {
            i19 |= 1;
        }
        int i20 = i19 << 1;
        return readModule(3, i17, i10, i11) ? i20 | 1 : i20;
    }

    private int readCorner2(int i10, int i11) {
        int i12 = (readModule(i10 + (-3), 0, i10, i11) ? 1 : 0) << 1;
        if (readModule(i10 - 2, 0, i10, i11)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (readModule(i10 - 1, 0, i10, i11)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (readModule(0, i11 - 4, i10, i11)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        if (readModule(0, i11 - 3, i10, i11)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        if (readModule(0, i11 - 2, i10, i11)) {
            i16 |= 1;
        }
        int i17 = i16 << 1;
        int i18 = i11 - 1;
        if (readModule(0, i18, i10, i11)) {
            i17 |= 1;
        }
        int i19 = i17 << 1;
        return readModule(1, i18, i10, i11) ? i19 | 1 : i19;
    }

    private int readCorner3(int i10, int i11) {
        int i12 = i10 - 1;
        int i13 = (readModule(i12, 0, i10, i11) ? 1 : 0) << 1;
        int i14 = i11 - 1;
        if (readModule(i12, i14, i10, i11)) {
            i13 |= 1;
        }
        int i15 = i13 << 1;
        int i16 = i11 - 3;
        if (readModule(0, i16, i10, i11)) {
            i15 |= 1;
        }
        int i17 = i15 << 1;
        int i18 = i11 - 2;
        if (readModule(0, i18, i10, i11)) {
            i17 |= 1;
        }
        int i19 = i17 << 1;
        if (readModule(0, i14, i10, i11)) {
            i19 |= 1;
        }
        int i20 = i19 << 1;
        if (readModule(1, i16, i10, i11)) {
            i20 |= 1;
        }
        int i21 = i20 << 1;
        if (readModule(1, i18, i10, i11)) {
            i21 |= 1;
        }
        int i22 = i21 << 1;
        return readModule(1, i14, i10, i11) ? i22 | 1 : i22;
    }

    private int readCorner4(int i10, int i11) {
        int i12 = (readModule(i10 + (-3), 0, i10, i11) ? 1 : 0) << 1;
        if (readModule(i10 - 2, 0, i10, i11)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (readModule(i10 - 1, 0, i10, i11)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (readModule(0, i11 - 2, i10, i11)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        int i16 = i11 - 1;
        if (readModule(0, i16, i10, i11)) {
            i15 |= 1;
        }
        int i17 = i15 << 1;
        if (readModule(1, i16, i10, i11)) {
            i17 |= 1;
        }
        int i18 = i17 << 1;
        if (readModule(2, i16, i10, i11)) {
            i18 |= 1;
        }
        int i19 = i18 << 1;
        return readModule(3, i16, i10, i11) ? i19 | 1 : i19;
    }

    private boolean readModule(int i10, int i11, int i12, int i13) {
        if (i10 < 0) {
            i10 += i12;
            i11 += 4 - ((i12 + 4) & 7);
        }
        if (i11 < 0) {
            i11 += i13;
            i10 += 4 - ((i13 + 4) & 7);
        }
        this.readMappingMatrix.set(i11, i10);
        return this.mappingBitMatrix.get(i11, i10);
    }

    private int readUtah(int i10, int i11, int i12, int i13) {
        int i14 = i10 - 2;
        int i15 = i11 - 2;
        int i16 = (readModule(i14, i15, i12, i13) ? 1 : 0) << 1;
        int i17 = i11 - 1;
        if (readModule(i14, i17, i12, i13)) {
            i16 |= 1;
        }
        int i18 = i16 << 1;
        int i19 = i10 - 1;
        if (readModule(i19, i15, i12, i13)) {
            i18 |= 1;
        }
        int i20 = i18 << 1;
        if (readModule(i19, i17, i12, i13)) {
            i20 |= 1;
        }
        int i21 = i20 << 1;
        if (readModule(i19, i11, i12, i13)) {
            i21 |= 1;
        }
        int i22 = i21 << 1;
        if (readModule(i10, i15, i12, i13)) {
            i22 |= 1;
        }
        int i23 = i22 << 1;
        if (readModule(i10, i17, i12, i13)) {
            i23 |= 1;
        }
        int i24 = i23 << 1;
        return readModule(i10, i11, i12, i13) ? i24 | 1 : i24;
    }

    private static Version readVersion(BitMatrix bitMatrix) {
        return Version.getVersionForDimensions(bitMatrix.getHeight(), bitMatrix.getWidth());
    }

    public Version getVersion() {
        return this.version;
    }

    public byte[] readCodewords() {
        byte[] bArr = new byte[this.version.getTotalCodewords()];
        int height = this.mappingBitMatrix.getHeight();
        int width = this.mappingBitMatrix.getWidth();
        int i10 = 0;
        boolean z10 = false;
        int i11 = 0;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        int i12 = 4;
        while (true) {
            if (i12 == height && i10 == 0 && !z10) {
                bArr[i11] = (byte) readCorner1(height, width);
                i12 -= 2;
                i10 += 2;
                i11++;
                z10 = true;
            } else {
                int i13 = height - 2;
                if (i12 == i13 && i10 == 0 && (width & 3) != 0 && !z11) {
                    bArr[i11] = (byte) readCorner2(height, width);
                    i12 -= 2;
                    i10 += 2;
                    i11++;
                    z11 = true;
                } else if (i12 == height + 4 && i10 == 2 && (width & 7) == 0 && !z12) {
                    bArr[i11] = (byte) readCorner3(height, width);
                    i12 -= 2;
                    i10 += 2;
                    i11++;
                    z12 = true;
                } else if (i12 == i13 && i10 == 0 && (width & 7) == 4 && !z13) {
                    bArr[i11] = (byte) readCorner4(height, width);
                    i12 -= 2;
                    i10 += 2;
                    i11++;
                    z13 = true;
                } else {
                    do {
                        if (i12 < height && i10 >= 0 && !this.readMappingMatrix.get(i10, i12)) {
                            bArr[i11] = (byte) readUtah(i12, i10, height, width);
                            i11++;
                        }
                        i12 -= 2;
                        i10 += 2;
                        if (i12 < 0) {
                            break;
                        }
                    } while (i10 < width);
                    int i14 = i12 + 1;
                    int i15 = i10 + 3;
                    do {
                        if (i14 >= 0 && i15 < width && !this.readMappingMatrix.get(i15, i14)) {
                            bArr[i11] = (byte) readUtah(i14, i15, height, width);
                            i11++;
                        }
                        i14 += 2;
                        i15 -= 2;
                        if (i14 >= height) {
                            break;
                        }
                    } while (i15 >= 0);
                    i12 = i14 + 3;
                    i10 = i15 + 1;
                }
            }
            if (i12 >= height && i10 >= width) {
                break;
            }
        }
        if (i11 == this.version.getTotalCodewords()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }
}
