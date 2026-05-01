package com.google.android.gms.cast.framework;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.internal.cast.zzju;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

/* loaded from: classes.dex */
public class PrecacheManager {
    private final Logger zza = new Logger("PrecacheManager");
    private final CastOptions zzb;
    private final SessionManager zzc;
    private final com.google.android.gms.cast.internal.zzn zzd;

    public PrecacheManager(CastOptions castOptions, SessionManager sessionManager, com.google.android.gms.cast.internal.zzn zznVar) {
        this.zzb = castOptions;
        this.zzc = sessionManager;
        this.zzd = zznVar;
    }

    public void precache(@RecentlyNonNull final String str) {
        com.google.android.gms.internal.cast.zzl.zzd(zzju.PRECACHE);
        Session currentSession = this.zzc.getCurrentSession();
        if (str == null) {
            throw new IllegalArgumentException("No precache data found to be precached");
        }
        final List list = null;
        if (currentSession == null) {
            final com.google.android.gms.cast.internal.zzn zznVar = this.zzd;
            final String[] strArr = {this.zzb.getReceiverApplicationId()};
            zznVar.doWrite(TaskApiCall.builder().setMethodKey(8423).run(new RemoteCall(strArr, str, list) { // from class: com.google.android.gms.cast.internal.zzh
                public final /* synthetic */ String[] zzb;
                public final /* synthetic */ String zzc;

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.gms.common.api.internal.RemoteCall
                public final void accept(Object obj, Object obj2) {
                    zzn zznVar2 = zzn.this;
                    String[] strArr2 = this.zzb;
                    String str2 = this.zzc;
                    ((zzah) ((zzo) obj).getService()).zze(new zzj(zznVar2, (TaskCompletionSource) obj2), strArr2, str2, null);
                }
            }).build());
        } else {
            if (!(currentSession instanceof CastSession)) {
                this.zza.e("Current session is not a CastSession. Precache is not supported.", new Object[0]);
                return;
            }
            RemoteMediaClient remoteMediaClient = ((CastSession) currentSession).getRemoteMediaClient();
            if (remoteMediaClient != null) {
                remoteMediaClient.zze(str, null);
            } else {
                this.zza.e("Failed to get RemoteMediaClient from current cast session.", new Object[0]);
            }
        }
    }
}
