package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public final class zzlc extends zzoy<zzlc, zzlb> implements zzqf {
    private static final zzlc zzb;
    private int zze;
    private String zzf = "";
    private String zzg = "";

    static {
        zzlc zzlcVar = new zzlc();
        zzb = zzlcVar;
        zzoy.zzA(zzlc.class, zzlcVar);
    }

    private zzlc() {
    }

    public static zzlb zza() {
        return zzb.zzr();
    }

    public static /* synthetic */ void zzd(zzlc zzlcVar, String str) {
        str.getClass();
        zzlcVar.zze |= 1;
        zzlcVar.zzf = str;
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i11 == 3) {
            return new zzlc();
        }
        zzjy zzjyVar = null;
        if (i11 == 4) {
            return new zzlb(zzjyVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
