package com.google.android.material.shape;

/* loaded from: classes2.dex */
public class EdgeTreatment {
    @Deprecated
    public void getEdgePath(float f10, float f11, ShapePath shapePath) {
        getEdgePath(f10, f10 / 2.0f, f11, shapePath);
    }

    public void getEdgePath(float f10, float f11, float f12, ShapePath shapePath) {
        shapePath.lineTo(f10, 0.0f);
    }
}
