package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public final class zznj extends zzoy<zznj, zzni> implements zzqf {
    private static final zznj zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private zzpg<zzlc> zzh = zzoy.zzw();
    private zzpg<zzlc> zzi = zzoy.zzw();
    private int zzj;

    static {
        zznj zznjVar = new zznj();
        zzb = zznjVar;
        zzoy.zzA(zznj.class, zznjVar);
    }

    private zznj() {
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003\u001b\u0004\u001b\u0005ဌ\u0002", new Object[]{"zze", "zzf", zzji.zza(), "zzg", zzjl.zza(), "zzh", zzlc.class, "zzi", zzlc.class, "zzj", zzgl.zza()});
        }
        if (i11 == 3) {
            return new zznj();
        }
        zzjy zzjyVar = null;
        if (i11 == 4) {
            return new zzni(zzjyVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
