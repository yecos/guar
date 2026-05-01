package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zzkj implements Runnable {
    final /* synthetic */ zzku zza;
    final /* synthetic */ zzkt zzb;

    public zzkj(zzkt zzktVar, zzku zzkuVar) {
        this.zzb = zzktVar;
        this.zza = zzkuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkt.zzy(this.zzb, this.zza);
        this.zzb.zzS();
    }
}
