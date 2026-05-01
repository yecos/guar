package com.google.android.gms.cast;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MediaLoadOptions {
    public static final double PLAYBACK_RATE_MAX = 2.0d;
    public static final double PLAYBACK_RATE_MIN = 0.5d;
    private boolean zza;
    private long zzb;
    private double zzc;
    private final long[] zzd;
    private final JSONObject zze;
    private final String zzf;
    private final String zzg;

    public static class Builder {
        private boolean zza = true;
        private long zzb = -1;
        private double zzc = 1.0d;
        private long[] zzd;
        private JSONObject zze;
        private String zzf;
        private String zzg;

        @RecentlyNonNull
        public MediaLoadOptions build() {
            return new MediaLoadOptions(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, null);
        }

        @RecentlyNonNull
        public Builder setActiveTrackIds(@RecentlyNonNull long[] jArr) {
            this.zzd = jArr;
            return this;
        }

        @RecentlyNonNull
        public Builder setAutoplay(boolean z10) {
            this.zza = z10;
            return this;
        }

        @RecentlyNonNull
        public Builder setCredentials(String str) {
            this.zzf = str;
            return this;
        }

        @RecentlyNonNull
        public Builder setCredentialsType(String str) {
            this.zzg = str;
            return this;
        }

        @RecentlyNonNull
        public Builder setCustomData(JSONObject jSONObject) {
            this.zze = jSONObject;
            return this;
        }

        @RecentlyNonNull
        public Builder setPlayPosition(long j10) {
            this.zzb = j10;
            return this;
        }

        @RecentlyNonNull
        public Builder setPlaybackRate(double d10) {
            if (Double.compare(d10, 2.0d) > 0 || Double.compare(d10, 0.5d) < 0) {
                throw new IllegalArgumentException("playbackRate must be between PLAYBACK_RATE_MIN and PLAYBACK_RATE_MAX");
            }
            this.zzc = d10;
            return this;
        }
    }

    public /* synthetic */ MediaLoadOptions(boolean z10, long j10, double d10, long[] jArr, JSONObject jSONObject, String str, String str2, zzbw zzbwVar) {
        this.zza = z10;
        this.zzb = j10;
        this.zzc = d10;
        this.zzd = jArr;
        this.zze = jSONObject;
        this.zzf = str;
        this.zzg = str2;
    }

    @RecentlyNullable
    public long[] getActiveTrackIds() {
        return this.zzd;
    }

    public boolean getAutoplay() {
        return this.zza;
    }

    @RecentlyNullable
    public String getCredentials() {
        return this.zzf;
    }

    @RecentlyNullable
    public String getCredentialsType() {
        return this.zzg;
    }

    @RecentlyNullable
    public JSONObject getCustomData() {
        return this.zze;
    }

    public long getPlayPosition() {
        return this.zzb;
    }

    public double getPlaybackRate() {
        return this.zzc;
    }
}
