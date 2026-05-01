package com.google.android.gms.cast.internal;

import com.google.android.gms.cast.Cast;

/* loaded from: classes.dex */
final class zzr implements Runnable {
    final /* synthetic */ zzw zza;
    final /* synthetic */ int zzb;

    public zzr(zzv zzvVar, zzw zzwVar, int i10) {
        this.zza = zzwVar;
        this.zzb = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Cast.Listener listener;
        listener = this.zza.zzj;
        listener.onApplicationDisconnected(this.zzb);
    }
}
