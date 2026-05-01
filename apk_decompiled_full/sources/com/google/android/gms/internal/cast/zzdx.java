package com.google.android.gms.internal.cast;

import com.google.firebase.analytics.FirebaseAnalytics;

/* loaded from: classes.dex */
final class zzdx<E> extends zzdu<E> {
    static final zzdu<Object> zza = new zzdx(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    public zzdx(Object[] objArr, int i10) {
        this.zzb = objArr;
        this.zzc = i10;
    }

    @Override // java.util.List
    public final E get(int i10) {
        zzdj.zza(i10, this.zzc, FirebaseAnalytics.Param.INDEX);
        E e10 = (E) this.zzb[i10];
        e10.getClass();
        return e10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.cast.zzdu, com.google.android.gms.internal.cast.zzdq
    public final int zza(Object[] objArr, int i10) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.cast.zzdq
    public final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.cast.zzdq
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.cast.zzdq
    public final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.cast.zzdq
    public final Object[] zzg() {
        return this.zzb;
    }
}
