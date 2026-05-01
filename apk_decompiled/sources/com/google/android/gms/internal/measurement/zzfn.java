package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzfn extends zzkf implements zzln {
    private static final zzfn zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";

    static {
        zzfn zzfnVar = new zzfn();
        zza = zzfnVar;
        zzkf.zzbL(zzfn.class, zzfnVar);
    }

    private zzfn() {
    }

    @Override // com.google.android.gms.internal.measurement.zzkf
    public final Object zzl(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzkf.zzbI(zza, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i11 == 3) {
            return new zzfn();
        }
        zzfk zzfkVar = null;
        if (i11 == 4) {
            return new zzfm(zzfkVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }
}
