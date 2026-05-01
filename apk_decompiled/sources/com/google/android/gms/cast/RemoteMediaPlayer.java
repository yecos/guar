package com.google.android.gms.cast;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes.dex */
public class RemoteMediaPlayer implements Cast.MessageReceivedCallback {

    @RecentlyNonNull
    public static final String NAMESPACE = com.google.android.gms.cast.internal.zzap.zzb;
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_CANCELED = 2101;
    public static final int STATUS_FAILED = 2100;
    public static final int STATUS_REPLACED = 2103;
    public static final int STATUS_SUCCEEDED = 0;
    public static final int STATUS_TIMED_OUT = 2102;
    private final Object zza;
    private final com.google.android.gms.cast.internal.zzap zzb;
    private final zzdi zzc;
    private OnPreloadStatusUpdatedListener zzd;
    private OnQueueStatusUpdatedListener zze;
    private OnMetadataUpdatedListener zzf;
    private OnStatusUpdatedListener zzg;

    @Deprecated
    public interface MediaChannelResult extends Result {
        @RecentlyNullable
        JSONObject getCustomData();
    }

    @Deprecated
    public interface OnMetadataUpdatedListener {
        void onMetadataUpdated();
    }

    @Deprecated
    public interface OnPreloadStatusUpdatedListener {
        void onPreloadStatusUpdated();
    }

    @Deprecated
    public interface OnQueueStatusUpdatedListener {
        void onQueueStatusUpdated();
    }

    @Deprecated
    public interface OnStatusUpdatedListener {
        void onStatusUpdated();
    }

    public RemoteMediaPlayer() {
        com.google.android.gms.cast.internal.zzap zzapVar = new com.google.android.gms.cast.internal.zzap(null);
        this.zza = new Object();
        this.zzb = zzapVar;
        zzapVar.zzS(new zzcu(this));
        zzdi zzdiVar = new zzdi(this);
        this.zzc = zzdiVar;
        zzapVar.zzh(zzdiVar);
    }

    public static /* bridge */ /* synthetic */ int zza(RemoteMediaPlayer remoteMediaPlayer, int i10) {
        MediaStatus mediaStatus = remoteMediaPlayer.getMediaStatus();
        if (mediaStatus == null) {
            return -1;
        }
        for (int i11 = 0; i11 < mediaStatus.getQueueItemCount(); i11++) {
            MediaQueueItem queueItem = mediaStatus.getQueueItem(i11);
            if (queueItem != null && queueItem.getItemId() == i10) {
                return i11;
            }
        }
        return -1;
    }

    public static /* bridge */ /* synthetic */ void zze(RemoteMediaPlayer remoteMediaPlayer) {
        OnMetadataUpdatedListener onMetadataUpdatedListener = remoteMediaPlayer.zzf;
        if (onMetadataUpdatedListener != null) {
            onMetadataUpdatedListener.onMetadataUpdated();
        }
    }

    public static /* bridge */ /* synthetic */ void zzf(RemoteMediaPlayer remoteMediaPlayer) {
        OnPreloadStatusUpdatedListener onPreloadStatusUpdatedListener = remoteMediaPlayer.zzd;
        if (onPreloadStatusUpdatedListener != null) {
            onPreloadStatusUpdatedListener.onPreloadStatusUpdated();
        }
    }

    public static /* bridge */ /* synthetic */ void zzg(RemoteMediaPlayer remoteMediaPlayer) {
        OnQueueStatusUpdatedListener onQueueStatusUpdatedListener = remoteMediaPlayer.zze;
        if (onQueueStatusUpdatedListener != null) {
            onQueueStatusUpdatedListener.onQueueStatusUpdated();
        }
    }

    public static /* bridge */ /* synthetic */ void zzh(RemoteMediaPlayer remoteMediaPlayer) {
        OnStatusUpdatedListener onStatusUpdatedListener = remoteMediaPlayer.zzg;
        if (onStatusUpdatedListener != null) {
            onStatusUpdatedListener.onStatusUpdated();
        }
    }

    public long getApproximateStreamPosition() {
        long zzm;
        synchronized (this.zza) {
            zzm = this.zzb.zzm();
        }
        return zzm;
    }

    @RecentlyNullable
    public MediaInfo getMediaInfo() {
        MediaInfo zzK;
        synchronized (this.zza) {
            zzK = this.zzb.zzK();
        }
        return zzK;
    }

    @RecentlyNullable
    public MediaStatus getMediaStatus() {
        MediaStatus zzL;
        synchronized (this.zza) {
            zzL = this.zzb.zzL();
        }
        return zzL;
    }

    @RecentlyNonNull
    public String getNamespace() {
        return this.zzb.zze();
    }

    public long getStreamDuration() {
        long zzo;
        synchronized (this.zza) {
            zzo = this.zzb.zzo();
        }
        return zzo;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> load(@RecentlyNonNull GoogleApiClient googleApiClient, @RecentlyNonNull MediaInfo mediaInfo) {
        return load(googleApiClient, mediaInfo, true, -1L, null, null);
    }

    @Override // com.google.android.gms.cast.Cast.MessageReceivedCallback
    public void onMessageReceived(@RecentlyNonNull CastDevice castDevice, @RecentlyNonNull String str, @RecentlyNonNull String str2) {
        this.zzb.zzQ(str2);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> pause(@RecentlyNonNull GoogleApiClient googleApiClient) {
        return pause(googleApiClient, null);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> play(@RecentlyNonNull GoogleApiClient googleApiClient) {
        return play(googleApiClient, null);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueAppendItem(@RecentlyNonNull GoogleApiClient googleApiClient, @RecentlyNonNull MediaQueueItem mediaQueueItem, @RecentlyNonNull JSONObject jSONObject) {
        return queueInsertItems(googleApiClient, new MediaQueueItem[]{mediaQueueItem}, 0, jSONObject);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueInsertAndPlayItem(@RecentlyNonNull GoogleApiClient googleApiClient, @RecentlyNonNull MediaQueueItem mediaQueueItem, int i10, long j10, JSONObject jSONObject) {
        return googleApiClient.execute(new zzco(this, googleApiClient, mediaQueueItem, i10, j10, jSONObject));
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueInsertItems(@RecentlyNonNull GoogleApiClient googleApiClient, @RecentlyNonNull MediaQueueItem[] mediaQueueItemArr, int i10, JSONObject jSONObject) {
        return googleApiClient.execute(new zzcn(this, googleApiClient, mediaQueueItemArr, i10, jSONObject));
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueJumpToItem(@RecentlyNonNull GoogleApiClient googleApiClient, int i10, long j10, JSONObject jSONObject) {
        return googleApiClient.execute(new zzcx(this, googleApiClient, i10, j10, jSONObject));
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueLoad(@RecentlyNonNull GoogleApiClient googleApiClient, @RecentlyNonNull MediaQueueItem[] mediaQueueItemArr, int i10, int i11, long j10, JSONObject jSONObject) {
        return googleApiClient.execute(new zzcm(this, googleApiClient, mediaQueueItemArr, i10, i11, j10, jSONObject));
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueMoveItemToNewIndex(@RecentlyNonNull GoogleApiClient googleApiClient, int i10, int i11, JSONObject jSONObject) {
        return googleApiClient.execute(new zzcy(this, googleApiClient, i10, i11, jSONObject));
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueNext(@RecentlyNonNull GoogleApiClient googleApiClient, JSONObject jSONObject) {
        return googleApiClient.execute(new zzct(this, googleApiClient, jSONObject));
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queuePrev(@RecentlyNonNull GoogleApiClient googleApiClient, JSONObject jSONObject) {
        return googleApiClient.execute(new zzcs(this, googleApiClient, jSONObject));
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueRemoveItem(@RecentlyNonNull GoogleApiClient googleApiClient, int i10, JSONObject jSONObject) {
        return googleApiClient.execute(new zzcw(this, googleApiClient, i10, jSONObject));
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueRemoveItems(@RecentlyNonNull GoogleApiClient googleApiClient, @RecentlyNonNull int[] iArr, JSONObject jSONObject) {
        return googleApiClient.execute(new zzcq(this, googleApiClient, iArr, jSONObject));
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueReorderItems(@RecentlyNonNull GoogleApiClient googleApiClient, @RecentlyNonNull int[] iArr, int i10, JSONObject jSONObject) {
        return googleApiClient.execute(new zzcr(this, googleApiClient, iArr, i10, jSONObject));
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueSetRepeatMode(@RecentlyNonNull GoogleApiClient googleApiClient, int i10, JSONObject jSONObject) {
        return googleApiClient.execute(new zzcv(this, googleApiClient, i10, jSONObject));
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueUpdateItems(@RecentlyNonNull GoogleApiClient googleApiClient, @RecentlyNonNull MediaQueueItem[] mediaQueueItemArr, JSONObject jSONObject) {
        return googleApiClient.execute(new zzcp(this, googleApiClient, mediaQueueItemArr, jSONObject));
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> requestStatus(@RecentlyNonNull GoogleApiClient googleApiClient) {
        return googleApiClient.execute(new zzdg(this, googleApiClient));
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> seek(@RecentlyNonNull GoogleApiClient googleApiClient, long j10) {
        return seek(googleApiClient, j10, 0, null);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> setActiveMediaTracks(@RecentlyNonNull GoogleApiClient googleApiClient, @RecentlyNonNull long[] jArr) {
        return googleApiClient.execute(new zzck(this, googleApiClient, jArr));
    }

    public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener onMetadataUpdatedListener) {
        this.zzf = onMetadataUpdatedListener;
    }

    public void setOnPreloadStatusUpdatedListener(OnPreloadStatusUpdatedListener onPreloadStatusUpdatedListener) {
        this.zzd = onPreloadStatusUpdatedListener;
    }

    public void setOnQueueStatusUpdatedListener(OnQueueStatusUpdatedListener onQueueStatusUpdatedListener) {
        this.zze = onQueueStatusUpdatedListener;
    }

    public void setOnStatusUpdatedListener(OnStatusUpdatedListener onStatusUpdatedListener) {
        this.zzg = onStatusUpdatedListener;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> setStreamMute(@RecentlyNonNull GoogleApiClient googleApiClient, boolean z10) {
        return setStreamMute(googleApiClient, z10, null);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> setStreamVolume(@RecentlyNonNull GoogleApiClient googleApiClient, double d10) {
        return setStreamVolume(googleApiClient, d10, null);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> setTextTrackStyle(@RecentlyNonNull GoogleApiClient googleApiClient, @RecentlyNonNull TextTrackStyle textTrackStyle) {
        return googleApiClient.execute(new zzcl(this, googleApiClient, textTrackStyle));
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> stop(@RecentlyNonNull GoogleApiClient googleApiClient) {
        return stop(googleApiClient, null);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> load(@RecentlyNonNull GoogleApiClient googleApiClient, @RecentlyNonNull MediaInfo mediaInfo, boolean z10) {
        return load(googleApiClient, mediaInfo, z10, -1L, null, null);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> pause(@RecentlyNonNull GoogleApiClient googleApiClient, JSONObject jSONObject) {
        return googleApiClient.execute(new zzda(this, googleApiClient, jSONObject));
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> play(@RecentlyNonNull GoogleApiClient googleApiClient, JSONObject jSONObject) {
        return googleApiClient.execute(new zzdc(this, googleApiClient, jSONObject));
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueInsertAndPlayItem(@RecentlyNonNull GoogleApiClient googleApiClient, @RecentlyNonNull MediaQueueItem mediaQueueItem, int i10, JSONObject jSONObject) {
        return queueInsertAndPlayItem(googleApiClient, mediaQueueItem, i10, -1L, jSONObject);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueJumpToItem(@RecentlyNonNull GoogleApiClient googleApiClient, int i10, JSONObject jSONObject) {
        return queueJumpToItem(googleApiClient, i10, -1L, jSONObject);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueLoad(@RecentlyNonNull GoogleApiClient googleApiClient, @RecentlyNonNull MediaQueueItem[] mediaQueueItemArr, int i10, int i11, JSONObject jSONObject) {
        return queueLoad(googleApiClient, mediaQueueItemArr, i10, i11, -1L, jSONObject);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> seek(@RecentlyNonNull GoogleApiClient googleApiClient, long j10, int i10) {
        return seek(googleApiClient, j10, i10, null);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> setStreamMute(@RecentlyNonNull GoogleApiClient googleApiClient, boolean z10, JSONObject jSONObject) {
        return googleApiClient.execute(new zzdf(this, googleApiClient, z10, jSONObject));
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> setStreamVolume(@RecentlyNonNull GoogleApiClient googleApiClient, double d10, JSONObject jSONObject) {
        return googleApiClient.execute(new zzde(this, googleApiClient, d10, jSONObject));
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> stop(@RecentlyNonNull GoogleApiClient googleApiClient, JSONObject jSONObject) {
        return googleApiClient.execute(new zzdb(this, googleApiClient, jSONObject));
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> load(@RecentlyNonNull GoogleApiClient googleApiClient, @RecentlyNonNull MediaInfo mediaInfo, boolean z10, long j10) {
        return load(googleApiClient, mediaInfo, z10, j10, null, null);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> seek(@RecentlyNonNull GoogleApiClient googleApiClient, long j10, int i10, JSONObject jSONObject) {
        return googleApiClient.execute(new zzdd(this, googleApiClient, j10, i10, jSONObject));
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> load(@RecentlyNonNull GoogleApiClient googleApiClient, @RecentlyNonNull MediaInfo mediaInfo, boolean z10, long j10, JSONObject jSONObject) {
        return load(googleApiClient, mediaInfo, z10, j10, null, jSONObject);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> load(@RecentlyNonNull GoogleApiClient googleApiClient, @RecentlyNonNull MediaInfo mediaInfo, boolean z10, long j10, long[] jArr, JSONObject jSONObject) {
        return googleApiClient.execute(new zzcz(this, googleApiClient, mediaInfo, z10, j10, jArr, jSONObject));
    }
}
