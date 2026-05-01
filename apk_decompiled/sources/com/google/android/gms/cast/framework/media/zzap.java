package com.google.android.gms.cast.framework.media;

import org.json.JSONObject;

/* loaded from: classes.dex */
final class zzap extends zzbl {
    final /* synthetic */ int zza;
    final /* synthetic */ JSONObject zzb;
    final /* synthetic */ RemoteMediaClient zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzap(RemoteMediaClient remoteMediaClient, int i10, JSONObject jSONObject) {
        super(remoteMediaClient, false);
        this.zzc = remoteMediaClient;
        this.zza = i10;
        this.zzb = jSONObject;
    }

    @Override // com.google.android.gms.cast.framework.media.zzbl
    public final void zza() {
        com.google.android.gms.cast.internal.zzap zzapVar;
        zzapVar = this.zzc.zzd;
        zzapVar.zzA(zzb(), 0, -1L, null, 0, false, Integer.valueOf(this.zza), this.zzb);
    }
}
