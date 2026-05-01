package com.google.android.gms.cast;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
final class zzbz {
    private final Map<String, String> zza = new HashMap();
    private final Map<String, String> zzb = new HashMap();
    private final Map<String, Integer> zzc = new HashMap();

    public final int zza(String str) {
        Integer num = this.zzc.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final zzbz zzb(String str, String str2, int i10) {
        this.zza.put(str, str2);
        this.zzb.put(str2, str);
        this.zzc.put(str, Integer.valueOf(i10));
        return this;
    }

    public final String zzc(String str) {
        return this.zza.get(str);
    }

    public final String zzd(String str) {
        return this.zzb.get(str);
    }
}
