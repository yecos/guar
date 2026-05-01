package com.google.android.gms.cast.framework.media.widget;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;

/* loaded from: classes.dex */
final class zzh implements com.google.android.gms.cast.framework.media.internal.zza {
    final /* synthetic */ ExpandedControllerActivity zza;

    public zzh(ExpandedControllerActivity expandedControllerActivity) {
        this.zza = expandedControllerActivity;
    }

    @Override // com.google.android.gms.cast.framework.media.internal.zza
    public final void zza(Bitmap bitmap) {
        TextView textView;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        TextView textView2;
        if (bitmap != null) {
            textView = this.zza.zzE;
            if (textView != null) {
                textView2 = this.zza.zzE;
                textView2.setVisibility(8);
            }
            imageView = this.zza.zzD;
            if (imageView != null) {
                imageView2 = this.zza.zzD;
                imageView2.setVisibility(0);
                imageView3 = this.zza.zzD;
                imageView3.setImageBitmap(bitmap);
            }
        }
    }
}
