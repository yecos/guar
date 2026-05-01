package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnFailureListener;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
final class zzbg implements com.google.android.gms.cast.internal.zzaq {
    final /* synthetic */ RemoteMediaClient zza;
    private com.google.android.gms.cast.zzr zzb;
    private final AtomicLong zzc = new AtomicLong((CastUtils.zzb() & 65535) * NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS);

    public zzbg(RemoteMediaClient remoteMediaClient) {
        this.zza = remoteMediaClient;
    }

    @Override // com.google.android.gms.cast.internal.zzaq
    public final long zza() {
        return this.zzc.getAndIncrement();
    }

    @Override // com.google.android.gms.cast.internal.zzaq
    public final void zzb(String str, String str2, final long j10, String str3) {
        com.google.android.gms.cast.zzr zzrVar = this.zzb;
        if (zzrVar == null) {
            throw new IllegalStateException("Device is not connected");
        }
        zzrVar.zzh(str, str2).addOnFailureListener(new OnFailureListener() { // from class: com.google.android.gms.cast.framework.media.zzbf
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                com.google.android.gms.cast.internal.zzap zzapVar;
                zzbg zzbgVar = zzbg.this;
                long j11 = j10;
                int statusCode = exc instanceof ApiException ? ((ApiException) exc).getStatusCode() : 13;
                zzapVar = zzbgVar.zza.zzd;
                zzapVar.zzR(j11, statusCode);
            }
        });
    }

    public final void zzc(com.google.android.gms.cast.zzr zzrVar) {
        this.zzb = zzrVar;
    }
}
