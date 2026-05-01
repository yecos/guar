package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public final class zzlt extends zzoy<zzlt, zzls> implements zzqf {
    private static final zzlt zzb;
    private int zze;
    private zzpg<zzll> zzf = zzoy.zzw();
    private boolean zzg;
    private boolean zzh;

    static {
        zzlt zzltVar = new zzlt();
        zzb = zzltVar;
        zzoy.zzA(zzlt.class, zzltVar);
    }

    private zzlt() {
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001b\u0002ဇ\u0000\u0003ဇ\u0001", new Object[]{"zze", "zzf", zzll.class, "zzg", "zzh"});
        }
        if (i11 == 3) {
            return new zzlt();
        }
        zzjy zzjyVar = null;
        if (i11 == 4) {
            return new zzls(zzjyVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
