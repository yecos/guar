package com.hpplay.glide.request.animation;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.hpplay.glide.request.animation.ViewAnimation;

/* loaded from: classes2.dex */
public class ViewAnimationFactory<R> implements GlideAnimationFactory<R> {
    private final ViewAnimation.AnimationFactory animationFactory;
    private GlideAnimation<R> glideAnimation;

    public static class ConcreteAnimationFactory implements ViewAnimation.AnimationFactory {
        private final Animation animation;

        public ConcreteAnimationFactory(Animation animation) {
            this.animation = animation;
        }

        @Override // com.hpplay.glide.request.animation.ViewAnimation.AnimationFactory
        public Animation build() {
            return this.animation;
        }
    }

    public static class ResourceAnimationFactory implements ViewAnimation.AnimationFactory {
        private final int animationId;
        private final Context context;

        public ResourceAnimationFactory(Context context, int i10) {
            this.context = context.getApplicationContext();
            this.animationId = i10;
        }

        @Override // com.hpplay.glide.request.animation.ViewAnimation.AnimationFactory
        public Animation build() {
            return AnimationUtils.loadAnimation(this.context, this.animationId);
        }
    }

    public ViewAnimationFactory(Animation animation) {
        this(new ConcreteAnimationFactory(animation));
    }

    @Override // com.hpplay.glide.request.animation.GlideAnimationFactory
    public GlideAnimation<R> build(boolean z10, boolean z11) {
        if (z10 || !z11) {
            return NoAnimation.get();
        }
        if (this.glideAnimation == null) {
            this.glideAnimation = new ViewAnimation(this.animationFactory);
        }
        return this.glideAnimation;
    }

    public ViewAnimationFactory(Context context, int i10) {
        this(new ResourceAnimationFactory(context, i10));
    }

    public ViewAnimationFactory(ViewAnimation.AnimationFactory animationFactory) {
        this.animationFactory = animationFactory;
    }
}
