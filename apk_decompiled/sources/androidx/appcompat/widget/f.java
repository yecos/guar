package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R$styleable;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public final View f1494a;

    /* renamed from: d, reason: collision with root package name */
    public p2 f1497d;

    /* renamed from: e, reason: collision with root package name */
    public p2 f1498e;

    /* renamed from: f, reason: collision with root package name */
    public p2 f1499f;

    /* renamed from: c, reason: collision with root package name */
    public int f1496c = -1;

    /* renamed from: b, reason: collision with root package name */
    public final k f1495b = k.b();

    public f(View view) {
        this.f1494a = view;
    }

    public final boolean a(Drawable drawable) {
        if (this.f1499f == null) {
            this.f1499f = new p2();
        }
        p2 p2Var = this.f1499f;
        p2Var.a();
        ColorStateList q10 = b0.c1.q(this.f1494a);
        if (q10 != null) {
            p2Var.f1593d = true;
            p2Var.f1590a = q10;
        }
        PorterDuff.Mode r10 = b0.c1.r(this.f1494a);
        if (r10 != null) {
            p2Var.f1592c = true;
            p2Var.f1591b = r10;
        }
        if (!p2Var.f1593d && !p2Var.f1592c) {
            return false;
        }
        k.i(drawable, p2Var, this.f1494a.getDrawableState());
        return true;
    }

    public void b() {
        Drawable background = this.f1494a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            p2 p2Var = this.f1498e;
            if (p2Var != null) {
                k.i(background, p2Var, this.f1494a.getDrawableState());
                return;
            }
            p2 p2Var2 = this.f1497d;
            if (p2Var2 != null) {
                k.i(background, p2Var2, this.f1494a.getDrawableState());
            }
        }
    }

    public ColorStateList c() {
        p2 p2Var = this.f1498e;
        if (p2Var != null) {
            return p2Var.f1590a;
        }
        return null;
    }

    public PorterDuff.Mode d() {
        p2 p2Var = this.f1498e;
        if (p2Var != null) {
            return p2Var.f1591b;
        }
        return null;
    }

    public void e(AttributeSet attributeSet, int i10) {
        r2 u10 = r2.u(this.f1494a.getContext(), attributeSet, R$styleable.O, i10, 0);
        try {
            int i11 = R$styleable.ViewBackgroundHelper_android_background;
            if (u10.r(i11)) {
                this.f1496c = u10.n(i11, -1);
                ColorStateList f10 = this.f1495b.f(this.f1494a.getContext(), this.f1496c);
                if (f10 != null) {
                    h(f10);
                }
            }
            int i12 = R$styleable.ViewBackgroundHelper_backgroundTint;
            if (u10.r(i12)) {
                b0.c1.p0(this.f1494a, u10.c(i12));
            }
            int i13 = R$styleable.ViewBackgroundHelper_backgroundTintMode;
            if (u10.r(i13)) {
                b0.c1.q0(this.f1494a, o1.e(u10.k(i13, -1), null));
            }
        } finally {
            u10.v();
        }
    }

    public void f(Drawable drawable) {
        this.f1496c = -1;
        h(null);
        b();
    }

    public void g(int i10) {
        this.f1496c = i10;
        k kVar = this.f1495b;
        h(kVar != null ? kVar.f(this.f1494a.getContext(), i10) : null);
        b();
    }

    public void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1497d == null) {
                this.f1497d = new p2();
            }
            p2 p2Var = this.f1497d;
            p2Var.f1590a = colorStateList;
            p2Var.f1593d = true;
        } else {
            this.f1497d = null;
        }
        b();
    }

    public void i(ColorStateList colorStateList) {
        if (this.f1498e == null) {
            this.f1498e = new p2();
        }
        p2 p2Var = this.f1498e;
        p2Var.f1590a = colorStateList;
        p2Var.f1593d = true;
        b();
    }

    public void j(PorterDuff.Mode mode) {
        if (this.f1498e == null) {
            this.f1498e = new p2();
        }
        p2 p2Var = this.f1498e;
        p2Var.f1591b = mode;
        p2Var.f1592c = true;
        b();
    }

    public final boolean k() {
        int i10 = Build.VERSION.SDK_INT;
        return i10 > 21 ? this.f1497d != null : i10 == 21;
    }
}
