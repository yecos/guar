package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.cardview.R$color;
import androidx.cardview.R$dimen;

/* loaded from: classes.dex */
public class i extends Drawable {

    /* renamed from: q, reason: collision with root package name */
    public static final double f1774q = Math.cos(Math.toRadians(45.0d));

    /* renamed from: r, reason: collision with root package name */
    public static a f1775r;

    /* renamed from: a, reason: collision with root package name */
    public final int f1776a;

    /* renamed from: c, reason: collision with root package name */
    public Paint f1778c;

    /* renamed from: d, reason: collision with root package name */
    public Paint f1779d;

    /* renamed from: e, reason: collision with root package name */
    public final RectF f1780e;

    /* renamed from: f, reason: collision with root package name */
    public float f1781f;

    /* renamed from: g, reason: collision with root package name */
    public Path f1782g;

    /* renamed from: h, reason: collision with root package name */
    public float f1783h;

    /* renamed from: i, reason: collision with root package name */
    public float f1784i;

    /* renamed from: j, reason: collision with root package name */
    public float f1785j;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f1786k;

    /* renamed from: m, reason: collision with root package name */
    public final int f1788m;

    /* renamed from: n, reason: collision with root package name */
    public final int f1789n;

    /* renamed from: l, reason: collision with root package name */
    public boolean f1787l = true;

    /* renamed from: o, reason: collision with root package name */
    public boolean f1790o = true;

    /* renamed from: p, reason: collision with root package name */
    public boolean f1791p = false;

    /* renamed from: b, reason: collision with root package name */
    public Paint f1777b = new Paint(5);

    public interface a {
        void a(Canvas canvas, RectF rectF, float f10, Paint paint);
    }

    public i(Resources resources, ColorStateList colorStateList, float f10, float f11, float f12) {
        this.f1788m = resources.getColor(R$color.cardview_shadow_start_color);
        this.f1789n = resources.getColor(R$color.cardview_shadow_end_color);
        this.f1776a = resources.getDimensionPixelSize(R$dimen.cardview_compat_inset_shadow);
        n(colorStateList);
        Paint paint = new Paint(5);
        this.f1778c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f1781f = (int) (f10 + 0.5f);
        this.f1780e = new RectF();
        Paint paint2 = new Paint(this.f1778c);
        this.f1779d = paint2;
        paint2.setAntiAlias(false);
        s(f11, f12);
    }

    public static float c(float f10, float f11, boolean z10) {
        if (!z10) {
            return f10;
        }
        double d10 = f10;
        double d11 = 1.0d - f1774q;
        double d12 = f11;
        Double.isNaN(d12);
        Double.isNaN(d10);
        return (float) (d10 + (d11 * d12));
    }

    public static float d(float f10, float f11, boolean z10) {
        if (!z10) {
            return f10 * 1.5f;
        }
        double d10 = f10 * 1.5f;
        double d11 = 1.0d - f1774q;
        double d12 = f11;
        Double.isNaN(d12);
        Double.isNaN(d10);
        return (float) (d10 + (d11 * d12));
    }

    public final void a(Rect rect) {
        float f10 = this.f1783h;
        float f11 = 1.5f * f10;
        this.f1780e.set(rect.left + f10, rect.top + f11, rect.right - f10, rect.bottom - f11);
        b();
    }

    public final void b() {
        float f10 = this.f1781f;
        RectF rectF = new RectF(-f10, -f10, f10, f10);
        RectF rectF2 = new RectF(rectF);
        float f11 = this.f1784i;
        rectF2.inset(-f11, -f11);
        Path path = this.f1782g;
        if (path == null) {
            this.f1782g = new Path();
        } else {
            path.reset();
        }
        this.f1782g.setFillType(Path.FillType.EVEN_ODD);
        this.f1782g.moveTo(-this.f1781f, 0.0f);
        this.f1782g.rLineTo(-this.f1784i, 0.0f);
        this.f1782g.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f1782g.arcTo(rectF, 270.0f, -90.0f, false);
        this.f1782g.close();
        float f12 = this.f1781f;
        float f13 = f12 / (this.f1784i + f12);
        Paint paint = this.f1778c;
        float f14 = this.f1781f + this.f1784i;
        int i10 = this.f1788m;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f14, new int[]{i10, i10, this.f1789n}, new float[]{0.0f, f13, 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.f1779d;
        float f15 = this.f1781f;
        float f16 = this.f1784i;
        float f17 = (-f15) + f16;
        float f18 = (-f15) - f16;
        int i11 = this.f1788m;
        paint2.setShader(new LinearGradient(0.0f, f17, 0.0f, f18, new int[]{i11, i11, this.f1789n}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f1779d.setAntiAlias(false);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f1787l) {
            a(getBounds());
            this.f1787l = false;
        }
        canvas.translate(0.0f, this.f1785j / 2.0f);
        e(canvas);
        canvas.translate(0.0f, (-this.f1785j) / 2.0f);
        f1775r.a(canvas, this.f1780e, this.f1781f, this.f1777b);
    }

    public final void e(Canvas canvas) {
        float f10 = this.f1781f;
        float f11 = (-f10) - this.f1784i;
        float f12 = f10 + this.f1776a + (this.f1785j / 2.0f);
        float f13 = f12 * 2.0f;
        boolean z10 = this.f1780e.width() - f13 > 0.0f;
        boolean z11 = this.f1780e.height() - f13 > 0.0f;
        int save = canvas.save();
        RectF rectF = this.f1780e;
        canvas.translate(rectF.left + f12, rectF.top + f12);
        canvas.drawPath(this.f1782g, this.f1778c);
        if (z10) {
            canvas.drawRect(0.0f, f11, this.f1780e.width() - f13, -this.f1781f, this.f1779d);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        RectF rectF2 = this.f1780e;
        canvas.translate(rectF2.right - f12, rectF2.bottom - f12);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f1782g, this.f1778c);
        if (z10) {
            canvas.drawRect(0.0f, f11, this.f1780e.width() - f13, (-this.f1781f) + this.f1784i, this.f1779d);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        RectF rectF3 = this.f1780e;
        canvas.translate(rectF3.left + f12, rectF3.bottom - f12);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f1782g, this.f1778c);
        if (z11) {
            canvas.drawRect(0.0f, f11, this.f1780e.height() - f13, -this.f1781f, this.f1779d);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF4 = this.f1780e;
        canvas.translate(rectF4.right - f12, rectF4.top + f12);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f1782g, this.f1778c);
        if (z11) {
            canvas.drawRect(0.0f, f11, this.f1780e.height() - f13, -this.f1781f, this.f1779d);
        }
        canvas.restoreToCount(save4);
    }

    public ColorStateList f() {
        return this.f1786k;
    }

    public float g() {
        return this.f1781f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil(d(this.f1783h, this.f1781f, this.f1790o));
        int ceil2 = (int) Math.ceil(c(this.f1783h, this.f1781f, this.f1790o));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public void h(Rect rect) {
        getPadding(rect);
    }

    public float i() {
        return this.f1783h;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f1786k;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    public float j() {
        float f10 = this.f1783h;
        return (Math.max(f10, this.f1781f + this.f1776a + ((f10 * 1.5f) / 2.0f)) * 2.0f) + (((this.f1783h * 1.5f) + this.f1776a) * 2.0f);
    }

    public float k() {
        float f10 = this.f1783h;
        return (Math.max(f10, this.f1781f + this.f1776a + (f10 / 2.0f)) * 2.0f) + ((this.f1783h + this.f1776a) * 2.0f);
    }

    public float l() {
        return this.f1785j;
    }

    public void m(boolean z10) {
        this.f1790o = z10;
        invalidateSelf();
    }

    public final void n(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f1786k = colorStateList;
        this.f1777b.setColor(colorStateList.getColorForState(getState(), this.f1786k.getDefaultColor()));
    }

    public void o(ColorStateList colorStateList) {
        n(colorStateList);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f1787l = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.f1786k;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f1777b.getColor() == colorForState) {
            return false;
        }
        this.f1777b.setColor(colorForState);
        this.f1787l = true;
        invalidateSelf();
        return true;
    }

    public void p(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("Invalid radius " + f10 + ". Must be >= 0");
        }
        float f11 = (int) (f10 + 0.5f);
        if (this.f1781f == f11) {
            return;
        }
        this.f1781f = f11;
        this.f1787l = true;
        invalidateSelf();
    }

    public void q(float f10) {
        s(this.f1785j, f10);
    }

    public void r(float f10) {
        s(f10, this.f1783h);
    }

    public final void s(float f10, float f11) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f10 + ". Must be >= 0");
        }
        if (f11 < 0.0f) {
            throw new IllegalArgumentException("Invalid max shadow size " + f11 + ". Must be >= 0");
        }
        float t10 = t(f10);
        float t11 = t(f11);
        if (t10 > t11) {
            if (!this.f1791p) {
                this.f1791p = true;
            }
            t10 = t11;
        }
        if (this.f1785j == t10 && this.f1783h == t11) {
            return;
        }
        this.f1785j = t10;
        this.f1783h = t11;
        this.f1784i = (int) ((t10 * 1.5f) + this.f1776a + 0.5f);
        this.f1787l = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f1777b.setAlpha(i10);
        this.f1778c.setAlpha(i10);
        this.f1779d.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1777b.setColorFilter(colorFilter);
    }

    public final int t(float f10) {
        int i10 = (int) (f10 + 0.5f);
        return i10 % 2 == 1 ? i10 - 1 : i10;
    }
}
