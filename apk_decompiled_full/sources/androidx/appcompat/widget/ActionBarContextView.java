package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import com.google.common.primitives.Ints;

/* loaded from: classes.dex */
public class ActionBarContextView extends androidx.appcompat.widget.a {

    /* renamed from: i, reason: collision with root package name */
    public CharSequence f1283i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f1284j;

    /* renamed from: k, reason: collision with root package name */
    public View f1285k;

    /* renamed from: l, reason: collision with root package name */
    public View f1286l;

    /* renamed from: m, reason: collision with root package name */
    public LinearLayout f1287m;

    /* renamed from: n, reason: collision with root package name */
    public TextView f1288n;

    /* renamed from: o, reason: collision with root package name */
    public TextView f1289o;

    /* renamed from: p, reason: collision with root package name */
    public int f1290p;

    /* renamed from: q, reason: collision with root package name */
    public int f1291q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f1292r;

    /* renamed from: s, reason: collision with root package name */
    public int f1293s;

    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.b f1294a;

        public a(g.b bVar) {
            this.f1294a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f1294a.a();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ b0.a2 f(int i10, long j10) {
        return super.f(i10, j10);
    }

    public void g() {
        if (this.f1285k == null) {
            k();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f1284j;
    }

    public CharSequence getTitle() {
        return this.f1283i;
    }

    public void h(g.b bVar) {
        View view = this.f1285k;
        if (view == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.f1293s, (ViewGroup) this, false);
            this.f1285k = inflate;
            addView(inflate);
        } else if (view.getParent() == null) {
            addView(this.f1285k);
        }
        this.f1285k.findViewById(R$id.action_mode_close_button).setOnClickListener(new a(bVar));
        androidx.appcompat.view.menu.g gVar = (androidx.appcompat.view.menu.g) bVar.c();
        d dVar = this.f1428d;
        if (dVar != null) {
            dVar.p();
        }
        d dVar2 = new d(getContext());
        this.f1428d = dVar2;
        dVar2.A(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        gVar.addMenuPresenter(this.f1428d, this.f1426b);
        ActionMenuView actionMenuView = (ActionMenuView) this.f1428d.g(this);
        this.f1427c = actionMenuView;
        b0.c1.o0(actionMenuView, null);
        addView(this.f1427c, layoutParams);
    }

    public final void i() {
        if (this.f1287m == null) {
            LayoutInflater.from(getContext()).inflate(R$layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f1287m = linearLayout;
            this.f1288n = (TextView) linearLayout.findViewById(R$id.action_bar_title);
            this.f1289o = (TextView) this.f1287m.findViewById(R$id.action_bar_subtitle);
            if (this.f1290p != 0) {
                this.f1288n.setTextAppearance(getContext(), this.f1290p);
            }
            if (this.f1291q != 0) {
                this.f1289o.setTextAppearance(getContext(), this.f1291q);
            }
        }
        this.f1288n.setText(this.f1283i);
        this.f1289o.setText(this.f1284j);
        boolean z10 = !TextUtils.isEmpty(this.f1283i);
        boolean z11 = !TextUtils.isEmpty(this.f1284j);
        int i10 = 0;
        this.f1289o.setVisibility(z11 ? 0 : 8);
        LinearLayout linearLayout2 = this.f1287m;
        if (!z10 && !z11) {
            i10 = 8;
        }
        linearLayout2.setVisibility(i10);
        if (this.f1287m.getParent() == null) {
            addView(this.f1287m);
        }
    }

    public boolean j() {
        return this.f1292r;
    }

    public void k() {
        removeAllViews();
        this.f1286l = null;
        this.f1427c = null;
    }

    public boolean l() {
        d dVar = this.f1428d;
        if (dVar != null) {
            return dVar.B();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d dVar = this.f1428d;
        if (dVar != null) {
            dVar.s();
            this.f1428d.t();
        }
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() != 32) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            return;
        }
        accessibilityEvent.setSource(this);
        accessibilityEvent.setClassName(getClass().getName());
        accessibilityEvent.setPackageName(getContext().getPackageName());
        accessibilityEvent.setContentDescription(this.f1283i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        boolean b10 = y2.b(this);
        int paddingRight = b10 ? (i12 - i10) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i13 - i11) - getPaddingTop()) - getPaddingBottom();
        View view = this.f1285k;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1285k.getLayoutParams();
            int i14 = b10 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i15 = b10 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int d10 = androidx.appcompat.widget.a.d(paddingRight, i14, b10);
            paddingRight = androidx.appcompat.widget.a.d(d10 + e(this.f1285k, d10, paddingTop, paddingTop2, b10), i15, b10);
        }
        int i16 = paddingRight;
        LinearLayout linearLayout = this.f1287m;
        if (linearLayout != null && this.f1286l == null && linearLayout.getVisibility() != 8) {
            i16 += e(this.f1287m, i16, paddingTop, paddingTop2, b10);
        }
        int i17 = i16;
        View view2 = this.f1286l;
        if (view2 != null) {
            e(view2, i17, paddingTop, paddingTop2, b10);
        }
        int paddingLeft = b10 ? getPaddingLeft() : (i12 - i10) - getPaddingRight();
        ActionMenuView actionMenuView = this.f1427c;
        if (actionMenuView != null) {
            e(actionMenuView, paddingLeft, paddingTop, paddingTop2, !b10);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int i12 = Ints.MAX_POWER_OF_TWO;
        if (mode != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i11) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i10);
        int i13 = this.f1429e;
        if (i13 <= 0) {
            i13 = View.MeasureSpec.getSize(i11);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int i14 = i13 - paddingTop;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i14, Integer.MIN_VALUE);
        View view = this.f1285k;
        if (view != null) {
            int c10 = c(view, paddingLeft, makeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1285k.getLayoutParams();
            paddingLeft = c10 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f1427c;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = c(this.f1427c, paddingLeft, makeMeasureSpec, 0);
        }
        LinearLayout linearLayout = this.f1287m;
        if (linearLayout != null && this.f1286l == null) {
            if (this.f1292r) {
                this.f1287m.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                int measuredWidth = this.f1287m.getMeasuredWidth();
                boolean z10 = measuredWidth <= paddingLeft;
                if (z10) {
                    paddingLeft -= measuredWidth;
                }
                this.f1287m.setVisibility(z10 ? 0 : 8);
            } else {
                paddingLeft = c(linearLayout, paddingLeft, makeMeasureSpec, 0);
            }
        }
        View view2 = this.f1286l;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i15 = layoutParams.width;
            int i16 = i15 != -2 ? Ints.MAX_POWER_OF_TWO : Integer.MIN_VALUE;
            if (i15 >= 0) {
                paddingLeft = Math.min(i15, paddingLeft);
            }
            int i17 = layoutParams.height;
            if (i17 == -2) {
                i12 = Integer.MIN_VALUE;
            }
            if (i17 >= 0) {
                i14 = Math.min(i17, i14);
            }
            this.f1286l.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i16), View.MeasureSpec.makeMeasureSpec(i14, i12));
        }
        if (this.f1429e > 0) {
            setMeasuredDimension(size, i13);
            return;
        }
        int childCount = getChildCount();
        int i18 = 0;
        for (int i19 = 0; i19 < childCount; i19++) {
            int measuredHeight = getChildAt(i19).getMeasuredHeight() + paddingTop;
            if (measuredHeight > i18) {
                i18 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i18);
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.a
    public void setContentHeight(int i10) {
        this.f1429e = i10;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f1286l;
        if (view2 != null) {
            removeView(view2);
        }
        this.f1286l = view;
        if (view != null && (linearLayout = this.f1287m) != null) {
            removeView(linearLayout);
            this.f1287m = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1284j = charSequence;
        i();
    }

    public void setTitle(CharSequence charSequence) {
        this.f1283i = charSequence;
        i();
    }

    public void setTitleOptional(boolean z10) {
        if (z10 != this.f1292r) {
            requestLayout();
        }
        this.f1292r = z10;
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i10) {
        super.setVisibility(i10);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        r2 u10 = r2.u(context, attributeSet, R$styleable.f807e, i10, 0);
        b0.c1.o0(this, u10.g(R$styleable.ActionMode_background));
        this.f1290p = u10.n(R$styleable.ActionMode_titleTextStyle, 0);
        this.f1291q = u10.n(R$styleable.ActionMode_subtitleTextStyle, 0);
        this.f1429e = u10.m(R$styleable.ActionMode_height, 0);
        this.f1293s = u10.n(R$styleable.ActionMode_closeItemLayout, R$layout.abc_action_mode_close_item_material);
        u10.v();
    }
}
