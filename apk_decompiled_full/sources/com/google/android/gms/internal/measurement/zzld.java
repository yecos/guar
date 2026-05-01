package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
final class zzld implements zzlk {
    private final zzlk[] zza;

    public zzld(zzlk... zzlkVarArr) {
        this.zza = zzlkVarArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    public final zzlj zzb(Class cls) {
        zzlk[] zzlkVarArr = this.zza;
        for (int i10 = 0; i10 < 2; i10++) {
            zzlk zzlkVar = zzlkVarArr[i10];
            if (zzlkVar.zzc(cls)) {
                return zzlkVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    public final boolean zzc(Class cls) {
        zzlk[] zzlkVarArr = this.zza;
        for (int i10 = 0; i10 < 2; i10++) {
            if (zzlkVarArr[i10].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
