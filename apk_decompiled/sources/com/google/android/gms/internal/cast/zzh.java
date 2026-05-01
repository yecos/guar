package com.google.android.gms.internal.cast;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public final class zzh {
    private static final Logger zza = new Logger("ApplicationAnalytics");
    private final zzd zzb;
    private final zzj zzc;
    private final SharedPreferences zzf;
    private zzi zzg;
    private final Handler zze = new zzco(Looper.getMainLooper());
    private final Runnable zzd = new Runnable() { // from class: com.google.android.gms.internal.cast.zze
        @Override // java.lang.Runnable
        public final void run() {
            zzh.zzf(zzh.this);
        }
    };

    public zzh(SharedPreferences sharedPreferences, zzd zzdVar, Bundle bundle, String str) {
        this.zzf = sharedPreferences;
        this.zzb = zzdVar;
        this.zzc = new zzj(bundle, str);
    }

    public static /* synthetic */ void zzf(zzh zzhVar) {
        zzi zziVar = zzhVar.zzg;
        if (zziVar != null) {
            zzhVar.zzb.zzb(zzhVar.zzc.zza(zziVar), 223);
        }
        zzhVar.zzs();
    }

    public static /* bridge */ /* synthetic */ void zzj(zzh zzhVar, CastSession castSession, int i10) {
        zzhVar.zzq(castSession);
        zzhVar.zzb.zzb(zzhVar.zzc.zze(zzhVar.zzg, i10), 228);
        zzhVar.zzp();
        zzhVar.zzg = null;
    }

    public static /* bridge */ /* synthetic */ void zzk(zzh zzhVar, SharedPreferences sharedPreferences, String str) {
        if (zzhVar.zzv(str)) {
            zza.d("Use the existing ApplicationAnalyticsSession if it is available and valid.", new Object[0]);
            Preconditions.checkNotNull(zzhVar.zzg);
            return;
        }
        zzhVar.zzg = zzi.zzb(sharedPreferences);
        if (zzhVar.zzv(str)) {
            zza.d("Use the restored ApplicationAnalyticsSession if it is valid.", new Object[0]);
            Preconditions.checkNotNull(zzhVar.zzg);
            zzi.zza = zzhVar.zzg.zzd + 1;
        } else {
            zza.d("The restored ApplicationAnalyticsSession is not valid, create a new one.", new Object[0]);
            zzi zza2 = zzi.zza();
            zzhVar.zzg = zza2;
            zza2.zzb = zzo();
            zzhVar.zzg.zzf = str;
        }
    }

    private static String zzo() {
        return ((CastContext) Preconditions.checkNotNull(CastContext.getSharedInstance())).getCastOptions().getReceiverApplicationId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzp() {
        this.zze.removeCallbacks(this.zzd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzq(CastSession castSession) {
        if (!zzu()) {
            zza.w("The analyticsSession should not be null for logging. Create a dummy one.", new Object[0]);
            zzr(castSession);
            return;
        }
        CastDevice castDevice = castSession != null ? castSession.getCastDevice() : null;
        if (castDevice != null && !TextUtils.equals(this.zzg.zzc, castDevice.zzb())) {
            zzt(castDevice);
        }
        Preconditions.checkNotNull(this.zzg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzr(CastSession castSession) {
        zza.d("Create a new ApplicationAnalyticsSession based on CastSession", new Object[0]);
        zzi zza2 = zzi.zza();
        this.zzg = zza2;
        zza2.zzb = zzo();
        CastDevice castDevice = castSession == null ? null : castSession.getCastDevice();
        if (castDevice != null) {
            zzt(castDevice);
        }
        Preconditions.checkNotNull(this.zzg);
        this.zzg.zzi = castSession != null ? castSession.zzk() : 0;
        Preconditions.checkNotNull(this.zzg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzs() {
        ((Handler) Preconditions.checkNotNull(this.zze)).postDelayed((Runnable) Preconditions.checkNotNull(this.zzd), 300000L);
    }

    private final void zzt(CastDevice castDevice) {
        zzi zziVar = this.zzg;
        if (zziVar == null) {
            return;
        }
        zziVar.zzc = castDevice.zzb();
        zziVar.zzg = castDevice.zza();
        zziVar.zzh = castDevice.getModelName();
    }

    private final boolean zzu() {
        String str;
        if (this.zzg == null) {
            zza.d("The analytics session is null when matching with application ID.", new Object[0]);
            return false;
        }
        String zzo = zzo();
        if (zzo == null || (str = this.zzg.zzb) == null || !TextUtils.equals(str, zzo)) {
            zza.d("The analytics session doesn't match the application ID %s", zzo);
            return false;
        }
        Preconditions.checkNotNull(this.zzg);
        return true;
    }

    private final boolean zzv(String str) {
        String str2;
        if (!zzu()) {
            return false;
        }
        Preconditions.checkNotNull(this.zzg);
        if (str != null && (str2 = this.zzg.zzf) != null && TextUtils.equals(str2, str)) {
            return true;
        }
        zza.d("The analytics session doesn't match the receiver session ID %s.", str);
        return false;
    }

    public final void zzn(SessionManager sessionManager) {
        sessionManager.addSessionManagerListener(new zzg(this, null), CastSession.class);
    }
}
