package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zzeo implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzep zzb;

    public zzeo(zzep zzepVar, boolean z10) {
        this.zzb = zzepVar;
        this.zza = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkt zzktVar;
        zzktVar = this.zzb.zzb;
        zzktVar.zzJ(this.zza);
    }
}
