package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R$styleable;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public final ImageView f1567a;

    /* renamed from: b, reason: collision with root package name */
    public p2 f1568b;

    /* renamed from: c, reason: collision with root package name */
    public p2 f1569c;

    /* renamed from: d, reason: collision with root package name */
    public p2 f1570d;

    public p(ImageView imageView) {
        this.f1567a = imageView;
    }

    public final boolean a(Drawable drawable) {
        if (this.f1570d == null) {
            this.f1570d = new p2();
        }
        p2 p2Var = this.f1570d;
        p2Var.a();
        ColorStateList a10 = androidx.core.widget.n.a(this.f1567a);
        if (a10 != null) {
            p2Var.f1593d = true;
            p2Var.f1590a = a10;
        }
        PorterDuff.Mode b10 = androidx.core.widget.n.b(this.f1567a);
        if (b10 != null) {
            p2Var.f1592c = true;
            p2Var.f1591b = b10;
        }
        if (!p2Var.f1593d && !p2Var.f1592c) {
            return false;
        }
        k.i(drawable, p2Var, this.f1567a.getDrawableState());
        return true;
    }

    public void b() {
        Drawable drawable = this.f1567a.getDrawable();
        if (drawable != null) {
            o1.b(drawable);
        }
        if (drawable != null) {
            if (j() && a(drawable)) {
                return;
            }
            p2 p2Var = this.f1569c;
            if (p2Var != null) {
                k.i(drawable, p2Var, this.f1567a.getDrawableState());
                return;
            }
            p2 p2Var2 = this.f1568b;
            if (p2Var2 != null) {
                k.i(drawable, p2Var2, this.f1567a.getDrawableState());
            }
        }
    }

    public ColorStateList c() {
        p2 p2Var = this.f1569c;
        if (p2Var != null) {
            return p2Var.f1590a;
        }
        return null;
    }

    public PorterDuff.Mode d() {
        p2 p2Var = this.f1569c;
        if (p2Var != null) {
            return p2Var.f1591b;
        }
        return null;
    }

    public boolean e() {
        return Build.VERSION.SDK_INT < 21 || !o.a(this.f1567a.getBackground());
    }

    public void f(AttributeSet attributeSet, int i10) {
        int n10;
        r2 u10 = r2.u(this.f1567a.getContext(), attributeSet, R$styleable.f813k, i10, 0);
        try {
            Drawable drawable = this.f1567a.getDrawable();
            if (drawable == null && (n10 = u10.n(R$styleable.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = d.b.d(this.f1567a.getContext(), n10)) != null) {
                this.f1567a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                o1.b(drawable);
            }
            int i11 = R$styleable.AppCompatImageView_tint;
            if (u10.r(i11)) {
                androidx.core.widget.n.c(this.f1567a, u10.c(i11));
            }
            int i12 = R$styleable.AppCompatImageView_tintMode;
            if (u10.r(i12)) {
                androidx.core.widget.n.d(this.f1567a, o1.e(u10.k(i12, -1), null));
            }
        } finally {
            u10.v();
        }
    }

    public void g(int i10) {
        if (i10 != 0) {
            Drawable d10 = d.b.d(this.f1567a.getContext(), i10);
            if (d10 != null) {
                o1.b(d10);
            }
            this.f1567a.setImageDrawable(d10);
        } else {
            this.f1567a.setImageDrawable(null);
        }
        b();
    }

    public void h(ColorStateList colorStateList) {
        if (this.f1569c == null) {
            this.f1569c = new p2();
        }
        p2 p2Var = this.f1569c;
        p2Var.f1590a = colorStateList;
        p2Var.f1593d = true;
        b();
    }

    public void i(PorterDuff.Mode mode) {
        if (this.f1569c == null) {
            this.f1569c = new p2();
        }
        p2 p2Var = this.f1569c;
        p2Var.f1591b = mode;
        p2Var.f1592c = true;
        b();
    }

    public final boolean j() {
        int i10 = Build.VERSION.SDK_INT;
        return i10 > 21 ? this.f1568b != null : i10 == 21;
    }
}
