package com.hpplay.glide.request.target;

import android.graphics.drawable.Drawable;
import com.hpplay.glide.manager.LifecycleListener;
import com.hpplay.glide.request.Request;
import com.hpplay.glide.request.animation.GlideAnimation;

/* loaded from: classes2.dex */
public interface Target<R> extends LifecycleListener {
    public static final int SIZE_ORIGINAL = Integer.MIN_VALUE;

    Request getRequest();

    void getSize(SizeReadyCallback sizeReadyCallback);

    void onLoadCleared(Drawable drawable);

    void onLoadFailed(Exception exc, Drawable drawable);

    void onLoadStarted(Drawable drawable);

    void onResourceReady(R r10, GlideAnimation<? super R> glideAnimation);

    void setRequest(Request request);
}
