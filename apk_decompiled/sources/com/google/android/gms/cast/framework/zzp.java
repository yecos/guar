package com.google.android.gms.cast.framework;

import android.os.RemoteException;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.ConnectionResult;

/* loaded from: classes.dex */
final class zzp extends com.google.android.gms.cast.zzq {
    final /* synthetic */ CastSession zza;

    public /* synthetic */ zzp(CastSession castSession, zzo zzoVar) {
        this.zza = castSession;
    }

    @Override // com.google.android.gms.cast.zzq
    public final void zza() {
        zzz zzzVar;
        Logger logger;
        RemoteMediaClient remoteMediaClient;
        zzz zzzVar2;
        RemoteMediaClient remoteMediaClient2;
        zzzVar = this.zza.zze;
        if (zzzVar == null) {
            return;
        }
        try {
            remoteMediaClient = this.zza.zzi;
            if (remoteMediaClient != null) {
                remoteMediaClient2 = this.zza.zzi;
                remoteMediaClient2.zzn();
            }
            zzzVar2 = this.zza.zze;
            zzzVar2.zzh(null);
        } catch (RemoteException e10) {
            logger = CastSession.zzb;
            logger.d(e10, "Unable to call %s on %s.", "onConnected", zzz.class.getSimpleName());
        }
    }

    @Override // com.google.android.gms.cast.zzq
    public final void zzb(int i10) {
        zzz zzzVar;
        Logger logger;
        zzz zzzVar2;
        zzzVar = this.zza.zze;
        if (zzzVar == null) {
            return;
        }
        try {
            zzzVar2 = this.zza.zze;
            zzzVar2.zzi(new ConnectionResult(i10));
        } catch (RemoteException e10) {
            logger = CastSession.zzb;
            logger.d(e10, "Unable to call %s on %s.", "onConnectionFailed", zzz.class.getSimpleName());
        }
    }

    @Override // com.google.android.gms.cast.zzq
    public final void zzc(int i10) {
        zzz zzzVar;
        Logger logger;
        zzz zzzVar2;
        zzzVar = this.zza.zze;
        if (zzzVar == null) {
            return;
        }
        try {
            zzzVar2 = this.zza.zze;
            zzzVar2.zzj(i10);
        } catch (RemoteException e10) {
            logger = CastSession.zzb;
            logger.d(e10, "Unable to call %s on %s.", "onConnectionSuspended", zzz.class.getSimpleName());
        }
    }

    @Override // com.google.android.gms.cast.zzq
    public final void zzd(int i10) {
        zzz zzzVar;
        Logger logger;
        zzz zzzVar2;
        zzzVar = this.zza.zze;
        if (zzzVar == null) {
            return;
        }
        try {
            zzzVar2 = this.zza.zze;
            zzzVar2.zzi(new ConnectionResult(i10));
        } catch (RemoteException e10) {
            logger = CastSession.zzb;
            logger.d(e10, "Unable to call %s on %s.", "onDisconnected", zzz.class.getSimpleName());
        }
    }
}
