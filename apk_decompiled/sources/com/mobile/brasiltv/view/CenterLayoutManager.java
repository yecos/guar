package com.mobile.brasiltv.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class CenterLayoutManager extends LinearLayoutManager {

    public static class CenterSmoothScroller extends androidx.recyclerview.widget.j {
        public CenterSmoothScroller(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.j
        public int calculateDtToFit(int i10, int i11, int i12, int i13, int i14) {
            return (i12 + ((i13 - i12) / 2)) - (i10 + ((i11 - i10) / 2));
        }

        @Override // androidx.recyclerview.widget.j
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }
    }

    public CenterLayoutManager(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.a0 a0Var, int i10) {
        CenterSmoothScroller centerSmoothScroller = new CenterSmoothScroller(recyclerView.getContext());
        centerSmoothScroller.setTargetPosition(i10);
        startSmoothScroll(centerSmoothScroller);
    }

    public CenterLayoutManager(Context context, int i10, boolean z10) {
        super(context, i10, z10);
    }

    public CenterLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }
}
