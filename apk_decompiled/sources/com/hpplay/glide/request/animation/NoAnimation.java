package com.hpplay.glide.request.animation;

import com.hpplay.glide.request.animation.GlideAnimation;

/* loaded from: classes2.dex */
public class NoAnimation<R> implements GlideAnimation<R> {
    private static final NoAnimation<?> NO_ANIMATION = new NoAnimation<>();
    private static final GlideAnimationFactory<?> NO_ANIMATION_FACTORY = new NoAnimationFactory();

    public static class NoAnimationFactory<R> implements GlideAnimationFactory<R> {
        @Override // com.hpplay.glide.request.animation.GlideAnimationFactory
        public GlideAnimation<R> build(boolean z10, boolean z11) {
            return NoAnimation.NO_ANIMATION;
        }
    }

    public static <R> GlideAnimation<R> get() {
        return NO_ANIMATION;
    }

    public static <R> GlideAnimationFactory<R> getFactory() {
        return (GlideAnimationFactory<R>) NO_ANIMATION_FACTORY;
    }

    @Override // com.hpplay.glide.request.animation.GlideAnimation
    public boolean animate(Object obj, GlideAnimation.ViewAdapter viewAdapter) {
        return false;
    }
}
