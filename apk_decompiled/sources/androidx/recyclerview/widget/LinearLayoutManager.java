package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.umeng.analytics.pro.q;
import java.util.List;

/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.o implements f.b, RecyclerView.z.b {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final a mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final b mLayoutChunkResult;
    private c mLayoutState;
    int mOrientation;
    m mOrientationHelper;
    d mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public m f2981a;

        /* renamed from: b, reason: collision with root package name */
        public int f2982b;

        /* renamed from: c, reason: collision with root package name */
        public int f2983c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f2984d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f2985e;

        public a() {
            e();
        }

        public void a() {
            this.f2983c = this.f2984d ? this.f2981a.i() : this.f2981a.m();
        }

        public void b(View view, int i10) {
            if (this.f2984d) {
                this.f2983c = this.f2981a.d(view) + this.f2981a.o();
            } else {
                this.f2983c = this.f2981a.g(view);
            }
            this.f2982b = i10;
        }

        public void c(View view, int i10) {
            int o10 = this.f2981a.o();
            if (o10 >= 0) {
                b(view, i10);
                return;
            }
            this.f2982b = i10;
            if (this.f2984d) {
                int i11 = (this.f2981a.i() - o10) - this.f2981a.d(view);
                this.f2983c = this.f2981a.i() - i11;
                if (i11 > 0) {
                    int e10 = this.f2983c - this.f2981a.e(view);
                    int m10 = this.f2981a.m();
                    int min = e10 - (m10 + Math.min(this.f2981a.g(view) - m10, 0));
                    if (min < 0) {
                        this.f2983c += Math.min(i11, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int g10 = this.f2981a.g(view);
            int m11 = g10 - this.f2981a.m();
            this.f2983c = g10;
            if (m11 > 0) {
                int i12 = (this.f2981a.i() - Math.min(0, (this.f2981a.i() - o10) - this.f2981a.d(view))) - (g10 + this.f2981a.e(view));
                if (i12 < 0) {
                    this.f2983c -= Math.min(m11, -i12);
                }
            }
        }

        public boolean d(View view, RecyclerView.a0 a0Var) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return !pVar.c() && pVar.a() >= 0 && pVar.a() < a0Var.b();
        }

        public void e() {
            this.f2982b = -1;
            this.f2983c = Integer.MIN_VALUE;
            this.f2984d = false;
            this.f2985e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f2982b + ", mCoordinate=" + this.f2983c + ", mLayoutFromEnd=" + this.f2984d + ", mValid=" + this.f2985e + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f2986a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f2987b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f2988c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f2989d;

        public void a() {
            this.f2986a = 0;
            this.f2987b = false;
            this.f2988c = false;
            this.f2989d = false;
        }
    }

    public static class c {

        /* renamed from: b, reason: collision with root package name */
        public int f2991b;

        /* renamed from: c, reason: collision with root package name */
        public int f2992c;

        /* renamed from: d, reason: collision with root package name */
        public int f2993d;

        /* renamed from: e, reason: collision with root package name */
        public int f2994e;

        /* renamed from: f, reason: collision with root package name */
        public int f2995f;

        /* renamed from: g, reason: collision with root package name */
        public int f2996g;

        /* renamed from: k, reason: collision with root package name */
        public int f3000k;

        /* renamed from: m, reason: collision with root package name */
        public boolean f3002m;

        /* renamed from: a, reason: collision with root package name */
        public boolean f2990a = true;

        /* renamed from: h, reason: collision with root package name */
        public int f2997h = 0;

        /* renamed from: i, reason: collision with root package name */
        public int f2998i = 0;

        /* renamed from: j, reason: collision with root package name */
        public boolean f2999j = false;

        /* renamed from: l, reason: collision with root package name */
        public List f3001l = null;

        public void a() {
            b(null);
        }

        public void b(View view) {
            View f10 = f(view);
            if (f10 == null) {
                this.f2993d = -1;
            } else {
                this.f2993d = ((RecyclerView.p) f10.getLayoutParams()).a();
            }
        }

        public boolean c(RecyclerView.a0 a0Var) {
            int i10 = this.f2993d;
            return i10 >= 0 && i10 < a0Var.b();
        }

        public View d(RecyclerView.v vVar) {
            if (this.f3001l != null) {
                return e();
            }
            View o10 = vVar.o(this.f2993d);
            this.f2993d += this.f2994e;
            return o10;
        }

        public final View e() {
            int size = this.f3001l.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = ((RecyclerView.d0) this.f3001l.get(i10)).itemView;
                RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
                if (!pVar.c() && this.f2993d == pVar.a()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public View f(View view) {
            int a10;
            int size = this.f3001l.size();
            View view2 = null;
            int i10 = Integer.MAX_VALUE;
            for (int i11 = 0; i11 < size; i11++) {
                View view3 = ((RecyclerView.d0) this.f3001l.get(i11)).itemView;
                RecyclerView.p pVar = (RecyclerView.p) view3.getLayoutParams();
                if (view3 != view && !pVar.c() && (a10 = (pVar.a() - this.f2993d) * this.f2994e) >= 0 && a10 < i10) {
                    view2 = view3;
                    if (a10 == 0) {
                        break;
                    }
                    i10 = a10;
                }
            }
            return view2;
        }
    }

    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public int f3003a;

        /* renamed from: b, reason: collision with root package name */
        public int f3004b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f3005c;

        public static class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i10) {
                return new d[i10];
            }
        }

        public d() {
        }

        public boolean a() {
            return this.f3003a >= 0;
        }

        public void b() {
            this.f3003a = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f3003a);
            parcel.writeInt(this.f3004b);
            parcel.writeInt(this.f3005c ? 1 : 0);
        }

        public d(Parcel parcel) {
            this.f3003a = parcel.readInt();
            this.f3004b = parcel.readInt();
            this.f3005c = parcel.readInt() == 1;
        }

        public d(d dVar) {
            this.f3003a = dVar.f3003a;
            this.f3004b = dVar.f3004b;
            this.f3005c = dVar.f3005c;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public final void A(RecyclerView.v vVar, int i10, int i11) {
        if (i10 < 0) {
            return;
        }
        int i12 = i10 - i11;
        int childCount = getChildCount();
        if (!this.mShouldReverseLayout) {
            for (int i13 = 0; i13 < childCount; i13++) {
                View childAt = getChildAt(i13);
                if (this.mOrientationHelper.d(childAt) > i12 || this.mOrientationHelper.p(childAt) > i12) {
                    y(vVar, 0, i13);
                    return;
                }
            }
            return;
        }
        int i14 = childCount - 1;
        for (int i15 = i14; i15 >= 0; i15--) {
            View childAt2 = getChildAt(i15);
            if (this.mOrientationHelper.d(childAt2) > i12 || this.mOrientationHelper.p(childAt2) > i12) {
                y(vVar, i14, i15);
                return;
            }
        }
    }

    public final void B() {
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            this.mShouldReverseLayout = this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = !this.mReverseLayout;
        }
    }

    public final boolean C(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar) {
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null && aVar.d(focusedChild, a0Var)) {
            aVar.c(focusedChild, getPosition(focusedChild));
            return true;
        }
        if (this.mLastStackFromEnd != this.mStackFromEnd) {
            return false;
        }
        View p10 = aVar.f2984d ? p(vVar, a0Var) : q(vVar, a0Var);
        if (p10 == null) {
            return false;
        }
        aVar.b(p10, getPosition(p10));
        if (!a0Var.e() && supportsPredictiveItemAnimations()) {
            if (this.mOrientationHelper.g(p10) >= this.mOrientationHelper.i() || this.mOrientationHelper.d(p10) < this.mOrientationHelper.m()) {
                aVar.f2983c = aVar.f2984d ? this.mOrientationHelper.i() : this.mOrientationHelper.m();
            }
        }
        return true;
    }

    public final boolean D(RecyclerView.a0 a0Var, a aVar) {
        int i10;
        if (!a0Var.e() && (i10 = this.mPendingScrollPosition) != -1) {
            if (i10 >= 0 && i10 < a0Var.b()) {
                aVar.f2982b = this.mPendingScrollPosition;
                d dVar = this.mPendingSavedState;
                if (dVar != null && dVar.a()) {
                    boolean z10 = this.mPendingSavedState.f3005c;
                    aVar.f2984d = z10;
                    if (z10) {
                        aVar.f2983c = this.mOrientationHelper.i() - this.mPendingSavedState.f3004b;
                    } else {
                        aVar.f2983c = this.mOrientationHelper.m() + this.mPendingSavedState.f3004b;
                    }
                    return true;
                }
                if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) {
                    boolean z11 = this.mShouldReverseLayout;
                    aVar.f2984d = z11;
                    if (z11) {
                        aVar.f2983c = this.mOrientationHelper.i() - this.mPendingScrollPositionOffset;
                    } else {
                        aVar.f2983c = this.mOrientationHelper.m() + this.mPendingScrollPositionOffset;
                    }
                    return true;
                }
                View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                if (findViewByPosition == null) {
                    if (getChildCount() > 0) {
                        aVar.f2984d = (this.mPendingScrollPosition < getPosition(getChildAt(0))) == this.mShouldReverseLayout;
                    }
                    aVar.a();
                } else {
                    if (this.mOrientationHelper.e(findViewByPosition) > this.mOrientationHelper.n()) {
                        aVar.a();
                        return true;
                    }
                    if (this.mOrientationHelper.g(findViewByPosition) - this.mOrientationHelper.m() < 0) {
                        aVar.f2983c = this.mOrientationHelper.m();
                        aVar.f2984d = false;
                        return true;
                    }
                    if (this.mOrientationHelper.i() - this.mOrientationHelper.d(findViewByPosition) < 0) {
                        aVar.f2983c = this.mOrientationHelper.i();
                        aVar.f2984d = true;
                        return true;
                    }
                    aVar.f2983c = aVar.f2984d ? this.mOrientationHelper.d(findViewByPosition) + this.mOrientationHelper.o() : this.mOrientationHelper.g(findViewByPosition);
                }
                return true;
            }
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        }
        return false;
    }

    public final void E(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar) {
        if (D(a0Var, aVar) || C(vVar, a0Var, aVar)) {
            return;
        }
        aVar.a();
        aVar.f2982b = this.mStackFromEnd ? a0Var.b() - 1 : 0;
    }

    public final void F(int i10, int i11, boolean z10, RecyclerView.a0 a0Var) {
        int m10;
        this.mLayoutState.f3002m = resolveIsInfinite();
        this.mLayoutState.f2995f = i10;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(a0Var, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]);
        int max2 = Math.max(0, this.mReusableIntPair[1]);
        boolean z11 = i10 == 1;
        c cVar = this.mLayoutState;
        int i12 = z11 ? max2 : max;
        cVar.f2997h = i12;
        if (!z11) {
            max = max2;
        }
        cVar.f2998i = max;
        if (z11) {
            cVar.f2997h = i12 + this.mOrientationHelper.j();
            View t10 = t();
            c cVar2 = this.mLayoutState;
            cVar2.f2994e = this.mShouldReverseLayout ? -1 : 1;
            int position = getPosition(t10);
            c cVar3 = this.mLayoutState;
            cVar2.f2993d = position + cVar3.f2994e;
            cVar3.f2991b = this.mOrientationHelper.d(t10);
            m10 = this.mOrientationHelper.d(t10) - this.mOrientationHelper.i();
        } else {
            View u10 = u();
            this.mLayoutState.f2997h += this.mOrientationHelper.m();
            c cVar4 = this.mLayoutState;
            cVar4.f2994e = this.mShouldReverseLayout ? 1 : -1;
            int position2 = getPosition(u10);
            c cVar5 = this.mLayoutState;
            cVar4.f2993d = position2 + cVar5.f2994e;
            cVar5.f2991b = this.mOrientationHelper.g(u10);
            m10 = (-this.mOrientationHelper.g(u10)) + this.mOrientationHelper.m();
        }
        c cVar6 = this.mLayoutState;
        cVar6.f2992c = i11;
        if (z10) {
            cVar6.f2992c = i11 - m10;
        }
        cVar6.f2996g = m10;
    }

    public final void G(int i10, int i11) {
        this.mLayoutState.f2992c = this.mOrientationHelper.i() - i11;
        c cVar = this.mLayoutState;
        cVar.f2994e = this.mShouldReverseLayout ? -1 : 1;
        cVar.f2993d = i10;
        cVar.f2995f = 1;
        cVar.f2991b = i11;
        cVar.f2996g = Integer.MIN_VALUE;
    }

    public final void H(a aVar) {
        G(aVar.f2982b, aVar.f2983c);
    }

    public final void I(int i10, int i11) {
        this.mLayoutState.f2992c = i11 - this.mOrientationHelper.m();
        c cVar = this.mLayoutState;
        cVar.f2993d = i10;
        cVar.f2994e = this.mShouldReverseLayout ? 1 : -1;
        cVar.f2995f = -1;
        cVar.f2991b = i11;
        cVar.f2996g = Integer.MIN_VALUE;
    }

    public final void J(a aVar) {
        I(aVar.f2982b, aVar.f2983c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public void calculateExtraLayoutSpace(RecyclerView.a0 a0Var, int[] iArr) {
        int i10;
        int extraLayoutSpace = getExtraLayoutSpace(a0Var);
        if (this.mLayoutState.f2995f == -1) {
            i10 = 0;
        } else {
            i10 = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void collectAdjacentPrefetchPositions(int i10, int i11, RecyclerView.a0 a0Var, RecyclerView.o.c cVar) {
        if (this.mOrientation != 0) {
            i10 = i11;
        }
        if (getChildCount() == 0 || i10 == 0) {
            return;
        }
        ensureLayoutState();
        F(i10 > 0 ? 1 : -1, Math.abs(i10), true, a0Var);
        collectPrefetchPositionsForLayoutState(a0Var, this.mLayoutState, cVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void collectInitialPrefetchPositions(int i10, RecyclerView.o.c cVar) {
        boolean z10;
        int i11;
        d dVar = this.mPendingSavedState;
        if (dVar == null || !dVar.a()) {
            B();
            z10 = this.mShouldReverseLayout;
            i11 = this.mPendingScrollPosition;
            if (i11 == -1) {
                i11 = z10 ? i10 - 1 : 0;
            }
        } else {
            d dVar2 = this.mPendingSavedState;
            z10 = dVar2.f3005c;
            i11 = dVar2.f3003a;
        }
        int i12 = z10 ? -1 : 1;
        for (int i13 = 0; i13 < this.mInitialPrefetchItemCount && i11 >= 0 && i11 < i10; i13++) {
            cVar.a(i11, 0);
            i11 += i12;
        }
    }

    public void collectPrefetchPositionsForLayoutState(RecyclerView.a0 a0Var, c cVar, RecyclerView.o.c cVar2) {
        int i10 = cVar.f2993d;
        if (i10 < 0 || i10 >= a0Var.b()) {
            return;
        }
        cVar2.a(i10, Math.max(0, cVar.f2996g));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollExtent(RecyclerView.a0 a0Var) {
        return g(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollOffset(RecyclerView.a0 a0Var) {
        return h(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollRange(RecyclerView.a0 a0Var) {
        return i(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z.b
    public PointF computeScrollVectorForPosition(int i10) {
        if (getChildCount() == 0) {
            return null;
        }
        int i11 = (i10 < getPosition(getChildAt(0))) != this.mShouldReverseLayout ? -1 : 1;
        return this.mOrientation == 0 ? new PointF(i11, 0.0f) : new PointF(0.0f, i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollExtent(RecyclerView.a0 a0Var) {
        return g(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollOffset(RecyclerView.a0 a0Var) {
        return h(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollRange(RecyclerView.a0 a0Var) {
        return i(a0Var);
    }

    public int convertFocusDirectionToLayoutDirection(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 17 ? i10 != 33 ? i10 != 66 ? (i10 == 130 && this.mOrientation == 1) ? 1 : Integer.MIN_VALUE : this.mOrientation == 0 ? 1 : Integer.MIN_VALUE : this.mOrientation == 1 ? -1 : Integer.MIN_VALUE : this.mOrientation == 0 ? -1 : Integer.MIN_VALUE : (this.mOrientation != 1 && isLayoutRTL()) ? -1 : 1 : (this.mOrientation != 1 && isLayoutRTL()) ? 1 : -1;
    }

    public c createLayoutState() {
        return new c();
    }

    public void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    public int fill(RecyclerView.v vVar, c cVar, RecyclerView.a0 a0Var, boolean z10) {
        int i10 = cVar.f2992c;
        int i11 = cVar.f2996g;
        if (i11 != Integer.MIN_VALUE) {
            if (i10 < 0) {
                cVar.f2996g = i11 + i10;
            }
            x(vVar, cVar);
        }
        int i12 = cVar.f2992c + cVar.f2997h;
        b bVar = this.mLayoutChunkResult;
        while (true) {
            if ((!cVar.f3002m && i12 <= 0) || !cVar.c(a0Var)) {
                break;
            }
            bVar.a();
            layoutChunk(vVar, a0Var, cVar, bVar);
            if (!bVar.f2987b) {
                cVar.f2991b += bVar.f2986a * cVar.f2995f;
                if (!bVar.f2988c || cVar.f3001l != null || !a0Var.e()) {
                    int i13 = cVar.f2992c;
                    int i14 = bVar.f2986a;
                    cVar.f2992c = i13 - i14;
                    i12 -= i14;
                }
                int i15 = cVar.f2996g;
                if (i15 != Integer.MIN_VALUE) {
                    int i16 = i15 + bVar.f2986a;
                    cVar.f2996g = i16;
                    int i17 = cVar.f2992c;
                    if (i17 < 0) {
                        cVar.f2996g = i16 + i17;
                    }
                    x(vVar, cVar);
                }
                if (z10 && bVar.f2989d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i10 - cVar.f2992c;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public View findFirstVisibleChildClosestToEnd(boolean z10, boolean z11) {
        return this.mShouldReverseLayout ? findOneVisibleChild(0, getChildCount(), z10, z11) : findOneVisibleChild(getChildCount() - 1, -1, z10, z11);
    }

    public View findFirstVisibleChildClosestToStart(boolean z10, boolean z11) {
        return this.mShouldReverseLayout ? findOneVisibleChild(getChildCount() - 1, -1, z10, z11) : findOneVisibleChild(0, getChildCount(), z10, z11);
    }

    public int findFirstVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public View findOnePartiallyOrCompletelyInvisibleChild(int i10, int i11) {
        int i12;
        int i13;
        ensureLayoutState();
        if ((i11 > i10 ? (char) 1 : i11 < i10 ? (char) 65535 : (char) 0) == 0) {
            return getChildAt(i10);
        }
        if (this.mOrientationHelper.g(getChildAt(i10)) < this.mOrientationHelper.m()) {
            i12 = 16644;
            i13 = 16388;
        } else {
            i12 = 4161;
            i13 = q.a.f10521a;
        }
        return this.mOrientation == 0 ? this.mHorizontalBoundCheck.a(i10, i11, i12, i13) : this.mVerticalBoundCheck.a(i10, i11, i12, i13);
    }

    public View findOneVisibleChild(int i10, int i11, boolean z10, boolean z11) {
        ensureLayoutState();
        int i12 = z10 ? 24579 : 320;
        int i13 = z11 ? 320 : 0;
        return this.mOrientation == 0 ? this.mHorizontalBoundCheck.a(i10, i11, i12, i13) : this.mVerticalBoundCheck.a(i10, i11, i12, i13);
    }

    public View findReferenceChild(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i10, int i11, int i12) {
        ensureLayoutState();
        int m10 = this.mOrientationHelper.m();
        int i13 = this.mOrientationHelper.i();
        int i14 = i11 > i10 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i10 != i11) {
            View childAt = getChildAt(i10);
            int position = getPosition(childAt);
            if (position >= 0 && position < i12) {
                if (((RecyclerView.p) childAt.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.mOrientationHelper.g(childAt) < i13 && this.mOrientationHelper.d(childAt) >= m10) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i10 += i14;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View findViewByPosition(int i10) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i10 - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i10) {
                return childAt;
            }
        }
        return super.findViewByPosition(i10);
    }

    public final int g(RecyclerView.a0 a0Var) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return p.a(a0Var, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p generateDefaultLayoutParams() {
        return new RecyclerView.p(-2, -2);
    }

    @Deprecated
    public int getExtraLayoutSpace(RecyclerView.a0 a0Var) {
        if (a0Var.d()) {
            return this.mOrientationHelper.n();
        }
        return 0;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    public final int h(RecyclerView.a0 a0Var) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return p.b(a0Var, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    public final int i(RecyclerView.a0 a0Var) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return p.c(a0Var, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    public final View j() {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    public final View k(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return findReferenceChild(vVar, a0Var, 0, getChildCount(), a0Var.b());
    }

    public final View l() {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    public void layoutChunk(RecyclerView.v vVar, RecyclerView.a0 a0Var, c cVar, b bVar) {
        int i10;
        int i11;
        int i12;
        int i13;
        int f10;
        View d10 = cVar.d(vVar);
        if (d10 == null) {
            bVar.f2987b = true;
            return;
        }
        RecyclerView.p pVar = (RecyclerView.p) d10.getLayoutParams();
        if (cVar.f3001l == null) {
            if (this.mShouldReverseLayout == (cVar.f2995f == -1)) {
                addView(d10);
            } else {
                addView(d10, 0);
            }
        } else {
            if (this.mShouldReverseLayout == (cVar.f2995f == -1)) {
                addDisappearingView(d10);
            } else {
                addDisappearingView(d10, 0);
            }
        }
        measureChildWithMargins(d10, 0, 0);
        bVar.f2986a = this.mOrientationHelper.e(d10);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                f10 = getWidth() - getPaddingRight();
                i13 = f10 - this.mOrientationHelper.f(d10);
            } else {
                i13 = getPaddingLeft();
                f10 = this.mOrientationHelper.f(d10) + i13;
            }
            if (cVar.f2995f == -1) {
                int i14 = cVar.f2991b;
                i12 = i14;
                i11 = f10;
                i10 = i14 - bVar.f2986a;
            } else {
                int i15 = cVar.f2991b;
                i10 = i15;
                i11 = f10;
                i12 = bVar.f2986a + i15;
            }
        } else {
            int paddingTop = getPaddingTop();
            int f11 = this.mOrientationHelper.f(d10) + paddingTop;
            if (cVar.f2995f == -1) {
                int i16 = cVar.f2991b;
                i11 = i16;
                i10 = paddingTop;
                i12 = f11;
                i13 = i16 - bVar.f2986a;
            } else {
                int i17 = cVar.f2991b;
                i10 = paddingTop;
                i11 = bVar.f2986a + i17;
                i12 = f11;
                i13 = i17;
            }
        }
        layoutDecoratedWithMargins(d10, i13, i10, i11, i12);
        if (pVar.c() || pVar.b()) {
            bVar.f2988c = true;
        }
        bVar.f2989d = d10.hasFocusable();
    }

    public final View m(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return findReferenceChild(vVar, a0Var, getChildCount() - 1, -1, a0Var.b());
    }

    public final View n() {
        return this.mShouldReverseLayout ? j() : l();
    }

    public final View o() {
        return this.mShouldReverseLayout ? l() : j();
    }

    public void onAnchorReady(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar, int i10) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.onDetachedFromWindow(recyclerView, vVar);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(vVar);
            vVar.c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View onFocusSearchFailed(View view, int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int convertFocusDirectionToLayoutDirection;
        B();
        if (getChildCount() == 0 || (convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i10)) == Integer.MIN_VALUE) {
            return null;
        }
        ensureLayoutState();
        F(convertFocusDirectionToLayoutDirection, (int) (this.mOrientationHelper.n() * MAX_SCROLL_FACTOR), false, a0Var);
        c cVar = this.mLayoutState;
        cVar.f2996g = Integer.MIN_VALUE;
        cVar.f2990a = false;
        fill(vVar, cVar, a0Var, true);
        View o10 = convertFocusDirectionToLayoutDirection == -1 ? o() : n();
        View u10 = convertFocusDirectionToLayoutDirection == -1 ? u() : t();
        if (!u10.hasFocusable()) {
            return o10;
        }
        if (o10 == null) {
            return null;
        }
        return u10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onLayoutChildren(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int i10;
        int i11;
        int i12;
        int i13;
        int r10;
        int i14;
        View findViewByPosition;
        int g10;
        int i15;
        int i16 = -1;
        if (!(this.mPendingSavedState == null && this.mPendingScrollPosition == -1) && a0Var.b() == 0) {
            removeAndRecycleAllViews(vVar);
            return;
        }
        d dVar = this.mPendingSavedState;
        if (dVar != null && dVar.a()) {
            this.mPendingScrollPosition = this.mPendingSavedState.f3003a;
        }
        ensureLayoutState();
        this.mLayoutState.f2990a = false;
        B();
        View focusedChild = getFocusedChild();
        a aVar = this.mAnchorInfo;
        if (!aVar.f2985e || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null) {
            aVar.e();
            a aVar2 = this.mAnchorInfo;
            aVar2.f2984d = this.mShouldReverseLayout ^ this.mStackFromEnd;
            E(vVar, a0Var, aVar2);
            this.mAnchorInfo.f2985e = true;
        } else if (focusedChild != null && (this.mOrientationHelper.g(focusedChild) >= this.mOrientationHelper.i() || this.mOrientationHelper.d(focusedChild) <= this.mOrientationHelper.m())) {
            this.mAnchorInfo.c(focusedChild, getPosition(focusedChild));
        }
        c cVar = this.mLayoutState;
        cVar.f2995f = cVar.f3000k >= 0 ? 1 : -1;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(a0Var, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]) + this.mOrientationHelper.m();
        int max2 = Math.max(0, this.mReusableIntPair[1]) + this.mOrientationHelper.j();
        if (a0Var.e() && (i14 = this.mPendingScrollPosition) != -1 && this.mPendingScrollPositionOffset != Integer.MIN_VALUE && (findViewByPosition = findViewByPosition(i14)) != null) {
            if (this.mShouldReverseLayout) {
                i15 = this.mOrientationHelper.i() - this.mOrientationHelper.d(findViewByPosition);
                g10 = this.mPendingScrollPositionOffset;
            } else {
                g10 = this.mOrientationHelper.g(findViewByPosition) - this.mOrientationHelper.m();
                i15 = this.mPendingScrollPositionOffset;
            }
            int i17 = i15 - g10;
            if (i17 > 0) {
                max += i17;
            } else {
                max2 -= i17;
            }
        }
        a aVar3 = this.mAnchorInfo;
        if (!aVar3.f2984d ? !this.mShouldReverseLayout : this.mShouldReverseLayout) {
            i16 = 1;
        }
        onAnchorReady(vVar, a0Var, aVar3, i16);
        detachAndScrapAttachedViews(vVar);
        this.mLayoutState.f3002m = resolveIsInfinite();
        this.mLayoutState.f2999j = a0Var.e();
        this.mLayoutState.f2998i = 0;
        a aVar4 = this.mAnchorInfo;
        if (aVar4.f2984d) {
            J(aVar4);
            c cVar2 = this.mLayoutState;
            cVar2.f2997h = max;
            fill(vVar, cVar2, a0Var, false);
            c cVar3 = this.mLayoutState;
            i11 = cVar3.f2991b;
            int i18 = cVar3.f2993d;
            int i19 = cVar3.f2992c;
            if (i19 > 0) {
                max2 += i19;
            }
            H(this.mAnchorInfo);
            c cVar4 = this.mLayoutState;
            cVar4.f2997h = max2;
            cVar4.f2993d += cVar4.f2994e;
            fill(vVar, cVar4, a0Var, false);
            c cVar5 = this.mLayoutState;
            i10 = cVar5.f2991b;
            int i20 = cVar5.f2992c;
            if (i20 > 0) {
                I(i18, i11);
                c cVar6 = this.mLayoutState;
                cVar6.f2997h = i20;
                fill(vVar, cVar6, a0Var, false);
                i11 = this.mLayoutState.f2991b;
            }
        } else {
            H(aVar4);
            c cVar7 = this.mLayoutState;
            cVar7.f2997h = max2;
            fill(vVar, cVar7, a0Var, false);
            c cVar8 = this.mLayoutState;
            i10 = cVar8.f2991b;
            int i21 = cVar8.f2993d;
            int i22 = cVar8.f2992c;
            if (i22 > 0) {
                max += i22;
            }
            J(this.mAnchorInfo);
            c cVar9 = this.mLayoutState;
            cVar9.f2997h = max;
            cVar9.f2993d += cVar9.f2994e;
            fill(vVar, cVar9, a0Var, false);
            c cVar10 = this.mLayoutState;
            i11 = cVar10.f2991b;
            int i23 = cVar10.f2992c;
            if (i23 > 0) {
                G(i21, i10);
                c cVar11 = this.mLayoutState;
                cVar11.f2997h = i23;
                fill(vVar, cVar11, a0Var, false);
                i10 = this.mLayoutState.f2991b;
            }
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int r11 = r(i10, vVar, a0Var, true);
                i12 = i11 + r11;
                i13 = i10 + r11;
                r10 = s(i12, vVar, a0Var, false);
            } else {
                int s10 = s(i11, vVar, a0Var, true);
                i12 = i11 + s10;
                i13 = i10 + s10;
                r10 = r(i13, vVar, a0Var, false);
            }
            i11 = i12 + r10;
            i10 = i13 + r10;
        }
        v(vVar, a0Var, i11, i10);
        if (a0Var.e()) {
            this.mAnchorInfo.e();
        } else {
            this.mOrientationHelper.s();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onLayoutCompleted(RecyclerView.a0 a0Var) {
        super.onLayoutCompleted(a0Var);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.e();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.mPendingSavedState = (d) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) {
            return new d(this.mPendingSavedState);
        }
        d dVar = new d();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z10 = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            dVar.f3005c = z10;
            if (z10) {
                View t10 = t();
                dVar.f3004b = this.mOrientationHelper.i() - this.mOrientationHelper.d(t10);
                dVar.f3003a = getPosition(t10);
            } else {
                View u10 = u();
                dVar.f3003a = getPosition(u10);
                dVar.f3004b = this.mOrientationHelper.g(u10) - this.mOrientationHelper.m();
            }
        } else {
            dVar.b();
        }
        return dVar;
    }

    public final View p(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.mShouldReverseLayout ? k(vVar, a0Var) : m(vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.f.b
    public void prepareForDrop(View view, View view2, int i10, int i11) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        B();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        char c10 = position < position2 ? (char) 1 : (char) 65535;
        if (this.mShouldReverseLayout) {
            if (c10 == 1) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.i() - (this.mOrientationHelper.g(view2) + this.mOrientationHelper.e(view)));
                return;
            } else {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.i() - this.mOrientationHelper.d(view2));
                return;
            }
        }
        if (c10 == 65535) {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.g(view2));
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.d(view2) - this.mOrientationHelper.e(view));
        }
    }

    public final View q(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.mShouldReverseLayout ? m(vVar, a0Var) : k(vVar, a0Var);
    }

    public final int r(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z10) {
        int i11;
        int i12 = this.mOrientationHelper.i() - i10;
        if (i12 <= 0) {
            return 0;
        }
        int i13 = -scrollBy(-i12, vVar, a0Var);
        int i14 = i10 + i13;
        if (!z10 || (i11 = this.mOrientationHelper.i() - i14) <= 0) {
            return i13;
        }
        this.mOrientationHelper.r(i11);
        return i11 + i13;
    }

    public boolean resolveIsInfinite() {
        return this.mOrientationHelper.k() == 0 && this.mOrientationHelper.h() == 0;
    }

    public final int s(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z10) {
        int m10;
        int m11 = i10 - this.mOrientationHelper.m();
        if (m11 <= 0) {
            return 0;
        }
        int i11 = -scrollBy(m11, vVar, a0Var);
        int i12 = i10 + i11;
        if (!z10 || (m10 = i12 - this.mOrientationHelper.m()) <= 0) {
            return i11;
        }
        this.mOrientationHelper.r(-m10);
        return i11 - m10;
    }

    public int scrollBy(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (getChildCount() == 0 || i10 == 0) {
            return 0;
        }
        ensureLayoutState();
        this.mLayoutState.f2990a = true;
        int i11 = i10 > 0 ? 1 : -1;
        int abs = Math.abs(i10);
        F(i11, abs, true, a0Var);
        c cVar = this.mLayoutState;
        int fill = cVar.f2996g + fill(vVar, cVar, a0Var, false);
        if (fill < 0) {
            return 0;
        }
        if (abs > fill) {
            i10 = i11 * fill;
        }
        this.mOrientationHelper.r(-i10);
        this.mLayoutState.f3000k = i10;
        return i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int scrollHorizontallyBy(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i10, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void scrollToPosition(int i10) {
        this.mPendingScrollPosition = i10;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        d dVar = this.mPendingSavedState;
        if (dVar != null) {
            dVar.b();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i10, int i11) {
        this.mPendingScrollPosition = i10;
        this.mPendingScrollPositionOffset = i11;
        d dVar = this.mPendingSavedState;
        if (dVar != null) {
            dVar.b();
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int scrollVerticallyBy(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i10, vVar, a0Var);
    }

    public void setInitialPrefetchItemCount(int i10) {
        this.mInitialPrefetchItemCount = i10;
    }

    public void setOrientation(int i10) {
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i10);
        }
        assertNotInLayoutOrScroll(null);
        if (i10 != this.mOrientation || this.mOrientationHelper == null) {
            m b10 = m.b(this, i10);
            this.mOrientationHelper = b10;
            this.mAnchorInfo.f2981a = b10;
            this.mOrientation = i10;
            requestLayout();
        }
    }

    public void setRecycleChildrenOnDetach(boolean z10) {
        this.mRecycleChildrenOnDetach = z10;
    }

    public void setReverseLayout(boolean z10) {
        assertNotInLayoutOrScroll(null);
        if (z10 == this.mReverseLayout) {
            return;
        }
        this.mReverseLayout = z10;
        requestLayout();
    }

    public void setSmoothScrollbarEnabled(boolean z10) {
        this.mSmoothScrollbarEnabled = z10;
    }

    public void setStackFromEnd(boolean z10) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd == z10) {
            return;
        }
        this.mStackFromEnd = z10;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean shouldMeasureTwice() {
        return (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.a0 a0Var, int i10) {
        j jVar = new j(recyclerView.getContext());
        jVar.setTargetPosition(i10);
        startSmoothScroll(jVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd;
    }

    public final View t() {
        return getChildAt(this.mShouldReverseLayout ? 0 : getChildCount() - 1);
    }

    public final View u() {
        return getChildAt(this.mShouldReverseLayout ? getChildCount() - 1 : 0);
    }

    public final void v(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i10, int i11) {
        if (!a0Var.g() || getChildCount() == 0 || a0Var.e() || !supportsPredictiveItemAnimations()) {
            return;
        }
        List k10 = vVar.k();
        int size = k10.size();
        int position = getPosition(getChildAt(0));
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < size; i14++) {
            RecyclerView.d0 d0Var = (RecyclerView.d0) k10.get(i14);
            if (!d0Var.isRemoved()) {
                if (((d0Var.getLayoutPosition() < position) != this.mShouldReverseLayout ? (char) 65535 : (char) 1) == 65535) {
                    i12 += this.mOrientationHelper.e(d0Var.itemView);
                } else {
                    i13 += this.mOrientationHelper.e(d0Var.itemView);
                }
            }
        }
        this.mLayoutState.f3001l = k10;
        if (i12 > 0) {
            I(getPosition(u()), i10);
            c cVar = this.mLayoutState;
            cVar.f2997h = i12;
            cVar.f2992c = 0;
            cVar.a();
            fill(vVar, this.mLayoutState, a0Var, false);
        }
        if (i13 > 0) {
            G(getPosition(t()), i11);
            c cVar2 = this.mLayoutState;
            cVar2.f2997h = i13;
            cVar2.f2992c = 0;
            cVar2.a();
            fill(vVar, this.mLayoutState, a0Var, false);
        }
        this.mLayoutState.f3001l = null;
    }

    public void validateChildOrder() {
        StringBuilder sb = new StringBuilder();
        sb.append("validating child count ");
        sb.append(getChildCount());
        if (getChildCount() < 1) {
            return;
        }
        int position = getPosition(getChildAt(0));
        int g10 = this.mOrientationHelper.g(getChildAt(0));
        if (this.mShouldReverseLayout) {
            for (int i10 = 1; i10 < getChildCount(); i10++) {
                View childAt = getChildAt(i10);
                int position2 = getPosition(childAt);
                int g11 = this.mOrientationHelper.g(childAt);
                if (position2 < position) {
                    w();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("detected invalid position. loc invalid? ");
                    sb2.append(g11 < g10);
                    throw new RuntimeException(sb2.toString());
                }
                if (g11 > g10) {
                    w();
                    throw new RuntimeException("detected invalid location");
                }
            }
            return;
        }
        for (int i11 = 1; i11 < getChildCount(); i11++) {
            View childAt2 = getChildAt(i11);
            int position3 = getPosition(childAt2);
            int g12 = this.mOrientationHelper.g(childAt2);
            if (position3 < position) {
                w();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("detected invalid position. loc invalid? ");
                sb3.append(g12 < g10);
                throw new RuntimeException(sb3.toString());
            }
            if (g12 < g10) {
                w();
                throw new RuntimeException("detected invalid location");
            }
        }
    }

    public final void w() {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            StringBuilder sb = new StringBuilder();
            sb.append("item ");
            sb.append(getPosition(childAt));
            sb.append(", coord:");
            sb.append(this.mOrientationHelper.g(childAt));
        }
    }

    public final void x(RecyclerView.v vVar, c cVar) {
        if (!cVar.f2990a || cVar.f3002m) {
            return;
        }
        int i10 = cVar.f2996g;
        int i11 = cVar.f2998i;
        if (cVar.f2995f == -1) {
            z(vVar, i10, i11);
        } else {
            A(vVar, i10, i11);
        }
    }

    public final void y(RecyclerView.v vVar, int i10, int i11) {
        if (i10 == i11) {
            return;
        }
        if (i11 <= i10) {
            while (i10 > i11) {
                removeAndRecycleViewAt(i10, vVar);
                i10--;
            }
        } else {
            for (int i12 = i11 - 1; i12 >= i10; i12--) {
                removeAndRecycleViewAt(i12, vVar);
            }
        }
    }

    public final void z(RecyclerView.v vVar, int i10, int i11) {
        int childCount = getChildCount();
        if (i10 < 0) {
            return;
        }
        int h10 = (this.mOrientationHelper.h() - i10) + i11;
        if (this.mShouldReverseLayout) {
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                if (this.mOrientationHelper.g(childAt) < h10 || this.mOrientationHelper.q(childAt) < h10) {
                    y(vVar, 0, i12);
                    return;
                }
            }
            return;
        }
        int i13 = childCount - 1;
        for (int i14 = i13; i14 >= 0; i14--) {
            View childAt2 = getChildAt(i14);
            if (this.mOrientationHelper.g(childAt2) < h10 || this.mOrientationHelper.q(childAt2) < h10) {
                y(vVar, i13, i14);
                return;
            }
        }
    }

    public LinearLayoutManager(Context context, int i10, boolean z10) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new a();
        this.mLayoutChunkResult = new b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(i10);
        setReverseLayout(z10);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new a();
        this.mLayoutChunkResult = new b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.o.d properties = RecyclerView.o.getProperties(context, attributeSet, i10, i11);
        setOrientation(properties.f3048a);
        setReverseLayout(properties.f3050c);
        setStackFromEnd(properties.f3051d);
    }
}
