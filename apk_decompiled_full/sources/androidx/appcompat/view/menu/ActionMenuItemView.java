package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.q0;
import androidx.appcompat.widget.t1;
import androidx.appcompat.widget.u2;
import com.google.common.primitives.Ints;

/* loaded from: classes.dex */
public class ActionMenuItemView extends q0 implements n.a, View.OnClickListener, ActionMenuView.a {

    /* renamed from: a, reason: collision with root package name */
    public i f1072a;

    /* renamed from: b, reason: collision with root package name */
    public CharSequence f1073b;

    /* renamed from: c, reason: collision with root package name */
    public Drawable f1074c;

    /* renamed from: d, reason: collision with root package name */
    public g.b f1075d;

    /* renamed from: e, reason: collision with root package name */
    public t1 f1076e;

    /* renamed from: f, reason: collision with root package name */
    public b f1077f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1078g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1079h;

    /* renamed from: i, reason: collision with root package name */
    public int f1080i;

    /* renamed from: j, reason: collision with root package name */
    public int f1081j;

    /* renamed from: k, reason: collision with root package name */
    public int f1082k;

    public class a extends t1 {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.t1
        public p b() {
            b bVar = ActionMenuItemView.this.f1077f;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.t1
        public boolean c() {
            p b10;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            g.b bVar = actionMenuItemView.f1075d;
            return bVar != null && bVar.b(actionMenuItemView.f1072a) && (b10 = b()) != null && b10.isShowing();
        }
    }

    public static abstract class b {
        public abstract p a();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean a() {
        return d();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean b() {
        return d() && this.f1072a.getIcon() == null;
    }

    public boolean d() {
        return !TextUtils.isEmpty(getText());
    }

    public final boolean e() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i10 = configuration.screenWidthDp;
        return i10 >= 480 || (i10 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    public final void f() {
        boolean z10 = true;
        boolean z11 = !TextUtils.isEmpty(this.f1073b);
        if (this.f1074c != null && (!this.f1072a.B() || (!this.f1078g && !this.f1079h))) {
            z10 = false;
        }
        boolean z12 = z11 & z10;
        setText(z12 ? this.f1073b : null);
        CharSequence contentDescription = this.f1072a.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z12 ? null : this.f1072a.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f1072a.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            u2.a(this, z12 ? null : this.f1072a.getTitle());
        } else {
            u2.a(this, tooltipText);
        }
    }

    @Override // androidx.appcompat.view.menu.n.a
    public i getItemData() {
        return this.f1072a;
    }

    @Override // androidx.appcompat.view.menu.n.a
    public void initialize(i iVar, int i10) {
        this.f1072a = iVar;
        setIcon(iVar.getIcon());
        setTitle(iVar.i(this));
        setId(iVar.getItemId());
        setVisibility(iVar.isVisible() ? 0 : 8);
        setEnabled(iVar.isEnabled());
        if (iVar.hasSubMenu() && this.f1076e == null) {
            this.f1076e = new a();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g.b bVar = this.f1075d;
        if (bVar != null) {
            bVar.b(this.f1072a);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1078g = e();
        f();
    }

    @Override // androidx.appcompat.widget.q0, android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        boolean d10 = d();
        if (d10 && (i12 = this.f1081j) >= 0) {
            super.setPadding(i12, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.f1080i) : this.f1080i;
        if (mode != 1073741824 && this.f1080i > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, Ints.MAX_POWER_OF_TWO), i11);
        }
        if (d10 || this.f1074c == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f1074c.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        t1 t1Var;
        if (this.f1072a.hasSubMenu() && (t1Var = this.f1076e) != null && t1Var.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.view.menu.n.a
    public boolean prefersCondensedTitle() {
        return true;
    }

    public void setCheckable(boolean z10) {
    }

    public void setChecked(boolean z10) {
    }

    public void setExpandedFormat(boolean z10) {
        if (this.f1079h != z10) {
            this.f1079h = z10;
            i iVar = this.f1072a;
            if (iVar != null) {
                iVar.c();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f1074c = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i10 = this.f1082k;
            if (intrinsicWidth > i10) {
                intrinsicHeight = (int) (intrinsicHeight * (i10 / intrinsicWidth));
                intrinsicWidth = i10;
            }
            if (intrinsicHeight > i10) {
                intrinsicWidth = (int) (intrinsicWidth * (i10 / intrinsicHeight));
            } else {
                i10 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i10);
        }
        setCompoundDrawables(drawable, null, null, null);
        f();
    }

    public void setItemInvoker(g.b bVar) {
        this.f1075d = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        this.f1081j = i10;
        super.setPadding(i10, i11, i12, i13);
    }

    public void setPopupCallback(b bVar) {
        this.f1077f = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f1073b = charSequence;
        f();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Resources resources = context.getResources();
        this.f1078g = e();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f805c, i10, 0);
        this.f1080i = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.f1082k = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f1081j = -1;
        setSaveEnabled(false);
    }
}
