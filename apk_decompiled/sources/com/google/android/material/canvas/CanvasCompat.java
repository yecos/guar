package com.google.android.material.canvas;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Build;

/* loaded from: classes2.dex */
public class CanvasCompat {
    private CanvasCompat() {
    }

    public static int saveLayerAlpha(Canvas canvas, RectF rectF, int i10) {
        int saveLayerAlpha;
        if (Build.VERSION.SDK_INT <= 21) {
            return canvas.saveLayerAlpha(rectF, i10, 31);
        }
        saveLayerAlpha = canvas.saveLayerAlpha(rectF, i10);
        return saveLayerAlpha;
    }

    public static int saveLayerAlpha(Canvas canvas, float f10, float f11, float f12, float f13, int i10) {
        int saveLayerAlpha;
        if (Build.VERSION.SDK_INT > 21) {
            saveLayerAlpha = canvas.saveLayerAlpha(f10, f11, f12, f13, i10);
            return saveLayerAlpha;
        }
        return canvas.saveLayerAlpha(f10, f11, f12, f13, i10, 31);
    }
}
