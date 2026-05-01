package com.hpplay.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.hpplay.glide.load.DecodeFormat;
import com.hpplay.glide.load.engine.bitmap_recycle.BitmapPool;

/* loaded from: classes2.dex */
public interface BitmapDecoder<T> {
    Bitmap decode(T t10, BitmapPool bitmapPool, int i10, int i11, DecodeFormat decodeFormat);

    String getId();
}
