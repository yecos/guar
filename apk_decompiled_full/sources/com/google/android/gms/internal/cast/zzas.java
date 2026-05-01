package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.AdBreakClipInfo;
import com.google.android.gms.cast.AdBreakInfo;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;
import com.google.android.gms.cast.framework.media.widget.CastSeekBar;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class zzas extends UIController implements RemoteMediaClient.ProgressListener {
    private final CastSeekBar zza;
    private final long zzb;
    private final com.google.android.gms.cast.framework.media.uicontroller.zza zzc;

    public zzas(CastSeekBar castSeekBar, long j10, com.google.android.gms.cast.framework.media.uicontroller.zza zzaVar) {
        this.zza = castSeekBar;
        this.zzb = j10;
        this.zzc = zzaVar;
        zzc();
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final RemoteMediaClient getRemoteMediaClient() {
        return super.getRemoteMediaClient();
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onMediaStatusUpdated() {
        zzc();
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.ProgressListener
    public final void onProgressUpdated(long j10, long j11) {
        zzb();
        zza();
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionConnected(CastSession castSession) {
        super.onSessionConnected(castSession);
        if (super.getRemoteMediaClient() != null) {
            super.getRemoteMediaClient().addProgressListener(this, this.zzb);
        }
        zzc();
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionEnded() {
        if (super.getRemoteMediaClient() != null) {
            super.getRemoteMediaClient().removeProgressListener(this);
        }
        super.onSessionEnded();
        zzc();
    }

    public final void zza() {
        RemoteMediaClient remoteMediaClient = super.getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.isPlayingAd()) {
            CastSeekBar castSeekBar = this.zza;
            castSeekBar.zzb = null;
            castSeekBar.postInvalidate();
            return;
        }
        int approximateAdBreakClipPositionMs = (int) remoteMediaClient.getApproximateAdBreakClipPositionMs();
        MediaStatus mediaStatus = remoteMediaClient.getMediaStatus();
        AdBreakClipInfo currentAdBreakClip = mediaStatus != null ? mediaStatus.getCurrentAdBreakClip() : null;
        int durationInMs = currentAdBreakClip != null ? (int) currentAdBreakClip.getDurationInMs() : approximateAdBreakClipPositionMs;
        if (approximateAdBreakClipPositionMs < 0) {
            approximateAdBreakClipPositionMs = 0;
        }
        if (durationInMs < 0) {
            durationInMs = 1;
        }
        if (approximateAdBreakClipPositionMs > durationInMs) {
            durationInMs = approximateAdBreakClipPositionMs;
        }
        CastSeekBar castSeekBar2 = this.zza;
        castSeekBar2.zzb = new com.google.android.gms.cast.framework.media.widget.zzc(approximateAdBreakClipPositionMs, durationInMs);
        castSeekBar2.postInvalidate();
    }

    public final void zzb() {
        RemoteMediaClient remoteMediaClient = super.getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || remoteMediaClient.isPlayingAd()) {
            this.zza.setEnabled(false);
        } else {
            this.zza.setEnabled(true);
        }
        com.google.android.gms.cast.framework.media.widget.zze zzeVar = new com.google.android.gms.cast.framework.media.widget.zze();
        zzeVar.zza = this.zzc.zza();
        zzeVar.zzb = this.zzc.zzb();
        zzeVar.zzc = (int) (-this.zzc.zze());
        RemoteMediaClient remoteMediaClient2 = super.getRemoteMediaClient();
        zzeVar.zzd = (remoteMediaClient2 != null && remoteMediaClient2.hasMediaSession() && remoteMediaClient2.zzq()) ? this.zzc.zzd() : this.zzc.zza();
        RemoteMediaClient remoteMediaClient3 = super.getRemoteMediaClient();
        zzeVar.zze = (remoteMediaClient3 != null && remoteMediaClient3.hasMediaSession() && remoteMediaClient3.zzq()) ? this.zzc.zzc() : this.zzc.zza();
        RemoteMediaClient remoteMediaClient4 = super.getRemoteMediaClient();
        zzeVar.zzf = remoteMediaClient4 != null && remoteMediaClient4.hasMediaSession() && remoteMediaClient4.zzq();
        this.zza.zze(zzeVar);
    }

    public final void zzc() {
        zzb();
        ArrayList arrayList = null;
        if (super.getRemoteMediaClient() == null) {
            this.zza.zzd(null);
        } else {
            MediaInfo mediaInfo = super.getRemoteMediaClient().getMediaInfo();
            if (!super.getRemoteMediaClient().hasMediaSession() || super.getRemoteMediaClient().isLoadingNextItem() || mediaInfo == null) {
                this.zza.zzd(null);
            } else {
                CastSeekBar castSeekBar = this.zza;
                List<AdBreakInfo> adBreaks = mediaInfo.getAdBreaks();
                if (adBreaks != null) {
                    arrayList = new ArrayList();
                    for (AdBreakInfo adBreakInfo : adBreaks) {
                        if (adBreakInfo != null) {
                            long playbackPositionInMs = adBreakInfo.getPlaybackPositionInMs();
                            int zzb = playbackPositionInMs == -1000 ? this.zzc.zzb() : Math.min((int) (playbackPositionInMs - this.zzc.zze()), this.zzc.zzb());
                            if (zzb >= 0) {
                                arrayList.add(new com.google.android.gms.cast.framework.media.widget.zzb(zzb, (int) adBreakInfo.getDurationInMs(), adBreakInfo.isExpanded()));
                            }
                        }
                    }
                }
                castSeekBar.zzd(arrayList);
            }
        }
        zza();
    }
}
