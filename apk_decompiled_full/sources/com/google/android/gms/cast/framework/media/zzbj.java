package com.google.android.gms.cast.framework.media;

import android.util.Log;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
final class zzbj implements com.google.android.gms.cast.internal.zzar {
    final /* synthetic */ zzbl zza;

    public zzbj(zzbl zzblVar) {
        this.zza = zzblVar;
    }

    @Override // com.google.android.gms.cast.internal.zzar
    public final void zza(long j10, int i10, Object obj) {
        if (true != (obj instanceof com.google.android.gms.cast.internal.zzao)) {
            obj = null;
        }
        try {
            this.zza.setResult(new zzbm(new Status(i10), obj != null ? ((com.google.android.gms.cast.internal.zzao) obj).zza : null, obj != null ? ((com.google.android.gms.cast.internal.zzao) obj).zzb : null));
        } catch (IllegalStateException e10) {
            Log.e("RemoteMediaClient", "Result already set when calling onRequestCompleted", e10);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzar
    public final void zzb(long j10) {
        try {
            zzbl zzblVar = this.zza;
            zzblVar.setResult(new zzbk(zzblVar, new Status(2103)));
        } catch (IllegalStateException e10) {
            Log.e("RemoteMediaClient", "Result already set when calling onRequestReplaced", e10);
        }
    }
}
