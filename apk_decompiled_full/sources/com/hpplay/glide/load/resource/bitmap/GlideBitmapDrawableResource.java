package com.hpplay.glide.load.resource.bitmap;

import com.hpplay.glide.load.engine.bitmap_recycle.BitmapPool;
import com.hpplay.glide.load.resource.drawable.DrawableResource;
import com.hpplay.glide.util.Util;

/* loaded from: classes2.dex */
public class GlideBitmapDrawableResource extends DrawableResource<GlideBitmapDrawable> {
    private final BitmapPool bitmapPool;

    public GlideBitmapDrawableResource(GlideBitmapDrawable glideBitmapDrawable, BitmapPool bitmapPool) {
        super(glideBitmapDrawable);
        this.bitmapPool = bitmapPool;
    }

    @Override // com.hpplay.glide.load.engine.Resource
    public int getSize() {
        return Util.getBitmapByteSize(((GlideBitmapDrawable) this.drawable).getBitmap());
    }

    @Override // com.hpplay.glide.load.engine.Resource
    public void recycle() {
        this.bitmapPool.put(((GlideBitmapDrawable) this.drawable).getBitmap());
    }
}
