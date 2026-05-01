package com.mobile.brasiltv.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.hpplay.component.protocol.push.IPushHandler;

/* loaded from: classes3.dex */
public final class HorizontalItemDecoration extends RecyclerView.n {
    private final Context content;
    private final int left;

    public HorizontalItemDecoration(Context context, int i10) {
        t9.i.g(context, "content");
        this.content = context;
        this.left = i10;
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
        if (recyclerView.getChildLayoutPosition(view) == 0) {
            rect.left = this.left;
        }
    }

    public final int getLeft() {
        return this.left;
    }
}
