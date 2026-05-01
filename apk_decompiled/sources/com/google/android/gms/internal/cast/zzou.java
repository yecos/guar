package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
final class zzou implements zzqc {
    private static final zzou zza = new zzou();

    private zzou() {
    }

    public static zzou zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.cast.zzqc
    public final zzqb zzb(Class<?> cls) {
        if (!zzoy.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            throw new IllegalArgumentException(name.length() != 0 ? "Unsupported message type: ".concat(name) : new String("Unsupported message type: "));
        }
        try {
            return (zzqb) zzoy.zzt(cls.asSubclass(zzoy.class)).zzb(3, null, null);
        } catch (Exception e10) {
            String name2 = cls.getName();
            throw new RuntimeException(name2.length() != 0 ? "Unable to get message info for ".concat(name2) : new String("Unable to get message info for "), e10);
        }
    }

    @Override // com.google.android.gms.internal.cast.zzqc
    public final boolean zzc(Class<?> cls) {
        return zzoy.class.isAssignableFrom(cls);
    }
}
