package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public final class zzlr extends zzoy<zzlr, zzlq> implements zzqf {
    private static final zzlr zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;

    static {
        zzlr zzlrVar = new zzlr();
        zzb = zzlrVar;
        zzoy.zzA(zzlr.class, zzlrVar);
    }

    private zzlr() {
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zze", "zzf", zzgx.zza(), "zzg", "zzh"});
        }
        if (i11 == 3) {
            return new zzlr();
        }
        zzjy zzjyVar = null;
        if (i11 == 4) {
            return new zzlq(zzjyVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
