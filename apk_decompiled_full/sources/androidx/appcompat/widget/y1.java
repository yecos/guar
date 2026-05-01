package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import com.google.common.primitives.Ints;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class y1 implements androidx.appcompat.view.menu.p {
    public static Method H;
    public static Method I;
    public static Method J;
    public final c A;
    public Runnable B;
    public final Handler C;
    public final Rect D;
    public Rect E;
    public boolean F;
    public PopupWindow G;

    /* renamed from: a, reason: collision with root package name */
    public Context f1710a;

    /* renamed from: b, reason: collision with root package name */
    public ListAdapter f1711b;

    /* renamed from: c, reason: collision with root package name */
    public r1 f1712c;

    /* renamed from: d, reason: collision with root package name */
    public int f1713d;

    /* renamed from: e, reason: collision with root package name */
    public int f1714e;

    /* renamed from: f, reason: collision with root package name */
    public int f1715f;

    /* renamed from: g, reason: collision with root package name */
    public int f1716g;

    /* renamed from: h, reason: collision with root package name */
    public int f1717h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f1718i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1719j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1720k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f1721l;

    /* renamed from: m, reason: collision with root package name */
    public int f1722m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f1723n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f1724o;

    /* renamed from: p, reason: collision with root package name */
    public int f1725p;

    /* renamed from: q, reason: collision with root package name */
    public View f1726q;

    /* renamed from: r, reason: collision with root package name */
    public int f1727r;

    /* renamed from: s, reason: collision with root package name */
    public DataSetObserver f1728s;

    /* renamed from: t, reason: collision with root package name */
    public View f1729t;

    /* renamed from: u, reason: collision with root package name */
    public Drawable f1730u;

    /* renamed from: v, reason: collision with root package name */
    public AdapterView.OnItemClickListener f1731v;

    /* renamed from: w, reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f1732w;

    /* renamed from: x, reason: collision with root package name */
    public final g f1733x;

    /* renamed from: y, reason: collision with root package name */
    public final f f1734y;

    /* renamed from: z, reason: collision with root package name */
    public final e f1735z;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View q10 = y1.this.q();
            if (q10 == null || q10.getWindowToken() == null) {
                return;
            }
            y1.this.show();
        }
    }

    public class b implements AdapterView.OnItemSelectedListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i10, long j10) {
            r1 r1Var;
            if (i10 == -1 || (r1Var = y1.this.f1712c) == null) {
                return;
            }
            r1Var.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            y1.this.o();
        }
    }

    public class d extends DataSetObserver {
        public d() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (y1.this.isShowing()) {
                y1.this.show();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            y1.this.dismiss();
        }
    }

    public class e implements AbsListView.OnScrollListener {
        public e() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i10) {
            if (i10 != 1 || y1.this.t() || y1.this.G.getContentView() == null) {
                return;
            }
            y1 y1Var = y1.this;
            y1Var.C.removeCallbacks(y1Var.f1733x);
            y1.this.f1733x.run();
        }
    }

    public class f implements View.OnTouchListener {
        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = y1.this.G) != null && popupWindow.isShowing() && x10 >= 0 && x10 < y1.this.G.getWidth() && y10 >= 0 && y10 < y1.this.G.getHeight()) {
                y1 y1Var = y1.this;
                y1Var.C.postDelayed(y1Var.f1733x, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            y1 y1Var2 = y1.this;
            y1Var2.C.removeCallbacks(y1Var2.f1733x);
            return false;
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            r1 r1Var = y1.this.f1712c;
            if (r1Var == null || !b0.c1.P(r1Var) || y1.this.f1712c.getCount() <= y1.this.f1712c.getChildCount()) {
                return;
            }
            int childCount = y1.this.f1712c.getChildCount();
            y1 y1Var = y1.this;
            if (childCount <= y1Var.f1725p) {
                y1Var.G.setInputMethodMode(2);
                y1.this.show();
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                H = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
            }
            try {
                J = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                I = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
            }
        }
    }

    public y1(Context context) {
        this(context, null, R$attr.listPopupWindowStyle);
    }

    public void A(Rect rect) {
        this.E = rect != null ? new Rect(rect) : null;
    }

    public void B(int i10) {
        this.G.setInputMethodMode(i10);
    }

    public void C(boolean z10) {
        this.F = z10;
        this.G.setFocusable(z10);
    }

    public void D(PopupWindow.OnDismissListener onDismissListener) {
        this.G.setOnDismissListener(onDismissListener);
    }

    public void E(AdapterView.OnItemClickListener onItemClickListener) {
        this.f1731v = onItemClickListener;
    }

    public void F(boolean z10) {
        this.f1721l = true;
        this.f1720k = z10;
    }

    public final void G(boolean z10) {
        if (Build.VERSION.SDK_INT > 28) {
            this.G.setIsClippedToScreen(z10);
            return;
        }
        Method method = H;
        if (method != null) {
            try {
                method.invoke(this.G, Boolean.valueOf(z10));
            } catch (Exception unused) {
            }
        }
    }

    public void H(int i10) {
        this.f1727r = i10;
    }

    public void I(int i10) {
        r1 r1Var = this.f1712c;
        if (!isShowing() || r1Var == null) {
            return;
        }
        r1Var.setListSelectionHidden(false);
        r1Var.setSelection(i10);
        if (r1Var.getChoiceMode() != 0) {
            r1Var.setItemChecked(i10, true);
        }
    }

    public void J(int i10) {
        this.f1714e = i10;
    }

    public int a() {
        return this.f1715f;
    }

    public void c(int i10) {
        this.f1715f = i10;
    }

    @Override // androidx.appcompat.view.menu.p
    public void dismiss() {
        this.G.dismiss();
        v();
        this.G.setContentView(null);
        this.f1712c = null;
        this.C.removeCallbacks(this.f1733x);
    }

    public Drawable e() {
        return this.G.getBackground();
    }

    public void g(int i10) {
        this.f1716g = i10;
        this.f1718i = true;
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean isShowing() {
        return this.G.isShowing();
    }

    public int j() {
        if (this.f1718i) {
            return this.f1716g;
        }
        return 0;
    }

    public void k(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f1728s;
        if (dataSetObserver == null) {
            this.f1728s = new d();
        } else {
            ListAdapter listAdapter2 = this.f1711b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f1711b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f1728s);
        }
        r1 r1Var = this.f1712c;
        if (r1Var != null) {
            r1Var.setAdapter(this.f1711b);
        }
    }

    @Override // androidx.appcompat.view.menu.p
    public ListView m() {
        return this.f1712c;
    }

    public final int n() {
        int i10;
        int i11;
        int makeMeasureSpec;
        int i12;
        if (this.f1712c == null) {
            Context context = this.f1710a;
            this.B = new a();
            r1 p10 = p(context, !this.F);
            this.f1712c = p10;
            Drawable drawable = this.f1730u;
            if (drawable != null) {
                p10.setSelector(drawable);
            }
            this.f1712c.setAdapter(this.f1711b);
            this.f1712c.setOnItemClickListener(this.f1731v);
            this.f1712c.setFocusable(true);
            this.f1712c.setFocusableInTouchMode(true);
            this.f1712c.setOnItemSelectedListener(new b());
            this.f1712c.setOnScrollListener(this.f1735z);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f1732w;
            if (onItemSelectedListener != null) {
                this.f1712c.setOnItemSelectedListener(onItemSelectedListener);
            }
            View view = this.f1712c;
            View view2 = this.f1726q;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i13 = this.f1727r;
                if (i13 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(view, layoutParams);
                } else if (i13 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.f1727r);
                } else {
                    linearLayout.addView(view, layoutParams);
                    linearLayout.addView(view2);
                }
                int i14 = this.f1714e;
                if (i14 >= 0) {
                    i12 = Integer.MIN_VALUE;
                } else {
                    i14 = 0;
                    i12 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i14, i12), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                i10 = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                i10 = 0;
            }
            this.G.setContentView(view);
        } else {
            View view3 = this.f1726q;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                i10 = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                i10 = 0;
            }
        }
        Drawable background = this.G.getBackground();
        if (background != null) {
            background.getPadding(this.D);
            Rect rect = this.D;
            int i15 = rect.top;
            i11 = rect.bottom + i15;
            if (!this.f1718i) {
                this.f1716g = -i15;
            }
        } else {
            this.D.setEmpty();
            i11 = 0;
        }
        int r10 = r(q(), this.f1716g, this.G.getInputMethodMode() == 2);
        if (this.f1723n || this.f1713d == -1) {
            return r10 + i11;
        }
        int i16 = this.f1714e;
        if (i16 == -2) {
            int i17 = this.f1710a.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.D;
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i17 - (rect2.left + rect2.right), Integer.MIN_VALUE);
        } else if (i16 != -1) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i16, Ints.MAX_POWER_OF_TWO);
        } else {
            int i18 = this.f1710a.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.D;
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i18 - (rect3.left + rect3.right), Ints.MAX_POWER_OF_TWO);
        }
        int d10 = this.f1712c.d(makeMeasureSpec, 0, -1, r10 - i10, -1);
        if (d10 > 0) {
            i10 += i11 + this.f1712c.getPaddingTop() + this.f1712c.getPaddingBottom();
        }
        return d10 + i10;
    }

    public void o() {
        r1 r1Var = this.f1712c;
        if (r1Var != null) {
            r1Var.setListSelectionHidden(true);
            r1Var.requestLayout();
        }
    }

    public r1 p(Context context, boolean z10) {
        return new r1(context, z10);
    }

    public View q() {
        return this.f1729t;
    }

    public final int r(View view, int i10, boolean z10) {
        int maxAvailableHeight;
        if (Build.VERSION.SDK_INT > 23) {
            maxAvailableHeight = this.G.getMaxAvailableHeight(view, i10, z10);
            return maxAvailableHeight;
        }
        Method method = I;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.G, view, Integer.valueOf(i10), Boolean.valueOf(z10))).intValue();
            } catch (Exception unused) {
            }
        }
        return this.G.getMaxAvailableHeight(view, i10);
    }

    public int s() {
        return this.f1714e;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.G.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.view.menu.p
    public void show() {
        int n10 = n();
        boolean t10 = t();
        androidx.core.widget.t.b(this.G, this.f1717h);
        if (this.G.isShowing()) {
            if (b0.c1.P(q())) {
                int i10 = this.f1714e;
                if (i10 == -1) {
                    i10 = -1;
                } else if (i10 == -2) {
                    i10 = q().getWidth();
                }
                int i11 = this.f1713d;
                if (i11 == -1) {
                    if (!t10) {
                        n10 = -1;
                    }
                    if (t10) {
                        this.G.setWidth(this.f1714e == -1 ? -1 : 0);
                        this.G.setHeight(0);
                    } else {
                        this.G.setWidth(this.f1714e == -1 ? -1 : 0);
                        this.G.setHeight(-1);
                    }
                } else if (i11 != -2) {
                    n10 = i11;
                }
                this.G.setOutsideTouchable((this.f1724o || this.f1723n) ? false : true);
                this.G.update(q(), this.f1715f, this.f1716g, i10 < 0 ? -1 : i10, n10 < 0 ? -1 : n10);
                return;
            }
            return;
        }
        int i12 = this.f1714e;
        if (i12 == -1) {
            i12 = -1;
        } else if (i12 == -2) {
            i12 = q().getWidth();
        }
        int i13 = this.f1713d;
        if (i13 == -1) {
            n10 = -1;
        } else if (i13 != -2) {
            n10 = i13;
        }
        this.G.setWidth(i12);
        this.G.setHeight(n10);
        G(true);
        this.G.setOutsideTouchable((this.f1724o || this.f1723n) ? false : true);
        this.G.setTouchInterceptor(this.f1734y);
        if (this.f1721l) {
            androidx.core.widget.t.a(this.G, this.f1720k);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = J;
            if (method != null) {
                try {
                    method.invoke(this.G, this.E);
                } catch (Exception e10) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e10);
                }
            }
        } else {
            this.G.setEpicenterBounds(this.E);
        }
        androidx.core.widget.t.c(this.G, q(), this.f1715f, this.f1716g, this.f1722m);
        this.f1712c.setSelection(-1);
        if (!this.F || this.f1712c.isInTouchMode()) {
            o();
        }
        if (this.F) {
            return;
        }
        this.C.post(this.A);
    }

    public boolean t() {
        return this.G.getInputMethodMode() == 2;
    }

    public boolean u() {
        return this.F;
    }

    public final void v() {
        View view = this.f1726q;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f1726q);
            }
        }
    }

    public void w(View view) {
        this.f1729t = view;
    }

    public void x(int i10) {
        this.G.setAnimationStyle(i10);
    }

    public void y(int i10) {
        Drawable background = this.G.getBackground();
        if (background == null) {
            J(i10);
            return;
        }
        background.getPadding(this.D);
        Rect rect = this.D;
        this.f1714e = rect.left + rect.right + i10;
    }

    public void z(int i10) {
        this.f1722m = i10;
    }

    public y1(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public y1(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f1713d = -2;
        this.f1714e = -2;
        this.f1717h = 1002;
        this.f1719j = true;
        this.f1722m = 0;
        this.f1723n = false;
        this.f1724o = false;
        this.f1725p = Integer.MAX_VALUE;
        this.f1727r = 0;
        this.f1733x = new g();
        this.f1734y = new f();
        this.f1735z = new e();
        this.A = new c();
        this.D = new Rect();
        this.f1710a = context;
        this.C = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f828z, i10, i11);
        this.f1715f = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.f1716g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f1718i = true;
        }
        obtainStyledAttributes.recycle();
        s sVar = new s(context, attributeSet, i10, i11);
        this.G = sVar;
        sVar.setInputMethodMode(1);
    }
}
