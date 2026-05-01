package com.google.android.gms.internal.cast;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

/* loaded from: classes.dex */
final class zzax implements com.google.android.gms.cast.framework.media.internal.zza {
    final /* synthetic */ zzay zza;

    public zzax(zzay zzayVar) {
        this.zza = zzayVar;
    }

    @Override // com.google.android.gms.cast.framework.media.internal.zza
    public final void zza(Bitmap bitmap) {
        View view;
        ImageView imageView;
        ImageView imageView2;
        View view2;
        if (bitmap != null) {
            view = this.zza.zzd;
            if (view != null) {
                view2 = this.zza.zzd;
                view2.setVisibility(4);
            }
            imageView = this.zza.zza;
            imageView.setVisibility(0);
            imageView2 = this.zza.zza;
            imageView2.setImageBitmap(bitmap);
        }
    }
}
