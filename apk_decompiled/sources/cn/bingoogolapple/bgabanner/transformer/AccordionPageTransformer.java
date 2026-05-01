package cn.bingoogolapple.bgabanner.transformer;

import android.view.View;
import b0.c1;

/* loaded from: classes.dex */
public class AccordionPageTransformer extends BGAPageTransformer {
    @Override // cn.bingoogolapple.bgabanner.transformer.BGAPageTransformer
    public void handleInvisiblePage(View view, float f10) {
    }

    @Override // cn.bingoogolapple.bgabanner.transformer.BGAPageTransformer
    public void handleLeftPage(View view, float f10) {
        c1.A0(view, view.getWidth());
        c1.G0(view, f10 + 1.0f);
    }

    @Override // cn.bingoogolapple.bgabanner.transformer.BGAPageTransformer
    public void handleRightPage(View view, float f10) {
        c1.A0(view, 0.0f);
        c1.G0(view, 1.0f - f10);
        c1.n0(view, 1.0f);
    }
}
