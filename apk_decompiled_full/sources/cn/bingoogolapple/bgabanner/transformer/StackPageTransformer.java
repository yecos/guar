package cn.bingoogolapple.bgabanner.transformer;

import android.view.View;
import b0.c1;

/* loaded from: classes.dex */
public class StackPageTransformer extends BGAPageTransformer {
    @Override // cn.bingoogolapple.bgabanner.transformer.BGAPageTransformer
    public void handleInvisiblePage(View view, float f10) {
    }

    @Override // cn.bingoogolapple.bgabanner.transformer.BGAPageTransformer
    public void handleLeftPage(View view, float f10) {
    }

    @Override // cn.bingoogolapple.bgabanner.transformer.BGAPageTransformer
    public void handleRightPage(View view, float f10) {
        c1.K0(view, (-view.getWidth()) * f10);
    }
}
