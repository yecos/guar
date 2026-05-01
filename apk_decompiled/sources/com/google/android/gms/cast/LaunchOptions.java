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
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Locale;

@SafeParcelable.Class(creator = "LaunchOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public class LaunchOptions extends AbstractSafeParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<LaunchOptions> CREATOR = new zzbs();

    @SafeParcelable.Field(getter = "getRelaunchIfRunning", id = 2)
    private boolean zza;

    @SafeParcelable.Field(getter = "getLanguage", id = 3)
    private String zzb;

    @SafeParcelable.Field(getter = "getAndroidReceiverCompatible", id = 4)
    private boolean zzc;

    @SafeParcelable.Field(getter = "getCredentialsData", id = 5)
    private CredentialsData zzd;

    @VisibleForTesting
    public static final class Builder {
        private LaunchOptions zza;

        public Builder() {
            this.zza = new LaunchOptions();
        }

        @RecentlyNonNull
        public LaunchOptions build() {
            return this.zza;
        }

        @RecentlyNonNull
        public Builder setAndroidReceiverCompatible(boolean z10) {
            this.zza.zzb(z10);
            return this;
        }

        @RecentlyNonNull
        public Builder setCredentialsData(@RecentlyNonNull CredentialsData credentialsData) {
            this.zza.zzd = credentialsData;
            return this;
        }

        @RecentlyNonNull
        public Builder setLocale(@RecentlyNonNull Locale locale) {
            this.zza.setLanguage(CastUtils.zzd(locale));
            return this;
        }

        @RecentlyNonNull
        public Builder setRelaunchIfRunning(boolean z10) {
            this.zza.setRelaunchIfRunning(z10);
            return this;
        }

        public Builder(@RecentlyNonNull LaunchOptions launchOptions) {
            this.zza = new LaunchOptions(launchOptions.getRelaunchIfRunning(), launchOptions.getLanguage(), launchOptions.getAndroidReceiverCompatible(), launchOptions.getCredentialsData());
        }
    }

    public LaunchOptions() {
        this(false, CastUtils.zzd(Locale.getDefault()), false, null);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LaunchOptions)) {
            return false;
        }
        LaunchOptions launchOptions = (LaunchOptions) obj;
        return this.zza == launchOptions.zza && CastUtils.zzh(this.zzb, launchOptions.zzb) && this.zzc == launchOptions.zzc && CastUtils.zzh(this.zzd, launchOptions.zzd);
    }

    public boolean getAndroidReceiverCompatible() {
        return this.zzc;
    }

    @RecentlyNullable
    public CredentialsData getCredentialsData() {
        return this.zzd;
    }

    @RecentlyNonNull
    public String getLanguage() {
        return this.zzb;
    }

    public boolean getRelaunchIfRunning() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.zza), this.zzb, Boolean.valueOf(this.zzc), this.zzd);
    }

    public void setLanguage(@RecentlyNonNull String str) {
        this.zzb = str;
    }

    public void setRelaunchIfRunning(boolean z10) {
        this.zza = z10;
    }

    @RecentlyNonNull
    public String toString() {
        return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s, androidReceiverCompatible: %b)", Boolean.valueOf(this.zza), this.zzb, Boolean.valueOf(this.zzc));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, getRelaunchIfRunning());
        SafeParcelWriter.writeString(parcel, 3, getLanguage(), false);
        SafeParcelWriter.writeBoolean(parcel, 4, getAndroidReceiverCompatible());
        SafeParcelWriter.writeParcelable(parcel, 5, getCredentialsData(), i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final void zzb(boolean z10) {
        this.zzc = z10;
    }

    @SafeParcelable.Constructor
    public LaunchOptions(@SafeParcelable.Param(id = 2) boolean z10, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) boolean z11, @SafeParcelable.Param(id = 5) CredentialsData credentialsData) {
        this.zza = z10;
        this.zzb = str;
        this.zzc = z11;
        this.zzd = credentialsData;
    }
}
