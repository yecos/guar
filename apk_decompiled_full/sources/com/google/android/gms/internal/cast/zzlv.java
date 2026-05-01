package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public final class zzlv extends zzoy<zzlv, zzlu> implements zzqf {
    private static final zzlv zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private zzlr zzh;

    static {
        zzlv zzlvVar = new zzlv();
        zzb = zzlvVar;
        zzoy.zzA(zzlv.class, zzlvVar);
    }

    private zzlv() {
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003ဉ\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
        }
        if (i11 == 3) {
            return new zzlv();
        }
        zzjy zzjyVar = null;
        if (i11 == 4) {
            return new zzlu(zzjyVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
