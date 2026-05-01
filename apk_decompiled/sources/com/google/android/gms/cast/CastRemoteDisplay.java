package com.google.android.gms.cast;

import android.content.Context;
import android.view.Display;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;

@Deprecated
/* loaded from: classes.dex */
public final class CastRemoteDisplay {

    @RecentlyNonNull
    @Deprecated
    public static final Api<CastRemoteDisplayOptions> API;
    public static final int CONFIGURATION_INTERACTIVE_NONREALTIME = 2;
    public static final int CONFIGURATION_INTERACTIVE_REALTIME = 1;
    public static final int CONFIGURATION_NONINTERACTIVE = 3;

    @RecentlyNonNull
    @Deprecated
    public static final CastRemoteDisplayApi CastRemoteDisplayApi;

    @RecentlyNonNull
    public static final String EXTRA_INT_SESSION_ENDED_STATUS_CODE = "extra_int_session_ended_status_code";
    private static final Api.AbstractClientBuilder<com.google.android.gms.internal.cast.zzch, CastRemoteDisplayOptions> zza;

    @Deprecated
    public static final class CastRemoteDisplayOptions implements Api.ApiOptions.HasOptions {
        final CastDevice zza;
        final CastRemoteDisplaySessionCallbacks zzb;
        final int zzc;

        @Deprecated
        public static final class Builder {
            CastDevice zza;
            CastRemoteDisplaySessionCallbacks zzb;
            int zzc;

            public Builder(@RecentlyNonNull CastDevice castDevice, @RecentlyNonNull CastRemoteDisplaySessionCallbacks castRemoteDisplaySessionCallbacks) {
                Preconditions.checkNotNull(castDevice, "CastDevice parameter cannot be null");
                this.zza = castDevice;
                this.zzb = castRemoteDisplaySessionCallbacks;
                this.zzc = 2;
            }

            @RecentlyNonNull
            public CastRemoteDisplayOptions build() {
                return new CastRemoteDisplayOptions(this, null);
            }

            @RecentlyNonNull
            public Builder setConfigPreset(@Configuration int i10) {
                this.zzc = i10;
                return this;
            }
        }

        public /* synthetic */ CastRemoteDisplayOptions(Builder builder, zzu zzuVar) {
            this.zza = builder.zza;
            this.zzb = builder.zzb;
            this.zzc = builder.zzc;
        }
    }

    @Deprecated
    public interface CastRemoteDisplaySessionCallbacks {
        void onRemoteDisplayEnded(@RecentlyNonNull Status status);
    }

    @Deprecated
    public interface CastRemoteDisplaySessionResult extends Result {
        @RecentlyNullable
        Display getPresentationDisplay();
    }

    public @interface Configuration {
    }

    static {
        zzt zztVar = new zzt();
        zza = zztVar;
        Api<CastRemoteDisplayOptions> api = new Api<>("CastRemoteDisplay.API", zztVar, com.google.android.gms.cast.internal.zzai.zzc);
        API = api;
        CastRemoteDisplayApi = new com.google.android.gms.internal.cast.zzce(api);
    }

    private CastRemoteDisplay() {
    }

    @RecentlyNonNull
    public static CastRemoteDisplayClient getClient(@RecentlyNonNull Context context) {
        return new CastRemoteDisplayClient(context);
    }

    public static final boolean isRemoteDisplaySdkSupported(@RecentlyNonNull Context context) {
        com.google.android.gms.cast.internal.zzaa.zza(context);
        return com.google.android.gms.cast.internal.zzaa.zza.get().booleanValue();
    }
}
