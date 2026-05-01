package com.google.android.gms.cast;

import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes.dex */
final class zzdi implements com.google.android.gms.cast.internal.zzaq {
    final /* synthetic */ RemoteMediaPlayer zza;
    private GoogleApiClient zzb;
    private long zzc = 0;

    public zzdi(RemoteMediaPlayer remoteMediaPlayer) {
        this.zza = remoteMediaPlayer;
    }

    @Override // com.google.android.gms.cast.internal.zzaq
    public final long zza() {
        long j10 = this.zzc + 1;
        this.zzc = j10;
        return j10;
    }

    @Override // com.google.android.gms.cast.internal.zzaq
    public final void zzb(String str, String str2, long j10, String str3) {
        GoogleApiClient googleApiClient = this.zzb;
        if (googleApiClient == null) {
            throw new IllegalStateException("No GoogleApiClient available");
        }
        Cast.CastApi.sendMessage(googleApiClient, str, str2).setResultCallback(new zzdh(this, j10));
    }

    public final void zzc(GoogleApiClient googleApiClient) {
        this.zzb = googleApiClient;
    }
}
