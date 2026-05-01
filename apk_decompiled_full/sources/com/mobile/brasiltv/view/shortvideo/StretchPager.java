package com.mobile.brasiltv.view.shortvideo;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.mobile.brasiltv.view.shortvideo.VerticalViewPager;

/* loaded from: classes3.dex */
public class StretchPager extends VerticalViewPager implements ValueAnimator.AnimatorUpdateListener {
    public static final int STRETCH_BOTH = 17;
    public static final int STRETCH_BOTTOM = 16;
    public static final int STRETCH_NONE = 0;
    public static final int STRETCH_TOP = 1;
    private int activePointerId;
    private final ValueAnimator anim;
    private View bottomView;
    private int directionModel;
    private int distanceY;
    private int expectDistance;
    private int firstScrollY;
    private boolean isAnimalRunning;
    private boolean isFirstMove;
    private boolean isMoveY;
    private int lastTotalDistance;
    private int lastX;
    private int lastY;
    private OnStretchListener listener;
    private int refreshModel;
    private int stretchModel;
    private boolean stretchStatus;
    private View topView;
    private boolean validTouch;

    public StretchPager(Context context) {
        this(context, null);
    }

    private void addEdgeView(View view) {
        VerticalViewPager.LayoutParams layoutParams = new VerticalViewPager.LayoutParams();
        layoutParams.isDecor = true;
        addView(view, layoutParams);
    }

    private void addTopBottomEdge() {
        View view;
        View view2;
        if (this.directionModel == 1 && (view2 = this.topView) != null && view2.getParent() == null) {
            addEdgeView(this.topView);
        } else if (this.directionModel == 16 && (view = this.bottomView) != null && view.getParent() == null) {
            addEdgeView(this.bottomView);
        }
    }

    private int getScrollDistance() {
        return this.expectDistance - getScrollY();
    }

    private boolean getStretchEnable(int i10) {
        int i11 = this.refreshModel;
        boolean z10 = (i11 & 1) > 0;
        boolean z11 = (i11 & 16) > 0;
        int i12 = this.stretchModel;
        boolean z12 = (i12 & 1) > 0;
        boolean z13 = (i12 & 16) > 0;
        if ((z12 || z10) && getCurrentItem() == 0 && i10 > 0) {
            this.directionModel = 1;
        } else {
            if ((!z13 && !z11) || getAdapter().getCount() != getCurrentItem() + 1 || i10 >= 0) {
                this.directionModel = 0;
                return false;
            }
            this.directionModel = 16;
        }
        return true;
    }

    private void refreshDoneAnim() {
        this.isAnimalRunning = true;
        this.anim.addUpdateListener(this);
        this.anim.start();
    }

    private void scrollByMove(int i10) {
        double d10;
        addTopBottomEdge();
        int height = (getHeight() * 2) / 10;
        int abs = Math.abs(getScrollY() - this.firstScrollY);
        double signum = Math.signum(-i10);
        double d11 = abs;
        double d12 = height;
        Double.isNaN(d12);
        if (d11 > d12 * 0.9d) {
            d10 = abs > height ? 0 : 1;
        } else {
            double abs2 = Math.abs(i10);
            Double.isNaN(abs2);
            d10 = abs2 * 0.75d;
        }
        Double.isNaN(signum);
        scrollBy(0, (int) (signum * d10));
        OnStretchListener onStretchListener = this.listener;
        if (onStretchListener != null) {
            onStretchListener.onScrolled(this.directionModel, getScrollDistance());
        }
    }

    private void scrollEndMove() {
        int scrollDistance = getScrollDistance();
        OnStretchListener onStretchListener = this.listener;
        if (onStretchListener != null) {
            onStretchListener.onRefresh(this.directionModel, Math.abs(scrollDistance));
        }
        refreshDoneAnim();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            boolean z10 = !this.isAnimalRunning;
            this.validTouch = z10;
            if (z10) {
                this.firstScrollY = getScrollY();
                int height = getHeight();
                double d10 = this.firstScrollY;
                Double.isNaN(d10);
                double d11 = height;
                Double.isNaN(d11);
                this.expectDistance = ((int) Math.round((d10 * 1.0d) / d11)) * height;
            }
            this.isFirstMove = true;
            this.isMoveY = false;
            this.lastX = (int) motionEvent.getX();
            this.lastY = (int) motionEvent.getY();
            this.activePointerId = motionEvent.getPointerId(0);
        } else if (action == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.activePointerId);
            if (getAdapter() != null && -1 != findPointerIndex) {
                int y10 = (int) motionEvent.getY(findPointerIndex);
                this.distanceY = y10 - this.lastY;
                if (this.isFirstMove) {
                    int x10 = ((int) motionEvent.getX(findPointerIndex)) - this.lastX;
                    int i10 = this.distanceY;
                    if (i10 != 0 && i10 != x10) {
                        this.isFirstMove = false;
                        this.isMoveY = Math.abs(i10) > Math.abs(x10);
                    }
                }
                if (this.isMoveY) {
                    this.lastY = y10;
                    if (!this.stretchStatus) {
                        this.stretchStatus = this.validTouch && getStretchEnable(this.distanceY);
                    }
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getRefreshModel() {
        return this.refreshModel;
    }

    public int getStretchModel() {
        return this.stretchModel;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        int scrollDistance = getScrollDistance();
        int i10 = this.lastTotalDistance;
        int i11 = scrollDistance + i10;
        double d10 = animatedFraction > 1.0f ? 1.0d : animatedFraction;
        double d11 = i11;
        Double.isNaN(d11);
        int i12 = ((int) (d10 * d11)) - i10;
        this.lastTotalDistance = i10 + i12;
        scrollBy(0, i12);
        if (1.0f <= animatedFraction || scrollDistance == 0) {
            this.anim.removeAllUpdateListeners();
            OnStretchListener onStretchListener = this.listener;
            if (onStretchListener != null) {
                onStretchListener.onRelease(this.directionModel);
            }
            removeView(this.topView);
            removeView(this.bottomView);
            this.lastTotalDistance = 0;
            this.isAnimalRunning = false;
            this.stretchStatus = false;
        }
    }

    @Override // com.mobile.brasiltv.view.shortvideo.VerticalViewPager, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        View childAt = getChildAt(getChildCount() - 1);
        if (childAt != null) {
            if (this.topView == childAt || this.bottomView == childAt) {
                int measuredHeight = getMeasuredHeight();
                int i14 = this.expectDistance + (childAt == this.topView ? -measuredHeight : measuredHeight);
                childAt.layout(0, i14, getMeasuredWidth(), measuredHeight + i14);
            }
        }
    }

    @Override // com.mobile.brasiltv.view.shortvideo.VerticalViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.stretchStatus) {
            int action = motionEvent.getAction() & 255;
            if (action != 1) {
                if (action == 2) {
                    if (getAdapter() != null && -1 != motionEvent.findPointerIndex(this.activePointerId)) {
                        scrollByMove(this.distanceY);
                    }
                    return true;
                }
                if (action != 3) {
                    if (action == 5) {
                        int actionIndex = motionEvent.getActionIndex();
                        this.lastY = (int) motionEvent.getY(actionIndex);
                        this.activePointerId = motionEvent.getPointerId(actionIndex);
                        return true;
                    }
                }
            }
            if (this.validTouch) {
                this.validTouch = false;
                scrollEndMove();
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAnimDuration(int i10) {
        this.anim.setDuration(i10);
    }

    public void setAnimInterpolator(Interpolator interpolator) {
        this.anim.setInterpolator(interpolator);
    }

    public void setOnStretchListener(OnStretchListener onStretchListener) {
        this.listener = onStretchListener;
    }

    public void setRefreshView(View view, View view2) {
        this.topView = view;
        this.bottomView = view2;
        if (view != null) {
            this.refreshModel |= 1;
        }
        if (view2 != null) {
            this.refreshModel |= 16;
        }
    }

    public void setStretchModel(int i10) {
        this.stretchModel = i10;
    }

    public StretchPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.refreshModel = 0;
        this.stretchModel = 17;
        this.directionModel = 0;
        this.lastX = 0;
        this.lastY = 0;
        this.distanceY = 0;
        this.stretchStatus = false;
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 1);
        this.anim = ofInt;
        this.firstScrollY = 0;
        this.lastTotalDistance = 0;
        this.isAnimalRunning = false;
        this.validTouch = false;
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.setDuration(300L);
    }
}
