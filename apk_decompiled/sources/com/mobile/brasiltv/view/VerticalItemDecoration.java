package com.mobile.brasiltv.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.hpplay.component.protocol.push.IPushHandler;
import com.zhy.autolayout.utils.AutoUtils;

/* loaded from: classes3.dex */
public final class VerticalItemDecoration extends RecyclerView.n {
    private final int bottom;
    private final Context content;
    private final int top;

    public VerticalItemDecoration(Context context, int i10, int i11) {
        t9.i.g(context, "content");
        this.content = context;
        this.top = i10;
        this.bottom = i11;
    }

    public final int getBottom() {
        return this.bottom;
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
        rect.top = AutoUtils.getPercentWidthSize(this.top);
        rect.bottom = AutoUtils.getPercentWidthSize(this.bottom);
    }

    public final int getTop() {
        return this.top;
    }
}
