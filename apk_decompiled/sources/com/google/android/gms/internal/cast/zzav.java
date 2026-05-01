package com.google.android.gms.internal.cast;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* loaded from: classes.dex */
final class zzav implements com.google.android.gms.cast.framework.media.internal.zza {
    final /* synthetic */ zzaw zza;

    public zzav(zzaw zzawVar) {
        this.zza = zzawVar;
    }

    @Override // com.google.android.gms.cast.framework.media.internal.zza
    public final void zza(Bitmap bitmap) {
        ImageView imageView;
        if (bitmap != null) {
            imageView = this.zza.zza;
            imageView.setImageBitmap(bitmap);
        }
    }
}
