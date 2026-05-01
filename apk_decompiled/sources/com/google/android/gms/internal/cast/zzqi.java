package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
final class zzqi<T> implements zzqp<T> {
    private final zzqe zza;
    private final zzrd<?, ?> zzb;
    private final boolean zzc;
    private final zzoo<?> zzd;

    private zzqi(zzrd<?, ?> zzrdVar, zzoo<?> zzooVar, zzqe zzqeVar) {
        this.zzb = zzrdVar;
        this.zzc = zzooVar.zzc(zzqeVar);
        this.zzd = zzooVar;
        this.zza = zzqeVar;
    }

    public static <T> zzqi<T> zzg(zzrd<?, ?> zzrdVar, zzoo<?> zzooVar, zzqe zzqeVar) {
        return new zzqi<>(zzrdVar, zzooVar, zzqeVar);
    }

    @Override // com.google.android.gms.internal.cast.zzqp
    public final int zza(T t10) {
        zzrd<?, ?> zzrdVar = this.zzb;
        int zzb = zzrdVar.zzb(zzrdVar.zzc(t10));
        if (!this.zzc) {
            return zzb;
        }
        this.zzd.zza(t10);
        throw null;
    }

    @Override // com.google.android.gms.internal.cast.zzqp
    public final int zzb(T t10) {
        int hashCode = this.zzb.zzc(t10).hashCode();
        if (!this.zzc) {
            return hashCode;
        }
        this.zzd.zza(t10);
        throw null;
    }

    @Override // com.google.android.gms.internal.cast.zzqp
    public final void zzc(T t10) {
        this.zzb.zze(t10);
        this.zzd.zzb(t10);
    }

    @Override // com.google.android.gms.internal.cast.zzqp
    public final void zzd(T t10, T t11) {
        zzqr.zzD(this.zzb, t10, t11);
        if (this.zzc) {
            zzqr.zzC(this.zzd, t10, t11);
        }
    }

    @Override // com.google.android.gms.internal.cast.zzqp
    public final boolean zze(T t10, T t11) {
        if (!this.zzb.zzc(t10).equals(this.zzb.zzc(t11))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zza(t10);
        this.zzd.zza(t11);
        throw null;
    }

    @Override // com.google.android.gms.internal.cast.zzqp
    public final boolean zzf(T t10) {
        this.zzd.zza(t10);
        throw null;
    }

    @Override // com.google.android.gms.internal.cast.zzqp
    public final void zzi(T t10, zzom zzomVar) {
        this.zzd.zza(t10);
        throw null;
    }
}
