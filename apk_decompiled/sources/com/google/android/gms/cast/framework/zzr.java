package com.google.android.gms.cast.framework;

import android.os.RemoteException;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.dynamic.IObjectWrapper;

@ShowFirstParty
/* loaded from: classes.dex */
public final class zzr {
    private static final Logger zza = new Logger("DiscoveryManager");
    private final zzad zzb;

    public zzr(zzad zzadVar) {
        this.zzb = zzadVar;
    }

    public final IObjectWrapper zza() {
        try {
            return this.zzb.zze();
        } catch (RemoteException e10) {
            zza.d(e10, "Unable to call %s on %s.", "getWrappedThis", zzad.class.getSimpleName());
            return null;
        }
    }
}
