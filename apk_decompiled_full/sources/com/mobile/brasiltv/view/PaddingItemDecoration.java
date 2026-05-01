package com.mobile.brasiltv.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.hpplay.component.protocol.push.IPushHandler;
import com.zhy.autolayout.utils.AutoUtils;

/* loaded from: classes3.dex */
public final class PaddingItemDecoration extends RecyclerView.n {
    private final Context content;
    private final boolean hasBottom;
    private final boolean hasTop;
    private final int padding;

    public PaddingItemDecoration(Context context, int i10, boolean z10, boolean z11) {
        t9.i.g(context, "content");
        this.content = context;
        this.padding = i10;
        this.hasTop = z10;
        this.hasBottom = z11;
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
        RecyclerView.g adapter = recyclerView.getAdapter();
        if (childLayoutPosition == (adapter != null ? adapter.getItemCount() : -1)) {
            rect.left = AutoUtils.getPercentWidthSize(this.padding);
            rect.right = AutoUtils.getPercentWidthSize(this.padding);
            if (this.hasTop) {
                rect.top = AutoUtils.getPercentHeightSize(this.padding);
            }
            if (this.hasBottom) {
                rect.bottom = AutoUtils.getPercentHeightSize(this.padding);
                return;
            }
            return;
        }
        rect.left = AutoUtils.getPercentWidthSize(this.padding);
        rect.right = AutoUtils.getPercentWidthSize(this.padding);
        if (this.hasTop) {
            rect.top = AutoUtils.getPercentHeightSize(this.padding);
        }
        if (this.hasBottom) {
            rect.bottom = AutoUtils.getPercentHeightSize(this.padding);
        }
    }

    public final int getPadding() {
        return this.padding;
    }

    public /* synthetic */ PaddingItemDecoration(Context context, int i10, boolean z10, boolean z11, int i11, t9.g gVar) {
        this(context, i10, (i11 & 4) != 0 ? false : z10, (i11 & 8) != 0 ? false : z11);
    }
}
