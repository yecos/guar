package com.google.android.gms.cast.framework.media.uicontroller;

import android.widget.SeekBar;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;

/* loaded from: classes.dex */
final class zzi implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ SeekBar zza;
    final /* synthetic */ UIMediaController zzb;

    public zzi(UIMediaController uIMediaController, SeekBar seekBar) {
        this.zzb = uIMediaController;
        this.zza = seekBar;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
        RemoteMediaClient remoteMediaClient = this.zzb.getRemoteMediaClient();
        if (remoteMediaClient != null && remoteMediaClient.hasMediaSession() && remoteMediaClient.zzq()) {
            if (z10 && i10 < this.zzb.zza.zzd()) {
                int zzd = this.zzb.zza.zzd();
                this.zza.setProgress(zzd);
                this.zzb.onSeekBarProgressChanged(seekBar, zzd, true);
                return;
            } else if (z10 && i10 > this.zzb.zza.zzc()) {
                int zzc = this.zzb.zza.zzc();
                this.zza.setProgress(zzc);
                this.zzb.onSeekBarProgressChanged(seekBar, zzc, true);
                return;
            }
        }
        this.zzb.onSeekBarProgressChanged(seekBar, i10, z10);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar) {
        this.zzb.onSeekBarStartTrackingTouch(seekBar);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar) {
        this.zzb.onSeekBarStopTrackingTouch(seekBar);
    }
}
