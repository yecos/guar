package com.hpplay.glide.load.engine.cache;

import com.hpplay.glide.load.Key;
import com.hpplay.glide.load.engine.Resource;
import com.hpplay.glide.load.engine.cache.MemoryCache;
import com.hpplay.glide.util.LruCache;

/* loaded from: classes2.dex */
public class LruResourceCache extends LruCache<Key, Resource<?>> implements MemoryCache {
    private MemoryCache.ResourceRemovedListener listener;

    public LruResourceCache(int i10) {
        super(i10);
    }

    @Override // com.hpplay.glide.load.engine.cache.MemoryCache
    public /* bridge */ /* synthetic */ Resource put(Key key, Resource resource) {
        return (Resource) super.put((LruResourceCache) key, (Key) resource);
    }

    @Override // com.hpplay.glide.load.engine.cache.MemoryCache
    public /* bridge */ /* synthetic */ Resource remove(Key key) {
        return (Resource) super.remove((LruResourceCache) key);
    }

    @Override // com.hpplay.glide.load.engine.cache.MemoryCache
    public void setResourceRemovedListener(MemoryCache.ResourceRemovedListener resourceRemovedListener) {
        this.listener = resourceRemovedListener;
    }

    @Override // com.hpplay.glide.load.engine.cache.MemoryCache
    public void trimMemory(int i10) {
        if (i10 >= 60) {
            clearMemory();
        } else if (i10 >= 40) {
            trimToSize(getCurrentSize() / 2);
        }
    }

    @Override // com.hpplay.glide.util.LruCache
    public int getSize(Resource<?> resource) {
        return resource.getSize();
    }

    @Override // com.hpplay.glide.util.LruCache
    public void onItemEvicted(Key key, Resource<?> resource) {
        MemoryCache.ResourceRemovedListener resourceRemovedListener = this.listener;
        if (resourceRemovedListener != null) {
            resourceRemovedListener.onResourceRemoved(resource);
        }
    }
}
