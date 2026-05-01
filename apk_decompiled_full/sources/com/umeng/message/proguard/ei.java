package com.umeng.message.proguard;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* loaded from: classes3.dex */
public final class ei extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private final Bitmap f12047a;

    /* renamed from: c, reason: collision with root package name */
    private final BitmapShader f12049c;

    /* renamed from: h, reason: collision with root package name */
    private int f12054h;

    /* renamed from: i, reason: collision with root package name */
    private int f12055i;

    /* renamed from: j, reason: collision with root package name */
    private final int f12056j;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f12048b = new Paint(3);

    /* renamed from: d, reason: collision with root package name */
    private final Matrix f12050d = new Matrix();

    /* renamed from: e, reason: collision with root package name */
    private final Rect f12051e = new Rect();

    /* renamed from: f, reason: collision with root package name */
    private final RectF f12052f = new RectF();

    /* renamed from: g, reason: collision with root package name */
    private boolean f12053g = true;

    public ei(Bitmap bitmap, int i10) {
        this.f12047a = bitmap;
        this.f12056j = i10;
        this.f12054h = bitmap.getWidth();
        this.f12055i = bitmap.getHeight();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.f12049c = new BitmapShader(bitmap, tileMode, tileMode);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Bitmap bitmap = this.f12047a;
        if (bitmap == null) {
            return;
        }
        canvas.getClipBounds(this.f12051e);
        if (this.f12053g) {
            this.f12052f.set(this.f12051e);
            if (this.f12049c != null) {
                Matrix matrix = this.f12050d;
                RectF rectF = this.f12052f;
                matrix.setTranslate(rectF.left, rectF.top);
                int width = this.f12047a.getWidth();
                int height = this.f12047a.getHeight();
                if (width != 0 && height != 0) {
                    this.f12050d.preScale((this.f12051e.width() * 1.0f) / width, (this.f12051e.height() * 1.0f) / height);
                    this.f12049c.setLocalMatrix(this.f12050d);
                    this.f12048b.setShader(this.f12049c);
                }
            }
            this.f12053g = false;
        }
        if (this.f12048b.getShader() == null) {
            canvas.drawBitmap(bitmap, (Rect) null, this.f12051e, this.f12048b);
            return;
        }
        RectF rectF2 = this.f12052f;
        int i10 = this.f12056j;
        canvas.drawRoundRect(rectF2, i10, i10, this.f12048b);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f12048b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.f12048b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f12055i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f12054h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f12053g = true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i10) {
        if (i10 != this.f12048b.getAlpha()) {
            this.f12048b.setAlpha(i10);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f12048b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setDither(boolean z10) {
        this.f12048b.setDither(z10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setFilterBitmap(boolean z10) {
        this.f12048b.setFilterBitmap(z10);
        invalidateSelf();
    }
}
