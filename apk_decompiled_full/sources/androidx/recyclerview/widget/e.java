package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public static final ThreadLocal f3234e = new ThreadLocal();

    /* renamed from: f, reason: collision with root package name */
    public static Comparator f3235f = new a();

    /* renamed from: b, reason: collision with root package name */
    public long f3237b;

    /* renamed from: c, reason: collision with root package name */
    public long f3238c;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f3236a = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f3239d = new ArrayList();

    public static class a implements Comparator {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            RecyclerView recyclerView = cVar.f3247d;
            if ((recyclerView == null) != (cVar2.f3247d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z10 = cVar.f3244a;
            if (z10 != cVar2.f3244a) {
                return z10 ? -1 : 1;
            }
            int i10 = cVar2.f3245b - cVar.f3245b;
            if (i10 != 0) {
                return i10;
            }
            int i11 = cVar.f3246c - cVar2.f3246c;
            if (i11 != 0) {
                return i11;
            }
            return 0;
        }
    }

    public static class b implements RecyclerView.o.c {

        /* renamed from: a, reason: collision with root package name */
        public int f3240a;

        /* renamed from: b, reason: collision with root package name */
        public int f3241b;

        /* renamed from: c, reason: collision with root package name */
        public int[] f3242c;

        /* renamed from: d, reason: collision with root package name */
        public int f3243d;

        @Override // androidx.recyclerview.widget.RecyclerView.o.c
        public void a(int i10, int i11) {
            if (i10 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i11 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i12 = this.f3243d * 2;
            int[] iArr = this.f3242c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.f3242c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i12 >= iArr.length) {
                int[] iArr3 = new int[i12 * 2];
                this.f3242c = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.f3242c;
            iArr4[i12] = i10;
            iArr4[i12 + 1] = i11;
            this.f3243d++;
        }

        public void b() {
            int[] iArr = this.f3242c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f3243d = 0;
        }

        public void c(RecyclerView recyclerView, boolean z10) {
            this.f3243d = 0;
            int[] iArr = this.f3242c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.o oVar = recyclerView.mLayout;
            if (recyclerView.mAdapter == null || oVar == null || !oVar.isItemPrefetchEnabled()) {
                return;
            }
            if (z10) {
                if (!recyclerView.mAdapterHelper.p()) {
                    oVar.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                }
            } else if (!recyclerView.hasPendingAdapterUpdates()) {
                oVar.collectAdjacentPrefetchPositions(this.f3240a, this.f3241b, recyclerView.mState, this);
            }
            int i10 = this.f3243d;
            if (i10 > oVar.mPrefetchMaxCountObserved) {
                oVar.mPrefetchMaxCountObserved = i10;
                oVar.mPrefetchMaxObservedInInitialPrefetch = z10;
                recyclerView.mRecycler.K();
            }
        }

        public boolean d(int i10) {
            if (this.f3242c != null) {
                int i11 = this.f3243d * 2;
                for (int i12 = 0; i12 < i11; i12 += 2) {
                    if (this.f3242c[i12] == i10) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void e(int i10, int i11) {
            this.f3240a = i10;
            this.f3241b = i11;
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public boolean f3244a;

        /* renamed from: b, reason: collision with root package name */
        public int f3245b;

        /* renamed from: c, reason: collision with root package name */
        public int f3246c;

        /* renamed from: d, reason: collision with root package name */
        public RecyclerView f3247d;

        /* renamed from: e, reason: collision with root package name */
        public int f3248e;

        public void a() {
            this.f3244a = false;
            this.f3245b = 0;
            this.f3246c = 0;
            this.f3247d = null;
            this.f3248e = 0;
        }
    }

    public static boolean e(RecyclerView recyclerView, int i10) {
        int j10 = recyclerView.mChildHelper.j();
        for (int i11 = 0; i11 < j10; i11++) {
            RecyclerView.d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.i(i11));
            if (childViewHolderInt.mPosition == i10 && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    public void a(RecyclerView recyclerView) {
        this.f3236a.add(recyclerView);
    }

    public final void b() {
        c cVar;
        int size = this.f3236a.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            RecyclerView recyclerView = (RecyclerView) this.f3236a.get(i11);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.c(recyclerView, false);
                i10 += recyclerView.mPrefetchRegistry.f3243d;
            }
        }
        this.f3239d.ensureCapacity(i10);
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            RecyclerView recyclerView2 = (RecyclerView) this.f3236a.get(i13);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.mPrefetchRegistry;
                int abs = Math.abs(bVar.f3240a) + Math.abs(bVar.f3241b);
                for (int i14 = 0; i14 < bVar.f3243d * 2; i14 += 2) {
                    if (i12 >= this.f3239d.size()) {
                        cVar = new c();
                        this.f3239d.add(cVar);
                    } else {
                        cVar = (c) this.f3239d.get(i12);
                    }
                    int[] iArr = bVar.f3242c;
                    int i15 = iArr[i14 + 1];
                    cVar.f3244a = i15 <= abs;
                    cVar.f3245b = abs;
                    cVar.f3246c = i15;
                    cVar.f3247d = recyclerView2;
                    cVar.f3248e = iArr[i14];
                    i12++;
                }
            }
        }
        Collections.sort(this.f3239d, f3235f);
    }

    public final void c(c cVar, long j10) {
        RecyclerView.d0 i10 = i(cVar.f3247d, cVar.f3248e, cVar.f3244a ? Long.MAX_VALUE : j10);
        if (i10 == null || i10.mNestedRecyclerView == null || !i10.isBound() || i10.isInvalid()) {
            return;
        }
        h(i10.mNestedRecyclerView.get(), j10);
    }

    public final void d(long j10) {
        for (int i10 = 0; i10 < this.f3239d.size(); i10++) {
            c cVar = (c) this.f3239d.get(i10);
            if (cVar.f3247d == null) {
                return;
            }
            c(cVar, j10);
            cVar.a();
        }
    }

    public void f(RecyclerView recyclerView, int i10, int i11) {
        if (recyclerView.isAttachedToWindow() && this.f3237b == 0) {
            this.f3237b = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.mPrefetchRegistry.e(i10, i11);
    }

    public void g(long j10) {
        b();
        d(j10);
    }

    public final void h(RecyclerView recyclerView, long j10) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.j() != 0) {
            recyclerView.removeAndRecycleViews();
        }
        b bVar = recyclerView.mPrefetchRegistry;
        bVar.c(recyclerView, true);
        if (bVar.f3243d != 0) {
            try {
                x.q.a("RV Nested Prefetch");
                recyclerView.mState.f(recyclerView.mAdapter);
                for (int i10 = 0; i10 < bVar.f3243d * 2; i10 += 2) {
                    i(recyclerView, bVar.f3242c[i10], j10);
                }
            } finally {
                x.q.b();
            }
        }
    }

    public final RecyclerView.d0 i(RecyclerView recyclerView, int i10, long j10) {
        if (e(recyclerView, i10)) {
            return null;
        }
        RecyclerView.v vVar = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.d0 I = vVar.I(i10, false, j10);
            if (I != null) {
                if (!I.isBound() || I.isInvalid()) {
                    vVar.a(I, false);
                } else {
                    vVar.B(I.itemView);
                }
            }
            return I;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    public void j(RecyclerView recyclerView) {
        this.f3236a.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            x.q.a("RV Prefetch");
            if (!this.f3236a.isEmpty()) {
                int size = this.f3236a.size();
                long j10 = 0;
                for (int i10 = 0; i10 < size; i10++) {
                    RecyclerView recyclerView = (RecyclerView) this.f3236a.get(i10);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j10 = Math.max(recyclerView.getDrawingTime(), j10);
                    }
                }
                if (j10 != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(j10) + this.f3238c);
                }
            }
        } finally {
            this.f3237b = 0L;
            x.q.b();
        }
    }
}
