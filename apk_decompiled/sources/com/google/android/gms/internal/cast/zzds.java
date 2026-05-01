package com.google.android.gms.internal.cast;

/* loaded from: classes.dex */
final class zzds<E> extends zzdn<E> {
    private final zzdu<E> zza;

    public zzds(zzdu<E> zzduVar, int i10) {
        super(zzduVar.size(), i10);
        this.zza = zzduVar;
    }

    @Override // com.google.android.gms.internal.cast.zzdn
    public final E zza(int i10) {
        return this.zza.get(i10);
    }
}
