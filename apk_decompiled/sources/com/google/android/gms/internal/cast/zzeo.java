package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public final class zzeo extends zzoy<zzeo, zzej> implements zzqf {
    private static final zzeo zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private boolean zzq;

    static {
        zzeo zzeoVar = new zzeo();
        zzb = zzeoVar;
        zzoy.zzA(zzeo.class, zzeoVar);
    }

    private zzeo() {
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003ဌ\u0002\u0004ဌ\u0003\u0005ဌ\u0004\u0006ဌ\u0005\u0007ဌ\u0006\bဌ\u0007\tင\b\nင\t\u000bင\n\fဇ\u000b", new Object[]{"zze", "zzf", "zzg", "zzh", zzek.zza, "zzi", zzel.zza, "zzj", zzei.zza, "zzk", zzem.zza, "zzl", zzen.zza, "zzm", zzeh.zza, "zzn", "zzo", "zzp", "zzq"});
        }
        if (i11 == 3) {
            return new zzeo();
        }
        zzeg zzegVar = null;
        if (i11 == 4) {
            return new zzej(zzegVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
