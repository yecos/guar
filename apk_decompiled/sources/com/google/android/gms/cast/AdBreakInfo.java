package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "AdBreakInfoCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public class AdBreakInfo extends AbstractSafeParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<AdBreakInfo> CREATOR = new zzb();

    @SafeParcelable.Field(getter = "getPlaybackPositionInMs", id = 2)
    private final long zza;

    @SafeParcelable.Field(getter = "getId", id = 3)
    private final String zzb;

    @SafeParcelable.Field(getter = "getDurationInMs", id = 4)
    private final long zzc;

    @SafeParcelable.Field(getter = "isWatched", id = 5)
    private final boolean zzd;

    @SafeParcelable.Field(getter = "getBreakClipIds", id = 6)
    private final String[] zze;

    @SafeParcelable.Field(getter = "isEmbedded", id = 7)
    private final boolean zzf;

    @SafeParcelable.Field(getter = "isExpanded", id = 8)
    private final boolean zzg;

    public static class Builder {
        private final long zza;
        private String zzb;
        private long zzc;
        private boolean zzd;
        private boolean zze;
        private String[] zzf;
        private boolean zzg;

        public Builder(long j10) {
            this.zza = j10;
        }

        @RecentlyNonNull
        public AdBreakInfo build() {
            return new AdBreakInfo(this.zza, this.zzb, this.zzc, this.zzd, this.zzf, this.zze, this.zzg);
        }

        @RecentlyNonNull
        public Builder setBreakClipIds(@RecentlyNonNull String[] strArr) {
            this.zzf = strArr;
            return this;
        }

        @RecentlyNonNull
        public Builder setDurationInMs(long j10) {
            this.zzc = j10;
            return this;
        }

        @RecentlyNonNull
        public Builder setId(@RecentlyNonNull String str) {
            this.zzb = str;
            return this;
        }

        @RecentlyNonNull
        public Builder setIsEmbedded(boolean z10) {
            this.zze = z10;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setIsExpanded(boolean z10) {
            this.zzg = z10;
            return this;
        }

        @RecentlyNonNull
        public Builder setIsWatched(boolean z10) {
            this.zzd = z10;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public AdBreakInfo(@SafeParcelable.Param(id = 2) long j10, @RecentlyNonNull @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) long j11, @SafeParcelable.Param(id = 5) boolean z10, @RecentlyNonNull @SafeParcelable.Param(id = 6) String[] strArr, @SafeParcelable.Param(id = 7) boolean z11, @SafeParcelable.Param(id = 8) boolean z12) {
        this.zza = j10;
        this.zzb = str;
        this.zzc = j11;
        this.zzd = z10;
        this.zze = strArr;
        this.zzf = z11;
        this.zzg = z12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdBreakInfo)) {
            return false;
        }
        AdBreakInfo adBreakInfo = (AdBreakInfo) obj;
        return CastUtils.zzh(this.zzb, adBreakInfo.zzb) && this.zza == adBreakInfo.zza && this.zzc == adBreakInfo.zzc && this.zzd == adBreakInfo.zzd && Arrays.equals(this.zze, adBreakInfo.zze) && this.zzf == adBreakInfo.zzf && this.zzg == adBreakInfo.zzg;
    }

    @RecentlyNonNull
    public String[] getBreakClipIds() {
        return this.zze;
    }

    public long getDurationInMs() {
        return this.zzc;
    }

    @RecentlyNonNull
    public String getId() {
        return this.zzb;
    }

    public long getPlaybackPositionInMs() {
        return this.zza;
    }

    public int hashCode() {
        return this.zzb.hashCode();
    }

    public boolean isEmbedded() {
        return this.zzf;
    }

    @KeepForSdk
    public boolean isExpanded() {
        return this.zzg;
    }

    public boolean isWatched() {
        return this.zzd;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 2, getPlaybackPositionInMs());
        SafeParcelWriter.writeString(parcel, 3, getId(), false);
        SafeParcelWriter.writeLong(parcel, 4, getDurationInMs());
        SafeParcelWriter.writeBoolean(parcel, 5, isWatched());
        SafeParcelWriter.writeStringArray(parcel, 6, getBreakClipIds(), false);
        SafeParcelWriter.writeBoolean(parcel, 7, isEmbedded());
        SafeParcelWriter.writeBoolean(parcel, 8, isExpanded());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @RecentlyNonNull
    public final JSONObject zza() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.zzb);
            jSONObject.put("position", CastUtils.millisecToSec(this.zza));
            jSONObject.put("isWatched", this.zzd);
            jSONObject.put("isEmbedded", this.zzf);
            jSONObject.put("duration", CastUtils.millisecToSec(this.zzc));
            jSONObject.put("expanded", this.zzg);
            if (this.zze != null) {
                JSONArray jSONArray = new JSONArray();
                for (String str : this.zze) {
                    jSONArray.put(str);
                }
                jSONObject.put("breakClipIds", jSONArray);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
