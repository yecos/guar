package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.CastRemoteDisplay;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
final class zzcg extends zzcl {
    final /* synthetic */ zzcm zza;
    final /* synthetic */ zzch zzb;

    public zzcg(zzch zzchVar, zzcm zzcmVar) {
        this.zzb = zzchVar;
        this.zza = zzcmVar;
    }

    @Override // com.google.android.gms.internal.cast.zzcm
    public final void zzb(int i10) {
        Logger logger;
        CastRemoteDisplay.CastRemoteDisplaySessionCallbacks castRemoteDisplaySessionCallbacks;
        CastRemoteDisplay.CastRemoteDisplaySessionCallbacks castRemoteDisplaySessionCallbacks2;
        logger = zzch.zze;
        logger.d("onRemoteDisplayEnded", new Object[0]);
        zzcm zzcmVar = this.zza;
        if (zzcmVar != null) {
            zzcmVar.zzb(i10);
        }
        castRemoteDisplaySessionCallbacks = this.zzb.zzf;
        if (castRemoteDisplaySessionCallbacks != null) {
            castRemoteDisplaySessionCallbacks2 = this.zzb.zzf;
            castRemoteDisplaySessionCallbacks2.onRemoteDisplayEnded(new Status(i10));
        }
    }
}
