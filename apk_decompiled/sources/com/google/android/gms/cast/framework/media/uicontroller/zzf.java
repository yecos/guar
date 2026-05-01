package com.google.android.gms.cast.framework.media.uicontroller;

import android.view.View;

/* loaded from: classes.dex */
final class zzf implements View.OnClickListener {
    final /* synthetic */ long zza;
    final /* synthetic */ UIMediaController zzb;

    public zzf(UIMediaController uIMediaController, long j10) {
        this.zzb = uIMediaController;
        this.zza = j10;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.zzb.onForwardClicked(view, this.zza);
    }
}
