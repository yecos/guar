package com.google.android.gms.cast;

import android.content.Context;
import android.content.ServiceConnection;
import android.view.Display;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
final class zzai implements OnCompleteListener<Display> {
    final /* synthetic */ CastRemoteDisplayLocalService zza;

    public zzai(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
        this.zza = castRemoteDisplayLocalService;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<Display> task) {
        Logger logger;
        Object obj;
        CastRemoteDisplayLocalService castRemoteDisplayLocalService;
        AtomicBoolean atomicBoolean;
        Context context;
        ServiceConnection serviceConnection;
        Logger logger2;
        Logger logger3;
        Logger logger4;
        if (!task.isSuccessful()) {
            logger4 = CastRemoteDisplayLocalService.zza;
            logger4.e("Connection was not successful", new Object[0]);
            CastRemoteDisplayLocalService.zzo(this.zza);
            return;
        }
        logger = CastRemoteDisplayLocalService.zza;
        logger.d("startRemoteDisplay successful", new Object[0]);
        obj = CastRemoteDisplayLocalService.zzc;
        synchronized (obj) {
            castRemoteDisplayLocalService = CastRemoteDisplayLocalService.zze;
            if (castRemoteDisplayLocalService == null) {
                logger3 = CastRemoteDisplayLocalService.zza;
                logger3.d("Remote Display started but session already cancelled", new Object[0]);
                CastRemoteDisplayLocalService.zzo(this.zza);
                return;
            }
            CastRemoteDisplayLocalService.zzl(this.zza, task.getResult());
            atomicBoolean = CastRemoteDisplayLocalService.zzd;
            atomicBoolean.set(false);
            context = this.zza.zzo;
            serviceConnection = this.zza.zzp;
            if (context != null && serviceConnection != null) {
                try {
                    ConnectionTracker.getInstance().unbindService(context, serviceConnection);
                } catch (IllegalArgumentException unused) {
                    logger2 = CastRemoteDisplayLocalService.zza;
                    logger2.d("No need to unbind service, already unbound", new Object[0]);
                }
            }
            this.zza.zzp = null;
            this.zza.zzo = null;
        }
    }
}
