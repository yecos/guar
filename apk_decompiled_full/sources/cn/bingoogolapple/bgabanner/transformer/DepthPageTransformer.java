package cn.bingoogolapple.bgabanner.transformer;

import android.view.View;
import b0.c1;

/* loaded from: classes.dex */
public class DepthPageTransformer extends BGAPageTransformer {
    private float mMinScale = 0.8f;

    public DepthPageTransformer() {
    }

    @Override // cn.bingoogolapple.bgabanner.transformer.BGAPageTransformer
    public void handleInvisiblePage(View view, float f10) {
        c1.n0(view, 0.0f);
    }

    @Override // cn.bingoogolapple.bgabanner.transformer.BGAPageTransformer
    public void handleLeftPage(View view, float f10) {
        c1.n0(view, 1.0f);
        c1.K0(view, 0.0f);
        c1.G0(view, 1.0f);
        c1.H0(view, 1.0f);
    }

    @Override // cn.bingoogolapple.bgabanner.transformer.BGAPageTransformer
    public void handleRightPage(View view, float f10) {
        float f11 = 1.0f - f10;
        c1.n0(view, f11);
        c1.K0(view, (-view.getWidth()) * f10);
        float f12 = this.mMinScale;
        float f13 = f12 + ((1.0f - f12) * f11);
        c1.G0(view, f13);
        c1.H0(view, f13);
    }

    public void setMinScale(float f10) {
        if (f10 < 0.6f || f10 > 1.0f) {
            return;
        }
        this.mMinScale = f10;
    }

    public DepthPageTransformer(float f10) {
        setMinScale(f10);
    }
}
