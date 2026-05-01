package com.google.android.gms.cast;

/* loaded from: classes.dex */
final class zzad implements Runnable {
    final /* synthetic */ CastRemoteDisplayLocalService zza;

    public zzad(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
        this.zza = castRemoteDisplayLocalService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z10;
        boolean z11;
        CastRemoteDisplayLocalService castRemoteDisplayLocalService = this.zza;
        z10 = castRemoteDisplayLocalService.zzs;
        StringBuilder sb = new StringBuilder(59);
        sb.append("onCreate after delay. The local service been started: ");
        sb.append(z10);
        castRemoteDisplayLocalService.zzv(sb.toString());
        z11 = this.zza.zzs;
        if (z11) {
            return;
        }
        CastRemoteDisplayLocalService.zza.e("[Instance: %s] %s", this.zza, "The local service has not been been started, stopping it");
        this.zza.stopSelf();
    }
}
