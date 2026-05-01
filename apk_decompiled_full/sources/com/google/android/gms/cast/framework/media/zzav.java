package com.google.android.gms.cast.framework.media;

/* loaded from: classes.dex */
final class zzav extends zzbl {
    final /* synthetic */ int zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ int zzc;
    final /* synthetic */ RemoteMediaClient zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzav(RemoteMediaClient remoteMediaClient, boolean z10, int i10, int i11, int i12) {
        super(remoteMediaClient, true);
        this.zzd = remoteMediaClient;
        this.zza = i10;
        this.zzb = i11;
        this.zzc = i12;
    }

    @Override // com.google.android.gms.cast.framework.media.zzbl
    public final void zza() {
        com.google.android.gms.cast.internal.zzap zzapVar;
        zzapVar = this.zzd.zzd;
        zzapVar.zzt(zzb(), this.zza, this.zzb, this.zzc);
    }
}
