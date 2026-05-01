package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zzke extends zzap {
    final /* synthetic */ zzkf zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzke(zzkf zzkfVar, zzgm zzgmVar) {
        super(zzgmVar);
        this.zza = zzkfVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzap
    public final void zzc() {
        this.zza.zza();
        this.zza.zzt.zzay().zzj().zza("Starting upload from DelayedRunnable");
        this.zza.zzf.zzX();
    }
}
