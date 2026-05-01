package com.google.zxing.datamatrix.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class Detector {
    private final BitMatrix image;
    private final WhiteRectangleDetector rectangleDetector;

    public static final class ResultPointsAndTransitions {
        private final ResultPoint from;
        private final ResultPoint to;
        private final int transitions;

        public ResultPoint getFrom() {
            return this.from;
        }

        public ResultPoint getTo() {
            return this.to;
        }

        public int getTransitions() {
            return this.transitions;
        }

        public String toString() {
            return this.from + Operator.Operation.DIVISION + this.to + '/' + this.transitions;
        }

        private ResultPointsAndTransitions(ResultPoint resultPoint, ResultPoint resultPoint2, int i10) {
            this.from = resultPoint;
            this.to = resultPoint2;
            this.transitions = i10;
        }
    }

    public static final class ResultPointsAndTransitionsComparator implements Serializable, Comparator<ResultPointsAndTransitions> {
        private ResultPointsAndTransitionsComparator() {
        }

        @Override // java.util.Comparator
        public int compare(ResultPointsAndTransitions resultPointsAndTransitions, ResultPointsAndTransitions resultPointsAndTransitions2) {
            return resultPointsAndTransitions.getTransitions() - resultPointsAndTransitions2.getTransitions();
        }
    }

    public Detector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
        this.rectangleDetector = new WhiteRectangleDetector(bitMatrix);
    }

    private ResultPoint correctTopRight(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i10) {
        float f10 = i10;
        float distance = distance(resultPoint, resultPoint2) / f10;
        float distance2 = distance(resultPoint3, resultPoint4);
        ResultPoint resultPoint5 = new ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint3.getX()) / distance2) * distance), resultPoint4.getY() + (distance * ((resultPoint4.getY() - resultPoint3.getY()) / distance2)));
        float distance3 = distance(resultPoint, resultPoint3) / f10;
        float distance4 = distance(resultPoint2, resultPoint4);
        ResultPoint resultPoint6 = new ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint2.getX()) / distance4) * distance3), resultPoint4.getY() + (distance3 * ((resultPoint4.getY() - resultPoint2.getY()) / distance4)));
        if (isValid(resultPoint5)) {
            return !isValid(resultPoint6) ? resultPoint5 : Math.abs(transitionsBetween(resultPoint3, resultPoint5).getTransitions() - transitionsBetween(resultPoint2, resultPoint5).getTransitions()) <= Math.abs(transitionsBetween(resultPoint3, resultPoint6).getTransitions() - transitionsBetween(resultPoint2, resultPoint6).getTransitions()) ? resultPoint5 : resultPoint6;
        }
        if (isValid(resultPoint6)) {
            return resultPoint6;
        }
        return null;
    }

    private ResultPoint correctTopRightRectangular(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i10, int i11) {
        float distance = distance(resultPoint, resultPoint2) / i10;
        float distance2 = distance(resultPoint3, resultPoint4);
        ResultPoint resultPoint5 = new ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint3.getX()) / distance2) * distance), resultPoint4.getY() + (distance * ((resultPoint4.getY() - resultPoint3.getY()) / distance2)));
        float distance3 = distance(resultPoint, resultPoint3) / i11;
        float distance4 = distance(resultPoint2, resultPoint4);
        ResultPoint resultPoint6 = new ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint2.getX()) / distance4) * distance3), resultPoint4.getY() + (distance3 * ((resultPoint4.getY() - resultPoint2.getY()) / distance4)));
        if (isValid(resultPoint5)) {
            return !isValid(resultPoint6) ? resultPoint5 : Math.abs(i10 - transitionsBetween(resultPoint3, resultPoint5).getTransitions()) + Math.abs(i11 - transitionsBetween(resultPoint2, resultPoint5).getTransitions()) <= Math.abs(i10 - transitionsBetween(resultPoint3, resultPoint6).getTransitions()) + Math.abs(i11 - transitionsBetween(resultPoint2, resultPoint6).getTransitions()) ? resultPoint5 : resultPoint6;
        }
        if (isValid(resultPoint6)) {
            return resultPoint6;
        }
        return null;
    }

    private static int distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return MathUtils.round(ResultPoint.distance(resultPoint, resultPoint2));
    }

    private static void increment(Map<ResultPoint, Integer> map, ResultPoint resultPoint) {
        Integer num = map.get(resultPoint);
        map.put(resultPoint, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    private boolean isValid(ResultPoint resultPoint) {
        return resultPoint.getX() >= 0.0f && resultPoint.getX() < ((float) this.image.getWidth()) && resultPoint.getY() > 0.0f && resultPoint.getY() < ((float) this.image.getHeight());
    }

    private static BitMatrix sampleGrid(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i10, int i11) {
        float f10 = i10 - 0.5f;
        float f11 = i11 - 0.5f;
        return GridSampler.getInstance().sampleGrid(bitMatrix, i10, i11, 0.5f, 0.5f, f10, 0.5f, f10, f11, 0.5f, f11, resultPoint.getX(), resultPoint.getY(), resultPoint4.getX(), resultPoint4.getY(), resultPoint3.getX(), resultPoint3.getY(), resultPoint2.getX(), resultPoint2.getY());
    }

    private ResultPointsAndTransitions transitionsBetween(ResultPoint resultPoint, ResultPoint resultPoint2) {
        int x10 = (int) resultPoint.getX();
        int y10 = (int) resultPoint.getY();
        int x11 = (int) resultPoint2.getX();
        int y11 = (int) resultPoint2.getY();
        int i10 = 0;
        boolean z10 = Math.abs(y11 - y10) > Math.abs(x11 - x10);
        if (z10) {
            y10 = x10;
            x10 = y10;
            y11 = x11;
            x11 = y11;
        }
        int abs = Math.abs(x11 - x10);
        int abs2 = Math.abs(y11 - y10);
        int i11 = (-abs) / 2;
        int i12 = y10 < y11 ? 1 : -1;
        int i13 = x10 >= x11 ? -1 : 1;
        boolean z11 = this.image.get(z10 ? y10 : x10, z10 ? x10 : y10);
        while (x10 != x11) {
            boolean z12 = this.image.get(z10 ? y10 : x10, z10 ? x10 : y10);
            if (z12 != z11) {
                i10++;
                z11 = z12;
            }
            i11 += abs2;
            if (i11 > 0) {
                if (y10 == y11) {
                    break;
                }
                y10 += i12;
                i11 -= abs;
            }
            x10 += i13;
        }
        return new ResultPointsAndTransitions(resultPoint, resultPoint2, i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v3, types: [com.google.zxing.ResultPoint] */
    /* JADX WARN: Type inference failed for: r16v3, types: [com.google.zxing.ResultPoint] */
    /* JADX WARN: Type inference failed for: r22v0, types: [com.google.zxing.ResultPoint] */
    /* JADX WARN: Type inference failed for: r23v0, types: [com.google.zxing.datamatrix.detector.Detector] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.google.zxing.ResultPoint[]] */
    /* JADX WARN: Type inference failed for: r4v6, types: [com.google.zxing.ResultPoint[]] */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.google.zxing.ResultPoint] */
    public DetectorResult detect() {
        ResultPoint resultPoint;
        BitMatrix sampleGrid;
        ResultPoint[] detect = this.rectangleDetector.detect();
        ResultPoint resultPoint2 = detect[0];
        ResultPoint resultPoint3 = detect[1];
        ResultPoint resultPoint4 = detect[2];
        ResultPoint resultPoint5 = detect[3];
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(transitionsBetween(resultPoint2, resultPoint3));
        arrayList.add(transitionsBetween(resultPoint2, resultPoint4));
        arrayList.add(transitionsBetween(resultPoint3, resultPoint5));
        arrayList.add(transitionsBetween(resultPoint4, resultPoint5));
        AnonymousClass1 anonymousClass1 = null;
        Collections.sort(arrayList, new ResultPointsAndTransitionsComparator());
        ResultPointsAndTransitions resultPointsAndTransitions = (ResultPointsAndTransitions) arrayList.get(0);
        ResultPointsAndTransitions resultPointsAndTransitions2 = (ResultPointsAndTransitions) arrayList.get(1);
        HashMap hashMap = new HashMap();
        increment(hashMap, resultPointsAndTransitions.getFrom());
        increment(hashMap, resultPointsAndTransitions.getTo());
        increment(hashMap, resultPointsAndTransitions2.getFrom());
        increment(hashMap, resultPointsAndTransitions2.getTo());
        Object obj = null;
        Object obj2 = null;
        for (Map.Entry entry : hashMap.entrySet()) {
            ?? r16 = (ResultPoint) entry.getKey();
            if (((Integer) entry.getValue()).intValue() == 2) {
                obj = r16;
            } else if (anonymousClass1 == null) {
                anonymousClass1 = r16;
            } else {
                obj2 = r16;
            }
        }
        if (anonymousClass1 == null || obj == null || obj2 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        ?? r42 = {anonymousClass1, obj, obj2};
        ResultPoint.orderBestPatterns(r42);
        ?? r14 = r42[0];
        ?? r22 = r42[1];
        ?? r62 = r42[2];
        ResultPoint resultPoint6 = !hashMap.containsKey(resultPoint2) ? resultPoint2 : !hashMap.containsKey(resultPoint3) ? resultPoint3 : !hashMap.containsKey(resultPoint4) ? resultPoint4 : resultPoint5;
        int transitions = transitionsBetween(r62, resultPoint6).getTransitions();
        int transitions2 = transitionsBetween(r14, resultPoint6).getTransitions();
        if ((transitions & 1) == 1) {
            transitions++;
        }
        int i10 = transitions + 2;
        if ((transitions2 & 1) == 1) {
            transitions2++;
        }
        int i11 = transitions2 + 2;
        if (i10 * 4 >= i11 * 7 || i11 * 4 >= i10 * 7) {
            resultPoint = r62;
            ResultPoint correctTopRightRectangular = correctTopRightRectangular(r22, r14, r62, resultPoint6, i10, i11);
            if (correctTopRightRectangular != null) {
                resultPoint6 = correctTopRightRectangular;
            }
            int transitions3 = transitionsBetween(resultPoint, resultPoint6).getTransitions();
            int transitions4 = transitionsBetween(r14, resultPoint6).getTransitions();
            if ((transitions3 & 1) == 1) {
                transitions3++;
            }
            int i12 = transitions3;
            if ((transitions4 & 1) == 1) {
                transitions4++;
            }
            sampleGrid = sampleGrid(this.image, resultPoint, r22, r14, resultPoint6, i12, transitions4);
        } else {
            ResultPoint correctTopRight = correctTopRight(r22, r14, r62, resultPoint6, Math.min(i11, i10));
            if (correctTopRight != null) {
                resultPoint6 = correctTopRight;
            }
            int max = Math.max(transitionsBetween(r62, resultPoint6).getTransitions(), transitionsBetween(r14, resultPoint6).getTransitions()) + 1;
            if ((max & 1) == 1) {
                max++;
            }
            int i13 = max;
            sampleGrid = sampleGrid(this.image, r62, r22, r14, resultPoint6, i13, i13);
            resultPoint = r62;
        }
        return new DetectorResult(sampleGrid, new ResultPoint[]{resultPoint, r22, r14, resultPoint6});
    }
}
