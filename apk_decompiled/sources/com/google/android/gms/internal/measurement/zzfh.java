package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzfh extends zzkf implements zzln {
    private static final zzfh zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zzfh zzfhVar = new zzfh();
        zza = zzfhVar;
        zzkf.zzbL(zzfh.class, zzfhVar);
    }

    private zzfh() {
    }

    @Override // com.google.android.gms.internal.measurement.zzkf
    public final Object zzl(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzkf.zzbI(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i11 == 3) {
            return new zzfh();
        }
        zzez zzezVar = null;
        if (i11 == 4) {
            return new zzfg(zzezVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }
}
