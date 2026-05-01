package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* loaded from: classes.dex */
final class zzje implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzq zzc;
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcf zzd;
    final /* synthetic */ zzjm zze;

    public zzje(zzjm zzjmVar, String str, String str2, zzq zzqVar, com.google.android.gms.internal.measurement.zzcf zzcfVar) {
        this.zze = zzjmVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzqVar;
        this.zzd = zzcfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfr zzfrVar;
        zzdx zzdxVar;
        ArrayList arrayList = new ArrayList();
        try {
            try {
                zzjm zzjmVar = this.zze;
                zzdxVar = zzjmVar.zzb;
                if (zzdxVar == null) {
                    zzjmVar.zzt.zzay().zzd().zzc("Failed to get conditional properties; not connected to service", this.zza, this.zzb);
                    zzfrVar = this.zze.zzt;
                } else {
                    Preconditions.checkNotNull(this.zzc);
                    arrayList = zzlb.zzH(zzdxVar.zzf(this.zza, this.zzb, this.zzc));
                    this.zze.zzQ();
                    zzfrVar = this.zze.zzt;
                }
            } catch (RemoteException e10) {
                this.zze.zzt.zzay().zzd().zzd("Failed to get conditional properties; remote exception", this.zza, this.zzb, e10);
                zzfrVar = this.zze.zzt;
            }
            zzfrVar.zzv().zzQ(this.zzd, arrayList);
        } catch (Throwable th) {
            this.zze.zzt.zzv().zzQ(this.zzd, arrayList);
            throw th;
        }
    }
}
