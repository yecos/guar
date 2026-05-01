package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public final class zzmz extends zzoy<zzmz, zzmy> implements zzqf {
    private static final zzmz zzb;
    private int zze;
    private String zzf = "";
    private zzpg<zzlr> zzg = zzoy.zzw();
    private zzpg<zzlc> zzh = zzoy.zzw();
    private boolean zzi;

    static {
        zzmz zzmzVar = new zzmz();
        zzb = zzmzVar;
        zzoy.zzA(zzmz.class, zzmzVar);
    }

    private zzmz() {
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဈ\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001", new Object[]{"zze", "zzf", "zzg", zzlr.class, "zzh", zzlc.class, "zzi"});
        }
        if (i11 == 3) {
            return new zzmz();
        }
        zzjy zzjyVar = null;
        if (i11 == 4) {
            return new zzmy(zzjyVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
