package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zziy extends zzap {
    final /* synthetic */ zzjm zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zziy(zzjm zzjmVar, zzgm zzgmVar) {
        super(zzgmVar);
        this.zza = zzjmVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzap
    public final void zzc() {
        this.zza.zzt.zzay().zzk().zza("Tasks have been queued for a long time");
    }
}
