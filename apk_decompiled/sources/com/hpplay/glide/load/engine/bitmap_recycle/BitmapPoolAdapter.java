package com.hpplay.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

/* loaded from: classes2.dex */
public class BitmapPoolAdapter implements BitmapPool {
    @Override // com.hpplay.glide.load.engine.bitmap_recycle.BitmapPool
    public void clearMemory() {
    }

    @Override // com.hpplay.glide.load.engine.bitmap_recycle.BitmapPool
    public Bitmap get(int i10, int i11, Bitmap.Config config) {
        return null;
    }

    @Override // com.hpplay.glide.load.engine.bitmap_recycle.BitmapPool
    public Bitmap getDirty(int i10, int i11, Bitmap.Config config) {
        return null;
    }

    @Override // com.hpplay.glide.load.engine.bitmap_recycle.BitmapPool
    public int getMaxSize() {
        return 0;
    }

    @Override // com.hpplay.glide.load.engine.bitmap_recycle.BitmapPool
    public boolean put(Bitmap bitmap) {
        return false;
    }

    @Override // com.hpplay.glide.load.engine.bitmap_recycle.BitmapPool
    public void setSizeMultiplier(float f10) {
    }

    @Override // com.hpplay.glide.load.engine.bitmap_recycle.BitmapPool
    public void trimMemory(int i10) {
    }
}
