package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public final class zzkw extends zzoy<zzkw, zzkv> implements zzqf {
    private static final zzkw zzb;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzkw zzkwVar = new zzkw();
        zzb = zzkwVar;
        zzoy.zzA(zzkw.class, zzkwVar);
    }

    private zzkw() {
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001", new Object[]{"zze", "zzf", zzfz.zza(), "zzg", zzfw.zza()});
        }
        if (i11 == 3) {
            return new zzkw();
        }
        zzjy zzjyVar = null;
        if (i11 == 4) {
            return new zzkv(zzjyVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
