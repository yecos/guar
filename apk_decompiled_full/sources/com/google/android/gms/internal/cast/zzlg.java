package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public final class zzlg extends zzoy<zzlg, zzld> implements zzqf {
    private static final zzlg zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private zzpg<zzlf> zzi = zzoy.zzw();

    static {
        zzlg zzlgVar = new zzlg();
        zzb = zzlgVar;
        zzoy.zzA(zzlg.class, zzlgVar);
    }

    private zzlg() {
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004\u001b", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", zzlf.class});
        }
        if (i11 == 3) {
            return new zzlg();
        }
        zzjy zzjyVar = null;
        if (i11 == 4) {
            return new zzld(zzjyVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
