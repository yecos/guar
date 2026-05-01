package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public final class zzml extends zzoy<zzml, zzmk> implements zzqf {
    private static final zzml zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;

    static {
        zzml zzmlVar = new zzml();
        zzb = zzmlVar;
        zzoy.zzA(zzml.class, zzmlVar);
    }

    private zzml() {
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
        }
        if (i11 == 3) {
            return new zzml();
        }
        zzjy zzjyVar = null;
        if (i11 == 4) {
            return new zzmk(zzjyVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
