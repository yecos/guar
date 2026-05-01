package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzfd extends zzkf implements zzln {
    private static final zzfd zza;
    private int zzd;
    private String zze = "";
    private boolean zzf;
    private boolean zzg;
    private int zzh;

    static {
        zzfd zzfdVar = new zzfd();
        zza = zzfdVar;
        zzkf.zzbL(zzfd.class, zzfdVar);
    }

    private zzfd() {
    }

    public static /* synthetic */ void zzd(zzfd zzfdVar, String str) {
        str.getClass();
        zzfdVar.zzd |= 1;
        zzfdVar.zze = str;
    }

    public final int zza() {
        return this.zzh;
    }

    public final String zzc() {
        return this.zze;
    }

    public final boolean zze() {
        return this.zzf;
    }

    public final boolean zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        return (this.zzd & 2) != 0;
    }

    public final boolean zzh() {
        return (this.zzd & 4) != 0;
    }

    public final boolean zzi() {
        return (this.zzd & 8) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzkf
    public final Object zzl(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzkf.zzbI(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i11 == 3) {
            return new zzfd();
        }
        zzez zzezVar = null;
        if (i11 == 4) {
            return new zzfc(zzezVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }
}
