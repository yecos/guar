package com.google.android.gms.internal.cast;

import android.app.Activity;
import android.view.ViewGroup;
import com.google.android.gms.cast.framework.IntroductoryOverlay;

/* loaded from: classes.dex */
final class zzw implements Runnable {
    final /* synthetic */ zzx zza;

    public zzw(zzx zzxVar) {
        this.zza = zzxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z10;
        Activity activity;
        IntroductoryOverlay.OnOverlayDismissedListener onOverlayDismissedListener;
        IntroductoryOverlay.OnOverlayDismissedListener onOverlayDismissedListener2;
        z10 = this.zza.zza.zzg;
        if (z10) {
            activity = this.zza.zza.zzb;
            ((ViewGroup) activity.getWindow().getDecorView()).removeView(this.zza.zza);
            onOverlayDismissedListener = this.zza.zza.zzc;
            if (onOverlayDismissedListener != null) {
                onOverlayDismissedListener2 = this.zza.zza.zzc;
                onOverlayDismissedListener2.onOverlayDismissed();
            }
            this.zza.zza.zzg();
        }
    }
}
