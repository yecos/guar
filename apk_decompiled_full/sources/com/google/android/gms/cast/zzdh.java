package com.google.android.gms.cast;

import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
final class zzdh implements ResultCallback<Status> {
    final /* synthetic */ zzdi zza;
    private final long zzb;

    public zzdh(zzdi zzdiVar, long j10) {
        this.zza = zzdiVar;
        this.zzb = j10;
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final /* bridge */ /* synthetic */ void onResult(Status status) {
        com.google.android.gms.cast.internal.zzap zzapVar;
        Status status2 = status;
        if (status2.isSuccess()) {
            return;
        }
        zzapVar = this.zza.zza.zzb;
        zzapVar.zzR(this.zzb, status2.getStatusCode());
    }
}
