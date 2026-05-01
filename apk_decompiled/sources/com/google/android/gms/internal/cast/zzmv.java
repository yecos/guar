package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public final class zzmv extends zzoy<zzmv, zzmu> implements zzqf {
    private static final zzmv zzb;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzmv zzmvVar = new zzmv();
        zzb = zzmvVar;
        zzoy.zzA(zzmv.class, zzmvVar);
    }

    private zzmv() {
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001", new Object[]{"zze", "zzf", zzih.zza(), "zzg", zzih.zza()});
        }
        if (i11 == 3) {
            return new zzmv();
        }
        zzjy zzjyVar = null;
        if (i11 == 4) {
            return new zzmu(zzjyVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
