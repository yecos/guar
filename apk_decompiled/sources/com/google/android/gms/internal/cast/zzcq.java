package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
final class zzcq extends zzcv {
    final /* synthetic */ zzcr zza;

    public zzcq(zzcr zzcrVar) {
        this.zza = zzcrVar;
    }

    @Override // com.google.android.gms.internal.cast.zzcv
    public final void zza(long j10) {
        int i10;
        zzcr zzcrVar = this.zza;
        i10 = zzcrVar.zzc;
        zzcrVar.zzc = i10 + 1;
        zzcr zzcrVar2 = this.zza;
        if (zzcrVar2.zza(zzcrVar2.zza) || this.zza.zza.isStarted() || zzcr.zze(this.zza)) {
            return;
        }
        this.zza.zza.start();
    }
}
