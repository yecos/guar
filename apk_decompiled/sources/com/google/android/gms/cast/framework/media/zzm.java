package com.google.android.gms.cast.framework.media;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
final class zzm implements com.google.android.gms.cast.framework.media.internal.zza {
    final /* synthetic */ zzo zza;
    final /* synthetic */ MediaNotificationService zzb;

    public zzm(MediaNotificationService mediaNotificationService, zzo zzoVar) {
        this.zzb = mediaNotificationService;
        this.zza = zzoVar;
    }

    @Override // com.google.android.gms.cast.framework.media.internal.zza
    public final void zza(Bitmap bitmap) {
        zzo zzoVar = this.zza;
        zzoVar.zzb = bitmap;
        this.zzb.zzn = zzoVar;
        this.zzb.zzj();
    }
}
