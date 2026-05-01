package com.hpplay.glide.util;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class LruCache<T, Y> {
    private final LinkedHashMap<T, Y> cache = new LinkedHashMap<>(100, 0.75f, true);
    private int currentSize = 0;
    private final int initialMaxSize;
    private int maxSize;

    public LruCache(int i10) {
        this.initialMaxSize = i10;
        this.maxSize = i10;
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    public void clearMemory() {
        trimToSize(0);
    }

    public boolean contains(T t10) {
        return this.cache.containsKey(t10);
    }

    public Y get(T t10) {
        return this.cache.get(t10);
    }

    public int getCurrentSize() {
        return this.currentSize;
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public int getSize(Y y10) {
        return 1;
    }

    public void onItemEvicted(T t10, Y y10) {
    }

    public Y put(T t10, Y y10) {
        if (getSize(y10) >= this.maxSize) {
            onItemEvicted(t10, y10);
            return null;
        }
        Y put = this.cache.put(t10, y10);
        if (y10 != null) {
            this.currentSize += getSize(y10);
        }
        if (put != null) {
            this.currentSize -= getSize(put);
        }
        evict();
        return put;
    }

    public Y remove(T t10) {
        Y remove = this.cache.remove(t10);
        if (remove != null) {
            this.currentSize -= getSize(remove);
        }
        return remove;
    }

    public void setSizeMultiplier(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("Multiplier must be >= 0");
        }
        this.maxSize = Math.round(this.initialMaxSize * f10);
        evict();
    }

    public void trimToSize(int i10) {
        while (this.currentSize > i10) {
            Map.Entry<T, Y> next = this.cache.entrySet().iterator().next();
            Y value = next.getValue();
            this.currentSize -= getSize(value);
            T key = next.getKey();
            this.cache.remove(key);
            onItemEvicted(key, value);
        }
    }
}
