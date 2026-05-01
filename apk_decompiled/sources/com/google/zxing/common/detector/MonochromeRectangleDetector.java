package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

@Deprecated
/* loaded from: classes2.dex */
public final class MonochromeRectangleDetector {
    private static final int MAX_MODULES = 32;
    private final BitMatrix image;

    public MonochromeRectangleDetector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0068 A[EDGE_INSN: B:67:0x0068->B:47:0x0068 BREAK  A[LOOP:3: B:39:0x0053->B:61:0x0053], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0031 A[EDGE_INSN: B:81:0x0031->B:21:0x0031 BREAK  A[LOOP:1: B:13:0x001c->B:75:0x001c], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int[] blackWhiteRange(int r5, int r6, int r7, int r8, boolean r9) {
        /*
            r4 = this;
            int r0 = r7 + r8
            int r0 = r0 / 2
            r1 = r0
        L5:
            if (r1 < r7) goto L3a
            com.google.zxing.common.BitMatrix r2 = r4.image
            if (r9 == 0) goto L12
            boolean r2 = r2.get(r1, r5)
            if (r2 == 0) goto L1b
            goto L18
        L12:
            boolean r2 = r2.get(r5, r1)
            if (r2 == 0) goto L1b
        L18:
            int r1 = r1 + (-1)
            goto L5
        L1b:
            r2 = r1
        L1c:
            int r2 = r2 + (-1)
            if (r2 < r7) goto L31
            com.google.zxing.common.BitMatrix r3 = r4.image
            if (r9 == 0) goto L2b
            boolean r3 = r3.get(r2, r5)
            if (r3 == 0) goto L1c
            goto L31
        L2b:
            boolean r3 = r3.get(r5, r2)
            if (r3 == 0) goto L1c
        L31:
            int r3 = r1 - r2
            if (r2 < r7) goto L3a
            if (r3 <= r6) goto L38
            goto L3a
        L38:
            r1 = r2
            goto L5
        L3a:
            int r1 = r1 + 1
        L3c:
            if (r0 >= r8) goto L71
            com.google.zxing.common.BitMatrix r7 = r4.image
            if (r9 == 0) goto L49
            boolean r7 = r7.get(r0, r5)
            if (r7 == 0) goto L52
            goto L4f
        L49:
            boolean r7 = r7.get(r5, r0)
            if (r7 == 0) goto L52
        L4f:
            int r0 = r0 + 1
            goto L3c
        L52:
            r7 = r0
        L53:
            int r7 = r7 + 1
            if (r7 >= r8) goto L68
            com.google.zxing.common.BitMatrix r2 = r4.image
            if (r9 == 0) goto L62
            boolean r2 = r2.get(r7, r5)
            if (r2 == 0) goto L53
            goto L68
        L62:
            boolean r2 = r2.get(r5, r7)
            if (r2 == 0) goto L53
        L68:
            int r2 = r7 - r0
            if (r7 >= r8) goto L71
            if (r2 <= r6) goto L6f
            goto L71
        L6f:
            r0 = r7
            goto L3c
        L71:
            int r0 = r0 + (-1)
            if (r0 <= r1) goto L7a
            int[] r5 = new int[]{r1, r0}
            return r5
        L7a:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.common.detector.MonochromeRectangleDetector.blackWhiteRange(int, int, int, int, boolean):int[]");
    }

    private ResultPoint findCornerFromCenter(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        int[] iArr = null;
        int i19 = i10;
        int i20 = i14;
        while (i20 < i17 && i20 >= i16 && i19 < i13 && i19 >= i12) {
            int[] blackWhiteRange = i11 == 0 ? blackWhiteRange(i20, i18, i12, i13, true) : blackWhiteRange(i19, i18, i16, i17, false);
            if (blackWhiteRange == null) {
                if (iArr == null) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (i11 == 0) {
                    int i21 = i20 - i15;
                    int i22 = iArr[0];
                    if (i22 >= i10) {
                        return new ResultPoint(iArr[1], i21);
                    }
                    if (iArr[1] > i10) {
                        return new ResultPoint(iArr[i15 <= 0 ? (char) 1 : (char) 0], i21);
                    }
                    return new ResultPoint(i22, i21);
                }
                int i23 = i19 - i11;
                int i24 = iArr[0];
                if (i24 >= i14) {
                    return new ResultPoint(i23, iArr[1]);
                }
                if (iArr[1] > i14) {
                    return new ResultPoint(i23, iArr[i11 >= 0 ? (char) 1 : (char) 0]);
                }
                return new ResultPoint(i23, i24);
            }
            i20 += i15;
            i19 += i11;
            iArr = blackWhiteRange;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public ResultPoint[] detect() {
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i10 = height / 2;
        int i11 = width / 2;
        int max = Math.max(1, height / 256);
        int max2 = Math.max(1, width / 256);
        int i12 = -max;
        int i13 = i11 / 2;
        int y10 = ((int) findCornerFromCenter(i11, 0, 0, width, i10, i12, 0, height, i13).getY()) - 1;
        int i14 = i10 / 2;
        ResultPoint findCornerFromCenter = findCornerFromCenter(i11, -max2, 0, width, i10, 0, y10, height, i14);
        int x10 = ((int) findCornerFromCenter.getX()) - 1;
        ResultPoint findCornerFromCenter2 = findCornerFromCenter(i11, max2, x10, width, i10, 0, y10, height, i14);
        int x11 = ((int) findCornerFromCenter2.getX()) + 1;
        ResultPoint findCornerFromCenter3 = findCornerFromCenter(i11, 0, x10, x11, i10, max, y10, height, i13);
        return new ResultPoint[]{findCornerFromCenter(i11, 0, x10, x11, i10, i12, y10, ((int) findCornerFromCenter3.getY()) + 1, i11 / 4), findCornerFromCenter, findCornerFromCenter2, findCornerFromCenter3};
    }
}
