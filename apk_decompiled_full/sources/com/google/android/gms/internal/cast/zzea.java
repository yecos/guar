package com.google.android.gms.internal.cast;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
final class zzea<K> extends zzdw<K> {
    private final transient zzdv<K, ?> zza;
    private final transient zzdu<K> zzb;

    public zzea(zzdv<K, ?> zzdvVar, zzdu<K> zzduVar) {
        this.zza = zzdvVar;
        this.zzb = zzduVar;
    }

    @Override // com.google.android.gms.internal.cast.zzdq, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        return false;
    }

    @Override // com.google.android.gms.internal.cast.zzdw, com.google.android.gms.internal.cast.zzdq, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 0;
    }

    @Override // com.google.android.gms.internal.cast.zzdq
    public final int zza(Object[] objArr, int i10) {
        return this.zzb.zza(objArr, 0);
    }

    @Override // com.google.android.gms.internal.cast.zzdw, com.google.android.gms.internal.cast.zzdq
    public final zzdu<K> zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.cast.zzdw, com.google.android.gms.internal.cast.zzdq
    /* renamed from: zze */
    public final zzee<K> iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // com.google.android.gms.internal.cast.zzdq
    public final boolean zzf() {
        throw null;
    }
}
