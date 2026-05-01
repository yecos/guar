package com.hpplay.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.hpplay.glide.gifdecoder.GifDecoder;
import com.hpplay.glide.load.engine.bitmap_recycle.BitmapPool;

/* loaded from: classes2.dex */
class GifBitmapProvider implements GifDecoder.BitmapProvider {
    private final BitmapPool bitmapPool;

    public GifBitmapProvider(BitmapPool bitmapPool) {
        this.bitmapPool = bitmapPool;
    }

    @Override // com.hpplay.glide.gifdecoder.GifDecoder.BitmapProvider
    public Bitmap obtain(int i10, int i11, Bitmap.Config config) {
        return this.bitmapPool.getDirty(i10, i11, config);
    }

    @Override // com.hpplay.glide.gifdecoder.GifDecoder.BitmapProvider
    public void release(Bitmap bitmap) {
        if (this.bitmapPool.put(bitmap)) {
            return;
        }
        bitmap.recycle();
    }
}
