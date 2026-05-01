package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public class h extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public float f1763a;

    /* renamed from: c, reason: collision with root package name */
    public final RectF f1765c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f1766d;

    /* renamed from: e, reason: collision with root package name */
    public float f1767e;

    /* renamed from: h, reason: collision with root package name */
    public ColorStateList f1770h;

    /* renamed from: i, reason: collision with root package name */
    public PorterDuffColorFilter f1771i;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f1772j;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1768f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1769g = true;

    /* renamed from: k, reason: collision with root package name */
    public PorterDuff.Mode f1773k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f1764b = new Paint(5);

    public h(ColorStateList colorStateList, float f10) {
        this.f1763a = f10;
        e(colorStateList);
        this.f1765c = new RectF();
        this.f1766d = new Rect();
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public ColorStateList b() {
        return this.f1770h;
    }

    public float c() {
        return this.f1767e;
    }

    public float d() {
        return this.f1763a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z10;
        Paint paint = this.f1764b;
        if (this.f1771i == null || paint.getColorFilter() != null) {
            z10 = false;
        } else {
            paint.setColorFilter(this.f1771i);
            z10 = true;
        }
        RectF rectF = this.f1765c;
        float f10 = this.f1763a;
        canvas.drawRoundRect(rectF, f10, f10, paint);
        if (z10) {
            paint.setColorFilter(null);
        }
    }

    public final void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f1770h = colorStateList;
        this.f1764b.setColor(colorStateList.getColorForState(getState(), this.f1770h.getDefaultColor()));
    }

    public void f(ColorStateList colorStateList) {
        e(colorStateList);
        invalidateSelf();
    }

    public void g(float f10, boolean z10, boolean z11) {
        if (f10 == this.f1767e && this.f1768f == z10 && this.f1769g == z11) {
            return;
        }
        this.f1767e = f10;
        this.f1768f = z10;
        this.f1769g = z11;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f1766d, this.f1763a);
    }

    public void h(float f10) {
        if (f10 == this.f1763a) {
            return;
        }
        this.f1763a = f10;
        i(null);
        invalidateSelf();
    }

    public final void i(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f1765c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f1766d.set(rect);
        if (this.f1768f) {
            this.f1766d.inset((int) Math.ceil(i.c(this.f1767e, this.f1763a, this.f1769g)), (int) Math.ceil(i.d(this.f1767e, this.f1763a, this.f1769g)));
            this.f1765c.set(this.f1766d);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f1772j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f1770h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        i(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f1770h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z10 = colorForState != this.f1764b.getColor();
        if (z10) {
            this.f1764b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f1772j;
        if (colorStateList2 == null || (mode = this.f1773k) == null) {
            return z10;
        }
        this.f1771i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f1764b.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1764b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f1772j = colorStateList;
        this.f1771i = a(colorStateList, this.f1773k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f1773k = mode;
        this.f1771i = a(this.f1772j, mode);
        invalidateSelf();
    }
}
