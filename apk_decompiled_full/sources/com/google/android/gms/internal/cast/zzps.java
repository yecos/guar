package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
abstract class zzps {
    private static final zzps zza;
    private static final zzps zzb;

    static {
        zzpp zzppVar = null;
        zza = new zzpq(zzppVar);
        zzb = new zzpr(zzppVar);
    }

    public /* synthetic */ zzps(zzpp zzppVar) {
    }

    public static zzps zzc() {
        return zza;
    }

    public static zzps zzd() {
        return zzb;
    }

    public abstract void zza(Object obj, long j10);

    public abstract <L> void zzb(Object obj, Object obj2, long j10);
}
