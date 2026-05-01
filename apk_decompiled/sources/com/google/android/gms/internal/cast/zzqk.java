package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
final class zzqk {
    private static final zzqj zza;
    private static final zzqj zzb;

    static {
        zzqj zzqjVar;
        try {
            zzqjVar = (zzqj) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzqjVar = null;
        }
        zza = zzqjVar;
        zzb = new zzqj();
    }

    public static zzqj zza() {
        return zza;
    }

    public static zzqj zzb() {
        return zzb;
    }
}
