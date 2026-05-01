package com.mobile.brasiltv.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import com.mobile.brasiltv.view.KoocanRecyclerView;
import com.zhy.autolayout.AutoFrameLayout;

/* loaded from: classes3.dex */
public class AnimatorFrameLayout extends AutoFrameLayout {
    private boolean animatorEnd;
    private KoocanRecyclerView.OnVisibility mOnVisibility;

    public AnimatorFrameLayout(Context context) {
        super(context);
        this.animatorEnd = true;
    }

    public void setOnVisibilityListener(KoocanRecyclerView.OnVisibility onVisibility) {
        this.mOnVisibility = onVisibility;
    }

    @Override // android.view.View
    public void setVisibility(final int i10) {
        KoocanRecyclerView.OnVisibility onVisibility = this.mOnVisibility;
        if (onVisibility != null) {
            onVisibility.onVisibility(i10, this);
        }
        if (this.animatorEnd) {
            if (i10 != 0) {
                ObjectAnimator duration = ObjectAnimator.ofFloat(this, "translationX", 0.0f, -getWidth()).setDuration(500L);
                duration.setInterpolator(new DecelerateInterpolator());
                duration.addListener(new AnimatorListenerAdapter() { // from class: com.mobile.brasiltv.view.AnimatorFrameLayout.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        AnimatorFrameLayout.this.animatorEnd = true;
                        AnimatorFrameLayout.super.setVisibility(i10);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        AnimatorFrameLayout.this.animatorEnd = false;
                    }
                });
                duration.start();
                return;
            }
            super.setVisibility(i10);
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(this, "translationX", -getWidth(), 0.0f).setDuration(500L);
            duration2.setInterpolator(new DecelerateInterpolator());
            duration2.addListener(new AnimatorListenerAdapter() { // from class: com.mobile.brasiltv.view.AnimatorFrameLayout.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AnimatorFrameLayout.this.animatorEnd = true;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    AnimatorFrameLayout.this.animatorEnd = false;
                }
            });
            duration2.start();
        }
    }

    public AnimatorFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.animatorEnd = true;
    }
}
