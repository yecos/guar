package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public final class zzkq extends zzoy<zzkq, zzkp> implements zzqf {
    private static final zzkq zzb;
    private int zze;
    private int zzf;

    static {
        zzkq zzkqVar = new zzkq();
        zzb = zzkqVar;
        zzoy.zzA(zzkq.class, zzkqVar);
    }

    private zzkq() {
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"zze", "zzf", zzfk.zza()});
        }
        if (i11 == 3) {
            return new zzkq();
        }
        zzjy zzjyVar = null;
        if (i11 == 4) {
            return new zzkp(zzjyVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
