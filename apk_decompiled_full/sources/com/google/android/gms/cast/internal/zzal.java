package com.google.android.gms.cast.internal;

import com.google.android.gms.cast.CastStatusCodes;

/* loaded from: classes.dex */
final class zzal implements zzar {
    final /* synthetic */ zzar zza;
    final /* synthetic */ zzap zzb;

    public zzal(zzap zzapVar, zzar zzarVar) {
        this.zzb = zzapVar;
        this.zza = zzarVar;
    }

    @Override // com.google.android.gms.cast.internal.zzar
    public final void zza(long j10, int i10, Object obj) {
        int i11;
        zzam zzamVar;
        if (this.zza != null) {
            if (i10 == 2001) {
                zzap zzapVar = this.zzb;
                Logger logger = zzapVar.zza;
                i11 = zzapVar.zzA;
                logger.w("Possibility of local queue out of sync with receiver queue. Refetching sequence number. Current Local Sequence Number = %d", Integer.valueOf(i11));
                zzamVar = this.zzb.zzz;
                zzamVar.zzl();
                i10 = CastStatusCodes.INVALID_REQUEST;
            }
            this.zza.zza(j10, i10, obj);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzar
    public final void zzb(long j10) {
        zzar zzarVar = this.zza;
        if (zzarVar != null) {
            zzarVar.zzb(j10);
        }
    }
}
