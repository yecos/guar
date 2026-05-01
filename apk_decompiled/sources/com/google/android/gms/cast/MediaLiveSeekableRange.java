package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "MediaLiveSeekableRangeCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public class MediaLiveSeekableRange extends AbstractSafeParcelable {

    @SafeParcelable.Field(getter = "getStartTime", id = 2)
    private final long zzb;

    @SafeParcelable.Field(getter = "getEndTime", id = 3)
    private final long zzc;

    @SafeParcelable.Field(getter = "isMovingWindow", id = 4)
    private final boolean zzd;

    @SafeParcelable.Field(getter = "isLiveDone", id = 5)
    private final boolean zze;
    private static final Logger zza = new Logger("MediaLiveSeekableRange");

    @RecentlyNonNull
    public static final Parcelable.Creator<MediaLiveSeekableRange> CREATOR = new zzbv();

    public static class Builder {
        private long zza;
        private long zzb;
        private boolean zzc;
        private boolean zzd;

        @RecentlyNonNull
        public MediaLiveSeekableRange build() {
            return new MediaLiveSeekableRange(this.zza, this.zzb, this.zzc, this.zzd);
        }

        @RecentlyNonNull
        public Builder setEndTime(long j10) {
            this.zzb = j10;
            return this;
        }

        @RecentlyNonNull
        public Builder setIsLiveDone(boolean z10) {
            this.zzd = z10;
            return this;
        }

        @RecentlyNonNull
        public Builder setIsMovingWindow(boolean z10) {
            this.zzc = z10;
            return this;
        }

        @RecentlyNonNull
        public Builder setStartTime(long j10) {
            this.zza = j10;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public MediaLiveSeekableRange(@SafeParcelable.Param(id = 2) long j10, @SafeParcelable.Param(id = 3) long j11, @SafeParcelable.Param(id = 4) boolean z10, @SafeParcelable.Param(id = 5) boolean z11) {
        this.zzb = Math.max(j10, 0L);
        this.zzc = Math.max(j11, 0L);
        this.zzd = z10;
        this.zze = z11;
    }

    public static MediaLiveSeekableRange zza(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("start") && jSONObject.has("end")) {
            try {
                long secToMillisec = CastUtils.secToMillisec(jSONObject.getDouble("start"));
                double d10 = jSONObject.getDouble("end");
                return new MediaLiveSeekableRange(secToMillisec, CastUtils.secToMillisec(d10), jSONObject.optBoolean("isMovingWindow"), jSONObject.optBoolean("isLiveDone"));
            } catch (JSONException unused) {
                zza.e("Ignoring Malformed MediaLiveSeekableRange: ".concat(jSONObject.toString()), new Object[0]);
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaLiveSeekableRange)) {
            return false;
        }
        MediaLiveSeekableRange mediaLiveSeekableRange = (MediaLiveSeekableRange) obj;
        return this.zzb == mediaLiveSeekableRange.zzb && this.zzc == mediaLiveSeekableRange.zzc && this.zzd == mediaLiveSeekableRange.zzd && this.zze == mediaLiveSeekableRange.zze;
    }

    public long getEndTime() {
        return this.zzc;
    }

    public long getStartTime() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zzb), Long.valueOf(this.zzc), Boolean.valueOf(this.zzd), Boolean.valueOf(this.zze));
    }

    public boolean isLiveDone() {
        return this.zze;
    }

    public boolean isMovingWindow() {
        return this.zzd;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i10) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 2, getStartTime());
        SafeParcelWriter.writeLong(parcel, 3, getEndTime());
        SafeParcelWriter.writeBoolean(parcel, 4, isMovingWindow());
        SafeParcelWriter.writeBoolean(parcel, 5, isLiveDone());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final JSONObject zzb() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("start", CastUtils.millisecToSec(this.zzb));
            jSONObject.put("end", CastUtils.millisecToSec(this.zzc));
            jSONObject.put("isMovingWindow", this.zzd);
            jSONObject.put("isLiveDone", this.zze);
            return jSONObject;
        } catch (JSONException unused) {
            zza.e("Error transforming MediaLiveSeekableRange into JSONObject", new Object[0]);
            return new JSONObject();
        }
    }
}
