package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.internal.Logger;

/* loaded from: classes.dex */
final class zzbw extends zzcl {
    final /* synthetic */ zzce zza;

    public zzbw(zzce zzceVar) {
        this.zza = zzceVar;
    }

    @Override // com.google.android.gms.internal.cast.zzcm
    public final void zzb(int i10) {
        Logger logger;
        logger = zzce.zza;
        logger.d("onRemoteDisplayEnded", new Object[0]);
        zzce.zzf(this.zza);
    }
}
