package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaSeekOptions;

/* loaded from: classes.dex */
final class zzbb extends zzbl {
    final /* synthetic */ MediaSeekOptions zza;
    final /* synthetic */ RemoteMediaClient zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbb(RemoteMediaClient remoteMediaClient, MediaSeekOptions mediaSeekOptions) {
        super(remoteMediaClient, false);
        this.zzb = remoteMediaClient;
        this.zza = mediaSeekOptions;
    }

    @Override // com.google.android.gms.cast.framework.media.zzbl
    public final void zza() {
        com.google.android.gms.cast.internal.zzap zzapVar;
        zzapVar = this.zzb.zzd;
        zzapVar.zzC(zzb(), this.zza);
    }
}
