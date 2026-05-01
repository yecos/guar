package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* loaded from: classes.dex */
final class zzms implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzmt zzb;

    public zzms(zzmt zzmtVar) {
        zzku zzkuVar;
        this.zzb = zzmtVar;
        zzkuVar = zzmtVar.zza;
        this.zza = zzkuVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
