package com.google.android.gms.cast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class zzcx extends zzdl {
    final /* synthetic */ int zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ JSONObject zzc;
    final /* synthetic */ RemoteMediaPlayer zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcx(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, int i10, long j10, JSONObject jSONObject) {
        super(remoteMediaPlayer, googleApiClient);
        this.zzd = remoteMediaPlayer;
        this.zza = i10;
        this.zzb = j10;
        this.zzc = jSONObject;
    }

    @Override // com.google.android.gms.cast.zzdl
    public final void zza(com.google.android.gms.cast.internal.zzw zzwVar) {
        com.google.android.gms.cast.internal.zzap zzapVar;
        if (RemoteMediaPlayer.zza(this.zzd, this.zza) == -1) {
            setResult((zzcx) new zzdk(this, new Status(0)));
        } else {
            zzapVar = this.zzd.zzb;
            zzapVar.zzA(zzb(), this.zza, this.zzb, null, 0, false, null, this.zzc);
        }
    }
}
