package com.google.android.gms.cast.internal;

/* loaded from: classes.dex */
final class zzs implements Runnable {
    final /* synthetic */ zzw zza;
    final /* synthetic */ zzy zzb;

    public zzs(zzv zzvVar, zzw zzwVar, zzy zzyVar) {
        this.zza = zzwVar;
        this.zzb = zzyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzw.zzI(this.zza, this.zzb);
    }
}
