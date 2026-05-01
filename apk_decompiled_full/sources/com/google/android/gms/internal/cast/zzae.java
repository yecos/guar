package com.google.android.gms.internal.cast;

import android.os.RemoteException;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import n0.t0;

/* loaded from: classes.dex */
public final class zzae extends t0.b {
    private static final Logger zza = new Logger("MediaRouterCallback");
    private final zzu zzb;

    public zzae(zzu zzuVar) {
        this.zzb = (zzu) Preconditions.checkNotNull(zzuVar);
    }

    @Override // n0.t0.b
    public final void onRouteAdded(t0 t0Var, t0.i iVar) {
        try {
            this.zzb.zze(iVar.k(), iVar.i());
        } catch (RemoteException e10) {
            zza.d(e10, "Unable to call %s on %s.", "onRouteAdded", zzu.class.getSimpleName());
        }
    }

    @Override // n0.t0.b
    public final void onRouteChanged(t0 t0Var, t0.i iVar) {
        try {
            this.zzb.zzf(iVar.k(), iVar.i());
        } catch (RemoteException e10) {
            zza.d(e10, "Unable to call %s on %s.", "onRouteChanged", zzu.class.getSimpleName());
        }
    }

    @Override // n0.t0.b
    public final void onRouteRemoved(t0 t0Var, t0.i iVar) {
        try {
            this.zzb.zzg(iVar.k(), iVar.i());
        } catch (RemoteException e10) {
            zza.d(e10, "Unable to call %s on %s.", "onRouteRemoved", zzu.class.getSimpleName());
        }
    }

    @Override // n0.t0.b
    public final void onRouteSelected(t0 t0Var, t0.i iVar, int i10) {
        if (iVar.o() != 1) {
            return;
        }
        try {
            this.zzb.zzh(iVar.k(), iVar.i());
        } catch (RemoteException e10) {
            zza.d(e10, "Unable to call %s on %s.", "onRouteSelected", zzu.class.getSimpleName());
        }
    }

    @Override // n0.t0.b
    public final void onRouteUnselected(t0 t0Var, t0.i iVar, int i10) {
        if (iVar.o() != 1) {
            return;
        }
        try {
            this.zzb.zzi(iVar.k(), iVar.i(), i10);
        } catch (RemoteException e10) {
            zza.d(e10, "Unable to call %s on %s.", "onRouteUnselected", zzu.class.getSimpleName());
        }
    }
}
