package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class zzz extends zzab {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ CastRemoteDisplayClient zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzz(CastRemoteDisplayClient castRemoteDisplayClient, TaskCompletionSource taskCompletionSource) {
        super(null);
        this.zzb = castRemoteDisplayClient;
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.cast.zzab, com.google.android.gms.internal.cast.zzcj
    public final void zzd(int i10) {
        Logger logger;
        logger = this.zzb.zzc;
        logger.d("onError: %d", Integer.valueOf(i10));
        CastRemoteDisplayClient.zzd(this.zzb);
        TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, this.zza);
    }

    @Override // com.google.android.gms.cast.zzab, com.google.android.gms.internal.cast.zzcj
    public final void zzf() {
        Logger logger;
        logger = this.zzb.zzc;
        logger.d("onDisconnected", new Object[0]);
        CastRemoteDisplayClient.zzd(this.zzb);
        TaskUtil.setResultOrApiException(Status.RESULT_SUCCESS, this.zza);
    }
}
