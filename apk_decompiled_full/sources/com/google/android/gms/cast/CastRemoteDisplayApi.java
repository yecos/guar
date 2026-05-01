package com.google.android.gms.cast;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.cast.CastRemoteDisplay;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

@Deprecated
/* loaded from: classes.dex */
public interface CastRemoteDisplayApi {
    @RecentlyNonNull
    PendingResult<CastRemoteDisplay.CastRemoteDisplaySessionResult> startRemoteDisplay(@RecentlyNonNull GoogleApiClient googleApiClient, @RecentlyNonNull String str);

    @RecentlyNonNull
    PendingResult<CastRemoteDisplay.CastRemoteDisplaySessionResult> stopRemoteDisplay(@RecentlyNonNull GoogleApiClient googleApiClient);
}
