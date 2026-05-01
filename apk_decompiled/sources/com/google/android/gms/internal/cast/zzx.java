package com.google.android.gms.internal.cast;

import android.app.Activity;

/* loaded from: classes.dex */
final class zzx implements com.google.android.gms.cast.framework.internal.featurehighlight.zzg {
    final /* synthetic */ zzy zza;

    public zzx(zzy zzyVar) {
        this.zza = zzyVar;
    }

    @Override // com.google.android.gms.cast.framework.internal.featurehighlight.zzg
    public final void zza() {
        boolean z10;
        Activity activity;
        com.google.android.gms.cast.framework.internal.featurehighlight.zzh zzhVar;
        z10 = this.zza.zzg;
        if (z10) {
            activity = this.zza.zzb;
            com.google.android.gms.cast.framework.zzas.zza(activity);
            zzhVar = this.zza.zze;
            zzhVar.zzj(new zzw(this));
        }
    }

    @Override // com.google.android.gms.cast.framework.internal.featurehighlight.zzg
    public final void zzb() {
        boolean z10;
        Activity activity;
        com.google.android.gms.cast.framework.internal.featurehighlight.zzh zzhVar;
        z10 = this.zza.zzg;
        if (z10) {
            activity = this.zza.zzb;
            com.google.android.gms.cast.framework.zzas.zza(activity);
            zzhVar = this.zza.zze;
            zzhVar.zzi(new zzv(this));
        }
    }
}
