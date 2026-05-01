package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public final class zzlx extends zzoy<zzlx, zzlw> implements zzqf {
    private static final zzlx zzb;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzlx zzlxVar = new zzlx();
        zzb = zzlxVar;
        zzoy.zzA(zzlx.class, zzlxVar);
    }

    private zzlx() {
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002င\u0001", new Object[]{"zze", "zzf", zzgi.zza(), "zzg"});
        }
        if (i11 == 3) {
            return new zzlx();
        }
        zzjy zzjyVar = null;
        if (i11 == 4) {
            return new zzlw(zzjyVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
