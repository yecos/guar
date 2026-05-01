package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public final class zzmb extends zzoy<zzmb, zzma> implements zzqf {
    private static final zzmb zzb;
    private int zze;
    private String zzf = "";
    private String zzg = "";

    static {
        zzmb zzmbVar = new zzmb();
        zzb = zzmbVar;
        zzoy.zzA(zzmb.class, zzmbVar);
    }

    private zzmb() {
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i11 == 3) {
            return new zzmb();
        }
        zzjy zzjyVar = null;
        if (i11 == 4) {
            return new zzma(zzjyVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
