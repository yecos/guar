package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public final class zzmj extends zzoy<zzmj, zzmi> implements zzqf {
    private static final zzmj zzb;
    private int zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private int zzj;
    private int zzk;
    private boolean zzl;

    static {
        zzmj zzmjVar = new zzmj();
        zzb = zzmjVar;
        zzoy.zzA(zzmj.class, zzmjVar);
    }

    private zzmj() {
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဌ\u0004\u0006ဌ\u0005\u0007ဇ\u0006", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzhs.zza(), "zzk", zzhs.zza(), "zzl"});
        }
        if (i11 == 3) {
            return new zzmj();
        }
        zzjy zzjyVar = null;
        if (i11 == 4) {
            return new zzmi(zzjyVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
