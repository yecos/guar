package com.google.android.gms.cast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class zzcw extends zzdl {
    final /* synthetic */ int zza;
    final /* synthetic */ JSONObject zzb;
    final /* synthetic */ RemoteMediaPlayer zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcw(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, int i10, JSONObject jSONObject) {
        super(remoteMediaPlayer, googleApiClient);
        this.zzc = remoteMediaPlayer;
        this.zza = i10;
        this.zzb = jSONObject;
    }

    @Override // com.google.android.gms.cast.zzdl
    public final void zza(com.google.android.gms.cast.internal.zzw zzwVar) {
        com.google.android.gms.cast.internal.zzap zzapVar;
        if (RemoteMediaPlayer.zza(this.zzc, this.zza) == -1) {
            setResult((zzcw) new zzdk(this, new Status(0)));
        } else {
            zzapVar = this.zzc.zzb;
            zzapVar.zzy(zzb(), new int[]{this.zza}, this.zzb);
        }
    }
}
