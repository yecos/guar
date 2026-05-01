package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public final class zzky extends zzoy<zzky, zzkx> implements zzqf {
    private static final zzky zzb;
    private int zze;
    private int zzf = 0;
    private Object zzg;
    private long zzh;

    static {
        zzky zzkyVar = new zzky();
        zzb = zzkyVar;
        zzoy.zzA(zzky.class, zzkyVar);
    }

    private zzky() {
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0004\u0001\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001စ\u0000\u0002်\u0000\u0003ဵ\u0000\u0004း\u0000", new Object[]{"zzg", "zzf", "zze", "zzh"});
        }
        if (i11 == 3) {
            return new zzky();
        }
        zzjy zzjyVar = null;
        if (i11 == 4) {
            return new zzkx(zzjyVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
