package com.google.android.gms.internal.cast;

import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.RemoteException;
import android.view.Display;
import android.view.Surface;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.Status;
import com.google.firebase.messaging.Constants;

/* loaded from: classes.dex */
public final class zzca extends zzbz {
    final /* synthetic */ zzcc zza;
    private final zzch zzb;

    public zzca(zzcc zzccVar, zzch zzchVar) {
        this.zza = zzccVar;
        this.zzb = zzchVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.cast.zzbz, com.google.android.gms.internal.cast.zzcj
    public final void zzb(int i10, int i11, Surface surface) {
        Logger logger;
        VirtualDisplay virtualDisplay;
        VirtualDisplay virtualDisplay2;
        Logger logger2;
        VirtualDisplay virtualDisplay3;
        Logger logger3;
        Logger logger4;
        Logger logger5;
        logger = zzce.zza;
        logger.d("onConnected", new Object[0]);
        DisplayManager displayManager = (DisplayManager) this.zzb.getContext().getSystemService(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
        if (displayManager == null) {
            logger5 = zzce.zza;
            logger5.e("Unable to get the display manager", new Object[0]);
            this.zza.setResult((zzcc) new zzcd(Status.RESULT_INTERNAL_ERROR));
            return;
        }
        zzce.zzf(this.zza.zzc);
        this.zza.zzc.zzc = displayManager.createVirtualDisplay("private_display", i10, i11, ((i10 < i11 ? i10 : i11) * 320) / 1080, surface, 2);
        virtualDisplay = this.zza.zzc.zzc;
        if (virtualDisplay == null) {
            logger4 = zzce.zza;
            logger4.e("Unable to create virtual display", new Object[0]);
            this.zza.setResult((zzcc) new zzcd(Status.RESULT_INTERNAL_ERROR));
            return;
        }
        virtualDisplay2 = this.zza.zzc.zzc;
        if (virtualDisplay2.getDisplay() == null) {
            logger3 = zzce.zza;
            logger3.e("Virtual display does not have a display", new Object[0]);
            this.zza.setResult((zzcc) new zzcd(Status.RESULT_INTERNAL_ERROR));
            return;
        }
        try {
            zzch zzchVar = this.zzb;
            virtualDisplay3 = this.zza.zzc.zzc;
            ((zzck) zzchVar.getService()).zzf(this, virtualDisplay3.getDisplay().getDisplayId());
        } catch (RemoteException | IllegalStateException unused) {
            logger2 = zzce.zza;
            logger2.e("Unable to provision the route's new virtual Display", new Object[0]);
            this.zza.setResult((zzcc) new zzcd(Status.RESULT_INTERNAL_ERROR));
        }
    }

    @Override // com.google.android.gms.internal.cast.zzbz, com.google.android.gms.internal.cast.zzcj
    public final void zzc() {
        Logger logger;
        VirtualDisplay virtualDisplay;
        VirtualDisplay virtualDisplay2;
        Logger logger2;
        Logger logger3;
        logger = zzce.zza;
        logger.d("onConnectedWithDisplay", new Object[0]);
        virtualDisplay = this.zza.zzc.zzc;
        if (virtualDisplay == null) {
            logger3 = zzce.zza;
            logger3.e("There is no virtual display", new Object[0]);
            this.zza.setResult((zzcc) new zzcd(Status.RESULT_INTERNAL_ERROR));
            return;
        }
        virtualDisplay2 = this.zza.zzc.zzc;
        Display display = virtualDisplay2.getDisplay();
        if (display != null) {
            this.zza.setResult((zzcc) new zzcd(display));
            return;
        }
        logger2 = zzce.zza;
        logger2.e("Virtual display no longer has a display", new Object[0]);
        this.zza.setResult((zzcc) new zzcd(Status.RESULT_INTERNAL_ERROR));
    }

    @Override // com.google.android.gms.internal.cast.zzbz, com.google.android.gms.internal.cast.zzcj
    public final void zzd(int i10) {
        Logger logger;
        logger = zzce.zza;
        logger.d("onError: %d", Integer.valueOf(i10));
        zzce.zzf(this.zza.zzc);
        this.zza.setResult((zzcc) new zzcd(Status.RESULT_INTERNAL_ERROR));
    }
}
