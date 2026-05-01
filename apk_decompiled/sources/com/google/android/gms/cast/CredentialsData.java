package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "CredentialsDataCreator")
/* loaded from: classes.dex */
public class CredentialsData extends AbstractSafeParcelable {

    @RecentlyNonNull
    @KeepForSdk
    public static final Parcelable.Creator<CredentialsData> CREATOR = new zzao();

    @RecentlyNonNull
    public static final String CREDENTIALS_TYPE_ANDROID = "android";

    @RecentlyNonNull
    public static final String CREDENTIALS_TYPE_CLOUD = "cloud";

    @RecentlyNonNull
    public static final String CREDENTIALS_TYPE_IOS = "ios";

    @RecentlyNonNull
    public static final String CREDENTIALS_TYPE_WEB = "web";

    @SafeParcelable.Field(getter = "getCredentials", id = 1)
    private final String zza;

    @SafeParcelable.Field(getter = "getCredentialsType", id = 2)
    private final String zzb;

    public static class Builder {
        private String zza;
        private String zzb = "android";

        @RecentlyNonNull
        public CredentialsData build() {
            return new CredentialsData(this.zza, this.zzb);
        }

        @RecentlyNonNull
        public Builder setCredentials(@RecentlyNonNull String str) {
            this.zza = str;
            return this;
        }

        @RecentlyNonNull
        public Builder setCredentialsType(@RecentlyNonNull String str) {
            this.zzb = str;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public CredentialsData(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    @RecentlyNullable
    @KeepForSdk
    public static CredentialsData fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new CredentialsData(CastUtils.optStringOrNull(jSONObject, "credentials"), CastUtils.optStringOrNull(jSONObject, "credentialsType"));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CredentialsData)) {
            return false;
        }
        CredentialsData credentialsData = (CredentialsData) obj;
        return Objects.equal(this.zza, credentialsData.zza) && Objects.equal(this.zzb, credentialsData.zzb);
    }

    @RecentlyNullable
    public String getCredentials() {
        return this.zza;
    }

    @RecentlyNullable
    public String getCredentialsType() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getCredentials(), false);
        SafeParcelWriter.writeString(parcel, 2, getCredentialsType(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
