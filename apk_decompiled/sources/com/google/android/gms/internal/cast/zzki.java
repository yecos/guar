package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public final class zzki extends zzoy<zzki, zzkh> implements zzqf {
    private static final zzki zzb;
    private int zze;
    private int zzf;
    private boolean zzg;
    private int zzh;
    private boolean zzi;
    private zzpg<zzmn> zzj = zzoy.zzw();
    private zzpg<zzmn> zzk = zzoy.zzw();
    private String zzl = "";

    static {
        zzki zzkiVar = new zzki();
        zzb = zzkiVar;
        zzoy.zzA(zzki.class, zzkiVar);
    }

    private zzki() {
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0007\u0000\u0001\u0001\t\u0007\u0000\u0002\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဌ\u0002\u0004ဇ\u0003\u0007\u001b\b\u001b\tဈ\u0004", new Object[]{"zze", "zzf", zzev.zza(), "zzg", "zzh", zzgl.zza(), "zzi", "zzj", zzmn.class, "zzk", zzmn.class, "zzl"});
        }
        if (i11 == 3) {
            return new zzki();
        }
        zzjy zzjyVar = null;
        if (i11 == 4) {
            return new zzkh(zzjyVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
