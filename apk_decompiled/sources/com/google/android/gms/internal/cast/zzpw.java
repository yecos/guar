package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
final class zzpw implements zzqq {
    private static final zzqc zza = new zzpu();
    private final zzqc zzb;

    public zzpw() {
        zzqc zzqcVar;
        zzqc[] zzqcVarArr = new zzqc[2];
        zzqcVarArr[0] = zzou.zza();
        try {
            zzqcVar = (zzqc) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            zzqcVar = zza;
        }
        zzqcVarArr[1] = zzqcVar;
        zzpv zzpvVar = new zzpv(zzqcVarArr);
        zzph.zzf(zzpvVar, "messageInfoFactory");
        this.zzb = zzpvVar;
    }

    private static boolean zzb(zzqb zzqbVar) {
        return zzqbVar.zzc() == 1;
    }

    @Override // com.google.android.gms.internal.cast.zzqq
    public final <T> zzqp<T> zza(Class<T> cls) {
        zzqr.zzE(cls);
        zzqb zzb = this.zzb.zzb(cls);
        return zzb.zzb() ? zzoy.class.isAssignableFrom(cls) ? zzqi.zzg(zzqr.zzB(), zzoq.zzb(), zzb.zza()) : zzqi.zzg(zzqr.zzz(), zzoq.zza(), zzb.zza()) : zzoy.class.isAssignableFrom(cls) ? zzb(zzb) ? zzqh.zzg(cls, zzb, zzqk.zzb(), zzps.zzd(), zzqr.zzB(), zzoq.zzb(), zzqa.zzb()) : zzqh.zzg(cls, zzb, zzqk.zzb(), zzps.zzd(), zzqr.zzB(), null, zzqa.zzb()) : zzb(zzb) ? zzqh.zzg(cls, zzb, zzqk.zza(), zzps.zzc(), zzqr.zzz(), zzoq.zza(), zzqa.zza()) : zzqh.zzg(cls, zzb, zzqk.zza(), zzps.zzc(), zzqr.zzA(), null, zzqa.zza());
    }
}
