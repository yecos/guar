package androidx.appcompat.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.OverScroller;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.view.menu.m;

/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements h1, b0.z, b0.x, b0.y {
    public static final int[] B = {R$attr.actionBarSize, R.attr.windowContentOverlay};
    public final b0.a0 A;

    /* renamed from: a, reason: collision with root package name */
    public int f1296a;

    /* renamed from: b, reason: collision with root package name */
    public int f1297b;

    /* renamed from: c, reason: collision with root package name */
    public ContentFrameLayout f1298c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarContainer f1299d;

    /* renamed from: e, reason: collision with root package name */
    public i1 f1300e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f1301f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1302g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1303h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f1304i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1305j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1306k;

    /* renamed from: l, reason: collision with root package name */
    public int f1307l;

    /* renamed from: m, reason: collision with root package name */
    public int f1308m;

    /* renamed from: n, reason: collision with root package name */
    public final Rect f1309n;

    /* renamed from: o, reason: collision with root package name */
    public final Rect f1310o;

    /* renamed from: p, reason: collision with root package name */
    public final Rect f1311p;

    /* renamed from: q, reason: collision with root package name */
    public final Rect f1312q;

    /* renamed from: r, reason: collision with root package name */
    public final Rect f1313r;

    /* renamed from: s, reason: collision with root package name */
    public final Rect f1314s;

    /* renamed from: t, reason: collision with root package name */
    public final Rect f1315t;

    /* renamed from: u, reason: collision with root package name */
    public d f1316u;

    /* renamed from: v, reason: collision with root package name */
    public OverScroller f1317v;

    /* renamed from: w, reason: collision with root package name */
    public ViewPropertyAnimator f1318w;

    /* renamed from: x, reason: collision with root package name */
    public final AnimatorListenerAdapter f1319x;

    /* renamed from: y, reason: collision with root package name */
    public final Runnable f1320y;

    /* renamed from: z, reason: collision with root package name */
    public final Runnable f1321z;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f1318w = null;
            actionBarOverlayLayout.f1306k = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f1318w = null;
            actionBarOverlayLayout.f1306k = false;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.o();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f1318w = actionBarOverlayLayout.f1299d.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.f1319x);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.o();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f1318w = actionBarOverlayLayout.f1299d.animate().translationY(-ActionBarOverlayLayout.this.f1299d.getHeight()).setListener(ActionBarOverlayLayout.this.f1319x);
        }
    }

    public interface d {
        void a();

        void b(int i10);

        void c();

        void d(boolean z10);

        void e();

        void f();
    }

    public static class e extends ViewGroup.MarginLayoutParams {
        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(int i10, int i11) {
            super(i10, i11);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1297b = 0;
        this.f1309n = new Rect();
        this.f1310o = new Rect();
        this.f1311p = new Rect();
        this.f1312q = new Rect();
        this.f1313r = new Rect();
        this.f1314s = new Rect();
        this.f1315t = new Rect();
        this.f1319x = new a();
        this.f1320y = new b();
        this.f1321z = new c();
        p(context);
        this.A = new b0.a0(this);
    }

    @Override // androidx.appcompat.widget.h1
    public boolean a() {
        t();
        return this.f1300e.a();
    }

    @Override // androidx.appcompat.widget.h1
    public boolean b() {
        t();
        return this.f1300e.b();
    }

    @Override // androidx.appcompat.widget.h1
    public boolean c() {
        t();
        return this.f1300e.c();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // androidx.appcompat.widget.h1
    public void d(Menu menu, m.a aVar) {
        t();
        this.f1300e.d(menu, aVar);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1301f == null || this.f1302g) {
            return;
        }
        int bottom = this.f1299d.getVisibility() == 0 ? (int) (this.f1299d.getBottom() + this.f1299d.getTranslationY() + 0.5f) : 0;
        this.f1301f.setBounds(0, bottom, getWidth(), this.f1301f.getIntrinsicHeight() + bottom);
        this.f1301f.draw(canvas);
    }

    @Override // androidx.appcompat.widget.h1
    public boolean e() {
        t();
        return this.f1300e.e();
    }

    @Override // androidx.appcompat.widget.h1
    public void f() {
        t();
        this.f1300e.f();
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        t();
        b0.c1.J(this);
        boolean k10 = k(this.f1299d, rect, true, true, false, true);
        this.f1312q.set(rect);
        y2.a(this, this.f1312q, this.f1309n);
        if (!this.f1313r.equals(this.f1312q)) {
            this.f1313r.set(this.f1312q);
            k10 = true;
        }
        if (!this.f1310o.equals(this.f1309n)) {
            this.f1310o.set(this.f1309n);
            k10 = true;
        }
        if (k10) {
            requestLayout();
        }
        return true;
    }

    @Override // androidx.appcompat.widget.h1
    public boolean g() {
        t();
        return this.f1300e.g();
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f1299d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.A.a();
    }

    public CharSequence getTitle() {
        t();
        return this.f1300e.getTitle();
    }

    @Override // androidx.appcompat.widget.h1
    public void h(int i10) {
        t();
        if (i10 == 2) {
            this.f1300e.p();
        } else if (i10 == 5) {
            this.f1300e.y();
        } else {
            if (i10 != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    @Override // androidx.appcompat.widget.h1
    public void i() {
        t();
        this.f1300e.r();
    }

    public final void j() {
        o();
        this.f1321z.run();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean k(android.view.View r3, android.graphics.Rect r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        /*
            r2 = this;
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.ActionBarOverlayLayout$e r3 = (androidx.appcompat.widget.ActionBarOverlayLayout.e) r3
            r0 = 1
            if (r5 == 0) goto L13
            int r5 = r3.leftMargin
            int r1 = r4.left
            if (r5 == r1) goto L13
            r3.leftMargin = r1
            r5 = 1
            goto L14
        L13:
            r5 = 0
        L14:
            if (r6 == 0) goto L1f
            int r6 = r3.topMargin
            int r1 = r4.top
            if (r6 == r1) goto L1f
            r3.topMargin = r1
            r5 = 1
        L1f:
            if (r8 == 0) goto L2a
            int r6 = r3.rightMargin
            int r8 = r4.right
            if (r6 == r8) goto L2a
            r3.rightMargin = r8
            r5 = 1
        L2a:
            if (r7 == 0) goto L35
            int r6 = r3.bottomMargin
            int r4 = r4.bottom
            if (r6 == r4) goto L35
            r3.bottomMargin = r4
            goto L36
        L35:
            r0 = r5
        L36:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.k(android.view.View, android.graphics.Rect, boolean, boolean, boolean, boolean):boolean");
    }

    @Override // android.view.ViewGroup
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.ViewGroup
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final i1 n(View view) {
        if (view instanceof i1) {
            return (i1) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void o() {
        removeCallbacks(this.f1320y);
        removeCallbacks(this.f1321z);
        ViewPropertyAnimator viewPropertyAnimator = this.f1318w;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        p(getContext());
        b0.c1.h0(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        o();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i15 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i16 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
                childAt.layout(i15, i16, measuredWidth + i15, measuredHeight + i16);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int measuredHeight;
        t();
        measureChildWithMargins(this.f1299d, i10, 0, i11, 0);
        e eVar = (e) this.f1299d.getLayoutParams();
        int max = Math.max(0, this.f1299d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin);
        int max2 = Math.max(0, this.f1299d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f1299d.getMeasuredState());
        boolean z10 = (b0.c1.J(this) & 256) != 0;
        if (z10) {
            measuredHeight = this.f1296a;
            if (this.f1304i && this.f1299d.getTabContainer() != null) {
                measuredHeight += this.f1296a;
            }
        } else {
            measuredHeight = this.f1299d.getVisibility() != 8 ? this.f1299d.getMeasuredHeight() : 0;
        }
        this.f1311p.set(this.f1309n);
        this.f1314s.set(this.f1312q);
        if (this.f1303h || z10) {
            Rect rect = this.f1314s;
            rect.top += measuredHeight;
            rect.bottom += 0;
        } else {
            Rect rect2 = this.f1311p;
            rect2.top += measuredHeight;
            rect2.bottom += 0;
        }
        k(this.f1298c, this.f1311p, true, true, true, true);
        if (!this.f1315t.equals(this.f1314s)) {
            this.f1315t.set(this.f1314s);
            this.f1298c.a(this.f1314s);
        }
        measureChildWithMargins(this.f1298c, i10, 0, i11, 0);
        e eVar2 = (e) this.f1298c.getLayoutParams();
        int max3 = Math.max(max, this.f1298c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar2).leftMargin + ((ViewGroup.MarginLayoutParams) eVar2).rightMargin);
        int max4 = Math.max(max2, this.f1298c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f1298c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i10, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i11, combineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, b0.z
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        if (!this.f1305j || !z10) {
            return false;
        }
        if (v(f10, f11)) {
            j();
        } else {
            u();
        }
        this.f1306k = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, b0.z
    public boolean onNestedPreFling(View view, float f10, float f11) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, b0.z
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
    }

    @Override // b0.y
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        onNestedScroll(view, i10, i11, i12, i13, i14);
    }

    @Override // b0.x
    public void onNestedScrollAccepted(View view, View view2, int i10, int i11) {
        if (i11 == 0) {
            onNestedScrollAccepted(view, view2, i10);
        }
    }

    @Override // b0.x
    public boolean onStartNestedScroll(View view, View view2, int i10, int i11) {
        return i11 == 0 && onStartNestedScroll(view, view2, i10);
    }

    @Override // b0.x
    public void onStopNestedScroll(View view, int i10) {
        if (i10 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i10) {
        super.onWindowSystemUiVisibilityChanged(i10);
        t();
        int i11 = this.f1308m ^ i10;
        this.f1308m = i10;
        boolean z10 = (i10 & 4) == 0;
        boolean z11 = (i10 & 256) != 0;
        d dVar = this.f1316u;
        if (dVar != null) {
            dVar.d(!z11);
            if (z10 || !z11) {
                this.f1316u.a();
            } else {
                this.f1316u.e();
            }
        }
        if ((i11 & 256) == 0 || this.f1316u == null) {
            return;
        }
        b0.c1.h0(this);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        this.f1297b = i10;
        d dVar = this.f1316u;
        if (dVar != null) {
            dVar.b(i10);
        }
    }

    public final void p(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(B);
        this.f1296a = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f1301f = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        this.f1302g = context.getApplicationInfo().targetSdkVersion < 19;
        this.f1317v = new OverScroller(context);
    }

    public boolean q() {
        return this.f1303h;
    }

    public final void r() {
        o();
        postDelayed(this.f1321z, 600L);
    }

    public final void s() {
        o();
        postDelayed(this.f1320y, 600L);
    }

    public void setActionBarHideOffset(int i10) {
        o();
        this.f1299d.setTranslationY(-Math.max(0, Math.min(i10, this.f1299d.getHeight())));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.f1316u = dVar;
        if (getWindowToken() != null) {
            this.f1316u.b(this.f1297b);
            int i10 = this.f1308m;
            if (i10 != 0) {
                onWindowSystemUiVisibilityChanged(i10);
                b0.c1.h0(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z10) {
        this.f1304i = z10;
    }

    public void setHideOnContentScrollEnabled(boolean z10) {
        if (z10 != this.f1305j) {
            this.f1305j = z10;
            if (z10) {
                return;
            }
            o();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i10) {
        t();
        this.f1300e.setIcon(i10);
    }

    public void setLogo(int i10) {
        t();
        this.f1300e.t(i10);
    }

    public void setOverlayMode(boolean z10) {
        this.f1303h = z10;
        this.f1302g = z10 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z10) {
    }

    public void setUiOptions(int i10) {
    }

    @Override // androidx.appcompat.widget.h1
    public void setWindowCallback(Window.Callback callback) {
        t();
        this.f1300e.setWindowCallback(callback);
    }

    @Override // androidx.appcompat.widget.h1
    public void setWindowTitle(CharSequence charSequence) {
        t();
        this.f1300e.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void t() {
        if (this.f1298c == null) {
            this.f1298c = (ContentFrameLayout) findViewById(R$id.action_bar_activity_content);
            this.f1299d = (ActionBarContainer) findViewById(R$id.action_bar_container);
            this.f1300e = n(findViewById(R$id.action_bar));
        }
    }

    public final void u() {
        o();
        this.f1320y.run();
    }

    public final boolean v(float f10, float f11) {
        this.f1317v.fling(0, 0, 0, (int) f11, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.f1317v.getFinalY() > this.f1299d.getHeight();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    @Override // b0.x
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr, int i12) {
        if (i12 == 0) {
            onNestedPreScroll(view, i10, i11, iArr);
        }
    }

    @Override // b0.x
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14) {
        if (i14 == 0) {
            onNestedScroll(view, i10, i11, i12, i13);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, b0.z
    public void onNestedScrollAccepted(View view, View view2, int i10) {
        this.A.b(view, view2, i10);
        this.f1307l = getActionBarHideOffset();
        o();
        d dVar = this.f1316u;
        if (dVar != null) {
            dVar.f();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, b0.z
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        if ((i10 & 2) == 0 || this.f1299d.getVisibility() != 0) {
            return false;
        }
        return this.f1305j;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, b0.z
    public void onStopNestedScroll(View view) {
        if (this.f1305j && !this.f1306k) {
            if (this.f1307l <= this.f1299d.getHeight()) {
                s();
            } else {
                r();
            }
        }
        d dVar = this.f1316u;
        if (dVar != null) {
            dVar.c();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, b0.z
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        int i14 = this.f1307l + i11;
        this.f1307l = i14;
        setActionBarHideOffset(i14);
    }

    public void setIcon(Drawable drawable) {
        t();
        this.f1300e.setIcon(drawable);
    }
}
