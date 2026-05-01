package com.google.android.gms.cast.framework.media.widget;

import android.widget.TextView;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;

/* loaded from: classes.dex */
final class zzm implements RemoteMediaClient.Listener {
    final /* synthetic */ ExpandedControllerActivity zza;

    public /* synthetic */ zzm(ExpandedControllerActivity expandedControllerActivity, zzl zzlVar) {
        this.zza = expandedControllerActivity;
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onAdBreakStatusUpdated() {
        this.zza.zzr();
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onMetadataUpdated() {
        this.zza.zzq();
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onPreloadStatusUpdated() {
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onQueueStatusUpdated() {
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onSendingRemoteMediaRequest() {
        TextView textView;
        textView = this.zza.zzu;
        textView.setText(this.zza.getResources().getString(R.string.cast_expanded_controller_loading));
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onStatusUpdated() {
        RemoteMediaClient zzl;
        boolean z10;
        zzl = this.zza.zzl();
        if (zzl != null && zzl.hasMediaSession()) {
            this.zza.zzL = false;
            this.zza.zzp();
            this.zza.zzr();
        } else {
            z10 = this.zza.zzL;
            if (z10) {
                return;
            }
            this.zza.finish();
        }
    }
}
