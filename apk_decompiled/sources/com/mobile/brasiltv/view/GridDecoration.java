package com.mobile.brasiltv.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class GridDecoration extends RecyclerView.n {
    private int size;
    private int totalSize;

    public GridDecoration(int i10, int i11) {
        this.size = i10;
        this.totalSize = i11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        int i10 = this.size;
        rect.right = i10;
        if (childLayoutPosition < this.totalSize) {
            rect.top = i10;
        } else {
            rect.top = 0;
        }
        rect.bottom = i10;
    }
}
