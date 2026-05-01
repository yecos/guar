package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zzih implements Runnable {
    final /* synthetic */ zzie zza;
    final /* synthetic */ zzie zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzim zze;

    public zzih(zzim zzimVar, zzie zzieVar, zzie zzieVar2, long j10, boolean z10) {
        this.zze = zzimVar;
        this.zza = zzieVar;
        this.zzb = zzieVar2;
        this.zzc = j10;
        this.zzd = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zze.zzA(this.zza, this.zzb, this.zzc, this.zzd, null);
    }
}
