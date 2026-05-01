package com.google.android.gms.internal.cast;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
final class zzqm {
    private static final zzqm zza = new zzqm();
    private final ConcurrentMap<Class<?>, zzqp<?>> zzc = new ConcurrentHashMap();
    private final zzqq zzb = new zzpw();

    private zzqm() {
    }

    public static zzqm zza() {
        return zza;
    }

    public final <T> zzqp<T> zzb(Class<T> cls) {
        zzph.zzf(cls, "messageType");
        zzqp<T> zzqpVar = (zzqp) this.zzc.get(cls);
        if (zzqpVar == null) {
            zzqpVar = this.zzb.zza(cls);
            zzph.zzf(cls, "messageType");
            zzph.zzf(zzqpVar, "schema");
            zzqp<T> zzqpVar2 = (zzqp) this.zzc.putIfAbsent(cls, zzqpVar);
            if (zzqpVar2 != null) {
                return zzqpVar2;
            }
        }
        return zzqpVar;
    }
}
