package com.bumptech.glide.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class LruCache<T, Y> {
    private final Map<T, Entry<Y>> cache = new LinkedHashMap(100, 0.75f, true);
    private long currentSize;
    private final long initialMaxSize;
    private long maxSize;

    public static final class Entry<Y> {
        final int size;
        final Y value;

        public Entry(Y y10, int i10) {
            this.value = y10;
            this.size = i10;
        }
    }

    public LruCache(long j10) {
        this.initialMaxSize = j10;
        this.maxSize = j10;
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    public void clearMemory() {
        trimToSize(0L);
    }

    public synchronized boolean contains(T t10) {
        return this.cache.containsKey(t10);
    }

    public synchronized Y get(T t10) {
        Entry<Y> entry;
        entry = this.cache.get(t10);
        return entry != null ? entry.value : null;
    }

    public synchronized int getCount() {
        return this.cache.size();
    }

    public synchronized long getCurrentSize() {
        return this.currentSize;
    }

    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    public int getSize(Y y10) {
        return 1;
    }

    public void onItemEvicted(T t10, Y y10) {
    }

    public synchronized Y put(T t10, Y y10) {
        int size = getSize(y10);
        long j10 = size;
        if (j10 >= this.maxSize) {
            onItemEvicted(t10, y10);
            return null;
        }
        if (y10 != null) {
            this.currentSize += j10;
        }
        Entry<Y> put = this.cache.put(t10, y10 == null ? null : new Entry<>(y10, size));
        if (put != null) {
            this.currentSize -= put.size;
            if (!put.value.equals(y10)) {
                onItemEvicted(t10, put.value);
            }
        }
        evict();
        return put != null ? put.value : null;
    }

    public synchronized Y remove(T t10) {
        Entry<Y> remove = this.cache.remove(t10);
        if (remove == null) {
            return null;
        }
        this.currentSize -= remove.size;
        return remove.value;
    }

    public synchronized void setSizeMultiplier(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("Multiplier must be >= 0");
        }
        this.maxSize = Math.round(this.initialMaxSize * f10);
        evict();
    }

    public synchronized void trimToSize(long j10) {
        while (this.currentSize > j10) {
            Iterator<Map.Entry<T, Entry<Y>>> it = this.cache.entrySet().iterator();
            Map.Entry<T, Entry<Y>> next = it.next();
            Entry<Y> value = next.getValue();
            this.currentSize -= value.size;
            T key = next.getKey();
            it.remove();
            onItemEvicted(key, value.value);
        }
    }
}
