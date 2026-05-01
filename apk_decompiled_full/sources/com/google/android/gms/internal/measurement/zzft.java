package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes.dex */
public final class zzft extends zzkf implements zzln {
    private static final zzft zza;
    private int zzd;
    private zzkm zze = zzkf.zzbE();
    private String zzf = "";
    private long zzg;
    private long zzh;
    private int zzi;

    static {
        zzft zzftVar = new zzft();
        zza = zzftVar;
        zzkf.zzbL(zzft.class, zzftVar);
    }

    private zzft() {
    }

    public static zzfs zze() {
        return (zzfs) zza.zzbx();
    }

    public static /* synthetic */ void zzj(zzft zzftVar, int i10, zzfx zzfxVar) {
        zzfxVar.getClass();
        zzftVar.zzv();
        zzftVar.zze.set(i10, zzfxVar);
    }

    public static /* synthetic */ void zzk(zzft zzftVar, zzfx zzfxVar) {
        zzfxVar.getClass();
        zzftVar.zzv();
        zzftVar.zze.add(zzfxVar);
    }

    public static /* synthetic */ void zzm(zzft zzftVar, Iterable iterable) {
        zzftVar.zzv();
        zzio.zzbt(iterable, zzftVar.zze);
    }

    public static /* synthetic */ void zzo(zzft zzftVar, int i10) {
        zzftVar.zzv();
        zzftVar.zze.remove(i10);
    }

    public static /* synthetic */ void zzp(zzft zzftVar, String str) {
        str.getClass();
        zzftVar.zzd |= 1;
        zzftVar.zzf = str;
    }

    public static /* synthetic */ void zzq(zzft zzftVar, long j10) {
        zzftVar.zzd |= 2;
        zzftVar.zzg = j10;
    }

    public static /* synthetic */ void zzr(zzft zzftVar, long j10) {
        zzftVar.zzd |= 4;
        zzftVar.zzh = j10;
    }

    private final void zzv() {
        zzkm zzkmVar = this.zze;
        if (zzkmVar.zzc()) {
            return;
        }
        this.zze = zzkf.zzbF(zzkmVar);
    }

    public final int zza() {
        return this.zzi;
    }

    public final int zzb() {
        return this.zze.size();
    }

    public final long zzc() {
        return this.zzh;
    }

    public final long zzd() {
        return this.zzg;
    }

    public final zzfx zzg(int i10) {
        return (zzfx) this.zze.get(i10);
    }

    public final String zzh() {
        return this.zzf;
    }

    public final List zzi() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.measurement.zzkf
    public final Object zzl(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzkf.zzbI(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zzd", "zze", zzfx.class, "zzf", "zzg", "zzh", "zzi"});
        }
        if (i11 == 3) {
            return new zzft();
        }
        zzfk zzfkVar = null;
        if (i11 == 4) {
            return new zzfs(zzfkVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zza;
    }

    public final boolean zzs() {
        return (this.zzd & 8) != 0;
    }

    public final boolean zzt() {
        return (this.zzd & 4) != 0;
    }

    public final boolean zzu() {
        return (this.zzd & 2) != 0;
    }
}
