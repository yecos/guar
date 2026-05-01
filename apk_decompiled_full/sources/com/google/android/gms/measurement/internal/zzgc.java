package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zzgc implements Runnable {
    final /* synthetic */ zzaw zza;
    final /* synthetic */ zzq zzb;
    final /* synthetic */ zzgj zzc;

    public zzgc(zzgj zzgjVar, zzaw zzawVar, zzq zzqVar) {
        this.zzc = zzgjVar;
        this.zza = zzawVar;
        this.zzb = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zzv(this.zzc.zzb(this.zza, this.zzb), this.zzb);
    }
}
