package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public final class zzmr extends zzoy<zzmr, zzmq> implements zzqf {
    private static final zzmr zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;

    static {
        zzmr zzmrVar = new zzmr();
        zzb = zzmrVar;
        zzoy.zzA(zzmr.class, zzmrVar);
    }

    private zzmr() {
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002ဌ\u0001\u0003င\u0002", new Object[]{"zze", "zzf", "zzg", zzhy.zza(), "zzh"});
        }
        if (i11 == 3) {
            return new zzmr();
        }
        zzjy zzjyVar = null;
        if (i11 == 4) {
            return new zzmq(zzjyVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
