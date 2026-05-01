package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* loaded from: classes.dex */
final class zzd extends AnimatorListenerAdapter {
    final /* synthetic */ zzh zza;

    public zzd(zzh zzhVar) {
        this.zza = zzhVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        Animator animator2;
        zzh zzhVar = this.zza;
        zzhVar.zzg = zzh.zzb(zzhVar);
        animator2 = this.zza.zzg;
        animator2.start();
    }
}
