package h4;

import android.graphics.Canvas;
import android.graphics.Rect;

/* loaded from: classes.dex */
public abstract class b extends f {
    @Override // h4.f
    public void I(Canvas canvas) {
        for (int i10 = 0; i10 < K(); i10++) {
            e J = J(i10);
            int save = canvas.save();
            canvas.rotate((i10 * 360) / K(), getBounds().centerX(), getBounds().centerY());
            J.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    @Override // h4.f, h4.e, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        Rect a10 = a(rect);
        double width = a10.width();
        Double.isNaN(width);
        double K = K();
        Double.isNaN(K);
        int i10 = (int) (((width * 3.141592653589793d) / 3.5999999046325684d) / K);
        int centerX = a10.centerX() - i10;
        int centerX2 = a10.centerX() + i10;
        for (int i11 = 0; i11 < K(); i11++) {
            e J = J(i11);
            int i12 = a10.top;
            J.u(centerX, i12, centerX2, (i10 * 2) + i12);
        }
    }
}
