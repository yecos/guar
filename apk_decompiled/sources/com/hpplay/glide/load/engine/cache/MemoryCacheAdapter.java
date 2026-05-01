package com.hpplay.glide.load.engine.cache;

import com.hpplay.glide.load.Key;
import com.hpplay.glide.load.engine.Resource;
import com.hpplay.glide.load.engine.cache.MemoryCache;

/* loaded from: classes2.dex */
public class MemoryCacheAdapter implements MemoryCache {
    private MemoryCache.ResourceRemovedListener listener;

    @Override // com.hpplay.glide.load.engine.cache.MemoryCache
    public void clearMemory() {
    }

    @Override // com.hpplay.glide.load.engine.cache.MemoryCache
    public int getCurrentSize() {
        return 0;
    }

    @Override // com.hpplay.glide.load.engine.cache.MemoryCache
    public int getMaxSize() {
        return 0;
    }

    @Override // com.hpplay.glide.load.engine.cache.MemoryCache
    public Resource<?> put(Key key, Resource<?> resource) {
        this.listener.onResourceRemoved(resource);
        return null;
    }

    @Override // com.hpplay.glide.load.engine.cache.MemoryCache
    public Resource<?> remove(Key key) {
        return null;
    }

    @Override // com.hpplay.glide.load.engine.cache.MemoryCache
    public void setResourceRemovedListener(MemoryCache.ResourceRemovedListener resourceRemovedListener) {
        this.listener = resourceRemovedListener;
    }

    @Override // com.hpplay.glide.load.engine.cache.MemoryCache
    public void setSizeMultiplier(float f10) {
    }

    @Override // com.hpplay.glide.load.engine.cache.MemoryCache
    public void trimMemory(int i10) {
    }
}
