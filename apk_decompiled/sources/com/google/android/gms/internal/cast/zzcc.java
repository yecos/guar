package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.CastRemoteDisplay;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes.dex */
class zzcc extends BaseImplementation.ApiMethodImpl<CastRemoteDisplay.CastRemoteDisplaySessionResult, zzch> {
    final /* synthetic */ zzce zzc;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzcc(com.google.android.gms.internal.cast.zzce r1, com.google.android.gms.common.api.GoogleApiClient r2) {
        /*
            r0 = this;
            r0.zzc = r1
            com.google.android.gms.common.api.Api r1 = com.google.android.gms.internal.cast.zzce.zzd(r1)
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzcc.<init>(com.google.android.gms.internal.cast.zzce, com.google.android.gms.common.api.GoogleApiClient):void");
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        return new zzcd(status);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl, com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    @KeepForSdk
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((zzcc) obj);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    @VisibleForTesting
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public void doExecute(zzch zzchVar) {
        throw null;
    }
}
