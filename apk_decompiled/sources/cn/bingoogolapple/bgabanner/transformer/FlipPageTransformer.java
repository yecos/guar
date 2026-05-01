package cn.bingoogolapple.bgabanner.transformer;

import android.view.View;
import b0.c1;

/* loaded from: classes.dex */
public class FlipPageTransformer extends BGAPageTransformer {
    private static final float ROTATION = 180.0f;

    @Override // cn.bingoogolapple.bgabanner.transformer.BGAPageTransformer
    public void handleInvisiblePage(View view, float f10) {
    }

    @Override // cn.bingoogolapple.bgabanner.transformer.BGAPageTransformer
    public void handleLeftPage(View view, float f10) {
        c1.K0(view, (-view.getWidth()) * f10);
        c1.F0(view, ROTATION * f10);
        if (f10 > -0.5d) {
            view.setVisibility(0);
        } else {
            view.setVisibility(4);
        }
    }

    @Override // cn.bingoogolapple.bgabanner.transformer.BGAPageTransformer
    public void handleRightPage(View view, float f10) {
        c1.K0(view, (-view.getWidth()) * f10);
        c1.F0(view, ROTATION * f10);
        if (f10 < 0.5d) {
            view.setVisibility(0);
        } else {
            view.setVisibility(4);
        }
    }
}
