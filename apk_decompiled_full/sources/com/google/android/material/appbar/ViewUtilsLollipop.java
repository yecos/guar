package com.google.android.material.appbar;

import android.R;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.internal.ThemeEnforcement;

/* loaded from: classes2.dex */
class ViewUtilsLollipop {
    private static final int[] STATE_LIST_ANIM_ATTRS = {R.attr.stateListAnimator};

    public static void setBoundsViewOutlineProvider(View view) {
        ViewOutlineProvider viewOutlineProvider;
        viewOutlineProvider = ViewOutlineProvider.BOUNDS;
        view.setOutlineProvider(viewOutlineProvider);
    }

    public static void setDefaultAppBarLayoutStateListAnimator(View view, float f10) {
        int integer = view.getResources().getInteger(com.google.android.material.R.integer.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j10 = integer;
        stateListAnimator.addState(new int[]{R.attr.enabled, com.google.android.material.R.attr.state_liftable, -com.google.android.material.R.attr.state_lifted}, ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(j10));
        stateListAnimator.addState(new int[]{R.attr.enabled}, ObjectAnimator.ofFloat(view, "elevation", f10).setDuration(j10));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(0L));
        view.setStateListAnimator(stateListAnimator);
    }

    public static void setStateListAnimatorFromAttrs(View view, AttributeSet attributeSet, int i10, int i11) {
        StateListAnimator loadStateListAnimator;
        Context context = view.getContext();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, STATE_LIST_ANIM_ATTRS, i10, i11, new int[0]);
        try {
            if (obtainStyledAttributes.hasValue(0)) {
                loadStateListAnimator = AnimatorInflater.loadStateListAnimator(context, obtainStyledAttributes.getResourceId(0, 0));
                view.setStateListAnimator(loadStateListAnimator);
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
