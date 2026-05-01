package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPoint;

/* loaded from: classes2.dex */
public final class FinderPattern extends ResultPoint {
    private final int count;
    private final float estimatedModuleSize;

    public FinderPattern(float f10, float f11, float f12) {
        this(f10, f11, f12, 1);
    }

    public boolean aboutEquals(float f10, float f11, float f12) {
        if (Math.abs(f11 - getY()) > f10 || Math.abs(f12 - getX()) > f10) {
            return false;
        }
        float abs = Math.abs(f10 - this.estimatedModuleSize);
        return abs <= 1.0f || abs <= this.estimatedModuleSize;
    }

    public FinderPattern combineEstimate(float f10, float f11, float f12) {
        int i10 = this.count;
        int i11 = i10 + 1;
        float x10 = (i10 * getX()) + f11;
        float f13 = i11;
        return new FinderPattern(x10 / f13, ((this.count * getY()) + f10) / f13, ((this.count * this.estimatedModuleSize) + f12) / f13, i11);
    }

    public int getCount() {
        return this.count;
    }

    public float getEstimatedModuleSize() {
        return this.estimatedModuleSize;
    }

    private FinderPattern(float f10, float f11, float f12, int i10) {
        super(f10, f11);
        this.estimatedModuleSize = f12;
        this.count = i10;
    }
}
