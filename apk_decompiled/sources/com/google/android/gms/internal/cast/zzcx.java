package com.google.android.gms.internal.cast;

import android.view.Choreographer;

/* loaded from: classes.dex */
final class zzcx extends zzcy {
    private final Choreographer zza = Choreographer.getInstance();

    @Override // com.google.android.gms.internal.cast.zzcy
    public final void zza(zzcv zzcvVar) {
        this.zza.postFrameCallback(zzcvVar.zzb());
    }
}
