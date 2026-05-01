package com.google.android.gms.internal.cast;

import android.animation.ObjectAnimator;
import android.view.View;
import com.google.android.gms.common.util.PlatformVersion;

/* loaded from: classes.dex */
final class zzaa implements View.OnClickListener {
    final /* synthetic */ zzad zza;

    public zzaa(zzad zzadVar) {
        this.zza = zzadVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (!PlatformVersion.isAtLeastJellyBean()) {
            zzad.zza(this.zza);
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f);
        ofFloat.setDuration(400L).addListener(new zzz(this));
        ofFloat.start();
    }
}
