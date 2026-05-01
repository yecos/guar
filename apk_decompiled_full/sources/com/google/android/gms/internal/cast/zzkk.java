package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public final class zzkk extends zzoy<zzkk, zzkj> implements zzqf {
    private static final zzkk zzb;
    private int zze;
    private String zzf = "";
    private String zzg = "";

    static {
        zzkk zzkkVar = new zzkk();
        zzb = zzkkVar;
        zzoy.zzA(zzkk.class, zzkkVar);
    }

    private zzkk() {
    }

    public static zzkj zza() {
        return zzb.zzr();
    }

    public static /* synthetic */ void zzd(zzkk zzkkVar, String str) {
        str.getClass();
        zzkkVar.zze |= 1;
        zzkkVar.zzf = str;
    }

    public static /* synthetic */ void zze(zzkk zzkkVar, String str) {
        str.getClass();
        zzkkVar.zze |= 2;
        zzkkVar.zzg = str;
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
            return new zzkk();
        }
        zzjy zzjyVar = null;
        if (i11 == 4) {
            return new zzkj(zzjyVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
