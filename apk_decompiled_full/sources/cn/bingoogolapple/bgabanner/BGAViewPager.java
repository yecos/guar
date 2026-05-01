package cn.bingoogolapple.bgabanner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import androidx.viewpager.widget.ViewPager;
import b0.c1;
import b0.h0;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class BGAViewPager extends ViewPager {
    private boolean mAllowUserScrollable;
    private AutoPlayDelegate mAutoPlayDelegate;

    public interface AutoPlayDelegate {
        void handleAutoPlayActionUpOrCancel(float f10);
    }

    public BGAViewPager(Context context) {
        super(context);
        this.mAllowUserScrollable = true;
    }

    private float getXVelocity() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mVelocityTracker");
            declaredField.setAccessible(true);
            VelocityTracker velocityTracker = (VelocityTracker) declaredField.get(this);
            Field declaredField2 = ViewPager.class.getDeclaredField("mActivePointerId");
            declaredField2.setAccessible(true);
            ViewPager.class.getDeclaredField("mMaximumVelocity").setAccessible(true);
            velocityTracker.computeCurrentVelocity(1000, r0.getInt(this));
            return h0.a(velocityTracker, declaredField2.getInt(this));
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.mAllowUserScrollable || getAdapter() == null || getAdapter().getCount() <= 0) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mAllowUserScrollable || getAdapter() == null || getAdapter().getCount() <= 0) {
            return false;
        }
        if (this.mAutoPlayDelegate == null || !(motionEvent.getAction() == 3 || motionEvent.getAction() == 1)) {
            return super.onTouchEvent(motionEvent);
        }
        this.mAutoPlayDelegate.handleAutoPlayActionUpOrCancel(getXVelocity());
        return false;
    }

    public void setAllowUserScrollable(boolean z10) {
        this.mAllowUserScrollable = z10;
    }

    public void setAutoPlayDelegate(AutoPlayDelegate autoPlayDelegate) {
        this.mAutoPlayDelegate = autoPlayDelegate;
    }

    public void setBannerCurrentItemInternal(int i10, boolean z10) {
        try {
            Class cls = Boolean.TYPE;
            Method declaredMethod = ViewPager.class.getDeclaredMethod("setCurrentItemInternal", Integer.TYPE, cls, cls);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this, Integer.valueOf(i10), Boolean.valueOf(z10), Boolean.TRUE);
            c1.b0(this);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void setPageChangeDuration(int i10) {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(this, new BGABannerScroller(getContext(), i10));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public BGAViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAllowUserScrollable = true;
    }
}
