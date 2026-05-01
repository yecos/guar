package com.google.zxing.pdf417.decoder;

/* loaded from: classes2.dex */
final class BarcodeMetadata {
    private final int columnCount;
    private final int errorCorrectionLevel;
    private final int rowCount;
    private final int rowCountLowerPart;
    private final int rowCountUpperPart;

    public BarcodeMetadata(int i10, int i11, int i12, int i13) {
        this.columnCount = i10;
        this.errorCorrectionLevel = i13;
        this.rowCountUpperPart = i11;
        this.rowCountLowerPart = i12;
        this.rowCount = i11 + i12;
    }

    public int getColumnCount() {
        return this.columnCount;
    }

    public int getErrorCorrectionLevel() {
        return this.errorCorrectionLevel;
    }

    public int getRowCount() {
        return this.rowCount;
    }

    public int getRowCountLowerPart() {
        return this.rowCountLowerPart;
    }

    public int getRowCountUpperPart() {
        return this.rowCountUpperPart;
    }
}
