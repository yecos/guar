package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public final class zzla extends zzoy<zzla, zzkz> implements zzqf {
    private static final zzla zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private zzkg zzh;

    static {
        zzla zzlaVar = new zzla();
        zzb = zzlaVar;
        zzoy.zzA(zzla.class, zzlaVar);
    }

    private zzla() {
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zze", "zzf", zzgf.zza(), "zzg", "zzh"});
        }
        if (i11 == 3) {
            return new zzla();
        }
        zzjy zzjyVar = null;
        if (i11 == 4) {
            return new zzkz(zzjyVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
