package com.google.zxing.pdf417.decoder;

import com.google.zxing.pdf417.PDF417Common;
import java.util.Formatter;

/* loaded from: classes2.dex */
final class DetectionResult {
    private static final int ADJUST_ROW_NUMBER_SKIP = 2;
    private final int barcodeColumnCount;
    private final BarcodeMetadata barcodeMetadata;
    private BoundingBox boundingBox;
    private final DetectionResultColumn[] detectionResultColumns;

    public DetectionResult(BarcodeMetadata barcodeMetadata, BoundingBox boundingBox) {
        this.barcodeMetadata = barcodeMetadata;
        int columnCount = barcodeMetadata.getColumnCount();
        this.barcodeColumnCount = columnCount;
        this.boundingBox = boundingBox;
        this.detectionResultColumns = new DetectionResultColumn[columnCount + 2];
    }

    private void adjustIndicatorColumnRowNumbers(DetectionResultColumn detectionResultColumn) {
        if (detectionResultColumn != null) {
            ((DetectionResultRowIndicatorColumn) detectionResultColumn).adjustCompleteIndicatorColumnRowNumbers(this.barcodeMetadata);
        }
    }

    private static boolean adjustRowNumber(Codeword codeword, Codeword codeword2) {
        if (codeword2 == null || !codeword2.hasValidRowNumber() || codeword2.getBucket() != codeword.getBucket()) {
            return false;
        }
        codeword.setRowNumber(codeword2.getRowNumber());
        return true;
    }

    private static int adjustRowNumberIfValid(int i10, int i11, Codeword codeword) {
        if (codeword == null) {
            return i11;
        }
        if (codeword.hasValidRowNumber()) {
            return i11;
        }
        if (!codeword.isValidRowNumber(i10)) {
            return i11 + 1;
        }
        codeword.setRowNumber(i10);
        return 0;
    }

    private int adjustRowNumbers() {
        int adjustRowNumbersByRow = adjustRowNumbersByRow();
        if (adjustRowNumbersByRow == 0) {
            return 0;
        }
        for (int i10 = 1; i10 < this.barcodeColumnCount + 1; i10++) {
            Codeword[] codewords = this.detectionResultColumns[i10].getCodewords();
            for (int i11 = 0; i11 < codewords.length; i11++) {
                Codeword codeword = codewords[i11];
                if (codeword != null && !codeword.hasValidRowNumber()) {
                    adjustRowNumbers(i10, i11, codewords);
                }
            }
        }
        return adjustRowNumbersByRow;
    }

    private int adjustRowNumbersByRow() {
        adjustRowNumbersFromBothRI();
        return adjustRowNumbersFromLRI() + adjustRowNumbersFromRRI();
    }

    private void adjustRowNumbersFromBothRI() {
        DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
        DetectionResultColumn detectionResultColumn = detectionResultColumnArr[0];
        if (detectionResultColumn == null || detectionResultColumnArr[this.barcodeColumnCount + 1] == null) {
            return;
        }
        Codeword[] codewords = detectionResultColumn.getCodewords();
        Codeword[] codewords2 = this.detectionResultColumns[this.barcodeColumnCount + 1].getCodewords();
        for (int i10 = 0; i10 < codewords.length; i10++) {
            Codeword codeword = codewords[i10];
            if (codeword != null && codewords2[i10] != null && codeword.getRowNumber() == codewords2[i10].getRowNumber()) {
                for (int i11 = 1; i11 <= this.barcodeColumnCount; i11++) {
                    Codeword codeword2 = this.detectionResultColumns[i11].getCodewords()[i10];
                    if (codeword2 != null) {
                        codeword2.setRowNumber(codewords[i10].getRowNumber());
                        if (!codeword2.hasValidRowNumber()) {
                            this.detectionResultColumns[i11].getCodewords()[i10] = null;
                        }
                    }
                }
            }
        }
    }

    private int adjustRowNumbersFromLRI() {
        DetectionResultColumn detectionResultColumn = this.detectionResultColumns[0];
        if (detectionResultColumn == null) {
            return 0;
        }
        Codeword[] codewords = detectionResultColumn.getCodewords();
        int i10 = 0;
        for (int i11 = 0; i11 < codewords.length; i11++) {
            Codeword codeword = codewords[i11];
            if (codeword != null) {
                int rowNumber = codeword.getRowNumber();
                int i12 = 0;
                for (int i13 = 1; i13 < this.barcodeColumnCount + 1 && i12 < 2; i13++) {
                    Codeword codeword2 = this.detectionResultColumns[i13].getCodewords()[i11];
                    if (codeword2 != null) {
                        i12 = adjustRowNumberIfValid(rowNumber, i12, codeword2);
                        if (!codeword2.hasValidRowNumber()) {
                            i10++;
                        }
                    }
                }
            }
        }
        return i10;
    }

    private int adjustRowNumbersFromRRI() {
        DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
        int i10 = this.barcodeColumnCount;
        if (detectionResultColumnArr[i10 + 1] == null) {
            return 0;
        }
        Codeword[] codewords = detectionResultColumnArr[i10 + 1].getCodewords();
        int i11 = 0;
        for (int i12 = 0; i12 < codewords.length; i12++) {
            Codeword codeword = codewords[i12];
            if (codeword != null) {
                int rowNumber = codeword.getRowNumber();
                int i13 = 0;
                for (int i14 = this.barcodeColumnCount + 1; i14 > 0 && i13 < 2; i14--) {
                    Codeword codeword2 = this.detectionResultColumns[i14].getCodewords()[i12];
                    if (codeword2 != null) {
                        i13 = adjustRowNumberIfValid(rowNumber, i13, codeword2);
                        if (!codeword2.hasValidRowNumber()) {
                            i11++;
                        }
                    }
                }
            }
        }
        return i11;
    }

    public int getBarcodeColumnCount() {
        return this.barcodeColumnCount;
    }

    public int getBarcodeECLevel() {
        return this.barcodeMetadata.getErrorCorrectionLevel();
    }

    public int getBarcodeRowCount() {
        return this.barcodeMetadata.getRowCount();
    }

    public BoundingBox getBoundingBox() {
        return this.boundingBox;
    }

    public DetectionResultColumn getDetectionResultColumn(int i10) {
        return this.detectionResultColumns[i10];
    }

    public DetectionResultColumn[] getDetectionResultColumns() {
        adjustIndicatorColumnRowNumbers(this.detectionResultColumns[0]);
        adjustIndicatorColumnRowNumbers(this.detectionResultColumns[this.barcodeColumnCount + 1]);
        int i10 = PDF417Common.MAX_CODEWORDS_IN_BARCODE;
        while (true) {
            int adjustRowNumbers = adjustRowNumbers();
            if (adjustRowNumbers <= 0 || adjustRowNumbers >= i10) {
                break;
            }
            i10 = adjustRowNumbers;
        }
        return this.detectionResultColumns;
    }

    public void setBoundingBox(BoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }

    public void setDetectionResultColumn(int i10, DetectionResultColumn detectionResultColumn) {
        this.detectionResultColumns[i10] = detectionResultColumn;
    }

    public String toString() {
        DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
        DetectionResultColumn detectionResultColumn = detectionResultColumnArr[0];
        if (detectionResultColumn == null) {
            detectionResultColumn = detectionResultColumnArr[this.barcodeColumnCount + 1];
        }
        Formatter formatter = new Formatter();
        for (int i10 = 0; i10 < detectionResultColumn.getCodewords().length; i10++) {
            formatter.format("CW %3d:", Integer.valueOf(i10));
            for (int i11 = 0; i11 < this.barcodeColumnCount + 2; i11++) {
                DetectionResultColumn detectionResultColumn2 = this.detectionResultColumns[i11];
                if (detectionResultColumn2 == null) {
                    formatter.format("    |   ", new Object[0]);
                } else {
                    Codeword codeword = detectionResultColumn2.getCodewords()[i10];
                    if (codeword == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        formatter.format(" %3d|%3d", Integer.valueOf(codeword.getRowNumber()), Integer.valueOf(codeword.getValue()));
                    }
                }
            }
            formatter.format("%n", new Object[0]);
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }

    private void adjustRowNumbers(int i10, int i11, Codeword[] codewordArr) {
        Codeword codeword = codewordArr[i11];
        Codeword[] codewords = this.detectionResultColumns[i10 - 1].getCodewords();
        DetectionResultColumn detectionResultColumn = this.detectionResultColumns[i10 + 1];
        Codeword[] codewords2 = detectionResultColumn != null ? detectionResultColumn.getCodewords() : codewords;
        Codeword[] codewordArr2 = new Codeword[14];
        codewordArr2[2] = codewords[i11];
        codewordArr2[3] = codewords2[i11];
        if (i11 > 0) {
            int i12 = i11 - 1;
            codewordArr2[0] = codewordArr[i12];
            codewordArr2[4] = codewords[i12];
            codewordArr2[5] = codewords2[i12];
        }
        if (i11 > 1) {
            int i13 = i11 - 2;
            codewordArr2[8] = codewordArr[i13];
            codewordArr2[10] = codewords[i13];
            codewordArr2[11] = codewords2[i13];
        }
        if (i11 < codewordArr.length - 1) {
            int i14 = i11 + 1;
            codewordArr2[1] = codewordArr[i14];
            codewordArr2[6] = codewords[i14];
            codewordArr2[7] = codewords2[i14];
        }
        if (i11 < codewordArr.length - 2) {
            int i15 = i11 + 2;
            codewordArr2[9] = codewordArr[i15];
            codewordArr2[12] = codewords[i15];
            codewordArr2[13] = codewords2[i15];
        }
        for (int i16 = 0; i16 < 14 && !adjustRowNumber(codeword, codewordArr2[i16]); i16++) {
        }
    }
}
