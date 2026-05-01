package com.google.android.gms.cast;

import n0.t0;

/* loaded from: classes.dex */
final class zzac extends t0.b {
    final /* synthetic */ CastRemoteDisplayLocalService zza;

    public zzac(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
        this.zza = castRemoteDisplayLocalService;
    }

    @Override // n0.t0.b
    public final void onRouteUnselected(t0 t0Var, t0.i iVar) {
        CastDevice castDevice;
        CastDevice castDevice2;
        this.zza.zzv("onRouteUnselected");
        castDevice = this.zza.zzm;
        if (castDevice == null) {
            this.zza.zzv("onRouteUnselected, no device was selected");
            return;
        }
        CastDevice fromBundle = CastDevice.getFromBundle(iVar.i());
        if (fromBundle != null) {
            String deviceId = fromBundle.getDeviceId();
            castDevice2 = this.zza.zzm;
            if (deviceId.equals(castDevice2.getDeviceId())) {
                CastRemoteDisplayLocalService.stopService();
                return;
            }
        }
        this.zza.zzv("onRouteUnselected, device does not match");
    }
}
