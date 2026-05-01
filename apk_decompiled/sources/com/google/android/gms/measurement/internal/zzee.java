package com.google.android.gms.measurement.internal;

import android.util.Log;
import com.hpplay.cybergarage.soap.SOAP;

/* loaded from: classes.dex */
final class zzee implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Object zzc;
    final /* synthetic */ Object zzd;
    final /* synthetic */ Object zze;
    final /* synthetic */ zzeh zzf;

    public zzee(zzeh zzehVar, int i10, String str, Object obj, Object obj2, Object obj3) {
        this.zzf = zzehVar;
        this.zza = i10;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        char c10;
        long j10;
        char c11;
        long j11;
        zzew zzm = this.zzf.zzt.zzm();
        if (!zzm.zzx()) {
            Log.println(6, this.zzf.zzq(), "Persisted config not initialized. Not logging error/warn");
            return;
        }
        zzeh zzehVar = this.zzf;
        c10 = zzehVar.zza;
        if (c10 == 0) {
            if (zzehVar.zzt.zzf().zzy()) {
                zzeh zzehVar2 = this.zzf;
                zzehVar2.zzt.zzaw();
                zzehVar2.zza = 'C';
            } else {
                zzeh zzehVar3 = this.zzf;
                zzehVar3.zzt.zzaw();
                zzehVar3.zza = 'c';
            }
        }
        zzeh zzehVar4 = this.zzf;
        j10 = zzehVar4.zzb;
        if (j10 < 0) {
            zzehVar4.zzt.zzf().zzh();
            zzehVar4.zzb = 74029L;
        }
        char charAt = "01VDIWEA?".charAt(this.zza);
        zzeh zzehVar5 = this.zzf;
        c11 = zzehVar5.zza;
        j11 = zzehVar5.zzb;
        String str = "2" + charAt + c11 + j11 + SOAP.DELIM + zzeh.zzo(true, this.zzb, this.zzc, this.zzd, this.zze);
        if (str.length() > 1024) {
            str = this.zzb.substring(0, 1024);
        }
        zzeu zzeuVar = zzm.zzb;
        if (zzeuVar != null) {
            zzeuVar.zzb(str, 1L);
        }
    }
}
