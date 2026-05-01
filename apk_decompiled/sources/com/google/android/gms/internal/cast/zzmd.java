package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public final class zzmd extends zzoy<zzmd, zzmc> implements zzqf {
    private static final zzmd zzb;
    private int zze;
    private int zzf;
    private long zzg;
    private int zzh;

    static {
        zzmd zzmdVar = new zzmd();
        zzb = zzmdVar;
        zzoy.zzA(zzmd.class, zzmdVar);
    }

    private zzmd() {
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဂ\u0001\u0003ဌ\u0002", new Object[]{"zze", "zzf", zzhm.zza(), "zzg", "zzh", zzfh.zza()});
        }
        if (i11 == 3) {
            return new zzmd();
        }
        zzjy zzjyVar = null;
        if (i11 == 4) {
            return new zzmc(zzjyVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
