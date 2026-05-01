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
public final class au extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private final Bitmap f11563a;

    /* renamed from: c, reason: collision with root package name */
    private final BitmapShader f11565c;

    /* renamed from: h, reason: collision with root package name */
    private final int f11570h;

    /* renamed from: i, reason: collision with root package name */
    private final int f11571i;

    /* renamed from: j, reason: collision with root package name */
    private final int f11572j;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f11564b = new Paint(3);

    /* renamed from: d, reason: collision with root package name */
    private final Matrix f11566d = new Matrix();

    /* renamed from: e, reason: collision with root package name */
    private final Rect f11567e = new Rect();

    /* renamed from: f, reason: collision with root package name */
    private final RectF f11568f = new RectF();

    /* renamed from: g, reason: collision with root package name */
    private boolean f11569g = true;

    public au(Bitmap bitmap, int i10) {
        this.f11563a = bitmap;
        this.f11572j = i10;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.f11565c = new BitmapShader(bitmap, tileMode, tileMode);
        this.f11570h = bitmap.getWidth();
        this.f11571i = bitmap.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Bitmap bitmap;
        if (canvas == null || (bitmap = this.f11563a) == null) {
            return;
        }
        canvas.getClipBounds(this.f11567e);
        if (this.f11569g) {
            this.f11568f.set(this.f11567e);
            if (this.f11565c != null) {
                Matrix matrix = this.f11566d;
                RectF rectF = this.f11568f;
                matrix.setTranslate(rectF.left, rectF.top);
                int width = this.f11563a.getWidth();
                int height = this.f11563a.getHeight();
                if (width != 0 && height != 0) {
                    this.f11566d.preScale((this.f11567e.width() * 1.0f) / width, (this.f11567e.height() * 1.0f) / height);
                    this.f11565c.setLocalMatrix(this.f11566d);
                    this.f11564b.setShader(this.f11565c);
                }
            }
            this.f11569g = false;
        }
        if (this.f11564b.getShader() == null) {
            canvas.drawBitmap(bitmap, (Rect) null, this.f11567e, this.f11564b);
            return;
        }
        RectF rectF2 = this.f11568f;
        int i10 = this.f11572j;
        canvas.drawRoundRect(rectF2, i10, i10, this.f11564b);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f11564b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.f11564b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f11571i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f11570h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f11569g = true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i10) {
        if (i10 != this.f11564b.getAlpha()) {
            this.f11564b.setAlpha(i10);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f11564b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setDither(boolean z10) {
        this.f11564b.setDither(z10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setFilterBitmap(boolean z10) {
        this.f11564b.setFilterBitmap(z10);
        invalidateSelf();
    }
}
