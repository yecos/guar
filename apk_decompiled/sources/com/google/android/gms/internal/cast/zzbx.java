package com.google.android.gms.internal.cast;

import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes.dex */
final class zzbx extends zzcc {
    final /* synthetic */ String zza;
    final /* synthetic */ zzce zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbx(zzce zzceVar, GoogleApiClient googleApiClient, String str) {
        super(zzceVar, googleApiClient);
        this.zzb = zzceVar;
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.cast.zzcc, com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(zzch zzchVar) {
        doExecute(zzchVar);
    }

    @Override // com.google.android.gms.internal.cast.zzcc
    /* renamed from: zza */
    public final void doExecute(zzch zzchVar) {
        zzcm zzcmVar;
        zzca zzcaVar = new zzca(this, zzchVar);
        zzcmVar = this.zzb.zzd;
        zzchVar.zzr(zzcaVar, zzcmVar, this.zza);
    }
}
