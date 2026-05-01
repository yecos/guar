package com.hpplay.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import com.hpplay.glide.load.engine.bitmap_recycle.BitmapPool;

/* loaded from: classes2.dex */
public class FitCenter extends BitmapTransformation {
    public FitCenter(Context context) {
        super(context);
    }

    @Override // com.hpplay.glide.load.Transformation
    public String getId() {
        return "FitCenter.com.bumptech.glide.load.resource.bitmap";
    }

    @Override // com.hpplay.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i10, int i11) {
        return TransformationUtils.fitCenter(bitmap, bitmapPool, i10, i11);
    }

    public FitCenter(BitmapPool bitmapPool) {
        super(bitmapPool);
    }
}
