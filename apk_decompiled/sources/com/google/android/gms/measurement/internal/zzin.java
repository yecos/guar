package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

/* loaded from: classes.dex */
final class zzin implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzq zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcf zze;
    final /* synthetic */ zzjm zzf;

    public zzin(zzjm zzjmVar, String str, String str2, zzq zzqVar, boolean z10, com.google.android.gms.internal.measurement.zzcf zzcfVar) {
        this.zzf = zzjmVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzqVar;
        this.zzd = z10;
        this.zze = zzcfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle;
        RemoteException e10;
        zzdx zzdxVar;
        Bundle bundle2 = new Bundle();
        try {
            zzjm zzjmVar = this.zzf;
            zzdxVar = zzjmVar.zzb;
            if (zzdxVar == null) {
                zzjmVar.zzt.zzay().zzd().zzc("Failed to get user properties; not connected to service", this.zza, this.zzb);
                this.zzf.zzt.zzv().zzR(this.zze, bundle2);
                return;
            }
            Preconditions.checkNotNull(this.zzc);
            List<zzkw> zzh = zzdxVar.zzh(this.zza, this.zzb, this.zzd, this.zzc);
            bundle = new Bundle();
            if (zzh != null) {
                for (zzkw zzkwVar : zzh) {
                    String str = zzkwVar.zze;
                    if (str != null) {
                        bundle.putString(zzkwVar.zzb, str);
                    } else {
                        Long l10 = zzkwVar.zzd;
                        if (l10 != null) {
                            bundle.putLong(zzkwVar.zzb, l10.longValue());
                        } else {
                            Double d10 = zzkwVar.zzg;
                            if (d10 != null) {
                                bundle.putDouble(zzkwVar.zzb, d10.doubleValue());
                            }
                        }
                    }
                }
            }
            try {
                try {
                    this.zzf.zzQ();
                    this.zzf.zzt.zzv().zzR(this.zze, bundle);
                } catch (RemoteException e11) {
                    e10 = e11;
                    this.zzf.zzt.zzay().zzd().zzc("Failed to get user properties; remote exception", this.zza, e10);
                    this.zzf.zzt.zzv().zzR(this.zze, bundle);
                }
            } catch (Throwable th) {
                th = th;
                bundle2 = bundle;
                this.zzf.zzt.zzv().zzR(this.zze, bundle2);
                throw th;
            }
        } catch (RemoteException e12) {
            bundle = bundle2;
            e10 = e12;
        } catch (Throwable th2) {
            th = th2;
            this.zzf.zzt.zzv().zzR(this.zze, bundle2);
            throw th;
        }
    }
}
