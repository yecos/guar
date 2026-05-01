package androidx.transition;

import android.view.View;

/* loaded from: classes.dex */
public class f0 extends o0 {

    /* renamed from: e, reason: collision with root package name */
    public static boolean f3473e = true;

    @Override // androidx.transition.o0
    public void a(View view) {
    }

    @Override // androidx.transition.o0
    public float c(View view) {
        float transitionAlpha;
        if (f3473e) {
            try {
                transitionAlpha = view.getTransitionAlpha();
                return transitionAlpha;
            } catch (NoSuchMethodError unused) {
                f3473e = false;
            }
        }
        return view.getAlpha();
    }

    @Override // androidx.transition.o0
    public void d(View view) {
    }

    @Override // androidx.transition.o0
    public void f(View view, float f10) {
        if (f3473e) {
            try {
                view.setTransitionAlpha(f10);
                return;
            } catch (NoSuchMethodError unused) {
                f3473e = false;
            }
        }
        view.setAlpha(f10);
    }
}
