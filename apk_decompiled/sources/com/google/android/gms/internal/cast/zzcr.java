package com.google.android.gms.internal.cast;

import android.animation.Animator;

/* loaded from: classes.dex */
public final class zzcr extends zzcp {
    protected final Animator zza;
    private int zzc;
    private final zzcv zzd = new zzcq(this);
    private final int zzb = -1;

    private zzcr(Animator animator, int i10, Runnable runnable) {
        this.zza = animator;
    }

    public static void zzd(Animator animator, int i10, Runnable runnable) {
        animator.addListener(new zzcr(animator, -1, null));
    }

    public static /* bridge */ /* synthetic */ boolean zze(zzcr zzcrVar) {
        return zzcrVar.zzb != -1 && zzcrVar.zzc >= 0;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (zza(animator)) {
            return;
        }
        zzcy.zzb().zza(this.zzd);
    }
}
