package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.internal.cast.zzdr;
import com.google.android.gms.internal.cast.zzdu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "MediaInfoCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public class MediaInfo extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final int STREAM_TYPE_BUFFERED = 1;
    public static final int STREAM_TYPE_INVALID = -1;
    public static final int STREAM_TYPE_LIVE = 2;
    public static final int STREAM_TYPE_NONE = 0;
    public static final long UNKNOWN_DURATION = -1;
    public static final long UNKNOWN_START_ABSOLUTE_TIME = -1;

    @SafeParcelable.Field(id = 9)
    String zzb;

    @SafeParcelable.Field(getter = "getContentId", id = 2)
    private String zzc;

    @SafeParcelable.Field(getter = "getStreamType", id = 3)
    private int zzd;

    @SafeParcelable.Field(getter = "getContentType", id = 4)
    private String zze;

    @SafeParcelable.Field(getter = "getMetadata", id = 5)
    private MediaMetadata zzf;

    @SafeParcelable.Field(getter = "getStreamDuration", id = 6)
    private long zzg;

    @SafeParcelable.Field(getter = "getMediaTracks", id = 7)
    private List<MediaTrack> zzh;

    @SafeParcelable.Field(getter = "getTextTrackStyle", id = 8)
    private TextTrackStyle zzi;

    @SafeParcelable.Field(getter = "getAdBreaks", id = 10)
    private List<AdBreakInfo> zzj;

    @SafeParcelable.Field(getter = "getAdBreakClips", id = 11)
    private List<AdBreakClipInfo> zzk;

    @SafeParcelable.Field(getter = "getEntity", id = 12)
    private String zzl;

    @SafeParcelable.Field(getter = "getVmapAdsRequest", id = 13)
    private VastAdsRequest zzm;

    @SafeParcelable.Field(getter = "getStartAbsoluteTime", id = 14)
    private long zzn;

    @SafeParcelable.Field(getter = "getAtvEntity", id = 15)
    private String zzo;

    @SafeParcelable.Field(getter = "getContentUrl", id = 16)
    private String zzp;

    @HlsSegmentFormat
    @SafeParcelable.Field(getter = "getHlsSegmentFormat", id = 17)
    private String zzq;

    @HlsVideoSegmentFormat
    @SafeParcelable.Field(getter = "getHlsVideoSegmentFormat", id = 18)
    private String zzr;
    private JSONObject zzs;
    private final Writer zzt;
    public static final long zza = CastUtils.secToMillisec(-1L);

    @RecentlyNonNull
    public static final Parcelable.Creator<MediaInfo> CREATOR = new zzbu();

    public static class Builder {
        private final MediaInfo zza;

        public Builder(@RecentlyNonNull String str) {
            this.zza = new MediaInfo(str);
        }

        @RecentlyNonNull
        public MediaInfo build() {
            return this.zza;
        }

        @RecentlyNonNull
        public Builder setAdBreakClips(@RecentlyNonNull List<AdBreakClipInfo> list) {
            this.zza.getWriter().setAdBreakClips(list);
            return this;
        }

        @RecentlyNonNull
        public Builder setAdBreaks(@RecentlyNonNull List<AdBreakInfo> list) {
            this.zza.getWriter().setAdBreaks(list);
            return this;
        }

        @RecentlyNonNull
        public Builder setAtvEntity(@RecentlyNonNull String str) {
            this.zza.zzo = str;
            return this;
        }

        @RecentlyNonNull
        public Builder setContentType(@RecentlyNonNull String str) {
            this.zza.getWriter().setContentType(str);
            return this;
        }

        @RecentlyNonNull
        public Builder setContentUrl(@RecentlyNonNull String str) {
            this.zza.getWriter().setContentUrl(str);
            return this;
        }

        @RecentlyNonNull
        public Builder setCustomData(@RecentlyNonNull JSONObject jSONObject) {
            this.zza.getWriter().setCustomData(jSONObject);
            return this;
        }

        @RecentlyNonNull
        public Builder setEntity(@RecentlyNonNull String str) {
            this.zza.getWriter().setEntity(str);
            return this;
        }

        @RecentlyNonNull
        public Builder setHlsSegmentFormat(@HlsSegmentFormat String str) {
            this.zza.getWriter().setHlsSegmentFormat(str);
            return this;
        }

        @RecentlyNonNull
        public Builder setHlsVideoSegmentFormat(@HlsVideoSegmentFormat String str) {
            this.zza.getWriter().setHlsVideoSegmentFormat(str);
            return this;
        }

        @RecentlyNonNull
        public Builder setMediaTracks(@RecentlyNonNull List<MediaTrack> list) {
            this.zza.getWriter().setMediaTracks(list);
            return this;
        }

        @RecentlyNonNull
        public Builder setMetadata(@RecentlyNonNull MediaMetadata mediaMetadata) {
            this.zza.getWriter().setMetadata(mediaMetadata);
            return this;
        }

        @RecentlyNonNull
        public Builder setStreamDuration(long j10) {
            this.zza.getWriter().setStreamDuration(j10);
            return this;
        }

        @RecentlyNonNull
        public Builder setStreamType(int i10) {
            this.zza.getWriter().setStreamType(i10);
            return this;
        }

        @RecentlyNonNull
        public Builder setTextTrackStyle(@RecentlyNonNull TextTrackStyle textTrackStyle) {
            this.zza.getWriter().setTextTrackStyle(textTrackStyle);
            return this;
        }

        @RecentlyNonNull
        public Builder setVmapAdsRequest(@RecentlyNonNull VastAdsRequest vastAdsRequest) {
            this.zza.getWriter().setVmapAdsRequest(vastAdsRequest);
            return this;
        }

        public Builder(@RecentlyNonNull String str, @RecentlyNonNull String str2) {
            this.zza = new MediaInfo(str, str2);
        }
    }

    @KeepForSdk
    public class Writer {
        public Writer() {
        }

        @KeepForSdk
        public void setAdBreakClips(List<AdBreakClipInfo> list) {
            MediaInfo.this.zzk = list;
        }

        @KeepForSdk
        public void setAdBreaks(List<AdBreakInfo> list) {
            MediaInfo.this.zzj = list;
        }

        @KeepForSdk
        public void setContentId(@RecentlyNonNull String str) {
            MediaInfo.this.zzc = str;
        }

        @KeepForSdk
        public void setContentType(String str) {
            MediaInfo.this.zze = str;
        }

        @KeepForSdk
        public void setContentUrl(String str) {
            MediaInfo.this.zzp = str;
        }

        @KeepForSdk
        public void setCustomData(JSONObject jSONObject) {
            MediaInfo.this.zzs = jSONObject;
        }

        @KeepForSdk
        public void setEntity(String str) {
            MediaInfo.this.zzl = str;
        }

        @KeepForSdk
        public void setHlsSegmentFormat(@HlsSegmentFormat String str) {
            MediaInfo.this.zzq = str;
        }

        @KeepForSdk
        public void setHlsVideoSegmentFormat(@HlsVideoSegmentFormat String str) {
            MediaInfo.this.zzr = str;
        }

        @KeepForSdk
        public void setMediaTracks(List<MediaTrack> list) {
            MediaInfo.this.zzh = list;
        }

        @KeepForSdk
        public void setMetadata(MediaMetadata mediaMetadata) {
            MediaInfo.this.zzf = mediaMetadata;
        }

        @KeepForSdk
        public void setStartAbsoluteTime(long j10) {
            if (j10 < 0 && j10 != -1) {
                throw new IllegalArgumentException("Invalid start absolute time");
            }
            MediaInfo.this.zzn = j10;
        }

        @KeepForSdk
        public void setStreamDuration(long j10) {
            if (j10 < 0 && j10 != -1) {
                throw new IllegalArgumentException("Invalid stream duration");
            }
            MediaInfo.this.zzg = j10;
        }

        @KeepForSdk
        public void setStreamType(int i10) {
            if (i10 < -1 || i10 > 2) {
                throw new IllegalArgumentException("invalid stream type");
            }
            MediaInfo.this.zzd = i10;
        }

        @KeepForSdk
        public void setTextTrackStyle(TextTrackStyle textTrackStyle) {
            MediaInfo.this.zzi = textTrackStyle;
        }

        @KeepForSdk
        public void setVmapAdsRequest(VastAdsRequest vastAdsRequest) {
            MediaInfo.this.zzm = vastAdsRequest;
        }
    }

    public MediaInfo(String str) {
        this(str, -1, null, null, -1L, null, null, null, null, null, null, null, -1L, null, null, null, null);
        if (str == null) {
            throw new IllegalArgumentException("contentID cannot be null");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaInfo)) {
            return false;
        }
        MediaInfo mediaInfo = (MediaInfo) obj;
        JSONObject jSONObject = this.zzs;
        boolean z10 = jSONObject == null;
        JSONObject jSONObject2 = mediaInfo.zzs;
        if (z10 != (jSONObject2 == null)) {
            return false;
        }
        return (jSONObject == null || jSONObject2 == null || JsonUtils.areJsonValuesEquivalent(jSONObject, jSONObject2)) && CastUtils.zzh(this.zzc, mediaInfo.zzc) && this.zzd == mediaInfo.zzd && CastUtils.zzh(this.zze, mediaInfo.zze) && CastUtils.zzh(this.zzf, mediaInfo.zzf) && this.zzg == mediaInfo.zzg && CastUtils.zzh(this.zzh, mediaInfo.zzh) && CastUtils.zzh(this.zzi, mediaInfo.zzi) && CastUtils.zzh(this.zzj, mediaInfo.zzj) && CastUtils.zzh(this.zzk, mediaInfo.zzk) && CastUtils.zzh(this.zzl, mediaInfo.zzl) && CastUtils.zzh(this.zzm, mediaInfo.zzm) && this.zzn == mediaInfo.zzn && CastUtils.zzh(this.zzo, mediaInfo.zzo) && CastUtils.zzh(this.zzp, mediaInfo.zzp) && CastUtils.zzh(this.zzq, mediaInfo.zzq) && CastUtils.zzh(this.zzr, mediaInfo.zzr);
    }

    @RecentlyNullable
    public List<AdBreakClipInfo> getAdBreakClips() {
        List<AdBreakClipInfo> list = this.zzk;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    @RecentlyNullable
    public List<AdBreakInfo> getAdBreaks() {
        List<AdBreakInfo> list = this.zzj;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    @RecentlyNonNull
    public String getContentId() {
        return this.zzc;
    }

    @RecentlyNullable
    public String getContentType() {
        return this.zze;
    }

    @RecentlyNullable
    public String getContentUrl() {
        return this.zzp;
    }

    @RecentlyNullable
    public JSONObject getCustomData() {
        return this.zzs;
    }

    @RecentlyNullable
    public String getEntity() {
        return this.zzl;
    }

    @RecentlyNullable
    @HlsSegmentFormat
    public String getHlsSegmentFormat() {
        return this.zzq;
    }

    @RecentlyNullable
    @HlsVideoSegmentFormat
    public String getHlsVideoSegmentFormat() {
        return this.zzr;
    }

    @RecentlyNullable
    public List<MediaTrack> getMediaTracks() {
        return this.zzh;
    }

    @RecentlyNullable
    public MediaMetadata getMetadata() {
        return this.zzf;
    }

    public long getStartAbsoluteTime() {
        return this.zzn;
    }

    public long getStreamDuration() {
        return this.zzg;
    }

    public int getStreamType() {
        return this.zzd;
    }

    @RecentlyNullable
    public TextTrackStyle getTextTrackStyle() {
        return this.zzi;
    }

    @RecentlyNullable
    public VastAdsRequest getVmapAdsRequest() {
        return this.zzm;
    }

    @RecentlyNonNull
    @KeepForSdk
    public Writer getWriter() {
        return this.zzt;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzc, Integer.valueOf(this.zzd), this.zze, this.zzf, Long.valueOf(this.zzg), String.valueOf(this.zzs), this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, Long.valueOf(this.zzn), this.zzo, this.zzq, this.zzr);
    }

    public void setTextTrackStyle(@RecentlyNonNull TextTrackStyle textTrackStyle) {
        this.zzi = textTrackStyle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
        JSONObject jSONObject = this.zzs;
        this.zzb = jSONObject == null ? null : jSONObject.toString();
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getContentId(), false);
        SafeParcelWriter.writeInt(parcel, 3, getStreamType());
        SafeParcelWriter.writeString(parcel, 4, getContentType(), false);
        SafeParcelWriter.writeParcelable(parcel, 5, getMetadata(), i10, false);
        SafeParcelWriter.writeLong(parcel, 6, getStreamDuration());
        SafeParcelWriter.writeTypedList(parcel, 7, getMediaTracks(), false);
        SafeParcelWriter.writeParcelable(parcel, 8, getTextTrackStyle(), i10, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzb, false);
        SafeParcelWriter.writeTypedList(parcel, 10, getAdBreaks(), false);
        SafeParcelWriter.writeTypedList(parcel, 11, getAdBreakClips(), false);
        SafeParcelWriter.writeString(parcel, 12, getEntity(), false);
        SafeParcelWriter.writeParcelable(parcel, 13, getVmapAdsRequest(), i10, false);
        SafeParcelWriter.writeLong(parcel, 14, getStartAbsoluteTime());
        SafeParcelWriter.writeString(parcel, 15, this.zzo, false);
        SafeParcelWriter.writeString(parcel, 16, getContentUrl(), false);
        SafeParcelWriter.writeString(parcel, 17, getHlsSegmentFormat(), false);
        SafeParcelWriter.writeString(parcel, 18, getHlsVideoSegmentFormat(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @RecentlyNonNull
    public final JSONObject zza() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("contentId", this.zzc);
            jSONObject.putOpt("contentUrl", this.zzp);
            int i10 = this.zzd;
            jSONObject.put("streamType", i10 != 1 ? i10 != 2 ? "NONE" : "LIVE" : "BUFFERED");
            String str = this.zze;
            if (str != null) {
                jSONObject.put("contentType", str);
            }
            MediaMetadata mediaMetadata = this.zzf;
            if (mediaMetadata != null) {
                jSONObject.put("metadata", mediaMetadata.zza());
            }
            long j10 = this.zzg;
            if (j10 <= -1) {
                jSONObject.put("duration", JSONObject.NULL);
            } else {
                jSONObject.put("duration", CastUtils.millisecToSec(j10));
            }
            if (this.zzh != null) {
                JSONArray jSONArray = new JSONArray();
                Iterator<MediaTrack> it = this.zzh.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().zza());
                }
                jSONObject.put("tracks", jSONArray);
            }
            TextTrackStyle textTrackStyle = this.zzi;
            if (textTrackStyle != null) {
                jSONObject.put("textTrackStyle", textTrackStyle.zza());
            }
            JSONObject jSONObject2 = this.zzs;
            if (jSONObject2 != null) {
                jSONObject.put("customData", jSONObject2);
            }
            String str2 = this.zzl;
            if (str2 != null) {
                jSONObject.put("entity", str2);
            }
            if (this.zzj != null) {
                JSONArray jSONArray2 = new JSONArray();
                Iterator<AdBreakInfo> it2 = this.zzj.iterator();
                while (it2.hasNext()) {
                    jSONArray2.put(it2.next().zza());
                }
                jSONObject.put("breaks", jSONArray2);
            }
            if (this.zzk != null) {
                JSONArray jSONArray3 = new JSONArray();
                Iterator<AdBreakClipInfo> it3 = this.zzk.iterator();
                while (it3.hasNext()) {
                    jSONArray3.put(it3.next().zza());
                }
                jSONObject.put("breakClips", jSONArray3);
            }
            VastAdsRequest vastAdsRequest = this.zzm;
            if (vastAdsRequest != null) {
                jSONObject.put("vmapAdsRequest", vastAdsRequest.zza());
            }
            long j11 = this.zzn;
            if (j11 != -1) {
                jSONObject.put("startAbsoluteTime", CastUtils.millisecToSec(j11));
            }
            jSONObject.putOpt("atvEntity", this.zzo);
            String str3 = this.zzq;
            if (str3 != null) {
                jSONObject.put("hlsSegmentFormat", str3);
            }
            String str4 = this.zzr;
            if (str4 != null) {
                jSONObject.put("hlsVideoSegmentFormat", str4);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00a4 A[LOOP:0: B:4:0x0022->B:10:0x00a4, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x00ab A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x017b A[LOOP:2: B:34:0x00cb->B:40:0x017b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0182 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzs(JSONObject jSONObject) {
        String string;
        long secToMillisec;
        String optStringOrNull;
        String optStringOrNull2;
        String str;
        String optStringOrNull3;
        JSONObject optJSONObject;
        String optStringOrNull4;
        String optStringOrNull5;
        long secToMillisec2;
        String optStringOrNull6;
        VastAdsRequest fromJson;
        AdBreakClipInfo adBreakClipInfo;
        String str2;
        AdBreakInfo adBreakInfo;
        if (jSONObject.has("breaks")) {
            JSONArray jSONArray = jSONObject.getJSONArray("breaks");
            ArrayList arrayList = new ArrayList(jSONArray.length());
            int i10 = 0;
            while (true) {
                if (i10 >= jSONArray.length()) {
                    break;
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                Parcelable.Creator<AdBreakInfo> creator = AdBreakInfo.CREATOR;
                if (jSONObject2 != null && jSONObject2.has("id") && jSONObject2.has("position")) {
                    try {
                        String string2 = jSONObject2.getString("id");
                        long secToMillisec3 = CastUtils.secToMillisec(jSONObject2.getLong("position"));
                        boolean optBoolean = jSONObject2.optBoolean("isWatched");
                        long secToMillisec4 = CastUtils.secToMillisec(jSONObject2.optLong("duration"));
                        JSONArray optJSONArray = jSONObject2.optJSONArray("breakClipIds");
                        String[] strArr = new String[0];
                        if (optJSONArray != null) {
                            strArr = new String[optJSONArray.length()];
                            for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                                strArr[i11] = optJSONArray.getString(i11);
                            }
                        }
                        adBreakInfo = new AdBreakInfo(secToMillisec3, string2, secToMillisec4, optBoolean, strArr, jSONObject2.optBoolean("isEmbedded"), jSONObject2.optBoolean("expanded"));
                    } catch (JSONException e10) {
                        String.format(Locale.ROOT, "Error while creating an AdBreakInfo from JSON: %s", e10.getMessage());
                    }
                    if (adBreakInfo != null) {
                        arrayList.clear();
                        break;
                    } else {
                        arrayList.add(adBreakInfo);
                        i10++;
                    }
                }
                adBreakInfo = null;
                if (adBreakInfo != null) {
                }
            }
            this.zzj = new ArrayList(arrayList);
        }
        if (jSONObject.has("breakClips")) {
            JSONArray jSONArray2 = jSONObject.getJSONArray("breakClips");
            ArrayList arrayList2 = new ArrayList(jSONArray2.length());
            int i12 = 0;
            while (true) {
                if (i12 >= jSONArray2.length()) {
                    break;
                }
                JSONObject jSONObject3 = jSONArray2.getJSONObject(i12);
                Parcelable.Creator<AdBreakClipInfo> creator2 = AdBreakClipInfo.CREATOR;
                if (jSONObject3 != null && jSONObject3.has("id")) {
                    try {
                        string = jSONObject3.getString("id");
                        secToMillisec = CastUtils.secToMillisec(jSONObject3.optLong("duration"));
                        optStringOrNull = CastUtils.optStringOrNull(jSONObject3, "clickThroughUrl");
                        optStringOrNull2 = CastUtils.optStringOrNull(jSONObject3, "contentUrl");
                        String optStringOrNull7 = CastUtils.optStringOrNull(jSONObject3, "mimeType");
                        if (optStringOrNull7 == null) {
                            optStringOrNull7 = CastUtils.optStringOrNull(jSONObject3, "contentType");
                        }
                        str = optStringOrNull7;
                        optStringOrNull3 = CastUtils.optStringOrNull(jSONObject3, "title");
                        optJSONObject = jSONObject3.optJSONObject("customData");
                        optStringOrNull4 = CastUtils.optStringOrNull(jSONObject3, "contentId");
                        optStringOrNull5 = CastUtils.optStringOrNull(jSONObject3, "posterUrl");
                        secToMillisec2 = jSONObject3.has("whenSkippable") ? CastUtils.secToMillisec(((Integer) jSONObject3.get("whenSkippable")).intValue()) : -1L;
                        optStringOrNull6 = CastUtils.optStringOrNull(jSONObject3, "hlsSegmentFormat");
                        fromJson = VastAdsRequest.fromJson(jSONObject3.optJSONObject("vastAdsRequest"));
                    } catch (JSONException e11) {
                        String.format(Locale.ROOT, "Error while creating an AdBreakClipInfo from JSON: %s", e11.getMessage());
                    }
                    if (optJSONObject != null && optJSONObject.length() != 0) {
                        str2 = optJSONObject.toString();
                        adBreakClipInfo = new AdBreakClipInfo(string, optStringOrNull3, secToMillisec, optStringOrNull2, str, optStringOrNull, str2, optStringOrNull4, optStringOrNull5, secToMillisec2, optStringOrNull6, fromJson);
                        if (adBreakClipInfo == null) {
                            arrayList2.clear();
                            break;
                        } else {
                            arrayList2.add(adBreakClipInfo);
                            i12++;
                        }
                    }
                    str2 = null;
                    adBreakClipInfo = new AdBreakClipInfo(string, optStringOrNull3, secToMillisec, optStringOrNull2, str, optStringOrNull, str2, optStringOrNull4, optStringOrNull5, secToMillisec2, optStringOrNull6, fromJson);
                    if (adBreakClipInfo == null) {
                    }
                }
                adBreakClipInfo = null;
                if (adBreakClipInfo == null) {
                }
            }
            this.zzk = new ArrayList(arrayList2);
        }
    }

    @SafeParcelable.Constructor
    public MediaInfo(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i10, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) MediaMetadata mediaMetadata, @SafeParcelable.Param(id = 6) long j10, @SafeParcelable.Param(id = 7) List<MediaTrack> list, @SafeParcelable.Param(id = 8) TextTrackStyle textTrackStyle, @SafeParcelable.Param(id = 9) String str3, @SafeParcelable.Param(id = 10) List<AdBreakInfo> list2, @SafeParcelable.Param(id = 11) List<AdBreakClipInfo> list3, @SafeParcelable.Param(id = 12) String str4, @SafeParcelable.Param(id = 13) VastAdsRequest vastAdsRequest, @SafeParcelable.Param(id = 14) long j11, @SafeParcelable.Param(id = 15) String str5, @SafeParcelable.Param(id = 16) String str6, @HlsSegmentFormat @SafeParcelable.Param(id = 17) String str7, @SafeParcelable.Param(id = 18) @HlsVideoSegmentFormat String str8) {
        this.zzt = new Writer();
        this.zzc = str;
        this.zzd = i10;
        this.zze = str2;
        this.zzf = mediaMetadata;
        this.zzg = j10;
        this.zzh = list;
        this.zzi = textTrackStyle;
        this.zzb = str3;
        if (str3 != null) {
            try {
                this.zzs = new JSONObject(str3);
            } catch (JSONException unused) {
                this.zzs = null;
                this.zzb = null;
            }
        } else {
            this.zzs = null;
        }
        this.zzj = list2;
        this.zzk = list3;
        this.zzl = str4;
        this.zzm = vastAdsRequest;
        this.zzn = j11;
        this.zzo = str5;
        this.zzp = str6;
        this.zzq = str7;
        this.zzr = str8;
    }

    public MediaInfo(String str, String str2) {
        this(str, -1, null, null, -1L, null, null, null, null, null, str2, null, -1L, null, null, null, null);
        if (str == null) {
            throw new IllegalArgumentException("contentID cannot be null");
        }
    }

    public MediaInfo(JSONObject jSONObject) {
        this(jSONObject.optString("contentId"), -1, null, null, -1L, null, null, null, null, null, null, null, -1L, null, null, null, null);
        MediaInfo mediaInfo;
        int i10;
        int i11;
        zzdu zzduVar;
        String optString = jSONObject.optString("streamType", "NONE");
        if ("NONE".equals(optString)) {
            mediaInfo = this;
            mediaInfo.zzd = 0;
        } else {
            mediaInfo = this;
            if ("BUFFERED".equals(optString)) {
                mediaInfo.zzd = 1;
            } else if ("LIVE".equals(optString)) {
                mediaInfo.zzd = 2;
            } else {
                mediaInfo.zzd = -1;
            }
        }
        mediaInfo.zze = CastUtils.optStringOrNull(jSONObject, "contentType");
        if (jSONObject.has("metadata")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("metadata");
            MediaMetadata mediaMetadata = new MediaMetadata(jSONObject2.getInt("metadataType"));
            mediaInfo.zzf = mediaMetadata;
            mediaMetadata.zzc(jSONObject2);
        }
        mediaInfo.zzg = -1L;
        if (jSONObject.has("duration") && !jSONObject.isNull("duration")) {
            double optDouble = jSONObject.optDouble("duration", 0.0d);
            if (!Double.isNaN(optDouble) && !Double.isInfinite(optDouble)) {
                mediaInfo.zzg = CastUtils.secToMillisec(optDouble);
            }
        }
        if (jSONObject.has("tracks")) {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray("tracks");
            for (int i12 = 0; i12 < jSONArray.length(); i12++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i12);
                String str = MediaTrack.ROLE_ALTERNATE;
                long j10 = jSONObject3.getLong("trackId");
                String optString2 = jSONObject3.optString("type");
                if ("TEXT".equals(optString2)) {
                    i10 = 1;
                } else if ("AUDIO".equals(optString2)) {
                    i10 = 2;
                } else {
                    i10 = "VIDEO".equals(optString2) ? 3 : 0;
                }
                String optStringOrNull = CastUtils.optStringOrNull(jSONObject3, "trackContentId");
                String optStringOrNull2 = CastUtils.optStringOrNull(jSONObject3, "trackContentType");
                String optStringOrNull3 = CastUtils.optStringOrNull(jSONObject3, "name");
                String optStringOrNull4 = CastUtils.optStringOrNull(jSONObject3, "language");
                if (jSONObject3.has("subtype")) {
                    String string = jSONObject3.getString("subtype");
                    if ("SUBTITLES".equals(string)) {
                        i11 = 1;
                    } else if ("CAPTIONS".equals(string)) {
                        i11 = 2;
                    } else if ("DESCRIPTIONS".equals(string)) {
                        i11 = 3;
                    } else if ("CHAPTERS".equals(string)) {
                        i11 = 4;
                    } else {
                        i11 = "METADATA".equals(string) ? 5 : -1;
                    }
                } else {
                    i11 = 0;
                }
                if (jSONObject3.has("roles")) {
                    zzdr zzi = zzdu.zzi();
                    JSONArray jSONArray2 = jSONObject3.getJSONArray("roles");
                    for (int i13 = 0; i13 < jSONArray2.length(); i13++) {
                        zzi.zzb((zzdr) jSONArray2.optString(i13));
                    }
                    zzduVar = zzi.zzc();
                } else {
                    zzduVar = null;
                }
                arrayList.add(new MediaTrack(j10, i10, optStringOrNull, optStringOrNull2, optStringOrNull3, optStringOrNull4, i11, zzduVar, jSONObject3.optJSONObject("customData")));
            }
            mediaInfo.zzh = new ArrayList(arrayList);
        } else {
            mediaInfo.zzh = null;
        }
        if (jSONObject.has("textTrackStyle")) {
            JSONObject jSONObject4 = jSONObject.getJSONObject("textTrackStyle");
            TextTrackStyle textTrackStyle = new TextTrackStyle();
            textTrackStyle.fromJson(jSONObject4);
            mediaInfo.zzi = textTrackStyle;
        } else {
            mediaInfo.zzi = null;
        }
        zzs(jSONObject);
        mediaInfo.zzs = jSONObject.optJSONObject("customData");
        mediaInfo.zzl = CastUtils.optStringOrNull(jSONObject, "entity");
        mediaInfo.zzo = CastUtils.optStringOrNull(jSONObject, "atvEntity");
        mediaInfo.zzm = VastAdsRequest.fromJson(jSONObject.optJSONObject("vmapAdsRequest"));
        if (jSONObject.has("startAbsoluteTime") && !jSONObject.isNull("startAbsoluteTime")) {
            double optDouble2 = jSONObject.optDouble("startAbsoluteTime");
            if (!Double.isNaN(optDouble2) && !Double.isInfinite(optDouble2) && optDouble2 >= 0.0d) {
                mediaInfo.zzn = CastUtils.secToMillisec(optDouble2);
            }
        }
        if (jSONObject.has("contentUrl")) {
            mediaInfo.zzp = jSONObject.optString("contentUrl");
        }
        mediaInfo.zzq = CastUtils.optStringOrNull(jSONObject, "hlsSegmentFormat");
        mediaInfo.zzr = CastUtils.optStringOrNull(jSONObject, "hlsVideoSegmentFormat");
    }
}
