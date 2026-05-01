package com.mobile.brasiltv.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class TopDecoration extends RecyclerView.n {
    private int top;

    public TopDecoration(int i10) {
        this.top = i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        if (recyclerView.getChildLayoutPosition(view) == 0) {
            rect.top = this.top;
        }
    }
}
