package com.mobile.brasiltv.view;

import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.msandroid.mobile.R;

/* loaded from: classes3.dex */
public class RecyclerLoadMoreView extends LoadMoreView {
    @Override // com.chad.library.adapter.base.loadmore.LoadMoreView
    public int getLayoutId() {
        return R.layout.layout_recycler_load_more;
    }

    @Override // com.chad.library.adapter.base.loadmore.LoadMoreView
    public int getLoadEndViewId() {
        return R.id.layout_over_view;
    }

    @Override // com.chad.library.adapter.base.loadmore.LoadMoreView
    public int getLoadFailViewId() {
        return R.id.layout_failed_view;
    }

    @Override // com.chad.library.adapter.base.loadmore.LoadMoreView
    public int getLoadingViewId() {
        return R.id.layout_loading_view;
    }

    @Override // com.chad.library.adapter.base.loadmore.LoadMoreView
    public boolean isLoadEndGone() {
        return false;
    }
}
