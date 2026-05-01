package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;

/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public boolean f1273a;

    /* renamed from: b, reason: collision with root package name */
    public View f1274b;

    /* renamed from: c, reason: collision with root package name */
    public View f1275c;

    /* renamed from: d, reason: collision with root package name */
    public View f1276d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f1277e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f1278f;

    /* renamed from: g, reason: collision with root package name */
    public Drawable f1279g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1280h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f1281i;

    /* renamed from: j, reason: collision with root package name */
    public int f1282j;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b0.c1.o0(this, new b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f803a);
        this.f1277e = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_background);
        this.f1278f = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundStacked);
        this.f1282j = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_height, -1);
        boolean z10 = true;
        if (getId() == R$id.split_action_bar) {
            this.f1280h = true;
            this.f1279g = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        if (!this.f1280h ? this.f1277e != null || this.f1278f != null : this.f1279g != null) {
            z10 = false;
        }
        setWillNotDraw(z10);
    }

    public final int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public final boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f1277e;
        if (drawable != null && drawable.isStateful()) {
            this.f1277e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f1278f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f1278f.setState(getDrawableState());
        }
        Drawable drawable3 = this.f1279g;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f1279g.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f1274b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1277e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f1278f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f1279g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1275c = findViewById(R$id.action_bar);
        this.f1276d = findViewById(R$id.action_context_bar);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f1273a || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        Drawable drawable;
        super.onLayout(z10, i10, i11, i12, i13);
        View view = this.f1274b;
        boolean z11 = true;
        boolean z12 = false;
        boolean z13 = (view == null || view.getVisibility() == 8) ? false : true;
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            int measuredHeight2 = measuredHeight - view.getMeasuredHeight();
            int i14 = layoutParams.bottomMargin;
            view.layout(i10, measuredHeight2 - i14, i12, measuredHeight - i14);
        }
        if (this.f1280h) {
            Drawable drawable2 = this.f1279g;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z11 = false;
            }
        } else {
            if (this.f1277e != null) {
                if (this.f1275c.getVisibility() == 0) {
                    this.f1277e.setBounds(this.f1275c.getLeft(), this.f1275c.getTop(), this.f1275c.getRight(), this.f1275c.getBottom());
                } else {
                    View view2 = this.f1276d;
                    if (view2 == null || view2.getVisibility() != 0) {
                        this.f1277e.setBounds(0, 0, 0, 0);
                    } else {
                        this.f1277e.setBounds(this.f1276d.getLeft(), this.f1276d.getTop(), this.f1276d.getRight(), this.f1276d.getBottom());
                    }
                }
                z12 = true;
            }
            this.f1281i = z13;
            if (!z13 || (drawable = this.f1278f) == null) {
                z11 = z12;
            } else {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
        if (z11) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        if (this.f1275c == null && View.MeasureSpec.getMode(i11) == Integer.MIN_VALUE && (i12 = this.f1282j) >= 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(Math.min(i12, View.MeasureSpec.getSize(i11)), Integer.MIN_VALUE);
        }
        super.onMeasure(i10, i11);
        if (this.f1275c == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i11);
        View view = this.f1274b;
        if (view == null || view.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min((!b(this.f1275c) ? a(this.f1275c) : !b(this.f1276d) ? a(this.f1276d) : 0) + a(this.f1274b), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i11) : Integer.MAX_VALUE));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f1277e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f1277e);
        }
        this.f1277e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f1275c;
            if (view != null) {
                this.f1277e.setBounds(view.getLeft(), this.f1275c.getTop(), this.f1275c.getRight(), this.f1275c.getBottom());
            }
        }
        boolean z10 = true;
        if (!this.f1280h ? this.f1277e != null || this.f1278f != null : this.f1279g != null) {
            z10 = false;
        }
        setWillNotDraw(z10);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1279g;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f1279g);
        }
        this.f1279g = drawable;
        boolean z10 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1280h && (drawable2 = this.f1279g) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f1280h ? !(this.f1277e != null || this.f1278f != null) : this.f1279g == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1278f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f1278f);
        }
        this.f1278f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1281i && (drawable2 = this.f1278f) != null) {
                drawable2.setBounds(this.f1274b.getLeft(), this.f1274b.getTop(), this.f1274b.getRight(), this.f1274b.getBottom());
            }
        }
        boolean z10 = true;
        if (!this.f1280h ? this.f1277e != null || this.f1278f != null : this.f1279g != null) {
            z10 = false;
        }
        setWillNotDraw(z10);
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setTabContainer(j2 j2Var) {
        View view = this.f1274b;
        if (view != null) {
            removeView(view);
        }
        this.f1274b = j2Var;
    }

    public void setTransitioning(boolean z10) {
        this.f1273a = z10;
        setDescendantFocusability(z10 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z10 = i10 == 0;
        Drawable drawable = this.f1277e;
        if (drawable != null) {
            drawable.setVisible(z10, false);
        }
        Drawable drawable2 = this.f1278f;
        if (drawable2 != null) {
            drawable2.setVisible(z10, false);
        }
        Drawable drawable3 = this.f1279g;
        if (drawable3 != null) {
            drawable3.setVisible(z10, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f1277e && !this.f1280h) || (drawable == this.f1278f && this.f1281i) || ((drawable == this.f1279g && this.f1280h) || super.verifyDrawable(drawable));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i10) {
        if (i10 != 0) {
            return super.startActionModeForChild(view, callback, i10);
        }
        return null;
    }
}
