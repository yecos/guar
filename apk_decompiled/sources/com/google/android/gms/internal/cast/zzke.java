package com.google.android.gms.internal.cast;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class zzke extends zzoy<zzke, zzkd> implements zzqf {
    private static final zzpe<Integer, zzju> zzb = new zzkc();
    private static final zzke zze;
    private int zzf;
    private zzkk zzg;
    private zzmb zzh;
    private zzpg<zzlx> zzi = zzoy.zzw();
    private zzpd zzj = zzoy.zzu();

    static {
        zzke zzkeVar = new zzke();
        zze = zzkeVar;
        zzoy.zzA(zzke.class, zzkeVar);
    }

    private zzke() {
    }

    public static zzkd zza() {
        return zze.zzr();
    }

    public static /* synthetic */ void zzd(zzke zzkeVar, zzkk zzkkVar) {
        zzkkVar.getClass();
        zzkeVar.zzg = zzkkVar;
        zzkeVar.zzf |= 1;
    }

    public static /* synthetic */ void zze(zzke zzkeVar, Iterable iterable) {
        zzpd zzpdVar = zzkeVar.zzj;
        if (!zzpdVar.zzc()) {
            int size = zzpdVar.size();
            zzkeVar.zzj = zzpdVar.zzg(size == 0 ? 10 : size + size);
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            zzkeVar.zzj.zzh(((zzju) it.next()).zza());
        }
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzoy.zzz(zze, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001b\u0004\u001e", new Object[]{"zzf", "zzg", "zzh", "zzi", zzlx.class, "zzj", zzju.zzc()});
        }
        if (i11 == 3) {
            return new zzke();
        }
        zzjy zzjyVar = null;
        if (i11 == 4) {
            return new zzkd(zzjyVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zze;
    }
}
