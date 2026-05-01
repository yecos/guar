package com.google.android.gms.cast.framework.media.uicontroller;

import com.google.android.gms.cast.framework.media.widget.CastSeekBar;

/* loaded from: classes.dex */
final class zzh extends com.google.android.gms.cast.framework.media.widget.zzd {
    final /* synthetic */ UIMediaController zza;

    public zzh(UIMediaController uIMediaController) {
        this.zza = uIMediaController;
    }

    @Override // com.google.android.gms.cast.framework.media.widget.zzd
    public final void zza(CastSeekBar castSeekBar, int i10, boolean z10) {
        this.zza.zzb(castSeekBar, i10, z10);
    }

    @Override // com.google.android.gms.cast.framework.media.widget.zzd
    public final void zzb(CastSeekBar castSeekBar) {
        this.zza.zzc(castSeekBar);
    }

    @Override // com.google.android.gms.cast.framework.media.widget.zzd
    public final void zzc(CastSeekBar castSeekBar) {
        this.zza.zzd(castSeekBar);
    }
}
