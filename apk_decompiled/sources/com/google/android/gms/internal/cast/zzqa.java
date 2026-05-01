package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
final class zzqa {
    private static final zzpz zza;
    private static final zzpz zzb;

    static {
        zzpz zzpzVar;
        try {
            zzpzVar = (zzpz) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzpzVar = null;
        }
        zza = zzpzVar;
        zzb = new zzpz();
    }

    public static zzpz zza() {
        return zza;
    }

    public static zzpz zzb() {
        return zzb;
    }
}
