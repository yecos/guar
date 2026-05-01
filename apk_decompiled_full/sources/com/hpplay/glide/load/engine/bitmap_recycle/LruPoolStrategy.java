package com.hpplay.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

/* loaded from: classes2.dex */
interface LruPoolStrategy {
    Bitmap get(int i10, int i11, Bitmap.Config config);

    int getSize(Bitmap bitmap);

    String logBitmap(int i10, int i11, Bitmap.Config config);

    String logBitmap(Bitmap bitmap);

    void put(Bitmap bitmap);

    Bitmap removeLast();
}
