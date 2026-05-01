package i4;

import android.animation.ValueAnimator;

/* loaded from: classes.dex */
public class g extends h4.a {
    @Override // h4.e
    public ValueAnimator c() {
        float[] fArr = {0.0f, 1.0f};
        return new f4.d(this).l(fArr, 0.0f, 1.0f).a(fArr, 255, 0).c(1000L).d(fArr).b();
    }
}
