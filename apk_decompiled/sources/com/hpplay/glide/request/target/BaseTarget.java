package com.hpplay.glide.request.target;

import android.graphics.drawable.Drawable;
import com.hpplay.glide.request.Request;

/* loaded from: classes2.dex */
public abstract class BaseTarget<Z> implements Target<Z> {
    private Request request;

    @Override // com.hpplay.glide.request.target.Target
    public Request getRequest() {
        return this.request;
    }

    @Override // com.hpplay.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.hpplay.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
    }

    @Override // com.hpplay.glide.request.target.Target
    public void onLoadFailed(Exception exc, Drawable drawable) {
    }

    @Override // com.hpplay.glide.request.target.Target
    public void onLoadStarted(Drawable drawable) {
    }

    @Override // com.hpplay.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.hpplay.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Override // com.hpplay.glide.request.target.Target
    public void setRequest(Request request) {
        this.request = request;
    }
}
