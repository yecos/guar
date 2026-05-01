package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import c0.g0;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.o implements RecyclerView.z.b {

    /* renamed from: b, reason: collision with root package name */
    public f[] f3080b;

    /* renamed from: c, reason: collision with root package name */
    public m f3081c;

    /* renamed from: d, reason: collision with root package name */
    public m f3082d;

    /* renamed from: e, reason: collision with root package name */
    public int f3083e;

    /* renamed from: f, reason: collision with root package name */
    public int f3084f;

    /* renamed from: g, reason: collision with root package name */
    public final i f3085g;

    /* renamed from: j, reason: collision with root package name */
    public BitSet f3088j;

    /* renamed from: o, reason: collision with root package name */
    public boolean f3093o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f3094p;

    /* renamed from: q, reason: collision with root package name */
    public e f3095q;

    /* renamed from: r, reason: collision with root package name */
    public int f3096r;

    /* renamed from: w, reason: collision with root package name */
    public int[] f3101w;

    /* renamed from: a, reason: collision with root package name */
    public int f3079a = -1;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3086h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3087i = false;

    /* renamed from: k, reason: collision with root package name */
    public int f3089k = -1;

    /* renamed from: l, reason: collision with root package name */
    public int f3090l = Integer.MIN_VALUE;

    /* renamed from: m, reason: collision with root package name */
    public d f3091m = new d();

    /* renamed from: n, reason: collision with root package name */
    public int f3092n = 2;

    /* renamed from: s, reason: collision with root package name */
    public final Rect f3097s = new Rect();

    /* renamed from: t, reason: collision with root package name */
    public final b f3098t = new b();

    /* renamed from: u, reason: collision with root package name */
    public boolean f3099u = false;

    /* renamed from: v, reason: collision with root package name */
    public boolean f3100v = true;

    /* renamed from: x, reason: collision with root package name */
    public final Runnable f3102x = new a();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.m();
        }
    }

    public class b {

        /* renamed from: a, reason: collision with root package name */
        public int f3104a;

        /* renamed from: b, reason: collision with root package name */
        public int f3105b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f3106c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f3107d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f3108e;

        /* renamed from: f, reason: collision with root package name */
        public int[] f3109f;

        public b() {
            c();
        }

        public void a() {
            this.f3105b = this.f3106c ? StaggeredGridLayoutManager.this.f3081c.i() : StaggeredGridLayoutManager.this.f3081c.m();
        }

        public void b(int i10) {
            if (this.f3106c) {
                this.f3105b = StaggeredGridLayoutManager.this.f3081c.i() - i10;
            } else {
                this.f3105b = StaggeredGridLayoutManager.this.f3081c.m() + i10;
            }
        }

        public void c() {
            this.f3104a = -1;
            this.f3105b = Integer.MIN_VALUE;
            this.f3106c = false;
            this.f3107d = false;
            this.f3108e = false;
            int[] iArr = this.f3109f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        public void d(f[] fVarArr) {
            int length = fVarArr.length;
            int[] iArr = this.f3109f;
            if (iArr == null || iArr.length < length) {
                this.f3109f = new int[StaggeredGridLayoutManager.this.f3080b.length];
            }
            for (int i10 = 0; i10 < length; i10++) {
                this.f3109f[i10] = fVarArr[i10].r(Integer.MIN_VALUE);
            }
        }
    }

    public static class c extends RecyclerView.p {

        /* renamed from: e, reason: collision with root package name */
        public f f3111e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f3112f;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public final int e() {
            f fVar = this.f3111e;
            if (fVar == null) {
                return -1;
            }
            return fVar.f3133e;
        }

        public boolean f() {
            return this.f3112f;
        }

        public void g(boolean z10) {
            this.f3112f = z10;
        }

        public c(int i10, int i11) {
            super(i10, i11);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public int f3119a;

        /* renamed from: b, reason: collision with root package name */
        public int f3120b;

        /* renamed from: c, reason: collision with root package name */
        public int f3121c;

        /* renamed from: d, reason: collision with root package name */
        public int[] f3122d;

        /* renamed from: e, reason: collision with root package name */
        public int f3123e;

        /* renamed from: f, reason: collision with root package name */
        public int[] f3124f;

        /* renamed from: g, reason: collision with root package name */
        public List f3125g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f3126h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f3127i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f3128j;

        public static class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public e[] newArray(int i10) {
                return new e[i10];
            }
        }

        public e() {
        }

        public void a() {
            this.f3122d = null;
            this.f3121c = 0;
            this.f3119a = -1;
            this.f3120b = -1;
        }

        public void b() {
            this.f3122d = null;
            this.f3121c = 0;
            this.f3123e = 0;
            this.f3124f = null;
            this.f3125g = null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f3119a);
            parcel.writeInt(this.f3120b);
            parcel.writeInt(this.f3121c);
            if (this.f3121c > 0) {
                parcel.writeIntArray(this.f3122d);
            }
            parcel.writeInt(this.f3123e);
            if (this.f3123e > 0) {
                parcel.writeIntArray(this.f3124f);
            }
            parcel.writeInt(this.f3126h ? 1 : 0);
            parcel.writeInt(this.f3127i ? 1 : 0);
            parcel.writeInt(this.f3128j ? 1 : 0);
            parcel.writeList(this.f3125g);
        }

        public e(Parcel parcel) {
            this.f3119a = parcel.readInt();
            this.f3120b = parcel.readInt();
            int readInt = parcel.readInt();
            this.f3121c = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.f3122d = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.f3123e = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.f3124f = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.f3126h = parcel.readInt() == 1;
            this.f3127i = parcel.readInt() == 1;
            this.f3128j = parcel.readInt() == 1;
            this.f3125g = parcel.readArrayList(d.a.class.getClassLoader());
        }

        public e(e eVar) {
            this.f3121c = eVar.f3121c;
            this.f3119a = eVar.f3119a;
            this.f3120b = eVar.f3120b;
            this.f3122d = eVar.f3122d;
            this.f3123e = eVar.f3123e;
            this.f3124f = eVar.f3124f;
            this.f3126h = eVar.f3126h;
            this.f3127i = eVar.f3127i;
            this.f3128j = eVar.f3128j;
            this.f3125g = eVar.f3125g;
        }
    }

    public class f {

        /* renamed from: a, reason: collision with root package name */
        public ArrayList f3129a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public int f3130b = Integer.MIN_VALUE;

        /* renamed from: c, reason: collision with root package name */
        public int f3131c = Integer.MIN_VALUE;

        /* renamed from: d, reason: collision with root package name */
        public int f3132d = 0;

        /* renamed from: e, reason: collision with root package name */
        public final int f3133e;

        public f(int i10) {
            this.f3133e = i10;
        }

        public void a(View view) {
            c p10 = p(view);
            p10.f3111e = this;
            this.f3129a.add(view);
            this.f3131c = Integer.MIN_VALUE;
            if (this.f3129a.size() == 1) {
                this.f3130b = Integer.MIN_VALUE;
            }
            if (p10.c() || p10.b()) {
                this.f3132d += StaggeredGridLayoutManager.this.f3081c.e(view);
            }
        }

        public void b(boolean z10, int i10) {
            int n10 = z10 ? n(Integer.MIN_VALUE) : r(Integer.MIN_VALUE);
            e();
            if (n10 == Integer.MIN_VALUE) {
                return;
            }
            if (!z10 || n10 >= StaggeredGridLayoutManager.this.f3081c.i()) {
                if (z10 || n10 <= StaggeredGridLayoutManager.this.f3081c.m()) {
                    if (i10 != Integer.MIN_VALUE) {
                        n10 += i10;
                    }
                    this.f3131c = n10;
                    this.f3130b = n10;
                }
            }
        }

        public void c() {
            d.a f10;
            ArrayList arrayList = this.f3129a;
            View view = (View) arrayList.get(arrayList.size() - 1);
            c p10 = p(view);
            this.f3131c = StaggeredGridLayoutManager.this.f3081c.d(view);
            if (p10.f3112f && (f10 = StaggeredGridLayoutManager.this.f3091m.f(p10.a())) != null && f10.f3116b == 1) {
                this.f3131c += f10.a(this.f3133e);
            }
        }

        public void d() {
            d.a f10;
            View view = (View) this.f3129a.get(0);
            c p10 = p(view);
            this.f3130b = StaggeredGridLayoutManager.this.f3081c.g(view);
            if (p10.f3112f && (f10 = StaggeredGridLayoutManager.this.f3091m.f(p10.a())) != null && f10.f3116b == -1) {
                this.f3130b -= f10.a(this.f3133e);
            }
        }

        public void e() {
            this.f3129a.clear();
            s();
            this.f3132d = 0;
        }

        public int f() {
            return StaggeredGridLayoutManager.this.f3086h ? j(this.f3129a.size() - 1, -1, true) : j(0, this.f3129a.size(), true);
        }

        public int g() {
            return StaggeredGridLayoutManager.this.f3086h ? k(0, this.f3129a.size(), true) : k(this.f3129a.size() - 1, -1, true);
        }

        public int h() {
            return StaggeredGridLayoutManager.this.f3086h ? j(0, this.f3129a.size(), true) : j(this.f3129a.size() - 1, -1, true);
        }

        public int i(int i10, int i11, boolean z10, boolean z11, boolean z12) {
            int m10 = StaggeredGridLayoutManager.this.f3081c.m();
            int i12 = StaggeredGridLayoutManager.this.f3081c.i();
            int i13 = i11 > i10 ? 1 : -1;
            while (i10 != i11) {
                View view = (View) this.f3129a.get(i10);
                int g10 = StaggeredGridLayoutManager.this.f3081c.g(view);
                int d10 = StaggeredGridLayoutManager.this.f3081c.d(view);
                boolean z13 = false;
                boolean z14 = !z12 ? g10 >= i12 : g10 > i12;
                if (!z12 ? d10 > m10 : d10 >= m10) {
                    z13 = true;
                }
                if (z14 && z13) {
                    if (z10 && z11) {
                        if (g10 >= m10 && d10 <= i12) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    } else {
                        if (z11) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                        if (g10 < m10 || d10 > i12) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    }
                }
                i10 += i13;
            }
            return -1;
        }

        public int j(int i10, int i11, boolean z10) {
            return i(i10, i11, false, false, z10);
        }

        public int k(int i10, int i11, boolean z10) {
            return i(i10, i11, z10, true, false);
        }

        public int l() {
            return this.f3132d;
        }

        public int m() {
            int i10 = this.f3131c;
            if (i10 != Integer.MIN_VALUE) {
                return i10;
            }
            c();
            return this.f3131c;
        }

        public int n(int i10) {
            int i11 = this.f3131c;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            if (this.f3129a.size() == 0) {
                return i10;
            }
            c();
            return this.f3131c;
        }

        public View o(int i10, int i11) {
            View view = null;
            if (i11 != -1) {
                int size = this.f3129a.size() - 1;
                while (size >= 0) {
                    View view2 = (View) this.f3129a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.f3086h && staggeredGridLayoutManager.getPosition(view2) >= i10) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.f3086h && staggeredGridLayoutManager2.getPosition(view2) <= i10) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f3129a.size();
                int i12 = 0;
                while (i12 < size2) {
                    View view3 = (View) this.f3129a.get(i12);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.f3086h && staggeredGridLayoutManager3.getPosition(view3) <= i10) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.f3086h && staggeredGridLayoutManager4.getPosition(view3) >= i10) || !view3.hasFocusable()) {
                        break;
                    }
                    i12++;
                    view = view3;
                }
            }
            return view;
        }

        public c p(View view) {
            return (c) view.getLayoutParams();
        }

        public int q() {
            int i10 = this.f3130b;
            if (i10 != Integer.MIN_VALUE) {
                return i10;
            }
            d();
            return this.f3130b;
        }

        public int r(int i10) {
            int i11 = this.f3130b;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            if (this.f3129a.size() == 0) {
                return i10;
            }
            d();
            return this.f3130b;
        }

        public void s() {
            this.f3130b = Integer.MIN_VALUE;
            this.f3131c = Integer.MIN_VALUE;
        }

        public void t(int i10) {
            int i11 = this.f3130b;
            if (i11 != Integer.MIN_VALUE) {
                this.f3130b = i11 + i10;
            }
            int i12 = this.f3131c;
            if (i12 != Integer.MIN_VALUE) {
                this.f3131c = i12 + i10;
            }
        }

        public void u() {
            int size = this.f3129a.size();
            View view = (View) this.f3129a.remove(size - 1);
            c p10 = p(view);
            p10.f3111e = null;
            if (p10.c() || p10.b()) {
                this.f3132d -= StaggeredGridLayoutManager.this.f3081c.e(view);
            }
            if (size == 1) {
                this.f3130b = Integer.MIN_VALUE;
            }
            this.f3131c = Integer.MIN_VALUE;
        }

        public void v() {
            View view = (View) this.f3129a.remove(0);
            c p10 = p(view);
            p10.f3111e = null;
            if (this.f3129a.size() == 0) {
                this.f3131c = Integer.MIN_VALUE;
            }
            if (p10.c() || p10.b()) {
                this.f3132d -= StaggeredGridLayoutManager.this.f3081c.e(view);
            }
            this.f3130b = Integer.MIN_VALUE;
        }

        public void w(View view) {
            c p10 = p(view);
            p10.f3111e = this;
            this.f3129a.add(0, view);
            this.f3130b = Integer.MIN_VALUE;
            if (this.f3129a.size() == 1) {
                this.f3131c = Integer.MIN_VALUE;
            }
            if (p10.c() || p10.b()) {
                this.f3132d += StaggeredGridLayoutManager.this.f3081c.e(view);
            }
        }

        public void x(int i10) {
            this.f3130b = i10;
            this.f3131c = i10;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        RecyclerView.o.d properties = RecyclerView.o.getProperties(context, attributeSet, i10, i11);
        setOrientation(properties.f3048a);
        setSpanCount(properties.f3049b);
        setReverseLayout(properties.f3050c);
        this.f3085g = new i();
        t();
    }

    public final int A(int i10) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i10) {
                return position;
            }
        }
        return 0;
    }

    public final void B(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z10) {
        int i10;
        int F = F(Integer.MIN_VALUE);
        if (F != Integer.MIN_VALUE && (i10 = this.f3081c.i() - F) > 0) {
            int i11 = i10 - (-scrollBy(-i10, vVar, a0Var));
            if (!z10 || i11 <= 0) {
                return;
            }
            this.f3081c.r(i11);
        }
    }

    public final void C(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z10) {
        int m10;
        int I = I(Integer.MAX_VALUE);
        if (I != Integer.MAX_VALUE && (m10 = I - this.f3081c.m()) > 0) {
            int scrollBy = m10 - scrollBy(m10, vVar, a0Var);
            if (!z10 || scrollBy <= 0) {
                return;
            }
            this.f3081c.r(-scrollBy);
        }
    }

    public int D() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    public int E() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    public final int F(int i10) {
        int n10 = this.f3080b[0].n(i10);
        for (int i11 = 1; i11 < this.f3079a; i11++) {
            int n11 = this.f3080b[i11].n(i10);
            if (n11 > n10) {
                n10 = n11;
            }
        }
        return n10;
    }

    public final int G(int i10) {
        int r10 = this.f3080b[0].r(i10);
        for (int i11 = 1; i11 < this.f3079a; i11++) {
            int r11 = this.f3080b[i11].r(i10);
            if (r11 > r10) {
                r10 = r11;
            }
        }
        return r10;
    }

    public final int H(int i10) {
        int n10 = this.f3080b[0].n(i10);
        for (int i11 = 1; i11 < this.f3079a; i11++) {
            int n11 = this.f3080b[i11].n(i10);
            if (n11 < n10) {
                n10 = n11;
            }
        }
        return n10;
    }

    public final int I(int i10) {
        int r10 = this.f3080b[0].r(i10);
        for (int i11 = 1; i11 < this.f3079a; i11++) {
            int r11 = this.f3080b[i11].r(i10);
            if (r11 < r10) {
                r10 = r11;
            }
        }
        return r10;
    }

    public final f J(i iVar) {
        int i10;
        int i11;
        int i12;
        if (Q(iVar.f3254e)) {
            i11 = this.f3079a - 1;
            i10 = -1;
            i12 = -1;
        } else {
            i10 = this.f3079a;
            i11 = 0;
            i12 = 1;
        }
        f fVar = null;
        if (iVar.f3254e == 1) {
            int m10 = this.f3081c.m();
            int i13 = Integer.MAX_VALUE;
            while (i11 != i10) {
                f fVar2 = this.f3080b[i11];
                int n10 = fVar2.n(m10);
                if (n10 < i13) {
                    fVar = fVar2;
                    i13 = n10;
                }
                i11 += i12;
            }
            return fVar;
        }
        int i14 = this.f3081c.i();
        int i15 = Integer.MIN_VALUE;
        while (i11 != i10) {
            f fVar3 = this.f3080b[i11];
            int r10 = fVar3.r(i14);
            if (r10 > i15) {
                fVar = fVar3;
                i15 = r10;
            }
            i11 += i12;
        }
        return fVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void K(int i10, int i11, int i12) {
        int i13;
        int i14;
        int E = this.f3087i ? E() : D();
        if (i12 != 8) {
            i13 = i10 + i11;
        } else {
            if (i10 >= i11) {
                i13 = i10 + 1;
                i14 = i11;
                this.f3091m.h(i14);
                if (i12 != 1) {
                    this.f3091m.j(i10, i11);
                } else if (i12 == 2) {
                    this.f3091m.k(i10, i11);
                } else if (i12 == 8) {
                    this.f3091m.k(i10, 1);
                    this.f3091m.j(i11, 1);
                }
                if (i13 > E) {
                    return;
                }
                if (i14 <= (this.f3087i ? D() : E())) {
                    requestLayout();
                    return;
                }
                return;
            }
            i13 = i11 + 1;
        }
        i14 = i10;
        this.f3091m.h(i14);
        if (i12 != 1) {
        }
        if (i13 > E) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
    
        if (r10 == r11) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008a, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0088, code lost:
    
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0086, code lost:
    
        if (r10 == r11) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View L() {
        int i10;
        int i11;
        boolean z10;
        int childCount = getChildCount() - 1;
        BitSet bitSet = new BitSet(this.f3079a);
        bitSet.set(0, this.f3079a, true);
        char c10 = (this.f3083e == 1 && isLayoutRTL()) ? (char) 1 : (char) 65535;
        if (this.f3087i) {
            i10 = -1;
        } else {
            i10 = childCount + 1;
            childCount = 0;
        }
        int i12 = childCount < i10 ? 1 : -1;
        while (childCount != i10) {
            View childAt = getChildAt(childCount);
            c cVar = (c) childAt.getLayoutParams();
            if (bitSet.get(cVar.f3111e.f3133e)) {
                if (n(cVar.f3111e)) {
                    return childAt;
                }
                bitSet.clear(cVar.f3111e.f3133e);
            }
            if (!cVar.f3112f && (i11 = childCount + i12) != i10) {
                View childAt2 = getChildAt(i11);
                if (this.f3087i) {
                    int d10 = this.f3081c.d(childAt);
                    int d11 = this.f3081c.d(childAt2);
                    if (d10 < d11) {
                        return childAt;
                    }
                } else {
                    int g10 = this.f3081c.g(childAt);
                    int g11 = this.f3081c.g(childAt2);
                    if (g10 > g11) {
                        return childAt;
                    }
                }
                if (z10) {
                    if ((cVar.f3111e.f3133e - ((c) childAt2.getLayoutParams()).f3111e.f3133e < 0) != (c10 < 0)) {
                        return childAt;
                    }
                } else {
                    continue;
                }
            }
            childCount += i12;
        }
        return null;
    }

    public void M() {
        this.f3091m.b();
        requestLayout();
    }

    public final void N(View view, int i10, int i11, boolean z10) {
        calculateItemDecorationsForChild(view, this.f3097s);
        c cVar = (c) view.getLayoutParams();
        int i12 = ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
        Rect rect = this.f3097s;
        int g02 = g0(i10, i12 + rect.left, ((ViewGroup.MarginLayoutParams) cVar).rightMargin + rect.right);
        int i13 = ((ViewGroup.MarginLayoutParams) cVar).topMargin;
        Rect rect2 = this.f3097s;
        int g03 = g0(i11, i13 + rect2.top, ((ViewGroup.MarginLayoutParams) cVar).bottomMargin + rect2.bottom);
        if (z10 ? shouldReMeasureChild(view, g02, g03, cVar) : shouldMeasureChild(view, g02, g03, cVar)) {
            view.measure(g02, g03);
        }
    }

    public final void O(View view, c cVar, boolean z10) {
        if (cVar.f3112f) {
            if (this.f3083e == 1) {
                N(view, this.f3096r, RecyclerView.o.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) cVar).height, true), z10);
                return;
            } else {
                N(view, RecyclerView.o.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) cVar).width, true), this.f3096r, z10);
                return;
            }
        }
        if (this.f3083e == 1) {
            N(view, RecyclerView.o.getChildMeasureSpec(this.f3084f, getWidthMode(), 0, ((ViewGroup.MarginLayoutParams) cVar).width, false), RecyclerView.o.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) cVar).height, true), z10);
        } else {
            N(view, RecyclerView.o.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) cVar).width, true), RecyclerView.o.getChildMeasureSpec(this.f3084f, getHeightMode(), 0, ((ViewGroup.MarginLayoutParams) cVar).height, false), z10);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x0157, code lost:
    
        if (m() != false) goto L90;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void P(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z10) {
        e eVar;
        b bVar = this.f3098t;
        if (!(this.f3095q == null && this.f3089k == -1) && a0Var.b() == 0) {
            removeAndRecycleAllViews(vVar);
            bVar.c();
            return;
        }
        boolean z11 = true;
        boolean z12 = (bVar.f3108e && this.f3089k == -1 && this.f3095q == null) ? false : true;
        if (z12) {
            bVar.c();
            if (this.f3095q != null) {
                h(bVar);
            } else {
                X();
                bVar.f3106c = this.f3087i;
            }
            c0(a0Var, bVar);
            bVar.f3108e = true;
        }
        if (this.f3095q == null && this.f3089k == -1 && (bVar.f3106c != this.f3093o || isLayoutRTL() != this.f3094p)) {
            this.f3091m.b();
            bVar.f3107d = true;
        }
        if (getChildCount() > 0 && ((eVar = this.f3095q) == null || eVar.f3121c < 1)) {
            if (bVar.f3107d) {
                for (int i10 = 0; i10 < this.f3079a; i10++) {
                    this.f3080b[i10].e();
                    int i11 = bVar.f3105b;
                    if (i11 != Integer.MIN_VALUE) {
                        this.f3080b[i10].x(i11);
                    }
                }
            } else if (z12 || this.f3098t.f3109f == null) {
                for (int i12 = 0; i12 < this.f3079a; i12++) {
                    this.f3080b[i12].b(this.f3087i, bVar.f3105b);
                }
                this.f3098t.d(this.f3080b);
            } else {
                for (int i13 = 0; i13 < this.f3079a; i13++) {
                    f fVar = this.f3080b[i13];
                    fVar.e();
                    fVar.x(this.f3098t.f3109f[i13]);
                }
            }
        }
        detachAndScrapAttachedViews(vVar);
        this.f3085g.f3250a = false;
        this.f3099u = false;
        e0(this.f3082d.n());
        d0(bVar.f3104a, a0Var);
        if (bVar.f3106c) {
            Y(-1);
            u(vVar, this.f3085g, a0Var);
            Y(1);
            i iVar = this.f3085g;
            iVar.f3252c = bVar.f3104a + iVar.f3253d;
            u(vVar, iVar, a0Var);
        } else {
            Y(1);
            u(vVar, this.f3085g, a0Var);
            Y(-1);
            i iVar2 = this.f3085g;
            iVar2.f3252c = bVar.f3104a + iVar2.f3253d;
            u(vVar, iVar2, a0Var);
        }
        W();
        if (getChildCount() > 0) {
            if (this.f3087i) {
                B(vVar, a0Var, true);
                C(vVar, a0Var, false);
            } else {
                C(vVar, a0Var, true);
                B(vVar, a0Var, false);
            }
        }
        if (z10 && !a0Var.e()) {
            if (this.f3092n != 0 && getChildCount() > 0 && (this.f3099u || L() != null)) {
                removeCallbacks(this.f3102x);
            }
        }
        z11 = false;
        if (a0Var.e()) {
            this.f3098t.c();
        }
        this.f3093o = bVar.f3106c;
        this.f3094p = isLayoutRTL();
        if (z11) {
            this.f3098t.c();
            P(vVar, a0Var, false);
        }
    }

    public final boolean Q(int i10) {
        if (this.f3083e == 0) {
            return (i10 == -1) != this.f3087i;
        }
        return ((i10 == -1) == this.f3087i) == isLayoutRTL();
    }

    public void R(int i10, RecyclerView.a0 a0Var) {
        int D;
        int i11;
        if (i10 > 0) {
            D = E();
            i11 = 1;
        } else {
            D = D();
            i11 = -1;
        }
        this.f3085g.f3250a = true;
        d0(D, a0Var);
        Y(i11);
        i iVar = this.f3085g;
        iVar.f3252c = D + iVar.f3253d;
        iVar.f3251b = Math.abs(i10);
    }

    public final void S(View view) {
        for (int i10 = this.f3079a - 1; i10 >= 0; i10--) {
            this.f3080b[i10].w(view);
        }
    }

    public final void T(RecyclerView.v vVar, i iVar) {
        if (!iVar.f3250a || iVar.f3258i) {
            return;
        }
        if (iVar.f3251b == 0) {
            if (iVar.f3254e == -1) {
                U(vVar, iVar.f3256g);
                return;
            } else {
                V(vVar, iVar.f3255f);
                return;
            }
        }
        if (iVar.f3254e != -1) {
            int H = H(iVar.f3256g) - iVar.f3256g;
            V(vVar, H < 0 ? iVar.f3255f : Math.min(H, iVar.f3251b) + iVar.f3255f);
        } else {
            int i10 = iVar.f3255f;
            int G = i10 - G(i10);
            U(vVar, G < 0 ? iVar.f3256g : iVar.f3256g - Math.min(G, iVar.f3251b));
        }
    }

    public final void U(RecyclerView.v vVar, int i10) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.f3081c.g(childAt) < i10 || this.f3081c.q(childAt) < i10) {
                return;
            }
            c cVar = (c) childAt.getLayoutParams();
            if (cVar.f3112f) {
                for (int i11 = 0; i11 < this.f3079a; i11++) {
                    if (this.f3080b[i11].f3129a.size() == 1) {
                        return;
                    }
                }
                for (int i12 = 0; i12 < this.f3079a; i12++) {
                    this.f3080b[i12].u();
                }
            } else if (cVar.f3111e.f3129a.size() == 1) {
                return;
            } else {
                cVar.f3111e.u();
            }
            removeAndRecycleView(childAt, vVar);
        }
    }

    public final void V(RecyclerView.v vVar, int i10) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.f3081c.d(childAt) > i10 || this.f3081c.p(childAt) > i10) {
                return;
            }
            c cVar = (c) childAt.getLayoutParams();
            if (cVar.f3112f) {
                for (int i11 = 0; i11 < this.f3079a; i11++) {
                    if (this.f3080b[i11].f3129a.size() == 1) {
                        return;
                    }
                }
                for (int i12 = 0; i12 < this.f3079a; i12++) {
                    this.f3080b[i12].v();
                }
            } else if (cVar.f3111e.f3129a.size() == 1) {
                return;
            } else {
                cVar.f3111e.v();
            }
            removeAndRecycleView(childAt, vVar);
        }
    }

    public final void W() {
        if (this.f3082d.k() == 1073741824) {
            return;
        }
        int childCount = getChildCount();
        float f10 = 0.0f;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            float e10 = this.f3082d.e(childAt);
            if (e10 >= f10) {
                if (((c) childAt.getLayoutParams()).f()) {
                    e10 = (e10 * 1.0f) / this.f3079a;
                }
                f10 = Math.max(f10, e10);
            }
        }
        int i11 = this.f3084f;
        int round = Math.round(f10 * this.f3079a);
        if (this.f3082d.k() == Integer.MIN_VALUE) {
            round = Math.min(round, this.f3082d.n());
        }
        e0(round);
        if (this.f3084f == i11) {
            return;
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = getChildAt(i12);
            c cVar = (c) childAt2.getLayoutParams();
            if (!cVar.f3112f) {
                if (isLayoutRTL() && this.f3083e == 1) {
                    int i13 = this.f3079a;
                    int i14 = cVar.f3111e.f3133e;
                    childAt2.offsetLeftAndRight(((-((i13 - 1) - i14)) * this.f3084f) - ((-((i13 - 1) - i14)) * i11));
                } else {
                    int i15 = cVar.f3111e.f3133e;
                    int i16 = this.f3084f * i15;
                    int i17 = i15 * i11;
                    if (this.f3083e == 1) {
                        childAt2.offsetLeftAndRight(i16 - i17);
                    } else {
                        childAt2.offsetTopAndBottom(i16 - i17);
                    }
                }
            }
        }
    }

    public final void X() {
        if (this.f3083e == 1 || !isLayoutRTL()) {
            this.f3087i = this.f3086h;
        } else {
            this.f3087i = !this.f3086h;
        }
    }

    public final void Y(int i10) {
        i iVar = this.f3085g;
        iVar.f3254e = i10;
        iVar.f3253d = this.f3087i != (i10 == -1) ? -1 : 1;
    }

    public final void Z(int i10, int i11) {
        for (int i12 = 0; i12 < this.f3079a; i12++) {
            if (!this.f3080b[i12].f3129a.isEmpty()) {
                f0(this.f3080b[i12], i10, i11);
            }
        }
    }

    public final boolean a0(RecyclerView.a0 a0Var, b bVar) {
        bVar.f3104a = this.f3093o ? A(a0Var.b()) : v(a0Var.b());
        bVar.f3105b = Integer.MIN_VALUE;
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void assertNotInLayoutOrScroll(String str) {
        if (this.f3095q == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public boolean b0(RecyclerView.a0 a0Var, b bVar) {
        int i10;
        if (!a0Var.e() && (i10 = this.f3089k) != -1) {
            if (i10 >= 0 && i10 < a0Var.b()) {
                e eVar = this.f3095q;
                if (eVar == null || eVar.f3119a == -1 || eVar.f3121c < 1) {
                    View findViewByPosition = findViewByPosition(this.f3089k);
                    if (findViewByPosition != null) {
                        bVar.f3104a = this.f3087i ? E() : D();
                        if (this.f3090l != Integer.MIN_VALUE) {
                            if (bVar.f3106c) {
                                bVar.f3105b = (this.f3081c.i() - this.f3090l) - this.f3081c.d(findViewByPosition);
                            } else {
                                bVar.f3105b = (this.f3081c.m() + this.f3090l) - this.f3081c.g(findViewByPosition);
                            }
                            return true;
                        }
                        if (this.f3081c.e(findViewByPosition) > this.f3081c.n()) {
                            bVar.f3105b = bVar.f3106c ? this.f3081c.i() : this.f3081c.m();
                            return true;
                        }
                        int g10 = this.f3081c.g(findViewByPosition) - this.f3081c.m();
                        if (g10 < 0) {
                            bVar.f3105b = -g10;
                            return true;
                        }
                        int i11 = this.f3081c.i() - this.f3081c.d(findViewByPosition);
                        if (i11 < 0) {
                            bVar.f3105b = i11;
                            return true;
                        }
                        bVar.f3105b = Integer.MIN_VALUE;
                    } else {
                        int i12 = this.f3089k;
                        bVar.f3104a = i12;
                        int i13 = this.f3090l;
                        if (i13 == Integer.MIN_VALUE) {
                            bVar.f3106c = l(i12) == 1;
                            bVar.a();
                        } else {
                            bVar.b(i13);
                        }
                        bVar.f3107d = true;
                    }
                } else {
                    bVar.f3105b = Integer.MIN_VALUE;
                    bVar.f3104a = this.f3089k;
                }
                return true;
            }
            this.f3089k = -1;
            this.f3090l = Integer.MIN_VALUE;
        }
        return false;
    }

    public void c0(RecyclerView.a0 a0Var, b bVar) {
        if (b0(a0Var, bVar) || a0(a0Var, bVar)) {
            return;
        }
        bVar.a();
        bVar.f3104a = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean canScrollHorizontally() {
        return this.f3083e == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean canScrollVertically() {
        return this.f3083e == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean checkLayoutParams(RecyclerView.p pVar) {
        return pVar instanceof c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void collectAdjacentPrefetchPositions(int i10, int i11, RecyclerView.a0 a0Var, RecyclerView.o.c cVar) {
        int n10;
        int i12;
        if (this.f3083e != 0) {
            i10 = i11;
        }
        if (getChildCount() == 0 || i10 == 0) {
            return;
        }
        R(i10, a0Var);
        int[] iArr = this.f3101w;
        if (iArr == null || iArr.length < this.f3079a) {
            this.f3101w = new int[this.f3079a];
        }
        int i13 = 0;
        for (int i14 = 0; i14 < this.f3079a; i14++) {
            i iVar = this.f3085g;
            if (iVar.f3253d == -1) {
                n10 = iVar.f3255f;
                i12 = this.f3080b[i14].r(n10);
            } else {
                n10 = this.f3080b[i14].n(iVar.f3256g);
                i12 = this.f3085g.f3256g;
            }
            int i15 = n10 - i12;
            if (i15 >= 0) {
                this.f3101w[i13] = i15;
                i13++;
            }
        }
        Arrays.sort(this.f3101w, 0, i13);
        for (int i16 = 0; i16 < i13 && this.f3085g.a(a0Var); i16++) {
            cVar.a(this.f3085g.f3252c, this.f3101w[i16]);
            i iVar2 = this.f3085g;
            iVar2.f3252c += iVar2.f3253d;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollExtent(RecyclerView.a0 a0Var) {
        return o(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollOffset(RecyclerView.a0 a0Var) {
        return p(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollRange(RecyclerView.a0 a0Var) {
        return q(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z.b
    public PointF computeScrollVectorForPosition(int i10) {
        int l10 = l(i10);
        PointF pointF = new PointF();
        if (l10 == 0) {
            return null;
        }
        if (this.f3083e == 0) {
            pointF.x = l10;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = l10;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollExtent(RecyclerView.a0 a0Var) {
        return o(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollOffset(RecyclerView.a0 a0Var) {
        return p(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollRange(RecyclerView.a0 a0Var) {
        return q(a0Var);
    }

    public final int convertFocusDirectionToLayoutDirection(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 17 ? i10 != 33 ? i10 != 66 ? (i10 == 130 && this.f3083e == 1) ? 1 : Integer.MIN_VALUE : this.f3083e == 0 ? 1 : Integer.MIN_VALUE : this.f3083e == 1 ? -1 : Integer.MIN_VALUE : this.f3083e == 0 ? -1 : Integer.MIN_VALUE : (this.f3083e != 1 && isLayoutRTL()) ? -1 : 1 : (this.f3083e != 1 && isLayoutRTL()) ? 1 : -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d0(int i10, RecyclerView.a0 a0Var) {
        int i11;
        int i12;
        int c10;
        i iVar = this.f3085g;
        boolean z10 = false;
        iVar.f3251b = 0;
        iVar.f3252c = i10;
        if (!isSmoothScrolling() || (c10 = a0Var.c()) == -1) {
            i11 = 0;
        } else {
            if (this.f3087i != (c10 < i10)) {
                i12 = this.f3081c.n();
                i11 = 0;
                if (getClipToPadding()) {
                    this.f3085g.f3256g = this.f3081c.h() + i11;
                    this.f3085g.f3255f = -i12;
                } else {
                    this.f3085g.f3255f = this.f3081c.m() - i12;
                    this.f3085g.f3256g = this.f3081c.i() + i11;
                }
                i iVar2 = this.f3085g;
                iVar2.f3257h = false;
                iVar2.f3250a = true;
                if (this.f3081c.k() == 0 && this.f3081c.h() == 0) {
                    z10 = true;
                }
                iVar2.f3258i = z10;
            }
            i11 = this.f3081c.n();
        }
        i12 = 0;
        if (getClipToPadding()) {
        }
        i iVar22 = this.f3085g;
        iVar22.f3257h = false;
        iVar22.f3250a = true;
        if (this.f3081c.k() == 0) {
            z10 = true;
        }
        iVar22.f3258i = z10;
    }

    public void e0(int i10) {
        this.f3084f = i10 / this.f3079a;
        this.f3096r = View.MeasureSpec.makeMeasureSpec(i10, this.f3082d.k());
    }

    public final void f0(f fVar, int i10, int i11) {
        int l10 = fVar.l();
        if (i10 == -1) {
            if (fVar.q() + l10 <= i11) {
                this.f3088j.set(fVar.f3133e, false);
            }
        } else if (fVar.m() - l10 >= i11) {
            this.f3088j.set(fVar.f3133e, false);
        }
    }

    public final void g(View view) {
        for (int i10 = this.f3079a - 1; i10 >= 0; i10--) {
            this.f3080b[i10].a(view);
        }
    }

    public final int g0(int i10, int i11, int i12) {
        if (i11 == 0 && i12 == 0) {
            return i10;
        }
        int mode = View.MeasureSpec.getMode(i10);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i10) - i11) - i12), mode) : i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p generateDefaultLayoutParams() {
        return this.f3083e == 0 ? new c(-2, -1) : new c(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int getColumnCountForAccessibility(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.f3083e == 1 ? this.f3079a : super.getColumnCountForAccessibility(vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int getRowCountForAccessibility(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.f3083e == 0 ? this.f3079a : super.getRowCountForAccessibility(vVar, a0Var);
    }

    public int getSpanCount() {
        return this.f3079a;
    }

    public final void h(b bVar) {
        e eVar = this.f3095q;
        int i10 = eVar.f3121c;
        if (i10 > 0) {
            if (i10 == this.f3079a) {
                for (int i11 = 0; i11 < this.f3079a; i11++) {
                    this.f3080b[i11].e();
                    e eVar2 = this.f3095q;
                    int i12 = eVar2.f3122d[i11];
                    if (i12 != Integer.MIN_VALUE) {
                        i12 += eVar2.f3127i ? this.f3081c.i() : this.f3081c.m();
                    }
                    this.f3080b[i11].x(i12);
                }
            } else {
                eVar.b();
                e eVar3 = this.f3095q;
                eVar3.f3119a = eVar3.f3120b;
            }
        }
        e eVar4 = this.f3095q;
        this.f3094p = eVar4.f3128j;
        setReverseLayout(eVar4.f3126h);
        X();
        e eVar5 = this.f3095q;
        int i13 = eVar5.f3119a;
        if (i13 != -1) {
            this.f3089k = i13;
            bVar.f3106c = eVar5.f3127i;
        } else {
            bVar.f3106c = this.f3087i;
        }
        if (eVar5.f3123e > 1) {
            d dVar = this.f3091m;
            dVar.f3113a = eVar5.f3124f;
            dVar.f3114b = eVar5.f3125g;
        }
    }

    public boolean i() {
        int n10 = this.f3080b[0].n(Integer.MIN_VALUE);
        for (int i10 = 1; i10 < this.f3079a; i10++) {
            if (this.f3080b[i10].n(Integer.MIN_VALUE) != n10) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean isAutoMeasureEnabled() {
        return this.f3092n != 0;
    }

    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    public boolean j() {
        int r10 = this.f3080b[0].r(Integer.MIN_VALUE);
        for (int i10 = 1; i10 < this.f3079a; i10++) {
            if (this.f3080b[i10].r(Integer.MIN_VALUE) != r10) {
                return false;
            }
        }
        return true;
    }

    public final void k(View view, c cVar, i iVar) {
        if (iVar.f3254e == 1) {
            if (cVar.f3112f) {
                g(view);
                return;
            } else {
                cVar.f3111e.a(view);
                return;
            }
        }
        if (cVar.f3112f) {
            S(view);
        } else {
            cVar.f3111e.w(view);
        }
    }

    public final int l(int i10) {
        if (getChildCount() == 0) {
            return this.f3087i ? 1 : -1;
        }
        return (i10 < D()) != this.f3087i ? -1 : 1;
    }

    public boolean m() {
        int D;
        int E;
        if (getChildCount() == 0 || this.f3092n == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.f3087i) {
            D = E();
            E = D();
        } else {
            D = D();
            E = E();
        }
        if (D == 0 && L() != null) {
            this.f3091m.b();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
        if (!this.f3099u) {
            return false;
        }
        int i10 = this.f3087i ? -1 : 1;
        int i11 = E + 1;
        d.a e10 = this.f3091m.e(D, i11, i10, true);
        if (e10 == null) {
            this.f3099u = false;
            this.f3091m.d(i11);
            return false;
        }
        d.a e11 = this.f3091m.e(D, e10.f3115a, i10 * (-1), true);
        if (e11 == null) {
            this.f3091m.d(e10.f3115a);
        } else {
            this.f3091m.d(e11.f3115a + 1);
        }
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        return true;
    }

    public final boolean n(f fVar) {
        if (this.f3087i) {
            if (fVar.m() < this.f3081c.i()) {
                ArrayList arrayList = fVar.f3129a;
                return !fVar.p((View) arrayList.get(arrayList.size() - 1)).f3112f;
            }
        } else if (fVar.q() > this.f3081c.m()) {
            return !fVar.p((View) fVar.f3129a.get(0)).f3112f;
        }
        return false;
    }

    public final int o(RecyclerView.a0 a0Var) {
        if (getChildCount() == 0) {
            return 0;
        }
        return p.a(a0Var, this.f3081c, x(!this.f3100v), w(!this.f3100v), this, this.f3100v);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void offsetChildrenHorizontal(int i10) {
        super.offsetChildrenHorizontal(i10);
        for (int i11 = 0; i11 < this.f3079a; i11++) {
            this.f3080b[i11].t(i10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void offsetChildrenVertical(int i10) {
        super.offsetChildrenVertical(i10);
        for (int i11 = 0; i11 < this.f3079a; i11++) {
            this.f3080b[i11].t(i10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.onDetachedFromWindow(recyclerView, vVar);
        removeCallbacks(this.f3102x);
        for (int i10 = 0; i10 < this.f3079a; i10++) {
            this.f3080b[i10].e();
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View onFocusSearchFailed(View view, int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        View findContainingItemView;
        View o10;
        if (getChildCount() == 0 || (findContainingItemView = findContainingItemView(view)) == null) {
            return null;
        }
        X();
        int convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i10);
        if (convertFocusDirectionToLayoutDirection == Integer.MIN_VALUE) {
            return null;
        }
        c cVar = (c) findContainingItemView.getLayoutParams();
        boolean z10 = cVar.f3112f;
        f fVar = cVar.f3111e;
        int E = convertFocusDirectionToLayoutDirection == 1 ? E() : D();
        d0(E, a0Var);
        Y(convertFocusDirectionToLayoutDirection);
        i iVar = this.f3085g;
        iVar.f3252c = iVar.f3253d + E;
        iVar.f3251b = (int) (this.f3081c.n() * 0.33333334f);
        i iVar2 = this.f3085g;
        iVar2.f3257h = true;
        iVar2.f3250a = false;
        u(vVar, iVar2, a0Var);
        this.f3093o = this.f3087i;
        if (!z10 && (o10 = fVar.o(E, convertFocusDirectionToLayoutDirection)) != null && o10 != findContainingItemView) {
            return o10;
        }
        if (Q(convertFocusDirectionToLayoutDirection)) {
            for (int i11 = this.f3079a - 1; i11 >= 0; i11--) {
                View o11 = this.f3080b[i11].o(E, convertFocusDirectionToLayoutDirection);
                if (o11 != null && o11 != findContainingItemView) {
                    return o11;
                }
            }
        } else {
            for (int i12 = 0; i12 < this.f3079a; i12++) {
                View o12 = this.f3080b[i12].o(E, convertFocusDirectionToLayoutDirection);
                if (o12 != null && o12 != findContainingItemView) {
                    return o12;
                }
            }
        }
        boolean z11 = (this.f3086h ^ true) == (convertFocusDirectionToLayoutDirection == -1);
        if (!z10) {
            View findViewByPosition = findViewByPosition(z11 ? fVar.f() : fVar.h());
            if (findViewByPosition != null && findViewByPosition != findContainingItemView) {
                return findViewByPosition;
            }
        }
        if (Q(convertFocusDirectionToLayoutDirection)) {
            for (int i13 = this.f3079a - 1; i13 >= 0; i13--) {
                if (i13 != fVar.f3133e) {
                    View findViewByPosition2 = findViewByPosition(z11 ? this.f3080b[i13].f() : this.f3080b[i13].h());
                    if (findViewByPosition2 != null && findViewByPosition2 != findContainingItemView) {
                        return findViewByPosition2;
                    }
                }
            }
        } else {
            for (int i14 = 0; i14 < this.f3079a; i14++) {
                View findViewByPosition3 = findViewByPosition(z11 ? this.f3080b[i14].f() : this.f3080b[i14].h());
                if (findViewByPosition3 != null && findViewByPosition3 != findContainingItemView) {
                    return findViewByPosition3;
                }
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View x10 = x(false);
            View w10 = w(false);
            if (x10 == null || w10 == null) {
                return;
            }
            int position = getPosition(x10);
            int position2 = getPosition(w10);
            if (position < position2) {
                accessibilityEvent.setFromIndex(position);
                accessibilityEvent.setToIndex(position2);
            } else {
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.v vVar, RecyclerView.a0 a0Var, View view, g0 g0Var) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof c)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, g0Var);
            return;
        }
        c cVar = (c) layoutParams;
        if (this.f3083e == 0) {
            g0Var.Z(g0.c.a(cVar.e(), cVar.f3112f ? this.f3079a : 1, -1, -1, false, false));
        } else {
            g0Var.Z(g0.c.a(-1, -1, cVar.e(), cVar.f3112f ? this.f3079a : 1, false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsAdded(RecyclerView recyclerView, int i10, int i11) {
        K(i10, i11, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsChanged(RecyclerView recyclerView) {
        this.f3091m.b();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsMoved(RecyclerView recyclerView, int i10, int i11, int i12) {
        K(i10, i11, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsRemoved(RecyclerView recyclerView, int i10, int i11) {
        K(i10, i11, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsUpdated(RecyclerView recyclerView, int i10, int i11, Object obj) {
        K(i10, i11, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onLayoutChildren(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        P(vVar, a0Var, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onLayoutCompleted(RecyclerView.a0 a0Var) {
        super.onLayoutCompleted(a0Var);
        this.f3089k = -1;
        this.f3090l = Integer.MIN_VALUE;
        this.f3095q = null;
        this.f3098t.c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof e) {
            this.f3095q = (e) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable onSaveInstanceState() {
        int r10;
        int m10;
        int[] iArr;
        if (this.f3095q != null) {
            return new e(this.f3095q);
        }
        e eVar = new e();
        eVar.f3126h = this.f3086h;
        eVar.f3127i = this.f3093o;
        eVar.f3128j = this.f3094p;
        d dVar = this.f3091m;
        if (dVar == null || (iArr = dVar.f3113a) == null) {
            eVar.f3123e = 0;
        } else {
            eVar.f3124f = iArr;
            eVar.f3123e = iArr.length;
            eVar.f3125g = dVar.f3114b;
        }
        if (getChildCount() > 0) {
            eVar.f3119a = this.f3093o ? E() : D();
            eVar.f3120b = y();
            int i10 = this.f3079a;
            eVar.f3121c = i10;
            eVar.f3122d = new int[i10];
            for (int i11 = 0; i11 < this.f3079a; i11++) {
                if (this.f3093o) {
                    r10 = this.f3080b[i11].n(Integer.MIN_VALUE);
                    if (r10 != Integer.MIN_VALUE) {
                        m10 = this.f3081c.i();
                        r10 -= m10;
                        eVar.f3122d[i11] = r10;
                    } else {
                        eVar.f3122d[i11] = r10;
                    }
                } else {
                    r10 = this.f3080b[i11].r(Integer.MIN_VALUE);
                    if (r10 != Integer.MIN_VALUE) {
                        m10 = this.f3081c.m();
                        r10 -= m10;
                        eVar.f3122d[i11] = r10;
                    } else {
                        eVar.f3122d[i11] = r10;
                    }
                }
            }
        } else {
            eVar.f3119a = -1;
            eVar.f3120b = -1;
            eVar.f3121c = 0;
        }
        return eVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onScrollStateChanged(int i10) {
        if (i10 == 0) {
            m();
        }
    }

    public final int p(RecyclerView.a0 a0Var) {
        if (getChildCount() == 0) {
            return 0;
        }
        return p.b(a0Var, this.f3081c, x(!this.f3100v), w(!this.f3100v), this, this.f3100v, this.f3087i);
    }

    public final int q(RecyclerView.a0 a0Var) {
        if (getChildCount() == 0) {
            return 0;
        }
        return p.c(a0Var, this.f3081c, x(!this.f3100v), w(!this.f3100v), this, this.f3100v);
    }

    public final d.a r(int i10) {
        d.a aVar = new d.a();
        aVar.f3117c = new int[this.f3079a];
        for (int i11 = 0; i11 < this.f3079a; i11++) {
            aVar.f3117c[i11] = i10 - this.f3080b[i11].n(i10);
        }
        return aVar;
    }

    public final d.a s(int i10) {
        d.a aVar = new d.a();
        aVar.f3117c = new int[this.f3079a];
        for (int i11 = 0; i11 < this.f3079a; i11++) {
            aVar.f3117c[i11] = this.f3080b[i11].r(i10) - i10;
        }
        return aVar;
    }

    public int scrollBy(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (getChildCount() == 0 || i10 == 0) {
            return 0;
        }
        R(i10, a0Var);
        int u10 = u(vVar, this.f3085g, a0Var);
        if (this.f3085g.f3251b >= u10) {
            i10 = i10 < 0 ? -u10 : u10;
        }
        this.f3081c.r(-i10);
        this.f3093o = this.f3087i;
        i iVar = this.f3085g;
        iVar.f3251b = 0;
        T(vVar, iVar);
        return i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int scrollHorizontallyBy(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return scrollBy(i10, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void scrollToPosition(int i10) {
        e eVar = this.f3095q;
        if (eVar != null && eVar.f3119a != i10) {
            eVar.a();
        }
        this.f3089k = i10;
        this.f3090l = Integer.MIN_VALUE;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int scrollVerticallyBy(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return scrollBy(i10, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void setMeasuredDimension(Rect rect, int i10, int i11) {
        int chooseSize;
        int chooseSize2;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.f3083e == 1) {
            chooseSize2 = RecyclerView.o.chooseSize(i11, rect.height() + paddingTop, getMinimumHeight());
            chooseSize = RecyclerView.o.chooseSize(i10, (this.f3084f * this.f3079a) + paddingLeft, getMinimumWidth());
        } else {
            chooseSize = RecyclerView.o.chooseSize(i10, rect.width() + paddingLeft, getMinimumWidth());
            chooseSize2 = RecyclerView.o.chooseSize(i11, (this.f3084f * this.f3079a) + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(chooseSize, chooseSize2);
    }

    public void setOrientation(int i10) {
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        assertNotInLayoutOrScroll(null);
        if (i10 == this.f3083e) {
            return;
        }
        this.f3083e = i10;
        m mVar = this.f3081c;
        this.f3081c = this.f3082d;
        this.f3082d = mVar;
        requestLayout();
    }

    public void setReverseLayout(boolean z10) {
        assertNotInLayoutOrScroll(null);
        e eVar = this.f3095q;
        if (eVar != null && eVar.f3126h != z10) {
            eVar.f3126h = z10;
        }
        this.f3086h = z10;
        requestLayout();
    }

    public void setSpanCount(int i10) {
        assertNotInLayoutOrScroll(null);
        if (i10 != this.f3079a) {
            M();
            this.f3079a = i10;
            this.f3088j = new BitSet(this.f3079a);
            this.f3080b = new f[this.f3079a];
            for (int i11 = 0; i11 < this.f3079a; i11++) {
                this.f3080b[i11] = new f(i11);
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.a0 a0Var, int i10) {
        j jVar = new j(recyclerView.getContext());
        jVar.setTargetPosition(i10);
        startSmoothScroll(jVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean supportsPredictiveItemAnimations() {
        return this.f3095q == null;
    }

    public final void t() {
        this.f3081c = m.b(this, this.f3083e);
        this.f3082d = m.b(this, 1 - this.f3083e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    public final int u(RecyclerView.v vVar, i iVar, RecyclerView.a0 a0Var) {
        int i10;
        f fVar;
        int e10;
        int i11;
        int i12;
        int e11;
        ?? r92 = 0;
        this.f3088j.set(0, this.f3079a, true);
        if (this.f3085g.f3258i) {
            i10 = iVar.f3254e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            i10 = iVar.f3254e == 1 ? iVar.f3256g + iVar.f3251b : iVar.f3255f - iVar.f3251b;
        }
        Z(iVar.f3254e, i10);
        int i13 = this.f3087i ? this.f3081c.i() : this.f3081c.m();
        boolean z10 = false;
        while (iVar.a(a0Var) && (this.f3085g.f3258i || !this.f3088j.isEmpty())) {
            View b10 = iVar.b(vVar);
            c cVar = (c) b10.getLayoutParams();
            int a10 = cVar.a();
            int g10 = this.f3091m.g(a10);
            boolean z11 = g10 == -1;
            if (z11) {
                fVar = cVar.f3112f ? this.f3080b[r92] : J(iVar);
                this.f3091m.n(a10, fVar);
            } else {
                fVar = this.f3080b[g10];
            }
            f fVar2 = fVar;
            cVar.f3111e = fVar2;
            if (iVar.f3254e == 1) {
                addView(b10);
            } else {
                addView(b10, r92);
            }
            O(b10, cVar, r92);
            if (iVar.f3254e == 1) {
                int F = cVar.f3112f ? F(i13) : fVar2.n(i13);
                int e12 = this.f3081c.e(b10) + F;
                if (z11 && cVar.f3112f) {
                    d.a r10 = r(F);
                    r10.f3116b = -1;
                    r10.f3115a = a10;
                    this.f3091m.a(r10);
                }
                i11 = e12;
                e10 = F;
            } else {
                int I = cVar.f3112f ? I(i13) : fVar2.r(i13);
                e10 = I - this.f3081c.e(b10);
                if (z11 && cVar.f3112f) {
                    d.a s10 = s(I);
                    s10.f3116b = 1;
                    s10.f3115a = a10;
                    this.f3091m.a(s10);
                }
                i11 = I;
            }
            if (cVar.f3112f && iVar.f3253d == -1) {
                if (z11) {
                    this.f3099u = true;
                } else {
                    if (!(iVar.f3254e == 1 ? i() : j())) {
                        d.a f10 = this.f3091m.f(a10);
                        if (f10 != null) {
                            f10.f3118d = true;
                        }
                        this.f3099u = true;
                    }
                }
            }
            k(b10, cVar, iVar);
            if (isLayoutRTL() && this.f3083e == 1) {
                int i14 = cVar.f3112f ? this.f3082d.i() : this.f3082d.i() - (((this.f3079a - 1) - fVar2.f3133e) * this.f3084f);
                e11 = i14;
                i12 = i14 - this.f3082d.e(b10);
            } else {
                int m10 = cVar.f3112f ? this.f3082d.m() : (fVar2.f3133e * this.f3084f) + this.f3082d.m();
                i12 = m10;
                e11 = this.f3082d.e(b10) + m10;
            }
            if (this.f3083e == 1) {
                layoutDecoratedWithMargins(b10, i12, e10, e11, i11);
            } else {
                layoutDecoratedWithMargins(b10, e10, i12, i11, e11);
            }
            if (cVar.f3112f) {
                Z(this.f3085g.f3254e, i10);
            } else {
                f0(fVar2, this.f3085g.f3254e, i10);
            }
            T(vVar, this.f3085g);
            if (this.f3085g.f3257h && b10.hasFocusable()) {
                if (cVar.f3112f) {
                    this.f3088j.clear();
                } else {
                    this.f3088j.set(fVar2.f3133e, false);
                    z10 = true;
                    r92 = 0;
                }
            }
            z10 = true;
            r92 = 0;
        }
        if (!z10) {
            T(vVar, this.f3085g);
        }
        int m11 = this.f3085g.f3254e == -1 ? this.f3081c.m() - I(this.f3081c.m()) : F(this.f3081c.i()) - this.f3081c.i();
        if (m11 > 0) {
            return Math.min(iVar.f3251b, m11);
        }
        return 0;
    }

    public final int v(int i10) {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            int position = getPosition(getChildAt(i11));
            if (position >= 0 && position < i10) {
                return position;
            }
        }
        return 0;
    }

    public View w(boolean z10) {
        int m10 = this.f3081c.m();
        int i10 = this.f3081c.i();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int g10 = this.f3081c.g(childAt);
            int d10 = this.f3081c.d(childAt);
            if (d10 > m10 && g10 < i10) {
                if (d10 <= i10 || !z10) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public View x(boolean z10) {
        int m10 = this.f3081c.m();
        int i10 = this.f3081c.i();
        int childCount = getChildCount();
        View view = null;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            int g10 = this.f3081c.g(childAt);
            if (this.f3081c.d(childAt) > m10 && g10 < i10) {
                if (g10 >= m10 || !z10) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public int y() {
        View w10 = this.f3087i ? w(true) : x(true);
        if (w10 == null) {
            return -1;
        }
        return getPosition(w10);
    }

    public int[] z(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f3079a];
        } else if (iArr.length < this.f3079a) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f3079a + ", array size:" + iArr.length);
        }
        for (int i10 = 0; i10 < this.f3079a; i10++) {
            iArr[i10] = this.f3080b[i10].g();
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public int[] f3113a;

        /* renamed from: b, reason: collision with root package name */
        public List f3114b;

        public void a(a aVar) {
            if (this.f3114b == null) {
                this.f3114b = new ArrayList();
            }
            int size = this.f3114b.size();
            for (int i10 = 0; i10 < size; i10++) {
                a aVar2 = (a) this.f3114b.get(i10);
                if (aVar2.f3115a == aVar.f3115a) {
                    this.f3114b.remove(i10);
                }
                if (aVar2.f3115a >= aVar.f3115a) {
                    this.f3114b.add(i10, aVar);
                    return;
                }
            }
            this.f3114b.add(aVar);
        }

        public void b() {
            int[] iArr = this.f3113a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f3114b = null;
        }

        public void c(int i10) {
            int[] iArr = this.f3113a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i10, 10) + 1];
                this.f3113a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i10 >= iArr.length) {
                int[] iArr3 = new int[o(i10)];
                this.f3113a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f3113a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        public int d(int i10) {
            List list = this.f3114b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (((a) this.f3114b.get(size)).f3115a >= i10) {
                        this.f3114b.remove(size);
                    }
                }
            }
            return h(i10);
        }

        public a e(int i10, int i11, int i12, boolean z10) {
            List list = this.f3114b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i13 = 0; i13 < size; i13++) {
                a aVar = (a) this.f3114b.get(i13);
                int i14 = aVar.f3115a;
                if (i14 >= i11) {
                    return null;
                }
                if (i14 >= i10 && (i12 == 0 || aVar.f3116b == i12 || (z10 && aVar.f3118d))) {
                    return aVar;
                }
            }
            return null;
        }

        public a f(int i10) {
            List list = this.f3114b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = (a) this.f3114b.get(size);
                if (aVar.f3115a == i10) {
                    return aVar;
                }
            }
            return null;
        }

        public int g(int i10) {
            int[] iArr = this.f3113a;
            if (iArr == null || i10 >= iArr.length) {
                return -1;
            }
            return iArr[i10];
        }

        public int h(int i10) {
            int[] iArr = this.f3113a;
            if (iArr == null || i10 >= iArr.length) {
                return -1;
            }
            int i11 = i(i10);
            if (i11 == -1) {
                int[] iArr2 = this.f3113a;
                Arrays.fill(iArr2, i10, iArr2.length, -1);
                return this.f3113a.length;
            }
            int i12 = i11 + 1;
            Arrays.fill(this.f3113a, i10, i12, -1);
            return i12;
        }

        public final int i(int i10) {
            if (this.f3114b == null) {
                return -1;
            }
            a f10 = f(i10);
            if (f10 != null) {
                this.f3114b.remove(f10);
            }
            int size = this.f3114b.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    i11 = -1;
                    break;
                }
                if (((a) this.f3114b.get(i11)).f3115a >= i10) {
                    break;
                }
                i11++;
            }
            if (i11 == -1) {
                return -1;
            }
            a aVar = (a) this.f3114b.get(i11);
            this.f3114b.remove(i11);
            return aVar.f3115a;
        }

        public void j(int i10, int i11) {
            int[] iArr = this.f3113a;
            if (iArr == null || i10 >= iArr.length) {
                return;
            }
            int i12 = i10 + i11;
            c(i12);
            int[] iArr2 = this.f3113a;
            System.arraycopy(iArr2, i10, iArr2, i12, (iArr2.length - i10) - i11);
            Arrays.fill(this.f3113a, i10, i12, -1);
            l(i10, i11);
        }

        public void k(int i10, int i11) {
            int[] iArr = this.f3113a;
            if (iArr == null || i10 >= iArr.length) {
                return;
            }
            int i12 = i10 + i11;
            c(i12);
            int[] iArr2 = this.f3113a;
            System.arraycopy(iArr2, i12, iArr2, i10, (iArr2.length - i10) - i11);
            int[] iArr3 = this.f3113a;
            Arrays.fill(iArr3, iArr3.length - i11, iArr3.length, -1);
            m(i10, i11);
        }

        public final void l(int i10, int i11) {
            List list = this.f3114b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = (a) this.f3114b.get(size);
                int i12 = aVar.f3115a;
                if (i12 >= i10) {
                    aVar.f3115a = i12 + i11;
                }
            }
        }

        public final void m(int i10, int i11) {
            List list = this.f3114b;
            if (list == null) {
                return;
            }
            int i12 = i10 + i11;
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = (a) this.f3114b.get(size);
                int i13 = aVar.f3115a;
                if (i13 >= i10) {
                    if (i13 < i12) {
                        this.f3114b.remove(size);
                    } else {
                        aVar.f3115a = i13 - i11;
                    }
                }
            }
        }

        public void n(int i10, f fVar) {
            c(i10);
            this.f3113a[i10] = fVar.f3133e;
        }

        public int o(int i10) {
            int length = this.f3113a.length;
            while (length <= i10) {
                length *= 2;
            }
            return length;
        }

        public static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new C0042a();

            /* renamed from: a, reason: collision with root package name */
            public int f3115a;

            /* renamed from: b, reason: collision with root package name */
            public int f3116b;

            /* renamed from: c, reason: collision with root package name */
            public int[] f3117c;

            /* renamed from: d, reason: collision with root package name */
            public boolean f3118d;

            /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a$a, reason: collision with other inner class name */
            public static class C0042a implements Parcelable.Creator {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public a[] newArray(int i10) {
                    return new a[i10];
                }
            }

            public a(Parcel parcel) {
                this.f3115a = parcel.readInt();
                this.f3116b = parcel.readInt();
                this.f3118d = parcel.readInt() == 1;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.f3117c = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            public int a(int i10) {
                int[] iArr = this.f3117c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i10];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f3115a + ", mGapDir=" + this.f3116b + ", mHasUnwantedGapAfter=" + this.f3118d + ", mGapPerSpan=" + Arrays.toString(this.f3117c) + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i10) {
                parcel.writeInt(this.f3115a);
                parcel.writeInt(this.f3116b);
                parcel.writeInt(this.f3118d ? 1 : 0);
                int[] iArr = this.f3117c;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f3117c);
                }
            }

            public a() {
            }
        }
    }
}
