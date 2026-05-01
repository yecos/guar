package h4;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;

/* loaded from: classes.dex */
public abstract class d extends e {
    public Paint E;
    public int F;
    public int G;

    public d() {
        Paint paint = new Paint();
        this.E = paint;
        paint.setAntiAlias(true);
        this.E.setColor(-1);
    }

    public abstract void I(Canvas canvas, Paint paint);

    public final void J() {
        int alpha = getAlpha();
        int i10 = this.G;
        this.F = ((((i10 >>> 24) * (alpha + (alpha >> 7))) >> 8) << 24) | ((i10 << 8) >>> 8);
    }

    @Override // h4.e
    public final void b(Canvas canvas) {
        this.E.setColor(this.F);
        I(canvas, this.E);
    }

    @Override // h4.e, android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        super.setAlpha(i10);
        J();
    }

    @Override // h4.e, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.E.setColorFilter(colorFilter);
    }

    @Override // h4.e
    public void t(int i10) {
        this.G = i10;
        J();
    }
}
