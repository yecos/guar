package cn.bingoogolapple.bgabanner.transformer;

import android.view.View;
import b0.c1;

/* loaded from: classes.dex */
public class ZoomFadePageTransformer extends BGAPageTransformer {
    @Override // cn.bingoogolapple.bgabanner.transformer.BGAPageTransformer
    public void handleInvisiblePage(View view, float f10) {
    }

    @Override // cn.bingoogolapple.bgabanner.transformer.BGAPageTransformer
    public void handleLeftPage(View view, float f10) {
        c1.K0(view, (-view.getWidth()) * f10);
        c1.A0(view, view.getWidth() * 0.5f);
        c1.B0(view, view.getHeight() * 0.5f);
        float f11 = f10 + 1.0f;
        c1.G0(view, f11);
        c1.H0(view, f11);
        c1.n0(view, f11);
    }

    @Override // cn.bingoogolapple.bgabanner.transformer.BGAPageTransformer
    public void handleRightPage(View view, float f10) {
        c1.K0(view, (-view.getWidth()) * f10);
        c1.A0(view, view.getWidth() * 0.5f);
        c1.B0(view, view.getHeight() * 0.5f);
        float f11 = 1.0f - f10;
        c1.G0(view, f11);
        c1.H0(view, f11);
        c1.n0(view, f11);
    }
}
