package com.chad.library.adapter.base.listener;

import android.graphics.Canvas;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public interface OnItemSwipeListener {
    void clearView(RecyclerView.d0 d0Var, int i10);

    void onItemSwipeMoving(Canvas canvas, RecyclerView.d0 d0Var, float f10, float f11, boolean z10);

    void onItemSwipeStart(RecyclerView.d0 d0Var, int i10);

    void onItemSwiped(RecyclerView.d0 d0Var, int i10);
}
