package com.google.android.gms.cast.framework;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.cast.zzdf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "CastOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public class CastOptions extends AbstractSafeParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<CastOptions> CREATOR = new zze();

    @SafeParcelable.Field(getter = "getReceiverApplicationId", id = 2)
    private String zza;

    @SafeParcelable.Field(getter = "getSupportedNamespaces", id = 3)
    private final List<String> zzb;

    @SafeParcelable.Field(getter = "getStopReceiverApplicationWhenEndingSession", id = 4)
    private boolean zzc;

    @SafeParcelable.Field(getter = "getLaunchOptions", id = 5)
    private LaunchOptions zzd;

    @SafeParcelable.Field(getter = "getResumeSavedSession", id = 6)
    private final boolean zze;

    @SafeParcelable.Field(getter = "getCastMediaOptions", id = 7)
    private final CastMediaOptions zzf;

    @SafeParcelable.Field(getter = "getEnableReconnectionService", id = 8)
    private final boolean zzg;

    @SafeParcelable.Field(getter = "getVolumeDeltaBeforeIceCreamSandwich", id = 9)
    private final double zzh;

    @SafeParcelable.Field(getter = "getEnableIpv6Support", id = 10)
    private final boolean zzi;

    @SafeParcelable.Field(getter = "getOutputSwitcherEnabled", id = 11)
    private final boolean zzj;

    @SafeParcelable.Field(getter = "getTransferToLocalEnabled", id = 12)
    private final boolean zzk;

    @VisibleForTesting
    public static final class Builder {
        private String zza;
        private boolean zzc;
        private List<String> zzb = new ArrayList();
        private LaunchOptions zzd = new LaunchOptions();
        private boolean zze = true;
        private zzdf<CastMediaOptions> zzf = null;
        private boolean zzg = true;
        private double zzh = 0.05000000074505806d;

        @RecentlyNonNull
        public CastOptions build() {
            zzdf<CastMediaOptions> zzdfVar = this.zzf;
            return new CastOptions(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzdfVar != null ? zzdfVar.zza() : new CastMediaOptions.Builder().build(), this.zzg, this.zzh, false, false, false);
        }

        @RecentlyNonNull
        public Builder setCastMediaOptions(@RecentlyNonNull CastMediaOptions castMediaOptions) {
            this.zzf = zzdf.zzb(castMediaOptions);
            return this;
        }

        @RecentlyNonNull
        public Builder setEnableReconnectionService(boolean z10) {
            this.zzg = z10;
            return this;
        }

        @RecentlyNonNull
        public Builder setLaunchOptions(@RecentlyNonNull LaunchOptions launchOptions) {
            this.zzd = launchOptions;
            return this;
        }

        @RecentlyNonNull
        public Builder setReceiverApplicationId(@RecentlyNonNull String str) {
            this.zza = str;
            return this;
        }

        @RecentlyNonNull
        public Builder setResumeSavedSession(boolean z10) {
            this.zze = z10;
            return this;
        }

        @RecentlyNonNull
        public Builder setStopReceiverApplicationWhenEndingSession(boolean z10) {
            this.zzc = z10;
            return this;
        }

        @RecentlyNonNull
        public Builder setSupportedNamespaces(@RecentlyNonNull List<String> list) {
            this.zzb = list;
            return this;
        }

        @RecentlyNonNull
        public Builder setVolumeDeltaBeforeIceCreamSandwich(double d10) {
            if (d10 <= 0.0d || d10 > 0.5d) {
                throw new IllegalArgumentException("volumeDelta must be greater than 0 and less or equal to 0.5");
            }
            this.zzh = d10;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public CastOptions(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) List<String> list, @SafeParcelable.Param(id = 4) boolean z10, @SafeParcelable.Param(id = 5) LaunchOptions launchOptions, @SafeParcelable.Param(id = 6) boolean z11, @SafeParcelable.Param(id = 7) CastMediaOptions castMediaOptions, @SafeParcelable.Param(id = 8) boolean z12, @SafeParcelable.Param(id = 9) double d10, @SafeParcelable.Param(id = 10) boolean z13, @SafeParcelable.Param(id = 11) boolean z14, @SafeParcelable.Param(id = 12) boolean z15) {
        this.zza = true == TextUtils.isEmpty(str) ? "" : str;
        int size = list == null ? 0 : list.size();
        ArrayList arrayList = new ArrayList(size);
        this.zzb = arrayList;
        if (size > 0) {
            arrayList.addAll(list);
        }
        this.zzc = z10;
        this.zzd = launchOptions == null ? new LaunchOptions() : launchOptions;
        this.zze = z11;
        this.zzf = castMediaOptions;
        this.zzg = z12;
        this.zzh = d10;
        this.zzi = z13;
        this.zzj = z14;
        this.zzk = z15;
    }

    @RecentlyNullable
    public CastMediaOptions getCastMediaOptions() {
        return this.zzf;
    }

    public boolean getEnableReconnectionService() {
        return this.zzg;
    }

    @RecentlyNonNull
    public LaunchOptions getLaunchOptions() {
        return this.zzd;
    }

    @RecentlyNonNull
    public String getReceiverApplicationId() {
        return this.zza;
    }

    public boolean getResumeSavedSession() {
        return this.zze;
    }

    public boolean getStopReceiverApplicationWhenEndingSession() {
        return this.zzc;
    }

    @RecentlyNonNull
    public List<String> getSupportedNamespaces() {
        return Collections.unmodifiableList(this.zzb);
    }

    public double getVolumeDeltaBeforeIceCreamSandwich() {
        return this.zzh;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getReceiverApplicationId(), false);
        SafeParcelWriter.writeStringList(parcel, 3, getSupportedNamespaces(), false);
        SafeParcelWriter.writeBoolean(parcel, 4, getStopReceiverApplicationWhenEndingSession());
        SafeParcelWriter.writeParcelable(parcel, 5, getLaunchOptions(), i10, false);
        SafeParcelWriter.writeBoolean(parcel, 6, getResumeSavedSession());
        SafeParcelWriter.writeParcelable(parcel, 7, getCastMediaOptions(), i10, false);
        SafeParcelWriter.writeBoolean(parcel, 8, getEnableReconnectionService());
        SafeParcelWriter.writeDouble(parcel, 9, getVolumeDeltaBeforeIceCreamSandwich());
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzi);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzj);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzk);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final void zza(@RecentlyNonNull LaunchOptions launchOptions) {
        this.zzd = launchOptions;
    }

    public final void zzb(@RecentlyNonNull String str) {
        this.zza = str;
    }

    public final boolean zzc() {
        return this.zzj;
    }

    public final boolean zzd() {
        return this.zzk;
    }
}
