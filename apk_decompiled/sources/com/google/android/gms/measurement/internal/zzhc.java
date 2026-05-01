package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
final class zzhc implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Object zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzhx zze;

    public zzhc(zzhx zzhxVar, String str, String str2, Object obj, long j10) {
        this.zze = zzhxVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = obj;
        this.zzd = j10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zze.zzY(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
