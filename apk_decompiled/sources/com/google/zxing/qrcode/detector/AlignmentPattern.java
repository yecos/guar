package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPoint;

/* loaded from: classes2.dex */
public final class AlignmentPattern extends ResultPoint {
    private final float estimatedModuleSize;

    public AlignmentPattern(float f10, float f11, float f12) {
        super(f10, f11);
        this.estimatedModuleSize = f12;
    }

    public boolean aboutEquals(float f10, float f11, float f12) {
        if (Math.abs(f11 - getY()) > f10 || Math.abs(f12 - getX()) > f10) {
            return false;
        }
        float abs = Math.abs(f10 - this.estimatedModuleSize);
        return abs <= 1.0f || abs <= this.estimatedModuleSize;
    }

    public AlignmentPattern combineEstimate(float f10, float f11, float f12) {
        return new AlignmentPattern((getX() + f11) / 2.0f, (getY() + f10) / 2.0f, (this.estimatedModuleSize + f12) / 2.0f);
    }
}
