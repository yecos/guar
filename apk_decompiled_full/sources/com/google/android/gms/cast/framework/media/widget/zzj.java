package com.google.android.gms.cast.framework.media.widget;

/* loaded from: classes.dex */
final class zzj implements Runnable {
    final /* synthetic */ zzk zza;

    public zzj(zzk zzkVar) {
        this.zza = zzkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzk zzkVar = this.zza;
        zzkVar.zzb.zzo(zzkVar.zza);
    }
}
