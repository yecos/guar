package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.cast.MediaQueueData;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.cast.internal.media.MediaCommon;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.component.dlna.DLNAControllerImp;
import com.hpplay.component.protocol.PlistBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@VisibleForTesting
@SafeParcelable.Class(creator = "MediaStatusCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public class MediaStatus extends AbstractSafeParcelable {
    public static final long COMMAND_DISLIKE = 32768;
    public static final long COMMAND_EDIT_TRACKS = 4096;
    public static final long COMMAND_FOLLOW = 65536;
    public static final long COMMAND_LIKE = 16384;
    public static final long COMMAND_PAUSE = 1;
    public static final long COMMAND_PLAYBACK_RATE = 8192;
    public static final long COMMAND_QUEUE_NEXT = 64;
    public static final long COMMAND_QUEUE_PREVIOUS = 128;
    public static final long COMMAND_QUEUE_REPEAT = 3072;
    public static final long COMMAND_QUEUE_REPEAT_ALL = 1024;
    public static final long COMMAND_QUEUE_REPEAT_ONE = 2048;
    public static final long COMMAND_QUEUE_SHUFFLE = 256;
    public static final long COMMAND_SEEK = 2;
    public static final long COMMAND_SET_VOLUME = 4;
    public static final long COMMAND_SKIP_AD = 512;

    @Deprecated
    public static final long COMMAND_SKIP_BACKWARD = 32;

    @Deprecated
    public static final long COMMAND_SKIP_FORWARD = 16;

    @ShowFirstParty
    @KeepForSdk
    public static final long COMMAND_STREAM_TRANSFER = 262144;
    public static final long COMMAND_TOGGLE_MUTE = 8;
    public static final long COMMAND_UNFOLLOW = 131072;
    public static final int IDLE_REASON_CANCELED = 2;
    public static final int IDLE_REASON_ERROR = 4;
    public static final int IDLE_REASON_FINISHED = 1;
    public static final int IDLE_REASON_INTERRUPTED = 3;
    public static final int IDLE_REASON_NONE = 0;
    public static final int PLAYER_STATE_BUFFERING = 4;
    public static final int PLAYER_STATE_IDLE = 1;
    public static final int PLAYER_STATE_LOADING = 5;
    public static final int PLAYER_STATE_PAUSED = 3;
    public static final int PLAYER_STATE_PLAYING = 2;
    public static final int PLAYER_STATE_UNKNOWN = 0;
    public static final int REPEAT_MODE_REPEAT_ALL = 1;
    public static final int REPEAT_MODE_REPEAT_ALL_AND_SHUFFLE = 3;
    public static final int REPEAT_MODE_REPEAT_OFF = 0;
    public static final int REPEAT_MODE_REPEAT_SINGLE = 2;

    @VisibleForTesting
    @SafeParcelable.Field(getter = "getMediaInfo", id = 2)
    MediaInfo zza;

    @VisibleForTesting
    @SafeParcelable.Field(getter = "getMediaSessionId", id = 3)
    long zzb;

    @VisibleForTesting
    @SafeParcelable.Field(getter = "getCurrentItemId", id = 4)
    int zzc;

    @VisibleForTesting
    @SafeParcelable.Field(getter = "getPlaybackRate", id = 5)
    double zzd;

    @VisibleForTesting
    @SafeParcelable.Field(getter = "getPlayerState", id = 6)
    int zze;

    @VisibleForTesting
    @SafeParcelable.Field(getter = "getIdleReason", id = 7)
    int zzf;

    @VisibleForTesting
    @SafeParcelable.Field(getter = "getStreamPosition", id = 8)
    long zzg;

    @SafeParcelable.Field(id = 9)
    long zzh;

    @VisibleForTesting
    @SafeParcelable.Field(getter = "getStreamVolume", id = 10)
    double zzi;

    @VisibleForTesting
    @SafeParcelable.Field(getter = "isMute", id = 11)
    boolean zzj;

    @VisibleForTesting
    @SafeParcelable.Field(getter = "getActiveTrackIds", id = 12)
    long[] zzk;

    @VisibleForTesting
    @SafeParcelable.Field(getter = "getLoadingItemId", id = 13)
    int zzl;

    @VisibleForTesting
    @SafeParcelable.Field(getter = "getPreloadedItemId", id = 14)
    int zzm;

    @SafeParcelable.Field(id = 15)
    String zzn;

    @VisibleForTesting
    JSONObject zzo;

    @SafeParcelable.Field(id = 16)
    int zzp;

    @SafeParcelable.Field(id = 17)
    final List<MediaQueueItem> zzq;

    @VisibleForTesting
    @SafeParcelable.Field(getter = "isPlayingAd", id = 18)
    boolean zzr;

    @VisibleForTesting
    @SafeParcelable.Field(getter = "getAdBreakStatus", id = 19)
    AdBreakStatus zzs;

    @VisibleForTesting
    @SafeParcelable.Field(getter = "getVideoInfo", id = 20)
    VideoInfo zzt;

    @VisibleForTesting
    @SafeParcelable.Field(getter = "getLiveSeekableRange", id = 21)
    MediaLiveSeekableRange zzu;

    @VisibleForTesting
    @SafeParcelable.Field(getter = "getQueueData", id = 22)
    MediaQueueData zzv;
    private final SparseArray<Integer> zzx;
    private final Writer zzy;
    private static final Logger zzw = new Logger("MediaStatus");

    @RecentlyNonNull
    @KeepForSdk
    public static final Parcelable.Creator<MediaStatus> CREATOR = new zzci();

    @KeepForSdk
    public static class Builder {
        private MediaInfo zza;
        private long zzb;
        private double zzd;
        private long zzg;
        private long zzh;
        private double zzi;
        private boolean zzj;
        private long[] zzk;
        private JSONObject zzn;
        private boolean zzq;
        private AdBreakStatus zzr;
        private VideoInfo zzs;
        private MediaLiveSeekableRange zzt;
        private MediaQueueData zzu;
        private int zzc = 0;
        private int zze = 0;
        private int zzf = 0;
        private int zzl = 0;
        private int zzm = 0;
        private int zzo = 0;
        private final List<MediaQueueItem> zzp = new ArrayList();

        @RecentlyNonNull
        @KeepForSdk
        public MediaStatus build() {
            MediaStatus mediaStatus = new MediaStatus(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, null, this.zzo, this.zzp, this.zzq, this.zzr, this.zzs, this.zzt, this.zzu);
            mediaStatus.zzo = this.zzn;
            return mediaStatus;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setActiveTrackIds(@RecentlyNonNull long[] jArr) {
            this.zzk = jArr;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setAdBreakStatus(@RecentlyNonNull AdBreakStatus adBreakStatus) {
            this.zzr = adBreakStatus;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setCurrentItemId(int i10) {
            this.zzc = i10;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setCustomData(@RecentlyNonNull JSONObject jSONObject) {
            this.zzn = jSONObject;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setIdleReason(int i10) {
            this.zzf = i10;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setIsMute(boolean z10) {
            this.zzj = z10;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setIsPlayingAd(boolean z10) {
            this.zzq = z10;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setLiveSeekableRange(@RecentlyNonNull MediaLiveSeekableRange mediaLiveSeekableRange) {
            this.zzt = mediaLiveSeekableRange;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setLoadingItemId(int i10) {
            this.zzl = i10;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setMediaInfo(MediaInfo mediaInfo) {
            this.zza = mediaInfo;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setMediaSessionId(long j10) {
            this.zzb = j10;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setPlaybackRate(double d10) {
            this.zzd = d10;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setPlayerState(int i10) {
            this.zze = i10;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setPreloadedItemId(int i10) {
            this.zzm = i10;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setQueueData(@RecentlyNonNull MediaQueueData mediaQueueData) {
            this.zzu = mediaQueueData;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setQueueItems(@RecentlyNonNull List<MediaQueueItem> list) {
            this.zzp.clear();
            this.zzp.addAll(list);
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setQueueRepeatMode(int i10) {
            this.zzo = i10;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setStreamPosition(long j10) {
            this.zzg = j10;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setStreamVolume(double d10) {
            this.zzi = d10;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setSupportedMediaCommands(long j10) {
            this.zzh = j10;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setVideoInfo(@RecentlyNonNull VideoInfo videoInfo) {
            this.zzs = videoInfo;
            return this;
        }
    }

    @KeepForSdk
    public class Writer {
        public Writer() {
        }

        @KeepForSdk
        public void setActiveTrackIds(long[] jArr) {
            MediaStatus.this.zzk = jArr;
        }

        @KeepForSdk
        public void setAdBreakStatus(AdBreakStatus adBreakStatus) {
            MediaStatus.this.zzs = adBreakStatus;
        }

        @KeepForSdk
        public void setCurrentItemId(int i10) {
            MediaStatus.this.zzc = i10;
        }

        @KeepForSdk
        public void setCustomData(JSONObject jSONObject) {
            MediaStatus mediaStatus = MediaStatus.this;
            mediaStatus.zzo = jSONObject;
            mediaStatus.zzn = null;
        }

        @KeepForSdk
        public void setIdleReason(int i10) {
            MediaStatus.this.zzf = i10;
        }

        @KeepForSdk
        public void setIsPlayingAd(boolean z10) {
            MediaStatus.this.zzr = z10;
        }

        @KeepForSdk
        public void setLiveSeekableRange(MediaLiveSeekableRange mediaLiveSeekableRange) {
            MediaStatus.this.zzu = mediaLiveSeekableRange;
        }

        @KeepForSdk
        public void setLoadingItemId(int i10) {
            MediaStatus.this.zzl = i10;
        }

        @KeepForSdk
        public void setMediaInfo(MediaInfo mediaInfo) {
            MediaStatus.this.zza = mediaInfo;
        }

        @KeepForSdk
        public void setMute(boolean z10) {
            MediaStatus.this.zzj = z10;
        }

        @KeepForSdk
        public void setPlaybackRate(double d10) {
            MediaStatus.this.zzd = d10;
        }

        @KeepForSdk
        public void setPlayerState(int i10) {
            MediaStatus.this.zze = i10;
        }

        @KeepForSdk
        public void setPreloadedItemId(int i10) {
            MediaStatus.this.zzm = i10;
        }

        @KeepForSdk
        public void setQueueData(MediaQueueData mediaQueueData) {
            MediaStatus.this.zzv = mediaQueueData;
        }

        @KeepForSdk
        public void setQueueItems(List<MediaQueueItem> list) {
            MediaStatus.this.zze(list);
        }

        @KeepForSdk
        public void setQueueRepeatMode(int i10) {
            MediaStatus.this.zzp = i10;
        }

        @KeepForSdk
        public void setStreamPosition(long j10) {
            MediaStatus.this.zzg = j10;
        }

        @KeepForSdk
        public void setStreamVolume(double d10) {
            MediaStatus.this.zzi = d10;
        }

        @KeepForSdk
        public void setSupportedMediaCommands(long j10) {
            MediaStatus.this.zzh = j10;
        }

        @KeepForSdk
        public void setVideoInfo(VideoInfo videoInfo) {
            MediaStatus.this.zzt = videoInfo;
        }
    }

    @SafeParcelable.Constructor
    @KeepForSdk
    public MediaStatus(@SafeParcelable.Param(id = 2) MediaInfo mediaInfo, @SafeParcelable.Param(id = 3) long j10, @SafeParcelable.Param(id = 4) int i10, @SafeParcelable.Param(id = 5) double d10, @SafeParcelable.Param(id = 6) int i11, @SafeParcelable.Param(id = 7) int i12, @SafeParcelable.Param(id = 8) long j11, @SafeParcelable.Param(id = 9) long j12, @SafeParcelable.Param(id = 10) double d11, @SafeParcelable.Param(id = 11) boolean z10, @SafeParcelable.Param(id = 12) long[] jArr, @SafeParcelable.Param(id = 13) int i13, @SafeParcelable.Param(id = 14) int i14, @SafeParcelable.Param(id = 15) String str, @SafeParcelable.Param(id = 16) int i15, @SafeParcelable.Param(id = 17) List<MediaQueueItem> list, @SafeParcelable.Param(id = 18) boolean z11, @SafeParcelable.Param(id = 19) AdBreakStatus adBreakStatus, @SafeParcelable.Param(id = 20) VideoInfo videoInfo, @SafeParcelable.Param(id = 21) MediaLiveSeekableRange mediaLiveSeekableRange, @SafeParcelable.Param(id = 22) MediaQueueData mediaQueueData) {
        this.zzq = new ArrayList();
        this.zzx = new SparseArray<>();
        this.zzy = new Writer();
        this.zza = mediaInfo;
        this.zzb = j10;
        this.zzc = i10;
        this.zzd = d10;
        this.zze = i11;
        this.zzf = i12;
        this.zzg = j11;
        this.zzh = j12;
        this.zzi = d11;
        this.zzj = z10;
        this.zzk = jArr;
        this.zzl = i13;
        this.zzm = i14;
        this.zzn = str;
        if (str != null) {
            try {
                this.zzo = new JSONObject(str);
            } catch (JSONException unused) {
                this.zzo = null;
                this.zzn = null;
            }
        } else {
            this.zzo = null;
        }
        this.zzp = i15;
        if (list != null && !list.isEmpty()) {
            zze(list);
        }
        this.zzr = z11;
        this.zzs = adBreakStatus;
        this.zzt = videoInfo;
        this.zzu = mediaLiveSeekableRange;
        this.zzv = mediaQueueData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zze(List<MediaQueueItem> list) {
        this.zzq.clear();
        this.zzx.clear();
        if (list != null) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                MediaQueueItem mediaQueueItem = list.get(i10);
                this.zzq.add(mediaQueueItem);
                this.zzx.put(mediaQueueItem.getItemId(), Integer.valueOf(i10));
            }
        }
    }

    private static final boolean zzf(int i10, int i11, int i12, int i13) {
        if (i10 != 1) {
            return false;
        }
        if (i11 != 1) {
            if (i11 == 2) {
                return i13 != 2;
            }
            if (i11 != 3) {
                return true;
            }
        }
        return i12 == 0;
    }

    public boolean equals(Object obj) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaStatus)) {
            return false;
        }
        MediaStatus mediaStatus = (MediaStatus) obj;
        return (this.zzo == null) == (mediaStatus.zzo == null) && this.zzb == mediaStatus.zzb && this.zzc == mediaStatus.zzc && this.zzd == mediaStatus.zzd && this.zze == mediaStatus.zze && this.zzf == mediaStatus.zzf && this.zzg == mediaStatus.zzg && this.zzi == mediaStatus.zzi && this.zzj == mediaStatus.zzj && this.zzl == mediaStatus.zzl && this.zzm == mediaStatus.zzm && this.zzp == mediaStatus.zzp && Arrays.equals(this.zzk, mediaStatus.zzk) && CastUtils.zzh(Long.valueOf(this.zzh), Long.valueOf(mediaStatus.zzh)) && CastUtils.zzh(this.zzq, mediaStatus.zzq) && CastUtils.zzh(this.zza, mediaStatus.zza) && ((jSONObject = this.zzo) == null || (jSONObject2 = mediaStatus.zzo) == null || JsonUtils.areJsonValuesEquivalent(jSONObject, jSONObject2)) && this.zzr == mediaStatus.isPlayingAd() && CastUtils.zzh(this.zzs, mediaStatus.zzs) && CastUtils.zzh(this.zzt, mediaStatus.zzt) && CastUtils.zzh(this.zzu, mediaStatus.zzu) && Objects.equal(this.zzv, mediaStatus.zzv);
    }

    @RecentlyNullable
    public long[] getActiveTrackIds() {
        return this.zzk;
    }

    @RecentlyNullable
    public AdBreakStatus getAdBreakStatus() {
        return this.zzs;
    }

    @RecentlyNullable
    public AdBreakInfo getCurrentAdBreak() {
        MediaInfo mediaInfo;
        List<AdBreakInfo> adBreaks;
        AdBreakStatus adBreakStatus = this.zzs;
        if (adBreakStatus == null) {
            return null;
        }
        String breakId = adBreakStatus.getBreakId();
        if (!TextUtils.isEmpty(breakId) && (mediaInfo = this.zza) != null && (adBreaks = mediaInfo.getAdBreaks()) != null && !adBreaks.isEmpty()) {
            for (AdBreakInfo adBreakInfo : adBreaks) {
                if (breakId.equals(adBreakInfo.getId())) {
                    return adBreakInfo;
                }
            }
        }
        return null;
    }

    @RecentlyNullable
    public AdBreakClipInfo getCurrentAdBreakClip() {
        MediaInfo mediaInfo;
        List<AdBreakClipInfo> adBreakClips;
        AdBreakStatus adBreakStatus = this.zzs;
        if (adBreakStatus == null) {
            return null;
        }
        String breakClipId = adBreakStatus.getBreakClipId();
        if (!TextUtils.isEmpty(breakClipId) && (mediaInfo = this.zza) != null && (adBreakClips = mediaInfo.getAdBreakClips()) != null && !adBreakClips.isEmpty()) {
            for (AdBreakClipInfo adBreakClipInfo : adBreakClips) {
                if (breakClipId.equals(adBreakClipInfo.getId())) {
                    return adBreakClipInfo;
                }
            }
        }
        return null;
    }

    public int getCurrentItemId() {
        return this.zzc;
    }

    @RecentlyNullable
    public JSONObject getCustomData() {
        return this.zzo;
    }

    public int getIdleReason() {
        return this.zzf;
    }

    @RecentlyNonNull
    public Integer getIndexById(int i10) {
        return this.zzx.get(i10);
    }

    @RecentlyNullable
    public MediaQueueItem getItemById(int i10) {
        Integer num = this.zzx.get(i10);
        if (num == null) {
            return null;
        }
        return this.zzq.get(num.intValue());
    }

    @RecentlyNullable
    public MediaQueueItem getItemByIndex(int i10) {
        if (i10 < 0 || i10 >= this.zzq.size()) {
            return null;
        }
        return this.zzq.get(i10);
    }

    @RecentlyNullable
    public MediaLiveSeekableRange getLiveSeekableRange() {
        return this.zzu;
    }

    public int getLoadingItemId() {
        return this.zzl;
    }

    @RecentlyNullable
    public MediaInfo getMediaInfo() {
        return this.zza;
    }

    public double getPlaybackRate() {
        return this.zzd;
    }

    public int getPlayerState() {
        return this.zze;
    }

    public int getPreloadedItemId() {
        return this.zzm;
    }

    @RecentlyNullable
    public MediaQueueData getQueueData() {
        return this.zzv;
    }

    @RecentlyNullable
    public MediaQueueItem getQueueItem(int i10) {
        return getItemByIndex(i10);
    }

    @RecentlyNullable
    public MediaQueueItem getQueueItemById(int i10) {
        return getItemById(i10);
    }

    public int getQueueItemCount() {
        return this.zzq.size();
    }

    @RecentlyNonNull
    public List<MediaQueueItem> getQueueItems() {
        return this.zzq;
    }

    public int getQueueRepeatMode() {
        return this.zzp;
    }

    public long getStreamPosition() {
        return this.zzg;
    }

    public double getStreamVolume() {
        return this.zzi;
    }

    @KeepForSdk
    public long getSupportedMediaCommands() {
        return this.zzh;
    }

    @RecentlyNullable
    public VideoInfo getVideoInfo() {
        return this.zzt;
    }

    @RecentlyNonNull
    @KeepForSdk
    public Writer getWriter() {
        return this.zzy;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, Long.valueOf(this.zzb), Integer.valueOf(this.zzc), Double.valueOf(this.zzd), Integer.valueOf(this.zze), Integer.valueOf(this.zzf), Long.valueOf(this.zzg), Long.valueOf(this.zzh), Double.valueOf(this.zzi), Boolean.valueOf(this.zzj), Integer.valueOf(Arrays.hashCode(this.zzk)), Integer.valueOf(this.zzl), Integer.valueOf(this.zzm), String.valueOf(this.zzo), Integer.valueOf(this.zzp), this.zzq, Boolean.valueOf(this.zzr), this.zzs, this.zzt, this.zzu, this.zzv);
    }

    public boolean isMediaCommandSupported(long j10) {
        return (j10 & this.zzh) != 0;
    }

    public boolean isMute() {
        return this.zzj;
    }

    public boolean isPlayingAd() {
        return this.zzr;
    }

    @RecentlyNonNull
    @KeepForSdk
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mediaSessionId", this.zzb);
            int i10 = this.zze;
            String str = "IDLE";
            if (i10 != 1) {
                if (i10 == 2) {
                    str = DLNAControllerImp.PLAYING;
                } else if (i10 == 3) {
                    str = "PAUSED";
                } else if (i10 == 4) {
                    str = "BUFFERING";
                } else if (i10 == 5) {
                    str = "LOADING";
                }
            }
            jSONObject.put("playerState", str);
            JSONArray jSONArray = null;
            if (this.zze == 1) {
                int i11 = this.zzf;
                jSONObject.putOpt("idleReason", i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? null : MediaError.ERROR_TYPE_ERROR : "INTERRUPTED" : "CANCELLED" : "FINISHED");
            }
            jSONObject.put("playbackRate", this.zzd);
            jSONObject.put("currentTime", CastUtils.millisecToSec(this.zzg));
            jSONObject.put("supportedMediaCommands", this.zzh);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(FirebaseAnalytics.Param.LEVEL, this.zzi);
            jSONObject2.put("muted", this.zzj);
            jSONObject.put(PlistBuilder.VALUE_TYPE_VOLUME, jSONObject2);
            if (this.zzk != null) {
                jSONArray = new JSONArray();
                for (long j10 : this.zzk) {
                    jSONArray.put(j10);
                }
            }
            jSONObject.putOpt("activeTrackIds", jSONArray);
            jSONObject.putOpt("customData", this.zzo);
            MediaInfo mediaInfo = this.zza;
            if (mediaInfo != null) {
                jSONObject.putOpt("media", mediaInfo.zza());
            }
            int i12 = this.zzc;
            if (i12 != 0) {
                jSONObject.put("currentItemId", i12);
            }
            int i13 = this.zzm;
            if (i13 != 0) {
                jSONObject.put("preloadedItemId", i13);
            }
            int i14 = this.zzl;
            if (i14 != 0) {
                jSONObject.put("loadingItemId", i14);
            }
            AdBreakStatus adBreakStatus = this.zzs;
            if (adBreakStatus != null) {
                jSONObject.putOpt("breakStatus", adBreakStatus.zzb());
            }
            VideoInfo videoInfo = this.zzt;
            if (videoInfo != null) {
                jSONObject.putOpt("videoInfo", videoInfo.zzb());
            }
            MediaQueueData mediaQueueData = this.zzv;
            if (mediaQueueData != null) {
                jSONObject.putOpt("queueData", mediaQueueData.zza());
            }
            MediaLiveSeekableRange mediaLiveSeekableRange = this.zzu;
            if (mediaLiveSeekableRange != null) {
                jSONObject.putOpt("liveSeekableRange", mediaLiveSeekableRange.zzb());
            }
            jSONObject.putOpt("repeatMode", MediaCommon.zza(Integer.valueOf(this.zzp)));
            List<MediaQueueItem> list = this.zzq;
            if (list != null && !list.isEmpty()) {
                JSONArray jSONArray2 = new JSONArray();
                Iterator<MediaQueueItem> it = this.zzq.iterator();
                while (it.hasNext()) {
                    jSONArray2.put(it.next().toJson());
                }
                jSONObject.put("items", jSONArray2);
            }
            return jSONObject;
        } catch (JSONException e10) {
            zzw.e(e10, "Error transforming MediaStatus into JSONObject", new Object[0]);
            return new JSONObject();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
        JSONObject jSONObject = this.zzo;
        this.zzn = jSONObject == null ? null : jSONObject.toString();
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getMediaInfo(), i10, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzb);
        SafeParcelWriter.writeInt(parcel, 4, getCurrentItemId());
        SafeParcelWriter.writeDouble(parcel, 5, getPlaybackRate());
        SafeParcelWriter.writeInt(parcel, 6, getPlayerState());
        SafeParcelWriter.writeInt(parcel, 7, getIdleReason());
        SafeParcelWriter.writeLong(parcel, 8, getStreamPosition());
        SafeParcelWriter.writeLong(parcel, 9, this.zzh);
        SafeParcelWriter.writeDouble(parcel, 10, getStreamVolume());
        SafeParcelWriter.writeBoolean(parcel, 11, isMute());
        SafeParcelWriter.writeLongArray(parcel, 12, getActiveTrackIds(), false);
        SafeParcelWriter.writeInt(parcel, 13, getLoadingItemId());
        SafeParcelWriter.writeInt(parcel, 14, getPreloadedItemId());
        SafeParcelWriter.writeString(parcel, 15, this.zzn, false);
        SafeParcelWriter.writeInt(parcel, 16, this.zzp);
        SafeParcelWriter.writeTypedList(parcel, 17, this.zzq, false);
        SafeParcelWriter.writeBoolean(parcel, 18, isPlayingAd());
        SafeParcelWriter.writeParcelable(parcel, 19, getAdBreakStatus(), i10, false);
        SafeParcelWriter.writeParcelable(parcel, 20, getVideoInfo(), i10, false);
        SafeParcelWriter.writeParcelable(parcel, 21, getLiveSeekableRange(), i10, false);
        SafeParcelWriter.writeParcelable(parcel, 22, getQueueData(), i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX WARN: Code restructure failed: missing block: B:152:0x02d8, code lost:
    
        if (r15 == false) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x018c, code lost:
    
        if (r13.zzk != null) goto L103;
     */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0249  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zza(@RecentlyNonNull JSONObject jSONObject, int i10) {
        int i11;
        MediaInfo mediaInfo;
        boolean z10;
        int i12;
        MediaInfo mediaInfo2;
        int i13;
        JSONObject optJSONObject = jSONObject.optJSONObject("extendedStatus");
        boolean z11 = false;
        if (optJSONObject != null) {
            try {
                ArrayList arrayList = new ArrayList();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    arrayList.add(keys.next());
                }
                JSONObject jSONObject2 = new JSONObject(jSONObject, (String[]) arrayList.toArray(new String[0]));
                Iterator<String> keys2 = optJSONObject.keys();
                while (keys2.hasNext()) {
                    String next = keys2.next();
                    jSONObject2.put(next, optJSONObject.get(next));
                }
                jSONObject2.remove("extendedStatus");
                jSONObject = jSONObject2;
            } catch (JSONException unused) {
            }
        }
        long j10 = jSONObject.getLong("mediaSessionId");
        if (j10 != this.zzb) {
            this.zzb = j10;
            i11 = 1;
        } else {
            i11 = 0;
        }
        if (jSONObject.has("playerState")) {
            String string = jSONObject.getString("playerState");
            int i14 = 3;
            int i15 = string.equals("IDLE") ? 1 : string.equals(DLNAControllerImp.PLAYING) ? 2 : string.equals("PAUSED") ? 3 : string.equals("BUFFERING") ? 4 : string.equals("LOADING") ? 5 : 0;
            if (i15 != this.zze) {
                this.zze = i15;
                i11 |= 2;
            }
            if (i15 == 1 && jSONObject.has("idleReason")) {
                String string2 = jSONObject.getString("idleReason");
                if (string2.equals("CANCELLED")) {
                    i14 = 2;
                } else if (!string2.equals("INTERRUPTED")) {
                    i14 = string2.equals("FINISHED") ? 1 : string2.equals(MediaError.ERROR_TYPE_ERROR) ? 4 : 0;
                }
                if (i14 != this.zzf) {
                    this.zzf = i14;
                    i11 |= 2;
                }
            }
        }
        if (jSONObject.has("playbackRate")) {
            double d10 = jSONObject.getDouble("playbackRate");
            if (this.zzd != d10) {
                this.zzd = d10;
                i11 |= 2;
            }
        }
        if (jSONObject.has("currentTime")) {
            long secToMillisec = CastUtils.secToMillisec(jSONObject.getDouble("currentTime"));
            if (secToMillisec != this.zzg) {
                this.zzg = secToMillisec;
                i11 |= 2;
            }
            i11 |= 128;
        }
        if (jSONObject.has("supportedMediaCommands")) {
            long j11 = jSONObject.getLong("supportedMediaCommands");
            if (j11 != this.zzh) {
                this.zzh = j11;
                i11 |= 2;
            }
        }
        if (jSONObject.has(PlistBuilder.VALUE_TYPE_VOLUME) && i10 == 0) {
            JSONObject jSONObject3 = jSONObject.getJSONObject(PlistBuilder.VALUE_TYPE_VOLUME);
            double d11 = jSONObject3.getDouble(FirebaseAnalytics.Param.LEVEL);
            if (d11 != this.zzi) {
                this.zzi = d11;
                i11 |= 2;
            }
            boolean z12 = jSONObject3.getBoolean("muted");
            if (z12 != this.zzj) {
                this.zzj = z12;
                i11 |= 2;
            }
        }
        long[] zzj = CastUtils.zzj(jSONObject.has("activeTrackIds") ? jSONObject.getJSONArray("activeTrackIds") : null);
        if (zzj != null) {
            long[] jArr = this.zzk;
            if (jArr != null && jArr.length == zzj.length) {
                for (int i16 = 0; i16 < zzj.length; i16++) {
                    if (this.zzk[i16] == zzj[i16]) {
                    }
                }
            }
            this.zzk = zzj;
            i11 |= 2;
            break;
        }
        if (jSONObject.has("customData")) {
            this.zzo = jSONObject.getJSONObject("customData");
            this.zzn = null;
            i11 |= 2;
        }
        if (jSONObject.has("media")) {
            JSONObject jSONObject4 = jSONObject.getJSONObject("media");
            MediaInfo mediaInfo3 = new MediaInfo(jSONObject4);
            MediaInfo mediaInfo4 = this.zza;
            if (mediaInfo4 == null || !mediaInfo4.equals(mediaInfo3)) {
                this.zza = mediaInfo3;
                i11 |= 2;
            }
            if (jSONObject4.has("metadata")) {
                i11 |= 4;
            }
        }
        if (jSONObject.has("currentItemId") && this.zzc != (i13 = jSONObject.getInt("currentItemId"))) {
            this.zzc = i13;
            i11 |= 2;
        }
        int optInt = jSONObject.optInt("preloadedItemId", 0);
        if (this.zzm != optInt) {
            this.zzm = optInt;
            i11 |= 16;
        }
        int optInt2 = jSONObject.optInt("loadingItemId", 0);
        if (this.zzl != optInt2) {
            this.zzl = optInt2;
            i11 |= 2;
        }
        MediaInfo mediaInfo5 = this.zza;
        if (zzf(this.zze, this.zzf, this.zzl, mediaInfo5 == null ? -1 : mediaInfo5.getStreamType())) {
            this.zzc = 0;
            this.zzl = 0;
            this.zzm = 0;
            if (!this.zzq.isEmpty()) {
                this.zzp = 0;
                this.zzq.clear();
                this.zzx.clear();
                i11 |= 8;
            }
        } else {
            if (jSONObject.has("repeatMode")) {
                Integer mediaRepeatModeFromString = MediaCommon.mediaRepeatModeFromString(jSONObject.getString("repeatMode"));
                Integer valueOf = Integer.valueOf(mediaRepeatModeFromString == null ? this.zzp : mediaRepeatModeFromString.intValue());
                if (this.zzp != valueOf.intValue()) {
                    this.zzp = valueOf.intValue();
                    z10 = true;
                    if (jSONObject.has("items")) {
                        JSONArray jSONArray = jSONObject.getJSONArray("items");
                        int length = jSONArray.length();
                        SparseArray sparseArray = new SparseArray();
                        for (int i17 = 0; i17 < length; i17++) {
                            sparseArray.put(i17, Integer.valueOf(jSONArray.getJSONObject(i17).getInt("itemId")));
                        }
                        ArrayList arrayList2 = new ArrayList();
                        while (i12 < length) {
                            Integer num = (Integer) sparseArray.get(i12);
                            JSONObject jSONObject5 = jSONArray.getJSONObject(i12);
                            MediaQueueItem itemById = getItemById(num.intValue());
                            if (itemById != null) {
                                z10 |= itemById.fromJson(jSONObject5);
                                arrayList2.add(itemById);
                                i12 = i12 == getIndexById(num.intValue()).intValue() ? i12 + 1 : 0;
                            } else if (num.intValue() != this.zzc || (mediaInfo2 = this.zza) == null) {
                                arrayList2.add(new MediaQueueItem(jSONObject5));
                            } else {
                                MediaQueueItem build = new MediaQueueItem.Builder(mediaInfo2).build();
                                build.fromJson(jSONObject5);
                                arrayList2.add(build);
                            }
                            z10 = true;
                        }
                        z10 |= !(this.zzq.size() == length);
                        zze(arrayList2);
                    }
                }
            }
            z10 = false;
            if (jSONObject.has("items")) {
            }
        }
        AdBreakStatus zza = AdBreakStatus.zza(jSONObject.optJSONObject("breakStatus"));
        AdBreakStatus adBreakStatus = this.zzs;
        if ((adBreakStatus == null && zza != null) || (adBreakStatus != null && !adBreakStatus.equals(zza))) {
            if (zza != null && (zza.getBreakId() != null || zza.getBreakClipId() != null)) {
                z11 = true;
            }
            this.zzr = z11;
            this.zzs = zza;
            i11 |= 32;
        }
        VideoInfo zza2 = VideoInfo.zza(jSONObject.optJSONObject("videoInfo"));
        VideoInfo videoInfo = this.zzt;
        if ((videoInfo == null && zza2 != null) || (videoInfo != null && !videoInfo.equals(zza2))) {
            this.zzt = zza2;
            i11 |= 64;
        }
        if (jSONObject.has("breakInfo") && (mediaInfo = this.zza) != null) {
            mediaInfo.zzs(jSONObject.getJSONObject("breakInfo"));
            i11 |= 2;
        }
        if (jSONObject.has("queueData")) {
            MediaQueueData.Builder builder = new MediaQueueData.Builder();
            builder.zza(jSONObject.getJSONObject("queueData"));
            this.zzv = builder.build();
        }
        if (jSONObject.has("liveSeekableRange")) {
            this.zzu = MediaLiveSeekableRange.zza(jSONObject.optJSONObject("liveSeekableRange"));
            return i11 | 2;
        }
        if (this.zzu != null) {
            i11 |= 2;
        }
        this.zzu = null;
        return i11;
    }

    public final long zzb() {
        return this.zzb;
    }

    public final boolean zzd() {
        MediaInfo mediaInfo = this.zza;
        return zzf(this.zze, this.zzf, this.zzl, mediaInfo == null ? -1 : mediaInfo.getStreamType());
    }

    @KeepForSdk
    public MediaStatus(@RecentlyNonNull JSONObject jSONObject) {
        this(null, 0L, 0, 0.0d, 0, 0, 0L, 0L, 0.0d, false, null, 0, 0, null, 0, null, false, null, null, null, null);
        zza(jSONObject, 0);
    }
}
