package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.io.IOException;

/* loaded from: classes.dex */
public final class zzm implements Cast.CastApi {
    @Override // com.google.android.gms.cast.Cast.CastApi
    public final int getActiveInputState(GoogleApiClient googleApiClient) {
        return ((com.google.android.gms.cast.internal.zzw) googleApiClient.getClient(com.google.android.gms.cast.internal.zzai.zza)).zzr();
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient) {
        return ((com.google.android.gms.cast.internal.zzw) googleApiClient.getClient(com.google.android.gms.cast.internal.zzai.zza)).zzt();
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final String getApplicationStatus(GoogleApiClient googleApiClient) {
        return ((com.google.android.gms.cast.internal.zzw) googleApiClient.getClient(com.google.android.gms.cast.internal.zzai.zza)).zzz();
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final int getStandbyState(GoogleApiClient googleApiClient) {
        return ((com.google.android.gms.cast.internal.zzw) googleApiClient.getClient(com.google.android.gms.cast.internal.zzai.zza)).zzs();
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final double getVolume(GoogleApiClient googleApiClient) {
        return ((com.google.android.gms.cast.internal.zzw) googleApiClient.getClient(com.google.android.gms.cast.internal.zzai.zza)).zzq();
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final boolean isMute(GoogleApiClient googleApiClient) {
        return ((com.google.android.gms.cast.internal.zzw) googleApiClient.getClient(com.google.android.gms.cast.internal.zzai.zza)).zzX();
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient) {
        return zza(googleApiClient, null, null, null);
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.execute(new zzg(this, googleApiClient, str));
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final PendingResult<Status> leaveApplication(GoogleApiClient googleApiClient) {
        return googleApiClient.execute(new zzj(this, googleApiClient));
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str) {
        try {
            ((com.google.android.gms.cast.internal.zzw) googleApiClient.getClient(com.google.android.gms.cast.internal.zzai.zza)).zzO(str);
        } catch (RemoteException unused) {
            throw new IOException("service error");
        }
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final void requestStatus(GoogleApiClient googleApiClient) {
        try {
            ((com.google.android.gms.cast.internal.zzw) googleApiClient.getClient(com.google.android.gms.cast.internal.zzai.zza)).zzP();
        } catch (RemoteException unused) {
            throw new IOException("service error");
        }
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, String str, String str2) {
        return googleApiClient.execute(new zzf(this, googleApiClient, str, str2));
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, Cast.MessageReceivedCallback messageReceivedCallback) {
        try {
            ((com.google.android.gms.cast.internal.zzw) googleApiClient.getClient(com.google.android.gms.cast.internal.zzai.zza)).zzS(str, messageReceivedCallback);
        } catch (RemoteException unused) {
            throw new IOException("service error");
        }
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final void setMute(GoogleApiClient googleApiClient, boolean z10) {
        try {
            ((com.google.android.gms.cast.internal.zzw) googleApiClient.getClient(com.google.android.gms.cast.internal.zzai.zza)).zzT(z10);
        } catch (RemoteException unused) {
            throw new IOException("service error");
        }
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final void setVolume(GoogleApiClient googleApiClient, double d10) {
        try {
            ((com.google.android.gms.cast.internal.zzw) googleApiClient.getClient(com.google.android.gms.cast.internal.zzai.zza)).zzU(d10);
        } catch (RemoteException unused) {
            throw new IOException("service error");
        }
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final PendingResult<Status> stopApplication(GoogleApiClient googleApiClient) {
        return googleApiClient.execute(new zzk(this, googleApiClient));
    }

    @ShowFirstParty
    public final PendingResult<Cast.ApplicationConnectionResult> zza(GoogleApiClient googleApiClient, String str, String str2, zzbq zzbqVar) {
        return googleApiClient.execute(new zzi(this, googleApiClient, str, str2, null));
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str) {
        return zza(googleApiClient, str, null, null);
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, LaunchOptions launchOptions) {
        return googleApiClient.execute(new zzh(this, googleApiClient, str, launchOptions));
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final PendingResult<Status> stopApplication(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.execute(new zzl(this, googleApiClient, str));
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    public final PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str, String str2) {
        return zza(googleApiClient, str, str2, null);
    }

    @Override // com.google.android.gms.cast.Cast.CastApi
    @Deprecated
    public final PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, boolean z10) {
        LaunchOptions.Builder builder = new LaunchOptions.Builder();
        builder.setRelaunchIfRunning(z10);
        return googleApiClient.execute(new zzh(this, googleApiClient, str, builder.build()));
    }
}
