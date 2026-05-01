package com.google.android.gms.measurement.internal;

import android.util.Log;

/* loaded from: classes.dex */
final class zzgt implements zzeb {
    final /* synthetic */ zzfr zza;

    public zzgt(zzgu zzguVar, zzfr zzfrVar) {
        this.zza = zzfrVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzeb
    public final boolean zza() {
        return this.zza.zzL() && Log.isLoggable(this.zza.zzay().zzq(), 3);
    }
}
