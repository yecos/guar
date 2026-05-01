package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzfb extends zzkf implements zzln {
    private static final zzfb zza;
    private int zzd;
    private String zze = "";
    private zzkm zzf = zzkf.zzbE();
    private boolean zzg;

    static {
        zzfb zzfbVar = new zzfb();
        zza = zzfbVar;
        zzkf.zzbL(zzfb.class, zzfbVar);
    }

    private zzfb() {
    }

    public final String zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.measurement.zzkf
    public final Object zzl(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzkf.zzbI(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဇ\u0001", new Object[]{"zzd", "zze", "zzf", zzfh.class, "zzg"});
        }
        if (i11 == 3) {
            return new zzfb();
        }
        zzez zzezVar = null;
        if (i11 == 4) {
            return new zzfa(zzezVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }
}
