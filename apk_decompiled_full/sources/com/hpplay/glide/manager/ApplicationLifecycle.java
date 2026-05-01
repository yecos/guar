package com.hpplay.glide.manager;

/* loaded from: classes2.dex */
class ApplicationLifecycle implements Lifecycle {
    @Override // com.hpplay.glide.manager.Lifecycle
    public void addListener(LifecycleListener lifecycleListener) {
        lifecycleListener.onStart();
    }
}
