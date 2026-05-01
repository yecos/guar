package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
final class zzpr extends zzps {
    public /* synthetic */ zzpr(zzpp zzppVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.cast.zzps
    public final void zza(Object obj, long j10) {
        ((zzpg) zzrn.zzf(obj, j10)).zzb();
    }

    @Override // com.google.android.gms.internal.cast.zzps
    public final <E> void zzb(Object obj, Object obj2, long j10) {
        zzpg zzpgVar = (zzpg) zzrn.zzf(obj, j10);
        zzpg zzpgVar2 = (zzpg) zzrn.zzf(obj2, j10);
        int size = zzpgVar.size();
        int size2 = zzpgVar2.size();
        if (size > 0 && size2 > 0) {
            if (!zzpgVar.zzc()) {
                zzpgVar = zzpgVar.zzg(size2 + size);
            }
            zzpgVar.addAll(zzpgVar2);
        }
        if (size > 0) {
            zzpgVar2 = zzpgVar;
        }
        zzrn.zzs(obj, j10, zzpgVar2);
    }

    private zzpr() {
        super(null);
    }
}
