package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public final class zzkm extends zzoy<zzkm, zzkl> implements zzqf {
    private static final zzkm zzb;
    private int zze;
    private zzlc zzf;
    private boolean zzg;
    private long zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private zzmv zzn;
    private int zzo;
    private int zzp;

    static {
        zzkm zzkmVar = new zzkm();
        zzb = zzkmVar;
        zzoy.zzA(zzkm.class, zzkmVar);
    }

    private zzkm() {
    }

    public static zzkl zza() {
        return zzb.zzr();
    }

    public static zzkl zzc(zzkm zzkmVar) {
        zzkl zzr = zzb.zzr();
        zzr.zzo(zzkmVar);
        return zzr;
    }

    public static zzkm zze() {
        return zzb;
    }

    public static /* synthetic */ void zzf(zzkm zzkmVar, zzlc zzlcVar) {
        zzlcVar.getClass();
        zzkmVar.zzf = zzlcVar;
        zzkmVar.zze |= 1;
    }

    public static /* synthetic */ void zzg(zzkm zzkmVar, boolean z10) {
        zzkmVar.zze |= 2;
        zzkmVar.zzg = z10;
    }

    public static /* synthetic */ void zzh(zzkm zzkmVar, long j10) {
        zzkmVar.zze |= 4;
        zzkmVar.zzh = j10;
    }

    public static /* synthetic */ void zzi(zzkm zzkmVar, int i10) {
        zzkmVar.zze |= 64;
        zzkmVar.zzl = i10;
    }

    public static /* synthetic */ void zzj(zzkm zzkmVar, int i10) {
        zzkmVar.zze |= 128;
        zzkmVar.zzm = i10;
    }

    public static /* synthetic */ void zzk(zzkm zzkmVar, int i10) {
        zzkmVar.zze |= 1024;
        zzkmVar.zzp = i10;
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဇ\u0001\u0003စ\u0002\u0004ဆ\u0003\u0005ဌ\u0004\u0006ဌ\u0005\u0007င\u0006\bင\u0007\tဉ\b\nဌ\t\u000bင\n", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzfb.zza(), "zzk", zzey.zza(), "zzl", "zzm", "zzn", "zzo", zzgo.zza(), "zzp"});
        }
        if (i11 == 3) {
            return new zzkm();
        }
        zzjy zzjyVar = null;
        if (i11 == 4) {
            return new zzkl(zzjyVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
