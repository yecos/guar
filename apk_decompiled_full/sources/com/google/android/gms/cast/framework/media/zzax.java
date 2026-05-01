package com.google.android.gms.cast.framework.media;

import java.util.List;

/* loaded from: classes.dex */
final class zzax extends zzbl {
    final /* synthetic */ String zza;
    final /* synthetic */ RemoteMediaClient zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzax(RemoteMediaClient remoteMediaClient, boolean z10, String str, List list) {
        super(remoteMediaClient, true);
        this.zzb = remoteMediaClient;
        this.zza = str;
    }

    @Override // com.google.android.gms.cast.framework.media.zzbl
    public final void zza() {
        com.google.android.gms.cast.internal.zzap zzapVar;
        zzapVar = this.zzb.zzd;
        zzapVar.zzs(this.zza, null);
    }
}
