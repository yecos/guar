package com.google.android.gms.cast.internal;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;

/* loaded from: classes.dex */
public final class zzn extends GoogleApi<Api.ApiOptions.NoOptions> {
    private static final Api.ClientKey<zzo> zza;
    private static final Api.AbstractClientBuilder<zzo, Api.ApiOptions.NoOptions> zzb;
    private static final Api<Api.ApiOptions.NoOptions> zzc;

    static {
        Api.ClientKey<zzo> clientKey = new Api.ClientKey<>();
        zza = clientKey;
        zzi zziVar = new zzi();
        zzb = zziVar;
        zzc = new Api<>("CastApi.API", zziVar, clientKey);
    }

    public zzn(Context context) {
        super(context, zzc, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
