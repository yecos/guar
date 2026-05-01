package com.google.zxing.pdf417.decoder;

import java.util.Formatter;

/* loaded from: classes2.dex */
class DetectionResultColumn {
    private static final int MAX_NEARBY_DISTANCE = 5;
    private final BoundingBox boundingBox;
    private final Codeword[] codewords;

    public DetectionResultColumn(BoundingBox boundingBox) {
        this.boundingBox = new BoundingBox(boundingBox);
        this.codewords = new Codeword[(boundingBox.getMaxY() - boundingBox.getMinY()) + 1];
    }

    public final BoundingBox getBoundingBox() {
        return this.boundingBox;
    }

    public final Codeword getCodeword(int i10) {
        return this.codewords[imageRowToCodewordIndex(i10)];
    }

    public final Codeword getCodewordNearby(int i10) {
        Codeword codeword;
        Codeword codeword2;
        Codeword codeword3 = getCodeword(i10);
        if (codeword3 != null) {
            return codeword3;
        }
        for (int i11 = 1; i11 < 5; i11++) {
            int imageRowToCodewordIndex = imageRowToCodewordIndex(i10) - i11;
            if (imageRowToCodewordIndex >= 0 && (codeword2 = this.codewords[imageRowToCodewordIndex]) != null) {
                return codeword2;
            }
            int imageRowToCodewordIndex2 = imageRowToCodewordIndex(i10) + i11;
            Codeword[] codewordArr = this.codewords;
            if (imageRowToCodewordIndex2 < codewordArr.length && (codeword = codewordArr[imageRowToCodewordIndex2]) != null) {
                return codeword;
            }
        }
        return null;
    }

    public final Codeword[] getCodewords() {
        return this.codewords;
    }

    public final int imageRowToCodewordIndex(int i10) {
        return i10 - this.boundingBox.getMinY();
    }

    public final void setCodeword(int i10, Codeword codeword) {
        this.codewords[imageRowToCodewordIndex(i10)] = codeword;
    }

    public String toString() {
        Formatter formatter = new Formatter();
        int i10 = 0;
        for (Codeword codeword : this.codewords) {
            if (codeword == null) {
                formatter.format("%3d:    |   %n", Integer.valueOf(i10));
                i10++;
            } else {
                formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i10), Integer.valueOf(codeword.getRowNumber()), Integer.valueOf(codeword.getValue()));
                i10++;
            }
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }
}
