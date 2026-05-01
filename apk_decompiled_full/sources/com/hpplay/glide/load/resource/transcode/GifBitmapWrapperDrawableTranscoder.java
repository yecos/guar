package com.hpplay.glide.load.resource.transcode;

import android.graphics.Bitmap;
import com.hpplay.glide.load.engine.Resource;
import com.hpplay.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.hpplay.glide.load.resource.drawable.GlideDrawable;
import com.hpplay.glide.load.resource.gifbitmap.GifBitmapWrapper;

/* loaded from: classes2.dex */
public class GifBitmapWrapperDrawableTranscoder implements ResourceTranscoder<GifBitmapWrapper, GlideDrawable> {
    private final ResourceTranscoder<Bitmap, GlideBitmapDrawable> bitmapDrawableResourceTranscoder;

    public GifBitmapWrapperDrawableTranscoder(ResourceTranscoder<Bitmap, GlideBitmapDrawable> resourceTranscoder) {
        this.bitmapDrawableResourceTranscoder = resourceTranscoder;
    }

    @Override // com.hpplay.glide.load.resource.transcode.ResourceTranscoder
    public String getId() {
        return "GifBitmapWrapperDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }

    @Override // com.hpplay.glide.load.resource.transcode.ResourceTranscoder
    public Resource<GlideDrawable> transcode(Resource<GifBitmapWrapper> resource) {
        GifBitmapWrapper gifBitmapWrapper = resource.get();
        Resource<Bitmap> bitmapResource = gifBitmapWrapper.getBitmapResource();
        return bitmapResource != null ? this.bitmapDrawableResourceTranscoder.transcode(bitmapResource) : gifBitmapWrapper.getGifResource();
    }
}
