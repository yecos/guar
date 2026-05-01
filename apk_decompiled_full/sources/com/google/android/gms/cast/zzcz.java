package com.google.android.gms.cast;

import com.google.android.gms.cast.MediaLoadRequestData;
import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class zzcz extends zzdl {
    final /* synthetic */ MediaInfo zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ long[] zzd;
    final /* synthetic */ JSONObject zze;
    final /* synthetic */ RemoteMediaPlayer zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcz(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, MediaInfo mediaInfo, boolean z10, long j10, long[] jArr, JSONObject jSONObject) {
        super(remoteMediaPlayer, googleApiClient);
        this.zzf = remoteMediaPlayer;
        this.zza = mediaInfo;
        this.zzb = z10;
        this.zzc = j10;
        this.zzd = jArr;
        this.zze = jSONObject;
    }

    @Override // com.google.android.gms.cast.zzdl
    public final void zza(com.google.android.gms.cast.internal.zzw zzwVar) {
        Object obj;
        com.google.android.gms.cast.internal.zzap zzapVar;
        obj = this.zzf.zza;
        synchronized (obj) {
            zzapVar = this.zzf.zzb;
            com.google.android.gms.cast.internal.zzar zzb = zzb();
            MediaLoadRequestData.Builder builder = new MediaLoadRequestData.Builder();
            builder.setMediaInfo(this.zza);
            builder.setAutoplay(Boolean.valueOf(this.zzb));
            builder.setCurrentTime(this.zzc);
            builder.setActiveTrackIds(this.zzd);
            builder.setCustomData(this.zze);
            zzapVar.zzp(zzb, builder.build());
        }
    }
}
