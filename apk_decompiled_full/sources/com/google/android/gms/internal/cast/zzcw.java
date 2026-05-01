package com.google.android.gms.internal.cast;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
final class zzcw extends zzcy {
    private final Handler zza;

    public zzcw(Looper looper) {
        this.zza = new Handler(looper);
    }

    @Override // com.google.android.gms.internal.cast.zzcy
    public final void zza(zzcv zzcvVar) {
        this.zza.postDelayed(zzcvVar.zzc(), 0L);
    }
}
