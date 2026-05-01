package com.google.android.gms.cast.framework.media;

/* loaded from: classes.dex */
final class zzat extends zzbl {
    final /* synthetic */ RemoteMediaClient zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzat(RemoteMediaClient remoteMediaClient, boolean z10) {
        super(remoteMediaClient, true);
        this.zza = remoteMediaClient;
    }

    @Override // com.google.android.gms.cast.framework.media.zzbl
    public final void zza() {
        com.google.android.gms.cast.internal.zzap zzapVar;
        zzapVar = this.zza.zzd;
        zzapVar.zzu(zzb());
    }
}
