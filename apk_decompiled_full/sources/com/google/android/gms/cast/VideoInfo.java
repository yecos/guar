package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "VideoInfoCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class VideoInfo extends AbstractSafeParcelable {
    public static final int HDR_TYPE_DV = 3;
    public static final int HDR_TYPE_HDR = 4;
    public static final int HDR_TYPE_HDR10 = 2;
    public static final int HDR_TYPE_SDR = 1;
    public static final int HDR_TYPE_UNKNOWN = 0;

    @SafeParcelable.Field(getter = "getWidth", id = 2)
    private int zzb;

    @SafeParcelable.Field(getter = "getHeight", id = 3)
    private int zzc;

    @SafeParcelable.Field(getter = "getHdrType", id = 4)
    private int zzd;
    private static final Logger zza = new Logger("VideoInfo");

    @RecentlyNonNull
    public static final Parcelable.Creator<VideoInfo> CREATOR = new zzdq();

    public static class Builder {
        private int zza;
        private int zzb;
        private int zzc;

        @RecentlyNonNull
        public VideoInfo build() {
            return new VideoInfo(this.zza, this.zzb, this.zzc);
        }

        @RecentlyNonNull
        public Builder setHdrType(int i10) {
            this.zzc = i10;
            return this;
        }

        @RecentlyNonNull
        public Builder setHeight(int i10) {
            this.zzb = i10;
            return this;
        }

        @RecentlyNonNull
        public Builder setWidth(int i10) {
            this.zza = i10;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public VideoInfo(@SafeParcelable.Param(id = 2) int i10, @SafeParcelable.Param(id = 3) int i11, @SafeParcelable.Param(id = 4) int i12) {
        this.zzb = i10;
        this.zzc = i11;
        this.zzd = i12;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static VideoInfo zza(JSONObject jSONObject) {
        char c10;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString("hdrType");
            int hashCode = string.hashCode();
            int i10 = 3;
            if (hashCode == 3218) {
                if (string.equals("dv")) {
                    c10 = 0;
                    if (c10 != 0) {
                    }
                    return new VideoInfo(jSONObject.getInt("width"), jSONObject.getInt("height"), i10);
                }
                c10 = 65535;
                if (c10 != 0) {
                }
                return new VideoInfo(jSONObject.getInt("width"), jSONObject.getInt("height"), i10);
            }
            if (hashCode == 103158) {
                if (string.equals("hdr")) {
                    c10 = 2;
                    if (c10 != 0) {
                    }
                    return new VideoInfo(jSONObject.getInt("width"), jSONObject.getInt("height"), i10);
                }
                c10 = 65535;
                if (c10 != 0) {
                }
                return new VideoInfo(jSONObject.getInt("width"), jSONObject.getInt("height"), i10);
            }
            if (hashCode == 113729) {
                if (string.equals("sdr")) {
                    c10 = 3;
                    if (c10 != 0) {
                    }
                    return new VideoInfo(jSONObject.getInt("width"), jSONObject.getInt("height"), i10);
                }
                c10 = 65535;
                if (c10 != 0) {
                }
                return new VideoInfo(jSONObject.getInt("width"), jSONObject.getInt("height"), i10);
            }
            if (hashCode == 99136405 && string.equals("hdr10")) {
                c10 = 1;
                if (c10 != 0) {
                    if (c10 == 1) {
                        i10 = 2;
                    } else if (c10 == 2) {
                        i10 = 4;
                    } else if (c10 != 3) {
                        zza.d("Unknown HDR type: %s", string);
                        i10 = 0;
                    } else {
                        i10 = 1;
                    }
                }
                return new VideoInfo(jSONObject.getInt("width"), jSONObject.getInt("height"), i10);
            }
            c10 = 65535;
            if (c10 != 0) {
            }
            return new VideoInfo(jSONObject.getInt("width"), jSONObject.getInt("height"), i10);
        } catch (JSONException e10) {
            zza.d(e10, "Error while creating a VideoInfo instance from JSON", new Object[0]);
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoInfo)) {
            return false;
        }
        VideoInfo videoInfo = (VideoInfo) obj;
        return this.zzc == videoInfo.getHeight() && this.zzb == videoInfo.getWidth() && this.zzd == videoInfo.getHdrType();
    }

    public int getHdrType() {
        return this.zzd;
    }

    public int getHeight() {
        return this.zzc;
    }

    public int getWidth() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), Integer.valueOf(this.zzd));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, getWidth());
        SafeParcelWriter.writeInt(parcel, 3, getHeight());
        SafeParcelWriter.writeInt(parcel, 4, getHdrType());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final JSONObject zzb() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", this.zzb);
            jSONObject.put("height", this.zzc);
            int i10 = this.zzd;
            jSONObject.put("hdrType", i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? null : "hdr" : "dv" : "hdr10" : "sdr");
            return jSONObject;
        } catch (JSONException unused) {
            zza.e("Failed to transform VideoInfo into Json", new Object[0]);
            return new JSONObject();
        }
    }
}
