package com.google.android.gms.cast;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.cast.CastRemoteDisplay;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;

/* loaded from: classes.dex */
final class zzt extends Api.AbstractClientBuilder<com.google.android.gms.internal.cast.zzch, CastRemoteDisplay.CastRemoteDisplayOptions> {
    @Override // com.google.android.gms.common.api.Api.AbstractClientBuilder
    public final /* bridge */ /* synthetic */ com.google.android.gms.internal.cast.zzch buildClient(Context context, Looper looper, ClientSettings clientSettings, CastRemoteDisplay.CastRemoteDisplayOptions castRemoteDisplayOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        CastRemoteDisplay.CastRemoteDisplayOptions castRemoteDisplayOptions2 = castRemoteDisplayOptions;
        Bundle bundle = new Bundle();
        bundle.putInt("configuration", castRemoteDisplayOptions2.zzc);
        return new com.google.android.gms.internal.cast.zzch(context, looper, clientSettings, castRemoteDisplayOptions2.zza, bundle, castRemoteDisplayOptions2.zzb, connectionCallbacks, onConnectionFailedListener);
    }
}
