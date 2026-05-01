package com.google.android.gms.cast;

import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class zzcv extends zzdl {
    final /* synthetic */ int zza;
    final /* synthetic */ JSONObject zzb;
    final /* synthetic */ RemoteMediaPlayer zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcv(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, int i10, JSONObject jSONObject) {
        super(remoteMediaPlayer, googleApiClient);
        this.zzc = remoteMediaPlayer;
        this.zza = i10;
        this.zzb = jSONObject;
    }

    @Override // com.google.android.gms.cast.zzdl
    public final void zza(com.google.android.gms.cast.internal.zzw zzwVar) {
        com.google.android.gms.cast.internal.zzap zzapVar;
        zzapVar = this.zzc.zzb;
        zzapVar.zzA(zzb(), 0, -1L, null, 0, false, Integer.valueOf(this.zza), this.zzb);
    }
}
