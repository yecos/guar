package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzgg extends zzkf implements zzln {
    private static final zzgg zza;
    private int zzd;
    private int zze = 1;
    private zzkm zzf = zzkf.zzbE();

    static {
        zzgg zzggVar = new zzgg();
        zza = zzggVar;
        zzkf.zzbL(zzgg.class, zzggVar);
    }

    private zzgg() {
    }

    public static zzge zza() {
        return (zzge) zza.zzbx();
    }

    public static /* synthetic */ void zzc(zzgg zzggVar, zzfv zzfvVar) {
        zzfvVar.getClass();
        zzkm zzkmVar = zzggVar.zzf;
        if (!zzkmVar.zzc()) {
            zzggVar.zzf = zzkf.zzbF(zzkmVar);
        }
        zzggVar.zzf.add(zzfvVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzkf
    public final Object zzl(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzkf.zzbI(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", new Object[]{"zzd", "zze", zzgf.zza, "zzf", zzfv.class});
        }
        if (i11 == 3) {
            return new zzgg();
        }
        zzfk zzfkVar = null;
        if (i11 == 4) {
            return new zzge(zzfkVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }
}
