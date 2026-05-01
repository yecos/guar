package com.google.android.gms.cast.internal;

import android.os.Handler;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.cast.zzco;
import java.util.concurrent.atomic.AtomicReference;

@VisibleForTesting
/* loaded from: classes.dex */
final class zzv extends zzaf {
    private final AtomicReference<zzw> zza;
    private final Handler zzb;

    public zzv(zzw zzwVar) {
        this.zza = new AtomicReference<>(zzwVar);
        this.zzb = new zzco(zzwVar.getLooper());
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzb(ApplicationMetadata applicationMetadata, String str, String str2, boolean z10) {
        Object obj;
        BaseImplementation.ResultHolder resultHolder;
        BaseImplementation.ResultHolder resultHolder2;
        zzw zzwVar = this.zza.get();
        if (zzwVar == null) {
            return;
        }
        zzwVar.zzh = applicationMetadata;
        zzwVar.zzy = applicationMetadata.getApplicationId();
        zzwVar.zzz = str2;
        zzwVar.zzo = str;
        obj = zzw.zzf;
        synchronized (obj) {
            resultHolder = zzwVar.zzC;
            if (resultHolder != null) {
                resultHolder2 = zzwVar.zzC;
                resultHolder2.setResult(new zzq(new Status(0), applicationMetadata, str, str2, z10));
                zzwVar.zzC = null;
            }
        }
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzc(int i10) {
        zzw zzwVar = this.zza.get();
        if (zzwVar == null) {
            return;
        }
        zzwVar.zzR(i10);
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzd(int i10) {
        Cast.Listener listener;
        zzw zzwVar = this.zza.get();
        if (zzwVar == null) {
            return;
        }
        zzwVar.zzy = null;
        zzwVar.zzz = null;
        zzwVar.zzab(i10);
        listener = zzwVar.zzj;
        if (listener != null) {
            this.zzb.post(new zzr(this, zzwVar, i10));
        }
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zze(int i10) {
        zzw zzwVar = this.zza.get();
        if (zzwVar == null) {
            return;
        }
        zzwVar.zzab(i10);
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzf(zza zzaVar) {
        Logger logger;
        zzw zzwVar = this.zza.get();
        if (zzwVar == null) {
            return;
        }
        logger = zzw.zze;
        logger.d("onApplicationStatusChanged", new Object[0]);
        this.zzb.post(new zzt(this, zzwVar, zzaVar));
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzg(int i10) {
        zzw zzwVar = this.zza.get();
        if (zzwVar == null) {
            return;
        }
        zzwVar.zzab(i10);
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzh(String str, byte[] bArr) {
        Logger logger;
        if (this.zza.get() == null) {
            return;
        }
        logger = zzw.zze;
        logger.d("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzi(int i10) {
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzj(zzy zzyVar) {
        Logger logger;
        zzw zzwVar = this.zza.get();
        if (zzwVar == null) {
            return;
        }
        logger = zzw.zze;
        logger.d("onDeviceStatusChanged", new Object[0]);
        this.zzb.post(new zzs(this, zzwVar, zzyVar));
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzk(int i10) {
        Logger logger;
        zzw zzq = zzq();
        if (zzq == null) {
            return;
        }
        logger = zzw.zze;
        logger.d("ICastDeviceControllerListener.onDisconnected: %d", Integer.valueOf(i10));
        if (i10 != 0) {
            zzq.triggerConnectionSuspended(2);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzl(String str, long j10) {
        zzw zzwVar = this.zza.get();
        if (zzwVar == null) {
            return;
        }
        zzwVar.zzaa(j10, 0);
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzm(String str, long j10, int i10) {
        zzw zzwVar = this.zza.get();
        if (zzwVar == null) {
            return;
        }
        zzwVar.zzaa(j10, i10);
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzn(String str, double d10, boolean z10) {
        Logger logger;
        logger = zzw.zze;
        logger.d("Deprecated callback: \"onStatusreceived\"", new Object[0]);
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzo(int i10) {
    }

    @Override // com.google.android.gms.cast.internal.zzag
    public final void zzp(String str, String str2) {
        Logger logger;
        zzw zzwVar = this.zza.get();
        if (zzwVar == null) {
            return;
        }
        logger = zzw.zze;
        logger.d("Receive (type=text, ns=%s) %s", str, str2);
        this.zzb.post(new zzu(this, zzwVar, str, str2));
    }

    public final zzw zzq() {
        zzw andSet = this.zza.getAndSet(null);
        if (andSet == null) {
            return null;
        }
        andSet.zzY();
        return andSet;
    }

    public final boolean zzr() {
        return this.zza.get() == null;
    }
}
