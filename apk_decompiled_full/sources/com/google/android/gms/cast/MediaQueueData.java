package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.cast.MediaQueueContainerMetadata;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.media.MediaCommon;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.umeng.analytics.AnalyticsConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "MediaQueueDataCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public class MediaQueueData extends AbstractSafeParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<MediaQueueData> CREATOR = new zzce();
    public static final int MEDIA_QUEUE_TYPE_ALBUM = 1;
    public static final int MEDIA_QUEUE_TYPE_AUDIO_BOOK = 3;
    public static final int MEDIA_QUEUE_TYPE_GENERIC = 0;
    public static final int MEDIA_QUEUE_TYPE_LIVE_TV = 8;
    public static final int MEDIA_QUEUE_TYPE_MOVIE = 9;
    public static final int MEDIA_QUEUE_TYPE_PLAYLIST = 2;
    public static final int MEDIA_QUEUE_TYPE_PODCAST_SERIES = 5;
    public static final int MEDIA_QUEUE_TYPE_RADIO_STATION = 4;
    public static final int MEDIA_QUEUE_TYPE_TV_SERIES = 6;
    public static final int MEDIA_QUEUE_TYPE_VIDEO_PLAYLIST = 7;

    @SafeParcelable.Field(getter = "getQueueId", id = 2)
    private String zza;

    @SafeParcelable.Field(getter = "getEntity", id = 3)
    private String zzb;

    @SafeParcelable.Field(getter = "getQueueType", id = 4)
    private int zzc;

    @SafeParcelable.Field(getter = "getName", id = 5)
    private String zzd;

    @SafeParcelable.Field(getter = "getContainerMetadata", id = 6)
    private MediaQueueContainerMetadata zze;

    @SafeParcelable.Field(getter = "getRepeatMode", id = 7)
    private int zzf;

    @SafeParcelable.Field(getter = "getItems", id = 8)
    private List<MediaQueueItem> zzg;

    @SafeParcelable.Field(getter = "getStartIndex", id = 9)
    private int zzh;

    @SafeParcelable.Field(getter = "getStartTime", id = 10)
    private long zzi;

    public static class Builder {
        private final MediaQueueData zza;

        public Builder() {
            this.zza = new MediaQueueData(null);
        }

        @RecentlyNonNull
        public MediaQueueData build() {
            return new MediaQueueData(this.zza, null);
        }

        @RecentlyNonNull
        public Builder setContainerMetadata(MediaQueueContainerMetadata mediaQueueContainerMetadata) {
            this.zza.zze = mediaQueueContainerMetadata;
            return this;
        }

        @RecentlyNonNull
        public Builder setEntity(String str) {
            this.zza.zzb = str;
            return this;
        }

        @RecentlyNonNull
        public Builder setItems(List<MediaQueueItem> list) {
            MediaQueueData.zze(this.zza, list);
            return this;
        }

        @RecentlyNonNull
        public Builder setName(String str) {
            this.zza.zzd = str;
            return this;
        }

        @RecentlyNonNull
        public Builder setQueueId(String str) {
            this.zza.zza = str;
            return this;
        }

        @RecentlyNonNull
        public Builder setQueueType(int i10) {
            this.zza.zzc = i10;
            return this;
        }

        @RecentlyNonNull
        public Builder setRepeatMode(int i10) {
            this.zza.setRepeatMode(i10);
            return this;
        }

        @RecentlyNonNull
        public Builder setStartIndex(int i10) {
            this.zza.zzh = i10;
            return this;
        }

        @RecentlyNonNull
        public Builder setStartTime(long j10) {
            this.zza.zzi = j10;
            return this;
        }

        @RecentlyNonNull
        public final Builder zza(@RecentlyNonNull JSONObject jSONObject) {
            MediaQueueData.zzb(this.zza, jSONObject);
            return this;
        }

        @KeepForSdk
        public Builder(@RecentlyNonNull MediaQueueData mediaQueueData) {
            this.zza = new MediaQueueData(mediaQueueData, null);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaQueueType {
    }

    private MediaQueueData() {
        zzk();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static /* bridge */ /* synthetic */ void zzb(MediaQueueData mediaQueueData, JSONObject jSONObject) {
        char c10;
        mediaQueueData.zzk();
        if (jSONObject == null) {
            return;
        }
        mediaQueueData.zza = CastUtils.optStringOrNull(jSONObject, "id");
        mediaQueueData.zzb = CastUtils.optStringOrNull(jSONObject, "entity");
        String optString = jSONObject.optString("queueType");
        switch (optString.hashCode()) {
            case -1803151310:
                if (optString.equals("PODCAST_SERIES")) {
                    c10 = 4;
                    break;
                }
                c10 = 65535;
                break;
            case -1758903120:
                if (optString.equals("RADIO_STATION")) {
                    c10 = 3;
                    break;
                }
                c10 = 65535;
                break;
            case -1632865838:
                if (optString.equals("PLAYLIST")) {
                    c10 = 1;
                    break;
                }
                c10 = 65535;
                break;
            case -1319760993:
                if (optString.equals("AUDIOBOOK")) {
                    c10 = 2;
                    break;
                }
                c10 = 65535;
                break;
            case -1088524588:
                if (optString.equals("TV_SERIES")) {
                    c10 = 5;
                    break;
                }
                c10 = 65535;
                break;
            case 62359119:
                if (optString.equals("ALBUM")) {
                    c10 = 0;
                    break;
                }
                c10 = 65535;
                break;
            case 73549584:
                if (optString.equals("MOVIE")) {
                    c10 = '\b';
                    break;
                }
                c10 = 65535;
                break;
            case 393100598:
                if (optString.equals("VIDEO_PLAYLIST")) {
                    c10 = 6;
                    break;
                }
                c10 = 65535;
                break;
            case 902303413:
                if (optString.equals("LIVE_TV")) {
                    c10 = 7;
                    break;
                }
                c10 = 65535;
                break;
            default:
                c10 = 65535;
                break;
        }
        switch (c10) {
            case 0:
                mediaQueueData.zzc = 1;
                break;
            case 1:
                mediaQueueData.zzc = 2;
                break;
            case 2:
                mediaQueueData.zzc = 3;
                break;
            case 3:
                mediaQueueData.zzc = 4;
                break;
            case 4:
                mediaQueueData.zzc = 5;
                break;
            case 5:
                mediaQueueData.zzc = 6;
                break;
            case 6:
                mediaQueueData.zzc = 7;
                break;
            case 7:
                mediaQueueData.zzc = 8;
                break;
            case '\b':
                mediaQueueData.zzc = 9;
                break;
        }
        mediaQueueData.zzd = CastUtils.optStringOrNull(jSONObject, "name");
        JSONObject optJSONObject = jSONObject.has("containerMetadata") ? jSONObject.optJSONObject("containerMetadata") : null;
        if (optJSONObject != null) {
            MediaQueueContainerMetadata.Builder builder = new MediaQueueContainerMetadata.Builder();
            builder.zza(optJSONObject);
            mediaQueueData.zze = builder.build();
        }
        Integer mediaRepeatModeFromString = MediaCommon.mediaRepeatModeFromString(jSONObject.optString("repeatMode"));
        if (mediaRepeatModeFromString != null) {
            mediaQueueData.zzf = mediaRepeatModeFromString.intValue();
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("items");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            mediaQueueData.zzg = arrayList;
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i10);
                if (optJSONObject2 != null) {
                    try {
                        arrayList.add(new MediaQueueItem(optJSONObject2));
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        mediaQueueData.zzh = jSONObject.optInt("startIndex", mediaQueueData.zzh);
        if (jSONObject.has(AnalyticsConfig.RTD_START_TIME)) {
            mediaQueueData.zzi = CastUtils.secToMillisec(jSONObject.optDouble(AnalyticsConfig.RTD_START_TIME, mediaQueueData.zzi));
        }
    }

    public static /* bridge */ /* synthetic */ void zze(MediaQueueData mediaQueueData, List list) {
        mediaQueueData.zzg = list == null ? null : new ArrayList(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzk() {
        this.zza = null;
        this.zzb = null;
        this.zzc = 0;
        this.zzd = null;
        this.zzf = 0;
        this.zzg = null;
        this.zzh = 0;
        this.zzi = -1L;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaQueueData)) {
            return false;
        }
        MediaQueueData mediaQueueData = (MediaQueueData) obj;
        return TextUtils.equals(this.zza, mediaQueueData.zza) && TextUtils.equals(this.zzb, mediaQueueData.zzb) && this.zzc == mediaQueueData.zzc && TextUtils.equals(this.zzd, mediaQueueData.zzd) && Objects.equal(this.zze, mediaQueueData.zze) && this.zzf == mediaQueueData.zzf && Objects.equal(this.zzg, mediaQueueData.zzg) && this.zzh == mediaQueueData.zzh && this.zzi == mediaQueueData.zzi;
    }

    @RecentlyNullable
    public MediaQueueContainerMetadata getContainerMetadata() {
        return this.zze;
    }

    @RecentlyNullable
    public String getEntity() {
        return this.zzb;
    }

    @RecentlyNullable
    public List<MediaQueueItem> getItems() {
        List<MediaQueueItem> list = this.zzg;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    @RecentlyNullable
    public String getName() {
        return this.zzd;
    }

    @RecentlyNullable
    public String getQueueId() {
        return this.zza;
    }

    public int getQueueType() {
        return this.zzc;
    }

    public int getRepeatMode() {
        return this.zzf;
    }

    public int getStartIndex() {
        return this.zzh;
    }

    public long getStartTime() {
        return this.zzi;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, Integer.valueOf(this.zzc), this.zzd, this.zze, Integer.valueOf(this.zzf), this.zzg, Integer.valueOf(this.zzh), Long.valueOf(this.zzi));
    }

    @KeepForSdk
    public void setRepeatMode(int i10) {
        this.zzf = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getQueueId(), false);
        SafeParcelWriter.writeString(parcel, 3, getEntity(), false);
        SafeParcelWriter.writeInt(parcel, 4, getQueueType());
        SafeParcelWriter.writeString(parcel, 5, getName(), false);
        SafeParcelWriter.writeParcelable(parcel, 6, getContainerMetadata(), i10, false);
        SafeParcelWriter.writeInt(parcel, 7, getRepeatMode());
        SafeParcelWriter.writeTypedList(parcel, 8, getItems(), false);
        SafeParcelWriter.writeInt(parcel, 9, getStartIndex());
        SafeParcelWriter.writeLong(parcel, 10, getStartTime());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @RecentlyNonNull
    public final JSONObject zza() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.zza)) {
                jSONObject.put("id", this.zza);
            }
            if (!TextUtils.isEmpty(this.zzb)) {
                jSONObject.put("entity", this.zzb);
            }
            switch (this.zzc) {
                case 1:
                    jSONObject.put("queueType", "ALBUM");
                    break;
                case 2:
                    jSONObject.put("queueType", "PLAYLIST");
                    break;
                case 3:
                    jSONObject.put("queueType", "AUDIOBOOK");
                    break;
                case 4:
                    jSONObject.put("queueType", "RADIO_STATION");
                    break;
                case 5:
                    jSONObject.put("queueType", "PODCAST_SERIES");
                    break;
                case 6:
                    jSONObject.put("queueType", "TV_SERIES");
                    break;
                case 7:
                    jSONObject.put("queueType", "VIDEO_PLAYLIST");
                    break;
                case 8:
                    jSONObject.put("queueType", "LIVE_TV");
                    break;
                case 9:
                    jSONObject.put("queueType", "MOVIE");
                    break;
            }
            if (!TextUtils.isEmpty(this.zzd)) {
                jSONObject.put("name", this.zzd);
            }
            MediaQueueContainerMetadata mediaQueueContainerMetadata = this.zze;
            if (mediaQueueContainerMetadata != null) {
                jSONObject.put("containerMetadata", mediaQueueContainerMetadata.zza());
            }
            String zza = MediaCommon.zza(Integer.valueOf(this.zzf));
            if (zza != null) {
                jSONObject.put("repeatMode", zza);
            }
            List<MediaQueueItem> list = this.zzg;
            if (list != null && !list.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                Iterator<MediaQueueItem> it = this.zzg.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().toJson());
                }
                jSONObject.put("items", jSONArray);
            }
            jSONObject.put("startIndex", this.zzh);
            long j10 = this.zzi;
            if (j10 != -1) {
                jSONObject.put(AnalyticsConfig.RTD_START_TIME, CastUtils.millisecToSec(j10));
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public /* synthetic */ MediaQueueData(zzcd zzcdVar) {
        zzk();
    }

    public /* synthetic */ MediaQueueData(MediaQueueData mediaQueueData, zzcd zzcdVar) {
        this.zza = mediaQueueData.zza;
        this.zzb = mediaQueueData.zzb;
        this.zzc = mediaQueueData.zzc;
        this.zzd = mediaQueueData.zzd;
        this.zze = mediaQueueData.zze;
        this.zzf = mediaQueueData.zzf;
        this.zzg = mediaQueueData.zzg;
        this.zzh = mediaQueueData.zzh;
        this.zzi = mediaQueueData.zzi;
    }

    @SafeParcelable.Constructor
    public MediaQueueData(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) int i10, @SafeParcelable.Param(id = 5) String str3, @SafeParcelable.Param(id = 6) MediaQueueContainerMetadata mediaQueueContainerMetadata, @SafeParcelable.Param(id = 7) int i11, @SafeParcelable.Param(id = 8) List<MediaQueueItem> list, @SafeParcelable.Param(id = 9) int i12, @SafeParcelable.Param(id = 10) long j10) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = i10;
        this.zzd = str3;
        this.zze = mediaQueueContainerMetadata;
        this.zzf = i11;
        this.zzg = list;
        this.zzh = i12;
        this.zzi = j10;
    }
}
