package com.google.android.gms.internal.measurement;

import android.os.Bundle;

/* loaded from: classes.dex */
final class zzdv extends zzch {
    private final com.google.android.gms.measurement.internal.zzgr zza;

    public zzdv(com.google.android.gms.measurement.internal.zzgr zzgrVar) {
        this.zza = zzgrVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzci
    public final int zzd() {
        return System.identityHashCode(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzci
    public final void zze(String str, String str2, Bundle bundle, long j10) {
        this.zza.interceptEvent(str, str2, bundle, j10);
    }
}
