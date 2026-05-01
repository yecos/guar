package androidx.transition;

import android.view.View;

/* loaded from: classes.dex */
public class k0 extends i0 {

    /* renamed from: h, reason: collision with root package name */
    public static boolean f3482h = true;

    @Override // androidx.transition.o0
    public void e(View view, int i10, int i11, int i12, int i13) {
        if (f3482h) {
            try {
                view.setLeftTopRightBottom(i10, i11, i12, i13);
            } catch (NoSuchMethodError unused) {
                f3482h = false;
            }
        }
    }
}
