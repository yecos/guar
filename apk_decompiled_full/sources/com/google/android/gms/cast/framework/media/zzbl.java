package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Iterator;
import java.util.List;

@VisibleForTesting
/* loaded from: classes.dex */
abstract class zzbl extends BasePendingResult<RemoteMediaClient.MediaChannelResult> {
    private com.google.android.gms.cast.internal.zzar zza;
    private final boolean zzb;
    final /* synthetic */ RemoteMediaClient zzg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbl(RemoteMediaClient remoteMediaClient, boolean z10) {
        super((GoogleApiClient) null);
        this.zzg = remoteMediaClient;
        this.zzb = z10;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ RemoteMediaClient.MediaChannelResult createFailedResult(Status status) {
        return new zzbk(this, status);
    }

    public abstract void zza();

    public final com.google.android.gms.cast.internal.zzar zzb() {
        if (this.zza == null) {
            this.zza = new zzbj(this);
        }
        return this.zza;
    }

    public final void zzc() {
        Object obj;
        List list;
        if (!this.zzb) {
            list = this.zzg.zzh;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((RemoteMediaClient.Listener) it.next()).onSendingRemoteMediaRequest();
            }
            Iterator<RemoteMediaClient.Callback> it2 = this.zzg.zza.iterator();
            while (it2.hasNext()) {
                it2.next().onSendingRemoteMediaRequest();
            }
        }
        try {
            obj = this.zzg.zzb;
            synchronized (obj) {
                zza();
            }
        } catch (com.google.android.gms.cast.internal.zzan unused) {
            setResult(new zzbk(this, new Status(2100)));
        }
    }
}
