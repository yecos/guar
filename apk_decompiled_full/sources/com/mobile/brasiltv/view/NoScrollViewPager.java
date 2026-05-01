package com.mobile.brasiltv.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes3.dex */
public class NoScrollViewPager extends ViewPager {
    private boolean isScrollable;

    public NoScrollViewPager(Context context) {
        super(context);
        this.isScrollable = false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.isScrollable) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.isScrollable) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setScrollable(boolean z10) {
        this.isScrollable = z10;
    }

    public NoScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isScrollable = false;
    }
}
