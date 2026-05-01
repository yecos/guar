package com.google.android.gms.internal.cast;

import android.widget.TextView;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;

/* loaded from: classes.dex */
public final class zzbs extends UIController implements RemoteMediaClient.ProgressListener {
    private final TextView zza;
    private final com.google.android.gms.cast.framework.media.uicontroller.zza zzb;

    public zzbs(TextView textView, com.google.android.gms.cast.framework.media.uicontroller.zza zzaVar) {
        this.zza = textView;
        this.zzb = zzaVar;
        zza();
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onMediaStatusUpdated() {
        zza();
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.ProgressListener
    public final void onProgressUpdated(long j10, long j11) {
        zza();
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionConnected(CastSession castSession) {
        super.onSessionConnected(castSession);
        if (getRemoteMediaClient() != null) {
            getRemoteMediaClient().addProgressListener(this, 1000L);
        }
        zza();
    }

    @Override // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionEnded() {
        if (getRemoteMediaClient() != null) {
            getRemoteMediaClient().removeProgressListener(this);
        }
        super.onSessionEnded();
        zza();
    }

    public final void zza() {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            TextView textView = this.zza;
            textView.setText(textView.getContext().getString(R.string.cast_invalid_stream_duration_text));
        } else {
            if (remoteMediaClient.isLiveStream() && this.zzb.zzi() == null) {
                this.zza.setVisibility(8);
                return;
            }
            this.zza.setVisibility(0);
            TextView textView2 = this.zza;
            com.google.android.gms.cast.framework.media.uicontroller.zza zzaVar = this.zzb;
            textView2.setText(zzaVar.zzl(zzaVar.zzb() + zzaVar.zze()));
        }
    }
}
