package com.google.android.gms.measurement.internal;

import java.util.Map;

/* loaded from: classes.dex */
final class zzfh implements com.google.android.gms.internal.measurement.zzo {
    final /* synthetic */ String zza;
    final /* synthetic */ zzfi zzb;

    public zzfh(zzfi zzfiVar, String str) {
        this.zzb = zzfiVar;
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.measurement.zzo
    public final String zza(String str) {
        Map map;
        map = this.zzb.zzg;
        Map map2 = (Map) map.get(this.zza);
        if (map2 == null || !map2.containsKey(str)) {
            return null;
        }
        return (String) map2.get(str);
    }
}
