package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

/* loaded from: classes.dex */
public class i0 extends f0 {

    /* renamed from: f, reason: collision with root package name */
    public static boolean f3480f = true;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f3481g = true;

    @Override // androidx.transition.o0
    public void h(View view, Matrix matrix) {
        if (f3480f) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f3480f = false;
            }
        }
    }

    @Override // androidx.transition.o0
    public void i(View view, Matrix matrix) {
        if (f3481g) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f3481g = false;
            }
        }
    }
}
