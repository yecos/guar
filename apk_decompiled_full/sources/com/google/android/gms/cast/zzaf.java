package com.google.android.gms.cast;

/* loaded from: classes.dex */
final class zzaf implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ CastRemoteDisplayLocalService zzb;

    public zzaf(CastRemoteDisplayLocalService castRemoteDisplayLocalService, boolean z10) {
        this.zzb = castRemoteDisplayLocalService;
        this.zza = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzx(this.zza);
    }
}
