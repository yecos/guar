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
    */
    private int[] blackWhiteRange(int i10, int i11, int i12, int i13, boolean z10) {
        int i14;
        int i15;
        int i16 = (i12 + i13) / 2;
        int i17 = i16;
        while (i17 >= i12) {
            BitMatrix bitMatrix = this.image;
            if (z10) {
                if (!bitMatrix.get(i17, i10)) {
                    i15 = i17;
                    while (true) {
                        i15--;
                        if (i15 >= i12) {
                            break;
                        }
                        BitMatrix bitMatrix2 = this.image;
                        if (z10) {
                            if (bitMatrix2.get(i15, i10)) {
                                break;
                            }
                        } else if (bitMatrix2.get(i10, i15)) {
                            break;
                        }
                    }
                    int i18 = i17 - i15;
                    if (i15 >= i12 || i18 > i11) {
                        break;
                        break;
                    }
                    i17 = i15;
                } else {
                    i17--;
                }
            } else if (bitMatrix.get(i10, i17)) {
                i17--;
            } else {
                i15 = i17;
                while (true) {
                    i15--;
                    if (i15 >= i12) {
                    }
                }
                int i182 = i17 - i15;
                if (i15 >= i12) {
                    break;
                }
                i17 = i15;
            }
        }
        int i19 = i17 + 1;
        while (i16 < i13) {
            BitMatrix bitMatrix3 = this.image;
            if (z10) {
                if (!bitMatrix3.get(i16, i10)) {
                    i14 = i16;
                    while (true) {
                        i14++;
                        if (i14 < i13) {
                            break;
                        }
                        BitMatrix bitMatrix4 = this.image;
                        if (z10) {
                            if (bitMatrix4.get(i14, i10)) {
                                break;
                            }
                        } else if (bitMatrix4.get(i10, i14)) {
                            break;
                        }
                    }
                    int i20 = i14 - i16;
                    if (i14 < i13 || i20 > i11) {
                        break;
                        break;
                    }
                    i16 = i14;
                } else {
                    i16++;
                }
            } else if (bitMatrix3.get(i10, i16)) {
                i16++;
            } else {
                i14 = i16;
                while (true) {
                    i14++;
                    if (i14 < i13) {
                    }
                }
                int i202 = i14 - i16;
                if (i14 < i13) {
                    break;
                }
                i16 = i14;
            }
        }
        int i21 = i16 - 1;
        if (i21 > i19) {
            return new int[]{i19, i21};
        }
        return null;
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
