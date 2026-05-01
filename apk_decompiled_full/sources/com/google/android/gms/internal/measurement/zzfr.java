package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzfr extends zzkf implements zzln {
    private static final zzfr zza;
    private int zzd;
    private int zze;
    private long zzf;

    static {
        zzfr zzfrVar = new zzfr();
        zza = zzfrVar;
        zzkf.zzbL(zzfr.class, zzfrVar);
    }

    private zzfr() {
    }

    public static zzfq zzc() {
        return (zzfq) zza.zzbx();
    }

    public static /* synthetic */ void zze(zzfr zzfrVar, int i10) {
        zzfrVar.zzd |= 1;
        zzfrVar.zze = i10;
    }

    public static /* synthetic */ void zzf(zzfr zzfrVar, long j10) {
        zzfrVar.zzd |= 2;
        zzfrVar.zzf = j10;
    }

    public final int zza() {
        return this.zze;
    }

    public final long zzb() {
        return this.zzf;
    }

    public final boolean zzg() {
        return (this.zzd & 2) != 0;
    }

    public final boolean zzh() {
        return (this.zzd & 1) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzkf
    public final Object zzl(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzkf.zzbI(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i11 == 3) {
            return new zzfr();
        }
        zzfk zzfkVar = null;
        if (i11 == 4) {
            return new zzfq(zzfkVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }
}
