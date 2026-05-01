package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
final class zzmq extends zzmo {
    @Override // com.google.android.gms.internal.measurement.zzmo
    public final /* synthetic */ int zza(Object obj) {
        return ((zzmp) obj).zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzmo
    public final /* synthetic */ int zzb(Object obj) {
        return ((zzmp) obj).zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzmo
    public final /* bridge */ /* synthetic */ Object zzc(Object obj) {
        zzkf zzkfVar = (zzkf) obj;
        zzmp zzmpVar = zzkfVar.zzc;
        if (zzmpVar != zzmp.zzc()) {
            return zzmpVar;
        }
        zzmp zzf = zzmp.zzf();
        zzkfVar.zzc = zzf;
        return zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzmo
    public final /* synthetic */ Object zzd(Object obj) {
        return ((zzkf) obj).zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzmo
    public final /* bridge */ /* synthetic */ Object zze(Object obj, Object obj2) {
        if (zzmp.zzc().equals(obj2)) {
            return obj;
        }
        if (zzmp.zzc().equals(obj)) {
            return zzmp.zze((zzmp) obj, (zzmp) obj2);
        }
        ((zzmp) obj).zzd((zzmp) obj2);
        return obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzmo
    public final /* bridge */ /* synthetic */ void zzf(Object obj, int i10, long j10) {
        ((zzmp) obj).zzj(i10 << 3, Long.valueOf(j10));
    }

    @Override // com.google.android.gms.internal.measurement.zzmo
    public final void zzg(Object obj) {
        ((zzkf) obj).zzc.zzh();
    }

    @Override // com.google.android.gms.internal.measurement.zzmo
    public final /* synthetic */ void zzh(Object obj, Object obj2) {
        ((zzkf) obj).zzc = (zzmp) obj2;
    }

    @Override // com.google.android.gms.internal.measurement.zzmo
    public final /* synthetic */ void zzi(Object obj, zzng zzngVar) {
        ((zzmp) obj).zzk(zzngVar);
    }
}
