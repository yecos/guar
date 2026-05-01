package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public final class zzll extends zzoy<zzll, zzlk> implements zzqf {
    private static final zzpe<Integer, zzjo> zzb = new zzlj();
    private static final zzll zze;
    private int zzf;
    private boolean zzh;
    private zznm zzi;
    private boolean zzj;
    private String zzg = "";
    private zzpd zzk = zzoy.zzu();

    static {
        zzll zzllVar = new zzll();
        zze = zzllVar;
        zzoy.zzA(zzll.class, zzllVar);
    }

    private zzll() {
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zze, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005,", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzjo.zza()});
        }
        if (i11 == 3) {
            return new zzll();
        }
        zzjy zzjyVar = null;
        if (i11 == 4) {
            return new zzlk(zzjyVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zze;
    }
}
