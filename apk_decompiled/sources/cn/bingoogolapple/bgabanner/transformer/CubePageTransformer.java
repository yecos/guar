package cn.bingoogolapple.bgabanner.transformer;

import android.view.View;
import b0.c1;

/* loaded from: classes.dex */
public class CubePageTransformer extends BGAPageTransformer {
    private float mMaxRotation = 90.0f;

    public CubePageTransformer() {
    }

    @Override // cn.bingoogolapple.bgabanner.transformer.BGAPageTransformer
    public void handleInvisiblePage(View view, float f10) {
        c1.A0(view, view.getMeasuredWidth());
        c1.B0(view, view.getMeasuredHeight() * 0.5f);
        c1.F0(view, 0.0f);
    }

    @Override // cn.bingoogolapple.bgabanner.transformer.BGAPageTransformer
    public void handleLeftPage(View view, float f10) {
        c1.A0(view, view.getMeasuredWidth());
        c1.B0(view, view.getMeasuredHeight() * 0.5f);
        c1.F0(view, this.mMaxRotation * f10);
    }

    @Override // cn.bingoogolapple.bgabanner.transformer.BGAPageTransformer
    public void handleRightPage(View view, float f10) {
        c1.A0(view, 0.0f);
        c1.B0(view, view.getMeasuredHeight() * 0.5f);
        c1.F0(view, this.mMaxRotation * f10);
    }

    public void setMaxRotation(float f10) {
        if (f10 < 0.0f || f10 > 90.0f) {
            return;
        }
        this.mMaxRotation = f10;
    }

    public CubePageTransformer(float f10) {
        setMaxRotation(f10);
    }
}
