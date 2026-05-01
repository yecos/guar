package com.titan.thumbnail;

import android.graphics.Bitmap;

/* loaded from: classes3.dex */
public interface ThumbnailCallback {
    void onBitmapPrepared(boolean z10, Bitmap bitmap);

    void onGetThumbnail(boolean z10);
}
