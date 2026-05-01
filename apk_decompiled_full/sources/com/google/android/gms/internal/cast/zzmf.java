package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public final class zzmf extends zzoy<zzmf, zzme> implements zzqf {
    private static final zzmf zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private boolean zzi;
    private int zzj;
    private int zzk;

    static {
        zzmf zzmfVar = new zzmf();
        zzb = zzmfVar;
        zzoy.zzA(zzmf.class, zzmfVar);
    }

    private zzmf() {
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဌ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဌ\u0004\u0006ဆ\u0005", new Object[]{"zze", "zzf", "zzg", zzhp.zza(), "zzh", "zzi", "zzj", zzgc.zza(), "zzk"});
        }
        if (i11 == 3) {
            return new zzmf();
        }
        zzjy zzjyVar = null;
        if (i11 == 4) {
            return new zzme(zzjyVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
