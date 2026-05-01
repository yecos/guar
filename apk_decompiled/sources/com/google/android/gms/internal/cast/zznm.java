package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public final class zznm extends zzoy<zznm, zznl> implements zzqf {
    private static final zzpe<Integer, zzjo> zzb = new zznk();
    private static final zznm zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private zzpd zzi = zzoy.zzu();
    private int zzj;

    static {
        zznm zznmVar = new zznm();
        zze = zznmVar;
        zzoy.zzA(zznm.class, zznmVar);
    }

    private zznm() {
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zze, "\u0001\u0004\u0000\u0001\u0001\u0005\u0004\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003\u001e\u0005ဌ\u0002", new Object[]{"zzf", "zzg", zzjr.zza(), "zzh", zzgl.zza(), "zzi", zzjo.zza(), "zzj", zzft.zza()});
        }
        if (i11 == 3) {
            return new zznm();
        }
        zzjy zzjyVar = null;
        if (i11 == 4) {
            return new zznl(zzjyVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zze;
    }
}
