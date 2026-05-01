package com.google.android.gms.cast.internal;

/* loaded from: classes.dex */
final class zzaj implements zzar {
    final /* synthetic */ zzar zza;
    final /* synthetic */ zzap zzb;

    public zzaj(zzap zzapVar, zzar zzarVar) {
        this.zzb = zzapVar;
        this.zza = zzarVar;
    }

    @Override // com.google.android.gms.cast.internal.zzar
    public final void zza(long j10, int i10, Object obj) {
        this.zzb.zzy = null;
        zzar zzarVar = this.zza;
        if (zzarVar != null) {
            zzarVar.zza(j10, i10, obj);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzar
    public final void zzb(long j10) {
        zzar zzarVar = this.zza;
        if (zzarVar != null) {
            zzarVar.zzb(j10);
        }
    }
}
