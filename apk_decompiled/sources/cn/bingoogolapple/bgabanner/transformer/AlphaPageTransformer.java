package cn.bingoogolapple.bgabanner.transformer;

import android.view.View;
import b0.c1;

/* loaded from: classes.dex */
public class AlphaPageTransformer extends BGAPageTransformer {
    private float mMinScale = 0.4f;

    public AlphaPageTransformer() {
    }

    @Override // cn.bingoogolapple.bgabanner.transformer.BGAPageTransformer
    public void handleInvisiblePage(View view, float f10) {
        c1.n0(view, 0.0f);
    }

    @Override // cn.bingoogolapple.bgabanner.transformer.BGAPageTransformer
    public void handleLeftPage(View view, float f10) {
        float f11 = this.mMinScale;
        c1.n0(view, f11 + ((1.0f - f11) * (f10 + 1.0f)));
    }

    @Override // cn.bingoogolapple.bgabanner.transformer.BGAPageTransformer
    public void handleRightPage(View view, float f10) {
        float f11 = this.mMinScale;
        c1.n0(view, f11 + ((1.0f - f11) * (1.0f - f10)));
    }

    public void setMinScale(float f10) {
        if (f10 < 0.0f || f10 > 1.0f) {
            return;
        }
        this.mMinScale = f10;
    }

    public AlphaPageTransformer(float f10) {
        setMinScale(f10);
    }
}
