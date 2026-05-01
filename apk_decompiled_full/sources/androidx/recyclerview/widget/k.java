package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class k extends r {

    /* renamed from: d, reason: collision with root package name */
    public m f3259d;

    /* renamed from: e, reason: collision with root package name */
    public m f3260e;

    @Override // androidx.recyclerview.widget.r
    public int[] c(RecyclerView.o oVar, View view) {
        int[] iArr = new int[2];
        if (oVar.canScrollHorizontally()) {
            iArr[0] = n(oVar, view, q(oVar));
        } else {
            iArr[0] = 0;
        }
        if (oVar.canScrollVertically()) {
            iArr[1] = n(oVar, view, r(oVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.r
    public View h(RecyclerView.o oVar) {
        if (oVar.canScrollVertically()) {
            return p(oVar, r(oVar));
        }
        if (oVar.canScrollHorizontally()) {
            return p(oVar, q(oVar));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.r
    public int i(RecyclerView.o oVar, int i10, int i11) {
        int itemCount;
        View h10;
        int position;
        int i12;
        PointF computeScrollVectorForPosition;
        int i13;
        int i14;
        if (!(oVar instanceof RecyclerView.z.b) || (itemCount = oVar.getItemCount()) == 0 || (h10 = h(oVar)) == null || (position = oVar.getPosition(h10)) == -1 || (computeScrollVectorForPosition = ((RecyclerView.z.b) oVar).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return -1;
        }
        if (oVar.canScrollHorizontally()) {
            i13 = o(oVar, q(oVar), i10, 0);
            if (computeScrollVectorForPosition.x < 0.0f) {
                i13 = -i13;
            }
        } else {
            i13 = 0;
        }
        if (oVar.canScrollVertically()) {
            i14 = o(oVar, r(oVar), 0, i11);
            if (computeScrollVectorForPosition.y < 0.0f) {
                i14 = -i14;
            }
        } else {
            i14 = 0;
        }
        if (oVar.canScrollVertically()) {
            i13 = i14;
        }
        if (i13 == 0) {
            return -1;
        }
        int i15 = position + i13;
        int i16 = i15 >= 0 ? i15 : 0;
        return i16 >= itemCount ? i12 : i16;
    }

    public final float m(RecyclerView.o oVar, m mVar) {
        int childCount = oVar.getChildCount();
        if (childCount == 0) {
            return 1.0f;
        }
        View view = null;
        View view2 = null;
        int i10 = Integer.MAX_VALUE;
        int i11 = Integer.MIN_VALUE;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = oVar.getChildAt(i12);
            int position = oVar.getPosition(childAt);
            if (position != -1) {
                if (position < i10) {
                    view = childAt;
                    i10 = position;
                }
                if (position > i11) {
                    view2 = childAt;
                    i11 = position;
                }
            }
        }
        if (view == null || view2 == null) {
            return 1.0f;
        }
        int max = Math.max(mVar.d(view), mVar.d(view2)) - Math.min(mVar.g(view), mVar.g(view2));
        if (max == 0) {
            return 1.0f;
        }
        return (max * 1.0f) / ((i11 - i10) + 1);
    }

    public final int n(RecyclerView.o oVar, View view, m mVar) {
        return (mVar.g(view) + (mVar.e(view) / 2)) - (mVar.m() + (mVar.n() / 2));
    }

    public final int o(RecyclerView.o oVar, m mVar, int i10, int i11) {
        int[] d10 = d(i10, i11);
        float m10 = m(oVar, mVar);
        if (m10 <= 0.0f) {
            return 0;
        }
        return Math.round((Math.abs(d10[0]) > Math.abs(d10[1]) ? d10[0] : d10[1]) / m10);
    }

    public final View p(RecyclerView.o oVar, m mVar) {
        int childCount = oVar.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int m10 = mVar.m() + (mVar.n() / 2);
        int i10 = Integer.MAX_VALUE;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = oVar.getChildAt(i11);
            int abs = Math.abs((mVar.g(childAt) + (mVar.e(childAt) / 2)) - m10);
            if (abs < i10) {
                view = childAt;
                i10 = abs;
            }
        }
        return view;
    }

    public final m q(RecyclerView.o oVar) {
        m mVar = this.f3260e;
        if (mVar == null || mVar.f3262a != oVar) {
            this.f3260e = m.a(oVar);
        }
        return this.f3260e;
    }

    public final m r(RecyclerView.o oVar) {
        m mVar = this.f3259d;
        if (mVar == null || mVar.f3262a != oVar) {
            this.f3259d = m.c(oVar);
        }
        return this.f3259d;
    }
}
