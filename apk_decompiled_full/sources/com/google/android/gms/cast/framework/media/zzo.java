package com.google.android.gms.cast.framework.media;

import android.graphics.Bitmap;
import android.net.Uri;
import com.google.android.gms.common.images.WebImage;

/* loaded from: classes.dex */
final class zzo {
    public final Uri zza;
    public Bitmap zzb;

    public zzo(WebImage webImage) {
        this.zza = webImage == null ? null : webImage.getUrl();
    }
}
