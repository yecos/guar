package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.Cast;

/* loaded from: classes.dex */
final class zzbd extends Cast.Listener {
    final /* synthetic */ zzbe zza;

    public zzbd(zzbe zzbeVar) {
        this.zza = zzbeVar;
    }

    @Override // com.google.android.gms.cast.Cast.Listener
    public final void onVolumeChanged() {
        this.zza.zza();
    }
}
