package com.google.android.gms.cast;

import com.google.android.gms.cast.CastRemoteDisplayLocalService;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class zzaj implements OnCompleteListener<Void> {
    final /* synthetic */ CastRemoteDisplayLocalService zza;

    public zzaj(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
        this.zza = castRemoteDisplayLocalService;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<Void> task) {
        WeakReference weakReference;
        if (task.isSuccessful()) {
            this.zza.zzv("remote display stopped");
        } else {
            this.zza.zzv("Unable to stop the remote display, result unsuccessful");
            weakReference = this.zza.zzg;
            CastRemoteDisplayLocalService.Callbacks callbacks = (CastRemoteDisplayLocalService.Callbacks) weakReference.get();
            if (callbacks != null) {
                callbacks.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_STOPPING_SERVICE_FAILED));
            }
        }
        this.zza.zzn = null;
    }
}
