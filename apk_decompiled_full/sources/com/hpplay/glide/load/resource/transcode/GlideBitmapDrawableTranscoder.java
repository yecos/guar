package com.hpplay.glide.load.resource.transcode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.hpplay.glide.Glide;
import com.hpplay.glide.load.engine.Resource;
import com.hpplay.glide.load.engine.bitmap_recycle.BitmapPool;
import com.hpplay.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.hpplay.glide.load.resource.bitmap.GlideBitmapDrawableResource;

/* loaded from: classes2.dex */
public class GlideBitmapDrawableTranscoder implements ResourceTranscoder<Bitmap, GlideBitmapDrawable> {
    private final BitmapPool bitmapPool;
    private final Resources resources;

    public GlideBitmapDrawableTranscoder(Context context) {
        this(context.getResources(), Glide.get(context).getBitmapPool());
    }

    @Override // com.hpplay.glide.load.resource.transcode.ResourceTranscoder
    public String getId() {
        return "GlideBitmapDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }

    @Override // com.hpplay.glide.load.resource.transcode.ResourceTranscoder
    public Resource<GlideBitmapDrawable> transcode(Resource<Bitmap> resource) {
        return new GlideBitmapDrawableResource(new GlideBitmapDrawable(this.resources, resource.get()), this.bitmapPool);
    }

    public GlideBitmapDrawableTranscoder(Resources resources, BitmapPool bitmapPool) {
        this.resources = resources;
        this.bitmapPool = bitmapPool;
    }
}
