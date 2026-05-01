package com.google.android.gms.cast.framework.media;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.cast.AdBreakInfo;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaError;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaLoadOptions;
import com.google.android.gms.cast.MediaLoadRequestData;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaSeekOptions;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.SessionState;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.cast.zzco;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class RemoteMediaClient implements Cast.MessageReceivedCallback {

    @RecentlyNonNull
    public static final String NAMESPACE = com.google.android.gms.cast.internal.zzap.zzb;
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_FAILED = 2100;
    public static final int STATUS_REPLACED = 2103;
    public static final int STATUS_SUCCEEDED = 0;
    private final com.google.android.gms.cast.internal.zzap zzd;
    private final zzbg zze;
    private final MediaQueue zzf;
    private com.google.android.gms.cast.zzr zzg;
    private ParseAdsInfoCallback zzk;
    private final List<Listener> zzh = new CopyOnWriteArrayList();

    @VisibleForTesting
    final List<Callback> zza = new CopyOnWriteArrayList();
    private final Map<ProgressListener, zzbq> zzi = new ConcurrentHashMap();
    private final Map<Long, zzbq> zzj = new ConcurrentHashMap();
    private final Object zzb = new Object();
    private final Handler zzc = new zzco(Looper.getMainLooper());

    public static abstract class Callback {
        public void onAdBreakStatusUpdated() {
        }

        public void onMediaError(@RecentlyNonNull MediaError mediaError) {
        }

        public void onMetadataUpdated() {
        }

        public void onPreloadStatusUpdated() {
        }

        public void onQueueStatusUpdated() {
        }

        public void onSendingRemoteMediaRequest() {
        }

        public void onStatusUpdated() {
        }

        public void zza(@RecentlyNonNull int[] iArr) {
        }

        public void zzb(@RecentlyNonNull int[] iArr, int i10) {
        }

        public void zzc(@RecentlyNonNull MediaQueueItem[] mediaQueueItemArr) {
        }

        public void zzd(@RecentlyNonNull int[] iArr) {
        }

        public void zze(@RecentlyNonNull List<Integer> list, @RecentlyNonNull List<Integer> list2, int i10) {
        }

        public void zzf(@RecentlyNonNull int[] iArr) {
        }

        public void zzg() {
        }
    }

    @Deprecated
    public interface Listener {
        void onAdBreakStatusUpdated();

        void onMetadataUpdated();

        void onPreloadStatusUpdated();

        void onQueueStatusUpdated();

        void onSendingRemoteMediaRequest();

        void onStatusUpdated();
    }

    public interface MediaChannelResult extends Result {
        @RecentlyNullable
        JSONObject getCustomData();

        @RecentlyNullable
        MediaError getMediaError();
    }

    public interface ParseAdsInfoCallback {
        @RecentlyNonNull
        List<AdBreakInfo> parseAdBreaksFromMediaStatus(@RecentlyNonNull MediaStatus mediaStatus);

        boolean parseIsPlayingAdFromMediaStatus(@RecentlyNonNull MediaStatus mediaStatus);
    }

    public interface ProgressListener {
        void onProgressUpdated(long j10, long j11);
    }

    public RemoteMediaClient(com.google.android.gms.cast.internal.zzap zzapVar) {
        zzbg zzbgVar = new zzbg(this);
        this.zze = zzbgVar;
        com.google.android.gms.cast.internal.zzap zzapVar2 = (com.google.android.gms.cast.internal.zzap) Preconditions.checkNotNull(zzapVar);
        this.zzd = zzapVar2;
        zzapVar2.zzS(new zzbo(this, null));
        zzapVar2.zzh(zzbgVar);
        this.zzf = new MediaQueue(this, 20, 20);
    }

    @RecentlyNonNull
    public static PendingResult<MediaChannelResult> zzd(int i10, String str) {
        zzbi zzbiVar = new zzbi();
        zzbiVar.setResult(new zzbh(zzbiVar, new Status(i10, str)));
        return zzbiVar;
    }

    public static /* bridge */ /* synthetic */ void zzl(RemoteMediaClient remoteMediaClient) {
        for (zzbq zzbqVar : remoteMediaClient.zzj.values()) {
            if (remoteMediaClient.hasMediaSession() && !zzbqVar.zzi()) {
                zzbqVar.zzf();
            } else if (!remoteMediaClient.hasMediaSession() && zzbqVar.zzi()) {
                zzbqVar.zzg();
            }
            if (zzbqVar.zzi() && (remoteMediaClient.isBuffering() || remoteMediaClient.zzp() || remoteMediaClient.isPaused() || remoteMediaClient.isLoadingNextItem())) {
                remoteMediaClient.zzr(zzbqVar.zzb);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzr(Set<ProgressListener> set) {
        MediaInfo media;
        HashSet hashSet = new HashSet(set);
        if (isPlaying() || isPaused() || isBuffering() || zzp()) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((ProgressListener) it.next()).onProgressUpdated(getApproximateStreamPosition(), getStreamDuration());
            }
        } else {
            if (!isLoadingNextItem()) {
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    ((ProgressListener) it2.next()).onProgressUpdated(0L, 0L);
                }
                return;
            }
            MediaQueueItem loadingItem = getLoadingItem();
            if (loadingItem == null || (media = loadingItem.getMedia()) == null) {
                return;
            }
            Iterator it3 = hashSet.iterator();
            while (it3.hasNext()) {
                ((ProgressListener) it3.next()).onProgressUpdated(0L, media.getStreamDuration());
            }
        }
    }

    private final boolean zzs() {
        return this.zzg != null;
    }

    private static final zzbl zzt(zzbl zzblVar) {
        try {
            zzblVar.zzc();
        } catch (IllegalArgumentException e10) {
            throw e10;
        } catch (Throwable unused) {
            zzblVar.setResult(new zzbk(zzblVar, new Status(2100)));
        }
        return zzblVar;
    }

    @Deprecated
    public void addListener(@RecentlyNonNull Listener listener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (listener != null) {
            this.zzh.add(listener);
        }
    }

    public boolean addProgressListener(@RecentlyNonNull ProgressListener progressListener, long j10) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (progressListener == null || this.zzi.containsKey(progressListener)) {
            return false;
        }
        Map<Long, zzbq> map = this.zzj;
        Long valueOf = Long.valueOf(j10);
        zzbq zzbqVar = map.get(valueOf);
        if (zzbqVar == null) {
            zzbqVar = new zzbq(this, j10);
            this.zzj.put(valueOf, zzbqVar);
        }
        zzbqVar.zzd(progressListener);
        this.zzi.put(progressListener, zzbqVar);
        if (!hasMediaSession()) {
            return true;
        }
        zzbqVar.zzf();
        return true;
    }

    public long getApproximateAdBreakClipPositionMs() {
        long zzj;
        synchronized (this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            zzj = this.zzd.zzj();
        }
        return zzj;
    }

    public long getApproximateLiveSeekableRangeEnd() {
        long zzk;
        synchronized (this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            zzk = this.zzd.zzk();
        }
        return zzk;
    }

    public long getApproximateLiveSeekableRangeStart() {
        long zzl;
        synchronized (this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            zzl = this.zzd.zzl();
        }
        return zzl;
    }

    public long getApproximateStreamPosition() {
        long zzm;
        synchronized (this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            zzm = this.zzd.zzm();
        }
        return zzm;
    }

    @RecentlyNullable
    public MediaQueueItem getCurrentItem() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        if (mediaStatus == null) {
            return null;
        }
        return mediaStatus.getQueueItemById(mediaStatus.getCurrentItemId());
    }

    public int getIdleReason() {
        int idleReason;
        synchronized (this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            MediaStatus mediaStatus = getMediaStatus();
            idleReason = mediaStatus != null ? mediaStatus.getIdleReason() : 0;
        }
        return idleReason;
    }

    @RecentlyNullable
    public MediaQueueItem getLoadingItem() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        if (mediaStatus == null) {
            return null;
        }
        return mediaStatus.getQueueItemById(mediaStatus.getLoadingItemId());
    }

    @RecentlyNullable
    public MediaInfo getMediaInfo() {
        MediaInfo zzK;
        synchronized (this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            zzK = this.zzd.zzK();
        }
        return zzK;
    }

    @RecentlyNonNull
    public MediaQueue getMediaQueue() {
        MediaQueue mediaQueue;
        synchronized (this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            mediaQueue = this.zzf;
        }
        return mediaQueue;
    }

    @RecentlyNullable
    public MediaStatus getMediaStatus() {
        MediaStatus zzL;
        synchronized (this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            zzL = this.zzd.zzL();
        }
        return zzL;
    }

    @RecentlyNonNull
    public String getNamespace() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzd.zze();
    }

    public int getPlayerState() {
        int playerState;
        synchronized (this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            MediaStatus mediaStatus = getMediaStatus();
            playerState = mediaStatus != null ? mediaStatus.getPlayerState() : 1;
        }
        return playerState;
    }

    @RecentlyNullable
    public MediaQueueItem getPreloadedItem() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        if (mediaStatus == null) {
            return null;
        }
        return mediaStatus.getQueueItemById(mediaStatus.getPreloadedItemId());
    }

    public long getStreamDuration() {
        long zzo;
        synchronized (this.zzb) {
            Preconditions.checkMainThread("Must be called from the main thread.");
            zzo = this.zzd.zzo();
        }
        return zzo;
    }

    public boolean hasMediaSession() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return isBuffering() || zzp() || isPlaying() || isPaused() || isLoadingNextItem();
    }

    public boolean isBuffering() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        return mediaStatus != null && mediaStatus.getPlayerState() == 4;
    }

    public boolean isLiveStream() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaInfo mediaInfo = getMediaInfo();
        return mediaInfo != null && mediaInfo.getStreamType() == 2;
    }

    public boolean isLoadingNextItem() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        return (mediaStatus == null || mediaStatus.getLoadingItemId() == 0) ? false : true;
    }

    public boolean isPaused() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        if (mediaStatus == null) {
            return false;
        }
        if (mediaStatus.getPlayerState() != 3) {
            return isLiveStream() && getIdleReason() == 2;
        }
        return true;
    }

    public boolean isPlaying() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        return mediaStatus != null && mediaStatus.getPlayerState() == 2;
    }

    public boolean isPlayingAd() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        return mediaStatus != null && mediaStatus.isPlayingAd();
    }

    @RecentlyNonNull
    @Deprecated
    public PendingResult<MediaChannelResult> load(@RecentlyNonNull MediaInfo mediaInfo) {
        return load(mediaInfo, new MediaLoadOptions.Builder().build());
    }

    @Override // com.google.android.gms.cast.Cast.MessageReceivedCallback
    public void onMessageReceived(@RecentlyNonNull CastDevice castDevice, @RecentlyNonNull String str, @RecentlyNonNull String str2) {
        this.zzd.zzQ(str2);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> pause() {
        return pause(null);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> play() {
        return play(null);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueAppendItem(@RecentlyNonNull MediaQueueItem mediaQueueItem, @RecentlyNonNull JSONObject jSONObject) {
        return queueInsertItems(new MediaQueueItem[]{mediaQueueItem}, 0, jSONObject);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueInsertAndPlayItem(@RecentlyNonNull MediaQueueItem mediaQueueItem, int i10, long j10, @RecentlyNonNull JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, null);
        }
        zzai zzaiVar = new zzai(this, mediaQueueItem, i10, j10, jSONObject);
        zzt(zzaiVar);
        return zzaiVar;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueInsertItems(@RecentlyNonNull MediaQueueItem[] mediaQueueItemArr, int i10, @RecentlyNonNull JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, null);
        }
        zzah zzahVar = new zzah(this, mediaQueueItemArr, i10, jSONObject);
        zzt(zzahVar);
        return zzahVar;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueJumpToItem(int i10, long j10, @RecentlyNonNull JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, null);
        }
        zzar zzarVar = new zzar(this, i10, j10, jSONObject);
        zzt(zzarVar);
        return zzarVar;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueLoad(@RecentlyNonNull MediaQueueItem[] mediaQueueItemArr, int i10, int i11, long j10, @RecentlyNonNull JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, null);
        }
        zzag zzagVar = new zzag(this, mediaQueueItemArr, i10, i11, j10, jSONObject);
        zzt(zzagVar);
        return zzagVar;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueMoveItemToNewIndex(int i10, int i11, @RecentlyNonNull JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, null);
        }
        zzas zzasVar = new zzas(this, i10, i11, jSONObject);
        zzt(zzasVar);
        return zzasVar;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueNext(JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, null);
        }
        zzao zzaoVar = new zzao(this, jSONObject);
        zzt(zzaoVar);
        return zzaoVar;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queuePrev(JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, null);
        }
        zzan zzanVar = new zzan(this, jSONObject);
        zzt(zzanVar);
        return zzanVar;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueRemoveItem(int i10, @RecentlyNonNull JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, null);
        }
        zzaq zzaqVar = new zzaq(this, i10, jSONObject);
        zzt(zzaqVar);
        return zzaqVar;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueRemoveItems(@RecentlyNonNull int[] iArr, @RecentlyNonNull JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, null);
        }
        zzak zzakVar = new zzak(this, iArr, jSONObject);
        zzt(zzakVar);
        return zzakVar;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueReorderItems(@RecentlyNonNull int[] iArr, int i10, @RecentlyNonNull JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, null);
        }
        zzal zzalVar = new zzal(this, iArr, i10, jSONObject);
        zzt(zzalVar);
        return zzalVar;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueSetRepeatMode(int i10, JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, null);
        }
        zzap zzapVar = new zzap(this, i10, jSONObject);
        zzt(zzapVar);
        return zzapVar;
    }

    @RecentlyNonNull
    @ShowFirstParty
    @KeepForSdk
    public PendingResult<MediaChannelResult> queueShuffle(JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, null);
        }
        zzam zzamVar = new zzam(this, jSONObject);
        zzt(zzamVar);
        return zzamVar;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueUpdateItems(@RecentlyNonNull MediaQueueItem[] mediaQueueItemArr, @RecentlyNonNull JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, null);
        }
        zzaj zzajVar = new zzaj(this, mediaQueueItemArr, jSONObject);
        zzt(zzajVar);
        return zzajVar;
    }

    public void registerCallback(@RecentlyNonNull Callback callback) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (callback != null) {
            this.zza.add(callback);
        }
    }

    @Deprecated
    public void removeListener(@RecentlyNonNull Listener listener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (listener != null) {
            this.zzh.remove(listener);
        }
    }

    public void removeProgressListener(@RecentlyNonNull ProgressListener progressListener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzbq remove = this.zzi.remove(progressListener);
        if (remove != null) {
            remove.zze(progressListener);
            if (remove.zzh()) {
                return;
            }
            this.zzj.remove(Long.valueOf(remove.zzb()));
            remove.zzg();
        }
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> requestStatus() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, null);
        }
        zzad zzadVar = new zzad(this);
        zzt(zzadVar);
        return zzadVar;
    }

    @RecentlyNonNull
    @Deprecated
    public PendingResult<MediaChannelResult> seek(long j10) {
        return seek(j10, 0, null);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> setActiveMediaTracks(@RecentlyNonNull long[] jArr) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, null);
        }
        zzae zzaeVar = new zzae(this, jArr);
        zzt(zzaeVar);
        return zzaeVar;
    }

    public void setParseAdsInfoCallback(@RecentlyNonNull ParseAdsInfoCallback parseAdsInfoCallback) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.zzk = parseAdsInfoCallback;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> setPlaybackRate(double d10) {
        return setPlaybackRate(d10, null);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> setStreamMute(boolean z10) {
        return setStreamMute(z10, null);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> setStreamVolume(double d10) {
        return setStreamVolume(d10, null);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> setTextTrackStyle(@RecentlyNonNull TextTrackStyle textTrackStyle) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, null);
        }
        zzaf zzafVar = new zzaf(this, textTrackStyle);
        zzt(zzafVar);
        return zzafVar;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> skipAd() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, null);
        }
        zzac zzacVar = new zzac(this);
        zzt(zzacVar);
        return zzacVar;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> stop() {
        return stop(null);
    }

    public void togglePlayback() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        int playerState = getPlayerState();
        if (playerState == 4 || playerState == 2) {
            pause();
        } else {
            play();
        }
    }

    public void unregisterCallback(@RecentlyNonNull Callback callback) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (callback != null) {
            this.zza.remove(callback);
        }
    }

    @RecentlyNonNull
    public final PendingResult<MediaChannelResult> zze(String str, List list) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, null);
        }
        zzax zzaxVar = new zzax(this, true, str, null);
        zzt(zzaxVar);
        return zzaxVar;
    }

    @RecentlyNonNull
    public final PendingResult<MediaChannelResult> zzf(int i10, int i11, int i12) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, null);
        }
        zzav zzavVar = new zzav(this, true, i10, i11, i12);
        zzt(zzavVar);
        return zzavVar;
    }

    @RecentlyNonNull
    public final PendingResult<MediaChannelResult> zzg() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, null);
        }
        zzat zzatVar = new zzat(this, true);
        zzt(zzatVar);
        return zzatVar;
    }

    @RecentlyNonNull
    public final PendingResult<MediaChannelResult> zzh(@RecentlyNonNull int[] iArr) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, null);
        }
        zzau zzauVar = new zzau(this, true, iArr);
        zzt(zzauVar);
        return zzauVar;
    }

    @RecentlyNonNull
    public final Task<SessionState> zzi(JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return Tasks.forException(new com.google.android.gms.cast.internal.zzan());
        }
        SessionState sessionState = null;
        if (((MediaStatus) Preconditions.checkNotNull(getMediaStatus())).isMediaCommandSupported(MediaStatus.COMMAND_STREAM_TRANSFER)) {
            return this.zzd.zzN(null);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        MediaInfo mediaInfo = getMediaInfo();
        MediaStatus mediaStatus = getMediaStatus();
        if (mediaInfo != null && mediaStatus != null) {
            MediaLoadRequestData.Builder builder = new MediaLoadRequestData.Builder();
            builder.setMediaInfo(mediaInfo);
            builder.setCurrentTime(getApproximateStreamPosition());
            builder.setQueueData(mediaStatus.getQueueData());
            builder.setPlaybackRate(mediaStatus.getPlaybackRate());
            builder.setActiveTrackIds(mediaStatus.getActiveTrackIds());
            builder.setCustomData(mediaStatus.getCustomData());
            MediaLoadRequestData build = builder.build();
            SessionState.Builder builder2 = new SessionState.Builder();
            builder2.setLoadRequestData(build);
            sessionState = builder2.build();
        }
        taskCompletionSource.setResult(sessionState);
        return taskCompletionSource.getTask();
    }

    public final void zzn() {
        com.google.android.gms.cast.zzr zzrVar = this.zzg;
        if (zzrVar == null) {
            return;
        }
        zzrVar.zzi(getNamespace(), this);
        requestStatus();
    }

    public final void zzo(com.google.android.gms.cast.zzr zzrVar) {
        com.google.android.gms.cast.zzr zzrVar2 = this.zzg;
        if (zzrVar2 == zzrVar) {
            return;
        }
        if (zzrVar2 != null) {
            this.zzd.zzf();
            this.zzf.zzl();
            zzrVar2.zzg(getNamespace());
            this.zze.zzc(null);
            this.zzc.removeCallbacksAndMessages(null);
        }
        this.zzg = zzrVar;
        if (zzrVar != null) {
            this.zze.zzc(zzrVar);
        }
    }

    public final boolean zzp() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        MediaStatus mediaStatus = getMediaStatus();
        return mediaStatus != null && mediaStatus.getPlayerState() == 5;
    }

    public final boolean zzq() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!isLiveStream()) {
            return true;
        }
        MediaStatus mediaStatus = getMediaStatus();
        return (mediaStatus == null || !mediaStatus.isMediaCommandSupported(2L) || mediaStatus.getLiveSeekableRange() == null) ? false : true;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> load(@RecentlyNonNull MediaInfo mediaInfo, @RecentlyNonNull MediaLoadOptions mediaLoadOptions) {
        MediaLoadRequestData.Builder builder = new MediaLoadRequestData.Builder();
        builder.setMediaInfo(mediaInfo);
        builder.setAutoplay(Boolean.valueOf(mediaLoadOptions.getAutoplay()));
        builder.setCurrentTime(mediaLoadOptions.getPlayPosition());
        builder.setPlaybackRate(mediaLoadOptions.getPlaybackRate());
        builder.setActiveTrackIds(mediaLoadOptions.getActiveTrackIds());
        builder.setCustomData(mediaLoadOptions.getCustomData());
        builder.setCredentials(mediaLoadOptions.getCredentials());
        builder.setCredentialsType(mediaLoadOptions.getCredentialsType());
        return load(builder.build());
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> pause(JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, null);
        }
        zzay zzayVar = new zzay(this, jSONObject);
        zzt(zzayVar);
        return zzayVar;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> play(JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, null);
        }
        zzba zzbaVar = new zzba(this, jSONObject);
        zzt(zzbaVar);
        return zzbaVar;
    }

    @RecentlyNonNull
    @Deprecated
    public PendingResult<MediaChannelResult> seek(long j10, int i10) {
        return seek(j10, i10, null);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> setPlaybackRate(double d10, JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, null);
        }
        zzbe zzbeVar = new zzbe(this, d10, jSONObject);
        zzt(zzbeVar);
        return zzbeVar;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> setStreamMute(boolean z10, JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, null);
        }
        zzbd zzbdVar = new zzbd(this, z10, jSONObject);
        zzt(zzbdVar);
        return zzbdVar;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> setStreamVolume(double d10, JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, null);
        }
        zzbc zzbcVar = new zzbc(this, d10, jSONObject);
        zzt(zzbcVar);
        return zzbcVar;
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> stop(JSONObject jSONObject) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, null);
        }
        zzaz zzazVar = new zzaz(this, jSONObject);
        zzt(zzazVar);
        return zzazVar;
    }

    @RecentlyNonNull
    @Deprecated
    public PendingResult<MediaChannelResult> seek(long j10, int i10, JSONObject jSONObject) {
        MediaSeekOptions.Builder builder = new MediaSeekOptions.Builder();
        builder.setPosition(j10);
        builder.setResumeState(i10);
        builder.setCustomData(jSONObject);
        return seek(builder.build());
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueInsertAndPlayItem(@RecentlyNonNull MediaQueueItem mediaQueueItem, int i10, @RecentlyNonNull JSONObject jSONObject) {
        return queueInsertAndPlayItem(mediaQueueItem, i10, -1L, jSONObject);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueJumpToItem(int i10, @RecentlyNonNull JSONObject jSONObject) {
        return queueJumpToItem(i10, -1L, jSONObject);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> queueLoad(@RecentlyNonNull MediaQueueItem[] mediaQueueItemArr, int i10, int i11, @RecentlyNonNull JSONObject jSONObject) {
        return queueLoad(mediaQueueItemArr, i10, i11, -1L, jSONObject);
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> seek(@RecentlyNonNull MediaSeekOptions mediaSeekOptions) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, null);
        }
        zzbb zzbbVar = new zzbb(this, mediaSeekOptions);
        zzt(zzbbVar);
        return zzbbVar;
    }

    @RecentlyNonNull
    @Deprecated
    public PendingResult<MediaChannelResult> load(@RecentlyNonNull MediaInfo mediaInfo, boolean z10) {
        MediaLoadOptions.Builder builder = new MediaLoadOptions.Builder();
        builder.setAutoplay(z10);
        return load(mediaInfo, builder.build());
    }

    @RecentlyNonNull
    @Deprecated
    public PendingResult<MediaChannelResult> load(@RecentlyNonNull MediaInfo mediaInfo, boolean z10, long j10) {
        MediaLoadOptions.Builder builder = new MediaLoadOptions.Builder();
        builder.setAutoplay(z10);
        builder.setPlayPosition(j10);
        return load(mediaInfo, builder.build());
    }

    @RecentlyNonNull
    @Deprecated
    public PendingResult<MediaChannelResult> load(@RecentlyNonNull MediaInfo mediaInfo, boolean z10, long j10, @RecentlyNonNull JSONObject jSONObject) {
        MediaLoadOptions.Builder builder = new MediaLoadOptions.Builder();
        builder.setAutoplay(z10);
        builder.setPlayPosition(j10);
        builder.setCustomData(jSONObject);
        return load(mediaInfo, builder.build());
    }

    @RecentlyNonNull
    @Deprecated
    public PendingResult<MediaChannelResult> load(@RecentlyNonNull MediaInfo mediaInfo, boolean z10, long j10, @RecentlyNonNull long[] jArr, @RecentlyNonNull JSONObject jSONObject) {
        MediaLoadOptions.Builder builder = new MediaLoadOptions.Builder();
        builder.setAutoplay(z10);
        builder.setPlayPosition(j10);
        builder.setActiveTrackIds(jArr);
        builder.setCustomData(jSONObject);
        return load(mediaInfo, builder.build());
    }

    @RecentlyNonNull
    public PendingResult<MediaChannelResult> load(@RecentlyNonNull MediaLoadRequestData mediaLoadRequestData) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (!zzs()) {
            return zzd(17, null);
        }
        zzaw zzawVar = new zzaw(this, mediaLoadRequestData);
        zzt(zzawVar);
        return zzawVar;
    }
}
