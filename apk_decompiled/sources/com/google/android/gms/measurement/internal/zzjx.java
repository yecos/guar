package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import anet.channel.entity.ConnType;

/* loaded from: classes.dex */
final class zzjx implements Runnable {
    final long zza;
    final long zzb;
    final /* synthetic */ zzjy zzc;

    public zzjx(zzjy zzjyVar, long j10, long j11) {
        this.zzc = zzjyVar;
        this.zza = j10;
        this.zzb = j11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzt.zzaz().zzp(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjw
            @Override // java.lang.Runnable
            public final void run() {
                zzjx zzjxVar = zzjx.this;
                zzjy zzjyVar = zzjxVar.zzc;
                long j10 = zzjxVar.zza;
                long j11 = zzjxVar.zzb;
                zzjyVar.zza.zzg();
                zzjyVar.zza.zzt.zzay().zzc().zza("Application going to the background");
                zzjyVar.zza.zzt.zzm().zzm.zza(true);
                Bundle bundle = new Bundle();
                if (!zzjyVar.zza.zzt.zzf().zzu()) {
                    zzjyVar.zza.zzb.zzb(j11);
                    zzjyVar.zza.zzb.zzd(false, false, j11);
                }
                zzjyVar.zza.zzt.zzq().zzH(ConnType.PK_AUTO, "_ab", j10, bundle);
            }
        });
    }
}
