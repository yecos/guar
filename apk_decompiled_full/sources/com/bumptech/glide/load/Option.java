package com.bumptech.glide.load;

import com.bumptech.glide.util.Preconditions;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class Option<T> {
    private static final CacheKeyUpdater<Object> EMPTY_UPDATER = new CacheKeyUpdater<Object>() { // from class: com.bumptech.glide.load.Option.1
        @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
        public void update(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    };
    private final CacheKeyUpdater<T> cacheKeyUpdater;
    private final T defaultValue;
    private final String key;
    private volatile byte[] keyBytes;

    public interface CacheKeyUpdater<T> {
        void update(byte[] bArr, T t10, MessageDigest messageDigest);
    }

    private Option(String str, T t10, CacheKeyUpdater<T> cacheKeyUpdater) {
        this.key = Preconditions.checkNotEmpty(str);
        this.defaultValue = t10;
        this.cacheKeyUpdater = (CacheKeyUpdater) Preconditions.checkNotNull(cacheKeyUpdater);
    }

    public static <T> Option<T> disk(String str, CacheKeyUpdater<T> cacheKeyUpdater) {
        return new Option<>(str, null, cacheKeyUpdater);
    }

    private static <T> CacheKeyUpdater<T> emptyUpdater() {
        return (CacheKeyUpdater<T>) EMPTY_UPDATER;
    }

    private byte[] getKeyBytes() {
        if (this.keyBytes == null) {
            this.keyBytes = this.key.getBytes(Key.CHARSET);
        }
        return this.keyBytes;
    }

    public static <T> Option<T> memory(String str) {
        return new Option<>(str, null, emptyUpdater());
    }

    public boolean equals(Object obj) {
        if (obj instanceof Option) {
            return this.key.equals(((Option) obj).key);
        }
        return false;
    }

    public T getDefaultValue() {
        return this.defaultValue;
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.key + '\'' + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }

    public void update(T t10, MessageDigest messageDigest) {
        this.cacheKeyUpdater.update(getKeyBytes(), t10, messageDigest);
    }

    public static <T> Option<T> disk(String str, T t10, CacheKeyUpdater<T> cacheKeyUpdater) {
        return new Option<>(str, t10, cacheKeyUpdater);
    }

    public static <T> Option<T> memory(String str, T t10) {
        return new Option<>(str, t10, emptyUpdater());
    }
}
