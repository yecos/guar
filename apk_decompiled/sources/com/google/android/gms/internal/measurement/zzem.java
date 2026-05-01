package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzem extends zzkf implements zzln {
    private static final zzem zza;
    private int zzd;
    private zzey zze;
    private zzer zzf;
    private boolean zzg;
    private String zzh = "";

    static {
        zzem zzemVar = new zzem();
        zza = zzemVar;
        zzkf.zzbL(zzem.class, zzemVar);
    }

    private zzem() {
    }

    public static zzem zzb() {
        return zza;
    }

    public static /* synthetic */ void zzf(zzem zzemVar, String str) {
        zzemVar.zzd |= 8;
        zzemVar.zzh = str;
    }

    public final zzer zzc() {
        zzer zzerVar = this.zzf;
        return zzerVar == null ? zzer.zzb() : zzerVar;
    }

    public final zzey zzd() {
        zzey zzeyVar = this.zze;
        return zzeyVar == null ? zzey.zzc() : zzeyVar;
    }

    public final String zze() {
        return this.zzh;
    }

    public final boolean zzg() {
        return this.zzg;
    }

    public final boolean zzh() {
        return (this.zzd & 4) != 0;
    }

    public final boolean zzi() {
        return (this.zzd & 2) != 0;
    }

    public final boolean zzj() {
        return (this.zzd & 8) != 0;
    }

    public final boolean zzk() {
        return (this.zzd & 1) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzkf
    public final Object zzl(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzkf.zzbI(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i11 == 3) {
            return new zzem();
        }
        zzeg zzegVar = null;
        if (i11 == 4) {
            return new zzel(zzegVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }
}
