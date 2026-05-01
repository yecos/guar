package com.google.android.gms.internal.cast;

import android.content.Context;
import android.view.View;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;
import java.util.List;

/* loaded from: classes.dex */
public final class zzat extends UIController {
    private final View zza;
    private final String zzb;
    private final String zzc;

    public zzat(View view, Context context) {
        this.zza = view;
        this.zzb = context.getString(R.string.cast_closed_captions);
        this.zzc = context.getString(R.string.cast_closed_captions_unavailable);
        view.setEnabled(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zza() {
        MediaInfo mediaInfo;
        List<MediaTrack> mediaTracks;
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null && remoteMediaClient.hasMediaSession() && (mediaInfo = remoteMediaClient.getMediaInfo()) != null && (mediaTracks = mediaInfo.getMediaTracks()) != null && !mediaTracks.isEmpty()) {
            int i10 = 0;
            for (MediaTrack mediaTrack : mediaTracks) {
                if (mediaTrack.getType() == 2) {
                    i10++;
                    if (i10 > 1) {
                        if (!remoteMediaClient.isPlayingAd()) {
                            this.zza.setEnabled(true);
                            this.zza.setContentDescription(this.zzb);
                            return;
                        }
                    }
                } else if (mediaTrack.getType() == 1) {
                    if (!remoteMediaClient.isPlayingAd()) {
                    }
                }
            }
        }
        this.zza.setEnabled(false);
        this.zza.setContentDescription(this.zzc);
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onMediaStatusUpdated() {
        zza();
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSendingRemoteMediaRequest() {
        this.zza.setEnabled(false);
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionConnected(CastSession castSession) {
        super.onSessionConnected(castSession);
        this.zza.setEnabled(true);
        zza();
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionEnded() {
        this.zza.setEnabled(false);
        super.onSessionEnded();
    }
}
