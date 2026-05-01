package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
final class zzls {
    private static final zzlr zza;
    private static final zzlr zzb;

    static {
        zzlr zzlrVar;
        try {
            zzlrVar = (zzlr) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzlrVar = null;
        }
        zza = zzlrVar;
        zzb = new zzlr();
    }

    public static zzlr zza() {
        return zza;
    }

    public static zzlr zzb() {
        return zzb;
    }
}
