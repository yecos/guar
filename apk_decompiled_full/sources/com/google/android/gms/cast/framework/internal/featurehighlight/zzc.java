package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.view.View;

/* loaded from: classes.dex */
final class zzc implements View.OnLayoutChangeListener {
    final /* synthetic */ zzh zza;

    public zzc(zzh zzhVar, Runnable runnable) {
        this.zza = zzhVar;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        this.zza.zzm();
        this.zza.removeOnLayoutChangeListener(this);
    }
}
