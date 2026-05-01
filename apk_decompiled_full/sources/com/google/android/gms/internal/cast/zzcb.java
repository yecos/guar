package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public final class zzcb extends zzbz {
    final /* synthetic */ zzcc zza;

    public zzcb(zzcc zzccVar) {
        this.zza = zzccVar;
    }

    @Override // com.google.android.gms.internal.cast.zzbz, com.google.android.gms.internal.cast.zzcj
    public final void zzd(int i10) {
        Logger logger;
        logger = zzce.zza;
        logger.d("onError: %d", Integer.valueOf(i10));
        zzce.zzf(this.zza.zzc);
        this.zza.setResult((zzcc) new zzcd(Status.RESULT_INTERNAL_ERROR));
    }

    @Override // com.google.android.gms.internal.cast.zzbz, com.google.android.gms.internal.cast.zzcj
    public final void zzf() {
        Logger logger;
        logger = zzce.zza;
        logger.d("onDisconnected", new Object[0]);
        zzce.zzf(this.zza.zzc);
        this.zza.setResult((zzcc) new zzcd(Status.RESULT_SUCCESS));
    }
}
