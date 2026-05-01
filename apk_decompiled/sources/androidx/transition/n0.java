package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

/* loaded from: classes.dex */
public class n0 extends m0 {
    @Override // androidx.transition.f0, androidx.transition.o0
    public float c(View view) {
        float transitionAlpha;
        transitionAlpha = view.getTransitionAlpha();
        return transitionAlpha;
    }

    @Override // androidx.transition.k0, androidx.transition.o0
    public void e(View view, int i10, int i11, int i12, int i13) {
        view.setLeftTopRightBottom(i10, i11, i12, i13);
    }

    @Override // androidx.transition.f0, androidx.transition.o0
    public void f(View view, float f10) {
        view.setTransitionAlpha(f10);
    }

    @Override // androidx.transition.m0, androidx.transition.o0
    public void g(View view, int i10) {
        view.setTransitionVisibility(i10);
    }

    @Override // androidx.transition.i0, androidx.transition.o0
    public void h(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // androidx.transition.i0, androidx.transition.o0
    public void i(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
