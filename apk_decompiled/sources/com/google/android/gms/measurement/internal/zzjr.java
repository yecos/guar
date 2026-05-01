package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zzjr implements Runnable {
    final /* synthetic */ zzkt zza;
    final /* synthetic */ Runnable zzb;

    public zzjr(zzjt zzjtVar, zzkt zzktVar, Runnable runnable) {
        this.zza = zzktVar;
        this.zzb = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzA();
        this.zza.zzz(this.zzb);
        this.zza.zzX();
    }
}
