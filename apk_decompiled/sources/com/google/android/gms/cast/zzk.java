package com.google.android.gms.cast;

import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes.dex */
final class zzk extends com.google.android.gms.cast.internal.zzab {
    public zzk(zzm zzmVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.cast.internal.zzab, com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(com.google.android.gms.cast.internal.zzw zzwVar) {
        doExecute(zzwVar);
    }

    @Override // com.google.android.gms.cast.internal.zzab
    /* renamed from: zza */
    public final void doExecute(com.google.android.gms.cast.internal.zzw zzwVar) {
        try {
            zzwVar.zzV("", this);
        } catch (IllegalStateException unused) {
            zzc(CastStatusCodes.INVALID_REQUEST);
        }
    }
}
