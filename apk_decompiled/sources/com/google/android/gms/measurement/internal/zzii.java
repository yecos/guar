package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zzii implements Runnable {
    final /* synthetic */ zzim zza;

    public zzii(zzim zzimVar) {
        this.zza = zzimVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzie zzieVar;
        zzim zzimVar = this.zza;
        zzieVar = zzimVar.zzh;
        zzimVar.zza = zzieVar;
    }
}
