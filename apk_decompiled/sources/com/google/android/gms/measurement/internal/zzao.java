package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zzao implements Runnable {
    final /* synthetic */ zzgm zza;
    final /* synthetic */ zzap zzb;

    public zzao(zzap zzapVar, zzgm zzgmVar) {
        this.zzb = zzapVar;
        this.zza = zzgmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzaw();
        if (zzab.zza()) {
            this.zza.zzaz().zzp(this);
            return;
        }
        boolean zze = this.zzb.zze();
        this.zzb.zzd = 0L;
        if (zze) {
            this.zzb.zzc();
        }
    }
}
