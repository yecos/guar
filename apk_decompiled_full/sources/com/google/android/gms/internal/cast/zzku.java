package com.google.android.gms.internal.cast;

import com.google.common.primitives.Ints;

/* loaded from: classes.dex */
public final class zzku extends zzoy<zzku, zzkt> implements zzqf {
    private static final zzku zzb;
    private int zzC;
    private int zzD;
    private zzlc zzE;
    private int zzF;
    private zzks zzG;
    private zzlc zzI;
    private int zzJ;
    private int zzK;
    private int zzL;
    private int zzM;
    private int zzN;
    private int zzO;
    private zznj zzP;
    private zzkm zzQ;
    private zzkb zzR;
    private zzlz zzS;
    private zzmx zzT;
    private zzmd zzU;
    private int zzW;
    private zzml zzX;
    private boolean zzZ;
    private boolean zzaa;
    private int zzab;
    private zzke zzac;
    private zzmt zzad;
    private zzlt zzae;
    private zzmj zzaf;
    private zznd zzag;
    private zzkw zzah;
    private int zzai;
    private int zzaj;
    private int zzak;
    private int zze;
    private int zzf;
    private long zzg;
    private long zzh;
    private int zzi;
    private zzlp zzj;
    private zzmr zzk;
    private zzln zzl;
    private zzli zzm;
    private zzkq zzn;
    private zzmp zzo;
    private zzki zzp;
    private zznh zzq;
    private zzlg zzs;
    private zzes zzt;
    private zzmh zzv;
    private byte zzal = 2;
    private String zzr = "";
    private String zzu = "";
    private String zzw = "";
    private zzpd zzx = zzoy.zzu();
    private zzpg<zzlr> zzy = zzoy.zzw();
    private zzpg<zzlv> zzz = zzoy.zzw();
    private zzpg<zzky> zzA = zzoy.zzw();
    private zzpg<zzmz> zzB = zzoy.zzw();
    private zzpg<zzlc> zzH = zzoy.zzw();
    private zzpg<zzkk> zzV = zzoy.zzw();
    private zzpg<zzko> zzY = zzoy.zzw();

    static {
        zzku zzkuVar = new zzku();
        zzb = zzkuVar;
        zzoy.zzA(zzku.class, zzkuVar);
    }

    private zzku() {
    }

    public static zzkt zzc() {
        return zzb.zzr();
    }

    public static zzkt zzd(zzku zzkuVar) {
        zzkt zzr = zzb.zzr();
        zzr.zzo(zzkuVar);
        return zzr;
    }

    public static /* synthetic */ void zzf(zzku zzkuVar, int i10) {
        zzkuVar.zze |= 268435456;
        zzkuVar.zzO = i10;
    }

    public static /* synthetic */ void zzg(zzku zzkuVar, zzkm zzkmVar) {
        zzkmVar.getClass();
        zzkuVar.zzQ = zzkmVar;
        zzkuVar.zze |= Ints.MAX_POWER_OF_TWO;
    }

    public static /* synthetic */ void zzh(zzku zzkuVar, zzkk zzkkVar) {
        zzkkVar.getClass();
        zzpg<zzkk> zzpgVar = zzkuVar.zzV;
        if (!zzpgVar.zzc()) {
            int size = zzpgVar.size();
            zzkuVar.zzV = zzpgVar.zzg(size == 0 ? 10 : size + size);
        }
        zzkuVar.zzV.add(zzkkVar);
    }

    public static /* synthetic */ void zzi(zzku zzkuVar, zzke zzkeVar) {
        zzkeVar.getClass();
        zzkuVar.zzac = zzkeVar;
        zzkuVar.zzf |= 256;
    }

    public static /* synthetic */ void zzj(zzku zzkuVar, long j10) {
        zzkuVar.zze |= 2;
        zzkuVar.zzh = j10;
    }

    public static /* synthetic */ void zzk(zzku zzkuVar, String str) {
        zzkuVar.zze |= 2048;
        zzkuVar.zzr = str;
    }

    public static /* synthetic */ void zzl(zzku zzkuVar, String str) {
        str.getClass();
        zzkuVar.zze |= 16384;
        zzkuVar.zzu = str;
    }

    public static /* synthetic */ void zzm(zzku zzkuVar, String str) {
        zzkuVar.zze |= 65536;
        zzkuVar.zzw = str;
    }

    public final zzkm zza() {
        zzkm zzkmVar = this.zzQ;
        return zzkmVar == null ? zzkm.zze() : zzkmVar;
    }

    @Override // com.google.android.gms.internal.cast.zzoy
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return Byte.valueOf(this.zzal);
        }
        if (i11 == 2) {
            return zzoy.zzz(zzb, "\u00019\u0000\u0002\u000199\u0000\b\u0001\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဌ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007ဉ\u0006\bဉ\u0007\tဈ\u000e\nဉ\b\u000bဉ\t\fဉ\n\rဈ\u000b\u000eဉ\f\u000fဉ\r\u0010ဉ\u000f\u0011ဈ\u0010\u0012\u0016\u0013\u001b\u0014\u001b\u0015\u001b\u0016\u001b\u0017ဌ\u0011\u0018ဉ\u0015\u0019\u001b\u001aဉ\u0016\u001bဌ\u0018\u001cင\u0019\u001dင\u001a\u001eင\u001b\u001fဆ\u001c ဉ\u001d!ဉ\u001e\"ဉ\u001f#ဌ\u0012$ဉ\u0013%ᐉ &ဉ!'ဉ\"(\u001b)ဌ#*ဉ$+\u001b,ဌ\u0017-ဇ%.ဇ&/ဌ'0ဉ(1င\u00142ဉ)3ဉ*4ဉ+5ဉ,6ဉ-7ဌ.8ဌ/9ဌ0", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", zzjc.zza(), "zzj", "zzk", "zzl", "zzm", "zzn", "zzu", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzv", "zzw", "zzx", "zzy", zzlr.class, "zzz", zzlv.class, "zzA", zzky.class, "zzB", zzmz.class, "zzC", zziw.zza(), "zzG", "zzH", zzlc.class, "zzI", "zzK", zzhd.zza(), "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzR", "zzD", zziq.zza(), "zzE", "zzS", "zzT", "zzU", "zzV", zzkk.class, "zzW", zzit.zza(), "zzX", "zzY", zzko.class, "zzJ", zzha.zza(), "zzZ", "zzaa", "zzab", zzgu.zza(), "zzac", "zzF", "zzad", "zzae", "zzaf", "zzag", "zzah", "zzai", zzfq.zza(), "zzaj", zzhv.zza(), "zzak", zzfn.zza()});
        }
        if (i11 == 3) {
            return new zzku();
        }
        zzjy zzjyVar = null;
        if (i11 == 4) {
            return new zzkt(zzjyVar);
        }
        if (i11 == 5) {
            return zzb;
        }
        this.zzal = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
