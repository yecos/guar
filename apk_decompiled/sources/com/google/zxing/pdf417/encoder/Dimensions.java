package com.google.zxing.pdf417.encoder;

/* loaded from: classes2.dex */
public final class Dimensions {
    private final int maxCols;
    private final int maxRows;
    private final int minCols;
    private final int minRows;

    public Dimensions(int i10, int i11, int i12, int i13) {
        this.minCols = i10;
        this.maxCols = i11;
        this.minRows = i12;
        this.maxRows = i13;
    }

    public int getMaxCols() {
        return this.maxCols;
    }

    public int getMaxRows() {
        return this.maxRows;
    }

    public int getMinCols() {
        return this.minCols;
    }

    public int getMinRows() {
        return this.minRows;
    }
}
