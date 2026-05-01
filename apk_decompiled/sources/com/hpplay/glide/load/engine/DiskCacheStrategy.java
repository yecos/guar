package com.hpplay.glide.load.engine;

/* loaded from: classes2.dex */
public enum DiskCacheStrategy {
    ALL(true, true),
    NONE(false, false),
    SOURCE(true, false),
    RESULT(false, true);

    private final boolean cacheResult;
    private final boolean cacheSource;

    DiskCacheStrategy(boolean z10, boolean z11) {
        this.cacheSource = z10;
        this.cacheResult = z11;
    }

    public boolean cacheResult() {
        return this.cacheResult;
    }

    public boolean cacheSource() {
        return this.cacheSource;
    }
}
