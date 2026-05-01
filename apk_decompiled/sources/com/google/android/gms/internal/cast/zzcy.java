package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
public abstract class zzcy {
    private static final ThreadLocal<zzcy> zza = new zzcs();

    public static zzcy zzb() {
        return zza.get();
    }

    public abstract void zza(zzcv zzcvVar);
}
