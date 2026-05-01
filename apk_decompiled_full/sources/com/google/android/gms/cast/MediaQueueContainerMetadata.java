package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "MediaQueueContainerMetadataCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public class MediaQueueContainerMetadata extends AbstractSafeParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<MediaQueueContainerMetadata> CREATOR = new zzcc();
    public static final int MEDIA_QUEUE_CONTAINER_TYPE_AUDIO_BOOK = 1;
    public static final int MEDIA_QUEUE_CONTAINER_TYPE_GENERIC = 0;

    @SafeParcelable.Field(getter = "getContainerType", id = 2)
    private int zza;

    @SafeParcelable.Field(getter = "getTitle", id = 3)
    private String zzb;

    @SafeParcelable.Field(getter = "getSections", id = 4)
    private List<MediaMetadata> zzc;

    @SafeParcelable.Field(getter = "getContainerImages", id = 5)
    private List<WebImage> zzd;

    @SafeParcelable.Field(getter = "getContainerDuration", id = 6)
    private double zze;

    public static class Builder {
        private final MediaQueueContainerMetadata zza = new MediaQueueContainerMetadata(null);

        @RecentlyNonNull
        public MediaQueueContainerMetadata build() {
            return new MediaQueueContainerMetadata(this.zza, null);
        }

        @RecentlyNonNull
        public Builder setContainerDuration(double d10) {
            this.zza.zze = d10;
            return this;
        }

        @RecentlyNonNull
        public Builder setContainerImages(List<WebImage> list) {
            MediaQueueContainerMetadata.zzd(this.zza, list);
            return this;
        }

        @RecentlyNonNull
        public Builder setContainerType(int i10) {
            this.zza.zza = i10;
            return this;
        }

        @RecentlyNonNull
        public Builder setSections(List<MediaMetadata> list) {
            this.zza.zzg(list);
            return this;
        }

        @RecentlyNonNull
        public Builder setTitle(String str) {
            this.zza.zzb = str;
            return this;
        }

        @RecentlyNonNull
        public final Builder zza(@RecentlyNonNull JSONObject jSONObject) {
            MediaQueueContainerMetadata.zzb(this.zza, jSONObject);
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaQueueContainerType {
    }

    private MediaQueueContainerMetadata() {
        zzh();
    }

    public static /* bridge */ /* synthetic */ void zzb(MediaQueueContainerMetadata mediaQueueContainerMetadata, JSONObject jSONObject) {
        char c10;
        mediaQueueContainerMetadata.zzh();
        String optString = jSONObject.optString("containerType", "");
        int hashCode = optString.hashCode();
        if (hashCode != 6924225) {
            if (hashCode == 828666841 && optString.equals("GENERIC_CONTAINER")) {
                c10 = 0;
            }
            c10 = 65535;
        } else {
            if (optString.equals("AUDIOBOOK_CONTAINER")) {
                c10 = 1;
            }
            c10 = 65535;
        }
        if (c10 == 0) {
            mediaQueueContainerMetadata.zza = 0;
        } else if (c10 == 1) {
            mediaQueueContainerMetadata.zza = 1;
        }
        mediaQueueContainerMetadata.zzb = CastUtils.optStringOrNull(jSONObject, "title");
        JSONArray optJSONArray = jSONObject.optJSONArray("sections");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            mediaQueueContainerMetadata.zzc = arrayList;
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                if (optJSONObject != null) {
                    MediaMetadata mediaMetadata = new MediaMetadata();
                    mediaMetadata.zzc(optJSONObject);
                    arrayList.add(mediaMetadata);
                }
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("containerImages");
        if (optJSONArray2 != null) {
            ArrayList arrayList2 = new ArrayList();
            mediaQueueContainerMetadata.zzd = arrayList2;
            com.google.android.gms.cast.internal.media.zza.zzd(arrayList2, optJSONArray2);
        }
        mediaQueueContainerMetadata.zze = jSONObject.optDouble("containerDuration", mediaQueueContainerMetadata.zze);
    }

    public static /* bridge */ /* synthetic */ void zzd(MediaQueueContainerMetadata mediaQueueContainerMetadata, List list) {
        mediaQueueContainerMetadata.zzd = list == null ? null : new ArrayList(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzh() {
        this.zza = 0;
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = 0.0d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaQueueContainerMetadata)) {
            return false;
        }
        MediaQueueContainerMetadata mediaQueueContainerMetadata = (MediaQueueContainerMetadata) obj;
        return this.zza == mediaQueueContainerMetadata.zza && TextUtils.equals(this.zzb, mediaQueueContainerMetadata.zzb) && Objects.equal(this.zzc, mediaQueueContainerMetadata.zzc) && Objects.equal(this.zzd, mediaQueueContainerMetadata.zzd) && this.zze == mediaQueueContainerMetadata.zze;
    }

    public double getContainerDuration() {
        return this.zze;
    }

    @RecentlyNullable
    public List<WebImage> getContainerImages() {
        List<WebImage> list = this.zzd;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public int getContainerType() {
        return this.zza;
    }

    @RecentlyNullable
    public List<MediaMetadata> getSections() {
        List<MediaMetadata> list = this.zzc;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    @RecentlyNullable
    public String getTitle() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), this.zzb, this.zzc, this.zzd, Double.valueOf(this.zze));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, getContainerType());
        SafeParcelWriter.writeString(parcel, 3, getTitle(), false);
        SafeParcelWriter.writeTypedList(parcel, 4, getSections(), false);
        SafeParcelWriter.writeTypedList(parcel, 5, getContainerImages(), false);
        SafeParcelWriter.writeDouble(parcel, 6, getContainerDuration());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @RecentlyNonNull
    public final JSONObject zza() {
        JSONObject jSONObject = new JSONObject();
        try {
            int i10 = this.zza;
            if (i10 == 0) {
                jSONObject.put("containerType", "GENERIC_CONTAINER");
            } else if (i10 == 1) {
                jSONObject.put("containerType", "AUDIOBOOK_CONTAINER");
            }
            if (!TextUtils.isEmpty(this.zzb)) {
                jSONObject.put("title", this.zzb);
            }
            List<MediaMetadata> list = this.zzc;
            if (list != null && !list.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                Iterator<MediaMetadata> it = this.zzc.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().zza());
                }
                jSONObject.put("sections", jSONArray);
            }
            List<WebImage> list2 = this.zzd;
            if (list2 != null && !list2.isEmpty()) {
                jSONObject.put("containerImages", com.google.android.gms.cast.internal.media.zza.zzc(this.zzd));
            }
            jSONObject.put("containerDuration", this.zze);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final void zzg(List<MediaMetadata> list) {
        this.zzc = list == null ? null : new ArrayList(list);
    }

    @SafeParcelable.Constructor
    public MediaQueueContainerMetadata(@SafeParcelable.Param(id = 2) int i10, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) List<MediaMetadata> list, @SafeParcelable.Param(id = 5) List<WebImage> list2, @SafeParcelable.Param(id = 6) double d10) {
        this.zza = i10;
        this.zzb = str;
        this.zzc = list;
        this.zzd = list2;
        this.zze = d10;
    }

    public /* synthetic */ MediaQueueContainerMetadata(zzcb zzcbVar) {
        zzh();
    }

    public /* synthetic */ MediaQueueContainerMetadata(MediaQueueContainerMetadata mediaQueueContainerMetadata, zzcb zzcbVar) {
        this.zza = mediaQueueContainerMetadata.zza;
        this.zzb = mediaQueueContainerMetadata.zzb;
        this.zzc = mediaQueueContainerMetadata.zzc;
        this.zzd = mediaQueueContainerMetadata.zzd;
        this.zze = mediaQueueContainerMetadata.zze;
    }
}
