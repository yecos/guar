package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* loaded from: classes.dex */
final class zzam<R extends Result> extends BasePendingResult<R> {
    private final zzan<R, Status> zza;

    public zzam(zzan<R, Status> zzanVar) {
        super((GoogleApiClient) null);
        this.zza = zzanVar;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final R createFailedResult(Status status) {
        int i10 = CastSession.zza;
        return status;
    }
}
