package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzfz extends zzkf implements zzln {
    private static final zzfz zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private zzfn zzg;

    static {
        zzfz zzfzVar = new zzfz();
        zza = zzfzVar;
        zzkf.zzbL(zzfz.class, zzfzVar);
    }

    private zzfz() {
    }

    @Override // com.google.android.gms.internal.measurement.zzkf
    public final Object zzl(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzkf.zzbI(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i11 == 3) {
            return new zzfz();
        }
        zzfk zzfkVar = null;
        if (i11 == 4) {
            return new zzfy(zzfkVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }
}
