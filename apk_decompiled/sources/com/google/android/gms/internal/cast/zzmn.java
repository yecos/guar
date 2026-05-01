package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public final class zzmn extends zzoy<zzmn, zzmm> implements zzqf {
    private static final zzmn zzb;
    private int zze;
    private int zzf;
    private String zzg = "";

    static {
        zzmn zzmnVar = new zzmn();
        zzb = zzmnVar;
        zzoy.zzA(zzmn.class, zzmnVar);
    }

    private zzmn() {
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i11 == 3) {
            return new zzmn();
        }
        zzjy zzjyVar = null;
        if (i11 == 4) {
            return new zzmm(zzjyVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
