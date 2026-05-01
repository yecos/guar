package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public final class zzln extends zzoy<zzln, zzlm> implements zzqf {
    private static final zzln zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private zzpd zzh = zzoy.zzu();
    private zzpd zzi = zzoy.zzu();
    private zzpg<String> zzj = zzoy.zzw();
    private zzpg<String> zzk = zzoy.zzw();
    private int zzl;

    static {
        zzln zzlnVar = new zzln();
        zzb = zzlnVar;
        zzoy.zzA(zzln.class, zzlnVar);
    }

    private zzln() {
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0004\u0000\u0001င\u0000\u0002ဌ\u0001\u0003\u0016\u0004\u0016\u0005\u001a\u0006\u001a\u0007ဌ\u0002", new Object[]{"zze", "zzf", "zzg", zzgx.zza(), "zzh", "zzi", "zzj", "zzk", "zzl", zzgl.zza()});
        }
        if (i11 == 3) {
            return new zzln();
        }
        zzjy zzjyVar = null;
        if (i11 == 4) {
            return new zzlm(zzjyVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
