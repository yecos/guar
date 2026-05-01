package i4;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* loaded from: classes.dex */
public class h extends h4.c {
    @Override // h4.c, h4.d
    public void I(Canvas canvas, Paint paint) {
        super.I(canvas, paint);
    }

    @Override // h4.e
    public ValueAnimator c() {
        float[] fArr = {0.0f, 0.5f, 1.0f};
        return new f4.d(this).j(fArr, 0, -180, -180).k(fArr, 0, 0, -180).c(1200L).d(fArr).b();
    }

    @Override // h4.e, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        v(a(rect));
    }
}
