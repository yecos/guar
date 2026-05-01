package com.google.android.gms.measurement.internal;

import androidx.collection.e;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
final class zzff extends e {
    final /* synthetic */ zzfi zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzff(zzfi zzfiVar, int i10) {
        super(20);
        this.zza = zzfiVar;
    }

    @Override // androidx.collection.e
    public final /* bridge */ /* synthetic */ Object create(Object obj) {
        String str = (String) obj;
        Preconditions.checkNotEmpty(str);
        return zzfi.zzd(this.zza, str);
    }
}
