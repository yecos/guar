package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public final class zzmp extends zzoy<zzmp, zzmo> implements zzqf {
    private static final zzmp zzb;
    private int zze;
    private boolean zzf;
    private boolean zzg;
    private int zzh;
    private int zzj;
    private int zzk;
    private String zzi = "";
    private String zzl = "";

    static {
        zzmp zzmpVar = new zzmp();
        zzb = zzmpVar;
        zzoy.zzA(zzmp.class, zzmpVar);
    }

    private zzmp() {
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003င\u0002\u0004ဈ\u0003\u0005င\u0004\u0006င\u0005\u0007ဈ\u0006", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
        }
        if (i11 == 3) {
            return new zzmp();
        }
        zzjy zzjyVar = null;
        if (i11 == 4) {
            return new zzmo(zzjyVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
