package com.mobile.brasiltv.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class KoocanRecyclerView extends RecyclerView {
    private boolean animatorEnd;
    private OnVisibility mOnVisibility;
    private int totalScrollY;

    public interface OnVisibility {
        void onVisibility(int i10, View view);
    }

    public KoocanRecyclerView(Context context) {
        this(context, null);
    }

    private void initParams() {
        setFocusable(false);
        setFocusableInTouchMode(false);
        setOnScrollListener(new RecyclerView.t() { // from class: com.mobile.brasiltv.view.KoocanRecyclerView.1
            @Override // androidx.recyclerview.widget.RecyclerView.t
            public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
                KoocanRecyclerView.this.totalScrollY += i11;
            }
        });
    }

    public int getTotalScrollY() {
        return this.totalScrollY;
    }

    public void setOnVisibilityListener(OnVisibility onVisibility) {
        this.mOnVisibility = onVisibility;
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        OnVisibility onVisibility = this.mOnVisibility;
        if (onVisibility != null) {
            onVisibility.onVisibility(i10, this);
        }
    }

    public void setVisibilityAnimate(final int i10) {
        if (this.animatorEnd) {
            OnVisibility onVisibility = this.mOnVisibility;
            if (onVisibility != null) {
                onVisibility.onVisibility(i10, this);
            }
            if (i10 != 0) {
                ObjectAnimator duration = ObjectAnimator.ofFloat(this, "translationY", 0.0f, (-getContext().getResources().getDisplayMetrics().heightPixels) / 2).setDuration(400L);
                duration.setInterpolator(new DecelerateInterpolator());
                duration.addListener(new AnimatorListenerAdapter() { // from class: com.mobile.brasiltv.view.KoocanRecyclerView.3
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        KoocanRecyclerView.this.animatorEnd = true;
                        KoocanRecyclerView.super.setVisibility(i10);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        KoocanRecyclerView.this.animatorEnd = false;
                    }
                });
                duration.start();
                return;
            }
            super.setVisibility(i10);
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(this, "translationY", (-getContext().getResources().getDisplayMetrics().heightPixels) / 2, 0.0f).setDuration(400L);
            duration2.setInterpolator(new DecelerateInterpolator());
            duration2.addListener(new AnimatorListenerAdapter() { // from class: com.mobile.brasiltv.view.KoocanRecyclerView.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    KoocanRecyclerView.this.animatorEnd = true;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    KoocanRecyclerView.this.animatorEnd = false;
                }
            });
            duration2.start();
        }
    }

    public KoocanRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KoocanRecyclerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.animatorEnd = true;
        initParams();
    }
}
