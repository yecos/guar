package com.google.android.gms.cast;

import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class zzdf extends zzdl {
    final /* synthetic */ boolean zza;
    final /* synthetic */ JSONObject zzb;
    final /* synthetic */ RemoteMediaPlayer zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdf(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, boolean z10, JSONObject jSONObject) {
        super(remoteMediaPlayer, googleApiClient);
        this.zzc = remoteMediaPlayer;
        this.zza = z10;
        this.zzb = jSONObject;
    }

    @Override // com.google.android.gms.cast.zzdl
    public final void zza(com.google.android.gms.cast.internal.zzw zzwVar) {
        com.google.android.gms.cast.internal.zzap zzapVar;
        zzapVar = this.zzc.zzb;
        zzapVar.zzF(zzb(), this.zza, this.zzb);
    }
}
