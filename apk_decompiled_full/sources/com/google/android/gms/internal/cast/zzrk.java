package com.google.android.gms.internal.cast;

import sun.misc.Unsafe;

/* loaded from: classes.dex */
final class zzrk extends zzrm {
    public zzrk(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.cast.zzrm
    public final double zza(Object obj, long j10) {
        return Double.longBitsToDouble(zzk(obj, j10));
    }

    @Override // com.google.android.gms.internal.cast.zzrm
    public final float zzb(Object obj, long j10) {
        return Float.intBitsToFloat(zzj(obj, j10));
    }

    @Override // com.google.android.gms.internal.cast.zzrm
    public final void zzc(Object obj, long j10, boolean z10) {
        if (zzrn.zzb) {
            zzrn.zzD(obj, j10, r3 ? (byte) 1 : (byte) 0);
        } else {
            zzrn.zzE(obj, j10, r3 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.cast.zzrm
    public final void zzd(Object obj, long j10, byte b10) {
        if (zzrn.zzb) {
            zzrn.zzD(obj, j10, b10);
        } else {
            zzrn.zzE(obj, j10, b10);
        }
    }

    @Override // com.google.android.gms.internal.cast.zzrm
    public final void zze(Object obj, long j10, double d10) {
        zzo(obj, j10, Double.doubleToLongBits(d10));
    }

    @Override // com.google.android.gms.internal.cast.zzrm
    public final void zzf(Object obj, long j10, float f10) {
        zzn(obj, j10, Float.floatToIntBits(f10));
    }

    @Override // com.google.android.gms.internal.cast.zzrm
    public final boolean zzg(Object obj, long j10) {
        return zzrn.zzb ? zzrn.zzt(obj, j10) : zzrn.zzu(obj, j10);
    }
}
