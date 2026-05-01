package com.google.android.gms.internal.cast;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
final class zzdt extends zzdu {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzdu zzc;

    public zzdt(zzdu zzduVar, int i10, int i11) {
        this.zzc = zzduVar;
        this.zza = i10;
        this.zzb = i11;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        zzdj.zza(i10, this.zzb, FirebaseAnalytics.Param.INDEX);
        return this.zzc.get(i10 + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.cast.zzdu, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i10, int i11) {
        return subList(i10, i11);
    }

    @Override // com.google.android.gms.internal.cast.zzdq
    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.cast.zzdq
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.cast.zzdq
    public final boolean zzf() {
        return true;
    }

    @Override // com.google.android.gms.internal.cast.zzdq
    @CheckForNull
    public final Object[] zzg() {
        return this.zzc.zzg();
    }

    @Override // com.google.android.gms.internal.cast.zzdu
    /* renamed from: zzh */
    public final zzdu subList(int i10, int i11) {
        zzdj.zzd(i10, i11, this.zzb);
        zzdu zzduVar = this.zzc;
        int i12 = this.zza;
        return zzduVar.subList(i10 + i12, i11 + i12);
    }
}
