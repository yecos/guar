package com.google.android.gms.internal.cast;

import java.util.Iterator;

/* loaded from: classes.dex */
final class zzrh implements Iterator<String> {
    final Iterator<String> zza;
    final /* synthetic */ zzri zzb;

    public zzrh(zzri zzriVar) {
        zzpo zzpoVar;
        this.zzb = zzriVar;
        zzpoVar = zzriVar.zza;
        this.zza = zzpoVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ String next() {
        return this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
