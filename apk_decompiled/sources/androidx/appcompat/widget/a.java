package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;

/* loaded from: classes.dex */
public abstract class a extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public final C0018a f1425a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f1426b;

    /* renamed from: c, reason: collision with root package name */
    public ActionMenuView f1427c;

    /* renamed from: d, reason: collision with root package name */
    public d f1428d;

    /* renamed from: e, reason: collision with root package name */
    public int f1429e;

    /* renamed from: f, reason: collision with root package name */
    public b0.a2 f1430f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1431g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1432h;

    /* renamed from: androidx.appcompat.widget.a$a, reason: collision with other inner class name */
    public class C0018a implements b0.b2 {

        /* renamed from: a, reason: collision with root package name */
        public boolean f1433a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f1434b;

        public C0018a() {
        }

        @Override // b0.b2
        public void a(View view) {
            this.f1433a = true;
        }

        @Override // b0.b2
        public void b(View view) {
            if (this.f1433a) {
                return;
            }
            a aVar = a.this;
            aVar.f1430f = null;
            a.super.setVisibility(this.f1434b);
        }

        @Override // b0.b2
        public void c(View view) {
            a.super.setVisibility(0);
            this.f1433a = false;
        }

        public C0018a d(b0.a2 a2Var, int i10) {
            a.this.f1430f = a2Var;
            this.f1434b = i10;
            return this;
        }
    }

    public a(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f1425a = new C0018a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R$attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f1426b = context;
        } else {
            this.f1426b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    public static int d(int i10, int i11, boolean z10) {
        return z10 ? i10 - i11 : i10 + i11;
    }

    public int c(View view, int i10, int i11, int i12) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i10, Integer.MIN_VALUE), i11);
        return Math.max(0, (i10 - view.getMeasuredWidth()) - i12);
    }

    public int e(View view, int i10, int i11, int i12, boolean z10) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i13 = i11 + ((i12 - measuredHeight) / 2);
        if (z10) {
            view.layout(i10 - measuredWidth, i13, i10, measuredHeight + i13);
        } else {
            view.layout(i10, i13, i10 + measuredWidth, measuredHeight + i13);
        }
        return z10 ? -measuredWidth : measuredWidth;
    }

    public b0.a2 f(int i10, long j10) {
        b0.a2 a2Var = this.f1430f;
        if (a2Var != null) {
            a2Var.b();
        }
        if (i10 != 0) {
            b0.a2 a10 = b0.c1.c(this).a(0.0f);
            a10.d(j10);
            a10.f(this.f1425a.d(a10, i10));
            return a10;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        b0.a2 a11 = b0.c1.c(this).a(1.0f);
        a11.d(j10);
        a11.f(this.f1425a.d(a11, i10));
        return a11;
    }

    public int getAnimatedVisibility() {
        return this.f1430f != null ? this.f1425a.f1434b : getVisibility();
    }

    public int getContentHeight() {
        return this.f1429e;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, R$styleable.f803a, R$attr.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(R$styleable.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        d dVar = this.f1428d;
        if (dVar != null) {
            dVar.w(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1432h = false;
        }
        if (!this.f1432h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f1432h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1432h = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1431g = false;
        }
        if (!this.f1431g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f1431g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1431g = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i10);

    @Override // android.view.View
    public void setVisibility(int i10) {
        if (i10 != getVisibility()) {
            b0.a2 a2Var = this.f1430f;
            if (a2Var != null) {
                a2Var.b();
            }
            super.setVisibility(i10);
        }
    }
}
