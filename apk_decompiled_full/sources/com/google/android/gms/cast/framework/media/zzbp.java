package com.google.android.gms.cast.framework.media;

import android.os.Handler;
import java.util.TimerTask;

/* loaded from: classes.dex */
final class zzbp extends TimerTask {
    final /* synthetic */ RemoteMediaClient zza;
    final /* synthetic */ zzbq zzb;

    public zzbp(zzbq zzbqVar, RemoteMediaClient remoteMediaClient) {
        this.zzb = zzbqVar;
        this.zza = remoteMediaClient;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Handler handler;
        long j10;
        zzbq zzbqVar = this.zzb;
        zzbqVar.zza.zzr(zzbqVar.zzb);
        handler = this.zzb.zza.zzc;
        j10 = this.zzb.zzc;
        handler.postDelayed(this, j10);
    }
}
