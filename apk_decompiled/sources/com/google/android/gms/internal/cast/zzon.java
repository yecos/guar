package com.google.android.gms.internal.cast;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzon {
    static final zzon zza = new zzon(true);
    private static volatile boolean zzb = false;
    private static volatile zzon zzc;
    private final Map zzd;

    public zzon() {
        this.zzd = new HashMap();
    }

    public static zzon zza() {
        zzon zzonVar = zzc;
        if (zzonVar == null) {
            synchronized (zzon.class) {
                zzonVar = zzc;
                if (zzonVar == null) {
                    zzonVar = zza;
                    zzc = zzonVar;
                }
            }
        }
        return zzonVar;
    }

    public zzon(boolean z10) {
        this.zzd = Collections.emptyMap();
    }
}
