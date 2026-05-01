package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public final class zznb extends zzoy<zznb, zzna> implements zzqf {
    private static final zznb zzb;
    private int zze;
    private zzkg zzf;

    static {
        zznb zznbVar = new zznb();
        zzb = zznbVar;
        zzoy.zzA(zznb.class, zznbVar);
    }

    private zznb() {
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zze", "zzf"});
        }
        if (i11 == 3) {
            return new zznb();
        }
        zzjy zzjyVar = null;
        if (i11 == 4) {
            return new zzna(zzjyVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
