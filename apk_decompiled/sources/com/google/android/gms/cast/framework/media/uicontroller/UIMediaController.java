package com.google.android.gms.cast.framework.media.uicontroller;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.e;
import androidx.fragment.app.y;
import com.google.android.gms.cast.MediaSeekOptions;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.ImageHints;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.TracksChooserDialogFragment;
import com.google.android.gms.cast.framework.media.widget.CastSeekBar;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzas;
import com.google.android.gms.internal.cast.zzat;
import com.google.android.gms.internal.cast.zzau;
import com.google.android.gms.internal.cast.zzaw;
import com.google.android.gms.internal.cast.zzay;
import com.google.android.gms.internal.cast.zzaz;
import com.google.android.gms.internal.cast.zzba;
import com.google.android.gms.internal.cast.zzbb;
import com.google.android.gms.internal.cast.zzbc;
import com.google.android.gms.internal.cast.zzbe;
import com.google.android.gms.internal.cast.zzbf;
import com.google.android.gms.internal.cast.zzbg;
import com.google.android.gms.internal.cast.zzbh;
import com.google.android.gms.internal.cast.zzbj;
import com.google.android.gms.internal.cast.zzbk;
import com.google.android.gms.internal.cast.zzbl;
import com.google.android.gms.internal.cast.zzbm;
import com.google.android.gms.internal.cast.zzbn;
import com.google.android.gms.internal.cast.zzbo;
import com.google.android.gms.internal.cast.zzbp;
import com.google.android.gms.internal.cast.zzbq;
import com.google.android.gms.internal.cast.zzbr;
import com.google.android.gms.internal.cast.zzju;
import com.google.android.gms.internal.cast.zzl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class UIMediaController implements RemoteMediaClient.Listener, SessionManagerListener<CastSession> {
    private static final Logger zzb = new Logger("UIMediaController");
    private final Activity zzc;
    private final SessionManager zzd;
    private RemoteMediaClient.Listener zzg;
    private RemoteMediaClient zzh;
    private final Map<View, List<UIController>> zze = new HashMap();
    private final Set<zzbp> zzf = new HashSet();
    zza zza = zza.zzf();

    public UIMediaController(@RecentlyNonNull Activity activity) {
        this.zzc = activity;
        CastContext zza = CastContext.zza(activity);
        zzl.zzd(zzju.UI_MEDIA_CONTROLLER);
        SessionManager sessionManager = zza != null ? zza.getSessionManager() : null;
        this.zzd = sessionManager;
        if (sessionManager != null) {
            sessionManager.addSessionManagerListener(this, CastSession.class);
            zzg(sessionManager.getCurrentCastSession());
        }
    }

    private final void zzf() {
        if (isActive()) {
            this.zza.zza = null;
            Iterator<List<UIController>> it = this.zze.values().iterator();
            while (it.hasNext()) {
                Iterator<UIController> it2 = it.next().iterator();
                while (it2.hasNext()) {
                    it2.next().onSessionEnded();
                }
            }
            Preconditions.checkNotNull(this.zzh);
            this.zzh.removeListener(this);
            this.zzh = null;
        }
    }

    private final void zzg(Session session) {
        if (isActive() || session == null || !session.isConnected()) {
            return;
        }
        CastSession castSession = (CastSession) session;
        RemoteMediaClient remoteMediaClient = castSession.getRemoteMediaClient();
        this.zzh = remoteMediaClient;
        if (remoteMediaClient != null) {
            remoteMediaClient.addListener(this);
            Preconditions.checkNotNull(this.zza);
            this.zza.zza = castSession.getRemoteMediaClient();
            Iterator<List<UIController>> it = this.zze.values().iterator();
            while (it.hasNext()) {
                Iterator<UIController> it2 = it.next().iterator();
                while (it2.hasNext()) {
                    it2.next().onSessionConnected(castSession);
                }
            }
            zzl();
        }
    }

    private final void zzh(int i10, boolean z10) {
        if (z10) {
            Iterator<zzbp> it = this.zzf.iterator();
            while (it.hasNext()) {
                it.next().zzb(i10 + this.zza.zze());
            }
        }
    }

    private final void zzi() {
        Iterator<zzbp> it = this.zzf.iterator();
        while (it.hasNext()) {
            it.next().zza(false);
        }
    }

    private final void zzj(int i10) {
        Iterator<zzbp> it = this.zzf.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else {
                it.next().zza(true);
            }
        }
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            return;
        }
        long zze = i10 + this.zza.zze();
        MediaSeekOptions.Builder builder = new MediaSeekOptions.Builder();
        builder.setPosition(zze);
        builder.setIsSeekToInfinite(remoteMediaClient.isLiveStream() && this.zza.zzn(zze));
        remoteMediaClient.seek(builder.build());
    }

    private final void zzk(View view, UIController uIController) {
        if (this.zzd == null) {
            return;
        }
        List<UIController> list = this.zze.get(view);
        if (list == null) {
            list = new ArrayList<>();
            this.zze.put(view, list);
        }
        list.add(uIController);
        if (isActive()) {
            uIController.onSessionConnected((CastSession) Preconditions.checkNotNull(this.zzd.getCurrentCastSession()));
            zzl();
        }
    }

    private final void zzl() {
        Iterator<List<UIController>> it = this.zze.values().iterator();
        while (it.hasNext()) {
            Iterator<UIController> it2 = it.next().iterator();
            while (it2.hasNext()) {
                it2.next().onMediaStatusUpdated();
            }
        }
    }

    @Deprecated
    public void bindImageViewToImageOfCurrentItem(@RecentlyNonNull ImageView imageView, int i10, int i11) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzk(imageView, new zzay(imageView, this.zzc, new ImageHints(i10, 0, 0), i11, null));
    }

    @Deprecated
    public void bindImageViewToImageOfPreloadedItem(@RecentlyNonNull ImageView imageView, int i10, int i11) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzk(imageView, new zzaw(imageView, this.zzc, new ImageHints(i10, 0, 0), i11));
    }

    public void bindImageViewToMuteToggle(@RecentlyNonNull ImageView imageView) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        imageView.setOnClickListener(new zzb(this));
        zzk(imageView, new zzbe(imageView, this.zzc));
    }

    public void bindImageViewToPlayPauseToggle(@RecentlyNonNull ImageView imageView, @RecentlyNonNull Drawable drawable, @RecentlyNonNull Drawable drawable2, @RecentlyNonNull Drawable drawable3, View view, boolean z10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzl.zzd(zzju.PAUSE_CONTROLLER);
        imageView.setOnClickListener(new zzc(this));
        zzk(imageView, new zzbf(imageView, this.zzc, drawable, drawable2, drawable3, view, z10));
    }

    public void bindProgressBar(@RecentlyNonNull ProgressBar progressBar) {
        bindProgressBar(progressBar, 1000L);
    }

    public void bindSeekBar(@RecentlyNonNull SeekBar seekBar) {
        bindSeekBar(seekBar, 1000L);
    }

    public void bindTextViewToMetadataOfCurrentItem(@RecentlyNonNull TextView textView, @RecentlyNonNull String str) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        bindTextViewToMetadataOfCurrentItem(textView, Collections.singletonList(str));
    }

    public void bindTextViewToMetadataOfPreloadedItem(@RecentlyNonNull TextView textView, @RecentlyNonNull String str) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        bindTextViewToMetadataOfPreloadedItem(textView, Collections.singletonList(str));
    }

    public void bindTextViewToSmartSubtitle(@RecentlyNonNull TextView textView) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzk(textView, new zzbm(textView));
    }

    public void bindTextViewToStreamDuration(@RecentlyNonNull TextView textView) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzk(textView, new zzbn(textView, this.zzc.getString(R.string.cast_invalid_stream_duration_text), null));
    }

    public void bindTextViewToStreamPosition(@RecentlyNonNull TextView textView, boolean z10) {
        bindTextViewToStreamPosition(textView, z10, 1000L);
    }

    public void bindViewToClosedCaption(@RecentlyNonNull View view) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        view.setOnClickListener(new zzk(this));
        zzk(view, new zzat(view, this.zzc));
    }

    public void bindViewToForward(@RecentlyNonNull View view, long j10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        view.setOnClickListener(new zzf(this, j10));
        zzk(view, new zzau(view, this.zza));
    }

    public void bindViewToLaunchExpandedController(@RecentlyNonNull View view) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        view.setOnClickListener(new zzj(this));
        zzk(view, new zzaz(view));
    }

    public void bindViewToLoadingIndicator(@RecentlyNonNull View view) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzk(view, new zzba(view));
    }

    public void bindViewToRewind(@RecentlyNonNull View view, long j10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        view.setOnClickListener(new zzg(this, j10));
        zzk(view, new zzbh(view, this.zza));
    }

    public void bindViewToSkipNext(@RecentlyNonNull View view, int i10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        view.setOnClickListener(new zzd(this));
        zzk(view, new zzbk(view, i10));
    }

    public void bindViewToSkipPrev(@RecentlyNonNull View view, int i10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        view.setOnClickListener(new zze(this));
        zzk(view, new zzbl(view, i10));
    }

    public void bindViewToUIController(@RecentlyNonNull View view, @RecentlyNonNull UIController uIController) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzk(view, uIController);
    }

    public void bindViewVisibilityToMediaSession(@RecentlyNonNull View view, int i10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzk(view, new zzbr(view, i10));
    }

    public void bindViewVisibilityToPreloadingEvent(@RecentlyNonNull View view, int i10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzk(view, new zzbq(view, i10));
    }

    public void dispose() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzf();
        this.zze.clear();
        SessionManager sessionManager = this.zzd;
        if (sessionManager != null) {
            sessionManager.removeSessionManagerListener(this, CastSession.class);
        }
        this.zzg = null;
    }

    @RecentlyNullable
    public RemoteMediaClient getRemoteMediaClient() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzh;
    }

    public boolean isActive() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzh != null;
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public void onAdBreakStatusUpdated() {
        zzl();
        RemoteMediaClient.Listener listener = this.zzg;
        if (listener != null) {
            listener.onAdBreakStatusUpdated();
        }
    }

    public void onClosedCaptionClicked(@RecentlyNonNull View view) {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null && remoteMediaClient.hasMediaSession() && (this.zzc instanceof e)) {
            TracksChooserDialogFragment newInstance = TracksChooserDialogFragment.newInstance();
            e eVar = (e) this.zzc;
            y m10 = eVar.getSupportFragmentManager().m();
            Fragment h02 = eVar.getSupportFragmentManager().h0("TRACKS_CHOOSER_DIALOG_TAG");
            if (h02 != null) {
                m10.p(h02);
            }
            newInstance.show(m10, "TRACKS_CHOOSER_DIALOG_TAG");
        }
    }

    public void onForwardClicked(@RecentlyNonNull View view, long j10) {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            return;
        }
        if (!remoteMediaClient.zzq()) {
            remoteMediaClient.seek(remoteMediaClient.getApproximateStreamPosition() + j10);
            return;
        }
        remoteMediaClient.seek(Math.min(remoteMediaClient.getApproximateStreamPosition() + j10, r2.zzc() + this.zza.zze()));
    }

    public void onLaunchExpandedControllerClicked(@RecentlyNonNull View view) {
        CastMediaOptions castMediaOptions = CastContext.getSharedInstance(this.zzc).getCastOptions().getCastMediaOptions();
        if (castMediaOptions == null || TextUtils.isEmpty(castMediaOptions.getExpandedControllerActivityClassName())) {
            return;
        }
        ComponentName componentName = new ComponentName(this.zzc.getApplicationContext(), castMediaOptions.getExpandedControllerActivityClassName());
        Intent intent = new Intent();
        intent.setComponent(componentName);
        this.zzc.startActivity(intent);
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public void onMetadataUpdated() {
        zzl();
        RemoteMediaClient.Listener listener = this.zzg;
        if (listener != null) {
            listener.onMetadataUpdated();
        }
    }

    public void onMuteToggleClicked(@RecentlyNonNull ImageView imageView) {
        CastSession currentCastSession = CastContext.getSharedInstance(this.zzc.getApplicationContext()).getSessionManager().getCurrentCastSession();
        if (currentCastSession == null || !currentCastSession.isConnected()) {
            return;
        }
        try {
            currentCastSession.setMute(!currentCastSession.isMute());
        } catch (IOException | IllegalArgumentException e10) {
            zzb.e("Unable to call CastSession.setMute(boolean).", e10);
        }
    }

    public void onPlayPauseToggleClicked(@RecentlyNonNull ImageView imageView) {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            return;
        }
        remoteMediaClient.togglePlayback();
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public void onPreloadStatusUpdated() {
        zzl();
        RemoteMediaClient.Listener listener = this.zzg;
        if (listener != null) {
            listener.onPreloadStatusUpdated();
        }
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public void onQueueStatusUpdated() {
        zzl();
        RemoteMediaClient.Listener listener = this.zzg;
        if (listener != null) {
            listener.onQueueStatusUpdated();
        }
    }

    public void onRewindClicked(@RecentlyNonNull View view, long j10) {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            return;
        }
        if (!remoteMediaClient.zzq()) {
            remoteMediaClient.seek(remoteMediaClient.getApproximateStreamPosition() - j10);
            return;
        }
        remoteMediaClient.seek(Math.max(remoteMediaClient.getApproximateStreamPosition() - j10, r2.zzd() + this.zza.zze()));
    }

    public void onSeekBarProgressChanged(@RecentlyNonNull SeekBar seekBar, int i10, boolean z10) {
        zzh(i10, z10);
    }

    public void onSeekBarStartTrackingTouch(@RecentlyNonNull SeekBar seekBar) {
        if (this.zze.containsKey(seekBar)) {
            for (UIController uIController : this.zze.get(seekBar)) {
                if (uIController instanceof zzbj) {
                    ((zzbj) uIController).zza(false);
                }
            }
        }
        zzi();
    }

    public void onSeekBarStopTrackingTouch(@RecentlyNonNull SeekBar seekBar) {
        if (this.zze.containsKey(seekBar)) {
            for (UIController uIController : this.zze.get(seekBar)) {
                if (uIController instanceof zzbj) {
                    ((zzbj) uIController).zza(true);
                }
            }
        }
        zzj(seekBar.getProgress());
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public void onSendingRemoteMediaRequest() {
        Iterator<List<UIController>> it = this.zze.values().iterator();
        while (it.hasNext()) {
            Iterator<UIController> it2 = it.next().iterator();
            while (it2.hasNext()) {
                it2.next().onSendingRemoteMediaRequest();
            }
        }
        RemoteMediaClient.Listener listener = this.zzg;
        if (listener != null) {
            listener.onSendingRemoteMediaRequest();
        }
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionEnded(@RecentlyNonNull CastSession castSession, int i10) {
        zzf();
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionEnding(@RecentlyNonNull CastSession castSession) {
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionResumeFailed(@RecentlyNonNull CastSession castSession, int i10) {
        zzf();
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionResumed(@RecentlyNonNull CastSession castSession, boolean z10) {
        zzg(castSession);
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionResuming(@RecentlyNonNull CastSession castSession, @RecentlyNonNull String str) {
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionStartFailed(@RecentlyNonNull CastSession castSession, int i10) {
        zzf();
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionStarted(@RecentlyNonNull CastSession castSession, @RecentlyNonNull String str) {
        zzg(castSession);
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionStarting(@RecentlyNonNull CastSession castSession) {
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionSuspended(@RecentlyNonNull CastSession castSession, int i10) {
    }

    public void onSkipNextClicked(@RecentlyNonNull View view) {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            return;
        }
        remoteMediaClient.queueNext(null);
    }

    public void onSkipPrevClicked(@RecentlyNonNull View view) {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            return;
        }
        remoteMediaClient.queuePrev(null);
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public void onStatusUpdated() {
        zzl();
        RemoteMediaClient.Listener listener = this.zzg;
        if (listener != null) {
            listener.onStatusUpdated();
        }
    }

    public void setPostRemoteMediaClientListener(RemoteMediaClient.Listener listener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.zzg = listener;
    }

    public final zza zza() {
        return this.zza;
    }

    public final void zzb(@RecentlyNonNull CastSeekBar castSeekBar, int i10, boolean z10) {
        zzh(i10, z10);
    }

    public final void zzc(@RecentlyNonNull CastSeekBar castSeekBar) {
        zzi();
    }

    public final void zzd(@RecentlyNonNull CastSeekBar castSeekBar) {
        zzj(castSeekBar.getProgress());
    }

    public final void zze(zzbp zzbpVar) {
        this.zzf.add(zzbpVar);
    }

    public void bindProgressBar(@RecentlyNonNull ProgressBar progressBar, long j10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzk(progressBar, new zzbg(progressBar, j10));
    }

    public void bindSeekBar(@RecentlyNonNull SeekBar seekBar, long j10) {
        zzl.zzd(zzju.SEEK_CONTROLLER);
        Preconditions.checkMainThread("Must be called from the main thread.");
        seekBar.setOnSeekBarChangeListener(new zzi(this, seekBar));
        zzk(seekBar, new zzbj(seekBar, j10, this.zza));
    }

    public void bindTextViewToStreamPosition(@RecentlyNonNull TextView textView, boolean z10, long j10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzbo zzboVar = new zzbo(textView, j10, this.zzc.getString(R.string.cast_invalid_stream_position_text));
        if (z10) {
            this.zzf.add(zzboVar);
        }
        zzk(textView, zzboVar);
    }

    @Deprecated
    public void bindImageViewToImageOfCurrentItem(@RecentlyNonNull ImageView imageView, int i10, @RecentlyNonNull View view) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzk(imageView, new zzay(imageView, this.zzc, new ImageHints(i10, 0, 0), 0, view));
    }

    public void bindImageViewToImageOfPreloadedItem(@RecentlyNonNull ImageView imageView, @RecentlyNonNull ImageHints imageHints, int i10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzk(imageView, new zzaw(imageView, this.zzc, imageHints, i10));
    }

    public void bindTextViewToMetadataOfCurrentItem(@RecentlyNonNull TextView textView, @RecentlyNonNull List<String> list) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzk(textView, new zzbc(textView, list));
    }

    public void bindTextViewToMetadataOfPreloadedItem(@RecentlyNonNull TextView textView, @RecentlyNonNull List<String> list) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzk(textView, new zzbb(textView, list));
    }

    public void bindImageViewToImageOfCurrentItem(@RecentlyNonNull ImageView imageView, @RecentlyNonNull ImageHints imageHints, int i10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzk(imageView, new zzay(imageView, this.zzc, imageHints, i10, null));
    }

    public void bindTextViewToStreamDuration(@RecentlyNonNull TextView textView, @RecentlyNonNull View view) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzk(textView, new zzbn(textView, this.zzc.getString(R.string.cast_invalid_stream_duration_text), view));
    }

    public void bindSeekBar(@RecentlyNonNull CastSeekBar castSeekBar) {
        bindSeekBar(castSeekBar, 1000L);
    }

    public void bindImageViewToImageOfCurrentItem(@RecentlyNonNull ImageView imageView, @RecentlyNonNull ImageHints imageHints, @RecentlyNonNull View view) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzk(imageView, new zzay(imageView, this.zzc, imageHints, 0, view));
    }

    public void bindSeekBar(@RecentlyNonNull CastSeekBar castSeekBar, long j10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzl.zzd(zzju.SEEK_CONTROLLER);
        castSeekBar.zzd = new zzh(this);
        zzk(castSeekBar, new zzas(castSeekBar, j10, this.zza));
    }
}
