package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.ViewGroup;
import androidx.appcompat.R$styleable;
import g.b;

/* loaded from: classes.dex */
public abstract class a {

    public static abstract class b {
    }

    public boolean g() {
        return false;
    }

    public abstract boolean h();

    public abstract void i(boolean z10);

    public abstract int j();

    public abstract Context k();

    public boolean l() {
        return false;
    }

    public void m(Configuration configuration) {
    }

    public void n() {
    }

    public abstract boolean o(int i10, KeyEvent keyEvent);

    public boolean p(KeyEvent keyEvent) {
        return false;
    }

    public boolean q() {
        return false;
    }

    public abstract void r(boolean z10);

    public abstract void s(boolean z10);

    public abstract void t(int i10);

    public abstract void u(boolean z10);

    public abstract void v(CharSequence charSequence);

    public abstract void w(CharSequence charSequence);

    public abstract void x(CharSequence charSequence);

    public g.b y(b.a aVar) {
        return null;
    }

    /* renamed from: androidx.appcompat.app.a$a, reason: collision with other inner class name */
    public static class C0015a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f913a;

        public C0015a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f913a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f804b);
            this.f913a = obtainStyledAttributes.getInt(R$styleable.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public C0015a(int i10, int i11) {
            super(i10, i11);
            this.f913a = 8388627;
        }

        public C0015a(C0015a c0015a) {
            super((ViewGroup.MarginLayoutParams) c0015a);
            this.f913a = 0;
            this.f913a = c0015a.f913a;
        }

        public C0015a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f913a = 0;
        }
    }
}
