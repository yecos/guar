package com.google.android.gms.cast.framework.media.internal;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.framework.ReconnectionService;
import com.google.android.gms.cast.framework.media.MediaNotificationService;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.cast.zzaj;
import com.google.android.gms.internal.cast.zzcn;
import com.google.android.gms.internal.cast.zzco;

/* loaded from: classes.dex */
public final class zzp implements RemoteMediaClient.Listener {
    private static final Logger zza = new Logger("MediaSessionManager");
    private final Context zzb;
    private final CastOptions zzc;
    private final zzaj zzd;
    private final ComponentName zze;
    private final zzb zzf;
    private final zzb zzg;
    private final Handler zzh;
    private final Runnable zzi;
    private RemoteMediaClient zzj;
    private CastDevice zzk;
    private MediaSessionCompat zzl;
    private MediaSessionCompat.b zzm;
    private boolean zzn;

    public zzp(Context context, CastOptions castOptions, zzaj zzajVar) {
        this.zzb = context;
        this.zzc = castOptions;
        this.zzd = zzajVar;
        if (castOptions.getCastMediaOptions() == null || TextUtils.isEmpty(castOptions.getCastMediaOptions().getExpandedControllerActivityClassName())) {
            this.zze = null;
        } else {
            this.zze = new ComponentName(context, castOptions.getCastMediaOptions().getExpandedControllerActivityClassName());
        }
        zzb zzbVar = new zzb(context);
        this.zzf = zzbVar;
        zzbVar.zzc(new zzm(this));
        zzb zzbVar2 = new zzb(context);
        this.zzg = zzbVar2;
        zzbVar2.zzc(new zzn(this));
        this.zzh = new zzco(Looper.getMainLooper());
        this.zzi = new Runnable() { // from class: com.google.android.gms.cast.framework.media.internal.zzl
            @Override // java.lang.Runnable
            public final void run() {
                zzp.this.zzf();
            }
        };
    }

    public static Bitmap zza(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f10 = width;
        int i10 = (int) (((9.0f * f10) / 16.0f) + 0.5f);
        float f11 = (i10 - height) / 2;
        RectF rectF = new RectF(0.0f, f11, f10, height + f11);
        Bitmap.Config config = bitmap.getConfig();
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, i10, config);
        new Canvas(createBitmap).drawBitmap(bitmap, (Rect) null, rectF, (Paint) null);
        return createBitmap;
    }

    private final Uri zzh(MediaMetadata mediaMetadata, int i10) {
        WebImage onPickImage = this.zzc.getCastMediaOptions().getImagePicker() != null ? this.zzc.getCastMediaOptions().getImagePicker().onPickImage(mediaMetadata, i10) : mediaMetadata.hasImages() ? mediaMetadata.getImages().get(0) : null;
        if (onPickImage == null) {
            return null;
        }
        return onPickImage.getUrl();
    }

    private final MediaMetadataCompat.b zzi() {
        MediaSessionCompat mediaSessionCompat = this.zzl;
        MediaMetadataCompat a10 = mediaSessionCompat == null ? null : mediaSessionCompat.d().a();
        return a10 == null ? new MediaMetadataCompat.b() : new MediaMetadataCompat.b(a10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzj(Bitmap bitmap, int i10) {
        MediaSessionCompat mediaSessionCompat = this.zzl;
        if (mediaSessionCompat == null) {
            return;
        }
        if (i10 != 0) {
            if (i10 == 3) {
                mediaSessionCompat.n(zzi().b("android.media.metadata.ALBUM_ART", bitmap).a());
            }
        } else {
            if (bitmap != null) {
                mediaSessionCompat.n(zzi().b("android.media.metadata.DISPLAY_ICON", bitmap).a());
                return;
            }
            Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            createBitmap.eraseColor(0);
            this.zzl.n(zzi().b("android.media.metadata.DISPLAY_ICON", createBitmap).a());
        }
    }

    private final void zzk(boolean z10) {
        if (this.zzc.getEnableReconnectionService()) {
            this.zzh.removeCallbacks(this.zzi);
            Intent intent = new Intent(this.zzb, (Class<?>) ReconnectionService.class);
            intent.setPackage(this.zzb.getPackageName());
            try {
                this.zzb.startService(intent);
            } catch (IllegalStateException unused) {
                if (z10) {
                    this.zzh.postDelayed(this.zzi, 1000L);
                }
            }
        }
    }

    private final void zzl() {
        if (this.zzc.getCastMediaOptions().getNotificationOptions() == null) {
            return;
        }
        zza.d("Stopping notification service.", new Object[0]);
        if (Build.VERSION.SDK_INT >= 26) {
            MediaNotificationService.zze();
            return;
        }
        Intent intent = new Intent(this.zzb, (Class<?>) MediaNotificationService.class);
        intent.setPackage(this.zzb.getPackageName());
        intent.setAction(MediaNotificationService.ACTION_UPDATE_NOTIFICATION);
        this.zzb.stopService(intent);
    }

    private final void zzm() {
        if (this.zzc.getEnableReconnectionService()) {
            this.zzh.removeCallbacks(this.zzi);
            Intent intent = new Intent(this.zzb, (Class<?>) ReconnectionService.class);
            intent.setPackage(this.zzb.getPackageName());
            this.zzb.stopService(intent);
        }
    }

    private final void zzn(int i10, MediaInfo mediaInfo) {
        PendingIntent zza2;
        MediaSessionCompat mediaSessionCompat = this.zzl;
        if (mediaSessionCompat == null) {
            return;
        }
        if (i10 == 0) {
            mediaSessionCompat.o(new PlaybackStateCompat.b().c(0, 0L, 1.0f).a());
            this.zzl.n(new MediaMetadataCompat.b().a());
            return;
        }
        this.zzl.o(new PlaybackStateCompat.b().c(i10, this.zzj.isLiveStream() ? 0L : this.zzj.getApproximateStreamPosition(), 1.0f).b(true != this.zzj.isLiveStream() ? 768L : 512L).a());
        MediaSessionCompat mediaSessionCompat2 = this.zzl;
        if (this.zze == null) {
            zza2 = null;
        } else {
            Intent intent = new Intent();
            intent.setComponent(this.zze);
            zza2 = zzcn.zza(this.zzb, 0, intent, zzcn.zza | 134217728);
        }
        mediaSessionCompat2.r(zza2);
        if (this.zzl == null) {
            return;
        }
        MediaMetadata metadata = mediaInfo.getMetadata();
        this.zzl.n(zzi().d("android.media.metadata.TITLE", metadata.getString(MediaMetadata.KEY_TITLE)).d("android.media.metadata.DISPLAY_TITLE", metadata.getString(MediaMetadata.KEY_TITLE)).d("android.media.metadata.DISPLAY_SUBTITLE", metadata.getString(MediaMetadata.KEY_SUBTITLE)).c("android.media.metadata.DURATION", this.zzj.isLiveStream() ? 0L : mediaInfo.getStreamDuration()).a());
        Uri zzh = zzh(metadata, 0);
        if (zzh != null) {
            this.zzf.zzd(zzh);
        } else {
            zzj(null, 0);
        }
        Uri zzh2 = zzh(metadata, 3);
        if (zzh2 != null) {
            this.zzg.zzd(zzh2);
        } else {
            zzj(null, 3);
        }
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onAdBreakStatusUpdated() {
        zzg(false);
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onMetadataUpdated() {
        zzg(false);
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onPreloadStatusUpdated() {
        zzg(false);
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onQueueStatusUpdated() {
        zzg(false);
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onSendingRemoteMediaRequest() {
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public final void onStatusUpdated() {
        zzg(false);
    }

    public final void zzd(RemoteMediaClient remoteMediaClient, CastDevice castDevice) {
        CastOptions castOptions;
        if (this.zzn || (castOptions = this.zzc) == null || castOptions.getCastMediaOptions() == null || remoteMediaClient == null || castDevice == null) {
            return;
        }
        this.zzj = remoteMediaClient;
        remoteMediaClient.addListener(this);
        this.zzk = castDevice;
        if (!PlatformVersion.isAtLeastLollipop()) {
            ((AudioManager) this.zzb.getSystemService("audio")).requestAudioFocus(null, 3, 3);
        }
        ComponentName componentName = new ComponentName(this.zzb, this.zzc.getCastMediaOptions().getMediaIntentReceiverClassName());
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setComponent(componentName);
        PendingIntent zzb = zzcn.zzb(this.zzb, 0, intent, zzcn.zza);
        if (this.zzc.getCastMediaOptions().getMediaSessionEnabled()) {
            this.zzl = new MediaSessionCompat(this.zzb, "CastMediaSession", componentName, zzb);
            zzn(0, null);
            CastDevice castDevice2 = this.zzk;
            if (castDevice2 != null && !TextUtils.isEmpty(castDevice2.getFriendlyName())) {
                this.zzl.n(new MediaMetadataCompat.b().d("android.media.metadata.ALBUM_ARTIST", this.zzb.getResources().getString(R.string.cast_casting_to_device, this.zzk.getFriendlyName())).a());
            }
            zzo zzoVar = new zzo(this);
            this.zzm = zzoVar;
            this.zzl.l(zzoVar);
            this.zzl.k(true);
            this.zzd.zzq(this.zzl);
        }
        this.zzn = true;
        zzg(false);
    }

    public final void zze(int i10) {
        if (this.zzn) {
            this.zzn = false;
            RemoteMediaClient remoteMediaClient = this.zzj;
            if (remoteMediaClient != null) {
                remoteMediaClient.removeListener(this);
            }
            if (!PlatformVersion.isAtLeastLollipop()) {
                ((AudioManager) this.zzb.getSystemService("audio")).abandonAudioFocus(null);
            }
            this.zzd.zzq(null);
            this.zzf.zza();
            zzb zzbVar = this.zzg;
            if (zzbVar != null) {
                zzbVar.zza();
            }
            MediaSessionCompat mediaSessionCompat = this.zzl;
            if (mediaSessionCompat != null) {
                mediaSessionCompat.r(null);
                this.zzl.l(null);
                this.zzl.n(new MediaMetadataCompat.b().a());
                zzn(0, null);
                this.zzl.k(false);
                this.zzl.i();
                this.zzl = null;
            }
            this.zzj = null;
            this.zzk = null;
            this.zzm = null;
            zzl();
            if (i10 == 0) {
                zzm();
            }
        }
    }

    public final /* synthetic */ void zzf() {
        zzk(false);
    }

    public final void zzg(boolean z10) {
        boolean z11;
        boolean z12;
        MediaQueueItem loadingItem;
        RemoteMediaClient remoteMediaClient = this.zzj;
        if (remoteMediaClient == null) {
            return;
        }
        MediaInfo mediaInfo = remoteMediaClient.getMediaInfo();
        int i10 = 6;
        if (!this.zzj.isBuffering()) {
            if (this.zzj.isPlaying()) {
                i10 = 3;
            } else if (this.zzj.isPaused()) {
                i10 = 2;
            } else if (!this.zzj.isLoadingNextItem() || (loadingItem = this.zzj.getLoadingItem()) == null || loadingItem.getMedia() == null) {
                i10 = 0;
            } else {
                mediaInfo = loadingItem.getMedia();
            }
        }
        if (mediaInfo == null || mediaInfo.getMetadata() == null) {
            i10 = 0;
        }
        zzn(i10, mediaInfo);
        if (!this.zzj.hasMediaSession()) {
            zzl();
            zzm();
            return;
        }
        if (i10 != 0) {
            if (this.zzk != null && MediaNotificationService.isNotificationOptionsValid(this.zzc)) {
                Intent intent = new Intent(this.zzb, (Class<?>) MediaNotificationService.class);
                intent.putExtra("extra_media_notification_force_update", z10);
                intent.setPackage(this.zzb.getPackageName());
                intent.setAction(MediaNotificationService.ACTION_UPDATE_NOTIFICATION);
                intent.putExtra("extra_media_info", this.zzj.getMediaInfo());
                intent.putExtra("extra_remote_media_client_player_state", this.zzj.getPlayerState());
                intent.putExtra("extra_cast_device", this.zzk);
                MediaSessionCompat mediaSessionCompat = this.zzl;
                if (mediaSessionCompat != null) {
                    intent.putExtra("extra_media_session_token", mediaSessionCompat.f());
                }
                MediaStatus mediaStatus = this.zzj.getMediaStatus();
                int queueRepeatMode = mediaStatus.getQueueRepeatMode();
                if (queueRepeatMode == 1 || queueRepeatMode == 2 || queueRepeatMode == 3) {
                    z11 = true;
                    z12 = true;
                } else {
                    Integer indexById = mediaStatus.getIndexById(mediaStatus.getCurrentItemId());
                    if (indexById != null) {
                        z12 = indexById.intValue() > 0;
                        z11 = indexById.intValue() < mediaStatus.getQueueItemCount() + (-1);
                    } else {
                        z11 = false;
                        z12 = false;
                    }
                }
                intent.putExtra("extra_can_skip_next", z11);
                intent.putExtra("extra_can_skip_prev", z12);
                zza.d("Starting notification service.", new Object[0]);
                if (Build.VERSION.SDK_INT >= 26) {
                    this.zzb.startForegroundService(intent);
                } else {
                    this.zzb.startService(intent);
                }
            }
            if (this.zzj.isLoadingNextItem()) {
                return;
            }
            zzk(true);
        }
    }
}
