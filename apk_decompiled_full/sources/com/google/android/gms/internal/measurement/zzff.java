package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes.dex */
public final class zzff extends zzkf implements zzln {
    private static final zzff zza;
    private int zzd;
    private long zze;
    private int zzg;
    private boolean zzl;
    private String zzf = "";
    private zzkm zzh = zzkf.zzbE();
    private zzkm zzi = zzkf.zzbE();
    private zzkm zzj = zzkf.zzbE();
    private String zzk = "";
    private zzkm zzm = zzkf.zzbE();
    private zzkm zzn = zzkf.zzbE();
    private String zzo = "";

    static {
        zzff zzffVar = new zzff();
        zza = zzffVar;
        zzkf.zzbL(zzff.class, zzffVar);
    }

    private zzff() {
    }

    public static zzfe zze() {
        return (zzfe) zza.zzbx();
    }

    public static zzff zzg() {
        return zza;
    }

    public static /* synthetic */ void zzo(zzff zzffVar, int i10, zzfd zzfdVar) {
        zzfdVar.getClass();
        zzkm zzkmVar = zzffVar.zzi;
        if (!zzkmVar.zzc()) {
            zzffVar.zzi = zzkf.zzbF(zzkmVar);
        }
        zzffVar.zzi.set(i10, zzfdVar);
    }

    public final int zza() {
        return this.zzm.size();
    }

    public final int zzb() {
        return this.zzi.size();
    }

    public final long zzc() {
        return this.zze;
    }

    public final zzfd zzd(int i10) {
        return (zzfd) this.zzi.get(i10);
    }

    public final String zzh() {
        return this.zzf;
    }

    public final String zzi() {
        return this.zzo;
    }

    public final List zzj() {
        return this.zzj;
    }

    public final List zzk() {
        return this.zzn;
    }

    @Override // com.google.android.gms.internal.measurement.zzkf
    public final Object zzl(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzkf.zzbI(zza, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0005\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b\n\u001b\u000bဈ\u0005", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", zzfj.class, "zzi", zzfd.class, "zzj", zzei.class, "zzk", "zzl", "zzm", zzgt.class, "zzn", zzfb.class, "zzo"});
        }
        if (i11 == 3) {
            return new zzff();
        }
        zzez zzezVar = null;
        if (i11 == 4) {
            return new zzfe(zzezVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }

    public final List zzm() {
        return this.zzm;
    }

    public final List zzn() {
        return this.zzh;
    }

    public final boolean zzq() {
        return this.zzl;
    }

    public final boolean zzr() {
        return (this.zzd & 2) != 0;
    }

    public final boolean zzs() {
        return (this.zzd & 1) != 0;
    }
}
