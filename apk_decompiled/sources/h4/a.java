package h4;

import android.graphics.Canvas;
import android.graphics.Paint;

/* loaded from: classes.dex */
public abstract class a extends d {
    @Override // h4.d
    public void I(Canvas canvas, Paint paint) {
        if (d() != null) {
            canvas.drawCircle(d().centerX(), d().centerY(), Math.min(d().width(), d().height()) / 2, paint);
        }
    }
}
