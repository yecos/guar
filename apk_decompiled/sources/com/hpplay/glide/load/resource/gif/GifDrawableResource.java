package com.hpplay.glide.load.resource.gif;

import com.hpplay.glide.load.resource.drawable.DrawableResource;
import com.hpplay.glide.util.Util;

/* loaded from: classes2.dex */
public class GifDrawableResource extends DrawableResource<GifDrawable> {
    public GifDrawableResource(GifDrawable gifDrawable) {
        super(gifDrawable);
    }

    @Override // com.hpplay.glide.load.engine.Resource
    public int getSize() {
        return ((GifDrawable) this.drawable).getData().length + Util.getBitmapByteSize(((GifDrawable) this.drawable).getFirstFrame());
    }

    @Override // com.hpplay.glide.load.engine.Resource
    public void recycle() {
        ((GifDrawable) this.drawable).stop();
        ((GifDrawable) this.drawable).recycle();
    }
}
