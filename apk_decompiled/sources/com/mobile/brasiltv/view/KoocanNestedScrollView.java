package com.mobile.brasiltv.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.widget.NestedScrollView;

/* loaded from: classes3.dex */
public class KoocanNestedScrollView extends NestedScrollView {
    private OnOverScroller mOnOverScroller;

    public interface OnOverScroller {
        void onBottom();
    }

    public KoocanNestedScrollView(Context context) {
        super(context, null);
    }

    private void init() {
        setOnScrollChangeListener(new NestedScrollView.b() { // from class: com.mobile.brasiltv.view.KoocanNestedScrollView.1
            @Override // androidx.core.widget.NestedScrollView.b
            public void onScrollChange(NestedScrollView nestedScrollView, int i10, int i11, int i12, int i13) {
                if (KoocanNestedScrollView.this.getChildAt(0).getHeight() != i11 + KoocanNestedScrollView.this.getHeight() || KoocanNestedScrollView.this.mOnOverScroller == null) {
                    return;
                }
                KoocanNestedScrollView.this.mOnOverScroller.onBottom();
            }
        });
    }

    public void setOnScrollerOverListener(OnOverScroller onOverScroller) {
        this.mOnOverScroller = onOverScroller;
    }

    public KoocanNestedScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }
}
