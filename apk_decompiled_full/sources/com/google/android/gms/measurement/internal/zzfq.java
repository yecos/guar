package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zzfq implements Runnable {
    final /* synthetic */ zzgu zza;
    final /* synthetic */ zzfr zzb;

    public zzfq(zzfr zzfrVar, zzgu zzguVar) {
        this.zzb = zzfrVar;
        this.zza = zzguVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfr.zzA(this.zzb, this.zza);
        this.zzb.zzH(this.zza.zzg);
    }
}
