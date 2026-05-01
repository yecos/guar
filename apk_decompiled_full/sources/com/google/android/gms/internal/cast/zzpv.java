package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
final class zzpv implements zzqc {
    private final zzqc[] zza;

    public zzpv(zzqc... zzqcVarArr) {
        this.zza = zzqcVarArr;
    }

    @Override // com.google.android.gms.internal.cast.zzqc
    public final zzqb zzb(Class<?> cls) {
        zzqc[] zzqcVarArr = this.zza;
        for (int i10 = 0; i10 < 2; i10++) {
            zzqc zzqcVar = zzqcVarArr[i10];
            if (zzqcVar.zzc(cls)) {
                return zzqcVar.zzb(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }

    @Override // com.google.android.gms.internal.cast.zzqc
    public final boolean zzc(Class<?> cls) {
        zzqc[] zzqcVarArr = this.zza;
        for (int i10 = 0; i10 < 2; i10++) {
            if (zzqcVarArr[i10].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
