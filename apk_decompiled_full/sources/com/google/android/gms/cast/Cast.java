package com.google.android.gms.cast;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes.dex */
public final class Cast {
    public static final int ACTIVE_INPUT_STATE_NO = 0;
    public static final int ACTIVE_INPUT_STATE_UNKNOWN = -1;
    public static final int ACTIVE_INPUT_STATE_YES = 1;

    @RecentlyNonNull
    public static final Api<CastOptions> API;

    @RecentlyNonNull
    public static final CastApi CastApi;

    @RecentlyNonNull
    public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
    public static final int MAX_MESSAGE_LENGTH = 65536;
    public static final int MAX_NAMESPACE_LENGTH = 128;
    public static final int STANDBY_STATE_NO = 0;
    public static final int STANDBY_STATE_UNKNOWN = -1;
    public static final int STANDBY_STATE_YES = 1;

    @VisibleForTesting
    static final Api.AbstractClientBuilder<com.google.android.gms.cast.internal.zzw, CastOptions> zza;

    public interface ApplicationConnectionResult extends Result {
        @RecentlyNullable
        ApplicationMetadata getApplicationMetadata();

        @RecentlyNullable
        String getApplicationStatus();

        @RecentlyNullable
        String getSessionId();

        boolean getWasLaunched();
    }

    @Deprecated
    public interface CastApi {
        int getActiveInputState(@RecentlyNonNull GoogleApiClient googleApiClient);

        @RecentlyNullable
        ApplicationMetadata getApplicationMetadata(@RecentlyNonNull GoogleApiClient googleApiClient);

        @RecentlyNullable
        String getApplicationStatus(@RecentlyNonNull GoogleApiClient googleApiClient);

        int getStandbyState(@RecentlyNonNull GoogleApiClient googleApiClient);

        double getVolume(@RecentlyNonNull GoogleApiClient googleApiClient);

        boolean isMute(@RecentlyNonNull GoogleApiClient googleApiClient);

        @RecentlyNonNull
        PendingResult<ApplicationConnectionResult> joinApplication(@RecentlyNonNull GoogleApiClient googleApiClient);

        @RecentlyNonNull
        PendingResult<ApplicationConnectionResult> joinApplication(@RecentlyNonNull GoogleApiClient googleApiClient, @RecentlyNonNull String str);

        @RecentlyNonNull
        PendingResult<ApplicationConnectionResult> joinApplication(@RecentlyNonNull GoogleApiClient googleApiClient, @RecentlyNonNull String str, @RecentlyNonNull String str2);

        @RecentlyNonNull
        PendingResult<ApplicationConnectionResult> launchApplication(@RecentlyNonNull GoogleApiClient googleApiClient, @RecentlyNonNull String str);

        @RecentlyNonNull
        PendingResult<ApplicationConnectionResult> launchApplication(@RecentlyNonNull GoogleApiClient googleApiClient, @RecentlyNonNull String str, @RecentlyNonNull LaunchOptions launchOptions);

        @RecentlyNonNull
        @Deprecated
        PendingResult<ApplicationConnectionResult> launchApplication(@RecentlyNonNull GoogleApiClient googleApiClient, @RecentlyNonNull String str, boolean z10);

        @RecentlyNonNull
        PendingResult<Status> leaveApplication(@RecentlyNonNull GoogleApiClient googleApiClient);

        void removeMessageReceivedCallbacks(@RecentlyNonNull GoogleApiClient googleApiClient, @RecentlyNonNull String str);

        void requestStatus(@RecentlyNonNull GoogleApiClient googleApiClient);

        @RecentlyNonNull
        PendingResult<Status> sendMessage(@RecentlyNonNull GoogleApiClient googleApiClient, @RecentlyNonNull String str, @RecentlyNonNull String str2);

        void setMessageReceivedCallbacks(@RecentlyNonNull GoogleApiClient googleApiClient, @RecentlyNonNull String str, @RecentlyNonNull MessageReceivedCallback messageReceivedCallback);

        void setMute(@RecentlyNonNull GoogleApiClient googleApiClient, boolean z10);

        void setVolume(@RecentlyNonNull GoogleApiClient googleApiClient, double d10);

        @RecentlyNonNull
        PendingResult<Status> stopApplication(@RecentlyNonNull GoogleApiClient googleApiClient);

        @RecentlyNonNull
        PendingResult<Status> stopApplication(@RecentlyNonNull GoogleApiClient googleApiClient, @RecentlyNonNull String str);
    }

    public static final class CastOptions implements Api.ApiOptions.HasOptions {
        final CastDevice zza;
        final Listener zzb;
        final Bundle zzc;
        final int zzd;
        final String zze = UUID.randomUUID().toString();

        public static final class Builder {
            CastDevice zza;
            Listener zzb;
            private int zzc;
            private Bundle zzd;

            public Builder(@RecentlyNonNull CastDevice castDevice, @RecentlyNonNull Listener listener) {
                Preconditions.checkNotNull(castDevice, "CastDevice parameter cannot be null");
                Preconditions.checkNotNull(listener, "CastListener parameter cannot be null");
                this.zza = castDevice;
                this.zzb = listener;
                this.zzc = 0;
            }

            @RecentlyNonNull
            public CastOptions build() {
                return new CastOptions(this, null);
            }

            @RecentlyNonNull
            public Builder setVerboseLoggingEnabled(boolean z10) {
                this.zzc = z10 ? 1 : 0;
                return this;
            }

            @RecentlyNonNull
            public final Builder zzc(@RecentlyNonNull Bundle bundle) {
                this.zzd = bundle;
                return this;
            }
        }

        public /* synthetic */ CastOptions(Builder builder, zzn zznVar) {
            this.zza = builder.zza;
            this.zzb = builder.zzb;
            this.zzd = builder.zzc;
            this.zzc = builder.zzd;
        }

        @RecentlyNonNull
        @Deprecated
        public static Builder builder(@RecentlyNonNull CastDevice castDevice, @RecentlyNonNull Listener listener) {
            return new Builder(castDevice, listener);
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x0057, code lost:
        
            if (r1 == r3) goto L26;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CastOptions)) {
                return false;
            }
            CastOptions castOptions = (CastOptions) obj;
            if (Objects.equal(this.zza, castOptions.zza)) {
                Bundle bundle = this.zzc;
                Bundle bundle2 = castOptions.zzc;
                if (bundle != null && bundle2 != null) {
                    if (bundle.size() == bundle2.size()) {
                        Set<String> keySet = bundle.keySet();
                        if (keySet.containsAll(bundle2.keySet())) {
                            for (String str : keySet) {
                                if (!Objects.equal(bundle.get(str), bundle2.get(str))) {
                                    break;
                                }
                            }
                            if (this.zzd != castOptions.zzd || !Objects.equal(this.zze, castOptions.zze)) {
                                break;
                            }
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(this.zza, this.zzc, Integer.valueOf(this.zzd), this.zze);
        }
    }

    public static class Listener {
        public void onActiveInputStateChanged(int i10) {
        }

        public void onApplicationDisconnected(int i10) {
        }

        public void onApplicationMetadataChanged(ApplicationMetadata applicationMetadata) {
        }

        public void onApplicationStatusChanged() {
        }

        public void onStandbyStateChanged(int i10) {
        }

        public void onVolumeChanged() {
        }
    }

    public interface MessageReceivedCallback {
        void onMessageReceived(@RecentlyNonNull CastDevice castDevice, @RecentlyNonNull String str, @RecentlyNonNull String str2);
    }

    static {
        zze zzeVar = new zze();
        zza = zzeVar;
        API = new Api<>("Cast.API", zzeVar, com.google.android.gms.cast.internal.zzai.zza);
        CastApi = new zzm();
    }

    private Cast() {
    }

    @ShowFirstParty
    public static zzr zza(Context context, CastOptions castOptions) {
        return new zzbp(context, castOptions);
    }
}
