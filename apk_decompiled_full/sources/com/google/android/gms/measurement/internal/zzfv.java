package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class zzfv implements Callable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzgj zzd;

    public zzfv(zzgj zzgjVar, String str, String str2, String str3) {
        this.zzd = zzgjVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        zzkt zzktVar;
        zzkt zzktVar2;
        zzktVar = this.zzd.zza;
        zzktVar.zzA();
        zzktVar2 = this.zzd.zza;
        return zzktVar2.zzi().zzv(this.zza, this.zzb, this.zzc);
    }
}
