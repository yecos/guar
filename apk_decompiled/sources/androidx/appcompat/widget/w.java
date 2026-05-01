package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R$styleable;

/* loaded from: classes.dex */
public class w extends t {

    /* renamed from: d, reason: collision with root package name */
    public final SeekBar f1671d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f1672e;

    /* renamed from: f, reason: collision with root package name */
    public ColorStateList f1673f;

    /* renamed from: g, reason: collision with root package name */
    public PorterDuff.Mode f1674g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1675h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f1676i;

    public w(SeekBar seekBar) {
        super(seekBar);
        this.f1673f = null;
        this.f1674g = null;
        this.f1675h = false;
        this.f1676i = false;
        this.f1671d = seekBar;
    }

    @Override // androidx.appcompat.widget.t
    public void c(AttributeSet attributeSet, int i10) {
        super.c(attributeSet, i10);
        r2 u10 = r2.u(this.f1671d.getContext(), attributeSet, R$styleable.f814l, i10, 0);
        Drawable h10 = u10.h(R$styleable.AppCompatSeekBar_android_thumb);
        if (h10 != null) {
            this.f1671d.setThumb(h10);
        }
        j(u10.g(R$styleable.AppCompatSeekBar_tickMark));
        int i11 = R$styleable.AppCompatSeekBar_tickMarkTintMode;
        if (u10.r(i11)) {
            this.f1674g = o1.e(u10.k(i11, -1), this.f1674g);
            this.f1676i = true;
        }
        int i12 = R$styleable.AppCompatSeekBar_tickMarkTint;
        if (u10.r(i12)) {
            this.f1673f = u10.c(i12);
            this.f1675h = true;
        }
        u10.v();
        f();
    }

    public final void f() {
        Drawable drawable = this.f1672e;
        if (drawable != null) {
            if (this.f1675h || this.f1676i) {
                Drawable r10 = s.h.r(drawable.mutate());
                this.f1672e = r10;
                if (this.f1675h) {
                    s.h.o(r10, this.f1673f);
                }
                if (this.f1676i) {
                    s.h.p(this.f1672e, this.f1674g);
                }
                if (this.f1672e.isStateful()) {
                    this.f1672e.setState(this.f1671d.getDrawableState());
                }
            }
        }
    }

    public void g(Canvas canvas) {
        if (this.f1672e != null) {
            int max = this.f1671d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f1672e.getIntrinsicWidth();
                int intrinsicHeight = this.f1672e.getIntrinsicHeight();
                int i10 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i11 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f1672e.setBounds(-i10, -i11, i10, i11);
                float width = ((this.f1671d.getWidth() - this.f1671d.getPaddingLeft()) - this.f1671d.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(this.f1671d.getPaddingLeft(), this.f1671d.getHeight() / 2);
                for (int i12 = 0; i12 <= max; i12++) {
                    this.f1672e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    public void h() {
        Drawable drawable = this.f1672e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f1671d.getDrawableState())) {
            this.f1671d.invalidateDrawable(drawable);
        }
    }

    public void i() {
        Drawable drawable = this.f1672e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public void j(Drawable drawable) {
        Drawable drawable2 = this.f1672e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1672e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f1671d);
            s.h.m(drawable, b0.c1.z(this.f1671d));
            if (drawable.isStateful()) {
                drawable.setState(this.f1671d.getDrawableState());
            }
            f();
        }
        this.f1671d.invalidate();
    }
}
