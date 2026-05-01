package com.google.android.gms.cast;

import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.RemoteException;
import android.view.Display;
import android.view.Surface;
import com.google.android.gms.cast.CastRemoteDisplayLocalService;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.messaging.Constants;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class zzy extends zzab {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ com.google.android.gms.internal.cast.zzcf zzb;
    final /* synthetic */ CastRemoteDisplayClient zzc;
    final /* synthetic */ zzah zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzy(CastRemoteDisplayClient castRemoteDisplayClient, TaskCompletionSource taskCompletionSource, com.google.android.gms.internal.cast.zzcf zzcfVar, zzah zzahVar, byte[] bArr) {
        super(null);
        this.zzc = castRemoteDisplayClient;
        this.zza = taskCompletionSource;
        this.zzb = zzcfVar;
        this.zzd = zzahVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.cast.zzab, com.google.android.gms.internal.cast.zzcj
    public final void zzb(int i10, int i11, Surface surface) {
        Logger logger;
        VirtualDisplay virtualDisplay;
        VirtualDisplay virtualDisplay2;
        Logger logger2;
        Logger logger3;
        Logger logger4;
        Logger logger5;
        logger = this.zzc.zzc;
        logger.d("onConnected", new Object[0]);
        DisplayManager displayManager = (DisplayManager) this.zzc.getApplicationContext().getSystemService(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
        if (displayManager == null) {
            logger5 = this.zzc.zzc;
            logger5.e("Unable to get the display manager", new Object[0]);
            TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, null, this.zza);
            return;
        }
        CastRemoteDisplayClient.zzd(this.zzc);
        int min = Math.min(i10, i11);
        this.zzc.zzd = displayManager.createVirtualDisplay("private_display", i10, i11, (min * 320) / 1080, surface, 2);
        virtualDisplay = this.zzc.zzd;
        if (virtualDisplay == null) {
            logger4 = this.zzc.zzc;
            logger4.e("Unable to create virtual display", new Object[0]);
            TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, null, this.zza);
            return;
        }
        virtualDisplay2 = this.zzc.zzd;
        Display display = virtualDisplay2.getDisplay();
        if (display == null) {
            logger3 = this.zzc.zzc;
            logger3.e("Virtual display does not have a display", new Object[0]);
            TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, null, this.zza);
        } else {
            try {
                ((com.google.android.gms.internal.cast.zzck) this.zzb.getService()).zzf(this, display.getDisplayId());
            } catch (RemoteException | IllegalStateException unused) {
                logger2 = this.zzc.zzc;
                logger2.e("Unable to provision the route's new virtual Display", new Object[0]);
                TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, null, this.zza);
            }
        }
    }

    @Override // com.google.android.gms.cast.zzab, com.google.android.gms.internal.cast.zzcj
    public final void zzc() {
        Logger logger;
        VirtualDisplay virtualDisplay;
        VirtualDisplay virtualDisplay2;
        Logger logger2;
        Logger logger3;
        logger = this.zzc.zzc;
        logger.d("onConnectedWithDisplay", new Object[0]);
        virtualDisplay = this.zzc.zzd;
        if (virtualDisplay == null) {
            logger3 = this.zzc.zzc;
            logger3.e("There is no virtual display", new Object[0]);
            TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, null, this.zza);
            return;
        }
        virtualDisplay2 = this.zzc.zzd;
        Display display = virtualDisplay2.getDisplay();
        if (display != null) {
            TaskUtil.setResultOrApiException(Status.RESULT_SUCCESS, display, this.zza);
            return;
        }
        logger2 = this.zzc.zzc;
        logger2.e("Virtual display no longer has a display", new Object[0]);
        TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, null, this.zza);
    }

    @Override // com.google.android.gms.cast.zzab, com.google.android.gms.internal.cast.zzcj
    public final void zzd(int i10) {
        Logger logger;
        logger = this.zzc.zzc;
        logger.d("onError: %d", Integer.valueOf(i10));
        CastRemoteDisplayClient.zzd(this.zzc);
        TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, null, this.zza);
    }

    @Override // com.google.android.gms.cast.zzab, com.google.android.gms.internal.cast.zzcj
    public final void zze(boolean z10) {
        Logger logger;
        WeakReference weakReference;
        logger = this.zzc.zzc;
        logger.d("onRemoteDisplayMuteStateChanged: %b", Boolean.valueOf(z10));
        zzah zzahVar = this.zzd;
        if (zzahVar != null) {
            CastRemoteDisplayLocalService castRemoteDisplayLocalService = zzahVar.zza;
            StringBuilder sb = new StringBuilder(38);
            sb.append("onRemoteDisplayMuteStateChanged: ");
            sb.append(z10);
            castRemoteDisplayLocalService.zzv(sb.toString());
            weakReference = zzahVar.zza.zzg;
            CastRemoteDisplayLocalService.Callbacks callbacks = (CastRemoteDisplayLocalService.Callbacks) weakReference.get();
            if (callbacks != null) {
                callbacks.onRemoteDisplayMuteStateChanged(z10);
            }
        }
    }
}
