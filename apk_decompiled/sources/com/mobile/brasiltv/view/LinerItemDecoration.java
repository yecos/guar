package com.mobile.brasiltv.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class LinerItemDecoration extends RecyclerView.n {
    private boolean isVertical;
    private int leftSpace;
    private int topSpace;

    public LinerItemDecoration(int i10, int i11, boolean z10) {
        this.topSpace = i10;
        this.leftSpace = i11;
        this.isVertical = z10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        if (this.isVertical) {
            if (childLayoutPosition != 0) {
                rect.top = this.topSpace;
            }
        } else if (childLayoutPosition != 0) {
            rect.left = this.leftSpace;
        }
    }
}
