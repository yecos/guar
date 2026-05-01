package com.hpplay.glide.request.target;

import android.widget.ImageView;
import com.hpplay.glide.load.resource.drawable.GlideDrawable;
import com.hpplay.glide.request.animation.GlideAnimation;

/* loaded from: classes2.dex */
public class GlideDrawableImageViewTarget extends ImageViewTarget<GlideDrawable> {
    private static final float SQUARE_RATIO_MARGIN = 0.05f;
    private int maxLoopCount;
    private GlideDrawable resource;

    public GlideDrawableImageViewTarget(ImageView imageView) {
        this(imageView, -1);
    }

    @Override // com.hpplay.glide.request.target.ImageViewTarget, com.hpplay.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(Object obj, GlideAnimation glideAnimation) {
        onResourceReady((GlideDrawable) obj, (GlideAnimation<? super GlideDrawable>) glideAnimation);
    }

    @Override // com.hpplay.glide.request.target.BaseTarget, com.hpplay.glide.manager.LifecycleListener
    public void onStart() {
        GlideDrawable glideDrawable = this.resource;
        if (glideDrawable != null) {
            glideDrawable.start();
        }
    }

    @Override // com.hpplay.glide.request.target.BaseTarget, com.hpplay.glide.manager.LifecycleListener
    public void onStop() {
        GlideDrawable glideDrawable = this.resource;
        if (glideDrawable != null) {
            glideDrawable.stop();
        }
    }

    public GlideDrawableImageViewTarget(ImageView imageView, int i10) {
        super(imageView);
        this.maxLoopCount = i10;
    }

    public void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
        if (!glideDrawable.isAnimated()) {
            float intrinsicWidth = glideDrawable.getIntrinsicWidth() / glideDrawable.getIntrinsicHeight();
            if (Math.abs((((ImageView) this.view).getWidth() / ((ImageView) this.view).getHeight()) - 1.0f) <= SQUARE_RATIO_MARGIN && Math.abs(intrinsicWidth - 1.0f) <= SQUARE_RATIO_MARGIN) {
                glideDrawable = new SquaringDrawable(glideDrawable, ((ImageView) this.view).getWidth());
            }
        }
        super.onResourceReady((GlideDrawableImageViewTarget) glideDrawable, (GlideAnimation<? super GlideDrawableImageViewTarget>) glideAnimation);
        this.resource = glideDrawable;
        glideDrawable.setLoopCount(this.maxLoopCount);
        glideDrawable.start();
    }

    @Override // com.hpplay.glide.request.target.ImageViewTarget
    public void setResource(GlideDrawable glideDrawable) {
        ((ImageView) this.view).setImageDrawable(glideDrawable);
    }
}
