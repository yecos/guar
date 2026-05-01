package com.google.zxing.aztec.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.raizlabs.android.dbflow.sql.language.Operator;

/* loaded from: classes2.dex */
public final class Detector {
    private static final int[] EXPECTED_CORNER_BITS = {3808, 476, 2107, 1799};
    private boolean compact;
    private final BitMatrix image;
    private int nbCenterLayers;
    private int nbDataBlocks;
    private int nbLayers;
    private int shift;

    public static final class Point {

        /* renamed from: x, reason: collision with root package name */
        private final int f7203x;

        /* renamed from: y, reason: collision with root package name */
        private final int f7204y;

        public Point(int i10, int i11) {
            this.f7203x = i10;
            this.f7204y = i11;
        }

        public int getX() {
            return this.f7203x;
        }

        public int getY() {
            return this.f7204y;
        }

        public ResultPoint toResultPoint() {
            return new ResultPoint(getX(), getY());
        }

        public String toString() {
            return Operator.Operation.LESS_THAN + this.f7203x + ' ' + this.f7204y + ASCIIPropertyListParser.DATA_END_TOKEN;
        }
    }

    public Detector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    private static float distance(Point point, Point point2) {
        return MathUtils.distance(point.getX(), point.getY(), point2.getX(), point2.getY());
    }

    private static ResultPoint[] expandSquare(ResultPoint[] resultPointArr, float f10, float f11) {
        float f12 = f11 / (f10 * 2.0f);
        float x10 = resultPointArr[0].getX() - resultPointArr[2].getX();
        float y10 = resultPointArr[0].getY() - resultPointArr[2].getY();
        float x11 = (resultPointArr[0].getX() + resultPointArr[2].getX()) / 2.0f;
        float y11 = (resultPointArr[0].getY() + resultPointArr[2].getY()) / 2.0f;
        float f13 = x10 * f12;
        float f14 = y10 * f12;
        ResultPoint resultPoint = new ResultPoint(x11 + f13, y11 + f14);
        ResultPoint resultPoint2 = new ResultPoint(x11 - f13, y11 - f14);
        float x12 = resultPointArr[1].getX() - resultPointArr[3].getX();
        float y12 = resultPointArr[1].getY() - resultPointArr[3].getY();
        float x13 = (resultPointArr[1].getX() + resultPointArr[3].getX()) / 2.0f;
        float y13 = (resultPointArr[1].getY() + resultPointArr[3].getY()) / 2.0f;
        float f15 = x12 * f12;
        float f16 = f12 * y12;
        return new ResultPoint[]{resultPoint, new ResultPoint(x13 + f15, y13 + f16), resultPoint2, new ResultPoint(x13 - f15, y13 - f16)};
    }

    private void extractParameters(ResultPoint[] resultPointArr) {
        long j10;
        long j11;
        if (!isValid(resultPointArr[0]) || !isValid(resultPointArr[1]) || !isValid(resultPointArr[2]) || !isValid(resultPointArr[3])) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i10 = this.nbCenterLayers * 2;
        int[] iArr = {sampleLine(resultPointArr[0], resultPointArr[1], i10), sampleLine(resultPointArr[1], resultPointArr[2], i10), sampleLine(resultPointArr[2], resultPointArr[3], i10), sampleLine(resultPointArr[3], resultPointArr[0], i10)};
        this.shift = getRotation(iArr, i10);
        long j12 = 0;
        for (int i11 = 0; i11 < 4; i11++) {
            int i12 = iArr[(this.shift + i11) % 4];
            if (this.compact) {
                j10 = j12 << 7;
                j11 = (i12 >> 1) & 127;
            } else {
                j10 = j12 << 10;
                j11 = ((i12 >> 2) & 992) + ((i12 >> 1) & 31);
            }
            j12 = j10 + j11;
        }
        int correctedParameterData = getCorrectedParameterData(j12, this.compact);
        if (this.compact) {
            this.nbLayers = (correctedParameterData >> 6) + 1;
            this.nbDataBlocks = (correctedParameterData & 63) + 1;
        } else {
            this.nbLayers = (correctedParameterData >> 11) + 1;
            this.nbDataBlocks = (correctedParameterData & 2047) + 1;
        }
    }

    private ResultPoint[] getBullsEyeCorners(Point point) {
        this.nbCenterLayers = 1;
        Point point2 = point;
        Point point3 = point2;
        Point point4 = point3;
        Point point5 = point4;
        boolean z10 = true;
        while (this.nbCenterLayers < 9) {
            Point firstDifferent = getFirstDifferent(point2, z10, 1, -1);
            Point firstDifferent2 = getFirstDifferent(point3, z10, 1, 1);
            Point firstDifferent3 = getFirstDifferent(point4, z10, -1, 1);
            Point firstDifferent4 = getFirstDifferent(point5, z10, -1, -1);
            if (this.nbCenterLayers > 2) {
                double distance = (distance(firstDifferent4, firstDifferent) * this.nbCenterLayers) / (distance(point5, point2) * (this.nbCenterLayers + 2));
                if (distance < 0.75d || distance > 1.25d || !isWhiteOrBlackRectangle(firstDifferent, firstDifferent2, firstDifferent3, firstDifferent4)) {
                    break;
                }
            }
            z10 = !z10;
            this.nbCenterLayers++;
            point5 = firstDifferent4;
            point2 = firstDifferent;
            point3 = firstDifferent2;
            point4 = firstDifferent3;
        }
        int i10 = this.nbCenterLayers;
        if (i10 != 5 && i10 != 7) {
            throw NotFoundException.getNotFoundInstance();
        }
        this.compact = i10 == 5;
        ResultPoint[] resultPointArr = {new ResultPoint(point2.getX() + 0.5f, point2.getY() - 0.5f), new ResultPoint(point3.getX() + 0.5f, point3.getY() + 0.5f), new ResultPoint(point4.getX() - 0.5f, point4.getY() + 0.5f), new ResultPoint(point5.getX() - 0.5f, point5.getY() - 0.5f)};
        int i11 = this.nbCenterLayers;
        return expandSquare(resultPointArr, (i11 * 2) - 3, i11 * 2);
    }

    private int getColor(Point point, Point point2) {
        float distance = distance(point, point2);
        float x10 = (point2.getX() - point.getX()) / distance;
        float y10 = (point2.getY() - point.getY()) / distance;
        float x11 = point.getX();
        float y11 = point.getY();
        boolean z10 = this.image.get(point.getX(), point.getY());
        int ceil = (int) Math.ceil(distance);
        int i10 = 0;
        for (int i11 = 0; i11 < ceil; i11++) {
            x11 += x10;
            y11 += y10;
            if (this.image.get(MathUtils.round(x11), MathUtils.round(y11)) != z10) {
                i10++;
            }
        }
        float f10 = i10 / distance;
        if (f10 <= 0.1f || f10 >= 0.9f) {
            return (f10 <= 0.1f) == z10 ? 1 : -1;
        }
        return 0;
    }

    private static int getCorrectedParameterData(long j10, boolean z10) {
        int i10;
        int i11;
        if (z10) {
            i10 = 7;
            i11 = 2;
        } else {
            i10 = 10;
            i11 = 4;
        }
        int i12 = i10 - i11;
        int[] iArr = new int[i10];
        for (int i13 = i10 - 1; i13 >= 0; i13--) {
            iArr[i13] = ((int) j10) & 15;
            j10 >>= 4;
        }
        try {
            new ReedSolomonDecoder(GenericGF.AZTEC_PARAM).decode(iArr, i12);
            int i14 = 0;
            for (int i15 = 0; i15 < i11; i15++) {
                i14 = (i14 << 4) + iArr[i15];
            }
            return i14;
        } catch (ReedSolomonException unused) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    private int getDimension() {
        if (this.compact) {
            return (this.nbLayers * 4) + 11;
        }
        int i10 = this.nbLayers;
        return i10 <= 4 ? (i10 * 4) + 15 : (i10 * 4) + ((((i10 - 4) / 8) + 1) * 2) + 15;
    }

    private Point getFirstDifferent(Point point, boolean z10, int i10, int i11) {
        int x10 = point.getX() + i10;
        int y10 = point.getY();
        while (true) {
            y10 += i11;
            if (!isValid(x10, y10) || this.image.get(x10, y10) != z10) {
                break;
            }
            x10 += i10;
        }
        int i12 = x10 - i10;
        int i13 = y10 - i11;
        while (isValid(i12, i13) && this.image.get(i12, i13) == z10) {
            i12 += i10;
        }
        int i14 = i12 - i10;
        while (isValid(i14, i13) && this.image.get(i14, i13) == z10) {
            i13 += i11;
        }
        return new Point(i14, i13 - i11);
    }

    private Point getMatrixCenter() {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        ResultPoint resultPoint4;
        ResultPoint resultPoint5;
        ResultPoint resultPoint6;
        ResultPoint resultPoint7;
        ResultPoint resultPoint8;
        try {
            ResultPoint[] detect = new WhiteRectangleDetector(this.image).detect();
            resultPoint3 = detect[0];
            resultPoint4 = detect[1];
            resultPoint2 = detect[2];
            resultPoint = detect[3];
        } catch (NotFoundException unused) {
            int width = this.image.getWidth() / 2;
            int height = this.image.getHeight() / 2;
            int i10 = width + 7;
            int i11 = height - 7;
            ResultPoint resultPoint9 = getFirstDifferent(new Point(i10, i11), false, 1, -1).toResultPoint();
            int i12 = height + 7;
            ResultPoint resultPoint10 = getFirstDifferent(new Point(i10, i12), false, 1, 1).toResultPoint();
            int i13 = width - 7;
            ResultPoint resultPoint11 = getFirstDifferent(new Point(i13, i12), false, -1, 1).toResultPoint();
            resultPoint = getFirstDifferent(new Point(i13, i11), false, -1, -1).toResultPoint();
            resultPoint2 = resultPoint11;
            resultPoint3 = resultPoint9;
            resultPoint4 = resultPoint10;
        }
        int round = MathUtils.round((((resultPoint3.getX() + resultPoint.getX()) + resultPoint4.getX()) + resultPoint2.getX()) / 4.0f);
        int round2 = MathUtils.round((((resultPoint3.getY() + resultPoint.getY()) + resultPoint4.getY()) + resultPoint2.getY()) / 4.0f);
        try {
            ResultPoint[] detect2 = new WhiteRectangleDetector(this.image, 15, round, round2).detect();
            resultPoint5 = detect2[0];
            resultPoint6 = detect2[1];
            resultPoint7 = detect2[2];
            resultPoint8 = detect2[3];
        } catch (NotFoundException unused2) {
            int i14 = round + 7;
            int i15 = round2 - 7;
            resultPoint5 = getFirstDifferent(new Point(i14, i15), false, 1, -1).toResultPoint();
            int i16 = round2 + 7;
            resultPoint6 = getFirstDifferent(new Point(i14, i16), false, 1, 1).toResultPoint();
            int i17 = round - 7;
            resultPoint7 = getFirstDifferent(new Point(i17, i16), false, -1, 1).toResultPoint();
            resultPoint8 = getFirstDifferent(new Point(i17, i15), false, -1, -1).toResultPoint();
        }
        return new Point(MathUtils.round((((resultPoint5.getX() + resultPoint8.getX()) + resultPoint6.getX()) + resultPoint7.getX()) / 4.0f), MathUtils.round((((resultPoint5.getY() + resultPoint8.getY()) + resultPoint6.getY()) + resultPoint7.getY()) / 4.0f));
    }

    private ResultPoint[] getMatrixCornerPoints(ResultPoint[] resultPointArr) {
        return expandSquare(resultPointArr, this.nbCenterLayers * 2, getDimension());
    }

    private static int getRotation(int[] iArr, int i10) {
        int i11 = 0;
        for (int i12 : iArr) {
            i11 = (i11 << 3) + ((i12 >> (i10 - 2)) << 1) + (i12 & 1);
        }
        int i13 = ((i11 & 1) << 11) + (i11 >> 1);
        for (int i14 = 0; i14 < 4; i14++) {
            if (Integer.bitCount(EXPECTED_CORNER_BITS[i14] ^ i13) <= 2) {
                return i14;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private boolean isValid(int i10, int i11) {
        return i10 >= 0 && i10 < this.image.getWidth() && i11 > 0 && i11 < this.image.getHeight();
    }

    private boolean isWhiteOrBlackRectangle(Point point, Point point2, Point point3, Point point4) {
        Point point5 = new Point(point.getX() - 3, point.getY() + 3);
        Point point6 = new Point(point2.getX() - 3, point2.getY() - 3);
        Point point7 = new Point(point3.getX() + 3, point3.getY() - 3);
        Point point8 = new Point(point4.getX() + 3, point4.getY() + 3);
        int color = getColor(point8, point5);
        return color != 0 && getColor(point5, point6) == color && getColor(point6, point7) == color && getColor(point7, point8) == color;
    }

    private BitMatrix sampleGrid(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) {
        GridSampler gridSampler = GridSampler.getInstance();
        int dimension = getDimension();
        float f10 = dimension / 2.0f;
        int i10 = this.nbCenterLayers;
        float f11 = f10 - i10;
        float f12 = f10 + i10;
        return gridSampler.sampleGrid(bitMatrix, dimension, dimension, f11, f11, f12, f11, f12, f12, f11, f12, resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY(), resultPoint3.getX(), resultPoint3.getY(), resultPoint4.getX(), resultPoint4.getY());
    }

    private int sampleLine(ResultPoint resultPoint, ResultPoint resultPoint2, int i10) {
        float distance = distance(resultPoint, resultPoint2);
        float f10 = distance / i10;
        float x10 = resultPoint.getX();
        float y10 = resultPoint.getY();
        float x11 = ((resultPoint2.getX() - resultPoint.getX()) * f10) / distance;
        float y11 = (f10 * (resultPoint2.getY() - resultPoint.getY())) / distance;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            float f11 = i12;
            if (this.image.get(MathUtils.round((f11 * x11) + x10), MathUtils.round((f11 * y11) + y10))) {
                i11 |= 1 << ((i10 - i12) - 1);
            }
        }
        return i11;
    }

    public AztecDetectorResult detect() {
        return detect(false);
    }

    private static float distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return MathUtils.distance(resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY());
    }

    private boolean isValid(ResultPoint resultPoint) {
        return isValid(MathUtils.round(resultPoint.getX()), MathUtils.round(resultPoint.getY()));
    }

    public AztecDetectorResult detect(boolean z10) {
        ResultPoint[] bullsEyeCorners = getBullsEyeCorners(getMatrixCenter());
        if (z10) {
            ResultPoint resultPoint = bullsEyeCorners[0];
            bullsEyeCorners[0] = bullsEyeCorners[2];
            bullsEyeCorners[2] = resultPoint;
        }
        extractParameters(bullsEyeCorners);
        BitMatrix bitMatrix = this.image;
        int i10 = this.shift;
        return new AztecDetectorResult(sampleGrid(bitMatrix, bullsEyeCorners[i10 % 4], bullsEyeCorners[(i10 + 1) % 4], bullsEyeCorners[(i10 + 2) % 4], bullsEyeCorners[(i10 + 3) % 4]), getMatrixCornerPoints(bullsEyeCorners), this.compact, this.nbDataBlocks, this.nbLayers);
    }
}
