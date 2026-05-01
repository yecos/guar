package com.google.android.gms.cast.internal;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import java.util.Map;

/* loaded from: classes.dex */
final class zzu implements Runnable {
    final /* synthetic */ zzw zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;

    public zzu(zzv zzvVar, zzw zzwVar, String str, String str2) {
        this.zza = zzwVar;
        this.zzb = str;
        this.zzc = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Map map;
        Map map2;
        Cast.MessageReceivedCallback messageReceivedCallback;
        Logger logger;
        CastDevice castDevice;
        map = this.zza.zzk;
        synchronized (map) {
            map2 = this.zza.zzk;
            messageReceivedCallback = (Cast.MessageReceivedCallback) map2.get(this.zzb);
        }
        if (messageReceivedCallback != null) {
            castDevice = this.zza.zzi;
            messageReceivedCallback.onMessageReceived(castDevice, this.zzb, this.zzc);
        } else {
            logger = zzw.zze;
            logger.d("Discarded message for unknown namespace '%s'", this.zzb);
        }
    }
}
