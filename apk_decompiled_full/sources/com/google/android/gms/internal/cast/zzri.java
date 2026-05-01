package com.google.android.gms.internal.cast;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class zzri extends AbstractList<String> implements RandomAccess, zzpo {
    private final zzpo zza;

    public zzri(zzpo zzpoVar) {
        this.zza = zzpoVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i10) {
        return ((zzpn) this.zza).get(i10);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new zzrh(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i10) {
        return new zzrg(this, i10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.cast.zzpo
    public final zzpo zzd() {
        return this;
    }

    @Override // com.google.android.gms.internal.cast.zzpo
    public final Object zze(int i10) {
        return this.zza.zze(i10);
    }

    @Override // com.google.android.gms.internal.cast.zzpo
    public final List<?> zzh() {
        return this.zza.zzh();
    }
}
