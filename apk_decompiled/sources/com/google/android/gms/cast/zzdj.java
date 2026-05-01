package com.google.android.gms.cast;

import android.util.Log;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
final class zzdj implements com.google.android.gms.cast.internal.zzar {
    final /* synthetic */ zzdl zza;

    public zzdj(zzdl zzdlVar) {
        this.zza = zzdlVar;
    }

    @Override // com.google.android.gms.cast.internal.zzar
    public final void zza(long j10, int i10, Object obj) {
        if (true != (obj instanceof com.google.android.gms.cast.internal.zzao)) {
            obj = null;
        }
        try {
            this.zza.setResult((zzdl) new zzdm(new Status(i10), obj != null ? ((com.google.android.gms.cast.internal.zzao) obj).zza : null));
        } catch (IllegalStateException e10) {
            Log.e("RemoteMediaPlayer", "Result already set when calling onRequestCompleted", e10);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzar
    public final void zzb(long j10) {
        try {
            zzdl zzdlVar = this.zza;
            zzdlVar.setResult((zzdl) new zzdk(zzdlVar, new Status(2103)));
        } catch (IllegalStateException e10) {
            Log.e("RemoteMediaPlayer", "Result already set when calling onRequestReplaced", e10);
        }
    }
}
