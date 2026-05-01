package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R$attr;
import com.google.common.primitives.Ints;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class r1 extends ListView {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f1598a;

    /* renamed from: b, reason: collision with root package name */
    public int f1599b;

    /* renamed from: c, reason: collision with root package name */
    public int f1600c;

    /* renamed from: d, reason: collision with root package name */
    public int f1601d;

    /* renamed from: e, reason: collision with root package name */
    public int f1602e;

    /* renamed from: f, reason: collision with root package name */
    public int f1603f;

    /* renamed from: g, reason: collision with root package name */
    public Field f1604g;

    /* renamed from: h, reason: collision with root package name */
    public a f1605h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f1606i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1607j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1608k;

    /* renamed from: l, reason: collision with root package name */
    public b0.a2 f1609l;

    /* renamed from: m, reason: collision with root package name */
    public androidx.core.widget.o f1610m;

    /* renamed from: n, reason: collision with root package name */
    public b f1611n;

    public static class a extends e.m {

        /* renamed from: a, reason: collision with root package name */
        public boolean f1612a;

        public a(Drawable drawable) {
            super(drawable);
            this.f1612a = true;
        }

        public void a(boolean z10) {
            this.f1612a = z10;
        }

        @Override // e.m, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f1612a) {
                super.draw(canvas);
            }
        }

        @Override // e.m, android.graphics.drawable.Drawable
        public void setHotspot(float f10, float f11) {
            if (this.f1612a) {
                super.setHotspot(f10, f11);
            }
        }

        @Override // e.m, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i10, int i11, int i12, int i13) {
            if (this.f1612a) {
                super.setHotspotBounds(i10, i11, i12, i13);
            }
        }

        @Override // e.m, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f1612a) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // e.m, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z10, boolean z11) {
            if (this.f1612a) {
                return super.setVisible(z10, z11);
            }
            return false;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void a() {
            r1 r1Var = r1.this;
            r1Var.f1611n = null;
            r1Var.removeCallbacks(this);
        }

        public void b() {
            r1.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            r1 r1Var = r1.this;
            r1Var.f1611n = null;
            r1Var.drawableStateChanged();
        }
    }

    public r1(Context context, boolean z10) {
        super(context, null, R$attr.dropDownListViewStyle);
        this.f1598a = new Rect();
        this.f1599b = 0;
        this.f1600c = 0;
        this.f1601d = 0;
        this.f1602e = 0;
        this.f1607j = z10;
        setCacheColorHint(0);
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f1604g = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e10) {
            e10.printStackTrace();
        }
    }

    public final void a() {
        this.f1608k = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f1603f - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        b0.a2 a2Var = this.f1609l;
        if (a2Var != null) {
            a2Var.b();
            this.f1609l = null;
        }
    }

    public final void b(View view, int i10) {
        performItemClick(view, i10, getItemIdAtPosition(i10));
    }

    public final void c(Canvas canvas) {
        Drawable selector;
        if (this.f1598a.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.f1598a);
        selector.draw(canvas);
    }

    public int d(int i10, int i11, int i12, int i13, int i14) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i15 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        View view = null;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (i16 < count) {
            int itemViewType = adapter.getItemViewType(i16);
            if (itemViewType != i17) {
                view = null;
                i17 = itemViewType;
            }
            view = adapter.getView(i16, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i19 = layoutParams.height;
            view.measure(i10, i19 > 0 ? View.MeasureSpec.makeMeasureSpec(i19, Ints.MAX_POWER_OF_TWO) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i16 > 0) {
                i15 += dividerHeight;
            }
            i15 += view.getMeasuredHeight();
            if (i15 >= i13) {
                return (i14 < 0 || i16 <= i14 || i18 <= 0 || i15 == i13) ? i13 : i18;
            }
            if (i14 >= 0 && i16 >= i14) {
                i18 = i15;
            }
            i16++;
        }
        return i15;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.f1611n != null) {
            return;
        }
        super.drawableStateChanged();
        j(true);
        l();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
    
        if (r0 != 3) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0048 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean e(android.view.MotionEvent r8, int r9) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L16
            r3 = 2
            if (r0 == r3) goto L14
            r9 = 3
            if (r0 == r9) goto L11
        Le:
            r9 = 0
            r3 = 1
            goto L46
        L11:
            r9 = 0
            r3 = 0
            goto L46
        L14:
            r3 = 1
            goto L17
        L16:
            r3 = 0
        L17:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L1e
            goto L11
        L1e:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L31
            r9 = 1
            goto L46
        L31:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.i(r3, r5, r4, r9)
            if (r0 != r1) goto Le
            r7.b(r3, r5)
            goto Le
        L46:
            if (r3 == 0) goto L4a
            if (r9 == 0) goto L4d
        L4a:
            r7.a()
        L4d:
            if (r3 == 0) goto L65
            androidx.core.widget.o r9 = r7.f1610m
            if (r9 != 0) goto L5a
            androidx.core.widget.o r9 = new androidx.core.widget.o
            r9.<init>(r7)
            r7.f1610m = r9
        L5a:
            androidx.core.widget.o r9 = r7.f1610m
            r9.m(r1)
            androidx.core.widget.o r9 = r7.f1610m
            r9.onTouch(r7, r8)
            goto L6c
        L65:
            androidx.core.widget.o r8 = r7.f1610m
            if (r8 == 0) goto L6c
            r8.m(r2)
        L6c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.r1.e(android.view.MotionEvent, int):boolean");
    }

    public final void f(int i10, View view) {
        Rect rect = this.f1598a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f1599b;
        rect.top -= this.f1600c;
        rect.right += this.f1601d;
        rect.bottom += this.f1602e;
        try {
            boolean z10 = this.f1604g.getBoolean(this);
            if (view.isEnabled() != z10) {
                this.f1604g.set(this, Boolean.valueOf(!z10));
                if (i10 != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
        }
    }

    public final void g(int i10, View view) {
        Drawable selector = getSelector();
        boolean z10 = (selector == null || i10 == -1) ? false : true;
        if (z10) {
            selector.setVisible(false, false);
        }
        f(i10, view);
        if (z10) {
            Rect rect = this.f1598a;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            s.h.k(selector, exactCenterX, exactCenterY);
        }
    }

    public final void h(int i10, View view, float f10, float f11) {
        g(i10, view);
        Drawable selector = getSelector();
        if (selector == null || i10 == -1) {
            return;
        }
        s.h.k(selector, f10, f11);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f1607j || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f1607j || super.hasWindowFocus();
    }

    public final void i(View view, int i10, float f10, float f11) {
        View childAt;
        this.f1608k = true;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 21) {
            drawableHotspotChanged(f10, f11);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i12 = this.f1603f;
        if (i12 != -1 && (childAt = getChildAt(i12 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f1603f = i10;
        float left = f10 - view.getLeft();
        float top = f11 - view.getTop();
        if (i11 >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        h(i10, view, f10, f11);
        j(false);
        refreshDrawableState();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f1607j || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.f1607j && this.f1606i) || super.isInTouchMode();
    }

    public final void j(boolean z10) {
        a aVar = this.f1605h;
        if (aVar != null) {
            aVar.a(z10);
        }
    }

    public final boolean k() {
        return this.f1608k;
    }

    public final void l() {
        Drawable selector = getSelector();
        if (selector != null && k() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f1611n = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f1611n == null) {
            b bVar = new b();
            this.f1611n = bVar;
            bVar.b();
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (pointToPosition != -1 && pointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                }
                l();
            }
        } else {
            setSelection(-1);
        }
        return onHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f1603f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        b bVar = this.f1611n;
        if (bVar != null) {
            bVar.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z10) {
        this.f1606i = z10;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        a aVar = drawable != null ? new a(drawable) : null;
        this.f1605h = aVar;
        super.setSelector(aVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f1599b = rect.left;
        this.f1600c = rect.top;
        this.f1601d = rect.right;
        this.f1602e = rect.bottom;
    }
}
