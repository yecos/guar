package com.google.android.gms.internal.cast;

import java.util.Map;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
final class zzec<K, V> extends zzdv<K, V> {
    static final zzdv<Object, Object> zza = new zzec(null, new Object[0], 0);
    final transient Object[] zzb;

    private zzec(@CheckForNull Object obj, Object[] objArr, int i10) {
        this.zzb = objArr;
    }

    @Override // java.util.Map
    @CheckForNull
    public final V get(@CheckForNull Object obj) {
        return null;
    }

    @Override // java.util.Map
    public final int size() {
        return 0;
    }

    @Override // com.google.android.gms.internal.cast.zzdv
    public final zzdq<V> zza() {
        return new zzeb(this.zzb, 1, 0);
    }

    @Override // com.google.android.gms.internal.cast.zzdv
    public final zzdw<Map.Entry<K, V>> zzd() {
        return new zzdz(this, this.zzb, 0, 0);
    }

    @Override // com.google.android.gms.internal.cast.zzdv
    public final zzdw<K> zze() {
        return new zzea(this, new zzeb(this.zzb, 0, 0));
    }
}
