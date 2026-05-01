package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c0.g0;
import com.google.common.primitives.Ints;
import java.util.Arrays;

/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    private static final boolean DEBUG = false;
    public static final int DEFAULT_SPAN_COUNT = -1;
    private static final String TAG = "GridLayoutManager";
    int[] mCachedBorders;
    final Rect mDecorInsets;
    boolean mPendingSpanCountChange;
    final SparseIntArray mPreLayoutSpanIndexCache;
    final SparseIntArray mPreLayoutSpanSizeCache;
    View[] mSet;
    int mSpanCount;
    c mSpanSizeLookup;
    private boolean mUsingSpansToEstimateScrollBarDimensions;

    public static final class a extends c {
        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int getSpanIndex(int i10, int i11) {
            return i10 % i11;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int getSpanSize(int i10) {
            return 1;
        }
    }

    public static abstract class c {
        final SparseIntArray mSpanIndexCache = new SparseIntArray();
        final SparseIntArray mSpanGroupIndexCache = new SparseIntArray();
        private boolean mCacheSpanIndices = false;
        private boolean mCacheSpanGroupIndices = false;

        public static int findFirstKeyLessThan(SparseIntArray sparseIntArray, int i10) {
            int size = sparseIntArray.size() - 1;
            int i11 = 0;
            while (i11 <= size) {
                int i12 = (i11 + size) >>> 1;
                if (sparseIntArray.keyAt(i12) < i10) {
                    i11 = i12 + 1;
                } else {
                    size = i12 - 1;
                }
            }
            int i13 = i11 - 1;
            if (i13 < 0 || i13 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i13);
        }

        public int getCachedSpanGroupIndex(int i10, int i11) {
            if (!this.mCacheSpanGroupIndices) {
                return getSpanGroupIndex(i10, i11);
            }
            int i12 = this.mSpanGroupIndexCache.get(i10, -1);
            if (i12 != -1) {
                return i12;
            }
            int spanGroupIndex = getSpanGroupIndex(i10, i11);
            this.mSpanGroupIndexCache.put(i10, spanGroupIndex);
            return spanGroupIndex;
        }

        public int getCachedSpanIndex(int i10, int i11) {
            if (!this.mCacheSpanIndices) {
                return getSpanIndex(i10, i11);
            }
            int i12 = this.mSpanIndexCache.get(i10, -1);
            if (i12 != -1) {
                return i12;
            }
            int spanIndex = getSpanIndex(i10, i11);
            this.mSpanIndexCache.put(i10, spanIndex);
            return spanIndex;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0043  */
        /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int getSpanGroupIndex(int i10, int i11) {
            int i12;
            int i13;
            int findFirstKeyLessThan;
            if (this.mCacheSpanGroupIndices && (findFirstKeyLessThan = findFirstKeyLessThan(this.mSpanGroupIndexCache, i10)) != -1) {
                int i14 = this.mSpanGroupIndexCache.get(findFirstKeyLessThan);
                i12 = findFirstKeyLessThan + 1;
                i13 = getCachedSpanIndex(findFirstKeyLessThan, i11) + getSpanSize(findFirstKeyLessThan);
                i14 = i13 == i11 ? i14 + 1 : 0;
                int spanSize = getSpanSize(i10);
                while (i12 < i10) {
                    int spanSize2 = getSpanSize(i12);
                    i13 += spanSize2;
                    if (i13 == i11) {
                        i14++;
                        i13 = 0;
                    } else if (i13 > i11) {
                        i14++;
                        i13 = spanSize2;
                    }
                    i12++;
                }
                return i13 + spanSize <= i11 ? i14 + 1 : i14;
            }
            i12 = 0;
            i13 = 0;
            int spanSize3 = getSpanSize(i10);
            while (i12 < i10) {
            }
            if (i13 + spanSize3 <= i11) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002b -> B:10:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002d -> B:10:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002f -> B:10:0x0030). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int getSpanIndex(int i10, int i11) {
            int i12;
            int i13;
            int spanSize = getSpanSize(i10);
            if (spanSize == i11) {
                return 0;
            }
            if (!this.mCacheSpanIndices || (i12 = findFirstKeyLessThan(this.mSpanIndexCache, i10)) < 0) {
                i12 = 0;
                i13 = 0;
                if (i12 >= i10) {
                    int spanSize2 = getSpanSize(i12);
                    i13 += spanSize2;
                    if (i13 == i11) {
                        i13 = 0;
                    } else if (i13 > i11) {
                        i13 = spanSize2;
                    }
                    i12++;
                    if (i12 >= i10) {
                        if (spanSize + i13 <= i11) {
                            return i13;
                        }
                        return 0;
                    }
                }
            } else {
                i13 = this.mSpanIndexCache.get(i12) + getSpanSize(i12);
                i12++;
                if (i12 >= i10) {
                }
            }
        }

        public abstract int getSpanSize(int i10);

        public void invalidateSpanGroupIndexCache() {
            this.mSpanGroupIndexCache.clear();
        }

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public boolean isSpanGroupIndexCacheEnabled() {
            return this.mCacheSpanGroupIndices;
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        public void setSpanGroupIndexCacheEnabled(boolean z10) {
            if (!z10) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanGroupIndices = z10;
        }

        public void setSpanIndexCacheEnabled(boolean z10) {
            if (!z10) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanIndices = z10;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new a();
        this.mDecorInsets = new Rect();
        setSpanCount(RecyclerView.o.getProperties(context, attributeSet, i10, i11).f3049b);
    }

    public static int[] calculateItemBorders(int[] iArr, int i10, int i11) {
        int i12;
        if (iArr == null || iArr.length != i10 + 1 || iArr[iArr.length - 1] != i11) {
            iArr = new int[i10 + 1];
        }
        int i13 = 0;
        iArr[0] = 0;
        int i14 = i11 / i10;
        int i15 = i11 % i10;
        int i16 = 0;
        for (int i17 = 1; i17 <= i10; i17++) {
            i13 += i15;
            if (i13 <= 0 || i10 - i13 >= i15) {
                i12 = i14;
            } else {
                i12 = i14 + 1;
                i13 -= i10;
            }
            i16 += i12;
            iArr[i17] = i16;
        }
        return iArr;
    }

    public final void K(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i10, boolean z10) {
        int i11;
        int i12;
        int i13;
        int i14 = 0;
        if (z10) {
            i12 = i10;
            i11 = 0;
            i13 = 1;
        } else {
            i11 = i10 - 1;
            i12 = -1;
            i13 = -1;
        }
        while (i11 != i12) {
            View view = this.mSet[i11];
            b bVar = (b) view.getLayoutParams();
            int U = U(vVar, a0Var, getPosition(view));
            bVar.f2980f = U;
            bVar.f2979e = i14;
            i14 += U;
            i11 += i13;
        }
    }

    public final void L() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            b bVar = (b) getChildAt(i10).getLayoutParams();
            int a10 = bVar.a();
            this.mPreLayoutSpanSizeCache.put(a10, bVar.f());
            this.mPreLayoutSpanIndexCache.put(a10, bVar.e());
        }
    }

    public final void M(int i10) {
        this.mCachedBorders = calculateItemBorders(this.mCachedBorders, this.mSpanCount, i10);
    }

    public final void N() {
        this.mPreLayoutSpanSizeCache.clear();
        this.mPreLayoutSpanIndexCache.clear();
    }

    public final int O(RecyclerView.a0 a0Var) {
        if (getChildCount() != 0 && a0Var.b() != 0) {
            ensureLayoutState();
            boolean isSmoothScrollbarEnabled = isSmoothScrollbarEnabled();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled, true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled, true);
            if (findFirstVisibleChildClosestToStart != null && findFirstVisibleChildClosestToEnd != null) {
                int cachedSpanGroupIndex = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount);
                int cachedSpanGroupIndex2 = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount);
                int max = this.mShouldReverseLayout ? Math.max(0, ((this.mSpanSizeLookup.getCachedSpanGroupIndex(a0Var.b() - 1, this.mSpanCount) + 1) - Math.max(cachedSpanGroupIndex, cachedSpanGroupIndex2)) - 1) : Math.max(0, Math.min(cachedSpanGroupIndex, cachedSpanGroupIndex2));
                if (isSmoothScrollbarEnabled) {
                    return Math.round((max * (Math.abs(this.mOrientationHelper.d(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.g(findFirstVisibleChildClosestToStart)) / ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount) - this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount)) + 1))) + (this.mOrientationHelper.m() - this.mOrientationHelper.g(findFirstVisibleChildClosestToStart)));
                }
                return max;
            }
        }
        return 0;
    }

    public final int P(RecyclerView.a0 a0Var) {
        if (getChildCount() != 0 && a0Var.b() != 0) {
            ensureLayoutState();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
            if (findFirstVisibleChildClosestToStart != null && findFirstVisibleChildClosestToEnd != null) {
                if (!isSmoothScrollbarEnabled()) {
                    return this.mSpanSizeLookup.getCachedSpanGroupIndex(a0Var.b() - 1, this.mSpanCount) + 1;
                }
                int d10 = this.mOrientationHelper.d(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.g(findFirstVisibleChildClosestToStart);
                int cachedSpanGroupIndex = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount);
                return (int) ((d10 / ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount) - cachedSpanGroupIndex) + 1)) * (this.mSpanSizeLookup.getCachedSpanGroupIndex(a0Var.b() - 1, this.mSpanCount) + 1));
            }
        }
        return 0;
    }

    public final void Q(RecyclerView.v vVar, RecyclerView.a0 a0Var, LinearLayoutManager.a aVar, int i10) {
        boolean z10 = i10 == 1;
        int T = T(vVar, a0Var, aVar.f2982b);
        if (z10) {
            while (T > 0) {
                int i11 = aVar.f2982b;
                if (i11 <= 0) {
                    return;
                }
                int i12 = i11 - 1;
                aVar.f2982b = i12;
                T = T(vVar, a0Var, i12);
            }
            return;
        }
        int b10 = a0Var.b() - 1;
        int i13 = aVar.f2982b;
        while (i13 < b10) {
            int i14 = i13 + 1;
            int T2 = T(vVar, a0Var, i14);
            if (T2 <= T) {
                break;
            }
            i13 = i14;
            T = T2;
        }
        aVar.f2982b = i13;
    }

    public final void R() {
        View[] viewArr = this.mSet;
        if (viewArr == null || viewArr.length != this.mSpanCount) {
            this.mSet = new View[this.mSpanCount];
        }
    }

    public final int S(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i10) {
        if (!a0Var.e()) {
            return this.mSpanSizeLookup.getCachedSpanGroupIndex(i10, this.mSpanCount);
        }
        int f10 = vVar.f(i10);
        if (f10 != -1) {
            return this.mSpanSizeLookup.getCachedSpanGroupIndex(f10, this.mSpanCount);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot find span size for pre layout position. ");
        sb.append(i10);
        return 0;
    }

    public final int T(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i10) {
        if (!a0Var.e()) {
            return this.mSpanSizeLookup.getCachedSpanIndex(i10, this.mSpanCount);
        }
        int i11 = this.mPreLayoutSpanIndexCache.get(i10, -1);
        if (i11 != -1) {
            return i11;
        }
        int f10 = vVar.f(i10);
        if (f10 != -1) {
            return this.mSpanSizeLookup.getCachedSpanIndex(f10, this.mSpanCount);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
        sb.append(i10);
        return 0;
    }

    public final int U(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i10) {
        if (!a0Var.e()) {
            return this.mSpanSizeLookup.getSpanSize(i10);
        }
        int i11 = this.mPreLayoutSpanSizeCache.get(i10, -1);
        if (i11 != -1) {
            return i11;
        }
        int f10 = vVar.f(i10);
        if (f10 != -1) {
            return this.mSpanSizeLookup.getSpanSize(f10);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
        sb.append(i10);
        return 1;
    }

    public final void V(float f10, int i10) {
        M(Math.max(Math.round(f10 * this.mSpanCount), i10));
    }

    public final void W(View view, int i10, boolean z10) {
        int i11;
        int i12;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.f3053b;
        int i13 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar).topMargin + ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        int i14 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar).leftMargin + ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        int spaceForSpanRange = getSpaceForSpanRange(bVar.f2979e, bVar.f2980f);
        if (this.mOrientation == 1) {
            i12 = RecyclerView.o.getChildMeasureSpec(spaceForSpanRange, i10, i14, ((ViewGroup.MarginLayoutParams) bVar).width, false);
            i11 = RecyclerView.o.getChildMeasureSpec(this.mOrientationHelper.n(), getHeightMode(), i13, ((ViewGroup.MarginLayoutParams) bVar).height, true);
        } else {
            int childMeasureSpec = RecyclerView.o.getChildMeasureSpec(spaceForSpanRange, i10, i13, ((ViewGroup.MarginLayoutParams) bVar).height, false);
            int childMeasureSpec2 = RecyclerView.o.getChildMeasureSpec(this.mOrientationHelper.n(), getWidthMode(), i14, ((ViewGroup.MarginLayoutParams) bVar).width, true);
            i11 = childMeasureSpec;
            i12 = childMeasureSpec2;
        }
        X(view, i12, i11, z10);
    }

    public final void X(View view, int i10, int i11, boolean z10) {
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        if (z10 ? shouldReMeasureChild(view, i10, i11, pVar) : shouldMeasureChild(view, i10, i11, pVar)) {
            view.measure(i10, i11);
        }
    }

    public final void Y() {
        int height;
        int paddingTop;
        if (getOrientation() == 1) {
            height = getWidth() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        M(height - paddingTop);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean checkLayoutParams(RecyclerView.p pVar) {
        return pVar instanceof b;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void collectPrefetchPositionsForLayoutState(RecyclerView.a0 a0Var, LinearLayoutManager.c cVar, RecyclerView.o.c cVar2) {
        int i10 = this.mSpanCount;
        for (int i11 = 0; i11 < this.mSpanCount && cVar.c(a0Var) && i10 > 0; i11++) {
            int i12 = cVar.f2993d;
            cVar2.a(i12, Math.max(0, cVar.f2996g));
            i10 -= this.mSpanSizeLookup.getSpanSize(i12);
            cVar.f2993d += cVar.f2994e;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollOffset(RecyclerView.a0 a0Var) {
        return this.mUsingSpansToEstimateScrollBarDimensions ? O(a0Var) : super.computeHorizontalScrollOffset(a0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollRange(RecyclerView.a0 a0Var) {
        return this.mUsingSpansToEstimateScrollBarDimensions ? P(a0Var) : super.computeHorizontalScrollRange(a0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollOffset(RecyclerView.a0 a0Var) {
        return this.mUsingSpansToEstimateScrollBarDimensions ? O(a0Var) : super.computeVerticalScrollOffset(a0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollRange(RecyclerView.a0 a0Var) {
        return this.mUsingSpansToEstimateScrollBarDimensions ? P(a0Var) : super.computeVerticalScrollRange(a0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
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
            if (position >= 0 && position < i12 && T(vVar, a0Var, position) == 0) {
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

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p generateDefaultLayoutParams() {
        return this.mOrientation == 0 ? new b(-2, -1) : new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int getColumnCountForAccessibility(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.mOrientation == 1) {
            return this.mSpanCount;
        }
        if (a0Var.b() < 1) {
            return 0;
        }
        return S(vVar, a0Var, a0Var.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int getRowCountForAccessibility(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.mOrientation == 0) {
            return this.mSpanCount;
        }
        if (a0Var.b() < 1) {
            return 0;
        }
        return S(vVar, a0Var, a0Var.b() - 1) + 1;
    }

    public int getSpaceForSpanRange(int i10, int i11) {
        if (this.mOrientation != 1 || !isLayoutRTL()) {
            int[] iArr = this.mCachedBorders;
            return iArr[i11 + i10] - iArr[i10];
        }
        int[] iArr2 = this.mCachedBorders;
        int i12 = this.mSpanCount;
        return iArr2[i12 - i10] - iArr2[(i12 - i10) - i11];
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    public c getSpanSizeLookup() {
        return this.mSpanSizeLookup;
    }

    public boolean isUsingSpansToEstimateScrollbarDimensions() {
        return this.mUsingSpansToEstimateScrollBarDimensions;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x009f, code lost:
    
        r21.f2987b = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a1, code lost:
    
        return;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void layoutChunk(RecyclerView.v vVar, RecyclerView.a0 a0Var, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int f10;
        int i18;
        int i19;
        int childMeasureSpec;
        int i20;
        View d10;
        int l10 = this.mOrientationHelper.l();
        boolean z10 = l10 != 1073741824;
        int i21 = getChildCount() > 0 ? this.mCachedBorders[this.mSpanCount] : 0;
        if (z10) {
            Y();
        }
        boolean z11 = cVar.f2994e == 1;
        int i22 = this.mSpanCount;
        if (!z11) {
            i22 = T(vVar, a0Var, cVar.f2993d) + U(vVar, a0Var, cVar.f2993d);
        }
        int i23 = 0;
        while (i23 < this.mSpanCount && cVar.c(a0Var) && i22 > 0) {
            int i24 = cVar.f2993d;
            int U = U(vVar, a0Var, i24);
            if (U > this.mSpanCount) {
                throw new IllegalArgumentException("Item at position " + i24 + " requires " + U + " spans but GridLayoutManager has only " + this.mSpanCount + " spans.");
            }
            i22 -= U;
            if (i22 < 0 || (d10 = cVar.d(vVar)) == null) {
                break;
            }
            this.mSet[i23] = d10;
            i23++;
        }
        K(vVar, a0Var, i23, z11);
        float f11 = 0.0f;
        int i25 = 0;
        for (int i26 = 0; i26 < i23; i26++) {
            View view = this.mSet[i26];
            if (cVar.f3001l == null) {
                if (z11) {
                    addView(view);
                } else {
                    addView(view, 0);
                }
            } else if (z11) {
                addDisappearingView(view);
            } else {
                addDisappearingView(view, 0);
            }
            calculateItemDecorationsForChild(view, this.mDecorInsets);
            W(view, l10, false);
            int e10 = this.mOrientationHelper.e(view);
            if (e10 > i25) {
                i25 = e10;
            }
            float f12 = (this.mOrientationHelper.f(view) * 1.0f) / ((b) view.getLayoutParams()).f2980f;
            if (f12 > f11) {
                f11 = f12;
            }
        }
        if (z10) {
            V(f11, i21);
            i25 = 0;
            for (int i27 = 0; i27 < i23; i27++) {
                View view2 = this.mSet[i27];
                W(view2, Ints.MAX_POWER_OF_TWO, true);
                int e11 = this.mOrientationHelper.e(view2);
                if (e11 > i25) {
                    i25 = e11;
                }
            }
        }
        for (int i28 = 0; i28 < i23; i28++) {
            View view3 = this.mSet[i28];
            if (this.mOrientationHelper.e(view3) != i25) {
                b bVar2 = (b) view3.getLayoutParams();
                Rect rect = bVar2.f3053b;
                int i29 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar2).topMargin + ((ViewGroup.MarginLayoutParams) bVar2).bottomMargin;
                int i30 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar2).leftMargin + ((ViewGroup.MarginLayoutParams) bVar2).rightMargin;
                int spaceForSpanRange = getSpaceForSpanRange(bVar2.f2979e, bVar2.f2980f);
                if (this.mOrientation == 1) {
                    i20 = RecyclerView.o.getChildMeasureSpec(spaceForSpanRange, Ints.MAX_POWER_OF_TWO, i30, ((ViewGroup.MarginLayoutParams) bVar2).width, false);
                    childMeasureSpec = View.MeasureSpec.makeMeasureSpec(i25 - i29, Ints.MAX_POWER_OF_TWO);
                } else {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i25 - i30, Ints.MAX_POWER_OF_TWO);
                    childMeasureSpec = RecyclerView.o.getChildMeasureSpec(spaceForSpanRange, Ints.MAX_POWER_OF_TWO, i29, ((ViewGroup.MarginLayoutParams) bVar2).height, false);
                    i20 = makeMeasureSpec;
                }
                X(view3, i20, childMeasureSpec, true);
            }
        }
        bVar.f2986a = i25;
        if (this.mOrientation == 1) {
            if (cVar.f2995f == -1) {
                i15 = cVar.f2991b;
                i19 = i15 - i25;
            } else {
                i19 = cVar.f2991b;
                i15 = i19 + i25;
            }
            i13 = i19;
            i14 = 0;
            i12 = 0;
        } else {
            if (cVar.f2995f == -1) {
                i11 = cVar.f2991b;
                i10 = i11 - i25;
            } else {
                i10 = cVar.f2991b;
                i11 = i10 + i25;
            }
            i12 = i10;
            i13 = 0;
            i14 = i11;
            i15 = 0;
        }
        int i31 = 0;
        while (i31 < i23) {
            View view4 = this.mSet[i31];
            b bVar3 = (b) view4.getLayoutParams();
            if (this.mOrientation != 1) {
                int paddingTop = getPaddingTop() + this.mCachedBorders[bVar3.f2979e];
                i16 = paddingTop;
                i17 = i14;
                f10 = this.mOrientationHelper.f(view4) + paddingTop;
            } else if (isLayoutRTL()) {
                int paddingLeft = getPaddingLeft() + this.mCachedBorders[this.mSpanCount - bVar3.f2979e];
                i12 = paddingLeft - this.mOrientationHelper.f(view4);
                f10 = i15;
                i17 = paddingLeft;
                i16 = i13;
            } else {
                int paddingLeft2 = getPaddingLeft() + this.mCachedBorders[bVar3.f2979e];
                f10 = i15;
                i18 = paddingLeft2;
                i16 = i13;
                i17 = this.mOrientationHelper.f(view4) + paddingLeft2;
                layoutDecoratedWithMargins(view4, i18, i16, i17, f10);
                if (!bVar3.c() || bVar3.b()) {
                    bVar.f2988c = true;
                }
                bVar.f2989d |= view4.hasFocusable();
                i31++;
                i15 = f10;
                i14 = i17;
                i13 = i16;
                i12 = i18;
            }
            i18 = i12;
            layoutDecoratedWithMargins(view4, i18, i16, i17, f10);
            if (!bVar3.c()) {
            }
            bVar.f2988c = true;
            bVar.f2989d |= view4.hasFocusable();
            i31++;
            i15 = f10;
            i14 = i17;
            i13 = i16;
            i12 = i18;
        }
        Arrays.fill(this.mSet, (Object) null);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void onAnchorReady(RecyclerView.v vVar, RecyclerView.a0 a0Var, LinearLayoutManager.a aVar, int i10) {
        super.onAnchorReady(vVar, a0Var, aVar, i10);
        Y();
        if (a0Var.b() > 0 && !a0Var.e()) {
            Q(vVar, a0Var, aVar, i10);
        }
        R();
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x00d6, code lost:
    
        if (r13 == (r2 > r15)) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00f6, code lost:
    
        if (r13 == (r2 > r7)) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0107  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onFocusSearchFailed(View view, int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int childCount;
        int i11;
        int i12;
        View view2;
        View view3;
        int i13;
        int i14;
        boolean z10;
        int i15;
        int i16;
        RecyclerView.v vVar2 = vVar;
        RecyclerView.a0 a0Var2 = a0Var;
        View findContainingItemView = findContainingItemView(view);
        View view4 = null;
        if (findContainingItemView == null) {
            return null;
        }
        b bVar = (b) findContainingItemView.getLayoutParams();
        int i17 = bVar.f2979e;
        int i18 = bVar.f2980f + i17;
        if (super.onFocusSearchFailed(view, i10, vVar, a0Var) == null) {
            return null;
        }
        if ((convertFocusDirectionToLayoutDirection(i10) == 1) != this.mShouldReverseLayout) {
            i11 = getChildCount() - 1;
            childCount = -1;
            i12 = -1;
        } else {
            childCount = getChildCount();
            i11 = 0;
            i12 = 1;
        }
        boolean z11 = this.mOrientation == 1 && isLayoutRTL();
        int S = S(vVar2, a0Var2, i11);
        int i19 = i11;
        int i20 = 0;
        int i21 = -1;
        int i22 = -1;
        int i23 = 0;
        View view5 = null;
        while (i19 != childCount) {
            int S2 = S(vVar2, a0Var2, i19);
            View childAt = getChildAt(i19);
            if (childAt == findContainingItemView) {
                break;
            }
            if (!childAt.hasFocusable() || S2 == S) {
                b bVar2 = (b) childAt.getLayoutParams();
                int i24 = bVar2.f2979e;
                view2 = findContainingItemView;
                int i25 = bVar2.f2980f + i24;
                if (childAt.hasFocusable() && i24 == i17 && i25 == i18) {
                    return childAt;
                }
                if (!(childAt.hasFocusable() && view4 == null) && (childAt.hasFocusable() || view5 != null)) {
                    view3 = view5;
                    int min = Math.min(i25, i18) - Math.max(i24, i17);
                    if (childAt.hasFocusable()) {
                        if (min <= i20) {
                            if (min == i20) {
                            }
                        }
                    } else if (view4 == null) {
                        i13 = i20;
                        i14 = childCount;
                        if (isViewPartiallyVisible(childAt, false, true)) {
                            i15 = i23;
                            if (min > i15) {
                                i16 = i22;
                                if (z10) {
                                    if (childAt.hasFocusable()) {
                                        i21 = bVar2.f2979e;
                                        i22 = i16;
                                        i23 = i15;
                                        view5 = view3;
                                        view4 = childAt;
                                        i20 = Math.min(i25, i18) - Math.max(i24, i17);
                                    } else {
                                        int i26 = bVar2.f2979e;
                                        i23 = Math.min(i25, i18) - Math.max(i24, i17);
                                        i22 = i26;
                                        i20 = i13;
                                        view5 = childAt;
                                    }
                                    i19 += i12;
                                    vVar2 = vVar;
                                    a0Var2 = a0Var;
                                    findContainingItemView = view2;
                                    childCount = i14;
                                }
                            } else {
                                if (min == i15) {
                                    i16 = i22;
                                } else {
                                    i16 = i22;
                                }
                                z10 = false;
                                if (z10) {
                                }
                            }
                        }
                        i16 = i22;
                        i15 = i23;
                        z10 = false;
                        if (z10) {
                        }
                    }
                    i13 = i20;
                    i14 = childCount;
                    i16 = i22;
                    i15 = i23;
                    z10 = false;
                    if (z10) {
                    }
                } else {
                    view3 = view5;
                }
                i13 = i20;
                i14 = childCount;
                i16 = i22;
                i15 = i23;
                z10 = true;
                if (z10) {
                }
            } else {
                if (view4 != null) {
                    break;
                }
                view2 = findContainingItemView;
                view3 = view5;
                i13 = i20;
                i14 = childCount;
                i16 = i22;
                i15 = i23;
            }
            i22 = i16;
            i23 = i15;
            i20 = i13;
            view5 = view3;
            i19 += i12;
            vVar2 = vVar;
            a0Var2 = a0Var;
            findContainingItemView = view2;
            childCount = i14;
        }
        return view4 != null ? view4 : view5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.v vVar, RecyclerView.a0 a0Var, View view, g0 g0Var) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, g0Var);
            return;
        }
        b bVar = (b) layoutParams;
        int S = S(vVar, a0Var, bVar.a());
        if (this.mOrientation == 0) {
            g0Var.Z(g0.c.a(bVar.e(), bVar.f(), S, 1, false, false));
        } else {
            g0Var.Z(g0.c.a(S, 1, bVar.e(), bVar.f(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsAdded(RecyclerView recyclerView, int i10, int i11) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsChanged(RecyclerView recyclerView) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsMoved(RecyclerView recyclerView, int i10, int i11, int i12) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsRemoved(RecyclerView recyclerView, int i10, int i11) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsUpdated(RecyclerView recyclerView, int i10, int i11, Object obj) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void onLayoutChildren(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (a0Var.e()) {
            L();
        }
        super.onLayoutChildren(vVar, a0Var);
        N();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void onLayoutCompleted(RecyclerView.a0 a0Var) {
        super.onLayoutCompleted(a0Var);
        this.mPendingSpanCountChange = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int scrollHorizontallyBy(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        Y();
        R();
        return super.scrollHorizontallyBy(i10, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int scrollVerticallyBy(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        Y();
        R();
        return super.scrollVerticallyBy(i10, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void setMeasuredDimension(Rect rect, int i10, int i11) {
        int chooseSize;
        int chooseSize2;
        if (this.mCachedBorders == null) {
            super.setMeasuredDimension(rect, i10, i11);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            chooseSize2 = RecyclerView.o.chooseSize(i11, rect.height() + paddingTop, getMinimumHeight());
            int[] iArr = this.mCachedBorders;
            chooseSize = RecyclerView.o.chooseSize(i10, iArr[iArr.length - 1] + paddingLeft, getMinimumWidth());
        } else {
            chooseSize = RecyclerView.o.chooseSize(i10, rect.width() + paddingLeft, getMinimumWidth());
            int[] iArr2 = this.mCachedBorders;
            chooseSize2 = RecyclerView.o.chooseSize(i11, iArr2[iArr2.length - 1] + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(chooseSize, chooseSize2);
    }

    public void setSpanCount(int i10) {
        if (i10 == this.mSpanCount) {
            return;
        }
        this.mPendingSpanCountChange = true;
        if (i10 >= 1) {
            this.mSpanCount = i10;
            this.mSpanSizeLookup.invalidateSpanIndexCache();
            requestLayout();
        } else {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i10);
        }
    }

    public void setSpanSizeLookup(c cVar) {
        this.mSpanSizeLookup = cVar;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setStackFromEnd(boolean z10) {
        if (z10) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.setStackFromEnd(false);
    }

    public void setUsingSpansToEstimateScrollbarDimensions(boolean z10) {
        this.mUsingSpansToEstimateScrollBarDimensions = z10;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.mPendingSpanCountChange;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    public static class b extends RecyclerView.p {

        /* renamed from: e, reason: collision with root package name */
        public int f2979e;

        /* renamed from: f, reason: collision with root package name */
        public int f2980f;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2979e = -1;
            this.f2980f = 0;
        }

        public int e() {
            return this.f2979e;
        }

        public int f() {
            return this.f2980f;
        }

        public b(int i10, int i11) {
            super(i10, i11);
            this.f2979e = -1;
            this.f2980f = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2979e = -1;
            this.f2980f = 0;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2979e = -1;
            this.f2980f = 0;
        }
    }

    public GridLayoutManager(Context context, int i10) {
        super(context);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new a();
        this.mDecorInsets = new Rect();
        setSpanCount(i10);
    }

    public GridLayoutManager(Context context, int i10, int i11, boolean z10) {
        super(context, i11, z10);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new a();
        this.mDecorInsets = new Rect();
        setSpanCount(i10);
    }
}
