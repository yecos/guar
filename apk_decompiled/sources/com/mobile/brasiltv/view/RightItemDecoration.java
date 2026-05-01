package com.mobile.brasiltv.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.hpplay.component.protocol.push.IPushHandler;
import com.mobile.brasiltv.utils.s0;

/* loaded from: classes3.dex */
public final class RightItemDecoration extends RecyclerView.n {
    private final Context content;
    private final int right;

    public RightItemDecoration(Context context, int i10) {
        t9.i.g(context, "content");
        this.content = context;
        this.right = i10;
    }

    public final Context getContent() {
        return this.content;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        t9.i.g(rect, "outRect");
        t9.i.g(view, "view");
        t9.i.g(recyclerView, "parent");
        t9.i.g(a0Var, IPushHandler.STATE);
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        if (childLayoutPosition == 0) {
            rect.left = 0;
        }
        RecyclerView.g adapter = recyclerView.getAdapter();
        if (childLayoutPosition == (adapter != null ? adapter.getItemCount() : -1)) {
            rect.right = 0;
        } else {
            rect.right = s0.c(this.content, this.right);
        }
    }

    public final int getRight() {
        return this.right;
    }
}
