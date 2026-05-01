package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public final class zznd extends zzoy<zznd, zznc> implements zzqf {
    private static final zznd zzb;
    private int zze;
    private long zzf;
    private boolean zzg;
    private long zzh;
    private boolean zzi;

    static {
        zznd zzndVar = new zznd();
        zzb = zzndVar;
        zzoy.zzA(zznd.class, zzndVar);
    }

    private zznd() {
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဇ\u0001\u0003ဂ\u0002\u0004ဇ\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i11 == 3) {
            return new zznd();
        }
        zzjy zzjyVar = null;
        if (i11 == 4) {
            return new zznc(zzjyVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
