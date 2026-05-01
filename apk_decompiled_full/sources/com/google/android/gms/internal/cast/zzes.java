package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public final class zzes extends zzoy<zzes, zzep> implements zzqf {
    private static final zzes zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private zzeo zzj;
    private int zzk;

    static {
        zzes zzesVar = new zzes();
        zzb = zzesVar;
        zzoy.zzA(zzes.class, zzesVar);
    }

    private zzes() {
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဌ\u0001\u0003င\u0002\u0004င\u0003\u0005ဉ\u0004\u0006ဌ\u0005", new Object[]{"zze", "zzf", "zzg", zzer.zza, "zzh", "zzi", "zzj", "zzk", zzeq.zza});
        }
        if (i11 == 3) {
            return new zzes();
        }
        zzeg zzegVar = null;
        if (i11 == 4) {
            return new zzep(zzegVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
