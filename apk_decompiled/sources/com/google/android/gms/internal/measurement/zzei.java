package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes.dex */
public final class zzei extends zzkf implements zzln {
    private static final zzei zza;
    private int zzd;
    private int zze;
    private zzkm zzf = zzkf.zzbE();
    private zzkm zzg = zzkf.zzbE();
    private boolean zzh;
    private boolean zzi;

    static {
        zzei zzeiVar = new zzei();
        zza = zzeiVar;
        zzkf.zzbL(zzei.class, zzeiVar);
    }

    private zzei() {
    }

    public static /* synthetic */ void zzi(zzei zzeiVar, int i10, zzet zzetVar) {
        zzetVar.getClass();
        zzkm zzkmVar = zzeiVar.zzf;
        if (!zzkmVar.zzc()) {
            zzeiVar.zzf = zzkf.zzbF(zzkmVar);
        }
        zzeiVar.zzf.set(i10, zzetVar);
    }

    public static /* synthetic */ void zzj(zzei zzeiVar, int i10, zzek zzekVar) {
        zzekVar.getClass();
        zzkm zzkmVar = zzeiVar.zzg;
        if (!zzkmVar.zzc()) {
            zzeiVar.zzg = zzkf.zzbF(zzkmVar);
        }
        zzeiVar.zzg.set(i10, zzekVar);
    }

    public final int zza() {
        return this.zze;
    }

    public final int zzb() {
        return this.zzg.size();
    }

    public final int zzc() {
        return this.zzf.size();
    }

    public final zzek zze(int i10) {
        return (zzek) this.zzg.get(i10);
    }

    public final zzet zzf(int i10) {
        return (zzet) this.zzf.get(i10);
    }

    public final List zzg() {
        return this.zzg;
    }

    public final List zzh() {
        return this.zzf;
    }

    public final boolean zzk() {
        return (this.zzd & 1) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzkf
    public final Object zzl(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzkf.zzbI(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zzd", "zze", "zzf", zzet.class, "zzg", zzek.class, "zzh", "zzi"});
        }
        if (i11 == 3) {
            return new zzei();
        }
        zzeg zzegVar = null;
        if (i11 == 4) {
            return new zzeh(zzegVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }
}
