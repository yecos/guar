package com.google.android.gms.cast;

import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes.dex */
final class zzdg extends zzdl {
    final /* synthetic */ RemoteMediaPlayer zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdg(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient) {
        super(remoteMediaPlayer, googleApiClient);
        this.zza = remoteMediaPlayer;
    }

    @Override // com.google.android.gms.cast.zzdl
    public final void zza(com.google.android.gms.cast.internal.zzw zzwVar) {
        com.google.android.gms.cast.internal.zzap zzapVar;
        zzapVar = this.zza.zzb;
        zzapVar.zzB(zzb());
    }
}
