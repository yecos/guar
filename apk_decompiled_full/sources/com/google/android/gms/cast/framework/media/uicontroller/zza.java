package com.google.android.gms.cast.framework.media.uicontroller;

import android.text.format.DateUtils;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.text.DateFormat;
import java.util.Date;

@ShowFirstParty
/* loaded from: classes.dex */
public final class zza {
    RemoteMediaClient zza;

    private zza() {
    }

    public static zza zzf() {
        return new zza();
    }

    private final MediaMetadata zzo() {
        MediaInfo mediaInfo;
        RemoteMediaClient remoteMediaClient = this.zza;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || (mediaInfo = this.zza.getMediaInfo()) == null) {
            return null;
        }
        return mediaInfo.getMetadata();
    }

    private static final String zzp(long j10) {
        if (j10 >= 0) {
            return DateUtils.formatElapsedTime(j10 / 1000);
        }
        String valueOf = String.valueOf(DateUtils.formatElapsedTime((-j10) / 1000));
        return valueOf.length() != 0 ? Operator.Operation.MINUS.concat(valueOf) : new String(Operator.Operation.MINUS);
    }

    public final int zza() {
        RemoteMediaClient remoteMediaClient = this.zza;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            return 0;
        }
        RemoteMediaClient remoteMediaClient2 = this.zza;
        if (!remoteMediaClient2.isLiveStream() && remoteMediaClient2.isLoadingNextItem()) {
            return 0;
        }
        int approximateStreamPosition = (int) (remoteMediaClient2.getApproximateStreamPosition() - zze());
        if (remoteMediaClient2.zzq()) {
            approximateStreamPosition = CastUtils.zza(approximateStreamPosition, zzd(), zzc());
        }
        return CastUtils.zza(approximateStreamPosition, 0, zzb());
    }

    public final int zzb() {
        MediaInfo media;
        RemoteMediaClient remoteMediaClient = this.zza;
        long j10 = 1;
        if (remoteMediaClient != null && remoteMediaClient.hasMediaSession()) {
            RemoteMediaClient remoteMediaClient2 = this.zza;
            if (remoteMediaClient2.isLiveStream()) {
                Long zzi = zzi();
                if (zzi != null) {
                    j10 = zzi.longValue();
                } else {
                    Long zzg = zzg();
                    j10 = zzg != null ? zzg.longValue() : Math.max(remoteMediaClient2.getApproximateStreamPosition(), 1L);
                }
            } else if (remoteMediaClient2.isLoadingNextItem()) {
                MediaQueueItem loadingItem = remoteMediaClient2.getLoadingItem();
                if (loadingItem != null && (media = loadingItem.getMedia()) != null) {
                    j10 = Math.max(media.getStreamDuration(), 1L);
                }
            } else {
                j10 = Math.max(remoteMediaClient2.getStreamDuration(), 1L);
            }
        }
        return Math.max((int) (j10 - zze()), 1);
    }

    public final int zzc() {
        RemoteMediaClient remoteMediaClient = this.zza;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || !this.zza.isLiveStream()) {
            return zzb();
        }
        if (this.zza.zzq()) {
            return CastUtils.zza((int) (((Long) Preconditions.checkNotNull(zzg())).longValue() - zze()), 0, zzb());
        }
        return 0;
    }

    public final int zzd() {
        RemoteMediaClient remoteMediaClient = this.zza;
        if (remoteMediaClient != null && remoteMediaClient.hasMediaSession() && this.zza.isLiveStream() && this.zza.zzq()) {
            return CastUtils.zza((int) (((Long) Preconditions.checkNotNull(zzh())).longValue() - zze()), 0, zzb());
        }
        return 0;
    }

    public final long zze() {
        RemoteMediaClient remoteMediaClient = this.zza;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || !this.zza.isLiveStream()) {
            return 0L;
        }
        RemoteMediaClient remoteMediaClient2 = this.zza;
        Long zzj = zzj();
        if (zzj != null) {
            return zzj.longValue();
        }
        Long zzh = zzh();
        return zzh != null ? zzh.longValue() : remoteMediaClient2.getApproximateStreamPosition();
    }

    public final Long zzg() {
        RemoteMediaClient remoteMediaClient;
        MediaStatus mediaStatus;
        RemoteMediaClient remoteMediaClient2 = this.zza;
        if (remoteMediaClient2 == null || !remoteMediaClient2.hasMediaSession() || !this.zza.isLiveStream() || !this.zza.zzq() || (mediaStatus = (remoteMediaClient = this.zza).getMediaStatus()) == null || mediaStatus.getLiveSeekableRange() == null) {
            return null;
        }
        return Long.valueOf(remoteMediaClient.getApproximateLiveSeekableRangeEnd());
    }

    public final Long zzh() {
        RemoteMediaClient remoteMediaClient;
        MediaStatus mediaStatus;
        RemoteMediaClient remoteMediaClient2 = this.zza;
        if (remoteMediaClient2 == null || !remoteMediaClient2.hasMediaSession() || !this.zza.isLiveStream() || !this.zza.zzq() || (mediaStatus = (remoteMediaClient = this.zza).getMediaStatus()) == null || mediaStatus.getLiveSeekableRange() == null) {
            return null;
        }
        return Long.valueOf(remoteMediaClient.getApproximateLiveSeekableRangeStart());
    }

    public final Long zzi() {
        MediaMetadata zzo;
        Long zzj;
        RemoteMediaClient remoteMediaClient = this.zza;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || !this.zza.isLiveStream() || (zzo = zzo()) == null || !zzo.containsKey(MediaMetadata.KEY_SECTION_DURATION) || (zzj = zzj()) == null) {
            return null;
        }
        return Long.valueOf(zzj.longValue() + zzo.getTimeMillis(MediaMetadata.KEY_SECTION_DURATION));
    }

    public final Long zzj() {
        RemoteMediaClient remoteMediaClient = this.zza;
        if (remoteMediaClient != null && remoteMediaClient.hasMediaSession() && this.zza.isLiveStream()) {
            RemoteMediaClient remoteMediaClient2 = this.zza;
            MediaInfo mediaInfo = remoteMediaClient2.getMediaInfo();
            MediaMetadata zzo = zzo();
            if (mediaInfo != null && zzo != null && zzo.containsKey(MediaMetadata.KEY_SECTION_START_TIME_IN_MEDIA) && (zzo.containsKey(MediaMetadata.KEY_SECTION_DURATION) || remoteMediaClient2.zzq())) {
                return Long.valueOf(zzo.getTimeMillis(MediaMetadata.KEY_SECTION_START_TIME_IN_MEDIA));
            }
        }
        return null;
    }

    public final Long zzk() {
        MediaInfo mediaInfo;
        RemoteMediaClient remoteMediaClient = this.zza;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || !this.zza.isLiveStream() || (mediaInfo = this.zza.getMediaInfo()) == null || mediaInfo.getStartAbsoluteTime() == -1) {
            return null;
        }
        return Long.valueOf(mediaInfo.getStartAbsoluteTime());
    }

    public final String zzl(long j10) {
        RemoteMediaClient remoteMediaClient = this.zza;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            return null;
        }
        RemoteMediaClient remoteMediaClient2 = this.zza;
        if (((remoteMediaClient2 == null || !remoteMediaClient2.hasMediaSession() || !this.zza.isLiveStream() || zzk() == null) ? 1 : 2) - 1 != 1) {
            return (remoteMediaClient2.isLiveStream() && zzj() == null) ? zzp(j10) : zzp(j10 - zze());
        }
        return DateFormat.getTimeInstance().format(new Date(((Long) Preconditions.checkNotNull(zzk())).longValue() + j10));
    }

    public final boolean zzm() {
        return zzn(zza() + zze());
    }

    public final boolean zzn(long j10) {
        RemoteMediaClient remoteMediaClient = this.zza;
        return remoteMediaClient != null && remoteMediaClient.hasMediaSession() && this.zza.zzq() && (((long) zzc()) + zze()) - j10 < NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS;
    }
}
