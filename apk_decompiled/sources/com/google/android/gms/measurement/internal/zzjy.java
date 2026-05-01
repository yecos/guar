package com.google.android.gms.measurement.internal;

import android.os.Handler;

/* loaded from: classes.dex */
final class zzjy {
    final /* synthetic */ zzkc zza;
    private zzjx zzb;

    public zzjy(zzkc zzkcVar) {
        this.zza = zzkcVar;
    }

    public final void zza(long j10) {
        Handler handler;
        this.zzb = new zzjx(this, this.zza.zzt.zzav().currentTimeMillis(), j10);
        handler = this.zza.zzd;
        handler.postDelayed(this.zzb, 2000L);
    }

    public final void zzb() {
        Handler handler;
        this.zza.zzg();
        zzjx zzjxVar = this.zzb;
        if (zzjxVar != null) {
            handler = this.zza.zzd;
            handler.removeCallbacks(zzjxVar);
        }
        this.zza.zzt.zzm().zzm.zza(false);
    }
}
