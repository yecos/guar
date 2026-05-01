package com.google.android.gms.cast.framework.media.uicontroller;

import android.view.View;

/* loaded from: classes.dex */
final class zzj implements View.OnClickListener {
    final /* synthetic */ UIMediaController zza;

    public zzj(UIMediaController uIMediaController) {
        this.zza = uIMediaController;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.zza.onLaunchExpandedControllerClicked(view);
    }
}
