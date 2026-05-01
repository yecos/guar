package com.mobile.brasiltv.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* loaded from: classes3.dex */
public final class FixGifStateDrawable extends Drawable {
    private final Drawable normalDrawable;
    private final Drawable selectDrawable;

    public FixGifStateDrawable(Drawable drawable, Drawable drawable2) {
        t9.i.g(drawable, "normalDrawable");
        t9.i.g(drawable2, "selectDrawable");
        this.normalDrawable = drawable;
        this.selectDrawable = drawable2;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        t9.i.g(canvas, "canvas");
    }

    public final Drawable getNormalDrawable() {
        return this.normalDrawable;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    public final Drawable getSelectDrawable() {
        return this.selectDrawable;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
