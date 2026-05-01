package com.google.android.gms.cast;

import com.google.android.gms.cast.RemoteMediaPlayer;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;

@VisibleForTesting
/* loaded from: classes.dex */
abstract class zzdl extends com.google.android.gms.cast.internal.zzc<RemoteMediaPlayer.MediaChannelResult> {
    private com.google.android.gms.cast.internal.zzar zza;
    protected final WeakReference<GoogleApiClient> zzg;
    final /* synthetic */ RemoteMediaPlayer zzh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdl(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.zzh = remoteMediaPlayer;
        this.zzg = new WeakReference<>(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        return new zzdk(this, status);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(com.google.android.gms.cast.internal.zzw zzwVar) {
        Object obj;
        zzdi zzdiVar;
        zzdi zzdiVar2;
        com.google.android.gms.cast.internal.zzw zzwVar2 = zzwVar;
        obj = this.zzh.zza;
        synchronized (obj) {
            GoogleApiClient googleApiClient = this.zzg.get();
            if (googleApiClient == null) {
                setResult((zzdl) new zzdk(this, new Status(2100)));
                return;
            }
            zzdiVar = this.zzh.zzc;
            zzdiVar.zzc(googleApiClient);
            try {
                zza(zzwVar2);
            } catch (IllegalArgumentException e10) {
                throw e10;
            } catch (Throwable unused) {
                setResult((zzdl) new zzdk(this, new Status(2100)));
            }
            zzdiVar2 = this.zzh.zzc;
            zzdiVar2.zzc(null);
        }
    }

    public abstract void zza(com.google.android.gms.cast.internal.zzw zzwVar);

    public final com.google.android.gms.cast.internal.zzar zzb() {
        if (this.zza == null) {
            this.zza = new zzdj(this);
        }
        return this.zza;
    }
}
