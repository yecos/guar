package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public final class zzmt extends zzoy<zzmt, zzms> implements zzqf {
    private static final zzmt zzb;
    private int zze;
    private zzpg<zznf> zzf = zzoy.zzw();
    private zzpg<zzla> zzg = zzoy.zzw();
    private zznb zzh;

    static {
        zzmt zzmtVar = new zzmt();
        zzb = zzmtVar;
        zzoy.zzA(zzmt.class, zzmtVar);
    }

    private zzmt() {
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001\u001b\u0002\u001b\u0003ဉ\u0000", new Object[]{"zze", "zzf", zznf.class, "zzg", zzla.class, "zzh"});
        }
        if (i11 == 3) {
            return new zzmt();
        }
        zzjy zzjyVar = null;
        if (i11 == 4) {
            return new zzms(zzjyVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
