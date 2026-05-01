package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.ArrayList;
import java.util.HashMap;
import m.e;
import m.f;
import m.g;
import m.i;

/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public SparseArray f1854a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f1855b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f1856c;

    /* renamed from: d, reason: collision with root package name */
    public g f1857d;

    /* renamed from: e, reason: collision with root package name */
    public int f1858e;

    /* renamed from: f, reason: collision with root package name */
    public int f1859f;

    /* renamed from: g, reason: collision with root package name */
    public int f1860g;

    /* renamed from: h, reason: collision with root package name */
    public int f1861h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f1862i;

    /* renamed from: j, reason: collision with root package name */
    public int f1863j;

    /* renamed from: k, reason: collision with root package name */
    public b f1864k;

    /* renamed from: l, reason: collision with root package name */
    public int f1865l;

    /* renamed from: m, reason: collision with root package name */
    public HashMap f1866m;

    /* renamed from: n, reason: collision with root package name */
    public int f1867n;

    /* renamed from: o, reason: collision with root package name */
    public int f1868o;

    /* renamed from: p, reason: collision with root package name */
    public int f1869p;

    /* renamed from: q, reason: collision with root package name */
    public int f1870q;

    /* renamed from: r, reason: collision with root package name */
    public int f1871r;

    /* renamed from: s, reason: collision with root package name */
    public int f1872s;

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1854a = new SparseArray();
        this.f1855b = new ArrayList(4);
        this.f1856c = new ArrayList(100);
        this.f1857d = new g();
        this.f1858e = 0;
        this.f1859f = 0;
        this.f1860g = Integer.MAX_VALUE;
        this.f1861h = Integer.MAX_VALUE;
        this.f1862i = true;
        this.f1863j = 7;
        this.f1864k = null;
        this.f1865l = -1;
        this.f1866m = new HashMap();
        this.f1867n = -1;
        this.f1868o = -1;
        this.f1869p = -1;
        this.f1870q = -1;
        this.f1871r = 0;
        this.f1872s = 0;
        g(attributeSet);
    }

    @Override // android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i10, layoutParams);
    }

    @Override // android.view.ViewGroup
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    public Object c(int i10, Object obj) {
        if (i10 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap hashMap = this.f1866m;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.f1866m.get(str);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public final f d(int i10) {
        if (i10 == 0) {
            return this.f1857d;
        }
        View view = (View) this.f1854a.get(i10);
        if (view == null && (view = findViewById(i10)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.f1857d;
        }
        if (view == null) {
            return null;
        }
        return ((a) view.getLayoutParams()).f1896l0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = getWidth();
            float height = getHeight();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i11 = (int) ((parseInt / 1080.0f) * width);
                        int i12 = (int) ((parseInt2 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f10 = i11;
                        float f11 = i12;
                        float f12 = i11 + ((int) ((parseInt3 / 1080.0f) * width));
                        canvas.drawLine(f10, f11, f12, f11, paint);
                        float parseInt4 = i12 + ((int) ((Integer.parseInt(split[3]) / 1920.0f) * height));
                        canvas.drawLine(f12, f11, f12, parseInt4, paint);
                        canvas.drawLine(f12, parseInt4, f10, parseInt4, paint);
                        canvas.drawLine(f10, parseInt4, f10, f11, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f10, f11, f12, parseInt4, paint);
                        canvas.drawLine(f10, parseInt4, f12, f11, paint);
                    }
                }
            }
        }
    }

    public View e(int i10) {
        return (View) this.f1854a.get(i10);
    }

    public final f f(View view) {
        if (view == this) {
            return this.f1857d;
        }
        if (view == null) {
            return null;
        }
        return ((a) view.getLayoutParams()).f1896l0;
    }

    public final void g(AttributeSet attributeSet) {
        this.f1857d.W(this);
        this.f1854a.put(getId(), this);
        this.f1864k = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.f1913a);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.f1858e = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1858e);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.f1859f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1859f);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.f1860g = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1860g);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.f1861h = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1861h);
                } else if (index == R$styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.f1863j = obtainStyledAttributes.getInt(index, this.f1863j);
                } else if (index == R$styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        b bVar = new b();
                        this.f1864k = bVar;
                        bVar.d(getContext(), resourceId);
                    } catch (Resources.NotFoundException unused) {
                        this.f1864k = null;
                    }
                    this.f1865l = resourceId;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f1857d.c1(this.f1863j);
    }

    public int getMaxHeight() {
        return this.f1861h;
    }

    public int getMaxWidth() {
        return this.f1860g;
    }

    public int getMinHeight() {
        return this.f1859f;
    }

    public int getMinWidth() {
        return this.f1858e;
    }

    public int getOptimizationLevel() {
        return this.f1857d.R0();
    }

    public final void h(int i10, int i11) {
        boolean z10;
        boolean z11;
        int baseline;
        int childMeasureSpec;
        int childMeasureSpec2;
        boolean z12;
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                a aVar = (a) childAt.getLayoutParams();
                f fVar = aVar.f1896l0;
                if (!aVar.Y && !aVar.Z) {
                    fVar.x0(childAt.getVisibility());
                    int i13 = ((ViewGroup.MarginLayoutParams) aVar).width;
                    int i14 = ((ViewGroup.MarginLayoutParams) aVar).height;
                    boolean z13 = aVar.V;
                    if (z13 || (z12 = aVar.W) || (!z13 && aVar.I == 1) || i13 == -1 || (!z12 && (aVar.J == 1 || i14 == -1))) {
                        if (i13 == 0) {
                            childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, paddingLeft, -2);
                            z10 = true;
                        } else if (i13 == -1) {
                            childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, paddingLeft, -1);
                            z10 = false;
                        } else {
                            z10 = i13 == -2;
                            childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, paddingLeft, i13);
                        }
                        if (i14 == 0) {
                            childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i11, paddingTop, -2);
                            z11 = true;
                        } else if (i14 == -1) {
                            childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i11, paddingTop, -1);
                            z11 = false;
                        } else {
                            z11 = i14 == -2;
                            childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i11, paddingTop, i14);
                        }
                        childAt.measure(childMeasureSpec, childMeasureSpec2);
                        fVar.z0(i13 == -2);
                        fVar.c0(i14 == -2);
                        i13 = childAt.getMeasuredWidth();
                        i14 = childAt.getMeasuredHeight();
                    } else {
                        z10 = false;
                        z11 = false;
                    }
                    fVar.y0(i13);
                    fVar.b0(i14);
                    if (z10) {
                        fVar.B0(i13);
                    }
                    if (z11) {
                        fVar.A0(i14);
                    }
                    if (aVar.X && (baseline = childAt.getBaseline()) != -1) {
                        fVar.V(baseline);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0299 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x021c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(int r25, int r26) {
        /*
            Method dump skipped, instructions count: 682
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.i(int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r25v0, types: [android.view.View, android.view.ViewGroup, androidx.constraintlayout.widget.ConstraintLayout] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v32 */
    public final void j() {
        float f10;
        int i10;
        int i11;
        f d10;
        f d11;
        f d12;
        f d13;
        int i12;
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        ?? r32 = 0;
        if (isInEditMode) {
            for (int i13 = 0; i13 < childCount; i13++) {
                View childAt = getChildAt(i13);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    k(0, resourceName, Integer.valueOf(childAt.getId()));
                    int indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    d(childAt.getId()).X(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        for (int i14 = 0; i14 < childCount; i14++) {
            f f11 = f(getChildAt(i14));
            if (f11 != null) {
                f11.Q();
            }
        }
        if (this.f1865l != -1) {
            for (int i15 = 0; i15 < childCount; i15++) {
                getChildAt(i15).getId();
                int i16 = this.f1865l;
            }
        }
        b bVar = this.f1864k;
        if (bVar != null) {
            bVar.a(this);
        }
        this.f1857d.M0();
        int size = this.f1855b.size();
        if (size > 0) {
            for (int i17 = 0; i17 < size; i17++) {
                ((androidx.constraintlayout.widget.a) this.f1855b.get(i17)).e(this);
            }
        }
        for (int i18 = 0; i18 < childCount; i18++) {
            getChildAt(i18);
        }
        int i19 = 0;
        while (i19 < childCount) {
            View childAt2 = getChildAt(i19);
            f f12 = f(childAt2);
            if (f12 != null) {
                a aVar = (a) childAt2.getLayoutParams();
                aVar.a();
                if (aVar.f1898m0) {
                    aVar.f1898m0 = r32;
                } else if (isInEditMode) {
                    try {
                        String resourceName2 = getResources().getResourceName(childAt2.getId());
                        k(r32, resourceName2, Integer.valueOf(childAt2.getId()));
                        d(childAt2.getId()).X(resourceName2.substring(resourceName2.indexOf("id/") + 3));
                    } catch (Resources.NotFoundException unused2) {
                    }
                }
                f12.x0(childAt2.getVisibility());
                if (aVar.f1874a0) {
                    f12.x0(8);
                }
                f12.W(childAt2);
                this.f1857d.I0(f12);
                if (!aVar.W || !aVar.V) {
                    this.f1856c.add(f12);
                }
                if (aVar.Y) {
                    i iVar = (i) f12;
                    int i20 = aVar.f1890i0;
                    int i21 = aVar.f1892j0;
                    float f13 = aVar.f1894k0;
                    if (f13 != -1.0f) {
                        iVar.L0(f13);
                    } else if (i20 != -1) {
                        iVar.J0(i20);
                    } else if (i21 != -1) {
                        iVar.K0(i21);
                    }
                } else if (aVar.f1879d != -1 || aVar.f1881e != -1 || aVar.f1883f != -1 || aVar.f1885g != -1 || aVar.f1902q != -1 || aVar.f1901p != -1 || aVar.f1903r != -1 || aVar.f1904s != -1 || aVar.f1887h != -1 || aVar.f1889i != -1 || aVar.f1891j != -1 || aVar.f1893k != -1 || aVar.f1895l != -1 || aVar.Q != -1 || aVar.R != -1 || aVar.f1897m != -1 || ((ViewGroup.MarginLayoutParams) aVar).width == -1 || ((ViewGroup.MarginLayoutParams) aVar).height == -1) {
                    int i22 = aVar.f1876b0;
                    int i23 = aVar.f1878c0;
                    int i24 = aVar.f1880d0;
                    int i25 = aVar.f1882e0;
                    int i26 = aVar.f1884f0;
                    int i27 = aVar.f1886g0;
                    float f14 = aVar.f1888h0;
                    int i28 = aVar.f1897m;
                    if (i28 != -1) {
                        f d14 = d(i28);
                        if (d14 != null) {
                            f12.f(d14, aVar.f1900o, aVar.f1899n);
                        }
                    } else {
                        if (i22 != -1) {
                            f d15 = d(i22);
                            if (d15 != null) {
                                e.d dVar = e.d.LEFT;
                                f10 = f14;
                                i10 = i27;
                                i11 = i25;
                                f12.J(dVar, d15, dVar, ((ViewGroup.MarginLayoutParams) aVar).leftMargin, i26);
                            } else {
                                f10 = f14;
                                i10 = i27;
                                i11 = i25;
                            }
                        } else {
                            f10 = f14;
                            i10 = i27;
                            i11 = i25;
                            if (i23 != -1 && (d10 = d(i23)) != null) {
                                f12.J(e.d.LEFT, d10, e.d.RIGHT, ((ViewGroup.MarginLayoutParams) aVar).leftMargin, i26);
                            }
                        }
                        if (i24 != -1) {
                            f d16 = d(i24);
                            if (d16 != null) {
                                f12.J(e.d.RIGHT, d16, e.d.LEFT, ((ViewGroup.MarginLayoutParams) aVar).rightMargin, i10);
                            }
                        } else {
                            int i29 = i11;
                            if (i29 != -1 && (d11 = d(i29)) != null) {
                                e.d dVar2 = e.d.RIGHT;
                                f12.J(dVar2, d11, dVar2, ((ViewGroup.MarginLayoutParams) aVar).rightMargin, i10);
                            }
                        }
                        int i30 = aVar.f1887h;
                        if (i30 != -1) {
                            f d17 = d(i30);
                            if (d17 != null) {
                                e.d dVar3 = e.d.TOP;
                                f12.J(dVar3, d17, dVar3, ((ViewGroup.MarginLayoutParams) aVar).topMargin, aVar.f1906u);
                            }
                        } else {
                            int i31 = aVar.f1889i;
                            if (i31 != -1 && (d12 = d(i31)) != null) {
                                f12.J(e.d.TOP, d12, e.d.BOTTOM, ((ViewGroup.MarginLayoutParams) aVar).topMargin, aVar.f1906u);
                            }
                        }
                        int i32 = aVar.f1891j;
                        if (i32 != -1) {
                            f d18 = d(i32);
                            if (d18 != null) {
                                f12.J(e.d.BOTTOM, d18, e.d.TOP, ((ViewGroup.MarginLayoutParams) aVar).bottomMargin, aVar.f1908w);
                            }
                        } else {
                            int i33 = aVar.f1893k;
                            if (i33 != -1 && (d13 = d(i33)) != null) {
                                e.d dVar4 = e.d.BOTTOM;
                                f12.J(dVar4, d13, dVar4, ((ViewGroup.MarginLayoutParams) aVar).bottomMargin, aVar.f1908w);
                            }
                        }
                        int i34 = aVar.f1895l;
                        if (i34 != -1) {
                            View view = (View) this.f1854a.get(i34);
                            f d19 = d(aVar.f1895l);
                            if (d19 != null && view != null && (view.getLayoutParams() instanceof a)) {
                                a aVar2 = (a) view.getLayoutParams();
                                aVar.X = true;
                                aVar2.X = true;
                                e.d dVar5 = e.d.BASELINE;
                                f12.h(dVar5).a(d19.h(dVar5), 0, -1, e.c.STRONG, 0, true);
                                f12.h(e.d.TOP).m();
                                f12.h(e.d.BOTTOM).m();
                            }
                        }
                        if (f10 >= 0.0f && f10 != 0.5f) {
                            f12.d0(f10);
                        }
                        float f15 = aVar.A;
                        if (f15 >= 0.0f && f15 != 0.5f) {
                            f12.r0(f15);
                        }
                    }
                    if (isInEditMode && ((i12 = aVar.Q) != -1 || aVar.R != -1)) {
                        f12.o0(i12, aVar.R);
                    }
                    if (aVar.V) {
                        f12.g0(f.b.FIXED);
                        f12.y0(((ViewGroup.MarginLayoutParams) aVar).width);
                    } else if (((ViewGroup.MarginLayoutParams) aVar).width == -1) {
                        f12.g0(f.b.MATCH_PARENT);
                        f12.h(e.d.LEFT).f16485e = ((ViewGroup.MarginLayoutParams) aVar).leftMargin;
                        f12.h(e.d.RIGHT).f16485e = ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
                    } else {
                        f12.g0(f.b.MATCH_CONSTRAINT);
                        f12.y0(0);
                    }
                    if (aVar.W) {
                        r32 = 0;
                        f12.u0(f.b.FIXED);
                        f12.b0(((ViewGroup.MarginLayoutParams) aVar).height);
                    } else if (((ViewGroup.MarginLayoutParams) aVar).height == -1) {
                        f12.u0(f.b.MATCH_PARENT);
                        f12.h(e.d.TOP).f16485e = ((ViewGroup.MarginLayoutParams) aVar).topMargin;
                        f12.h(e.d.BOTTOM).f16485e = ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                        r32 = 0;
                    } else {
                        f12.u0(f.b.MATCH_CONSTRAINT);
                        r32 = 0;
                        f12.b0(0);
                    }
                    String str = aVar.B;
                    if (str != null) {
                        f12.Y(str);
                    }
                    f12.i0(aVar.E);
                    f12.w0(aVar.F);
                    f12.e0(aVar.G);
                    f12.s0(aVar.H);
                    f12.h0(aVar.I, aVar.K, aVar.M, aVar.O);
                    f12.v0(aVar.J, aVar.L, aVar.N, aVar.P);
                }
            }
            i19++;
            r32 = r32;
        }
    }

    public void k(int i10, Object obj, Object obj2) {
        if (i10 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.f1866m == null) {
                this.f1866m = new HashMap();
            }
            String str = (String) obj;
            int indexOf = str.indexOf(Operator.Operation.DIVISION);
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.f1866m.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    public final void l(int i10, int i11) {
        int i12;
        f.b bVar;
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        f.b bVar2 = f.b.FIXED;
        getLayoutParams();
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                bVar = f.b.WRAP_CONTENT;
            } else if (mode != 1073741824) {
                bVar = bVar2;
            } else {
                i12 = Math.min(this.f1860g, size) - paddingLeft;
                bVar = bVar2;
            }
            i12 = 0;
        } else {
            i12 = size;
            bVar = f.b.WRAP_CONTENT;
        }
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                bVar2 = f.b.WRAP_CONTENT;
            } else if (mode2 == 1073741824) {
                size2 = Math.min(this.f1861h, size2) - paddingTop;
            }
            size2 = 0;
        } else {
            bVar2 = f.b.WRAP_CONTENT;
        }
        this.f1857d.m0(0);
        this.f1857d.l0(0);
        this.f1857d.g0(bVar);
        this.f1857d.y0(i12);
        this.f1857d.u0(bVar2);
        this.f1857d.b0(size2);
        this.f1857d.m0((this.f1858e - getPaddingLeft()) - getPaddingRight());
        this.f1857d.l0((this.f1859f - getPaddingTop()) - getPaddingBottom());
    }

    public void m(String str) {
        this.f1857d.K0();
    }

    public final void n() {
        int childCount = getChildCount();
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= childCount) {
                break;
            }
            if (getChildAt(i10).isLayoutRequested()) {
                z10 = true;
                break;
            }
            i10++;
        }
        if (z10) {
            this.f1856c.clear();
            j();
        }
    }

    public final void o() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            getChildAt(i10);
        }
        int size = this.f1855b.size();
        if (size > 0) {
            for (int i11 = 0; i11 < size; i11++) {
                ((androidx.constraintlayout.widget.a) this.f1855b.get(i11)).d(this);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            a aVar = (a) childAt.getLayoutParams();
            f fVar = aVar.f1896l0;
            if ((childAt.getVisibility() != 8 || aVar.Y || aVar.Z || isInEditMode) && !aVar.f1874a0) {
                int p10 = fVar.p();
                int q10 = fVar.q();
                childAt.layout(p10, q10, fVar.D() + p10, fVar.r() + q10);
            }
        }
        int size = this.f1855b.size();
        if (size > 0) {
            for (int i15 = 0; i15 < size; i15++) {
                ((androidx.constraintlayout.widget.a) this.f1855b.get(i15)).c(this);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:161:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0135  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r21, int r22) {
        /*
            Method dump skipped, instructions count: 885
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        f f10 = f(view);
        if ((view instanceof c) && !(f10 instanceof i)) {
            a aVar = (a) view.getLayoutParams();
            i iVar = new i();
            aVar.f1896l0 = iVar;
            aVar.Y = true;
            iVar.M0(aVar.S);
        }
        if (view instanceof androidx.constraintlayout.widget.a) {
            androidx.constraintlayout.widget.a aVar2 = (androidx.constraintlayout.widget.a) view;
            aVar2.f();
            ((a) view.getLayoutParams()).Z = true;
            if (!this.f1855b.contains(aVar2)) {
                this.f1855b.add(aVar2);
            }
        }
        this.f1854a.put(view.getId(), view);
        this.f1862i = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f1854a.remove(view.getId());
        f f10 = f(view);
        this.f1857d.L0(f10);
        this.f1855b.remove(view);
        this.f1856c.remove(f10);
        this.f1862i = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        this.f1862i = true;
        this.f1867n = -1;
        this.f1868o = -1;
        this.f1869p = -1;
        this.f1870q = -1;
        this.f1871r = 0;
        this.f1872s = 0;
    }

    public void setConstraintSet(b bVar) {
        this.f1864k = bVar;
    }

    @Override // android.view.View
    public void setId(int i10) {
        this.f1854a.remove(getId());
        super.setId(i10);
        this.f1854a.put(getId(), this);
    }

    public void setMaxHeight(int i10) {
        if (i10 == this.f1861h) {
            return;
        }
        this.f1861h = i10;
        requestLayout();
    }

    public void setMaxWidth(int i10) {
        if (i10 == this.f1860g) {
            return;
        }
        this.f1860g = i10;
        requestLayout();
    }

    public void setMinHeight(int i10) {
        if (i10 == this.f1859f) {
            return;
        }
        this.f1859f = i10;
        requestLayout();
    }

    public void setMinWidth(int i10) {
        if (i10 == this.f1858e) {
            return;
        }
        this.f1858e = i10;
        requestLayout();
    }

    public void setOptimizationLevel(int i10) {
        this.f1857d.c1(i10);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    public static class a extends ViewGroup.MarginLayoutParams {
        public float A;
        public String B;
        public float C;
        public int D;
        public float E;
        public float F;
        public int G;
        public int H;
        public int I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public float O;
        public float P;
        public int Q;
        public int R;
        public int S;
        public boolean T;
        public boolean U;
        public boolean V;
        public boolean W;
        public boolean X;
        public boolean Y;
        public boolean Z;

        /* renamed from: a, reason: collision with root package name */
        public int f1873a;

        /* renamed from: a0, reason: collision with root package name */
        public boolean f1874a0;

        /* renamed from: b, reason: collision with root package name */
        public int f1875b;

        /* renamed from: b0, reason: collision with root package name */
        public int f1876b0;

        /* renamed from: c, reason: collision with root package name */
        public float f1877c;

        /* renamed from: c0, reason: collision with root package name */
        public int f1878c0;

        /* renamed from: d, reason: collision with root package name */
        public int f1879d;

        /* renamed from: d0, reason: collision with root package name */
        public int f1880d0;

        /* renamed from: e, reason: collision with root package name */
        public int f1881e;

        /* renamed from: e0, reason: collision with root package name */
        public int f1882e0;

        /* renamed from: f, reason: collision with root package name */
        public int f1883f;

        /* renamed from: f0, reason: collision with root package name */
        public int f1884f0;

        /* renamed from: g, reason: collision with root package name */
        public int f1885g;

        /* renamed from: g0, reason: collision with root package name */
        public int f1886g0;

        /* renamed from: h, reason: collision with root package name */
        public int f1887h;

        /* renamed from: h0, reason: collision with root package name */
        public float f1888h0;

        /* renamed from: i, reason: collision with root package name */
        public int f1889i;

        /* renamed from: i0, reason: collision with root package name */
        public int f1890i0;

        /* renamed from: j, reason: collision with root package name */
        public int f1891j;

        /* renamed from: j0, reason: collision with root package name */
        public int f1892j0;

        /* renamed from: k, reason: collision with root package name */
        public int f1893k;

        /* renamed from: k0, reason: collision with root package name */
        public float f1894k0;

        /* renamed from: l, reason: collision with root package name */
        public int f1895l;

        /* renamed from: l0, reason: collision with root package name */
        public f f1896l0;

        /* renamed from: m, reason: collision with root package name */
        public int f1897m;

        /* renamed from: m0, reason: collision with root package name */
        public boolean f1898m0;

        /* renamed from: n, reason: collision with root package name */
        public int f1899n;

        /* renamed from: o, reason: collision with root package name */
        public float f1900o;

        /* renamed from: p, reason: collision with root package name */
        public int f1901p;

        /* renamed from: q, reason: collision with root package name */
        public int f1902q;

        /* renamed from: r, reason: collision with root package name */
        public int f1903r;

        /* renamed from: s, reason: collision with root package name */
        public int f1904s;

        /* renamed from: t, reason: collision with root package name */
        public int f1905t;

        /* renamed from: u, reason: collision with root package name */
        public int f1906u;

        /* renamed from: v, reason: collision with root package name */
        public int f1907v;

        /* renamed from: w, reason: collision with root package name */
        public int f1908w;

        /* renamed from: x, reason: collision with root package name */
        public int f1909x;

        /* renamed from: y, reason: collision with root package name */
        public int f1910y;

        /* renamed from: z, reason: collision with root package name */
        public float f1911z;

        /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$a$a, reason: collision with other inner class name */
        public static class C0025a {

            /* renamed from: a, reason: collision with root package name */
            public static final SparseIntArray f1912a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f1912a = sparseIntArray;
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_android_orientation, 1);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
            }
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            int i10;
            this.f1873a = -1;
            this.f1875b = -1;
            this.f1877c = -1.0f;
            this.f1879d = -1;
            this.f1881e = -1;
            this.f1883f = -1;
            this.f1885g = -1;
            this.f1887h = -1;
            this.f1889i = -1;
            this.f1891j = -1;
            this.f1893k = -1;
            this.f1895l = -1;
            this.f1897m = -1;
            this.f1899n = 0;
            this.f1900o = 0.0f;
            this.f1901p = -1;
            this.f1902q = -1;
            this.f1903r = -1;
            this.f1904s = -1;
            this.f1905t = -1;
            this.f1906u = -1;
            this.f1907v = -1;
            this.f1908w = -1;
            this.f1909x = -1;
            this.f1910y = -1;
            this.f1911z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 0.0f;
            this.D = 1;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 1.0f;
            this.P = 1.0f;
            this.Q = -1;
            this.R = -1;
            this.S = -1;
            this.T = false;
            this.U = false;
            this.V = true;
            this.W = true;
            this.X = false;
            this.Y = false;
            this.Z = false;
            this.f1874a0 = false;
            this.f1876b0 = -1;
            this.f1878c0 = -1;
            this.f1880d0 = -1;
            this.f1882e0 = -1;
            this.f1884f0 = -1;
            this.f1886g0 = -1;
            this.f1888h0 = 0.5f;
            this.f1896l0 = new f();
            this.f1898m0 = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f1913a);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                int i12 = C0025a.f1912a.get(index);
                switch (i12) {
                    case 1:
                        this.S = obtainStyledAttributes.getInt(index, this.S);
                        break;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.f1897m);
                        this.f1897m = resourceId;
                        if (resourceId == -1) {
                            this.f1897m = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.f1899n = obtainStyledAttributes.getDimensionPixelSize(index, this.f1899n);
                        break;
                    case 4:
                        float f10 = obtainStyledAttributes.getFloat(index, this.f1900o) % 360.0f;
                        this.f1900o = f10;
                        if (f10 < 0.0f) {
                            this.f1900o = (360.0f - f10) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.f1873a = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1873a);
                        break;
                    case 6:
                        this.f1875b = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1875b);
                        break;
                    case 7:
                        this.f1877c = obtainStyledAttributes.getFloat(index, this.f1877c);
                        break;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.f1879d);
                        this.f1879d = resourceId2;
                        if (resourceId2 == -1) {
                            this.f1879d = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.f1881e);
                        this.f1881e = resourceId3;
                        if (resourceId3 == -1) {
                            this.f1881e = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.f1883f);
                        this.f1883f = resourceId4;
                        if (resourceId4 == -1) {
                            this.f1883f = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.f1885g);
                        this.f1885g = resourceId5;
                        if (resourceId5 == -1) {
                            this.f1885g = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.f1887h);
                        this.f1887h = resourceId6;
                        if (resourceId6 == -1) {
                            this.f1887h = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.f1889i);
                        this.f1889i = resourceId7;
                        if (resourceId7 == -1) {
                            this.f1889i = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.f1891j);
                        this.f1891j = resourceId8;
                        if (resourceId8 == -1) {
                            this.f1891j = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.f1893k);
                        this.f1893k = resourceId9;
                        if (resourceId9 == -1) {
                            this.f1893k = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.f1895l);
                        this.f1895l = resourceId10;
                        if (resourceId10 == -1) {
                            this.f1895l = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.f1901p);
                        this.f1901p = resourceId11;
                        if (resourceId11 == -1) {
                            this.f1901p = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.f1902q);
                        this.f1902q = resourceId12;
                        if (resourceId12 == -1) {
                            this.f1902q = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.f1903r);
                        this.f1903r = resourceId13;
                        if (resourceId13 == -1) {
                            this.f1903r = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.f1904s);
                        this.f1904s = resourceId14;
                        if (resourceId14 == -1) {
                            this.f1904s = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.f1905t = obtainStyledAttributes.getDimensionPixelSize(index, this.f1905t);
                        break;
                    case 22:
                        this.f1906u = obtainStyledAttributes.getDimensionPixelSize(index, this.f1906u);
                        break;
                    case 23:
                        this.f1907v = obtainStyledAttributes.getDimensionPixelSize(index, this.f1907v);
                        break;
                    case 24:
                        this.f1908w = obtainStyledAttributes.getDimensionPixelSize(index, this.f1908w);
                        break;
                    case 25:
                        this.f1909x = obtainStyledAttributes.getDimensionPixelSize(index, this.f1909x);
                        break;
                    case 26:
                        this.f1910y = obtainStyledAttributes.getDimensionPixelSize(index, this.f1910y);
                        break;
                    case 27:
                        this.T = obtainStyledAttributes.getBoolean(index, this.T);
                        break;
                    case 28:
                        this.U = obtainStyledAttributes.getBoolean(index, this.U);
                        break;
                    case 29:
                        this.f1911z = obtainStyledAttributes.getFloat(index, this.f1911z);
                        break;
                    case 30:
                        this.A = obtainStyledAttributes.getFloat(index, this.A);
                        break;
                    case 31:
                        int i13 = obtainStyledAttributes.getInt(index, 0);
                        this.I = i13;
                        if (i13 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 32:
                        int i14 = obtainStyledAttributes.getInt(index, 0);
                        this.J = i14;
                        if (i14 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 33:
                        try {
                            this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.K) == -2) {
                                this.K = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.M) == -2) {
                                this.M = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.O = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.O));
                        break;
                    case 36:
                        try {
                            this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.L) == -2) {
                                this.L = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.N) == -2) {
                                this.N = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 38:
                        this.P = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.P));
                        break;
                    default:
                        switch (i12) {
                            case 44:
                                String string = obtainStyledAttributes.getString(index);
                                this.B = string;
                                this.C = Float.NaN;
                                this.D = -1;
                                if (string != null) {
                                    int length = string.length();
                                    int indexOf = this.B.indexOf(44);
                                    if (indexOf <= 0 || indexOf >= length - 1) {
                                        i10 = 0;
                                    } else {
                                        String substring = this.B.substring(0, indexOf);
                                        if (substring.equalsIgnoreCase("W")) {
                                            this.D = 0;
                                        } else if (substring.equalsIgnoreCase("H")) {
                                            this.D = 1;
                                        }
                                        i10 = indexOf + 1;
                                    }
                                    int indexOf2 = this.B.indexOf(58);
                                    if (indexOf2 < 0 || indexOf2 >= length - 1) {
                                        String substring2 = this.B.substring(i10);
                                        if (substring2.length() > 0) {
                                            this.C = Float.parseFloat(substring2);
                                            break;
                                        } else {
                                            break;
                                        }
                                    } else {
                                        String substring3 = this.B.substring(i10, indexOf2);
                                        String substring4 = this.B.substring(indexOf2 + 1);
                                        if (substring3.length() > 0 && substring4.length() > 0) {
                                            try {
                                                float parseFloat = Float.parseFloat(substring3);
                                                float parseFloat2 = Float.parseFloat(substring4);
                                                if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                                    if (this.D == 1) {
                                                        this.C = Math.abs(parseFloat2 / parseFloat);
                                                        break;
                                                    } else {
                                                        this.C = Math.abs(parseFloat / parseFloat2);
                                                        break;
                                                    }
                                                }
                                            } catch (NumberFormatException unused5) {
                                                break;
                                            }
                                        }
                                    }
                                } else {
                                    break;
                                }
                                break;
                            case 45:
                                this.E = obtainStyledAttributes.getFloat(index, this.E);
                                break;
                            case 46:
                                this.F = obtainStyledAttributes.getFloat(index, this.F);
                                break;
                            case 47:
                                this.G = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.H = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.Q = obtainStyledAttributes.getDimensionPixelOffset(index, this.Q);
                                break;
                            case 50:
                                this.R = obtainStyledAttributes.getDimensionPixelOffset(index, this.R);
                                break;
                        }
                }
            }
            obtainStyledAttributes.recycle();
            a();
        }

        public void a() {
            this.Y = false;
            this.V = true;
            this.W = true;
            int i10 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i10 == -2 && this.T) {
                this.V = false;
                this.I = 1;
            }
            int i11 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i11 == -2 && this.U) {
                this.W = false;
                this.J = 1;
            }
            if (i10 == 0 || i10 == -1) {
                this.V = false;
                if (i10 == 0 && this.I == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.T = true;
                }
            }
            if (i11 == 0 || i11 == -1) {
                this.W = false;
                if (i11 == 0 && this.J == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.U = true;
                }
            }
            if (this.f1877c == -1.0f && this.f1873a == -1 && this.f1875b == -1) {
                return;
            }
            this.Y = true;
            this.V = true;
            this.W = true;
            if (!(this.f1896l0 instanceof i)) {
                this.f1896l0 = new i();
            }
            ((i) this.f1896l0).M0(this.S);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x004f  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0078  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0080  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void resolveLayoutDirection(int r7) {
            /*
                Method dump skipped, instructions count: 261
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.a.resolveLayoutDirection(int):void");
        }

        public a(int i10, int i11) {
            super(i10, i11);
            this.f1873a = -1;
            this.f1875b = -1;
            this.f1877c = -1.0f;
            this.f1879d = -1;
            this.f1881e = -1;
            this.f1883f = -1;
            this.f1885g = -1;
            this.f1887h = -1;
            this.f1889i = -1;
            this.f1891j = -1;
            this.f1893k = -1;
            this.f1895l = -1;
            this.f1897m = -1;
            this.f1899n = 0;
            this.f1900o = 0.0f;
            this.f1901p = -1;
            this.f1902q = -1;
            this.f1903r = -1;
            this.f1904s = -1;
            this.f1905t = -1;
            this.f1906u = -1;
            this.f1907v = -1;
            this.f1908w = -1;
            this.f1909x = -1;
            this.f1910y = -1;
            this.f1911z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 0.0f;
            this.D = 1;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 1.0f;
            this.P = 1.0f;
            this.Q = -1;
            this.R = -1;
            this.S = -1;
            this.T = false;
            this.U = false;
            this.V = true;
            this.W = true;
            this.X = false;
            this.Y = false;
            this.Z = false;
            this.f1874a0 = false;
            this.f1876b0 = -1;
            this.f1878c0 = -1;
            this.f1880d0 = -1;
            this.f1882e0 = -1;
            this.f1884f0 = -1;
            this.f1886g0 = -1;
            this.f1888h0 = 0.5f;
            this.f1896l0 = new f();
            this.f1898m0 = false;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1873a = -1;
            this.f1875b = -1;
            this.f1877c = -1.0f;
            this.f1879d = -1;
            this.f1881e = -1;
            this.f1883f = -1;
            this.f1885g = -1;
            this.f1887h = -1;
            this.f1889i = -1;
            this.f1891j = -1;
            this.f1893k = -1;
            this.f1895l = -1;
            this.f1897m = -1;
            this.f1899n = 0;
            this.f1900o = 0.0f;
            this.f1901p = -1;
            this.f1902q = -1;
            this.f1903r = -1;
            this.f1904s = -1;
            this.f1905t = -1;
            this.f1906u = -1;
            this.f1907v = -1;
            this.f1908w = -1;
            this.f1909x = -1;
            this.f1910y = -1;
            this.f1911z = 0.5f;
            this.A = 0.5f;
            this.B = null;
            this.C = 0.0f;
            this.D = 1;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 0;
            this.H = 0;
            this.I = 0;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 1.0f;
            this.P = 1.0f;
            this.Q = -1;
            this.R = -1;
            this.S = -1;
            this.T = false;
            this.U = false;
            this.V = true;
            this.W = true;
            this.X = false;
            this.Y = false;
            this.Z = false;
            this.f1874a0 = false;
            this.f1876b0 = -1;
            this.f1878c0 = -1;
            this.f1880d0 = -1;
            this.f1882e0 = -1;
            this.f1884f0 = -1;
            this.f1886g0 = -1;
            this.f1888h0 = 0.5f;
            this.f1896l0 = new f();
            this.f1898m0 = false;
        }
    }
}
