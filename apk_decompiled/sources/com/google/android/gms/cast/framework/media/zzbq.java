package com.google.android.gms.cast.framework.media;

import android.os.Handler;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
final class zzbq {
    final /* synthetic */ RemoteMediaClient zza;
    private final Set<RemoteMediaClient.ProgressListener> zzb = new HashSet();
    private final long zzc;
    private final Runnable zzd;
    private boolean zze;

    public zzbq(RemoteMediaClient remoteMediaClient, long j10) {
        this.zza = remoteMediaClient;
        this.zzc = j10;
        this.zzd = new zzbp(this, remoteMediaClient);
    }

    public final long zzb() {
        return this.zzc;
    }

    public final void zzd(RemoteMediaClient.ProgressListener progressListener) {
        this.zzb.add(progressListener);
    }

    public final void zze(RemoteMediaClient.ProgressListener progressListener) {
        this.zzb.remove(progressListener);
    }

    public final void zzf() {
        Handler handler;
        Handler handler2;
        handler = this.zza.zzc;
        handler.removeCallbacks(this.zzd);
        this.zze = true;
        handler2 = this.zza.zzc;
        handler2.postDelayed(this.zzd, this.zzc);
    }

    public final void zzg() {
        Handler handler;
        handler = this.zza.zzc;
        handler.removeCallbacks(this.zzd);
        this.zze = false;
    }

    public final boolean zzh() {
        return !this.zzb.isEmpty();
    }

    public final boolean zzi() {
        return this.zze;
    }
}
