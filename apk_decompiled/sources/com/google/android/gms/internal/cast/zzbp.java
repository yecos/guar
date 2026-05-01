package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.framework.media.uicontroller.UIController;

/* loaded from: classes.dex */
public abstract class zzbp extends UIController {
    private boolean zza = true;

    public void zza(boolean z10) {
        this.zza = z10;
    }

    public abstract void zzb(long j10);

    public final boolean zzc() {
        return this.zza;
    }
}
