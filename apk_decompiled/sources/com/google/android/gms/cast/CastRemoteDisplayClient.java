package com.google.android.gms.cast;

import android.app.PendingIntent;
import android.content.Context;
import android.hardware.display.VirtualDisplay;
import android.os.Bundle;
import android.view.Display;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.cast.CastRemoteDisplay;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

@Deprecated
/* loaded from: classes.dex */
public class CastRemoteDisplayClient extends GoogleApi<Api.ApiOptions.NoOptions> {
    private static final Api.AbstractClientBuilder<com.google.android.gms.internal.cast.zzcf, Api.ApiOptions.NoOptions> zza;
    private static final Api<Api.ApiOptions.NoOptions> zzb;
    private final Logger zzc;
    private VirtualDisplay zzd;

    static {
        zzx zzxVar = new zzx();
        zza = zzxVar;
        zzb = new Api<>("CastRemoteDisplay.API", zzxVar, com.google.android.gms.cast.internal.zzai.zzd);
    }

    public CastRemoteDisplayClient(Context context) {
        super(context, zzb, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.zzc = new Logger("CastRemoteDisplay");
    }

    public static /* bridge */ /* synthetic */ void zzd(CastRemoteDisplayClient castRemoteDisplayClient) {
        VirtualDisplay virtualDisplay = castRemoteDisplayClient.zzd;
        if (virtualDisplay != null) {
            if (virtualDisplay.getDisplay() != null) {
                Logger logger = castRemoteDisplayClient.zzc;
                int displayId = castRemoteDisplayClient.zzd.getDisplay().getDisplayId();
                StringBuilder sb = new StringBuilder(38);
                sb.append("releasing virtual display: ");
                sb.append(displayId);
                logger.d(sb.toString(), new Object[0]);
            }
            VirtualDisplay virtualDisplay2 = castRemoteDisplayClient.zzd;
            if (virtualDisplay2 != null) {
                virtualDisplay2.release();
                castRemoteDisplayClient.zzd = null;
            }
        }
    }

    @RecentlyNonNull
    public Task<Display> startRemoteDisplay(@RecentlyNonNull CastDevice castDevice, @RecentlyNonNull String str, @CastRemoteDisplay.Configuration int i10, PendingIntent pendingIntent) {
        return zze(castDevice, str, i10, pendingIntent, null);
    }

    @RecentlyNonNull
    public Task<Void> stopRemoteDisplay() {
        return doWrite(TaskApiCall.builder().setMethodKey(8402).run(new RemoteCall() { // from class: com.google.android.gms.cast.zzv
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((com.google.android.gms.internal.cast.zzck) ((com.google.android.gms.internal.cast.zzcf) obj).getService()).zzi(new zzz(CastRemoteDisplayClient.this, (TaskCompletionSource) obj2));
            }
        }).build());
    }

    public final Task<Display> zze(final CastDevice castDevice, final String str, @CastRemoteDisplay.Configuration final int i10, final PendingIntent pendingIntent, final zzah zzahVar) {
        final byte[] bArr = null;
        return doWrite(TaskApiCall.builder().setMethodKey(8401).run(new RemoteCall(i10, zzahVar, pendingIntent, castDevice, str, bArr) { // from class: com.google.android.gms.cast.zzw
            public final /* synthetic */ int zzb;
            public final /* synthetic */ PendingIntent zzc;
            public final /* synthetic */ CastDevice zzd;
            public final /* synthetic */ String zze;
            public final /* synthetic */ zzah zzf;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                CastRemoteDisplayClient castRemoteDisplayClient = CastRemoteDisplayClient.this;
                int i11 = this.zzb;
                zzah zzahVar2 = this.zzf;
                PendingIntent pendingIntent2 = this.zzc;
                CastDevice castDevice2 = this.zzd;
                String str2 = this.zze;
                com.google.android.gms.internal.cast.zzcf zzcfVar = (com.google.android.gms.internal.cast.zzcf) obj;
                Bundle bundle = new Bundle();
                bundle.putInt("configuration", i11);
                ((com.google.android.gms.internal.cast.zzck) zzcfVar.getService()).zzh(new zzy(castRemoteDisplayClient, (TaskCompletionSource) obj2, zzcfVar, zzahVar2, null), pendingIntent2, castDevice2.getDeviceId(), str2, bundle);
            }
        }).build());
    }
}
