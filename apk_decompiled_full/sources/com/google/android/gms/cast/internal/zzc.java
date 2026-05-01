package com.google.android.gms.cast.internal;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastStatusCodes;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* loaded from: classes.dex */
public abstract class zzc<R extends Result> extends BaseImplementation.ApiMethodImpl<R, zzw> {
    public zzc(GoogleApiClient googleApiClient) {
        super(Cast.API, googleApiClient);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl, com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    @KeepForSdk
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((zzc<R>) obj);
    }

    public final void zzc(int i10) {
        setResult((zzc<R>) createFailedResult(new Status(CastStatusCodes.INVALID_REQUEST)));
    }
}
