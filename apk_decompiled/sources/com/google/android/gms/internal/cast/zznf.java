package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public final class zznf extends zzoy<zznf, zzne> implements zzqf {
    private static final zznf zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private zzkg zzh;

    static {
        zznf zznfVar = new zznf();
        zzb = zznfVar;
        zzoy.zzA(zznf.class, zznfVar);
    }

    private zznf() {
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zze", "zzf", zziz.zza(), "zzg", "zzh"});
        }
        if (i11 == 3) {
            return new zznf();
        }
        zzjy zzjyVar = null;
        if (i11 == 4) {
            return new zzne(zzjyVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
