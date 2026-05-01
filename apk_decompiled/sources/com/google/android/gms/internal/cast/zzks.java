package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public final class zzks extends zzoy<zzks, zzkr> implements zzqf {
    private static final zzks zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private boolean zzi;
    private int zzj;

    static {
        zzks zzksVar = new zzks();
        zzb = zzksVar;
        zzoy.zzA(zzks.class, zzksVar);
    }

    private zzks() {
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဇ\u0003\u0005င\u0004", new Object[]{"zze", "zzf", zzih.zza(), "zzg", zzib.zza(), "zzh", zzie.zza(), "zzi", "zzj"});
        }
        if (i11 == 3) {
            return new zzks();
        }
        zzjy zzjyVar = null;
        if (i11 == 4) {
            return new zzkr(zzjyVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
