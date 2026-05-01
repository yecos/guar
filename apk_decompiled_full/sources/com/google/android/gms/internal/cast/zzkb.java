package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public final class zzkb extends zzoy<zzkb, zzka> implements zzqf {
    private static final zzpe<Integer, zzju> zzb = new zzjz();
    private static final zzkb zze;
    private int zzf;
    private String zzg = "";
    private String zzh = "";
    private zzpd zzi = zzoy.zzu();

    static {
        zzkb zzkbVar = new zzkb();
        zze = zzkbVar;
        zzoy.zzA(zzkb.class, zzkbVar);
    }

    private zzkb() {
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zze, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003\u001e", new Object[]{"zzf", "zzg", "zzh", "zzi", zzju.zzc()});
        }
        if (i11 == 3) {
            return new zzkb();
        }
        zzjy zzjyVar = null;
        if (i11 == 4) {
            return new zzka(zzjyVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zze;
    }
}
