package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
final class zzcs extends zzdu {
    final /* synthetic */ Boolean zza;
    final /* synthetic */ zzef zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcs(zzef zzefVar, Boolean bool) {
        super(zzefVar, true);
        this.zzb = zzefVar;
        this.zza = bool;
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final void zza() {
        zzcc zzccVar;
        zzcc zzccVar2;
        if (this.zza != null) {
            zzccVar2 = this.zzb.zzj;
            ((zzcc) Preconditions.checkNotNull(zzccVar2)).setMeasurementEnabled(this.zza.booleanValue(), this.zzh);
        } else {
            zzccVar = this.zzb.zzj;
            ((zzcc) Preconditions.checkNotNull(zzccVar)).clearMeasurementEnabled(this.zzh);
        }
    }
}
