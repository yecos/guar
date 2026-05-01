package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import anet.channel.entity.ConnType;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zznw;
import com.google.android.gms.internal.measurement.zzpd;

/* loaded from: classes.dex */
final class zzkb {
    final /* synthetic */ zzkc zza;

    public zzkb(zzkc zzkcVar) {
        this.zza = zzkcVar;
    }

    public final void zza() {
        this.zza.zzg();
        if (this.zza.zzt.zzm().zzk(this.zza.zzt.zzav().currentTimeMillis())) {
            this.zza.zzt.zzm().zzg.zza(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.zza.zzt.zzay().zzj().zza("Detected application was in foreground");
                zzc(this.zza.zzt.zzav().currentTimeMillis(), false);
            }
        }
    }

    public final void zzb(long j10, boolean z10) {
        this.zza.zzg();
        this.zza.zzm();
        if (this.zza.zzt.zzm().zzk(j10)) {
            this.zza.zzt.zzm().zzg.zza(true);
            zzpd.zzc();
            if (this.zza.zzt.zzf().zzs(null, zzdu.zzam)) {
                this.zza.zzt.zzh().zzo();
            }
        }
        this.zza.zzt.zzm().zzj.zzb(j10);
        if (this.zza.zzt.zzm().zzg.zzb()) {
            zzc(j10, z10);
        }
    }

    @VisibleForTesting
    public final void zzc(long j10, boolean z10) {
        this.zza.zzg();
        if (this.zza.zzt.zzJ()) {
            this.zza.zzt.zzm().zzj.zzb(j10);
            this.zza.zzt.zzay().zzj().zzb("Session started, time", Long.valueOf(this.zza.zzt.zzav().elapsedRealtime()));
            Long valueOf = Long.valueOf(j10 / 1000);
            this.zza.zzt.zzq().zzY(ConnType.PK_AUTO, "_sid", valueOf, j10);
            this.zza.zzt.zzm().zzk.zzb(valueOf.longValue());
            this.zza.zzt.zzm().zzg.zza(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", valueOf.longValue());
            if (this.zza.zzt.zzf().zzs(null, zzdu.zzZ) && z10) {
                bundle.putLong("_aib", 1L);
            }
            this.zza.zzt.zzq().zzH(ConnType.PK_AUTO, "_s", j10, bundle);
            zznw.zzc();
            if (this.zza.zzt.zzf().zzs(null, zzdu.zzac)) {
                String zza = this.zza.zzt.zzm().zzp.zza();
                if (TextUtils.isEmpty(zza)) {
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("_ffr", zza);
                this.zza.zzt.zzq().zzH(ConnType.PK_AUTO, "_ssr", j10, bundle2);
            }
        }
    }
}
