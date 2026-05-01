package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.PersistableBundle;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public final class zzjt {
    private final Context zza;

    public zzjt(Context context) {
        Preconditions.checkNotNull(context);
        this.zza = context;
    }

    private final zzeh zzk() {
        return zzfr.zzp(this.zza, null, null).zzay();
    }

    public final int zza(final Intent intent, int i10, final int i11) {
        zzfr zzp = zzfr.zzp(this.zza, null, null);
        final zzeh zzay = zzp.zzay();
        if (intent == null) {
            zzay.zzk().zza("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zzp.zzaw();
        zzay.zzj().zzc("Local AppMeasurementService called. startId, action", Integer.valueOf(i11), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            zzh(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjq
                @Override // java.lang.Runnable
                public final void run() {
                    zzjt.this.zzc(i11, zzay, intent);
                }
            });
        }
        return 2;
    }

    public final IBinder zzb(Intent intent) {
        if (intent == null) {
            zzk().zzd().zza("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzgj(zzkt.zzt(this.zza), null);
        }
        zzk().zzk().zzb("onBind received unknown action", action);
        return null;
    }

    public final /* synthetic */ void zzc(int i10, zzeh zzehVar, Intent intent) {
        if (((zzjs) this.zza).zzc(i10)) {
            zzehVar.zzj().zzb("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i10));
            zzk().zzj().zza("Completed wakeful intent.");
            ((zzjs) this.zza).zza(intent);
        }
    }

    public final /* synthetic */ void zzd(zzeh zzehVar, JobParameters jobParameters) {
        zzehVar.zzj().zza("AppMeasurementJobService processed last upload request.");
        ((zzjs) this.zza).zzb(jobParameters, false);
    }

    public final void zze() {
        zzfr zzp = zzfr.zzp(this.zza, null, null);
        zzeh zzay = zzp.zzay();
        zzp.zzaw();
        zzay.zzj().zza("Local AppMeasurementService is starting up");
    }

    public final void zzf() {
        zzfr zzp = zzfr.zzp(this.zza, null, null);
        zzeh zzay = zzp.zzay();
        zzp.zzaw();
        zzay.zzj().zza("Local AppMeasurementService is shutting down");
    }

    public final void zzg(Intent intent) {
        if (intent == null) {
            zzk().zzd().zza("onRebind called with null intent");
        } else {
            zzk().zzj().zzb("onRebind called. action", intent.getAction());
        }
    }

    public final void zzh(Runnable runnable) {
        zzkt zzt = zzkt.zzt(this.zza);
        zzt.zzaz().zzp(new zzjr(this, zzt, runnable));
    }

    public final boolean zzi(final JobParameters jobParameters) {
        PersistableBundle extras;
        String string;
        zzfr zzp = zzfr.zzp(this.zza, null, null);
        final zzeh zzay = zzp.zzay();
        extras = jobParameters.getExtras();
        string = extras.getString("action");
        zzp.zzaw();
        zzay.zzj().zzb("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        zzh(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjp
            @Override // java.lang.Runnable
            public final void run() {
                zzjt.this.zzd(zzay, jobParameters);
            }
        });
        return true;
    }

    public final boolean zzj(Intent intent) {
        if (intent == null) {
            zzk().zzd().zza("onUnbind called with null intent");
            return true;
        }
        zzk().zzj().zzb("onUnbind called for intent. action", intent.getAction());
        return true;
    }
}
