package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* loaded from: classes.dex */
final class zzig implements Runnable {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ zzie zzb;
    final /* synthetic */ zzie zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzim zze;

    public zzig(zzim zzimVar, Bundle bundle, zzie zzieVar, zzie zzieVar2, long j10) {
        this.zze = zzimVar;
        this.zza = bundle;
        this.zzb = zzieVar;
        this.zzc = zzieVar2;
        this.zzd = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzim.zzp(this.zze, this.zza, this.zzb, this.zzc, this.zzd);
    }
}
