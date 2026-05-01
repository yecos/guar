package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
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
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.cast.zzdu;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "MediaTrackCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class MediaTrack extends AbstractSafeParcelable implements ReflectedParcelable {

    @RecentlyNonNull
    @KeepForSdk
    public static final Parcelable.Creator<MediaTrack> CREATOR = new zzcj();

    @RecentlyNonNull
    public static final String ROLE_ALTERNATE = "alternate";

    @RecentlyNonNull
    public static final String ROLE_CAPTION = "caption";

    @RecentlyNonNull
    public static final String ROLE_COMMENTARY = "commentary";

    @RecentlyNonNull
    public static final String ROLE_DESCRIPTION = "description";

    @RecentlyNonNull
    public static final String ROLE_DUB = "dub";

    @RecentlyNonNull
    public static final String ROLE_EMERGENCY = "emergency";

    @RecentlyNonNull
    public static final String ROLE_FORCED_SUBTITLE = "forced_subtitle";

    @RecentlyNonNull
    public static final String ROLE_MAIN = "main";

    @RecentlyNonNull
    public static final String ROLE_SIGN = "sign";

    @RecentlyNonNull
    public static final String ROLE_SUBTITLE = "subtitle";

    @RecentlyNonNull
    public static final String ROLE_SUPPLEMENTARY = "supplementary";
    public static final int SUBTYPE_CAPTIONS = 2;
    public static final int SUBTYPE_CHAPTERS = 4;
    public static final int SUBTYPE_DESCRIPTIONS = 3;
    public static final int SUBTYPE_METADATA = 5;
    public static final int SUBTYPE_NONE = 0;
    public static final int SUBTYPE_SUBTITLES = 1;
    public static final int SUBTYPE_UNKNOWN = -1;
    public static final int TYPE_AUDIO = 2;
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_VIDEO = 3;

    @SafeParcelable.Field(id = 10)
    String zza;

    @SafeParcelable.Field(getter = "getId", id = 2)
    private long zzb;

    @SafeParcelable.Field(getter = "getType", id = 3)
    private int zzc;

    @SafeParcelable.Field(getter = "getContentId", id = 4)
    private String zzd;

    @SafeParcelable.Field(getter = "getContentType", id = 5)
    private String zze;

    @SafeParcelable.Field(getter = "getName", id = 6)
    private String zzf;

    @SafeParcelable.Field(getter = "getLanguage", id = 7)
    private final String zzg;

    @SafeParcelable.Field(getter = "getSubtype", id = 8)
    private int zzh;

    @SafeParcelable.Field(getter = "getRoles", id = 9)
    private final List<String> zzi;
    private final JSONObject zzj;

    @VisibleForTesting
    public static class Builder {
        private final long zza;
        private final int zzb;
        private String zzc;
        private String zzd;
        private String zze;
        private String zzf;
        private int zzg = 0;
        private List<String> zzh;
        private JSONObject zzi;

        public Builder(long j10, int i10) {
            this.zza = j10;
            this.zzb = i10;
        }

        @RecentlyNonNull
        public MediaTrack build() {
            return new MediaTrack(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi);
        }

        @RecentlyNonNull
        public Builder setContentId(String str) {
            this.zzc = str;
            return this;
        }

        @RecentlyNonNull
        public Builder setContentType(String str) {
            this.zzd = str;
            return this;
        }

        @RecentlyNonNull
        public Builder setCustomData(JSONObject jSONObject) {
            this.zzi = jSONObject;
            return this;
        }

        @RecentlyNonNull
        public Builder setLanguage(String str) {
            this.zzf = str;
            return this;
        }

        @RecentlyNonNull
        public Builder setName(String str) {
            this.zze = str;
            return this;
        }

        @RecentlyNonNull
        public Builder setRoles(List<String> list) {
            if (list != null) {
                list = zzdu.zzl(list);
            }
            this.zzh = list;
            return this;
        }

        @RecentlyNonNull
        public Builder setSubtype(int i10) {
            if (i10 < -1 || i10 > 5) {
                StringBuilder sb = new StringBuilder(27);
                sb.append("invalid subtype ");
                sb.append(i10);
                throw new IllegalArgumentException(sb.toString());
            }
            if (i10 != 0 && this.zzb != 1) {
                throw new IllegalArgumentException("subtypes are only valid for text tracks");
            }
            this.zzg = i10;
            return this;
        }

        @RecentlyNonNull
        public Builder setLanguage(@RecentlyNonNull Locale locale) {
            this.zzf = CastUtils.zzd(locale);
            return this;
        }
    }

    public MediaTrack(long j10, int i10, String str, String str2, String str3, String str4, int i11, List<String> list, JSONObject jSONObject) {
        this.zzb = j10;
        this.zzc = i10;
        this.zzd = str;
        this.zze = str2;
        this.zzf = str3;
        this.zzg = str4;
        this.zzh = i11;
        this.zzi = list;
        this.zzj = jSONObject;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaTrack)) {
            return false;
        }
        MediaTrack mediaTrack = (MediaTrack) obj;
        JSONObject jSONObject = this.zzj;
        boolean z10 = jSONObject == null;
        JSONObject jSONObject2 = mediaTrack.zzj;
        if (z10 != (jSONObject2 == null)) {
            return false;
        }
        return (jSONObject == null || jSONObject2 == null || JsonUtils.areJsonValuesEquivalent(jSONObject, jSONObject2)) && this.zzb == mediaTrack.zzb && this.zzc == mediaTrack.zzc && CastUtils.zzh(this.zzd, mediaTrack.zzd) && CastUtils.zzh(this.zze, mediaTrack.zze) && CastUtils.zzh(this.zzf, mediaTrack.zzf) && CastUtils.zzh(this.zzg, mediaTrack.zzg) && this.zzh == mediaTrack.zzh && CastUtils.zzh(this.zzi, mediaTrack.zzi);
    }

    @RecentlyNullable
    public String getContentId() {
        return this.zzd;
    }

    @RecentlyNullable
    public String getContentType() {
        return this.zze;
    }

    @RecentlyNullable
    public JSONObject getCustomData() {
        return this.zzj;
    }

    public long getId() {
        return this.zzb;
    }

    @RecentlyNullable
    public String getLanguage() {
        return this.zzg;
    }

    @RecentlyNullable
    public Locale getLanguageLocale() {
        Locale forLanguageTag;
        if (TextUtils.isEmpty(this.zzg)) {
            return null;
        }
        if (PlatformVersion.isAtLeastLollipop()) {
            forLanguageTag = Locale.forLanguageTag(this.zzg);
            return forLanguageTag;
        }
        String[] split = this.zzg.split(Operator.Operation.MINUS, -1);
        return split.length == 1 ? new Locale(split[0]) : new Locale(split[0], split[1]);
    }

    @RecentlyNullable
    public String getName() {
        return this.zzf;
    }

    @RecentlyNullable
    public List<String> getRoles() {
        return this.zzi;
    }

    public int getSubtype() {
        return this.zzh;
    }

    public int getType() {
        return this.zzc;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zzb), Integer.valueOf(this.zzc), this.zzd, this.zze, this.zzf, this.zzg, Integer.valueOf(this.zzh), this.zzi, String.valueOf(this.zzj));
    }

    public void setContentId(String str) {
        this.zzd = str;
    }

    public void setContentType(String str) {
        this.zze = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
        JSONObject jSONObject = this.zzj;
        this.zza = jSONObject == null ? null : jSONObject.toString();
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 2, getId());
        SafeParcelWriter.writeInt(parcel, 3, getType());
        SafeParcelWriter.writeString(parcel, 4, getContentId(), false);
        SafeParcelWriter.writeString(parcel, 5, getContentType(), false);
        SafeParcelWriter.writeString(parcel, 6, getName(), false);
        SafeParcelWriter.writeString(parcel, 7, getLanguage(), false);
        SafeParcelWriter.writeInt(parcel, 8, getSubtype());
        SafeParcelWriter.writeStringList(parcel, 9, getRoles(), false);
        SafeParcelWriter.writeString(parcel, 10, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @RecentlyNonNull
    public final JSONObject zza() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("trackId", this.zzb);
            int i10 = this.zzc;
            if (i10 == 1) {
                jSONObject.put("type", "TEXT");
            } else if (i10 == 2) {
                jSONObject.put("type", "AUDIO");
            } else if (i10 == 3) {
                jSONObject.put("type", "VIDEO");
            }
            String str = this.zzd;
            if (str != null) {
                jSONObject.put("trackContentId", str);
            }
            String str2 = this.zze;
            if (str2 != null) {
                jSONObject.put("trackContentType", str2);
            }
            String str3 = this.zzf;
            if (str3 != null) {
                jSONObject.put("name", str3);
            }
            if (!TextUtils.isEmpty(this.zzg)) {
                jSONObject.put("language", this.zzg);
            }
            int i11 = this.zzh;
            if (i11 == 1) {
                jSONObject.put("subtype", "SUBTITLES");
            } else if (i11 == 2) {
                jSONObject.put("subtype", "CAPTIONS");
            } else if (i11 == 3) {
                jSONObject.put("subtype", "DESCRIPTIONS");
            } else if (i11 == 4) {
                jSONObject.put("subtype", "CHAPTERS");
            } else if (i11 == 5) {
                jSONObject.put("subtype", "METADATA");
            }
            List<String> list = this.zzi;
            if (list != null) {
                jSONObject.put("roles", new JSONArray((Collection) list));
            }
            JSONObject jSONObject2 = this.zzj;
            if (jSONObject2 != null) {
                jSONObject.put("customData", jSONObject2);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
