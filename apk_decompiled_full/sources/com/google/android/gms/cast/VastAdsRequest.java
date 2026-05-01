package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "VastAdsRequestCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public class VastAdsRequest extends AbstractSafeParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<VastAdsRequest> CREATOR = new zzdp();

    @SafeParcelable.Field(getter = "getAdTagUrl", id = 2)
    private final String zza;

    @SafeParcelable.Field(getter = "getAdsResponse", id = 3)
    private final String zzb;

    public static class Builder {
        private String zza;
        private String zzb;

        @RecentlyNonNull
        public VastAdsRequest build() {
            return new VastAdsRequest(this.zza, this.zzb);
        }

        @RecentlyNonNull
        public Builder setAdTagUrl(@RecentlyNonNull String str) {
            this.zza = str;
            return this;
        }

        @RecentlyNonNull
        public Builder setAdsResponse(@RecentlyNonNull String str) {
            this.zzb = str;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public VastAdsRequest(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    @RecentlyNullable
    public static VastAdsRequest fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new VastAdsRequest(CastUtils.optStringOrNull(jSONObject, "adTagUrl"), CastUtils.optStringOrNull(jSONObject, "adsResponse"));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VastAdsRequest)) {
            return false;
        }
        VastAdsRequest vastAdsRequest = (VastAdsRequest) obj;
        return CastUtils.zzh(this.zza, vastAdsRequest.zza) && CastUtils.zzh(this.zzb, vastAdsRequest.zzb);
    }

    @RecentlyNullable
    public String getAdTagUrl() {
        return this.zza;
    }

    @RecentlyNullable
    public String getAdsResponse() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getAdTagUrl(), false);
        SafeParcelWriter.writeString(parcel, 3, getAdsResponse(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @RecentlyNonNull
    public final JSONObject zza() {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = this.zza;
            if (str != null) {
                jSONObject.put("adTagUrl", str);
            }
            String str2 = this.zzb;
            if (str2 != null) {
                jSONObject.put("adsResponse", str2);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
