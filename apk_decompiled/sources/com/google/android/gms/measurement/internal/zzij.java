package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zzij implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzim zzb;

    public zzij(zzim zzimVar, long j10) {
        this.zzb = zzimVar;
        this.zza = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzt.zzd().zzf(this.zza);
        this.zzb.zza = null;
    }
}
