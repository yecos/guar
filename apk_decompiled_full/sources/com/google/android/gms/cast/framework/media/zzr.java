package com.google.android.gms.cast.framework.media;

import java.util.TimerTask;

/* loaded from: classes.dex */
final class zzr extends TimerTask {
    final /* synthetic */ MediaQueue zza;

    public zzr(MediaQueue mediaQueue) {
        this.zza = mediaQueue;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        MediaQueue.zzj(this.zza);
    }
}
