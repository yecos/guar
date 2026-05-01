package com.hpplay.glide.request.animation;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import com.hpplay.glide.request.animation.GlideAnimation;

/* loaded from: classes2.dex */
public class DrawableCrossFadeViewAnimation<T extends Drawable> implements GlideAnimation<T> {
    private final GlideAnimation<T> defaultAnimation;
    private final int duration;

    public DrawableCrossFadeViewAnimation(GlideAnimation<T> glideAnimation, int i10) {
        this.defaultAnimation = glideAnimation;
        this.duration = i10;
    }

    @Override // com.hpplay.glide.request.animation.GlideAnimation
    public boolean animate(T t10, GlideAnimation.ViewAdapter viewAdapter) {
        Drawable currentDrawable = viewAdapter.getCurrentDrawable();
        if (currentDrawable == null) {
            this.defaultAnimation.animate(t10, viewAdapter);
            return false;
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{currentDrawable, t10});
        transitionDrawable.setCrossFadeEnabled(true);
        transitionDrawable.startTransition(this.duration);
        viewAdapter.setDrawable(transitionDrawable);
        return true;
    }
}
