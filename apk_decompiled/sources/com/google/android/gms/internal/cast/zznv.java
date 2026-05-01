package com.google.android.gms.internal.cast;

import java.util.NoSuchElementException;

/* loaded from: classes.dex */
final class zznv extends zzny {
    final /* synthetic */ zzoe zza;
    private int zzb = 0;
    private final int zzc;

    public zznv(zzoe zzoeVar) {
        this.zza = zzoeVar;
        this.zzc = zzoeVar.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // com.google.android.gms.internal.cast.zzoa
    public final byte zza() {
        int i10 = this.zzb;
        if (i10 >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = i10 + 1;
        return this.zza.zzb(i10);
    }
}
