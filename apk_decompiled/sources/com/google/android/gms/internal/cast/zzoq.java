package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
final class zzoq {
    private static final zzoo<?> zza = new zzop();
    private static final zzoo<?> zzb;

    static {
        zzoo<?> zzooVar;
        try {
            zzooVar = (zzoo) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzooVar = null;
        }
        zzb = zzooVar;
    }

    public static zzoo<?> zza() {
        zzoo<?> zzooVar = zzb;
        if (zzooVar != null) {
            return zzooVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static zzoo<?> zzb() {
        return zza;
    }
}
