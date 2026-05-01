package com.google.android.gms.cast.internal;

import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.IOException;

/* loaded from: classes.dex */
final class zzak implements zzar {
    final /* synthetic */ zzap zza;

    public zzak(zzap zzapVar) {
        this.zza = zzapVar;
    }

    @Override // com.google.android.gms.cast.internal.zzar
    public final void zza(long j10, int i10, Object obj) {
        TaskCompletionSource taskCompletionSource;
        if (i10 != 0) {
            taskCompletionSource = this.zza.zzB;
            taskCompletionSource.setException(new IOException("storing session is timeout"));
        }
    }

    @Override // com.google.android.gms.cast.internal.zzar
    public final void zzb(long j10) {
        TaskCompletionSource taskCompletionSource;
        taskCompletionSource = this.zza.zzB;
        taskCompletionSource.setResult(null);
    }
}
