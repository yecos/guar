package com.google.android.gms.internal.cast;

import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
final class zzdz<K, V> extends zzdw<Map.Entry<K, V>> {
    private final transient zzdv<K, V> zza;
    private final transient Object[] zzb;

    public zzdz(zzdv<K, V> zzdvVar, Object[] objArr, int i10, int i11) {
        this.zza = zzdvVar;
        this.zzb = objArr;
    }

    @Override // com.google.android.gms.internal.cast.zzdq, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(null)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.cast.zzdw, com.google.android.gms.internal.cast.zzdq, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zzd().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 0;
    }

    @Override // com.google.android.gms.internal.cast.zzdq
    public final int zza(Object[] objArr, int i10) {
        return zzd().zza(objArr, 0);
    }

    @Override // com.google.android.gms.internal.cast.zzdw, com.google.android.gms.internal.cast.zzdq
    /* renamed from: zze */
    public final zzee<Map.Entry<K, V>> iterator() {
        return zzd().listIterator(0);
    }

    @Override // com.google.android.gms.internal.cast.zzdq
    public final boolean zzf() {
        throw null;
    }

    @Override // com.google.android.gms.internal.cast.zzdw
    public final zzdu<Map.Entry<K, V>> zzh() {
        return new zzdy(this);
    }
}
