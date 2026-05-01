package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
final class zzky extends zzla {
    public /* synthetic */ zzky(zzkx zzkxVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzla
    public final void zza(Object obj, long j10) {
        ((zzkm) zzmy.zzf(obj, j10)).zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzla
    public final void zzb(Object obj, Object obj2, long j10) {
        zzkm zzkmVar = (zzkm) zzmy.zzf(obj, j10);
        zzkm zzkmVar2 = (zzkm) zzmy.zzf(obj2, j10);
        int size = zzkmVar.size();
        int size2 = zzkmVar2.size();
        if (size > 0 && size2 > 0) {
            if (!zzkmVar.zzc()) {
                zzkmVar = zzkmVar.zzd(size2 + size);
            }
            zzkmVar.addAll(zzkmVar2);
        }
        if (size > 0) {
            zzkmVar2 = zzkmVar;
        }
        zzmy.zzs(obj, j10, zzkmVar2);
    }

    private zzky() {
        super(null);
    }
}
