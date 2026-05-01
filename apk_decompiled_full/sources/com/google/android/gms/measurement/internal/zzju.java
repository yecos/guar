package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zzju implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzkc zzb;

    public zzju(zzkc zzkcVar, long j10) {
        this.zzb = zzkcVar;
        this.zza = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkc.zzl(this.zzb, this.zza);
    }
}
