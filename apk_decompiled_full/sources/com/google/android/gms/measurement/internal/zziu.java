package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* loaded from: classes.dex */
final class zziu implements Runnable {
    final /* synthetic */ zzie zza;
    final /* synthetic */ zzjm zzb;

    public zziu(zzjm zzjmVar, zzie zzieVar) {
        this.zzb = zzjmVar;
        this.zza = zzieVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdx zzdxVar;
        zzjm zzjmVar = this.zzb;
        zzdxVar = zzjmVar.zzb;
        if (zzdxVar == null) {
            zzjmVar.zzt.zzay().zzd().zza("Failed to send current screen to service");
            return;
        }
        try {
            zzie zzieVar = this.zza;
            if (zzieVar == null) {
                zzdxVar.zzq(0L, null, null, zzjmVar.zzt.zzau().getPackageName());
            } else {
                zzdxVar.zzq(zzieVar.zzc, zzieVar.zza, zzieVar.zzb, zzjmVar.zzt.zzau().getPackageName());
            }
            this.zzb.zzQ();
        } catch (RemoteException e10) {
            this.zzb.zzt.zzay().zzd().zzb("Failed to send current screen to the service", e10);
        }
    }
}
