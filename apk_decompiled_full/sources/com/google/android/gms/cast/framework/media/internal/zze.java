package com.google.android.gms.cast.framework.media.internal;

/* loaded from: classes.dex */
final class zze extends zzj {
    final /* synthetic */ zzf zza;

    public /* synthetic */ zze(zzf zzfVar, zzd zzdVar) {
        this.zza = zzfVar;
    }

    @Override // com.google.android.gms.cast.framework.media.internal.zzk
    public final void zzb(long j10, long j11) {
        this.zza.publishProgress(Long.valueOf(j10), Long.valueOf(j11));
    }
}
