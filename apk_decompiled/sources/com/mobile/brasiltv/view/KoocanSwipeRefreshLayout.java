package com.mobile.brasiltv.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.msandroid.mobile.R;

/* loaded from: classes3.dex */
public class KoocanSwipeRefreshLayout extends SwipeRefreshLayout {
    public KoocanSwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public KoocanSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setColorSchemeResources(R.color.color_selected);
    }
}
