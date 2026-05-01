package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.TextTrackStyle;

/* loaded from: classes.dex */
final class zzaf extends zzbl {
    final /* synthetic */ TextTrackStyle zza;
    final /* synthetic */ RemoteMediaClient zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaf(RemoteMediaClient remoteMediaClient, TextTrackStyle textTrackStyle) {
        super(remoteMediaClient, false);
        this.zzb = remoteMediaClient;
        this.zza = textTrackStyle;
    }

    @Override // com.google.android.gms.cast.framework.media.zzbl
    public final void zza() {
        com.google.android.gms.cast.internal.zzap zzapVar;
        zzapVar = this.zzb.zzd;
        zzapVar.zzH(zzb(), this.zza);
    }
}
