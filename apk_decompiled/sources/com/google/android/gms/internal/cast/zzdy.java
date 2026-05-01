package com.google.android.gms.internal.cast;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;
import java.util.Map;

/* loaded from: classes.dex */
final class zzdy extends zzdu<Map.Entry> {
    final /* synthetic */ zzdz zza;

    public zzdy(zzdz zzdzVar) {
        this.zza = zzdzVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i10) {
        Object[] objArr;
        Object[] objArr2;
        zzdj.zza(i10, 0, FirebaseAnalytics.Param.INDEX);
        int i11 = i10 + i10;
        objArr = this.zza.zzb;
        Object obj = objArr[i11];
        obj.getClass();
        objArr2 = this.zza.zzb;
        Object obj2 = objArr2[i11 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return 0;
    }

    @Override // com.google.android.gms.internal.cast.zzdq
    public final boolean zzf() {
        return true;
    }
}
